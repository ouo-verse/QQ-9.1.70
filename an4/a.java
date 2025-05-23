package an4;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$ArkMsgRecvInfo;
import trpc.yes.common.UserProxyCmdOuterClass$GetArkMsgBodyRsp;
import trpc.yes.common.UserProxyCmdOuterClass$SendArkMsgRsp;
import trpc.yes.common.UserProxyCmdOuterClass$ShareArkToGuildRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\b\u0006*\u0002%(\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\"\u0010\u0011\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0015R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010)\u00a8\u0006-"}, d2 = {"Lan4/a;", "", "", "teamId", "", "b", "textMessage", "", "Ltrpc/yes/common/UserProxyCmdOuterClass$ArkMsgRecvInfo;", "recList", VirtualAppProxy.KEY_GAME_ID, "mateData", "", "g", "guildId", "", "uinLong", tl.h.F, "", "f", "arkString", "Landroid/content/Intent;", "d", "isCPDD", "c", "Landroid/app/Activity;", EventKey.ACT, "i", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "receiveList", "j", "requestCode", "requestCode2", "data", "e", "Ljava/lang/String;", "lastTeamId", "an4/a$a", "Lan4/a$a;", "sendArkMsgListener", "an4/a$b", "Lan4/a$b;", "sendArkToGuildListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f26353a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String lastTeamId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C0053a sendArkMsgListener = new C0053a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b sendArkToGuildListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"an4/a$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$SendArkMsgRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: an4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0053a implements IResultListener<UserProxyCmdOuterClass$SendArkMsgRsp> {
        C0053a() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable UserProxyCmdOuterClass$SendArkMsgRsp result) {
            com.tencent.timi.game.ui.widget.f.c("\u5df2\u53d1\u9001");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c(ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"an4/a$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$ShareArkToGuildRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<UserProxyCmdOuterClass$ShareArkToGuildRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable UserProxyCmdOuterClass$ShareArkToGuildRsp result) {
            com.tencent.timi.game.ui.widget.f.c("\u5df2\u53d1\u9001");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c(ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"an4/a$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetArkMsgBodyRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26357a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<Activity> f26358b;

        c(String str, WeakReference<Activity> weakReference) {
            this.f26357a = str;
            this.f26358b = weakReference;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable UserProxyCmdOuterClass$GetArkMsgBodyRsp result) {
            String str;
            PBStringField pBStringField;
            if (result != null && (pBStringField = result.body_json) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                Intent d16 = a.f26353a.d(this.f26357a, str);
                d16.putExtra("share_not_send_by_client", true);
                d16.putExtra(ForwardBaseOption.FORWARD_INPUT_VIEW_HIDE, true);
                Activity activity = this.f26358b.get();
                if (activity != null) {
                    RouteUtils.startActivityForResult(activity, d16, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, 1185);
                    return;
                }
                return;
            }
            com.tencent.timi.game.utils.l.e("FleetCPDDArkShareUtil", "shareArkToQQFriend error " + str);
            com.tencent.timi.game.ui.widget.f.c("\u5206\u4eab\u6570\u636e\u9519\u8bef");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c("\u5206\u4eab\u6570\u636e\u9519\u8bef");
        }
    }

    a() {
    }

    private final int b(String teamId) {
        Long longOrNull;
        long j3;
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        if (gVar != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(teamId);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            gm4.c K0 = gVar.K0(j3);
            if (K0 != null) {
                return K0.o1();
            }
        }
        return 0;
    }

    private final String c(String teamId, boolean isCPDD) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("team_id", teamId);
        String str = "1";
        jSONObject2.put("roomtype", "1");
        jSONObject2.put("entryscene", "1");
        if (isCPDD) {
            str = "2";
        }
        jSONObject2.put("destscene", str);
        jSONObject2.put("game_id", b(teamId));
        jSONObject.put(DownloadInfo.spKey_Config, jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
        return jSONObject3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent d(String teamId, String arkString) {
        Intent intent = new Intent();
        try {
            JSONObject jSONObject = new JSONObject(arkString);
            String c16 = c(teamId, false);
            intent.putExtra("forward_type", 27);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", jSONObject.optString("app"));
            intent.putExtra("forward_ark_app_view", jSONObject.optString("view"));
            intent.putExtra("forward_ark_app_ver", jSONObject.optString("ver"));
            intent.putExtra("forward_ark_app_prompt", jSONObject.optString("prompt"));
            intent.putExtra("forward_ark_app_meta", c16);
            com.tencent.timi.game.utils.l.i("FleetCPDDArkShareUtil", "getShareArkIntent " + c16 + " " + teamId);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, "{\n        \"forward\":1,\n        \"autosize\":0,\n        \"type\":\"normal\"\n    }");
            intent.putExtra("appName", jSONObject.optString("app"));
            intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, jSONObject.optString("view"));
            intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, jSONObject.optString("ver"));
            intent.putExtra(QQCustomArkDialogUtil.META_DATA, c16);
        } catch (JSONException e16) {
            com.tencent.timi.game.utils.l.e("FleetCPDDArkShareUtil", "shareArkToQQFriend error " + e16);
        }
        return intent;
    }

    private final boolean f(String guildId) {
        return !TextUtils.isEmpty(guildId);
    }

    private final void g(String textMessage, List<UserProxyCmdOuterClass$ArkMsgRecvInfo> recList, int gameId, String mateData) {
        bn4.d.f28702a.a(textMessage, recList, 0, ((ll4.a) mm4.b.b(ll4.a.class)).h(), gameId, mateData, sendArkMsgListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void h(String guildId, int gameId, long uinLong) {
        long j3;
        Long longOrNull;
        if (guildId != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            bn4.e.a(gameId, j3, uinLong, c(lastTeamId, false), sendArkToGuildListener);
        } else {
            com.tencent.timi.game.ui.widget.f.c(ShareJsPlugin.ERRMSG_INVITE_REQUIRE);
        }
    }

    public final void e(int requestCode, int requestCode2, @Nullable Intent data) {
        boolean z16;
        String str;
        int i3;
        String str2;
        if (data != null) {
            z16 = data.getBooleanExtra("share_process_by_caller", false);
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        Long l3 = null;
        if (data != null) {
            str = data.getStringExtra("uin");
        } else {
            str = null;
        }
        if (data != null) {
            i3 = data.getIntExtra("uintype", 0);
        } else {
            i3 = 0;
        }
        if (data == null || (str2 = data.getStringExtra("share_emoji_text")) == null) {
            str2 = "";
        }
        com.tencent.timi.game.utils.l.i("FleetCPDDArkShareUtil", "doOnActivityResult " + str + "," + i3 + "," + str2);
        if (str != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        }
        if (l3 != null) {
            ArrayList arrayList = new ArrayList();
            UserProxyCmdOuterClass$ArkMsgRecvInfo userProxyCmdOuterClass$ArkMsgRecvInfo = new UserProxyCmdOuterClass$ArkMsgRecvInfo();
            userProxyCmdOuterClass$ArkMsgRecvInfo.send_type.set(i3);
            userProxyCmdOuterClass$ArkMsgRecvInfo.recv_uin.set(l3.longValue());
            userProxyCmdOuterClass$ArkMsgRecvInfo.c2c_relation.set(false);
            arrayList.add(userProxyCmdOuterClass$ArkMsgRecvInfo);
            int b16 = b(lastTeamId);
            String stringExtra = data.getStringExtra("guild_id");
            if (f(stringExtra)) {
                h(stringExtra, b16, l3.longValue());
            } else {
                g(str2, arrayList, b16, c(lastTeamId, false));
            }
        }
    }

    public final void i(@NotNull Activity act, @NotNull String teamId) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(act, "act");
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        long h16 = ((ll4.a) mm4.b.b(ll4.a.class)).h();
        CommonOuterClass$QQUserId myQQUid = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        lastTeamId = teamId;
        WeakReference weakReference = new WeakReference(act);
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(teamId);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        int o16 = gVar.K0(j3).o1();
        bn4.b bVar = bn4.b.f28699a;
        Intrinsics.checkNotNullExpressionValue(myQQUid, "myQQUid");
        bVar.a(0, o16, h16, myQQUid, new c(teamId, weakReference));
    }

    public final void j(@NotNull Activity activity, @NotNull List<Long> receiveList, @NotNull String teamId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(receiveList, "receiveList");
        Intrinsics.checkNotNullParameter(teamId, "teamId");
        int b16 = b(teamId);
        lastTeamId = teamId;
        String c16 = c(teamId, true);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = receiveList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            UserProxyCmdOuterClass$ArkMsgRecvInfo userProxyCmdOuterClass$ArkMsgRecvInfo = new UserProxyCmdOuterClass$ArkMsgRecvInfo();
            userProxyCmdOuterClass$ArkMsgRecvInfo.send_type.set(0);
            userProxyCmdOuterClass$ArkMsgRecvInfo.recv_uin.set(longValue);
            userProxyCmdOuterClass$ArkMsgRecvInfo.c2c_relation.set(true);
            arrayList.add(userProxyCmdOuterClass$ArkMsgRecvInfo);
        }
        g("", arrayList, b16, c16);
    }
}
