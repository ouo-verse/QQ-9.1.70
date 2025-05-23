package com.tencent.mobileqq.troop.teamup.member.vm;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.teamup.member.event.TroopTeamUpUpdateEvent;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpMembersReq;
import com.tencent.qqnt.kernel.nativeinterface.GetTeamUpMembersRsp;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpMembersCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ITeamUpCreateGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpApplicationMaterial;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpCreateGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpCreateGroupRsp;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpInviteToGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpMemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpSubmitDeadlineReq;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u0001:\u0001MB\u000f\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bJ\u0010KJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J \u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J&\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u001a\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0002J(\u0010)\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J\u0016\u0010*\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010+\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010,\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010.\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020-J\u001c\u0010/\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102RD\u00108\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u001a 5*\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u00070\u0005j\b\u0012\u0004\u0012\u00020\u001a`\u0007048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107RD\u0010:\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u0006 5*\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00070\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R&\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0005j\b\u0012\u0004\u0012\u00020\u001a`\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR'\u0010H\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u0005j\b\u0012\u0004\u0012\u00020\u001a`\u00070E8F\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR'\u0010\b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070E8F\u00a2\u0006\u0006\u001a\u0004\bI\u0010G\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/vm/n;", "Landroidx/lifecycle/ViewModel;", "", "isSelectAll", "isSelectCreatePage", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpMemberInfo;", "Lkotlin/collections/ArrayList;", "memberInfoList", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "view", "", "type", "j2", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/teamup/member/data/e;", "data", "m2", SemanticAttributes.DbSystemValues.H2, "c2", "", "Lcom/tencent/mobileqq/troop/teamup/member/data/b;", "currentList", "memberNames", "x2", "groupId", "textMsg", "p2", "b2", "", "result", "errMsg", "z2", "Landroid/view/View$OnClickListener;", "cancelClick", "confirmClick", "d2", "v2", Constants.BASE_IN_PLUGIN_VERSION, "e2", "Lcom/tencent/mobileqq/troop/teamup/member/data/c;", "r2", NowProxyConstants.AccountInfoKey.A2, "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "detailData", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_allMemberList", BdhLogUtil.LogTag.Tag_Conn, "_memberInfoList", "D", "Ljava/util/ArrayList;", "allMemberDataList", "E", "Z", "isDeadline", "Landroid/app/Dialog;", UserInfo.SEX_FEMALE, "Landroid/app/Dialog;", "createTroopDialog", "Landroidx/lifecycle/LiveData;", "k2", "()Landroidx/lifecycle/LiveData;", "allMemberList", "l2", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;)V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class n extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<TeamUpMemberInfo>> _memberInfoList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b> allMemberDataList;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDeadline;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Dialog createTroopDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TeamUpTeamDetail detailData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b>> _allMemberList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/vm/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.member.vm.n$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56000);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n(@NotNull TeamUpTeamDetail detailData) {
        Intrinsics.checkNotNullParameter(detailData, "detailData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) detailData);
            return;
        }
        this.detailData = detailData;
        this._allMemberList = new MutableLiveData<>(new ArrayList());
        this._memberInfoList = new MutableLiveData<>(new ArrayList());
        this.allMemberDataList = new ArrayList<>();
        this.isDeadline = detailData.status == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(ActionSheet actionSheet, n this$0, Activity activity, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        actionSheet.dismiss();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.c2(activity, it, "cancel");
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(ActionSheet actionSheet, n this$0, Activity activity, List currentList, StringBuilder nameStringBuilder, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(currentList, "$currentList");
        Intrinsics.checkNotNullParameter(nameStringBuilder, "$nameStringBuilder");
        actionSheet.dismiss();
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(activity, "\u5efa\u7fa4\u4e2d", true);
        this$0.createTroopDialog = showLoadingDialog;
        if (showLoadingDialog != null) {
            showLoadingDialog.setCancelable(false);
        }
        Dialog dialog = this$0.createTroopDialog;
        if (dialog != null) {
            dialog.show();
        }
        String sb5 = nameStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "nameStringBuilder.toString()");
        this$0.x2(activity, currentList, sb5);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.c2(activity, it, MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void a2(boolean isSelectAll, boolean isSelectCreatePage, ArrayList<TeamUpMemberInfo> memberInfoList) {
        boolean z16;
        this.allMemberDataList = new ArrayList<>();
        String str = this.detailData.title;
        Intrinsics.checkNotNullExpressionValue(str, "detailData.title");
        boolean z17 = true;
        com.tencent.mobileqq.troop.teamup.member.data.e eVar = new com.tencent.mobileqq.troop.teamup.member.data.e(1, str, isSelectCreatePage);
        com.tencent.mobileqq.troop.teamup.member.data.d dVar = new com.tencent.mobileqq.troop.teamup.member.data.d(2, memberInfoList.size(), this.detailData.joinLimit);
        if (this.detailData.joinedCnt != memberInfoList.size()) {
            this.detailData.joinedCnt = memberInfoList.size();
            SimpleEventBus.getInstance().dispatchEvent(new TroopTeamUpUpdateEvent.UpdateJoinTeamUp(this.detailData));
        }
        this.allMemberDataList.add(eVar);
        this.allMemberDataList.add(dVar);
        if (memberInfoList.size() > 0) {
            int i3 = 0;
            for (Object obj : memberInfoList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TeamUpMemberInfo teamUpMemberInfo = (TeamUpMemberInfo) obj;
                String str2 = teamUpMemberInfo.nick;
                Intrinsics.checkNotNullExpressionValue(str2, "data.nick");
                long j3 = teamUpMemberInfo.uin;
                long j16 = teamUpMemberInfo.joinTime;
                int i17 = teamUpMemberInfo.joinGroupStatus;
                TeamUpApplicationMaterial teamUpApplicationMaterial = teamUpMemberInfo.material;
                Intrinsics.checkNotNullExpressionValue(teamUpApplicationMaterial, "data.material");
                TeamUpTeamDetail teamUpTeamDetail = this.detailData;
                if (i3 == memberInfoList.size() - 1) {
                    z16 = z17;
                } else {
                    z16 = false;
                }
                this.allMemberDataList.add(new com.tencent.mobileqq.troop.teamup.member.data.c(3, str2, j3, j16, i17, teamUpApplicationMaterial, teamUpTeamDetail, z16, isSelectAll, isSelectCreatePage));
                i3 = i16;
                z17 = true;
            }
        } else {
            this.allMemberDataList.add(new com.tencent.mobileqq.troop.teamup.member.data.a(4));
        }
        this._allMemberList.postValue(this.allMemberDataList);
    }

    private final void b2() {
        Dialog dialog = this.createTroopDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private final void c2(Activity activity, View view, String type) {
        HashMap<String, Object> hashMapOf;
        View view2;
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("click_type", type));
        Window window = activity.getWindow();
        if (window != null) {
            view2 = window.getDecorView();
        } else {
            view2 = null;
        }
        aVar.d(view, "em_group_popup", hashMapOf, view2);
    }

    private final View d2(Activity activity, String memberNames, View.OnClickListener cancelClick, View.OnClickListener confirmClick) {
        View view = LayoutInflater.from(activity).inflate(R.layout.i1e, (ViewGroup) null);
        TextView textView = (TextView) view.findViewById(R.id.f1037661h);
        TextView textView2 = (TextView) view.findViewById(R.id.f1037361e);
        textView.setText(this.detailData.title);
        textView2.setText(memberNames);
        ((QUIButton) view.findViewById(R.id.f1037961k)).setOnClickListener(cancelClick);
        ((QUIButton) view.findViewById(R.id.f1038061l)).setOnClickListener(confirmClick);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(n this$0, Activity activity, com.tencent.mobileqq.troop.teamup.member.data.e data, ActionSheet actionSheet, View clickedView, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        this$0.m2(activity, data);
        actionSheet.dismiss();
        Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
        this$0.j2(activity, clickedView, "act_end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(ActionSheet actionSheet, n this$0, Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        actionSheet.dismiss();
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.j2(activity, view, "cancel");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h2(final Context context, com.tencent.mobileqq.troop.teamup.member.data.e data) {
        TeamUpSubmitDeadlineReq teamUpSubmitDeadlineReq = new TeamUpSubmitDeadlineReq();
        teamUpSubmitDeadlineReq.teamId = this.detailData.teamId;
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.teamUpSubmitDeadline(teamUpSubmitDeadlineReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    n.i2(n.this, context, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(n this$0, Context context, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (com.tencent.qqnt.e.d(i3)) {
            this$0.isDeadline = true;
            QQToastUtil.showQQToastInUiThread(2, context.getString(R.string.f236497ei));
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str2 = this$0.detailData.teamId;
            Intrinsics.checkNotNullExpressionValue(str2, "detailData.teamId");
            simpleEventBus.dispatchEvent(new TroopTeamUpUpdateEvent.StopTimeTeamUp(str2));
            return;
        }
        QLog.e("TroopTeamUpTroopTeamUpMemberListViewModel", 1, "teamUpSubmitDeadline result" + i3 + " err: " + str);
        this$0.z2(i3, str);
    }

    private final void j2(Activity activity, View view, String type) {
        HashMap<String, Object> hashMapOf;
        View view2;
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("tab_name", type));
        Window window = activity.getWindow();
        if (window != null) {
            view2 = window.getDecorView();
        } else {
            view2 = null;
        }
        aVar.d(view, "em_group_tab", hashMapOf, view2);
    }

    private final void m2(final Context context, final com.tencent.mobileqq.troop.teamup.member.data.e data) {
        DialogUtil.createCustomDialog(context, 230, (String) null, context.getString(R.string.f236477eg), context.getString(R.string.f2059456z), context.getString(R.string.f2339978r), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n.n2(n.this, context, data, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n.o2(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(n this$0, Context context, com.tencent.mobileqq.troop.teamup.member.data.e data, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.h2(context, data);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void p2(final String groupId, String textMsg) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(groupId, 2, 1009L, 1, true, true, null);
        localGrayTipBuilder.g(textMsg, 1);
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(peekAppRuntime, localGrayTipBuilder.m(), new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
            public final void onResult(int i3, long j3) {
                n.q2(groupId, this, i3, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(String groupId, n this$0, int i3, long j3) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopTeamUpTroopTeamUpMemberListViewModel", 1, "addLocalGrayTip result: " + i3);
        ITroopCreateService iTroopCreateService = (ITroopCreateService) bg.m(ITroopCreateService.class, "");
        if (iTroopCreateService != null) {
            iTroopCreateService.jumpToAioAfterCreated(groupId, this$0.detailData.title, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(n this$0, final Context context, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (com.tencent.qqnt.e.d(i3)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.k
                @Override // java.lang.Runnable
                public final void run() {
                    n.t2(context);
                }
            });
            return;
        }
        QLog.e("TroopTeamUpTroopTeamUpMemberListViewModel", 1, "inviteTroop result" + i3 + " err: " + str);
        this$0.z2(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, context.getString(R.string.f236207dq), (String) null, context.getString(R.string.f2328575o), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n.u2(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026                        )");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(n this$0, boolean z16, boolean z17, int i3, String str, GetTeamUpMembersRsp getTeamUpMembersRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.qqnt.e.d(i3)) {
            this$0._memberInfoList.postValue(getTeamUpMembersRsp.memberInfoList);
            ArrayList<TeamUpMemberInfo> arrayList = getTeamUpMembersRsp.memberInfoList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.memberInfoList");
            this$0.a2(z16, z17, arrayList);
            return;
        }
        QLog.e("TroopTeamUpTroopTeamUpMemberListViewModel", 1, "getTeamUpMembers result" + i3 + " err: " + str);
        this$0.z2(i3, str);
        this$0.allMemberDataList = new ArrayList<>();
        this$0.allMemberDataList.add(new com.tencent.mobileqq.troop.teamup.member.data.a(5));
        this$0._allMemberList.postValue(this$0.allMemberDataList);
    }

    private final void x2(final Activity activity, List<? extends com.tencent.mobileqq.troop.teamup.member.data.b> currentList, final String memberNames) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (com.tencent.mobileqq.troop.teamup.member.data.b bVar : currentList) {
            if (bVar instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
                com.tencent.mobileqq.troop.teamup.member.data.c cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) bVar;
                if (cVar.m()) {
                    arrayList.add(Long.valueOf(cVar.f()));
                }
            }
        }
        TeamUpCreateGroupReq teamUpCreateGroupReq = new TeamUpCreateGroupReq();
        teamUpCreateGroupReq.participants = arrayList;
        teamUpCreateGroupReq.teamId = this.detailData.teamId;
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.teamUpCreateGroup(teamUpCreateGroupReq, new ITeamUpCreateGroupCallback() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.j
                @Override // com.tencent.qqnt.kernel.nativeinterface.ITeamUpCreateGroupCallback
                public final void onResult(int i16, String str, TeamUpCreateGroupRsp teamUpCreateGroupRsp) {
                    n.y2(n.this, activity, memberNames, i16, str, teamUpCreateGroupRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(n this$0, Activity activity, String memberNames, int i3, String str, TeamUpCreateGroupRsp teamUpCreateGroupRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(memberNames, "$memberNames");
        this$0.b2();
        if (com.tencent.qqnt.e.d(i3)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = activity.getResources().getString(R.string.f236197dp);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026roop_team_up_invite_name)");
            String format = String.format(string, Arrays.copyOf(new Object[]{memberNames}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            this$0.p2(String.valueOf(teamUpCreateGroupRsp.groupId), format);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str2 = this$0.detailData.teamId;
            Intrinsics.checkNotNullExpressionValue(str2, "detailData.teamId");
            simpleEventBus.dispatchEvent(new TroopTeamUpUpdateEvent.CreateTroopTeamUp(str2, teamUpCreateGroupRsp.groupId));
            return;
        }
        QLog.e("TroopTeamUpTroopTeamUpMemberListViewModel", 1, "requestCreateTroop result" + i3 + " err: " + str);
        this$0.z2(i3, str);
    }

    private final void z2(int result, String errMsg) {
        if (result != 1002 && result != 1003) {
            if (errMsg != null) {
                QQToastUtil.showQQToastInUiThread(1, errMsg);
                return;
            }
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f146290ts));
    }

    public final void A2(@NotNull final Activity activity, @NotNull final List<? extends com.tencent.mobileqq.troop.teamup.member.data.b> currentList) {
        View view;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) currentList);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(currentList, "currentList");
        Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        final StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (Object obj : currentList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.troop.teamup.member.data.b bVar = (com.tencent.mobileqq.troop.teamup.member.data.b) obj;
            if (bVar instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
                com.tencent.mobileqq.troop.teamup.member.data.c cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) bVar;
                if (cVar.m()) {
                    if (sb5.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        sb5.append("\uff0c");
                    }
                    sb5.append(cVar.e());
                }
            }
            i3 = i16;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "nameStringBuilder.toString()");
        actionSheet.setActionContentView(d2(activity, sb6, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.B2(ActionSheet.this, this, activity, view2);
            }
        }, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.C2(ActionSheet.this, this, activity, currentList, sb5, view2);
            }
        }), null);
        actionSheet.show();
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        ViewGroup rootView = actionSheet.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "actionSheet.rootView");
        Window window = activity.getWindow();
        if (window != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        aVar.c(rootView, "em_group_popup", null, view);
    }

    public final void D2(boolean isSelectAll, boolean isSelectCreatePage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isSelectAll), Boolean.valueOf(isSelectCreatePage));
            return;
        }
        ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b> arrayList = new ArrayList<>();
        for (com.tencent.mobileqq.troop.teamup.member.data.b bVar : this.allMemberDataList) {
            if (bVar instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
                com.tencent.mobileqq.troop.teamup.member.data.c cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) bVar;
                cVar.o(isSelectAll);
                cVar.p(isSelectCreatePage);
                arrayList.add(bVar);
            } else if (bVar instanceof com.tencent.mobileqq.troop.teamup.member.data.e) {
                ((com.tencent.mobileqq.troop.teamup.member.data.e) bVar).d(isSelectCreatePage);
                arrayList.add(bVar);
            } else {
                arrayList.add(bVar);
            }
        }
        this._allMemberList.setValue(arrayList);
    }

    public final void e2(@NotNull final Activity activity, @NotNull final com.tencent.mobileqq.troop.teamup.member.data.e data) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        View view = null;
        Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f236507ej);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                n.f2(n.this, activity, data, actionSheet, view2, i3);
            }
        });
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n.g2(ActionSheet.this, this, activity, view2);
            }
        });
        actionSheet.show();
        if (this.isDeadline) {
            ActionSheet.ItemViewHolder itemViewById = actionSheet.getItemViewById(0);
            if (itemViewById != null && (textView = itemViewById.titleTv) != null) {
                textView.setTextColor(ContextCompat.getColorStateList(activity, R.color.qui_common_text_tertiary));
            }
            LinearLayout linearLayout = actionSheet.mContentContainer;
            if (linearLayout != null) {
                view = linearLayout.findViewById(0);
            }
            if (view != null) {
                view.setBackgroundResource(R.drawable.f160041q);
            }
            if (view != null) {
                view.setClickable(false);
            }
            if (view != null) {
                view.setEnabled(false);
            }
        }
    }

    @NotNull
    public final LiveData<ArrayList<com.tencent.mobileqq.troop.teamup.member.data.b>> k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this._allMemberList;
    }

    @NotNull
    public final LiveData<ArrayList<TeamUpMemberInfo>> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this._memberInfoList;
    }

    public final void r2(@NotNull final Context context, @NotNull com.tencent.mobileqq.troop.teamup.member.data.c data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(data.f()));
        TeamUpInviteToGroupReq teamUpInviteToGroupReq = new TeamUpInviteToGroupReq();
        teamUpInviteToGroupReq.teamId = this.detailData.teamId;
        teamUpInviteToGroupReq.participantList = arrayList;
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.teamUpInviteToGroup(teamUpInviteToGroupReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str) {
                    n.s2(n.this, context, i16, str);
                }
            });
        }
    }

    public final void v2(final boolean isSelectAll, final boolean isSelectCreatePage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSelectAll), Boolean.valueOf(isSelectCreatePage));
            return;
        }
        GetTeamUpMembersReq getTeamUpMembersReq = new GetTeamUpMembersReq();
        getTeamUpMembersReq.teamId = this.detailData.teamId;
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.getTeamUpMembers(getTeamUpMembersReq, new IGetTeamUpMembersCallback() { // from class: com.tencent.mobileqq.troop.teamup.member.vm.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTeamUpMembersCallback
                public final void onResult(int i16, String str, GetTeamUpMembersRsp getTeamUpMembersRsp) {
                    n.w2(n.this, isSelectAll, isSelectCreatePage, i16, str, getTeamUpMembersRsp);
                }
            });
        }
    }
}
