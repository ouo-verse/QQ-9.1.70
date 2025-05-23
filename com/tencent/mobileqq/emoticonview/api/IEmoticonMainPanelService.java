package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import androidx.annotation.DrawableRes;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes12.dex */
public interface IEmoticonMainPanelService extends IRuntimeService {

    /* loaded from: classes12.dex */
    public interface PanelBuilder {

        /* loaded from: classes12.dex */
        public static final class PanelContainerStyleSheet {
            static IPatchRedirector $redirector_;

            @DrawableRes
            public int contentBg;

            @DrawableRes
            public int tabContainerBg;

            public PanelContainerStyleSheet() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.contentBg = 0;
                    this.tabContainerBg = 0;
                }
            }
        }

        PanelBuilder addEmotionInjectionInfo(String str, EmotionInjectionInfo emotionInjectionInfo);

        PanelBuilder addTabLRPadding();

        IEmoticonMainPanel create();

        IEmoticonMainPanelApp getEmoticonMainPanelApp();

        PanelBuilder keepLottieMerged(boolean z16);

        PanelBuilder setAdjustColumn(boolean z16);

        PanelBuilder setCallBack(EmoticonCallback emoticonCallback);

        PanelBuilder setCustomEmotionData(int i3, List<EmotionPanelData> list);

        PanelBuilder setDefaultEpId(String str);

        PanelBuilder setDefaultPanelType(int i3);

        PanelBuilder setDisableAutoDownload(boolean z16);

        PanelBuilder setDisableGuide(boolean z16);

        PanelBuilder setDisableGuideOneTime(boolean z16);

        PanelBuilder setDisableMoreEmotionButton(boolean z16);

        PanelBuilder setEmoticonListProvider(EmoticonListProvider emoticonListProvider);

        PanelBuilder setFilterEmotionData(int i3, List<EmotionPanelData> list);

        PanelBuilder setFilterSysFaceBeyond255Enable(boolean z16);

        PanelBuilder setGuildChatPieScene(int i3);

        PanelBuilder setHasBigEmotion(boolean z16);

        PanelBuilder setHideAllSettingTabs(boolean z16);

        PanelBuilder setHideEmoSettingBtn();

        PanelBuilder setIsOnlySysEmotion(boolean z16);

        PanelBuilder setKanDianBiu(boolean z16);

        PanelBuilder setOnlySysAndEmoji(boolean z16);

        PanelBuilder setPanelBusinessParam(Map<Integer, BaseEmotionPanelBusinessParam> map);

        PanelBuilder setPanelInteractionListener(IPanelInteractionListener iPanelInteractionListener);

        PanelBuilder setShowEmotionPanelDeleteButton(boolean z16);

        PanelBuilder setStyleChange(boolean z16);

        PanelBuilder setStyleSheet(PanelContainerStyleSheet panelContainerStyleSheet);

        PanelBuilder setSysEmotionOrder(int[] iArr);

        PanelBuilder setTextGifOpen(boolean z16);

        PanelBuilder setToastOffset(int i3);

        PanelBuilder setTopTab();

        PanelBuilder showDescribeInPreview(boolean z16);
    }

    PanelBuilder newBuilder(Context context, int i3);

    PanelBuilder newBuilder(Context context, a aVar, int i3);
}
