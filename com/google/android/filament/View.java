package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class View {
    private AmbientOcclusionOptions mAmbientOcclusionOptions;
    private BlendMode mBlendMode;
    private BloomOptions mBloomOptions;
    private Camera mCamera;
    private ColorGrading mColorGrading;
    private DepthOfFieldOptions mDepthOfFieldOptions;
    private DynamicResolutionOptions mDynamicResolution;
    private a mFogOptions;
    private b mGuardBandOptions;
    private c mMultiSampleAntiAliasingOptions;
    private String mName;
    private long mNativeObject;
    private RenderQuality mRenderQuality;
    private RenderTarget mRenderTarget;
    private Scene mScene;
    private f mScreenSpaceReflectionsOptions;
    private g mSoftShadowOptions;
    private h mTemporalAntiAliasingOptions;
    private Viewport mViewport = new Viewport(0, 0, 0, 0);
    private i mVignetteOptions;
    private j mVsmShadowOptions;
    private static final AntiAliasing[] sAntiAliasingValues = AntiAliasing.values();
    private static final Dithering[] sDitheringValues = Dithering.values();
    private static final AmbientOcclusion[] sAmbientOcclusionValues = AmbientOcclusion.values();

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public enum AmbientOcclusion {
        NONE,
        SSAO
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class AmbientOcclusionOptions {
        public boolean bentNormals;
        public boolean enabled;

        @NonNull
        public QualityLevel lowPassFilter;
        public float minHorizonAngleRad;

        @NonNull
        public QualityLevel quality;
        public float ssctContactDistanceMax;
        public float ssctDepthBias;
        public float ssctDepthSlopeBias;
        public boolean ssctEnabled;
        public float ssctIntensity;
        public float ssctLightConeRad;

        @NonNull
        @Size(min = 3)
        public float[] ssctLightDirection;
        public int ssctRayCount;
        public int ssctSampleCount;
        public float ssctShadowDistance;

        @NonNull
        public QualityLevel upsampling;
        public float radius = 0.3f;
        public float power = 1.0f;
        public float bias = 5.0E-4f;
        public float resolution = 0.5f;
        public float intensity = 1.0f;
        public float bilateralThreshold = 0.05f;

        public AmbientOcclusionOptions() {
            QualityLevel qualityLevel = QualityLevel.LOW;
            this.quality = qualityLevel;
            this.lowPassFilter = QualityLevel.MEDIUM;
            this.upsampling = qualityLevel;
            this.enabled = false;
            this.bentNormals = false;
            this.minHorizonAngleRad = 0.0f;
            this.ssctLightConeRad = 1.0f;
            this.ssctShadowDistance = 0.3f;
            this.ssctContactDistanceMax = 1.0f;
            this.ssctIntensity = 0.8f;
            this.ssctLightDirection = new float[]{0.0f, -1.0f, 0.0f};
            this.ssctDepthBias = 0.01f;
            this.ssctDepthSlopeBias = 0.01f;
            this.ssctSampleCount = 4;
            this.ssctRayCount = 1;
            this.ssctEnabled = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum AntiAliasing {
        NONE,
        FXAA
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum BlendMode {
        OPAQUE,
        TRANSLUCENT
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class BloomOptions {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public Texture f32984a = null;

        /* renamed from: b, reason: collision with root package name */
        public float f32985b = 0.2f;

        /* renamed from: c, reason: collision with root package name */
        public float f32986c = 0.1f;

        /* renamed from: d, reason: collision with root package name */
        public int f32987d = 360;

        /* renamed from: e, reason: collision with root package name */
        public float f32988e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public int f32989f = 6;

        /* renamed from: g, reason: collision with root package name */
        @NonNull
        public BlendMode f32990g = BlendMode.ADD;

        /* renamed from: h, reason: collision with root package name */
        public boolean f32991h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f32992i = false;

        /* renamed from: j, reason: collision with root package name */
        public float f32993j = 1000.0f;

        /* renamed from: k, reason: collision with root package name */
        public boolean f32994k = false;

        /* renamed from: l, reason: collision with root package name */
        public boolean f32995l = true;

        /* renamed from: m, reason: collision with root package name */
        public float f32996m = 0.005f;

        /* renamed from: n, reason: collision with root package name */
        public int f32997n = 4;

        /* renamed from: o, reason: collision with root package name */
        public float f32998o = 0.6f;

        /* renamed from: p, reason: collision with root package name */
        public float f32999p = 10.0f;

        /* renamed from: q, reason: collision with root package name */
        public float f33000q = 0.1f;

        /* renamed from: r, reason: collision with root package name */
        public float f33001r = 0.4f;

        /* renamed from: s, reason: collision with root package name */
        public float f33002s = 10.0f;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum BlendMode {
            ADD,
            INTERPOLATE
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DepthOfFieldOptions {

        /* renamed from: a, reason: collision with root package name */
        public float f33003a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f33004b = 0.01f;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33005c = false;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        public Filter f33006d = Filter.MEDIAN;

        /* renamed from: e, reason: collision with root package name */
        public boolean f33007e = false;

        /* renamed from: f, reason: collision with root package name */
        public int f33008f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f33009g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f33010h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f33011i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f33012j = 0;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum Filter {
            NONE,
            UNUSED,
            MEDIAN
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Dithering {
        NONE,
        TEMPORAL
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DynamicResolutionOptions {
        public float minScale = 0.5f;
        public float maxScale = 1.0f;
        public float sharpness = 0.9f;
        public boolean enabled = false;
        public boolean homogeneousScaling = false;

        @NonNull
        public QualityLevel quality = QualityLevel.LOW;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class InternalOnPickCallback implements Runnable {
        float mDepth;
        float mFragCoordsX;
        float mFragCoordsY;
        float mFragCoordsZ;
        private final e mPickingQueryResult = new e();

        @Entity
        int mRenderable;
        private final d mUserCallback;

        public InternalOnPickCallback(d dVar) {
            this.mUserCallback = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.mPickingQueryResult;
            eVar.f33027a = this.mRenderable;
            eVar.f33028b = this.mDepth;
            float[] fArr = eVar.f33029c;
            fArr[0] = this.mFragCoordsX;
            fArr[1] = this.mFragCoordsY;
            fArr[2] = this.mFragCoordsZ;
            this.mUserCallback.a(eVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum QualityLevel {
        LOW,
        MEDIUM,
        HIGH,
        ULTRA
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class RenderQuality {

        @NonNull
        public QualityLevel hdrColorBuffer = QualityLevel.HIGH;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum ShadowType {
        PCF,
        VSM,
        DPCF,
        PCSS
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes2.dex */
    public enum ToneMapping {
        LINEAR,
        ACES
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float f33013a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f33014b = 1.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f33015c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f33016d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        @Size(min = 3)
        public float[] f33017e = {0.5f, 0.5f, 0.5f};

        /* renamed from: f, reason: collision with root package name */
        public float f33018f = 0.1f;

        /* renamed from: g, reason: collision with root package name */
        public float f33019g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f33020h = -1.0f;

        /* renamed from: i, reason: collision with root package name */
        public boolean f33021i = false;

        /* renamed from: j, reason: collision with root package name */
        public boolean f33022j = false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f33023a = false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f33024a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f33025b = 4;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33026c = false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface d {
        void a(@NonNull e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        @Entity
        public int f33027a;

        /* renamed from: b, reason: collision with root package name */
        public float f33028b;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        public float[] f33029c = new float[3];
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public float f33030a = 0.1f;

        /* renamed from: b, reason: collision with root package name */
        public float f33031b = 0.01f;

        /* renamed from: c, reason: collision with root package name */
        public float f33032c = 3.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f33033d = 2.0f;

        /* renamed from: e, reason: collision with root package name */
        public boolean f33034e = false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public float f33035a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f33036b = 1.0f;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public float f33037a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f33038b = 0.04f;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33039c = false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public float f33040a = 0.5f;

        /* renamed from: b, reason: collision with root package name */
        public float f33041b = 0.5f;

        /* renamed from: c, reason: collision with root package name */
        public float f33042c = 0.5f;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        @Size(min = 4)
        public float[] f33043d = {0.0f, 0.0f, 0.0f, 1.0f};

        /* renamed from: e, reason: collision with root package name */
        public boolean f33044e = false;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public int f33045a = 0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f33046b = false;

        /* renamed from: c, reason: collision with root package name */
        public float f33047c = 0.5f;

        /* renamed from: d, reason: collision with root package name */
        public float f33048d = 0.15f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View(long j3) {
        this.mNativeObject = j3;
    }

    private static native int nGetAmbientOcclusion(long j3);

    private static native int nGetAntiAliasing(long j3);

    private static native int nGetDithering(long j3);

    private static native int nGetSampleCount(long j3);

    private static native boolean nIsFrontFaceWindingInverted(long j3);

    private static native boolean nIsPostProcessingEnabled(long j3);

    private static native boolean nIsScreenSpaceRefractionEnabled(long j3);

    private static native boolean nIsShadowingEnabled(long j3);

    private static native void nPick(long j3, int i3, int i16, Object obj, InternalOnPickCallback internalOnPickCallback);

    private static native void nSetAmbientOcclusion(long j3, int i3);

    private static native void nSetAmbientOcclusionOptions(long j3, float f16, float f17, float f18, float f19, float f26, float f27, int i3, int i16, int i17, boolean z16, boolean z17, float f28);

    private static native void nSetAntiAliasing(long j3, int i3);

    private static native void nSetBlendMode(long j3, int i3);

    private static native void nSetBloomOptions(long j3, long j16, float f16, float f17, int i3, float f18, int i16, int i17, boolean z16, boolean z17, float f19, boolean z18, boolean z19, float f26, int i18, float f27, float f28, float f29, float f36, float f37);

    private static native void nSetCamera(long j3, long j16);

    private static native void nSetColorGrading(long j3, long j16);

    private static native void nSetDepthOfFieldOptions(long j3, float f16, float f17, boolean z16, int i3, boolean z17, int i16, int i17, int i18, int i19, int i26);

    private static native void nSetDithering(long j3, int i3);

    private static native void nSetDynamicLightingOptions(long j3, float f16, float f17);

    private static native void nSetDynamicResolutionOptions(long j3, boolean z16, boolean z17, float f16, float f17, float f18, int i3);

    private static native void nSetFogOptions(long j3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, float f37, boolean z16, boolean z17);

    private static native void nSetFrontFaceWindingInverted(long j3, boolean z16);

    private static native void nSetGuardBandOptions(long j3, boolean z16);

    private static native void nSetMultiSampleAntiAliasingOptions(long j3, boolean z16, int i3, boolean z17);

    private static native void nSetName(long j3, String str);

    private static native void nSetPostProcessingEnabled(long j3, boolean z16);

    private static native void nSetRenderQuality(long j3, int i3);

    private static native void nSetRenderTarget(long j3, long j16);

    private static native void nSetSSCTOptions(long j3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36, int i3, int i16, boolean z16);

    private static native void nSetSampleCount(long j3, int i3);

    private static native void nSetScene(long j3, long j16);

    private static native void nSetScreenSpaceReflectionsOptions(long j3, float f16, float f17, float f18, float f19, boolean z16);

    private static native void nSetScreenSpaceRefractionEnabled(long j3, boolean z16);

    private static native void nSetShadowType(long j3, int i3);

    private static native void nSetShadowingEnabled(long j3, boolean z16);

    private static native void nSetSoftShadowOptions(long j3, float f16, float f17);

    private static native void nSetTemporalAntiAliasingOptions(long j3, float f16, float f17, boolean z16);

    private static native void nSetViewport(long j3, int i3, int i16, int i17, int i18);

    private static native void nSetVignetteOptions(long j3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, boolean z16);

    private static native void nSetVisibleLayers(long j3, int i3, int i16);

    private static native void nSetVsmShadowOptions(long j3, int i3, boolean z16, float f16, float f17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    @NonNull
    @Deprecated
    public AmbientOcclusion getAmbientOcclusion() {
        return sAmbientOcclusionValues[nGetAmbientOcclusion(getNativeObject())];
    }

    @NonNull
    public AmbientOcclusionOptions getAmbientOcclusionOptions() {
        if (this.mAmbientOcclusionOptions == null) {
            this.mAmbientOcclusionOptions = new AmbientOcclusionOptions();
        }
        return this.mAmbientOcclusionOptions;
    }

    @NonNull
    public AntiAliasing getAntiAliasing() {
        return sAntiAliasingValues[nGetAntiAliasing(getNativeObject())];
    }

    public BlendMode getBlendMode() {
        return this.mBlendMode;
    }

    @NonNull
    public BloomOptions getBloomOptions() {
        if (this.mBloomOptions == null) {
            this.mBloomOptions = new BloomOptions();
        }
        return this.mBloomOptions;
    }

    @Nullable
    public Camera getCamera() {
        return this.mCamera;
    }

    public ColorGrading getColorGrading() {
        return this.mColorGrading;
    }

    @NonNull
    public DepthOfFieldOptions getDepthOfFieldOptions() {
        if (this.mDepthOfFieldOptions == null) {
            this.mDepthOfFieldOptions = new DepthOfFieldOptions();
        }
        return this.mDepthOfFieldOptions;
    }

    @NonNull
    public Dithering getDithering() {
        return sDitheringValues[nGetDithering(getNativeObject())];
    }

    @NonNull
    public DynamicResolutionOptions getDynamicResolutionOptions() {
        if (this.mDynamicResolution == null) {
            this.mDynamicResolution = new DynamicResolutionOptions();
        }
        return this.mDynamicResolution;
    }

    @NonNull
    public a getFogOptions() {
        if (this.mFogOptions == null) {
            this.mFogOptions = new a();
        }
        return this.mFogOptions;
    }

    @NonNull
    public b getGuardBandOptions() {
        if (this.mGuardBandOptions == null) {
            this.mGuardBandOptions = new b();
        }
        return this.mGuardBandOptions;
    }

    @NonNull
    public c getMultiSampleAntiAliasingOptions() {
        if (this.mMultiSampleAntiAliasingOptions == null) {
            this.mMultiSampleAntiAliasingOptions = new c();
        }
        return this.mMultiSampleAntiAliasingOptions;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed View");
    }

    @NonNull
    public RenderQuality getRenderQuality() {
        if (this.mRenderQuality == null) {
            this.mRenderQuality = new RenderQuality();
        }
        return this.mRenderQuality;
    }

    @Nullable
    public RenderTarget getRenderTarget() {
        return this.mRenderTarget;
    }

    @Deprecated
    public int getSampleCount() {
        return nGetSampleCount(getNativeObject());
    }

    @Nullable
    public Scene getScene() {
        return this.mScene;
    }

    @NonNull
    public f getScreenSpaceReflectionsOptions() {
        if (this.mScreenSpaceReflectionsOptions == null) {
            this.mScreenSpaceReflectionsOptions = new f();
        }
        return this.mScreenSpaceReflectionsOptions;
    }

    @NonNull
    public g getSoftShadowOptions() {
        if (this.mSoftShadowOptions == null) {
            this.mSoftShadowOptions = new g();
        }
        return this.mSoftShadowOptions;
    }

    @NonNull
    public h getTemporalAntiAliasingOptions() {
        if (this.mTemporalAntiAliasingOptions == null) {
            this.mTemporalAntiAliasingOptions = new h();
        }
        return this.mTemporalAntiAliasingOptions;
    }

    @NonNull
    @Deprecated
    public ToneMapping getToneMapping() {
        return ToneMapping.ACES;
    }

    @NonNull
    public Viewport getViewport() {
        return this.mViewport;
    }

    @NonNull
    public i getVignetteOptions() {
        if (this.mVignetteOptions == null) {
            this.mVignetteOptions = new i();
        }
        return this.mVignetteOptions;
    }

    @NonNull
    public j getVsmShadowOptions() {
        if (this.mVsmShadowOptions == null) {
            this.mVsmShadowOptions = new j();
        }
        return this.mVsmShadowOptions;
    }

    public boolean isFrontFaceWindingInverted() {
        return nIsFrontFaceWindingInverted(getNativeObject());
    }

    public boolean isPostProcessingEnabled() {
        return nIsPostProcessingEnabled(getNativeObject());
    }

    boolean isScreenSpaceRefractionEnabled() {
        return nIsScreenSpaceRefractionEnabled(getNativeObject());
    }

    boolean isShadowingEnabled() {
        return nIsShadowingEnabled(getNativeObject());
    }

    public void pick(int i3, int i16, @Nullable Object obj, @Nullable d dVar) {
        nPick(getNativeObject(), i3, i16, obj, new InternalOnPickCallback(dVar));
    }

    @Deprecated
    public void setAmbientOcclusion(@NonNull AmbientOcclusion ambientOcclusion) {
        nSetAmbientOcclusion(getNativeObject(), ambientOcclusion.ordinal());
    }

    public void setAmbientOcclusionOptions(@NonNull AmbientOcclusionOptions ambientOcclusionOptions) {
        this.mAmbientOcclusionOptions = ambientOcclusionOptions;
        nSetAmbientOcclusionOptions(getNativeObject(), ambientOcclusionOptions.radius, ambientOcclusionOptions.bias, ambientOcclusionOptions.power, ambientOcclusionOptions.resolution, ambientOcclusionOptions.intensity, ambientOcclusionOptions.bilateralThreshold, ambientOcclusionOptions.quality.ordinal(), ambientOcclusionOptions.lowPassFilter.ordinal(), ambientOcclusionOptions.upsampling.ordinal(), ambientOcclusionOptions.enabled, ambientOcclusionOptions.bentNormals, ambientOcclusionOptions.minHorizonAngleRad);
        long nativeObject = getNativeObject();
        float f16 = ambientOcclusionOptions.ssctLightConeRad;
        float f17 = ambientOcclusionOptions.ssctShadowDistance;
        float f18 = ambientOcclusionOptions.ssctContactDistanceMax;
        float f19 = ambientOcclusionOptions.ssctIntensity;
        float[] fArr = ambientOcclusionOptions.ssctLightDirection;
        nSetSSCTOptions(nativeObject, f16, f17, f18, f19, fArr[0], fArr[1], fArr[2], ambientOcclusionOptions.ssctDepthBias, ambientOcclusionOptions.ssctDepthSlopeBias, ambientOcclusionOptions.ssctSampleCount, ambientOcclusionOptions.ssctRayCount, ambientOcclusionOptions.ssctEnabled);
    }

    public void setAntiAliasing(@NonNull AntiAliasing antiAliasing) {
        nSetAntiAliasing(getNativeObject(), antiAliasing.ordinal());
    }

    public void setBlendMode(BlendMode blendMode) {
        this.mBlendMode = blendMode;
        nSetBlendMode(getNativeObject(), blendMode.ordinal());
    }

    public void setBloomOptions(@NonNull BloomOptions bloomOptions) {
        long j3;
        this.mBloomOptions = bloomOptions;
        long nativeObject = getNativeObject();
        Texture texture = bloomOptions.f32984a;
        if (texture != null) {
            j3 = texture.getNativeObject();
        } else {
            j3 = 0;
        }
        nSetBloomOptions(nativeObject, j3, bloomOptions.f32985b, bloomOptions.f32986c, bloomOptions.f32987d, bloomOptions.f32988e, bloomOptions.f32989f, bloomOptions.f32990g.ordinal(), bloomOptions.f32991h, bloomOptions.f32992i, bloomOptions.f32993j, bloomOptions.f32994k, bloomOptions.f32995l, bloomOptions.f32996m, bloomOptions.f32997n, bloomOptions.f32998o, bloomOptions.f32999p, bloomOptions.f33000q, bloomOptions.f33001r, bloomOptions.f33002s);
    }

    public void setCamera(@Nullable Camera camera2) {
        long nativeObject;
        this.mCamera = camera2;
        long nativeObject2 = getNativeObject();
        if (camera2 == null) {
            nativeObject = 0;
        } else {
            nativeObject = camera2.getNativeObject();
        }
        nSetCamera(nativeObject2, nativeObject);
    }

    public void setColorGrading(@Nullable ColorGrading colorGrading) {
        long j3;
        long nativeObject = getNativeObject();
        if (colorGrading != null) {
            j3 = colorGrading.b();
        } else {
            j3 = 0;
        }
        nSetColorGrading(nativeObject, j3);
        this.mColorGrading = colorGrading;
    }

    public void setDepthOfFieldOptions(@NonNull DepthOfFieldOptions depthOfFieldOptions) {
        this.mDepthOfFieldOptions = depthOfFieldOptions;
        nSetDepthOfFieldOptions(getNativeObject(), depthOfFieldOptions.f33003a, depthOfFieldOptions.f33004b, depthOfFieldOptions.f33005c, depthOfFieldOptions.f33006d.ordinal(), depthOfFieldOptions.f33007e, depthOfFieldOptions.f33008f, depthOfFieldOptions.f33009g, depthOfFieldOptions.f33010h, depthOfFieldOptions.f33011i, depthOfFieldOptions.f33012j);
    }

    public void setDithering(@NonNull Dithering dithering) {
        nSetDithering(getNativeObject(), dithering.ordinal());
    }

    public void setDynamicLightingOptions(float f16, float f17) {
        nSetDynamicLightingOptions(getNativeObject(), f16, f17);
    }

    public void setDynamicResolutionOptions(@NonNull DynamicResolutionOptions dynamicResolutionOptions) {
        this.mDynamicResolution = dynamicResolutionOptions;
        nSetDynamicResolutionOptions(getNativeObject(), dynamicResolutionOptions.enabled, dynamicResolutionOptions.homogeneousScaling, dynamicResolutionOptions.minScale, dynamicResolutionOptions.maxScale, dynamicResolutionOptions.sharpness, dynamicResolutionOptions.quality.ordinal());
    }

    public void setFogOptions(@NonNull a aVar) {
        Asserts.assertFloat3In(aVar.f33017e);
        this.mFogOptions = aVar;
        long nativeObject = getNativeObject();
        float f16 = aVar.f33013a;
        float f17 = aVar.f33014b;
        float f18 = aVar.f33015c;
        float f19 = aVar.f33016d;
        float[] fArr = aVar.f33017e;
        nSetFogOptions(nativeObject, f16, f17, f18, f19, fArr[0], fArr[1], fArr[2], aVar.f33018f, aVar.f33019g, aVar.f33020h, aVar.f33021i, aVar.f33022j);
    }

    public void setFrontFaceWindingInverted(boolean z16) {
        nSetFrontFaceWindingInverted(getNativeObject(), z16);
    }

    public void setGuardBandOptions(@NonNull b bVar) {
        this.mGuardBandOptions = bVar;
        nSetGuardBandOptions(getNativeObject(), bVar.f33023a);
    }

    public void setMultiSampleAntiAliasingOptions(@NonNull c cVar) {
        this.mMultiSampleAntiAliasingOptions = cVar;
        nSetMultiSampleAntiAliasingOptions(getNativeObject(), cVar.f33024a, cVar.f33025b, cVar.f33026c);
    }

    public void setName(@NonNull String str) {
        this.mName = str;
        nSetName(getNativeObject(), str);
    }

    public void setPostProcessingEnabled(boolean z16) {
        nSetPostProcessingEnabled(getNativeObject(), z16);
    }

    public void setRenderQuality(@NonNull RenderQuality renderQuality) {
        this.mRenderQuality = renderQuality;
        nSetRenderQuality(getNativeObject(), renderQuality.hdrColorBuffer.ordinal());
    }

    public void setRenderTarget(@Nullable RenderTarget renderTarget) {
        long j3;
        this.mRenderTarget = renderTarget;
        long nativeObject = getNativeObject();
        if (renderTarget != null) {
            j3 = renderTarget.getNativeObject();
        } else {
            j3 = 0;
        }
        nSetRenderTarget(nativeObject, j3);
    }

    @Deprecated
    public void setSampleCount(int i3) {
        nSetSampleCount(getNativeObject(), i3);
    }

    public void setScene(@Nullable Scene scene) {
        long nativeObject;
        this.mScene = scene;
        long nativeObject2 = getNativeObject();
        if (scene == null) {
            nativeObject = 0;
        } else {
            nativeObject = scene.getNativeObject();
        }
        nSetScene(nativeObject2, nativeObject);
    }

    public void setScreenSpaceReflectionsOptions(@NonNull f fVar) {
        this.mScreenSpaceReflectionsOptions = fVar;
        nSetScreenSpaceReflectionsOptions(getNativeObject(), fVar.f33030a, fVar.f33031b, fVar.f33032c, fVar.f33033d, fVar.f33034e);
    }

    public void setScreenSpaceRefractionEnabled(boolean z16) {
        nSetScreenSpaceRefractionEnabled(getNativeObject(), z16);
    }

    public void setShadowType(ShadowType shadowType) {
        nSetShadowType(getNativeObject(), shadowType.ordinal());
    }

    public void setShadowingEnabled(boolean z16) {
        nSetShadowingEnabled(getNativeObject(), z16);
    }

    public void setSoftShadowOptions(@NonNull g gVar) {
        this.mSoftShadowOptions = gVar;
        nSetSoftShadowOptions(getNativeObject(), gVar.f33035a, gVar.f33036b);
    }

    public void setTemporalAntiAliasingOptions(@NonNull h hVar) {
        this.mTemporalAntiAliasingOptions = hVar;
        nSetTemporalAntiAliasingOptions(getNativeObject(), hVar.f33038b, hVar.f33037a, hVar.f33039c);
    }

    public void setViewport(@NonNull Viewport viewport) {
        this.mViewport = viewport;
        long nativeObject = getNativeObject();
        Viewport viewport2 = this.mViewport;
        nSetViewport(nativeObject, viewport2.left, viewport2.bottom, viewport2.width, viewport2.height);
    }

    public void setVignetteOptions(@NonNull i iVar) {
        Asserts.assertFloat4In(iVar.f33043d);
        this.mVignetteOptions = iVar;
        long nativeObject = getNativeObject();
        float f16 = iVar.f33040a;
        float f17 = iVar.f33041b;
        float f18 = iVar.f33042c;
        float[] fArr = iVar.f33043d;
        nSetVignetteOptions(nativeObject, f16, f17, f18, fArr[0], fArr[1], fArr[2], fArr[3], iVar.f33044e);
    }

    public void setVisibleLayers(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16) {
        nSetVisibleLayers(getNativeObject(), i3 & 255, i16 & 255);
    }

    public void setVsmShadowOptions(@NonNull j jVar) {
        this.mVsmShadowOptions = jVar;
        nSetVsmShadowOptions(getNativeObject(), jVar.f33045a, jVar.f33046b, jVar.f33047c, jVar.f33048d);
    }

    @Deprecated
    public void setToneMapping(@NonNull ToneMapping toneMapping) {
    }
}
