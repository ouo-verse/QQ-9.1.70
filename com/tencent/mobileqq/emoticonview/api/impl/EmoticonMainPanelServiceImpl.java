package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class EmoticonMainPanelServiceImpl implements IEmoticonMainPanelService {
    static IPatchRedirector $redirector_;
    private AppRuntime mAppRuntime;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class PanelBuilder implements IEmoticonMainPanelService.PanelBuilder {
        static IPatchRedirector $redirector_;
        private EmoticonMainPanel.EmoticonPanelBuilder mBuilder;

        public PanelBuilder(AppRuntime appRuntime, Context context, com.tencent.aio.api.runtime.a aVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, context, aVar, Integer.valueOf(i3));
            } else {
                this.mBuilder = new EmoticonMainPanel.EmoticonPanelBuilder(new QQEmoticonMainPanelApp(appRuntime), context, aVar, i3);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder addEmotionInjectionInfo(String str, EmotionInjectionInfo emotionInjectionInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) emotionInjectionInfo);
            }
            this.mBuilder.addEmotionInjectionInfo(str, emotionInjectionInfo);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder addTabLRPadding() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 34, (Object) this);
            }
            this.mBuilder.addTabLRPadding();
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanel create() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (IEmoticonMainPanel) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            return this.mBuilder.create();
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelApp getEmoticonMainPanelApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IEmoticonMainPanelApp) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mBuilder.getEmoticonMainPanelApp();
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder keepLottieMerged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 28, (Object) this, z16);
            }
            this.mBuilder.keepLottieMerged(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setAdjustColumn(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 32, (Object) this, z16);
            }
            this.mBuilder.setAdjustColumn(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setCallBack(EmoticonCallback emoticonCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) emoticonCallback);
            }
            this.mBuilder.setCallBack(emoticonCallback);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setCustomEmotionData(int i3, List<EmotionPanelData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) list);
            }
            this.mBuilder.setCustomEmotionData(i3, list);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setDefaultEpId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.mBuilder.setDefaultEpId(str);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setDefaultPanelType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.mBuilder.setDefaultPanelType(i3);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setDisableAutoDownload(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.mBuilder.setDisableAutoDownload(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setDisableGuide(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 13, (Object) this, z16);
            }
            this.mBuilder.setDisableGuide(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setDisableGuideOneTime(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.mBuilder.setDisableGuideOneTime(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setDisableMoreEmotionButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            this.mBuilder.setDisableMoreEmotionButton(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setEmoticonListProvider(EmoticonListProvider emoticonListProvider) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonListProvider);
            }
            this.mBuilder.setEmoticonListProvider(emoticonListProvider);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setFilterEmotionData(int i3, List<EmotionPanelData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 30, (Object) this, i3, (Object) list);
            }
            if (list != null && !list.isEmpty()) {
                this.mBuilder.setFilterEmotionData(i3, list);
            }
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setFilterSysFaceBeyond255Enable(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 18, (Object) this, z16);
            }
            this.mBuilder.setFilterSysFaceBeyond255Enable(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setGuildChatPieScene(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 25, (Object) this, i3);
            }
            this.mBuilder.setGuildChatPieScene(i3);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setHasBigEmotion(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 11, (Object) this, z16);
            }
            this.mBuilder.setHasBigEmotion(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setHideAllSettingTabs(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 20, (Object) this, z16);
            }
            this.mBuilder.setHideAllSettingTabs(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setHideEmoSettingBtn() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            this.mBuilder.setHideEmoSettingBtn();
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setIsOnlySysEmotion(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.mBuilder.setIsOnlySysEmotion(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setKanDianBiu(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.mBuilder.setKanDianBiu(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setOnlySysAndEmoji(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.mBuilder.setOnlySysAndEmoji(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setPanelBusinessParam(Map<Integer, BaseEmotionPanelBusinessParam> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) map);
            }
            this.mBuilder.setPanelBusinessParam(map);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setPanelInteractionListener(IPanelInteractionListener iPanelInteractionListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) iPanelInteractionListener);
            }
            this.mBuilder.setPanelInteractionListener(iPanelInteractionListener);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setShowEmotionPanelDeleteButton(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 31, (Object) this, z16);
            }
            this.mBuilder.setShowEmotionPanelDeleteButton(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setStyleChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 27, (Object) this, z16);
            }
            this.mBuilder.setStyleChange(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setStyleSheet(IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet panelContainerStyleSheet) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 35, (Object) this, (Object) panelContainerStyleSheet);
            }
            this.mBuilder.setContainerStyleSheet(panelContainerStyleSheet);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setSysEmotionOrder(int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) iArr);
            }
            this.mBuilder.setSysEmotionOrder(iArr);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setTextGifOpen(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 26, (Object) this, z16);
            }
            this.mBuilder.setGuildTextSafeSwitch(z16);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setToastOffset(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.mBuilder.setToastOffset(i3);
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder setTopTab() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 33, (Object) this);
            }
            this.mBuilder.setTopTab();
            return this;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
        public IEmoticonMainPanelService.PanelBuilder showDescribeInPreview(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (IEmoticonMainPanelService.PanelBuilder) iPatchRedirector.redirect((short) 23, (Object) this, z16);
            }
            this.mBuilder.showDescribeInPreview(z16);
            return this;
        }
    }

    public EmoticonMainPanelServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mAppRuntime = null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService
    public PanelBuilder newBuilder(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? newBuilder(context, (com.tencent.aio.api.runtime.a) null, i3) : (PanelBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService
    public PanelBuilder newBuilder(Context context, com.tencent.aio.api.runtime.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new PanelBuilder(this.mAppRuntime, context, aVar, i3) : (PanelBuilder) iPatchRedirector.redirect((short) 3, this, context, aVar, Integer.valueOf(i3));
    }
}
