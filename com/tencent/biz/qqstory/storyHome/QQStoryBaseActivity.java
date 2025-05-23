package com.tencent.biz.qqstory.storyHome;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.model.i;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQStoryBaseActivity extends IphoneTitleBarActivity implements IEventReceiver {
    private static final int M_COUNT = 4;
    private static final int M_startActivity = 0;
    private static final int M_startActivityForResult = 2;
    private static final int M_startActivityForResult_opt = 3;
    private static final int M_startActivity_opt = 1;
    public AppInterface mApp;
    protected Dialog mLoadingDialog;
    protected ProgressView mLoadingView;
    public final String TAG = "Q.qqstory.QQStoryBaseActivity";
    protected final boolean DEBUG = false;
    protected int animationTimes = 0;
    protected boolean needImageAnimation = true;
    protected int[] mAnimationArgs = null;
    protected Bitmap mOriginViewBitmap = null;
    protected ImageView mMaskImageView = null;
    protected boolean mValidate = false;
    protected Map<Subscriber, String> mActors = new HashMap();
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    protected int mAnimationPlayedTimes = 0;
    Animation.AnimationListener listener = new a();
    private long[] mLastStartActTime = new long[4];

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b implements Dispatcher.Command {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements Subscriber {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QQStoryBaseActivity> f94221d;

        public c(QQStoryBaseActivity qQStoryBaseActivity) {
            this.f94221d = new WeakReference<>(qQStoryBaseActivity);
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> list) {
            list.add(b.class);
        }

        @Override // com.tribe.async.dispatch.Subscriber
        public void handleDispatch(@NonNull Dispatcher.Dispatchable dispatchable) {
            QQStoryBaseActivity qQStoryBaseActivity = this.f94221d.get();
            if (qQStoryBaseActivity != null) {
                qQStoryBaseActivity.onOutOfMemory();
            }
        }
    }

    private void initAnimation(Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("positionX", 0);
        int intExtra2 = intent.getIntExtra("positionY", 0);
        int intExtra3 = intent.getIntExtra("viewWidth", -1);
        int intExtra4 = intent.getIntExtra("viewHeight", -1);
        this.needImageAnimation = intent.getBooleanExtra("need_image_animation", true);
        String stringExtra = intent.getStringExtra("viewImageKey");
        if (intExtra3 >= 0 && intExtra4 >= 0) {
            this.mAnimationArgs = r5;
            int[] iArr = {intExtra, intExtra2, intExtra3, intExtra4};
            if (!TextUtils.isEmpty(stringExtra)) {
                com.tencent.biz.qqstory.base.b bVar = (com.tencent.biz.qqstory.base.b) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQSTORY_MANAGER);
                SoftReference<Bitmap> softReference = bVar.f93991i.get(stringExtra);
                if (softReference != null && softReference.get() != null) {
                    this.mOriginViewBitmap = softReference.get();
                    bVar.f93991i.remove(stringExtra);
                }
            }
        }
    }

    private boolean isTooFastOpenActivity(int i3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long[] jArr = this.mLastStartActTime;
        long j3 = elapsedRealtime - jArr[i3];
        if (j3 < 1000) {
            hd0.c.v("Q.qqstory.QQStoryBaseActivity", "startActivity fail, open twice take time:%d", Long.valueOf(j3));
            return true;
        }
        jArr[i3] = SystemClock.elapsedRealtime();
        return false;
    }

    public <T extends View> T $(int i3) {
        return (T) findViewById(i3);
    }

    public <T extends ViewGroup.LayoutParams> T $lp(View view) {
        return (T) view.getLayoutParams();
    }

    public void dismissLoadingDialog() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new Runnable() { // from class: com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.2
            @Override // java.lang.Runnable
            public void run() {
                Dialog dialog = QQStoryBaseActivity.this.mLoadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void doEnterAnimation() {
        int[] iArr;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_STORY_PGC, 2, "QQStoryBaseActivity doEnterAnimation mAnimationPlayedTimes=" + this.mAnimationPlayedTimes);
        }
        int i16 = this.animationTimes;
        this.animationTimes = i16 + 1;
        if (i16 <= 0 && (iArr = this.mAnimationArgs) != null && iArr.length >= 4 && (i3 = this.mAnimationPlayedTimes) <= 0) {
            this.mAnimationPlayedTimes = i3 + 1;
            int i17 = iArr[0];
            int i18 = iArr[1];
            int i19 = iArr[2];
            int i26 = iArr[3];
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
            if (this.mOriginViewBitmap != null && this.needImageAnimation) {
                ImageView imageView = new ImageView(this);
                this.mMaskImageView = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                viewGroup.addView(this.mMaskImageView, new FrameLayout.LayoutParams(-1, -1));
                this.mMaskImageView.setImageBitmap(this.mOriginViewBitmap);
            }
            float measuredHeight = (i26 * 1.0f) / viewGroup.getMeasuredHeight();
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setInterpolator(new DecelerateInterpolator());
            animationSet.setRepeatMode(1);
            animationSet.setRepeatCount(0);
            animationSet.setDuration(100L);
            animationSet.addAnimation(new ScaleAnimation((i19 * 1.0f) / viewGroup.getMeasuredWidth(), 1.0f, measuredHeight, 1.0f, 0.5f, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(i17, 0.0f, i18, 0.0f));
            if (this.mOriginViewBitmap != null && this.mMaskImageView != null && this.needImageAnimation) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setInterpolator(new DecelerateInterpolator());
                alphaAnimation.setRepeatMode(1);
                alphaAnimation.setRepeatCount(0);
                alphaAnimation.setDuration(100L);
                this.mMaskImageView.startAnimation(alphaAnimation);
                viewGroup.startAnimation(animationSet);
                alphaAnimation.setAnimationListener(this.listener);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_STORY_PGC, 2, "QQStoryBaseActivity doEnterAnimation animationSet start with origin view");
                    return;
                }
                return;
            }
            viewGroup.startAnimation(animationSet);
            animationSet.setAnimationListener(this.listener);
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_STORY_PGC, 2, "QQStoryBaseActivity doEnterAnimation animationSet start without origin view");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        logV("onActivityResult");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        QQStoryContext.h();
        HashMap hashMap = new HashMap();
        onCreateSubscribers(hashMap);
        this.mActors.clear();
        this.mActors.putAll(hashMap);
        logD("register subscriber size : " + this.mActors.size());
        for (Map.Entry<Subscriber, String> entry : this.mActors.entrySet()) {
            com.tencent.biz.qqstory.base.c.a().registerSubscriber(entry.getValue(), entry.getKey());
        }
        super.doOnCreate(bundle);
        logV("onCreate");
        this.mValidate = true;
        QQStoryContext.h();
        this.mApp = QQStoryContext.a();
        ((TrimmableManager) i.c(26)).c(0);
        initAnimation(getIntent());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        logV(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mValidate = false;
        logD("unregister subscriber size : " + this.mActors.size());
        Iterator<Map.Entry<Subscriber, String>> it = this.mActors.entrySet().iterator();
        while (it.hasNext()) {
            com.tencent.biz.qqstory.base.c.a().unRegisterSubscriber(it.next().getKey());
        }
        Bitmap bitmap = this.mOriginViewBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mOriginViewBitmap.recycle();
            this.mOriginViewBitmap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        id0.a.q(id0.a.f(getClass(), 0), this.currentActivityStayTime, getActivityName());
        logV(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        logV("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        logV("onStart");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        logV(DKHippyEvent.EVENT_STOP);
        this.mHandler.removeCallbacks(null);
    }

    public boolean isMainLooper() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        if (this.mValidate && !isFinishing()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void onCreateSubscribers(@NonNull Map<Subscriber, String> map) {
        map.put(new Subscriber.SubscriberWrapper(Looper.getMainLooper(), new c(this)), Dispatcher.ROOT_GROUP_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onOutOfMemory() {
        hd0.c.a("Q.qqstory.QQStoryBaseActivity", "onOutOfMemory");
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(str);
        this.rightViewText.setEnabled(true);
        if (onClickListener != null) {
            this.rightViewText.setOnClickListener(onClickListener);
        }
        if (AppSetting.f99565y) {
            this.rightViewText.setContentDescription(((Object) this.rightViewText.getText()) + HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.r4e));
        }
    }

    public void setRightButtonWithImage(int i3, String str, View.OnClickListener onClickListener) {
        this.rightViewText.setVisibility(8);
        this.rightViewImg.setVisibility(0);
        this.rightViewImg.setImageResource(i3);
        this.rightViewImg.setContentDescription(str);
        this.rightViewImg.setOnClickListener(onClickListener);
    }

    public void showLoadingDialog(int i3) {
        showLoadingDialog(getString(i3), true, 0L);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (isTooFastOpenActivity(0)) {
            return;
        }
        super.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3) {
        if (isTooFastOpenActivity(2)) {
            return;
        }
        super.startActivityForResult(intent, i3);
    }

    public void startActivityForResultDirectly(Intent intent, int i3) {
        super.startActivityForResult(intent, i3, null);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class ProgressView extends FrameLayout {

        /* renamed from: d, reason: collision with root package name */
        private ProgressBar f94218d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f94219e;

        public ProgressView(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.baj, this);
            this.f94218d = (ProgressBar) findViewById(com.tencent.mobileqq.R.id.g1f);
            this.f94219e = (TextView) findViewById(com.tencent.mobileqq.R.id.jfb);
        }

        public void b(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 0) {
                this.f94219e.setVisibility(0);
                this.f94219e.setText(charSequence);
            } else {
                this.f94219e.setVisibility(8);
            }
        }

        public ProgressView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            a(context);
        }
    }

    public <T extends View> T $(View view, int i3) {
        return (T) view.findViewById(i3);
    }

    public void showLoadingDialog(CharSequence charSequence) {
        showLoadingDialog(charSequence, true, 0L);
    }

    public void showLoadingDialog(CharSequence charSequence, boolean z16) {
        showLoadingDialog(charSequence, z16, 0L);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        if (isTooFastOpenActivity(1)) {
            return;
        }
        super.startActivity(intent, bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i3, Bundle bundle) {
        if (isTooFastOpenActivity(3)) {
            return;
        }
        super.startActivityForResult(intent, i3, bundle);
    }

    public void showLoadingDialog(CharSequence charSequence, boolean z16, long j3) {
        showLoadingDialog(charSequence, z16, j3, null);
    }

    public void showLoadingDialog(final CharSequence charSequence, final boolean z16, long j3, final DialogInterface.OnDismissListener onDismissListener) {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (QQStoryBaseActivity.this.isFinishing()) {
                    hd0.c.t("Q.qqstory.QQStoryBaseActivity", "Activity has been destroy.");
                    return;
                }
                QQStoryBaseActivity qQStoryBaseActivity = QQStoryBaseActivity.this;
                Dialog dialog = qQStoryBaseActivity.mLoadingDialog;
                if (dialog == null) {
                    qQStoryBaseActivity.mLoadingView = new ProgressView(this);
                    QQStoryBaseActivity.this.mLoadingDialog = new ReportDialog(this);
                    QQStoryBaseActivity.this.mLoadingDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    QQStoryBaseActivity.this.mLoadingDialog.setCanceledOnTouchOutside(false);
                    QQStoryBaseActivity.this.mLoadingDialog.requestWindowFeature(1);
                    QQStoryBaseActivity qQStoryBaseActivity2 = QQStoryBaseActivity.this;
                    qQStoryBaseActivity2.mLoadingDialog.setContentView(qQStoryBaseActivity2.mLoadingView);
                    QQStoryBaseActivity.this.mLoadingDialog.setOnDismissListener(onDismissListener);
                } else {
                    dialog.dismiss();
                }
                QQStoryBaseActivity.this.mLoadingDialog.setCancelable(z16);
                QQStoryBaseActivity.this.mLoadingView.b(charSequence);
                try {
                    QQStoryBaseActivity.this.mLoadingDialog.show();
                } catch (Exception e16) {
                    hd0.c.h("Q.qqstory.QQStoryBaseActivity", "mLoadingDialog show error", e16);
                }
            }
        }, j3);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ImageView imageView = QQStoryBaseActivity.this.mMaskImageView;
            if (imageView != null) {
                imageView.clearAnimation();
                ((ViewGroup) ((ViewGroup) QQStoryBaseActivity.this.findViewById(R.id.content)).getChildAt(0)).removeView(QQStoryBaseActivity.this.mMaskImageView);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    protected void logD(String str) {
    }

    protected void logV(String str) {
    }
}
