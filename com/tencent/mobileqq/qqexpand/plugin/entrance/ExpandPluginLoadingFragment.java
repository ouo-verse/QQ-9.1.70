package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher;
import com.tencent.mobileqq.qqexpand.utils.k;
import com.tencent.mobileqq.qqexpand.utils.o;
import com.tencent.mobileqq.qqexpand.utils.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.plugin.HighPluginCrashException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ~2\u00020\u0001:\u0001\u007fB\u0007\u00a2\u0006\u0004\b|\u0010}J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010\u001d\u001a\u00020\u0002J\"\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fJ\u000e\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\u0002J\u0006\u0010.\u001a\u00020\u0002J\u000e\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0005J\u000e\u00101\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00022\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204R\u0016\u00109\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00108R\u0018\u0010O\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0018\u0010Q\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010HR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010NR\u0016\u0010W\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010LR\u0016\u0010Y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010NR\u0016\u0010\\\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010[R\u0016\u0010`\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010NR\u0016\u0010b\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010[R\u0016\u0010d\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010[R\u0016\u0010g\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010LR\u0016\u0010q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010LR\u0014\u0010s\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010LR\u0014\u0010u\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010LR\u0014\u0010w\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010;R\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010z\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Fh", "Oh", "", "Bh", "Dh", "process", "updateProgress", "", "endTime", "Mh", "Gh", "Ah", "", OcrConfig.CHINESE, "Ch", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ih", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/LoadingStatus;", "status", "loadError", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Xh", "progress", "Qh", "Vh", "downloadSecond", "loadSecond", "Rh", "Landroid/view/View$OnClickListener;", "listener", "Nh", "Kh", "Jh", "Hh", "from", "Ph", "xh", "", "isHotStart", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "serviceLoadingState", "Lh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Lcom/tencent/image/URLImageView;", "D", "Lcom/tencent/image/URLImageView;", "mBoxingView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mLoadingError", "Landroid/widget/ProgressBar;", UserInfo.SEX_FEMALE, "Landroid/widget/ProgressBar;", "mProgressBar", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mLoadingWording", "H", "mLoadingSubWording", "I", "mCloseButton", "J", "mRetryLoading", "K", "mCountDownLoading", "L", "mLoadingStartTime", "M", "mLoadingEndTime", "N", "mDismissFrom", "P", "mDownloadDuration", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "mIsHotStart", BdhLogUtil.LogTag.Tag_Req, "mIsDownloading", ExifInterface.LATITUDE_SOUTH, "mDownloadStartTime", "T", "mHasDownload", "U", "mIsPluginProcessExists", "V", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/LoadingStatus;", "mCurrentLoadingStatus", "W", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "mServiceLoadingState", "Lcom/tencent/mobileqq/qqexpand/utils/k;", "X", "Lcom/tencent/mobileqq/qqexpand/utils/k;", "mLifecycleCallbacks", "Y", "mStartPluginState", "mErrorCode", "a0", "mPerProgress", "b0", "mPerProgressWhenDownload", "c0", "mCountDownDuration", "Landroid/content/BroadcastReceiver;", "d0", "Landroid/content/BroadcastReceiver;", "mReceiver", "<init>", "()V", "e0", "a", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandPluginLoadingFragment extends QPublicBaseFragment {

    /* renamed from: C */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private URLImageView mBoxingView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mLoadingError;

    /* renamed from: F */
    private ProgressBar mProgressBar;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mLoadingWording;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mLoadingSubWording;

    /* renamed from: I, reason: from kotlin metadata */
    private View mCloseButton;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mRetryLoading;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView mCountDownLoading;

    /* renamed from: L, reason: from kotlin metadata */
    private long mLoadingStartTime;

    /* renamed from: M, reason: from kotlin metadata */
    private long mLoadingEndTime;

    /* renamed from: N, reason: from kotlin metadata */
    private int mDismissFrom;

    /* renamed from: P, reason: from kotlin metadata */
    private long mDownloadDuration;

    /* renamed from: Q */
    private boolean mIsHotStart;

    /* renamed from: R */
    private boolean mIsDownloading;

    /* renamed from: S */
    private long mDownloadStartTime;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mHasDownload;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mIsPluginProcessExists;

    /* renamed from: V, reason: from kotlin metadata */
    private LoadingStatus mCurrentLoadingStatus = LoadingStatus.LOADING;

    /* renamed from: W, reason: from kotlin metadata */
    private ExpandPluginLauncher.PluginServiceState mServiceLoadingState = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;

    /* renamed from: X, reason: from kotlin metadata */
    private k mLifecycleCallbacks;

    /* renamed from: Y, reason: from kotlin metadata */
    private int mStartPluginState;

    /* renamed from: Z, reason: from kotlin metadata */
    private int mErrorCode;

    /* renamed from: a0, reason: from kotlin metadata */
    private final int mPerProgress;

    /* renamed from: b0, reason: from kotlin metadata */
    private final int mPerProgressWhenDownload;

    /* renamed from: c0, reason: from kotlin metadata */
    private final double mCountDownDuration;

    /* renamed from: d0, reason: from kotlin metadata */
    private final BroadcastReceiver mReceiver;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f263993a;

        static {
            int[] iArr = new int[LoadingStatus.values().length];
            try {
                iArr[LoadingStatus.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadingStatus.LOADING_ERROR_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadingStatus.LOADING_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadingStatus.LOADING_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f263993a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment$c", "Lcom/tencent/mobileqq/qqexpand/utils/o;", "", "onBackground", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements o {
        c() {
        }

        @Override // com.tencent.mobileqq.qqexpand.utils.o
        public void onBackground() {
            QLog.d("ExpandPluginLoadingFragment", 2, "onBackground");
            ExpandPluginLoadingFragment.this.Ph(4);
            if (Build.VERSION.SDK_INT > 28) {
                QLog.e("ExpandPluginLoadingFragment", 1, "sdk api above 28, dismiss");
                FragmentActivity activity = ExpandPluginLoadingFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    public ExpandPluginLoadingFragment() {
        int Ah = Ah();
        this.mPerProgress = Ah;
        this.mPerProgressWhenDownload = (int) (Ah * 0.4d);
        this.mCountDownDuration = zh();
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment$mReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH", intent.getAction()) && Intrinsics.areEqual(intent.getStringExtra("qshadow_plugin_id"), "expand")) {
                    QLog.d("ExpandPluginLoadingFragment", 2, "receive CRASH_ACTION");
                    int intExtra = intent.getIntExtra("qshadow_plugin_error_code", 0);
                    ExpandPluginLoadingFragment.this.mErrorCode = intExtra;
                    try {
                        Serializable serializableExtra = intent.getSerializableExtra("qshadow_plugin_throwable");
                        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type kotlin.Throwable");
                        Throwable th5 = (Throwable) serializableExtra;
                        String stringExtra = intent.getStringExtra("qshadow_plugin_id");
                        QLog.e("ExpandPluginLoadingFragment", 2, th5, new Object[0]);
                        HighPluginCrashException highPluginCrashException = new HighPluginCrashException(stringExtra + " \u63d2\u4ef6\u8fd0\u884c\u5f02\u5e38, errorCode: " + intExtra, th5);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(stringExtra);
                        sb5.append(" catch Exception");
                        com.tencent.qqperf.monitor.crash.catchedexception.a.c(highPluginCrashException, sb5.toString());
                    } catch (Exception e16) {
                        QLog.e("ExpandPluginLoadingFragment", 2, e16.getMessage());
                    }
                    ExpandPluginLoadingFragment.this.Xh(LoadingStatus.LOADING_ERROR, 1, intExtra);
                }
            }
        };
    }

    private final int Ah() {
        if (DeviceInfoUtils.isHighPerfDevice()) {
            return 15;
        }
        return DeviceInfoUtils.isLowPerfDevice() ? 5 : 10;
    }

    private final int Bh() {
        com.tencent.mobileqq.qroute.module.e j3 = QRoute.plugin("expand").j();
        if (j3 != null) {
            return j3.d();
        }
        return -5;
    }

    private final void Ch() {
        if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
            SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
        } else {
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
        ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
    }

    private final void Dh() {
        Drawable drawable = BaseApplication.context.getResources().getDrawable(R.drawable.mt7);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mExtraInfo = new Bundle();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable("https://downv6.qq.com/innovate/qqexpend/match/boxing.png", obtain);
        URLImageView uRLImageView = this.mBoxingView;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(drawable2);
        }
    }

    public static final void Eh(ExpandPluginLoadingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Fh() {
        k kVar = new k(new c());
        this.mLifecycleCallbacks = kVar;
        GuardManager.sInstance.registerCallBack(kVar);
        QLog.d("ExpandPluginLoadingFragment", 2, "add background callbacks");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH");
        BaseApplication.getContext().registerReceiver(this.mReceiver, intentFilter);
    }

    private final void Gh() {
        Object obj;
        HashMap hashMapOf;
        long j3 = this.mLoadingEndTime;
        if (j3 == 0) {
            j3 = System.currentTimeMillis();
        }
        this.mLoadingEndTime = j3;
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("duration", String.valueOf(j3 - this.mLoadingStartTime));
        pairArr[1] = TuplesKt.to("ext_int1", String.valueOf(this.mDismissFrom));
        pairArr[2] = TuplesKt.to("download_duration", String.valueOf(this.mDownloadDuration));
        String str = "2";
        if (this.mIsHotStart) {
            obj = "2";
        } else {
            obj = "1";
        }
        pairArr[3] = TuplesKt.to("launch_type", obj);
        if (!this.mIsPluginProcessExists) {
            str = "1";
        }
        pairArr[4] = TuplesKt.to("process_status", str);
        pairArr[5] = TuplesKt.to("service_loading_state", String.valueOf(this.mServiceLoadingState.getValue()));
        pairArr[6] = TuplesKt.to("start_plugin_state", String.valueOf(this.mStartPluginState));
        pairArr[7] = TuplesKt.to("dismiss_plugin_state", String.valueOf(Bh()));
        pairArr[8] = TuplesKt.to("error_code", String.valueOf(this.mErrorCode));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        QLog.i("ExpandPluginLoadingFragment", 1, "dismiss duration " + hashMapOf);
        com.tencent.mobileqq.qqexpand.utils.d.e("loading#launch_loading#view", true, -1L, -1L, hashMapOf, true, true);
    }

    private final void Mh(long endTime) {
        if (this.mLoadingEndTime != 0) {
            QLog.e("ExpandPluginLoadingFragment", 2, "endTime has value!!!");
        } else {
            this.mLoadingEndTime = endTime;
        }
    }

    private final void Oh() {
        k kVar = this.mLifecycleCallbacks;
        if (kVar != null) {
            kVar.a();
            GuardManager.sInstance.unregisterCallback(kVar);
            QLog.d("ExpandPluginLoadingFragment", 2, "remove background callbacks");
        }
        this.mLifecycleCallbacks = null;
        BaseApplication.getContext().unregisterReceiver(this.mReceiver);
    }

    public static final void Th(ExpandPluginLoadingFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.mCountDownLoading;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this$0.mCountDownLoading;
        if (textView2 == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = BaseApplication.context.getResources().getString(R.string.f198754nk);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026friend_plugin_count_down)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView2.setText(format);
    }

    public static final void Uh(double d16, double d17, ExpandPluginLoadingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        double d18 = 0.0d;
        if (!this$0.mIsDownloading) {
            d17 = d17 >= 2.0d ? d17 - 1.0d : 1.0d;
        } else if (d16 >= 1.0d) {
            d18 = d16 - 1.0d;
        }
        this$0.Rh(d18, d17);
    }

    public static final void Wh(int i3, ExpandPluginLoadingFragment this$0) {
        int random;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 > 100) {
            return;
        }
        if (i3 == 0) {
            if (this$0.mHasDownload) {
                i3 = 60;
            } else {
                int i16 = this$0.mPerProgress;
                i3 = RangesKt___RangesKt.random(new IntRange(i16, i16 + 5), Random.INSTANCE);
            }
        }
        this$0.updateProgress(i3);
        if (this$0.mHasDownload) {
            int i17 = this$0.mPerProgressWhenDownload;
            random = RangesKt___RangesKt.random(new IntRange(i17, i17 + 2), Random.INSTANCE);
        } else {
            int i18 = this$0.mPerProgress;
            random = RangesKt___RangesKt.random(new IntRange(i18, i18 + 5), Random.INSTANCE);
        }
        this$0.Vh(i3 + random);
    }

    public static final void Zh(ExpandPluginLoadingFragment this$0, LoadingStatus status, int i3, int i16) {
        int i17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(status, "$status");
        this$0.mCurrentLoadingStatus = status;
        int i18 = b.f263993a[status.ordinal()];
        if (i18 == 1) {
            TextView textView = this$0.mLoadingWording;
            if (textView != null) {
                textView.setText(R.string.f198774nm);
            }
            TextView textView2 = this$0.mLoadingSubWording;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            URLImageView uRLImageView = this$0.mBoxingView;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
            ImageView imageView = this$0.mLoadingError;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ProgressBar progressBar = this$0.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            TextView textView3 = this$0.mRetryLoading;
            if (textView3 == null) {
                return;
            }
            textView3.setVisibility(8);
            return;
        }
        View view = null;
        if (i18 == 2) {
            View view2 = this$0.mRootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            TextView textView4 = this$0.mLoadingWording;
            if (textView4 != null) {
                textView4.setText(R.string.f198784nn);
            }
            TextView textView5 = this$0.mLoadingSubWording;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            TextView textView6 = this$0.mLoadingSubWording;
            if (textView6 != null) {
                textView6.setText(R.string.f198804np);
            }
            URLImageView uRLImageView2 = this$0.mBoxingView;
            if (uRLImageView2 != null) {
                uRLImageView2.setVisibility(8);
            }
            ImageView imageView2 = this$0.mLoadingError;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ProgressBar progressBar2 = this$0.mProgressBar;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            TextView textView7 = this$0.mRetryLoading;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            TextView textView8 = this$0.mCountDownLoading;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            com.tencent.mobileqq.qqexpand.utils.d.e("expose#launch_network_error_page#view", true, -1L, -1L, null, true, true);
            return;
        }
        if (i18 != 3) {
            if (i18 != 4) {
                return;
            }
            this$0.xh(2);
            return;
        }
        View view3 = this$0.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
        if (i3 != 0 || (i17 = this$0.mErrorCode) == 0) {
            i17 = i3;
        }
        this$0.mErrorCode = i17;
        TextView textView9 = this$0.mLoadingWording;
        if (textView9 != null) {
            textView9.setText(R.string.f198784nn);
        }
        TextView textView10 = this$0.mLoadingSubWording;
        if (textView10 != null) {
            textView10.setVisibility(0);
        }
        TextView textView11 = this$0.mLoadingSubWording;
        if (textView11 != null) {
            textView11.setText(R.string.f198794no);
        }
        URLImageView uRLImageView3 = this$0.mBoxingView;
        if (uRLImageView3 != null) {
            uRLImageView3.setVisibility(8);
        }
        ImageView imageView3 = this$0.mLoadingError;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
        ProgressBar progressBar3 = this$0.mProgressBar;
        if (progressBar3 != null) {
            progressBar3.setVisibility(8);
        }
        TextView textView12 = this$0.mRetryLoading;
        if (textView12 != null) {
            textView12.setVisibility(0);
        }
        TextView textView13 = this$0.mCountDownLoading;
        if (textView13 != null) {
            textView13.setVisibility(8);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("load_error", String.valueOf(i16));
        hashMap.put("error_reason", String.valueOf(i3));
        com.tencent.mobileqq.qqexpand.utils.d.e("expose#launch_download_error_page#view", true, -1L, -1L, hashMap, true, true);
    }

    public static final void ai(ExpandPluginLoadingFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProgressBar progressBar = this$0.mProgressBar;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(i3);
    }

    private final void updateProgress(final int process) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.i
            @Override // java.lang.Runnable
            public final void run() {
                ExpandPluginLoadingFragment.ai(ExpandPluginLoadingFragment.this, process);
            }
        });
    }

    public static final void yh(ExpandPluginLoadingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final double zh() {
        if (DeviceInfoUtils.isHighPerfDevice()) {
            return 2.0d;
        }
        return DeviceInfoUtils.isLowPerfDevice() ? 4.0d : 3.0d;
    }

    public final void Hh() {
        this.mLoadingStartTime = System.currentTimeMillis();
        com.tencent.mobileqq.qqexpand.utils.d.e("click#launch_download_error_page#retry_btn", true, -1L, -1L, null, true, true);
    }

    public final void Jh() {
        if (this.mIsDownloading) {
            this.mIsDownloading = false;
            this.mDownloadDuration = System.currentTimeMillis() - this.mDownloadStartTime;
            this.mDownloadStartTime = 0L;
            Ph(1);
        }
    }

    public final void Lh(boolean isHotStart, ExpandPluginLauncher.PluginServiceState serviceLoadingState) {
        Intrinsics.checkNotNullParameter(serviceLoadingState, "serviceLoadingState");
        this.mIsHotStart = isHotStart;
        this.mServiceLoadingState = serviceLoadingState;
        Mh(System.currentTimeMillis());
    }

    public final void Nh(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView textView = this.mRetryLoading;
        if (textView != null) {
            textView.setOnClickListener(listener);
        }
    }

    public final void Ph(int from) {
        QLog.d("ExpandPluginLoadingFragment", 2, "updateDismissFrom " + from);
        if (this.mDismissFrom != 4) {
            this.mDismissFrom = from;
        }
    }

    public final void Rh(final double downloadSecond, final double loadSecond) {
        if (this.mCurrentLoadingStatus != LoadingStatus.LOADING || getActivity() == null) {
            return;
        }
        final int ceil = (int) Math.ceil(downloadSecond + loadSecond);
        QLog.d("ExpandPluginLoadingFragment", 2, "downloadTime " + downloadSecond + " loadTime " + loadSecond + " isDownloading " + this.mIsDownloading + " remainTime " + ceil);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.e
            @Override // java.lang.Runnable
            public final void run() {
                ExpandPluginLoadingFragment.Th(ExpandPluginLoadingFragment.this, ceil);
            }
        });
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.f
            @Override // java.lang.Runnable
            public final void run() {
                ExpandPluginLoadingFragment.Uh(downloadSecond, loadSecond, this);
            }
        }, 2000L);
    }

    public final void Vh(final int progress) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.h
            @Override // java.lang.Runnable
            public final void run() {
                ExpandPluginLoadingFragment.Wh(progress, this);
            }
        }, 500L);
    }

    public final void Xh(final LoadingStatus status, final int loadError, final int r56) {
        Intrinsics.checkNotNullParameter(status, "status");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.c
            @Override // java.lang.Runnable
            public final void run() {
                ExpandPluginLoadingFragment.Zh(ExpandPluginLoadingFragment.this, status, r56, loadError);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup r142, Bundle r152) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168803gx1, r142, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026dialog, container, false)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        this.mBoxingView = (URLImageView) inflate.findViewById(R.id.ysc);
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        this.mLoadingError = (ImageView) view.findViewById(R.id.ysp);
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        this.mProgressBar = (ProgressBar) view2.findViewById(R.id.efn);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        this.mLoadingWording = (TextView) view3.findViewById(R.id.ytc);
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        this.mLoadingSubWording = (TextView) view4.findViewById(R.id.f9034528);
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        this.mCloseButton = view5.findViewById(R.id.jok);
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        this.mRetryLoading = (TextView) view6.findViewById(R.id.f166136yt3);
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        TextView textView = (TextView) view7.findViewById(R.id.u9w);
        this.mCountDownLoading = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view8 = this.mCloseButton;
        if (view8 != null) {
            view8.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view9) {
                    ExpandPluginLoadingFragment.Eh(ExpandPluginLoadingFragment.this, view9);
                }
            });
        }
        Ch();
        Dh();
        Bundle arguments = getArguments();
        boolean a16 = p.a(arguments != null ? arguments.getInt("plugin_process_id", 0) : 0);
        this.mIsHotStart = a16;
        QLog.i("ExpandPluginLoadingFragment", 2, "isHotStart " + a16 + " ");
        if (this.mIsHotStart) {
            View view9 = this.mRootView;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view9 = null;
            }
            view9.setVisibility(8);
        }
        this.mStartPluginState = Bh();
        this.mIsPluginProcessExists = p.b("com.tencent.mobileqq:plugins");
        Ph(0);
        Yh(this, LoadingStatus.LOADING, 0, 0, 6, null);
        QLog.i("ExpandPluginLoadingFragment", 1, "plugin state " + this.mStartPluginState);
        if (this.mStartPluginState == 3) {
            Rh(0.0d, this.mCountDownDuration);
        }
        Fh();
        this.mLoadingStartTime = System.currentTimeMillis();
        ExpandPluginLauncher.INSTANCE.a().E(this);
        com.tencent.mobileqq.qqexpand.utils.d.e("expose#launch_loading#view", true, -1L, -1L, null, true, true);
        QLog.i("ExpandPluginLoadingFragment", 1, "expose loadingFragment " + System.identityHashCode(this));
        View view10 = this.mRootView;
        if (view10 != null) {
            return view10;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.i("ExpandPluginLoadingFragment", 4, "onDestroy " + System.identityHashCode(this));
        Oh();
        ExpandPluginLauncher.INSTANCE.a().H();
        LoadingStatus loadingStatus = this.mCurrentLoadingStatus;
        if (loadingStatus == LoadingStatus.LOADING || loadingStatus == LoadingStatus.LOADING_SUCCESS) {
            Gh();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i("ExpandPluginLoadingFragment", 4, "onPause " + System.identityHashCode(this));
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.i("ExpandPluginLoadingFragment", 4, "onResume " + System.identityHashCode(this));
        super.onResume();
    }

    public final void xh(int from) {
        Ph(from);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.g
            @Override // java.lang.Runnable
            public final void run() {
                ExpandPluginLoadingFragment.yh(ExpandPluginLoadingFragment.this);
            }
        });
    }

    public final void Ih() {
        QLog.i("ExpandPluginLoadingFragment", 2, "rootView visibility set VISIBLE");
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.setVisibility(0);
    }

    public final void Kh() {
        this.mHasDownload = true;
        if (this.mIsDownloading) {
            return;
        }
        this.mIsDownloading = true;
        this.mDownloadStartTime = System.currentTimeMillis();
        Ph(3);
    }

    public static /* synthetic */ void Sh(ExpandPluginLoadingFragment expandPluginLoadingFragment, double d16, double d17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            d17 = expandPluginLoadingFragment.mCountDownDuration;
        }
        expandPluginLoadingFragment.Rh(d16, d17);
    }

    public static /* synthetic */ void Yh(ExpandPluginLoadingFragment expandPluginLoadingFragment, LoadingStatus loadingStatus, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        expandPluginLoadingFragment.Xh(loadingStatus, i3, i16);
    }

    public final void Qh(int progress) {
        if (progress <= 100) {
            updateProgress((int) (progress * 0.6d));
        }
    }
}
