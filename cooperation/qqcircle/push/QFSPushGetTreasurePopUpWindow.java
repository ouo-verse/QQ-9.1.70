package cooperation.qqcircle.push;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxInfo;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxResultBean;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QFSPushPopWindowImgConst;
import feedcloud.FeedCloudWrite$PushBoxDrawGiftResult;
import feedcloud.FeedCloudWrite$PushShowOffBtn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes28.dex */
public class QFSPushGetTreasurePopUpWindow extends PopupWindow implements View.OnClickListener, SimpleEventReceiver {
    private static final float ANIMATE_HEIGHT_WIDTH_RATIO = 1.68f;
    private static final int ANIMATION_DOWNLOAD_TIME_OUT = 1000;
    private static final int ANIMATION_FRAME_DURATION = 25;
    private static final int AVATAR_DESC_IMG_HEIGHT = 26;
    private static final int AVATAR_DESC_IMG_WIDTH = 106;
    private static final int AVATAR_IMG_SIZE_IN_BANNER = 68;
    private static final int AVATAR_IMG_SIZE_IN_SINGLE = 94;
    private static final int AVATAR_MARGIN_IN_BANNER = 4;
    private static final int AVATAR_MARGIN_IN_SINGLE = 6;
    private static final int BANNER_BG_HEIGHT = 349;
    private static final int BANNER_BG_WIDTH = 276;
    private static final int BANNER_TAG_HEIGHT = 20;
    private static final int BANNER_TAG_WIDTH = 50;
    private static final int BANNER_TYPE = 0;
    private static final int CARD_DECO_HEIGHT = 34;
    private static final int CARD_DECO_WIDTH = 26;
    private static final int DATA_VIEW_BG_HEIGHT = 456;
    private static final int DATA_VIEW_BG_WIDTH = 300;
    private static final int DETAIL_DECO_HEIGHT = 6;
    private static final int DETAIL_DECO_WIDTH = 24;
    private static final int DETAIL_LAYOUT_MARGIN_BOTTOM_IN_BANNER = 10;
    private static final int DETAIL_LAYOUT_MARGIN_BOTTOM_IN_SINGLE = 8;
    private static final int DETAIL_LAYOUT_MARGIN_TOP_IN_BANNER = 6;
    private static final int DISMISS_DELAY = 200;
    private static final int DURATION_120 = 120;
    private static final int DURATION_160 = 160;
    private static final int DURATION_200 = 200;
    private static final int HIGH_RATE_RESULT = 10;
    private static final int INVALID_GIFT_RESULT = -1;
    private static final int NATIVE_ANIMATION_START_FRAME = 27;
    private static final int RESULT_VIEW_INIT_MARGIN_TOP = -300;
    private static final int RESULT_VIEW_UP_ANIMATION_DISTANCE = 16;
    private static final int SHOW_OFF_BTN_HEIGHT = 42;
    private static final int SHOW_OFF_BTN_WIDTH = 250;
    private static final int SINGLE_DETAIL_BG_SIZE = 104;
    private static final int SINGLE_TREASURE_TYPE = 1;
    public static final String TAG = "QFSPushGetTreasurePopUpWindow";
    private static final int TITLE_IMG_HEIGHT = 106;
    private static final int TITLE_IMG_WIDTH = 340;
    private static Map<String, Integer> sSourceMap;
    private FeedCloudWrite$PushShowOffBtn mBtnInfo;
    private ImageView mCloseBtn;
    private FrameLayout mContainerLayout;
    private Context mContext;
    private FrameLayout mDataView;
    private String mDetailUrl;
    private FeedCloudWrite$PushBoxDrawGiftResult mGiftResult;
    private int mGiftType;
    private boolean mHasShowNativeImg;
    private View.OnClickListener mHookClickListener;
    private boolean mIsDownloadAnimationOutTime;
    private boolean mIsSingleTreasure;
    private Button mJumpDetailBtn;
    private QQAnimationDrawable mOpenBoxAnimationDrawable;
    private Runnable mOpenBoxRunnable;
    private int mOpenNormalBoxNum;
    private int mOpenSuperBoxNum;
    private Runnable mOutTimeRunnable;
    private LinearLayout mResultView;
    private AnimatorSet mResultViewAnimatorSet;
    private TextView mRocketCntTitle;
    private View mRootView;
    private ImageView mShowOffBtn;
    private String mSource;
    private ImageView mTreasureAnimateImg;
    private RecyclerView mTreasureRecycler;
    private final List<QFSPushOpenBoxResultBean> mTreasureResultList;

