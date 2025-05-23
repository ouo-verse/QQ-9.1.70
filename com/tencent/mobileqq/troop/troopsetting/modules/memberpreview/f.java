package com.tencent.mobileqq.troop.troopsetting.modules.memberpreview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.QQToastUtil;
import h44.OpenRobotProfileCardArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB\u001f\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u0010G\u001a\u00020\u001a\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0010j\b\u0012\u0004\u0012\u00020\u0005`\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0016\u0010\u001e\u001a\u00020\u00072\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nJ\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\"\u0010=\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u00010\u001c0\u001c098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010CR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/memberpreview/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/memberpreview/TroopMemberPreviewVH;", "", "position", "", "o0", "", "y0", "C0", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "B0", "", "isOwnerOrAdmin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "s0", "memberUin", "z0", "Landroid/view/View;", "view", "A0", "n0", "Landroid/app/Activity;", "getActivity", "", "memberUinList", "F0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "p1", "x0", "viewHolder", "t0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "viewModel", "D", "I", "configMaxCount", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "E", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "activityRef", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/AsyncListDiffer;", "diff", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "q0", "()Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "r0", "()Ljava/lang/String;", "troopUin", "p0", "()Ljava/util/List;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;Landroid/app/Activity;)V", "G", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends RecyclerView.Adapter<TroopMemberPreviewVH> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TroopSettingViewModel viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final int configMaxCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.refresh.c<Activity> activityRef;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer<Long> diff;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/memberpreview/f$a;", "", "", "ADD_ENTRANCE_TAG", "J", "", "FROM_TROOP_MINUS_BUTTON", "I", "REMOVE_ENTRANCE_TAG", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.f$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/memberpreview/f$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "p0", "p1", "", "b", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    private static final class b extends DiffUtil.ItemCallback<Long> {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public boolean a(long p06, long p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Long.valueOf(p06), Long.valueOf(p16))).booleanValue();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areContentsTheSame(Long l3, Long l16) {
            return a(l3.longValue(), l16.longValue());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areItemsTheSame(Long l3, Long l16) {
            return b(l3.longValue(), l16.longValue());
        }

        public boolean b(long p06, long p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(p06), Long.valueOf(p16))).booleanValue();
            }
            if (p06 == p16) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60255);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull Context context, @NotNull TroopSettingViewModel viewModel, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, viewModel, activity);
            return;
        }
        this.context = context;
        this.viewModel = viewModel;
        this.configMaxCount = com.tencent.mobileqq.troop.troopsetting.vm.a.f301534a.b();
        this.activityRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(activity);
        this.diff = new AsyncListDiffer<>(this, new b());
    }

    private final void A0(View view) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).startSelectTroopMemberFragment(activity, true, 3, r0(), 9);
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
        VideoReport.reportEvent("dt_clck", view, null);
    }

    private final void B0(List<? extends TroopMemberInfo> troopMemberList) {
        if (troopMemberList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TroopMemberInfo troopMemberInfo : troopMemberList) {
            if (Utils.M(troopMemberInfo.memberuin)) {
                String str = troopMemberInfo.memberuin;
                Intrinsics.checkNotNullExpressionValue(str, "tmi.memberuin");
                arrayList.add(str);
            }
        }
        CopyOnWriteArrayList<String> L2 = this.viewModel.L2();
        if (L2 != null) {
            for (String uin : L2) {
                if (!arrayList.contains(uin)) {
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    arrayList.add(uin);
                }
            }
        }
        s0(q0().isOwnerOrAdim(), bg.f302144a.n(arrayList));
        AppInterface e16 = bg.e();
        if (e16 == null) {
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.report.c.f301449a.j(e16, q0(), "Grp", "Clk_invite_new", "0");
        ReportController.o(e16, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_clk", 0, 0, "", "", "", "");
    }

    private final void C0() {
        QBaseActivity qBaseActivity;
        boolean z16;
        Activity activity = getActivity();
        String str = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null || !q0().canInviteMember()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences sharedPreferences = qBaseActivity.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + str, 4);
        long j3 = sharedPreferences.getLong("key_last_update_time" + r0(), 0L);
        if (QLog.isColorLevel()) {
            QLog.i("TroopMemberPreviewAdapter", 2, "[startInviteJoinTroop] lastUpdateTime:" + j3);
        }
        if (j3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(r0(), qBaseActivity, z16, "TroopMemberPreviewAdapter", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.d
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                f.D0(f.this, z17, list);
            }
        });
        if (z16) {
            sharedPreferences.edit().putLong("key_last_update_time" + r0(), System.currentTimeMillis()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(final f this$0, boolean z16, final List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.e
            @Override // java.lang.Runnable
            public final void run() {
                f.E0(f.this, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(f this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(list);
    }

    private final Activity getActivity() {
        return this.activityRef.get();
    }

    private final boolean n0() {
        boolean z16;
        boolean z17;
        if (TroopInfo.hasPayPrivilege(q0().mTroopPrivilegeFlag, 128) && TroopInfo.hasPayPrivilege(q0().mTroopPrivilegeFlag, 512)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (q0().mMemberInvitingFlag && (q0().cGroupOption != 3 || z16)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (q0().isOwnerOrAdim() || !z17) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberPreviewAdapter", 2, "[refreshInviteBtnVisibility]: mMemberInvitingFlag= " + q0().mMemberInvitingFlag + ", isOwnerOrAdmin = " + q0().isOwnerOrAdim() + ", cGroupOption = " + ((int) q0().cGroupOption) + ", isPayToJoinTroop=" + z16);
        }
        return false;
    }

    private final String o0(int position) {
        boolean z16 = false;
        if (position >= 0 && position < p0().size()) {
            z16 = true;
        }
        if (z16) {
            return String.valueOf(p0().get(position).longValue());
        }
        return "";
    }

    private final List<Long> p0() {
        List<Long> currentList = this.diff.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "diff.currentList");
        return currentList;
    }

    private final TroopInfoData q0() {
        return this.viewModel.T2();
    }

    private final String r0() {
        String str = q0().troopUin;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void s0(boolean isOwnerOrAdmin, ArrayList<String> uinList) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.getIntent().putExtra(ISelectMemberActivityConstants.PARAM_WITH_HISTORY, true);
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).inviteMember(activity, r0(), isOwnerOrAdmin, uinList, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.A0(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(f this$0, String memberUin, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        this$0.z0(memberUin);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y0() {
        if (this.viewModel.S2().getMemberNum() >= this.viewModel.S2().wMemberMax) {
            QQToastUtil.showQQToastInUiThread(0, "\u7fa4\u4eba\u6570\u5df2\u8fbe\u7fa4\u89c4\u6a21\u4e0a\u9650");
        } else {
            C0();
            eu.g("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, r0(), eu.c(q0()));
        }
    }

    private final void z0(String memberUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        if (((ITroopRobotService) runtimeService).isRobotUin(memberUin)) {
            ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(this.context, memberUin, r0(), 8, 0, null));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, this.context.getString(R.string.i7y));
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopmemberCard(peekAppRuntime, this.context, r0(), memberUin, 10, 9, bundle);
        }
    }

    public final void F0(@Nullable List<Long> memberUinList) {
        List<Long> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) memberUinList);
            return;
        }
        int i3 = this.configMaxCount;
        ArrayList arrayList2 = new ArrayList();
        if (n0()) {
            arrayList2.add(-1L);
            i3--;
        }
        if (q0().isOwnerOrAdim()) {
            arrayList2.add(-2L);
            i3--;
        }
        List<Long> arrayList3 = new ArrayList<>();
        if (memberUinList != null) {
            arrayList = memberUinList;
        } else {
            arrayList = new ArrayList<>();
        }
        arrayList3.addAll(arrayList);
        if (arrayList3.size() > i3) {
            arrayList3 = arrayList3.subList(0, i3);
        }
        arrayList3.addAll(arrayList2);
        this.diff.submitList(arrayList3);
        g.f301186a.a("TroopMemberPreviewAdapter", arrayList3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return p0().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull TroopMemberPreviewVH viewHolder, int position) {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        boolean areEqual = Intrinsics.areEqual(o0(position), "-1");
        boolean areEqual2 = Intrinsics.areEqual(o0(position), "-2");
        viewHolder.t(position, 5);
        if (areEqual2) {
            viewHolder.r(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.u0(f.this, view);
                }
            });
            return;
        }
        if (areEqual) {
            viewHolder.p(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.v0(f.this, view);
                }
            });
            return;
        }
        if (position < p0().size()) {
            final String o06 = o0(position);
            Activity activity = getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            viewHolder.q(o06, r0(), qBaseActivity, this.viewModel, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.w0(f.this, o06, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public TroopMemberPreviewVH onCreateViewHolder(@NotNull ViewGroup parent, int p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMemberPreviewVH) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, p16);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.foj, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026mber_item, parent, false)");
        return new TroopMemberPreviewVH(inflate);
    }
}
