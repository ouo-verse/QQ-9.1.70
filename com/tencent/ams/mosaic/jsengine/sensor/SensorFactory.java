package com.tencent.ams.mosaic.jsengine.sensor;

import android.content.Context;
import android.util.Log;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.sensor.impl.b;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SensorFactory implements ISensorFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Integer, Class<? extends MosaicSensor>> f71445c;

    /* renamed from: a, reason: collision with root package name */
    private Context f71446a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.ams.mosaic.jsengine.a f71447b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int CREATE_ERROR = 2;
        public static final int NOT_SUPPORT = 1;
        public static final int SENSOR_ERROR = 3;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface SensorType {
        public static final int ACCELEROMETER = 1;
        public static final int GYROSCOPE = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements a.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SensorFactory.this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onFail(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
            } else {
                Log.i("SensorFactory", "onError notify fail.");
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
            } else {
                Log.i("SensorFactory", "onError notify success.");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f71445c = new HashMap();
        b(1, com.tencent.ams.mosaic.jsengine.sensor.impl.a.class);
        b(2, b.class);
    }

    public SensorFactory(Context context, com.tencent.ams.mosaic.jsengine.a aVar) {
        Context context2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f71446a = context2;
        this.f71447b = aVar;
    }

    private void a(@ErrorCode int i3, String str, JSFunction jSFunction) {
        com.tencent.ams.mosaic.jsengine.a aVar;
        f.e("SensorFactory", "notify error, errorCode: " + i3 + ", msg: " + str);
        if (jSFunction != null && (aVar = this.f71447b) != null) {
            aVar.u(jSFunction, new Object[]{Integer.valueOf(i3), str}, new a());
        }
    }

    public static void b(@SensorType int i3, Class<? extends MosaicSensor> cls) {
        f71445c.put(Integer.valueOf(i3), cls);
    }

    @Override // com.tencent.ams.mosaic.jsengine.sensor.ISensorFactory
    public MosaicSensor createSensor(int i3, int i16, JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MosaicSensor) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), jSFunction, jSFunction2);
        }
        Class<? extends MosaicSensor> cls = f71445c.get(Integer.valueOf(i3));
        if (cls == null) {
            a(1, "not support mosaic sensor type.", jSFunction2);
            return null;
        }
        try {
            return cls.getConstructor(Context.class, com.tencent.ams.mosaic.jsengine.a.class, Integer.TYPE, JSFunction.class, JSFunction.class).newInstance(this.f71446a, this.f71447b, Integer.valueOf(i16), jSFunction, jSFunction2);
        } catch (Exception e16) {
            f.c("SensorFactory", "create mosaic sensor error.", e16);
            a(2, "create mosaic sensor error.", jSFunction2);
            return null;
        }
    }
}
