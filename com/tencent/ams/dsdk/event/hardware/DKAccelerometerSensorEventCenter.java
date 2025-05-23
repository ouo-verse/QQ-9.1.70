package com.tencent.ams.dsdk.event.hardware;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Handler;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DKAccelerometerSensorEventCenter extends DKSensorEventCenter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKAccelerometerSensorEventCenter";
    private WeakReference<EventParamsBuilder> mEventParamsBuilder;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface EventParamsBuilder {
        JSONObject build(float f16, float f17, float f18);
    }

    public DKAccelerometerSensorEventCenter(WeakReference<DKEngine> weakReference, Handler handler, int i3) {
        super(weakReference, handler, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, weakReference, handler, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventParamsBuilderImpl(WeakReference<EventParamsBuilder> weakReference) {
        this.mEventParamsBuilder = weakReference;
    }

    @Override // com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter
    protected JSONObject createParams(SensorEvent sensorEvent) {
        float[] fArr;
        EventParamsBuilder eventParamsBuilder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this, (Object) sensorEvent);
        }
        if (sensorEvent != null && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            WeakReference<EventParamsBuilder> weakReference = this.mEventParamsBuilder;
            if (weakReference != null) {
                eventParamsBuilder = weakReference.get();
            } else {
                eventParamsBuilder = null;
            }
            if (eventParamsBuilder == null) {
                DLog.e(TAG, "[createParams] error, builder is null");
                return null;
            }
            return eventParamsBuilder.build(f16, f17, f18);
        }
        DLog.e(TAG, "[createParams] error, event is null");
        return null;
    }

    @Override // com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter
    protected int getSensorType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter
    public /* bridge */ /* synthetic */ void register(Context context) {
        super.register(context);
    }

    public void setEventParamsBuilder(WeakReference<EventParamsBuilder> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
        } else {
            run(new Runnable(weakReference) { // from class: com.tencent.ams.dsdk.event.hardware.DKAccelerometerSensorEventCenter.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ WeakReference val$builder;

                {
                    this.val$builder = weakReference;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKAccelerometerSensorEventCenter.this, (Object) weakReference);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKAccelerometerSensorEventCenter.this.setEventParamsBuilderImpl(this.val$builder);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter
    public /* bridge */ /* synthetic */ void setUpdateIntervalMillis(long j3) {
        super.setUpdateIntervalMillis(j3);
    }

    @Override // com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter
    public /* bridge */ /* synthetic */ void setUpdateIntervalMillisImpl(long j3) {
        super.setUpdateIntervalMillisImpl(j3);
    }

    @Override // com.tencent.ams.dsdk.event.hardware.DKSensorEventCenter
    public /* bridge */ /* synthetic */ void unRegister(Context context) {
        super.unRegister(context);
    }
}
