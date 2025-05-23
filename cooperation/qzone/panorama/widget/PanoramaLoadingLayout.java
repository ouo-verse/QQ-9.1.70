package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes38.dex */
public class PanoramaLoadingLayout extends RelativeLayout {
    public static final int ANIMATION_TIME = 300;
    private static final String TAG = "PanoramaLoadingLayout";
    public static boolean isPanoramaLoading = false;
    private Context context;
    private PanoramaLoadingBall horizontalPanoramaLoadingBall;
    private PanoramaLoadingBackground panoramaLoadingBackground;
    private TextView tvToast;
    private PanoramaLoadingBall verticalPanoramaLoadingBall;
    public static final int WIDTH = ViewUtils.dpToPx(55.0f);
    public static final int HEIGHT = ViewUtils.dpToPx(55.0f);

    public PanoramaLoadingLayout(Context context) {
        super(context);
        this.context = context;
    }

    public void onRecycled() {
        PanoramaLoadingBall panoramaLoadingBall = this.horizontalPanoramaLoadingBall;
        if (panoramaLoadingBall != null) {
            panoramaLoadingBall.stopTimer();
            removeView(this.horizontalPanoramaLoadingBall);
        }
        PanoramaLoadingBall panoramaLoadingBall2 = this.verticalPanoramaLoadingBall;
        if (panoramaLoadingBall2 != null) {
            panoramaLoadingBall2.stopTimer();
            removeView(this.verticalPanoramaLoadingBall);
        }
        PanoramaLoadingBackground panoramaLoadingBackground = this.panoramaLoadingBackground;
        if (panoramaLoadingBackground != null) {
            removeView(panoramaLoadingBackground);
        }
        this.panoramaLoadingBackground = null;
        this.horizontalPanoramaLoadingBall = null;
        this.verticalPanoramaLoadingBall = null;
    }

    public void showLoading(boolean z16, boolean z17) {
        int i3 = WIDTH;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, HEIGHT);
        layoutParams.addRule(13);
        if (this.panoramaLoadingBackground == null) {
            PanoramaLoadingBackground panoramaLoadingBackground = new PanoramaLoadingBackground(this.context);
            this.panoramaLoadingBackground = panoramaLoadingBackground;
            panoramaLoadingBackground.setId(1);
            addView(this.panoramaLoadingBackground, layoutParams);
        }
        if (this.horizontalPanoramaLoadingBall == null) {
            PanoramaLoadingBall panoramaLoadingBall = new PanoramaLoadingBall(this.context);
            this.horizontalPanoramaLoadingBall = panoramaLoadingBall;
            panoramaLoadingBall.setRotationX(60.0f);
            addView(this.horizontalPanoramaLoadingBall, layoutParams);
        }
        if (this.verticalPanoramaLoadingBall == null) {
            PanoramaLoadingBall panoramaLoadingBall2 = new PanoramaLoadingBall(this.context);
            this.verticalPanoramaLoadingBall = panoramaLoadingBall2;
            panoramaLoadingBall2.setRotationY(60.0f);
            addView(this.verticalPanoramaLoadingBall, layoutParams);
        }
        if (this.tvToast == null) {
            TextView textView = new TextView(this.context);
            this.tvToast = textView;
            textView.setText(this.context.getResources().getString(R.string.giw));
            this.tvToast.setTextColor(-1);
            this.tvToast.setTextSize(14.0f);
            this.tvToast.setShadowLayer(2.0f, 2.0f, 2.0f, -16777216);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.addRule(3, this.panoramaLoadingBackground.getId());
            layoutParams2.topMargin = ViewUtils.dip2px(10.0f) + (i3 / 5);
            addView(this.tvToast, layoutParams2);
        }
        if (z16) {
            startRotateAnimate();
        }
        if (z17) {
            this.tvToast.setVisibility(0);
        } else {
            this.tvToast.setVisibility(8);
        }
    }

    public void startRotateAnimate() {
        PanoramaLoadingBackground panoramaLoadingBackground;
        PanoramaLoadingBall panoramaLoadingBall = this.horizontalPanoramaLoadingBall;
        if (panoramaLoadingBall == null || this.verticalPanoramaLoadingBall == null || (panoramaLoadingBackground = this.panoramaLoadingBackground) == null) {
            return;
        }
        panoramaLoadingBall.startRotate(60.0f, 0, panoramaLoadingBackground);
        this.verticalPanoramaLoadingBall.startRotate(60.0f, 1, this.panoramaLoadingBackground);
    }

    public void stopRotateAnimate() {
        PanoramaLoadingBall panoramaLoadingBall = this.horizontalPanoramaLoadingBall;
        if (panoramaLoadingBall != null) {
            panoramaLoadingBall.stopTimer();
            this.horizontalPanoramaLoadingBall.setRotationX(60.0f);
        }
        PanoramaLoadingBall panoramaLoadingBall2 = this.verticalPanoramaLoadingBall;
        if (panoramaLoadingBall2 != null) {
            panoramaLoadingBall2.stopTimer();
            this.verticalPanoramaLoadingBall.setRotationY(60.0f);
        }
    }

    public PanoramaLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }
}
