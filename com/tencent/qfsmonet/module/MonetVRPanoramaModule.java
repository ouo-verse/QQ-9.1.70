package com.tencent.qfsmonet.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.module.singleinput.IMonetVRPanoramaModule;
import com.tencent.qfsmonet.module.MonetModuleInner;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import com.tencent.qfsmonet.module.operator.vr.MonetVRBarrelDistortionOperator;
import com.tencent.qfsmonet.module.operator.vr.MonetVRSphereOperator;
import com.tencent.qfsmonet.process.common.MonetCommonParams;
import com.tencent.qfsmonet.process.core.MonetProcessParams;
import com.tencent.qfsmonet.utils.d;
import com.tencent.qfsmonet.utils.device.b;
import com.tencent.qfsmonet.utils.math.a;
import java.util.ArrayList;
import java.util.Arrays;

@MonetModuleInner.ModuleAnnotation("MonetVRPanoramaModule")
/* loaded from: classes22.dex */
public class MonetVRPanoramaModule extends MonetModuleInner implements IMonetVRPanoramaModule {
    static IPatchRedirector $redirector_ = null;
    private static final float CONSTANT_ANGLE_MAX = 90.0f;
    private static final float CONSTANT_ANGLE_MIN = 0.03f;
    private static final int CONSTANT_SAMPLE_TIMES = 3;
    private static final MonetOperatorData INPUT_DATA;
    private static final String MODULE_INPUT = "vr_panorama_input";
    private static final String MODULE_NAME = "MonetVRPanorama";
    private static final String TAG = "MonetVRPanoramaModule";
    private float mAngleX;
    private float mAngleY;
    private Context mAppContext;
    private a.C9303a mBDCameraMatrix;
    private float[] mBDModelPosition;
    private com.tencent.qfsmonet.utils.math.a mBarrelDistortionCamera;
    private MonetVRBarrelDistortionOperator mBarrelDistortionOperator;
    private float mDeltaY;
    private float mInitAziDiff;
    private float mInitAziSum;
    private float mInitAzimuth;
    private int mSampleTimes;
    private b mSensor;
    private float[] mSensorMatrix;
    private a.C9303a mSphereCameraMatrix;
    private float[] mSphereModelPosition;
    private MonetVRSphereOperator mSphereOperator;
    private com.tencent.qfsmonet.utils.math.a mSphereVRCamera;
    private int mVRType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INPUT_DATA = new MonetOperatorData(MODULE_INPUT, 6408);
        }
    }

    public MonetVRPanoramaModule() {
        super(MODULE_NAME, INPUT_DATA);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSphereOperator = new MonetVRSphereOperator();
        this.mBarrelDistortionOperator = new MonetVRBarrelDistortionOperator();
        this.mSphereVRCamera = new com.tencent.qfsmonet.utils.math.a();
        this.mBarrelDistortionCamera = new com.tencent.qfsmonet.utils.math.a();
        this.mBDCameraMatrix = null;
        this.mSphereCameraMatrix = null;
        this.mBDModelPosition = new float[16];
        this.mSensorMatrix = new float[16];
        this.mSphereModelPosition = new float[16];
        this.mAppContext = null;
        this.mSensor = null;
        this.mVRType = 1;
        this.mSampleTimes = 0;
        this.mInitAzimuth = 0.0f;
        this.mInitAziSum = 0.0f;
        this.mInitAziDiff = 0.0f;
        this.mAngleX = 0.0f;
        this.mAngleY = 0.0f;
        this.mDeltaY = 0.0f;
        setUpOps();
        getApplicationContext();
        initSensor();
    }

    private void calcBDCameraMatrix() {
        this.mBarrelDistortionCamera.e(2);
        Matrix.setIdentityM(this.mBDModelPosition, 0);
        this.mBDCameraMatrix = this.mBarrelDistortionCamera.a(this.mBDModelPosition);
    }

    private synchronized void calcSphereCameraMatrix() {
        updateSurfaceSize();
        this.mSphereVRCamera.f(this.mSensorMatrix);
        this.mSphereVRCamera.d(2, this.mAngleX);
        this.mSphereVRCamera.d(1, this.mAngleY);
        Matrix.setIdentityM(this.mSphereModelPosition, 0);
        Matrix.rotateM(this.mSphereModelPosition, 0, this.mInitAziDiff, 0.0f, 0.0f, 1.0f);
        this.mSphereCameraMatrix = this.mSphereVRCamera.a(this.mSphereModelPosition);
    }

    @SuppressLint({"PrivateApi"})
    private void getApplicationContext() {
        this.mAppContext = MonetCommonParams.getApplicationContext();
    }

    private ArrayList<MonetProcessParams> getVRParamsList() {
        int i3;
        ArrayList<MonetProcessParams> arrayList = new ArrayList<>();
        if (this.mVRType == 2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        arrayList.add(createMonetParam(this.mBarrelDistortionOperator, MonetVRBarrelDistortionOperator.BD_VR_ENABLE_KEY, Integer.toString(i3)));
        arrayList.add(createMonetParam(this.mSphereOperator, MonetVRSphereOperator.SPHERE_VR_WIDTH_KEY, this.mModuleCommonParams.get(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_WIDTH)));
        arrayList.add(createMonetParam(this.mSphereOperator, MonetVRSphereOperator.SPHERE_VR_HEIGHT_KEY, this.mModuleCommonParams.get(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_HEIGHT)));
        arrayList.add(createMonetParam(this.mBarrelDistortionOperator, MonetVRBarrelDistortionOperator.BARREL_DISTORTION_WIDTH_KEY, this.mModuleCommonParams.get(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_WIDTH)));
        arrayList.add(createMonetParam(this.mBarrelDistortionOperator, MonetVRBarrelDistortionOperator.BARREL_DISTORTION_HEIGHT_KEY, this.mModuleCommonParams.get(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_HEIGHT)));
        arrayList.add(createMonetParam(this.mSphereOperator, MonetVRSphereOperator.SPHERE_VR_MVP_MATRIX_KEY, Arrays.toString(this.mSphereCameraMatrix.f342650b)));
        arrayList.add(createMonetParam(this.mBarrelDistortionOperator, MonetVRBarrelDistortionOperator.MVP_MATRIX_KEY, Arrays.toString(this.mBDCameraMatrix.f342650b)));
        return arrayList;
    }

    private void initSensor() {
        this.mSensor = new b(this.mAppContext, null);
        Matrix.setIdentityM(this.mSensorMatrix, 0);
        this.mSensor.a(new com.tencent.qfsmonet.utils.device.a() { // from class: com.tencent.qfsmonet.module.a
            @Override // com.tencent.qfsmonet.utils.device.a
            public final void a(int i3, long j3, float[] fArr) {
                MonetVRPanoramaModule.this.lambda$initSensor$0(i3, j3, fArr);
            }
        });
        try {
            this.mSensor.b();
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b("MonetVRPanoramaModule", "sensor start failed " + e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSensor$0(int i3, long j3, float[] fArr) {
        int rotation = ((WindowManager) this.mAppContext.getSystemService("window")).getDefaultDisplay().getRotation();
        synchronized (this) {
            d.a(fArr, rotation, this.mSensorMatrix);
            measureDeviceOrientation(this.mSensorMatrix);
        }
    }

    private void measureDeviceOrientation(float[] fArr) {
        if (this.mSampleTimes >= 3) {
            return;
        }
        SensorManager.getOrientation(fArr, r0);
        float degrees = (float) Math.toDegrees(r0[0]);
        float[] fArr2 = {degrees};
        float f16 = this.mInitAziSum + degrees;
        this.mInitAziSum = f16;
        int i3 = this.mSampleTimes + 1;
        this.mSampleTimes = i3;
        if (i3 == 3) {
            float f17 = f16 / i3;
            this.mInitAzimuth = f17;
            this.mInitAziDiff = (-90.0f) - f17;
            com.tencent.qfsmonet.utils.a.c("MonetVRPanoramaModule", "device init azimuth: " + this.mInitAzimuth + ", with diff: " + this.mInitAziDiff);
        }
    }

    private void setUpOps() {
        this.mSphereOperator.addInput(INPUT_DATA);
        this.mBarrelDistortionOperator.addInput(this.mSphereOperator.getOutput().get(0));
    }

    private void updateSurfaceSize() {
        this.mSphereVRCamera.g(Integer.parseInt(this.mModuleCommonParams.get(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_WIDTH)), Integer.parseInt(this.mModuleCommonParams.get(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_HEIGHT)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    @NonNull
    public ArrayList<MonetOperator> build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<MonetOperator> arrayList = new ArrayList<>();
        try {
            arrayList.add(this.mSphereOperator);
            arrayList.add(this.mBarrelDistortionOperator);
        } catch (Exception e16) {
            com.tencent.qfsmonet.utils.a.b("MonetVRPanoramaModule", "build protocol, ex=" + e16.toString());
        }
        return arrayList;
    }

    MonetProcessParams createMonetParam(@NonNull MonetOperator monetOperator, String str, String str2) {
        return new MonetProcessParams(monetOperator.getOpIdentifier(), str, str2);
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetVRPanoramaModule
    public void doRotate(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        synchronized (this) {
            if (Math.abs(f16) > CONSTANT_ANGLE_MIN) {
                this.mAngleX -= f16;
            }
            if (Math.abs(f17) > CONSTANT_ANGLE_MIN) {
                this.mAngleY += f17;
            }
        }
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public ArrayList<MonetProcessParams> getModuleProcessParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        calcSphereCameraMatrix();
        calcBDCameraMatrix();
        return getVRParamsList();
    }

    @Override // com.tencent.qfsmonet.api.module.IMonetModule
    public String getModuleType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MonetVRPanoramaModule";
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public void moduleWillRemove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.qfsmonet.utils.a.c("MonetVRPanoramaModule", "module will remove, stop sensor");
            this.mSensor.c();
        }
    }

    @Override // com.tencent.qfsmonet.module.MonetModuleInner
    public void setCommonParameters(@NonNull String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else if (str.equals(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_WIDTH) || str.equals(MonetModuleRuntimeParams.PARAMS_KEY_SURFACE_HEIGHT)) {
            this.mModuleCommonParams.put(str, str2);
        }
    }

    @Override // com.tencent.qfsmonet.api.module.singleinput.IMonetVRPanoramaModule
    public synchronized void setVRType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mVRType = i3;
        }
    }
}
