package com.tencent.mobileqq.zplan.avatar.image;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import cooperation.qzone.api.ZPlanHeaderViewConstant;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/l;", "", "", "a", "I", "staticImageId", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "successCount", "c", "imageWidth", "d", "imageHeight", "", "e", UserInfo.SEX_FEMALE, ZPlanHeaderViewConstant.KEY_DEFAULT_WINDOWSILL_LOCATION, "", "f", "Z", "enableNativeRecord", "<init>", "()V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int staticImageId = 501;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger successCount = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int imageWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int imageHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float defaultWindowsillLocation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean enableNativeRecord;

    public l() {
        this.imageWidth = 720;
        this.imageHeight = 1280;
        this.defaultWindowsillLocation = 0.359f;
        try {
            ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
            this.enableNativeRecord = zPlanFeatureSwitch.M();
            String G1 = zPlanFeatureSwitch.G1();
            QLog.i("ZPlanAvatarStaticImageRecordHelper", 1, "getQzoneConsiseDynamicAvatarConfig " + G1);
            JSONObject jSONObject = new JSONObject(G1);
            this.imageWidth = jSONObject.optInt(ZPlanHeaderViewConstant.KEY_DEFAULT_DYNAMIC_IMAGE_WIDTH, 720);
            this.imageHeight = jSONObject.optInt(ZPlanHeaderViewConstant.KEY_DEFAULT_DYNAMIC_IMAGE_HEIGHT, 1280);
            this.defaultWindowsillLocation = (float) jSONObject.optDouble(ZPlanHeaderViewConstant.KEY_DEFAULT_WINDOWSILL_LOCATION, 0.35899999737739563d);
        } catch (JSONException e16) {
            QLog.e("ZPlanAvatarStaticImageRecordHelper", 1, "getQzoneConsiseDynamicAvatarConfig", e16);
        } catch (Exception e17) {
            QLog.e("ZPlanAvatarStaticImageRecordHelper", 1, "getQzoneConsiseDynamicAvatarConfig", e17);
        }
        QLog.i("ZPlanAvatarStaticImageRecordHelper", 1, "getQzoneConsiseDynamicAvatarConfig " + this.imageWidth + " " + this.imageHeight + " " + this.defaultWindowsillLocation);
    }
}
