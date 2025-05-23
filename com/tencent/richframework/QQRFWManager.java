package com.tencent.richframework;

import androidx.fragment.app.Argus;
import androidx.recyclerview.widget.ArgusRecycleViewPreloader;
import androidx.recyclerview.widget.GapWorkerCompat;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.delegate.IConfigDelegate;
import com.tencent.biz.richframework.delegate.ILogDelegate;
import com.tencent.biz.richframework.delegate.ISoLoadDelegate;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWDelegate;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.mobileqq.qcircle.api.IRecyclerViewEventApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rfw.common.api.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.ArgusPageMonitor;
import com.tencent.richframework.argus.ArgusRecyclerMonitor;
import com.tencent.richframework.argus.business.performance.function.sample.ArgusMonitorSampleHelper;
import com.tencent.richframework.delegate.RFWApplicationImpl;
import com.tencent.richframework.delegate.RFWCommonConfigImpl;
import com.tencent.richframework.delegate.RFWConfigImpl;
import com.tencent.richframework.delegate.RFWLogImpl;
import com.tencent.richframework.delegate.RFWSoLoadImpl;
import com.tencent.richframework.delegate.RFWThreadLooperImpl;
import com.tencent.richframework.delegate.RFWThreadPoolExecuteListenerImpl;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import com.tencent.richframework.strategy.GlobalPicLoadStrategy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/richframework/QQRFWManager;", "", "", "initDelegate", "init", "<init>", "()V", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QQRFWManager {

    @NotNull
    public static final QQRFWManager INSTANCE = new QQRFWManager();

    QQRFWManager() {
    }

    private final void initDelegate() {
        RFWDelegate.registerDelegate(IApplicationDelegate.class, RFWApplicationImpl.class);
        RFWDelegate.registerDelegate(ILogDelegate.class, RFWLogImpl.class);
        RFWDelegate.registerDelegate(IConfigDelegate.class, RFWConfigImpl.class);
        RFWDelegate.registerDelegate(ISoLoadDelegate.class, RFWSoLoadImpl.class);
        RFWDelegate.registerDelegate(a.class, RFWCommonConfigImpl.class);
    }

    public final void init() {
        initDelegate();
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new GlobalPicLoadStrategy());
        RFWThreadManager.setErrorLooperDelegate(new RFWThreadLooperImpl());
        if (!RFWApplication.isPublicVersion()) {
            RFWThreadManager.setExecuteListener(new RFWThreadPoolExecuteListenerImpl());
        }
        RFWLifecycleHelper.getInstance().init(MobileQQ.sMobileQQ);
        ArrayList arrayList = new ArrayList();
        ArgusMonitorSampleHelper argusMonitorSampleHelper = ArgusMonitorSampleHelper.INSTANCE;
        if (argusMonitorSampleHelper.isOpenPreloadSample()) {
            QLog.d("QQRFWManager", 1, "open ArgusPreloadProvider");
            arrayList.add(ArgusRecycleViewPreloader.INSTANCE);
            ((IRecyclerViewEventApi) QRoute.api(IRecyclerViewEventApi.class)).isOpenPreload(true);
        }
        if (argusMonitorSampleHelper.isOpenReportSample()) {
            QLog.d("QQRFWManager", 1, "open ArgusRecyclerMonitor");
            arrayList.add(new ArgusRecyclerMonitor());
        }
        if (argusMonitorSampleHelper.isOpenPageSample()) {
            QLog.d("QQRFWManager", 1, "open ArgusPageMonitor");
            ArgusPageMonitor argusPageMonitor = ArgusPageMonitor.INSTANCE;
            arrayList.add(argusPageMonitor);
            Argus.INSTANCE.registerComponentCallback(argusPageMonitor);
        }
        GapWorkerCompat.hookGapWorker(arrayList);
    }
}
