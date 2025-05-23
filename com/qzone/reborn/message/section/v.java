package com.qzone.reborn.message.section;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bl.CommonNoticeBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZoneBaseMeta$StButton;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J*\u0010\u0019\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/message/section/v;", "Lcom/qzone/reborn/message/section/y;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", QCircleAlphaUserReporter.KEY_USER, "", "K", "H", "Lqzone/QZoneBaseMeta$StButton;", "buttonInfo", "J", "G", "L", "M", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "N", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "tvNickName", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "llDescButton", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "ivButtonIcon", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvDescButton", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class v extends y {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout llDescButton;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivButtonIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvDescButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView tvNickName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    private final void G(QZoneBaseMeta$StButton buttonInfo) {
        ImageView imageView = null;
        if (!TextUtils.isEmpty(buttonInfo.button_img.get())) {
            ImageView imageView2 = this.ivButtonIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivButtonIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.ivButtonIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivButtonIcon");
            } else {
                imageView = imageView3;
            }
            rn.h.a(imageView, buttonInfo.button_img.get(), R.color.qui_common_brand_standard);
            return;
        }
        ImageView imageView4 = this.ivButtonIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivButtonIcon");
        } else {
            imageView = imageView4;
        }
        imageView.setVisibility(8);
    }

    private final void H(CommonStUser user) {
        if (user.getNick().length() == 0) {
            return;
        }
        QZoneNickNameView qZoneNickNameView = this.tvNickName;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setRichText(user.getNick());
    }

    private final void J(QZoneBaseMeta$StButton buttonInfo) {
        LinearLayout linearLayout = null;
        if (!TextUtils.isEmpty(buttonInfo.button_color.get())) {
            TextView textView = this.tvDescButton;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvDescButton");
                textView = null;
            }
            textView.setTextColor(Color.parseColor(buttonInfo.button_color.get()));
        }
        TextView textView2 = this.tvDescButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescButton");
            textView2 = null;
        }
        textView2.setText(buttonInfo.text.get());
        LinearLayout linearLayout2 = this.llDescButton;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llDescButton");
        } else {
            linearLayout = linearLayout2;
        }
        w(linearLayout, "em_qz_intimate_space_en");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(CommonStUser user) {
        long f16 = gl.c.f402376a.f(user, ((CommonNoticeBean) this.mData).getCommonExt());
        if (f16 == 0) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setUser(f16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        ho.h.b(p(), gl.c.f402376a.f(((CommonNoticeBean) this.mData).getNotice().getOpUser(), ((CommonNoticeBean) this.mData).getCommonExt()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton;
        Object obj = ((CommonNoticeBean) this.mData).getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton2 = null;
        if (!(obj instanceof QZIntimateSpaceReader$StNotice)) {
            obj = null;
        }
        QZIntimateSpaceReader$StNotice qZIntimateSpaceReader$StNotice = (QZIntimateSpaceReader$StNotice) obj;
        if (qZIntimateSpaceReader$StNotice != null && (qZoneBaseMeta$StButton = qZIntimateSpaceReader$StNotice.space_button) != null) {
            qZoneBaseMeta$StButton2 = qZoneBaseMeta$StButton.get();
        }
        if (qZoneBaseMeta$StButton2 != null) {
            String str = qZoneBaseMeta$StButton2.actionurl.get();
            if (str == null || str.length() == 0) {
                return;
            }
            ho.i.q(p(), qZoneBaseMeta$StButton2.actionurl.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(v this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(v this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.qzone_user_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n87);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026(R.id.qzone_nike_name_tv)");
        this.tvNickName = (QZoneNickNameView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mtw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ne_desc_button_container)");
        this.llDescButton = (LinearLayout) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.mtx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026.qzone_desc_button_image)");
        this.ivButtonIcon = (ImageView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.mty);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026d.qzone_desc_button_text)");
        this.tvDescButton = (TextView) findViewById5;
        QZoneNickNameView qZoneNickNameView = this.tvNickName;
        LinearLayout linearLayout = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setMaxWidth(com.qzone.reborn.util.r.f59560a.e(175));
        QZoneNickNameView qZoneNickNameView2 = this.tvNickName;
        if (qZoneNickNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView2 = null;
        }
        qZoneNickNameView2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.O(v.this, view);
            }
        });
        LinearLayout linearLayout2 = this.llDescButton;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llDescButton");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.P(v.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162887n53};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton;
        if (data != null) {
            K(data.getNotice().getOpUser());
            H(data.getNotice().getOpUser());
            Object obj = data.getNotice().getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            QZoneBaseMeta$StButton qZoneBaseMeta$StButton2 = null;
            if (!(obj instanceof QZIntimateSpaceReader$StNotice)) {
                obj = null;
            }
            QZIntimateSpaceReader$StNotice qZIntimateSpaceReader$StNotice = (QZIntimateSpaceReader$StNotice) obj;
            if (qZIntimateSpaceReader$StNotice != null && (qZoneBaseMeta$StButton = qZIntimateSpaceReader$StNotice.space_button) != null) {
                qZoneBaseMeta$StButton2 = qZoneBaseMeta$StButton.get();
            }
            if (qZoneBaseMeta$StButton2 != null) {
                J(qZoneBaseMeta$StButton2);
                G(qZoneBaseMeta$StButton2);
            }
        }
    }
}
