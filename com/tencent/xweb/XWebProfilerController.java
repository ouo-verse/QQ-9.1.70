package com.tencent.xweb;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.a0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.d;
import com.tencent.luggage.wxa.tq.f;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.ConstValue;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes27.dex */
public class XWebProfilerController implements IProfilerController {

    /* renamed from: a, reason: collision with root package name */
    public boolean f385065a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f385066b;

    /* loaded from: classes27.dex */
    public static final class Holder {

        /* renamed from: a, reason: collision with root package name */
        public static final XWebProfilerController f385067a = new XWebProfilerController();
    }

    public static XWebProfilerController getInstance() {
        return Holder.f385067a;
    }

    public final boolean a(boolean z16, String str) {
        Object a16 = g.a(80013, new Object[]{Boolean.valueOf(z16), str});
        return (a16 instanceof Boolean) && ((Boolean) a16).booleanValue();
    }

    @Override // com.tencent.xweb.IProfilerController
    public void forceEnableFrameCostProfile(boolean z16) {
        if (z16) {
            n0.v();
            setProfileConfig(ConstValue.CATEGORY_FRAME_COST, 10000, 0, true);
        } else {
            n0.u();
            setProfileConfig(ConstValue.CATEGORY_FRAME_COST_DISABLE, 10000, 0, true);
        }
    }

    @Override // com.tencent.xweb.IProfilerController
    public void forceFlushCategory(String str) {
        g.a(ConstValue.INVOKE_RUNTIME_ID_XPROFILE_FORCE_FLUSH, new Object[]{str});
    }

    @Override // com.tencent.xweb.IProfilerController
    public void initProfile() {
        int i3;
        if (!this.f385065a) {
            String enabledTraceCategory = CommandCfg.getInstance().getEnabledTraceCategory(WebView.getModuleName());
            int traceRatioInTenThousand = CommandCfg.getInstance().getTraceRatioInTenThousand(WebView.getModuleName());
            String cmd = CommandCfg.getInstance().getCmd("enableWindowPerformanceSampleRatio", WebView.getModuleName());
            a0.a c16 = a0.c(cmd);
            if (c16.f121611a) {
                i3 = c16.b();
            } else {
                x0.f("XWebProfilerController", "initProfile error, enableWindowPerformanceSampleRatioStr:" + cmd);
                i3 = 0;
            }
            XWebProfilerController xWebProfilerController = getInstance();
            x0.d("XWebProfilerController", "setProfileConfig with enabledTraceCategory: " + enabledTraceCategory + " traceSampleRatio: " + traceRatioInTenThousand + " enableWindowPerformanceSampleRatio: " + i3);
            xWebProfilerController.setProfileConfig(enabledTraceCategory, traceRatioInTenThousand, i3, false);
            this.f385065a = true;
        }
    }

    public void onProfileStop(Object obj) {
        a(obj);
    }

    @Override // com.tencent.xweb.IProfilerController
    public void setAllKindsFpsProfileEnable(boolean z16) {
        if (z16) {
            n0.h();
        } else {
            n0.g();
        }
        g.a(ConstValue.INVOKE_RUNTIME_ID_XPROFILE_ENABLE_ALL_KINDS_FPS, new Object[]{Boolean.valueOf(z16)});
    }

    @Override // com.tencent.xweb.IProfilerController
    public void setProfileConfig(String str, int i3, int i16, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("enabledTraceCategory", str);
        bundle.putInt("traceSampleRatio", i3);
        bundle.putInt("enableWindowPerformanceSampleRatio", i16);
        bundle.putBoolean("forceUpdateEnabledCategory", z16);
        f b16 = g.b(WebView.WebViewKind.WV_KIND_PINUS);
        if (b16 != null && b16.getWebViewCoreWrapper() != null) {
            d webViewCoreWrapper = b16.getWebViewCoreWrapper();
            if (webViewCoreWrapper.hasFeature(6)) {
                x0.d("XWebProfilerController", "setProfileConfig, INTERNAL_XPROFILE_NEW_CORE");
                webViewCoreWrapper.invokeRuntimeChannel(80012, new Object[]{bundle});
            }
        }
    }

    @Override // com.tencent.xweb.IProfilerController
    public boolean setProfileResultCallback(String str, @Nullable IProfileResultCallback iProfileResultCallback) {
        if (iProfileResultCallback == null) {
            if (!this.f385066b.containsKey(str)) {
                return false;
            }
            this.f385066b.remove(str);
            a(false, str);
            return true;
        }
        if (!this.f385066b.containsKey(str) && !a(true, str)) {
            return false;
        }
        this.f385066b.put(str, iProfileResultCallback);
        return true;
    }

    public XWebProfilerController() {
        this.f385066b = new ConcurrentHashMap();
    }

    public final void a(Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            Object obj2 = objArr[0];
            if (!(obj2 instanceof String) || objArr.length < 2) {
                return;
            }
            String str = (String) obj2;
            IProfileResultCallback iProfileResultCallback = (IProfileResultCallback) this.f385066b.get(str);
            if (iProfileResultCallback != null) {
                iProfileResultCallback.onReceiveProfileResult(str, Arrays.copyOfRange(objArr, 1, objArr.length));
            }
        }
    }
}
