package com.tencent.aelight.camera.ae.camera.aibeauty;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.download.AEMaterialDownloader;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.common.app.AppInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0016\u0010\u000b\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0016\u0010\f\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/aibeauty/c;", "", "", h.F, "", "a", "", "", "ageList", "c", "genderList", "e", "d", "f", "g", "Lcom/tencent/aelight/camera/ae/camera/aibeauty/AIBeautyFaceType;", "faceType", "i", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "b", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "()Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "AIBeautyTipMaterial", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f62199a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AEMaterialMetaData AIBeautyTipMaterial;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f62201a;

        static {
            int[] iArr = new int[AIBeautyFaceType.values().length];
            try {
                iArr[AIBeautyFaceType.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIBeautyFaceType.CHILD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f62201a = iArr;
        }
    }

    static {
        AEMaterialMetaData aEMaterialMetaData = new AEMaterialMetaData();
        aEMaterialMetaData.f69050id = "video_0_zhineng_update";
        aEMaterialMetaData.name = "video_0_zhineng_update";
        aEMaterialMetaData.resurl = "https://downv6.qq.com/shadow_qqcamera/ai_beauty/video_0_zhineng_update.zip";
        aEMaterialMetaData.md5 = "video_0_zhineng_update";
        AIBeautyTipMaterial = aEMaterialMetaData;
    }

    c() {
    }

    public final void a() {
        ms.a.f("AEAIBeautyHelper", "downloadAIBeautyTipMaterial");
        AppInterface a16 = fr.b.a();
        AEMaterialMetaData aEMaterialMetaData = AIBeautyTipMaterial;
        AEMaterialDownloader.l(a16, aEMaterialMetaData, aEMaterialMetaData.getZipDownloadPath(), new b());
    }

    public final AEMaterialMetaData b() {
        return AIBeautyTipMaterial;
    }

    public final boolean f() {
        return AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_TIPS_CHILD, false, 0);
    }

    public final boolean g() {
        return AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_TIPS_MALE, false, 0);
    }

    public final boolean h() {
        return AEMaterialManager.W(AIBeautyTipMaterial);
    }

    public final boolean d(List<Integer> genderList) {
        if (genderList != null) {
            return genderList.contains(1);
        }
        return false;
    }

    public final boolean e(List<Integer> genderList) {
        if (genderList != null) {
            return genderList.contains(2);
        }
        return false;
    }

    public final void i(AIBeautyFaceType faceType) {
        String str;
        int i3 = faceType == null ? -1 : a.f62201a[faceType.ordinal()];
        if (i3 != 1) {
            str = i3 != 2 ? null : AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_TIPS_CHILD;
        } else {
            str = AECameraConstants.SP_KEY_AE_CAMERA_AUTO_BEAUTY_TIPS_MALE;
        }
        if (str != null) {
            AECameraPrefsUtil.f().l(str, true, 0);
        }
    }

    public final boolean c(List<Integer> ageList) {
        Object obj = null;
        if (ageList != null) {
            Iterator<T> it = ageList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Number) next).intValue() <= 15) {
                    obj = next;
                    break;
                }
            }
            obj = (Integer) obj;
        }
        return obj != null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/ae/camera/aibeauty/c$b", "Lcom/tencent/aelight/camera/download/a;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "", "isUsable", "", "resCode", "", "onDownloadFinish", "progress", "onProgressUpdate", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements com.tencent.aelight.camera.download.a {
        b() {
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData info, boolean isUsable, int resCode) {
            ms.a.f("AEAIBeautyHelper", "downloadAIBeautyTipMaterial---" + isUsable + ", resCode=" + resCode);
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData info, int progress) {
        }
    }
}
