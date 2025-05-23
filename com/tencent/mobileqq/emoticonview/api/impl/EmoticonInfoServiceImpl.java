package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.Adapter;
import android.widget.ImageButton;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticonview.BasePanelModel;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.SmallEmotionDownloadedAdapter;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.sender.SystemAndEmojiEmoticonInfoSender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqemoticon.api.IPanelListener;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.pb.emosm.EmosmPb$SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonInfoServiceImpl implements IEmoticonInfoService {
    static IPatchRedirector $redirector_ = null;
    private static final int EMO_PANEL_COMMON_USED_LINE_COUNT = 2;
    private static final String TAG = "EmoticonInfoServiceImpl";

    public EmoticonInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int getSysFaceRecentLineCnt() {
        return 2;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public void addToCommonUsed(AppRuntime appRuntime, Parcelable parcelable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, parcelable, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (appRuntime instanceof BaseQQAppInterface) {
            SystemAndEmojiEmoticonInfoSender.addToCommonUsed((BaseQQAppInterface) appRuntime, (p) parcelable, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(Context context, IPanelListener iPanelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IEmoticonPanelLinearLayoutHelper) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) iPanelListener);
        }
        return new QQEmoticonPanelLinearLayoutHelper(context, (IPanelInteractionListener) iPanelListener);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public int getAddedHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return XPanelContainer.f384717k0;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public List<EmotionPanelData> getCommonUsedSystemEmojiPanelData(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, boolean z16) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, iEmoticonMainPanelApp, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        ArrayList arrayList = new ArrayList();
        if (iEmoticonMainPanelApp == null) {
            return arrayList;
        }
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = (QQEmoticonMainPanelApp) iEmoticonMainPanelApp;
        for (int i19 = 0; i19 < i3; i19++) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
        }
        int sysFaceRecentLineCnt = getSysFaceRecentLineCnt();
        List<EmosmPb$SmallYellowItem> commonUsedSystemEmojiInfo = ((CommonUsedSystemEmojiManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getCommonUsedSystemEmojiInfo();
        if (commonUsedSystemEmojiInfo != null && commonUsedSystemEmojiInfo.size() > 1) {
            int i26 = 0;
            int i27 = 0;
            while (i26 < commonUsedSystemEmojiInfo.size() && i27 < sysFaceRecentLineCnt * i3) {
                EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = commonUsedSystemEmojiInfo.get(i26);
                if (emosmPb$SmallYellowItem.type.get() == i18) {
                    i17 = i18;
                } else {
                    i17 = 1;
                }
                if (!z16 || i17 != 1 || emosmPb$SmallYellowItem.f342125id.get() <= 255) {
                    if (QQSysAndEmojiResMgr.getInstance().getResImpl(emosmPb$SmallYellowItem.type.get()).checkEmoticonShouldHide(emosmPb$SmallYellowItem.f342125id.get())) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, i18, "getCommonUsedSystemEmojiPanelData ShouldHide = " + emosmPb$SmallYellowItem.f342125id.get());
                        }
                    } else {
                        arrayList.add(new SystemAndEmojiEmoticonInfo(7, i17, emosmPb$SmallYellowItem.f342125id.get(), "", true));
                        i27++;
                    }
                }
                i26++;
                i18 = 2;
            }
            if (i27 < sysFaceRecentLineCnt * i3 && (i16 = i27 % i3) != 0) {
                for (int i28 = 0; i28 < i3 - i16; i28++) {
                    arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
                }
            }
        } else {
            QLog.e(TAG, 1, "CommonlyUsedSystemEmoji IS NULL");
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public ImageButton getDeleteImageBtn(EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ImageButton) iPatchRedirector.redirect((short) 11, (Object) this, (Object) pullAndFastScrollListener);
        }
        if (pullAndFastScrollListener instanceof EmoticonMainPanel) {
            EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) pullAndFastScrollListener;
            if (emoticonMainPanel.getEmoController().getPageAdapter() != null) {
                int i17 = BasePanelModel.sLastSelectedSecondTabIndex;
                List<EmotionPanelInfo> panelDataList = emoticonMainPanel.getEmoController().getPanelDataList();
                EmotionPanelViewPagerAdapter pageAdapter = emoticonMainPanel.getEmoController().getPageAdapter();
                if (i17 >= 0 && panelDataList != null && i17 < panelDataList.size()) {
                    ImageButton deleteButtonFromCache = pageAdapter.getDeleteButtonFromCache(i17);
                    if (deleteButtonFromCache == null && i17 - 1 >= 0) {
                        deleteButtonFromCache = pageAdapter.getDeleteButtonFromCache(i16);
                    }
                    if (deleteButtonFromCache == null && (i3 = i17 + 1) < panelDataList.size()) {
                        return pageAdapter.getDeleteButtonFromCache(i3);
                    }
                    return deleteButtonFromCache;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public List<EmotionPanelData> getEmoticonList(IEmoticonMainPanelApp iEmoticonMainPanelApp, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, iEmoticonMainPanelApp, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (iEmoticonMainPanelApp == null) {
            QLog.e(TAG, 1, "getEmoticonList app = null");
            return null;
        }
        SystemEmoticonInfo.parseWhiteList(iEmoticonMainPanelApp.getAppRuntime(), false);
        int[] sysEmotionOrder = SystemEmoticonInfo.getSysEmotionOrder();
        ArrayList arrayList = new ArrayList(sysEmotionOrder.length + SystemAndEmojiEmoticonInfo.EMOJI_COUNT);
        if (i16 != 2 && i16 != 3) {
            for (int i26 = 0; i26 < i3; i26++) {
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_OFTEN, false));
            }
            List<EmosmPb$SmallYellowItem> commonUsedSystemEmojiInfo = ((CommonUsedSystemEmojiManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)).getCommonUsedSystemEmojiInfo();
            if (commonUsedSystemEmojiInfo != null && commonUsedSystemEmojiInfo.size() > 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmoticonList commonusedsize = " + commonUsedSystemEmojiInfo.size());
                }
                int size = commonUsedSystemEmojiInfo.size();
                int i27 = i3 * 3;
                if (size > i27) {
                    size = i27;
                }
                for (int i28 = 0; i28 < size; i28++) {
                    EmosmPb$SmallYellowItem emosmPb$SmallYellowItem = commonUsedSystemEmojiInfo.get(i28);
                    if (emosmPb$SmallYellowItem.type.get() == 2) {
                        i19 = 2;
                    } else {
                        i19 = 1;
                    }
                    arrayList.add(new SystemAndEmojiEmoticonInfo(7, i19, emosmPb$SmallYellowItem.f342125id.get(), "", true));
                }
                if (size < i27 && (i18 = size % i3) != 0) {
                    for (int i29 = 0; i29 < i3 - i18; i29++) {
                        arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
                    }
                }
            } else {
                QLog.e(TAG, 1, "CommonlyUsedSystemEmoji IS NULL");
            }
        }
        for (int i36 = 0; i36 < i3; i36++) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_SYSTEM, false));
        }
        for (int i37 : sysEmotionOrder) {
            arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, i37, "", false));
        }
        int length = sysEmotionOrder.length % i3;
        if (length > 0) {
            for (int i38 = 0; i38 < length; i38++) {
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, -1, "", false));
            }
        }
        if (i16 != 2) {
            for (int i39 = 0; i39 < i3; i39++) {
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, SystemAndEmojiEmoticonInfo.TITLE_EMOJI, false));
            }
            int i46 = 0;
            while (true) {
                i17 = SystemAndEmojiEmoticonInfo.EMOJI_COUNT;
                if (i46 >= i17) {
                    break;
                }
                arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, i46, "", false));
                i46++;
            }
            int i47 = i17 % i3;
            if (i47 > 0) {
                for (int i48 = 0; i48 < i47; i48++) {
                    arrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, -1, "", false));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public JSONObject getJSONFromLocal(AppRuntime appRuntime, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, this, appRuntime, Boolean.valueOf(z16));
        }
        return VasUpdateUtil.getJSONFromLocal(appRuntime, VasUpdateConstants.SCID_SYSTEM_EMOJI_WHITE_LIST, z16, null);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public boolean isSmallEmotionDownloadedAdapter(Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) adapter)).booleanValue();
        }
        return adapter instanceof SmallEmotionDownloadedAdapter;
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public void saveSystemEmojiInfoToFile(IEmoticonMainPanelApp iEmoticonMainPanelApp) {
        CommonUsedSystemEmojiManagerServiceProxy commonUsedSystemEmojiManagerServiceProxy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iEmoticonMainPanelApp);
        } else if (iEmoticonMainPanelApp != null && (commonUsedSystemEmojiManagerServiceProxy = (CommonUsedSystemEmojiManagerServiceProxy) iEmoticonMainPanelApp.getRuntimeService(ICommonUsedSystemEmojiManagerService.class)) != null) {
            commonUsedSystemEmojiManagerServiceProxy.saveSystemEmojiInfoToFile();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService
    public void addToCommonUsed(IEmoticonMainPanelApp iEmoticonMainPanelApp, Parcelable parcelable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, iEmoticonMainPanelApp, parcelable, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (iEmoticonMainPanelApp == null) {
                return;
            }
            SystemAndEmojiEmoticonInfoSender.addToCommonUsed(iEmoticonMainPanelApp, (p) parcelable, i3, i16);
        }
    }
}
