package com.tencent.mobileqq.guild.safety;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001-\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u00102\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0004J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\b\u0010\u001a\u001a\u00020\u0002H\u0004J\u0016\u0010\u001e\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0004J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004R\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/safety/i;", "Lcom/tencent/mobileqq/guild/mainframe/k;", "", "u", "Landroid/content/Context;", "context", "", "guildId", "k", DomainData.DOMAIN_NAME, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "r", "", "l", "Lcom/tencent/mobileqq/guild/safety/a;", "banInfo", "t", "tabChange", "onResume", "tabChanged", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "Landroidx/fragment/app/Fragment;", "fragments", "p", ReportConstant.COSTREPORT_PREFIX, "e", "Z", "needToJumpTab", "f", "registered", tl.h.F, "inGuildTab", "i", "Lcom/tencent/mobileqq/guild/safety/a;", "", "Lcom/tencent/mobileqq/guild/safety/g;", "Ljava/util/List;", "closeActions", "com/tencent/mobileqq/guild/safety/i$a", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/safety/i$a;", "banObserver", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class i extends k {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a banObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needToJumpTab;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean registered;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean inGuildTab;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.safety.a banInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> closeActions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/safety/i$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", AppConstants.Key.COLUMN_IS_VALID, "isBanned", "isFrozen", "", "guildBannedTimeLimit", "", "onBannedStatusChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onBannedStatusChanged(@Nullable String guildId, boolean isValid, boolean isBanned, boolean isFrozen, long guildBannedTimeLimit) {
            j.d("GuildBanHelper", "onBannedStatusChanged | guildId: " + guildId + " | isValid: " + isValid + " | isBanned: " + isBanned + "| isFrozen: " + isFrozen + "| guildBannedTimeLimit: " + guildBannedTimeLimit);
            if (guildId == null) {
                return;
            }
            com.tencent.mobileqq.guild.safety.a aVar = new com.tencent.mobileqq.guild.safety.a(guildId, isBanned, guildBannedTimeLimit * 1000);
            i iVar = i.this;
            iVar.banInfo = aVar;
            iVar.t(aVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/safety/i$b", "Lcom/tencent/mobileqq/guild/safety/g;", "", "guildId", "", "close", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements g {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.safety.g
        public void close(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), guildId)) {
                com.tencent.mobileqq.guild.media.core.j.a().D("", "GuildBanCloseAction, call close fun.");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/safety/i$c", "Lcom/tencent/mobileqq/guild/safety/g;", "", "guildId", "", "close", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements g {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.safety.g
        public void close(@NotNull String guildId) {
            String str;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            IGProGuildInfo value = gLiveChannelCore.t().k().getValue();
            if (value != null) {
                str = value.getGuildID();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                GLiveChannelCore.f(gLiveChannelCore, "GuildBanCloseAction, call close fun.", false, null, 4, null);
            }
        }
    }

    public i(@Nullable com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        arrayList.add(new c());
        this.closeActions = arrayList;
        this.banObserver = new a();
    }

    private final void j() {
        j.d("GuildBanHelper", "backToGuildTab");
        if (QBaseActivity.sTopActivity == null) {
            return;
        }
        String q16 = q();
        this.f227466d.h(r(), q(), null);
        LaunchGuildChatPieParam b16 = new LaunchGuildChatPieParam().l(q16).b("none");
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", q16);
        LaunchGuildChatPieParam a16 = b16.k(bundle).o(2).a();
        QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
        Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
        GuildMainFrameUtils.r(sTopActivity, 0, a16);
        n();
    }

    private final void k(Context context, String guildId) {
        j.b("GuildBanHelper", "backToGuildTab | guildId: " + guildId + " , selectedGuild: " + q());
        if (l(guildId)) {
            j.d("GuildBanHelper", "showBanDialog");
            this.needToJumpTab = true;
            m(guildId);
            n();
            o();
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoGuildTab(context, 0, null);
        }
    }

    private final boolean l(String guildId) {
        if (this.inGuildTab && s(guildId)) {
            return true;
        }
        return false;
    }

    private final void n() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            List<Fragment> fragments = qBaseActivity.getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "sTopActivity.supportFragmentManager.fragments");
            p(fragments);
        }
    }

    private final String q() {
        return com.tencent.mobileqq.guild.mainframe.helper.d.f().b().f227429b;
    }

    private final int r() {
        return com.tencent.mobileqq.guild.mainframe.helper.d.f().b().f227428a;
    }

    private final void u() {
        if (this.needToJumpTab) {
            j.b("GuildBanHelper", "onMainFragResume");
            this.needToJumpTab = false;
            j();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean tabChanged) {
        super.a(tabChanged);
        j.d("GuildBanHelper", "onPause | tabChanged: " + tabChanged);
        if (tabChanged) {
            this.inGuildTab = false;
        }
    }

    protected final void m(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Iterator<T> it = this.closeActions.iterator();
        while (it.hasNext()) {
            ((g) it.next()).close(guildId);
        }
    }

    protected final void o() {
        WeakReference weakReference;
        ShareActionSheet shareActionSheet;
        weakReference = j.f233052a;
        if (weakReference != null && (shareActionSheet = (ShareActionSheet) weakReference.get()) != null) {
            shareActionSheet.dismissImmediately();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        this.needToJumpTab = false;
        this.registered = false;
        this.banInfo = null;
        ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).deleteObserver(this.banObserver);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean tabChange) {
        super.onResume(tabChange);
        j.d("GuildBanHelper", "onResume | tabChanged: " + tabChange);
        this.inGuildTab = true;
        v();
        u();
    }

    protected final void p(@NotNull List<? extends Fragment> fragments) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        for (Fragment fragment : fragments) {
            if (fragment instanceof DialogFragment) {
                ((DialogFragment) fragment).dismissAllowingStateLoss();
            } else if (fragment.getChildFragmentManager().getFragments().size() > 0) {
                List<Fragment> fragments2 = fragment.getChildFragmentManager().getFragments();
                Intrinsics.checkNotNullExpressionValue(fragments2, "fragment.childFragmentManager.fragments");
                p(fragments2);
            }
        }
    }

    protected final boolean s(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        com.tencent.mobileqq.guild.mainframe.helper.d f16 = com.tencent.mobileqq.guild.mainframe.helper.d.f();
        if (f16.b().a() && Intrinsics.areEqual(f16.b().f227429b, guildId)) {
            return true;
        }
        return false;
    }

    protected void t(@NotNull com.tencent.mobileqq.guild.safety.a banInfo) {
        Intrinsics.checkNotNullParameter(banInfo, "banInfo");
        String guildId = banInfo.f233036a;
        if (banInfo.f233037b) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
            k(qBaseActivity, guildId);
        } else if (Intrinsics.areEqual(guildId, q())) {
            j();
        }
    }

    protected final void v() {
        if (!this.registered) {
            try {
                ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).addObserver(this.banObserver);
                this.registered = true;
                j.d("GuildBanHelper", "registerBanPush");
            } catch (IllegalStateException e16) {
                QLog.e("GuildBanHelper", 1, "registerBanPush error with IGPSService:" + e16);
            }
        }
    }
}
