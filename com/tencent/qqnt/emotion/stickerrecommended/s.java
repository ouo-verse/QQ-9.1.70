package com.tencent.qqnt.emotion.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.api.IFavroamingDBManagerService;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class s extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private Collection<String> f356626b;

    public s(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        } else {
            this.f356626b = null;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.b, com.tencent.qqnt.emotion.stickerrecommended.h
    public boolean a(BaseQQAppInterface baseQQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseQQAppInterface, (Object) str)).booleanValue();
        }
        Collection<String> collection = this.f356626b;
        if (collection == null || collection.isEmpty()) {
            c();
        }
        Collection<String> collection2 = this.f356626b;
        if (collection2 != null && collection2.contains(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.h
    public List<? extends g> b(String str) {
        Emoticon syncFindEmoticonById;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticon search start:" + com.tencent.qqnt.emotion.utils.k.a(str));
        }
        ArrayList arrayList = new ArrayList();
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f356489a.getRuntimeService(IEmoticonManagerService.class);
        IFavroamingDBManagerService iFavroamingDBManagerService = (IFavroamingDBManagerService) this.f356489a.getRuntimeService(IFavroamingDBManagerService.class);
        IStickerRecManager iStickerRecManager = StickerRecManagerImpl.get(this.f356489a);
        List<CustomEmotionData> emoticonDataList = iFavroamingDBManagerService.getEmoticonDataList();
        if (emoticonDataList != null) {
            List<CustomEmotionData> lottieEmoticonDataList = iFavroamingDBManagerService.getLottieEmoticonDataList();
            if (lottieEmoticonDataList != null) {
                emoticonDataList.addAll(lottieEmoticonDataList);
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite emoticonDataList.size : " + emoticonDataList.size());
            }
            for (CustomEmotionData customEmotionData : emoticonDataList) {
                if ("isUpdate".equals(customEmotionData.RomaingType) || FavEmoConstant.ROAMING_TYPE_PANEL.equals(customEmotionData.RomaingType) || "overflow".equals(customEmotionData.RomaingType) || FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED.equals(customEmotionData.RomaingType)) {
                    if (!TextUtils.isEmpty(customEmotionData.modifyWord) && str.equals(iStickerRecManager.preProcessUsrTextUseLocalSearch(customEmotionData.modifyWord))) {
                        arrayList.add(new r(this.f356489a, customEmotionData));
                    } else if (!TextUtils.isEmpty(customEmotionData.ocrWord) && str.equals(iStickerRecManager.preProcessUsrTextUseLocalSearch(customEmotionData.ocrWord))) {
                        arrayList.add(new r(this.f356489a, customEmotionData));
                    } else if (customEmotionData.isMarkFace && (syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(customEmotionData.emoPath, customEmotionData.eId)) != null && (i3 = syncFindEmoticonById.jobType) != 2 && i3 != 4 && !TextUtils.isEmpty(syncFindEmoticonById.name) && str.equals(iStickerRecManager.preProcessUsrTextUseLocalSearch(syncFindEmoticonById.name))) {
                        arrayList.add(new r(this.f356489a, customEmotionData));
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList is null or empty,keyWord: " + com.tencent.qqnt.emotion.utils.k.a(str));
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecFavoriteEmoHandleListener", 2, "favorite onSearchStickerRecLocalEmoticon matchList success size: " + arrayList.size());
        }
        return arrayList;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IStickerRecManager iStickerRecManager = StickerRecManagerImpl.get(this.f356489a);
        if (iStickerRecManager != null) {
            this.f356626b = iStickerRecManager.loadKeywordForFavEmotion();
        }
    }
}
