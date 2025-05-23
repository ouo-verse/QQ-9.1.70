package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class WebvttParserUtil {
    private static final Pattern COMMENT = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern HEADER = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    WebvttParserUtil() {
    }

    public static Matcher findNextCueHeader(ParsableByteArray parsableByteArray) {
        String readLine;
        while (true) {
            String readLine2 = parsableByteArray.readLine();
            if (readLine2 != null) {
                if (COMMENT.matcher(readLine2).matches()) {
                    do {
                        readLine = parsableByteArray.readLine();
                        if (readLine != null) {
                        }
                    } while (!readLine.isEmpty());
                } else {
                    Matcher matcher = WebvttCueParser.CUE_HEADER_PATTERN.matcher(readLine2);
                    if (matcher.matches()) {
                        return matcher;
                    }
                }
            } else {
                return null;
            }
        }
    }

    public static float parsePercentage(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long parseTimestampUs(String str) throws NumberFormatException {
        String[] split = str.split("\\.", 2);
        long j3 = 0;
        for (String str2 : split[0].split(":")) {
            j3 = (j3 * 60) + Long.parseLong(str2);
        }
        long j16 = j3 * 1000;
        if (split.length == 2) {
            j16 += Long.parseLong(split[1]);
        }
        return j16 * 1000;
    }

    public static void validateWebvttHeaderLine(ParsableByteArray parsableByteArray) throws SubtitleDecoderException {
        String readLine = parsableByteArray.readLine();
        if (readLine != null && HEADER.matcher(readLine).matches()) {
            return;
        }
        throw new SubtitleDecoderException("Expected WEBVTT. Got " + readLine);
    }
}
