package com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes24.dex */
public interface IScenesRecommendManager extends IRuntimeService {
    c findScenesRecItemByID(String str);

    void setUiHelper(a aVar);
}
