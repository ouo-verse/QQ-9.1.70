package com.tencent.mobileqq.troop.teamup.member.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopPreviewMediaApi;
import com.tencent.mobileqq.troop.teamup.member.adapter.g;
import com.tencent.mobileqq.troop.teamup.member.vm.n;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpImage;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpMemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\n\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u001a\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00106R2\u0010K\u001a\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/fragment/TroopTeamUpMemberListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "data", "", "Gh", "", "Rh", "Mh", "initData", "com/tencent/mobileqq/troop/teamup/member/fragment/TroopTeamUpMemberListFragment$b", "Ch", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;)Lcom/tencent/mobileqq/troop/teamup/member/fragment/TroopTeamUpMemberListFragment$b;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/troop/teamup/member/data/c;", "Hh", "Kh", "Jh", "Lcom/tencent/mobileqq/troop/teamup/member/data/e;", "Lh", "Ih", "Qh", "initReport", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initView", "Oh", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/teamup/member/adapter/g;", "memberListAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "memberListRecyclerView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "E", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "operateBtn", "Landroidx/constraintlayout/widget/ConstraintLayout;", UserInfo.SEX_FEMALE, "Landroidx/constraintlayout/widget/ConstraintLayout;", "allMemberCheckLayout", "G", "operateLayout", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "allMemberCheckBox", "Lcom/tencent/mobileqq/troop/teamup/member/vm/n;", "I", "Lcom/tencent/mobileqq/troop/teamup/member/vm/n;", "viewModel", "J", "Z", "isSelectCreateTroopPage", "K", "isSelectCreateTroopParams", "L", "isSelectAll", "M", "memberSize", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpMemberInfo;", "Lkotlin/collections/ArrayList;", "N", "Ljava/util/ArrayList;", "getMemberInfoList", "()Ljava/util/ArrayList;", "Nh", "(Ljava/util/ArrayList;)V", "memberInfoList", "P", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detailData", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpMemberListFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private g memberListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView memberListRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUIButton operateBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private ConstraintLayout allMemberCheckLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private ConstraintLayout operateLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private QUICheckBox allMemberCheckBox;

    /* renamed from: I, reason: from kotlin metadata */
    private n viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isSelectCreateTroopPage;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isSelectCreateTroopParams;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: M, reason: from kotlin metadata */
    private int memberSize;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private ArrayList<TeamUpMemberInfo> memberInfoList;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TeamUpTeamDetail detailData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/fragment/TroopTeamUpMemberListFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detail", "", "isSelectCreate", "", "a", "", "TAG", "Ljava/lang/String;", "TEAM_UP_DETAIL_INFO", "TEAM_UP_IS_SELECT_CREATE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.member.fragment.TroopTeamUpMemberListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

        public final void a(@NotNull Context context, @NotNull TeamUpTeamDetail detail, boolean isSelectCreate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, detail, Boolean.valueOf(isSelectCreate));
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("team_up_detail_info", detail);
            bundle.putBoolean("team_up_is_select_create", isSelectCreate);
            intent.putExtras(bundle);
            QPublicFragmentActivity.start(context, intent, TroopTeamUpMemberListFragment.class);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/teamup/member/fragment/TroopTeamUpMemberListFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TeamUpTeamDetail f299068a;

        b(TeamUpTeamDetail teamUpTeamDetail) {
            this.f299068a = teamUpTeamDetail;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) teamUpTeamDetail);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(TeamUpTeamDetail.class).newInstance(this.f299068a);
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026       .newInstance(data)");
            return newInstance;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55990);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpMemberListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isSelectAll = true;
            this.memberInfoList = new ArrayList<>();
        }
    }

    private final b Ch(TeamUpTeamDetail data) {
        return new b(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(TroopTeamUpMemberListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isSelectCreateTroopPage) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                n nVar = this$0.viewModel;
                g gVar = null;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    nVar = null;
                }
                g gVar2 = this$0.memberListAdapter;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
                } else {
                    gVar = gVar2;
                }
                List<com.tencent.mobileqq.troop.teamup.member.data.b> currentList = gVar.getCurrentList();
                Intrinsics.checkNotNullExpressionValue(currentList, "memberListAdapter.currentList");
                nVar.A2(activity, currentList);
            }
            com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            h.a.f(aVar, view, "em_group_create", null, null, 12, null);
        } else {
            this$0.Rh();
            com.tencent.mobileqq.troop.teamup.report.a aVar2 = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            h.a.f(aVar2, view, "em_group_one_click_create", null, null, 12, null);
        }
        this$0.isSelectCreateTroopPage = true;
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean Gh(TeamUpTeamDetail data) {
        if (data.newGroupId == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(View view, com.tencent.mobileqq.troop.teamup.member.data.c data) {
        HashMap hashMapOf;
        n nVar = this.viewModel;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nVar = null;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        nVar.r2(context, data);
        if (this.detailData != null) {
            com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("touin", Long.valueOf(data.f())));
            h.a.f(aVar, view, "em_group_invite_btn", hashMapOf, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        n nVar = this.viewModel;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nVar = null;
        }
        nVar.v2(this.isSelectAll, this.isSelectCreateTroopPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(View view, com.tencent.mobileqq.troop.teamup.member.data.c data) {
        if (!data.n()) {
            return;
        }
        g gVar = this.memberListAdapter;
        QUICheckBox qUICheckBox = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
            gVar = null;
        }
        List<com.tencent.mobileqq.troop.teamup.member.data.b> currentList = gVar.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "memberListAdapter.currentList");
        boolean z16 = false;
        int i3 = 0;
        for (com.tencent.mobileqq.troop.teamup.member.data.b bVar : currentList) {
            if ((bVar instanceof com.tencent.mobileqq.troop.teamup.member.data.c) && ((com.tencent.mobileqq.troop.teamup.member.data.c) bVar).m()) {
                i3++;
            }
        }
        this.memberSize = i3;
        if (i3 == this.memberInfoList.size()) {
            z16 = true;
        }
        this.isSelectAll = z16;
        QUICheckBox qUICheckBox2 = this.allMemberCheckBox;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allMemberCheckBox");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setOnCheckedChangeListener(null);
        QUICheckBox qUICheckBox3 = this.allMemberCheckBox;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allMemberCheckBox");
        } else {
            qUICheckBox = qUICheckBox3;
        }
        qUICheckBox.setChecked(this.isSelectAll);
        Oh();
        Qh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(View view, com.tencent.mobileqq.troop.teamup.member.data.c data) {
        HashMap hashMapOf;
        int collectionSizeOrDefault;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ITroopPreviewMediaApi iTroopPreviewMediaApi = (ITroopPreviewMediaApi) QRoute.api(ITroopPreviewMediaApi.class);
            ArrayList<TeamUpImage> pictures = data.d().getPictures();
            Intrinsics.checkNotNullExpressionValue(pictures, "data.material.getPictures()");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(pictures, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = pictures.iterator();
            while (it.hasNext()) {
                arrayList.add(((TeamUpImage) it.next()).picUrl);
            }
            iTroopPreviewMediaApi.showPicture(activity, 0, new ArrayList<>(arrayList));
        }
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("touin", Long.valueOf(data.f())));
        h.a.f(aVar, view, "em_group_check_pic", hashMapOf, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(View view, com.tencent.mobileqq.troop.teamup.member.data.e data) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            n nVar = this.viewModel;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                nVar = null;
            }
            nVar.e2(activity, data);
        }
        h.a.f(com.tencent.mobileqq.troop.teamup.report.a.f299203a, view, "em_group_modify", null, null, 12, null);
    }

    private final void Mh() {
        if (this.isSelectCreateTroopParams) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        setTitle(getString(R.string.f235847cr));
        QUIButton qUIButton = this.operateBtn;
        ConstraintLayout constraintLayout = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
            qUIButton = null;
        }
        qUIButton.setText(getString(R.string.f235837cq));
        TeamUpTeamDetail teamUpTeamDetail = this.detailData;
        if (teamUpTeamDetail != null) {
            QUIButton qUIButton2 = this.operateBtn;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
                qUIButton2 = null;
            }
            qUIButton2.setEnabled(Gh(teamUpTeamDetail));
        }
        n nVar = this.viewModel;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nVar = null;
        }
        nVar.D2(false, false);
        resetLeftButton();
        this.isSelectCreateTroopPage = false;
        ConstraintLayout constraintLayout2 = this.allMemberCheckLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allMemberCheckLayout");
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TroopTeamUpMemberListFragment this$0, CompoundButton compoundButton, boolean z16) {
        int i3;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isSelectAll = z16;
        n nVar = this$0.viewModel;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nVar = null;
        }
        nVar.D2(this$0.isSelectAll, this$0.isSelectCreateTroopPage);
        if (this$0.isSelectAll) {
            i3 = this$0.memberInfoList.size();
        } else {
            i3 = 0;
        }
        this$0.memberSize = i3;
        this$0.Qh();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Qh() {
        boolean z16;
        String string;
        QUIButton qUIButton = this.operateBtn;
        QUIButton qUIButton2 = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
            qUIButton = null;
        }
        if (this.memberSize != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        qUIButton.setEnabled(z16);
        QUIButton qUIButton3 = this.operateBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
            qUIButton3 = null;
        }
        if (this.memberSize > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            QUIButton qUIButton4 = this.operateBtn;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
            } else {
                qUIButton2 = qUIButton4;
            }
            String string2 = qUIButton2.getContext().getString(R.string.f2327775g);
            Intrinsics.checkNotNullExpressionValue(string2, "operateBtn.context.getSt\u2026reate_for_troop_with_num)");
            string = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(this.memberSize)}, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        } else {
            string = getString(R.string.f236297dz);
        }
        qUIButton3.setText(string);
    }

    private final void Rh() {
        setTitle(getString(R.string.f236247du));
        setLeftButton(getResources().getString(R.string.f2059456z), new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpMemberListFragment.Sh(TroopTeamUpMemberListFragment.this, view);
            }
        });
        ConstraintLayout constraintLayout = this.allMemberCheckLayout;
        n nVar = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allMemberCheckLayout");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        QUICheckBox qUICheckBox = this.allMemberCheckBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allMemberCheckBox");
            qUICheckBox = null;
        }
        qUICheckBox.setChecked(true);
        this.isSelectAll = true;
        n nVar2 = this.viewModel;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            nVar = nVar2;
        }
        nVar.D2(true, true);
        Qh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(TroopTeamUpMemberListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        n nVar = this.viewModel;
        n nVar2 = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nVar = null;
        }
        nVar.v2(this.isSelectAll, this.isSelectCreateTroopPage);
        n nVar3 = this.viewModel;
        if (nVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nVar3 = null;
        }
        LiveData<ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b>> k26 = nVar3.k2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b>, Unit> function1 = new Function1<ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b>, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.TroopTeamUpMemberListFragment$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpMemberListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b> arrayList) {
                g gVar;
                g gVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                    return;
                }
                gVar = TroopTeamUpMemberListFragment.this.memberListAdapter;
                g gVar3 = null;
                if (gVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
                    gVar = null;
                }
                gVar.submitList(arrayList);
                gVar2 = TroopTeamUpMemberListFragment.this.memberListAdapter;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
                } else {
                    gVar3 = gVar2;
                }
                gVar3.notifyDataSetChanged();
            }
        };
        k26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpMemberListFragment.Dh(Function1.this, obj);
            }
        });
        n nVar4 = this.viewModel;
        if (nVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            nVar2 = nVar4;
        }
        LiveData<ArrayList<TeamUpMemberInfo>> l26 = nVar2.l2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<ArrayList<TeamUpMemberInfo>, Unit> function12 = new Function1<ArrayList<TeamUpMemberInfo>, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.TroopTeamUpMemberListFragment$initData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpMemberListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<TeamUpMemberInfo> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<TeamUpMemberInfo> it) {
                ConstraintLayout constraintLayout;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                constraintLayout = TroopTeamUpMemberListFragment.this.operateLayout;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("operateLayout");
                    constraintLayout = null;
                }
                Boolean valueOf = Boolean.valueOf(it.size() > 0);
                constraintLayout.setVisibility(0);
                if (((View) au.a(valueOf, constraintLayout)) == null) {
                    constraintLayout.setVisibility(8);
                }
                TroopTeamUpMemberListFragment troopTeamUpMemberListFragment = TroopTeamUpMemberListFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopTeamUpMemberListFragment.Nh(it);
                TroopTeamUpMemberListFragment.this.memberSize = it.size();
            }
        };
        l26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopTeamUpMemberListFragment.Eh(Function1.this, obj);
            }
        });
    }

    private final void initReport() {
        TeamUpTeamDetail teamUpTeamDetail;
        HashMap hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null || (teamUpTeamDetail = this.detailData) == null) {
            return;
        }
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", Long.valueOf(teamUpTeamDetail.groupId)), TuplesKt.to("teamup_id", teamUpTeamDetail.teamId), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, Integer.valueOf(teamUpTeamDetail.templateId)), TuplesKt.to("sub_group_id", Long.valueOf(teamUpTeamDetail.newGroupId)));
        h.a.d(aVar, activity, "pg_group_teamup_detail_host", hashMapOf, false, 8, null);
    }

    public final void Nh(@NotNull ArrayList<TeamUpMemberInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.memberInfoList = arrayList;
        }
    }

    public final void Oh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QUICheckBox qUICheckBox = this.allMemberCheckBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("allMemberCheckBox");
            qUICheckBox = null;
        }
        qUICheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TroopTeamUpMemberListFragment.Ph(TroopTeamUpMemberListFragment.this, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.i1g;
    }

    public final void initView() {
        Serializable serializable;
        TeamUpTeamDetail teamUpTeamDetail;
        Boolean bool;
        QUIButton qUIButton;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f1037561g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026roop_team_up_member_list)");
        this.memberListRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f1037861j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026roop_team_up_operate_btn)");
        this.operateBtn = (QUIButton) findViewById2;
        View findViewById3 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.slv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI\u2026.all_member_check_layout)");
        this.allMemberCheckLayout = (ConstraintLayout) findViewById3;
        View findViewById4 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f1038161m);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewByI\u2026p_team_up_operate_layout)");
        this.operateLayout = (ConstraintLayout) findViewById4;
        View findViewById5 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.slu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewByI\u2026.id.all_member_check_box)");
        this.allMemberCheckBox = (QUICheckBox) findViewById5;
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("team_up_detail_info");
        } else {
            serializable = null;
        }
        if (serializable instanceof TeamUpTeamDetail) {
            teamUpTeamDetail = (TeamUpTeamDetail) serializable;
        } else {
            teamUpTeamDetail = null;
        }
        this.detailData = teamUpTeamDetail;
        if (teamUpTeamDetail == null) {
            QLog.e("TroopTeamUpTroopTeamUpMemberListFragment", 1, "invalid troop team up detail is null.");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(teamUpTeamDetail);
        ViewModel viewModel = new ViewModelProvider(this, Ch(teamUpTeamDetail)).get(n.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     \u2026istViewModel::class.java)");
        this.viewModel = (n) viewModel;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool = Boolean.valueOf(arguments2.getBoolean("team_up_is_select_create"));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            Rh();
            this.isSelectCreateTroopPage = true;
            this.isSelectCreateTroopParams = true;
        } else {
            setTitle(getString(R.string.f235847cr));
        }
        QUIButton qUIButton2 = this.operateBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
            qUIButton2 = null;
        }
        TeamUpTeamDetail teamUpTeamDetail2 = this.detailData;
        Intrinsics.checkNotNull(teamUpTeamDetail2);
        qUIButton2.setEnabled(Gh(teamUpTeamDetail2));
        this.memberListAdapter = new g(new com.tencent.mobileqq.troop.teamup.member.adapter.a(new TroopTeamUpMemberListFragment$initView$1(this), new TroopTeamUpMemberListFragment$initView$2(this), new TroopTeamUpMemberListFragment$initView$3(this), new TroopTeamUpMemberListFragment$initView$4(this), new TroopTeamUpMemberListFragment$initView$5(this)));
        RecyclerView recyclerView = this.memberListRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView2 = this.memberListRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListRecyclerView");
            recyclerView2 = null;
        }
        g gVar = this.memberListAdapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
            gVar = null;
        }
        recyclerView2.setAdapter(gVar);
        QUIButton qUIButton3 = this.operateBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operateBtn");
            qUIButton = null;
        } else {
            qUIButton = qUIButton3;
        }
        TriggerRunnerKt.c(qUIButton, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpMemberListFragment.Fh(TroopTeamUpMemberListFragment.this, view);
            }
        }, 1, null);
        Oh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initReport();
    }
}
