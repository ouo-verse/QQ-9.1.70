package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m extends a {
    public m(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
    }

    private List<l> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f179902a.getRuntimeService(IEmoticonManagerService.class);
        List<Emoticon> syncGetEmoticonsByKeyword = iEmoticonManagerService.syncGetEmoticonsByKeyword(str, true);
        if (syncGetEmoticonsByKeyword != null && !syncGetEmoticonsByKeyword.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < syncGetEmoticonsByKeyword.size(); i3++) {
                Emoticon emoticon = syncGetEmoticonsByKeyword.get(i3);
                EmoticonPackage syncFindEmoticonPackageById = iEmoticonManagerService.syncFindEmoticonPackageById(emoticon.epId);
                if (syncFindEmoticonPackageById == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons emoticonPackage is null.");
                    }
                } else if (iEmoticonManagerService.getTabCache() != null && iEmoticonManagerService.getTabCache().contains(emoticon.epId) && syncFindEmoticonPackageById.status == 2) {
                    arrayList.add(new l(emoticon));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + arrayList.size() + ",keyWord: " + aw.a(str));
            }
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + aw.a(str));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.stickerrecommended.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<l> b(String str, com.tencent.mobileqq.activity.aio.p pVar) {
        return c(str);
    }
}
