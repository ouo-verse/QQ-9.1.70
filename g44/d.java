package g44;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import g44.d;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends ShareActionSheetV2 {
    private Bitmap J0;
    private RoundCornerImageView K0;
    private boolean L0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements DialogInterface.OnShowListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: g44.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public class C10350a extends View.AccessibilityDelegate {
            C10350a() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (accessibilityNodeInfo != null) {
                    accessibilityNodeInfo.setClassName("");
                }
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(RelativeLayout relativeLayout, ScrollView scrollView, RelativeLayout relativeLayout2) {
            if (relativeLayout.getHeight() < ViewUtils.dpToPx(160.0f)) {
                QLog.d("ShareActionSheetWithRobotPreview", 2, "Height is less than the minimum threshold, do not init.");
                return;
            }
            int width = scrollView.getWidth();
            if (d.this.J0.getWidth() > width) {
                d dVar = d.this;
                d.this.J0 = dVar.E0(dVar.J0, width);
            }
            d.this.K0 = new RoundCornerImageView(relativeLayout.getContext());
            d.this.K0.f92071e = 1.0f;
            d.this.K0.setCorner(ViewUtils.dpToPx(16.0f));
            d.this.K0.setImageBitmap(d.this.J0);
            d.this.K0.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            d.this.K0.setLayoutParams(layoutParams);
            d.this.K0.setAdjustViewBounds(true);
            d.this.K0.setContentDescription("Description");
            relativeLayout2.addView(d.this.K0);
            d.this.K0.setAccessibilityDelegate(new C10350a());
            d.this.K0.startAnimation(d.this.C0());
            ((ShareActionSheetV2) d.this).F.setCanceledOnTouchOutside(false);
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (((ShareActionSheetV2) d.this).F != null && ((ShareActionSheetV2) d.this).F.getActionContentView() != null && ((ShareActionSheetV2) d.this).F.getActionContentView().getParent() != null && d.this.J0 != null && !d.this.J0.isRecycled() && ((ShareActionSheetV2) d.this).G != null) {
                final RelativeLayout relativeLayout = (RelativeLayout) ((ShareActionSheetV2) d.this).F.getActionContentView().getParent();
                relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: g44.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.a.c(view);
                    }
                });
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(0);
                gradientDrawable.setCornerRadius(ViewUtils.dpToPx(16.0f));
                LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
                linearLayout.setOrientation(1);
                linearLayout.setGravity(16);
                linearLayout.setBackground(gradientDrawable);
                linearLayout.setClipToOutline(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                layoutParams.addRule(2, R.id.action_sheet_actionView);
                int dpToPx = ViewUtils.dpToPx(32.0f);
                layoutParams.setMargins(dpToPx, ImmersiveUtils.getStatusBarHeight(relativeLayout.getContext()) + dpToPx, dpToPx, -dpToPx);
                relativeLayout.addView(linearLayout, layoutParams);
                final ScrollView scrollView = new ScrollView(relativeLayout.getContext());
                scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                scrollView.setVerticalScrollBarEnabled(false);
                scrollView.setHorizontalScrollBarEnabled(false);
                linearLayout.addView(scrollView);
                final RelativeLayout relativeLayout2 = new RelativeLayout(relativeLayout.getContext());
                relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout2.setBackgroundColor(0);
                relativeLayout2.setPadding(0, 0, 0, dpToPx * 2);
                scrollView.addView(relativeLayout2);
                View findViewById = relativeLayout.findViewById(R.id.action_sheet_actionView);
                if (findViewById != null) {
                    findViewById.bringToFront();
                }
                scrollView.post(new Runnable() { // from class: g44.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.this.d(relativeLayout, scrollView, relativeLayout2);
                    }
                });
            }
        }
    }

    public d(ShareActionSheetV2.Param param) {
        super(param);
        this.L0 = false;
    }

    private AnimationSet B0() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet C0() {
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
    public /* synthetic */ void D0() {
        RoundCornerImageView roundCornerImageView;
        if (!this.L0 && (roundCornerImageView = this.K0) != null && roundCornerImageView.getVisibility() == 0) {
            this.L0 = true;
            this.K0.startAnimation(B0());
        }
    }

    private void G0() {
        setWatchDismissListener(new ActionSheet.WatchDismissActions() { // from class: g44.a
            @Override // com.tencent.widget.ActionSheet.WatchDismissActions
            public final void onDismissOperations() {
                d.this.D0();
            }
        });
    }

    public Bitmap E0(Bitmap bitmap, int i3) {
        int width = bitmap.getWidth();
        if (width <= 0) {
            return bitmap;
        }
        return Bitmap.createScaledBitmap(bitmap, i3, Math.round(bitmap.getHeight() * (i3 / width)), true);
    }

    public void F0(Bitmap bitmap) {
        this.J0 = bitmap;
        setOnShowListener(new a());
        G0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.L0 = false;
            if (d.this.K0 != null) {
                d.this.K0.setVisibility(4);
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
