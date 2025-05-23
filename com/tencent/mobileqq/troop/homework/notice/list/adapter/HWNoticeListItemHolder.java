package com.tencent.mobileqq.troop.homework.notice.list.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeListType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeRoleType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B9\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010'\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010)\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/adapter/HWNoticeListItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeData;", "noticeData", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "Landroid/view/View;", "E", "Landroid/view/View;", "itemView", "Landroid/app/Activity;", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "G", "Landroid/content/Context;", "context", "", "H", "Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeRoleType;", "I", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeRoleType;", "roleType", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "J", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "listType", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "titleTextView", "L", "contentTextView", "M", "timeTextView", "N", "confirmBtnTextView", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "confirmBtnIconImageView", "<init>", "(Landroid/view/View;Landroid/app/Activity;Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeRoleType;Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeListItemHolder extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final Activity activity;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final HWNoticeCons$HWNoticeRoleType roleType;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final HWNoticeCons$HWNoticeListType listType;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView titleTextView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView contentTextView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final TextView timeTextView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final TextView confirmBtnTextView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final ImageView confirmBtnIconImageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/adapter/HWNoticeListItemHolder$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.list.adapter.HWNoticeListItemHolder$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53404);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWNoticeListItemHolder(@NotNull View itemView, @Nullable Activity activity, @NotNull Context context, @NotNull String troopUin, @NotNull HWNoticeCons$HWNoticeRoleType roleType, @NotNull HWNoticeCons$HWNoticeListType listType) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(roleType, "roleType");
        Intrinsics.checkNotNullParameter(listType, "listType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, itemView, activity, context, troopUin, roleType, listType);
            return;
        }
        this.itemView = itemView;
        this.activity = activity;
        this.context = context;
        this.troopUin = troopUin;
        this.roleType = roleType;
        this.listType = listType;
        View findViewById = this.itemView.findViewById(R.id.h4o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.notice_title)");
        this.titleTextView = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.zsy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.notice_content)");
        this.contentTextView = (TextView) findViewById2;
        View findViewById3 = this.itemView.findViewById(R.id.zto);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.notice_time)");
        this.timeTextView = (TextView) findViewById3;
        View findViewById4 = this.itemView.findViewById(R.id.zsx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026ice_confirm_btn_textview)");
        this.confirmBtnTextView = (TextView) findViewById4;
        View findViewById5 = this.itemView.findViewById(R.id.zsw);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026.notice_confirm_btn_icon)");
        this.confirmBtnIconImageView = (ImageView) findViewById5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(HWNoticeListItemHolder this$0, GroupSchoolNoticeData noticeData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(noticeData, "$noticeData");
        IHWTroopUIApi iHWTroopUIApi = (IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class);
        Activity activity = this$0.activity;
        String str = this$0.troopUin;
        String str2 = noticeData.noticeId;
        Intrinsics.checkNotNullExpressionValue(str2, "noticeData.noticeId");
        iHWTroopUIApi.openNoticeDetailPage(activity, str, str2, IHWTroopUIApi.DetailPageFrom.NOTICE_LIST);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p(GroupSchoolNoticeData noticeData) {
        this.timeTextView.setText(new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH:mm", Locale.getDefault()).format(new Date(noticeData.publishTime * 1000)));
        this.confirmBtnTextView.setText("\u5df2\u786e\u8ba4\uff1a" + noticeData.confirmedCount + "/" + noticeData.total);
        this.confirmBtnTextView.setTextColor(this.context.getColor(R.color.qui_common_text_secondary));
        this.confirmBtnIconImageView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.qui_chevron_right_text_secondary));
    }

    private final void q(final GroupSchoolNoticeData noticeData) {
        if (noticeData.isConfirm) {
            this.confirmBtnTextView.setText("\u5df2\u786e\u8ba4");
            this.confirmBtnTextView.setTextColor(this.context.getColor(R.color.qui_common_text_secondary));
            this.confirmBtnIconImageView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.qui_chevron_right_text_secondary));
        } else {
            this.confirmBtnTextView.setText("\u53bb\u786e\u8ba4");
            this.confirmBtnTextView.setTextColor(this.context.getColor(R.color.qui_common_brand_standard));
            this.confirmBtnIconImageView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.qui_chevron_right_brand_standard));
        }
        HWNoticeUtils.f297171a.e(String.valueOf(noticeData.authorUin), this.troopUin, "HWNoticeListItemHolder", new Function1<String, Unit>(this) { // from class: com.tencent.mobileqq.troop.homework.notice.list.adapter.HWNoticeListItemHolder$configForReceiver$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ HWNoticeListItemHolder this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupSchoolNoticeData.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String nickName) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) nickName);
                    return;
                }
                Intrinsics.checkNotNullParameter(nickName, "nickName");
                String str = nickName + " " + new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH:mm", Locale.getDefault()).format(new Date(GroupSchoolNoticeData.this.publishTime * 1000));
                textView = this.this$0.timeTextView;
                textView.setText(str);
            }
        });
    }

    public final void n(@NotNull final GroupSchoolNoticeData noticeData) {
        View view;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) noticeData);
            return;
        }
        Intrinsics.checkNotNullParameter(noticeData, "noticeData");
        this.titleTextView.setText(noticeData.content.title);
        this.contentTextView.setText(noticeData.content.content);
        HWNoticeCons$HWNoticeListType hWNoticeCons$HWNoticeListType = this.listType;
        if (hWNoticeCons$HWNoticeListType == HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_MY_PUBLISH) {
            p(noticeData);
        } else if (this.roleType == HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_ADMIN_OR_OWNER && hWNoticeCons$HWNoticeListType == HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_ALL && noticeData.authorUin == MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin()) {
            p(noticeData);
        } else {
            q(noticeData);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.list.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWNoticeListItemHolder.o(HWNoticeListItemHolder.this, noticeData, view2);
            }
        });
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        Activity activity = this.activity;
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        h.a.m(aVar, itemView, "em_group_notice_entrance", exposurePolicy, null, null, view, 24, null);
    }
}
