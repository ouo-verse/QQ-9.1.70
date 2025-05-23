package com.tencent.mobileqq.qzoneplayer.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.component.animation.rebound.SimpleSpringListener;
import com.tencent.component.animation.rebound.Spring;
import com.tencent.component.animation.rebound.SpringConfig;
import com.tencent.component.animation.rebound.SpringSystem;

/* compiled from: P */
/* loaded from: classes35.dex */
public class SoundLines extends View implements Handler.Callback {
    public static final int MSG_REFRESH = 3;
    public static final int MSG_START_PLAY = 1;
    public static final int MSG_STOP_PLAY = 2;
    public static int REFRESH_RATE = 100;
    private static HandlerThread realTimeThread;
    private int TopValue;
    private float[] aData1;
    private float[] aData2;
    private float[] aData3;
    private float[] aData4;
    private int aindex;
    private Spring animation1;
    private Spring animation2;
    private Spring animation3;
    private Spring animation4;
    private int bindex;
    private int cindex;
    private final int defaultEndValue;
    private final int defaultLowValue;
    private final int defaultTopValue;
    private int dindex;
    private int height;
    private long lastUpdated;
    private Paint paint;
    private Handler realtimeHandler;
    private Rect rect1;
    private Rect rect2;
    private Rect rect3;
    private Rect rect4;
    private int rectGap;

    /* renamed from: va, reason: collision with root package name */
    private int f279899va;

    /* renamed from: vb, reason: collision with root package name */
    private int f279900vb;

    /* renamed from: vc, reason: collision with root package name */
    private int f279901vc;

    /* renamed from: vd, reason: collision with root package name */
    private int f279902vd;
    private int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends SimpleSpringListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f279903a;

        a(int i3) {
            this.f279903a = i3;
        }

