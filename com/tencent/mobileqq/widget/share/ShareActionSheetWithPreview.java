package com.tencent.mobileqq.widget.share;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes20.dex */
public class ShareActionSheetWithPreview extends ShareActionSheetV2 {
    private Bitmap J0;
    private RelativeLayout K0;
    private RoundCornerImageView L0;
    private String M0;
    private boolean N0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass1 implements DialogInterface.OnShowListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            ActionSheet actionSheet = ShareActionSheetWithPreview.this.F;
            if (actionSheet != null && actionSheet.getActionContentView() != null && ShareActionSheetWithPreview.this.F.getActionContentView().getParent() != null && ShareActionSheetWithPreview.this.J0 != null && !ShareActionSheetWithPreview.this.J0.isRecycled()) {
                ShareActionSheetWithPreview shareActionSheetWithPreview = ShareActionSheetWithPreview.this;
                if (shareActionSheetWithPreview.G != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) shareActionSheetWithPreview.F.getActionContentView().getParent();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(10);
                    layoutParams.addRule(2, R.id.action_sheet_actionView);
                    int dpToPx = ViewUtils.dpToPx(32.0f);
                    layoutParams.setMargins(dpToPx, ImmersiveUtils.getStatusBarHeight(relativeLayout.getContext()) + dpToPx, dpToPx, dpToPx);
                    ShareActionSheetWithPreview.this.K0 = new RelativeLayout(relativeLayout.getContext());
                    relativeLayout.addView(ShareActionSheetWithPreview.this.K0, layoutParams);
                    ShareActionSheetWithPreview.this.K0.post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview.1.1

                        /* renamed from: com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview$1$1$a */
                        /* loaded from: classes20.dex */
                        class a extends View.AccessibilityDelegate {
                            a() {
                            }

                            @Override // android.view.View.AccessibilityDelegate
                            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                                if (accessibilityNodeInfo != null) {
                                    accessibilityNodeInfo.setClassName("");
                                }
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int width = ShareActionSheetWithPreview.this.K0.getWidth();
                            int height = ShareActionSheetWithPreview.this.K0.getHeight();
                            if (height < ViewUtils.dpToPx(160.0f)) {
                                QLog.d("ShareActionSheetWithPreview", 2, "Height is less than the minimum threshold, do not init.");
                                return;
                            }
                            ShareActionSheetWithPreview.this.L0 = new RoundCornerImageView(ShareActionSheetWithPreview.this.K0.getContext());
                            ShareActionSheetWithPreview.this.L0.f92071e = 1.0f;
                            float width2 = ShareActionSheetWithPreview.this.J0.getWidth();
                            float height2 = ShareActionSheetWithPreview.this.J0.getHeight();
                            float min = Math.min((width * 1.0f) / width2, (height * 1.0f) / height2);
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Math.round(width2 * min), Math.round(height2 * min));
                            layoutParams2.addRule(13);
                            ShareActionSheetWithPreview.this.K0.addView(ShareActionSheetWithPreview.this.L0, layoutParams2);
                            ShareActionSheetWithPreview.this.L0.setCorner(ViewUtils.dpToPx(16.0f));
                            ShareActionSheetWithPreview.this.L0.setAccessibilityDelegate(new a());
                            ShareActionSheetWithPreview.this.L0.setOnClickListener(new b());
                            ShareActionSheetWithPreview.this.L0.setContentDescription(ShareActionSheetWithPreview.this.M0);
                            ShareActionSheetWithPreview.this.L0.setImageBitmap(ShareActionSheetWithPreview.this.J0);
                            ShareActionSheetWithPreview.this.L0.startAnimation(ShareActionSheetWithPreview.this.A0());
                        }

                        /* renamed from: com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview$1$1$b */
                        /* loaded from: classes20.dex */
                        class b implements View.OnClickListener {
                            b() {
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                            }
                        }
                    });
                    ShareActionSheetWithPreview.this.K0.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview.1.2
                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                            if (ShareActionSheetWithPreview.this.L0 != null && !ShareActionSheetWithPreview.this.N0) {
                                if (i3 == i19 && i17 == i27 && i16 == i26 && i18 == i28) {
                                    return;
                                }
                                ShareActionSheetWithPreview.this.K0.post(new Runnable() { // from class: com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview.1.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ShareActionSheetWithPreview.this.B0();
                                    }
                                });
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements ActionSheet.WatchDismissActions {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public void onDismissOperations() {
            if (!ShareActionSheetWithPreview.this.N0 && ShareActionSheetWithPreview.this.L0 != null && ShareActionSheetWithPreview.this.L0.getVisibility() == 0) {
                ShareActionSheetWithPreview.this.N0 = true;
                ShareActionSheetWithPreview.this.L0.startAnimation(ShareActionSheetWithPreview.this.z0());
            }
        }
    }

    public ShareActionSheetWithPreview(ShareActionSheetV2.Param param) {
        super(param);
        this.N0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet A0() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        he0.b.l(alphaAnimation, R.anim.f154978ul);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154978ul);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        Bitmap bitmap;
        RelativeLayout.LayoutParams layoutParams;
        if (this.K0 == null || this.L0 == null || (bitmap = this.J0) == null || bitmap.isRecycled() || (layoutParams = (RelativeLayout.LayoutParams) this.L0.getLayoutParams()) == null) {
            return;
        }
        int width = this.K0.getWidth();
        int height = this.K0.getHeight();
        if (height < ViewUtils.dpToPx(160.0f)) {
            QLog.d("ShareActionSheetWithPreview", 2, "Height is less than the minimum threshold, set invisible.");
            this.L0.setVisibility(4);
            return;
        }
        float width2 = this.J0.getWidth();
        float height2 = this.J0.getHeight();
        float min = Math.min((width * 1.0f) / width2, (height * 1.0f) / height2);
        layoutParams.width = Math.round(width2 * min);
        layoutParams.height = Math.round(height2 * min);
        this.L0.setLayoutParams(layoutParams);
        this.L0.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet z0() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        he0.b.l(alphaAnimation, R.anim.f154975ui);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154975ui);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new b());
        return animationSet;
    }

    public void C0(String str) {
        this.M0 = str;
        RoundCornerImageView roundCornerImageView = this.L0;
        if (roundCornerImageView != null) {
            roundCornerImageView.setContentDescription(str);
        }
    }

    public void D0(Bitmap bitmap) {
        this.J0 = bitmap;
        setOnShowListener(new AnonymousClass1());
        setWatchDismissListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ShareActionSheetWithPreview.this.N0 = false;
            if (ShareActionSheetWithPreview.this.L0 != null) {
                ShareActionSheetWithPreview.this.L0.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
