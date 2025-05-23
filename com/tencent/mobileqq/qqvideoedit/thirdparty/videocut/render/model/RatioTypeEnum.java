package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RatioType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/RatioTypeEnum;", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "type", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "getType", "()Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;", "", "ratioValue", UserInfo.SEX_FEMALE, "getRatioValue", "()F", "<init>", "(Ljava/lang/String;ILcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/RatioType;F)V", "Companion", "a", "ORIGINAL", "R16_9", "R9_16", "R1_1", "R3_4", "R4_3", "R1_2", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public enum RatioTypeEnum {
    ORIGINAL(RatioType.ORIGINAL, 0.0f),
    R16_9(RatioType.R16_9, 1.7777778f),
    R9_16(RatioType.R9_16, 0.5625f),
    R1_1(RatioType.R1_1, 1.0f),
    R3_4(RatioType.R3_4, 0.75f),
    R4_3(RatioType.R4_3, 1.3333334f),
    R1_2(RatioType.R1_2, 0.5f);

    private final float ratioValue;

    @NotNull
    private final RatioType type;

    RatioTypeEnum(RatioType ratioType, float f16) {
        this.type = ratioType;
        this.ratioValue = f16;
    }

    public final float getRatioValue() {
        return this.ratioValue;
    }

    @NotNull
    public final RatioType getType() {
        return this.type;
    }
}