        @Override // com.tencent.component.animation.rebound.SimpleSpringListener, com.tencent.component.animation.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            int currentValue = (int) spring.getCurrentValue();
            int i3 = this.f279903a;
            if (i3 == 1) {
                SoundLines.this.setRectHeight(i3, (int) ((currentValue / 100.0f) * r6.f279899va));
            } else if (i3 == 2) {
                SoundLines.this.setRectHeight(i3, (int) ((currentValue / 100.0f) * r6.f279900vb));
            } else if (i3 == 3) {
                SoundLines.this.setRectHeight(i3, (int) ((currentValue / 100.0f) * r6.f279901vc));
            } else {
                SoundLines.this.setRectHeight(i3, (int) ((currentValue / 100.0f) * r6.f279902vd));
            }
            if (currentValue == 100) {
                spring.setEndValue(40.0d);
                return;
            }
            if (currentValue == 40) {
                int i16 = this.f279903a;
                if (i16 == 1) {
                    SoundLines soundLines = SoundLines.this;
                    soundLines.f279899va = (int) (soundLines.aData1[SoundLines.this.aindex] * SoundLines.this.TopValue);
                    SoundLines.access$508(SoundLines.this);
                    if (SoundLines.this.aindex > 4) {
                        SoundLines.this.aindex = 0;
                    }
                } else if (i16 == 2) {
                    SoundLines soundLines2 = SoundLines.this;
                    soundLines2.f279900vb = (int) (soundLines2.aData2[SoundLines.this.bindex] * SoundLines.this.TopValue);
                    SoundLines.access$808(SoundLines.this);
                    if (SoundLines.this.bindex > 4) {
                        SoundLines.this.bindex = 0;
                    }
                } else if (i16 == 3) {
                    SoundLines soundLines3 = SoundLines.this;
                    soundLines3.f279901vc = (int) (soundLines3.aData3[SoundLines.this.cindex] * SoundLines.this.TopValue);
                    SoundLines.access$1008(SoundLines.this);
                    if (SoundLines.this.cindex > 4) {
                        SoundLines.this.cindex = 0;
                    }
                } else {
                    SoundLines soundLines4 = SoundLines.this;
                    soundLines4.f279902vd = (int) (soundLines4.aData4[SoundLines.this.dindex] * SoundLines.this.TopValue);
                    SoundLines.access$1208(SoundLines.this);
                    if (SoundLines.this.dindex > 4) {
                        SoundLines.this.dindex = 0;
                    }
                }
                spring.setEndValue(100.0d);
            }
        }
    }

    public SoundLines(Context context) {
        super(context);
        this.aData1 = new float[]{0.3f, 0.8f, 0.38f, 0.64f, 0.18f};
        this.aData2 = new float[]{0.4f, 0.8f, 0.39f, 0.91f, 0.46f};
        this.aData3 = new float[]{0.64f, 0.9f, 0.5f, 0.8f, 0.82f};
        this.aData4 = new float[]{0.46f, 1.0f, 0.4f, 0.8f, 0.4f};
        this.defaultEndValue = FeedVideoEnv.dpToPx(4.0f);
        this.defaultTopValue = 100;
        this.defaultLowValue = 40;
        init(context);
    }

    static /* synthetic */ int access$1008(SoundLines soundLines) {
        int i3 = soundLines.cindex;
        soundLines.cindex = i3 + 1;
        return i3;
    }

    static /* synthetic */ int access$1208(SoundLines soundLines) {
        int i3 = soundLines.dindex;
        soundLines.dindex = i3 + 1;
        return i3;
    }

    static /* synthetic */ int access$508(SoundLines soundLines) {
        int i3 = soundLines.aindex;
        soundLines.aindex = i3 + 1;
        return i3;
    }

    static /* synthetic */ int access$808(SoundLines soundLines) {
        int i3 = soundLines.bindex;
        soundLines.bindex = i3 + 1;
        return i3;
    }

    private Spring getSpring(int i3, int i16, int i17) {
        return SpringSystem.create().createSpring().setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(i16, i17)).addListener(new a(i3));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            Spring spring = getSpring(1, 79, 12);
            this.animation1 = spring;
            spring.setCurrentValue(40.0d);
            this.animation1.setEndValue(100.0d);
            Spring spring2 = getSpring(2, 80, 11);
            this.animation2 = spring2;
            spring2.setCurrentValue(40.0d);
            this.animation2.setEndValue(100.0d);
            Spring spring3 = getSpring(3, 79, 12);
            this.animation3 = spring3;
            spring3.setCurrentValue(40.0d);
            this.animation3.setEndValue(100.0d);
            Spring spring4 = getSpring(4, 80, 11);
            this.animation4 = spring4;
            spring4.setCurrentValue(40.0d);
            this.animation4.setEndValue(100.0d);
            return false;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                return false;
            }
            postInvalidate();
            return false;
        }
        Spring spring5 = this.animation1;
        if (spring5 == null || this.animation2 == null || this.animation3 == null || this.animation4 == null) {
            return false;
        }
        spring5.setCurrentValue(this.defaultEndValue);
        this.animation1.setEndValue(this.defaultEndValue);
        this.animation2.setCurrentValue(this.defaultEndValue);
        this.animation2.setEndValue(this.defaultEndValue);
        this.animation3.setCurrentValue(this.defaultEndValue);
        this.animation3.setEndValue(this.defaultEndValue);
        this.animation4.setCurrentValue(this.defaultEndValue);
        this.animation4.setEndValue(this.defaultEndValue);
        return false;
    }

    public void init(Context context) {
        if (realTimeThread == null) {
            realTimeThread = BaseVideoCoverUtils.getInstance().getCoverThread();
        }
        this.realtimeHandler = new Handler(realTimeThread.getLooper(), this);
        this.TopValue = FeedVideoEnv.dpToPx(15.0f);
        this.width = FeedVideoEnv.dpToPx(20.0f);
        this.height = FeedVideoEnv.dpToPx(13.0f);
        int dpToPx = FeedVideoEnv.dpToPx(3.0f);
        this.rectGap = FeedVideoEnv.dpToPx(1.0f);
        this.rect1 = new Rect(0, 0, dpToPx, this.height);
        this.rect2 = new Rect(0, 0, dpToPx, this.height);
        this.rect3 = new Rect(0, 0, dpToPx, this.height);
        this.rect4 = new Rect(0, 0, dpToPx, this.height);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-1);
        setBackgroundColor(0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        super.onDraw(canvas);
        Rect rect = this.rect1;
        if (rect == null || this.rect2 == null || this.rect3 == null || this.rect4 == null || (paint = this.paint) == null) {
            return;
        }
        canvas.drawRect(rect, paint);
        canvas.translate(this.rectGap + this.rect1.width(), 0.0f);
        canvas.drawRect(this.rect2, this.paint);
        canvas.translate(this.rectGap + this.rect2.width(), 0.0f);
        canvas.drawRect(this.rect3, this.paint);
        canvas.translate(this.rectGap + this.rect3.width(), 0.0f);
        canvas.drawRect(this.rect4, this.paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.width, this.height);
    }

    public void startPlaySound() {
        if (this.realtimeHandler.hasMessages(1)) {
            return;
        }
        this.realtimeHandler.sendEmptyMessage(1);
    }

    public void stopPlaySound() {
        this.realtimeHandler.sendEmptyMessage(2);
        this.realtimeHandler.removeMessages(1);
        this.realtimeHandler.removeMessages(3);
    }

    public SoundLines(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aData1 = new float[]{0.3f, 0.8f, 0.38f, 0.64f, 0.18f};
        this.aData2 = new float[]{0.4f, 0.8f, 0.39f, 0.91f, 0.46f};
        this.aData3 = new float[]{0.64f, 0.9f, 0.5f, 0.8f, 0.82f};
        this.aData4 = new float[]{0.46f, 1.0f, 0.4f, 0.8f, 0.4f};
        this.defaultEndValue = FeedVideoEnv.dpToPx(4.0f);
        this.defaultTopValue = 100;
        this.defaultLowValue = 40;
        init(context);
    }

    public void setRectHeight(int i3, int i16) {
        if (i3 == 1) {
            this.rect1.top = this.height - i16;
        } else if (i3 == 2) {
            this.rect2.top = this.height - i16;
        } else if (i3 == 3) {
            this.rect3.top = this.height - i16;
        } else if (i3 == 4) {
            this.rect4.top = this.height - i16;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastUpdated > REFRESH_RATE) {
            this.realtimeHandler.sendEmptyMessage(3);
            this.lastUpdated = currentTimeMillis;
        }
    }

    public SoundLines(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.aData1 = new float[]{0.3f, 0.8f, 0.38f, 0.64f, 0.18f};
        this.aData2 = new float[]{0.4f, 0.8f, 0.39f, 0.91f, 0.46f};
        this.aData3 = new float[]{0.64f, 0.9f, 0.5f, 0.8f, 0.82f};
        this.aData4 = new float[]{0.46f, 1.0f, 0.4f, 0.8f, 0.4f};
        this.defaultEndValue = FeedVideoEnv.dpToPx(4.0f);
        this.defaultTopValue = 100;
        this.defaultLowValue = 40;
        init(context);
    }
}
