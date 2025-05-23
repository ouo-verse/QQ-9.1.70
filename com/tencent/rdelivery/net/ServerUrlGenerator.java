package com.tencent.rdelivery.net;

import android.text.TextUtils;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.rdelivery.RDeliverySetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/rdelivery/net/ServerUrlGenerator;", "", "", "prefixValue", "Lcom/tencent/rdelivery/net/ServerUrlGenerator$ProtocolPathInUrl;", "path", "businessSetName", "b", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "a", "<init>", "()V", "ProtocolPathInUrl", "ServerUrlPrefix", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ServerUrlGenerator {

    /* renamed from: a, reason: collision with root package name */
    public static final ServerUrlGenerator f364301a = new ServerUrlGenerator();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/rdelivery/net/ServerUrlGenerator$ProtocolPathInUrl;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "PULL_ALL_CONFIG_SWITCH_DATA", "PULL_ALL_CONFIG_SWITCH_DATA_ENCRYPT", "BATCH_PULL_ALL_CONFIG_SWITCH_DATA", "GET_CONFIG_SWITCH_DATA_BY_TASK_ID", "GET_CONFIG_SWITCH_DATA_BY_TASK_ID_ENCRYPT", "GET_SDK_SPECIFIC_CONFIG", "REPORT_PULL_EVENT", "REPORT_SDK_ERR", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum ProtocolPathInUrl {
        PULL_ALL_CONFIG_SWITCH_DATA("v1/config/pull"),
        PULL_ALL_CONFIG_SWITCH_DATA_ENCRYPT("v3/config/pull"),
        BATCH_PULL_ALL_CONFIG_SWITCH_DATA("v3/config/batchpull"),
        GET_CONFIG_SWITCH_DATA_BY_TASK_ID("v1/config/get"),
        GET_CONFIG_SWITCH_DATA_BY_TASK_ID_ENCRYPT("v2/config/get"),
        GET_SDK_SPECIFIC_CONFIG("v1/sdkconfig/get"),
        REPORT_PULL_EVENT("ConfigPullEvent"),
        REPORT_SDK_ERR("v1/sdk/report");


        @NotNull
        private final String value;

        ProtocolPathInUrl(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rdelivery/net/ServerUrlGenerator$ServerUrlPrefix;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "RELEASE", "PRE_RELEASE", "TEST", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum ServerUrlPrefix {
        RELEASE("https://rdelivery.qq.com/"),
        PRE_RELEASE("https://p.rdelivery.qq.com/"),
        TEST("https://t.rdelivery.qq.com/");


        @NotNull
        private final String value;

        ServerUrlPrefix(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    ServerUrlGenerator() {
    }

    @NotNull
    public final String a(@NotNull RDeliverySetting setting, @NotNull ProtocolPathInUrl path) {
        int i3;
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(path, "path");
        BaseProto$ServerType customServerType = setting.getCustomServerType();
        if (customServerType != null) {
            i3 = customServerType.getValue();
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = "";
        sb5.append("");
        String businessSetName = setting.getBusinessSetName();
        if (businessSetName != null) {
            str = businessSetName;
        }
        sb5.append((Object) str);
        String sb6 = sb5.toString();
        String customServerUrl = setting.getCustomServerUrl();
        if (customServerUrl == null) {
            customServerUrl = ServerUrlPrefix.RELEASE.getValue();
        }
        String customServerUrl2 = setting.getCustomServerUrl();
        if (customServerUrl2 == null) {
            customServerUrl2 = ServerUrlPrefix.PRE_RELEASE.getValue();
        }
        String customServerUrl3 = setting.getCustomServerUrl();
        if (customServerUrl3 == null) {
            customServerUrl3 = ServerUrlPrefix.TEST.getValue();
        }
        if (i3 == BaseProto$ServerType.RELEASE.getValue()) {
            return b(customServerUrl, path, sb6);
        }
        if (i3 == BaseProto$ServerType.PRE_RELEASE.getValue()) {
            return b(customServerUrl2, path, sb6);
        }
        if (i3 == BaseProto$ServerType.TEST.getValue()) {
            return b(customServerUrl3, path, sb6);
        }
        return b(customServerUrl, path, sb6);
    }

    @NotNull
    public final String b(@NotNull String prefixValue, @NotNull ProtocolPathInUrl path, @Nullable String businessSetName) {
        Intrinsics.checkParameterIsNotNull(prefixValue, "prefixValue");
        Intrinsics.checkParameterIsNotNull(path, "path");
        if (!TextUtils.isEmpty(businessSetName)) {
            return prefixValue + businessSetName + '/' + path.getValue();
        }
        return prefixValue + path.getValue();
    }
}
