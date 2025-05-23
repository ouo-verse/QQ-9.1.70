package com.tencent.mobileqq.wink.model;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00011BC\b\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003JE\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\tH\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "", "component5", "", "component6", "xAxisPercentage", "yAxisPercentage", BasicAnimation.KeyPath.ROTATION, "scale", "tagName", "joinNums", "copy", "toString", "", "hashCode", "", "other", "", "equals", UserInfo.SEX_FEMALE, "getXAxisPercentage", "()F", "setXAxisPercentage", "(F)V", "getYAxisPercentage", "setYAxisPercentage", "getRotation", "setRotation", "getScale", "setScale", "Ljava/lang/String;", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "J", "getJoinNums", "()J", "setJoinNums", "(J)V", "<init>", "(FFFFLjava/lang/String;J)V", "Companion", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class InteractiveModel implements Serializable {
    public static final float DEFAULT_ROTATION = 0.0f;
    public static final float DEFAULT_SCALE = 1.0f;
    public static final float DEFAULT_X_AXIS_PERCENTAGE = 0.1f;
    public static final float DEFAULT_Y_AXIS_PERCENTAGE = 0.17f;
    private static final long serialVersionUID = 599093123447234432L;
    private long joinNums;
    private float rotation;
    private float scale;

    @NotNull
    private String tagName;
    private float xAxisPercentage;
    private float yAxisPercentage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveModel(float f16, float f17, float f18, float f19, @NotNull String tagName) {
        this(f16, f17, f18, f19, tagName, 0L, 32, null);
        Intrinsics.checkNotNullParameter(tagName, "tagName");
    }

    public static /* synthetic */ InteractiveModel copy$default(InteractiveModel interactiveModel, float f16, float f17, float f18, float f19, String str, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = interactiveModel.xAxisPercentage;
        }
        if ((i3 & 2) != 0) {
            f17 = interactiveModel.yAxisPercentage;
        }
        float f26 = f17;
        if ((i3 & 4) != 0) {
            f18 = interactiveModel.rotation;
        }
        float f27 = f18;
        if ((i3 & 8) != 0) {
            f19 = interactiveModel.scale;
        }
        float f28 = f19;
        if ((i3 & 16) != 0) {
            str = interactiveModel.tagName;
        }
        String str2 = str;
        if ((i3 & 32) != 0) {
            j3 = interactiveModel.joinNums;
        }
        return interactiveModel.copy(f16, f26, f27, f28, str2, j3);
    }

    /* renamed from: component1, reason: from getter */
    public final float getXAxisPercentage() {
        return this.xAxisPercentage;
    }

    /* renamed from: component2, reason: from getter */
    public final float getYAxisPercentage() {
        return this.yAxisPercentage;
    }

    /* renamed from: component3, reason: from getter */
    public final float getRotation() {
        return this.rotation;
    }

    /* renamed from: component4, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    /* renamed from: component6, reason: from getter */
    public final long getJoinNums() {
        return this.joinNums;
    }

    @NotNull
    public final InteractiveModel copy(float xAxisPercentage, float yAxisPercentage, float rotation, float scale, @NotNull String tagName, long joinNums) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        return new InteractiveModel(xAxisPercentage, yAxisPercentage, rotation, scale, tagName, joinNums);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractiveModel)) {
            return false;
        }
        InteractiveModel interactiveModel = (InteractiveModel) other;
        if (Float.compare(this.xAxisPercentage, interactiveModel.xAxisPercentage) == 0 && Float.compare(this.yAxisPercentage, interactiveModel.yAxisPercentage) == 0 && Float.compare(this.rotation, interactiveModel.rotation) == 0 && Float.compare(this.scale, interactiveModel.scale) == 0 && Intrinsics.areEqual(this.tagName, interactiveModel.tagName) && this.joinNums == interactiveModel.joinNums) {
            return true;
        }
        return false;
    }

    public final long getJoinNums() {
        return this.joinNums;
    }

    public final float getRotation() {
        return this.rotation;
    }

    public final float getScale() {
        return this.scale;
    }

    @NotNull
    public final String getTagName() {
        return this.tagName;
    }

    public final float getXAxisPercentage() {
        return this.xAxisPercentage;
    }

    public final float getYAxisPercentage() {
        return this.yAxisPercentage;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.xAxisPercentage) * 31) + Float.floatToIntBits(this.yAxisPercentage)) * 31) + Float.floatToIntBits(this.rotation)) * 31) + Float.floatToIntBits(this.scale)) * 31) + this.tagName.hashCode()) * 31) + androidx.fragment.app.a.a(this.joinNums);
    }

    public final void setJoinNums(long j3) {
        this.joinNums = j3;
    }

    public final void setRotation(float f16) {
        this.rotation = f16;
    }

    public final void setScale(float f16) {
        this.scale = f16;
    }

    public final void setTagName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    public final void setXAxisPercentage(float f16) {
        this.xAxisPercentage = f16;
    }

    public final void setYAxisPercentage(float f16) {
        this.yAxisPercentage = f16;
    }

    @NotNull
    public String toString() {
        return "InteractiveModel(xAxisPercentage=" + this.xAxisPercentage + ", yAxisPercentage=" + this.yAxisPercentage + ", rotation=" + this.rotation + ", scale=" + this.scale + ", tagName=" + this.tagName + ", joinNums=" + this.joinNums + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveModel(float f16, float f17, float f18, @NotNull String tagName) {
        this(f16, f17, f18, 0.0f, tagName, 0L, 40, null);
        Intrinsics.checkNotNullParameter(tagName, "tagName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveModel(float f16, float f17, @NotNull String tagName) {
        this(f16, f17, 0.0f, 0.0f, tagName, 0L, 44, null);
        Intrinsics.checkNotNullParameter(tagName, "tagName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveModel(float f16, @NotNull String tagName) {
        this(f16, 0.0f, 0.0f, 0.0f, tagName, 0L, 46, null);
        Intrinsics.checkNotNullParameter(tagName, "tagName");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveModel(@NotNull String tagName) {
        this(0.0f, 0.0f, 0.0f, 0.0f, tagName, 0L, 47, null);
        Intrinsics.checkNotNullParameter(tagName, "tagName");
    }

    @JvmOverloads
    public InteractiveModel(float f16, float f17, float f18, float f19, @NotNull String tagName, long j3) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        this.xAxisPercentage = f16;
        this.yAxisPercentage = f17;
        this.rotation = f18;
        this.scale = f19;
        this.tagName = tagName;
        this.joinNums = j3;
    }

    public /* synthetic */ InteractiveModel(float f16, float f17, float f18, float f19, String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.1f : f16, (i3 & 2) != 0 ? 0.17f : f17, (i3 & 4) != 0 ? 0.0f : f18, (i3 & 8) != 0 ? 1.0f : f19, str, (i3 & 32) != 0 ? 0L : j3);
    }
}
