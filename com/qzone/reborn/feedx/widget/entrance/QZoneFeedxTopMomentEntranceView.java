package com.qzone.reborn.feedx.widget.entrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001>B\u0011\b\u0016\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109B\u001b\b\u0016\u0012\u0006\u00107\u001a\u000206\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u00a2\u0006\u0004\b8\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u0016\u0010.\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010\u001bR\u0016\u00100\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010\u001fR\u0016\u00102\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010\u001fR\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxTopMomentEntranceView;", "Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "", "z0", "B0", "F0", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "redTouchInfo", "D0", "", "isAvatarVisible", "C0", "y0", "s0", "u0", "w0", "", "x0", "getLayoutId", "", "data", com.tencent.luggage.wxa.c8.c.G, "bindData", "onResume", "o0", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mEntranceIcon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mEntranceText", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "mAvatarLayout", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mUserHead1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mUserHead2", BdhLogUtil.LogTag.Tag_Conn, "mQZMRedDot", "D", "mQZMRightArrow", "E", "mQZMNumRedDot", UserInfo.SEX_FEMALE, "mQZMRedDotText", "G", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "mRedDotIsShowing", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxTopMomentEntranceView extends QZoneFeedxBaseEntranceView {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mQZMRedDot;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mQZMRightArrow;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mQZMNumRedDot;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mQZMRedDotText;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneCountInfo mRedDotIsShowing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mEntranceIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mEntranceText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mAvatarLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mUserHead1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mUserHead2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxTopMomentEntranceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(QZoneFeedxTopMomentEntranceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void B0() {
        rn.b.d();
        TextView textView = this.mQZMRedDotText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMRedDotText");
            textView = null;
        }
        rn.b.q(textView, null);
        w0();
    }

    private final void C0(boolean isAvatarVisible) {
        FrameLayout frameLayout = this.mAvatarLayout;
        ImageView imageView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarLayout");
            frameLayout = null;
        }
        rn.b.n(frameLayout, isAvatarVisible);
        ImageView imageView2 = this.mQZMRedDot;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMRedDot");
        } else {
            imageView = imageView2;
        }
        rn.b.n(imageView, isAvatarVisible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(QZoneFeedxTopMomentEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneCountInfo f16 = rn.b.f();
        TextView textView = null;
        if (f16 != null) {
            this$0.mRedDotIsShowing = f16;
            com.tencent.mobileqq.service.qzone.b.x(f16.countId, f16.cTime);
            com.tencent.mobileqq.service.qzone.b.y(f16.countId, f16.uCount);
        } else {
            this$0.mRedDotIsShowing = null;
        }
        this$0.F0();
        TextView textView2 = this$0.mQZMRedDotText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMRedDotText");
            textView2 = null;
        }
        rn.b.q(textView2, f16);
        ImageView imageView = this$0.mQZMRedDot;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMRedDot");
            imageView = null;
        }
        TextView textView3 = this$0.mQZMNumRedDot;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMNumRedDot");
        } else {
            textView = textView3;
        }
        rn.b.p(imageView, textView, f16);
        this$0.D0(f16);
    }

    private final void F0() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MOMENT_OUTER_ENTRANCE_MAIN_TEXT, QzoneConfig.DEFAULT_KEY_QZONE_MOMENT_OUTER_ENTRANCE_MAIN_TEXT);
        TextView textView = this.mEntranceText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEntranceText");
            textView = null;
        }
        textView.setText(config);
        TextView textView3 = this.mEntranceText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEntranceText");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
    }

    private final void s0() {
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(QZoneFeedxTopMomentEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C0(false);
        TextView textView = this$0.mQZMNumRedDot;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMNumRedDot");
            textView = null;
        }
        rn.b.n(textView, false);
        TextView textView2 = this$0.mQZMRedDotText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMRedDotText");
            textView2 = null;
        }
        rn.b.q(textView2, null);
    }

    private final void w0() {
        HashMap hashMap = new HashMap();
        hashMap.put("point_type", Integer.valueOf(x0()));
        fo.c.o(getRootView(), "em_bas_entrancemoment_banner_below", new fo.b().l(hashMap));
    }

    private final int x0() {
        QZoneCountInfo qZoneCountInfo = this.mRedDotIsShowing;
        if (qZoneCountInfo == null) {
            return 0;
        }
        Intrinsics.checkNotNull(qZoneCountInfo);
        return qZoneCountInfo.countId == 66 ? 1 : 2;
    }

    private final void y0() {
        boolean z16;
        QZoneCountInfo qZoneCountInfo = this.mRedDotIsShowing;
        if (qZoneCountInfo != null) {
            Intrinsics.checkNotNull(qZoneCountInfo);
            if (qZoneCountInfo.countId == 66) {
                z16 = true;
                ((jn.b) i.t(jn.b.class)).b(getContext(), rn.b.a(z16));
                s0();
            }
        }
        z16 = false;
        ((jn.b) i.t(jn.b.class)).b(getContext(), rn.b.a(z16));
        s0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object data, int pos) {
        o0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.hm9;
    }

    @Override // com.qzone.reborn.feedx.widget.entrance.QZoneFeedxBaseEntranceView
    public void o0() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.entrance.d
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxTopMomentEntranceView.E0(QZoneFeedxTopMomentEntranceView.this);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.entrance.QZoneFeedxBaseEntranceView
    public void onResume() {
        o0();
    }

    private final void u0() {
        this.mRedDotIsShowing = null;
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.feedx.widget.entrance.f
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxTopMomentEntranceView.v0(QZoneFeedxTopMomentEntranceView.this);
            }
        }, 2000L);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxTopMomentEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        z0();
    }

    private final void D0(QZoneCountInfo redTouchInfo) {
        if (redTouchInfo == null) {
            C0(false);
            return;
        }
        if (rn.b.h(redTouchInfo.countId)) {
            C0(false);
            return;
        }
        ArrayList<QZoneCountUserInfo> arrayList = redTouchInfo.friendList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                QZoneCountUserInfo qZoneCountUserInfo = arrayList.get(i3);
                if (qZoneCountUserInfo != null) {
                    arrayList2.add(Long.valueOf(qZoneCountUserInfo.uin));
                }
            }
            if (arrayList2.isEmpty()) {
                QLog.e("QZoneFeedxMomentEntranceView", 1, "invalidate uin list");
                C0(false);
                return;
            }
            QZoneUserAvatarView qZoneUserAvatarView = null;
            if (arrayList2.size() == 1) {
                QZoneUserAvatarView qZoneUserAvatarView2 = this.mUserHead1;
                if (qZoneUserAvatarView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHead1");
                    qZoneUserAvatarView2 = null;
                }
                Object obj = arrayList2.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "friendUinList[0]");
                rn.b.k(qZoneUserAvatarView2, ((Number) obj).longValue());
                QZoneUserAvatarView qZoneUserAvatarView3 = this.mUserHead2;
                if (qZoneUserAvatarView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHead2");
                } else {
                    qZoneUserAvatarView = qZoneUserAvatarView3;
                }
                rn.b.n(qZoneUserAvatarView, false);
            } else {
                QZoneUserAvatarView qZoneUserAvatarView4 = this.mUserHead1;
                if (qZoneUserAvatarView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHead1");
                    qZoneUserAvatarView4 = null;
                }
                Object obj2 = arrayList2.get(0);
                Intrinsics.checkNotNullExpressionValue(obj2, "friendUinList[0]");
                rn.b.k(qZoneUserAvatarView4, ((Number) obj2).longValue());
                QZoneUserAvatarView qZoneUserAvatarView5 = this.mUserHead2;
                if (qZoneUserAvatarView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHead2");
                } else {
                    qZoneUserAvatarView = qZoneUserAvatarView5;
                }
                Object obj3 = arrayList2.get(1);
                Intrinsics.checkNotNullExpressionValue(obj3, "friendUinList[1]");
                rn.b.k(qZoneUserAvatarView, ((Number) obj3).longValue());
            }
            C0(true);
            return;
        }
        QLog.e("QZoneFeedxMomentEntranceView", 1, "invalidate list");
        C0(false);
    }

    private final void z0() {
        View findViewById = findViewById(R.id.f67883ej);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026.id.qzm_entrance_icon_iv)");
        ImageView imageView = (ImageView) findViewById;
        this.mEntranceIcon = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEntranceIcon");
            imageView = null;
        }
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.qui_right_now_brand_standard));
        View findViewById2 = findViewById(R.id.f67953eq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(com.tencent\u2026q.R.id.qzm_entrance_text)");
        this.mEntranceText = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f67863eh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(com.tencent\u2026m_entrance_avatar_layout)");
        this.mAvatarLayout = (FrameLayout) findViewById3;
        View findViewById4 = findViewById(R.id.f67963er);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(com.tencent\u2026bileqq.R.id.qzm_head1_iv)");
        this.mUserHead1 = (QZoneUserAvatarView) findViewById4;
        View findViewById5 = findViewById(R.id.f67973es);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(com.tencent\u2026bileqq.R.id.qzm_head2_iv)");
        this.mUserHead2 = (QZoneUserAvatarView) findViewById5;
        View findViewById6 = findViewById(R.id.f67923en);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(com.tencent\u2026zm_entrance_red_dot_icon)");
        this.mQZMRedDot = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f67853eg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(com.tencent\u2026ntrance_arrow_right_icon)");
        ImageView imageView3 = (ImageView) findViewById7;
        this.mQZMRightArrow = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQZMRightArrow");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_02));
        View findViewById8 = findViewById(R.id.f67903el);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(com.tencent\u2026ntrance_passive_red_info)");
        this.mQZMNumRedDot = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.f67933eo);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(com.tencent\u2026zm_entrance_red_dot_text)");
        this.mQZMRedDotText = (TextView) findViewById9;
        View rootView = getRootView();
        if (rootView != null) {
            rootView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.entrance.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneFeedxTopMomentEntranceView.A0(QZoneFeedxTopMomentEntranceView.this, view);
                }
            });
        }
        m0();
        n0();
        B0();
    }
}
