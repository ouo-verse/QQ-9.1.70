package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import java.util.List;

/* loaded from: classes12.dex */
public interface IEmoticonPanelController extends rg2.a {
    int findIndexByPanelType(int i3);

    List<EmotionPanelData> getCustomEmotionData(int i3);

    EmotionInjectionInfo getEmotionInjectionInfo(int i3);

    List<EmotionPanelData> getFilterEmotionData(int i3);

    <T extends AbstractEmoticonPanelHelper> T getHelper(int i3);

    IPanelInteractionListener getHostInterface();

    BaseEmotionPanelBusinessParam getPanelBusinessParam(int i3);

    List<EmotionPanelInfo> getPanelDataList();

    int getSessionType();

    boolean isEmoticonOnShow(int i3);

    @Override // rg2.a
    /* synthetic */ boolean isInAIO();

    boolean isPanelOpen();

    boolean keepLottieMerged();

    @Override // rg2.a
    /* synthetic */ void removePopupGuide();
}
