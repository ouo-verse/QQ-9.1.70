package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes12.dex */
public class EmoticonPanelParams {
    static IPatchRedirector $redirector_;
    public boolean adjustColumn;
    public a61.b aioContext;
    public QQEmoticonMainPanelApp app;

    @NonNull
    public final Map<Integer, BaseEmotionPanelBusinessParam> businessParamMap;
    public EmoticonCallback callback;
    public IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet containerStyleSheet;
    public Context context;
    public String defaultEpId;
    public int defaultPanelType;
    public boolean disableAutoDownload;
    public boolean disableGuide;
    public boolean disableGuideOneTime;
    public boolean disableMoreEmotionButton;
    public com.tencent.mobileqq.i emoInjectionInfoManager;
    public EmoticonListProvider emoticonListProvider;
    public int guildChatPieScene;
    public boolean hasBigEmotion;
    public boolean hideAllSettingTabs;
    public boolean hideSettingBtn;
    public IPanelInteractionListener interactionListener;
    public boolean isAddLRPadding;
    public boolean isFilterSysFaceBeyond255;
    public boolean isTextGifOpen;
    public boolean isTopTab;
    public boolean kanDianBiu;
    public boolean keepLottieMerged;
    public EmoticonPanelController mController;
    public Map<Integer, List<EmotionPanelData>> mCustomEmotionDataMap;
    public Map<Integer, List<EmotionPanelData>> mFilterEmotionDataMap;
    public boolean mIsOnlySysEmotion;
    public com.tencent.aio.api.runtime.a ntAioContext;
    public boolean onlySysAndEmoji;
    public int sessionType;
    public boolean showDescInPreview;
    public boolean showEmotionPanelDeleteButton;
    public boolean styleChange;
    public int[] sysEmotionOrder;
    public int toastOffset;

    public EmoticonPanelParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sessionType = 0;
        this.kanDianBiu = false;
        this.mIsOnlySysEmotion = false;
        this.hasBigEmotion = true;
        this.onlySysAndEmoji = false;
        this.disableGuide = false;
        this.disableGuideOneTime = false;
        this.disableAutoDownload = false;
        this.disableMoreEmotionButton = false;
        this.showEmotionPanelDeleteButton = false;
        this.isFilterSysFaceBeyond255 = false;
        this.defaultPanelType = -1;
        this.hideSettingBtn = false;
        this.hideAllSettingTabs = false;
        this.showDescInPreview = false;
        this.mCustomEmotionDataMap = new HashMap();
        this.mFilterEmotionDataMap = new HashMap();
        this.businessParamMap = new HashMap();
    }

    public void apply() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        EmoticonPanelController emoticonPanelController = this.mController;
        if (emoticonPanelController != null) {
            if (!this.disableMoreEmotionButton) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.disableMoreEmotionButton = z16;
            emoticonPanelController.mBasePanelModel.mParams = this;
            emoticonPanelController.callback = this.callback;
            emoticonPanelController.setKanDianBiu(this.kanDianBiu);
            this.mController.setEmoticonApp(this.app);
            EmoticonPanelController emoticonPanelController2 = this.mController;
            emoticonPanelController2.mBasePanelView.hasBigEmotion = this.hasBigEmotion;
            emoticonPanelController2.setEmoticonListProvider(this.emoticonListProvider);
            if (this.mController.getEmoticonListProvider() == null) {
                EmoticonPanelController emoticonPanelController3 = this.mController;
                emoticonPanelController3.setEmoticonListProvider(new DefaultEmoticonListProvider(emoticonPanelController3));
            }
            this.mController.setFilterSysFaceBeyond255Enable(this.isFilterSysFaceBeyond255);
            EmoticonPanelController emoticonPanelController4 = this.mController;
            emoticonPanelController4.mBasePanelView.mHideAllSettingTabs = this.hideAllSettingTabs;
            emoticonPanelController4.setOnlySysEmotionEnable(this.mIsOnlySysEmotion);
            EmoticonPanelController emoticonPanelController5 = this.mController;
            emoticonPanelController5.mInteractionListener = this.interactionListener;
            emoticonPanelController5.mBasePanelModel.mEmotionPanelInjectionInfoManager = this.emoInjectionInfoManager;
            emoticonPanelController5.setSysEmotionOrder(this.sysEmotionOrder);
            this.mController.setCurType(this.sessionType);
        }
    }

    public IEmoticonMainPanel create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) View.inflate(this.context, R.layout.emoticon_aio_panel, null);
        this.mController = emoticonMainPanel.getEmoController();
        show();
        return emoticonMainPanel;
    }

    public List<EmotionPanelData> getCustomEmotionData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return this.mCustomEmotionDataMap.get(Integer.valueOf(i3));
    }

    public List<EmotionPanelData> getFilterEmotionData(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return this.mFilterEmotionDataMap.get(Integer.valueOf(i3));
    }

    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (this.mController == null) {
                return;
            }
            apply();
            this.mController.getBasePanelView().setViewData(this);
            this.mController.init();
        }
    }

    public EmoticonPanelParams(EmoticonPanelController emoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.sessionType = 0;
        this.kanDianBiu = false;
        this.mIsOnlySysEmotion = false;
        this.hasBigEmotion = true;
        this.onlySysAndEmoji = false;
        this.disableGuide = false;
        this.disableGuideOneTime = false;
        this.disableAutoDownload = false;
        this.disableMoreEmotionButton = false;
        this.showEmotionPanelDeleteButton = false;
        this.isFilterSysFaceBeyond255 = false;
        this.defaultPanelType = -1;
        this.hideSettingBtn = false;
        this.hideAllSettingTabs = false;
        this.showDescInPreview = false;
        this.mCustomEmotionDataMap = new HashMap();
        this.mFilterEmotionDataMap = new HashMap();
        this.businessParamMap = new HashMap();
        this.mController = emoticonPanelController;
        if (emoticonPanelController != null) {
            this.callback = emoticonPanelController.callback;
            this.kanDianBiu = emoticonPanelController.getKanDianBiu();
            EmoticonPanelController emoticonPanelController2 = this.mController;
            this.app = emoticonPanelController2.app;
            this.hasBigEmotion = emoticonPanelController2.mBasePanelView.hasBigEmotion;
            this.emoticonListProvider = emoticonPanelController2.getEmoticonListProvider();
            this.isFilterSysFaceBeyond255 = this.mController.isFilterSysFaceBeyond255Enable();
            EmoticonPanelController emoticonPanelController3 = this.mController;
            this.hideAllSettingTabs = emoticonPanelController3.mBasePanelView.mHideAllSettingTabs;
            this.mIsOnlySysEmotion = emoticonPanelController3.isOnlySysEmotion();
            this.sysEmotionOrder = this.mController.getSysEmotionOrder();
            EmoticonPanelController emoticonPanelController4 = this.mController;
            this.interactionListener = emoticonPanelController4.mInteractionListener;
            this.emoInjectionInfoManager = emoticonPanelController4.mBasePanelModel.mEmotionPanelInjectionInfoManager;
        }
    }
}
