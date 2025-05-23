package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements c {

    /* renamed from: b, reason: collision with root package name */
    private static int f204253b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static Object f204254c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static b f204255d;

    /* renamed from: a, reason: collision with root package name */
    public kb1.a f204256a = new kb1.a();

    public static b b() {
        if (f204255d == null) {
            synchronized (f204254c) {
                if (f204255d == null) {
                    f204255d = new b();
                }
            }
        }
        return f204255d;
    }

    private CameraEmotionData c(String str, String str2, String str3, String str4) {
        CameraEmotionData cameraEmotionData = new CameraEmotionData();
        cameraEmotionData.uin = a().getCurrentAccountUin();
        cameraEmotionData.emoOriginalPath = str;
        cameraEmotionData.thumbPath = str3;
        cameraEmotionData.RomaingType = "needUpload";
        cameraEmotionData.strContext = str2;
        cameraEmotionData.templateId = str4;
        return cameraEmotionData;
    }

    private CameraEmotionData d(String str, String str2, String str3) {
        CameraEmotionData cameraEmotionData = new CameraEmotionData();
        cameraEmotionData.uin = a().getCurrentAccountUin();
        cameraEmotionData.emoPath = str;
        cameraEmotionData.RomaingType = "needUpload";
        cameraEmotionData.strContext = str2;
        cameraEmotionData.templateId = str3;
        return cameraEmotionData;
    }

    private int e() {
        ICameraEmotionRoamingDBManagerService iCameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService) a().getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        if (f204253b == -1) {
            f204253b = 1;
            List<CameraEmotionData> emoticonDataList = iCameraEmotionRoamingDBManagerService.getEmoticonDataList();
            if (emoticonDataList != null) {
                for (int i3 = 0; i3 < emoticonDataList.size(); i3++) {
                    int i16 = emoticonDataList.get(i3).emoId;
                    if (f204253b < i16) {
                        f204253b = i16;
                    }
                }
            }
        }
        int i17 = f204253b + 1;
        f204253b = i17;
        return i17;
    }

    public BaseQQAppInterface a() {
        return (BaseQQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public void f(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        BaseQQAppInterface a16 = a();
        if (a16 == null) {
            QLog.d("CameraEmoSendControl", 1, "app null");
            return;
        }
        ICameraEmotionRoamingDBManagerService iCameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService) a16.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        CameraEmoRoamingHandler cameraEmoRoamingHandler = (CameraEmoRoamingHandler) a16.getBusinessHandler(CameraEmoRoamingHandler.f194459e);
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            CameraEmotionData d16 = d(arrayList.get(i3), arrayList2.get(i3), arrayList3.get(i3));
            d16.emoId = e();
            iCameraEmotionRoamingDBManagerService.insertCustomEmotion(d16);
            arrayList4.add(d16);
        }
        cameraEmoRoamingHandler.notifyUI(4, true, null);
        if (QLog.isColorLevel()) {
            QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
        }
        this.f204256a.b(String.valueOf(1000), new Object[]{arrayList4});
    }

    public void g(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4) {
        BaseQQAppInterface a16 = a();
        ICameraEmotionRoamingDBManagerService iCameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService) a16.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        CameraEmoRoamingHandler cameraEmoRoamingHandler = (CameraEmoRoamingHandler) a16.getBusinessHandler(CameraEmoRoamingHandler.f194459e);
        ArrayList arrayList5 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            CameraEmotionData c16 = c(arrayList.get(i3), arrayList2.get(i3), arrayList3.get(i3), arrayList4.get(i3));
            c16.emoId = e();
            iCameraEmotionRoamingDBManagerService.insertCustomEmotion(c16);
            arrayList5.add(c16);
        }
        cameraEmoRoamingHandler.notifyUI(4, true, null);
        if (QLog.isColorLevel()) {
            QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
        }
        this.f204256a.b(String.valueOf(1000), new Object[]{arrayList5});
    }
}
