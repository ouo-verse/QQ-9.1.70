package com.tencent.mobileqq.troop.troopfullmember.config;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0001DB9\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010#\u001a\u00020\u001b\u0012\u0006\u0010)\u001a\u00020$\u0012\b\u0010/\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0017\u0010\u0017\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u0004\u0018\u00010*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/config/d;", "Lcom/tencent/mobileqq/widget/listitem/v;", "Landroid/content/Context;", "context", "", "P", BdhLogUtil.LogTag.Tag_Req, "N", "Landroid/view/View;", "view", "", "eid", "O", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "Lcom/tencent/mobileqq/widget/listitem/Group$c;", "outMargin", "D", "l", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getTroopNick", AppConstants.Preferences.TROOP_NICK, "", DomainData.DOMAIN_NAME, "I", "getTroopMemberNum", "()I", "troopMemberNum", "o", "getTroopMemberMax", "troopMemberMax", "", "p", "Z", "getCanShare", "()Z", "canShare", "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "getMTroopShareUtility", "()Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "mTroopShareUtility", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "r", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "troopAvatar", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "troopInfoContainer", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "nickTextView", "u", "memberTextView", "Landroid/widget/ImageView;", "v", "Landroid/widget/ImageView;", "shareIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIZLcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;)V", "w", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopNick;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int troopMemberNum;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int troopMemberMax;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final boolean canShare;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ITroopShareUtility mTroopShareUtility;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView troopAvatar;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private View troopInfoContainer;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private TextView nickTextView;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private TextView memberTextView;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private ImageView shareIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/config/d$a;", "", "", "KEY_GROUP_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopfullmember.config.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57521);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String troopUin, @NotNull String troopNick, int i3, int i16, boolean z16, @Nullable ITroopShareUtility iTroopShareUtility) {
        super(R.layout.hz_);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopNick, "troopNick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, troopNick, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), iTroopShareUtility);
            return;
        }
        this.troopUin = troopUin;
        this.troopNick = troopNick;
        this.troopMemberNum = i3;
        this.troopMemberMax = i16;
        this.canShare = z16;
        this.mTroopShareUtility = iTroopShareUtility;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(d this$0, View this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        View view2 = this$0.troopInfoContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoContainer");
            view2 = null;
        }
        this$0.O(view2, "em_group_alternative_unit");
        Context context = this_apply.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this$0.N(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N(Context context) {
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(context, ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getTroopProfileExtra(this.troopUin, 0), 2);
    }

    private final void O(View view, String eid) {
        VideoReport.setElementId(view, eid);
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", this.troopUin);
        VideoReport.setElementParams(view, hashMap);
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    private final void P(final Context context) {
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100).a();
        QQProAvatarView qQProAvatarView = this.troopAvatar;
        QQProAvatarView qQProAvatarView2 = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView = null;
        }
        qQProAvatarView.x(4, this.troopUin, a16);
        if (this.canShare) {
            QQProAvatarView qQProAvatarView3 = this.troopAvatar;
            if (qQProAvatarView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            } else {
                qQProAvatarView2 = qQProAvatarView3;
            }
            qQProAvatarView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.config.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.Q(d.this, context, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(d this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        QQProAvatarView qQProAvatarView = this$0.troopAvatar;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView = null;
        }
        this$0.O(qQProAvatarView, "em_group_alternative_unit");
        this$0.N(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R() {
        final ImageView imageView = this.shareIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.config.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.S(d.this, imageView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(d this$0, ImageView this_apply, View it) {
        QBaseActivity qBaseActivity;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.O(it, "em_group_share_btn");
        if (this$0.mTroopShareUtility == null) {
            QLog.e("TroopDoubleLineConfig", 1, "err: mTroopShareUtility is null");
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
            TroopInfo findTroopInfo = ((ITroopInfoService) runtimeService).findTroopInfo(this$0.troopUin);
            TroopInfoData troopInfoData = new TroopInfoData();
            troopInfoData.updateForTroopInfo(findTroopInfo, peekAppRuntime.getCurrentAccountUin());
            troopInfoData.isMember = true;
            troopInfoData.userFrom = "pg_group_full_swap";
            boolean useNewSharePanel = ((ITroopShareApi) QRoute.api(ITroopShareApi.class)).useNewSharePanel("group_idcard");
            Context context = this_apply.getContext();
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
            } else {
                qBaseActivity = null;
            }
            if (useNewSharePanel && qBaseActivity != null) {
                TroopSettingShareManager.INSTANCE.a().F(new com.tencent.mobileqq.troop.troopsetting.share.b(qBaseActivity, troopInfoData), "group_idcard");
            } else {
                ITroopShareUtility iTroopShareUtility = this$0.mTroopShareUtility;
                Context context2 = this_apply.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                iTroopShareUtility.troopUtils_shareTroop((Activity) context2, troopInfoData, (AppInterface) peekAppRuntime);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void D(@NotNull View view, @NotNull Group.c outMargin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) outMargin);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outMargin, "outMargin");
        int left = outMargin.getLeft();
        QQProAvatarView qQProAvatarView = this.troopAvatar;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopAvatar");
            qQProAvatarView = null;
        }
        outMargin.c(left + qQProAvatarView.getLayoutParams().width + Utils.n(12.0f, view.getResources()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.v, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    public View H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        final View H = super.H(parent);
        H.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View findViewById = H.findViewById(R.id.f101245uo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this.findViewById(R.id.troop_avatar)");
        this.troopAvatar = (QQProAvatarView) findViewById;
        Context context = H.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        P(context);
        View findViewById2 = H.findViewById(R.id.jyz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "this.findViewById(R.id.troop_info_container)");
        this.troopInfoContainer = findViewById2;
        View findViewById3 = H.findViewById(R.id.f102955za);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "this.findViewById(R.id.troop_nick_name)");
        TextView textView = (TextView) findViewById3;
        this.nickTextView = textView;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTextView");
            textView = null;
        }
        textView.setText(this.troopNick);
        View findViewById4 = H.findViewById(R.id.k08);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "this.findViewById(R.id.troop_member_num)");
        this.memberTextView = (TextView) findViewById4;
        String str = this.troopMemberNum + "/" + this.troopMemberMax;
        TextView textView2 = this.memberTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberTextView");
            textView2 = null;
        }
        textView2.setText(str);
        View findViewById5 = H.findViewById(R.id.ir5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "this.findViewById(R.id.share_icon)");
        ImageView imageView = (ImageView) findViewById5;
        this.shareIcon = imageView;
        if (this.canShare) {
            R();
            View view2 = this.troopInfoContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopInfoContainer");
            } else {
                view = view2;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.config.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    d.M(d.this, H, view3);
                }
            });
        } else {
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareIcon");
            } else {
                view = imageView;
            }
            view.setVisibility(8);
        }
        return H;
    }
}
