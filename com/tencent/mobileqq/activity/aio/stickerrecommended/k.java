package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k extends a {

    /* renamed from: b, reason: collision with root package name */
    private Collection<String> f179943b;

    public k(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        this.f179943b = null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.a, com.tencent.mobileqq.activity.aio.stickerrecommended.d
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        if (this.f179943b == null) {
            d();
        }
        Collection<String> collection = this.f179943b;
        if (collection != null && collection.contains(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<? extends IStickerRecEmoticon> b(String str, com.tencent.mobileqq.activity.aio.p pVar) {
        Emoticon syncFindEmoticonById;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start.");
        }
        ArrayList arrayList = new ArrayList();
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f179902a.getRuntimeService(IEmoticonManagerService.class);
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.f179902a.getRuntimeService(IFavroamingDBManagerService.class);
        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.get(this.f179902a);
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticonDataList.size : " + emoticonDataList.size());
            }
            for (CustomEmotionData customEmotionData : emoticonDataList) {
                if ("isUpdate".equals(customEmotionData.RomaingType) || FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType) || "overflow".equals(customEmotionData.RomaingType) || FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED.equals(customEmotionData.RomaingType)) {
                    if (!TextUtils.isEmpty(customEmotionData.modifyWord) && str.equals(stickerRecManagerImpl.preProcessUsrTextUseLocalSearch(customEmotionData.modifyWord))) {
                        arrayList.add(new j(this.f179902a, customEmotionData));
                    } else if (!TextUtils.isEmpty(customEmotionData.ocrWord) && str.equals(stickerRecManagerImpl.preProcessUsrTextUseLocalSearch(customEmotionData.ocrWord))) {
                        arrayList.add(new j(this.f179902a, customEmotionData));
                    } else if (customEmotionData.isMarkFace && (syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId)) != null && !TextUtils.isEmpty(syncFindEmoticonById.name) && str.equals(stickerRecManagerImpl.preProcessUsrTextUseLocalSearch(syncFindEmoticonById.name))) {
                        arrayList.add(new j(this.f179902a, customEmotionData));
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + aw.a(str));
            }
            return null;
        }
        return arrayList;
    }

    public void d() {
        StickerRecManagerImpl stickerRecManagerImpl = StickerRecManagerImpl.get(this.f179902a);
        if (stickerRecManagerImpl != null) {
            this.f179943b = stickerRecManagerImpl.loadKeywordForFavEmotion();
        }
    }
}
