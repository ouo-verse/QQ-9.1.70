package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BaseEmotionPanelBusinessParam;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes12.dex */
public class EmotionPanelViewPagerAdapter extends PagerAdapter implements View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_EMOTION_COLUMN = 17;
    public static final int PRELOAD_LINE_NUM = 5;
    public static final String TAG = "EmotionPanelViewPagerAdapter";
    public QQEmoticonMainPanelApp app;
    public Map<String, BaseEmotionAdapter> bigEmotionAdapters;
    public int businessType;
    public EmoticonCallback callback;
    public EmotionPanelInfo curItemInfo;
    public List<EmotionPanelInfo> data;
    public float density;
    public SparseArray<ImageButton> emotionDeleteButtons;
    private boolean enableChangeGifPlayState;
    private TextView favTipsText;
    boolean ignoreUIToken;
    IPanelInteractionListener interactionListener;
    boolean isFilterSysFaceBeyond255;
    private boolean isFirstShow;
    boolean isOnlySysEmotion;
    public HashSet<String> justDownload;
    public boolean kanDianBiu;
    public Context mContext;
    public int mainPanelWidth;
    public boolean multiWindowMode;
    public Map<Integer, BaseEmotionAdapter> otherEmotionAdapters;
    IEmoticonPanelController panelController;
    com.tencent.mobileqq.i panelInjectionInfoManager;
    boolean showDescInPreview;
    int[] sysEmotionOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class Switch {
        static IPatchRedirector $redirector_;
        static final boolean preloadSystemEmoticonDrawable;
        static final boolean syncLoadSystemEmoticonPanel;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49512);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                syncLoadSystemEmoticonPanel = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("sync_load_system_emoticon_panel_908", true);
                preloadSystemEmoticonDrawable = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("preload_system_emoticon_drawable_908", true);
            }
        }

        Switch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public EmotionPanelViewPagerAdapter(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, EmoticonCallback emoticonCallback, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQEmoticonMainPanelApp, iPanelInteractionListener, context, emoticonCallback, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.justDownload = new HashSet<>();
        this.isOnlySysEmotion = false;
        this.sysEmotionOrder = null;
        this.isFilterSysFaceBeyond255 = false;
        this.showDescInPreview = false;
        this.enableChangeGifPlayState = true;
        this.ignoreUIToken = false;
        this.isFirstShow = true;
        this.businessType = i3;
        this.app = qQEmoticonMainPanelApp;
        this.mContext = context;
        this.callback = emoticonCallback;
        this.kanDianBiu = z16;
        this.interactionListener = iPanelInteractionListener;
        this.density = context.getResources().getDisplayMetrics().density;
        this.mainPanelWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
        this.data = new ArrayList();
        this.otherEmotionAdapters = new HashMap();
        this.emotionDeleteButtons = new SparseArray<>();
        this.bigEmotionAdapters = new HashMap();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            this.enableChangeGifPlayState = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_change_gif_play_state");
        }
    }

    private void asyncGetPanelData(final int i3, final EmotionPanelInfo emotionPanelInfo, final BaseEmotionAdapter baseEmotionAdapter, final EmotionPanelListView emotionPanelListView) {
        if (i3 == 14) {
            asyncFetchEmotionSearchData();
            return;
        }
        if (i3 == 1 && Switch.syncLoadSystemEmoticonPanel) {
            syncUpdatePanelData(i3, baseEmotionAdapter, emotionPanelInfo, emotionPanelListView);
        } else if (i3 == 22) {
            asyncFetchEmotionAIData();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ah
                @Override // java.lang.Runnable
                public final void run() {
                    EmotionPanelViewPagerAdapter.this.lambda$asyncGetPanelData$0(i3, baseEmotionAdapter, emotionPanelInfo, emotionPanelListView);
                }
            }, 16, null, true);
        }
    }

    private void asyncGetSystemAndEmojiPanelData(EmotionPanelInfo emotionPanelInfo, BaseEmotionAdapter baseEmotionAdapter) {
        ThreadManagerV2.post(new Runnable(baseEmotionAdapter, emotionPanelInfo) { // from class: com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseEmotionAdapter val$adapter;
            final /* synthetic */ EmotionPanelInfo val$panelInfo;

            {
                this.val$adapter = baseEmotionAdapter;
                this.val$panelInfo = emotionPanelInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, EmotionPanelViewPagerAdapter.this, baseEmotionAdapter, emotionPanelInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SystemAndEmojiEmoticonInfo.EmoticonParams emoticonParams = new SystemAndEmojiEmoticonInfo.EmoticonParams(EmotionPanelViewPagerAdapter.this.panelController.getSessionType(), true);
                emoticonParams.keepLottieMerged = EmotionPanelViewPagerAdapter.this.panelController.keepLottieMerged();
                EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter = EmotionPanelViewPagerAdapter.this;
                List<EmotionPanelData> emoticonListFromConfig = SystemAndEmojiEmoticonInfo.getEmoticonListFromConfig(emotionPanelViewPagerAdapter.app, emotionPanelViewPagerAdapter.isFilterSysFaceBeyond255, this.val$adapter.columnNum, emotionPanelViewPagerAdapter.businessType, emoticonParams);
                EmotionPanelViewPagerAdapter emotionPanelViewPagerAdapter2 = EmotionPanelViewPagerAdapter.this;
                EmotionPanelInfo emotionPanelInfo2 = this.val$panelInfo;
                List filterEmotionData = emotionPanelViewPagerAdapter2.filterEmotionData(emotionPanelInfo2.type, emotionPanelInfo2.columnNum, emoticonListFromConfig);
                EmotionPanelViewPagerAdapter.this.handleIPSite(this.val$panelInfo.emotionPkg, this.val$adapter, filterEmotionData);
                EmotionPanelViewPagerAdapter.this.onGetSystemAndEmojiPanelDataResult(this.val$panelInfo, this.val$adapter, filterEmotionData);
            }
        }, 5, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<EmotionPanelData> filterEmotionData(int i3, int i16, List<EmotionPanelData> list) {
        List<EmotionPanelData> filterEmotionData = this.panelController.getFilterEmotionData(i3);
        if (filterEmotionData != null && !filterEmotionData.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            boolean z16 = false;
            for (Parcelable parcelable : list) {
                boolean z17 = parcelable instanceof SystemAndEmojiEmoticonInfo;
                if (z17) {
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) parcelable;
                    if (isInFilterList(filterEmotionData, systemAndEmojiEmoticonInfo)) {
                        QLog.d(TAG, 1, "filterEmotionData. type:" + systemAndEmojiEmoticonInfo.emotionType + ", id: " + systemAndEmojiEmoticonInfo.code);
                    }
                }
                if (!(parcelable instanceof IFavoriteEmoticonInfo) || !isInFilterList(filterEmotionData, (IFavoriteEmoticonInfo) parcelable)) {
                    if (z17) {
                        if (((SystemAndEmojiEmoticonInfo) parcelable).emotionType == 3) {
                            if (!z16) {
                                z16 = true;
                            }
                        } else if (z16) {
                            int size = arrayList.size() % i16;
                            if (size > 0) {
                                int i17 = i16 - size;
                                for (int i18 = 0; i18 < i17; i18++) {
                                    arrayList.add(new SystemAndEmojiEmoticonInfo(7, 3, -1, "", false));
                                }
                            }
                            z16 = false;
                        }
                    }
                    arrayList.add(parcelable);
                }
            }
            QLog.d(TAG, 1, "after filterEmotionData. filteredData size:" + arrayList.size() + ", origin data size: " + list.size());
            return arrayList;
        }
        return list;
    }

    private int getColumnNum(EmotionPanelListView emotionPanelListView, EmotionPanelInfo emotionPanelInfo) {
        int i3 = emotionPanelInfo.columnNum;
        if (this.multiWindowMode && !AppSetting.t(emotionPanelListView.getContext())) {
            i3 = Math.max(1, (i3 * 4) / 7);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "multiWindowMode: " + emotionPanelInfo.columnNum + "->" + i3);
            }
        }
        return i3;
    }

    private List<EmotionPanelData> getEmotionPanelData(int i3, BaseEmotionAdapter baseEmotionAdapter, EmotionPanelInfo emotionPanelInfo) {
        boolean z16;
        boolean z17;
        int i16;
        List<EmotionPanelData> syncGetEmotionPanelData;
        if (i3 == 1) {
            if (this.isOnlySysEmotion) {
                syncGetEmotionPanelData = SystemAndEmojiEmoticonInfo.getOnlySysEmoticonListFromConfig(this.app, baseEmotionAdapter.columnNum, this.sysEmotionOrder);
            } else {
                SystemAndEmojiEmoticonInfo.EmoticonParams emoticonParams = new SystemAndEmojiEmoticonInfo.EmoticonParams(this.panelController.getSessionType(), true);
                emoticonParams.keepLottieMerged = this.panelController.keepLottieMerged();
                syncGetEmotionPanelData = SystemAndEmojiEmoticonInfo.getEmoticonListFromConfig(this.app, this.isFilterSysFaceBeyond255, baseEmotionAdapter.columnNum, this.businessType, emoticonParams);
            }
        } else if (i3 == 16) {
            SystemAndEmojiEmoticonInfo.EmoticonParams emoticonParams2 = new SystemAndEmojiEmoticonInfo.EmoticonParams(this.panelController.getSessionType(), true);
            emoticonParams2.keepLottieMerged = this.panelController.keepLottieMerged();
            syncGetEmotionPanelData = SystemAndEmojiEmoticonInfo.getSysEmotionPanelData(this.isFilterSysFaceBeyond255, baseEmotionAdapter.columnNum, emoticonParams2);
        } else if (i3 == 17) {
            syncGetEmotionPanelData = SystemAndEmojiEmoticonInfo.getEmojiEmoticonPanelData(baseEmotionAdapter.columnNum, QQEmojiUtil.getOrderList());
        } else if (i3 == 21) {
            SystemAndEmojiEmoticonInfo.EmoticonParams emoticonParams3 = new SystemAndEmojiEmoticonInfo.EmoticonParams(this.panelController.getSessionType(), true);
            emoticonParams3.keepLottieMerged = this.panelController.keepLottieMerged();
            syncGetEmotionPanelData = SystemAndEmojiEmoticonInfo.getAniStickerPanelData(this.isFilterSysFaceBeyond255, baseEmotionAdapter.columnNum, emoticonParams3);
        } else if (i3 == 18) {
            List<EmotionPanelData> customEmotionData = this.panelController.getCustomEmotionData(emotionPanelInfo.type);
            SystemAndEmojiEmoticonInfo.EmoticonParams emoticonParams4 = new SystemAndEmojiEmoticonInfo.EmoticonParams(this.panelController.getSessionType(), true);
            emoticonParams4.keepLottieMerged = this.panelController.keepLottieMerged();
            syncGetEmotionPanelData = SystemAndEmojiEmoticonInfo.getRecentEmoticonPanelData(this.isFilterSysFaceBeyond255, baseEmotionAdapter.columnNum, emoticonParams4, customEmotionData);
        } else {
            IPanelInteractionListener iPanelInteractionListener = this.interactionListener;
            if (iPanelInteractionListener != null && !iPanelInteractionListener.needShowFavAndFunnyPicIcon()) {
                z16 = false;
            } else {
                z16 = true;
            }
            IPanelInteractionListener iPanelInteractionListener2 = this.interactionListener;
            if (iPanelInteractionListener2 != null && !iPanelInteractionListener2.canShowGif()) {
                z17 = false;
            } else {
                z17 = true;
            }
            EmotionPanelDataBuilder emotionPanelDataBuilder = EmotionPanelDataBuilder.getInstance();
            QQEmoticonMainPanelApp qQEmoticonMainPanelApp = this.app;
            EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
            IPanelInteractionListener iPanelInteractionListener3 = this.interactionListener;
            if (iPanelInteractionListener3 != null) {
                i16 = iPanelInteractionListener3.getCurType();
            } else {
                i16 = -1;
            }
            syncGetEmotionPanelData = emotionPanelDataBuilder.syncGetEmotionPanelData(qQEmoticonMainPanelApp, i3, emoticonPackage, i16, this.businessType, this.kanDianBiu, z16, z17);
        }
        return filterEmotionData(emotionPanelInfo.type, emotionPanelInfo.columnNum, syncGetEmotionPanelData);
    }

    private RelativeLayout getQCircleEmoticonLayout(EmotionPanelListView emotionPanelListView) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        String f16 = ud2.a.f438849a.f();
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        if (!TextUtils.isEmpty(f16)) {
            TextView textView = this.favTipsText;
            if (textView != null) {
                emotionPanelListView.removeHeaderView(textView);
            }
            this.favTipsText = new TextView(this.mContext);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            this.favTipsText.setPadding(ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(12.0f), 0, 0);
            this.favTipsText.setLayoutParams(layoutParams);
            this.favTipsText.setTextColor(Color.parseColor("#FF999999"));
            this.favTipsText.setTextSize(1, 10.0f);
            this.favTipsText.setText(f16);
            emotionPanelListView.addHeaderView(this.favTipsText);
        }
        relativeLayout.addView(emotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }

    @NotNull
    private RelativeLayout getSystemSmallEmoticonRelativeLayout(int i3, EmotionPanelListView emotionPanelListView, BaseEmotionAdapter baseEmotionAdapter) {
        int i16;
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        relativeLayout.addView(emotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ImageButton imageButton = new ImageButton(this.mContext);
        imageButton.setContentDescription(this.mContext.getString(R.string.br7));
        if (QQTheme.isNowThemeIsNight()) {
            imageButton.setBackgroundResource(R.drawable.j6_);
        } else {
            imageButton.setBackgroundResource(R.drawable.f160110ho);
        }
        imageButton.setOnClickListener(this);
        if (TextUtils.isEmpty(this.interactionListener.getEditText().getText())) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        imageButton.setVisibility(i16);
        layoutParams.rightMargin = ViewUtils.dip2px(5.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(18.0f);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        relativeLayout.addView(imageButton, layoutParams);
        this.emotionDeleteButtons.put(i3, imageButton);
        imageButton.measure(0, 0);
        if (baseEmotionAdapter instanceof SystemAndEmojiAdapter) {
            ((SystemAndEmojiAdapter) baseEmotionAdapter).setLastItemAddPaddingBottom(imageButton.getMeasuredHeight());
        }
        return relativeLayout;
    }

    @NotNull
    private RelativeLayout getZPlanEmoticonLayout(EmotionPanelListView emotionPanelListView) {
        RelativeLayout generateZPlanAioPanelLayout = ((IZPlanEmoticonApi) QRoute.api(IZPlanEmoticonApi.class)).generateZPlanAioPanelLayout(this.mContext, this.panelController.getSessionType());
        generateZPlanAioPanelLayout.setId(R.id.f126327og);
        generateZPlanAioPanelLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        generateZPlanAioPanelLayout.addView(emotionPanelListView, new RelativeLayout.LayoutParams(-1, -1));
        return generateZPlanAioPanelLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIPSite(EmoticonPackage emoticonPackage, BaseEmotionAdapter baseEmotionAdapter, List<EmotionPanelData> list) {
        Emoticon emoticon;
        EmoticonPackage syncFindEmoticonPackageById;
        if (emoticonPackage != null) {
            EmoticonRecDressup emotionRecommend = EmoticonRecDressup.getEmotionRecommend(emoticonPackage.epId, false);
            if (emotionRecommend == null || System.currentTimeMillis() - emotionRecommend.lastLookupTime > EmoticonRecDressup.RECOMMEND_EXPIRED_TIME) {
                ((EmoticonHandlerProxy) this.app.getBusinessHandler(EmoticonHandler.F)).fetchEmoticonRecommend(Integer.parseInt(emoticonPackage.epId));
            }
            if (baseEmotionAdapter instanceof BigEmotionDownloadedAdapter) {
                fetchIPSite((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class), Collections.singleton(emoticonPackage), false);
                return;
            }
            if ((baseEmotionAdapter instanceof MagicFaceAdapter) && list != null) {
                EmoticonManagerServiceProxy emoticonManagerServiceProxy = (EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class);
                ArrayList arrayList = new ArrayList();
                for (EmotionPanelData emotionPanelData : list) {
                    if ((emotionPanelData instanceof PicEmoticonInfo) && (emoticon = ((PicEmoticonInfo) emotionPanelData).emoticon) != null && (syncFindEmoticonPackageById = emoticonManagerServiceProxy.syncFindEmoticonPackageById(emoticon.epId)) != null) {
                        arrayList.add(syncFindEmoticonPackageById);
                    }
                }
                fetchIPSite(emoticonManagerServiceProxy, arrayList, true);
            }
        }
    }

    private void initEmoticonPanelAIHelper(EmotionPanelListView emotionPanelListView, BaseEmotionAdapter baseEmotionAdapter) {
        EmoticonMainPanel emoticonMainPanel;
        if (emotionPanelListView == null || this.interactionListener == null || (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) == null) {
            return;
        }
        ((EmoticonPanelAIHelper) emoticonMainPanel.getEmoController().getHelper(13)).setListViewAndAdapter(emotionPanelListView, baseEmotionAdapter);
    }

    private boolean isInFilterList(List<EmotionPanelData> list, SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo) {
        for (EmotionPanelData emotionPanelData : list) {
            if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo2 = (SystemAndEmojiEmoticonInfo) emotionPanelData;
                if (systemAndEmojiEmoticonInfo.emotionType == systemAndEmojiEmoticonInfo2.emotionType && systemAndEmojiEmoticonInfo.code == systemAndEmojiEmoticonInfo2.code) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPendingToShow(int i3) {
        EmoticonPanelViewPager viewPager;
        IEmoticonPanelController iEmoticonPanelController = this.panelController;
        if (!(iEmoticonPanelController instanceof EmoticonPanelController) || (viewPager = ((EmoticonPanelController) iEmoticonPanelController).getViewPager()) == null || i3 != viewPager.getCurrentItem()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncGetPanelData$0(int i3, BaseEmotionAdapter baseEmotionAdapter, EmotionPanelInfo emotionPanelInfo, EmotionPanelListView emotionPanelListView) {
        List<EmotionPanelData> emotionPanelData = getEmotionPanelData(i3, baseEmotionAdapter, emotionPanelInfo);
        handleIPSite(emotionPanelInfo.emotionPkg, baseEmotionAdapter, emotionPanelData);
        onGetPanelDataResult(i3, emotionPanelInfo, baseEmotionAdapter, emotionPanelListView, emotionPanelData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$syncUpdatePanelData$1(EmotionPanelInfo emotionPanelInfo, BaseEmotionAdapter baseEmotionAdapter, List list) {
        handleIPSite(emotionPanelInfo.emotionPkg, baseEmotionAdapter, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetSystemAndEmojiPanelDataResult(EmotionPanelInfo emotionPanelInfo, BaseEmotionAdapter baseEmotionAdapter, List<EmotionPanelData> list) {
        ThreadManager.getUIHandler().post(new Runnable(emotionPanelInfo, list, baseEmotionAdapter) { // from class: com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseEmotionAdapter val$adapter;
            final /* synthetic */ List val$data;
            final /* synthetic */ EmotionPanelInfo val$panelInfo;

            {
                this.val$panelInfo = emotionPanelInfo;
                this.val$data = list;
                this.val$adapter = baseEmotionAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, EmotionPanelViewPagerAdapter.this, emotionPanelInfo, list, baseEmotionAdapter);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d(EmotionPanelViewPagerAdapter.TAG, 1, "onGetSystemAndEmojiPanelDataResult get data panelInfo = " + this.val$panelInfo);
                List list2 = this.val$data;
                if (list2 != null && list2.size() > 0) {
                    this.val$adapter.setData(this.val$data);
                }
            }
        });
    }

    private boolean preloadSystemAndEmoji(EmotionPanelData emotionPanelData) {
        boolean z16 = false;
        if (!(emotionPanelData instanceof SystemAndEmojiEmoticonInfo)) {
            return false;
        }
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emotionPanelData;
        if (systemAndEmojiEmoticonInfo.type != 3 && systemAndEmojiEmoticonInfo.code != -1) {
            Drawable bigDrawable = systemAndEmojiEmoticonInfo.getBigDrawable(this.mContext, this.density);
            z16 = true;
            if (bigDrawable instanceof URLDrawable) {
                URLDrawable uRLDrawable = (URLDrawable) bigDrawable;
                if (uRLDrawable.getStatus() != 1) {
                    uRLDrawable.startDownload();
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadSystemEmotion(List<EmotionPanelData> list, ListView listView) {
        if (listView != null && list != null && list.size() > 0) {
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            int i3 = EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI;
            int i16 = i3 * 5;
            int i17 = i3 * (lastVisiblePosition + 1);
            for (int i18 = i17; i18 < i17 + i16 && i18 < list.size(); i18++) {
                preloadSystemAndEmoji(list.get(i18));
            }
            int i19 = (EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI * firstVisiblePosition) - 1;
            for (int i26 = i19; i26 >= 0 && i26 > i19 - i16 && i26 < list.size(); i26--) {
                preloadSystemAndEmoji(list.get(i26));
            }
        }
    }

    private void setBigEmotionDownloadedAdapterTabIdx(BaseEmotionAdapter baseEmotionAdapter, int i3) {
        if (baseEmotionAdapter instanceof BigEmotionDownloadedAdapter) {
            ((BigEmotionDownloadedAdapter) baseEmotionAdapter).setTabIdx(i3);
        }
    }

    private void setSystemAndEmojiAdapterLocalId(BaseEmotionAdapter baseEmotionAdapter) {
        EmoticonMainPanel emoticonMainPanel;
        if (this.interactionListener != null && (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) != null && (baseEmotionAdapter instanceof SystemAndEmojiAdapter)) {
            SystemAndEmojiAdapter systemAndEmojiAdapter = (SystemAndEmojiAdapter) baseEmotionAdapter;
            systemAndEmojiAdapter.mLocalId = emoticonMainPanel.mLocalId;
            systemAndEmojiAdapter.mEmotionType = emoticonMainPanel.mEmotionType;
            emoticonMainPanel.mLocalId = -1;
            emoticonMainPanel.mEmotionType = -1;
        }
    }

    private void syncUpdatePanelData(int i3, final BaseEmotionAdapter baseEmotionAdapter, final EmotionPanelInfo emotionPanelInfo, EmotionPanelListView emotionPanelListView) {
        long currentTimeMillis = System.currentTimeMillis();
        final List<EmotionPanelData> emotionPanelData = getEmotionPanelData(i3, baseEmotionAdapter, emotionPanelInfo);
        if (i3 == 1 && Switch.preloadSystemEmoticonDrawable) {
            preloadSystemEmotion(emotionPanelData, emotionPanelListView);
        }
        onGetPanelDataResult(i3, emotionPanelInfo, baseEmotionAdapter, emotionPanelListView, emotionPanelData);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ai
            @Override // java.lang.Runnable
            public final void run() {
                EmotionPanelViewPagerAdapter.this.lambda$syncUpdatePanelData$1(emotionPanelInfo, baseEmotionAdapter, emotionPanelData);
            }
        }, 16, null, true);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[syncUpdatePanelData] panelType=" + i3 + ", costTime=" + currentTimeMillis2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updatePanelData, reason: merged with bridge method [inline-methods] */
    public void lambda$onGetPanelDataResult$2(int i3, EmotionPanelInfo emotionPanelInfo, BaseEmotionAdapter baseEmotionAdapter, ListView listView, List<EmotionPanelData> list) {
        QLog.d(TAG, 1, "instantiateItem get data callback, panelType = " + i3 + ", panelInfo = " + emotionPanelInfo);
        listView.setOnScrollListener(new AbsListView.OnScrollListener(i3, baseEmotionAdapter, list, listView) { // from class: com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseEmotionAdapter val$adapter;
            final /* synthetic */ List val$data;
            final /* synthetic */ ListView val$listView;
            final /* synthetic */ int val$panelType;

            {
                this.val$panelType = i3;
                this.val$adapter = baseEmotionAdapter;
                this.val$data = list;
                this.val$listView = listView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, EmotionPanelViewPagerAdapter.this, Integer.valueOf(i3), baseEmotionAdapter, list, listView);
                }
            }

            protected boolean isInAIOAndSystemPanelReport(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i16)).booleanValue();
                }
                if (EmotionPanelViewPagerAdapter.this.panelController.isInAIO() && i16 == 0 && this.val$panelType == 1) {
                    return true;
                }
                return false;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i16, int i17, int i18) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, absListView, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i16) {
                BaseEmotionAdapter baseEmotionAdapter2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i16);
                    return;
                }
                processScrollStateChange(i16);
                if (isInAIOAndSystemPanelReport(i16)) {
                    ReportController.o(null, "dc00898", "", "", "0X800B9F4", "0X800B9F4", 0, 0, "", "", "", "");
                }
                if (this.val$panelType == 19 && (baseEmotionAdapter2 = this.val$adapter) != null) {
                    baseEmotionAdapter2.onScrollStateChange(i16);
                }
            }

            protected void processScrollStateChange(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i16);
                    return;
                }
                if (i16 != 0 && i16 != 2) {
                    URLDrawable.pause();
                    if (EmotionPanelViewPagerAdapter.this.enableChangeGifPlayState) {
                        AbstractGifImage.pauseAll();
                        return;
                    }
                    return;
                }
                URLDrawable.resume();
                if (EmotionPanelViewPagerAdapter.this.enableChangeGifPlayState) {
                    AbstractGifImage.resumeAll();
                }
                if (this.val$panelType == 1) {
                    EmotionPanelViewPagerAdapter.this.preloadSystemEmotion(this.val$data, this.val$listView);
                }
            }
        });
        if (list != null && list.size() > 0) {
            baseEmotionAdapter.setData(list);
        }
    }

    protected void addHotPicEmoticonHeaderAndFooter(EmotionPanelListView emotionPanelListView, BaseEmotionAdapter baseEmotionAdapter, View view, int i3) {
        EmoticonMainPanel emoticonMainPanel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, emotionPanelListView, baseEmotionAdapter, view, Integer.valueOf(i3));
            return;
        }
        if (emotionPanelListView == null || this.interactionListener == null || (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) == null) {
            return;
        }
        EmoticonPanelHotPicSearchHelper emoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6);
        emoticonPanelHotPicSearchHelper.addHeaderAndFooterView(emotionPanelListView, baseEmotionAdapter, i3);
        emoticonPanelHotPicSearchHelper.setEmptyView(view);
        emotionPanelListView.addOnScrollListener(emoticonPanelHotPicSearchHelper);
    }

    protected void asyncFetchEmotionAIData() {
        EmoticonMainPanel emoticonMainPanel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            if (this.interactionListener == null || (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) == null) {
                return;
            }
            ((EmoticonPanelAIHelper) emoticonMainPanel.getEmoController().getHelper(13)).loadPicData();
        }
    }

    protected void asyncFetchEmotionSearchData() {
        EmoticonMainPanel emoticonMainPanel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            if (this.interactionListener == null || (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) == null) {
                return;
            }
            ((EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6)).loadPicData();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View view, int i3, Object obj) {
        EmotionPanelListView emotionPanelListView;
        BaseEmotionAdapter baseEmotionAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, Integer.valueOf(i3), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "destroyItem position = " + i3);
        }
        if (view != null && obj != null) {
            ((ViewGroup) view).removeView((View) obj);
            if (obj instanceof RelativeLayout) {
                emotionPanelListView = (EmotionPanelListView) ((RelativeLayout) obj).findViewById(R.id.shi);
                ((ViewGroup) emotionPanelListView.getParent()).removeView(emotionPanelListView);
            } else {
                emotionPanelListView = (EmotionPanelListView) obj;
            }
            ListAdapter adapter = emotionPanelListView.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                baseEmotionAdapter = (BaseEmotionAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            } else {
                baseEmotionAdapter = (BaseEmotionAdapter) adapter;
            }
            emotionPanelListView.setAdapter((ListAdapter) null);
            emotionPanelListView.setOnScrollListener(null);
            emotionPanelListView.setEnableExtendPanle(false);
            emotionPanelListView.setShowDeleteButton(false);
            emotionPanelListView.setPullAndFastScrollListener(null);
            removeHeaderAndFooterView(emotionPanelListView);
            if (baseEmotionAdapter != null) {
                int i16 = baseEmotionAdapter.emotionType;
                if (i16 != 6 && i16 != 10) {
                    if (this.otherEmotionAdapters.containsKey(Integer.valueOf(i16))) {
                        this.otherEmotionAdapters.remove(Integer.valueOf(i16));
                    }
                } else {
                    EmoticonPackage emoticonPackage = baseEmotionAdapter.getEmoticonPackage();
                    if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId) && this.bigEmotionAdapters.containsKey(emoticonPackage.epId)) {
                        this.bigEmotionAdapters.remove(emoticonPackage.epId);
                    }
                }
                SparseArray<ImageButton> sparseArray = this.emotionDeleteButtons;
                if (sparseArray != null) {
                    sparseArray.remove(i3);
                }
                baseEmotionAdapter.destory();
            }
            EmotionPanelListViewPool.getInstance().relase(emotionPanelListView);
            return;
        }
        QLog.e(TAG, 1, "container or object = null");
    }

    public void fetchIPSite(EmoticonManagerServiceProxy emoticonManagerServiceProxy, Collection<EmoticonPackage> collection, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, emoticonManagerServiceProxy, collection, Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        EmoticonHandlerProxy emoticonHandlerProxy = (EmoticonHandlerProxy) this.app.getBusinessHandler(EmoticonHandler.F);
        for (EmoticonPackage emoticonPackage : collection) {
            if (emoticonPackage.status == 2) {
                long j3 = emoticonPackage.richIPReqTime;
                if (j3 == 0) {
                    j3 = 86400;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "rich ip emoticon, richReqTime = " + j3 + " epId = " + emoticonPackage.epId);
                }
                if (currentTimeMillis - emoticonPackage.richIPLastReqTime > j3 * 1000) {
                    emoticonPackage.richIPLastReqTime = currentTimeMillis;
                    emoticonHandlerProxy.fetchEmoticonIPSiteInformationEx(emoticonPackage.epId, z16);
                    emoticonManagerServiceProxy.saveEmoticonPackage(emoticonPackage);
                }
            }
        }
    }

    public BaseEmotionAdapter getAdapterFromCache(EmotionPanelInfo emotionPanelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (BaseEmotionAdapter) iPatchRedirector.redirect((short) 19, (Object) this, (Object) emotionPanelInfo);
        }
        if (emotionPanelInfo == null) {
            return null;
        }
        int i3 = emotionPanelInfo.type;
        if (i3 != 6 && i3 != 10) {
            if (this.otherEmotionAdapters.containsKey(Integer.valueOf(i3))) {
                return this.otherEmotionAdapters.get(Integer.valueOf(emotionPanelInfo.type));
            }
        } else {
            EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
            if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId) && this.bigEmotionAdapters.containsKey(emoticonPackage.epId)) {
                return this.bigEmotionAdapters.get(emoticonPackage.epId);
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        List<EmotionPanelInfo> list = this.data;
        if (list != null) {
            return list.size();
        }
        QLog.e(TAG, 1, "getCount count = 0");
        return 0;
    }

    public ImageButton getDeleteButtonFromCache(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ImageButton) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        SparseArray<ImageButton> sparseArray = this.emotionDeleteButtons;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i3);
    }

    protected RelativeLayout getHotPicSearchEmoticonLayout(EmotionPanelListView emotionPanelListView, int i3, BaseEmotionAdapter baseEmotionAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 12, this, emotionPanelListView, Integer.valueOf(i3), baseEmotionAdapter);
        }
        if (i3 == 14) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            emotionPanelListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.addView(emotionPanelListView);
            relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = ViewUtils.dip2px(60.0f);
            layoutParams.addRule(12);
            View inflate = View.inflate(this.mContext, R.layout.duv, null);
            relativeLayout.addView(inflate, layoutParams);
            addHotPicEmoticonHeaderAndFooter(emotionPanelListView, baseEmotionAdapter, inflate, i3);
            emotionPanelListView.setVerticalScrollBarEnabled(false);
            return relativeLayout;
        }
        if (i3 == 13) {
            RelativeLayout relativeLayout2 = new RelativeLayout(this.mContext);
            relativeLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            linearLayout2.setOrientation(1);
            emotionPanelListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout2.addView(emotionPanelListView);
            relativeLayout2.addView(linearLayout2, new RelativeLayout.LayoutParams(-1, -1));
            return relativeLayout2;
        }
        removeHeaderAndFooterView(emotionPanelListView);
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, obj)).intValue();
        }
        if (obj instanceof View) {
            View view = (View) obj;
            Object tag = view.getTag();
            if (tag instanceof EmotionPanelInfo) {
                EmotionPanelInfo emotionPanelInfo = (EmotionPanelInfo) tag;
                EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
                if (emoticonPackage != null && this.justDownload.contains(emoticonPackage.epId)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getItemPosition destroy " + view.getTag());
                    }
                    return -2;
                }
                int indexOf = this.data.indexOf(emotionPanelInfo);
                if (indexOf < 0) {
                    return -2;
                }
                return indexOf;
            }
        }
        return super.getItemPosition(obj);
    }

    public RelativeLayout initQCircleEmoticonLayout(EmotionPanelListView emotionPanelListView, int i3, RelativeLayout relativeLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 11, this, emotionPanelListView, Integer.valueOf(i3), relativeLayout);
        }
        IPanelInteractionListener iPanelInteractionListener = this.interactionListener;
        if (iPanelInteractionListener != null && !iPanelInteractionListener.needShowFavAndFunnyPicIcon()) {
            if (i3 == 4) {
                return getQCircleEmoticonLayout(emotionPanelListView);
            }
            TextView textView = this.favTipsText;
            if (textView != null) {
                emotionPanelListView.removeHeaderView(textView);
                return relativeLayout;
            }
            return relativeLayout;
        }
        return relativeLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x021e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d3  */
    @Override // androidx.viewpager.widget.PagerAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object instantiateItem(View view, int i3) {
        RelativeLayout relativeLayout;
        int i16;
        EmoticonPackage emoticonPackage;
        View view2;
        IPanelInteractionListener iPanelInteractionListener;
        RelativeLayout systemSmallEmoticonRelativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
        }
        EmotionPanelListView listView = EmotionPanelListViewPool.getInstance().getListView(this.mContext);
        if (listView == null) {
            QLog.e(TAG, 1, "instantiateItem listView is null");
            return null;
        }
        listView.setDivider(null);
        listView.setVerticalScrollBarEnabled(true);
        listView.setSelector(R.drawable.f162601b70);
        listView.setId(R.id.shi);
        listView.setMotionEventSplittingEnabled(false);
        EmotionPanelInfo emotionPanelInfo = this.data.get(i3);
        int panelType = EmotionPanelConstans.getPanelType(this.app, emotionPanelInfo);
        BaseEmotionAdapter adapter = EmotionPanelListViewAdapterBuilder.getInstance().getAdapter(this.app, this.mContext, this.panelInjectionInfoManager, this.interactionListener, getColumnNum(listView, emotionPanelInfo), panelType, emotionPanelInfo.type, emotionPanelInfo.emotionPkg, this.callback, this.businessType, this.kanDianBiu, isPendingToShow(i3));
        if (adapter == null) {
            QLog.e(TAG, 1, "instantiateItem adapter is null, panelType = " + panelType);
            return null;
        }
        RelativeLayout relativeLayout2 = null;
        adapter.ignoreUIToken = this.ignoreUIToken;
        IEmoticonPanelController iEmoticonPanelController = this.panelController;
        if ((iEmoticonPanelController instanceof EmoticonPanelController) && ((EmoticonPanelController) iEmoticonPanelController).getParams().adjustColumn && (adapter instanceof SystemAndEmojiAdapter)) {
            float f16 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            float f17 = this.density;
            adapter.columnNum = Math.max(17, (int) ((f16 - (18.0f * f17)) / (f17 * 48.0f)));
        }
        setSystemAndEmojiAdapterLocalId(adapter);
        setBigEmotionDownloadedAdapterTabIdx(adapter, i3);
        if (adapter instanceof SystemAndEmojiAdapter) {
            SystemAndEmojiAdapter systemAndEmojiAdapter = (SystemAndEmojiAdapter) adapter;
            systemAndEmojiAdapter.isOnlySysEmotion = this.isOnlySysEmotion;
            systemAndEmojiAdapter.setPanelController(this.panelController);
            systemAndEmojiAdapter.setShowDescribeInPreview(this.showDescInPreview);
            BaseEmotionPanelBusinessParam panelBusinessParam = this.panelController.getPanelBusinessParam(21);
            if (this.panelController.getSessionType() == 10017 && (panelBusinessParam instanceof PhotoCommentEmotionPanelBusinessParam)) {
                systemAndEmojiAdapter.showTitleLightColor = ((PhotoCommentEmotionPanelBusinessParam) panelBusinessParam).showTitleLightColor;
            }
        } else if (adapter instanceof EmotionHotPicSearchAdapter) {
            ((EmotionHotPicSearchAdapter) adapter).setEmoPanelController(this.panelController);
        }
        if (this.interactionListener != null) {
            EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
            if (emoticonMainPanel != null && (iPanelInteractionListener = this.interactionListener) != null && iPanelInteractionListener.getEditText() != null && emoticonMainPanel.isShowExtendPanel()) {
                listView.setEnableExtendPanle(true);
                listView.setPullAndFastScrollListener(emoticonMainPanel);
                AbsListView.OnScrollListener onScrollListener = listView.getOnScrollListener();
                if (!(onScrollListener instanceof EmoticonPanelOnScrollListener)) {
                    listView.setOnScrollListener(new EmoticonPanelOnScrollListener(listView, emoticonMainPanel, onScrollListener));
                }
                if (panelType != 1 && panelType != 2) {
                    if (panelType != 19) {
                        if (panelType != 21) {
                            if (panelType != 22) {
                                systemSmallEmoticonRelativeLayout = getHotPicSearchEmoticonLayout(listView, panelType, adapter);
                            } else {
                                initEmoticonPanelAIHelper(listView, adapter);
                                systemSmallEmoticonRelativeLayout = null;
                            }
                        }
                    } else {
                        systemSmallEmoticonRelativeLayout = getZPlanEmoticonLayout(listView);
                    }
                    relativeLayout = initQCircleEmoticonLayout(listView, panelType, systemSmallEmoticonRelativeLayout);
                    adapter.setWidthPixels(this.mainPanelWidth);
                    adapter.curPanelInfo = this.curItemInfo;
                    adapter.setCurrentListView(listView);
                    listView.setAdapter((ListAdapter) adapter);
                    i16 = emotionPanelInfo.type;
                    if (i16 == 6 && i16 != 10) {
                        this.otherEmotionAdapters.put(Integer.valueOf(i16), adapter);
                    } else {
                        emoticonPackage = emotionPanelInfo.emotionPkg;
                        if (emoticonPackage == null && !TextUtils.isEmpty(emoticonPackage.epId)) {
                            this.bigEmotionAdapters.put(emoticonPackage.epId, adapter);
                        } else {
                            QLog.e(TAG, 1, "instantiateItem put adapter to map error");
                        }
                    }
                    if (relativeLayout != null) {
                        view2 = view;
                        if (relativeLayout.getParent() != view2 && i3 < getF373114d()) {
                            ((ViewGroup) view2).addView(relativeLayout);
                            listView.setTag(emotionPanelInfo);
                            asyncGetPanelData(panelType, emotionPanelInfo, adapter, listView);
                            if (relativeLayout == null) {
                                return relativeLayout;
                            }
                            return listView;
                        }
                    } else {
                        view2 = view;
                    }
                    if (listView.getParent() != view2 && i3 < getF373114d()) {
                        ((ViewGroup) view2).addView(listView);
                    }
                    listView.setTag(emotionPanelInfo);
                    asyncGetPanelData(panelType, emotionPanelInfo, adapter, listView);
                    if (relativeLayout == null) {
                    }
                }
                systemSmallEmoticonRelativeLayout = getSystemSmallEmoticonRelativeLayout(i3, listView, adapter);
                relativeLayout = initQCircleEmoticonLayout(listView, panelType, systemSmallEmoticonRelativeLayout);
                adapter.setWidthPixels(this.mainPanelWidth);
                adapter.curPanelInfo = this.curItemInfo;
                adapter.setCurrentListView(listView);
                listView.setAdapter((ListAdapter) adapter);
                i16 = emotionPanelInfo.type;
                if (i16 == 6) {
                }
                emoticonPackage = emotionPanelInfo.emotionPkg;
                if (emoticonPackage == null) {
                }
                QLog.e(TAG, 1, "instantiateItem put adapter to map error");
                if (relativeLayout != null) {
                }
                if (listView.getParent() != view2) {
                    ((ViewGroup) view2).addView(listView);
                }
                listView.setTag(emotionPanelInfo);
                asyncGetPanelData(panelType, emotionPanelInfo, adapter, listView);
                if (relativeLayout == null) {
                }
            } else {
                IEmoticonPanelController iEmoticonPanelController2 = this.panelController;
                if ((iEmoticonPanelController2 instanceof EmoticonPanelController) && ((EmoticonPanelController) iEmoticonPanelController2).getParams().showEmotionPanelDeleteButton) {
                    relativeLayout2 = getSystemSmallEmoticonRelativeLayout(i3, listView, adapter);
                    listView.setShowDeleteButton(true);
                    listView.setPullAndFastScrollListener(emoticonMainPanel);
                    AbsListView.OnScrollListener onScrollListener2 = listView.getOnScrollListener();
                    if (!(onScrollListener2 instanceof EmoticonPanelOnScrollListener)) {
                        listView.setOnScrollListener(new EmoticonPanelOnScrollListener(listView, emoticonMainPanel, onScrollListener2));
                    }
                }
            }
        }
        relativeLayout = relativeLayout2;
        adapter.setWidthPixels(this.mainPanelWidth);
        adapter.curPanelInfo = this.curItemInfo;
        adapter.setCurrentListView(listView);
        listView.setAdapter((ListAdapter) adapter);
        i16 = emotionPanelInfo.type;
        if (i16 == 6) {
        }
        emoticonPackage = emotionPanelInfo.emotionPkg;
        if (emoticonPackage == null) {
        }
        QLog.e(TAG, 1, "instantiateItem put adapter to map error");
        if (relativeLayout != null) {
        }
        if (listView.getParent() != view2) {
        }
        listView.setTag(emotionPanelInfo);
        asyncGetPanelData(panelType, emotionPanelInfo, adapter, listView);
        if (relativeLayout == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, obj)).booleanValue();
        }
        if (view == obj) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmoticonMainPanel emoticonMainPanel;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else if (this.interactionListener != null && (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) != null) {
            emoticonMainPanel.deleteEmoticonClick();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        List<EmotionPanelInfo> list = this.data;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
        if (this.callback != null) {
            this.callback = null;
        }
        Map<Integer, BaseEmotionAdapter> map = this.otherEmotionAdapters;
        if (map != null) {
            map.clear();
        }
        SparseArray<ImageButton> sparseArray = this.emotionDeleteButtons;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        Map<String, BaseEmotionAdapter> map2 = this.bigEmotionAdapters;
        if (map2 != null) {
            map2.clear();
        }
        EmotionPanelListViewPool.getInstance().destory();
        EmotionPanelViewPool.getInstance().destory();
    }

    public void onDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            this.justDownload.add(str);
        }
    }

    protected void onGetPanelDataResult(final int i3, final EmotionPanelInfo emotionPanelInfo, final BaseEmotionAdapter baseEmotionAdapter, final ListView listView, final List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), emotionPanelInfo, baseEmotionAdapter, listView, list);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            lambda$onGetPanelDataResult$2(i3, emotionPanelInfo, baseEmotionAdapter, listView, list);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.aj
                @Override // java.lang.Runnable
                public final void run() {
                    EmotionPanelViewPagerAdapter.this.lambda$onGetPanelDataResult$2(i3, emotionPanelInfo, baseEmotionAdapter, listView, list);
                }
            });
        }
    }

    public void onPageSelected(EmotionPanelInfo emotionPanelInfo) {
        BaseEmotionAdapter adapterFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) emotionPanelInfo);
            return;
        }
        EmotionPanelInfo emotionPanelInfo2 = this.curItemInfo;
        this.curItemInfo = emotionPanelInfo;
        if (emotionPanelInfo == null) {
            return;
        }
        QLog.d(TAG, 1, "onPageSelected panelType = " + EmotionPanelConstans.getPanelType(this.app, emotionPanelInfo));
        BaseEmotionAdapter adapterFromCache2 = getAdapterFromCache(emotionPanelInfo);
        if (adapterFromCache2 != null) {
            adapterFromCache2.curPanelInfo = this.curItemInfo;
            adapterFromCache2.onAdapterSelected();
        }
        if (emotionPanelInfo2 != null && (adapterFromCache = getAdapterFromCache(emotionPanelInfo2)) != null) {
            adapterFromCache.onAdapterUnselected();
        }
    }

    public void onShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            updateCommonUsedEmotionPanelData();
        }
    }

    public void refreshListViewAdapter(EmotionPanelInfo emotionPanelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) emotionPanelInfo);
            return;
        }
        if (emotionPanelInfo == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            QLog.e(TAG, 1, "refreshListViewAdapter error not in main thread");
            return;
        }
        int panelType = EmotionPanelConstans.getPanelType(this.app, emotionPanelInfo);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshListViewAdapter panelType = " + panelType);
        }
        BaseEmotionAdapter adapterFromCache = getAdapterFromCache(emotionPanelInfo);
        if (adapterFromCache != null) {
            IEmoticonPanelController iEmoticonPanelController = this.panelController;
            if (iEmoticonPanelController != null && (adapterFromCache instanceof FavoriteEmotionAdapter)) {
                ((FavoriteEmotionAdapter) adapterFromCache).setEmotionFilterList(iEmoticonPanelController.getFilterEmotionData(4));
            }
            adapterFromCache.refreshPanelData();
            notifyDataSetChanged();
        }
    }

    protected void removeHeaderAndFooterView(EmotionPanelListView emotionPanelListView) {
        EmoticonMainPanel emoticonMainPanel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) emotionPanelListView);
            return;
        }
        if (emotionPanelListView == null || this.interactionListener == null || (emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener)) == null) {
            return;
        }
        EmoticonPanelHotPicSearchHelper emoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper) emoticonMainPanel.getEmoController().getHelper(6);
        emoticonPanelHotPicSearchHelper.removeHeaderAndFooterView(emotionPanelListView);
        emotionPanelListView.removeOnScrollListener(emoticonPanelHotPicSearchHelper);
        ((EmoticonPanelAIHelper) emoticonMainPanel.getEmoController().getHelper(13)).removeHeaderView(emotionPanelListView);
    }

    public void setData(List<EmotionPanelInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setData justDownload:" + this.justDownload.toString());
        }
        this.data = list;
        notifyDataSetChanged();
        this.justDownload.clear();
    }

    public void setPanelController(IEmoticonPanelController iEmoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iEmoticonPanelController);
        } else {
            this.panelController = iEmoticonPanelController;
        }
    }

    public void setPanelInjectionInfoManager(com.tencent.mobileqq.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar);
        } else {
            this.panelInjectionInfoManager = iVar;
        }
    }

    public void updateCommonUsedEmotionPanelData() {
        BaseEmotionAdapter baseEmotionAdapter;
        EmotionPanelListView currentListView;
        EmotionPanelInfo emotionPanelInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.isFirstShow) {
            this.isFirstShow = false;
        } else if (!this.isOnlySysEmotion && (baseEmotionAdapter = this.otherEmotionAdapters.get(7)) != null && (currentListView = baseEmotionAdapter.getCurrentListView()) != null && (emotionPanelInfo = (EmotionPanelInfo) currentListView.getTag()) != null) {
            asyncGetSystemAndEmojiPanelData(emotionPanelInfo, baseEmotionAdapter);
        }
    }

    private boolean isInFilterList(List<EmotionPanelData> list, IFavoriteEmoticonInfo iFavoriteEmoticonInfo) {
        for (Parcelable parcelable : list) {
            if (parcelable instanceof IFavoriteEmoticonInfo) {
                IFavoriteEmoticonInfo iFavoriteEmoticonInfo2 = (IFavoriteEmoticonInfo) parcelable;
                if (!TextUtils.isEmpty(iFavoriteEmoticonInfo2.getEid())) {
                    if (TextUtils.equals(iFavoriteEmoticonInfo.getEid(), iFavoriteEmoticonInfo2.getEid())) {
                        return true;
                    }
                } else if (iFavoriteEmoticonInfo2.getType() == iFavoriteEmoticonInfo.getType()) {
                    return true;
                }
            }
        }
        return false;
    }
}
