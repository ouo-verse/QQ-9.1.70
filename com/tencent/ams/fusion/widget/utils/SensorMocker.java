package com.tencent.ams.fusion.widget.utils;

import android.hardware.SensorEvent;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SensorMocker {
    static IPatchRedirector $redirector_ = null;
    private static final float NS2S = 1.0E-9f;
    private static final String TAG = "SensorMocker";
    private MockConfig mConfig;
    private MockEvent mCurrentEvent;
    private boolean mIsInitSuccess;
    private int mMockType;
    private long mStartTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class MockConfig {
        static IPatchRedirector $redirector_;
        final LinkedList<MockEvent> rotationEventList;
        final LinkedList<MockEvent> shakeEventList;

        MockConfig(String str) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SensorMocker.this, (Object) str);
                return;
            }
            LinkedList<MockEvent> linkedList = new LinkedList<>();
            this.shakeEventList = linkedList;
            LinkedList<MockEvent> linkedList2 = new LinkedList<>();
            this.rotationEventList = linkedList2;
            JSONObject jSONObject = new JSONObject(str);
            parseEvents(jSONObject.optJSONArray("shake"), linkedList);
            parseEvents(jSONObject.optJSONArray(BasicAnimation.KeyPath.ROTATION), linkedList2);
        }

        private void parseEvents(JSONArray jSONArray, LinkedList<MockEvent> linkedList) {
            if (jSONArray != null && linkedList != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        MockEvent mockEvent = new MockEvent(SensorMocker.this, null);
                        mockEvent.valueX = (float) optJSONObject.optDouble("valueX");
                        mockEvent.valueY = (float) optJSONObject.optDouble("valueY");
                        mockEvent.valueZ = (float) optJSONObject.optDouble("valueZ");
                        mockEvent.accuracy = optJSONObject.optInt("accuracy", 3);
                        mockEvent.timeFromStartMs = optJSONObject.optInt("timeFromStartMs");
                        linkedList.offer(mockEvent);
                    }
                }
                if (linkedList.size() > 0) {
                    Collections.sort(linkedList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class MockEvent implements Comparable<MockEvent> {
        static IPatchRedirector $redirector_;
        int accuracy;
        long timeFromStartMs;
        float valueX;
        float valueY;
        float valueZ;

        MockEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SensorMocker.this);
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "valueX: " + this.valueX + ", valueY: " + this.valueY + ", valueZ: " + this.valueZ + ", accuracy: " + this.accuracy + ", timeFromStartMs: " + this.timeFromStartMs;
        }

        /* synthetic */ MockEvent(SensorMocker sensorMocker, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sensorMocker, (Object) anonymousClass1);
        }

        @Override // java.lang.Comparable
        public int compareTo(MockEvent mockEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mockEvent)).intValue();
            }
            long j3 = this.timeFromStartMs;
            long j16 = mockEvent.timeFromStartMs;
            if (j3 > j16) {
                return 1;
            }
            return j3 < j16 ? -1 : 0;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MockType {
        public static final int ROTATION = 1;
        public static final int SHAKE = 0;
    }

    public SensorMocker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            init(FusionWidgetConfig.getMockSensorConfig());
        }
    }

    private void init(String str) {
        try {
            this.mConfig = new MockConfig(str);
            this.mIsInitSuccess = true;
        } catch (Throwable unused) {
            Logger.w(TAG, "init failed");
        }
    }

    private void pollEvent() {
        LinkedList<MockEvent> linkedList;
        if (this.mMockType == 0) {
            linkedList = this.mConfig.shakeEventList;
        } else {
            linkedList = this.mConfig.rotationEventList;
        }
        this.mCurrentEvent = linkedList.poll();
    }

    public float[] mockRotation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (float[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!this.mIsInitSuccess) {
            Logger.w(TAG, "injectSensorEvent failed: init not success");
            return null;
        }
        MockEvent mockEvent = this.mCurrentEvent;
        if (mockEvent == null || System.currentTimeMillis() - this.mStartTime < mockEvent.timeFromStartMs) {
            return null;
        }
        pollEvent();
        return new float[]{mockEvent.valueX, mockEvent.valueY, mockEvent.valueZ};
    }

    public void mockSensorEvent(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensorEvent);
            return;
        }
        if (!this.mIsInitSuccess) {
            Logger.w(TAG, "injectSensorEvent failed: init not success");
            return;
        }
        MockEvent mockEvent = this.mCurrentEvent;
        if (mockEvent != null && System.currentTimeMillis() - this.mStartTime >= mockEvent.timeFromStartMs) {
            sensorEvent.accuracy = mockEvent.accuracy;
            float[] fArr = sensorEvent.values;
            fArr[0] = mockEvent.valueX;
            fArr[1] = mockEvent.valueY;
            fArr[2] = mockEvent.valueZ;
            pollEvent();
        }
    }

    public void startMock(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        Logger.i(TAG, "startMock: " + i3);
        if (!this.mIsInitSuccess) {
            Logger.w(TAG, "startMock failed: init not success");
            return;
        }
        this.mMockType = i3;
        this.mStartTime = System.currentTimeMillis();
        pollEvent();
    }
}
