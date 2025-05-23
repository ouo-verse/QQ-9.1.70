package com.tencent.mobileqq.troop.troopsetting.modules.memberpreview;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J0\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/memberpreview/TroopMemberPreviewVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "memberMark", "memberUin", "", "isQiDianPrivateTroop", "", "u", ReportConstant.COSTREPORT_PREFIX, "o", "troopUin", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "viewModel", "Landroid/view/View$OnClickListener;", "onclickListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "r", "", "position", "gridColumnCount", "t", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "infoCardContainer", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatar", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "nameTv", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMemberPreviewVH extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout infoCardContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QQProAvatarView avatar;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView nameTv;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/memberpreview/TroopMemberPreviewVH$a;", "", "", "ITEM_HEIGHT", UserInfo.SEX_FEMALE, "ITEM_MARGIN_BOTTOM", "ITEM_WIDTH", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.TroopMemberPreviewVH$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopMemberPreviewVH(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.z1y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.member_info_card)");
        this.infoCardContainer = (RelativeLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon)");
        this.avatar = (QQProAvatarView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f5e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.name)");
        this.nameTv = (TextView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        String str;
        Object tag = this.itemView.getTag(R.id.jay);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void s(String memberUin) {
        this.itemView.setTag(R.id.jay, memberUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String memberMark, String memberUin, boolean isQiDianPrivateTroop) {
        AppInterface appInterface;
        Context context = this.itemView.getContext();
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(memberMark)) {
            memberMark = memberUin;
        }
        if (isQiDianPrivateTroop && TextUtils.isDigitsOnly(memberMark)) {
            memberMark = context.getString(R.string.kho);
        }
        SpannableString spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(memberMark, 12);
        if (!Intrinsics.areEqual(spannableStringFromColorNickText.toString(), this.nameTv.getText().toString())) {
            this.nameTv.setText(spannableStringFromColorNickText);
            this.itemView.setContentDescription(new QQText(spannableStringFromColorNickText.toString(), 16, 16).toPlainText());
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).setColorText(appInterface, this.nameTv, spannableStringFromColorNickText);
        }
    }

    public final void p(@NotNull View.OnClickListener onclickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) onclickListener);
            return;
        }
        Intrinsics.checkNotNullParameter(onclickListener, "onclickListener");
        s("");
        Context context = this.itemView.getContext();
        if (context == null) {
            return;
        }
        this.nameTv.setText(context.getString(R.string.bzl));
        this.avatar.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.lwq, null));
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        TriggerRunnerKt.b(itemView, 800L, onclickListener);
        View view = this.itemView;
        CharSequence text = this.nameTv.getText();
        view.setContentDescription(((Object) text) + context.getString(R.string.f170645x8));
        com.tencent.mobileqq.troop.troopsetting.modules.base.ui.b.a(this.avatar);
    }

    public final void q(@NotNull final String memberUin, @NotNull String troopUin, @Nullable QBaseActivity activity, @NotNull final TroopSettingViewModel viewModel, @NotNull View.OnClickListener onclickListener) {
        boolean z16;
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, memberUin, troopUin, activity, viewModel, onclickListener);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onclickListener, "onclickListener");
        if (memberUin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.nameTv.setText("");
            this.avatar.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
            return;
        }
        s(memberUin);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberName(troopUin, memberUin, activity, "TroopMemberPreviewVH", new Function1<TroopMemberNickInfo, Unit>(memberUin, this, viewModel) { // from class: com.tencent.mobileqq.troop.troopsetting.modules.memberpreview.TroopMemberPreviewVH$setMemberCard$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $memberUin;
            final /* synthetic */ TroopSettingViewModel $viewModel;
            final /* synthetic */ TroopMemberPreviewVH this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$memberUin = memberUin;
                this.this$0 = this;
                this.$viewModel = viewModel;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, memberUin, this, viewModel);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopMemberNickInfo troopMemberNickInfo) {
                invoke2(troopMemberNickInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable TroopMemberNickInfo troopMemberNickInfo) {
                String o16;
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopMemberNickInfo);
                    return;
                }
                String str2 = this.$memberUin;
                o16 = this.this$0.o();
                if (Intrinsics.areEqual(str2, o16)) {
                    if (troopMemberNickInfo == null || (str = troopMemberNickInfo.getShowName(true, true)) == null) {
                        str = this.$memberUin;
                    }
                    if (Intrinsics.areEqual(str, this.$memberUin)) {
                        str = this.$viewModel.x2().get(this.$memberUin);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.$memberUin;
                    }
                    TroopMemberPreviewVH troopMemberPreviewVH = this.this$0;
                    if (str == null) {
                        str = "";
                    }
                    troopMemberPreviewVH.u(str, this.$memberUin, this.$viewModel.G2());
                }
            }
        });
        this.avatar.x(1, memberUin, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100).a());
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        TriggerRunnerKt.b(itemView, 800L, onclickListener);
        com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
        QQProAvatarView qQProAvatarView = this.avatar;
        TroopInfoData T2 = viewModel.T2();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("qq_num", memberUin));
        cVar.A(qQProAvatarView, "em_group_member_profile", T2, mutableMapOf);
    }

    public final void r(@NotNull View.OnClickListener onclickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onclickListener);
            return;
        }
        Intrinsics.checkNotNullParameter(onclickListener, "onclickListener");
        s("");
        Context context = this.itemView.getContext();
        if (context == null) {
            return;
        }
        this.nameTv.setText(context.getString(R.string.f221016_o));
        this.avatar.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.lwr, null));
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        TriggerRunnerKt.b(itemView, 800L, onclickListener);
        View view = this.itemView;
        CharSequence text = this.nameTv.getText();
        view.setContentDescription(((Object) text) + context.getString(R.string.f170645x8));
        VideoReport.setElementId(this.avatar, "em_group_remove_btn");
        VideoReport.setElementClickPolicy(this.avatar, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", this.avatar, null);
        com.tencent.mobileqq.troop.troopsetting.modules.base.ui.b.a(this.avatar);
    }

    public final void t(int position, int gridColumnCount) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(position), Integer.valueOf(gridColumnCount));
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(66.0f), ViewUtils.dpToPx(61.0f));
        layoutParams.bottomMargin = ViewUtils.dpToPx(15.0f);
        int i3 = position % gridColumnCount;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == gridColumnCount - 1) {
            z17 = true;
        }
        if (z16) {
            layoutParams.addRule(20);
        } else if (z17) {
            layoutParams.addRule(21);
        } else {
            layoutParams.addRule(14);
        }
        this.infoCardContainer.setLayoutParams(layoutParams);
    }
}
