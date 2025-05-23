package com.tencent.videocut.render.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.videocut.model.RatioType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/videocut/render/model/RatioTypeEnum;", "", "Lcom/tencent/videocut/model/RatioType;", "type", "Lcom/tencent/videocut/model/RatioType;", "getType", "()Lcom/tencent/videocut/model/RatioType;", "", "ratioValue", UserInfo.SEX_FEMALE, "getRatioValue", "()F", "<init>", "(Ljava/lang/String;ILcom/tencent/videocut/model/RatioType;F)V", "Companion", "a", "ORIGINAL", "R16_9", "R9_16", "R1_1", "R3_4", "R4_3", "R1_2", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class RatioTypeEnum {
    private static final /* synthetic */ RatioTypeEnum[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final RatioTypeEnum ORIGINAL;
    public static final RatioTypeEnum R16_9;
    public static final RatioTypeEnum R1_1;
    public static final RatioTypeEnum R1_2;
    public static final RatioTypeEnum R3_4;
    public static final RatioTypeEnum R4_3;
    public static final RatioTypeEnum R9_16;
    private final float ratioValue;

    @NotNull
    private final RatioType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/videocut/render/model/RatioTypeEnum$a;", "", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.model.RatioTypeEnum$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static final /* synthetic */ RatioTypeEnum[] $values() {
        return new RatioTypeEnum[]{ORIGINAL, R16_9, R9_16, R1_1, R3_4, R4_3, R1_2};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ORIGINAL = new RatioTypeEnum("ORIGINAL", 0, RatioType.ORIGINAL, 0.0f);
        R16_9 = new RatioTypeEnum("R16_9", 1, RatioType.R16_9, 1.7777778f);
        R9_16 = new RatioTypeEnum("R9_16", 2, RatioType.R9_16, 0.5625f);
        R1_1 = new RatioTypeEnum("R1_1", 3, RatioType.R1_1, 1.0f);
        R3_4 = new RatioTypeEnum("R3_4", 4, RatioType.R3_4, 0.75f);
        R4_3 = new RatioTypeEnum("R4_3", 5, RatioType.R4_3, 1.3333334f);
        R1_2 = new RatioTypeEnum("R1_2", 6, RatioType.R1_2, 0.5f);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    RatioTypeEnum(String str, int i3, RatioType ratioType, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), ratioType, Float.valueOf(f16));
        } else {
            this.type = ratioType;
            this.ratioValue = f16;
        }
    }

    public static RatioTypeEnum valueOf(String str) {
        return (RatioTypeEnum) Enum.valueOf(RatioTypeEnum.class, str);
    }

    public static RatioTypeEnum[] values() {
        return (RatioTypeEnum[]) $VALUES.clone();
    }

    public final float getRatioValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.ratioValue;
    }

    @NotNull
    public final RatioType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RatioType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }
}
