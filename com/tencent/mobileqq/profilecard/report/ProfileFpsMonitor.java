package com.tencent.mobileqq.profilecard.report;

import com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/profilecard/report/ProfileFpsMonitor;", "Lcom/tencent/biz/richframework/monitor/local/RFWAbsMonitorProxy;", "()V", "isEnabledTracePrint", "", "isWnsEnabledCollect", "onBeginFPSFrameMonitor", "", "scene", "", "onEndFPSFrameMonitor", "onFrameInfo", "info", "Lcom/tencent/biz/richframework/monitor/local/fps/RFWDropFrameCollector$DropFrameInfo;", "isReportInfo", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileFpsMonitor extends RFWAbsMonitorProxy {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final ArrayList<Float> fpsRecordList;

    @NotNull
    private static final String tag = "ProfileFpsMonitor";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/profilecard/report/ProfileFpsMonitor$Companion;", "", "()V", "fpsRecordList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tag", "", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            fpsRecordList = new ArrayList<>();
        }
    }

    public ProfileFpsMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledTracePrint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isWnsEnabledCollect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ProfilePerformanceHelper.isEnable();
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onBeginFPSFrameMonitor(@Nullable String scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) scene);
            return;
        }
        QLog.i(tag, 1, "onBeginFPSFrameMonitor,scene=" + scene);
        fpsRecordList.clear();
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onEndFPSFrameMonitor(@Nullable String scene) {
        double averageOfFloat;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) scene);
            return;
        }
        ArrayList<Float> arrayList = fpsRecordList;
        if (!arrayList.isEmpty() && scene != null) {
            averageOfFloat = CollectionsKt___CollectionsKt.averageOfFloat(arrayList);
            int i3 = (int) averageOfFloat;
            QLog.i(tag, 1, "onEndFPSFrameMonitor,scene=" + scene + ",fps=" + i3);
            ProfilePerformanceHelper.reportFps(scene, i3);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onFrameInfo(@Nullable RFWDropFrameCollector.DropFrameInfo info, boolean isReportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, info, Boolean.valueOf(isReportInfo));
            return;
        }
        if (info != null) {
            fpsRecordList.add(Float.valueOf(info.getFps()));
        }
        if (info != null) {
            i3 = (int) info.getFps();
        }
        QLog.i(tag, 1, "record_fps=" + i3);
    }
}
