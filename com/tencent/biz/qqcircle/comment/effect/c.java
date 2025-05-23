package com.tencent.biz.qqcircle.comment.effect;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.biz.qqcircle.utils.QFSCommentSheetView;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;
import qqcircle.QQCircleEnvHub$KeywordHighlightInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class c implements a {
    private static final int F = -cx.a(53.0f);

    @NonNull
    protected final String C;

    @NonNull
    protected final List<AnimatorSet> D = new CopyOnWriteArrayList();
    protected boolean E;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    protected final QQCircleEnvHub$CommentActivityInfo f83571d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    protected final FrameLayout f83572e;

    /* renamed from: f, reason: collision with root package name */
    protected final RelativeLayout f83573f;

    /* renamed from: h, reason: collision with root package name */
    private View f83574h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f83575i;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    protected final String f83576m;

    public c(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull String str, @NonNull String str2) {
        this.f83571d = qQCircleEnvHub$CommentActivityInfo;
        this.f83572e = frameLayout;
        this.f83573f = relativeLayout;
        this.f83576m = str;
        this.C = str2;
        f();
    }

    private void d() {
        if (this.D.isEmpty()) {
            return;
        }
        Iterator<AnimatorSet> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        this.D.clear();
    }

    private void e() {
        VideoReport.setElementId(this.f83575i, QCircleDaTongConstant.ElementId.EM_XSJ_EMOJI_RAIN_ACTIVITY_ENTRANCE);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTIVITY_ID, this.f83571d.activityID.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_KEYWORD, getKeyword());
        VideoReport.setElementExposePolicy(this.f83575i, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(this.f83575i, buildElementParams);
        VideoReport.traversePage(this.f83575i);
    }

    private void f() {
        if (!h()) {
            return;
        }
        View findViewById = this.f83572e.findViewById(R.id.v7w);
        this.f83574h = findViewById;
        if (findViewById == null) {
            this.f83574h = ((ViewStub) this.f83572e.findViewById(R.id.u1j)).inflate();
        }
        this.f83574h.setTranslationY(F);
        this.f83575i = (ImageView) this.f83574h.findViewById(R.id.y2s);
        final ImageView imageView = (ImageView) this.f83574h.findViewById(R.id.dum);
        QFSHalfScreenFloatingView.a aVar = new QFSHalfScreenFloatingView.a() { // from class: com.tencent.biz.qqcircle.comment.effect.b
            @Override // com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView.a
            public final boolean onTouchEvent(MotionEvent motionEvent) {
                boolean g16;
                g16 = c.this.g(imageView, motionEvent);
                return g16;
            }
        };
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = (QFSHalfScreenFloatingView) this.f83572e.findViewById(R.id.f356412e);
        if (qFSHalfScreenFloatingView != null) {
            qFSHalfScreenFloatingView.setOutsideTouchEventListener(aVar);
        } else {
            QFSCommentSheetView qFSCommentSheetView = (QFSCommentSheetView) this.f83572e.findViewById(R.id.f47571xn);
            if (qFSCommentSheetView != null) {
                qFSCommentSheetView.setOutsideTouchEventListener(aVar);
            }
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(this.f83571d.entrancePicURL.get()).setTargetView(this.f83575i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean g(ImageView imageView, MotionEvent motionEvent) {
        boolean z16;
        if (this.f83574h.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && motionEvent.getAction() == 1) {
            Rect rect = new Rect();
            imageView.getGlobalVisibleRect(rect);
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                i(false);
                QLog.d("QFSBaseCommentEffect", 1, "close entrance");
                return true;
            }
            this.f83574h.getGlobalVisibleRect(rect);
            if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                QCircleSchemeLauncher.f(this.f83574h.getContext(), this.f83571d.jumpURL.get());
                return true;
            }
        }
        return false;
    }

    private boolean h() {
        return !TextUtils.isEmpty(this.f83571d.entrancePicURL.get());
    }

    private void j() {
        float[] fArr = {0.0f, 1.15f, 0.9f, 1.05f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f83574h, BasicAnimation.KeyPath.SCALE_X, fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f83574h, BasicAnimation.KeyPath.SCALE_Y, fArr);
        ofFloat.setDuration(600L);
        ofFloat2.setDuration(600L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f83574h, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat3.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.a
    public QQCircleEnvHub$KeywordHighlightInfo a() {
        return this.f83571d.keyWordHighLightInfo.get();
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.a
    public boolean b() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.a
    public String getKeyword() {
        for (String str : this.f83571d.keyWords.get()) {
            if (this.C.contains(str)) {
                return str;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(boolean z16) {
        int i3;
        if (!h()) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        this.f83574h.setVisibility(i3);
        if (z16) {
            Object drawable = this.f83575i.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
            j();
            e();
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.a
    public boolean isRunning() {
        return this.E;
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.a
    @CallSuper
    public void start() {
        this.E = true;
        d();
        QFSCommentEffectUtil.c(this.f83571d);
    }

    @Override // com.tencent.biz.qqcircle.comment.effect.a
    @CallSuper
    public void stop() {
        this.E = false;
        d();
    }
}
