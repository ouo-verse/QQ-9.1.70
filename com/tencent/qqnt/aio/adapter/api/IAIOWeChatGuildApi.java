package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.oskplayer.report.VideoResultCode;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0002\u001a\u001bJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0002H&J\b\u0010\u0011\u001a\u00020\u0002H&J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\bH&J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "requestTianshuConfig", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "type", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$a;", "getConfigData", "", "isWeChatMsgAgentFlagSuc", "isWeChatMsgAgentOpen", "report", "reportClik", "", "time", "getLastTime", "requestTianshuConfigIfNeeds", QCircleLpReportDc05507.KEY_CLEAR, "Landroid/content/Context;", "context", "openWeChatMiniApp", "isShowWechatGuildSettingItemRedDot", "", WadlProxyConsts.KEY_JUMP_URL, "handleUrl", "openWechat", "BIZ_TYPE_WX", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOWeChatGuildApi extends QRouteApi {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NULLDATA", "RECENT", "C2CAIO", "C2CAIOSEND", "C2CAIOREC", "GROUPAIO", "QZONE", "SETTING", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class BIZ_TYPE_WX {
        private static final /* synthetic */ BIZ_TYPE_WX[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BIZ_TYPE_WX C2CAIO;
        public static final BIZ_TYPE_WX C2CAIOREC;
        public static final BIZ_TYPE_WX C2CAIOSEND;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final BIZ_TYPE_WX GROUPAIO;
        public static final BIZ_TYPE_WX NULLDATA;
        public static final BIZ_TYPE_WX QZONE;
        public static final BIZ_TYPE_WX RECENT;
        public static final BIZ_TYPE_WX SETTING;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX$a;", "", "", "value", "Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$BIZ_TYPE_WX;", "a", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.adapter.api.IAIOWeChatGuildApi$BIZ_TYPE_WX$a, reason: from kotlin metadata */
        /* loaded from: classes23.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @NotNull
            public final BIZ_TYPE_WX a(int value) {
                BIZ_TYPE_WX biz_type_wx;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (BIZ_TYPE_WX) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
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
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ BIZ_TYPE_WX[] $values() {
            return new BIZ_TYPE_WX[]{NULLDATA, RECENT, C2CAIO, C2CAIOSEND, C2CAIOREC, GROUPAIO, QZONE, SETTING};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50463);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            NULLDATA = new BIZ_TYPE_WX("NULLDATA", 0, -1);
            RECENT = new BIZ_TYPE_WX("RECENT", 1, 1413);
            C2CAIO = new BIZ_TYPE_WX("C2CAIO", 2, 1403);
            C2CAIOSEND = new BIZ_TYPE_WX("C2CAIOSEND", 3, 14031);
            C2CAIOREC = new BIZ_TYPE_WX("C2CAIOREC", 4, 14032);
            GROUPAIO = new BIZ_TYPE_WX("GROUPAIO", 5, VideoResultCode.DOWNLOAD_FAKE_HTTP_STATUS_LOCAL_FILE_NOTFOUND);
            QZONE = new BIZ_TYPE_WX("QZONE", 6, 1405);
            SETTING = new BIZ_TYPE_WX("SETTING", 7, 1406);
            $VALUES = $values();
            INSTANCE = new Companion(null);
        }

        BIZ_TYPE_WX(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static BIZ_TYPE_WX valueOf(String str) {
            return (BIZ_TYPE_WX) Enum.valueOf(BIZ_TYPE_WX.class, str);
        }

        public static BIZ_TYPE_WX[] values() {
            return (BIZ_TYPE_WX[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOWeChatGuildApi$a;", "", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "setJson", "(Lorg/json/JSONObject;)V", ark.ARKMETADATA_JSON, "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {
        @Nullable
        JSONObject getJson();
    }

    void clear();

    @Nullable
    a getConfigData(@NotNull BIZ_TYPE_WX type);

    long getLastTime(@NotNull BIZ_TYPE_WX type);

    void handleUrl(@NotNull Context context, @NotNull String jumpUrl);

    boolean isShowWechatGuildSettingItemRedDot();

    boolean isWeChatMsgAgentFlagSuc();

    boolean isWeChatMsgAgentOpen();

    void openWeChatMiniApp(@NotNull BIZ_TYPE_WX type, @NotNull Context context);

    void openWechat(@NotNull Context context, @NotNull String jumpUrl);

    void report(@NotNull BIZ_TYPE_WX type);

    void report(@NotNull BIZ_TYPE_WX type, long time);

    void reportClik(@NotNull BIZ_TYPE_WX type);

    void requestTianshuConfig();

    void requestTianshuConfigIfNeeds();
}
