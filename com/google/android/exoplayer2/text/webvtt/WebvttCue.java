package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.google.android.exoplayer2.text.Cue;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class WebvttCue extends Cue {
    public final long endTime;
    public final long startTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.exoplayer2.text.webvtt.WebvttCue$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            $SwitchMap$android$text$Layout$Alignment = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$text$Layout$Alignment[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private static final String TAG = "WebvttCueBuilder";
        private long endTime;
        private float line;
        private int lineAnchor;
        private int lineType;
        private float position;
        private int positionAnchor;
        private long startTime;
        private SpannableStringBuilder text;
        private Layout.Alignment textAlignment;
        private float width;

        public Builder() {
            reset();
        }

        private Builder derivePositionAnchorFromAlignment() {
            Layout.Alignment alignment = this.textAlignment;
            if (alignment == null) {
                this.positionAnchor = Integer.MIN_VALUE;
            } else {
                int i3 = AnonymousClass1.$SwitchMap$android$text$Layout$Alignment[alignment.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            Log.w(TAG, "Unrecognized alignment: " + this.textAlignment);
                            this.positionAnchor = 0;
                        } else {
                            this.positionAnchor = 2;
                        }
                    } else {
                        this.positionAnchor = 1;
                    }
                } else {
                    this.positionAnchor = 0;
                }
            }
            return this;
        }

        public WebvttCue build() {
            if (this.position != Float.MIN_VALUE && this.positionAnchor == Integer.MIN_VALUE) {
                derivePositionAnchorFromAlignment();
            }
            return new WebvttCue(this.startTime, this.endTime, this.text, this.textAlignment, this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.text = null;
            this.textAlignment = null;
            this.line = Float.MIN_VALUE;
            this.lineType = Integer.MIN_VALUE;
            this.lineAnchor = Integer.MIN_VALUE;
            this.position = Float.MIN_VALUE;
            this.positionAnchor = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public Builder setEndTime(long j3) {
            this.endTime = j3;
            return this;
        }

        public Builder setLine(float f16) {
            this.line = f16;
            return this;
        }

        public Builder setLineAnchor(int i3) {
            this.lineAnchor = i3;
            return this;
        }

        public Builder setLineType(int i3) {
            this.lineType = i3;
            return this;
        }

        public Builder setPosition(float f16) {
            this.position = f16;
            return this;
        }

        public Builder setPositionAnchor(int i3) {
            this.positionAnchor = i3;
            return this;
        }

        public Builder setStartTime(long j3) {
            this.startTime = j3;
            return this;
        }

        public Builder setText(SpannableStringBuilder spannableStringBuilder) {
            this.text = spannableStringBuilder;
            return this;
        }

        public Builder setTextAlignment(Layout.Alignment alignment) {
            this.textAlignment = alignment;
            return this;
        }

        public Builder setWidth(float f16) {
            this.width = f16;
            return this;
        }
    }

    public WebvttCue(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public boolean isNormalCue() {
        if (this.line == Float.MIN_VALUE && this.position == Float.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public WebvttCue(long j3, long j16, CharSequence charSequence) {
        this(j3, j16, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public WebvttCue(long j3, long j16, CharSequence charSequence, Layout.Alignment alignment, float f16, int i3, int i16, float f17, int i17, float f18) {
        super(charSequence, alignment, f16, i3, i16, f17, i17, f18);
        this.startTime = j3;
        this.endTime = j16;
    }
}
