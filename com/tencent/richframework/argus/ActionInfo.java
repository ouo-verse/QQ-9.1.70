package com.tencent.richframework.argus;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\"B-\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/richframework/argus/ActionInfo;", "", "", "toString", "", "hashCode", "other", "", "equals", "windowToken", "I", "getWindowToken", "()I", "setWindowToken", "(I)V", "Lcom/tencent/richframework/argus/ActionInfo$Type;", "type", "Lcom/tencent/richframework/argus/ActionInfo$Type;", "getType", "()Lcom/tencent/richframework/argus/ActionInfo$Type;", "setType", "(Lcom/tencent/richframework/argus/ActionInfo$Type;)V", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_X, UserInfo.SEX_FEMALE, "getClickX", "()F", "setClickX", "(F)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_Y, "getClickY", "setClickY", "<init>", "(ILcom/tencent/richframework/argus/ActionInfo$Type;FF)V", "Type", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final /* data */ class ActionInfo {
    private float clickX;
    private float clickY;

    @NotNull
    private Type type;
    private int windowToken;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/richframework/argus/ActionInfo$Type;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "CLICK_VIEW", "FLING", "KEY_BACK", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public enum Type {
        UNKNOWN,
        CLICK_VIEW,
        FLING,
        KEY_BACK
    }

    @JvmOverloads
    public ActionInfo(int i3, @NotNull Type type) {
        this(i3, type, 0.0f, 0.0f, 12, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ActionInfo) {
                ActionInfo actionInfo = (ActionInfo) other;
                if (this.windowToken != actionInfo.windowToken || !Intrinsics.areEqual(this.type, actionInfo.type) || Float.compare(this.clickX, actionInfo.clickX) != 0 || Float.compare(this.clickY, actionInfo.clickY) != 0) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        int i16 = this.windowToken * 31;
        Type type = this.type;
        if (type != null) {
            i3 = type.hashCode();
        } else {
            i3 = 0;
        }
        return ((((i16 + i3) * 31) + Float.floatToIntBits(this.clickX)) * 31) + Float.floatToIntBits(this.clickY);
    }

    @NotNull
    public String toString() {
        return "ActionInfo{type=" + this.type + '}';
    }

    @JvmOverloads
    public ActionInfo(int i3, @NotNull Type type, float f16, float f17) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.windowToken = i3;
        this.type = type;
        this.clickX = f16;
        this.clickY = f17;
    }

    public /* synthetic */ ActionInfo(int i3, Type type, float f16, float f17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, type, (i16 & 4) != 0 ? 0.0f : f16, (i16 & 8) != 0 ? 0.0f : f17);
    }
}
