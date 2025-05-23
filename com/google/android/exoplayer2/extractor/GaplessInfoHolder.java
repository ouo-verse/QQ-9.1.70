package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class GaplessInfoHolder {
    private static final String GAPLESS_COMMENT_ID = "iTunSMPB";
    public int encoderDelay = -1;
    public int encoderPadding = -1;
    public static final Id3Decoder.FramePredicate GAPLESS_INFO_ID3_FRAME_PREDICATE = new Id3Decoder.FramePredicate() { // from class: com.google.android.exoplayer2.extractor.GaplessInfoHolder.1
        @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public boolean evaluate(int i3, int i16, int i17, int i18, int i19) {
            if (i16 == 67 && i17 == 79 && i18 == 77 && (i19 == 77 || i3 == 2)) {
                return true;
            }
            return false;
        }
    };
    private static final Pattern GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    private boolean setFromComment(String str, String str2) {
        if (!GAPLESS_COMMENT_ID.equals(str)) {
            return false;
        }
        Matcher matcher = GAPLESS_COMMENT_PATTERN.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.encoderDelay = parseInt;
                    this.encoderPadding = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public boolean hasGaplessInfo() {
        if (this.encoderDelay != -1 && this.encoderPadding != -1) {
            return true;
        }
        return false;
    }

    public boolean setFromMetadata(Metadata metadata) {
        for (int i3 = 0; i3 < metadata.length(); i3++) {
            Metadata.Entry entry = metadata.get(i3);
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if (setFromComment(commentFrame.description, commentFrame.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setFromXingHeaderValue(int i3) {
        int i16 = i3 >> 12;
        int i17 = i3 & 4095;
        if (i16 <= 0 && i17 <= 0) {
            return false;
        }
        this.encoderDelay = i16;
        this.encoderPadding = i17;
        return true;
    }
}
