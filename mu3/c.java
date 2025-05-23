package mu3;

import android.os.Bundle;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.qqmini.sdk.action.ShareAction;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lmu3/c;", "", "Lmu3/b;", "runtime", "", "shareTarget", "Lcom/tencent/qqmini/sdk/launcher/model/ShareChatModel;", "chatModel", TagName.ENGINE_TYPE, "", "b", "Lcom/tencent/qqmini/sdk/action/ShareAction;", "shareAction", "a", "<init>", "()V", "lib_minihippy_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f417637a = new c();

    c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean b(b runtime, int shareTarget, ShareChatModel chatModel, int engineType) {
        byte b16;
        byte b17;
        String str;
        ThirdPartyMiniPageProxy thirdPartyMiniPageProxy = (ThirdPartyMiniPageProxy) ProxyManager.get(ThirdPartyMiniPageProxy.class);
        Map<String, String> map = null;
        String str2 = null;
        if (thirdPartyMiniPageProxy != null) {
            MiniAppInfo miniAppInfo = runtime.getMiniAppInfo();
            if (miniAppInfo != null) {
                str2 = miniAppInfo.appId;
            }
            map = thirdPartyMiniPageProxy.getShareParam(str2, engineType);
        }
        if (map != null) {
            String str3 = map.get(ThirdPartyMiniPageProxy.KEY_SHARE_TEXT);
            if (str3 != null && str3.length() != 0) {
                b16 = false;
            } else {
                b16 = true;
            }
            if (b16 == false) {
                String str4 = map.get(ThirdPartyMiniPageProxy.KEY_SHARE_PIC_URL);
                if (str4 != null && str4.length() != 0) {
                    b17 = false;
                } else {
                    b17 = true;
                }
                if (b17 == false) {
                    InnerShareData.Builder shareTarget2 = new InnerShareData.Builder().setShareSource(12).setShareTarget(shareTarget);
                    MiniAppInfo miniAppInfo2 = runtime.getMiniAppInfo();
                    String str5 = "";
                    if (miniAppInfo2 == null || (str = miniAppInfo2.name) == null) {
                        str = "";
                    }
                    InnerShareData.Builder summary = shareTarget2.setTitle(str).setSummary(map.get(ThirdPartyMiniPageProxy.KEY_SHARE_TEXT));
                    String str6 = map.get(ThirdPartyMiniPageProxy.KEY_SHARE_QUERY);
                    if (str6 != null) {
                        str5 = str6;
                    }
                    summary.setEntryPath(str5).setSharePicPath(map.get(ThirdPartyMiniPageProxy.KEY_SHARE_PIC_URL)).setShareChatModel(chatModel).setMiniAppInfo(runtime.getMiniAppInfo()).setFromActivity(runtime.getAttachActivity()).build().shareAppMessage();
                    return true;
                }
            }
        }
        QMLog.e("FakeMiniShareHelper", "startShare: share param invalid.");
        return false;
    }

    static /* synthetic */ boolean c(c cVar, b bVar, int i3, ShareChatModel shareChatModel, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            shareChatModel = null;
        }
        return cVar.b(bVar, i3, shareChatModel, i16);
    }

    public final boolean a(@NotNull b runtime, @NotNull ShareAction shareAction, int engineType) {
        Intrinsics.checkParameterIsNotNull(runtime, "runtime");
        Intrinsics.checkParameterIsNotNull(shareAction, "shareAction");
        int what = shareAction.getWhat();
        boolean z16 = true;
        if (what != 1) {
            if (what != 2) {
                if (what != 5) {
                    QMLog.e("FakeMiniShareHelper", "doShare: un support type=" + shareAction.getWhat());
                    return false;
                }
                Bundle bundle = shareAction.getBundle();
                if (bundle == null) {
                    QMLog.e("FakeMiniShareHelper", "SHARE_QQ_CHAT: data is null.");
                    return false;
                }
                String string = bundle.getString("key_mini_app_share_chat_uin");
                int i3 = bundle.getInt("key_mini_app_share_chat_type", -1);
                String string2 = bundle.getString("key_mini_app_share_chat_name");
                if (string != null && string.length() != 0) {
                    z16 = false;
                }
                if (!z16 && i3 != -1) {
                    return b(runtime, 0, new ShareChatModel(i3, Long.parseLong(string), string2), engineType);
                }
                QMLog.e("FakeMiniShareHelper", "shareQQChat: param is invalid. uin=" + string + ", name=" + string2 + ", chatType=" + i3);
                return false;
            }
            return c(this, runtime, 1, null, engineType, 4, null);
        }
        return c(this, runtime, 0, null, engineType, 4, null);
    }
}
