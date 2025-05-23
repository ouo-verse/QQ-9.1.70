package com.tencent.mobileqq.guild.webview;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.webview.g;
import com.tencent.mobileqq.guild.webview.methods.AddGuildExternalMethod;
import com.tencent.mobileqq.guild.webview.methods.AddGuildMethod;
import com.tencent.mobileqq.guild.webview.methods.CheckGuildTabOpenMethod;
import com.tencent.mobileqq.guild.webview.methods.FetchGuildIdByInvitedMethod;
import com.tencent.mobileqq.guild.webview.methods.GetFontScaleRateMethod;
import com.tencent.mobileqq.guild.webview.methods.GuildGetGuidAndQimei36Method;
import com.tencent.mobileqq.guild.webview.methods.GuildGetUserTypeMethod;
import com.tencent.mobileqq.guild.webview.methods.GuildsetSpeakRuleBlockWordMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenEmojiSelPanelMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenGuildAIOMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenGuildBindGroupPageMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenGuildPageByInvitedMethod;
import com.tencent.mobileqq.guild.webview.methods.OpenGuildPageWithSigMethod;
import com.tencent.mobileqq.guild.webview.methods.RefreshGuildListMethod;
import com.tencent.mobileqq.guild.webview.methods.aa;
import com.tencent.mobileqq.guild.webview.methods.ab;
import com.tencent.mobileqq.guild.webview.methods.ac;
import com.tencent.mobileqq.guild.webview.methods.ad;
import com.tencent.mobileqq.guild.webview.methods.ae;
import com.tencent.mobileqq.guild.webview.methods.h;
import com.tencent.mobileqq.guild.webview.methods.i;
import com.tencent.mobileqq.guild.webview.methods.j;
import com.tencent.mobileqq.guild.webview.methods.k;
import com.tencent.mobileqq.guild.webview.methods.l;
import com.tencent.mobileqq.guild.webview.methods.m;
import com.tencent.mobileqq.guild.webview.methods.n;
import com.tencent.mobileqq.guild.webview.methods.o;
import com.tencent.mobileqq.guild.webview.methods.p;
import com.tencent.mobileqq.guild.webview.methods.q;
import com.tencent.mobileqq.guild.webview.methods.r;
import com.tencent.mobileqq.guild.webview.methods.u;
import com.tencent.mobileqq.guild.webview.methods.v;
import com.tencent.mobileqq.guild.webview.methods.w;
import com.tencent.mobileqq.guild.webview.methods.x;
import com.tencent.mobileqq.guild.webview.methods.z;
import com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/GuildJsBridgeMethodRegistry;", "", "", "methodName", "Lcom/tencent/mobileqq/guild/webview/g$a;", "a", "", "b", "Lkotlin/Lazy;", "()Ljava/util/Map;", Constants.Service.METHODS, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJsBridgeMethodRegistry {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildJsBridgeMethodRegistry f235736a = new GuildJsBridgeMethodRegistry();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy methods;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends g.a>>() { // from class: com.tencent.mobileqq.guild.webview.GuildJsBridgeMethodRegistry$methods$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends g.a> invoke() {
                Map<String, ? extends g.a> mapOf;
                long uptimeMillis = SystemClock.uptimeMillis();
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("openGuildInfoPage", new ac()), TuplesKt.to("openGuildInfoPageToJoin", new u()), TuplesKt.to("openGuildPageByInvited", new OpenGuildPageByInvitedMethod()), TuplesKt.to("openGuildShareURL", new aa()), TuplesKt.to("openGuildPageWithSig", new OpenGuildPageWithSigMethod()), TuplesKt.to("jumpToGuildDiscover", new m()), TuplesKt.to("openGuildAIO", new OpenGuildAIOMethod()), TuplesKt.to("openChannelAio", new i()), TuplesKt.to("jumpGuildFormSearch", new n()), TuplesKt.to("addGuild", new AddGuildMethod()), TuplesKt.to("addGuildWithJoinSig", new com.tencent.mobileqq.guild.webview.methods.e()), TuplesKt.to("fetchGuildIdByInvited", new FetchGuildIdByInvitedMethod()), TuplesKt.to("checkGuildTabOpen", new CheckGuildTabOpenMethod()), TuplesKt.to("refreshGuildList", new RefreshGuildListMethod()), TuplesKt.to("addGuildExternal", new AddGuildExternalMethod()), TuplesKt.to("grpo_jump_robot_summary_android", new com.tencent.mobileqq.guild.webview.methods.f()), TuplesKt.to("openGuildRolePage", new z()), TuplesKt.to("openGuildInfoSettingPage", new v()), TuplesKt.to("openSubChannelManagePage", new ae()), TuplesKt.to("openCreateGuildRolePage", new q()), TuplesKt.to("openLevelRoleList", new w()), TuplesKt.to("removeGuildBanner", new j()), TuplesKt.to("getUserType", new GuildGetUserTypeMethod()), TuplesKt.to(DeviceInfoPlugin.API_GET_GUID, new GuildGetGuidAndQimei36Method()), TuplesKt.to("updateGuildBanner", new k()), TuplesKt.to("closeLiveAgreement", new h()), TuplesKt.to("openEmojiSelPanel", new OpenEmojiSelPanelMethod()), TuplesKt.to("openClientManagePage", new p()), TuplesKt.to("getAppId", new com.tencent.mobileqq.guild.webview.methods.g()), TuplesKt.to("openGuildUserProfile", new ab()), TuplesKt.to("openLinkExaminingDialog", new ad()), TuplesKt.to("launchFeedEditor", new o()), TuplesKt.to("openThirdAppPanel", new r()), TuplesKt.to("setSpeakRuleBlockWord", new GuildsetSpeakRuleBlockWordMethod()), TuplesKt.to("openGuildBindGroupPage", new OpenGuildBindGroupPageMethod()), TuplesKt.to("getFontScaleRate", new GetFontScaleRateMethod()), TuplesKt.to("openGuildMsgNotifySetting", new x()), TuplesKt.to("hideLoadingView", new l()));
                Logger.f235387a.d().d("Guild.jump.JS.GuildJsBridgeMethodRegistry", 1, "loadMethods() costs " + (SystemClock.uptimeMillis() - uptimeMillis));
                return mapOf;
            }
        });
        methods = lazy;
    }

    GuildJsBridgeMethodRegistry() {
    }

    @JvmStatic
    @Nullable
    public static final g.a a(@NotNull String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return f235736a.b().get(methodName);
    }

    private final Map<String, g.a> b() {
        return (Map) methods.getValue();
    }
}
