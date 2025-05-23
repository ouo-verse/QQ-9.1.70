package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue: ";
    private static final String FORMAT_LINE_PREFIX = "Format: ";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private static final String TAG = "SsaDecoder";
    private int formatEndIndex;
    private int formatKeyCount;
    private int formatStartIndex;
    private int formatTextIndex;
    private final boolean haveInitializationData;

    public SsaDecoder() {
        this(null);
    }

    private void parseDialogueLine(String str, List<Cue> list, LongArray longArray) {
        long j3;
        if (this.formatKeyCount == 0) {
            Log.w(TAG, "Skipping dialogue line before complete format: " + str);
            return;
        }
        String[] split = str.substring(10).split(",", this.formatKeyCount);
        if (split.length != this.formatKeyCount) {
            Log.w(TAG, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long parseTimecodeUs = parseTimecodeUs(split[this.formatStartIndex]);
        if (parseTimecodeUs == -9223372036854775807L) {
            Log.w(TAG, "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.formatEndIndex];
        if (!str2.trim().isEmpty()) {
            j3 = parseTimecodeUs(str2);
            if (j3 == -9223372036854775807L) {
                Log.w(TAG, "Skipping invalid timing: " + str);
                return;
            }
        } else {
            j3 = -9223372036854775807L;
        }
        list.add(new Cue(split[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        longArray.add(parseTimecodeUs);
        if (j3 != -9223372036854775807L) {
            list.add(null);
            longArray.add(j3);
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine != null) {
                if (!this.haveInitializationData && readLine.startsWith(FORMAT_LINE_PREFIX)) {
                    parseFormatLine(readLine);
                } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                    parseDialogueLine(readLine, list, longArray);
                }
            } else {
                return;
            }
        }
    }

    private void parseFormatLine(String str) {
        char c16;
        String[] split = TextUtils.split(str.substring(8), ",");
        this.formatKeyCount = split.length;
        this.formatStartIndex = -1;
        this.formatEndIndex = -1;
        this.formatTextIndex = -1;
        for (int i3 = 0; i3 < this.formatKeyCount; i3++) {
            String lowerInvariant = Util.toLowerInvariant(split[i3].trim());
            lowerInvariant.hashCode();
            switch (lowerInvariant.hashCode()) {
                case 100571:
                    if (lowerInvariant.equals("end")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 3556653:
                    if (lowerInvariant.equals("text")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (lowerInvariant.equals("start")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            c16 = '\uffff';
            switch (c16) {
                case 0:
                    this.formatEndIndex = i3;
                    break;
                case 1:
                    this.formatTextIndex = i3;
                    break;
                case 2:
                    this.formatStartIndex = i3;
                    break;
            }
        }
        if (this.formatStartIndex == -1 || this.formatEndIndex == -1 || this.formatTextIndex == -1) {
            this.formatKeyCount = 0;
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        do {
            readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
        } while (!readLine.startsWith("[Events]"));
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    public SsaDecoder(List<byte[]> list) {
        super(TAG);
        if (list != null && !list.isEmpty()) {
            this.haveInitializationData = true;
            String str = new String(list.get(0));
            Assertions.checkArgument(str.startsWith(FORMAT_LINE_PREFIX));
            parseFormatLine(str);
            parseHeader(new ParsableByteArray(list.get(1)));
            return;
        }
        this.haveInitializationData = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public SsaSubtitle decode(byte[] bArr, int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i3);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, longArray);
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SsaSubtitle(cueArr, longArray.toArray());
    }
}
