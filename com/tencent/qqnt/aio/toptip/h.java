package com.tencent.qqnt.aio.toptip;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J'\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u00138\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010!8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\u00020\u00138\u0016X\u0096D\u00a2\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/h;", "Lcom/tencent/qqnt/aio/toptips/a;", "Landroid/view/View$OnClickListener;", "", "p", "", "r", "o", "", "event", DomainData.DOMAIN_NAME, "", "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "", "eventType", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", "v", NodeProps.ON_CLICK, "d", "Lcom/tencent/qqnt/aio/toptips/c;", "mManager", "e", "I", "j", "()I", "barPriority", "", "f", "[I", "b", "()[I", "excludeTypes", tl.h.F, "getType", "type", "<init>", "()V", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class h extends com.tencent.qqnt.aio.toptips.a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.toptips.c mManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int barPriority;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final int[] excludeTypes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/h$a;", "", "", "DEF_RADIUS", UserInfo.SEX_FEMALE, "", "ILLEGAL_CLASS_ID", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.toptip.h$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63855);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.barPriority = 15;
            this.type = 113;
        }
    }

    private final void n(String event) {
        HashMap hashMap = new HashMap();
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        Intrinsics.checkNotNull(cVar);
        hashMap.put("group_id", cVar.a().g().r().c().j());
        hashMap.put("grp_small_horizontal_banner_url", ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getTroopJoinGuildBean_JumpUrl());
        VideoReport.reportEvent(event, hashMap);
    }

    private final void o() {
        boolean z16;
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        if (cVar == null) {
            return;
        }
        Intrinsics.checkNotNull(cVar);
        if (cVar.b() == getType()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.qqnt.aio.toptips.c cVar2 = this.mManager;
            Intrinsics.checkNotNull(cVar2);
            cVar2.h(this);
        }
    }

    private final boolean p() {
        long j3;
        boolean z16;
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return false;
        }
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        Intrinsics.checkNotNull(cVar);
        String j16 = cVar.a().g().r().c().j();
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(ITroopInfoService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026pInfoService::class.java)");
        TroopInfo troopInfo = ((ITroopInfoService) runtimeService).getTroopInfo(j16);
        com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(String.valueOf(troopInfo.dwGroupClassExt));
        if (c16 == null || TextUtils.isEmpty(c16.f299961c)) {
            return false;
        }
        try {
            String str = c16.f299961c;
            Intrinsics.checkNotNullExpressionValue(str, "catalogBean.id");
            long parseLong = Long.parseLong(str);
            com.tencent.mobileqq.troop.troopcatalog.a aVar = c16.f299963e;
            if (aVar != null) {
                String str2 = aVar.f299961c;
                Intrinsics.checkNotNullExpressionValue(str2, "catalogBean.parentBean.id");
                j3 = Long.parseLong(str2);
            } else {
                j3 = Long.MIN_VALUE;
            }
            Set<Long> troopJoinGuildBean_AllowShowClassSet = ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getTroopJoinGuildBean_AllowShowClassSet();
            Intrinsics.checkNotNullExpressionValue(troopJoinGuildBean_AllowShowClassSet, "api(IGuildConfigApi::cla\u2026dBean_AllowShowClassSet()");
            int showTroopJoinGuildTipsTimes = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getShowTroopJoinGuildTipsTimes();
            if (showTroopJoinGuildTipsTimes >= ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getTroopJoinGuildBean_ShowMaxTimes()) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean showTroopJoinGuildTipsHasClose = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getShowTroopJoinGuildTipsHasClose();
            boolean isOwnerOrAdmin = troopInfo.isOwnerOrAdmin();
            QLog.i("TroopJoinGuildTipsBar", 1, "needShowTipSync currId: " + parseLong + ", parentId: " + j3 + ", showTimes: " + showTroopJoinGuildTipsTimes + ", hasShownMaxSize: " + z16 + ", hasClose: " + showTroopJoinGuildTipsHasClose + ", isAdmin: " + isOwnerOrAdmin);
            if (!showTroopJoinGuildTipsHasClose && !z16 && ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getTroopJoinGuildBean_Switch() && isOwnerOrAdmin && ((parseLong != Long.MIN_VALUE && troopJoinGuildBean_AllowShowClassSet.contains(Long.valueOf(parseLong))) || (j3 != Long.MIN_VALUE && troopJoinGuildBean_AllowShowClassSet.contains(Long.valueOf(j3))))) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            QLog.i("TroopJoinGuildTipsBar", 1, "NumberFormatException classExt" + troopInfo.dwGroupClassExt);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.p()) {
            this$0.r();
        }
    }

    private final void r() {
        boolean z16;
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        if (cVar == null) {
            return;
        }
        Intrinsics.checkNotNull(cVar);
        if (cVar.b() == getType()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            com.tencent.qqnt.aio.toptips.c cVar2 = this.mManager;
            Intrinsics.checkNotNull(cVar2);
            cVar2.e(this);
            n("ev_grp_small_horizontal_banner_view");
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).addShowTroopJoinGuildTipsTimes();
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @NotNull
    public View a(@NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        Intrinsics.checkNotNull(cVar);
        View inflate = LayoutInflater.from(cVar.a().c().getContext()).inflate(R.layout.f_8, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(co\u2026op_join_guild_tips, null)");
        ((TextView) inflate.findViewById(R.id.f102345xn)).setText(((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getTroopJoinGuildBean_TipStr());
        ((RoundRectImageView) inflate.findViewById(R.id.f102335xm)).setCornerRadiusAndMode(ViewUtils.dip2px(5.0f), 1);
        inflate.findViewById(R.id.f102325xl).setOnClickListener(this);
        inflate.setOnClickListener(this);
        return inflate;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.excludeTypes;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NotNull com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType, @NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, topTipsManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(topTipsManager, "topTipsManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (topTipsManager.a().g().r().c().e() != 2) {
            return;
        }
        this.mManager = topTipsManager;
        if (eventType == 1005) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.toptip.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.q(h.this);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.type;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.barPriority;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.f102325xl) {
                o();
                ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setShowTroopJoinGuildTipsHasClose();
            } else {
                com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
                Intrinsics.checkNotNull(cVar);
                Context requireContext = cVar.a().c().requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "mManager!!.getAioContext\u2026fragment.requireContext()");
                n("ev_grp_small_horizontal_banner_clk");
                Intent intent = new Intent(requireContext, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getTroopJoinGuildBean_JumpUrl());
                requireContext.startActivity(intent);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
