package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class EmoticonPanelMallHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> implements EmoticonPackageChangedListener {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "EmoticonPanelMallHelper";
    private static final long MARKET_OPEN_INTERVAL = 2592000000L;
    EmoticonPackageDownloadListener downloadListener;
    boolean isClickNoChangeTab;
    private boolean mAutoOpenPage;
    private int mFromType;
    private boolean mOnItemClicked;
    AdapterView.OnItemClickListener tabItemClickListener;

    public EmoticonPanelMallHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.mFromType = 0;
        this.mOnItemClicked = false;
        this.mAutoOpenPage = false;
        this.isClickNoChangeTab = false;
        this.downloadListener = new EmoticonPackageDownloadListener() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelMallHelper.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
            public void onPackageEnd(EmoticonPackage emoticonPackage, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) emoticonPackage, i3);
                    return;
                }
                if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "onPackageEnd resultCode = " + i3 + ",ep = " + emoticonPackage);
                    }
                    if (!((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelView().detached) {
                        ThreadManager.getUIHandler().post(new Runnable(emoticonPackage, i3) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ EmoticonPackage val$ep;
                            final /* synthetic */ int val$resultCode;

                            {
                                this.val$ep = emoticonPackage;
                                this.val$resultCode = i3;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass5.this, emoticonPackage, Integer.valueOf(i3));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                int i16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                EmotionPanelViewPagerAdapter pageAdapter = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPageAdapter();
                                if (pageAdapter != null) {
                                    pageAdapter.onDownload(this.val$ep.epId);
                                }
                                EmoticonPackage emoticonPackage2 = this.val$ep;
                                if ((emoticonPackage2.extraFlags & 2) > 0 && this.val$resultCode == 0) {
                                    ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanel().mSecondTabInited = false;
                                    this.val$ep.extraFlags &= -3;
                                    ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).switchTabMode(BasePanelModel.sLastSelectedSecondTabIndex);
                                    return;
                                }
                                int i17 = emoticonPackage2.jobType;
                                if (i17 != 3 && i17 != 5) {
                                    int i18 = this.val$resultCode;
                                    if (i18 == 0) {
                                        if (((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelModel().addEmoPkgList.contains(this.val$ep)) {
                                            ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelModel().addEmoPkgList.remove(this.val$ep);
                                            return;
                                        }
                                        ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelView().mMarketPgkDownloaded = false;
                                        ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanel().mSecondTabInited = false;
                                        ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelView().isNeedResetX = false;
                                        if (((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanel().getVisibility() == 0 && ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).app != null) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "Emoticon pkg downloaded in panel, refresh");
                                            }
                                            List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanelDataList();
                                            if (panelDataList == null) {
                                                return;
                                            }
                                            int i19 = 0;
                                            while (true) {
                                                if (i19 < panelDataList.size()) {
                                                    EmoticonPackage emoticonPackage3 = panelDataList.get(i19).emotionPkg;
                                                    if (emoticonPackage3 != null && this.val$ep.epId.equals(emoticonPackage3.epId)) {
                                                        break;
                                                    } else {
                                                        i19++;
                                                    }
                                                } else {
                                                    i19 = 0;
                                                    break;
                                                }
                                            }
                                            EmoticonPanelMallHelper emoticonPanelMallHelper = EmoticonPanelMallHelper.this;
                                            if (emoticonPanelMallHelper.isClickNoChangeTab && (i16 = BasePanelModel.sLastSelectedSecondTabIndex) >= 0) {
                                                i19 = i16;
                                            }
                                            int findIndexByPanelType = ((EmoticonPanelController) emoticonPanelMallHelper.mPanelController).findIndexByPanelType(12);
                                            if (BasePanelModel.sLastSelectedSecondTabIndex == findIndexByPanelType) {
                                                i19 = findIndexByPanelType;
                                            }
                                            ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).switchTabMode(i19);
                                            ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelView().mNeedUpdate = false;
                                            return;
                                        }
                                        return;
                                    }
                                    if (i18 == 11000) {
                                        T t16 = EmoticonPanelMallHelper.this.mPanelController;
                                        QQToast.makeText(((EmoticonPanelController) t16).context, ((EmoticonPanelController) t16).context.getString(R.string.f170248k8), 1).show(((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getToastOffset());
                                    } else if (i18 == 11001) {
                                        T t17 = EmoticonPanelMallHelper.this.mPanelController;
                                        QQToast.makeText(((EmoticonPanelController) t17).context, ((EmoticonPanelController) t17).context.getString(R.string.f170249k9), 1).show(((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getToastOffset());
                                    }
                                }
                            }
                        });
                    }
                }
            }
        };
        this.tabItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelMallHelper.this);
                }
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                boolean z16;
                View findViewById;
                EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                } else {
                    QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).app;
                    long currentTimeMillis = System.currentTimeMillis();
                    ei.a(null, "AIO_EmoticonPanel_TabClick");
                    List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanelDataList();
                    if (panelDataList != null && i3 < panelDataList.size() && !((EmoticonPanelTabSortHelper) ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getHelper(7)).setSelection(i3)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "mOnItemClicked position: " + i3);
                        }
                        EmoticonPanelMallHelper.this.mOnItemClicked = true;
                        EmoticonPanelMallHelper.this.mFromType = 1;
                        int size = panelDataList.size();
                        int i16 = BasePanelView.sRecommendEmoticonViewPoSition;
                        if (size > i16 && panelDataList.get(i16).type == 8) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        BasePanelModel.sIsRecommendExist = z16;
                        EmotionPanelInfo emotionPanelInfo = panelDataList.get(i3);
                        EmoticonPanelMallHelper.this.getTalkBackWordingAndReportEvent(view, qQEmoticonMainPanelApp, emotionPanelInfo);
                        if (emotionPanelInfo.type == 4 && view != null && (findViewById = view.findViewById(R.id.f166773i54)) != null) {
                            findViewById.setVisibility(8);
                        }
                        if (BasePanelModel.sLastSelectedSecondTabIndex != i3 || panelDataList.get(i3).type == 18) {
                            ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getHelperProvider().dispatchLifeCycle(13, i3, false);
                            try {
                                Object item = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getEmoticonTabAdapter().getItem(i3);
                                if ((item instanceof EmoticonTabAdapter.EmoticonTabItem) && ((EmoticonTabAdapter.EmoticonTabItem) item).type == 6) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("touin", qQEmoticonMainPanelApp.getCurrentUin());
                                    jSONObject.put("emoji_id", ((EmoticonTabAdapter.EmoticonTabItem) item).epId);
                                    ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "icon", "", "4", 102, 0, 0, "", jSONObject.toString(), "");
                                }
                            } catch (Exception e16) {
                                QLog.i(EmoticonPanelMallHelper.LOG_TAG, 1, "report exception: " + e16.getMessage());
                            }
                            if (((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).shouldShowPanelAndSetSelection(i3, 18)) {
                                BasePanelModel.sLastSelectedSecondTabIndex = i3;
                                ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelView().mEmoticonTabs.setSelection(i3);
                                ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).showPanelByTabIndex(i3);
                            }
                            ei.a("AIO_EmoticonPanel_TabClick", null);
                            EmoticonPanelMallHelper.this.isClickNoChangeTab = true;
                            if (QLog.isColorLevel()) {
                                QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - currentTimeMillis));
                            }
                        }
                    }
                }
                EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
            }
        };
        this.isClickNoChangeTab = false;
    }

    public void asyncInitPanelDataList(boolean z16, EmoticonPanelController.PanelDataCallback panelDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), panelDataCallback);
        } else {
            QLog.d(LOG_TAG, 1, "asyncInitPanelDataList begin");
            ThreadManagerV2.post(new Runnable(z16, panelDataCallback) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ EmoticonPanelController.PanelDataCallback val$callback;
                final /* synthetic */ boolean val$hasBigEmotion;

                {
                    this.val$hasBigEmotion = z16;
                    this.val$callback = panelDataCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmoticonPanelMallHelper.this, Boolean.valueOf(z16), panelDataCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).syncInitPanelDataList(this.val$hasBigEmotion);
                    if (this.val$callback != null) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass2.this.val$callback.callbackInMainThread();
                                }
                            }
                        });
                    }
                }
            }, 5, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findTabIndexByEpId(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, String str, List<EmotionPanelInfo> list) {
        boolean z16;
        EmoticonPackage emoticonPackage;
        int i3;
        if (TextUtils.isEmpty(str) || qQEmoticonMainPanelApp == null || list == null) {
            return 0;
        }
        EmoticonPackage syncFindEmoticonPackageById = ((EmoticonManagerServiceProxy) qQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(str);
        if (syncFindEmoticonPackageById != null && ((i3 = syncFindEmoticonPackageById.jobType) == 3 || i3 == 5)) {
            z16 = true;
        } else {
            z16 = false;
        }
        int size = list.size();
        int i16 = 0;
        while (true) {
            if (i16 < size) {
                EmotionPanelInfo emotionPanelInfo = list.get(i16);
                if ((emotionPanelInfo != null && (emoticonPackage = emotionPanelInfo.emotionPkg) != null && str.equals(emoticonPackage.epId)) || (z16 && emotionPanelInfo != null && emotionPanelInfo.type == 9)) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 == -1) {
            return 0;
        }
        return i16;
    }

    public int getEmoticonTab(String str, List<EmotionPanelInfo> list, boolean z16) {
        EmoticonPackage emoticonPackage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, this, str, list, Boolean.valueOf(z16))).intValue();
        }
        if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                EmotionPanelInfo emotionPanelInfo = list.get(i3);
                if (emotionPanelInfo.type == 6 && (emoticonPackage = emotionPanelInfo.emotionPkg) != null && str.equals(emoticonPackage.epId)) {
                    if (z16) {
                        return i3 - 3;
                    }
                    return i3 - 2;
                }
            }
        }
        return -1;
    }

    public int getFromType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mFromType;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return LOG_TAG;
    }

    @NotNull
    protected String getTalkBackWordingAndReportEvent(View view, QQEmoticonMainPanelApp qQEmoticonMainPanelApp, EmotionPanelInfo emotionPanelInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        boolean z16;
        String str13;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, this, view, qQEmoticonMainPanelApp, emotionPanelInfo);
        }
        int i3 = emotionPanelInfo.type;
        boolean z17 = true;
        String str14 = "";
        if (i3 == 8) {
            str = HardCodeUtil.qqStr(R.string.m7m);
            ImageView imageView = (ImageView) view.findViewById(R.id.f166773i54);
            if (imageView != null) {
                if (imageView.getVisibility() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                imageView.setVisibility(8);
            } else {
                z16 = false;
            }
            SharedPreferences sharedPreferences = qQEmoticonMainPanelApp.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
            sharedPreferences.edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", z16).apply();
            int i16 = sharedPreferences.getInt("recommendRuleId", -1);
            String currentUin = qQEmoticonMainPanelApp.getCurrentUin();
            if (!z16) {
                str13 = "";
            } else {
                str13 = "1";
            }
            VasWebviewUtil.reportCommercialDrainage(currentUin, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", str13, "", i16 + "", "", 0, 0, 0, 0);
            str3 = "0X800AE0B";
            z17 = false;
            str4 = "";
            str7 = str4;
            str2 = "0X8005798";
        } else {
            if (i3 == 9) {
                str = HardCodeUtil.qqStr(R.string.m7b);
                str2 = "0X8005797";
                str3 = "0X800AE0D";
                z17 = false;
            } else {
                if (i3 == 4) {
                    str = HardCodeUtil.qqStr(R.string.m6l);
                    ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
                    ((EmoticonPanelFavHelper) ((EmoticonPanelController) this.mPanelController).getHelper(2)).doSyncFavEmotion();
                    str12 = "0X800AE08";
                    str2 = "0X8005799";
                } else if (i3 == 7) {
                    str = HardCodeUtil.qqStr(R.string.m7v);
                    str12 = "0X800AE07";
                    str2 = "0X800579A";
                } else {
                    if (i3 == 6) {
                        EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
                        if (emoticonPackage == null) {
                            str8 = "";
                            str9 = str8;
                            str10 = str9;
                        } else {
                            String str15 = emoticonPackage.epId;
                            if (emoticonPackage.status == 2) {
                                str11 = "0X800584E";
                            } else {
                                str11 = "0X80059B8";
                            }
                            str9 = Integer.toString(((EmoticonPanelController) this.mPanelController).getEmoticonTab(str15));
                            str10 = HardCodeUtil.qqStr(R.string.m6s) + emoticonPackage.name + HardCodeUtil.qqStr(R.string.m79);
                            if (emoticonPackage.status != 2) {
                                str10 = str10 + HardCodeUtil.qqStr(R.string.m7y);
                            }
                            str8 = str15;
                            str14 = str11;
                        }
                        str4 = str8;
                        str7 = str9;
                        str = str10;
                        z17 = false;
                        str2 = str14;
                    } else {
                        if (i3 == 11) {
                            str = HardCodeUtil.qqStr(R.string.m7w);
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.f166773i54);
                            if (imageView2 != null) {
                                imageView2.setVisibility(8);
                                IPanelInteractionListener interactionListener = ((EmoticonPanelController) this.mPanelController).getInteractionListener();
                                if (interactionListener != null) {
                                    interactionListener.setPaneliconsShowRed(3, false);
                                }
                            }
                            ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
                            str5 = "0X800AE0A";
                        } else {
                            if (i3 == 12) {
                                str6 = "0X800AE09";
                            } else if (i3 == 10) {
                                z17 = false;
                                str = "";
                                str2 = str;
                                str4 = str2;
                                str7 = str4;
                            } else if (i3 == 19) {
                                str6 = "0X800C5C0";
                            } else if (i3 != 20) {
                                str = "";
                                str2 = str;
                                str3 = str2;
                                str4 = str3;
                                str7 = str4;
                            } else {
                                str = HardCodeUtil.qqStr(R.string.f212335n9);
                                str5 = "0X800C609";
                            }
                            str3 = str6;
                            str = "";
                            str2 = str;
                            str4 = str2;
                            str7 = str4;
                        }
                        str3 = str5;
                        str2 = "";
                        str4 = str2;
                        str7 = str4;
                    }
                    str3 = "0X800AE0C";
                }
                str3 = str12;
            }
            str4 = "";
            str7 = str4;
        }
        int fromType = ((EmoticonPanelController) this.mPanelController).getFromType(z17);
        if (!TextUtils.isEmpty(str3) && fromType != 0) {
            ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "dc00898", "", "", str3, str3, fromType, 0, "1", "", "", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            ReportController.o(qQEmoticonMainPanelApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", str2, 0, 0, str4, "", str7, "");
        }
        return str;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.emoticon.b.b().a(this);
            com.tencent.mobileqq.emoticon.b.b().addEmoticonPackageDownloadListener(this.downloadListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{6, 7, 8, 1, 3};
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            com.tencent.mobileqq.emoticon.b.b().n(this);
            com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(this.downloadListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
    public void onPackageAdded(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onPackageAdded: ep = " + emoticonPackage);
            }
            ((EmoticonPanelController) this.mPanelController).getBasePanelView().mNeedUpdate = true;
            ThreadManager.getUIHandler().post(new Runnable(emoticonPackage) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ EmoticonPackage val$ep;

                {
                    this.val$ep = emoticonPackage;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelMallHelper.this, (Object) emoticonPackage);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelModel().addEmoPkgList.contains(this.val$ep)) {
                        ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelModel().addEmoPkgList.add(this.val$ep);
                    }
                    ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelView().mMarketPgkDownloaded = true;
                    ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanel().mSecondTabInited = false;
                    if (((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanel().getVisibility() == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "refresh magic emoji.");
                        }
                        ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).switchTabMode(BasePanelModel.sLastSelectedSecondTabIndex);
                    }
                }
            });
            return;
        }
        QLog.e(LOG_TAG, 1, "onPackageAdded: ep = null");
    }

    @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
    public void onPackageDataListUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onPackageDataListUpdate");
        }
        ((EmoticonPanelController) this.mPanelController).getBasePanelView().mIsTabOrderChanged = true;
        ((EmoticonPanelController) this.mPanelController).getBasePanelView().mNeedUpdate = true;
    }

    @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
    public void onPackageDeleted(EmoticonPackage emoticonPackage) {
        int i3;
        EmoticonPackage emoticonPackage2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onPackageDeleted");
        }
        if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
            List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) this.mPanelController).getPanelDataList();
            int i16 = -1;
            for (int i17 = 0; i17 < panelDataList.size(); i17++) {
                EmotionPanelInfo emotionPanelInfo = panelDataList.get(i17);
                if (emotionPanelInfo != null && (((i3 = emotionPanelInfo.type) == 6 || i3 == 10) && (emoticonPackage2 = emotionPanelInfo.emotionPkg) != null && emoticonPackage.epId.equals(emoticonPackage2.epId))) {
                    i16 = i17;
                }
            }
            if (i16 == -1) {
                return;
            }
            int i18 = BasePanelModel.sLastSelectedSecondTabIndex;
            if (i16 < i18) {
                ((EmoticonPanelController) this.mPanelController).getBasePanelView().mDeleteLeftPkgCount++;
            } else if (i16 == i18 && i16 == panelDataList.size() - 1) {
                ((EmoticonPanelController) this.mPanelController).getBasePanelView().mDeleteLeftPkgCount = panelDataList.size() - 1;
            }
            ((EmoticonPanelController) this.mPanelController).getBasePanelView().mNeedUpdate = true;
        }
    }

    @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
    public void onPackageMoved(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onPackageMoved");
        }
        ((EmoticonPanelController) this.mPanelController).getBasePanelView().mNeedUpdate = true;
    }

    @Override // com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener
    public void onPackageSetBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onPackageSetBottom");
        }
        ((EmoticonPanelController) this.mPanelController).getBasePanelView().mIsTabOrderChanged = true;
        ((EmoticonPanelController) this.mPanelController).getBasePanelView().mNeedUpdate = true;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (((EmoticonPanelController) this.mPanelController).getPanelDataList() != null && i3 >= 0 && i3 < ((EmoticonPanelController) this.mPanelController).getPanelDataList().size()) {
            if (this.mAutoOpenPage) {
                this.mAutoOpenPage = false;
                return;
            }
            if (((EmoticonPanelController) this.mPanelController).findIndexByPanelType(12) == i3 && ((EmoticonPanelController) this.mPanelController).getPageAdapter() != null) {
                BaseEmotionAdapter adapterFromCache = ((EmoticonPanelController) this.mPanelController).getPageAdapter().getAdapterFromCache(((EmoticonPanelController) this.mPanelController).getPanelDataList().get(i3));
                if (adapterFromCache instanceof EmotionHotPicSearchAdapter) {
                    ((EmotionHotPicSearchAdapter) adapterFromCache).clearReportedMD5List();
                }
            }
            if (this.mOnItemClicked) {
                this.mOnItemClicked = false;
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onPageSelected position: " + i3);
            }
            this.mFromType = 2;
            reportPageEvent(((EmoticonPanelController) this.mPanelController).getPanelDataList().get(i3), false);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            com.tencent.mobileqq.emoticon.b.b().removeEmoticonPackageDownloadListener(this.downloadListener);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.emoticon.b.b().addEmoticonPackageDownloadListener(this.downloadListener);
        }
    }

    public void preloadWebProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelMallHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "preloadWebProcess");
                    }
                    try {
                        T t16 = EmoticonPanelMallHelper.this.mPanelController;
                        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = ((EmoticonPanelController) t16).app;
                        Context context = ((EmoticonPanelController) t16).context;
                        if (qQEmoticonMainPanelApp != null) {
                            IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) qQEmoticonMainPanelApp.getService(IWebProcessManagerService.class);
                            if (iWebProcessManagerService != null) {
                                SharedPreferences sharedPreferences = context.getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + qQEmoticonMainPanelApp.getCurrentAccountUin(), 0);
                                if (System.currentTimeMillis() - sharedPreferences.getLong(IEmoticonMainPanel.SP_KEY_MARKET_OPEN_TIME, 0L) < 2592000000L) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "preloadWebProcess, startWebProcess for market open strategy");
                                    }
                                    iWebProcessManagerService.startWebProcess(28, new com.tencent.mobileqq.webview.util.u() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                            }
                                        }

                                        @Override // com.tencent.mobileqq.webview.util.u
                                        public void onResult(boolean z16) {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, (Object) this, z16);
                                            } else if (z16) {
                                                ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelModel().webPreloadHitSessionBegin();
                                            }
                                        }
                                    });
                                    return;
                                } else {
                                    if (System.currentTimeMillis() - sharedPreferences.getLong(IEmoticonMainPanel.SP_KEY_SEND_H5_MAGIC_FACE_TIME, 0L) < 2592000000L) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "preloadWebProcess, startWebProcess for h5 magic send strategy");
                                        }
                                        iWebProcessManagerService.startWebProcess(28, new com.tencent.mobileqq.webview.util.u() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.4.2
                                            static IPatchRedirector $redirector_;

                                            {
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                                                }
                                            }

                                            @Override // com.tencent.mobileqq.webview.util.u
                                            public void onResult(boolean z16) {
                                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                    iPatchRedirector3.redirect((short) 2, (Object) this, z16);
                                                } else if (z16) {
                                                    ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getBasePanelModel().webPreloadHitSessionBegin();
                                                }
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "preloadWebProcess, web process alive already");
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e(EmoticonPanelMallHelper.LOG_TAG, 1, "preloadWebProcess, exception=" + MsfSdkUtils.getStackTraceString(e16));
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void reportPageEvent(EmotionPanelInfo emotionPanelInfo, boolean z16) {
        String str;
        boolean z17;
        int fromType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, emotionPanelInfo, Boolean.valueOf(z16));
            return;
        }
        if (emotionPanelInfo != null) {
            int i3 = emotionPanelInfo.type;
            if (i3 == 7) {
                str = "0X800AE07";
            } else if (i3 != 5 && i3 != 4) {
                if (i3 == 11) {
                    str = "0X800AE0A";
                } else {
                    if (i3 == 8) {
                        str = "0X800AE0B";
                    } else if (i3 == 9) {
                        str = "0X800AE0D";
                    } else if (i3 == 12) {
                        str = "0X800AE09";
                    } else if (i3 != 6 && i3 != 10) {
                        if (i3 == 19) {
                            str = "0X800C5C0";
                        } else {
                            str = "";
                        }
                    } else {
                        str = "0X800AE0C";
                    }
                    z17 = false;
                    fromType = ((EmoticonPanelController) this.mPanelController).getFromType(z17);
                    if (!TextUtils.isEmpty(str) && fromType != 0) {
                        ThreadManagerV2.excute(new Runnable(str, fromType, z16) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ boolean val$autoOpenPage;
                            final /* synthetic */ int val$fromType;
                            final /* synthetic */ String val$name;

                            {
                                this.val$name = str;
                                this.val$fromType = fromType;
                                this.val$autoOpenPage = z16;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, EmoticonPanelMallHelper.this, str, Integer.valueOf(fromType), Boolean.valueOf(z16));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                String str2;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                BaseQQAppInterface qQAppInterface = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).app.getQQAppInterface();
                                String str3 = this.val$name;
                                int i16 = this.val$fromType;
                                if (this.val$autoOpenPage) {
                                    str2 = "3";
                                } else {
                                    str2 = "2";
                                }
                                ReportController.o(qQAppInterface, "dc00898", "", "", str3, str3, i16, 0, str2, "", "", "");
                            }
                        }, 16, null, false);
                    }
                    if (!z16) {
                        this.mAutoOpenPage = true;
                        this.mFromType = 0;
                        return;
                    }
                    return;
                }
            } else {
                str = "0X800AE08";
            }
            z17 = true;
            fromType = ((EmoticonPanelController) this.mPanelController).getFromType(z17);
            if (!TextUtils.isEmpty(str)) {
                ThreadManagerV2.excute(new Runnable(str, fromType, z16) { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ boolean val$autoOpenPage;
                    final /* synthetic */ int val$fromType;
                    final /* synthetic */ String val$name;

                    {
                        this.val$name = str;
                        this.val$fromType = fromType;
                        this.val$autoOpenPage = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, EmoticonPanelMallHelper.this, str, Integer.valueOf(fromType), Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        BaseQQAppInterface qQAppInterface = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).app.getQQAppInterface();
                        String str3 = this.val$name;
                        int i16 = this.val$fromType;
                        if (this.val$autoOpenPage) {
                            str2 = "3";
                        } else {
                            str2 = "2";
                        }
                        ReportController.o(qQAppInterface, "dc00898", "", "", str3, str3, i16, 0, str2, "", "", "");
                    }
                }, 16, null, false);
            }
            if (!z16) {
            }
        }
    }

    public void setAutoOpenPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.mAutoOpenPage = true;
        }
    }

    public void updateLastEmoticonPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelMallHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(EmoticonPanelMallHelper.LOG_TAG, 2, "func updateLastEmoticonPanel begins.");
                    }
                    if (((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPageAdapter() != null) {
                        ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPageAdapter().notifyDataSetChanged();
                    }
                }
            }, 200L);
        }
    }

    public void updateMagicPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            if (!((EmoticonPanelController) this.mPanelController).getPanel().isShown()) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonPanelMallHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPanelDataList();
                    if (panelDataList != null) {
                        int size = panelDataList.size();
                        EmotionPanelInfo emotionPanelInfo = null;
                        int i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                emotionPanelInfo = panelDataList.get(i3);
                                if (emotionPanelInfo != null && emotionPanelInfo.type == 9) {
                                    break;
                                } else {
                                    i3++;
                                }
                            } else {
                                i3 = -1;
                                break;
                            }
                        }
                        if (i3 != -1 && BasePanelModel.sLastSelectedSecondTabIndex == i3 && ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPageAdapter() != null) {
                            ((EmoticonPanelController) EmoticonPanelMallHelper.this.mPanelController).getPageAdapter().refreshListViewAdapter(emotionPanelInfo);
                        }
                    }
                }
            }, 200L);
        }
    }
}
