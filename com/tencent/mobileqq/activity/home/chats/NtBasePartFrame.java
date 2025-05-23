package com.tencent.mobileqq.activity.home.chats;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.ILazyLoader;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.interfaces.IContextOwner;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public abstract class NtBasePartFrame implements IPartHost {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected View f182862d;

    /* renamed from: e, reason: collision with root package name */
    protected PartManager f182863e;

    /* renamed from: f, reason: collision with root package name */
    protected PartManager f182864f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f182865h;

    /* renamed from: i, reason: collision with root package name */
    protected QBaseActivity f182866i;

    public NtBasePartFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f182865h = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (!(this instanceof ILazyLoader) || this.f182865h) {
            return;
        }
        ILazyLoader iLazyLoader = (ILazyLoader) this;
        if (z16 || !iLazyLoader.isLazyLoad()) {
            iLazyLoader.load();
            this.f182865h = true;
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            A(false);
        }
    }

    public void C(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        PartManager partManager = this.f182863e;
        if (partManager != null) {
            partManager.onActivityResult(i3, i16, intent);
        }
        PartManager partManager2 = this.f182864f;
        if (partManager2 != null) {
            partManager2.onActivityResult(i3, i16, intent);
        }
    }

    public boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        QLog.i(q(), 1, "onBackEvent");
        if (r() != null && r().onBackEvent()) {
            return true;
        }
        if (p() != null && p().onBackEvent()) {
            return true;
        }
        return false;
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        return false;
    }

    public void F(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) appRuntime);
        }
    }

    public void G(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) configuration);
            return;
        }
        PartManager partManager = this.f182863e;
        if (partManager != null) {
            partManager.onConfigurationChanged(configuration);
        }
        PartManager partManager2 = this.f182864f;
        if (partManager2 != null) {
            partManager2.onConfigurationChanged(configuration);
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("NtBasePartFrame", 2, "[onCreate]");
        PartManager r16 = r();
        this.f182863e = r16;
        r16.registerPart(d());
    }

    public View I(LayoutInflater layoutInflater, ViewGroup viewGroup, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, this, layoutInflater, viewGroup, view, bundle);
        }
        this.f182862d = view;
        view.setTag(TagData.TAG_DATA_ID, f());
        e(layoutInflater, viewGroup);
        i(layoutInflater, viewGroup, bundle);
        QLog.i(q(), 1, "onCreateView");
        return this.f182862d;
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            QLog.i(q(), 1, "onKernelInitComplete");
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        }
    }

    public void N(RecyclerView recyclerView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) recyclerView, i3);
        }
    }

    public void O(RecyclerView recyclerView, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        }
    }

    public void Q(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) appRuntime);
        }
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        }
    }

    public void S(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity);
        } else {
            this.f182866i = qBaseActivity;
        }
    }

    public void a(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) appRuntime);
        }
    }

    protected abstract List<Part> d();

    protected void e(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
    }

    protected Object f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new Object();
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public Activity getHostActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (Activity) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.f182866i;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public Context getHostContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Context) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        if (this.f182862d.getContext() != null) {
            return this.f182862d.getContext();
        }
        return this.f182866i;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public Object getViewTagData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, (Object) this);
        }
        View view = this.f182862d;
        if (view != null) {
            return view.getTag(TagData.TAG_DATA_ID);
        }
        return null;
    }

    protected void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        try {
            PartManager partManager = this.f182863e;
            if (partManager != null) {
                partManager.onPartDestroy(o());
                this.f182863e = null;
            }
            PartManager partManager2 = this.f182864f;
            if (partManager2 != null) {
                partManager2.onPartDestroy(o());
                this.f182864f = null;
            }
        } catch (Throwable th5) {
            RFWLog.fatal(q(), RFWLog.USR, th5);
        }
    }

    protected void i(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, layoutInflater, viewGroup, bundle);
            return;
        }
        PartManager partManager = this.f182863e;
        if (partManager != null) {
            partManager.setParentView(viewGroup);
            this.f182863e.setRootView(this.f182862d);
            this.f182863e.onPartCreate(o(), bundle);
        }
    }

    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        try {
            PartManager partManager = this.f182863e;
            if (partManager != null) {
                partManager.onPartPause(o());
            }
            PartManager partManager2 = this.f182864f;
            if (partManager2 != null) {
                partManager2.onPartPause(o());
            }
        } catch (Throwable th5) {
            QLog.i(q(), 1, "onActivityPaused", th5);
        }
    }

    protected void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        try {
            PartManager partManager = this.f182863e;
            if (partManager != null) {
                partManager.onPartResume(o());
            }
            PartManager partManager2 = this.f182864f;
            if (partManager2 != null) {
                partManager2.onPartResume(o());
            }
        } catch (Throwable th5) {
            QLog.i(q(), 1, "onActivityResumed", th5);
        }
    }

    protected void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            PartManager partManager = this.f182863e;
            if (partManager != null) {
                partManager.onPartStart(o());
            }
            PartManager partManager2 = this.f182864f;
            if (partManager2 != null) {
                partManager2.onPartStart(o());
            }
        } catch (Throwable th5) {
            RFWLog.e(q(), RFWLog.USR, "onStart error:" + th5.toString());
        }
    }

    protected void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        try {
            PartManager partManager = this.f182863e;
            if (partManager != null) {
                partManager.onPartStop(o());
            }
            PartManager partManager2 = this.f182864f;
            if (partManager2 != null) {
                partManager2.onPartStop(o());
            }
        } catch (Throwable th5) {
            QLog.i(q(), 1, "onActivityStopped", th5);
        }
    }

    public Activity o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Activity) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f182866i;
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            QLog.i(q(), 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            h();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QLog.i(q(), 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            j();
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.i(q(), 1, "onResume");
        A(true);
        k();
    }

    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            l();
        }
    }

    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            QLog.i(q(), 1, DKHippyEvent.EVENT_STOP);
            m();
        }
    }

    public PartManager p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (PartManager) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.f182864f == null) {
            this.f182864f = new PartManager(this, this.f182862d);
        }
        return this.f182864f;
    }

    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return getClass().getName();
    }

    public PartManager r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PartManager) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f182863e == null) {
            this.f182863e = new PartManager(this, this.f182862d);
        }
        return this.f182863e;
    }

    public <T extends ViewModel> T s(IPartHost iPartHost, String str, Class<T> cls) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (T) iPatchRedirector.redirect((short) 32, this, iPartHost, str, cls);
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(iPartHost);
        if (str == null) {
            str2 = cls.getCanonicalName();
        } else {
            str2 = str + cls.getCanonicalName();
        }
        T t16 = (T) viewModelProvider.get(str2, cls);
        if ((t16 instanceof IContextOwner) && getHostActivity() != null) {
            ((IContextOwner) t16).setContextHashCode(getHostActivity().hashCode());
        }
        return t16;
    }

    public <T extends ViewModel> T t(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (T) iPatchRedirector.redirect((short) 29, (Object) this, (Object) cls);
        }
        return (T) getViewModel(null, cls);
    }

    public void u(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) intent);
        }
    }

    public boolean v(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("NtBasePartFrame", 2, "[lazyCreate]");
        PartManager p16 = p();
        this.f182864f = p16;
        p16.registerPart(assembleParts());
        this.f182864f.setRootView(this.f182862d);
        this.f182864f.onPartCreate(o(), null);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.NtBasePartFrame.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtBasePartFrame.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                NtBasePartFrame ntBasePartFrame = NtBasePartFrame.this;
                PartManager partManager = ntBasePartFrame.f182864f;
                if (partManager != null) {
                    partManager.onPartResume(ntBasePartFrame.o());
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public <T extends ViewModel> T getViewModel(String str, Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) ? (T) s(this, str, cls) : (T) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, (Object) cls);
    }
}
