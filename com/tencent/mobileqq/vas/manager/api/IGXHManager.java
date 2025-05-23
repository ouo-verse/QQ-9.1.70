package com.tencent.mobileqq.vas.manager.api;

import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.api.EIPCCallbackWrapper;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import eipc.EIPCCallback;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 62\u00020\u0001:\u000278J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H&J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J2\u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020!H&JH\u0010*\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010+\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u00100\u001a\u00020\n2\u0006\u0010\t\u001a\u00020/H&J*\u00103\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010/H&J\u001a\u00104\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010/H&J\u001a\u00105\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010/H&\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/vas/manager/api/IGXHManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "", "itemId", "", "bid", "Leipc/EIPCCallback;", "callback", "", GameCenterAPIJavaScript.QUERY_INFO, "business", "data", "notify", "quickSwitchDefaultMode", "iconId", "checkAppIconEnable", "getClientAppIconId", "setClientAppIconId", "type", "forceUpdateVasUserData", "jsonString", "updateTroopEnterEffectInfo", ColorRingJsPlugin.Method_SetUp, "setMagicFont", "id", "setMagicFontType", "getCustomBgList", "uin", "path", "effectId", "uinType", "", "isEncode", "setCustomChatBackground", "title", "appId", "appName", WadlProxyConsts.SCENE_ID, "sourceId", "reportExt", "openRechargePanel", "updatePendant", "Lcom/tencent/mobileqq/vas/manager/api/IGXHManager$FriendSelectParams;", "params", "openSelectFriendsPanel", "Lcom/tencent/mobileqq/vas/api/EIPCCallbackWrapper;", "openMobilePhotoSelect", "userId", "aid", "openPayItem", "getLocalToggleStatus", "setLocalToggleStatus", "Companion", "a", "FriendSelectParams", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IGXHManager extends IVasManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f310000a;
    public static final int UPDATE_DATA_TYPE_ALL = 0;
    public static final int UPDATE_DATA_TYPE_FUNCALL = 2;
    public static final int UPDATE_DATA_TYPE_TROOP_ENTER_EFFECT = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/manager/api/IGXHManager$FriendSelectParams;", "Ljava/io/Serializable;", "", "isSingle", "Z", "", "maxNum", "I", "", "title", "Ljava/lang/String;", "finishText", "isShowTroop", "troopEnterTitle", "overLimitTips", "isShowGuild", "isMiniMode", "isShowFriendFirst", "requestCode", "<init>", "()V", "Companion", "a", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class FriendSelectParams implements Serializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @JvmField
        public boolean isMiniMode;

        @JvmField
        public boolean isShowGuild;

        @JvmField
        public boolean isSingle;

        @JvmField
        public int maxNum = 9;

        @JvmField
        @NotNull
        public String title = "";

        @JvmField
        @NotNull
        public String finishText = "\u5b8c\u6210";

        @JvmField
        public boolean isShowTroop = true;

        @JvmField
        @NotNull
        public String troopEnterTitle = "";

        @JvmField
        @NotNull
        public String overLimitTips = "";

        @JvmField
        public boolean isShowFriendFirst = true;

        @JvmField
        public int requestCode = 1000;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/manager/api/IGXHManager$FriendSelectParams$a;", "", "Lorg/json/JSONObject;", "params", "Lcom/tencent/mobileqq/vas/manager/api/IGXHManager$FriendSelectParams;", "a", "<init>", "()V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.manager.api.IGXHManager$FriendSelectParams$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final FriendSelectParams a(@NotNull JSONObject params) {
                Intrinsics.checkNotNullParameter(params, "params");
                FriendSelectParams friendSelectParams = new FriendSelectParams();
                friendSelectParams.isSingle = !params.optBoolean("isMulti", true);
                friendSelectParams.maxNum = params.optInt("limitNum", friendSelectParams.maxNum);
                String optString = params.optString("title", friendSelectParams.title);
                Intrinsics.checkNotNullExpressionValue(optString, "params.optString(\"title\", title)");
                friendSelectParams.title = optString;
                String optString2 = params.optString("finishText", friendSelectParams.finishText);
                Intrinsics.checkNotNullExpressionValue(optString2, "params.optString(\"finishText\", finishText)");
                friendSelectParams.finishText = optString2;
                friendSelectParams.isShowTroop = params.optBoolean("isShowTroop", friendSelectParams.isShowTroop);
                String optString3 = params.optString("troopEnterTitle", friendSelectParams.troopEnterTitle);
                Intrinsics.checkNotNullExpressionValue(optString3, "params.optString(\"troopE\u2026rTitle\", troopEnterTitle)");
                friendSelectParams.troopEnterTitle = optString3;
                String optString4 = params.optString("overLimitTips", friendSelectParams.overLimitTips);
                Intrinsics.checkNotNullExpressionValue(optString4, "params.optString(\"overLimitTips\", overLimitTips)");
                friendSelectParams.overLimitTips = optString4;
                return friendSelectParams;
            }

            Companion() {
            }
        }

        @JvmStatic
        @NotNull
        public static final FriendSelectParams fromJson(@NotNull JSONObject jSONObject) {
            return INSTANCE.a(jSONObject);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/manager/api/IGXHManager$a;", "", "<init>", "()V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.manager.api.IGXHManager$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f310000a = new Companion();

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class b {
        public static /* synthetic */ void a(IGXHManager iGXHManager, String str, String str2, int i3, int i16, boolean z16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 16) != 0) {
                    z16 = false;
                }
                iGXHManager.setCustomChatBackground(str, str2, i3, i16, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomChatBackground");
        }
    }

    void checkAppIconEnable(@NotNull String iconId, @NotNull EIPCCallback callback);

    void forceUpdateVasUserData(int type);

    void getClientAppIconId(@NotNull EIPCCallback callback);

    void getCustomBgList(@NotNull EIPCCallback callback);

    void getLocalToggleStatus(@NotNull String jsonString, @Nullable EIPCCallbackWrapper callback);

    void notify(@NotNull String setKey, @NotNull String business, @NotNull String data, @NotNull EIPCCallback callback);

    void openMobilePhotoSelect(@NotNull EIPCCallbackWrapper callback);

    void openPayItem(@NotNull String userId, @NotNull String aid, @NotNull String itemId, @Nullable EIPCCallbackWrapper callback);

    void openRechargePanel(@NotNull String title, int appId, @NotNull String appName, @NotNull String sceneId, @NotNull String sourceId, @NotNull String reportExt, @NotNull EIPCCallback callback);

    void openSelectFriendsPanel(@NotNull FriendSelectParams params, @NotNull EIPCCallback callback);

    void queryInfo(@NotNull String setKey, int itemId, long bid, @NotNull EIPCCallback callback);

    void quickSwitchDefaultMode(@NotNull EIPCCallback callback);

    void setClientAppIconId(@NotNull String iconId, @NotNull EIPCCallback callback);

    void setCustomChatBackground(@NotNull String uin, @NotNull String path, int effectId, int uinType, boolean isEncode);

    void setLocalToggleStatus(@NotNull String jsonString, @Nullable EIPCCallbackWrapper callback);

    void setMagicFont(@NotNull String setup, @NotNull EIPCCallback callback);

    void setMagicFontType(@NotNull String id5, @NotNull EIPCCallback callback);

    void updatePendant(@NotNull String jsonString, @NotNull EIPCCallback callback);

    void updateTroopEnterEffectInfo(@NotNull String jsonString, @NotNull EIPCCallback callback);
}
