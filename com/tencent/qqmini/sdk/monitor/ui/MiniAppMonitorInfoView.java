package com.tencent.qqmini.sdk.monitor.ui;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.monitor.common.FPSCalculator;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.monitor.service.ThreadMsgInfo;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppMonitorInfoView extends FrameLayout {
    public static final String ACTION_SHOW_MONITOR_VIEW = "action.qq.miniapp.show.monitorview";
    private static final int REFRESH_MONITOR_DURATION = 1000;
    private static final String TAG = "MiniAppMonitorInfoView";
    public static long sDownloadDuration;
    private static final Action<Long> sGetDrawCallCountAction = new Action<Long>() { // from class: com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
        public Long perform(BaseRuntime baseRuntime) {
            return Long.valueOf(baseRuntime.getCurrentDrawCount());
        }
    };
    public static long sStartDuration;
    public static long sStartTime;
    private TextView mCpuRate;
    private TextView mCpuUsage;
    private TextView mDbCacheTv;
    private TextView mDownloadInfoTv;
    private TextView mDrawCallTv;
    private FpsListener mFpsListener;
    private TextView mFpsTv;
    private TextView mGraphicsTv;
    private View mInflateView;
    private final Handler mMainHandler;
    private IMiniAppContext mMiniAppContext;
    private int mMiniAppType;
    private TextView mNativePssTv;
    private TextView mPageSwitchTv;
    private final Runnable mRefreshRunnable;
    private TextView mStartDurationTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class FpsListener implements FPSCalculator.GetFPSListener {
        FpsListener() {
        }

        @Override // com.tencent.qqmini.sdk.monitor.common.FPSCalculator.GetFPSListener
        public void onInfo(long j3, double d16) {
            MiniAppMonitorInfoView miniAppMonitorInfoView = MiniAppMonitorInfoView.this;
            miniAppMonitorInfoView.updateFPSText(miniAppMonitorInfoView.mMiniAppContext, d16);
        }
    }

    public MiniAppMonitorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private long getDrawCallCount() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            return ((Long) iMiniAppContext.performAction(sGetDrawCallCountAction)).longValue();
        }
        return 0L;
    }

    private void updateMemoryText() {
        long j3;
        Debug.MemoryInfo processMemory = DeviceInfoUtil.getProcessMemory(Process.myPid());
        this.mNativePssTv.setText("NativePss: " + (processMemory.nativePss / 1024) + "MB");
        try {
            j3 = Integer.parseInt(processMemory.getMemoryStat("summary.graphics"));
        } catch (Exception e16) {
            QMLog.e(TAG, "updateMemoryText: get graphics failed.", e16);
            j3 = 0;
        }
        this.mGraphicsTv.setText("Graphics: " + (j3 / 1024) + "MB");
    }

    protected void initData() {
        TextView textView = this.mStartDurationTv;
        if (textView != null) {
            textView.setText("\u542f\u52a8\u8017\u65f6\uff1a" + sStartDuration + "ms");
            this.mStartDurationTv.setVisibility(0);
        }
        TextView textView2 = this.mDownloadInfoTv;
        if (textView2 != null) {
            textView2.setText("\u5305\u4e0b\u8f7d\u8017\u65f6\uff1a" + sDownloadDuration + "ms");
            this.mDownloadInfoTv.setVisibility(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        bringToFront();
    }

    public void setMiniAppType(int i3) {
        this.mMiniAppType = i3;
    }

    public void startRefreshMonitorUi() {
        this.mMainHandler.removeCallbacks(this.mRefreshRunnable);
        if (this.mMiniAppType == 0 && this.mFpsListener == null) {
            this.mFpsListener = new FpsListener();
            FPSCalculator.getInstance().addListener(this.mFpsListener);
        }
        this.mMainHandler.postDelayed(this.mRefreshRunnable, 1000L);
    }

    public void stopRefreshMonitorUi() {
        this.mMainHandler.removeCallbacks(this.mRefreshRunnable);
        if (this.mFpsListener != null) {
            FPSCalculator.getInstance().removeListener(this.mFpsListener);
        }
    }

    protected void updateData() {
        ThreadMsgInfo taskPerfmSwitchPageInfo = TaskMonitorManager.g().getTaskPerfmSwitchPageInfo();
        String str = "";
        if (taskPerfmSwitchPageInfo != null) {
            str = "\u5207\u6362\u9875\u9762\u8017\u65f6: " + taskPerfmSwitchPageInfo.realTimeCost + "ms";
        }
        TextView textView = this.mPageSwitchTv;
        if (textView != null) {
            if (taskPerfmSwitchPageInfo != null) {
                textView.setVisibility(0);
                this.mPageSwitchTv.setText(str);
            } else {
                textView.setText("\u5207\u6362\u9875\u9762\u8017\u65f6: \u65e0\u9875\u9762\u5207\u6362");
                this.mPageSwitchTv.setVisibility(0);
            }
        }
        TextView textView2 = this.mDrawCallTv;
        if (textView2 != null) {
            if (this.mMiniAppType == 1) {
                long drawCallCount = getDrawCallCount();
                this.mDrawCallTv.setText("drawCall: " + drawCallCount);
                this.mDrawCallTv.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        String cpuUsageRate = TaskMonitorManager.g().getCpuUsageRate();
        TextView textView3 = this.mCpuRate;
        if (textView3 != null) {
            textView3.setText(cpuUsageRate);
            this.mCpuRate.setVisibility(0);
        }
        String cpuUsageInfo = TaskMonitorManager.g().getCpuUsageInfo();
        TextView textView4 = this.mCpuUsage;
        if (textView4 != null) {
            textView4.setText(cpuUsageInfo);
            this.mCpuUsage.setVisibility(0);
        }
        String str2 = "\u5185\u5b58 \u4f7f\u7528\u7387: " + TaskMonitorManager.g().getMemeryUsage() + "%";
        TextView textView5 = this.mDbCacheTv;
        if (textView5 != null) {
            textView5.setText(str2);
            this.mDbCacheTv.setVisibility(0);
        }
        if (this.mMiniAppType == 1) {
            updateMemoryText();
        }
    }

    public void updateFPSText(IMiniAppContext iMiniAppContext, double d16) {
        this.mMiniAppContext = iMiniAppContext;
        if (this.mFpsTv != null) {
            this.mFpsTv.setText("\u5e27\u7387: " + String.format("%.0f", Double.valueOf(d16)) + "fps");
            TaskMonitorManager.g().setCurrentFps(d16);
        }
    }

    public MiniAppMonitorInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        this.mMiniAppType = 0;
        this.mMainHandler = ThreadManager.getUIHandler();
        this.mRefreshRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView.1
            @Override // java.lang.Runnable
            public void run() {
                MiniAppMonitorInfoView.this.updateData();
                MiniAppMonitorInfoView.this.mMainHandler.postDelayed(MiniAppMonitorInfoView.this.mRefreshRunnable, 1000L);
            }
        };
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_popup_monitor_layout, this);
        this.mInflateView = inflate;
        this.mPageSwitchTv = (TextView) inflate.findViewById(R.id.monitor_switch_page);
        this.mStartDurationTv = (TextView) this.mInflateView.findViewById(R.id.monitor_start_time);
        this.mDownloadInfoTv = (TextView) this.mInflateView.findViewById(R.id.monitor_download_package);
        this.mFpsTv = (TextView) this.mInflateView.findViewById(R.id.monitor_fps);
        this.mDrawCallTv = (TextView) this.mInflateView.findViewById(R.id.monitor_drawcall);
        this.mCpuRate = (TextView) this.mInflateView.findViewById(R.id.monitor_cpu_rate);
        this.mCpuUsage = (TextView) this.mInflateView.findViewById(R.id.monitor_cpu_usage);
        this.mDbCacheTv = (TextView) this.mInflateView.findViewById(R.id.monitor_db_cache);
        this.mNativePssTv = (TextView) this.mInflateView.findViewById(R.id.monitor_native_pss);
        this.mGraphicsTv = (TextView) this.mInflateView.findViewById(R.id.monitor_graphics);
        if (i3 == 1) {
            this.mNativePssTv.setVisibility(0);
            this.mGraphicsTv.setVisibility(0);
        } else {
            this.mNativePssTv.setVisibility(8);
            this.mGraphicsTv.setVisibility(8);
        }
        setMiniAppType(i3);
        initData();
    }
}
