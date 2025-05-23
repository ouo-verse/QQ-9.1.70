package com.tencent.robot.aio.input.inputbar.config;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "whiteList", "", "", "getWhiteList", "()Ljava/util/List;", "setWhiteList", "(Ljava/util/List;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotAtConfig implements IConfigData {

    @SerializedName("enable")
    private boolean enable = true;

    @SerializedName("whiteList")
    @NotNull
    private List<String> whiteList;

    public RobotAtConfig() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.whiteList = emptyList;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    public final void setEnable(boolean z16) {
        this.enable = z16;
    }

    public final void setWhiteList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.whiteList = list;
    }
}
