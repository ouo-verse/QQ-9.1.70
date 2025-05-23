package b84;

import android.graphics.Rect;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.sqshow.zootopia.friendsdressup.filament.FriendsDressUpBusinessScene;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u0014j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lb84/a;", "", "", "e", "Lcom/tencent/filament/zplan/avatar/LookAt;", "lookAt", "lookAtWithOffset", "", "enablePelvisOffset", "c", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "id", "", "bodyTypeName", "d", "cameraKey", "f", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mLookAtConfig", "Lcom/tencent/filament/zplan/avatar/Exposure;", "Lcom/tencent/filament/zplan/avatar/Exposure;", "mExposure", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28061a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<CameraKey, LookAt> mLookAtConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Exposure mExposure;

    static {
        a aVar = new a();
        f28061a = aVar;
        mLookAtConfig = new HashMap<>();
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setShutterSpeed(0.008d);
        exposure.setSensitivity(100.0d);
        mExposure = exposure;
        aVar.e();
    }

    a() {
    }

    private final boolean a() {
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).enablePortalPlanarShadow();
    }

    private final LookAt c(LookAt lookAt, LookAt lookAtWithOffset, boolean enablePelvisOffset) {
        if (enablePelvisOffset) {
            return lookAtWithOffset;
        }
        return lookAt;
    }

    private final LookAt d(CameraKey id5, String bodyTypeName) {
        HashMap<CameraKey, LookAt> hashMap = mLookAtConfig;
        LookAt lookAt = hashMap.get(id5);
        if (lookAt == null) {
            if (Intrinsics.areEqual(bodyTypeName, "BoyStretchConfig")) {
                lookAt = hashMap.get(new CameraKey(2000011, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D));
            } else if (Intrinsics.areEqual(bodyTypeName, "GirlStretchConfig")) {
                lookAt = hashMap.get(new CameraKey(2000011, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D));
            } else {
                lookAt = hashMap.get(new CameraKey(2000011, FriendsDressUpBusinessScene.BODY_TYPE_OLD));
            }
        }
        return lookAt == null ? new LookAt(null, null, null, 7, null) : lookAt;
    }

    public final CameraParams b(CameraKey cameraKey, String bodyTypeName) {
        Intrinsics.checkNotNullParameter(cameraKey, "cameraKey");
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        cameraParams.setExposure(mExposure);
        cameraParams.setLookAt(d(cameraKey, bodyTypeName));
        Rect d16 = e84.a.f395879a.d();
        cameraParams.setLensProjection(new LensProjection((d16.width() * 1.0f) / d16.height(), 1000.0f, 120, 0.05f));
        return cameraParams;
    }

    public final boolean f(CameraKey cameraKey) {
        Intrinsics.checkNotNullParameter(cameraKey, "cameraKey");
        return mLookAtConfig.containsKey(cameraKey);
    }

    private final void e() {
        boolean a16 = a();
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.0f, 17.00393f});
        lookAt.setTarget(new float[]{0.0f, -0.01795749f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        HashMap<CameraKey, LookAt> hashMap = mLookAtConfig;
        hashMap.put(new CameraKey(2000012, FriendsDressUpBusinessScene.BODY_TYPE_OLD), lookAt);
        hashMap.put(new CameraKey(2000014, FriendsDressUpBusinessScene.BODY_TYPE_OLD), lookAt);
        hashMap.put(new CameraKey(2000015, FriendsDressUpBusinessScene.BODY_TYPE_OLD), lookAt);
        hashMap.put(new CameraKey(2000017, FriendsDressUpBusinessScene.BODY_TYPE_OLD), lookAt);
        LookAt lookAt2 = new LookAt(null, null, null, 7, null);
        lookAt2.setEye(new float[]{0.0f, 1.0f, 5.232884f});
        lookAt2.setTarget(new float[]{0.0f, 0.8709314f, 0.0f});
        lookAt2.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000019, FriendsDressUpBusinessScene.BODY_TYPE_OLD), lookAt2);
        LookAt lookAt3 = new LookAt(null, null, null, 7, null);
        lookAt3.setEye(new float[]{0.0f, 1.0f, 10.3294f});
        lookAt3.setTarget(new float[]{0.0f, 0.6285071f, 0.0f});
        lookAt3.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000011, FriendsDressUpBusinessScene.BODY_TYPE_OLD), lookAt3);
        LookAt lookAt4 = new LookAt(null, null, null, 7, null);
        lookAt4.setEye(new float[]{0.0f, 1.0f, 18.1466f});
        lookAt4.setTarget(new float[]{0.0f, -0.1248608f, 0.0f});
        lookAt4.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        LookAt lookAt5 = new LookAt(null, null, null, 7, null);
        lookAt5.setEye(new float[]{0.0f, 1.0f, 19.24805f});
        lookAt5.setTarget(new float[]{0.0f, 0.01783717f, 0.0f});
        lookAt5.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000012, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D), c(lookAt4, lookAt5, a16));
        hashMap.put(new CameraKey(2000014, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D), c(lookAt4, lookAt5, a16));
        hashMap.put(new CameraKey(2000015, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D), c(lookAt4, lookAt5, a16));
        hashMap.put(new CameraKey(2000017, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D), c(lookAt4, lookAt5, a16));
        LookAt lookAt6 = new LookAt(null, null, null, 7, null);
        lookAt6.setEye(new float[]{0.0f, 1.0f, 4.998316f});
        lookAt6.setTarget(new float[]{0.0f, 0.9158249f, 0.0f});
        lookAt6.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        LookAt lookAt7 = new LookAt(null, null, null, 7, null);
        lookAt7.setEye(new float[]{0.0f, 1.0f, 4.806397f});
        lookAt7.setTarget(new float[]{0.0f, 1.063973f, 0.0f});
        lookAt7.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000019, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D), c(lookAt6, lookAt7, a16));
        LookAt lookAt8 = new LookAt(null, null, null, 7, null);
        lookAt8.setEye(new float[]{0.0f, 1.0f, 10.733f});
        lookAt8.setTarget(new float[]{0.0f, 0.5440356f, 0.0f});
        lookAt8.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        LookAt lookAt9 = new LookAt(null, null, null, 7, null);
        lookAt9.setEye(new float[]{0.0f, 1.0f, 11.432f});
        lookAt9.setTarget(new float[]{0.0f, 0.7090301f, 0.0f});
        lookAt9.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000011, FriendsDressUpBusinessScene.BODY_TYPE_MALE_D), c(lookAt8, lookAt9, a16));
        LookAt lookAt10 = new LookAt(null, null, null, 7, null);
        lookAt10.setEye(new float[]{0.0f, 1.0f, 18.1466f});
        lookAt10.setTarget(new float[]{0.0f, -0.08026756f, 0.0f});
        lookAt10.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        LookAt lookAt11 = new LookAt(null, null, null, 7, null);
        lookAt11.setEye(new float[]{0.0f, 1.0f, 18.97268f});
        lookAt11.setTarget(new float[]{0.0f, 0.01795728f, 0.0f});
        lookAt11.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000012, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D), c(lookAt10, lookAt11, a16));
        hashMap.put(new CameraKey(2000014, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D), c(lookAt10, lookAt11, a16));
        hashMap.put(new CameraKey(2000015, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D), c(lookAt10, lookAt11, a16));
        hashMap.put(new CameraKey(2000017, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D), c(lookAt10, lookAt11, a16));
        LookAt lookAt12 = new LookAt(null, null, null, 7, null);
        lookAt12.setEye(new float[]{0.0f, 1.0f, 4.998316f});
        lookAt12.setTarget(new float[]{0.0f, 0.8978674f, 0.0f});
        lookAt12.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        LookAt lookAt13 = new LookAt(null, null, null, 7, null);
        lookAt13.setEye(new float[]{0.0f, 1.0f, 4.891695f});
        lookAt13.setTarget(new float[]{0.0f, 0.9876543f, 0.0f});
        lookAt13.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000019, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D), c(lookAt12, lookAt13, a16));
        LookAt lookAt14 = new LookAt(null, null, null, 7, null);
        lookAt14.setEye(new float[]{0.0f, 1.0f, 10.733f});
        lookAt14.setTarget(new float[]{0.0f, 0.5886288f, 0.0f});
        lookAt14.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        LookAt lookAt15 = new LookAt(null, null, null, 7, null);
        lookAt15.setEye(new float[]{0.0f, 1.0f, 11.62263f});
        lookAt15.setTarget(new float[]{0.0f, 0.7090301f, 0.0f});
        lookAt15.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        hashMap.put(new CameraKey(2000011, FriendsDressUpBusinessScene.BODY_TYPE_FEMALE_D), c(lookAt14, lookAt15, a16));
    }
}
