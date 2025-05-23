package com.tencent.mobileqq.emoticonview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerFrameLayout;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.fd;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class QQEmoticonPanelLinearLayoutHelper implements View.OnClickListener, PopupWindow.OnDismissListener, IEmoticonPanelLinearLayoutHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionPanelLinearLayout";
    private static Rect tmp;
    private int businessType;
    private EmoticonCallback callback;
    Context context;
    private int currentChatPieType;
    float density;
    protected boolean enablePasteSticker;
    private boolean hasReportPressMove;
    private boolean haveRemovedWindowContent;
    boolean isDiyEmotion;
    private boolean isPreviewShowPoping;
    boolean isSelfieFaceEmotion;
    boolean isSoundEmotion;
    volatile long lastJumpCameraTime;
    float lastRelativeTouchX;
    float lastRelativeTouchY;
    float lastTouchX;
    float lastTouchY;
    private QQEmoticonMainPanelApp mApp;
    private ImageView mArrowImageView;
    private IEmoticonPanelLinearLayoutHelper.OnClickListener mClickListener;
    private EmoticonPanelLinearLayout mCurrentView;
    private TextView mEmoTitleTv;
    private EmoticonInfo mEmocInfo;
    boolean mHasPerformedLongPress;
    private IPanelInteractionListener mInteractionListener;
    CheckForLongPress mPendingCheckForLongPress;
    private EmoticonInfo mPointInfo;
    View mPointView;
    protected com.tencent.mobileqq.popanim.c mPopOutEmoticonGesture;
    public StickerFrameLayout mPopupEmo;
    private URLImageView mPopupEmoImage;
    private PopupWindow mPopupWindow;
    private ViewGroup mRootView;
    private int mSessionType;
    private RelativeLayout mShowEmoRlyt;
    private ImageView mStickerCancel;
    private ImageView mStickerConfirm;
    private PopupWindow mTipsPopupWindow;
    private FrameLayout mWindowContent;
    private int panelType;
    private AudioPlayer player;
    protected boolean popOutEmoAnimMode;
    private EmoticonReportCallback reportCallback;
    float screenHeight;
    float screenWidth;
    private boolean showDescribeInPreview;
    private boolean showSticker;
    private boolean showing;
    private boolean stickerMode;

    /* loaded from: classes12.dex */
    class CheckForLongPress implements Runnable {
        static IPatchRedirector $redirector_;
        int mOriginalWindowAttachCount;
        SparseIntArray mReportSparseArray;

        public CheckForLongPress(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQEmoticonPanelLinearLayoutHelper.this, (Object) motionEvent);
                return;
            }
            SparseIntArray sparseIntArray = new SparseIntArray(10);
            this.mReportSparseArray = sparseIntArray;
            sparseIntArray.put(7, 1);
            this.mReportSparseArray.put(1, 1);
            this.mReportSparseArray.put(2, 1);
            this.mReportSparseArray.put(4, 2);
            this.mReportSparseArray.put(5, 2);
            this.mReportSparseArray.put(11, 3);
            this.mReportSparseArray.put(6, 4);
            this.mReportSparseArray.put(9, 4);
            this.mReportSparseArray.put(10, 5);
        }

        private void reportShowPopupEmoEvent(EmoticonInfo emoticonInfo) {
            int i3;
            if (QQEmoticonPanelLinearLayoutHelper.this.mInteractionListener != null && (i3 = this.mReportSparseArray.get(emoticonInfo.type, -1)) != -1) {
                ReportController.o(QQEmoticonPanelLinearLayoutHelper.this.mApp.getAppRuntime(), "dc00898", "", "", "0X800AEEC", "0X800AEEC", i3, 0, "", "", "", "");
            }
        }

        public void rememberWindowAttachCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.mOriginalWindowAttachCount = QQEmoticonPanelLinearLayoutHelper.this.mCurrentView.getWindowAttachCount();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            EmoticonInfo emoticonInfo;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!QQEmoticonPanelLinearLayoutHelper.this.mCurrentView.isAttachedToWindow()) {
                QLog.w("EmotionPanelLinearLayout", 1, "[CheckForLongPress] not attach View, return.");
                return;
            }
            if (QQEmoticonPanelLinearLayoutHelper.this.mCurrentView.getParent() != null && this.mOriginalWindowAttachCount == QQEmoticonPanelLinearLayoutHelper.this.mCurrentView.getWindowAttachCount() && (view = QQEmoticonPanelLinearLayoutHelper.this.mPointView) != null && (emoticonInfo = (EmoticonInfo) view.getTag()) != null) {
                if (QQEmoticonPanelLinearLayoutHelper.this.callback != null && QQEmoticonPanelLinearLayoutHelper.this.callback.onLongClick(emoticonInfo)) {
                    QQEmoticonPanelLinearLayoutHelper.this.mPointView = null;
                    return;
                }
                QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper = QQEmoticonPanelLinearLayoutHelper.this;
                qQEmoticonPanelLinearLayoutHelper.mHasPerformedLongPress = true;
                qQEmoticonPanelLinearLayoutHelper.mCurrentView.getParent().requestDisallowInterceptTouchEvent(true);
                QQEmoticonPanelLinearLayoutHelper.this.mCurrentView.sendAccessibilityEvent(2);
                QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper2 = QQEmoticonPanelLinearLayoutHelper.this;
                qQEmoticonPanelLinearLayoutHelper2.handleLongClick(qQEmoticonPanelLinearLayoutHelper2.mPointView, emoticonInfo);
                if (!QQEmoticonPanelLinearLayoutHelper.this.needShowPopUpEmo(emoticonInfo)) {
                    return;
                }
                QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper3 = QQEmoticonPanelLinearLayoutHelper.this;
                qQEmoticonPanelLinearLayoutHelper3.showPopupEmo(qQEmoticonPanelLinearLayoutHelper3.mPointView, emoticonInfo);
                reportShowPopupEmoEvent(emoticonInfo);
                if (QQEmoticonPanelLinearLayoutHelper.this.mInteractionListener == null) {
                    QQEmoticonPanelLinearLayoutHelper.this.popOutEmoAnimMode = false;
                    return;
                }
                int curType = QQEmoticonPanelLinearLayoutHelper.this.mInteractionListener.getCurType();
                QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper4 = QQEmoticonPanelLinearLayoutHelper.this;
                qQEmoticonPanelLinearLayoutHelper4.popOutEmoAnimMode = com.tencent.mobileqq.popanim.util.a.f(qQEmoticonPanelLinearLayoutHelper4.panelType, QQEmoticonPanelLinearLayoutHelper.this.mEmocInfo, curType);
                QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper5 = QQEmoticonPanelLinearLayoutHelper.this;
                if (qQEmoticonPanelLinearLayoutHelper5.popOutEmoAnimMode) {
                    if (qQEmoticonPanelLinearLayoutHelper5.mPopOutEmoticonGesture == null) {
                        qQEmoticonPanelLinearLayoutHelper5.mPopOutEmoticonGesture = new com.tencent.mobileqq.popanim.c();
                        QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper6 = QQEmoticonPanelLinearLayoutHelper.this;
                        com.tencent.mobileqq.popanim.c cVar = qQEmoticonPanelLinearLayoutHelper6.mPopOutEmoticonGesture;
                        ViewGroup viewGroup = qQEmoticonPanelLinearLayoutHelper6.mRootView;
                        EmoticonPanelLinearLayout emoticonPanelLinearLayout = QQEmoticonPanelLinearLayoutHelper.this.mCurrentView;
                        QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper7 = QQEmoticonPanelLinearLayoutHelper.this;
                        cVar.b(viewGroup, emoticonPanelLinearLayout, qQEmoticonPanelLinearLayoutHelper7, qQEmoticonPanelLinearLayoutHelper7.mInteractionListener);
                    }
                    QQEmoticonPanelLinearLayoutHelper.this.mPopOutEmoticonGesture.h(emoticonInfo);
                    QQEmoticonPanelLinearLayoutHelper.this.hasReportPressMove = false;
                    boolean d16 = com.tencent.mobileqq.popanim.util.a.d(emoticonInfo);
                    if (d16) {
                        str = "0X800BC21";
                    } else {
                        str = "0X800BB9E";
                    }
                    com.tencent.mobileqq.popanim.view.a.i(str, emoticonInfo, d16);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            tmp = new Rect();
        }
    }

    public QQEmoticonPanelLinearLayoutHelper(Context context, IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) iPanelInteractionListener);
            return;
        }
        this.businessType = 0;
        this.isDiyEmotion = false;
        this.isSelfieFaceEmotion = false;
        this.isSoundEmotion = false;
        this.lastTouchX = 0.0f;
        this.lastTouchY = 0.0f;
        this.lastRelativeTouchX = 0.0f;
        this.lastRelativeTouchY = 0.0f;
        this.lastJumpCameraTime = 0L;
        this.showSticker = false;
        this.haveRemovedWindowContent = true;
        this.panelType = -1;
        this.showing = false;
        this.stickerMode = false;
        this.isPreviewShowPoping = false;
        this.showDescribeInPreview = false;
        initHelper(context);
        this.mInteractionListener = iPanelInteractionListener;
        if (iPanelInteractionListener != null) {
            this.currentChatPieType = iPanelInteractionListener.getPanelChatPieType();
            this.mRootView = this.mInteractionListener.getAIORootView();
            this.mSessionType = this.mInteractionListener.getCurType();
        }
    }

    private void addEmoTitleLayout(EmoticonInfo emoticonInfo, float f16) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mShowEmoRlyt = new RelativeLayout(getContext());
        this.mPopupEmo.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.mShowEmoRlyt, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(2, R.id.f630232e);
        this.mShowEmoRlyt.addView(this.mPopupEmoImage, layoutParams2);
        fillPopEmoLayout(this.mShowEmoRlyt);
        this.mEmoTitleTv = getEmoTitleTv(emoticonInfo);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (19.0f * f16);
        int i3 = (int) (f16 * 12.0f);
        layoutParams3.leftMargin = i3;
        layoutParams3.rightMargin = i3;
        this.mShowEmoRlyt.addView(this.mEmoTitleTv, layoutParams3);
        ImageView imageView = new ImageView(getContext());
        this.mArrowImageView = imageView;
        imageView.setImageDrawable(this.mCurrentView.getResources().getDrawable(R.drawable.j6p));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ViewUtils.dip2px(18.0f), ViewUtils.dip2px(12.0f));
        layoutParams4.topMargin = -ViewUtils.dip2px(9.5f);
        layoutParams4.gravity = 1;
        linearLayout.addView(this.mArrowImageView, layoutParams4);
    }

    private void addToCustomEmotionForPic(String str) {
        ((IEmosmService) QRoute.api(IEmosmService.class)).addToCustomEmotionForPic(getContext(), str, true, 0);
    }

    private void fillPopEmoLayout(RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(getContext());
        this.mStickerCancel = imageView;
        imageView.setId(R.id.shd);
        float f16 = this.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f16 * 20.0f), (int) (f16 * 20.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        relativeLayout.addView(this.mStickerCancel, layoutParams);
        this.mStickerCancel.setImageDrawable(this.mCurrentView.getResources().getDrawable(R.drawable.fon));
        this.mStickerCancel.setVisibility(4);
        ImageView imageView2 = new ImageView(getContext());
        this.mStickerConfirm = imageView2;
        imageView2.setId(R.id.she);
        float f17 = this.density;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f17 * 20.0f), (int) (f17 * 20.0f));
        layoutParams2.addRule(11);
        layoutParams2.addRule(12);
        relativeLayout.addView(this.mStickerConfirm, layoutParams2);
        this.mStickerConfirm.setVisibility(4);
        this.mStickerConfirm.setImageDrawable(this.mCurrentView.getResources().getDrawable(R.drawable.bvz));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getChildViewIndex(View view) {
        int childCount = this.mCurrentView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.mCurrentView.getChildAt(i3) == view) {
                return i3;
            }
        }
        return -1;
    }

    private int getEmoticonReportType(EmoticonInfo emoticonInfo) {
        switch (emoticonInfo.type) {
            case 1:
            case 2:
            case 7:
                return 1;
            case 3:
            case 8:
            default:
                return 7;
            case 4:
            case 5:
                return 5;
            case 6:
                if (this.isDiyEmotion) {
                    return 3;
                }
                if (this.isSoundEmotion) {
                    return 6;
                }
                return -1;
            case 9:
                return 4;
            case 10:
                return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLongClick(View view, EmoticonInfo emoticonInfo) {
        if (view != null && emoticonInfo != null) {
            if (this.panelType == 6 && (emoticonInfo instanceof HotPicSearchEmoticonInfo) && this.mApp.getQQAppInterface() != null) {
                reportHotPicSearchAddFav((HotPicSearchEmoticonInfo) emoticonInfo, false);
                showAddCustomFacePop(view, emoticonInfo);
            }
            if (this.panelType == 5 && (emoticonInfo instanceof CameraEmoticonInfo) && this.mApp.getQQAppInterface() != null) {
                showAddCustomFacePop(view, emoticonInfo);
                ReportController.o(null, "dc00898", "", "", "0X800C3C1", "0X800C3C1", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        QLog.e("EmotionPanelLinearLayout", 4, "handleLongClick pointView or info is null.");
    }

    private boolean isInvokeSticker(float f16, float f17, float f18, float f19) {
        float f26 = f16 - f18;
        float f27 = f17 - f19;
        if (Math.sqrt((f26 * f26) + (f27 * f27)) > 50.0d) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showPopupEmo$0(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess()) {
            if (option.getAnimatable() instanceof r01.c) {
                ((r01.c) option.getAnimatable()).start();
            }
        } else if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e("EmotionPanelLinearLayout", 1, "loadImage  state:" + loadState + ", listenerOption:" + option);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needShowPopUpEmo(EmoticonInfo emoticonInfo) {
        int i3;
        if ("delete".equals(emoticonInfo.action) || "setting".equals(emoticonInfo.action) || "add".equals(emoticonInfo.action) || EmoticonInfo.CAMERA_JUMP_ACTION.equals(emoticonInfo.action) || EmoticonInfo.CAMERA_EDIT_ACTION.equals(emoticonInfo.action) || (i3 = this.panelType) == 6 || i3 == 5) {
            return false;
        }
        if (!(emoticonInfo instanceof CameraEmoticonInfo)) {
            return true;
        }
        CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
        if (cameraEmoticonInfo.roamingType.equals("failed") || cameraEmoticonInfo.roamingType.equals("needUpload") || cameraEmoticonInfo.roamingType.equals("needDel")) {
            return false;
        }
        return true;
    }

    private void onFavEditClick() {
        this.context.startActivity(new Intent(this.context, (Class<?>) FavEmosmManageActivity.class));
        ReportController.o(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
        ReportController.o(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800B8B8", "0X800B8B8", 0, 0, "", "", "", "");
        reportQQClick("em_bas_aio_bottom_emoji_added");
    }

    private void onFunnyPicClick(View view) {
        int i3 = 0;
        if (AppSetting.f99551k.equals("7.3.5")) {
            SharedPreferences.Editor edit = this.context.getSharedPreferences(FunnyPicHelperConstant.SP_FUNNY_PIC_INFO, 0).edit();
            edit.putBoolean("group_emo_red_show_sp_key_" + this.mApp.getCurrentAccountUin(), false);
            edit.apply();
            View findViewById = view.findViewById(R.id.f165139c32);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
                i3 = 1;
            }
        }
        ((IEmosmService) QRoute.api(IEmosmService.class)).startEmoticonGroupStoreFragment(this.context);
        ReportController.o(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, i3, "", "", "", "", "", "", "", 0, 0, 0, 0);
        reportQQClick("em_bas_aio_bottom_emoji_group_chat_emojis");
    }

    private void reportHotPicSearchAddFav(HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo, boolean z16) {
        String str;
        int i3;
        String str2;
        String str3;
        int i16 = hotPicSearchEmoticonInfo.mPageType;
        if (i16 == 1) {
            if (z16) {
                str3 = "0X800B535";
            } else {
                str3 = "0X800B534";
            }
            if (TextUtils.isEmpty(hotPicSearchEmoticonInfo.mSearchWord)) {
                str2 = str3;
                i3 = 1;
            } else {
                str2 = str3;
                i3 = 2;
            }
        } else {
            if (i16 == 2) {
                if (z16) {
                    str = "0X800B537";
                } else {
                    str = "0X800B536";
                }
            } else {
                str = "";
            }
            i3 = 0;
            str2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            ReportController.o(null, "dc00898", "", "", str2, str2, i3, 0, "", "", "", "");
        }
    }

    private void reportQQClick(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(EmotionReportDtImpl.CURRENT_TAB, HardCodeUtil.qqStr(R.string.m7j));
        com.tencent.mobileqq.aio.utils.b.l(str, hashMap);
    }

    private void updateArrowLayout(View view, float f16, int i3, int i16, ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (this.mArrowImageView != null) {
            marginLayoutParams.topMargin = (tmp.top - i16) - ((int) (f16 * 30.0f));
            int width = (int) (((int) (r0.left + (view.getWidth() / 2.0f))) - (marginLayoutParams.leftMargin + (i3 / 2.0f)));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mArrowImageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = width;
                this.mArrowImageView.setLayoutParams(layoutParams);
            }
        }
    }

    private void updatePointViewAlpha(float f16) {
        View view;
        if (this.panelType == 6 && (view = this.mPointView) != null) {
            view.setAlpha(f16);
        }
    }

    private void updatePopupEmoLayout(int i3, ViewGroup.MarginLayoutParams marginLayoutParams) {
        Rect rect = tmp;
        int width = rect.left - ((i3 - rect.width()) / 2);
        marginLayoutParams.leftMargin = width;
        float f16 = width + i3;
        float f17 = this.screenWidth;
        if (f16 >= f17) {
            marginLayoutParams.leftMargin = ((int) f17) - i3;
        } else if (width <= 0) {
            marginLayoutParams.leftMargin = 0;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void attachCurrentView(EmoticonPanelLinearLayout emoticonPanelLinearLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticonPanelLinearLayout);
            return;
        }
        this.mCurrentView = emoticonPanelLinearLayout;
        emoticonPanelLinearLayout.setClickable(true);
        emoticonPanelLinearLayout.setLongClickable(true);
        emoticonPanelLinearLayout.setOrientation(0);
    }

    View findPointChild(float f16, float f17) {
        for (int childCount = this.mCurrentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mCurrentView.getChildAt(childCount);
            float scrollX = (this.mCurrentView.getScrollX() + f16) - childAt.getLeft();
            float scrollY = (this.mCurrentView.getScrollY() + f17) - childAt.getTop();
            if (scrollX >= 0.0f && scrollX <= childAt.getWidth() && scrollY >= 0.0f && scrollY < childAt.getHeight()) {
                return childAt;
            }
        }
        return null;
    }

    boolean getChildRect(View view, Rect rect) {
        if (view == null) {
            return false;
        }
        view.getDrawingRect(rect);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        rect.offset(view.getLeft() - viewGroup.getScrollX(), view.getTop() - viewGroup.getScrollY());
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Context) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.context;
    }

    public int getCurrentPointViewIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        View view = this.mPointView;
        if (view != null) {
            return getChildViewIndex(view);
        }
        return -1;
    }

    protected TextView getEmoTitleTv(EmoticonInfo emoticonInfo) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (TextView) iPatchRedirector.redirect((short) 21, (Object) this, (Object) emoticonInfo);
        }
        TextView textView = new TextView(getContext());
        textView.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(emoticonInfo));
        textView.setId(R.id.f630232e);
        textView.setTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_primary));
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setLines(1);
        if (SimpleUIUtil.isNowElderMode()) {
            f16 = 18.0f;
        } else {
            f16 = 12.0f;
        }
        textView.setTextSize(f16);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    public int getNavigateWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        if (this.mCurrentView == null) {
            return 0;
        }
        return (int) (this.screenWidth - r0.getWidth());
    }

    public void hidePopupWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (this.mRootView != null && !this.isDiyEmotion && this.stickerMode && ((IEmosmService) QRoute.api(IEmosmService.class)).getEmojiStickerSwitch(this.mSessionType)) {
            if (this.isPreviewShowPoping) {
                return;
            }
            this.mRootView.post(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQEmoticonPanelLinearLayoutHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQEmoticonPanelLinearLayoutHelper.this.mRootView.removeView(QQEmoticonPanelLinearLayoutHelper.this.mPopupEmo);
                    }
                }
            });
            ((IEmosmService) QRoute.api(IEmosmService.class)).setEmojiStickerMode(false);
            return;
        }
        if (this.mPopupEmo != null && this.showing && this.mWindowContent != null && !this.haveRemovedWindowContent) {
            this.haveRemovedWindowContent = true;
            PopupWindow popupWindow = this.mPopupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.mPopupWindow = null;
            }
            AudioPlayer audioPlayer = this.player;
            if (audioPlayer != null) {
                audioPlayer.stop();
            }
            EmoticonCallback emoticonCallback = this.callback;
            if (emoticonCallback != null) {
                emoticonCallback.onHidePopup(this.mPointInfo);
            }
            this.showing = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void initHelper(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.density = context.getResources().getDisplayMetrics().density;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.screenHeight = displayMetrics.heightPixels;
        this.screenWidth = displayMetrics.widthPixels;
        this.mApp = new QQEmoticonMainPanelApp();
        this.enablePasteSticker = true;
        if (context instanceof Activity) {
            if (((Activity) context).getIntent() != null) {
                this.enablePasteSticker = !r4.getIntent().getBooleanExtra("KEY_OPEN_MINI_CHAT", false);
            }
        }
    }

    public boolean isSplitViewModeAndLand(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context)).booleanValue();
        }
        if (context == null || !AppSetting.t(context) || context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f164035i0) {
            if (QLog.isColorLevel()) {
                QLog.d("EmotionPanelLinearLayout", 4, " add_to_custom_face ");
            }
            PopupWindow popupWindow = this.mTipsPopupWindow;
            if (popupWindow != null && popupWindow.isShowing()) {
                EmoticonInfo emoticonInfo = (EmoticonInfo) view.getTag();
                if (emoticonInfo instanceof HotPicSearchEmoticonInfo) {
                    HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = (HotPicSearchEmoticonInfo) emoticonInfo;
                    if (hotPicSearchEmoticonInfo.mSearchItem != null) {
                        File diskFile = ((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFile(hotPicSearchEmoticonInfo.mSearchItem.originalUrl);
                        if (diskFile != null && FileUtils.fileExistsAndNotEmpty(diskFile.getAbsolutePath())) {
                            addToCustomEmotionForPic(hotPicSearchEmoticonInfo.mSearchItem.originalUrl);
                        } else {
                            addToCustomEmotionForPic(hotPicSearchEmoticonInfo.mSearchItem.url);
                        }
                        reportHotPicSearchAddFav(hotPicSearchEmoticonInfo, true);
                    }
                }
                if (emoticonInfo instanceof CameraEmoticonInfo) {
                    CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
                    if (cameraEmoticonInfo.url != null) {
                        if (!NetworkUtil.isNetworkAvailable()) {
                            ToastUtil.a().f("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0);
                        } else {
                            ((IEmosmService) QRoute.api(IEmosmService.class)).addToDiyEmotionForPic(this.context, cameraEmoticonInfo.url);
                            ReportController.o(null, "dc00898", "", "", "0X800C3C2", "0X800C3C2", 0, 0, "", "", "", "");
                        }
                    }
                }
                this.mTipsPopupWindow.dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        PopupWindow popupWindow = this.mTipsPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mTipsPopupWindow.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.mTipsPopupWindow = null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CheckForLongPress checkForLongPress;
        View view;
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        boolean z17 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.mCurrentView.setPressed(false);
                        CheckForLongPress checkForLongPress2 = this.mPendingCheckForLongPress;
                        if (checkForLongPress2 != null) {
                            this.mCurrentView.removeCallbacks(checkForLongPress2);
                        }
                        if (!this.showSticker) {
                            hidePopupWindow();
                        }
                        updatePointViewAlpha(1.0f);
                        this.mPointView = null;
                        com.tencent.mobileqq.popanim.c cVar = this.mPopOutEmoticonGesture;
                        if (cVar != null && cVar.c()) {
                            this.mPopOutEmoticonGesture.f(motionEvent);
                        }
                    }
                } else {
                    if (this.mHasPerformedLongPress) {
                        float rawX = motionEvent.getRawX();
                        float rawY = motionEvent.getRawY();
                        if (this.mPopupEmo != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        boolean isInvokeSticker = isInvokeSticker(this.lastTouchX, this.lastTouchY, rawX, rawY);
                        com.tencent.mobileqq.popanim.c cVar2 = this.mPopOutEmoticonGesture;
                        if (cVar2 != null && cVar2.c()) {
                            z17 = true;
                        }
                        if (this.popOutEmoAnimMode) {
                            if (z17 && z16 && isInvokeSticker) {
                                if (this.mPointView == null) {
                                    this.mPointView = findPointChild(this.lastRelativeTouchX, this.lastRelativeTouchY);
                                }
                                this.mPopOutEmoticonGesture.f(motionEvent);
                                if (!this.hasReportPressMove) {
                                    this.hasReportPressMove = true;
                                    boolean d16 = com.tencent.mobileqq.popanim.util.a.d(this.mEmocInfo);
                                    if (d16) {
                                        str = "0X800BC22";
                                    } else {
                                        str = "0X800BB9F";
                                    }
                                    com.tencent.mobileqq.popanim.view.a.i(str, this.mEmocInfo, d16);
                                }
                            }
                        }
                    }
                    if ((!this.showSticker && this.mWindowContent != null) || !((IEmosmService) QRoute.api(IEmosmService.class)).getEmojiStickerSwitch(this.mSessionType)) {
                        if (this.mHasPerformedLongPress && (!getChildRect(this.mPointView, tmp) || !tmp.contains((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                            if (this.mPointView != null) {
                                updatePointViewAlpha(1.0f);
                            }
                            View findPointChild = findPointChild(motionEvent.getX(), motionEvent.getY());
                            this.mPointView = findPointChild;
                            if (findPointChild != null && findPointChild.getTag() != null) {
                                EmoticonInfo emoticonInfo = (EmoticonInfo) this.mPointView.getTag();
                                if (needShowPopUpEmo(emoticonInfo)) {
                                    showPopupEmo(this.mPointView, emoticonInfo);
                                }
                            } else {
                                hidePopupWindow();
                            }
                        } else if (!this.mHasPerformedLongPress && (view = this.mPointView) != null && (!getChildRect(view, tmp) || !tmp.contains((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                            this.mPointView = null;
                        }
                    }
                }
            } else {
                if (!this.mHasPerformedLongPress && (checkForLongPress = this.mPendingCheckForLongPress) != null) {
                    this.mCurrentView.removeCallbacks(checkForLongPress);
                }
                updatePointViewAlpha(1.0f);
                View view2 = this.mPointView;
                this.mPointView = null;
                if (view2 != null && !this.mHasPerformedLongPress) {
                    performClick(view2);
                    view2.callOnClick();
                }
                if (!this.showSticker) {
                    hidePopupWindow();
                }
                com.tencent.mobileqq.popanim.c cVar3 = this.mPopOutEmoticonGesture;
                if (cVar3 != null && cVar3.c()) {
                    this.mPopOutEmoticonGesture.f(motionEvent);
                } else if (this.mRootView != null && !this.isDiyEmotion && this.enablePasteSticker && ((IEmosmService) QRoute.api(IEmosmService.class)).getEmojiStickerSwitch(this.mSessionType) && !this.isPreviewShowPoping) {
                    this.mRootView.onTouchEvent(motionEvent);
                }
            }
        } else {
            this.lastTouchX = motionEvent.getRawX();
            this.lastTouchY = motionEvent.getRawY();
            this.lastRelativeTouchX = motionEvent.getX();
            this.lastRelativeTouchY = motionEvent.getY();
            this.mHasPerformedLongPress = false;
            View findPointChild2 = findPointChild(motionEvent.getX(), motionEvent.getY());
            this.mPointView = findPointChild2;
            if (findPointChild2 != null) {
                updatePointViewAlpha(0.2f);
                if (this.mPendingCheckForLongPress == null) {
                    this.mPendingCheckForLongPress = new CheckForLongPress(motionEvent);
                }
                this.mPendingCheckForLongPress.rememberWindowAttachCount();
                this.mCurrentView.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
            }
        }
        return true;
    }

    void performClick(View view) {
        EmoticonInfo emoticonInfo;
        if (view.getAlpha() != 1.0f) {
            return;
        }
        Object tag = view.getTag();
        if (tag != null && (tag instanceof EmoticonInfo)) {
            emoticonInfo = (EmoticonInfo) tag;
        } else {
            emoticonInfo = null;
        }
        if (emoticonInfo != null) {
            IEmoticonPanelLinearLayoutHelper.OnClickListener onClickListener = this.mClickListener;
            if (onClickListener != null && onClickListener.shouldInterceptClickEvent(view, emoticonInfo)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("EmotionPanelLinearLayout", 2, "[performClick] action=", emoticonInfo.action);
            }
            this.mCurrentView.sendAccessibilityEvent(1);
            this.mCurrentView.playSoundEffect(0);
            if (!"delete".equals(emoticonInfo.action) && this.callback != null) {
                if ("setting".equals(emoticonInfo.action)) {
                    this.callback.setting();
                } else if ("add".equals(emoticonInfo.action)) {
                    this.callback.emoticonMall();
                    ReportController.o(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
                } else if (EmoticonInfo.CAMERA_JUMP_ACTION.equals(emoticonInfo.action)) {
                    if (this.mInteractionListener == null) {
                        QLog.e("EmotionPanelLinearLayout", 1, "baseChatPie is null.");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.lastJumpCameraTime > 1000) {
                        this.lastJumpCameraTime = currentTimeMillis;
                        this.mInteractionListener.launchAECameraUnit();
                        ReportController.o(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
                        ReportController.o(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
                    }
                } else if (EmoticonInfo.CAMERA_EDIT_ACTION.equals(emoticonInfo.action)) {
                    Intent intent = new Intent(this.context, (Class<?>) FavEmosmManageActivity.class);
                    intent.putExtra("camera_emo_mode", 1);
                    this.context.startActivity(intent);
                    ReportController.o(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
                } else if (EmoticonInfo.FAV_EDIT_ACTION.equals(emoticonInfo.action)) {
                    onFavEditClick();
                } else if ("funny_pic".equals(emoticonInfo.action)) {
                    onFunnyPicClick(view);
                } else if ("push".equals(emoticonInfo.action)) {
                    ((IEmosmService) QRoute.api(IEmosmService.class)).gotoEmoMallPage(this.callback);
                    ReportController.o(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
                    ReportController.o(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
                    SharedPreferences sharedPreferences = this.context.getSharedPreferences("mobileQQ", 0);
                    String currentAccountUin = this.mApp.getCurrentAccountUin();
                    if (!sharedPreferences.getBoolean("magic_promotion_is_new_content_" + currentAccountUin, false)) {
                        return;
                    }
                    ImageView imageView = (ImageView) view.findViewById(R.id.f915355f);
                    if (QLog.isColorLevel()) {
                        QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + imageView);
                    }
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = this.context.getResources().getDrawable(R.drawable.fnm);
                    URLDrawable drawable = URLDrawable.getDrawable(sharedPreferences.getString("magic_promotion_imgUrl", ""), obtain);
                    if (imageView != null && drawable != null) {
                        imageView.setImageDrawable(drawable);
                    }
                    sharedPreferences.edit().putBoolean("magic_promotion_is_new_content_" + currentAccountUin, false).apply();
                } else if (emoticonInfo instanceof PicEmoticonInfo) {
                    if (QLog.isColorLevel()) {
                        QLog.e("EmotionPanelLinearLayout", 2, "[performClick] send PicEmoticonInfo.");
                    }
                    PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) emoticonInfo;
                    picEmoticonInfo.stickerInfo = null;
                    Emoticon emoticon = picEmoticonInfo.emoticon;
                    ((EmoticonManagerServiceProxy) this.mApp.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(emoticon.epId, this.businessType, new QueryCallback<EmoticonPackage>(emoticon, emoticonInfo, picEmoticonInfo) { // from class: com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Emoticon val$emoticon;
                        final /* synthetic */ PicEmoticonInfo val$emoticonInfo;
                        final /* synthetic */ EmoticonInfo val$infoFinal;

                        {
                            this.val$emoticon = emoticon;
                            this.val$infoFinal = emoticonInfo;
                            this.val$emoticonInfo = picEmoticonInfo;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, QQEmoticonPanelLinearLayoutHelper.this, emoticon, emoticonInfo, picEmoticonInfo);
                            }
                        }

                        @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                        public void postQuery(EmoticonPackage emoticonPackage) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                                return;
                            }
                            if (emoticonPackage == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("EmotionPanelLinearLayout", 2, "package is null, epId: " + this.val$emoticon.epId);
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.e("EmotionPanelLinearLayout", 2, "[performClick] send PicEmoticonInfo, asyncFindEmoticonPackage result success. callback=", QQEmoticonPanelLinearLayoutHelper.this.callback);
                            }
                            EmoticonCallback emoticonCallback = QQEmoticonPanelLinearLayoutHelper.this.callback;
                            int i3 = this.val$emoticon.jobType;
                            if (i3 == 2 || i3 == 4) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("EmotionPanelLinearLayout", 2, "[performClick] send PicEmoticonInfo return, magic face is offline.");
                                }
                            } else if (emoticonCallback != null) {
                                emoticonCallback.send(this.val$infoFinal);
                            }
                            if (this.val$emoticonInfo.srcType == 2) {
                                if (emoticonPackage.jobType != 0 || emoticonPackage.subType != 4) {
                                    ReportController.o(QQEmoticonPanelLinearLayoutHelper.this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "2", "");
                                    com.tencent.mobileqq.config.business.w a16 = com.tencent.mobileqq.config.business.w.INSTANCE.a();
                                    Emoticon emoticon2 = this.val$emoticon;
                                    if (a16.a(emoticon2.epId, emoticon2.eId)) {
                                        BaseQQAppInterface qQAppInterface = QQEmoticonPanelLinearLayoutHelper.this.mApp.getQQAppInterface();
                                        Emoticon emoticon3 = this.val$emoticon;
                                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C28A", "0X800C28A", 0, 0, "", "", emoticon3.epId, emoticon3.eId);
                                        return;
                                    }
                                    return;
                                }
                                ReportController.o(QQEmoticonPanelLinearLayoutHelper.this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "3", "");
                            }
                        }
                    });
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.e("EmotionPanelLinearLayout", 2, "[performClick] send. callback=", this.callback);
                    }
                    EmoticonCallback emoticonCallback = this.callback;
                    if (emoticonCallback instanceof EmoticonCallbackWithView) {
                        ((EmoticonCallbackWithView) emoticonCallback).send(emoticonInfo, view);
                    } else {
                        emoticonCallback.send(emoticonInfo);
                        EmoticonReportCallback emoticonReportCallback = this.reportCallback;
                        if (emoticonReportCallback != null) {
                            emoticonReportCallback.report(emoticonInfo);
                        }
                    }
                }
            } else {
                QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
            }
            if (view instanceof EmoticonImageView) {
                EmoticonImageView emoticonImageView = (EmoticonImageView) view;
                if (emoticonImageView.isNewIconVisible()) {
                    if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                        ((IApolloUtil) QRoute.api(IApolloUtil.class)).onNewEmoticonClick(((SystemAndEmojiEmoticonInfo) emoticonInfo).code);
                    }
                    emoticonImageView.setNewIconVisible(false);
                    if (!EmoticonImageView.isNewIconDisable()) {
                        EmoticonImageView.disableNewIcon(true);
                        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.mInteractionListener);
                        if (emoticonMainPanel != null) {
                            emoticonMainPanel.updateSystemAndEmojiPanel();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
    }

    public PopupWindow popupFullScreen(Context context, View view, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (PopupWindow) iPatchRedirector.redirect((short) 19, this, context, view, drawable);
        }
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setWindowLayoutMode(-1, -1);
        popupWindow.setFocusable(true);
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        popupWindow.setBackgroundDrawable(drawable);
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(new View(context), 0, 0, 0);
        return popupWindow;
    }

    public void removeStickerMaskOnPanel() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.mInteractionListener);
        if (emoticonMainPanel != null && (view = emoticonMainPanel.stickerMaskLayout) != null) {
            emoticonMainPanel.removeView(view);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void setBusinessType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.businessType = i3;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void setCallBack(EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonCallback);
        } else {
            this.callback = emoticonCallback;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void setInterceptListener(IEmoticonPanelLinearLayoutHelper.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onClickListener);
        } else {
            this.mClickListener = onClickListener;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void setPanelType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.panelType = i3;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void setReportCallback(EmoticonReportCallback emoticonReportCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticonReportCallback);
        } else {
            this.reportCallback = emoticonReportCallback;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper
    public void setShowDescribeInPreview(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.showDescribeInPreview = z16;
        }
    }

    public void showAddCustomFacePop(View view, EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view, (Object) emoticonInfo);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        TextView textView = new TextView(getContext());
        textView.setId(R.id.f164035i0);
        textView.setTag(emoticonInfo);
        textView.setOnClickListener(this);
        textView.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
        textView.setTextSize(14.0f);
        textView.setGravity(17);
        textView.setText(getContext().getResources().getString(R.string.f209185eq));
        textView.setBackgroundResource(R.drawable.cay);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(ViewUtils.dip2px(65.0f), ViewUtils.dip2px(46.0f)));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cau));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(10.0f)));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.topMargin = -com.tencent.mobileqq.EmotionUtils.a(7.0f, getContext().getResources());
        layoutParams.bottomMargin = com.tencent.mobileqq.EmotionUtils.a(3.0f, getContext().getResources());
        imageView.setLayoutParams(layoutParams);
        PopupWindow popupWindow = new PopupWindow(linearLayout, -2, -2);
        this.mTipsPopupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.mTipsPopupWindow.setOutsideTouchable(true);
        this.mTipsPopupWindow.setFocusable(true);
        this.mTipsPopupWindow.setOnDismissListener(this);
        linearLayout.measure(0, 0);
        view.post(new Runnable(view, linearLayout) { // from class: com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ LinearLayout val$linearLayout;
            final /* synthetic */ View val$view;

            {
                this.val$view = view;
                this.val$linearLayout = linearLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QQEmoticonPanelLinearLayoutHelper.this, view, linearLayout);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if ((QQEmoticonPanelLinearLayoutHelper.this.getContext() instanceof Activity) && !((Activity) QQEmoticonPanelLinearLayoutHelper.this.getContext()).isFinishing()) {
                    int[] iArr = new int[2];
                    this.val$view.getLocationInWindow(iArr);
                    int i3 = 0;
                    if (QLog.isColorLevel()) {
                        QLog.d("EmotionPanelLinearLayout", 4, " getLocationInWindow [x,y]= [" + iArr[0] + "," + iArr[1] + "]");
                    }
                    int measuredWidth = this.val$view.getMeasuredWidth();
                    if (com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT) {
                        int childViewIndex = QQEmoticonPanelLinearLayoutHelper.this.getChildViewIndex(this.val$view);
                        if (childViewIndex >= 0) {
                            if (childViewIndex <= 1) {
                                i3 = -((int) (((1 - childViewIndex) * measuredWidth) + (measuredWidth / 2.0f) + ViewUtils.dip2px(3.0f)));
                            } else {
                                i3 = (int) ((((childViewIndex - 2) * measuredWidth) + (measuredWidth / 2.0f)) - ViewUtils.dip2px(1.0f));
                            }
                        }
                        QQEmoticonPanelLinearLayoutHelper.this.mTipsPopupWindow.showAtLocation(this.val$view, 48, i3, iArr[1] - this.val$linearLayout.getMeasuredHeight());
                        return;
                    }
                    QQEmoticonPanelLinearLayoutHelper.this.mTipsPopupWindow.showAtLocation(this.val$view, 0, (iArr[0] + (measuredWidth / 2)) - (this.val$linearLayout.getMeasuredWidth() / 2), iArr[1] - this.val$linearLayout.getMeasuredHeight());
                }
            }
        });
    }

    void showPopupEmo(View view, EmoticonInfo emoticonInfo) {
        Drawable bigDrawable;
        int i3;
        int i16;
        int i17;
        int i18;
        TextView textView;
        int width;
        int i19;
        AppRuntime waitAppRuntime;
        String str;
        AudioPlayer audioPlayer;
        int i26;
        EmoticonManagerServiceProxy emoticonManagerServiceProxy;
        EmoticonPackage syncFindEmoticonPackageById;
        if (view != null && emoticonInfo != null) {
            float f16 = getContext().getResources().getDisplayMetrics().density;
            this.isDiyEmotion = false;
            this.isSoundEmotion = false;
            this.stickerMode = false;
            this.showSticker = false;
            this.mEmocInfo = emoticonInfo;
            boolean z16 = emoticonInfo instanceof PicEmoticonInfo;
            if (z16) {
                PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) emoticonInfo;
                if (picEmoticonInfo.emoticon != null && (emoticonManagerServiceProxy = (EmoticonManagerServiceProxy) this.mApp.getRuntimeService(IEmoticonManagerService.class)) != null && (syncFindEmoticonPackageById = emoticonManagerServiceProxy.syncFindEmoticonPackageById(picEmoticonInfo.emoticon.epId)) != null) {
                    int i27 = syncFindEmoticonPackageById.subType;
                    if (i27 == 4) {
                        this.isDiyEmotion = true;
                    } else if (i27 == 1) {
                        this.isSoundEmotion = true;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, PicEmoticonInfo isDiyEmotion = " + this.isDiyEmotion + " isSoundEmotion = " + this.isSoundEmotion);
                }
                int i28 = (int) (f16 * 110.0f);
                bigDrawable = picEmoticonInfo.getLoadingDrawable(EmotionConstants.FROM_AIO, true, false, null, i28, i28);
            } else {
                bigDrawable = emoticonInfo.getBigDrawable(this.context, this.density);
            }
            Drawable drawable = bigDrawable;
            if (emoticonInfo instanceof CameraEmoticonInfo) {
                this.isSelfieFaceEmotion = true;
            }
            if (drawable == null) {
                QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
                return;
            }
            view.getGlobalVisibleRect(tmp);
            int i29 = emoticonInfo.type;
            if (this.mRootView != null && !this.isDiyEmotion && !this.isSelfieFaceEmotion && ((IEmosmService) QRoute.api(IEmosmService.class)).getEmojiStickerSwitch(this.mSessionType)) {
                if (this.mRootView.findViewById(R.id.gne) != null) {
                    this.isPreviewShowPoping = true;
                    return;
                }
                this.isPreviewShowPoping = false;
                StickerFrameLayout stickerFrameLayout = new StickerFrameLayout(getContext());
                this.mPopupEmo = stickerFrameLayout;
                stickerFrameLayout.setId(R.id.gne);
                this.mPopupEmo.setTag(emoticonInfo);
                this.mPopupEmo.setTag(R.id.god, Integer.valueOf(this.panelType));
                URLImageView uRLImageView = new URLImageView(getContext());
                this.mPopupEmoImage = uRLImageView;
                uRLImageView.setId(R.id.shf);
                this.mPopupEmoImage.setAdjustViewBounds(false);
                this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                drawable.setCallback(this.mPopupEmoImage);
                IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
                if (iPanelInteractionListener != null && iPanelInteractionListener.isShowEmoTitleInPreview(emoticonInfo, this.showDescribeInPreview)) {
                    addEmoTitleLayout(emoticonInfo, f16);
                } else {
                    this.mPopupEmo.addView(this.mPopupEmoImage);
                    fillPopEmoLayout(this.mPopupEmo);
                    this.mEmoTitleTv = null;
                    this.mArrowImageView = null;
                }
                this.mRootView.addView(this.mPopupEmo);
                this.stickerMode = true;
                URLImageView uRLImageView2 = this.mPopupEmoImage;
                if (uRLImageView2 != null) {
                    uRLImageView2.setRotation(0.0f);
                    this.mPopupEmoImage.setScaleX(1.0f);
                    this.mPopupEmoImage.setScaleY(1.0f);
                }
                ImageView imageView = this.mStickerCancel;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                ImageView imageView2 = this.mStickerConfirm;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                this.mWindowContent = null;
                this.showing = false;
                ((IEmosmService) QRoute.api(IEmosmService.class)).setEmojiStickerMode(true);
            } else {
                if (this.mWindowContent == null) {
                    this.mWindowContent = new FrameLayout(getContext());
                    StickerFrameLayout stickerFrameLayout2 = new StickerFrameLayout(getContext());
                    this.mPopupEmo = stickerFrameLayout2;
                    stickerFrameLayout2.setTag(emoticonInfo);
                    URLImageView uRLImageView3 = new URLImageView(getContext());
                    this.mPopupEmoImage = uRLImageView3;
                    uRLImageView3.setAdjustViewBounds(false);
                    this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    IPanelInteractionListener iPanelInteractionListener2 = this.mInteractionListener;
                    if (iPanelInteractionListener2 != null && iPanelInteractionListener2.isShowEmoTitleInPreview(emoticonInfo, this.showDescribeInPreview)) {
                        addEmoTitleLayout(emoticonInfo, f16);
                    } else {
                        this.mPopupEmo.addView(this.mPopupEmoImage);
                        this.mEmoTitleTv = null;
                        this.mArrowImageView = null;
                    }
                    this.mWindowContent.addView(this.mPopupEmo);
                }
                TextView textView2 = this.mEmoTitleTv;
                if (textView2 != null) {
                    textView2.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(emoticonInfo));
                }
            }
            if (this.mPopupEmo == null) {
                return;
            }
            if (!(emoticonInfo instanceof FavoriteEmoticonInfo) && !(emoticonInfo instanceof AIEmoticonInfo)) {
                this.mPopupEmoImage.setImageDrawable(drawable);
            } else {
                Option option = emoticonInfo.getOption();
                if (option != null) {
                    option.setTargetView(this.mPopupEmoImage);
                    ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).loadPic(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emoticonview.am
                        @Override // com.tencent.libra.listener.IPicLoadStateListener
                        public final void onStateChange(LoadState loadState, Option option2) {
                            QQEmoticonPanelLinearLayoutHelper.lambda$showPopupEmo$0(loadState, option2);
                        }
                    });
                }
            }
            int i36 = (int) (5.0f * f16);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mPopupEmoImage.getLayoutParams();
            if (i29 != 1 && i29 != 2 && i29 != 7 && i29 != 10) {
                this.mPopupEmo.setBackgroundResource(R.drawable.o4c);
                this.mPopupEmo.setPadding(i36, i36, i36, i36);
                layoutParams.bottomMargin = 0;
                int i37 = (int) (100.0f * f16);
                layoutParams.width = i37;
                layoutParams.height = i37;
                ReportController.o(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
                i18 = (int) (f16 * 110.0f);
                i17 = i18;
            } else {
                IPanelInteractionListener iPanelInteractionListener3 = this.mInteractionListener;
                if (iPanelInteractionListener3 != null && iPanelInteractionListener3.isShowEmoTitleInPreview(emoticonInfo, this.showDescribeInPreview)) {
                    i16 = (int) (81.0f * f16);
                    i3 = (int) (92.0f * f16);
                    int i38 = (int) (30.0f * f16);
                    layoutParams.width = i38;
                    layoutParams.height = i38;
                    if (this.mShowEmoRlyt != null && (textView = this.mEmoTitleTv) != null && this.mArrowImageView != null) {
                        textView.setVisibility(0);
                        this.mArrowImageView.setVisibility(0);
                        this.mShowEmoRlyt.setBackgroundResource(R.drawable.j6o);
                        if (QLog.isColorLevel()) {
                            QLog.d("EmotionPanelLinearLayout", 4, "emo title is visible");
                        }
                    }
                } else {
                    i3 = (int) (71.0f * f16);
                    int i39 = (int) (28.0f * f16);
                    layoutParams.width = i39;
                    layoutParams.height = i39;
                    this.mPopupEmo.setPadding(i36, i36, i36, i36);
                    this.mPopupEmo.setBackgroundResource(R.drawable.o4d);
                    i16 = (int) (64.0f * f16);
                }
                layoutParams.bottomMargin = (int) (4.0f * f16);
                layoutParams.addRule(14);
                layoutParams.addRule(15);
                i17 = i3;
                i18 = i16;
            }
            if (this.mRootView != null && !this.isDiyEmotion && this.stickerMode && ((IEmosmService) QRoute.api(IEmosmService.class)).getEmojiStickerSwitch(this.mSessionType)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mPopupEmo.getLayoutParams();
                if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
                    i26 = (tmp.right - i18) - getNavigateWidth();
                } else {
                    i26 = tmp.right - i18;
                }
                IPanelInteractionListener iPanelInteractionListener4 = this.mInteractionListener;
                if (iPanelInteractionListener4 != null && iPanelInteractionListener4.isShowEmoTitleInPreview(emoticonInfo, this.showDescribeInPreview)) {
                    updatePopupEmoLayout(i18, marginLayoutParams);
                } else if (i26 < 0) {
                    Rect rect = tmp;
                    marginLayoutParams.leftMargin = (rect.left - ((i18 - rect.width()) / 2)) - (i26 / 2);
                } else {
                    Rect rect2 = tmp;
                    marginLayoutParams.leftMargin = rect2.left - ((i18 - rect2.width()) / 2);
                }
                marginLayoutParams.topMargin = (tmp.top - i17) - ((int) (15.0f * f16));
                marginLayoutParams.width = i18;
                marginLayoutParams.height = i17;
                updateArrowLayout(view, f16, i18, i17, marginLayoutParams);
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPopupEmo.getLayoutParams();
                layoutParams2.gravity = 51;
                if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
                    Rect rect3 = tmp;
                    width = (rect3.left + i18) - ((int) this.screenWidth);
                    i19 = (rect3.right - i18) - getNavigateWidth();
                } else {
                    width = (tmp.left + i18) - this.mCurrentView.getWidth();
                    i19 = tmp.right - i18;
                }
                IPanelInteractionListener iPanelInteractionListener5 = this.mInteractionListener;
                if (iPanelInteractionListener5 != null && iPanelInteractionListener5.isShowEmoTitleInPreview(emoticonInfo, this.showDescribeInPreview)) {
                    updatePopupEmoLayout(i18, layoutParams2);
                } else if (width > 0) {
                    Rect rect4 = tmp;
                    layoutParams2.leftMargin = (rect4.left - ((i18 - rect4.width()) / 2)) - (width / 2);
                } else if (i19 < 0) {
                    Rect rect5 = tmp;
                    layoutParams2.leftMargin = (rect5.left - ((i18 - rect5.width()) / 2)) - (i19 / 2);
                } else {
                    Rect rect6 = tmp;
                    layoutParams2.leftMargin = rect6.left - ((i18 - rect6.width()) / 2);
                }
                layoutParams2.topMargin = (tmp.top - i17) - ImmersiveUtils.getStatusBarHeight(view.getContext());
                layoutParams2.width = i18;
                layoutParams2.height = i17;
                updateArrowLayout(view, f16, i18, i17, layoutParams2);
            }
            if (this.showing) {
                this.mPopupEmo.requestLayout();
            } else if (this.mWindowContent != null) {
                PopupWindow popupWindow = this.mPopupWindow;
                if (popupWindow != null && popupWindow.isShowing()) {
                    this.mPopupWindow.dismiss();
                }
                if (!this.mCurrentView.isAttachedToWindow()) {
                    QLog.w("EmotionPanelLinearLayout", 1, "[popupFullScreen] not attach View, return.");
                    return;
                }
                try {
                    this.mPopupWindow = popupFullScreen(this.context, this.mWindowContent, new ColorDrawable(0));
                    this.haveRemovedWindowContent = false;
                    this.showing = true;
                } catch (Throwable th5) {
                    QLog.e("EmotionPanelLinearLayout", 1, "[popupFullScreen] error. stack=", th5);
                    return;
                }
            }
            EmoticonInfo emoticonInfo2 = this.mPointInfo;
            this.mPointInfo = emoticonInfo;
            if (emoticonInfo2 != null && emoticonInfo2.type == 6 && (emoticonInfo2 instanceof PicEmoticonInfo) && (audioPlayer = this.player) != null) {
                audioPlayer.stop();
            }
            int i46 = -1;
            if (emoticonInfo.type == 6 && z16 && (drawable instanceof URLDrawable)) {
                PicEmoticonInfo picEmoticonInfo2 = (PicEmoticonInfo) emoticonInfo;
                if (picEmoticonInfo2.isSound()) {
                    String replace = MarketFaceConstants.emoticonSoundPath.replace("[epId]", picEmoticonInfo2.emoticon.epId).replace("[eId]", picEmoticonInfo2.emoticon.eId);
                    if (this.player == null) {
                        this.player = new AudioPlayer(getContext(), null);
                    }
                    this.player.C(5);
                    this.player.u(replace);
                    EmotionUtils.startSoundDrawablePlay((URLDrawable) drawable);
                }
                Emoticon emoticon = picEmoticonInfo2.emoticon;
                if (2 == emoticon.jobType) {
                    ReportController.o(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, emoticon.epId, "", "", "");
                }
                if (picEmoticonInfo2.isNewSoundType()) {
                    Emoticon emoticon2 = picEmoticonInfo2.emoticon;
                    if (emoticon2 != null) {
                        str = emoticon2.epId;
                    } else {
                        str = "";
                    }
                    EmoticonOperateReport.reportNewSoundEvent(null, "0X800A938", -1, str);
                }
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                if (BaseApplication.getContext() != null && (waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null)) != null && (waitAppRuntime instanceof BaseQQAppInterface)) {
                    BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) waitAppRuntime;
                    if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(systemAndEmojiEmoticonInfo.code)) {
                        IPanelInteractionListener iPanelInteractionListener6 = this.mInteractionListener;
                        if (iPanelInteractionListener6 != null) {
                            i46 = iPanelInteractionListener6.getCurType();
                        }
                        fd.a(baseQQAppInterface, "cmshow", "Apollo", "0X800812D", i46, 0, String.valueOf(systemAndEmojiEmoticonInfo.code), "0");
                    }
                }
            }
            EmoticonCallback emoticonCallback = this.callback;
            if (emoticonCallback != null) {
                emoticonCallback.onShowPopup(emoticonInfo2, emoticonInfo, drawable);
                return;
            }
            return;
        }
        QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
    }

    public void showStickerMaskOnPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.mInteractionListener);
        if (emoticonMainPanel == null) {
            return;
        }
        if (emoticonMainPanel.stickerMaskLayout == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setBackgroundColor(-1);
            linearLayout.getBackground().setAlpha(0);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            emoticonMainPanel.stickerMaskLayout = linearLayout;
        }
        if (emoticonMainPanel.stickerMaskLayout.getParent() != emoticonMainPanel) {
            emoticonMainPanel.addView(emoticonMainPanel.stickerMaskLayout);
        }
        ObjectAnimator.ofPropertyValuesHolder(emoticonMainPanel.stickerMaskLayout.getBackground(), PropertyValuesHolder.ofInt(com.tencent.luggage.wxa.c8.c.f123400v, 0, 178)).setDuration(500L).start();
    }
}
