package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi;
import com.tencent.mobileqq.emoticonview.searchemo.SearchEmotionPanelBusinessParam;
import com.tencent.mobileqq.emoticonview.view.IBasePanelView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.api.IVas04586Report;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import org.slf4j.Marker;

/* loaded from: classes12.dex */
public class BasePanelView implements IBasePanelView, ViewPager.OnPageChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String LOG_TAG = "BasePanelView";
    static boolean sOpenFirstTimeInProcess;
    public static int sRecommendEmoticonViewPoSition;
    private QQEmoticonMainPanelApp app;
    public RelativeLayout contentLayout;
    private Context context;
    float density;
    volatile boolean detached;
    private Object gestureDetector;
    public boolean hasBigEmotion;
    private boolean isFilterSysFaceBeyond255Enable;
    public boolean isNeedResetX;
    public boolean isResumed;
    public boolean kanDianBiu;
    int mDeleteLeftPkgCount;
    public EmoticonTabAdapter mEmoticonTabAdapter;
    public HorizontalListViewEx mEmoticonTabs;
    boolean mHideAllSettingTabs;
    boolean mIsOnlySysEmotion;
    boolean mIsPositioningTab;
    boolean mIsTabOrderChanged;
    private final EmoticonMainPanel mMainPanel;
    public boolean mMarketPgkDownloaded;
    boolean mNeedUpdate;
    public ImageView mNewFlag;
    boolean mOpenFirstTimeInAIO;
    int mOrientation;
    private IEmoticonMainPanelService.PanelBuilder.PanelContainerStyleSheet mPanelContainerStyleSheet;
    private final EmoticonPanelController mPanelController;
    public View mSecondTabContainer;
    private int[] mSysEmotionOrder;
    public EmotionPanelViewPagerAdapter pageAdapter;
    boolean showDescInPreview;
    int toastOffset;
    public EmoticonPanelViewPager viewPager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48107);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
        } else {
            sRecommendEmoticonViewPoSition = 3;
            sOpenFirstTimeInProcess = true;
        }
    }

    public BasePanelView(IEmoticonMainPanel iEmoticonMainPanel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iEmoticonMainPanel);
            return;
        }
        this.mSysEmotionOrder = null;
        this.isFilterSysFaceBeyond255Enable = false;
        this.mDeleteLeftPkgCount = 0;
        this.mIsPositioningTab = false;
        this.isNeedResetX = true;
        this.kanDianBiu = false;
        this.isResumed = false;
        this.detached = false;
        this.hasBigEmotion = true;
        this.showDescInPreview = false;
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) iEmoticonMainPanel;
        this.mMainPanel = emoticonMainPanel;
        EmoticonPanelController emoController = emoticonMainPanel.getEmoController();
        this.mPanelController = emoController;
        Context context = emoticonMainPanel.getContext();
        this.context = context;
        this.mOrientation = context.getResources().getConfiguration().orientation;
        this.density = this.context.getResources().getDisplayMetrics().density;
        this.app = emoController.app;
    }

    private void applyContainerStyleSheet() {
        this.contentLayout.setBackgroundResource(this.mPanelContainerStyleSheet.contentBg);
        this.mSecondTabContainer.setBackgroundResource(this.mPanelContainerStyleSheet.tabContainerBg);
    }

    private void changeTabPosition(EmoticonMainPanel emoticonMainPanel) {
        LinearLayout linearLayout = (LinearLayout) emoticonMainPanel.findViewById(R.id.f166941ja2);
        RelativeLayout relativeLayout = (RelativeLayout) emoticonMainPanel.findViewById(R.id.emotion_panel);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.removeRule(12);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams2.removeRule(2);
        layoutParams2.addRule(3, R.id.f166941ja2);
        emoticonMainPanel.findViewById(R.id.j_2).setVisibility(8);
        emoticonMainPanel.findViewById(R.id.f164637tb0).setVisibility(0);
    }

    private void filterPanelDataListInLiveChannel(List<EmotionPanelInfo> list) {
        if (justShowSystemAndEmoji() && list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                EmotionPanelInfo emotionPanelInfo = list.get(size);
                if (emotionPanelInfo == null || emotionPanelInfo.type != 7) {
                    list.remove(size);
                }
            }
        }
    }

    private int fixSelectIndex(int i3, List<EmotionPanelInfo> list) {
        if (list != null && !list.isEmpty()) {
            if (i3 < 0) {
                if (list.size() <= 1) {
                    return 0;
                }
                return 1;
            }
            if (i3 >= list.size()) {
                return list.size() - 1;
            }
            return i3;
        }
        QLog.w(LOG_TAG, 1, "setViewPagerAdapter, panel data list is null or empty");
        return 0;
    }

    private String getShowEpId(String str, String str2) {
        if (str != null) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        return null;
    }

    private int getTabLiveBgColor() {
        if (justShowSystemAndEmoji()) {
            return 0;
        }
        if (isRobotAIO()) {
            return xy2.b.g(this.context.getColor(R.color.bif), this.context.getColor(R.color.qui_common_bg_nav_bottom_aio));
        }
        return this.context.getResources().getColor(R.color.emo_tabitem_divider2);
    }

    private void hideTabsListInLiveChannel() {
        if (justShowSystemAndEmoji()) {
            this.mMainPanel.findViewById(R.id.f166941ja2).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int initPanelDataAndSelectIndex(String str, int i3, int i16) {
        int i17;
        long currentTimeMillis = System.currentTimeMillis();
        this.mPanelController.syncInitPanelDataList(this.hasBigEmotion);
        if (!TextUtils.isEmpty(str)) {
            i17 = this.mPanelController.findTabIndexByEpId(str);
        } else {
            i17 = i3;
        }
        if (i16 != 0 && i16 != -1) {
            i17 = this.mPanelController.mPanelTabSortHelper.updateOriginalSelectIndex(this.mPanelController.findIndexByPanelType(i16));
        }
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "execQueryTask, panelType=" + i16 + ", selectIndex=" + i3 + "->" + i17 + ", cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return i17;
    }

    private boolean isRobotAIO() {
        IPanelInteractionListener interactionListener;
        EmoticonPanelController emoticonPanelController = this.mPanelController;
        if (emoticonPanelController == null || (interactionListener = emoticonPanelController.getInteractionListener()) == null || !interactionListener.isRobotAIO()) {
            return false;
        }
        return true;
    }

    private boolean isSelfieSelect(int i3) {
        CameraEmoRoamingManagerServiceProxy cameraEmoRoamingManagerServiceProxy;
        if (i3 == -1 || (cameraEmoRoamingManagerServiceProxy = (CameraEmoRoamingManagerServiceProxy) this.app.getRuntimeService(ICameraEmoRoamingManagerService.class)) == null || this.mEmoticonTabAdapter == null || !cameraEmoRoamingManagerServiceProxy.isShowCameraEmoInApp() || i3 != this.mPanelController.findIndexByPanelType(11)) {
            return false;
        }
        return true;
    }

    public static boolean needRequestRecommendData(AppRuntime appRuntime) {
        boolean z16;
        boolean z17 = false;
        if (appRuntime != null) {
            z16 = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("decrease_recommend_request", false);
        } else {
            z16 = false;
        }
        if (!EmoticonStoreTabEntryUtils.disableRecommendTab() || !z16) {
            z17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "decreaseRcmReqSwitch:" + z16 + ", actNeedRcmReq:" + z17);
        }
        return z17;
    }

    private void setSkinColor() {
        if (this.mPanelContainerStyleSheet != null) {
            applyContainerStyleSheet();
        } else if (isLiveChannelScene()) {
            int parseColor = Color.parseColor("#313138");
            this.contentLayout.setBackgroundColor(parseColor);
            this.mSecondTabContainer.setBackgroundColor(parseColor);
        } else if (justShowSystemAndEmoji()) {
            this.contentLayout.setBackground(null);
            this.mSecondTabContainer.setBackground(null);
        } else {
            EmoticonPanelController emoticonPanelController = this.mPanelController;
            if (emoticonPanelController != null && emoticonPanelController.getSessionType() == 10017) {
                this.contentLayout.setBackgroundColor(-16777216);
            } else if (isRobotAIO()) {
                this.contentLayout.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg_robot);
                this.mSecondTabContainer.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg_robot);
            } else {
                this.contentLayout.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
                this.mSecondTabContainer.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
            }
        }
        this.mMainPanel.findViewById(R.id.j_2).setBackgroundColor(getTabLiveBgColor());
        this.mMainPanel.findViewById(R.id.f164637tb0).setBackgroundColor(getTabLiveBgColor());
        this.mEmoticonTabAdapter.setSelectBgSkinDrawable();
        this.mEmoticonTabs.setSkinColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewPagerAdapter(long j3, int i3, boolean z16) {
        this.mSecondTabContainer.setVisibility(0);
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        filterPanelDataListInLiveChannel(panelDataList);
        int fixSelectIndex = fixSelectIndex(i3, panelDataList);
        if (i3 != fixSelectIndex) {
            BasePanelModel.sOldSelectedSecondTabIndex = i3;
            QLog.i(LOG_TAG, 1, "setViewPagerAdapter originalSelectIndex:" + i3 + ", selectIndex:" + fixSelectIndex);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "setViewPagerAdapter, fix select index, " + i3 + "->" + fixSelectIndex);
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        if (from.decodeBool(IEmoticonMainPanel.FORCE_TO_RECOMMEND_PANEL_SP, false)) {
            if (panelDataList != null) {
                int size = panelDataList.size();
                int i16 = sRecommendEmoticonViewPoSition;
                if (size <= i16 || panelDataList.get(i16).type != 8) {
                    BasePanelModel.sLastSelectedSecondTabIndex = fixSelectIndex;
                    from.encodeBool(IEmoticonMainPanel.FORCE_TO_RECOMMEND_PANEL_SP, false);
                }
            }
            BasePanelModel.sLastSelectedSecondTabIndex = sRecommendEmoticonViewPoSition;
            fixSelectIndex = sRecommendEmoticonViewPoSition;
            from.encodeBool(IEmoticonMainPanel.FORCE_TO_RECOMMEND_PANEL_SP, false);
        } else {
            BasePanelModel.sLastSelectedSecondTabIndex = fixSelectIndex;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "setViewPagerAdapter after recommend calculate, selectIndex = " + fixSelectIndex);
        }
        if (!this.mMainPanel.mSecondTabInited) {
            initTabView(fixSelectIndex);
        }
        if (panelDataList != null && panelDataList.size() != 0) {
            int selectedItemPosition = this.mEmoticonTabs.getSelectedItemPosition();
            if (selectedItemPosition != fixSelectIndex || selectedItemPosition == 0) {
                if (fixSelectIndex == sRecommendEmoticonViewPoSition) {
                    this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
                }
                this.mEmoticonTabs.setSelection(fixSelectIndex);
            }
            this.pageAdapter.setData(panelDataList);
            PagerAdapter adapter = this.viewPager.getAdapter();
            EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = this.pageAdapter;
            if (adapter != emotionPanelViewPagerAdapter) {
                this.viewPager.setAdapter(emotionPanelViewPagerAdapter);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "[Performance] switchTabMode to , setAdapter duration: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (fixSelectIndex < panelDataList.size()) {
                this.mPanelController.mPanelMallHelper.reportPageEvent(panelDataList.get(fixSelectIndex), true);
                if (!z16) {
                    this.mPanelController.mDtReportHelper.updateAutoPaged(fixSelectIndex, true);
                }
            }
            showPanelByTabIndex(fixSelectIndex);
            if (this.mOpenFirstTimeInAIO && fixSelectIndex == 0) {
                this.pageAdapter.onPageSelected(panelDataList.get(fixSelectIndex));
            }
        } else {
            this.viewPager.setAdapter(null);
        }
        ei.a("AIO_EmoticonPanel_EnterSecond", null);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[Performance] switchTabMode to , duration:" + (System.currentTimeMillis() - j3) + ",mSecondTabInited:" + this.mMainPanel.mSecondTabInited);
        }
    }

    public void addTabListAdditionalView(boolean z16, View view) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Boolean.valueOf(z16), view);
            return;
        }
        View view2 = this.mSecondTabContainer;
        if (view2 instanceof LinearLayout) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
                if (layoutParams != null) {
                    i3 = layoutParams.width;
                } else {
                    i3 = -2;
                }
                layoutParams = new LinearLayout.LayoutParams(i3, -1);
            }
            view.setLayoutParams(layoutParams);
            if (z16) {
                ((LinearLayout) view2).addView(view, 0);
            } else {
                ((LinearLayout) view2).addView(view);
            }
        }
    }

    protected EmoticonTabAdapter.EmoticonTabItem convertEmoticonTabItem(EmotionPanelInfo emotionPanelInfo) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (EmoticonTabAdapter.EmoticonTabItem) iPatchRedirector.redirect((short) 29, (Object) this, (Object) emotionPanelInfo);
        }
        EmoticonTabAdapter.EmoticonTabItem emoticonTabItem = new EmoticonTabAdapter.EmoticonTabItem();
        int i3 = emotionPanelInfo.type;
        emoticonTabItem.type = i3;
        if (i3 == 8) {
            str = HardCodeUtil.qqStr(R.string.m6w);
        } else if (i3 == 9) {
            str = HardCodeUtil.qqStr(R.string.m6y);
        } else if (i3 == 4) {
            str = HardCodeUtil.qqStr(R.string.m7j);
        } else if (i3 == 7) {
            str = HardCodeUtil.qqStr(R.string.m7i);
        } else if (i3 != 6 && i3 != 10) {
            if (i3 == 11) {
                str = HardCodeUtil.qqStr(R.string.m6k);
            } else if (i3 == 13) {
                str = this.context.getResources().getString(R.string.axk);
            } else if (i3 == 14) {
                str = this.context.getResources().getString(R.string.axl);
            } else if (i3 == 12) {
                str = this.context.getResources().getString(R.string.yqa);
            } else if (i3 == 17) {
                str = this.context.getResources().getString(R.string.f170542u0);
            } else if (i3 == 18) {
                str = this.context.getResources().getString(R.string.f170218yq3);
            } else if (i3 == 19) {
                str = this.context.getResources().getString(R.string.ypw);
            } else {
                if (i3 == 20) {
                    str = this.context.getResources().getString(R.string.yqe);
                }
                str = "";
            }
        } else {
            EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
            if (emoticonPackage != null) {
                String str2 = emoticonPackage.name + HardCodeUtil.qqStr(R.string.f171947m82);
                if (emoticonPackage.status != 2) {
                    str2 = str2 + HardCodeUtil.qqStr(R.string.f171948m84);
                }
                emoticonTabItem.epId = emoticonPackage.epId;
                emoticonTabItem.subType = emoticonPackage.subType;
                if (emoticonPackage.status == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                emoticonTabItem.completed = z16;
                str = str2;
            }
            str = "";
        }
        emoticonTabItem.description = str;
        return emoticonTabItem;
    }

    public void dispatchDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) canvas);
            return;
        }
        if (EmoticonMainPanel.sOpenStartTime == -1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - EmoticonMainPanel.sOpenStartTime;
        if (currentTimeMillis <= 0) {
            return;
        }
        HashMap hashMap = new HashMap(2);
        if (sOpenFirstTimeInProcess) {
            i3 = 1;
        } else if (this.mOpenFirstTimeInAIO) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        hashMap.put(IEmoticonMainPanel.REPORT_PARAM_PANEL_MODE, "2");
        hashMap.put("duration", String.valueOf(currentTimeMillis));
        ThreadManagerV2.post(new Runnable(i3, currentTimeMillis, hashMap) { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$duration;
            final /* synthetic */ HashMap val$params;
            final /* synthetic */ int val$tempCondition;

            {
                this.val$tempCondition = i3;
                this.val$duration = currentTimeMillis;
                this.val$params = hashMap;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BasePanelView.this, Integer.valueOf(i3), Long.valueOf(currentTimeMillis), hashMap);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i16;
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (BasePanelView.this.app != null) {
                    String currentAccountUin = BasePanelView.this.app.getCurrentAccountUin();
                    if (BasePanelView.this.context != null && currentAccountUin != null) {
                        SharedPreferences sharedPreferences = BasePanelView.this.context.getSharedPreferences(IEmoticonMainPanel.SP_USER_FILE_NAME + currentAccountUin, 0);
                        long j3 = sharedPreferences.getLong(IEmoticonMainPanel.SP_KEY_EMOTICON_PANEL_LAST_REPORT_TIME, 0L);
                        int i17 = sharedPreferences.getInt(IEmoticonMainPanel.SP_KEY_EMOTICON_PANEL_REPORT_COUNT, 0);
                        if (System.currentTimeMillis() - j3 > 86400000) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putLong(IEmoticonMainPanel.SP_KEY_EMOTICON_PANEL_LAST_REPORT_TIME, System.currentTimeMillis());
                            edit.putInt(IEmoticonMainPanel.SP_KEY_EMOTICON_PANEL_REPORT_COUNT, 0);
                            edit.apply();
                            i16 = 0;
                        } else {
                            i16 = i17;
                        }
                        if (i16 < 10) {
                            int i18 = this.val$tempCondition;
                            String str2 = IEmoticonMainPanel.PERF_REPORT_OPEN_DURATION_TAG1;
                            if (i18 != 1) {
                                if (i18 != 2) {
                                    if (i18 == 3) {
                                        str = IEmoticonMainPanel.PERF_REPORT_OPEN_DURATION_TAG3;
                                    }
                                } else {
                                    str = IEmoticonMainPanel.PERF_REPORT_OPEN_DURATION_TAG2;
                                }
                                str2 = str;
                            }
                            StatisticCollector.getInstance(BasePanelView.this.context).collectPerformance(currentAccountUin, str2, true, this.val$duration, 0L, this.val$params, "", false);
                            SharedPreferences.Editor edit2 = sharedPreferences.edit();
                            edit2.putInt(IEmoticonMainPanel.SP_KEY_EMOTICON_PANEL_REPORT_COUNT, i16 + 1);
                            edit2.apply();
                        }
                    }
                }
            }
        }, 5, null, true);
        ei.a("AIO_EmoticonPanel_OpenDuration", null);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[Performance] dispatchDraw over, duration=" + currentTimeMillis + ",openCondition=" + i3 + ",panelMode=2");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("open EmoticonPanel duration=");
            sb5.append(currentTimeMillis);
            QLog.d("StressTesting.Emoticon.PanelCreate", 2, sb5.toString());
        }
        EmoticonMainPanel.sOpenStartTime = -1L;
        this.mOpenFirstTimeInAIO = false;
        sOpenFirstTimeInProcess = false;
    }

    protected void execQueryTask(int i3, int i16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str);
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_panel_sync_init_panel_data_908", true)) {
            long currentTimeMillis = System.currentTimeMillis();
            initQueryFinish(Integer.valueOf(initPanelDataAndSelectIndex(str, i16, i3)), j3);
            if (QLog.isColorLevel()) {
                QLog.i(LOG_TAG, 2, "[execQueryTask] init panel data, cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return;
            }
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_panel_sync_query_task_908", true)) {
            i17 = 150;
        }
        new QueryTask(new QueryTask.Query<String, Integer>(i16, i3) { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$panelType;
            final /* synthetic */ int val$selectIndex;

            {
                this.val$selectIndex = i16;
                this.val$panelType = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BasePanelView.this, Integer.valueOf(i16), Integer.valueOf(i3));
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
            public Integer query(String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Integer.valueOf(BasePanelView.this.initPanelDataAndSelectIndex(str2, this.val$selectIndex, this.val$panelType)) : (Integer) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str2);
            }
        }, new QueryCallback<Integer>(j3) { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BasePanelView.this, Long.valueOf(j3));
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            public void postQuery(Integer num) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    BasePanelView.this.initQueryFinish(num, this.val$startTime);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                }
            }
        }, i17).execute(str);
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mMainPanel.getContext();
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public EmoticonPanelController getController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmoticonPanelController) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mPanelController;
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public EmoticonMainPanel getMainPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EmoticonMainPanel) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mMainPanel;
    }

    public int[] getSysEmotionOrder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (int[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mSysEmotionOrder;
    }

    public void hideAllTabs() {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        EmoticonMainPanel emoticonMainPanel = this.mMainPanel;
        if (emoticonMainPanel != null && (findViewById = emoticonMainPanel.findViewById(R.id.f166941ja2)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void initEmoticonView(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            initEmoticonView(-1, i3, str);
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) str);
        }
    }

    public void initGestureDetector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
        } else {
            this.gestureDetector = ((IEmosmService) QRoute.api(IEmosmService.class)).initGestureDetector(this.gestureDetector, this.context, this.mPanelController.getInteractionListener());
        }
    }

    public void initQueryFinish(Integer num, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, num, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LOG_TAG, 2, "initQueryFinish, select index=" + num);
        }
        boolean checkTabListCanShowGuide = EmoticonStoreTabEntryUtils.checkTabListCanShowGuide(this.mPanelController.getPanelDataList());
        initTabView(num.intValue());
        switchTabMode(num.intValue());
        if (justShowSystemAndEmoji()) {
            this.mPanelController.onShowPageFinish();
            return;
        }
        if (!this.mPanelController.getParams().disableGuide && !this.mPanelController.getParams().disableGuideOneTime) {
            this.mPanelController.mPanelSystemAndEmojiHelper.showEmoticonPopupGuide();
        }
        this.mPanelController.getParams().disableGuideOneTime = false;
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "selectIndex = " + num + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - j3));
        }
        if (!this.mPanelController.getParams().disableAutoDownload) {
            this.mPanelController.mPanelFavHelper.roamTenEmoticon(num.intValue());
        }
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        int businessType = this.mPanelController.getBusinessType();
        int size = panelDataList.size();
        int i3 = sRecommendEmoticonViewPoSition;
        if (size > i3) {
            if (panelDataList.get(i3).type != 8 && (needRequestRecommendData(this.app.getAppRuntime()) || businessType == 1)) {
                com.tencent.mobileqq.EmotionUtils.d(this.app, businessType);
            }
        } else if (needRequestRecommendData(this.app.getAppRuntime()) || businessType == 1) {
            com.tencent.mobileqq.EmotionUtils.d(this.app, businessType);
        }
        if (checkTabListCanShowGuide && EmoticonStoreTabEntryUtils.checkIsNeedShowGuide()) {
            int dimension = (int) this.mMainPanel.getResources().getDimension(R.dimen.f158749nw);
            int dpToPx = ViewUtils.dpToPx(8.0f);
            EmoticonPanelController emoticonPanelController = this.mPanelController;
            emoticonPanelController.mPanelSettingHelper.showGuideView(this.mMainPanel, dpToPx, dimension, emoticonPanelController.getParams().isTopTab);
        }
        this.mPanelController.onShowPageFinish();
    }

    void initTabView(int i3) {
        if (this.mMainPanel.mSecondTabInited) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean isCmShowMemeTabInFaceDisabled = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).isCmShowMemeTabInFaceDisabled();
        EmoticonPanelController emoticonPanelController = this.mPanelController;
        emoticonPanelController.hideItemByTypeIfNeed(15, isCmShowMemeTabInFaceDisabled, emoticonPanelController.getPanelDataList());
        EmoticonPanelController emoticonPanelController2 = this.mPanelController;
        emoticonPanelController2.hideItemByTypeIfNeed(12, false, emoticonPanelController2.getPanelDataList());
        EmoticonPanelController emoticonPanelController3 = this.mPanelController;
        emoticonPanelController3.hideItemByTypeIfNeed(18, false, emoticonPanelController3.getPanelDataList());
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        if (panelDataList != null && panelDataList.size() != 0) {
            if (i3 == sRecommendEmoticonViewPoSition) {
                this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
            }
            StringBuffer stringBuffer = new StringBuffer();
            int size = panelDataList.size();
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < size; i16++) {
                EmoticonTabAdapter.EmoticonTabItem convertEmoticonTabItem = convertEmoticonTabItem(panelDataList.get(i16));
                stringBuffer.append(convertEmoticonTabItem);
                stringBuffer.append(";");
                arrayList.add(convertEmoticonTabItem);
            }
            QLog.i(LOG_TAG, 1, "initTabView, tabs=" + ((Object) stringBuffer));
            if (arrayList.size() > 0) {
                if (this.isNeedResetX) {
                    this.mEmoticonTabs.resetCurrentX(i3);
                }
                this.isNeedResetX = true;
                this.mEmoticonTabAdapter.updateData(arrayList);
            }
            this.mMainPanel.mSecondTabInited = true;
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "[Performance] initSecondTabView duration:" + (System.currentTimeMillis() - currentTimeMillis));
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasePanelView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(Marker.ANY_NON_NULL_MARKER, "4", SearchConstants.PLATFORM, "6", "1", 101, 1, System.currentTimeMillis());
                    }
                }
            }, 16, null, false);
        }
    }

    public void initView() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        boolean z17 = true;
        this.mOpenFirstTimeInAIO = true;
        this.toastOffset = this.mPanelController.getParams().toastOffset;
        EmoticonPanelViewPager emoticonPanelViewPager = (EmoticonPanelViewPager) this.mMainPanel.findViewById(R.id.viewPager);
        this.viewPager = emoticonPanelViewPager;
        emoticonPanelViewPager.setOnPageChangeListener(this);
        EmoticonPanelController emoticonPanelController = this.mPanelController;
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp = emoticonPanelController.app;
        IPanelInteractionListener interactionListener = emoticonPanelController.getInteractionListener();
        EmoticonPanelController emoticonPanelController2 = this.mPanelController;
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = new EmotionPanelViewPagerAdapter(qQEmoticonMainPanelApp, interactionListener, emoticonPanelController2.context, emoticonPanelController2.callback, emoticonPanelController2.getBusinessType(), this.kanDianBiu);
        this.pageAdapter = emotionPanelViewPagerAdapter;
        emotionPanelViewPagerAdapter.setPanelInjectionInfoManager(this.mPanelController.getEmotionPanelManager());
        this.pageAdapter.setPanelController(this.mPanelController);
        this.pageAdapter.isOnlySysEmotion = this.mPanelController.getParams().mIsOnlySysEmotion;
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter2 = this.pageAdapter;
        emotionPanelViewPagerAdapter2.sysEmotionOrder = this.mSysEmotionOrder;
        emotionPanelViewPagerAdapter2.showDescInPreview = this.showDescInPreview;
        emotionPanelViewPagerAdapter2.isFilterSysFaceBeyond255 = this.mPanelController.isFilterSysFaceBeyond255Enable();
        this.pageAdapter.ignoreUIToken = isLiveChannelScene();
        this.contentLayout = (RelativeLayout) this.mMainPanel.findViewById(R.id.emotion_panel);
        this.mSecondTabContainer = this.mMainPanel.findViewById(R.id.container_secondary_tab);
        HorizontalListViewEx horizontalListViewEx = (HorizontalListViewEx) this.mMainPanel.findViewById(R.id.tab_sencondary_emoticon);
        this.mEmoticonTabs = horizontalListViewEx;
        this.mMainPanel.mEmoticonTabs = horizontalListViewEx;
        horizontalListViewEx.setOnItemClickListener(this.mPanelController.getTabItemClickListener());
        EmoticonPanelController emoticonPanelController3 = this.mPanelController;
        QQEmoticonMainPanelApp qQEmoticonMainPanelApp2 = emoticonPanelController3.app;
        com.tencent.mobileqq.i emotionPanelManager = emoticonPanelController3.getEmotionPanelManager();
        EmoticonPanelController emoticonPanelController4 = this.mPanelController;
        EmoticonTabAdapter emoticonTabAdapter = new EmoticonTabAdapter(qQEmoticonMainPanelApp2, emotionPanelManager, emoticonPanelController4.context, emoticonPanelController4.getBusinessType());
        this.mEmoticonTabAdapter = emoticonTabAdapter;
        if (!this.mPanelController.isShowExtendPanel() && !this.mPanelController.getParams().styleChange) {
            z16 = false;
        } else {
            z16 = true;
        }
        emoticonTabAdapter.setAIOShowStyleChange(z16);
        this.mEmoticonTabAdapter.setGifEntranceIcon(this.mPanelController.isInC2COrTroopAIO());
        IPanelInteractionListener iPanelInteractionListener = this.mPanelController.mInteractionListener;
        if (iPanelInteractionListener != null) {
            boolean isCurGuildLiveChannel = iPanelInteractionListener.isCurGuildLiveChannel();
            this.mEmoticonTabAdapter.setInGuildLiveRoom(isCurGuildLiveChannel);
            this.mEmoticonTabs.setIsInGuildLiveRoom(isCurGuildLiveChannel);
        }
        HorizontalListViewEx horizontalListViewEx2 = this.mEmoticonTabs;
        if (!this.mPanelController.isShowExtendPanel() && !this.mPanelController.getParams().styleChange) {
            z17 = false;
        }
        horizontalListViewEx2.setTabAnimateEnable(z17);
        this.mEmoticonTabs.setAdapter((ListAdapter) this.mEmoticonTabAdapter);
        this.mNewFlag = (ImageView) this.mMainPanel.findViewById(R.id.bvb);
        setSkinColor();
        if (this.mPanelController.getParams().defaultPanelType != -1) {
            initEmoticonView(this.mPanelController.getParams().defaultPanelType);
        } else {
            initEmoticonView(this.mPanelController.getParams().defaultEpId);
        }
        hideTabsListInLiveChannel();
        if (this.mPanelController.getParams().isTopTab) {
            changeTabPosition(this.mMainPanel);
        }
        if (this.mPanelController.getParams().isAddLRPadding) {
            this.mEmoticonTabs.setPaddingRelative(ViewUtils.dpToPx(12.0f), 0, ViewUtils.dpToPx(12.0f), 0);
        }
    }

    public boolean isFilterSysFaceBeyond255Enable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.isFilterSysFaceBeyond255Enable;
    }

    protected boolean isLiveChannelScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return ((IEmosmService) QRoute.api(IEmosmService.class)).isLiveChannelScene(this.mMainPanel.getEmoController().getParams().guildChatPieScene);
    }

    protected boolean justShowSystemAndEmoji() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return ((IEmosmService) QRoute.api(IEmosmService.class)).justShowSystemAndEmoji(this.mMainPanel.getEmoController().getParams().guildChatPieScene, this.mMainPanel.getEmoController().getParams().isTextGifOpen);
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        HorizontalListViewEx.destroyCacheView();
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = this.pageAdapter;
        if (emotionPanelViewPagerAdapter != null) {
            emotionPanelViewPagerAdapter.onDestroy();
        }
        this.mMainPanel.mSecondTabInited = false;
        this.gestureDetector = ((IEmosmService) QRoute.api(IEmosmService.class)).gestureDetectorDestory(this.gestureDetector, this.mPanelController.getInteractionListener());
        QLog.i(LOG_TAG, 1, "onDestroy  oldIndex:" + BasePanelModel.sOldSelectedSecondTabIndex);
        if (BasePanelModel.sOldSelectedSecondTabIndex > 0 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_restore_tab_index_137539015", true)) {
            BasePanelModel.sLastSelectedSecondTabIndex = BasePanelModel.sOldSelectedSecondTabIndex;
        }
        BasePanelModel.sOldSelectedSecondTabIndex = -1;
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.detached = true;
        EmotionPanelListViewPool.getInstance().destory();
        EmotionPanelViewPool.getInstance().destory();
    }

    public void onMeasureMainPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.9
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasePanelView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int measuredWidth = BasePanelView.this.mMainPanel.getMeasuredWidth();
                    DisplayMetrics displayMetrics = BasePanelView.this.context.getResources().getDisplayMetrics();
                    EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = BasePanelView.this.pageAdapter;
                    if (emotionPanelViewPagerAdapter != null && measuredWidth != (i3 = emotionPanelViewPagerAdapter.mainPanelWidth)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(BasePanelView.LOG_TAG, 2, "onMeasure: oldWidth=" + i3 + " newWidth=" + measuredWidth);
                        }
                        EmotionPanelViewPool.getInstance().destory();
                        EmotionPanelViewPool.widthPixels = measuredWidth;
                        BasePanelView basePanelView = BasePanelView.this;
                        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter2 = basePanelView.pageAdapter;
                        if (measuredWidth / displayMetrics.widthPixels < 0.66f) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        emotionPanelViewPagerAdapter2.multiWindowMode = z16;
                        emotionPanelViewPagerAdapter2.mainPanelWidth = measuredWidth;
                        int currentItem = basePanelView.viewPager.getCurrentItem();
                        BasePanelView basePanelView2 = BasePanelView.this;
                        basePanelView2.viewPager.setAdapter(basePanelView2.pageAdapter);
                        BasePanelView.this.mPanelController.mPanelMallHelper.setAutoOpenPage();
                        BasePanelView.this.viewPager.setCurrentItem(currentItem, false);
                    }
                }
            });
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ei.a(null, "AIO_EmoticonPanel_PageScroll");
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        if (panelDataList == null || this.mPanelController.mPanelTabSortHelper.setSelection(i3)) {
            return;
        }
        EmotionPanelInfo emotionPanelInfo = panelDataList.get(i3);
        if (emotionPanelInfo != null && (emotionPanelViewPagerAdapter = this.pageAdapter) != null) {
            emotionPanelViewPagerAdapter.onPageSelected(emotionPanelInfo);
            int i17 = emotionPanelInfo.type;
            if (i17 == 7) {
                i16 = 1;
            } else if (i17 != 5 && i17 != 4) {
                if (i17 == 11) {
                    i16 = 3;
                } else if (i17 == 8) {
                    i16 = 4;
                } else if (i17 == 9) {
                    i16 = 5;
                } else {
                    EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
                    if (emoticonPackage != null && !StringUtil.isEmpty(emoticonPackage.epId)) {
                        i16 = 6;
                    } else {
                        i16 = -1;
                    }
                }
            } else {
                i16 = 2;
            }
            EmoticonMainPanel emoticonMainPanel = this.mMainPanel;
            if (emoticonMainPanel != null) {
                emoticonMainPanel.onPanelTabSelected(emotionPanelInfo.type);
            }
            ThreadManagerV2.excute(new Runnable(i16) { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$idx;

                {
                    this.val$idx = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasePanelView.this, i16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.val$idx > 0) {
                        ReportController.o(BasePanelView.this.app.getQQAppInterface(), "dc00898", "", "", "0x800a572", "0x800a572", 0, 0, this.val$idx + "", this.val$idx + "", this.val$idx + "", "");
                    }
                    if (this.val$idx == 3) {
                        ReportController.o(null, "dc00898", "", "", "0X800C3C0", "0X800C3C0", 0, 0, "", "", "", "");
                    }
                }
            }, 16, null, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "onPageSelected, position=" + i3 + "panelInfo = " + emotionPanelInfo);
        }
        this.mPanelController.mPanelSettingHelper.switchMoreSettingStyle(emotionPanelInfo);
        try {
            Object item = this.mPanelController.getEmoticonTabAdapter().getItem(i3);
            if ((item instanceof EmoticonTabAdapter.EmoticonTabItem) && ((EmoticonTabAdapter.EmoticonTabItem) item).type == 6) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("touin", this.app.getCurrentUin());
                jSONObject.put("emoji_id", ((EmoticonTabAdapter.EmoticonTabItem) item).epId);
                ((IVas04586Report) QRoute.api(IVas04586Report.class)).reportAction("DressVip", "pg_aio", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "dress", "", "4", 101, 0, 0, "", jSONObject.toString(), "");
            }
        } catch (Exception e16) {
            QLog.i(LOG_TAG, 1, "report exception: " + e16.getMessage());
        }
        if (BasePanelModel.sLastSelectedSecondTabIndex != i3) {
            this.mEmoticonTabs.setSelection(i3);
            if (i3 == sRecommendEmoticonViewPoSition) {
                this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("isClickRecommendRedpoint", true).apply();
            }
        } else if (emotionPanelInfo != null && emotionPanelInfo.type == 8) {
            ThreadManagerV2.excute(new Runnable(i3) { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.8
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$position;

                {
                    this.val$position = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasePanelView.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ReportController.o(BasePanelView.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, "", this.val$position + "", "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d(BasePanelView.LOG_TAG, 2, "view times report. cur page:" + this.val$position);
                    }
                }
            }, 16, null, false);
        }
        BasePanelModel.sLastSelectedSecondTabIndex = i3;
        this.mPanelController.getHelperProvider().dispatchLifeCycle(3, i3, false);
        ei.a("AIO_EmoticonPanel_PageScroll", null);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "[Performance] onPageSelected, handle duration=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.isResumed = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        ei.a(null, "AIO_EmoticonPanel_OnResume");
        this.isResumed = true;
        if (this.mMainPanel.getVisibility() == 0 && this.mNeedUpdate) {
            if (QLog.isColorLevel()) {
                QLog.d(LOG_TAG, 2, "onResume, Emoticon pkg moved\u3001added or deleted, refresh");
            }
            this.mMainPanel.mSecondTabInited = false;
            this.mPanelController.updateLastSelectedSecondTabIndex();
            this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, null);
            this.mDeleteLeftPkgCount = 0;
            this.mNeedUpdate = false;
        } else if (this.mMainPanel.isShown()) {
            if (com.tencent.mobileqq.core.util.a.n(this.mPanelController.getSessionType()) && !TextUtils.isEmpty(this.context.getSharedPreferences("mobileQQ", 0).getString("LAST_ADD_EMO_PACKAGE", ""))) {
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "download in market, initEmoticonView");
                }
                this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, null);
            }
            this.mPanelController.updateFavEmoticonPanel();
        }
        this.mPanelController.getHelperProvider().dispatchLifeCycle(6);
        setSkinColor();
        ei.a("AIO_EmoticonPanel_OnResume", null);
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            this.pageAdapter.onShow();
        }
    }

    public void setEmoticonApp(QQEmoticonMainPanelApp qQEmoticonMainPanelApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQEmoticonMainPanelApp);
        } else {
            this.app = qQEmoticonMainPanelApp;
        }
    }

    public void setFilterSysFaceBeyond255Enable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        this.isFilterSysFaceBeyond255Enable = z16;
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = this.pageAdapter;
        if (emotionPanelViewPagerAdapter != null) {
            emotionPanelViewPagerAdapter.isFilterSysFaceBeyond255 = z16;
        }
    }

    public void setOnlySysEmotionEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        this.mIsOnlySysEmotion = z16;
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = this.pageAdapter;
        if (emotionPanelViewPagerAdapter != null) {
            emotionPanelViewPagerAdapter.isOnlySysEmotion = z16;
        }
    }

    public void setOverScrollMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        HorizontalListViewEx horizontalListViewEx = this.mEmoticonTabs;
        if (horizontalListViewEx != null) {
            horizontalListViewEx.setOverScrollMode(i3);
        }
    }

    public void setSysEmotionOrder(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iArr);
            return;
        }
        this.mSysEmotionOrder = iArr;
        EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = this.pageAdapter;
        if (emotionPanelViewPagerAdapter != null) {
            emotionPanelViewPagerAdapter.sysEmotionOrder = iArr;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.view.IBasePanelView
    public void setViewData(EmoticonPanelParams emoticonPanelParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonPanelParams);
            return;
        }
        EmoticonMainPanel emoticonMainPanel = this.mMainPanel;
        emoticonMainPanel.disableAutoDownload = emoticonPanelParams.disableAutoDownload;
        emoticonMainPanel.disableMoreEmotionButton = emoticonPanelParams.disableMoreEmotionButton;
        emoticonMainPanel.hasBigEmotion = emoticonPanelParams.hasBigEmotion;
        emoticonMainPanel.onlySysAndEmoji = emoticonPanelParams.onlySysAndEmoji;
        emoticonMainPanel.disableGuide = emoticonPanelParams.disableGuide;
        emoticonMainPanel.disableGuideOneTime = emoticonPanelParams.disableGuideOneTime;
        this.showDescInPreview = emoticonPanelParams.showDescInPreview;
        this.mPanelContainerStyleSheet = emoticonPanelParams.containerStyleSheet;
    }

    public void setVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != this.mMainPanel.getVisibility()) {
            if (i3 == 0) {
                int i16 = this.context.getResources().getConfiguration().orientation;
                if (this.mNeedUpdate) {
                    this.mMainPanel.mSecondTabInited = false;
                    this.mPanelController.updateLastSelectedSecondTabIndex();
                    initEmoticonView((String) null);
                    this.mDeleteLeftPkgCount = 0;
                    this.mNeedUpdate = false;
                } else {
                    this.mMainPanel.mSecondTabInited = false;
                    if (!this.mIsPositioningTab) {
                        this.isNeedResetX = false;
                    }
                    this.mIsPositioningTab = false;
                    initEmoticonView((String) null);
                }
                this.mOrientation = i16;
                if (QLog.isColorLevel()) {
                    QLog.d(LOG_TAG, 2, "[Performance] reopen in aio, duration=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                this.mPanelController.updateEmojiMallRedpoint();
                File file = new File(AppConstants.SDCARD_EMOTICON_SAVE);
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (QLog.isColorLevel()) {
                        QLog.d(LOG_TAG, 2, "root dir not exist. try to make it. success:" + mkdirs);
                        return;
                    }
                    return;
                }
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasePanelView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BasePanelView.this.mPanelController.removePopupGuide();
                    }
                }
            }, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowPanelAndSetSelection(int i3, int i16) {
        EmotionPanelInfo emotionPanelInfo;
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        if (panelDataList == null || i3 >= panelDataList.size() || (emotionPanelInfo = panelDataList.get(i3)) == null || emotionPanelInfo.type == i16) {
            return false;
        }
        return true;
    }

    public void showAllTabs() {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.mMainPanel != null && !justShowSystemAndEmoji() && (findViewById = this.mMainPanel.findViewById(R.id.f166941ja2)) != null) {
            findViewById.setVisibility(0);
        }
    }

    public void showPanelByTabIndex(int i3) {
        EmotionPanelInfo emotionPanelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "showPanelByTabIndex tabIndex = " + i3);
        }
        List<EmotionPanelInfo> panelDataList = this.mPanelController.getPanelDataList();
        if (i3 < panelDataList.size()) {
            emotionPanelInfo = panelDataList.get(i3);
        } else {
            emotionPanelInfo = null;
        }
        if (emotionPanelInfo != null) {
            this.mPanelController.mPanelSettingHelper.switchSettingBtnStyle(emotionPanelInfo);
            this.viewPager.setCurrentItem(i3, false);
        }
    }

    public void switchTabMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        int updateOriginalSelectIndex = this.mPanelController.mPanelTabSortHelper.updateOriginalSelectIndex(i3);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "switchTabMode selectIndex = " + i3 + "->" + updateOriginalSelectIndex);
        }
        if (this.app == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ei.a(null, "AIO_EmoticonPanel_EnterSecond");
        if (!this.mMainPanel.mSecondTabInited) {
            this.mPanelController.mPanelMallHelper.asyncInitPanelDataList(this.hasBigEmotion, new EmoticonPanelController.PanelDataCallback(updateOriginalSelectIndex, currentTimeMillis) { // from class: com.tencent.mobileqq.emoticonview.BasePanelView.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$originalSelectIndex;
                final /* synthetic */ long val$startTime;

                {
                    this.val$originalSelectIndex = updateOriginalSelectIndex;
                    this.val$startTime = currentTimeMillis;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BasePanelView.this, Integer.valueOf(updateOriginalSelectIndex), Long.valueOf(currentTimeMillis));
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelController.PanelDataCallback
                public void callbackInMainThread() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.val$originalSelectIndex;
                    if (BasePanelView.this.mMarketPgkDownloaded) {
                        if (QLog.isColorLevel()) {
                            QLog.d(BasePanelView.LOG_TAG, 2, "switchTabMode mMarketPgkDownloaded = true");
                        }
                        List<EmotionPanelInfo> panelDataList = BasePanelView.this.mPanelController.getPanelDataList();
                        if (panelDataList != null && panelDataList.size() > 0) {
                            i16 = BasePanelView.this.mPanelController.mPanelTabSortHelper.getPkgEndSwitchSelectIndex();
                            int lastCanSelectedTabIndex = BasePanelView.this.mPanelController.mPanelTabSortHelper.getLastCanSelectedTabIndex();
                            if (lastCanSelectedTabIndex != 0 && lastCanSelectedTabIndex < i16) {
                                i16 = lastCanSelectedTabIndex;
                            }
                            int findIndexByPanelType = BasePanelView.this.mPanelController.findIndexByPanelType(12);
                            if (BasePanelModel.sLastSelectedSecondTabIndex == findIndexByPanelType) {
                                i16 = findIndexByPanelType;
                            }
                        }
                        BasePanelView.this.mMarketPgkDownloaded = false;
                    }
                    BasePanelView.this.setViewPagerAdapter(this.val$startTime, i16, true);
                }
            });
        } else {
            setViewPagerAdapter(currentTimeMillis, updateOriginalSelectIndex, false);
        }
    }

    public void initEmoticonView(int i3, int i16, String str) {
        int i17;
        String str2;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i19 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        QLog.i(LOG_TAG, 1, "initEmoticonView 2, selectPanelType=" + i3 + ", selectIndex=" + i16 + ", defaultEpId = " + str);
        setSkinColor();
        initGestureDetector();
        getMainPanel().isHiden = false;
        int updateOriginalSelectIndex = this.mPanelController.mPanelTabSortHelper.updateOriginalSelectIndex(i16);
        boolean isSelfieSelect = isSelfieSelect(updateOriginalSelectIndex);
        if (!com.tencent.mobileqq.core.util.a.n(this.mPanelController.getSessionType())) {
            this.mNewFlag.setVisibility(8);
            this.hasBigEmotion = false;
        }
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("mobileQQ", 0);
        String string = sharedPreferences.getString("LAST_ADD_EMO_PACKAGE", "");
        if (!TextUtils.isEmpty(string)) {
            getMainPanel().mSecondTabInited = false;
            this.mMarketPgkDownloaded = false;
            sharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE").apply();
            sharedPreferences.edit().remove("LAST_ADD_EMO_PACKAGE_MAGIC").apply();
            if (QLog.isColorLevel()) {
                QLog.i(LOG_TAG, 2, "initEmoticonView, last add epid is not empty, reset panel type");
            }
            i3 = -1;
        } else {
            if (this.hasBigEmotion && this.mMarketPgkDownloaded) {
                QLog.i(LOG_TAG, 1, "new pkg downloaded in panel, refresh");
                getMainPanel().mSecondTabInited = false;
            }
            i19 = updateOriginalSelectIndex;
        }
        String showEpId = getShowEpId(str, string);
        if (isSelfieSelect && str == null) {
            if (QLog.isColorLevel()) {
                QLog.i(LOG_TAG, 2, "initEmoticonView, select selfie, reset panel type");
            }
            i18 = updateOriginalSelectIndex;
            str2 = null;
            i17 = -1;
        } else {
            i17 = i3;
            str2 = showEpId;
            i18 = i19;
        }
        execQueryTask(i17, i18, System.currentTimeMillis(), str2);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "ep_mall", "show_mine", "", 0, 0, 0, "", "", "");
    }

    public void initEmoticonView(int i3) {
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        this.mIsPositioningTab = true;
        BasePanelModel.sLastSelectedSecondTabIndex = this.mPanelController.findIndexByPanelType(i3);
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "initEmoticonView panelType: " + i3 + " selectIndex: " + BasePanelModel.sLastSelectedSecondTabIndex);
        }
        this.mPanelController.mPanelTabSortHelper.updateLastSelectedSecondTabIndex();
        this.mPanelController.initEmoticonView(i3, BasePanelModel.sLastSelectedSecondTabIndex, null);
        EmoticonPanelController emoticonPanelController = this.mPanelController;
        emoticonPanelController.mPanelMallHelper.isClickNoChangeTab = true;
        emoticonPanelController.mPanelExtendHelper.initPanelExtendHeight();
        if (i3 == 12) {
            this.mPanelController.mPanelHotPicSearchHelper.onSearchPullUp();
            return;
        }
        if (i3 != 18) {
            if (i3 == 20) {
                ((ISearchEmoticonMgrApi) QRoute.api(ISearchEmoticonMgrApi.class)).aioDestroy();
                return;
            }
            return;
        }
        BaseEmotionPanelBusinessParam baseEmotionPanelBusinessParam = this.mPanelController.getParams().businessParamMap.get(Integer.valueOf(i3));
        if (baseEmotionPanelBusinessParam instanceof SearchEmotionPanelBusinessParam) {
            SearchEmotionPanelBusinessParam searchEmotionPanelBusinessParam = (SearchEmotionPanelBusinessParam) baseEmotionPanelBusinessParam;
            str = searchEmotionPanelBusinessParam.searchWord;
            i16 = searchEmotionPanelBusinessParam.defaultSelectTabIndex;
            this.mPanelController.getParams().businessParamMap.remove(Integer.valueOf(i3));
        } else {
            str = "";
            i16 = 0;
        }
        this.mPanelController.mPanelHotPicSearchHelper.popUpSearchDialog(str, 1, i16);
    }

    public void initEmoticonView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LOG_TAG, 2, "initEmoticonView 1");
        }
        this.mPanelController.updateTabSortLastSelectedSecondTabIndex();
        this.mPanelController.initEmoticonView(BasePanelModel.sLastSelectedSecondTabIndex, str);
        this.mPanelController.initPanelExtendHeight();
    }
}
