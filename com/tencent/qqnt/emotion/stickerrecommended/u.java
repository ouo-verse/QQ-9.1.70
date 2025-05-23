package com.tencent.qqnt.emotion.stickerrecommended;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class u extends b {
    static IPatchRedirector $redirector_;

    public u(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    private List<t> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecLocalEmoticonHandleListener", 2, "local emoticon search start.");
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f356489a.getRuntimeService(IEmoticonManagerService.class);
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
                    arrayList.add(new t(emoticon));
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons stickerRecEmotionList.size:" + arrayList.size() + ",keyWord: " + com.tencent.qqnt.emotion.utils.k.a(str));
            }
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecLocalEmoticonHandleListener", 2, "findLocalMatchEmoticons arrEmoticon is null or empty,keyWord: " + com.tencent.qqnt.emotion.utils.k.a(str));
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.h
    public List<t> b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return c(str);
    }
}