    static {
        HashMap hashMap = new HashMap();
        sSourceMap = hashMap;
        hashMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_BOX_PENDANT, 1);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_PUSH_BUTTON_EXPAND_BOX, 2);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_BOX_BUTTON, 3);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_PAGE_OPEN_BOX_BUTTON, 4);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_PAGE_BOX_BUTTON, 5);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_PAGE_OPENALL_BUTTON, 6);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BOX_RESULT_SHARE_BUTTON, 7);
        sSourceMap.put(QCircleDaTongConstant.ElementId.EM_XSJ_ROCKET_RESULT_PAGE_SOURCE_OTHER, 8);
    }

    public QFSPushGetTreasurePopUpWindow(Context context, QFSPushOpenBoxInfo qFSPushOpenBoxInfo) {
        this(context, qFSPushOpenBoxInfo, null);
    }

    private void abnormalClickDtReport(String str, View view, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (map != null) {
            buildElementParams.putAll(map);
        }
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
    }

    private void abnormalImpDtReport(String str, View view, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        if (map != null) {
            buildElementParams.putAll(map);
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustViewLocation() {
        int screenWidth = ImmersiveUtils.getScreenWidth();
        int i3 = (int) (screenWidth * ANIMATE_HEIGHT_WIDTH_RATIO);
        int pxToDp = (ImmersiveUtils.pxToDp(ImmersiveUtils.getScreenWidth()) * 92) / QidPagView.DESIGN_PAG_WIDTH;
        ImageView imageView = this.mTreasureAnimateImg;
        if (imageView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = screenWidth;
        layoutParams.height = i3;
        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(pxToDp);
        this.mTreasureAnimateImg.setLayoutParams(layoutParams);
    }

    private void countBoxNum(int i3) {
        if (i3 == 2) {
            this.mOpenSuperBoxNum++;
        } else if (i3 == 1) {
            this.mOpenNormalBoxNum++;
        }
    }

    private String getAnimateUrl() {
        if (this.mTreasureResultList.isEmpty()) {
            return "";
        }
        if (this.mTreasureResultList.size() == 1 && this.mTreasureResultList.get(0).getTreasureType() == 1) {
            return QFSPushPopWindowImgConst.AnimationURL.QVIDEO_ROCKET_KAIXIANG_3_SEQ;
        }
        return QFSPushPopWindowImgConst.AnimationURL.QVIDEO_ROCKET_KAIXIANG_2_SEQ;
    }

    private String getMultiTreasureMultipleImgUrl(float f16) {
        if (f16 == 10.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_10_V3;
        }
        if (f16 == 100.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_100_V3;
        }
        return "";
    }

    private String getMultipleImgUrl(float f16, int i3) {
        if (i3 == 0) {
            return getMultiTreasureMultipleImgUrl(f16);
        }
        if (f16 == 2.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_2;
        }
        if (f16 == 3.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_3;
        }
        if (f16 == 5.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_5;
        }
        if (f16 == 10.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_10;
        }
        if (f16 == 100.0f) {
            return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_100;
        }
        return QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_05;
    }

    private AnimationDrawableFactory.CreateResultListener getOpenBoxAnimListener() {
        return new AnimationDrawableFactory.CreateResultListener() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.4
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
                QFSPushGetTreasurePopUpWindow.this.removeDownloadAnimationTimingTask();
                if (QFSPushGetTreasurePopUpWindow.this.mIsDownloadAnimationOutTime) {
                    QLog.d(QFSPushGetTreasurePopUpWindow.TAG, 1, "Open Box Animation download out of time!");
                    return;
                }
                if (!z16) {
                    QLog.d(QFSPushGetTreasurePopUpWindow.TAG, 1, "Open Box Animation downloaded fail, show static image!");
                    QFSPushGetTreasurePopUpWindow.this.showOpenBoxStaticImg();
                } else {
                    QLog.d(QFSPushGetTreasurePopUpWindow.TAG, 1, "Open Box Animation has downloaded!");
                    qQAnimationDrawable.setOneShot(true);
                    QFSPushGetTreasurePopUpWindow.this.mOpenBoxAnimationDrawable = qQAnimationDrawable;
                    QFSPushGetTreasurePopUpWindow.this.playOpenBoxAnimation();
                }
            }
        };
    }

    private float getRewardForReport() {
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult == null) {
            return -1.0f;
        }
        if (feedCloudWrite$PushBoxDrawGiftResult.gift_type.get() == 3) {
            return 0.0f;
        }
        return this.mGiftResult.rate.get();
    }

    private int getRocketCntFromList() {
        int i3 = 0;
        if (this.mTreasureResultList.size() == 0) {
            return 0;
        }
        Iterator<QFSPushOpenBoxResultBean> it = this.mTreasureResultList.iterator();
        while (it.hasNext()) {
            i3 = (int) (i3 + it.next().getRocketCount());
        }
        return i3;
    }

    private SpannableStringBuilder getRocketCountTitle() {
        int rocketCntFromList;
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult != null && feedCloudWrite$PushBoxDrawGiftResult.total_rocket.get() != 0) {
            rocketCntFromList = this.mGiftResult.total_rocket.get();
            QLog.d(TAG, 1, "rocket count from gift result.");
        } else {
            rocketCntFromList = getRocketCntFromList();
            QLog.d(TAG, 1, "no gift result, count rocket native.");
        }
        String valueOf = String.valueOf(rocketCntFromList);
        String string = this.mContext.getString(R.string.f194264bf, Integer.valueOf(rocketCntFromList));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(valueOf);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.clh)), indexOf, valueOf.length() + indexOf, 34);
        return spannableStringBuilder;
    }

    private float getSingleTreasureMultiple() {
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult != null && feedCloudWrite$PushBoxDrawGiftResult.rate.get() != 0.0f) {
            return this.mGiftResult.rate.get();
        }
        if (this.mTreasureResultList.size() == 0) {
            return 0.0f;
        }
        return this.mTreasureResultList.get(0).getTreasureMultiple();
    }

    private void handleSelectTabEvent(QCircleSelectTabEvent qCircleSelectTabEvent) {
        View view;
        if (qCircleSelectTabEvent.tabType == 1 && (view = this.mRootView) != null) {
            view.postDelayed(new Runnable() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.7
                @Override // java.lang.Runnable
                public void run() {
                    QFSPushGetTreasurePopUpWindow.this.dismiss();
                }
            }, 200L);
        }
    }

    private void handleTabStatusChangedEvent(ASEngineTabStatusEvent aSEngineTabStatusEvent) {
        if (aSEngineTabStatusEvent.getBusinessKey().equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && !aSEngineTabStatusEvent.isSelected()) {
            dismiss();
        }
    }

    private boolean ifGetHighResult() {
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult == null) {
            return false;
        }
        if (this.mGiftType != 2 && feedCloudWrite$PushBoxDrawGiftResult.rate.get() < 10.0f) {
            return false;
        }
        return true;
    }

    private void initAvatarDecorateLayout(View view, int i3, int i16) {
        ViewStub viewStub;
        int i17;
        int i18;
        int i19;
        float f16;
        if (view == null || this.mGiftResult == null || (viewStub = (ViewStub) view.findViewById(i3)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        TextView textView = (TextView) inflate.findViewById(R.id.f5071265);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f5069263);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f5067261);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f5068262);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f5070264);
        imageView2.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        int i26 = 8;
        if (i16 == 0) {
            i17 = 8;
        } else {
            i17 = 0;
        }
        textView.setVisibility(i17);
        if (i16 == 0) {
            i18 = 8;
        } else {
            i18 = 0;
        }
        imageView2.setVisibility(i18);
        if (i16 == 0) {
            i26 = 0;
        }
        linearLayout.setVisibility(i26);
        if (i16 == 0) {
            i19 = 68;
        } else {
            i19 = 94;
        }
        if (i16 == 0) {
            f16 = 4.0f;
        } else {
            f16 = 6.0f;
        }
        int dip2px = ViewUtils.dip2px(f16);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        float f17 = i19;
        layoutParams.width = ViewUtils.dip2px(f17);
        layoutParams.height = ViewUtils.dip2px(f17);
        layoutParams.topMargin = dip2px;
        layoutParams.bottomMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        layoutParams.rightMargin = dip2px;
        imageView.setLayoutParams(layoutParams);
        textView.setText(this.mGiftResult.congratulation_words.get());
        textView2.setText(this.mGiftResult.setting_btn_text.get());
        setStaticImg(this.mGiftResult.img_url.get(), i19, i19, imageView);
        if (imageView2.getVisibility() == 0) {
            setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_AVATAR, 106, 26, imageView2);
        }
    }

    private void initBannerView(View view) {
        int i3;
        ViewStub viewStub;
        if (this.mGiftResult == null || (i3 = this.mGiftType) == 0 || i3 == 1 || (viewStub = (ViewStub) view.findViewById(R.id.f506025u)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f5073267);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f509026n);
        setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_BANNER_BG, 276, BANNER_BG_HEIGHT, imageView);
        setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_TAG_BG, 50, 20, imageView2);
        int i16 = this.mGiftType;
        if (i16 == 3) {
            initAvatarDecorateLayout(inflate, R.id.f5072266, 0);
            imageView2.setVisibility(0);
        } else if (i16 == 2) {
            initDetailLayout(inflate, R.id.f5074268, 0);
            imageView2.setVisibility(8);
        }
    }

    private void initDataViewImg(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f508826l);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f508926m);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.f507626_);
        setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_BG, 300, 456, imageView);
        setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_TITLE_BG, TITLE_IMG_WIDTH, 106, imageView2);
        setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_CARD_DECO, 26, 34, imageView3);
    }

    private void initDetailLayout(View view, int i3, int i16) {
        ViewStub viewStub;
        int i17;
        String str;
        int i18;
        String str2;
        if (view == null || (viewStub = (ViewStub) view.findViewById(i3)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f508226f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int i19 = 8;
        if (i16 == 0) {
            i17 = 6;
        } else {
            i17 = 8;
        }
        layoutParams.topMargin = i17;
        if (i16 == 0) {
            i19 = 10;
        }
        layoutParams.bottomMargin = i19;
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.f508426h);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f508126e);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f508326g);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f507926c);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.f508026d);
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        String str3 = "";
        if (feedCloudWrite$PushBoxDrawGiftResult == null) {
            str = "";
        } else {
            str = feedCloudWrite$PushBoxDrawGiftResult.congratulation_words.get();
        }
        textView.setText(str);
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult2 = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult2 != null) {
            str3 = feedCloudWrite$PushBoxDrawGiftResult2.sub_title.get();
        }
        textView2.setText(str3);
        Resources resources = this.mContext.getResources();
        int i26 = R.color.f158017al3;
        if (i16 == 0) {
            i18 = R.color.f158017al3;
        } else {
            i18 = R.color.cmc;
        }
        textView.setTextColor(resources.getColor(i18));
        Resources resources2 = this.mContext.getResources();
        if (i16 != 0) {
            i26 = R.color.cmd;
        }
        textView2.setTextColor(resources2.getColor(i26));
        setStaticImg(getMultipleImgUrl(getSingleTreasureMultiple(), i16), 100, 100, imageView);
        String str4 = QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_DECO;
        if (i16 == 0) {
            str2 = QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DUOKAI_DECO;
        } else {
            str2 = QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_TEXT_DECO;
        }
        setStaticImg(str2, 24, 6, imageView2);
        if (i16 != 0) {
            str4 = QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_TEXT_DECO;
        }
        setStaticImg(str4, 24, 6, imageView3);
    }

    private void initMultiTreasureView(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f505825s);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.mRocketCntTitle = (TextView) inflate.findViewById(R.id.f505725r);
        this.mTreasureRecycler = (RecyclerView) inflate.findViewById(R.id.f505425o);
        this.mRocketCntTitle.setText(getRocketCountTitle());
        RFWTypefaceUtil.setNumberTypeface(this.mRocketCntTitle, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8893/rocket/FZRuiZhengHeiS-EB-GB.ttf");
        initTreasureRecycler();
    }

    private void initPopupWindow() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.gpf, (ViewGroup) null, false);
        this.mContainerLayout = (FrameLayout) inflate.findViewById(R.id.f508726k);
        this.mTreasureAnimateImg = (ImageView) inflate.findViewById(R.id.f508526i);
        this.mResultView = (LinearLayout) inflate.findViewById(R.id.f5066260);
        this.mDataView = (FrameLayout) inflate.findViewById(R.id.f506225w);
        this.mJumpDetailBtn = (Button) inflate.findViewById(R.id.f508626j);
        this.mCloseBtn = (ImageView) inflate.findViewById(R.id.f507726a);
        this.mShowOffBtn = (ImageView) inflate.findViewById(R.id.f507826b);
        this.mResultView.setVisibility(8);
        initShowOffBtnBg();
        setInteractBtnVisible(false);
        this.mShowOffBtn.setOnClickListener(this);
        this.mJumpDetailBtn.setOnClickListener(this);
        this.mCloseBtn.setOnClickListener(this);
        this.mShowOffBtn.setOnClickListener(this);
        initDataViewImg(inflate);
        if (this.mIsSingleTreasure) {
            initSingleTreasureView(inflate);
        } else {
            initBannerView(inflate);
            initMultiTreasureView(inflate);
        }
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setOutsideTouchable(false);
        setTouchable(true);
        setFocusable(false);
    }

    private void initShowOffBtnBg() {
        if (this.mBtnInfo == null) {
            return;
        }
        ImageView imageView = this.mShowOffBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        setStaticImg(this.mBtnInfo.url.get(), 250, 42, this.mShowOffBtn);
        abnormalImpDtReport(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BOX_RESULT_SHARE_BUTTON, this.mShowOffBtn, null);
    }

    private void initSingleTreasureView(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f506525z);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.f506125v);
        TextView textView = (TextView) inflate.findViewById(R.id.f506425y);
        this.mRocketCntTitle = textView;
        textView.setText(getRocketCountTitle());
        RFWTypefaceUtil.setNumberTypeface(this.mRocketCntTitle, "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8893/rocket/FZRuiZhengHeiS-EB-GB.ttf");
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult == null) {
            return;
        }
        int i3 = feedCloudWrite$PushBoxDrawGiftResult.gift_type.get();
        if (i3 != 2) {
            if (i3 != 3) {
                imageView.setVisibility(8);
                initDetailLayout(inflate, R.id.f506325x, 1);
                return;
            } else {
                initAvatarDecorateLayout(inflate, R.id.f505925t, 1);
                imageView.setVisibility(0);
                setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_BG_2, 104, 104, imageView);
                return;
            }
        }
        initDetailLayout(inflate, R.id.f506325x, 1);
        imageView.setVisibility(0);
        setStaticImg(QFSPushPopWindowImgConst.ImageURL.QVIDEO_ROCKET_KAIXIANG_DANKAI_BG_1, 104, 104, imageView);
    }

    private void initTreasureRecycler() {
        if (this.mIsSingleTreasure) {
            return;
        }
        Iterator<QFSPushOpenBoxResultBean> it = this.mTreasureResultList.iterator();
        while (it.hasNext()) {
            countBoxNum(it.next().getTreasureType());
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mTreasureRecycler.getContext());
        linearLayoutManager.setOrientation(1);
        this.mTreasureRecycler.setLayoutManager(linearLayoutManager);
        QFSPushGetTreasureAdapter qFSPushGetTreasureAdapter = new QFSPushGetTreasureAdapter();
        this.mTreasureRecycler.setAdapter(qFSPushGetTreasureAdapter);
        qFSPushGetTreasureAdapter.setData(this.mTreasureResultList);
        qFSPushGetTreasureAdapter.notifyDataSetChanged();
        this.mTreasureRecycler.setVisibility(0);
    }

    private boolean isRootViewActivityAlive() {
        View view = this.mRootView;
        if (view == null) {
            return false;
        }
        if (view.getContext() instanceof Activity) {
            return !((Activity) this.mRootView.getContext()).isFinishing();
        }
        if (!(this.mRootView.getContext() instanceof MutableContextWrapper)) {
            return false;
        }
        MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) this.mRootView.getContext();
        if (!(mutableContextWrapper.getBaseContext() instanceof Activity) || ((Activity) mutableContextWrapper.getBaseContext()).isFinishing()) {
            return false;
        }
        return true;
    }

    private void jumpH5Page(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "h5 url is empty.");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.mContext, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playOpenBoxAnimation() {
        ImageView imageView = this.mTreasureAnimateImg;
        if (imageView != null && this.mOpenBoxAnimationDrawable != null) {
            imageView.setVisibility(0);
            this.mTreasureAnimateImg.setImageDrawable(this.mOpenBoxAnimationDrawable);
            this.mOpenBoxAnimationDrawable.start();
            this.mOpenBoxAnimationDrawable.setListener(new QQAnimationDrawable.QQAnimationListener() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.6
                @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
                public void onPlay(int i3) {
                    if (i3 == 27) {
                        QFSPushGetTreasurePopUpWindow.this.showOpenBoxStaticImg();
                        QLog.d(QFSPushGetTreasurePopUpWindow.TAG, 1, "Native animation start");
                    }
                }

                @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
                public void onStop() {
                    QFSPushGetTreasurePopUpWindow.this.showOpenBoxStaticImg();
                    QLog.d(QFSPushGetTreasurePopUpWindow.TAG, 1, "Open box animation finish");
                }

                @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
                public void onStart() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playResultViewAnimation() {
        LinearLayout linearLayout = this.mResultView;
        if (linearLayout != null && this.mContainerLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = ViewUtils.dip2px(-300.0f);
            this.mResultView.setLayoutParams(layoutParams);
            float dip2px = ViewUtils.dip2px(16.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mResultView, BasicAnimation.KeyPath.ROTATION_Y, 360.0f, 69.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mResultView, BasicAnimation.KeyPath.SCALE_X, 0.3f, 0.18f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mResultView, BasicAnimation.KeyPath.SCALE_Y, 0.3f, 0.18f);
            float f16 = dip2px * (-1.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mResultView, "translationY", 0.0f, f16);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mResultView, BasicAnimation.KeyPath.ROTATION_Y, 69.0f, 0.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mResultView, BasicAnimation.KeyPath.SCALE_X, 0.18f, 1.0f);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.mResultView, BasicAnimation.KeyPath.SCALE_Y, 0.18f, 1.0f);
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.mResultView, "translationY", f16, (this.mContainerLayout.getHeight() * 1.0f) / 2.0f);
            ofFloat.setDuration(120L);
            ofFloat2.setDuration(120L);
            ofFloat3.setDuration(120L);
            ofFloat4.setDuration(120L);
            ofFloat5.setDuration(120L);
            ofFloat6.setDuration(200L);
            ofFloat7.setDuration(200L);
            ofFloat8.setDuration(160L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.mResultViewAnimatorSet = animatorSet;
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).before(ofFloat5).before(ofFloat6).before(ofFloat7).before(ofFloat8);
            this.mResultViewAnimatorSet.start();
            this.mResultViewAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (QFSPushGetTreasurePopUpWindow.this.mResultViewAnimatorSet != null) {
                        QFSPushGetTreasurePopUpWindow.this.mResultViewAnimatorSet.removeAllListeners();
                    }
                    QFSPushGetTreasurePopUpWindow.this.setInteractBtnVisible(true);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDownloadAnimationTimingTask() {
        Runnable runnable;
        LinearLayout linearLayout = this.mResultView;
        if (linearLayout != null && (runnable = this.mOutTimeRunnable) != null) {
            linearLayout.removeCallbacks(runnable);
        }
    }

    private void setDownloadAnimationTimingTask() {
        if (this.mOutTimeRunnable == null) {
            this.mOutTimeRunnable = new Runnable() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.5
                @Override // java.lang.Runnable
                public void run() {
                    QFSPushGetTreasurePopUpWindow.this.mIsDownloadAnimationOutTime = true;
                    QFSPushGetTreasurePopUpWindow.this.showOpenBoxStaticImg();
                }
            };
        }
        LinearLayout linearLayout = this.mResultView;
        if (linearLayout != null) {
            linearLayout.postDelayed(this.mOutTimeRunnable, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInteractBtnVisible(boolean z16) {
        int i3;
        ImageView imageView = this.mShowOffBtn;
        int i16 = 0;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        ImageView imageView2 = this.mCloseBtn;
        if (imageView2 != null) {
            if (!z16) {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
        }
    }

    private void setStaticImg(String str, int i3, int i16, ImageView imageView) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setRequestWidth(ImmersiveUtils.dpToPx(i3)).setRequestHeight(ImmersiveUtils.dpToPx(i16)).setTargetView(imageView).setSupportRecycler(true).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenBoxAnimation() {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            QLog.d(TAG, 1, "Low Device, show static image!");
            showOpenBoxStaticImg();
            FrameLayout frameLayout = this.mDataView;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mOpenBoxAnimationDrawable != null) {
            playOpenBoxAnimation();
            return;
        }
        int screenWidth = ImmersiveUtils.getScreenWidth();
        int i3 = (int) (screenWidth * ANIMATE_HEIGHT_WIDTH_RATIO);
        AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder(getAnimateUrl());
        defaultBuilder.setFrameDuration(25);
        defaultBuilder.setRequestWidth(screenWidth);
        defaultBuilder.setRequestHeight(i3);
        AnimationDrawableFactory.getInstance().createFromUrl(hashCode(), defaultBuilder.build(), getOpenBoxAnimListener());
        setDownloadAnimationTimingTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenBoxStaticImg() {
        if (this.mHasShowNativeImg) {
            return;
        }
        this.mHasShowNativeImg = true;
        Runnable runnable = new Runnable() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.2
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPushGetTreasurePopUpWindow.this.mResultView != null) {
                    QFSPushGetTreasurePopUpWindow.this.mResultView.setVisibility(0);
                }
                QFSPushGetTreasurePopUpWindow.this.playResultViewAnimation();
            }
        };
        this.mOpenBoxRunnable = runnable;
        LinearLayout linearLayout = this.mResultView;
        if (linearLayout != null) {
            linearLayout.post(runnable);
        }
    }

    private int transformSourceToReportParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return sSourceMap.get(str).intValue();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Runnable runnable;
        if (isShowing() && isRootViewActivityAlive()) {
            super.dismiss();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
        LinearLayout linearLayout = this.mResultView;
        if (linearLayout != null && (runnable = this.mOpenBoxRunnable) != null) {
            linearLayout.removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(ASEngineTabStatusEvent.class);
        arrayList.add(QCircleSelectTabEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        View.OnClickListener onClickListener = this.mHookClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (id5 == R.id.f507726a) {
            abnormalClickDtReport(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BOX_WINDOW_ESC, this.mCloseBtn, null);
            dismiss();
        } else {
            String str2 = "";
            if (id5 == R.id.f507826b) {
                HashMap hashMap = new HashMap();
                FeedCloudWrite$PushShowOffBtn feedCloudWrite$PushShowOffBtn = this.mBtnInfo;
                if (feedCloudWrite$PushShowOffBtn == null) {
                    str = "";
                } else {
                    str = feedCloudWrite$PushShowOffBtn.f398480id.get();
                }
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_OPEN_BOX_RESULT_TEXT, str);
                abnormalClickDtReport(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BOX_RESULT_SHARE_BUTTON, this.mShowOffBtn, hashMap);
                FeedCloudWrite$PushShowOffBtn feedCloudWrite$PushShowOffBtn2 = this.mBtnInfo;
                if (feedCloudWrite$PushShowOffBtn2 != null) {
                    str2 = feedCloudWrite$PushShowOffBtn2.jump_url.get();
                }
                jumpH5Page(str2);
                dismiss();
            } else if (id5 == R.id.f508626j) {
                abnormalClickDtReport(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BOX_RESULT_CHECK_BUTTON, this.mJumpDetailBtn, null);
                jumpH5Page(this.mDetailUrl);
            } else if (id5 == R.id.f5070264 || id5 == R.id.f5068262) {
                FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
                if (feedCloudWrite$PushBoxDrawGiftResult != null) {
                    str2 = feedCloudWrite$PushBoxDrawGiftResult.setting_btn_url.get();
                }
                jumpH5Page(str2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ASEngineTabStatusEvent) {
            handleTabStatusChangedEvent((ASEngineTabStatusEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleSelectTabEvent) {
            handleSelectTabEvent((QCircleSelectTabEvent) simpleBaseEvent);
        }
    }

    public void show(View view) {
        String str;
        this.mRootView = view;
        if (view == null) {
            return;
        }
        if (isRootViewActivityAlive()) {
            showAtLocation(this.mRootView, 17, 0, 0);
            this.mRootView.post(new Runnable() { // from class: cooperation.qqcircle.push.QFSPushGetTreasurePopUpWindow.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSPushGetTreasurePopUpWindow.this.adjustViewLocation();
                    QFSPushGetTreasurePopUpWindow.this.showOpenBoxAnimation();
                }
            });
        }
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_REF_LOCATION, Integer.valueOf(transformSourceToReportParams(this.mSource)));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_NORMAL_BOX_OPENED_NUM, Integer.valueOf(this.mOpenNormalBoxNum));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUPER_BOX_OPENED_NUM, Integer.valueOf(this.mOpenSuperBoxNum));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_OPEN_BOX_RESULT_HIGH_IF, Integer.valueOf(ifGetHighResult() ? 1 : 0));
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult == null) {
            str = "";
        } else {
            str = feedCloudWrite$PushBoxDrawGiftResult.gift_id.get();
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PENDANT_ID, str);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_OPEN_BOX_REWARD, Float.valueOf(getRewardForReport()));
        abnormalImpDtReport(QCircleDaTongConstant.ElementId.EM_XSJ_OPEN_BOX_RESULT_WINDOW, this.mDataView, hashMap);
    }

    public QFSPushGetTreasurePopUpWindow(Context context, QFSPushOpenBoxInfo qFSPushOpenBoxInfo, View.OnClickListener onClickListener) {
        this.mIsSingleTreasure = true;
        this.mIsDownloadAnimationOutTime = false;
        ArrayList arrayList = new ArrayList();
        this.mTreasureResultList = arrayList;
        this.mOpenNormalBoxNum = 0;
        this.mOpenSuperBoxNum = 0;
        this.mHasShowNativeImg = false;
        if (context == null || qFSPushOpenBoxInfo == null) {
            return;
        }
        this.mContext = context;
        arrayList.addAll(qFSPushOpenBoxInfo.getResultList());
        this.mSource = qFSPushOpenBoxInfo.getSource();
        this.mDetailUrl = qFSPushOpenBoxInfo.getDetailUrl();
        this.mGiftResult = qFSPushOpenBoxInfo.getGiftResult();
        this.mBtnInfo = qFSPushOpenBoxInfo.getShowOffBtnInfo();
        FeedCloudWrite$PushBoxDrawGiftResult feedCloudWrite$PushBoxDrawGiftResult = this.mGiftResult;
        if (feedCloudWrite$PushBoxDrawGiftResult != null) {
            this.mGiftType = feedCloudWrite$PushBoxDrawGiftResult.gift_type.get();
        }
        if (arrayList.size() == 0) {
            return;
        }
        this.mIsSingleTreasure = arrayList.size() == 1;
        this.mHookClickListener = onClickListener;
        initPopupWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
