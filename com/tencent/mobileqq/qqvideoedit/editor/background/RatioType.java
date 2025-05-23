package com.tencent.mobileqq.qqvideoedit.editor.background;

import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.RatioTypeEnum;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/RatioType;", "", "w", "", h.F, "(Ljava/lang/String;III)V", "getH", "()I", "getW", "label", "", "toTavCutRatioTypeEnum", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/RatioTypeEnum;", "ORIGINAL", "FREE", "R_16_9", "R_9_16", "R_4_3", "R_3_4", "R_1_1", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public enum RatioType {
    ORIGINAL(-1, -1),
    FREE(0, 0),
    R_16_9(16, 9),
    R_9_16(9, 16),
    R_4_3(4, 3),
    R_3_4(3, 4),
    R_1_1(1, 1);

    private final int h;
    private final int w;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275201a;

        static {
            int[] iArr = new int[RatioType.values().length];
            try {
                iArr[RatioType.ORIGINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RatioType.FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RatioType.R_16_9.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RatioType.R_9_16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RatioType.R_4_3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RatioType.R_3_4.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RatioType.R_1_1.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f275201a = iArr;
        }
    }

    RatioType(int i3, int i16) {
        this.w = i3;
        this.h = i16;
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    @NotNull
    public final String label() {
        int i3 = a.f275201a[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return this.w + ":" + this.h;
            }
            return "\u81ea\u7531";
        }
        return "\u539f\u59cb";
    }

    @NotNull
    public final RatioTypeEnum toTavCutRatioTypeEnum() {
        switch (a.f275201a[ordinal()]) {
            case 1:
                return RatioTypeEnum.ORIGINAL;
            case 2:
                return RatioTypeEnum.ORIGINAL;
            case 3:
                return RatioTypeEnum.R16_9;
            case 4:
                return RatioTypeEnum.R9_16;
            case 5:
                return RatioTypeEnum.R4_3;
            case 6:
                return RatioTypeEnum.R3_4;
            case 7:
                return RatioTypeEnum.R1_1;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
