package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qzonehub.api.panorama.OnAnimateListener;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes38.dex */
public class PanoramaGuideAnimate extends LinearLayout {
    private static final float ALPHA_RATE = 0.05f;
    private static final int HANDLE_MSG_ALPHA = 292;
    private static final int HANDLE_MSG_ROTATE = 291;
    private static final int ORIENTATION_ANTI_CLOCK_WISE = 1;
    private static final int ORIENTATION_CLOCK_WISE = 0;
    private static final int ROTATE_ANGEL = 45;
    private static final float ROTATE_RATE = 0.15f;
    private static final int TRANSLATION_DISTANCE = 140;
    private float alpha;
    private Context context;
    private int currentOrientation;
    private float currentRotate;
    private float currentTranslation;
    private Handler handler;
    private ImageView imgPhone;
    private OnAnimateListener onAnimateListener;
    private Timer timer;
    private TimerTask timerTask;
    private TextView tvToast;

    public PanoramaGuideAnimate(Context context) {
        super(context);
        this.currentRotate = 0.0f;
        this.currentTranslation = 0.0f;
        this.currentOrientation = 0;
        this.alpha = 1.0f;
        this.handler = new Handler() { // from class: cooperation.qzone.panorama.widget.PanoramaGuideAnimate.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i3 = message.what;
                if (i3 == 291) {
                    PanoramaGuideAnimate.this.imgPhone.setRotationY(PanoramaGuideAnimate.this.currentRotate);
                    PanoramaGuideAnimate.this.imgPhone.setTranslationX(PanoramaGuideAnimate.this.currentTranslation);
                    return;
                }
                if (i3 != 292) {
                    return;
                }
                if (PanoramaGuideAnimate.this.alpha <= 0.0f) {
                    if (PanoramaGuideAnimate.this.onAnimateListener != null) {
                        PanoramaGuideAnimate.this.onAnimateListener.onAnimateComplete();
                    }
                } else {
                    PanoramaGuideAnimate.this.alpha -= 0.05f;
                    PanoramaGuideAnimate panoramaGuideAnimate = PanoramaGuideAnimate.this;
                    panoramaGuideAnimate.setAlpha(panoramaGuideAnimate.alpha);
                    PanoramaGuideAnimate.this.handler.sendEmptyMessage(292);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    private void startTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.timer = new BaseTimer();
        TimerTask timerTask2 = new TimerTask() { // from class: cooperation.qzone.panorama.widget.PanoramaGuideAnimate.2
            private float rotateOffest = PanoramaGuideAnimate.ROTATE_RATE;
            private float translationOffest = 0.46666667f;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (PanoramaGuideAnimate.this.currentOrientation == 0) {
                    PanoramaGuideAnimate.this.currentRotate += this.rotateOffest;
                    PanoramaGuideAnimate.this.currentTranslation -= this.translationOffest;
                } else {
                    PanoramaGuideAnimate.this.currentRotate -= this.rotateOffest;
                    PanoramaGuideAnimate.this.currentTranslation += this.translationOffest;
                }
                if (PanoramaGuideAnimate.this.currentRotate >= 45.0f || PanoramaGuideAnimate.this.currentTranslation <= -140.0f) {
                    PanoramaGuideAnimate.this.currentOrientation = 1;
                }
                if (PanoramaGuideAnimate.this.currentRotate <= -45.0f || PanoramaGuideAnimate.this.currentTranslation >= 140.0f) {
                    if (PanoramaGuideAnimate.this.timer != null) {
                        PanoramaGuideAnimate.this.timer.cancel();
                    }
                    if (PanoramaGuideAnimate.this.timerTask != null) {
                        PanoramaGuideAnimate.this.timerTask.cancel();
                    }
                    PanoramaGuideAnimate.this.handler.sendEmptyMessage(292);
                    return;
                }
                PanoramaGuideAnimate.this.handler.sendEmptyMessage(291);
            }
        };
        this.timerTask = timerTask2;
        this.timer.schedule(timerTask2, 800L, 1L);
    }

    public void onPause() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    public void setOnAnimateListener(OnAnimateListener onAnimateListener) {
        this.onAnimateListener = onAnimateListener;
    }

    public void addView(int i3) {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(this.context);
        this.imgPhone = imageView;
        imageView.setImageResource(R.drawable.fvx);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
        layoutParams.bottomMargin = 20;
        addView(this.imgPhone, layoutParams);
        TextView textView = new TextView(this.context);
        this.tvToast = textView;
        if (i3 == 1) {
            textView.setText(this.context.getResources().getString(R.string.gix));
        } else {
            textView.setText(this.context.getResources().getString(R.string.giy));
        }
        this.tvToast.setTextColor(-1);
        this.tvToast.setTextSize(14.0f);
        addView(this.tvToast, new LinearLayout.LayoutParams(-2, -2));
        this.imgPhone.setRotationY(0.0f);
        this.imgPhone.setTranslationX(0.0f);
        startTimer();
    }

    public PanoramaGuideAnimate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentRotate = 0.0f;
        this.currentTranslation = 0.0f;
        this.currentOrientation = 0;
        this.alpha = 1.0f;
        this.handler = new Handler() { // from class: cooperation.qzone.panorama.widget.PanoramaGuideAnimate.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i3 = message.what;
                if (i3 == 291) {
                    PanoramaGuideAnimate.this.imgPhone.setRotationY(PanoramaGuideAnimate.this.currentRotate);
                    PanoramaGuideAnimate.this.imgPhone.setTranslationX(PanoramaGuideAnimate.this.currentTranslation);
                    return;
                }
                if (i3 != 292) {
                    return;
                }
                if (PanoramaGuideAnimate.this.alpha <= 0.0f) {
                    if (PanoramaGuideAnimate.this.onAnimateListener != null) {
                        PanoramaGuideAnimate.this.onAnimateListener.onAnimateComplete();
                    }
                } else {
                    PanoramaGuideAnimate.this.alpha -= 0.05f;
                    PanoramaGuideAnimate panoramaGuideAnimate = PanoramaGuideAnimate.this;
                    panoramaGuideAnimate.setAlpha(panoramaGuideAnimate.alpha);
                    PanoramaGuideAnimate.this.handler.sendEmptyMessage(292);
                }
            }
        };
        init(context);
    }
}
