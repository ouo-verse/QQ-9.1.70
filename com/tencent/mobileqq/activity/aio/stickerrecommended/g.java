package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends a {

    /* renamed from: b, reason: collision with root package name */
    private Collection<String> f179914b;

    public g(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        this.f179914b = null;
    }

    private List<f> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecCameraEmoticonHandleListener", 2, "camera emoticon search start.");
        }
        ArrayList arrayList = new ArrayList();
        ICameraEmotionRoamingDBManagerService iCameraEmotionRoamingDBManagerService = (ICameraEmotionRoamingDBManagerService) this.f179902a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.get(this.f179902a);
        List<CameraEmotionData> emoticonDataList = iCameraEmotionRoamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            for (CameraEmotionData cameraEmotionData : emoticonDataList) {
                if ("normal".equals(cameraEmotionData.RomaingType) && str.equals(stickerRecManagerImpl.preProcessUsrTextUseLocalSearch(cameraEmotionData.strContext))) {
                    arrayList.add(new f(this.f179902a, cameraEmotionData));
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecCameraEmoticonHandleListener", 2, "findMatchCameraEmoticons matchList is null or empty,keyWord: " + aw.a(str));
            }
            return null;
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.a, com.tencent.mobileqq.activity.aio.stickerrecommended.d
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        if (this.f179914b == null) {
            e();
        }
        Collection<String> collection = this.f179914b;
        if (collection != null && collection.contains(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<f> b(String str, com.tencent.mobileqq.activity.aio.p pVar) {
        return c(str);
    }

    public void e() {
        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.get(this.f179902a);
        if (stickerRecManagerImpl != null) {
            this.f179914b = stickerRecManagerImpl.loadKeywordForCameraEmotion();
        }
    }
}
