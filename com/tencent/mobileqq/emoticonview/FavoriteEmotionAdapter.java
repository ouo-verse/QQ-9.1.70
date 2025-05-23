package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavoriteEmotionAdapter extends BaseEmotionAdapter implements IEmotionPanelDataCallback<EmotionPanelData>, View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTENT_HEIGHT = 61;
    public static final int ERROR_ICON_HEIGHT_OFFSET = 5;
    public static final int IMG_HEIGHT = 56;
    private static final String LOTTIE_MAGIC_FACE_DICE_EMO_ID = "358";
    private static final int LOTTIE_MAGIC_FACE_FORCE_UPDATE_COLUMN_NUM_LIMIT = 5;
    private static final String MAGIC_FACE_DICE_PACKAGE_ID = "11464";
    private static final String MMKV_KEY_LOTTIE_MAGIC_FACE_RED_DOT_ENABLE = "lottie_magic_face_red_dot_enable";
    private static final String MMKV_KEY_LOTTIE_MAGIC_FACE_USER_GUIDE_ENABLE = "lottie_magic_face_user_guide_enable";
    public static final String TAG = "FavoriteEmotionAdapter";
    private List<EmotionPanelData> emotionFilterList;
    private Drawable mFavPanelFailedDrawable;
    private IPanelInteractionListener mInteractionListener;
    public IEmoticonPanelLinearLayoutHelper.OnClickListener mInterceptListener;
    private boolean mIsSVipUser;
    private boolean mNeedForceUpdateLottieMagicFaceRedDot;
    private boolean mViewFromLottieMagicFaceUserGuide;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class FavoriteEmotionViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        RelativeLayout[] contentViews;

        public FavoriteEmotionViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public FavoriteEmotionAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
            return;
        }
        this.mNeedForceUpdateLottieMagicFaceRedDot = false;
        this.mViewFromLottieMagicFaceUserGuide = false;
        this.mFavPanelFailedDrawable = null;
        this.emotionFilterList = new ArrayList();
        this.mInterceptListener = new IEmoticonPanelLinearLayoutHelper.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FavoriteEmotionAdapter.this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper.OnClickListener
            public boolean shouldInterceptClickEvent(View view, EmoticonInfo emoticonInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) emoticonInfo)).booleanValue();
                }
                if (emoticonInfo != null && view != null && TextUtils.isEmpty(emoticonInfo.action)) {
                    String roamingType = FavoriteEmotionAdapter.this.getRoamingType(emoticonInfo);
                    int emoId = FavoriteEmotionAdapter.this.getEmoId(emoticonInfo);
                    if (!roamingType.equals("needUpload") && !roamingType.equals("needDel")) {
                        if (roamingType.equals("failed")) {
                            List<CustomEmotionData> emoticonDataList = ((FavroamingDBManagerServiceProxy) FavoriteEmotionAdapter.this.app.getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
                            if (emoticonDataList != null && emoticonDataList.size() > 0) {
                                for (CustomEmotionData customEmotionData : emoticonDataList) {
                                    int i18 = customEmotionData.emoId;
                                    if (i18 == emoId) {
                                        QLog.d(FavoriteEmotionAdapter.TAG, 1, "resend, emoId:", Integer.valueOf(i18));
                                        String str = customEmotionData.emoOriginalPath;
                                        if (str != null && !com.tencent.mobileqq.emosm.favroaming.f.a(str)) {
                                            ((FavEmoRoamingHandlerProxy) FavoriteEmotionAdapter.this.app.getBusinessHandler(FavEmoRoamingHandler.f194632e)).notifyUI(2, true, 1);
                                        } else {
                                            customEmotionData.RomaingType = "needUpload";
                                            FavoriteEmotionAdapter.this.setRoamingType(emoticonInfo, "needUpload");
                                            ((FavEmoRoamingHandlerProxy) FavoriteEmotionAdapter.this.app.getBusinessHandler(FavEmoRoamingHandler.f194632e)).notifyUI(2, true, null);
                                            CameraEmoAllSend.S = false;
                                            ThreadManagerV2.excute(new FavEmoSingleSend(customEmotionData, true), 64, null, false);
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
                        URLImageView uRLImageView2 = (URLImageView) view.findViewById(R.id.f6295328);
                        if (uRLImageView.getDrawable() instanceof URLDrawable) {
                            URLDrawable uRLDrawable = (URLDrawable) uRLImageView.getDrawable();
                            if (uRLDrawable.getStatus() != 3 && uRLDrawable.getStatus() != 2) {
                                if (uRLDrawable.getStatus() == 0) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i(FavoriteEmotionAdapter.TAG, 2, "now  favorite EmoticonInfo loading " + emoticonInfo.toString());
                                    }
                                    return true;
                                }
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.i(FavoriteEmotionAdapter.TAG, 2, "now  favorite EmoticonInfo loading failed, restart download " + emoticonInfo.toString());
                                }
                                uRLImageView.setVisibility(8);
                                uRLImageView2.setVisibility(0);
                                uRLDrawable.restartDownload();
                                if (!(uRLImageView2.getDrawable() instanceof Animatable)) {
                                    Animatable animatable = (Animatable) BaseApplication.getContext().getResources().getDrawable(R.drawable.f160545jt);
                                    uRLImageView2.setImageDrawable((Drawable) animatable);
                                    animatable.start();
                                } else {
                                    ((Animatable) uRLImageView2.getDrawable()).start();
                                }
                                return true;
                            }
                        }
                        if (!(emoticonInfo instanceof FavoriteLottieEmoticonInfo)) {
                            FavoriteEmotionAdapter favoriteEmotionAdapter = FavoriteEmotionAdapter.this;
                            if (favoriteEmotionAdapter.handleSvipOverTime(favoriteEmotionAdapter.getEmoticonInfoDataIndex(emoticonInfo))) {
                                QLog.d(FavoriteEmotionAdapter.TAG, 1, "svip overtime, not click");
                                FavoriteEmotionAdapter.this.showPaySvipDialog(view.getContext());
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
        };
        this.mInteractionListener = iPanelInteractionListener;
        this.mFavPanelFailedDrawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.njj);
        this.mIsSVipUser = VasUtil.getSignedService(iEmoticonMainPanelApp.getAppRuntime()).getVipStatus().isSVip();
    }

    private List<EmotionPanelData> filterEmotionPanelData(List<EmotionPanelData> list) {
        List<EmotionPanelData> list2 = this.emotionFilterList;
        if (list2 != null && !list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (EmotionPanelData emotionPanelData : list) {
                if (!isInEmotionFilterList(emotionPanelData)) {
                    arrayList.add(emotionPanelData);
                }
            }
            return arrayList;
        }
        return list;
    }

    private String getClickedTodayKey() {
        return "emoji_svip_pay_click" + new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date()) + this.app.getAppRuntime().getCurrentUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEmoId(EmoticonInfo emoticonInfo) {
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            return ((FavoriteEmoticonInfo) emoticonInfo).emoId;
        }
        if (emoticonInfo instanceof PicEmoticonInfo) {
            return ((PicEmoticonInfo) emoticonInfo).emoId;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getEmoticonInfoDataIndex(EmoticonInfo emoticonInfo) {
        List<EmotionPanelData> list = this.data;
        if (list != null && emoticonInfo != null) {
            return list.indexOf(emoticonInfo);
        }
        return 0;
    }

    private RelativeLayout getFavouriteView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setGravity(17);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int) (this.density * 61.0f)));
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setId(R.id.f915355f);
        float f16 = this.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f16 * 56.0f), (int) (f16 * 56.0f));
        layoutParams.addRule(13, -1);
        layoutParams.addRule(12, -1);
        layoutParams.setMargins(0, 0, 0, (int) (this.density * 5.0f));
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        uRLImageView.setAdjustViewBounds(false);
        relativeLayout.addView(uRLImageView, layoutParams);
        URLImageView uRLImageView2 = new URLImageView(this.mContext);
        uRLImageView2.setId(R.id.f165068lg0);
        float f17 = this.density;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f17 * 56.0f), (int) (f17 * 56.0f));
        layoutParams2.addRule(13, -1);
        layoutParams2.addRule(12, -1);
        layoutParams2.setMargins(0, 0, 0, (int) (this.density * 5.0f));
        uRLImageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        uRLImageView2.setAdjustViewBounds(false);
        relativeLayout.addView(uRLImageView2, layoutParams2);
        URLImageView uRLImageView3 = new URLImageView(this.mContext);
        uRLImageView3.setId(R.id.f6295328);
        float f18 = this.density;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (f18 * 56.0f), (int) (f18 * 56.0f));
        layoutParams3.addRule(13, -1);
        layoutParams3.addRule(12, -1);
        layoutParams3.setMargins(0, 0, 0, (int) (this.density * 5.0f));
        uRLImageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        uRLImageView3.setAdjustViewBounds(false);
        uRLImageView3.setVisibility(8);
        relativeLayout.addView(uRLImageView3, layoutParams3);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.mContext);
        relativeLayout2.setId(R.id.f165139c32);
        relativeLayout2.setVisibility(8);
        relativeLayout2.setBackgroundResource(R.drawable.skin_tips_newmessage);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0f), ViewUtils.dip2px(9.0f));
        layoutParams4.addRule(3, R.id.f915355f);
        layoutParams4.addRule(7, R.id.f915355f);
        layoutParams4.addRule(6, R.id.f915355f);
        relativeLayout.addView(relativeLayout2, layoutParams4);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setId(R.id.lg6);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        imageView.setBackgroundResource(R.drawable.njg);
        layoutParams5.addRule(7, R.id.f915355f);
        layoutParams5.addRule(8, R.id.f915355f);
        float f19 = this.density;
        layoutParams5.setMargins(0, 0, (int) (f19 * (-5.0f)), (int) (f19 * (-5.0f)));
        relativeLayout.addView(imageView, layoutParams5);
        ImageView imageView2 = new ImageView(this.mContext);
        imageView2.setId(R.id.f629732_);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(7, R.id.f915355f);
        layoutParams6.addRule(8, R.id.f915355f);
        relativeLayout.addView(imageView2, layoutParams6);
        if (AppSetting.f99565y) {
            relativeLayout.setFocusable(true);
        }
        return relativeLayout;
    }

    private String getLottieMagicFaceRedDotMMKVKey() {
        String str;
        IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
        if (iEmoticonMainPanelApp != null) {
            str = iEmoticonMainPanelApp.getCurrentAccountUin();
        } else {
            str = "";
        }
        return str + "_" + MMKV_KEY_LOTTIE_MAGIC_FACE_RED_DOT_ENABLE;
    }

    private String getLottieMagicFaceUserGuideMMKVKey() {
        String str;
        IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
        if (iEmoticonMainPanelApp != null) {
            str = iEmoticonMainPanelApp.getCurrentAccountUin();
        } else {
            str = "";
        }
        return str + "_" + MMKV_KEY_LOTTIE_MAGIC_FACE_USER_GUIDE_ENABLE;
    }

    private int getPaySvipBannerPos() {
        List<EmotionPanelData> list = this.data;
        if (list != null && handleSvipOverTime(list.size() - 1) && !isClickedToday() && VasNormalToggle.AIO_EMOJI_SVIP_PAY.isEnable(true)) {
            return (int) Math.ceil(502.0f / this.columnNum);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRoamingType(EmoticonInfo emoticonInfo) {
        String str;
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            str = ((FavoriteEmoticonInfo) emoticonInfo).roamingType;
        } else if (!(emoticonInfo instanceof PicEmoticonInfo)) {
            str = "isUpdate";
        } else {
            str = ((PicEmoticonInfo) emoticonInfo).roamingType;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "getRoamingType return null, " + emoticonInfo.toString());
            return "isUpdate";
        }
        return str;
    }

    private RelativeLayout getSvipPayView() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.h8o, (ViewGroup) null);
        ((RoundImageView) relativeLayout.findViewById(R.id.f9102542)).setImageDrawable(URLDrawable.getDrawable("https://tianquan.gtimg.cn/shoal/vaclient/cc746e41-d390-408c-aa6b-419e38a4432f.png"));
        relativeLayout.setVisibility(8);
        relativeLayout.setFocusable(true);
        relativeLayout.setFocusableInTouchMode(true);
        setSvipPayViewClick(relativeLayout, true);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleSvipOverTime(int i3) {
        if (!this.mIsSVipUser && i3 >= 502) {
            return true;
        }
        return false;
    }

    private boolean isClickedToday() {
        return !TextUtils.isEmpty(VasMMKV.getChatBg(this.mContext, "vas_emoji_vip").getString(getClickedTodayKey(), ""));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isInEmotionFilterList(EmotionPanelData emotionPanelData) {
        if (!(emotionPanelData instanceof IFavoriteEmoticonInfo)) {
            return false;
        }
        IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) emotionPanelData;
        for (Parcelable parcelable : this.emotionFilterList) {
            if (parcelable instanceof IFavoriteEmoticonInfo) {
                IFavoriteEmoticonInfo iFavoriteEmoticonInfo2 = (IFavoriteEmoticonInfo) parcelable;
                if (!TextUtils.isEmpty(iFavoriteEmoticonInfo2.getEid())) {
                    if (TextUtils.equals(iFavoriteEmoticonInfo.getEid(), iFavoriteEmoticonInfo2.getEid())) {
                        return true;
                    }
                } else if (iFavoriteEmoticonInfo.getType() == iFavoriteEmoticonInfo2.getType()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSvipPayViewClick$1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d(TAG, 1, "emoji click pay vip");
        Context context = this.mContext;
        VasH5PayUtil.openClubPay(context, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", context.getString(R.string.f173184hu3), "");
        setClickedToday();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void setClickedToday() {
        VasMMKV.getChatBg(this.mContext, "vas_emoji_vip").edit().putString(getClickedTodayKey(), "1").apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoamingType(EmoticonInfo emoticonInfo, String str) {
        if (emoticonInfo instanceof FavoriteEmoticonInfo) {
            ((FavoriteEmoticonInfo) emoticonInfo).roamingType = str;
        } else if (emoticonInfo instanceof PicEmoticonInfo) {
            ((PicEmoticonInfo) emoticonInfo).roamingType = str;
        }
    }

    private void setSvipPayViewClick(View view, boolean z16) {
        View.OnClickListener onClickListener;
        if (!z16) {
            onClickListener = null;
        } else {
            onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FavoriteEmotionAdapter.this.lambda$setSvipPayViewClick$1(view2);
                }
            };
        }
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPaySvipDialog(Context context) {
        DialogUtil.createCustomDialog(context, 0, HardCodeUtil.qqStr(R.string.zup), HardCodeUtil.qqStr(R.string.zur), R.string.ax8, R.string.zuq, new DialogInterface.OnClickListener(context) { // from class: com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context val$context;

            {
                this.val$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FavoriteEmotionAdapter.this, (Object) context);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                QLog.e(FavoriteEmotionAdapter.TAG, 1, "click pay for handleOverSizeOpenSvip");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Context context2 = this.val$context;
                VasH5PayUtil.openClubPay(context2, "mvip.n.a.bqsc_ql", 3, "1450000516", "CJCLUBT", context2.getString(R.string.f173184hu3), "");
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FavoriteEmotionAdapter.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmoticonDrawable(ImageView imageView, URLImageView uRLImageView) {
        if (imageView.getDrawable() instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) imageView.getDrawable();
            if (uRLDrawable.getStatus() == 0) {
                imageView.setVisibility(8);
                uRLImageView.setVisibility(0);
                if (!uRLDrawable.isDownloadStarted()) {
                    uRLDrawable.startDownload();
                }
                if (!(uRLImageView.getDrawable() instanceof Animatable)) {
                    uRLImageView.setImageDrawable((Drawable) ((Animatable) BaseApplication.getContext().getResources().getDrawable(R.drawable.f160545jt)));
                }
                Animatable animatable = (Animatable) uRLImageView.getDrawable();
                if (!animatable.isRunning()) {
                    animatable.start();
                    return;
                }
                return;
            }
            if (uRLDrawable.getStatus() != 2 && uRLDrawable.getStatus() != 3) {
                imageView.setVisibility(0);
                uRLImageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(8);
            uRLImageView.setVisibility(0);
            if (uRLImageView.getDrawable() instanceof Animatable) {
                ((Animatable) uRLImageView.getDrawable()).stop();
            }
            uRLImageView.setImageDrawable(this.mFavPanelFailedDrawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateUI(View view, EmotionPanelData emotionPanelData) {
        boolean z16;
        if (view != null && (emotionPanelData instanceof EmoticonInfo)) {
            EmoticonInfo emoticonInfo = (EmoticonInfo) emotionPanelData;
            view.setTag(emoticonInfo);
            view.setVisibility(0);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f165139c32);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
            Object tag = uRLImageView.getTag(R.id.kxb);
            if (tag == emoticonInfo) {
                if ((tag instanceof FavoriteLottieEmoticonInfo) && this.mNeedForceUpdateLottieMagicFaceRedDot) {
                    this.mNeedForceUpdateLottieMagicFaceRedDot = false;
                } else {
                    return;
                }
            }
            uRLImageView.setTag(R.id.kxb, emotionPanelData);
            URLImageView uRLImageView2 = (URLImageView) view.findViewById(R.id.f165068lg0);
            URLImageView uRLImageView3 = (URLImageView) view.findViewById(R.id.f6295328);
            ImageView imageView = (ImageView) view.findViewById(R.id.lg6);
            uRLImageView.setVisibility(0);
            Drawable drawable = uRLImageView.getDrawable();
            if (drawable instanceof URLDrawable) {
                ((URLDrawable) drawable).setURLDrawableListener(null);
            }
            String str = emoticonInfo.action;
            if (EmoticonInfo.FAV_EDIT_ACTION.equals(str)) {
                uRLImageView.setImageDrawable(null);
                uRLImageView.setImageResource(R.drawable.l0n);
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                uRLImageView3.setVisibility(8);
                imageView.setVisibility(8);
                uRLImageView2.setVisibility(8);
                if (AppSetting.f99565y) {
                    uRLImageView.setContentDescription(this.mContext.getString(R.string.f209085eg));
                }
            } else if ("funny_pic".equals(str)) {
                uRLImageView.setImageDrawable(null);
                uRLImageView.setImageResource(R.drawable.l0k);
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                uRLImageView3.setVisibility(8);
                imageView.setVisibility(8);
                uRLImageView2.setVisibility(8);
                if (AppSetting.f99565y) {
                    uRLImageView.setContentDescription(this.mContext.getString(R.string.f209475fi));
                }
            } else {
                Context context = this.mContext;
                float f16 = this.density;
                Drawable zoomDrawable = emoticonInfo.getZoomDrawable(context, f16, (int) (f16 * 56.0f), (int) (56.0f * f16));
                uRLImageView.setImageDrawable(zoomDrawable);
                if (AppSetting.f99565y) {
                    uRLImageView.setContentDescription(((IFavroamingManagerService) this.app.getAppRuntime().getRuntimeService(IFavroamingManagerService.class, "")).getAccessibilityDescription(Integer.valueOf(emoticonInfo.emoId)));
                }
                String roamingType = getRoamingType(emoticonInfo);
                if (roamingType.equals("needUpload")) {
                    uRLImageView2.setImageDrawable(new ColorDrawable(-419430401));
                    uRLImageView2.setVisibility(0);
                    Animatable animatable = (Animatable) BaseApplication.getContext().getResources().getDrawable(R.drawable.f160545jt);
                    uRLImageView3.setImageDrawable((Drawable) animatable);
                    animatable.start();
                    uRLImageView3.setVisibility(0);
                    imageView.setVisibility(8);
                } else if (roamingType.equals("failed")) {
                    uRLImageView2.setImageDrawable(new ColorDrawable(-419430401));
                    uRLImageView3.setVisibility(8);
                    imageView.setVisibility(0);
                    uRLImageView2.setVisibility(0);
                } else {
                    uRLImageView3.setVisibility(4);
                    imageView.setVisibility(4);
                    uRLImageView2.setVisibility(8);
                    if (zoomDrawable instanceof URLDrawable) {
                        URLDrawable uRLDrawable = (URLDrawable) zoomDrawable;
                        if (this.mViewFromLottieMagicFaceUserGuide && (emoticonInfo instanceof FavoriteLottieEmoticonInfo) && TextUtils.equals(((FavoriteLottieEmoticonInfo) emoticonInfo).getEid(), LOTTIE_MAGIC_FACE_DICE_EMO_ID) && QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(getLottieMagicFaceRedDotMMKVKey(), true)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        uRLDrawable.setURLDrawableListener(new URLDrawable.URLDrawableListener(z16, relativeLayout, uRLImageView, uRLImageView3, emoticonInfo) { // from class: com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ URLImageView val$emoticonImg;
                            final /* synthetic */ EmoticonInfo val$emotionInfo;
                            final /* synthetic */ boolean val$needShowLottieMagicFaceRedDot;
                            final /* synthetic */ URLImageView val$progressView;
                            final /* synthetic */ RelativeLayout val$redLayout;

                            {
                                this.val$needShowLottieMagicFaceRedDot = z16;
                                this.val$redLayout = relativeLayout;
                                this.val$emoticonImg = uRLImageView;
                                this.val$progressView = uRLImageView3;
                                this.val$emotionInfo = emoticonInfo;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, FavoriteEmotionAdapter.this, Boolean.valueOf(z16), relativeLayout, uRLImageView, uRLImageView3, emoticonInfo);
                                }
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadCanceled(URLDrawable uRLDrawable2) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable2);
                                    return;
                                }
                                QLog.e(FavoriteEmotionAdapter.TAG, 1, "onLoadFailed: " + this.val$emotionInfo.toString());
                                FavoriteEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadFialed(URLDrawable uRLDrawable2, Throwable th5) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable2, (Object) th5);
                                    return;
                                }
                                QLog.e(FavoriteEmotionAdapter.TAG, 1, "onLoadFailed: " + this.val$emotionInfo.toString());
                                FavoriteEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadProgressed(URLDrawable uRLDrawable2, int i3) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                                    FavoriteEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                                } else {
                                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable2, i3);
                                }
                            }

                            @Override // com.tencent.image.URLDrawable.URLDrawableListener
                            public void onLoadSuccessed(URLDrawable uRLDrawable2) {
                                RelativeLayout relativeLayout2;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable2);
                                    return;
                                }
                                if (this.val$needShowLottieMagicFaceRedDot && (relativeLayout2 = this.val$redLayout) != null) {
                                    relativeLayout2.setVisibility(0);
                                }
                                FavoriteEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                            }
                        });
                        updateEmoticonDrawable(uRLImageView, uRLImageView3);
                        if (z16 && uRLDrawable.getStatus() == 1 && relativeLayout != null) {
                            relativeLayout.setVisibility(0);
                        }
                    }
                    if (!TextUtils.isEmpty(emoticonInfo.getName())) {
                        uRLImageView.setContentDescription(this.mContext.getString(R.string.f209045ec) + emoticonInfo.getName());
                    } else {
                        uRLImageView.setContentDescription(this.mContext.getString(R.string.f209055ed));
                    }
                }
            }
            if (!(emoticonInfo instanceof FavoriteLottieEmoticonInfo) && handleSvipOverTime(getEmoticonInfoDataIndex(emoticonInfo))) {
                uRLImageView2.setImageDrawable(new ColorDrawable(-419430401));
                uRLImageView2.setVisibility(0);
            }
            ImageView imageView2 = (ImageView) view.findViewById(R.id.f629732_);
            if (emoticonInfo instanceof PicEmoticonInfo) {
                PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) emoticonInfo;
                if (picEmoticonInfo.isSound()) {
                    if (picEmoticonInfo.isNewSoundType()) {
                        imageView2.setImageResource(R.drawable.bft);
                    } else {
                        imageView2.setImageResource(R.drawable.h29);
                    }
                    imageView2.setVisibility(0);
                    return;
                }
                imageView2.setVisibility(8);
                return;
            }
            imageView2.setVisibility(8);
            return;
        }
        QLog.e(TAG, 1, "emotionInfo or contentView = null");
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback
    public void callbackInMainThread(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else if (list != null) {
            setData(filterEmotionPanelData(list));
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int count = super.getCount();
        if (getPaySvipBannerPos() > 0) {
            return count + 1;
        }
        return count;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        int i16;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        FavoriteEmotionViewHolder favoriteEmotionViewHolder = (FavoriteEmotionViewHolder) viewHolder;
        View view3 = view;
        if (view == null) {
            View view4 = EmotionPanelViewPool.getInstance().getView(this.panelType);
            if (view4 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + "; view from inflater");
                }
                EmoticonPanelLinearLayout emoticonPanelLinearLayout = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.mInteractionListener), -1);
                emoticonPanelLinearLayout.setPanelType(3);
                emoticonPanelLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                emoticonPanelLinearLayout.setOrientation(0);
                if (i3 == 0) {
                    emoticonPanelLinearLayout.setPadding(0, (int) (this.density * 16.0f), 0, 0);
                } else {
                    emoticonPanelLinearLayout.setPadding(0, (int) (this.density * 14.0f), 0, 0);
                }
                for (int i17 = 0; i17 < this.columnNum; i17++) {
                    RelativeLayout favouriteView = getFavouriteView();
                    favouriteView.setVisibility(8);
                    favouriteView.setFocusable(true);
                    favouriteView.setFocusableInTouchMode(true);
                    emoticonPanelLinearLayout.addView(favouriteView);
                }
                emoticonPanelLinearLayout.addView(getSvipPayView());
                emoticonPanelLinearLayout.setInterceptListener(this.mInterceptListener);
                view2 = emoticonPanelLinearLayout;
            } else {
                view2 = view4;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + "; view from cache");
                    view2 = view4;
                }
            }
            ((EmoticonPanelLinearLayout) view2).setCallBack(this.callback);
            recycleView(this.panelType, view2);
            ViewGroup viewGroup2 = (ViewGroup) view2;
            favoriteEmotionViewHolder.contentViews = new RelativeLayout[this.columnNum + 1];
            for (int i18 = 0; i18 < this.columnNum + 1; i18++) {
                favoriteEmotionViewHolder.contentViews[i18] = (RelativeLayout) viewGroup2.getChildAt(i18);
            }
            view2.setTag(favoriteEmotionViewHolder);
            view3 = view2;
        }
        if (i3 == getPaySvipBannerPos()) {
            int i19 = 0;
            while (true) {
                i16 = this.columnNum;
                if (i19 >= i16) {
                    break;
                }
                favoriteEmotionViewHolder.contentViews[i19].setVisibility(8);
                i19++;
            }
            RelativeLayout relativeLayout = favoriteEmotionViewHolder.contentViews[i16];
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                setSvipPayViewClick(relativeLayout, true);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView show SvipBanner");
                }
            }
        } else {
            RelativeLayout relativeLayout2 = favoriteEmotionViewHolder.contentViews[this.columnNum];
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                setSvipPayViewClick(relativeLayout2, false);
            }
            if (getPaySvipBannerPos() > 0 && i3 > getPaySvipBannerPos()) {
                i3--;
            }
            int i26 = 0;
            while (true) {
                int i27 = this.columnNum;
                if (i26 >= i27) {
                    break;
                }
                final int i28 = (i27 * i3) + i26;
                if (i28 > this.data.size() - 1) {
                    favoriteEmotionViewHolder.contentViews[i26].setTag(null);
                    favoriteEmotionViewHolder.contentViews[i26].setVisibility(8);
                } else {
                    final RelativeLayout relativeLayout3 = favoriteEmotionViewHolder.contentViews[i26];
                    updateUI(relativeLayout3, this.data.get(i28));
                    IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
                    if (iPanelInteractionListener != null && iPanelInteractionListener.isInAio()) {
                        relativeLayout3.setOnClickListener(this);
                        relativeLayout3.setClickable(false);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.al
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmoticonReportDtHelper.bindFavoriteEmotionView(relativeLayout3, i28);
                            }
                        }, 16, null, false);
                    }
                }
                i26++;
            }
        }
        return view3;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new FavoriteEmotionViewHolder();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "FavoriteEmotionAdapter itemView onClicked");
            }
            Object tag = view.getTag();
            if (tag instanceof PicEmoticonInfo) {
                PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) tag;
                if (picEmoticonInfo.getImageJobType() == 2 || picEmoticonInfo.getImageJobType() == 4) {
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                    Context context = view.getContext();
                    if (TextUtils.equals(picEmoticonInfo.getEpid(), MAGIC_FACE_DICE_PACKAGE_ID) && from.decodeBool(getLottieMagicFaceUserGuideMMKVKey(), true)) {
                        List<EmotionPanelData> list = this.data;
                        if (list.get(list.size() - 1) instanceof FavoriteLottieEmoticonInfo) {
                            from.encodeBool(getLottieMagicFaceUserGuideMMKVKey(), false);
                            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(context, 230).setTitle(context.getString(R.string.m77)).setMessage(R.string.f209235ev).setPositiveButton(R.string.f209225eu, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.3
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FavoriteEmotionAdapter.this);
                                    }
                                }

                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                                        return;
                                    }
                                    EmotionPanelListView currentListView = FavoriteEmotionAdapter.this.getCurrentListView();
                                    if (currentListView != null) {
                                        FavoriteEmotionAdapter.this.mViewFromLottieMagicFaceUserGuide = true;
                                        FavoriteEmotionAdapter favoriteEmotionAdapter = FavoriteEmotionAdapter.this;
                                        if (favoriteEmotionAdapter.columnNum <= 5) {
                                            favoriteEmotionAdapter.mNeedForceUpdateLottieMagicFaceRedDot = true;
                                            FavoriteEmotionAdapter.this.notifyDataSetChanged();
                                        }
                                        currentListView.setSelection(FavoriteEmotionAdapter.this.getCount() - 1);
                                    }
                                }
                            });
                            positiveButton.setCanceledOnTouchOutside(true);
                            positiveButton.show();
                        }
                    }
                    QQToast.makeText(context, R.string.f209255ex, 0).show();
                }
            } else if (tag instanceof FavoriteLottieEmoticonInfo) {
                View findViewById = view.findViewById(R.id.f165139c32);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                this.mViewFromLottieMagicFaceUserGuide = false;
                QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(getLottieMagicFaceRedDotMMKVKey(), false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void refreshPanelData() {
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshPanelData");
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null) {
            i3 = iPanelInteractionListener.getCurType();
        } else {
            i3 = -1;
        }
        int i16 = i3;
        IPanelInteractionListener iPanelInteractionListener2 = this.mInteractionListener;
        if (iPanelInteractionListener2 != null && !iPanelInteractionListener2.needShowFavAndFunnyPicIcon()) {
            z16 = false;
        } else {
            z16 = true;
        }
        IPanelInteractionListener iPanelInteractionListener3 = this.mInteractionListener;
        if (iPanelInteractionListener3 != null && !iPanelInteractionListener3.canShowGif()) {
            z17 = false;
        } else {
            z17 = true;
        }
        EmotionPanelDataBuilder.getInstance().asyncGetEmotionPanelData(this.app, this.panelType, null, i16, 0, false, this, z16, z17);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter
    public void setData(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            super.setData(list);
            ((IFavroamingManagerService) this.app.getAppRuntime().getRuntimeService(IFavroamingManagerService.class, "")).cacheAccessibilityEmotionData();
        }
    }

    public void setEmotionFilterList(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        } else {
            this.emotionFilterList = list;
        }
    }
}
