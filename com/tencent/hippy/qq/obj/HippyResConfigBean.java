package com.tencent.hippy.qq.obj;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/hippy/qq/obj/HippyResConfigBean;", "Lcom/tencent/freesia/IConfigData;", "()V", "hippyBridgeSoName", "", "getHippyBridgeSoName", "()Ljava/lang/String;", "setHippyBridgeSoName", "(Ljava/lang/String;)V", "hippyJsPluginType", "", "getHippyJsPluginType", "()I", "setHippyJsPluginType", "(I)V", "isHippyUseAllInOneSo", "", "()Z", "setHippyUseAllInOneSo", "(Z)V", "toString", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HippyResConfigBean implements IConfigData {

    @SerializedName("hippyBridgeSoName")
    @Nullable
    private String hippyBridgeSoName;

    @SerializedName("hippyJsPluginType")
    private int hippyJsPluginType;

    @SerializedName("isHippyUseAllInOneSo")
    private boolean isHippyUseAllInOneSo = true;

    @Nullable
    public final String getHippyBridgeSoName() {
        return this.hippyBridgeSoName;
    }

    public final int getHippyJsPluginType() {
        return this.hippyJsPluginType;
    }

    /* renamed from: isHippyUseAllInOneSo, reason: from getter */
    public final boolean getIsHippyUseAllInOneSo() {
        return this.isHippyUseAllInOneSo;
    }

    public final void setHippyBridgeSoName(@Nullable String str) {
        this.hippyBridgeSoName = str;
    }

    public final void setHippyJsPluginType(int i3) {
        this.hippyJsPluginType = i3;
    }

    public final void setHippyUseAllInOneSo(boolean z16) {
        this.isHippyUseAllInOneSo = z16;
    }

    @NotNull
    public String toString() {
        return "HippyResConfigBean(hippyJsPluginType=" + this.hippyJsPluginType + ", hippyBridgeSoName=" + this.hippyBridgeSoName + ", isHippyUseAllInOneSo=" + this.isHippyUseAllInOneSo + ')';
    }
}
