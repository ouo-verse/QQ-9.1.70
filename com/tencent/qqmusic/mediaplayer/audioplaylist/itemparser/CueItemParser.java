package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes23.dex */
public class CueItemParser extends AudioPlayListItemParser {
    public static final String TAG = "CueItemParser";
    private LineNumberReader mReader;
    protected List<TrackInfo> mTrackInfoList;

    public CueItemParser(String str) {
        this.mUri = str;
        this.mTrackInfoList = new LinkedList();
    }

    private long convertTimeStrToMs(String str) throws ParseException {
        String[] split = str.split(":");
        long parseLong = Long.parseLong(split[0]);
        return (((parseLong * 60) + Long.parseLong(split[1])) * 1000) + (Long.parseLong(split[2]) * 10);
    }

    private String guessCharsetEncoding(String str) throws IOException {
        Logger.i(TAG, "CueItemParser.guessCharsetEncoding, filePath: " + str);
        return guessCharsetEncoding(new FileInputStream(str));
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
    public boolean isParseSuccess() {
        return !this.mTrackInfoList.isEmpty();
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
    public Iterator<TrackInfo> iterator() {
        return this.mTrackInfoList.iterator();
    }

    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
    public void parse() throws ParseException {
        int i3;
        String str;
        String str2;
        String str3;
        File file;
        int i16;
        boolean z16;
        long j3;
        int i17;
        String str4 = "/";
        Logger.i(TAG, "CueItemParser.parse, uri: " + this.mUri);
        File file2 = new File(this.mUri);
        this.mTrackInfoList.clear();
        try {
            try {
                this.mReader = new LineNumberReader(new InputStreamReader(new FileInputStream(file2), guessCharsetEncoding(this.mUri)));
                String str5 = null;
                String str6 = null;
                TrackInfo trackInfo = null;
                String str7 = null;
                boolean z17 = false;
                long j16 = 0;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    boolean z18 = false;
                    while (true) {
                        try {
                            String readLine = this.mReader.readLine();
                            i19 = this.mReader.getLineNumber();
                            if (!TextUtils.isEmpty(readLine)) {
                                if (!z17 && readLine.trim().toUpperCase().startsWith("PERFORMER")) {
                                    str6 = AudioPlayListItemParser.delSeprator(readLine);
                                }
                                if (!z17) {
                                    str = str6;
                                    if (readLine.trim().toUpperCase().startsWith("TITLE")) {
                                        str5 = AudioPlayListItemParser.delSeprator(readLine);
                                    }
                                } else {
                                    str = str6;
                                }
                                str2 = str5;
                                if (readLine.trim().toUpperCase().startsWith("FILE")) {
                                    if (z17) {
                                        z17 = false;
                                    }
                                    if (j16 != 0 && trackInfo != null) {
                                        trackInfo.setEndPostion(j16);
                                    }
                                    String delSeprator = AudioPlayListItemParser.delSeprator(readLine);
                                    String parent = file2.getParent();
                                    if (!parent.endsWith(str4)) {
                                        parent = parent + str4;
                                    }
                                    if (delSeprator.startsWith(str4)) {
                                        delSeprator = delSeprator.substring(1);
                                    }
                                    String str8 = parent + delSeprator;
                                    if (new File(str8).exists()) {
                                        NativeDecoder nativeDecoder = new NativeDecoder();
                                        int init = nativeDecoder.init(new FileDataSource(str8));
                                        if (init == 0) {
                                            j16 = nativeDecoder.getAudioInformation().getDuration();
                                            str3 = str4;
                                            file = file2;
                                        } else {
                                            str3 = str4;
                                            StringBuilder sb5 = new StringBuilder();
                                            file = file2;
                                            sb5.append("media item in cue init fail! ret = ");
                                            sb5.append(init);
                                            sb5.append(" ,path: ");
                                            sb5.append(str8);
                                            Logger.e(TAG, sb5.toString());
                                        }
                                        nativeDecoder.release();
                                        str7 = str8;
                                    } else {
                                        throw new IOException("media file in cue not exist! cue Path: " + this.mUri);
                                    }
                                } else {
                                    str3 = str4;
                                    file = file2;
                                }
                                if (readLine.trim().toUpperCase().startsWith("TRACK")) {
                                    TrackInfo trackInfo2 = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
                                    trackInfo2.setFilePath(str7);
                                    trackInfo = trackInfo2;
                                    i16 = i18 + 1;
                                    z17 = true;
                                } else {
                                    i16 = i18;
                                }
                                if (z17 && readLine.trim().toUpperCase().startsWith("TITLE")) {
                                    trackInfo.setTitle(AudioPlayListItemParser.delSeprator(readLine));
                                }
                                if (z17 && readLine.trim().toUpperCase().startsWith("PERFORMER")) {
                                    trackInfo.setPerformer(AudioPlayListItemParser.delSeprator(readLine));
                                }
                                if (i16 == 1 && readLine.trim().toUpperCase().startsWith("INDEX")) {
                                    if (readLine.trim().contains(" 01 ")) {
                                        trackInfo.setStartPosition(convertTimeStrToMs(readLine.trim().split(" 01 ")[1].trim()));
                                    } else {
                                        throw new IOException("first item in CUE must only have feature \"INDEX 01\"!");
                                    }
                                }
                                if (i16 >= 2 && readLine.trim().toUpperCase().startsWith("INDEX")) {
                                    if (readLine.trim().contains(" 00 ")) {
                                        z16 = z17;
                                        j3 = j16;
                                        this.mTrackInfoList.get(i16 - 2).setEndPostion(convertTimeStrToMs(readLine.trim().split(" 00 ")[1].trim()));
                                        i17 = 1;
                                        z18 = true;
                                        if (i16 >= i17 || !readLine.trim().toUpperCase().startsWith("INDEX") || !readLine.trim().contains(" 01 ")) {
                                            i18 = i16;
                                            z17 = z16;
                                            str5 = str2;
                                            str6 = str;
                                            str4 = str3;
                                            file2 = file;
                                            j16 = j3;
                                        }
                                    } else {
                                        z16 = z17;
                                        j3 = j16;
                                        if (readLine.trim().contains(" 01 ")) {
                                            String trim = readLine.trim().split(" 01 ")[1].trim();
                                            trackInfo.setStartPosition(convertTimeStrToMs(trim));
                                            if (!z18) {
                                                this.mTrackInfoList.get(i16 - 2).setEndPostion(convertTimeStrToMs(trim));
                                            }
                                        } else {
                                            throw new IOException("item " + i16 + " in CUE have illegel feature \"INDEX\"!");
                                        }
                                    }
                                } else {
                                    z16 = z17;
                                    j3 = j16;
                                }
                                i17 = 1;
                                if (i16 >= i17) {
                                }
                                i18 = i16;
                                z17 = z16;
                                str5 = str2;
                                str6 = str;
                                str4 = str3;
                                file2 = file;
                                j16 = j3;
                            } else {
                                if (!this.mTrackInfoList.isEmpty()) {
                                    List<TrackInfo> list = this.mTrackInfoList;
                                    TrackInfo trackInfo3 = list.get(list.size() - 1);
                                    if (j16 != 0 && trackInfo3.getRange() != null && ((Long) trackInfo3.getRange().second).longValue() == 0) {
                                        trackInfo3.setEndPostion(j16);
                                    }
                                    for (int i26 = 0; i26 < this.mTrackInfoList.size(); i26++) {
                                        TrackInfo trackInfo4 = this.mTrackInfoList.get(i26);
                                        if (!TextUtils.isEmpty(str5) && TextUtils.isEmpty(trackInfo4.getAlbum())) {
                                            trackInfo4.setAlbum(str5);
                                        }
                                        if (!TextUtils.isEmpty(str6) && TextUtils.isEmpty(trackInfo4.getPerformer())) {
                                            trackInfo4.setPerformer(str6);
                                        }
                                    }
                                }
                                try {
                                    this.mReader.close();
                                    return;
                                } catch (Exception e16) {
                                    Logger.e(TAG, "LineNumberReader close ex", e16);
                                    return;
                                }
                            }
                        } catch (IOException e17) {
                            e = e17;
                            i3 = i19;
                            throw new ParseException("Parse Exception occured", e, i3);
                        }
                    }
                    this.mTrackInfoList.add(trackInfo);
                    trackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
                    trackInfo.setFilePath(str7);
                    i18 = i16;
                    z17 = z16;
                    str5 = str2;
                    str6 = str;
                    str4 = str3;
                    file2 = file;
                    j16 = j3;
                }
            } catch (Throwable th5) {
                try {
                    this.mReader.close();
                    throw th5;
                } catch (Exception e18) {
                    Logger.e(TAG, "LineNumberReader close ex", e18);
                    throw th5;
                }
            }
        } catch (IOException e19) {
            e = e19;
            i3 = 0;
        }
    }
}
