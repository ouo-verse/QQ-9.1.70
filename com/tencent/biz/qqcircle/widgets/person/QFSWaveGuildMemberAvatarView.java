package com.tencent.biz.qqcircle.widgets.person;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSWaveGuildMemberAvatarView extends QCircleBaseWidgetView {
    private final List<a> C;
    private Interpolator D;
    private Paint E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L;
    private QCircleRoundImageView M;
    private Runnable N;

    /* renamed from: d, reason: collision with root package name */
    private float f93728d;

    /* renamed from: e, reason: collision with root package name */
    private long f93729e;

    /* renamed from: f, reason: collision with root package name */
    private int f93730f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93731h;

    /* renamed from: i, reason: collision with root package name */
    private long f93732i;

    /* renamed from: m, reason: collision with root package name */
    private long f93733m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public @interface IUserAvatarSizeType {
        public static final int AVATAR_SIZE_BIG = 1;
        public static final int AVATAR_SIZE_NOMAL = 0;
        public static final int AVATAR_SIZE_ORIG = 2;
        public static final int AVATAR_SIZE_SMALL = 3;
        public static final int AVATAR_SIZE_VERY_SMALL = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f93734a = System.currentTimeMillis();

        /* renamed from: b, reason: collision with root package name */
        private float f93735b;

        /* renamed from: c, reason: collision with root package name */
        private float f93736c;

        /* renamed from: d, reason: collision with root package name */
        private float f93737d;

        a() {
            if (QFSWaveGuildMemberAvatarView.this.L > 0) {
                QFSWaveGuildMemberAvatarView.this.f93728d = (QFSWaveGuildMemberAvatarView.this.L >> 1) * 1.0f;
                this.f93735b = QFSWaveGuildMemberAvatarView.this.f93728d * QFSWaveGuildMemberAvatarView.this.F;
                this.f93736c = QFSWaveGuildMemberAvatarView.this.f93728d * QFSWaveGuildMemberAvatarView.this.G;
                this.f93737d = QFSWaveGuildMemberAvatarView.this.f93728d * 2.0f * QFSWaveGuildMemberAvatarView.this.H;
            }
            f();
        }

        private void f() {
            if (QFSWaveGuildMemberAvatarView.this.I >= 10.0f && QFSWaveGuildMemberAvatarView.this.I < 65.0f) {
                float f16 = QFSWaveGuildMemberAvatarView.this.I / 65.0f;
                if (f16 >= QFSWaveGuildMemberAvatarView.this.J) {
                    this.f93735b *= f16;
                    this.f93736c *= f16;
                    return;
                } else {
                    this.f93735b *= QFSWaveGuildMemberAvatarView.this.J;
                    this.f93736c *= QFSWaveGuildMemberAvatarView.this.J;
                    return;
                }
            }
            if (QFSWaveGuildMemberAvatarView.this.I > 65.0f) {
                float f17 = QFSWaveGuildMemberAvatarView.this.I / 65.0f;
                if (f17 > QFSWaveGuildMemberAvatarView.this.K) {
                    f17 = QFSWaveGuildMemberAvatarView.this.K;
                }
                this.f93736c *= f17;
                this.f93737d *= f17;
            }
        }

        int c() {
            return (int) ((1.5f - QFSWaveGuildMemberAvatarView.this.D.getInterpolation((((float) (System.currentTimeMillis() - this.f93734a)) * 1.0f) / ((float) QFSWaveGuildMemberAvatarView.this.f93729e))) * 255.0f);
        }

        float d() {
            return this.f93735b + (QFSWaveGuildMemberAvatarView.this.D.getInterpolation((((float) (System.currentTimeMillis() - this.f93734a)) * 1.0f) / ((float) QFSWaveGuildMemberAvatarView.this.f93729e)) * (this.f93736c - this.f93735b));
        }

        int e() {
            return (int) (this.f93737d - (QFSWaveGuildMemberAvatarView.this.D.getInterpolation((((float) (System.currentTimeMillis() - this.f93734a)) * 1.0f) / ((float) QFSWaveGuildMemberAvatarView.this.f93729e)) * this.f93737d));
        }
    }

    public QFSWaveGuildMemberAvatarView(Context context) {
        this(context, null);
    }

    private void C0(View view) {
        QCircleRoundImageView qCircleRoundImageView = (QCircleRoundImageView) view.findViewById(R.id.x4e);
        this.M = qCircleRoundImageView;
        qCircleRoundImageView.setRoundRect(DisplayUtil.getScreenHeight() / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f93732i < this.f93730f) {
            return;
        }
        this.C.add(new a());
        this.f93732i = currentTimeMillis;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gty;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        View childAt = getChildAt(0);
        if (childAt != null && this.f93728d != 0.0f) {
            int width = childAt.getWidth() / 2;
            int height = childAt.getHeight() / 2;
            int left = width + childAt.getLeft();
            int top = height + childAt.getTop();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<a> it = this.C.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                a next = it.next();
                float d16 = next.d();
                int e16 = next.e();
                float f16 = e16;
                i3 = Math.max(i3, (int) (next.f93736c + f16 + 0.5d));
                Iterator<a> it5 = it;
                if (currentTimeMillis - next.f93734a <= this.f93729e) {
                    float f17 = e16 >> 1;
                    float f18 = d16 + f17;
                    if (f18 > this.f93728d) {
                        this.E.setStrokeJoin(Paint.Join.ROUND);
                        this.E.setStrokeCap(Paint.Cap.ROUND);
                        this.E.setStyle(Paint.Style.STROKE);
                        this.E.setStrokeWidth(f16);
                        this.E.setAlpha(next.c());
                        float f19 = (int) (d16 - f17);
                        float f26 = this.f93728d;
                        if (f19 < f26) {
                            d16 = (r0 >> 1) + f26;
                            this.E.setStrokeWidth((int) (f18 - f26));
                        }
                        canvas.drawCircle(left, top, d16, this.E);
                    }
                } else {
                    it5.remove();
                }
                it = it5;
            }
            if (this.C.size() > 0) {
                postInvalidateDelayed(30L, left - i3, top - i3, left + i3, i3 + top);
            } else {
                this.f93731h = false;
            }
        }
    }

    public void setAvatarMeta(String str, String str2, String str3) {
        ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByTinyIdAndAvatarMeta(str, str2, str3, 3, this.M);
    }

    public void setColor(int i3) {
        Paint paint = this.E;
        if (paint == null) {
            return;
        }
        paint.setColor(i3);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.D = interpolator;
        if (interpolator == null) {
            this.D = new LinearInterpolator();
        }
    }

    public void setVolume(float f16) {
        this.I = f16;
        this.f93733m = System.currentTimeMillis();
        start();
    }

    public void start() {
        Runnable runnable = this.N;
        if (runnable != null && !this.f93731h) {
            this.f93731h = true;
            runnable.run();
            invalidate();
        }
    }

    public void stop() {
        this.f93731h = false;
    }

    public QFSWaveGuildMemberAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSWaveGuildMemberAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93729e = 1000L;
        this.f93730f = TbsListener.ErrorCode.STATIC_TBS_INSTALL_TMP_RENAME_ERR;
        this.C = new ArrayList();
        this.D = new DecelerateInterpolator();
        this.E = new Paint(1);
        this.F = 0.85f;
        this.G = 1.62f;
        this.H = 0.2f;
        this.I = 0.0f;
        this.J = 0.8f;
        this.K = 1.0f;
        this.L = cx.a(33.0f);
        this.N = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.person.QFSWaveGuildMemberAvatarView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFSWaveGuildMemberAvatarView.this.I < 10.0f || System.currentTimeMillis() - QFSWaveGuildMemberAvatarView.this.f93733m > QFSWaveGuildMemberAvatarView.this.f93730f) {
                    QFSWaveGuildMemberAvatarView.this.f93731h = false;
                } else if (QFSWaveGuildMemberAvatarView.this.f93731h) {
                    QFSWaveGuildMemberAvatarView.this.D0();
                    QFSWaveGuildMemberAvatarView qFSWaveGuildMemberAvatarView = QFSWaveGuildMemberAvatarView.this;
                    qFSWaveGuildMemberAvatarView.postDelayed(qFSWaveGuildMemberAvatarView.N, QFSWaveGuildMemberAvatarView.this.f93730f);
                }
            }
        };
        setWillNotDraw(false);
        C0(this);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
