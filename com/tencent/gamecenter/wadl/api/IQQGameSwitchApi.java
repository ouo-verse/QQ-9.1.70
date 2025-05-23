package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/IQQGameSwitchApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "init", "", "name", "", "isFeatureSwitch", "default", "Lorg/json/JSONObject;", "getJSONObject", "Companion", "a", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameSwitchApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f106592a;

    @NotNull
    public static final String PARAMS_KEY_ACTION_TYPE = "actionType";

    @NotNull
    public static final String PARAMS_KEY_HIPPY_INFO = "hippyInfo";

    @NotNull
    public static final String PARAMS_KEY_NETWORK_CHECK = "netWorkCheck";

    @NotNull
    public static final String SWITCH_KEY_DOWNLOAD_CONFIG = "gamecenter_distribute_download_config";

    @NotNull
    public static final String SWITCH_KEY_SUBSCRIBE_CONFIG = "gamecenter_subscribe_config";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/IQQGameSwitchApi$a;", "", "<init>", "()V", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gamecenter.wadl.api.IQQGameSwitchApi$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f106592a = new Companion();

        Companion() {
        }
    }

    @Nullable
    JSONObject getJSONObject(@NotNull String name);

    void init();

    boolean isFeatureSwitch(@NotNull String name);

    boolean isFeatureSwitch(@NotNull String name, boolean r26);
}
