package com.tencent.mobileqq.zootopia.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.ba;
import com.tencent.common.app.AppInterface;
import com.tencent.falco.utils.UIUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.proxy.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b6\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u0096\u0001\u0097\u0001B\u0012\u0012\u0007\u0010\u0092\u0001\u001a\u00020=\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0007J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$J&\u0010)\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010&\u001a\u0004\u0018\u00010\u00102\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u000e\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020$J\u0012\u0010.\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u00101\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u000100H\u0016J\u0012\u00102\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0012\u00103\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0006\u00105\u001a\u000204J\u000e\u00108\u001a\u0002072\u0006\u00106\u001a\u00020$J\u0016\u0010;\u001a\u00020$2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$R\u001e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010HR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u001c\u0010X\u001a\b\u0018\u00010UR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010`R\u0016\u0010d\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010VR\u0016\u0010f\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010VR\u0016\u0010h\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010cR\u0016\u0010j\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010QR\u0016\u0010l\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010`R\u0016\u0010n\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010`R\u0016\u0010p\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010`R\u0016\u0010r\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010`R\u0018\u0010u\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010`R\u0016\u0010y\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010`R\u0016\u0010{\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010`R\u0016\u0010}\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010`R\u0016\u0010\u007f\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010`R\u0018\u0010\u0081\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010`R\u0017\u0010\u0082\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010`R\u0019\u0010\u0085\u0001\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010VR\u0018\u0010\u0089\u0001\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010VR\u0018\u0010\u008b\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010`R\u0018\u0010\u008d\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010`R\u0018\u0010\u008f\u0001\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010VR\u0018\u0010\u0091\u0001\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010V\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/mobileqq/armap/e;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "", "f", "", ReportConstant.COSTREPORT_PREFIX, "u", "Landroid/os/Handler;", "i", "t", "r", "Landroid/widget/ImageView;", "headView", "", "uin", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "Landroid/view/View$OnClickListener;", "listener", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "isSpeaking", "y", "isWifi", "isBad", HippyTKDListViewAdapter.X, "", "status", "headPath", "Landroid/graphics/Bitmap;", "head", tl.h.F, "orientation", DomainData.DOMAIN_NAME, "Landroid/animation/Animator;", "animation", "onAnimationStart", "onAnimationEnd", "Landroid/animation/ValueAnimator;", "onAnimationUpdate", "onAnimationCancel", "onAnimationRepeat", "Landroid/graphics/Rect;", "k", "position", "Landroid/graphics/Point;", "j", "nEndX", "nEndY", "g", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "d", "Lmqq/util/WeakReference;", "weakActivity", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mFloatRootView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mAudioCallStatusText", "Landroid/widget/ImageView;", "mAudioCallStatusImg", "mSignalView", "mAudioCallNetStatusImg", "Landroid/view/WindowManager$LayoutParams;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/WindowManager$LayoutParams;", "mLayoutParam", "D", "Z", "mIsAddWindow", "E", "mTimerOn", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView$TimmerRunnable;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView$TimmerRunnable;", "mRunnable", "G", "Landroid/os/Handler;", "mHandler", "Lcom/tencent/mobileqq/armap/f;", "H", "Lcom/tencent/mobileqq/armap/f;", "mFaceDecoder", "I", "mTouchSlop", "", "J", "mMoveUpdateX", "K", "mMoveUpdateY", "L", "mDownTime", "M", "mScrollStarted", "N", "mPortraitLeftMarginInit", "P", "mPortraitTopMarginInit", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLandLeftMarginInit", BdhLogUtil.LogTag.Tag_Req, "mLandTopMarginInit", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Integer;", "mCurOrientation", "T", "mStatusBarHeight", "U", "mBottomBarHeight", "V", "mScreenWidth", "W", "mScreenHeight", "X", "mLeftOffsetX", "Y", "mTopOffsetY", "mAnimationEndPosition", "a0", "Landroid/animation/ValueAnimator;", "mPenUpAnimator", "b0", "mPenUpLeft", "c0", "mPenUpTop", "d0", "mMoveEndWidowX", "e0", "mMoveEndWidowY", "f0", "mDownStartX", "g0", "mDownStartY", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "h0", "a", "TimmerRunnable", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaAudioCallFloatView implements View.OnTouchListener, com.tencent.mobileqq.armap.e, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: C, reason: from kotlin metadata */
    private WindowManager.LayoutParams mLayoutParam;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsAddWindow;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mTimerOn;

    /* renamed from: F, reason: from kotlin metadata */
    private TimmerRunnable mRunnable;

    /* renamed from: G, reason: from kotlin metadata */
    private Handler mHandler;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.armap.f mFaceDecoder;

    /* renamed from: I, reason: from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: J, reason: from kotlin metadata */
    private float mMoveUpdateX;

    /* renamed from: K, reason: from kotlin metadata */
    private float mMoveUpdateY;

    /* renamed from: L, reason: from kotlin metadata */
    private long mDownTime;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mScrollStarted;

    /* renamed from: N, reason: from kotlin metadata */
    private int mPortraitLeftMarginInit;

    /* renamed from: P, reason: from kotlin metadata */
    private int mPortraitTopMarginInit;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mLandLeftMarginInit;

    /* renamed from: R, reason: from kotlin metadata */
    private int mLandTopMarginInit;

    /* renamed from: S, reason: from kotlin metadata */
    private Integer mCurOrientation;

    /* renamed from: T, reason: from kotlin metadata */
    private int mStatusBarHeight;

    /* renamed from: U, reason: from kotlin metadata */
    private int mBottomBarHeight;

    /* renamed from: V, reason: from kotlin metadata */
    private int mScreenWidth;

    /* renamed from: W, reason: from kotlin metadata */
    private int mScreenHeight;

    /* renamed from: X, reason: from kotlin metadata */
    private int mLeftOffsetX;

    /* renamed from: Y, reason: from kotlin metadata */
    private int mTopOffsetY;

    /* renamed from: Z, reason: from kotlin metadata */
    private int mAnimationEndPosition;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mPenUpAnimator;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private float mPenUpLeft;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float mPenUpTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Activity> weakActivity;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int mMoveEndWidowX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mFloatRootView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int mMoveEndWidowY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mAudioCallStatusText;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private float mDownStartX;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private float mDownStartY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mAudioCallStatusImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mSignalView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mAudioCallNetStatusImg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView$TimmerRunnable;", "Ljava/lang/Runnable;", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView;)V", TencentLocation.RUN_MODE, "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public final class TimmerRunnable implements Runnable {
        public TimmerRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ZootopiaAudioCallFloatView.this.mTimerOn) {
                long f16 = ZootopiaAudioCallFloatView.this.f();
                if (f16 != 0) {
                    String formatTime = ba.formatTime(f16);
                    TextView textView = ZootopiaAudioCallFloatView.this.mAudioCallStatusText;
                    if (textView != null) {
                        textView.setContentDescription(ba.getTimeDesc(formatTime));
                    }
                    TextView textView2 = ZootopiaAudioCallFloatView.this.mAudioCallStatusText;
                    if (textView2 != null) {
                        textView2.setText(formatTime);
                    }
                }
                Handler i3 = ZootopiaAudioCallFloatView.this.i();
                if (i3 != null) {
                    i3.postDelayed(this, 1000L);
                }
            }
        }
    }

    public ZootopiaAudioCallFloatView(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.weakActivity = new WeakReference<>(activity);
        this.mCurOrientation = 0;
        this.mAnimationEndPosition = 6;
        this.mPenUpLeft = -1.0f;
        this.mPenUpTop = -1.0f;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f() {
        a.Companion companion = com.tencent.mobileqq.zplan.proxy.a.INSTANCE;
        if (companion.a() == 0) {
            companion.c(SystemClock.elapsedRealtime());
            QLog.e("ZootopiaAudioCallFloatView", 1, "[getCurDuration] connectedTime is 0.");
        }
        return ((SystemClock.elapsedRealtime() - companion.a()) / 1000) + companion.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler i() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ZootopiaAudioCallFloatView this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.mAudioCallStatusImg;
        if (imageView != null) {
            Activity activity = this$0.weakActivity.get();
            imageView.setImageDrawable(new BitmapDrawable(activity != null ? activity.getResources() : null, bitmap));
        }
    }

    private final void r() {
        ImageView imageView = this.mSignalView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.mSignalView;
        Drawable drawable = imageView2 != null ? imageView2.getDrawable() : null;
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private final void s() {
        if (this.mTimerOn) {
            return;
        }
        QLog.d("ZootopiaAudioCallFloatView", 1, "startTimer");
        this.mTimerOn = true;
        if (this.mRunnable == null) {
            this.mRunnable = new TimmerRunnable();
        }
        Handler i3 = i();
        if (i3 != null) {
            TimmerRunnable timmerRunnable = this.mRunnable;
            Intrinsics.checkNotNull(timmerRunnable);
            i3.post(timmerRunnable);
        }
    }

    private final void t() {
        ImageView imageView = this.mSignalView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mSignalView;
        Drawable drawable = imageView2 != null ? imageView2.getDrawable() : null;
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    private final void u() {
        if (this.mTimerOn) {
            QLog.d("ZootopiaAudioCallFloatView", 1, "stopTimer");
            this.mTimerOn = false;
            if (this.mRunnable != null) {
                Handler i3 = i();
                if (i3 != null) {
                    TimmerRunnable timmerRunnable = this.mRunnable;
                    Intrinsics.checkNotNull(timmerRunnable);
                    i3.removeCallbacks(timmerRunnable);
                }
                this.mRunnable = null;
            }
        }
    }

    private final void w(ImageView headView, String uin) {
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
            Activity activity = this.weakActivity.get();
            Resources resources = activity != null ? activity.getResources() : null;
            if (d16 == null) {
                d16 = BaseImageUtil.getDefaultFaceBitmap();
            }
            headView.setImageDrawable(new BitmapDrawable(resources, d16));
        }
    }

    @Override // com.tencent.mobileqq.armap.e
    public void h(String uin, String headPath, final Bitmap head) {
        Activity activity;
        Activity activity2 = this.weakActivity.get();
        boolean z16 = false;
        if (activity2 != null && !activity2.isDestroyed()) {
            z16 = true;
        }
        if (z16 && (activity = this.weakActivity.get()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaAudioCallFloatView.o(ZootopiaAudioCallFloatView.this, head);
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00af, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Point j(int position) {
        Rect k3 = k();
        Point point = new Point();
        switch (position) {
            case 0:
                point.x = k3.centerX();
                point.y = k3.centerY();
                break;
            case 1:
                point.x = k3.left;
                point.y = k3.top;
                break;
            case 2:
                point.x = k3.left;
                point.y = k3.top + this.mStatusBarHeight;
                break;
            case 3:
                point.x = k3.left;
                point.y = k3.centerY();
                break;
            case 4:
                point.x = k3.left;
                point.y = k3.bottom - this.mBottomBarHeight;
                break;
            case 5:
                point.x = k3.left;
                point.y = k3.bottom;
                break;
            case 6:
                point.x = k3.right;
                point.y = k3.top;
                break;
            case 7:
                point.x = k3.right;
                point.y = k3.top + this.mStatusBarHeight;
                break;
            case 8:
                point.x = k3.right;
                point.y = k3.centerY();
                break;
            case 9:
                point.x = k3.right;
                point.y = k3.bottom - this.mBottomBarHeight;
                break;
            case 10:
                point.x = k3.right;
                point.y = k3.bottom;
                break;
            case 11:
                point.x = k3.centerX() / 2;
                point.y = k3.top;
                break;
            case 12:
                point.x = k3.centerX();
                point.y = k3.top;
                break;
            case 13:
                point.x = (k3.centerX() * 3) / 2;
                point.y = k3.top;
                break;
        }
    }

    public final Rect k() {
        int i3;
        Rect rect = new Rect();
        WindowManager.LayoutParams layoutParams = this.mLayoutParam;
        int i16 = layoutParams != null ? layoutParams.width : 0;
        int i17 = layoutParams != null ? layoutParams.height : 0;
        int i18 = i16 / 2;
        int i19 = this.mLeftOffsetX;
        rect.left = i18 + i19;
        int i26 = i17 / 2;
        int i27 = this.mTopOffsetY;
        rect.top = i26 + i27;
        int i28 = this.mScreenWidth;
        if (i28 != 0 && (i3 = this.mScreenHeight) != 0) {
            rect.right = (i28 - i18) - i19;
            rect.bottom = (i3 - i26) - i27;
        }
        return rect;
    }

    public final void l() {
        Handler i3;
        WindowManager windowManager;
        if (this.mIsAddWindow) {
            Activity activity = this.weakActivity.get();
            if (activity != null && (windowManager = activity.getWindowManager()) != null) {
                windowManager.removeViewImmediate(this.mFloatRootView);
            }
            this.mIsAddWindow = false;
            u();
            TimmerRunnable timmerRunnable = this.mRunnable;
            if (timmerRunnable != null && (i3 = i()) != null) {
                i3.removeCallbacks(timmerRunnable);
            }
            t();
        }
    }

    public final void m() {
        Resources resources;
        Configuration configuration;
        Resources resources2;
        DisplayMetrics displayMetrics;
        Resources resources3;
        DisplayMetrics displayMetrics2;
        Resources resources4;
        Resources resources5;
        this.mTouchSlop = ViewConfiguration.get(this.weakActivity.get()).getScaledTouchSlop();
        Integer num = null;
        View inflate = LayoutInflater.from(this.weakActivity.get()).inflate(R.layout.f167418d72, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        this.mFloatRootView = relativeLayout;
        this.mAudioCallStatusText = relativeLayout != null ? (TextView) relativeLayout.findViewById(R.id.qz8) : null;
        RelativeLayout relativeLayout2 = this.mFloatRootView;
        this.mAudioCallStatusImg = relativeLayout2 != null ? (ImageView) relativeLayout2.findViewById(R.id.r0m) : null;
        RelativeLayout relativeLayout3 = this.mFloatRootView;
        this.mAudioCallNetStatusImg = relativeLayout3 != null ? (ImageView) relativeLayout3.findViewById(R.id.qz7) : null;
        RelativeLayout relativeLayout4 = this.mFloatRootView;
        ImageView imageView = relativeLayout4 != null ? (ImageView) relativeLayout4.findViewById(R.id.r0n) : null;
        this.mSignalView = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.mSignalView;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.gwz);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 1f)");
        this.mPenUpAnimator = ofFloat;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenUpAnimator");
            ofFloat = null;
        }
        ofFloat.setDuration(200L);
        ValueAnimator valueAnimator = this.mPenUpAnimator;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenUpAnimator");
            valueAnimator = null;
        }
        valueAnimator.addListener(this);
        ValueAnimator valueAnimator2 = this.mPenUpAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenUpAnimator");
            valueAnimator2 = null;
        }
        valueAnimator2.addUpdateListener(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Activity activity = this.weakActivity.get();
        int i3 = 0;
        layoutParams.width = (activity == null || (resources5 = activity.getResources()) == null) ? 0 : (int) resources5.getDimension(R.dimen.f11013m);
        Activity activity2 = this.weakActivity.get();
        layoutParams.height = (activity2 == null || (resources4 = activity2.getResources()) == null) ? 0 : (int) resources4.getDimension(R.dimen.f11003l);
        layoutParams.flags = 40;
        layoutParams.format = -3;
        Activity activity3 = this.weakActivity.get();
        this.mScreenWidth = (activity3 == null || (resources3 = activity3.getResources()) == null || (displayMetrics2 = resources3.getDisplayMetrics()) == null) ? 0 : displayMetrics2.widthPixels;
        Activity activity4 = this.weakActivity.get();
        if (activity4 != null && (resources2 = activity4.getResources()) != null && (displayMetrics = resources2.getDisplayMetrics()) != null) {
            i3 = displayMetrics.heightPixels;
        }
        this.mScreenHeight = i3;
        this.mLeftOffsetX = UIUtil.dp2px(this.weakActivity.get(), 10.0f);
        this.mTopOffsetY = UIUtil.dp2px(this.weakActivity.get(), 50.0f);
        if (this.weakActivity.get() != null) {
            this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(this.weakActivity.get());
        }
        this.mBottomBarHeight = UIUtil.dp2px(this.weakActivity.get(), 10.0f);
        Activity activity5 = this.weakActivity.get();
        if (activity5 != null && (resources = activity5.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            num = Integer.valueOf(configuration.orientation);
        }
        this.mCurOrientation = num;
        if (num != null && num.intValue() == 2) {
            this.mLandLeftMarginInit = ((this.mScreenWidth / 2) - (layoutParams.width / 2)) - UIUtil.dp2px(this.weakActivity.get(), 30.0f);
            int dp2px = (layoutParams.height / 2) + UIUtil.dp2px(this.weakActivity.get(), 50.0f);
            int i16 = this.mScreenHeight;
            this.mLandTopMarginInit = dp2px - (i16 / 2);
            this.mPortraitLeftMarginInit = ((i16 / 2) - (layoutParams.width / 2)) - this.mLeftOffsetX;
            this.mPortraitTopMarginInit = ((layoutParams.height / 2) + UIUtil.dp2px(this.weakActivity.get(), 92.0f)) - (this.mScreenWidth / 2);
            layoutParams.x = this.mLandLeftMarginInit;
            layoutParams.y = this.mLandTopMarginInit;
        } else {
            this.mLandLeftMarginInit = ((this.mScreenHeight / 2) - (layoutParams.width / 2)) - UIUtil.dp2px(this.weakActivity.get(), 30.0f);
            int dp2px2 = (layoutParams.height / 2) + UIUtil.dp2px(this.weakActivity.get(), 50.0f);
            int i17 = this.mScreenWidth;
            this.mLandTopMarginInit = dp2px2 - (i17 / 2);
            this.mPortraitLeftMarginInit = ((i17 / 2) - (layoutParams.width / 2)) - this.mLeftOffsetX;
            int dp2px3 = ((layoutParams.height / 2) + UIUtil.dp2px(this.weakActivity.get(), 92.0f)) - (this.mScreenHeight / 2);
            this.mPortraitTopMarginInit = dp2px3;
            layoutParams.x = this.mPortraitLeftMarginInit;
            layoutParams.y = dp2px3;
        }
        layoutParams.windowAnimations = R.style.f243300f;
        QLog.d("ZootopiaAudioCallFloatView", 1, "getCurOrientation " + this.mCurOrientation + " left=" + this.mLandLeftMarginInit + " top=" + this.mLandTopMarginInit + " width=" + this.mScreenWidth + " height=" + this.mScreenHeight);
        this.mLayoutParam = layoutParams;
        RelativeLayout relativeLayout5 = this.mFloatRootView;
        if (relativeLayout5 != null) {
            relativeLayout5.setOnTouchListener(this);
        }
    }

    public final void n(int orientation) {
        WindowManager windowManager;
        Resources resources;
        DisplayMetrics displayMetrics;
        Resources resources2;
        DisplayMetrics displayMetrics2;
        Integer num = this.mCurOrientation;
        if ((num == null || orientation != num.intValue()) && this.weakActivity.get() != null) {
            this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(this.weakActivity.get());
        }
        Activity activity = this.weakActivity.get();
        int i3 = 0;
        this.mScreenWidth = (activity == null || (resources2 = activity.getResources()) == null || (displayMetrics2 = resources2.getDisplayMetrics()) == null) ? 0 : displayMetrics2.widthPixels;
        Activity activity2 = this.weakActivity.get();
        if (activity2 != null && (resources = activity2.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            i3 = displayMetrics.heightPixels;
        }
        this.mScreenHeight = i3;
        this.mCurOrientation = Integer.valueOf(orientation);
        WindowManager.LayoutParams layoutParams = this.mLayoutParam;
        if (layoutParams == null || this.mFloatRootView == null || !this.mIsAddWindow) {
            return;
        }
        if (orientation == 1) {
            if (layoutParams != null) {
                layoutParams.x = this.mPortraitLeftMarginInit;
            }
            if (layoutParams != null) {
                layoutParams.y = this.mPortraitTopMarginInit;
            }
        } else if (orientation == 2) {
            if (layoutParams != null) {
                layoutParams.x = this.mLandLeftMarginInit;
            }
            if (layoutParams != null) {
                layoutParams.y = this.mLandTopMarginInit;
            }
        }
        Activity activity3 = this.weakActivity.get();
        if (activity3 == null || (windowManager = activity3.getWindowManager()) == null) {
            return;
        }
        windowManager.updateViewLayout(this.mFloatRootView, this.mLayoutParam);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        WindowManager windowManager;
        Point j3 = j(this.mAnimationEndPosition);
        WindowManager.LayoutParams layoutParams = this.mLayoutParam;
        if (layoutParams != null) {
            layoutParams.x = (int) (this.mMoveEndWidowX + (j3.x - this.mPenUpLeft));
        }
        if (layoutParams != null) {
            layoutParams.y = (int) (this.mMoveEndWidowY + (j3.y - this.mPenUpTop));
        }
        Activity activity = this.weakActivity.get();
        if (activity == null || (windowManager = activity.getWindowManager()) == null) {
            return;
        }
        windowManager.updateViewLayout(this.mFloatRootView, this.mLayoutParam);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        this.mAnimationEndPosition = g((int) this.mPenUpLeft, (int) this.mPenUpTop);
        WindowManager.LayoutParams layoutParams = this.mLayoutParam;
        this.mMoveEndWidowX = layoutParams != null ? layoutParams.x : 0;
        this.mMoveEndWidowY = layoutParams != null ? layoutParams.y : 0;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        WindowManager windowManager;
        Intrinsics.checkNotNull(animation);
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Point j3 = j(this.mAnimationEndPosition);
        WindowManager.LayoutParams layoutParams = this.mLayoutParam;
        if (layoutParams != null) {
            layoutParams.x = (int) (this.mMoveEndWidowX + ((j3.x - this.mPenUpLeft) * floatValue));
        }
        if (layoutParams != null) {
            layoutParams.y = (int) (this.mMoveEndWidowY + ((j3.y - this.mPenUpTop) * floatValue));
        }
        Activity activity = this.weakActivity.get();
        if (activity == null || (windowManager = activity.getWindowManager()) == null) {
            return;
        }
        windowManager.updateViewLayout(this.mFloatRootView, this.mLayoutParam);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        WindowManager windowManager;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        ValueAnimator valueAnimator = null;
        ValueAnimator valueAnimator2 = null;
        ValueAnimator valueAnimator3 = null;
        if (action == 0) {
            this.mMoveUpdateX = event.getRawX();
            this.mMoveUpdateY = event.getRawY();
            this.mDownTime = System.currentTimeMillis();
            this.mScrollStarted = false;
            ValueAnimator valueAnimator4 = this.mPenUpAnimator;
            if (valueAnimator4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenUpAnimator");
            } else {
                valueAnimator = valueAnimator4;
            }
            valueAnimator.cancel();
            this.mDownStartX = event.getRawX();
            this.mDownStartY = event.getRawY();
        } else if (action == 1) {
            int i3 = this.mScreenWidth / 2;
            WindowManager.LayoutParams layoutParams = this.mLayoutParam;
            this.mPenUpLeft = i3 + (layoutParams != null ? layoutParams.x : 0);
            this.mPenUpTop = (this.mScreenHeight / 2) + (layoutParams != null ? layoutParams.y : 0);
            if (this.mScrollStarted) {
                this.mScrollStarted = false;
                ValueAnimator valueAnimator5 = this.mPenUpAnimator;
                if (valueAnimator5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenUpAnimator");
                } else {
                    valueAnimator3 = valueAnimator5;
                }
                valueAnimator3.start();
                return true;
            }
            this.mScrollStarted = false;
            if (System.currentTimeMillis() - this.mDownTime > 200) {
                return true;
            }
        } else if (action == 2) {
            if (!this.mScrollStarted) {
                this.mScrollStarted = Math.abs(event.getRawX() - this.mDownStartX) > ((float) this.mTouchSlop) || Math.abs(event.getRawY() - this.mDownStartY) > ((float) this.mTouchSlop);
            }
            WindowManager.LayoutParams layoutParams2 = this.mLayoutParam;
            if (layoutParams2 != null) {
                layoutParams2.x = (layoutParams2 != null ? Integer.valueOf(layoutParams2.x + ((int) (event.getRawX() - this.mMoveUpdateX))) : null).intValue();
            }
            WindowManager.LayoutParams layoutParams3 = this.mLayoutParam;
            if (layoutParams3 != null) {
                layoutParams3.y = (layoutParams3 != null ? Integer.valueOf(layoutParams3.y + ((int) (event.getRawY() - this.mMoveUpdateY))) : null).intValue();
            }
            Activity activity = this.weakActivity.get();
            if (activity != null && (windowManager = activity.getWindowManager()) != null) {
                windowManager.updateViewLayout(this.mFloatRootView, this.mLayoutParam);
            }
            this.mMoveUpdateX = event.getRawX();
            this.mMoveUpdateY = event.getRawY();
        } else if (action == 3) {
            int i16 = this.mScreenWidth / 2;
            WindowManager.LayoutParams layoutParams4 = this.mLayoutParam;
            this.mPenUpLeft = i16 + (layoutParams4 != null ? layoutParams4.x : 0);
            this.mPenUpTop = (this.mScreenHeight / 2) + (layoutParams4 != null ? layoutParams4.y : 0);
            ValueAnimator valueAnimator6 = this.mPenUpAnimator;
            if (valueAnimator6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenUpAnimator");
            } else {
                valueAnimator2 = valueAnimator6;
            }
            valueAnimator2.start();
        }
        return this.mScrollStarted;
    }

    public final void p(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        RelativeLayout relativeLayout = this.mFloatRootView;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(listener);
        }
    }

    public final void q() {
        if (this.mIsAddWindow) {
            return;
        }
        if (this.mFloatRootView == null) {
            m();
        } else {
            Integer num = this.mCurOrientation;
            if (num != null && num.intValue() == 2) {
                WindowManager.LayoutParams layoutParams = this.mLayoutParam;
                if (layoutParams != null) {
                    layoutParams.x = this.mLandLeftMarginInit;
                }
                if (layoutParams != null) {
                    layoutParams.y = this.mLandTopMarginInit;
                }
            } else {
                WindowManager.LayoutParams layoutParams2 = this.mLayoutParam;
                if (layoutParams2 != null) {
                    layoutParams2.x = this.mPortraitLeftMarginInit;
                }
                if (layoutParams2 != null) {
                    layoutParams2.y = this.mPortraitTopMarginInit;
                }
            }
        }
        Activity activity = this.weakActivity.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        WindowManager windowManager = activity.getWindowManager();
        if (windowManager != null) {
            windowManager.addView(this.mFloatRootView, this.mLayoutParam);
        }
        this.mIsAddWindow = true;
    }

    public final void x(boolean isWifi, boolean isBad) {
        Resources resources;
        Resources resources2;
        if (isBad) {
            ImageView imageView = this.mAudioCallNetStatusImg;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            Drawable drawable = null;
            if (isWifi) {
                ImageView imageView2 = this.mAudioCallNetStatusImg;
                if (imageView2 != null) {
                    Activity activity = this.weakActivity.get();
                    if (activity != null && (resources2 = activity.getResources()) != null) {
                        drawable = resources2.getDrawable(R.drawable.f159830ik4);
                    }
                    imageView2.setImageDrawable(drawable);
                    return;
                }
                return;
            }
            ImageView imageView3 = this.mAudioCallNetStatusImg;
            if (imageView3 != null) {
                Activity activity2 = this.weakActivity.get();
                if (activity2 != null && (resources = activity2.getResources()) != null) {
                    drawable = resources.getDrawable(R.drawable.ijy);
                }
                imageView3.setImageDrawable(drawable);
                return;
            }
            return;
        }
        ImageView imageView4 = this.mAudioCallNetStatusImg;
        if (imageView4 == null) {
            return;
        }
        imageView4.setVisibility(8);
    }

    public final int g(int nEndX, int nEndY) {
        int i3 = Integer.MAX_VALUE;
        int i16 = 0;
        for (int i17 = 1; i17 < 14; i17++) {
            Point j3 = j(i17);
            int i18 = j3.x;
            int i19 = j3.y;
            int i26 = ((nEndX - i18) * (nEndX - i18)) + ((nEndY - i19) * (nEndY - i19));
            if (i26 < i3) {
                i16 = i17;
                i3 = i26;
            }
        }
        return i16;
    }

    public final void y(long uin, boolean isSpeaking) {
        Resources resources;
        if (isSpeaking && uin > 0) {
            w(this.mAudioCallStatusImg, String.valueOf(uin));
            t();
            return;
        }
        ImageView imageView = this.mAudioCallStatusImg;
        if (imageView != null) {
            Activity activity = this.weakActivity.get();
            imageView.setImageDrawable((activity == null || (resources = activity.getResources()) == null) ? null : resources.getDrawable(R.drawable.f159829ik3));
        }
        r();
    }

    public final void v(int status) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Resources resources6;
        Drawable drawable = null;
        if (status == 0) {
            TextView textView = this.mAudioCallStatusText;
            if (textView != null) {
                Activity activity = this.weakActivity.get();
                textView.setText((activity == null || (resources2 = activity.getResources()) == null) ? null : resources2.getString(R.string.xhw));
            }
            ImageView imageView = this.mAudioCallNetStatusImg;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.mAudioCallStatusImg;
            if (imageView2 != null) {
                Activity activity2 = this.weakActivity.get();
                if (activity2 != null && (resources = activity2.getResources()) != null) {
                    drawable = resources.getDrawable(R.drawable.f159829ik3);
                }
                imageView2.setImageDrawable(drawable);
            }
            u();
            r();
            return;
        }
        if (status == 1) {
            if (!this.mTimerOn) {
                TextView textView2 = this.mAudioCallStatusText;
                if (textView2 != null) {
                    Activity activity3 = this.weakActivity.get();
                    textView2.setText((activity3 == null || (resources4 = activity3.getResources()) == null) ? null : resources4.getString(R.string.xhu));
                }
                s();
            }
            ImageView imageView3 = this.mAudioCallNetStatusImg;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.mAudioCallStatusImg;
            if (imageView4 != null) {
                Activity activity4 = this.weakActivity.get();
                if (activity4 != null && (resources3 = activity4.getResources()) != null) {
                    drawable = resources3.getDrawable(R.drawable.f159829ik3);
                }
                imageView4.setImageDrawable(drawable);
            }
            r();
            return;
        }
        if (status != 2) {
            return;
        }
        u();
        t();
        TextView textView3 = this.mAudioCallStatusText;
        if (textView3 != null) {
            Activity activity5 = this.weakActivity.get();
            textView3.setText((activity5 == null || (resources6 = activity5.getResources()) == null) ? null : resources6.getString(R.string.xhv));
        }
        ImageView imageView5 = this.mAudioCallNetStatusImg;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        ImageView imageView6 = this.mAudioCallStatusImg;
        if (imageView6 != null) {
            Activity activity6 = this.weakActivity.get();
            if (activity6 != null && (resources5 = activity6.getResources()) != null) {
                drawable = resources5.getDrawable(R.drawable.f159829ik3);
            }
            imageView6.setImageDrawable(drawable);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }
}
