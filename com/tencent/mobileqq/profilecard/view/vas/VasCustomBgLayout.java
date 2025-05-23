package com.tencent.mobileqq.profilecard.view.vas;

import QQService.EVIPSPEC;
import QQService.PrivilegeInfo;
import SummaryCardTaf.SSummaryCardRsp;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.luggage.wxa.gf.y;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.ProfilePersonalityLabelInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.profilecard.view.vas.bean.VasCustomBgJson;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qqlive.module.videoreport.storage.util.GsonObjectCoder;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.view.FilterEnum;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VasCustomBgLayout extends RelativeLayout implements IVasCustomBgView, GravitySensor.GravitySensorListener {
    private static final long ANIM_DELAY = 1500;
    private static final long ANIM_LONG_DURATION = 1000;
    private static final long ANIM_PART_DURATION = 500;
    private static final float ANIM_RATIO = 1.5f;
    private static final float ANIM_ROTATE_MAX_BIG = 5.0f;
    private static final float ANIM_ROTATE_MAX_HEAD = 10.0f;
    private static final float ANIM_ROTATE_MAX_SMALL = 5.0f;
    private static final float ANIM_TRANSLATION_MAX_BIG = 50.0f;
    private static final float ANIM_TRANSLATION_MAX_SMALL = 80.0f;
    private static final float CONFIG_BASE_HEIGHT = 1650.0f;
    private static final float CONFIG_BASE_WIDTH = 750.0f;
    private static final int DEFAULT_AVATAR_WIDTH = 640;
    private static final String DEFAULT_SLOGAN = "\u70b9\u51fb\u7f16\u8f91\u6211\u7684\u4e2a\u6027\u7b7e\u540d";
    private static final int ICON_DEFAULT_DENSITY = 500;
    private static final int NAME_BLANK_START = 81;
    private static final int NAME_MARGIN_TOP = 91;
    private static final int NAME_MARGIN_TOP_FIRST_LINE = 24;
    private static final int SET_STYLE_AND_BGW_AIT_TIME = 30000;
    private static final String TAG = "VasCustomBgLayout";
    private static final int UI_MSG_SAVE_CARD_RESULT = 13;
    private boolean isAnimated;
    private boolean isCharacterAdded;
    private boolean isIconAdded;
    private boolean isPagBgAdded;
    private boolean isSloganEmpty;
    private boolean isTextAroundBackAdded;
    private boolean isTextAroundFrontAdded;
    private final QQAppInterface mApp;
    private AvatarLayout mAvatarLayout;
    private ImageView mAvatarPendant;
    private ViewGroup mBigIconAnimLayout;
    private ProfileCardInfo mCardInfo;
    private final Map<Rect, View> mClickMap;
    private long mCurrentBgId;
    private long mCurrentStyleId;
    private Runnable mDismissRunnable;
    private GravitySensor mGravitySensor;
    private ViewGroup mHeadAnimLayout;
    private TextView mName;
    private CardObserver mSetCardObserver;
    private QQProgressDialog mSettingDialog;
    private ViewGroup mSmallIconAnimLayout;
    private SurroundView mSurroundBackView;
    private SurroundView mSurroundFrontView;
    private Bitmap mTextSurroundBitmap;
    private Handler.Callback mUICallback;
    private final WeakReferenceHandler mUIHandler;
    private RelativeLayout rootView;
    private VasCustomBgJson vasCustomBgJson;

    public VasCustomBgLayout(Context context) {
        super(context);
        this.mDismissRunnable = new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.e
            @Override // java.lang.Runnable
            public final void run() {
                VasCustomBgLayout.this.dismissDialog();
            }
        };
        this.mClickMap = new HashMap();
        this.mUICallback = new Handler.Callback() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 13) {
                    if (((Boolean) message.obj).booleanValue()) {
                        if (VasCustomBgLayout.this.mApp == null) {
                            return true;
                        }
                        AllInOne allInOne = new AllInOne(VasCustomBgLayout.this.mApp.getCurrentAccountUin(), 0);
                        allInOne.nickname = VasCustomBgLayout.this.mApp.getCurrentNickname();
                        allInOne.lastActivity = 1;
                        allInOne.profileEntryType = 5;
                        if (VasCustomBgLayout.this.mCardInfo != null && !VasCustomBgLayout.this.mCardInfo.allInOne.uin.equals(VasCustomBgLayout.this.mApp.getCurrentAccountUin())) {
                            ProfileUtils.openProfileCard(BaseApplication.getContext(), allInOne, false);
                        }
                    } else {
                        QQToast.makeText(VasCustomBgLayout.this.getContext().getApplicationContext(), R.string.d3z, 0).show();
                    }
                }
                return true;
            }
        };
        this.mSetCardObserver = new CardObserver() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.11
            @Override // com.tencent.mobileqq.app.CardObserver
            public void onSetCardTemplateReturn(boolean z16, Object obj) {
                try {
                    if (!((Activity) VasCustomBgLayout.this.getContext()).isFinishing()) {
                        VasCustomBgLayout.this.mUIHandler.removeCallbacks(VasCustomBgLayout.this.mDismissRunnable);
                        VasCustomBgLayout.this.dismissDialog();
                        if (z16 && obj != null) {
                            if (obj instanceof Card) {
                                final Card card = (Card) obj;
                                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        WeakReferenceHandler weakReferenceHandler = VasCustomBgLayout.this.mUIHandler;
                                        if (weakReferenceHandler == null) {
                                            return;
                                        }
                                        VasCustomBgLayout vasCustomBgLayout = VasCustomBgLayout.this;
                                        Card card2 = card;
                                        weakReferenceHandler.sendMessage(weakReferenceHandler.obtainMessage(13, Boolean.valueOf(vasCustomBgLayout.saveCardId2DB((int) card2.lCurrentStyleId, (int) card2.lCurrentBgId, card2.backgroundUrl, (int) card2.backgroundColor, card2.templateRet, card2.diyComplicatedInfo, card2.cardId))));
                                    }
                                }, 5, null, true);
                            } else if (obj instanceof Pair) {
                                SSummaryCardRsp sSummaryCardRsp = (SSummaryCardRsp) ((Pair) obj).second;
                                if (TextUtils.isEmpty(sSummaryCardRsp.strActiveCardUrl)) {
                                    VasCustomBgLayout.this.enterPersonalityCardMall();
                                } else {
                                    ProfileCardUtil.H(VasCustomBgLayout.this.getContext(), sSummaryCardRsp.bgid, sSummaryCardRsp.strActiveCardUrl);
                                }
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        initView(context);
        this.mApp = (QQAppInterface) ((QBaseActivity) getContext()).getAppRuntime();
        this.mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    }

    private void addAnimationListener(final ActionSheet actionSheet) {
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.10
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (VasCustomBgLayout.this.mApp == null) {
                    return;
                }
                if (i3 == 0) {
                    ReportController.o(VasCustomBgLayout.this.mApp, "dc00898", "", "", "", "0X8009E3A", 3, 0, "", "", "", "");
                    VasCustomBgLayout.this.handleDiyBackground();
                } else if (i3 == 1) {
                    ReportController.o(VasCustomBgLayout.this.mApp, "dc00898", "", "", "", "0X8009E3B", 3, 0, "", "", "", "");
                    VasCustomBgLayout.this.enterPersonalityCardMall();
                }
                actionSheet.superDismiss();
            }
        });
    }

    private void addAvatarAndPendant() {
        boolean z16 = false;
        View c16 = this.mAvatarLayout.c(0);
        if (c16 instanceof QQProAvatarView) {
            boolean isPaTypeHasUin = ProfilePAUtils.isPaTypeHasUin(this.mCardInfo.allInOne);
            e.a m3 = new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(this.mCardInfo.allInOne.uin)).b(true).j(true).p(7).c(true).m(7);
            if (isPaTypeHasUin && !SimpleUIUtil.isNowSimpleMode()) {
                z16 = true;
            }
            ((QQProAvatarView) c16).x(1, this.mCardInfo.allInOne.uin, m3.d(z16).n(1).o(3).g(640).a());
            return;
        }
        this.mAvatarLayout.setFaceDrawable(this.mApp, 1, this.mCardInfo.allInOne.uin, 640, true, true, true, false, 7);
        if (ProfilePAUtils.isPaTypeHasUin(this.mCardInfo.allInOne)) {
            final String str = this.mCardInfo.allInOne.uin;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    final NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(VasCustomBgLayout.this.mCardInfo.allInOne.uin), VasCustomBgLayout.TAG);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NTVasSimpleInfo nTVasSimpleInfo = vasSimpleInfoWithUid;
                            if (nTVasSimpleInfo != null && nTVasSimpleInfo.pendantId != 0) {
                                VasCustomBgLayout.this.mAvatarPendant.setVisibility(0);
                                NTVasSimpleInfo nTVasSimpleInfo2 = vasSimpleInfoWithUid;
                                long j3 = nTVasSimpleInfo2.pendantId;
                                int i3 = nTVasSimpleInfo2.pendantDiyId;
                                com.tencent.mobileqq.vas.b bVar = (com.tencent.mobileqq.vas.b) VasCustomBgLayout.this.mApp.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
                                if (bVar != null) {
                                    bVar.getPendantInfo(j3).setDrawable(VasCustomBgLayout.this.mAvatarPendant, 2, PendantConstant.PENDANT_TARGET_ID_CARD_XINCHUN, str, i3);
                                    return;
                                }
                                return;
                            }
                            VasCustomBgLayout.this.mAvatarPendant.setVisibility(4);
                        }
                    });
                }
            }, 8, null, true);
        }
    }

    private View addDiamondsView(VasCustomBgJson.DiamondsBean diamondsBean, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        linearLayout.setBackground(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(getExtraDir() + diamondsBean.getRes()).a());
        linearLayout.setRotation(diamondsBean.getRotate());
        linearLayout.addView(view, new ViewGroup.LayoutParams(adjustPosX(diamondsBean.getIconSize().get(0).intValue()), adjustPosY(diamondsBean.getIconSize().get(1).intValue())));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adjustPosX(diamondsBean.getContentSize().get(0).intValue()), adjustPosY(diamondsBean.getContentSize().get(1).intValue()));
        layoutParams.leftMargin = adjustPosX(diamondsBean.getCenter().get(0).intValue() - (diamondsBean.getContentSize().get(0).intValue() / 2));
        layoutParams.topMargin = adjustPosY(diamondsBean.getCenter().get(1).intValue() - (diamondsBean.getContentSize().get(1).intValue() / 2));
        viewGroup.addView(linearLayout, layoutParams);
        this.mClickMap.put(getRectByPos(diamondsBean), view);
        return linearLayout;
    }

    private void addGameplate() {
        Card card = this.mCardInfo.card;
        boolean isVipOpen = card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
        IGameCardManager.a aVar = new IGameCardManager.a(card.uin, card.namePlateOfKingGameId, card.namePlateOfKingDan, card.namePlateOfKingDanDisplatSwitch, card.gameCardId);
        aVar.f312733a = IGameCardManager.CARD;
        if (VipGrayConfigHelper.getsInstance().showNamePlateOfKing(aVar.f312734b, isVipOpen, card.namePlateOfKingLoginTime, aVar.f312737e, aVar.f312738f)) {
            VasCustomBgJson.DiamondsBean gameplate = this.vasCustomBgJson.getGameplate();
            URLImageView uRLImageView = new URLImageView(getContext());
            addDiamondsView(gameplate, uRLImageView, this.mBigIconAnimLayout);
            VipGrayConfigHelper.getsInstance().updateNamePlateOfKingIconView(uRLImageView, isVipOpen, card.namePlateOfKingLoginTime, aVar);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mark_type", 1);
                MobileReportManager.getInstance().reportAction("mark_sticker", "4", "DressVip", "user_data_card", "display_area", 101, 0, System.currentTimeMillis(), jSONObject.toString());
            } catch (Exception e16) {
                QLog.e(TAG, 2, " report exception " + e16);
            }
        }
    }

    private synchronized void addIcons() {
        if (this.isIconAdded) {
            return;
        }
        this.mBigIconAnimLayout = new RelativeLayout(getContext());
        this.mSmallIconAnimLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.rootView.addView(this.mBigIconAnimLayout, layoutParams);
        this.rootView.addView(this.mSmallIconAnimLayout, layoutParams);
        List<VasCustomBgJson.DiamondsBean> diamonds = this.vasCustomBgJson.getDiamonds();
        List<PrivilegeInfo> privilegeOpenInfo = this.mCardInfo.card.getPrivilegeOpenInfo();
        if (privilegeOpenInfo != null && !privilegeOpenInfo.isEmpty() && diamonds != null && !diamonds.isEmpty()) {
            int i3 = 0;
            for (PrivilegeInfo privilegeInfo : orderInfoList(privilegeOpenInfo)) {
                if (i3 >= diamonds.size()) {
                    break;
                }
                ImageView imageView = new ImageView(getContext());
                imageView.setImageDrawable(getIconDrawable(privilegeInfo));
                imageView.setTag(privilegeInfo);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Object tag = view.getTag();
                        if (tag instanceof PrivilegeInfo) {
                            PrivilegeInfo privilegeInfo2 = (PrivilegeInfo) tag;
                            VasCustomBgLayout.this.goIconWebPage(privilegeInfo2);
                            VasCustomBgLayout.this.reportIconClick(privilegeInfo2);
                        }
                    }
                });
                if (i3 != 0 && i3 != 4 && i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8 && i3 != 12) {
                    addDiamondsView(diamonds.get(i3), imageView, this.mSmallIconAnimLayout);
                    reportIconExpose(privilegeInfo);
                    i3++;
                }
                addDiamondsView(diamonds.get(i3), imageView, this.mBigIconAnimLayout);
                reportIconExpose(privilegeInfo);
                i3++;
            }
        }
        addNameplate();
        addGameplate();
        this.isIconAdded = true;
    }

    private synchronized void addPagBg() {
        if (this.isPagBgAdded) {
            return;
        }
        View view = new View(getContext());
        addView(view, 0, new ViewGroup.LayoutParams(-1, -1));
        this.isPagBgAdded = true;
        addStaticBg(view);
    }

    private void addStaticBg(View view) {
        String str;
        if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
            str = getExtraDir() + this.vasCustomBgJson.getBg().getResNight();
        } else {
            str = getExtraDir() + this.vasCustomBgJson.getBg().getRes();
        }
        view.setBackground(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStaticCharacter(View view) {
        view.setBackground(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(getExtraDir() + this.vasCustomBgJson.getAvatar().getRes()).a());
    }

    private void addSurroundTextView(Boolean bool) {
        SurroundView surroundView = new SurroundView(getContext(), null, bool.booleanValue());
        updateSurroundText(surroundView);
        int i3 = AppSetting.t(getContext()) ? 400 : FilterEnum.MIC_PTU_TRANS_XINXIAN;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adjustPosX(600), adjustPosY(i3));
        layoutParams.leftMargin = adjustPosX(75);
        int i16 = i3 / 2;
        int i17 = 890 - i16;
        layoutParams.topMargin = adjustPosY(i17);
        this.rootView.addView(surroundView, layoutParams);
        if (bool.booleanValue()) {
            this.mSurroundFrontView = surroundView;
            surroundView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VasCustomBgLayout.this.mTextSurroundBitmap = null;
                    int i18 = 0;
                    VasCustomBgLayout.this.isTextAroundFrontAdded = false;
                    ProfileSignatureUtils.handleSignatureClick(VasCustomBgLayout.this.mCardInfo, (QBaseActivity) VasCustomBgLayout.this.getContext(), VasCustomBgLayout.this.mApp);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!VasCustomBgLayout.this.isSloganEmpty) {
                            i18 = 1;
                        }
                        jSONObject.put("sign_status", i18);
                        MobileReportManager.getInstance().reportAction("sign", "4", "DressVip", "user_data_card", "display_area", 102, 0, System.currentTimeMillis(), jSONObject.toString());
                    } catch (Exception e16) {
                        QLog.e(VasCustomBgLayout.TAG, 2, " report exception " + e16);
                    }
                }
            });
            this.mClickMap.put(new Rect(adjustPosX(225), adjustPosY(i17), adjustPosX(525), adjustPosY(y.CTRL_INDEX)), this.mSurroundFrontView);
        } else {
            this.mSurroundBackView = surroundView;
            surroundView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VasCustomBgLayout.this.mTextSurroundBitmap = null;
                    boolean z16 = false;
                    VasCustomBgLayout.this.isTextAroundBackAdded = false;
                    ProfilePersonalityLabelInfo profilePersonalityLabelInfo = VasCustomBgLayout.this.mCardInfo != null ? (ProfilePersonalityLabelInfo) VasCustomBgLayout.this.mCardInfo.getBusinessInfo(ProfilePersonalityLabelInfo.class) : null;
                    if (profilePersonalityLabelInfo == null || profilePersonalityLabelInfo.personalityLabelInfos.size() == 0) {
                        if (VasCustomBgLayout.this.mCardInfo != null && VasCustomBgLayout.this.mCardInfo.allInOne != null && VasCustomBgLayout.this.mCardInfo.allInOne.f260789pa == 0) {
                            z16 = true;
                        }
                        if (z16) {
                            ProfileCardUtil.k0(VasCustomBgLayout.this.mApp.getCurrentAccountUin(), VasCustomBgLayout.this.mApp, (Activity) VasCustomBgLayout.this.getContext(), true);
                            return;
                        }
                        return;
                    }
                    VasCustomBgLayout.this.jump2LabelGallery();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("label_num", VasCustomBgLayout.this.getLabelInfos().size());
                        MobileReportManager.getInstance().reportAction("label", "4", "DressVip", "user_data_card", "display_area", 102, 0, System.currentTimeMillis(), jSONObject.toString());
                    } catch (Exception e16) {
                        QLog.e(VasCustomBgLayout.TAG, 2, " report exception " + e16);
                    }
                }
            });
            this.mClickMap.put(new Rect(adjustPosX(225), adjustPosY(y.CTRL_INDEX), adjustPosX(525), adjustPosY(i16 + y.CTRL_INDEX)), this.mSurroundBackView);
        }
    }

    private void addViews() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null || this.vasCustomBgJson == null) {
            return;
        }
        try {
            addPagBg();
            addAvatarAndPendant();
            addName(this.mCardInfo);
            addIcons();
            updateTextAround(Boolean.FALSE);
            addCharacter();
            updateTextAround(Boolean.TRUE);
            if (!isLowPerfDevice()) {
                playAnimation();
            }
            reportPageExpose();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "VasCustomBgLayout err , msg:" + th5.getMessage());
        }
    }

    private int adjustPosX(int i3) {
        float f16;
        int screenWidth;
        if (AppSetting.t(getContext())) {
            screenWidth = ViewUtils.getScreenWidth();
            if (getParent() != null && ((View) getParent()).getMeasuredWidth() != 0) {
                screenWidth = ((View) getParent()).getMeasuredWidth();
            }
            f16 = i3 / CONFIG_BASE_WIDTH;
        } else {
            f16 = i3 / CONFIG_BASE_WIDTH;
            screenWidth = ViewUtils.getScreenWidth();
        }
        return (int) (f16 * screenWidth);
    }

    private int adjustPosY(int i3) {
        float f16;
        int screenWidth;
        if (AppSetting.t(getContext())) {
            screenWidth = ViewUtils.getScreenHeight();
            if (getParent() != null && ((View) getParent()).getMeasuredHeight() != 0) {
                screenWidth = ((View) getParent()).getMeasuredHeight();
            }
            f16 = i3 / CONFIG_BASE_HEIGHT;
        } else {
            f16 = i3 / CONFIG_BASE_WIDTH;
            screenWidth = ViewUtils.getScreenWidth();
        }
        return (int) (f16 * screenWidth);
    }

    private void animateLayoutByGravity(float f16) {
        ViewGroup viewGroup = this.mHeadAnimLayout;
        if (viewGroup == null || this.mSmallIconAnimLayout == null || this.mBigIconAnimLayout == null) {
            return;
        }
        viewGroup.setRotationY(10.0f * f16 * 1.5f);
        float f17 = 5.0f * f16 * 1.5f;
        this.mSmallIconAnimLayout.setRotationY(f17);
        this.mSmallIconAnimLayout.setTranslationX(ANIM_TRANSLATION_MAX_SMALL * f16 * 1.5f);
        this.mBigIconAnimLayout.setRotationY(f17);
        this.mBigIconAnimLayout.setTranslationX(f16 * 50.0f * 1.5f);
    }

    private void delegateTouch() {
        View findViewById;
        View findViewById2 = ((Activity) getContext()).findViewById(android.R.id.content);
        if (findViewById2 == null || (findViewById = findViewById2.findViewById(R.id.dkn)) == null) {
            return;
        }
        findViewById.setOnClickListener(null);
        Rect rect = new Rect();
        findViewById.getHitRect(rect);
        if (rect.isEmpty()) {
            return;
        }
        findViewById.setTouchDelegate(new TouchDelegate(rect, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        QQProgressDialog qQProgressDialog = this.mSettingDialog;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.mSettingDialog.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.mSettingDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableGravity() {
        if (this.mGravitySensor == null) {
            this.mGravitySensor = new GravitySensor();
        }
        this.mGravitySensor.init(getContext());
        this.mGravitySensor.addListener(this);
    }

    private void fetchNameByProfileCardInfo(ProfileCardInfo profileCardInfo) {
        String str;
        if (profileCardInfo.card != null) {
            fetchTroopMemberName(profileCardInfo);
            return;
        }
        ContactCard contactCard = profileCardInfo.contactCard;
        if (contactCard != null) {
            str = contactCard.nickName;
        } else {
            str = "";
        }
        lambda$fetchTroopMemberName$0(str);
    }

    private void fetchTroopMemberName(ProfileCardInfo profileCardInfo) {
        final Card card = profileCardInfo.card;
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(profileCardInfo.troopUin, card.uin, false, getContext() instanceof LifecycleOwner ? (LifecycleOwner) getContext() : null, TAG, new g() { // from class: com.tencent.mobileqq.profilecard.view.vas.c
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                VasCustomBgLayout.this.lambda$fetchTroopMemberName$1(card, troopMemberInfo);
            }
        });
    }

    private String getExtraDir() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo != null && profileCardInfo.card != null) {
            return ProfileCardManager.t(null, this.mCardInfo.card.lCurrentBgId) + ".extra" + File.separator;
        }
        return "";
    }

    private URLDrawable getIconDrawable(PrivilegeInfo privilegeInfo) {
        String str;
        if (TextUtils.isEmpty(privilegeInfo.strDeluxeIconUrl)) {
            str = privilegeInfo.strIconUrl;
        } else {
            str = privilegeInfo.strDeluxeIconUrl;
        }
        URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(str, VasApngUtil.VIP_APNG_TAGS, new ColorDrawable(0));
        if (apngURLDrawable != null) {
            if (apngURLDrawable.getStatus() == 2) {
                apngURLDrawable.restartDownload();
            }
            if (!TextUtils.isEmpty(privilegeInfo.strTipsIconUrl) && (apngURLDrawable.getCurrDrawable() instanceof ApngDrawable)) {
                ApngImage image = ((ApngDrawable) apngURLDrawable.getCurrDrawable()).getImage();
                image.apngLoop = privilegeInfo.iTipsTimes;
                image.setDensity(500);
            }
        } else {
            QLog.e(TAG, 1, "apn drawable get null!iconUrl:" + str);
        }
        return apngURLDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PersonalityLabelInfo> getLabelInfos() {
        List<PersonalityLabelInfo> list;
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) this.mCardInfo.getBusinessInfo(ProfilePersonalityLabelInfo.class);
        return (profilePersonalityLabelInfo == null || (list = profilePersonalityLabelInfo.personalityLabelInfos) == null || list.isEmpty()) ? new ArrayList() : list;
    }

    private Rect getRectByPos(VasCustomBgJson.DiamondsBean diamondsBean) {
        int adjustPosX = adjustPosX(diamondsBean.getCenter().get(0).intValue() - (diamondsBean.getIconSize().get(0).intValue() / 2));
        int adjustPosY = adjustPosY(diamondsBean.getCenter().get(1).intValue() - (diamondsBean.getIconSize().get(1).intValue() / 2));
        return new Rect(adjustPosX, adjustPosY, adjustPosX(diamondsBean.getContentSize().get(0).intValue()) + adjustPosX, adjustPosY(diamondsBean.getContentSize().get(1).intValue()) + adjustPosY);
    }

    private String getUserLabel() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<PersonalityLabelInfo> it = getLabelInfos().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().text);
            sb5.append(" ");
        }
        boolean z16 = this.mCardInfo.allInOne.f260789pa == 0;
        if (TextUtils.isEmpty(sb5.toString()) && z16) {
            sb5.append("\u70b9\u51fb\u8bbe\u7f6e\u6211\u7684\u6807\u7b7e");
        }
        return sb5.toString();
    }

    private String getUserSlogan() {
        RichStatus richStatus = RichStatusUtils.INSTANCE.getRichStatus(this.mCardInfo.card);
        SpannableString spannableString = richStatus != null ? new SpannableString(richStatus.toSpannableStringWithTopic(null, 0, 0, null)) : null;
        if (spannableString == null) {
            spannableString = new SpannableString("");
        }
        String spannableString2 = spannableString.toString();
        return (TextUtils.isEmpty(spannableString2) && (this.mCardInfo.allInOne.f260789pa == 0)) ? DEFAULT_SLOGAN : spannableString2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goIconWebPage(PrivilegeInfo privilegeInfo) {
        String buildTraceDetailUrl;
        String str = privilegeInfo.strJumpUrl;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mCardInfo.allInOne.f260789pa == 0) {
            buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(str, IVipTraceDetailReport.FROM.PROFILECARD_SINGLE_DIAMOND);
        } else {
            buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(str, IVipTraceDetailReport.FROM.PROFILECARD_SINGLE_DIAMOND_GUEST);
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(getContext(), buildTraceDetailUrl);
            return;
        }
        Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", buildTraceDetailUrl);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        getContext().startActivity(intent);
    }

    private void handleClick() {
        if (this.mCardInfo.allInOne.f260789pa != 0) {
            try {
                String string = getContext().getString(R.string.g3u);
                ReportController.o(this.mApp, "dc00898", "", "", "", "0X800A4C0", 3, 0, "", "", "", "");
                ActionSheet create = ActionSheet.create(getContext());
                create.addButton(R.string.g8z, 1);
                create.addButton(string, 1);
                create.addButton(R.string.cancel, 1);
                addAnimationListener(create);
                create.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.hhf, (ViewGroup) this, true);
        AvatarLayout avatarLayout = (AvatarLayout) findViewById(R.id.xmk);
        this.mAvatarLayout = avatarLayout;
        avatarLayout.d(0, avatarLayout.findViewById(R.id.f164585t51), true);
        this.mAvatarPendant = (ImageView) findViewById(R.id.xj7);
        this.mHeadAnimLayout = (ViewGroup) findViewById(R.id.f165677x81);
    }

    private boolean isLowPerfDevice() {
        return Build.VERSION.SDK_INT < 26 && VasToggle.VAS_PROFILE_CARD_SPRING_COMPAT.isEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jump2LabelGallery() {
        Intent intent = new Intent(getContext(), (Class<?>) PersonalityLabelGalleryActivity.class);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
        String str = this.mCardInfo.allInOne.uin;
        intent.putExtra("uin", str);
        if (!TextUtils.equals(str, this.mApp.getCurrentAccountUin()) && !TextUtils.isEmpty(ProfileNameUtils.getCurCardName(this.mCardInfo))) {
            intent.putExtra("nickname", ProfileNameUtils.getCurCardName(this.mCardInfo));
        }
        ((Activity) getContext()).startActivityForResult(intent, 1029);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateNameLayout$2() {
        int lineCount = this.mName.getLineCount();
        int dip2px = ViewUtils.dip2px(91.0f);
        if (lineCount == 1) {
            dip2px += ViewUtils.dip2px(24.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mHeadAnimLayout.getLayoutParams();
        if (layoutParams.topMargin != dip2px) {
            layoutParams.topMargin = dip2px;
            this.mHeadAnimLayout.setLayoutParams(layoutParams);
        }
    }

    private List<PrivilegeInfo> orderInfoList(List<PrivilegeInfo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            PrivilegeInfo privilegeInfo = list.get(i3);
            if (privilegeInfo.iIsBig == 1) {
                arrayList2.add(privilegeInfo);
            } else {
                arrayList3.add(privilegeInfo);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    private void parseJsonToViewBean() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null || this.vasCustomBgJson != null) {
            return;
        }
        File file = new File(getExtraDir() + "config.json");
        if (file.exists()) {
            try {
                this.vasCustomBgJson = (VasCustomBgJson) new GsonObjectCoder().decode(FileUtils.readFileToStringEx(file, -1), VasCustomBgJson.class);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "VasCustomBgLayout err , msg:" + th5.getMessage());
                return;
            }
        }
        if (!VasToggle.VAS_PROFILE_CARD_CUSTOM_RETRY.isEnable(false) || this.mCardInfo.card.lCurrentBgId <= 0) {
            return;
        }
        ((ao) this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.j(this.mApp, VasUpdateConstants.SCID_CARD_PREFIX + this.mCardInfo.card.lCurrentBgId);
        QLog.e(TAG, 1, "VasCustomBgLayout parseJsonToViewBean download" + this.mCardInfo.card.lCurrentBgId);
    }

    private synchronized void playAnimation() {
        if (this.isAnimated) {
            return;
        }
        AnimatorSet createRoateAnimatorSet = createRoateAnimatorSet(this.mHeadAnimLayout, 10.0f);
        AnimatorSet createRoateAnimatorSet2 = createRoateAnimatorSet(this.mSmallIconAnimLayout, 5.0f);
        AnimatorSet createTranslationAnimatorSet = createTranslationAnimatorSet(this.mSmallIconAnimLayout, ANIM_TRANSLATION_MAX_SMALL);
        AnimatorSet createRoateAnimatorSet3 = createRoateAnimatorSet(this.mBigIconAnimLayout, 5.0f);
        AnimatorSet createTranslationAnimatorSet2 = createTranslationAnimatorSet(this.mBigIconAnimLayout, 50.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createRoateAnimatorSet).with(createRoateAnimatorSet3).with(createTranslationAnimatorSet2).with(createRoateAnimatorSet2).with(createTranslationAnimatorSet);
        animatorSet.setStartDelay(1500L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VasCustomBgLayout.this.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VasCustomBgLayout.this.enableGravity();
                    }
                }, 500L);
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
        animatorSet.start();
        this.isAnimated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportIconClick(PrivilegeInfo privilegeInfo) {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null || this.vasCustomBgJson == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mark_type", privilegeInfo.iType);
            MobileReportManager.getInstance().reportAction("mark_sticker", "4", "DressVip", "user_data_card", "display_area", 102, 0, System.currentTimeMillis(), jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 2, " report exception " + e16);
        }
    }

    private void reportIconExpose(PrivilegeInfo privilegeInfo) {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null || this.vasCustomBgJson == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mark_type", privilegeInfo.iType);
            MobileReportManager.getInstance().reportAction("mark_sticker", "4", "DressVip", "user_data_card", "display_area", 101, 0, System.currentTimeMillis(), jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 2, " report exception " + e16);
        }
    }

    private void reportPageExpose() {
        ProfileCardInfo profileCardInfo = this.mCardInfo;
        if (profileCardInfo == null || profileCardInfo.card == null || this.vasCustomBgJson == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("item_id", this.mCardInfo.card.lCurrentBgId);
            jSONObject.put("item_type", 3001008);
            jSONObject.put("set_status", this.mCardInfo.card.cardId);
            List<PrivilegeInfo> privilegeOpenInfo = this.mCardInfo.card.getPrivilegeOpenInfo();
            jSONObject.put("mark_num", (privilegeOpenInfo == null || privilegeOpenInfo.isEmpty()) ? 0 : privilegeOpenInfo.size());
            String str = "novip";
            Card card = this.mCardInfo.card;
            if (card.bQQVipOpen == 1) {
                str = "vip";
            } else if (card.bSuperVipOpen == 1) {
                str = "svip";
            }
            jSONObject.put("user_tag", str);
            jSONObject.put("vip_level", this.mCardInfo.card.iSuperVipLevel);
            MobileReportManager.getInstance().reportAction("", "", "DressVip", "user_data_card", "", 101, 0, System.currentTimeMillis(), jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 2, " report exception " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveCardId2DB(long j3, int i3, String str, int i16, int i17, String str2, long j16) {
        FriendsManager friendsManager = (FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card r16 = friendsManager.r(this.mApp.getCurrentAccountUin());
        if (r16 == null || j3 < 0) {
            return false;
        }
        r16.lCurrentStyleId = j3;
        r16.lCurrentBgId = i3;
        r16.strCurrentBgUrl = str;
        r16.backgroundColor = i16;
        r16.templateRet = i17;
        r16.cardId = j16;
        if (TextUtils.isEmpty(r16.diyComplicatedInfo)) {
            r16.diyComplicatedInfo = str2;
        }
        if (friendsManager.p0(r16)) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "save card in db failed ");
        }
        return false;
    }

    private void setupCardInfo(ProfileCardInfo profileCardInfo) {
        Card card;
        if (isCardInfoValid(profileCardInfo)) {
            long j3 = this.mCurrentStyleId;
            Card card2 = profileCardInfo.card;
            if (j3 == card2.lCurrentStyleId && this.mCurrentBgId != card2.lCurrentBgId) {
                destroyViews();
            }
        }
        this.mCardInfo = profileCardInfo;
        if (profileCardInfo == null || (card = profileCardInfo.card) == null) {
            return;
        }
        this.mCurrentStyleId = card.lCurrentStyleId;
        this.mCurrentBgId = card.lCurrentBgId;
    }

    private void showProgressDialog() {
        try {
            if (((Activity) getContext()).isFinishing()) {
                return;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext());
            this.mSettingDialog = qQProgressDialog;
            qQProgressDialog.setCancelable(false);
            this.mSettingDialog.setMessage(R.string.d3y);
            this.mSettingDialog.show();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateNameLayout, reason: merged with bridge method [inline-methods] */
    public void lambda$fetchTroopMemberName$0(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "updateNameLayout name is empty:" + str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new LeadingMarginSpan.Standard(ViewUtils.dip2px(81.0f), 0), 0, 1, 0);
        this.mName.setText(spannableString);
        this.mName.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.b
            @Override // java.lang.Runnable
            public final void run() {
                VasCustomBgLayout.this.lambda$updateNameLayout$2();
            }
        });
    }

    private void updateSurroundText(SurroundView surroundView) {
        surroundView.setTexture(this.mTextSurroundBitmap, -15.0d, -15.0d, 7000L, Color.parseColor(this.vasCustomBgJson.getColor().getTagBack()));
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public View getAvatarView() {
        return this.mAvatarLayout;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public View getPendantView() {
        return this.mAvatarPendant;
    }

    public void init(ProfileCardInfo profileCardInfo) {
        delegateTouch();
        setupCardInfo(profileCardInfo);
        parseJsonToViewBean();
        addViews();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mApp.removeObserver(this.mSetCardObserver);
        this.mSetCardObserver = null;
        this.mUICallback = null;
        this.mDismissRunnable = null;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public void onPause() {
        GravitySensor gravitySensor = this.mGravitySensor;
        if (gravitySensor != null) {
            gravitySensor.pause();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public void onResume() {
        CardObserver cardObserver;
        QQAppInterface qQAppInterface = this.mApp;
        if (qQAppInterface != null && (cardObserver = this.mSetCardObserver) != null) {
            qQAppInterface.addObserver(cardObserver);
        }
        GravitySensor gravitySensor = this.mGravitySensor;
        if (gravitySensor != null) {
            gravitySensor.resume();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public void onStop() {
        this.mApp.removeObserver(this.mSetCardObserver);
        GravitySensor gravitySensor = this.mGravitySensor;
        if (gravitySensor != null) {
            gravitySensor.destroy();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public void updateData(ProfileCardInfo profileCardInfo) {
        init(profileCardInfo);
    }

    private AnimatorSet createRoateAnimatorSet(View view, float f16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.ROTATION_Y, f16);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.ROTATION_Y, 0.0f - f16);
        ofFloat2.setDuration(1000L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.ROTATION_Y, 0.0f);
        ofFloat3.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private AnimatorSet createTranslationAnimatorSet(View view, float f16) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f16);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f - f16);
        ofFloat2.setDuration(1000L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationX", 0.0f);
        ofFloat3.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private void destroyViews() {
        this.vasCustomBgJson = null;
        this.isAnimated = false;
        this.isIconAdded = false;
        this.isTextAroundBackAdded = false;
        this.isTextAroundFrontAdded = false;
        this.isCharacterAdded = false;
        this.isPagBgAdded = false;
        this.mClickMap.clear();
        GravitySensor gravitySensor = this.mGravitySensor;
        if (gravitySensor != null) {
            gravitySensor.destroy();
        }
        try {
            this.mSurroundBackView = null;
            this.mSurroundFrontView = null;
            removeAllViews();
            initView(getContext());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void setStyleAndBg(long j3, long j16, long j17, String str) {
        dismissDialog();
        showProgressDialog();
        ProfileCardUtil.v0(this.mApp, j3, j16, null, j17, str);
        this.mUIHandler.postDelayed(this.mDismissRunnable, 30000L);
    }

    @Override // com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener
    public void updateGravityData(float[] fArr, boolean z16) {
        animateLayoutByGravity(fArr[0]);
    }

    private synchronized void addCharacter() {
        if (this.isCharacterAdded) {
            return;
        }
        VasPagView vasPagView = new VasPagView(getContext());
        final String str = getExtraDir() + this.vasCustomBgJson.getAvatar().getAnim();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adjustPosX(this.vasCustomBgJson.getAvatar().getContentSize().get(0).intValue()), adjustPosY(this.vasCustomBgJson.getAvatar().getContentSize().get(1).intValue()));
        layoutParams.leftMargin = adjustPosX(this.vasCustomBgJson.getAvatar().getCenter().get(0).intValue() - (this.vasCustomBgJson.getAvatar().getContentSize().get(0).intValue() / 2));
        layoutParams.topMargin = adjustPosY(this.vasCustomBgJson.getAvatar().getCenter().get(1).intValue() - (this.vasCustomBgJson.getAvatar().getContentSize().get(1).intValue() / 2));
        this.rootView.addView(vasPagView, layoutParams);
        this.isCharacterAdded = true;
        if (isLowPerfDevice()) {
            addStaticCharacter(vasPagView);
            return;
        }
        vasPagView.api().setStateChangeListener(new Function1<View, Unit>() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.5
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                if (!(view instanceof PAGView)) {
                    VasCustomBgLayout.this.addStaticCharacter(view);
                }
                return Unit.INSTANCE;
            }
        });
        vasPagView.api().build();
        vasPagView.api().postAction(new Function1<PAGView, Unit>() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.6
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(PAGView pAGView) {
                PAGFile Load = PagViewMonitor.Load(str);
                if (Load == null) {
                    return null;
                }
                if (AppSetting.t(VasCustomBgLayout.this.getContext())) {
                    pAGView.setScaleMode(2);
                } else {
                    pAGView.setScaleMode(3);
                }
                pAGView.setComposition(Load);
                pAGView.setProgress(0.0d);
                pAGView.setRepeatCount(0);
                pAGView.play();
                return null;
            }
        });
        try {
            MobileReportManager.getInstance().reportAction("animation", "4", "DressVip", "user_data_card", "display_area", 101, 0, System.currentTimeMillis(), "");
        } catch (Exception e16) {
            QLog.e(TAG, 2, " report exception " + e16);
        }
    }

    private void addNameplate() {
        final Card card = this.mCardInfo.card;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        linearLayout.setOrientation(0);
        ImageView imageView = new ImageView(getContext());
        ImageView imageView2 = new ImageView(getContext());
        VasCustomBgJson.DiamondsBean nameplate = this.vasCustomBgJson.getNameplate();
        linearLayout.addView(imageView, new ViewGroup.LayoutParams(-2, adjustPosY(nameplate.getIconSize().get(1).intValue())));
        linearLayout.addView(imageView2, new ViewGroup.LayoutParams(-2, adjustPosY(nameplate.getIconSize().get(1).intValue())));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.view.vas.VasCustomBgLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ff.j.a.f((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), card.uin, "VIA_PROFILECARD").onClick(view);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mark_type", 0);
                    MobileReportManager.getInstance().reportAction("mark_sticker", "4", "DressVip", "user_data_card", "display_area", 102, 0, System.currentTimeMillis(), jSONObject.toString());
                } catch (Exception e16) {
                    QLog.e(VasCustomBgLayout.TAG, 2, " report exception " + e16);
                }
            }
        });
        View addDiamondsView = addDiamondsView(nameplate, linearLayout, this.mBigIconAnimLayout);
        com.tencent.mobileqq.vas.image.c icon = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(imageView.getResources(), card.uin, VasInjectApi.getInstance().getVipIconInfo(card));
        if (icon != null) {
            imageView.setImageDrawable(icon);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mark_type", 0);
                MobileReportManager.getInstance().reportAction("mark_sticker", "4", "DressVip", "user_data_card", "display_area", 101, 0, System.currentTimeMillis(), jSONObject.toString());
            } catch (Exception e16) {
                QLog.e(TAG, 2, " report exception " + e16);
            }
        } else {
            imageView.setImageDrawable(null);
            addDiamondsView.setVisibility(4);
            linearLayout.setOnClickListener(null);
        }
        int[] d16 = ff.j.d(this.mApp, card.uin);
        if (!ff.C(d16[0]) && !ff.H(d16[0])) {
            imageView2.setVisibility(8);
        } else {
            ff.j.l(getContext(), imageView2, card.nameplateExtId, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterPersonalityCardMall() {
        if (this.mCardInfo.isTroopMemberCard) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        ProfileCardUtil.F((Activity) getContext(), this.mApp.getCurrentAccountUin(), "inside.friendCardBackground", 1, 1, 1, "", false, 42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDiyBackground() {
        Card card = this.mCardInfo.card;
        setStyleAndBg(card.lCurrentStyleId, card.lCurrentBgId, card.backgroundColor, card.strExtInfo);
        ReportController.o(this.mApp, "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
    }

    private boolean isCardInfoValid(ProfileCardInfo profileCardInfo) {
        Card card;
        return (profileCardInfo == null || (card = profileCardInfo.card) == null || card.lCurrentStyleId == 0 || card.lCurrentBgId == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTroopMemberName$1(Card card, TroopMemberInfo troopMemberInfo) {
        final String str;
        if (troopMemberInfo != null && !TextUtils.isEmpty(troopMemberInfo.troopnick)) {
            str = troopMemberInfo.troopnick;
        } else if (!TextUtils.isEmpty(card.strReMark)) {
            str = card.strReMark;
        } else {
            str = card.strNick;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.view.vas.d
            @Override // java.lang.Runnable
            public final void run() {
                VasCustomBgLayout.this.lambda$fetchTroopMemberName$0(str);
            }
        });
    }

    private synchronized void updateTextAround(Boolean bool) {
        SurroundView surroundView;
        if (bool.booleanValue()) {
            if (this.isTextAroundFrontAdded) {
                return;
            }
        } else if (this.isTextAroundBackAdded) {
            return;
        }
        if (bool.booleanValue()) {
            this.isTextAroundFrontAdded = true;
        } else {
            this.isTextAroundBackAdded = true;
        }
        if (bool.booleanValue()) {
            surroundView = this.mSurroundFrontView;
        } else {
            surroundView = this.mSurroundBackView;
        }
        SurroundView surroundView2 = surroundView;
        if (this.mTextSurroundBitmap == null) {
            SurroundContentView surroundContentView = new SurroundContentView(getContext(), Color.parseColor(this.vasCustomBgJson.getColor().getTagFront()));
            String userSlogan = getUserSlogan();
            this.isSloganEmpty = userSlogan.equals(DEFAULT_SLOGAN);
            surroundContentView.setSloganText(userSlogan);
            surroundContentView.setTagText(getUserLabel());
            try {
                this.mTextSurroundBitmap = getBitmap(surroundContentView);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "getDecorViewBitmap: ", th5);
                com.tencent.mobileqq.multiaio.utils.a.a();
            }
            if (bool.booleanValue()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sign_status", this.isSloganEmpty ? 0 : 1);
                    MobileReportManager.getInstance().reportAction("sign", "4", "DressVip", "user_data_card", "display_area", 101, 0, System.currentTimeMillis(), jSONObject.toString());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("label_num", getLabelInfos().size());
                    MobileReportManager.getInstance().reportAction("label", "4", "DressVip", "user_data_card", "display_area", 101, 0, System.currentTimeMillis(), jSONObject2.toString());
                } catch (Exception e16) {
                    QLog.e(TAG, 2, " report exception " + e16);
                }
            }
        }
        if (this.mTextSurroundBitmap != null) {
            if (surroundView2 != null) {
                updateSurroundText(surroundView2);
                return;
            }
            addSurroundTextView(bool);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (!this.mClickMap.isEmpty()) {
            boolean z17 = true;
            if (motionEvent.getAction() == 1) {
                Iterator<Map.Entry<Rect, View>> it = this.mClickMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<Rect, View> next = it.next();
                    if (next.getKey() != null && next.getKey().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        View value = next.getValue();
                        if (value != null) {
                            value.callOnClick();
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        VasCustomBgJson vasCustomBgJson = this.vasCustomBgJson;
                        if (vasCustomBgJson != null && vasCustomBgJson.getGameplate() != null && next.getKey().equals(getRectByPos(this.vasCustomBgJson.getGameplate()))) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mark_type", 1);
                                MobileReportManager.getInstance().reportAction("mark_sticker", "4", "DressVip", "user_data_card", "display_area", 102, 0, System.currentTimeMillis(), jSONObject.toString());
                            } catch (Exception e16) {
                                QLog.e(TAG, 2, " report exception " + e16);
                            }
                        }
                        z17 = z16;
                    }
                }
                if (z17) {
                    handleClick();
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void addName(ProfileCardInfo profileCardInfo) {
        this.mName = (TextView) findViewById(R.id.f165676x80);
        try {
            if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
                this.mName.setTextColor(Color.parseColor(this.vasCustomBgJson.getColor().getNickNight()));
            } else {
                this.mName.setTextColor(Color.parseColor(this.vasCustomBgJson.getColor().getNick()));
            }
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(this.mName, profileCardInfo.card);
            boolean checkFontExist = FontManagerConstants.checkFontExist(this.vasCustomBgJson.getBg().getNickfont(), 0);
            String tTFPath = FontManagerConstants.getTTFPath(this.vasCustomBgJson.getBg().getNickfont(), 0);
            if (!checkFontExist) {
                Bundle bundle = new Bundle();
                bundle.putInt("id", this.vasCustomBgJson.getBg().getNickfont());
                bundle.putInt("font_type", 0);
                QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.J, bundle, null);
            } else {
                this.mName.setTypeface(Typeface.createFromFile(tTFPath));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        fetchNameByProfileCardInfo(profileCardInfo);
    }

    private Bitmap getBitmap(View view) {
        view.measure(ViewUtils.dip2px(1092.0f), ViewUtils.dip2px(96.0f));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.setBitmap(null);
        return createBitmap;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.IVasCustomBgView
    public View getLayoutView() {
        return this;
    }
}
