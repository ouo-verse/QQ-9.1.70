package com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.thirdapp.ContentSize;
import com.tencent.mobileqq.guild.media.thirdapp.ScreenMode;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.c;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c;
import com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebJsReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\"\u0010!\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/JumpToUserAuthMethod;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/o;", "", "code", "", "l", "", "requestAppId", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", DomainData.DOMAIN_NAME, "o", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasSendAuthResult", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "jsApiCallback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "authCode", "r", "t", "", ReportConstant.COSTREPORT_PREFIX, "f", "b", "url", "Lorg/json/JSONObject;", "args", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/plugin/c;", "callback", "c", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class JumpToUserAuthMethod extends o {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/JumpToUserAuthMethod$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f229297b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.thirdapp.container.intent.c f229298c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f229299d;

        b(AtomicBoolean atomicBoolean, com.tencent.mobileqq.guild.media.thirdapp.container.intent.c cVar, String str) {
            this.f229297b = atomicBoolean;
            this.f229298c = cVar;
            this.f229299d = str;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.f
        public void a(@NotNull ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            JumpToUserAuthMethod.this.q(this.f229297b, intent, this.f229298c, this.f229299d);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/plugin/method/JumpToUserAuthMethod$c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "", "code", "", "msg", "Landroid/os/Bundle;", "extra", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c f229300a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JumpToUserAuthMethod f229301b;

        c(com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c cVar, JumpToUserAuthMethod jumpToUserAuthMethod) {
            this.f229300a = cVar;
            this.f229301b = jumpToUserAuthMethod;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.c
        public void a(long code, @Nullable String msg2, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, "[onResult] code " + code + ". extra " + extra);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("button", this.f229301b.l(code));
            jSONObject.put("auth_code", extra.getString("guildUserAuthCode"));
            GuildMediaWebJsReportTask webJsReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
            if (webJsReportTask != null) {
                webJsReportTask.j(code);
            }
            com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppLoadReportTask();
            if (thirdAppLoadReportTask != null) {
                thirdAppLoadReportTask.n(code);
            }
            c.a.a(this.f229300a, jSONObject, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l(long code) {
        int i3 = (int) code;
        if (i3 == 9999) {
            return 1;
        }
        return i3;
    }

    private final GuildOpenContainerLauncher.StartParams m(String requestAppId) {
        String str;
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        String p16 = p();
        Bundle bundle = new Bundle();
        bundle.putString("guildNickName", o());
        bundle.putString("guildUserAvatarUrl", n());
        bundle.putFloat("guildMiniAppHeightByDP", 376.0f);
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (channelInfo != null) {
            str = channelInfo.getChannelName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "MediaChannel.getCore().g\u2026Info()?.channelName ?: \"\"");
        }
        bundle.putString("channel_name", str);
        bundle.putInt("user_type", com.tencent.mobileqq.guild.media.z.h(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()));
        bundle.putInt("start_permission", GuildMediaUtils.k(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()) ? 1 : 0);
        return new GuildOpenContainerLauncher.StartParams(requestAppId, p16, guildID, E, "", 0L, null, bundle, 96, null);
    }

    private final String n() {
        return com.tencent.mobileqq.guild.media.core.j.a().d0().y1();
    }

    private final String o() {
        return com.tencent.mobileqq.guild.media.core.j.a().d0().z1();
    }

    private final String p() {
        ContentSize thirdAppPlaceHolderSize;
        boolean contains$default;
        String str;
        GuildMediaChannelViewModel channelViewModel = getChannelViewModel();
        if (channelViewModel == null || (thirdAppPlaceHolderSize = channelViewModel.getThirdAppPlaceHolderSize()) == null) {
            return "10000-pages-together/player-auth/index.html";
        }
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) "10000-pages-together/player-auth/index.html", (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        if (thirdAppPlaceHolderSize.getScreenMode() == ScreenMode.LAND) {
            str = "1";
        } else {
            str = "0";
        }
        return "10000-pages-together/player-auth/index.html" + str2 + ("isHorizontal=" + str + "&left=" + thirdAppPlaceHolderSize.getLeftPlaceHolder() + "&right=" + thirdAppPlaceHolderSize.getRightPlaceHolder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(AtomicBoolean hasSendAuthResult, ContainerMsgIntent intent, final com.tencent.mobileqq.guild.media.thirdapp.container.intent.c jsApiCallback, String requestAppId) {
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, "userAuthFragment handle intent " + intent);
        if (intent instanceof MiniAppIntent.NotifyUserAuthResultIntent) {
            if (hasSendAuthResult.compareAndSet(false, true)) {
                r(r7.getCode(), ((MiniAppIntent.NotifyUserAuthResultIntent) intent).getAuthCode(), jsApiCallback);
                return;
            }
            return;
        }
        if ((intent instanceof MainProcessIntent.ContainerLifeIntent) && !hasSendAuthResult.get() && ((MainProcessIntent.ContainerLifeIntent) intent).getEvent() == ContainerLifeEvent.ON_MINIAPP_DISMISS) {
            logger.d().d("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, "now sendUserAuthRequest while UserAuthDialog dismiss!");
            com.tencent.mobileqq.guild.media.core.j.a().d0().n2(requestAppId, new Function4<Integer, String, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.JumpToUserAuthMethod$handleAuthFragmentIntent$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool, String str2) {
                    invoke(num.intValue(), str, bool.booleanValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg, boolean z16, @NotNull String authCode) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(authCode, "authCode");
                    Logger.f235387a.d().d("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, "sendUserAuthRequest from dialog destroy ret " + i3 + ", errMsg " + errMsg + ", isAuth " + z16 + ", authCode " + authCode);
                    long j3 = i3 == 0 ? 1L : i3;
                    JumpToUserAuthMethod jumpToUserAuthMethod = JumpToUserAuthMethod.this;
                    if (i3 == 0) {
                        errMsg = authCode;
                    }
                    jumpToUserAuthMethod.r(j3, errMsg, jsApiCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long code, String authCode, com.tencent.mobileqq.guild.media.thirdapp.container.intent.c jsApiCallback) {
        if (jsApiCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putString("guildUserAuthCode", authCode);
            Unit unit = Unit.INSTANCE;
            c.a.a(jsApiCallback, code, null, bundle, 2, null);
        }
    }

    private final boolean s() {
        Activity activity;
        boolean z16;
        WeakReference<Activity> a16 = e().a();
        if (a16 != null) {
            activity = a16.get();
        } else {
            activity = null;
        }
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, "[isActivityAlive] isActivityAlive " + z16);
        return z16;
    }

    private final void t(String requestAppId, com.tencent.mobileqq.guild.media.thirdapp.container.intent.c jsApiCallback) {
        String str;
        boolean z16;
        List<String> listOf;
        DialogFragment dialogFragment;
        Activity activity;
        FragmentActivity fragmentActivity;
        FragmentManager fragmentManager;
        com.tencent.mobileqq.guild.media.thirdapp.container.b bVar;
        String str2;
        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (thirdAppInfo != null) {
            str = thirdAppInfo.getAppId();
        } else {
            str = null;
        }
        if (!TextUtils.equals(str, requestAppId)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            if (thirdAppInfo != null) {
                str2 = thirdAppInfo.getAppId();
            } else {
                str2 = null;
            }
            String str3 = "jumpToUserAuthMiniApp: error appId. requestAppId[" + requestAppId + "], cacheAppId[" + str2 + "]";
            if (str3 instanceof String) {
                bVar2.a().add(str3);
            }
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, (String) it.next(), null);
            }
            c.a.a(jsApiCallback, -9999L, null, null, 6, null);
            return;
        }
        if (thirdAppInfo != null && thirdAppInfo.getAntiAddiction() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && com.tencent.mobileqq.guild.media.core.j.a().d0().getIsPreventAddictionLimit()) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("jumpToUserAuthMiniApp: check prevent addiction limit");
            Iterator<T> it5 = bVar3.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, (String) it5.next(), null);
            }
            c.a.a(jsApiCallback, 1L, null, null, 6, null);
            return;
        }
        ActivityResultCaller b16 = GuildOpenContainerLauncher.f229226a.b(m(requestAppId), GuildOpenContainerLauncher.ContainerType.MINI_APP);
        b bVar4 = new b(atomicBoolean, jsApiCallback, requestAppId);
        String[] strArr = new String[2];
        String qualifiedName = Reflection.getOrCreateKotlinClass(MiniAppIntent.NotifyUserAuthResultIntent.class).getQualifiedName();
        String str4 = "";
        if (qualifiedName == null) {
            qualifiedName = "";
        }
        strArr[0] = qualifiedName;
        String qualifiedName2 = Reflection.getOrCreateKotlinClass(MainProcessIntent.ContainerLifeIntent.class).getQualifiedName();
        if (qualifiedName2 != null) {
            str4 = qualifiedName2;
        }
        strArr[1] = str4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) strArr);
        for (String str5 : listOf) {
            if (b16 instanceof com.tencent.mobileqq.guild.media.thirdapp.container.b) {
                bVar = (com.tencent.mobileqq.guild.media.thirdapp.container.b) b16;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.mb(str5, bVar4);
            }
        }
        if (b16 instanceof DialogFragment) {
            dialogFragment = (DialogFragment) b16;
        } else {
            dialogFragment = null;
        }
        WeakReference<Activity> a16 = e().a();
        if (a16 != null) {
            activity = a16.get();
        } else {
            activity = null;
        }
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            fragmentManager = fragmentActivity.getSupportFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (dialogFragment != null && fragmentManager != null && s()) {
            com.tencent.mobileqq.guild.base.extension.d.a(dialogFragment, fragmentManager, b16.getClass().getCanonicalName());
            return;
        }
        Logger logger3 = Logger.f235387a;
        Logger.b bVar5 = new Logger.b();
        bVar5.a().add("[jumpToUserAuthMiniApp] dialogFragment or fragmentManager is null!");
        Iterator<T> it6 = bVar5.a().iterator();
        while (it6.hasNext()) {
            Logger.f235387a.d().e("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, (String) it6.next(), null);
        }
        c.a.a(jsApiCallback, 900L, null, null, 6, null);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    @NotNull
    public String b() {
        return "authUserProfile";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o, com.tencent.mobileqq.guild.media.thirdapp.container.plugin.b
    public boolean c(@NotNull String url, @Nullable JSONObject args, @NotNull com.tencent.mobileqq.guild.media.thirdapp.container.plugin.c callback) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str2 = null;
        if (args != null) {
            str = args.optString("app_id");
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (args != null) {
            str2 = args.optString("user_id");
        }
        if (str2 != null) {
            str3 = str2;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.JumpToUserAuthMethod", 1, "[onInvoke], appId " + str + ", userId " + str3);
        c cVar = new c(callback, this);
        GuildMediaWebJsReportTask webJsReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
        if (webJsReportTask != null) {
            webJsReportTask.k();
        }
        com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppLoadReportTask();
        if (thirdAppLoadReportTask != null) {
            thirdAppLoadReportTask.o();
        }
        t(str, cVar);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.plugin.method.o
    @NotNull
    public String f() {
        return "QGMC.MediaThirdApp.JumpToUserAuthMethod";
    }
}
