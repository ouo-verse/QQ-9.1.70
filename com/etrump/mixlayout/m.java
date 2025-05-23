package com.etrump.mixlayout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m extends Observable {

    /* renamed from: i, reason: collision with root package name */
    private static m f32763i;

    /* renamed from: d, reason: collision with root package name */
    private ETEngine f32767d;

    /* renamed from: e, reason: collision with root package name */
    private ETEngine f32768e;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f32769f;

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f32764a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f32765b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Integer, k> f32766c = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private EIPCResultCallback f32770g = new a();

    /* renamed from: h, reason: collision with root package name */
    private EIPCResultCallback f32771h = new b();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (eIPCResult.code == 0) {
                m.this.setChanged();
                m.this.notifyObservers(2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements EIPCResultCallback {
        b() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            boolean z16 = false;
            if (eIPCResult.data.getInt("font_type") == 1) {
                z16 = m.this.f(false);
            }
            if (z16) {
                m.this.setChanged();
                m.this.notifyObservers(1);
            }
        }
    }

    m() {
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("VasFont", 0);
        this.f32769f = newFreeHandlerThread;
        newFreeHandlerThread.start();
    }

    public static synchronized m e() {
        m mVar;
        synchronized (m.class) {
            if (f32763i == null) {
                f32763i = new m();
            }
            mVar = f32763i;
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z16) {
        Exception e16;
        boolean z17;
        boolean z18 = false;
        if (!g(z16)) {
            return false;
        }
        this.f32767d = ETEngine.getInstance();
        this.f32768e = ETEngine.getInstanceForAnimation();
        ETEngine.isSOLoaded.set(true);
        try {
            z17 = this.f32767d.initEngine(5, 2097152);
            if (z17) {
                try {
                    if (this.f32768e.initEngine(3, 1048576)) {
                        z18 = true;
                    }
                } catch (Exception e17) {
                    e16 = e17;
                    QLog.e("FontManagerConstants.TOOL", 1, "initHYEngine error: ", e16);
                    return z17;
                }
            }
            this.f32764a.set(z18);
            return z18;
        } catch (Exception e18) {
            boolean z19 = z18;
            e16 = e18;
            z17 = z19;
        }
    }

    private boolean g(boolean z16) {
        String str = VasFontIPCModule.H;
        int loadLibrary = VasSoUtils.loadLibrary(VasSoUtils.getSoDir(1), FontSoBusiness.HY_FONT_SO_NAME);
        if (loadLibrary == 0) {
            return true;
        }
        if ((loadLibrary == 1 || loadLibrary == 2) && z16) {
            QIPCClientHelper.getInstance().callServer("VasFontIPCModule", str, null, this.f32771h);
        }
        return false;
    }

    public k d(int i3, int i16) {
        k kVar = this.f32766c.get(Integer.valueOf(i3));
        if (kVar == null) {
            boolean checkFontExist = FontManagerConstants.checkFontExist(i3, i16);
            String tTFPath = FontManagerConstants.getTTFPath(i3, i16);
            if (!checkFontExist) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", i3);
                bundle.putInt("font_type", i16);
                QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.J, bundle, this.f32770g);
            }
            boolean z16 = true;
            if (i16 != 1) {
                if (i16 == 2 && checkFontExist) {
                    k kVar2 = new k(i3, i16, tTFPath);
                    kVar2.f32754d = Typeface.createFromFile(tTFPath);
                    this.f32766c.put(Integer.valueOf(i3), kVar2);
                    return kVar2;
                }
                return kVar;
            }
            if (this.f32765b.compareAndSet(false, true)) {
                f(true);
            }
            if (this.f32764a.get() && checkFontExist) {
                if (!this.f32767d.native_loadFont(tTFPath, i3, false) || !this.f32768e.native_loadFont(tTFPath, i3, false)) {
                    z16 = false;
                }
                if (z16) {
                    k kVar3 = new k(i3, i16, tTFPath);
                    this.f32766c.put(Integer.valueOf(i3), kVar3);
                    return kVar3;
                }
                return kVar;
            }
            return kVar;
        }
        return kVar;
    }
}
