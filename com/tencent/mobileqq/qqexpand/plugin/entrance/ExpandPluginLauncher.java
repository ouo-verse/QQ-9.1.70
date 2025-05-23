package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.utils.l;
import com.tencent.mobileqq.qqexpand.utils.n;
import com.tencent.mobileqq.qqexpand.utils.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.a;
import com.tencent.mobileqq.qroute.module.d;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 E2\u00020\u0001:\u0002PQB\u0007\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J>\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a`\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!J\u0006\u0010$\u001a\u00020\u0002J\u0012\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010'\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\u0012\u0010)\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010*\u001a\u00020\u0002H\u0016J\u0012\u0010+\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\fR\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020!0.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R2\u0010A\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010ER\u0016\u0010H\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010GR\u0016\u0010J\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010ER\u0016\u0010K\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010GR\u0016\u0010L\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010GR\u0016\u0010M\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010E\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "G", "", ReportConstant.COSTREPORT_PREFIX, "hasDownload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/qroute/module/a;", "manager", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "remainSize", "", "startDownloadSize", "u", "r", "Landroid/content/Intent;", "v", "Lcom/tencent/mobileqq/qqexpand/manager/ExpandManager;", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "activityContext", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", WadlProxyConsts.KEY_JUMP_URL, "w", "Landroid/os/Bundle;", "t", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment;", "loadFragment", "E", "H", "p0", "onNetNone2Mobile", "onNetWifi2Mobile", "onNetWifi2None", "onNetNone2Wifi", "onNetMobile2None", "onNetMobile2Wifi", "pid", "D", "Ljava/lang/ref/WeakReference;", "d", "Ljava/lang/ref/WeakReference;", "mLoadingFragment", "Lcom/tencent/mobileqq/qqexpand/utils/n;", "e", "Lcom/tencent/mobileqq/qqexpand/utils/n;", "mNetSpeedChecker", "f", "I", "mPluginPid", tl.h.F, "mServiceStartedPid", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "i", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "mServiceState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "mExtraParams", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mJumpUrl", "J", "mDownloadStartTime", "Z", "mHasDownload", UserInfo.SEX_FEMALE, "mTotalRxBytes", "mComputeRemainTimeOnce", "mIsDownloading", "mLastEnterTime", "<init>", "()V", "a", "PluginServiceState", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ExpandPluginLauncher implements INetInfoHandler {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Intent K;
    private static final Lazy<ExpandPluginLauncher> L;

    /* renamed from: D, reason: from kotlin metadata */
    private long mDownloadStartTime;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mHasDownload;

    /* renamed from: F, reason: from kotlin metadata */
    private long mTotalRxBytes;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mComputeRemainTimeOnce;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsDownloading;

    /* renamed from: I, reason: from kotlin metadata */
    private long mLastEnterTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mPluginPid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mServiceStartedPid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<ExpandPluginLoadingFragment> mLoadingFragment = new WeakReference<>(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final n mNetSpeedChecker = new n();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PluginServiceState mServiceState = PluginServiceState.NOT_STARTED;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Object> mExtraParams = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private String mJumpUrl = "";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NOT_STARTED", "STARTING", "STARTED", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum PluginServiceState {
        NOT_STARTED(0),
        STARTING(1),
        STARTED(2);

        private final int value;

        PluginServiceState(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$a;", "", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "KEY_ENTER_TIME", "Ljava/lang/String;", "KEY_PLUGIN_PROCESS_ID", "PLUGIN_ENTRY_ACTIVITY", "PLUGIN_ID", "PLUGIN_ID_APK", "PLUGIN_PRELOAD_PACKAGE_NAME", "PLUGIN_PRELOAD_SERVICE", "PLUGIN_PRELOAD_SERVICE_NAME", "TAG", "Landroid/content/Intent;", "mStartIntent", "Landroid/content/Intent;", "<init>", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExpandPluginLauncher a() {
            return (ExpandPluginLauncher) ExpandPluginLauncher.L.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$b", "Lcom/tencent/mobileqq/qroute/module/c;", "", "p0", "", "onInstallBegin", "onInstallFinish", "", "p1", "onInstallError", "p2", "onInstallDownloadProgress", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.qroute.module.c {
        b() {
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallBegin(String p06) {
            l lVar = l.f264102a;
            if (QLog.isColorLevel()) {
                lVar.a().d("ExpandPluginLauncher", 2, "onInstallBegin");
            }
            ExpandPluginLoadingFragment expandPluginLoadingFragment = (ExpandPluginLoadingFragment) ExpandPluginLauncher.this.mLoadingFragment.get();
            if (expandPluginLoadingFragment != null) {
                ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING, 0, 0, 6, null);
            }
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallDownloadProgress(String p06, int p16, int p26) {
            ExpandPluginLauncher.this.mHasDownload = true;
            ExpandPluginLauncher.this.mIsDownloading = true;
            ExpandPluginLoadingFragment expandPluginLoadingFragment = (ExpandPluginLoadingFragment) ExpandPluginLauncher.this.mLoadingFragment.get();
            if (expandPluginLoadingFragment != null) {
                expandPluginLoadingFragment.Kh();
            }
            if (ExpandPluginLauncher.this.mTotalRxBytes == 0) {
                ExpandPluginLauncher.this.mTotalRxBytes = TrafficStats.getTotalRxBytes();
            }
            int i3 = (int) (((p16 * 1.0d) / p26) * 100);
            l lVar = l.f264102a;
            if (QLog.isColorLevel()) {
                lVar.a().d("ExpandPluginLauncher", 2, "onInstallDownloadProgress " + p06 + " " + p16 + " " + p26 + " " + i3);
            }
            if (i3 == 100) {
                ExpandPluginLoadingFragment expandPluginLoadingFragment2 = (ExpandPluginLoadingFragment) ExpandPluginLauncher.this.mLoadingFragment.get();
                if (expandPluginLoadingFragment2 != null) {
                    expandPluginLoadingFragment2.Jh();
                }
                ExpandPluginLauncher.this.mIsDownloading = false;
            }
            ExpandPluginLoadingFragment expandPluginLoadingFragment3 = (ExpandPluginLoadingFragment) ExpandPluginLauncher.this.mLoadingFragment.get();
            if (expandPluginLoadingFragment3 != null) {
                expandPluginLoadingFragment3.Qh(i3);
            }
            if (ExpandPluginLauncher.this.mDownloadStartTime == 0) {
                ExpandPluginLauncher.this.mDownloadStartTime = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - ExpandPluginLauncher.this.mDownloadStartTime <= 300 || ExpandPluginLauncher.this.mComputeRemainTimeOnce) {
                return;
            }
            ExpandPluginLauncher.this.mComputeRemainTimeOnce = true;
            ExpandPluginLauncher expandPluginLauncher = ExpandPluginLauncher.this;
            expandPluginLauncher.u(p26 - p16, expandPluginLauncher.mTotalRxBytes);
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallError(String p06, int p16) {
            ExpandPluginLoadingFragment expandPluginLoadingFragment;
            l.f264102a.a().e("ExpandPluginLauncher", 1, "onInstallError " + p06 + " " + p16, null);
            if (ExpandPluginLauncher.this.r() && (expandPluginLoadingFragment = (ExpandPluginLoadingFragment) ExpandPluginLauncher.this.mLoadingFragment.get()) != null) {
                expandPluginLoadingFragment.Xh(LoadingStatus.LOADING_ERROR, 2, p16);
            }
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallFinish(String p06) {
            l lVar = l.f264102a;
            if (QLog.isColorLevel()) {
                lVar.a().d("ExpandPluginLauncher", 2, "onInstallFinish");
            }
            if (ExpandPluginLauncher.this.mLoadingFragment.get() != null) {
                ExpandPluginLauncher expandPluginLauncher = ExpandPluginLauncher.this;
                expandPluginLauncher.A(expandPluginLauncher.mHasDownload);
            }
        }
    }

    static {
        Lazy<ExpandPluginLauncher> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ExpandPluginLauncher>() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpandPluginLauncher invoke() {
                return new ExpandPluginLauncher();
            }
        });
        L = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(boolean hasDownload) {
        ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
        if (expandPluginLoadingFragment != null) {
            expandPluginLoadingFragment.Vh(0);
        }
        d.b g16 = new d.b(QBaseActivity.sTopActivity).b("com.tencent.mobileqq.shadowplugins.expand.ExpandMainActivity").g("expand-plugin");
        Intent intent = K;
        if (intent == null) {
            intent = v(hasDownload);
        }
        d.b e16 = g16.d(intent).e(new a.InterfaceC8440a() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.b
            @Override // com.tencent.mobileqq.qroute.module.a.InterfaceC8440a
            public final void a(boolean z16) {
                ExpandPluginLauncher.C(ExpandPluginLauncher.this, z16);
            }
        });
        com.tencent.mobileqq.qroute.module.a plugin = QRoute.plugin("expand");
        if (plugin.b()) {
            plugin.f(e16.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ExpandPluginLauncher this$0, boolean z16) {
        ExpandPluginLoadingFragment expandPluginLoadingFragment;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("ExpandPluginLauncher", 2, "open plugin result " + z16);
        }
        if (z16 || (expandPluginLoadingFragment = this$0.mLoadingFragment.get()) == null) {
            return;
        }
        ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING_ERROR, 1, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(ExpandPluginLauncher this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ExpandPluginLauncher", 2, "retry load");
        ExpandPluginLoadingFragment expandPluginLoadingFragment = this$0.mLoadingFragment.get();
        if (expandPluginLoadingFragment != null) {
            expandPluginLoadingFragment.Hh();
        }
        this$0.q();
    }

    private final void q() {
        QLog.d("ExpandPluginLauncher", 2, "checkAndLoadPlugin");
        G();
        if (s()) {
            l lVar = l.f264102a;
            if (QLog.isColorLevel()) {
                lVar.a().d("ExpandPluginLauncher", 2, "load plugin");
            }
            B(this, false, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        l.f264102a.a().e("ExpandPluginLauncher", 1, "onInstallError network error", null);
        ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
        if (expandPluginLoadingFragment == null) {
            return false;
        }
        ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
        return false;
    }

    private final boolean s() {
        if (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface) {
            com.tencent.mobileqq.qroute.module.a qrouteModule = QRoute.plugin("expand");
            if (qrouteModule.i()) {
                if (qrouteModule.b()) {
                    l lVar = l.f264102a;
                    if (QLog.isColorLevel()) {
                        lVar.a().d("ExpandPluginLauncher", 2, "plugin has  installed");
                    }
                    return true;
                }
                l lVar2 = l.f264102a;
                if (QLog.isColorLevel()) {
                    lVar2.a().d("ExpandPluginLauncher", 2, "plugin not installed");
                }
                ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
                if (expandPluginLoadingFragment != null) {
                    expandPluginLoadingFragment.Ih();
                }
                r();
                Intrinsics.checkNotNullExpressionValue(qrouteModule, "qrouteModule");
                z(qrouteModule);
                return false;
            }
            l.f264102a.a().e("ExpandPluginLauncher", 1, "plugin info is null", null);
        } else {
            l.f264102a.a().e("ExpandPluginLauncher", 1, "runtime not instance of QQAppInterface", null);
        }
        ExpandPluginLoadingFragment expandPluginLoadingFragment2 = this.mLoadingFragment.get();
        if (expandPluginLoadingFragment2 != null) {
            expandPluginLoadingFragment2.Ih();
        }
        ExpandPluginLoadingFragment expandPluginLoadingFragment3 = this.mLoadingFragment.get();
        if (expandPluginLoadingFragment3 != null) {
            ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment3, LoadingStatus.LOADING_ERROR, 1, 0, 4, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int remainSize, long startDownloadSize) {
        double a16 = this.mNetSpeedChecker.a(0.3d, remainSize, startDownloadSize);
        l lVar = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar.a().d("ExpandPluginLauncher", 2, "remainTime " + a16);
        }
        ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
        if (expandPluginLoadingFragment != null) {
            ExpandPluginLoadingFragment.Sh(expandPluginLoadingFragment, a16, 0.0d, 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Intent v(boolean hasDownload) {
        Object obj;
        Object obj2;
        Object obj3;
        String str;
        boolean z16;
        boolean z17;
        String valueOf;
        boolean isBlank;
        Intent intent = new Intent();
        ExpandManager x16 = x();
        Intrinsics.checkNotNull(x16);
        HashMap hashMap = new HashMap();
        Object obj4 = this.mExtraParams.get("sourceType");
        if (obj4 != null && Intrinsics.areEqual(obj4, (Object) 6)) {
            hashMap.put("isPresent", 1);
        } else {
            hashMap.put("isPresent", 0);
        }
        if (obj4 != null) {
            String reportFromPage = ExpandPublicFragmentActivity.getReportFromPage(((Integer) obj4).intValue());
            Intrinsics.checkNotNullExpressionValue(reportFromPage, "getReportFromPage(sourceType as Int)");
            hashMap.put("from", reportFromPage);
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(currentTimeMillis);
        hashMap.put("startTime", sb5.toString());
        String str2 = "0";
        if (QLog.isDebugVersion()) {
            obj = "0";
        } else {
            obj = "1";
        }
        hashMap.put("isRelease", obj);
        if (QLog.isDebugVersion()) {
            obj2 = "0";
        } else {
            obj2 = "1";
        }
        hashMap.put("serverEnv", obj2);
        hashMap.put("screenWidth", Integer.valueOf(ViewUtils.pxToDp(BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(ViewUtils.pxToDp(BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels)));
        if (x16.e() != null) {
            ExpandConfig e16 = x16.e();
            Intrinsics.checkNotNull(e16);
            String str3 = e16.centerBannerList;
            Intrinsics.checkNotNullExpressionValue(str3, "extendFriendManager.exte\u2026Config!!.centerBannerList");
            hashMap.put("centerBannerList", str3);
            ExpandConfig e17 = x16.e();
            Intrinsics.checkNotNull(e17);
            String str4 = e17.testStrId;
            if (str4 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str4);
                if (!isBlank) {
                    z16 = false;
                    z17 = !z16;
                    if (!z17) {
                        ExpandConfig e18 = x16.e();
                        Intrinsics.checkNotNull(e18);
                        valueOf = e18.testStrId;
                    } else if (!z17) {
                        ExpandConfig e19 = x16.e();
                        Intrinsics.checkNotNull(e19);
                        valueOf = String.valueOf(e19.testId);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    Intrinsics.checkNotNullExpressionValue(valueOf, "when (hasTestStrId) {\n  \u2026.toString()\n            }");
                    hashMap.put("testId", valueOf);
                }
            }
            z16 = true;
            z17 = !z16;
            if (!z17) {
            }
            Intrinsics.checkNotNullExpressionValue(valueOf, "when (hasTestStrId) {\n  \u2026.toString()\n            }");
            hashMap.put("testId", valueOf);
        }
        QLog.d("ExpandPluginLauncher", 4, "jump2FlutterExpandByWidgetName " + intent.getStringExtra("centerBannerList"));
        if (!x16.B()) {
            obj3 = "0";
        } else {
            obj3 = "1";
        }
        hashMap.put("isHasPersonalLabels", obj3);
        boolean C = x16.C();
        boolean c16 = x16.c();
        if (C == c16) {
            l lVar = l.f264102a;
            if (QLog.isColorLevel()) {
                lVar.a().d("ExpandPluginLauncher", 2, "usedNewMatch and firstPromptExtendFriendNewUser flag is the same");
            }
        }
        if (!C && c16) {
            hashMap.put("isUsedNewExpand", "0");
            x16.b0(false);
        } else {
            hashMap.put("isUsedNewExpand", "1");
        }
        hashMap.put("userCategory", String.valueOf(x16.X()));
        if (x16.T()) {
            str2 = "1";
        }
        hashMap.put("isHasNewUserMoment", str2);
        hashMap.put("isHasUpgradeIntroduce", String.valueOf(x16.a()));
        if (this.mExtraParams.containsKey("sourceType") && Intrinsics.areEqual(this.mExtraParams.get("sourceType"), (Object) 2)) {
            str = x16.i();
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (isLebaSource) extend\u2026ndManager.wavesId else \"\"");
        hashMap.put("wavesId", str);
        intent.putExtra("isDownloadPlugin", hasDownload);
        hashMap.put("jump", this.mJumpUrl);
        hashMap.put("serverTime", Long.valueOf(NetConnInfoCenter.getServerTime()));
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("jump2FlutterExpandByWidgetName params=%s", Arrays.copyOf(new Object[]{intent.toString()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d("ExpandPluginLauncher", 2, format);
        }
        l lVar2 = l.f264102a;
        if (QLog.isColorLevel()) {
            lVar2.a().d("ExpandPluginLauncher", 2, "jump2FlutterExpandByWidgetName params=" + hashMap);
        }
        return intent;
    }

    private final ExpandManager x() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        AppInterface appInterface = runtime instanceof AppInterface ? (AppInterface) runtime : null;
        Manager manager = appInterface != null ? appInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER) : null;
        if (manager instanceof ExpandManager) {
            return (ExpandManager) manager;
        }
        return null;
    }

    public static final ExpandPluginLauncher y() {
        return INSTANCE.a();
    }

    private final void z(com.tencent.mobileqq.qroute.module.a manager) {
        manager.d(new b());
    }

    public final void D(int pid) {
        this.mServiceStartedPid = pid;
    }

    public final void E(ExpandPluginLoadingFragment loadFragment) {
        Intrinsics.checkNotNullParameter(loadFragment, "loadFragment");
        if (this.mLoadingFragment.get() != null) {
            QLog.e("ExpandPluginLauncher", 2, "loading already exits!!");
            loadFragment.xh(5);
            return;
        }
        QLog.d("ExpandPluginLauncher", 2, "registerLoadingFragment " + System.identityHashCode(loadFragment));
        WeakReference<ExpandPluginLoadingFragment> weakReference = new WeakReference<>(loadFragment);
        this.mLoadingFragment = weakReference;
        ExpandPluginLoadingFragment expandPluginLoadingFragment = weakReference.get();
        if (expandPluginLoadingFragment != null) {
            expandPluginLoadingFragment.Nh(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqexpand.plugin.entrance.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandPluginLauncher.F(ExpandPluginLauncher.this, view);
                }
            });
        }
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.sApplication, this);
        q();
    }

    public final void H() {
        QLog.d("ExpandPluginLauncher", 2, "unregisterLoadingFragment " + System.identityHashCode(this.mLoadingFragment.get()));
        this.mLoadingFragment = new WeakReference<>(null);
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.sApplication, this);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        ExpandPluginLoadingFragment expandPluginLoadingFragment;
        if (!this.mIsDownloading || (expandPluginLoadingFragment = this.mLoadingFragment.get()) == null) {
            return;
        }
        ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String p06) {
        if (this.mIsDownloading) {
            G();
            ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
            if (expandPluginLoadingFragment != null) {
                ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING, 0, 0, 6, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String p06) {
        if (this.mIsDownloading) {
            G();
            ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
            if (expandPluginLoadingFragment != null) {
                ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING, 0, 0, 6, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        ExpandPluginLoadingFragment expandPluginLoadingFragment;
        if (!this.mIsDownloading || (expandPluginLoadingFragment = this.mLoadingFragment.get()) == null) {
            return;
        }
        ExpandPluginLoadingFragment.Yh(expandPluginLoadingFragment, LoadingStatus.LOADING_ERROR_NETWORK, 0, 0, 6, null);
    }

    public final void t(Bundle params) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.d("ExpandPluginLauncher", 2, "closeLoading " + System.identityHashCode(this.mLoadingFragment.get()) + " " + this.mServiceState + ", " + this.mServiceStartedPid);
        int i3 = params.getInt("pluginPid", 0);
        if (this.mServiceState == PluginServiceState.STARTED && this.mServiceStartedPid != i3) {
            this.mServiceState = PluginServiceState.NOT_STARTED;
        }
        ExpandPluginLoadingFragment expandPluginLoadingFragment = this.mLoadingFragment.get();
        if (expandPluginLoadingFragment != null) {
            expandPluginLoadingFragment.Lh(this.mPluginPid == i3, this.mServiceState);
            expandPluginLoadingFragment.xh(2);
        }
        this.mPluginPid = i3;
    }

    public final void w(Context activityContext, HashMap<String, Object> params, String jumpUrl) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.d("ExpandPluginLauncher", 1, "enterPlugin");
        if (System.currentTimeMillis() - this.mLastEnterTime < 1000) {
            QLog.e("ExpandPluginLauncher", 2, "error double enter");
            return;
        }
        this.mLastEnterTime = System.currentTimeMillis();
        if (jumpUrl == null) {
            jumpUrl = "";
        }
        this.mJumpUrl = jumpUrl;
        this.mExtraParams = params;
        int i3 = this.mServiceStartedPid;
        if (i3 != 0 && i3 == p.c("com.tencent.mobileqq:plugins")) {
            this.mServiceState = PluginServiceState.STARTED;
        }
        Intent intent = new Intent();
        intent.putExtra("plugin_process_id", this.mPluginPid);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicTransFragmentActivity.start(activityContext, intent, ExpandPluginLoadingFragment.class);
    }

    private final void G() {
        this.mHasDownload = false;
        this.mDownloadStartTime = 0L;
        this.mTotalRxBytes = 0L;
        this.mComputeRemainTimeOnce = false;
        this.mIsDownloading = false;
    }

    static /* synthetic */ void B(ExpandPluginLauncher expandPluginLauncher, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        expandPluginLauncher.A(z16);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String p06) {
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String p06) {
    }
}
