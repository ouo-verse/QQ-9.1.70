package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonReportDtHelper extends AbstractEmoticonPanelHelper<EmoticonPanelController> {
    static IPatchRedirector $redirector_ = null;
    public static final int FROM_AUTO = 2;
    public static final int FROM_CLICK = 0;
    public static final int FROM_SCROLL = 1;
    public static final int POST_TIME_AUTO = 102;
    public static final int POST_TIME_PAGE_SELECTED = 101;
    private static final String TAG = "EmoticonDtReportHelper";
    boolean mAutoOpenPage;
    private int mBusinessType;
    protected int mFromType;
    boolean mNeedIntercept;
    boolean mOnItemClicked;
    private String mPreviousPanelName;
    private int mPreviousPanelType;

    public EmoticonReportDtHelper(EmoticonPanelController emoticonPanelController) {
        super(emoticonPanelController);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) emoticonPanelController);
            return;
        }
        this.mFromType = 3;
        this.mBusinessType = -1;
        this.mPreviousPanelType = -1;
        this.mPreviousPanelName = "";
        this.mOnItemClicked = false;
        this.mAutoOpenPage = false;
        this.mNeedIntercept = false;
    }

    public static void bindAlbumEmotionView(View view, PicEmoticonInfo picEmoticonInfo, int i3, int i16) {
        if (view != null && i3 >= 0 && picEmoticonInfo != null && i16 >= 0) {
            VideoReport.setElementId(view, EmotionReportDtImpl.EM_AIO_ALBUM_STICKERS);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementReuseIdentifier(view, EmotionReportDtImpl.EM_AIO_ALBUM_STICKERS + picEmoticonInfo.emoticon.eId);
            HashMap hashMap = new HashMap();
            hashMap.put(EmotionReportDtImpl.ORDER_IN_ALBUM_STICKERS, String.valueOf(i3));
            hashMap.put(EmotionReportDtImpl.ID_STICKERS_A_SET, picEmoticonInfo.emoticon.eId);
            hashMap.put(EmotionReportDtImpl.ORDER_TAB_IN_STICKERS_PANEL, String.valueOf(i16));
            VideoReport.setElementParams(view, hashMap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(EmotionReportDtImpl.LOG_TAG, 2, "bindAlbumEmotionView, input params error, emotionOrder:" + i3 + ", tabIdx:" + i16);
        }
    }

    public static void bindFavoriteEmotionView(View view, int i3) {
        if (view != null && i3 >= 2) {
            VideoReport.setElementId(view, EmotionReportDtImpl.EM_AIO_FAVORITES_STICKERS);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put(EmotionReportDtImpl.ORDER_IN_FAVORITES_STICKERS, String.valueOf(i3 - 2));
            VideoReport.setElementParams(view, hashMap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(EmotionReportDtImpl.LOG_TAG, 2, "bindFavoriteEmotionView, input params error, emotionOrder:" + i3);
        }
    }

    public static void bindStickersRecommendBar(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, EmotionReportDtImpl.EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            HashMap hashMap = new HashMap();
            hashMap.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, str);
            VideoReport.setElementParams(view, hashMap);
            if (QLog.isColorLevel()) {
                QLog.i(EmotionReportDtImpl.LOG_TAG, 2, "bindStickersRecommendBar params:" + hashMap.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(EmotionReportDtImpl.LOG_TAG, 2, "bindStickersRecommendBar, input params empty");
        }
    }

    private String convertEmoticonTabItem(EmotionPanelInfo emotionPanelInfo) {
        EmoticonTabAdapter.EmoticonTabItem emoticonTabItem = new EmoticonTabAdapter.EmoticonTabItem();
        int i3 = emotionPanelInfo.type;
        emoticonTabItem.type = i3;
        if (i3 == 8) {
            return HardCodeUtil.qqStr(R.string.m6w);
        }
        if (i3 == 9) {
            return HardCodeUtil.qqStr(R.string.m6y);
        }
        if (i3 == 4) {
            return HardCodeUtil.qqStr(R.string.m7j);
        }
        if (i3 == 7) {
            return HardCodeUtil.qqStr(R.string.m7i);
        }
        if (i3 != 6 && i3 != 10) {
            if (i3 == 11) {
                return HardCodeUtil.qqStr(R.string.m6k);
            }
            if (i3 == 13) {
                return HardCodeUtil.qqStr(R.string.axk);
            }
            if (i3 == 14) {
                return HardCodeUtil.qqStr(R.string.axl);
            }
            if (i3 == 12) {
                return HardCodeUtil.qqStr(R.string.yqa);
            }
            if (i3 == 17) {
                return HardCodeUtil.qqStr(R.string.f170542u0);
            }
            if (i3 == 18) {
                return HardCodeUtil.qqStr(R.string.f170218yq3);
            }
            if (i3 == 20) {
                return HardCodeUtil.qqStr(R.string.yqe);
            }
        } else {
            EmoticonPackage emoticonPackage = emotionPanelInfo.emotionPkg;
            if (emoticonPackage != null) {
                String str = emoticonPackage.name + HardCodeUtil.qqStr(R.string.f171947m82);
                if (emoticonPackage.status != 2) {
                    return str + HardCodeUtil.qqStr(R.string.f171948m84);
                }
                return str;
            }
        }
        return "";
    }

    private void reportQQImpEnd() {
        if (this.mPreviousPanelType != -1 && !this.mPreviousPanelName.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put(EmotionReportDtImpl.CURRENT_TAB, this.mPreviousPanelName);
            com.tencent.mobileqq.aio.utils.b.t(EmotionReportDtImpl.EM_NT_AIO_EMO_PANEL, hashMap);
        }
    }

    private void updateFromType(int i3) {
        this.mFromType = i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateFromType == " + i3);
        }
    }

    private void updateItemClick(boolean z16) {
        this.mOnItemClicked = z16;
    }

    protected void addDTReport(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) this.mPanelController).getPanelDataList();
        if (panelDataList != null && panelDataList.size() > i3) {
            EmotionPanelInfo emotionPanelInfo = panelDataList.get(i3);
            String convertEmoticonTabItem = convertEmoticonTabItem(emotionPanelInfo);
            if (((EmoticonPanelController) this.mPanelController).getPageAdapter().getAdapterFromCache(emotionPanelInfo) == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "Error!!! adapter is null!!! when post time = " + i16);
                    return;
                }
                return;
            }
            int i17 = emotionPanelInfo.type;
            reportQQImpEnd();
            HashMap hashMap = new HashMap();
            hashMap.put(EmotionReportDtImpl.CURRENT_TAB, convertEmoticonTabItem);
            com.tencent.mobileqq.aio.utils.b.q(EmotionReportDtImpl.EM_NT_AIO_EMO_PANEL, hashMap);
            this.mPreviousPanelType = i17;
            this.mPreviousPanelName = convertEmoticonTabItem;
            return;
        }
        QLog.d(TAG, 1, "panelDataList Error when = " + i16 + ", position = " + i3);
    }

    public boolean getEmotionNeedRed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        BaseQQAppInterface qQAppInterface = ((EmoticonPanelController) this.mPanelController).app.getQQAppInterface();
        if (qQAppInterface == null) {
            return false;
        }
        return ((ICameraEmoRoamingManagerService) qQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class, "")).getIsNeedShowGuide();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void initBefore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.initBefore();
        setBusinessType(((EmoticonPanelController) this.mPanelController).getBasePanelModel().businessType);
        setNeedIntercept(true);
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{3, 5, 13, 1, 4};
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onHide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        super.onHide(z16);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "OnHide");
        }
        reportQQImpEnd();
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onItemTabClick(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        List<EmotionPanelInfo> panelDataList = ((EmoticonPanelController) this.mPanelController).getPanelDataList();
        if (panelDataList != null && i3 < panelDataList.size()) {
            updateItemClick(true);
            this.mAutoOpenPage = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (((EmoticonPanelController) this.mPanelController).getPanelDataList() != null && i3 < ((EmoticonPanelController) this.mPanelController).getPanelDataList().size()) {
            if (this.mBusinessType != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "mBusinessType not AIO, it is " + this.mBusinessType);
                    return;
                }
                return;
            }
            if (this.mNeedIntercept && this.mAutoOpenPage) {
                setNeedIntercept(false);
                return;
            }
            setNeedIntercept(false);
            if (this.mAutoOpenPage) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "OnPageSelected mAutoPage = true So I return");
                }
                this.mAutoOpenPage = false;
                return;
            } else {
                if (this.mOnItemClicked) {
                    updateFromType(0);
                } else {
                    updateFromType(1);
                }
                updateItemClick(false);
                this.mAutoOpenPage = false;
                viewPostReport(i3, 101);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "mPanelController.panelDataList is null or position error ");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.AbstractEmoticonPanelHelper
    public void onShow() {
        EmoticonPanelHotPicSearchHelper emoticonPanelHotPicSearchHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onShow();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "OnShow");
        }
        setPanelDTParams();
        this.mAutoOpenPage = false;
        T t16 = this.mPanelController;
        if (t16 != 0 && ((EmoticonPanelController) t16).getPageAdapter() != null && ((EmoticonPanelController) this.mPanelController).getPageAdapter().curItemInfo != null) {
            EmotionPanelInfo emotionPanelInfo = ((EmoticonPanelController) this.mPanelController).getPageAdapter().curItemInfo;
            EmoticonPanelMallHelper emoticonPanelMallHelper = (EmoticonPanelMallHelper) ((EmoticonPanelController) this.mPanelController).getHelper(4);
            if (emoticonPanelMallHelper != null) {
                emoticonPanelMallHelper.reportPageEvent(emotionPanelInfo, false);
            }
            if (emotionPanelInfo.type == 12 && (emoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper) ((EmoticonPanelController) this.mPanelController).getHelper(6)) != null) {
                emoticonPanelHotPicSearchHelper.reportItemExposed();
            }
        }
    }

    protected void setBusinessType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mBusinessType = i3;
        }
    }

    protected void setNeedIntercept(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mNeedIntercept = z16;
        }
    }

    void setPanelDTParams() {
        IPanelInteractionListener hostInterface;
        EmoticonMainPanel panel = ((EmoticonPanelController) this.mPanelController).getPanel();
        if (panel != null && (hostInterface = ((EmoticonPanelController) this.mPanelController).getHostInterface()) != null) {
            if (hostInterface.getCurType() == 0) {
                VideoReport.setElementParam(panel, EmotionReportDtImpl.IS_RED_TIPS_BEFORE, 0);
            } else {
                VideoReport.setElementParam(panel, EmotionReportDtImpl.IS_RED_TIPS_BEFORE, Integer.valueOf(getEmotionNeedRed() ? 1 : 0));
            }
        }
    }

    public void updateAutoPaged(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.mAutoOpenPage = z16;
        updateFromType(2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateAutoPaged position == " + i3 + " isAuto == " + z16);
        }
        viewPostReport(i3, 102);
    }

    protected void viewPostReport(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (((EmoticonPanelController) this.mPanelController).getPageAdapter() != null) {
            EmoticonMainPanel panel = ((EmoticonPanelController) this.mPanelController).getPanel();
            if (panel != null) {
                panel.post(new Runnable(i3, i16) { // from class: com.tencent.mobileqq.emoticonview.EmoticonReportDtHelper.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$pos;
                    final /* synthetic */ int val$when;

                    {
                        this.val$pos = i3;
                        this.val$when = i16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, EmoticonReportDtHelper.this, Integer.valueOf(i3), Integer.valueOf(i16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            EmoticonReportDtHelper.this.addDTReport(this.val$pos, this.val$when);
                        }
                    }
                });
                return;
            }
            QLog.d(TAG, 2, "viewPostReport panel == null!!!when time == " + i16);
            return;
        }
        QLog.d(TAG, 2, "viewPostReport mPanelController.pageAdapter == null!!!when time == " + i16);
    }
}
