package com.tencent.mobileqq.zplan.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/ZPlanStickerInfo;", "", "stickerId", "", "data", "", "(ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getStickerId", "()I", "setStickerId", "(I)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class ZPlanStickerInfo {

    @NotNull
    private String data;
    private int stickerId;

    public ZPlanStickerInfo() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public final int getStickerId() {
        return this.stickerId;
    }

    public final void setData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.data = str;
    }

    public final void setStickerId(int i3) {
        this.stickerId = i3;
    }

    public ZPlanStickerInfo(int i3, @NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.stickerId = i3;
        this.data = data;
    }

    public /* synthetic */ ZPlanStickerInfo(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str);
    }
}
