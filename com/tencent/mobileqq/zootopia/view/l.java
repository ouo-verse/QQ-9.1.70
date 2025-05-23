package com.tencent.mobileqq.zootopia.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.common.app.AppInterface;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001FB\u000f\u0012\u0006\u0010C\u001a\u00020\u001f\u00a2\u0006\u0004\bD\u0010EJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010\t\u001a\u00020\u0007J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0015\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010*R\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010-R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00100R\u0016\u0010B\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00100\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/l;", "Lcom/tencent/mobileqq/armap/e;", "Landroid/view/View$OnTouchListener;", "Landroid/widget/ImageView;", "headView", "", "uin", "", "p", "j", "peerUin", "peerNickName", "", "isGroup", "", "roomId", "k", "f", "headPath", "Landroid/graphics/Bitmap;", "head", tl.h.F, "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "onTouch", "", "orientation", "g", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "d", "Lmqq/util/WeakReference;", "mWeakActivity", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mInvitingNotification", "Landroid/widget/ImageView;", "mHeadImg", "Lcom/tencent/mobileqq/armap/f;", "Lcom/tencent/mobileqq/armap/f;", "mFaceDecoder", "i", "Z", "mIsShowed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mTouchSlop", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "mStartX", "D", "mStartY", "E", "J", "mDownTime", "mScrollStarted", "Landroid/view/WindowManager$LayoutParams;", "G", "Landroid/view/WindowManager$LayoutParams;", "mLayoutParam", "H", "mLandTopMarginInit", "mPortraitTopMarginInit", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l implements com.tencent.mobileqq.armap.e, View.OnTouchListener {

    /* renamed from: C, reason: from kotlin metadata */
    private float mStartX;

    /* renamed from: D, reason: from kotlin metadata */
    private float mStartY;

    /* renamed from: E, reason: from kotlin metadata */
    private long mDownTime;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mScrollStarted;

    /* renamed from: G, reason: from kotlin metadata */
    private WindowManager.LayoutParams mLayoutParam;

    /* renamed from: H, reason: from kotlin metadata */
    private int mLandTopMarginInit;

    /* renamed from: I, reason: from kotlin metadata */
    private int mPortraitTopMarginInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Activity> mWeakActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mInvitingNotification;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mHeadImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.armap.f mFaceDecoder;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    public l(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mWeakActivity = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(l this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mHeadImg;
        if (imageView != null) {
            Activity activity = this$0.mWeakActivity.get();
            imageView.setImageDrawable(new BitmapDrawable(activity != null ? activity.getResources() : null, bitmap));
        }
    }

    private final void p(ImageView headView, String uin) {
        if (this.mFaceDecoder == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null) {
                com.tencent.mobileqq.armap.f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(appInterface.getApplicationContext(), 1);
                this.mFaceDecoder = nonMainAppHeadLoader;
                if (nonMainAppHeadLoader != null) {
                    nonMainAppHeadLoader.init();
                }
                com.tencent.mobileqq.armap.f fVar = this.mFaceDecoder;
                if (fVar != null) {
                    fVar.a(this);
                }
            }
        }
        com.tencent.mobileqq.armap.f fVar2 = this.mFaceDecoder;
        Bitmap d16 = fVar2 != null ? fVar2.d(uin, true, null) : null;
        if (headView != null) {
            Activity activity = this.mWeakActivity.get();
            Resources resources = activity != null ? activity.getResources() : null;
            if (d16 == null) {
                d16 = BaseImageUtil.getDefaultFaceBitmap();
            }
            headView.setImageDrawable(new BitmapDrawable(resources, d16));
        }
    }

    public final void g(int orientation) {
        WindowManager windowManager;
        WindowManager.LayoutParams layoutParams = this.mLayoutParam;
        if (layoutParams == null || this.mInvitingNotification == null || !this.mIsShowed) {
            return;
        }
        if (orientation != 1) {
            if (orientation == 2 && layoutParams != null) {
                layoutParams.y = this.mLandTopMarginInit;
            }
        } else if (layoutParams != null) {
            layoutParams.y = this.mPortraitTopMarginInit;
        }
        Activity activity = this.mWeakActivity.get();
        if (activity == null || (windowManager = activity.getWindowManager()) == null) {
            return;
        }
        windowManager.updateViewLayout(this.mInvitingNotification, this.mLayoutParam);
    }

    @Override // com.tencent.mobileqq.armap.e
    public void h(String uin, String headPath, final Bitmap head) {
        Activity activity;
        Activity activity2 = this.mWeakActivity.get();
        boolean z16 = false;
        if (activity2 != null && !activity2.isDestroyed()) {
            z16 = true;
        }
        if (z16 && (activity = this.mWeakActivity.get()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    l.i(l.this, head);
                }
            });
        }
    }

    public final void j() {
        com.tencent.mobileqq.armap.f fVar = this.mFaceDecoder;
        if (fVar != null) {
            fVar.f(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.mStartX = event.getRawX();
            this.mStartY = event.getRawY();
            this.mDownTime = System.currentTimeMillis();
            this.mScrollStarted = false;
            QLog.d("ZootopiaAudioCallInvitingNotification", 1, "ACTION_DOWN " + this.mStartY);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mScrollStarted) {
                    this.mScrollStarted = this.mStartY - event.getRawY() > ((float) this.mTouchSlop);
                }
                QLog.d("ZootopiaAudioCallInvitingNotification", 1, "ACTION_MOVE " + (event.getRawX() - this.mStartX) + " " + (event.getRawY() - this.mStartY) + " " + this.mScrollStarted);
            }
        } else {
            if (this.mScrollStarted) {
                this.mScrollStarted = false;
                QLog.d("ZootopiaAudioCallInvitingNotification", 1, "ACTION_UP " + (event.getRawY() - this.mStartY));
                if (event.getRawY() - this.mStartY < -100.0f) {
                    f();
                }
                return true;
            }
            this.mScrollStarted = false;
            QLog.d("ZootopiaAudioCallInvitingNotification", 1, "ACTION_UP");
            if (System.currentTimeMillis() - this.mDownTime > 200) {
                return true;
            }
        }
        return this.mScrollStarted;
    }

    public final void f() {
        WindowManager windowManager;
        this.mIsShowed = false;
        if (this.mInvitingNotification != null) {
            Activity activity = this.mWeakActivity.get();
            if (activity != null && (windowManager = activity.getWindowManager()) != null) {
                windowManager.removeView(this.mInvitingNotification);
            }
            this.mInvitingNotification = null;
        }
        QLog.d("ZootopiaAudioCallInvitingNotification", 1, "hideInvitingNotification");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(l this$0, Ref.IntRef fromType, long j3, final boolean z16, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fromType, "$fromType");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.k
            @Override // java.lang.Runnable
            public final void run() {
                l.m(z16);
            }
        }, 16, null, true);
        this$0.f();
        DataReport.T(null, "dc00898", "", "", "0X800C26E", "0X800C26E", fromType.element, 0, "", "", "", String.valueOf(j3));
        QLog.d("ZootopiaAudioCallInvitingNotification", 1, "btn_audio_call_accept");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(boolean z16) {
        if (z16) {
            ZplanAVControllerForQAV.INSTANCE.a();
        } else {
            ZplanAVControllerForQAV.INSTANCE.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(boolean z16, l this$0, Ref.IntRef fromType, long j3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fromType, "$fromType");
        if (z16) {
            ZplanAVControllerForQAV.INSTANCE.x();
        } else {
            ZplanAVControllerForQAV.INSTANCE.y();
        }
        this$0.f();
        DataReport.T(null, "dc00898", "", "", "0X800C270", "0X800C270", fromType.element, 0, "", "", "", String.valueOf(j3));
        QLog.d("ZootopiaAudioCallInvitingNotification", 1, "btn_audio_call_reject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(l this$0, Ref.IntRef fromType, long j3, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fromType, "$fromType");
        if (this$0.mWeakActivity.get() instanceof ZootopiaUEActivity) {
            Activity activity = this$0.mWeakActivity.get();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.ZootopiaUEActivity");
            str = ((ZootopiaUEActivity) activity).n3();
        } else {
            str = "";
        }
        ZplanAVControllerForQAV.INSTANCE.c(str);
        this$0.f();
        DataReport.T(null, "dc00898", "", "", "0X800C271", "0X800C271", fromType.element, 0, "", "", "", String.valueOf(j3));
        QLog.d("ZootopiaAudioCallInvitingNotification", 1, "backToActivity");
    }

    public final void k(String peerUin, String peerNickName, final boolean isGroup, final long roomId) {
        WindowManager windowManager;
        Resources resources;
        Configuration configuration;
        Resources resources2;
        DisplayMetrics displayMetrics;
        Resources resources3;
        DisplayMetrics displayMetrics2;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(peerNickName, "peerNickName");
        if (this.mIsShowed) {
            return;
        }
        this.mIsShowed = true;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        if (isGroup) {
            intRef.element = 2;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -2;
        layoutParams.height = UIUtil.dp2px(this.mWeakActivity.get(), 80.0f);
        layoutParams.flags = 40;
        layoutParams.format = -3;
        Activity activity = this.mWeakActivity.get();
        int i3 = 0;
        int i16 = (activity == null || (resources3 = activity.getResources()) == null || (displayMetrics2 = resources3.getDisplayMetrics()) == null) ? 0 : displayMetrics2.widthPixels;
        Activity activity2 = this.mWeakActivity.get();
        if (activity2 != null && (resources2 = activity2.getResources()) != null && (displayMetrics = resources2.getDisplayMetrics()) != null) {
            i3 = displayMetrics.heightPixels;
        }
        Activity activity3 = this.mWeakActivity.get();
        Integer valueOf = (activity3 == null || (resources = activity3.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        if (valueOf != null && valueOf.intValue() == 2) {
            this.mLandTopMarginInit = ((layoutParams.height / 2) + UIUtil.dp2px(this.mWeakActivity.get(), 46.5f)) - (i3 / 2);
            this.mPortraitTopMarginInit = ((layoutParams.height / 2) + UIUtil.dp2px(this.mWeakActivity.get(), 46.5f)) - (i16 / 2);
            layoutParams.y = this.mLandTopMarginInit;
        } else {
            this.mPortraitTopMarginInit = ((layoutParams.height / 2) + UIUtil.dp2px(this.mWeakActivity.get(), 46.5f)) - (i3 / 2);
            this.mLandTopMarginInit = ((layoutParams.height / 2) + UIUtil.dp2px(this.mWeakActivity.get(), 46.5f)) - (i16 / 2);
            layoutParams.y = this.mPortraitTopMarginInit;
        }
        layoutParams.windowAnimations = R.style.f243340j;
        this.mLayoutParam = layoutParams;
        if (this.mInvitingNotification == null) {
            View inflate = LayoutInflater.from(this.mWeakActivity.get()).inflate(R.layout.f167419d73, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            this.mInvitingNotification = (RelativeLayout) inflate;
        }
        RelativeLayout relativeLayout = this.mInvitingNotification;
        ImageView imageView = relativeLayout != null ? (ImageView) relativeLayout.findViewById(R.id.q1q) : null;
        this.mHeadImg = imageView;
        p(imageView, peerUin);
        RelativeLayout relativeLayout2 = this.mInvitingNotification;
        TextView textView = relativeLayout2 != null ? (TextView) relativeLayout2.findViewById(R.id.qun) : null;
        if (textView != null) {
            textView.setText(peerNickName);
        }
        RelativeLayout relativeLayout3 = this.mInvitingNotification;
        Button button = relativeLayout3 != null ? (Button) relativeLayout3.findViewById(R.id.pf9) : null;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.l(l.this, intRef, roomId, isGroup, view);
                }
            });
        }
        RelativeLayout relativeLayout4 = this.mInvitingNotification;
        Button button2 = relativeLayout4 != null ? (Button) relativeLayout4.findViewById(R.id.pf_) : null;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.n(isGroup, this, intRef, roomId, view);
                }
            });
        }
        RelativeLayout relativeLayout5 = this.mInvitingNotification;
        if (relativeLayout5 != null) {
            relativeLayout5.setOnTouchListener(this);
        }
        RelativeLayout relativeLayout6 = this.mInvitingNotification;
        if (relativeLayout6 != null) {
            relativeLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.o(l.this, intRef, roomId, view);
                }
            });
        }
        Activity activity4 = this.mWeakActivity.get();
        if (activity4 != null && (windowManager = activity4.getWindowManager()) != null) {
            windowManager.addView(this.mInvitingNotification, this.mLayoutParam);
        }
        DataReport.T(null, "dc00898", "", "", "0X800C26C", "0X800C26C", intRef.element, 0, "", "", "", String.valueOf(roomId));
    }
}
