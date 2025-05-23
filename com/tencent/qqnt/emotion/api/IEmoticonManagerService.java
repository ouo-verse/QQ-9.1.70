package com.tencent.qqnt.emotion.api;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.emotion.c;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes24.dex */
public interface IEmoticonManagerService extends IRuntimeService {
    void addTabEmoticonPackage(String str, int i3);

    void asyncFindEmoticonPackage(String str, int i3, c<EmoticonPackage> cVar);

    void asyncFindEmoticonPackage(String str, c<EmoticonPackage> cVar);

    void asyncIncreaseEmotionClickNum(Emoticon emoticon);

    void clearCache();

    int getExtensionSizeByScreenSize(String str);

    int getExtensionSizeByScreenSize(List<MarketFaceSupportSize> list);

    String getSmallEmoticonDescription(String str, String str2);

    List<String> getTabCache();

    List<Emoticon> queryBigEmoticonsFromDB();

    void reconstructAllTabEmoticonPackage(List<String> list, int i3);

    void saveEmoticon(Emoticon emoticon);

    void saveEmoticonPackage(EmoticonPackage emoticonPackage);

    void saveEmoticonPackages(List<EmoticonPackage> list);

    void saveEmoticons(List<Emoticon> list);

    Emoticon syncFindEmoticonById(String str, String str2);

    EmoticonPackage syncFindEmoticonPackageById(String str);

    EmoticonPackage syncFindEmoticonPackageById(String str, int i3);

    EmoticonPackage syncFindEmoticonPackageInCache(String str, int i3);

    EmoticonPackage syncFindTabEmoticonPackageById(String str);

    EmoticonPackage syncFindTabEmoticonPackageById(String str, int i3);

    <T extends EmoticonInfo> T syncGetEmoticonInfo(MarkFaceMessage markFaceMessage);

    List<Emoticon> syncGetEmoticonsByKeyword(String str, boolean z16);

    void syncIncreaseEmoticonExposeNum(g gVar);

    void syncPcTabEmoticonPackage(String str, int i3);
}
