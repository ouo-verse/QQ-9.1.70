package kk;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZoneBaseMeta$StButton;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J*\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u00104R\u0016\u00106\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010-R\u0016\u00108\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010:\u00a8\u0006>"}, d2 = {"Lkk/e;", "Lkk/a;", "Landroid/view/View$OnClickListener;", "Lqzone/QZoneBaseMeta$StUser;", "stUser", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "Lqzone/QZIntimateSpaceReader$StNotice;", "stNotice", "B", "Lqzone/QZoneBaseMeta$StButton;", "buttonInfo", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/qzone/reborn/message/data/a;", "data", "", "position", "", "", "payload", "G", "view", NodeProps.ON_CLICK, "", "e", "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "f", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "tvNickName", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvTime", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "llDescButton", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "ivButtonIcon", "tvDescButton", "E", "tvReplyButton", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "rootLayout", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends a implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView ivButtonIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView tvDescButton;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvReplyButton;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewGroup rootLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateMessageTitleSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView tvNickName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llDescButton;

    private final void A(QZoneBaseMeta$StUser stUser) {
        QZoneNickNameView qZoneNickNameView;
        QZoneNickNameView qZoneNickNameView2 = this.tvNickName;
        if (qZoneNickNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView2 = null;
        }
        qZoneNickNameView2.setRichText(stUser.nick.get());
        QZoneNickNameView qZoneNickNameView3 = this.tvNickName;
        if (qZoneNickNameView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView = null;
        } else {
            qZoneNickNameView = qZoneNickNameView3;
        }
        a.v(this, qZoneNickNameView, "em_qz_avatar_nickname_area", false, 4, null);
    }

    private final void B(QZIntimateSpaceReader$StNotice stNotice) {
        TextView textView;
        String f16 = com.qzone.proxy.feedcomponent.util.c.f(stNotice.create_time.get() * 1000, Calendar.getInstance());
        TextView textView2 = this.tvTime;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView2 = null;
        }
        textView2.setText(f16);
        TextView textView3 = this.tvTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView = null;
        } else {
            textView = textView3;
        }
        a.v(this, textView, "em_qz_avatar_nickname_area", false, 4, null);
    }

    private final void C(QZIntimateSpaceReader$StNotice stNotice) {
        TextView textView;
        TextView textView2 = null;
        if (stNotice.op_mask.get().contains(1)) {
            TextView textView3 = this.tvReplyButton;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvReplyButton");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.tvReplyButton;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvReplyButton");
                textView = null;
            } else {
                textView = textView4;
            }
            a.v(this, textView, "em_qz_reply_button", false, 4, null);
            return;
        }
        TextView textView5 = this.tvReplyButton;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvReplyButton");
        } else {
            textView2 = textView5;
        }
        textView2.setVisibility(8);
    }

    private final void D(QZoneBaseMeta$StButton buttonInfo) {
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
        u(linearLayout, "em_bas_chum_space_entry", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(QZoneBaseMeta$StUser stUser) {
        QZoneUserAvatarView qZoneUserAvatarView;
        if (TextUtils.isEmpty(stUser.uid.get())) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.avatarView;
        if (qZoneUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView2 = null;
        }
        qZoneUserAvatarView2.setUser(mk.h.f416877a.f(stUser.uid.get(), ((com.qzone.reborn.message.data.a) this.mData).getStCommonExt()));
        QZoneUserAvatarView qZoneUserAvatarView3 = this.avatarView;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        } else {
            qZoneUserAvatarView = qZoneUserAvatarView3;
        }
        a.v(this, qZoneUserAvatarView, "em_qz_avatar_nickname_area", false, 4, null);
    }

    private final void z(QZoneBaseMeta$StButton buttonInfo) {
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
            rn.h.a(imageView, buttonInfo.button_img.get(), R.color.qui_common_text_link);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n87) {
            ho.h.b(p(), mk.h.f416877a.f(((com.qzone.reborn.message.data.a) this.mData).getStNotice().op_user.uid.get(), ((com.qzone.reborn.message.data.a) this.mData).getStCommonExt()));
        } else if (valueOf != null && valueOf.intValue() == R.id.mtw) {
            y();
        } else if (valueOf != null && valueOf.intValue() == R.id.nav) {
            x();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n87);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.qzone_nike_name_tv)");
        this.tvNickName = (QZoneNickNameView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.qzone_user_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.nbi);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026(R.id.qzone_time_desc_tv)");
        this.tvTime = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.mtw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026ne_desc_button_container)");
        this.llDescButton = (LinearLayout) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.mtx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026.qzone_desc_button_image)");
        this.ivButtonIcon = (ImageView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.mty);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026d.qzone_desc_button_text)");
        this.tvDescButton = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.nav);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026.qzone_reply_button_text)");
        this.tvReplyButton = (TextView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.n7w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026essage_title_root_layout)");
        this.rootLayout = (ViewGroup) findViewById8;
        QZoneNickNameView qZoneNickNameView = this.tvNickName;
        TextView textView = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNickName");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setOnClickListener(this);
        LinearLayout linearLayout = this.llDescButton;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llDescButton");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        TextView textView2 = this.tvReplyButton;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvReplyButton");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.not};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.message.data.a data, int position, List<Object> payload) {
        if (data != null) {
            QZIntimateSpaceReader$StNotice stNotice = data.getStNotice();
            QZoneBaseMeta$StUser stUser = stNotice.op_user;
            QZoneBaseMeta$StButton buttonInfo = stNotice.space_button;
            Intrinsics.checkNotNullExpressionValue(stUser, "stUser");
            A(stUser);
            F(stUser);
            B(stNotice);
            Intrinsics.checkNotNullExpressionValue(buttonInfo, "buttonInfo");
            D(buttonInfo);
            z(buttonInfo);
            C(stNotice);
        }
    }
}
