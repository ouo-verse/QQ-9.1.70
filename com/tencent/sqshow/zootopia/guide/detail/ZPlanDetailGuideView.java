package com.tencent.sqshow.zootopia.guide.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.guide.detail.ZPlanDetailGuideView;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001;B\u001b\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\b\u00107\u001a\u0004\u0018\u000106\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J>\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010$R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010 R\u0018\u00100\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010 R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u0006<"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanDetailGuideView;", "Landroid/widget/RelativeLayout;", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "targetView", "Landroid/view/View$OnClickListener;", "onTargetClickListener", "e", "g", "b", "", "tipsText", "j", "stepText", "i", "onSkipClickListener", h.F, "f", "", "", "k", "(Landroid/view/View;)[Ljava/lang/Integer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "mode", "c", "Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanGuideMaskView;", "d", "Lcom/tencent/sqshow/zootopia/guide/detail/ZPlanGuideMaskView;", "mMaskView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mSightView", "mFingerView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTipsView", "Landroid/widget/RelativeLayout;", "mTipsContainer", "mStepView", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "mSkipButton", "D", "mTipsLineView", "E", "mRectView", UserInfo.SEX_FEMALE, "I", "mMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanDetailGuideView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout mSkipButton;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mTipsLineView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mRectView;

    /* renamed from: F, reason: from kotlin metadata */
    private int mMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanGuideMaskView mMaskView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mSightView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mFingerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTipsView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mTipsContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mStepView;

    public ZPlanDetailGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R.layout.f167421d80, this);
        n();
    }

    private final void b(View targetView) {
        if (this.mMode == 0) {
            ImageView imageView = this.mFingerView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mFingerView;
            ViewGroup.LayoutParams layoutParams = imageView2 != null ? imageView2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            Integer[] k3 = k(targetView);
            layoutParams2.leftMargin = k3[0].intValue() - i.a(64.0f);
            int intValue = k3[1].intValue();
            layoutParams2.topMargin = intValue;
            QLog.i("ZPlanGuideMaskView", 4, "bindFingerView :: leftMargin == " + layoutParams2.leftMargin + " , topMargin == " + intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ZPlanDetailGuideView this$0, View targetView, View.OnClickListener onClickListener, String tipsText, String stepText, View.OnClickListener onClickListener2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(targetView, "$targetView");
        Intrinsics.checkNotNullParameter(tipsText, "$tipsText");
        Intrinsics.checkNotNullParameter(stepText, "$stepText");
        this$0.e(targetView, onClickListener);
        this$0.g(targetView, onClickListener);
        this$0.b(targetView);
        this$0.j(tipsText, targetView);
        this$0.i(stepText);
        this$0.h(onClickListener2);
        this$0.f(targetView, onClickListener);
    }

    private final void e(View targetView, View.OnClickListener onTargetClickListener) {
        int i3 = this.mMode;
        if (i3 == 0) {
            Integer[] k3 = k(targetView);
            ZPlanGuideMaskView zPlanGuideMaskView = this.mMaskView;
            if (zPlanGuideMaskView != null) {
                zPlanGuideMaskView.setCircle(k3[0].intValue(), k3[1].intValue(), i.d(50.5f));
                return;
            }
            return;
        }
        if (i3 != 1) {
            ZPlanGuideMaskView zPlanGuideMaskView2 = this.mMaskView;
            if (zPlanGuideMaskView2 != null) {
                zPlanGuideMaskView2.setHalfScreen(m(targetView));
            }
            ZPlanGuideMaskView zPlanGuideMaskView3 = this.mMaskView;
            if (zPlanGuideMaskView3 != null) {
                zPlanGuideMaskView3.setOnClickListener(onTargetClickListener);
                return;
            }
            return;
        }
        float d16 = i.d(20.0f);
        ZPlanGuideMaskView zPlanGuideMaskView4 = this.mMaskView;
        if (zPlanGuideMaskView4 != null) {
            zPlanGuideMaskView4.setRect(l(targetView) - d16, m(targetView) - d16, l(targetView) + targetView.getWidth() + d16, m(targetView) + targetView.getHeight() + d16);
        }
        ZPlanGuideMaskView zPlanGuideMaskView5 = this.mMaskView;
        if (zPlanGuideMaskView5 != null) {
            zPlanGuideMaskView5.setOnClickListener(onTargetClickListener);
        }
    }

    private final void f(View targetView, View.OnClickListener onTargetClickListener) {
        if (this.mMode == 1) {
            ImageView imageView = this.mRectView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mRectView;
            if (imageView2 != null) {
                imageView2.setOnClickListener(onTargetClickListener);
            }
            ImageView imageView3 = this.mRectView;
            ViewGroup.LayoutParams layoutParams = imageView3 != null ? imageView3.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = targetView.getWidth() + (i.a(20.0f) * 2);
            layoutParams2.height = targetView.getHeight() + (i.a(20.0f) * 2);
            layoutParams2.leftMargin = l(targetView) - i.a(20.0f);
            int m3 = m(targetView) - i.a(20.0f);
            layoutParams2.topMargin = m3;
            QLog.i("ZPlanGuideMaskView", 4, "leftMargin == " + layoutParams2.leftMargin + " , topMargin == " + m3);
        }
    }

    private final void g(View targetView, View.OnClickListener onTargetClickListener) {
        if (this.mMode == 0) {
            ImageView imageView = this.mSightView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mSightView;
            if (imageView2 != null) {
                imageView2.setOnClickListener(onTargetClickListener);
            }
            ImageView imageView3 = this.mSightView;
            ViewGroup.LayoutParams layoutParams = imageView3 != null ? imageView3.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            Integer[] k3 = k(targetView);
            layoutParams2.leftMargin = k3[0].intValue() - i.a(50.5f);
            int intValue = k3[1].intValue() - i.a(50.5f);
            layoutParams2.topMargin = intValue;
            QLog.i("ZPlanGuideMaskView", 4, "bindSightView :: leftMargin == " + layoutParams2.leftMargin + " , topMargin == " + intValue);
        }
    }

    private final void h(View.OnClickListener onSkipClickListener) {
        LinearLayout linearLayout = this.mSkipButton;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onSkipClickListener);
        }
    }

    private final void i(String stepText) {
        TextView textView = this.mStepView;
        if (textView == null) {
            return;
        }
        textView.setText(stepText);
    }

    private final void j(String tipsText, View targetView) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView = this.mTipsView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.mTipsView;
        if (textView2 != null) {
            textView2.setText(tipsText);
        }
        int i3 = this.mMode;
        if (i3 == 2) {
            ImageView imageView = this.mTipsLineView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.mTipsLineView;
            ViewGroup.LayoutParams layoutParams2 = imageView2 != null ? imageView2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            ((RelativeLayout.LayoutParams) layoutParams2).addRule(14, -1);
            RelativeLayout relativeLayout = this.mTipsContainer;
            layoutParams = relativeLayout != null ? relativeLayout.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams3.topMargin = m(targetView) - i.a(155.0f);
            layoutParams3.addRule(14, -1);
            return;
        }
        if (i3 == 1) {
            ImageView imageView3 = this.mTipsLineView;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.mTipsLineView;
            ViewGroup.LayoutParams layoutParams4 = imageView4 != null ? imageView4.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
            layoutParams5.addRule(7, R.id.pyk);
            layoutParams5.rightMargin = i.a(30.0f);
            RelativeLayout relativeLayout2 = this.mTipsContainer;
            layoutParams = relativeLayout2 != null ? relativeLayout2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams6.topMargin = m(targetView) - i.a(155.0f);
            layoutParams6.addRule(14, -1);
        }
    }

    public final void c(int mode, final View targetView, final String tipsText, final String stepText, final View.OnClickListener onTargetClickListener, final View.OnClickListener onSkipClickListener) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(tipsText, "tipsText");
        Intrinsics.checkNotNullParameter(stepText, "stepText");
        this.mMode = mode;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: z84.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanDetailGuideView.d(ZPlanDetailGuideView.this, targetView, onTargetClickListener, tipsText, stepText, onSkipClickListener);
            }
        });
    }

    private final Integer[] k(View targetView) {
        int[] iArr = new int[2];
        targetView.getLocationInWindow(iArr);
        int width = iArr[0] + (targetView.getWidth() / 2);
        int height = iArr[1] + (targetView.getHeight() / 2);
        QLog.i("ZPlanGuideMaskView", 4, "findCenterPositionById :: centerX == " + width + " , centerY == " + height);
        return new Integer[]{Integer.valueOf(width), Integer.valueOf(height)};
    }

    private final int l(View targetView) {
        int[] iArr = new int[2];
        targetView.getLocationInWindow(iArr);
        return iArr[0];
    }

    private final int m(View targetView) {
        int[] iArr = new int[2];
        targetView.getLocationInWindow(iArr);
        return iArr[1];
    }

    private final void n() {
        this.mMaskView = (ZPlanGuideMaskView) findViewById(R.id.pye);
        this.mSightView = (ImageView) findViewById(R.id.pyc);
        this.mFingerView = (ImageView) findViewById(R.id.pyd);
        this.mTipsView = (TextView) findViewById(R.id.pyk);
        this.mStepView = (TextView) findViewById(R.id.pyh);
        this.mSkipButton = (LinearLayout) findViewById(R.id.pyg);
        this.mTipsContainer = (RelativeLayout) findViewById(R.id.pyi);
        this.mTipsLineView = (ImageView) findViewById(R.id.pyj);
        ImageView imageView = (ImageView) findViewById(R.id.pyf);
        this.mRectView = imageView;
        if (imageView == null) {
            return;
        }
        imageView.setTag(1);
    }
}
