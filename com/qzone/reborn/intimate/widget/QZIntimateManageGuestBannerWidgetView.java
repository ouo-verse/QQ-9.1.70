package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import nk.aw;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;
import qzone.QZIntimateProfileReader$SpaceThemeInfo;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001;B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateManageGuestBannerWidgetView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lij/i;", "Landroid/view/View$OnClickListener;", "", "u0", "o0", "r0", "s0", "Landroid/view/View;", "v", "p0", "q0", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "n0", "", "getLayoutId", "spaceItemBean", com.tencent.luggage.wxa.c8.c.G, "m0", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "e", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundCornerContainer", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "rlItemLayout", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarUser1", "i", "avatarUser2", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "tvDesc", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "ivArrowIcon", "Lnk/aw;", "D", "Lnk/aw;", "manageViewModel", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "E", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "spaceData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateManageGuestBannerWidgetView extends QZoneBaseWidgetView<ij.i> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final ImageView ivArrowIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private aw manageViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private QZIntimateProfileReader$IntimateSpaceAbs spaceData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout roundCornerContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout rlItemLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final QZoneUserAvatarView avatarUser1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final QZoneUserAvatarView avatarUser2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView tvDesc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateManageGuestBannerWidgetView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.k8y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guest_banner_root_container)");
        com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout roundCorneredFrameLayout = (com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout) findViewById;
        this.roundCornerContainer = roundCorneredFrameLayout;
        View findViewById2 = findViewById(R.id.ktr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById2;
        this.rlItemLayout = relativeLayout;
        View findViewById3 = findViewById(R.id.f19104s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.avatar_user1)");
        this.avatarUser1 = (QZoneUserAvatarView) findViewById3;
        View findViewById4 = findViewById(R.id.f19114t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.avatar_user2)");
        this.avatarUser2 = (QZoneUserAvatarView) findViewById4;
        View findViewById5 = findViewById(R.id.nin);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_desc)");
        this.tvDesc = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.nhz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_arrow_icon)");
        ImageView imageView = (ImageView) findViewById6;
        this.ivArrowIcon = imageView;
        rn.h.a(imageView, "qui_chevron_right", R.color.qui_common_text_secondary);
        roundCorneredFrameLayout.setRadius(ef.d.b(8));
        relativeLayout.setOnClickListener(this);
        relativeLayout.getLayoutParams().width = pl.a.f426446a.o(getContext()) - ImmersiveUtils.dpToPx(32.0f);
        relativeLayout.getLayoutParams().height = (int) (relativeLayout.getLayoutParams().width * 0.18950437f);
        this.manageViewModel = (aw) p(aw.class);
    }

    private final QZoneIntimateActivateSpaceBean n0() {
        String str;
        QZoneIntimateManageInitBean initBean;
        PBRepeatMessageField<QZoneBaseMeta$StUser> pBRepeatMessageField;
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = new QZoneIntimateActivateSpaceBean();
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        if (!((qZIntimateProfileReader$IntimateSpaceAbs == null || (pBRepeatMessageField = qZIntimateProfileReader$IntimateSpaceAbs.user) == null || pBRepeatMessageField.isEmpty()) ? false : true)) {
            QLog.e("QZIntimateManageGuestBannerWidgetView", 1, "updateUserData  mData.user.isEmpty");
            return qZoneIntimateActivateSpaceBean;
        }
        ArrayList arrayList = new ArrayList();
        oj.a aVar = oj.a.f423008a;
        aw awVar = this.manageViewModel;
        if (awVar == null || (initBean = awVar.getInitBean()) == null || (str = initBean.getUid()) == null) {
            str = "";
        }
        arrayList.add(aVar.g(aVar.f(str, "")));
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs2 = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs2);
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = qZIntimateProfileReader$IntimateSpaceAbs2.user.get(0);
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StUser, "spaceData!!.user[0]");
        arrayList.add(aVar.g(qZoneBaseMeta$StUser));
        qZoneIntimateActivateSpaceBean.setUsers(arrayList);
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs3 = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs3);
        qZoneIntimateActivateSpaceBean.setSpaceType(qZIntimateProfileReader$IntimateSpaceAbs3.space_type.get());
        return qZoneIntimateActivateSpaceBean;
    }

    private final void o0() {
        if (this.spaceData == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs);
        if (!qZIntimateProfileReader$IntimateSpaceAbs.user.isEmpty()) {
            mk.h hVar = mk.h.f416877a;
            QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs2 = this.spaceData;
            Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs2);
            String str = qZIntimateProfileReader$IntimateSpaceAbs2.user.get(0).uid.get();
            aw awVar = this.manageViewModel;
            hashMap.put("touin", Long.valueOf(hVar.f(str, awVar != null ? awVar.getCommonExt() : null)));
            QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs3 = this.spaceData;
            Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs3);
            String str2 = qZIntimateProfileReader$IntimateSpaceAbs3.user.get(0).uid.get();
            Intrinsics.checkNotNullExpressionValue(str2, "spaceData!!.user[0].uid.get()");
            hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str2);
        }
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs4 = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs4);
        hashMap.put("close_friend_space_type", Integer.valueOf(qZIntimateProfileReader$IntimateSpaceAbs4.space_type.get()));
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs5 = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs5);
        String str3 = qZIntimateProfileReader$IntimateSpaceAbs5.space_id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "spaceData!!.space_id.get()");
        hashMap.put("close_friend_space_id", str3);
        fo.c.o(this.rlItemLayout, "em_qz_open_friend_space_guide_bar", new fo.b().l(hashMap));
    }

    private final void p0(View v3) {
        QZoneIntimateManageInitBean initBean;
        if (this.spaceData == null) {
            return;
        }
        if (com.qzone.reborn.configx.g.f53821a.h().w()) {
            QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
            Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs);
            String valueOf = String.valueOf(qZIntimateProfileReader$IntimateSpaceAbs.space_type.get());
            mk.h hVar = mk.h.f416877a;
            aw awVar = this.manageViewModel;
            String uid = (awVar == null || (initBean = awVar.getInitBean()) == null) ? null : initBean.getUid();
            aw awVar2 = this.manageViewModel;
            ho.i.q(v3.getContext(), QZoneConfigHelper.w0(String.valueOf(hVar.f(uid, awVar2 != null ? awVar2.getCommonExt() : null)), valueOf));
            return;
        }
        StringBuilder sb5 = new StringBuilder(QZoneConfigHelper.v0());
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs2 = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs2);
        if (qZIntimateProfileReader$IntimateSpaceAbs2.user.size() > 0) {
            sb5.append("&to=");
            mk.h hVar2 = mk.h.f416877a;
            QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs3 = this.spaceData;
            Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs3);
            String str = qZIntimateProfileReader$IntimateSpaceAbs3.user.get(0).uid.get();
            aw awVar3 = this.manageViewModel;
            sb5.append(hVar2.f(str, awVar3 != null ? awVar3.getCommonExt() : null));
        }
        sb5.append("&space_type=");
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs4 = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs4);
        sb5.append(qZIntimateProfileReader$IntimateSpaceAbs4.space_type.get());
        ho.i.q(v3.getContext(), sb5.toString());
    }

    private final void q0(View v3) {
        QZoneIntimateManageInitBean initBean;
        PBStringField pBStringField;
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        String str = (qZIntimateProfileReader$IntimateSpaceAbs == null || (pBStringField = qZIntimateProfileReader$IntimateSpaceAbs.space_id) == null) ? null : pBStringField.get();
        if (str == null) {
            str = "";
        }
        qZoneIntimateMainPageInitBean.setSpaceId(str);
        qZoneIntimateMainPageInitBean.setDraft(true);
        aw awVar = this.manageViewModel;
        if (awVar != null && (initBean = awVar.getInitBean()) != null) {
            qZoneIntimateMainPageInitBean.setFrom(initBean.getFrom());
        }
        qZoneIntimateMainPageInitBean.setActivateSpaceBean(n0());
        ck.c o16 = ho.i.o();
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        o16.r(context, qZoneIntimateMainPageInitBean);
    }

    private final void r0() {
        QZoneIntimateManageInitBean initBean;
        QZoneIntimateManageInitBean initBean2;
        if (this.spaceData == null) {
            return;
        }
        QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
        bVar.f55960b = false;
        aw awVar = this.manageViewModel;
        if (!Intrinsics.areEqual((awVar == null || (initBean2 = awVar.getInitBean()) == null) ? null : initBean2.getUid(), "")) {
            QZoneUserAvatarView qZoneUserAvatarView = this.avatarUser1;
            mk.h hVar = mk.h.f416877a;
            aw awVar2 = this.manageViewModel;
            String uid = (awVar2 == null || (initBean = awVar2.getInitBean()) == null) ? null : initBean.getUid();
            aw awVar3 = this.manageViewModel;
            qZoneUserAvatarView.setUser(hVar.f(uid, awVar3 != null ? awVar3.getCommonExt() : null), bVar);
        } else {
            this.avatarUser1.setUser(LoginData.getInstance().getUin());
        }
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs);
        if (qZIntimateProfileReader$IntimateSpaceAbs.user.size() > 0) {
            QZoneUserAvatarView qZoneUserAvatarView2 = this.avatarUser2;
            mk.h hVar2 = mk.h.f416877a;
            QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs2 = this.spaceData;
            Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs2);
            String str = qZIntimateProfileReader$IntimateSpaceAbs2.user.get(0).uid.get();
            aw awVar4 = this.manageViewModel;
            qZoneUserAvatarView2.setUser(hVar2.f(str, awVar4 != null ? awVar4.getCommonExt() : null), bVar);
        }
    }

    private final void s0() {
        String str;
        PBStringField pBStringField;
        TextView textView = this.tvDesc;
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        if (qZIntimateProfileReader$IntimateSpaceAbs == null || (pBStringField = qZIntimateProfileReader$IntimateSpaceAbs.title) == null || (str = pBStringField.get()) == null) {
            str = "";
        }
        textView.setText(str);
    }

    private final void u0() {
        String str;
        List split$default;
        int a16;
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo;
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        if (qZIntimateProfileReader$IntimateSpaceAbs == null) {
            return;
        }
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo2 = (qZIntimateProfileReader$IntimateSpaceAbs == null || (qZIntimateProfileReader$SpaceThemeInfo = qZIntimateProfileReader$IntimateSpaceAbs.space_theme_info) == null) ? null : qZIntimateProfileReader$SpaceThemeInfo.get();
        if (qZIntimateProfileReader$SpaceThemeInfo2 == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            str = qZIntimateProfileReader$SpaceThemeInfo2.customer_night_color.get();
        } else {
            str = qZIntimateProfileReader$SpaceThemeInfo2.customer_daytime_color.get();
        }
        String cardBgColorString = str;
        if (TextUtils.isEmpty(cardBgColorString)) {
            QLog.e("QZIntimateManageGuestBannerWidgetView", 1, "cardBgColorString is empty");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(cardBgColorString, "cardBgColorString");
        split$default = StringsKt__StringsKt.split$default((CharSequence) cardBgColorString, new String[]{";"}, false, 0, 6, (Object) null);
        ef.a aVar = ef.a.f396213a;
        int a17 = aVar.a((String) split$default.get(0), getContext().getColor(R.color.qui_common_fill_light_secondary));
        if (split$default.size() == 1) {
            a16 = aVar.a((String) split$default.get(0), getContext().getColor(R.color.qui_common_fill_light_secondary));
        } else {
            a16 = aVar.a((String) split$default.get(1), getContext().getColor(R.color.qui_common_fill_light_secondary));
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{a17, a16});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ef.d.b(8));
        this.roundCornerContainer.setBackground(gradientDrawable);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f167297ck1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.ktr && !com.qzone.reborn.util.e.b("QZIntimateManageGuestBannerWidgetViewHalfScreen", 500L)) {
            if (com.qzone.reborn.configx.g.f53821a.b().D1()) {
                q0(v3);
            } else {
                p0(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(ij.i spaceItemBean, int pos) {
        QZIntimateProfileReader$IntimateSpaceAbs spaceAbsData = spaceItemBean != null ? spaceItemBean.getSpaceAbsData() : null;
        this.spaceData = spaceAbsData;
        if (spaceAbsData == null) {
            this.rlItemLayout.setVisibility(8);
            setVisibility(8);
            return;
        }
        this.rlItemLayout.setVisibility(0);
        setVisibility(0);
        u0();
        r0();
        s0();
        o0();
        QZIntimateProfileReader$IntimateSpaceAbs qZIntimateProfileReader$IntimateSpaceAbs = this.spaceData;
        Intrinsics.checkNotNull(qZIntimateProfileReader$IntimateSpaceAbs);
        QLog.d("QZIntimateManageGuestBannerWidgetView", 1, "onBindData  | space_id = " + qZIntimateProfileReader$IntimateSpaceAbs.space_id.get() + " | position = " + pos);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateManageGuestBannerWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.k8y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guest_banner_root_container)");
        com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout roundCorneredFrameLayout = (com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout) findViewById;
        this.roundCornerContainer = roundCorneredFrameLayout;
        View findViewById2 = findViewById(R.id.ktr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById2;
        this.rlItemLayout = relativeLayout;
        View findViewById3 = findViewById(R.id.f19104s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.avatar_user1)");
        this.avatarUser1 = (QZoneUserAvatarView) findViewById3;
        View findViewById4 = findViewById(R.id.f19114t);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.avatar_user2)");
        this.avatarUser2 = (QZoneUserAvatarView) findViewById4;
        View findViewById5 = findViewById(R.id.nin);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_desc)");
        this.tvDesc = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.nhz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_arrow_icon)");
        ImageView imageView = (ImageView) findViewById6;
        this.ivArrowIcon = imageView;
        rn.h.a(imageView, "qui_chevron_right", R.color.qui_common_text_secondary);
        roundCorneredFrameLayout.setRadius(ef.d.b(8));
        relativeLayout.setOnClickListener(this);
        relativeLayout.getLayoutParams().width = pl.a.f426446a.o(getContext()) - ImmersiveUtils.dpToPx(32.0f);
        relativeLayout.getLayoutParams().height = (int) (relativeLayout.getLayoutParams().width * 0.18950437f);
        this.manageViewModel = (aw) p(aw.class);
    }
}
