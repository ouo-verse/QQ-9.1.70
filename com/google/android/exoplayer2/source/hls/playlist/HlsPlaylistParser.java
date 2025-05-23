package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            String trim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = this.extraLines.poll();
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine != null) {
                    trim = readLine.trim();
                    this.next = trim;
                } else {
                    return false;
                }
            } while (trim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (!hasNext()) {
                return null;
            }
            String str = this.next;
            this.next = null;
            return str;
        }
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int skipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, read);
        for (int i3 = 0; i3 < 7; i3++) {
            if (skipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i3)) {
                return false;
            }
            skipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, skipIgnorableWhitespace));
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(" + BOOLEAN_FALSE + "|" + BOOLEAN_TRUE + ")");
    }

    private static boolean parseBooleanAttribute(String str, Pattern pattern, boolean z16) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1).equals(BOOLEAN_TRUE);
        }
        return z16;
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern));
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern));
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern));
    }

    private static HlsMasterPlaylist parseMasterPlaylist(LineIterator lineIterator, String str) throws IOException {
        List list;
        char c16;
        int parseInt;
        String str2;
        String str3;
        int i3;
        int i16;
        float f16;
        int i17;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        boolean z16 = false;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList5.add(next);
            }
            if (next.startsWith(TAG_MEDIA)) {
                arrayList4.add(next);
            } else if (next.startsWith(TAG_STREAM_INF)) {
                z16 |= next.contains(ATTR_CLOSED_CAPTIONS_NONE);
                int parseIntAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_AVERAGE_BANDWIDTH);
                if (parseOptionalStringAttr != null) {
                    parseIntAttr = Integer.parseInt(parseOptionalStringAttr);
                }
                int i18 = parseIntAttr;
                String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_CODECS);
                String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_RESOLUTION);
                if (parseOptionalStringAttr3 != null) {
                    String[] split = parseOptionalStringAttr3.split(HippyTKDListViewAdapter.X);
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 > 0 && parseInt3 > 0) {
                        i17 = parseInt2;
                    } else {
                        i17 = -1;
                        parseInt3 = -1;
                    }
                    i3 = i17;
                    i16 = parseInt3;
                } else {
                    i3 = -1;
                    i16 = -1;
                }
                String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_FRAME_RATE);
                if (parseOptionalStringAttr4 != null) {
                    f16 = Float.parseFloat(parseOptionalStringAttr4);
                } else {
                    f16 = -1.0f;
                }
                float f17 = f16;
                String parseOptionalStringAttr5 = parseOptionalStringAttr(next, REGEX_AUDIO);
                if (parseOptionalStringAttr5 != null && parseOptionalStringAttr2 != null) {
                    hashMap.put(parseOptionalStringAttr5, Util.getCodecsOfType(parseOptionalStringAttr2, 1));
                }
                String next2 = lineIterator.next();
                if (hashSet.add(next2)) {
                    arrayList.add(new HlsMasterPlaylist.HlsUrl(next2, Format.createVideoContainerFormat(Integer.toString(arrayList.size()), "application/x-mpegURL", null, parseOptionalStringAttr2, i18, i3, i16, f17, null, 0)));
                }
            }
        }
        int i19 = 0;
        Format format = null;
        ArrayList arrayList6 = null;
        while (i19 < arrayList4.size()) {
            String str4 = (String) arrayList4.get(i19);
            int parseSelectionFlags = parseSelectionFlags(str4);
            String parseOptionalStringAttr6 = parseOptionalStringAttr(str4, REGEX_URI);
            String parseStringAttr = parseStringAttr(str4, REGEX_NAME);
            String parseOptionalStringAttr7 = parseOptionalStringAttr(str4, REGEX_LANGUAGE);
            String parseOptionalStringAttr8 = parseOptionalStringAttr(str4, REGEX_GROUP_ID);
            String parseStringAttr2 = parseStringAttr(str4, REGEX_TYPE);
            parseStringAttr2.hashCode();
            ArrayList arrayList7 = arrayList4;
            switch (parseStringAttr2.hashCode()) {
                case -959297733:
                    if (parseStringAttr2.equals(TYPE_SUBTITLES)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -333210994:
                    if (parseStringAttr2.equals(TYPE_CLOSED_CAPTIONS)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 62628790:
                    if (parseStringAttr2.equals(TYPE_AUDIO)) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            c16 = '\uffff';
            switch (c16) {
                case 0:
                    arrayList3.add(new HlsMasterPlaylist.HlsUrl(parseOptionalStringAttr6, Format.createTextContainerFormat(parseStringAttr, "application/x-mpegURL", "text/vtt", null, -1, parseSelectionFlags, parseOptionalStringAttr7)));
                    break;
                case 1:
                    String parseStringAttr3 = parseStringAttr(str4, REGEX_INSTREAM_ID);
                    if (parseStringAttr3.startsWith("CC")) {
                        parseInt = Integer.parseInt(parseStringAttr3.substring(2));
                        str2 = "application/cea-608";
                    } else {
                        parseInt = Integer.parseInt(parseStringAttr3.substring(7));
                        str2 = "application/cea-708";
                    }
                    int i26 = parseInt;
                    String str5 = str2;
                    if (arrayList6 == null) {
                        arrayList6 = new ArrayList();
                    }
                    arrayList6.add(Format.createTextContainerFormat(parseStringAttr, null, str5, null, -1, parseSelectionFlags, parseOptionalStringAttr7, i26));
                    break;
                case 2:
                    String str6 = (String) hashMap.get(parseOptionalStringAttr8);
                    if (str6 != null) {
                        str3 = MimeTypes.getMediaMimeType(str6);
                    } else {
                        str3 = null;
                    }
                    Format createAudioContainerFormat = Format.createAudioContainerFormat(parseStringAttr, "application/x-mpegURL", str3, str6, -1, -1, -1, null, parseSelectionFlags, parseOptionalStringAttr7);
                    if (parseOptionalStringAttr6 == null) {
                        format = createAudioContainerFormat;
                        break;
                    } else {
                        arrayList2.add(new HlsMasterPlaylist.HlsUrl(parseOptionalStringAttr6, createAudioContainerFormat));
                        break;
                    }
            }
            i19++;
            arrayList4 = arrayList7;
        }
        if (z16) {
            list = Collections.emptyList();
        } else {
            list = arrayList6;
        }
        return new HlsMasterPlaylist(str, arrayList5, arrayList, arrayList2, arrayList3, format, list);
    }

    private static HlsMediaPlaylist parseMediaPlaylist(LineIterator lineIterator, String str) throws IOException {
        boolean z16;
        DrmInitData.SchemeData parseWidevineSchemeData;
        String str2;
        String hexString;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        char c16 = 0;
        boolean z17 = false;
        int i3 = 0;
        boolean z18 = false;
        boolean z19 = false;
        boolean z26 = false;
        long j3 = -9223372036854775807L;
        long j16 = -9223372036854775807L;
        int i16 = 1;
        long j17 = 0;
        long j18 = 0;
        DrmInitData drmInitData = null;
        HlsMediaPlaylist.Segment segment = null;
        long j19 = 0;
        long j26 = 0;
        long j27 = -1;
        long j28 = 0;
        String str3 = null;
        String str4 = null;
        long j29 = 0;
        int i17 = 0;
        int i18 = 0;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList2.add(next);
            }
            if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                String parseStringAttr = parseStringAttr(next, REGEX_PLAYLIST_TYPE);
                if ("VOD".equals(parseStringAttr)) {
                    i17 = 1;
                } else if ("EVENT".equals(parseStringAttr)) {
                    i17 = 2;
                }
            } else if (next.startsWith(TAG_START)) {
                j3 = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
            } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                String parseStringAttr2 = parseStringAttr(next, REGEX_URI);
                String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE);
                if (parseOptionalStringAttr != null) {
                    String[] split = parseOptionalStringAttr.split("@");
                    j27 = Long.parseLong(split[c16]);
                    if (split.length > 1) {
                        j19 = Long.parseLong(split[1]);
                    }
                }
                segment = new HlsMediaPlaylist.Segment(parseStringAttr2, j19, j27);
                j19 = 0;
                j27 = -1;
            } else if (next.startsWith(TAG_TARGET_DURATION)) {
                j16 = 1000000 * parseIntAttr(next, REGEX_TARGET_DURATION);
            } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                j26 = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                j18 = j26;
            } else if (next.startsWith(TAG_VERSION)) {
                i16 = parseIntAttr(next, REGEX_VERSION);
            } else if (next.startsWith(TAG_MEDIA_DURATION)) {
                j29 = (long) (parseDoubleAttr(next, REGEX_MEDIA_DURATION) * 1000000.0d);
            } else if (next.startsWith(TAG_KEY)) {
                String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_METHOD);
                String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_KEYFORMAT);
                if (!"NONE".equals(parseOptionalStringAttr2)) {
                    String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_IV);
                    if (!"identity".equals(parseOptionalStringAttr3) && parseOptionalStringAttr3 != null) {
                        if (parseOptionalStringAttr2 != null && (parseWidevineSchemeData = parseWidevineSchemeData(next, parseOptionalStringAttr3)) != null) {
                            if (!METHOD_SAMPLE_AES_CENC.equals(parseOptionalStringAttr2) && !METHOD_SAMPLE_AES_CTR.equals(parseOptionalStringAttr2)) {
                                str2 = C.CENC_TYPE_cbcs;
                            } else {
                                str2 = C.CENC_TYPE_cenc;
                            }
                            DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[1];
                            schemeDataArr[c16] = parseWidevineSchemeData;
                            str4 = parseOptionalStringAttr4;
                            drmInitData = new DrmInitData(str2, schemeDataArr);
                            str3 = null;
                        }
                    } else if (METHOD_AES_128.equals(parseOptionalStringAttr2)) {
                        str4 = parseOptionalStringAttr4;
                        str3 = parseStringAttr(next, REGEX_URI);
                    }
                    str4 = parseOptionalStringAttr4;
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
            } else if (next.startsWith(TAG_BYTERANGE)) {
                String[] split2 = parseStringAttr(next, REGEX_BYTERANGE).split("@");
                j27 = Long.parseLong(split2[c16]);
                if (split2.length > 1) {
                    j19 = Long.parseLong(split2[1]);
                }
            } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                i3 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                z17 = true;
            } else if (next.equals(TAG_DISCONTINUITY)) {
                i18++;
            } else if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                if (j17 == 0) {
                    j17 = C.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j28;
                } else {
                    c16 = 0;
                }
            } else if (next.equals(TAG_GAP)) {
                z26 = true;
            } else if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                z18 = true;
            } else if (next.equals(TAG_ENDLIST)) {
                z19 = true;
            } else if (!next.startsWith("#")) {
                if (str3 == null) {
                    hexString = null;
                } else if (str4 != null) {
                    hexString = str4;
                } else {
                    hexString = Long.toHexString(j26);
                }
                long j36 = j26 + 1;
                if (j27 == -1) {
                    j19 = 0;
                }
                arrayList.add(new HlsMediaPlaylist.Segment(next, j29, i18, j28, str3, hexString, j19, j27, z26));
                j28 += j29;
                if (j27 != -1) {
                    j19 += j27;
                }
                j26 = j36;
                j27 = -1;
                c16 = 0;
                z26 = false;
                j29 = 0;
            } else {
                c16 = 0;
            }
        }
        if (j17 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new HlsMediaPlaylist(i17, str, arrayList2, j3, j17, z17, i3, j18, i16, j16, z18, z19, z16, drmInitData, segment, arrayList);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private static int parseSelectionFlags(String str) {
        int i3;
        int i16 = 0;
        boolean parseBooleanAttribute = parseBooleanAttribute(str, REGEX_DEFAULT, false);
        if (parseBooleanAttribute(str, REGEX_FORCED, false)) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        int i17 = (parseBooleanAttribute ? 1 : 0) | i3;
        if (parseBooleanAttribute(str, REGEX_AUTOSELECT, false)) {
            i16 = 4;
        }
        return i17 | i16;
    }

    private static String parseStringAttr(String str, Pattern pattern) throws ParserException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static DrmInitData.SchemeData parseWidevineSchemeData(String str, String str2) throws ParserException {
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String parseStringAttr = parseStringAttr(str, REGEX_URI);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(parseStringAttr.substring(parseStringAttr.indexOf(44)), 0));
        }
        if (KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            try {
                return new DrmInitData.SchemeData(C.WIDEVINE_UUID, TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS, str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                throw new ParserException(e16);
            }
        }
        return null;
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z16, int i3) throws IOException {
        while (i3 != -1 && Character.isWhitespace(i3) && (z16 || !Util.isLinebreak(i3))) {
            i3 = bufferedReader.read();
        }
        return i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (checkPlaylistHeader(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (trim.startsWith(TAG_STREAM_INF)) {
                                arrayDeque.add(trim);
                                return parseMasterPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                            }
                            if (trim.startsWith(TAG_TARGET_DURATION) || trim.startsWith(TAG_MEDIA_SEQUENCE) || trim.startsWith(TAG_MEDIA_DURATION) || trim.startsWith(TAG_KEY) || trim.startsWith(TAG_BYTERANGE) || trim.equals(TAG_DISCONTINUITY) || trim.equals(TAG_DISCONTINUITY_SEQUENCE) || trim.equals(TAG_ENDLIST)) {
                                break;
                            }
                            arrayDeque.add(trim);
                        }
                    } else {
                        Util.closeQuietly(bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return parseMediaPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }
}
