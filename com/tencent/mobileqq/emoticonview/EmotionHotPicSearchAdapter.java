package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportHelper;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.HotPicSearchUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes12.dex */
public class EmotionHotPicSearchAdapter extends BaseEmotionAdapter implements IEmotionHotPicSearchAdapter {
    static IPatchRedirector $redirector_ = null;
    private static final int IMG_HEIGHT_SPACE = 2;
    public static final String REPORT_TAG_0X800AE2D = "0X800AE2D";
    private static final String TAG = "EmotionHotPicSearchAdapter";
    private IEmoticonPanelController mEmoPanelController;
    private EmotionDaTongReportHelper mEmotionDaTongReportHelper;
    private final IPanelInteractionListener mInteractionListener;
    private boolean mIsEmoPanelSearch;
    private boolean mIsRichPanelSearch;
    private final List<Integer> mReportedIndexList;
    private final List<String> mReportedMD5List;
    private final EmoticonReportCallback reportCallback;

    /* loaded from: classes12.dex */
    public static class HotPicSearchEmotionViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        URLImageView[] contentViews;

        public HotPicSearchEmotionViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public EmotionHotPicSearchAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
            return;
        }
        this.mReportedMD5List = new ArrayList();
        this.mReportedIndexList = new ArrayList();
        this.mIsRichPanelSearch = false;
        this.mIsEmoPanelSearch = false;
        this.reportCallback = new EmoticonReportCallback() { // from class: com.tencent.mobileqq.emoticonview.ag
            @Override // com.tencent.mobileqq.emoticonview.EmoticonReportCallback
            public final void report(EmoticonInfo emoticonInfo) {
                EmotionHotPicSearchAdapter.this.lambda$new$0(emoticonInfo);
            }
        };
        this.mInteractionListener = iPanelInteractionListener;
    }

    private void dtBindViewReport(View view, EmotionPanelData emotionPanelData) {
        if (emotionPanelData instanceof HotPicSearchEmoticonInfo) {
            HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionPanelData;
            if (hotPicSearchEmoticonInfo.mSearchItem != null) {
                VideoReport.setPageId(view, EmotionDaTongReportUtil.PG_BAS_HEAT_MAP);
                VideoReport.setElementId(view, EmotionDaTongReportUtil.EM_BAS_EMOTICON_SEARCH_RESULTS);
                HashMap hashMap = new HashMap();
                hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_APP_LOCATION, Integer.valueOf(hotPicSearchEmoticonInfo.mSearchItem.picIndex + 1));
                hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_SFACEID, hotPicSearchEmoticonInfo.mSearchItem.getEmoMd5());
                VideoReport.setElementParams(view, hashMap);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            }
        }
    }

    private URLImageView getHotPicSearchEmoView(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCameraEmoView");
        }
        int i16 = (int) (this.widthPixels - ((this.density * 2.0f) * (this.columnNum - 1)));
        int i17 = this.columnNum;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i16 / i17, i16 / i17);
        if (i3 == 0) {
            layoutParams.rightMargin = (int) (this.density * 1.0f);
            layoutParams.leftMargin = 0;
        } else if (i3 == this.columnNum - 1) {
            layoutParams.leftMargin = (int) (this.density * 1.0f);
            layoutParams.rightMargin = 0;
        } else {
            float f16 = this.density;
            layoutParams.rightMargin = (int) (f16 * 1.0f);
            layoutParams.leftMargin = (int) (f16 * 1.0f);
        }
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        uRLImageView.setAdjustViewBounds(false);
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setContentDescription(this.mContext.getString(R.string.f209295f1));
        return uRLImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(EmoticonInfo emoticonInfo) {
        if (!(emoticonInfo instanceof HotPicSearchEmoticonInfo)) {
            return;
        }
        reportEmotionViewClick(((HotPicSearchEmoticonInfo) emoticonInfo).mSearchItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportExposeEvent$2(int i3, HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo) {
        ReportController.o(this.app.getAppRuntime(), "dc00898", "", "", "0X800C504", "0X800C504", getFromType(this.mEmoPanelController), 0, "2", String.valueOf(i3 + 1), hotPicSearchEmoticonInfo.mSearchItem.getOriginEmoMd5(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportExposeEvent$3(int i3, int i16, HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo) {
        ReportController.o(this.app.getAppRuntime(), "dc00898", "", "", "0X800AE1D", "0X800AE1D", i3, 0, "2", String.valueOf(i16 + 1), hotPicSearchEmoticonInfo.mSearchItem.getOriginEmoMd5(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportExposeEvent$4(int i3, HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo) {
        ReportController.o(this.app.getAppRuntime(), "dc00898", "", "", REPORT_TAG_0X800AE2D, REPORT_TAG_0X800AE2D, 0, 0, "2", String.valueOf(i3 + 1), hotPicSearchEmoticonInfo.mSearchItem.getOriginEmoMd5(), hotPicSearchEmoticonInfo.mSearchWord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportExposeEvent$5(HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo, int i3) {
        ReportController.o(this.app.getAppRuntime(), "dc00898", "", "", "0X800AE35", "0X800AE35", ((IHotPicSearchService) QRoute.api(IHotPicSearchService.class)).getReportFromType(), 0, "2", "", hotPicSearchEmoticonInfo.mSearchItem.getEmoMd5(), String.valueOf(i3 + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateUI$1(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess()) {
            if (option.getAnimatable() instanceof r01.c) {
                ((r01.c) option.getAnimatable()).start();
            }
        } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e(TAG, 1, "loadImage  state:" + loadState + ", listenerOption:" + option);
        }
    }

    private void reportEmotionViewClick(EmotionSearchItem emotionSearchItem) {
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_APP_LOCATION, Integer.valueOf(emotionSearchItem.picIndex + 1));
        hashMap.put(EmotionDaTongReportUtil.EM_PARAMS_SFACEID, emotionSearchItem.getEmoMd5());
        EmotionDaTongReportUtil.INSTANCE.reportElementClick(this.mEmotionDaTongReportHelper, EmotionDaTongReportUtil.EM_BAS_EMOTICON_SEARCH_RESULTS, hashMap);
    }

    private void reportExposeEvent(EmotionPanelData emotionPanelData, final int i3) {
        IEmoticonPanelController iEmoticonPanelController;
        if (emotionPanelData instanceof HotPicSearchEmoticonInfo) {
            final HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionPanelData;
            if (hotPicSearchEmoticonInfo.mSearchItem != null) {
                if (hotPicSearchEmoticonInfo.mPageType == 1 && this.mEmoPanelController != null && this.mIsEmoPanelSearch && !this.mReportedIndexList.contains(Integer.valueOf(i3)) && TextUtils.isEmpty(hotPicSearchEmoticonInfo.mSearchWord)) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ab
                        @Override // java.lang.Runnable
                        public final void run() {
                            EmotionHotPicSearchAdapter.this.lambda$reportExposeEvent$2(i3, hotPicSearchEmoticonInfo);
                        }
                    }, 16, null, false);
                    this.mReportedIndexList.add(Integer.valueOf(i3));
                }
                String emoMd5 = hotPicSearchEmoticonInfo.mSearchItem.getEmoMd5();
                if (this.mReportedMD5List.contains(emoMd5)) {
                    return;
                }
                int i16 = hotPicSearchEmoticonInfo.mPageType;
                if (i16 == 1 && (iEmoticonPanelController = this.mEmoPanelController) != null && this.mIsEmoPanelSearch) {
                    final int fromType = getFromType(iEmoticonPanelController);
                    if (fromType != 0 && TextUtils.isEmpty(hotPicSearchEmoticonInfo.mSearchWord)) {
                        this.mReportedMD5List.add(emoMd5);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ac
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmotionHotPicSearchAdapter.this.lambda$reportExposeEvent$3(fromType, i3, hotPicSearchEmoticonInfo);
                            }
                        }, 16, null, false);
                        return;
                    } else {
                        if (!TextUtils.isEmpty(hotPicSearchEmoticonInfo.mSearchWord)) {
                            this.mReportedMD5List.add(emoMd5);
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ad
                                @Override // java.lang.Runnable
                                public final void run() {
                                    EmotionHotPicSearchAdapter.this.lambda$reportExposeEvent$4(i3, hotPicSearchEmoticonInfo);
                                }
                            }, 16, null, false);
                            return;
                        }
                        return;
                    }
                }
                if (i16 == 2 && this.mIsRichPanelSearch) {
                    this.mReportedMD5List.add(emoMd5);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.ae
                        @Override // java.lang.Runnable
                        public final void run() {
                            EmotionHotPicSearchAdapter.this.lambda$reportExposeEvent$5(hotPicSearchEmoticonInfo, i3);
                        }
                    }, 16, null, false);
                }
            }
        }
    }

    private void updateUI(View view, EmotionPanelData emotionPanelData, int i3) {
        if (view != null && (emotionPanelData instanceof EmoticonInfo)) {
            URLImageView uRLImageView = (URLImageView) view;
            EmoticonInfo emoticonInfo = (EmoticonInfo) emotionPanelData;
            view.setTag(emoticonInfo);
            view.setVisibility(0);
            view.setAlpha(1.0f);
            if (QLog.isColorLevel() && !StringUtil.isEmpty(emoticonInfo.action)) {
                QLog.d(TAG, 2, "updateUI info = " + emoticonInfo.action);
            }
            if (view.getTag(R.id.kxb) == emotionPanelData) {
                return;
            }
            reportExposeEvent(emotionPanelData, i3);
            dtBindViewReport(view, emotionPanelData);
            view.setTag(R.id.kxb, emotionPanelData);
            view.setVisibility(0);
            uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (HotPicSearchUtils.f306386a.a()) {
                Option option = emoticonInfo.getOption();
                if (option != null) {
                    option.setTargetView(uRLImageView);
                    QQEmoticonPicLoader.f356316a.b().loadImage(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emoticonview.af
                        @Override // com.tencent.libra.listener.IPicLoadStateListener
                        public final void onStateChange(LoadState loadState, Option option2) {
                            EmotionHotPicSearchAdapter.lambda$updateUI$1(loadState, option2);
                        }
                    });
                    return;
                }
                uRLImageView.setImageDrawable(null);
                QLog.e(TAG, 1, "updateUI can not get option, emotionInfo:" + emoticonInfo);
                return;
            }
            uRLImageView.setImageDrawable(emoticonInfo.getBigDrawable(this.mContext, this.density));
            return;
        }
        QLog.e(TAG, 1, "emotionInfo or contentView = null");
    }

    public void clearReportedMD5List() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mReportedMD5List.clear();
            this.mReportedIndexList.clear();
        }
    }

    public List<EmotionPanelData> getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup, com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout] */
    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        HotPicSearchEmotionViewHolder hotPicSearchEmotionViewHolder = (HotPicSearchEmotionViewHolder) viewHolder;
        View view2 = view;
        if (view == null) {
            EmoticonPanelLinearLayout view3 = EmotionPanelViewPool.getInstance().getView(this.panelType);
            if (view3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + "; view from inflater");
                }
                view3 = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.mInteractionListener), -1);
                view3.setPanelType(6);
                view3.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                view3.setOrientation(0);
                view3.setPadding(0, (int) (this.density * 2.0f), 0, 0);
                for (int i17 = 0; i17 < this.columnNum; i17++) {
                    URLImageView hotPicSearchEmoView = getHotPicSearchEmoView(i17);
                    hotPicSearchEmoView.setVisibility(8);
                    hotPicSearchEmoView.setFocusable(true);
                    hotPicSearchEmoView.setFocusableInTouchMode(true);
                    view3.addView(hotPicSearchEmoView);
                }
            }
            EmoticonPanelLinearLayout emoticonPanelLinearLayout = view3;
            emoticonPanelLinearLayout.setCallBack(this.callback);
            emoticonPanelLinearLayout.setReportCallBack(this.reportCallback);
            recycleView(this.panelType, view3);
            ViewGroup viewGroup2 = view3;
            hotPicSearchEmotionViewHolder.contentViews = new URLImageView[this.columnNum];
            for (int i18 = 0; i18 < this.columnNum; i18++) {
                hotPicSearchEmotionViewHolder.contentViews[i18] = (URLImageView) viewGroup2.getChildAt(i18);
            }
            view3.setTag(hotPicSearchEmotionViewHolder);
            view2 = view3;
        }
        while (true) {
            int i19 = this.columnNum;
            if (i16 < i19) {
                int i26 = (i19 * i3) + i16;
                if (i26 > this.data.size() - 1) {
                    hotPicSearchEmotionViewHolder.contentViews[i16].setTag(null);
                    hotPicSearchEmotionViewHolder.contentViews[i16].setVisibility(8);
                } else {
                    updateUI(hotPicSearchEmotionViewHolder.contentViews[i16], this.data.get(i26), i26);
                }
                i16++;
            } else {
                return view2;
            }
        }
    }

    protected int getFromType(IEmoticonPanelController iEmoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) iEmoticonPanelController)).intValue();
        }
        if (iEmoticonPanelController instanceof EmoticonPanelController) {
            return ((EmoticonPanelMallHelper) iEmoticonPanelController.getHelper(4)).getFromType();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter
    public int getWidthPixels() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.widthPixels;
    }

    protected boolean isEmoPanelSearch(IEmoticonPanelController iEmoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) iEmoticonPanelController)).booleanValue();
        }
        if (!(iEmoticonPanelController instanceof EmoticonPanelController) || ((EmoticonPanelController) iEmoticonPanelController).findIndexByPanelType(12) != BasePanelModel.sLastSelectedSecondTabIndex) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return new HotPicSearchEmotionViewHolder();
    }

    public void reportDefaultExposeEvent(int i3, int i16, int i17) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo;
        EmotionSearchItem emotionSearchItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        List<EmotionPanelData> list = this.data;
        if (list != null && !list.isEmpty() && i3 >= 0) {
            int max = Math.max(i3 - i17, 0) * 4;
            int i18 = i16 * 4;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "reportDefaultExposeEvent lastVisiblePosition: " + i18 + " firstVisiblePosition: " + max);
            }
            while (max < i18 && max < this.data.size()) {
                EmotionPanelData emotionPanelData = this.data.get(max);
                if ((emotionPanelData instanceof HotPicSearchEmoticonInfo) && (emotionSearchItem = (hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionPanelData).mSearchItem) != null) {
                    if (this.mReportedMD5List.contains(emotionSearchItem.getEmoMd5())) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 4, "emoMd5 contains ");
                        }
                    } else {
                        int i19 = hotPicSearchEmoticonInfo.mPageType;
                        if (i19 == 2) {
                            this.mIsRichPanelSearch = true;
                        } else if (i19 == 1) {
                            this.mIsEmoPanelSearch = true;
                        }
                        reportExposeEvent(emotionPanelData, max);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "searchItem is null ");
                }
                max++;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "reportDefaultExposeEvent data is null");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter
    public void setData(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            updateSearchEnable(list);
            super.setData(list);
        }
    }

    public void setEmoPanelController(IEmoticonPanelController iEmoticonPanelController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iEmoticonPanelController);
        } else {
            this.mEmoPanelController = iEmoticonPanelController;
        }
    }

    public void setEmotionDaTongReportHelper(EmotionDaTongReportHelper emotionDaTongReportHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emotionDaTongReportHelper);
        } else {
            this.mEmotionDaTongReportHelper = emotionDaTongReportHelper;
        }
    }

    public void updateSearchEnable(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        this.mIsRichPanelSearch = false;
        this.mIsEmoPanelSearch = false;
        if (list != null && !list.isEmpty()) {
            EmotionPanelData emotionPanelData = list.get(0);
            if (emotionPanelData instanceof HotPicSearchEmoticonInfo) {
                HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emotionPanelData;
                if (hotPicSearchEmoticonInfo.mSearchItem != null) {
                    int i3 = hotPicSearchEmoticonInfo.mPageType;
                    if (i3 == 2) {
                        if (((IHotPicSearchService) QRoute.api(IHotPicSearchService.class)).isRichTextLastTab(this.app.getApplication(), this.app.getCurrentAccountUin())) {
                            this.mIsRichPanelSearch = true;
                        }
                    } else if (i3 == 1 && isEmoPanelSearch(this.mEmoPanelController)) {
                        this.mIsEmoPanelSearch = true;
                    }
                }
            }
        }
    }
}
