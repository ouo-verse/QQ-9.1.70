package com.tencent.mobileqq.wechatguildreport.api;

import android.content.Context;
import android.view.View;
import com.tencent.ark.ark;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.oskplayer.report.VideoResultCode;
import com.tencent.oskplayer.util.SecretUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.vip.pb.TianShuAccess;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0003)*+J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\u0002H&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001e\u001a\u00020\nH&J \u0010\"\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\nH&J\u0010\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H&J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\rH&J \u0010(\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\nH&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "requestTianshuConfig", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "type", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "getConfig", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$a;", "getConfigData", "", "isWeChatMsgAgentFlagSuc", "isWeChatMsgAgentOpen", "", "getWeChatAgentReportFlag", "report", "reportClik", "reportClose", "", "time", "getLastTime", "requestTianshuConfigIfNeeds", QCircleLpReportDc05507.KEY_CLEAR, "Landroid/content/Context;", "context", "openWeChatMiniApp", "Landroid/view/View$OnClickListener;", "closeClickListener", "Landroid/view/View;", "getQZoneWechatGuildNoticeBar", "isShowWechatGuildSettingItemRedDot", "", WadlProxyConsts.KEY_JUMP_URL, "tipsShowAtTopActivity", "handleUrl", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$b;", "listener", "addListener", "listenerId", "removeListener", "openWechat", "BIZ_TYPE_WX", "a", "b", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface IWeChatGuildApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NULLDATA", "RECENT", "C2CAIO", "C2CAIOSEND", "C2CAIOREC", "GROUPAIO", "QZONE", "SETTING", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public enum BIZ_TYPE_WX {
        NULLDATA(-1),
        RECENT(1413),
        C2CAIO(1403),
        C2CAIOSEND(14031),
        C2CAIOREC(14032),
        GROUPAIO(VideoResultCode.DOWNLOAD_FAKE_HTTP_STATUS_LOCAL_FILE_NOTFOUND),
        QZONE(1405),
        SETTING(1406);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX$a;", "", "", "value", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "a", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wechatguildreport.api.IWeChatGuildApi$BIZ_TYPE_WX$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final BIZ_TYPE_WX a(int value) {
                BIZ_TYPE_WX biz_type_wx;
                boolean z16;
                BIZ_TYPE_WX[] values = BIZ_TYPE_WX.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        biz_type_wx = values[i3];
                        if (biz_type_wx.getValue() == value) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        biz_type_wx = null;
                        break;
                    }
                }
                if (biz_type_wx == null) {
                    return BIZ_TYPE_WX.NULLDATA;
                }
                return biz_type_wx;
            }

            Companion() {
            }
        }

        BIZ_TYPE_WX(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000e8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001e\u0010\"\u001a\u0004\u0018\u00010\b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001e\u0010%\u001a\u0004\u0018\u00010\b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001e\u0010+\u001a\u0004\u0018\u00010&8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$a;", "", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "getSceneId", "()Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "setSceneId", "(Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;)V", WadlProxyConsts.SCENE_ID, "", "b", "()Ljava/lang/Integer;", "setIAdId", "(Ljava/lang/Integer;)V", "iAdId", "", "getTraceInfo", "()Ljava/lang/String;", "setTraceInfo", "(Ljava/lang/String;)V", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "getText", IECSearchBar.METHOD_SET_TEXT, "text", "a", "setDes", SecretUtils.DES, "getIconUrl", "setIconUrl", "iconUrl", "getJumpUrl", "setJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "getRedType", "setRedType", "redType", "getType", "setType", "type", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "setJson", "(Lorg/json/JSONObject;)V", ark.ARKMETADATA_JSON, "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        @Nullable
        String a();

        @Nullable
        Integer b();

        @Nullable
        String getIconUrl();

        @Nullable
        JSONObject getJson();

        @Nullable
        String getJumpUrl();

        @Nullable
        Integer getRedType();

        @Nullable
        BIZ_TYPE_WX getSceneId();

        @Nullable
        String getText();

        @Nullable
        String getTraceInfo();

        @Nullable
        Integer getType();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$b;", "", "", "result", "", "Lcom/tencent/mobileqq/wechatguildreport/api/IWeChatGuildApi$BIZ_TYPE_WX;", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "map", "", "a", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
        void a(int result, @NotNull Map<BIZ_TYPE_WX, TianShuAccess.AdPlacementInfo> map);
    }

    int addListener(@NotNull b listener);

    void clear();

    @Nullable
    TianShuAccess.AdPlacementInfo getConfig(@NotNull BIZ_TYPE_WX type);

    @Nullable
    a getConfigData(@NotNull BIZ_TYPE_WX type);

    long getLastTime(@NotNull BIZ_TYPE_WX type);

    @Nullable
    View getQZoneWechatGuildNoticeBar(@NotNull Context context, @Nullable View.OnClickListener closeClickListener);

    int getWeChatAgentReportFlag();

    void handleUrl(@NotNull Context context, @NotNull String jumpUrl, boolean tipsShowAtTopActivity);

    boolean isShowWechatGuildSettingItemRedDot();

    boolean isWeChatMsgAgentFlagSuc();

    boolean isWeChatMsgAgentOpen();

    void openWeChatMiniApp(@NotNull BIZ_TYPE_WX type, @NotNull Context context);

    void openWechat(@NotNull Context context, @NotNull String jumpUrl, boolean tipsShowAtTopActivity);

    void removeListener(int listenerId);

    void report(@NotNull BIZ_TYPE_WX type);

    void report(@NotNull BIZ_TYPE_WX type, long time);

    void reportClik(@NotNull BIZ_TYPE_WX type);

    void reportClose(@NotNull BIZ_TYPE_WX type);

    void requestTianshuConfig();

    void requestTianshuConfigIfNeeds();
}
