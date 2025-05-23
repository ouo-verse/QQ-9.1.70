package com.tencent.mobileqq.profilecard.bussiness.accountinfo.view;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.utils.VasSvipPrivilegeAnimateHelper;
import com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.BaseProfileQQLevelView;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.image.c;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.f;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.mobileqq.widget.ai;
import com.tencent.mobileqq.zplan.nameplate.UpdateParams;
import com.tencent.mobileqq.zplan.nameplate.api.IZPlanNameplate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class BaseProfileQQLevelView extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    protected static final int MAX_QQ_LEVEL_LENGTH = 10;
    public static final String TAG = "BaseProfileQQLevelView";
    public ImageView mCardNamePlateIcon;
    private Context mContext;
    public ImageView mDarenIcon;
    private double mDensity;
    protected int mIconLength;
    protected LayoutInflater mInflater;
    public URLImageView mKingInfo;
    public AnimationTextView mLevelInfo;
    public QQValuePagView mPagLayout;
    public ImageView mPrettyOwner;
    protected int mQQLevel;
    protected int mQQLevelType;
    private final StringBuilder mSB;
    public ImageView mVipExtIcon;
    public ImageView mVipIcon;
    public TextView mVipInfo;
    public com.tencent.mobileqq.zplan.nameplate.a mZPlanNameplateManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.BaseProfileQQLevelView$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass2 implements IDownLoadListener {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Card val$card;

        AnonymousClass2(Card card) {
            this.val$card = card;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseProfileQQLevelView.this, (Object) card);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoadSuccess$0(Card card) {
            BaseProfileQQLevelView.this.updateCardNameplate(card);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
                return;
            }
            QLog.e("BaseProfileQQLevelView", 1, "download card nameplate fail!! e:" + updateListenerParams.mErrorCode + " s:" + updateListenerParams.mErrorMessage);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final Card card = this.val$card;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    BaseProfileQQLevelView.AnonymousClass2.this.lambda$onLoadSuccess$0(card);
                }
            });
        }
    }

    public BaseProfileQQLevelView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private String checkVip(StringBuilder sb5, boolean z16, boolean z17, boolean z18, Card card) {
        boolean z19;
        String str;
        StringBuilder sb6 = new StringBuilder();
        if (z16) {
            sb6.append("P");
            z19 = true;
        } else {
            z19 = false;
        }
        if (z17) {
            int vipLevel = card.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
            if (vipLevel < 1) {
                vipLevel = 1;
            }
            if (card.iQQVipType == 1) {
                sb5.append("\u5e74\u8d39\u8d85\u7ea7\u4f1a\u5458");
                sb5.append(vipLevel);
                sb5.append("\u7ea7");
            } else {
                sb5.append("\u8d85\u7ea7\u4f1a\u5458");
                sb5.append(vipLevel);
                sb5.append("\u7ea7");
            }
        } else if (z18) {
            int vipLevel2 = card.getVipLevel(EVIPSPEC.E_SP_QQVIP);
            if (vipLevel2 < 1) {
                vipLevel2 = 1;
            }
            if (card.iQQVipType == 1) {
                sb5.append("\u5e74\u8d39QQ\u4f1a\u5458");
                sb5.append(vipLevel2);
                sb5.append("\u7ea7");
            } else {
                sb5.append("QQ\u4f1a\u5458");
                sb5.append(vipLevel2);
                sb5.append("\u7ea7");
            }
        } else {
            if (!z19) {
                str = "N";
            } else {
                str = "BN";
            }
            sb6.append(str);
        }
        return sb6.toString();
    }

    private boolean decorateVipToken(TextView textView, String str) {
        Drawable drawable;
        if (textView == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        Resources resources = getResources();
        SpannableString spannableString = new SpannableString(str);
        int lastIndexOf = str.lastIndexOf(")");
        if (lastIndexOf == -1) {
            lastIndexOf = 0;
        }
        boolean z16 = false;
        while (lastIndexOf < str.length()) {
            int i3 = lastIndexOf + 1;
            String substring = str.substring(lastIndexOf, i3);
            if ("N".equals(substring)) {
                drawable = resources.getDrawable(R.drawable.f4n);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            } else if ("B".equals(substring)) {
                drawable = resources.getDrawable(R.drawable.f57);
                drawable.setBounds(0, 0, (int) (this.mDensity * 10.0d), drawable.getIntrinsicHeight());
            } else {
                if ("P".equalsIgnoreCase(substring)) {
                    drawable = getResources().getDrawable(R.drawable.f4x);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } else if ("G".equalsIgnoreCase(substring)) {
                    drawable = getResources().getDrawable(R.drawable.f4w);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                } else {
                    drawable = null;
                }
                z16 = true;
            }
            if (!TextUtils.isEmpty(substring) && drawable != null) {
                spannableString.setSpan(new VerticalCenterImageSpan(drawable, 1), lastIndexOf, i3, 33);
            }
            if (drawable != null && (drawable instanceof URLDrawable)) {
                ((URLDrawable) drawable).setURLDrawableListener(new ai(textView));
            }
            lastIndexOf = i3;
        }
        textView.setText(spannableString);
        return z16;
    }

    private static Drawable grayIconCtrl(AppRuntime appRuntime, Card card, IVasRecentData.FriendsVipData friendsVipData, Drawable drawable) {
        if (drawable != null && friendsVipData.getGrayNameplateFlag() != 0 && friendsVipData.getVipType() != 0 && !card.uin.equals(appRuntime.getCurrentAccountUin())) {
            return null;
        }
        return drawable;
    }

    private void hideVipInfoIfShowVipIcon() {
        if (this.mVipInfo.getVisibility() == 0 && this.mVipInfo.getText() != null && "N".equals(this.mVipInfo.getText().toString())) {
            this.mVipInfo.setVisibility(8);
        }
    }

    private void initViews() {
        this.mInflater.inflate(R.layout.b0r, this);
        this.mPrettyOwner = (ImageView) findViewById(R.id.m37);
        this.mVipInfo = (TextView) findViewById(R.id.dlu);
        this.mVipIcon = (ImageView) findViewById(R.id.kyu);
        this.mVipExtIcon = (ImageView) findViewById(R.id.f11988782);
        this.mCardNamePlateIcon = (ImageView) findViewById(R.id.to9);
        this.mKingInfo = (URLImageView) findViewById(R.id.dli);
        this.mLevelInfo = (AnimationTextView) findViewById(R.id.dkg);
        this.mDarenIcon = (ImageView) findViewById(R.id.bn6);
        this.mZPlanNameplateManager = ((IZPlanNameplate) QRoute.api(IZPlanNameplate.class)).generateManager((RelativeLayout) findViewById(R.id.f126687pf));
        this.mPagLayout = (QQValuePagView) findViewById(R.id.f219702g);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$updateCardNameplate$0(k kVar) {
        kVar.H(false);
        kVar.y(Integer.MAX_VALUE);
        kVar.I(true);
        return null;
    }

    private void setDarenIcon() {
        this.mDarenIcon.setBackgroundResource(R.drawable.obp);
        ViewGroup.LayoutParams layoutParams = this.mDarenIcon.getLayoutParams();
        layoutParams.height = ViewUtils.dpToPx(21.0f);
        layoutParams.width = ViewUtils.dpToPx(44.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCardNameplate(Card card) {
        int i3;
        IConfigProxy iConfigProxy = VasLongToggle.VAS_QQCARD_NAMEPLATE_CONFIG;
        if (this.mCardNamePlateIcon == null || !iConfigProxy.isEnable(true) || (i3 = card.cardNameplateId) <= 0) {
            return;
        }
        QQVasUpdateBusiness business = QQVasUpdateBusiness.getBusiness(337L);
        boolean isFileExists = business.isFileExists(i3);
        String str = business.getSavePath(i3) + "/qqcardNameplate.png";
        if (isFileExists && new File(str).exists()) {
            this.mCardNamePlateIcon.setOnClickListener(new View.OnClickListener(iConfigProxy, i3) { // from class: com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.BaseProfileQQLevelView.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$cardNameplateId;
                final /* synthetic */ IConfigProxy val$configSwitch;

                {
                    this.val$configSwitch = iConfigProxy;
                    this.val$cardNameplateId = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, BaseProfileQQLevelView.this, iConfigProxy, Integer.valueOf(i3));
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        String optString = this.val$configSwitch.getJson().optString("usersummary_jump_url");
                        if (!TextUtils.isEmpty(optString)) {
                            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(view.getContext(), optString);
                        }
                        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "\u8d44\u6599\u5361\u9875", "user_avatar", "", "" + this.val$cardNameplateId, "", "63", 102, 0, 0, "", "", "");
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            if (this.mCardNamePlateIcon.getVisibility() != 0) {
                this.mCardNamePlateIcon.setVisibility(0);
            }
            this.mCardNamePlateIcon.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).h(new Function1() { // from class: com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$updateCardNameplate$0;
                    lambda$updateCardNameplate$0 = BaseProfileQQLevelView.lambda$updateCardNameplate$0((k) obj);
                    return lambda$updateCardNameplate$0;
                }
            }).a());
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "\u8d44\u6599\u5361\u9875", "user_avatar", "", "" + i3, "", "63", 101, 0, 0, "", "", "");
            return;
        }
        business.addDownLoadListener(i3, new AnonymousClass2(card));
        business.startDownload(i3);
    }

    private void updateVipIconNew(AppRuntime appRuntime, Card card) {
        if (QQTheme.isNowSimpleUI() && !ff.d()) {
            this.mVipIcon.setVisibility(8);
            this.mVipExtIcon.setVisibility(8);
            return;
        }
        IVasRecentData.FriendsVipData vipIconInfo = VasInjectApi.getInstance().getVipIconInfo(card);
        Drawable grayIconCtrl = grayIconCtrl(appRuntime, card, vipIconInfo, ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(this.mVipIcon.getResources(), card.uin, vipIconInfo));
        if (grayIconCtrl != null) {
            this.mVipIcon.setImageDrawable(grayIconCtrl);
            this.mVipIcon.setVisibility(0);
            this.mVipIcon.setContentDescription(HardCodeUtil.qqStr(R.string.vhq));
            this.mVipIcon.setFocusableInTouchMode(true);
            hideVipInfoIfShowVipIcon();
        } else {
            this.mVipIcon.setVisibility(8);
        }
        c icon = ((IVipIconExFactory) QRoute.api(IVipIconExFactory.class)).getIcon(this.mVipIcon.getResources(), vipIconInfo);
        if (icon != null && f.b(vipIconInfo.getVipType()).a()) {
            this.mVipExtIcon.setImageDrawable(icon);
            this.mVipExtIcon.setVisibility(0);
        } else {
            this.mVipExtIcon.setVisibility(8);
        }
        if (this.mVipIcon.getVisibility() == 0) {
            ff.j.b c16 = ff.j.b.c(appRuntime, card.uin, "VIA_PROFILECARD");
            c16.d();
            this.mVipIcon.setOnTouchListener(c16);
        }
        if (this.mVipExtIcon.getVisibility() == 0) {
            this.mVipExtIcon.setOnClickListener(new ff.g());
        }
        VasSvipPrivilegeAnimateHelper.addSvipPrivilegeAnimateView(this.mVipIcon);
        VasSvipPrivilegeAnimateHelper.addSvipPrivilegeAnimateView(this.mVipExtIcon);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            int width = getWidth();
            if (this.mDarenIcon.getVisibility() == 0) {
                i19 = this.mDarenIcon.getWidth();
            } else {
                i19 = 0;
            }
            int left = this.mLevelInfo.getLeft();
            int i26 = (width - i19) - left;
            if (QLog.isColorLevel()) {
                QLog.d("BaseProfileQQLevelView", 2, String.format("onLayout totalWidth=%s darenWidth=%s levelLeft=%s", Integer.valueOf(width), Integer.valueOf(i19), Integer.valueOf(left)));
            }
            this.mIconLength = Math.min((i26 / ((int) getResources().getDimension(R.dimen.f159035ui))) - 1, 10);
            updateQQLevelContent();
        }
    }

    public void update(ProfileCardInfo profileCardInfo, boolean z16) {
        Card card;
        boolean z17;
        boolean z18;
        boolean z19;
        long j3;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, profileCardInfo, Boolean.valueOf(z16));
            return;
        }
        if (profileCardInfo == null) {
            card = null;
        } else {
            card = profileCardInfo.card;
        }
        Card card2 = card;
        if (card2 != null) {
            boolean isVipOpen = card2.isVipOpen(EVIPSPEC.E_SP_QQVIP);
            boolean isVipOpen2 = card2.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
            card2.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
            long j16 = card2.lUserFlag;
            if ((j16 & 1) == 1) {
                z28 = true;
            } else {
                z28 = false;
            }
            if ((j16 & 1024) == 1024) {
                z29 = true;
            } else {
                z29 = false;
            }
            if ((!ProfilePAUtils.isPaTypeShowAccount(profileCardInfo.allInOne) || ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) && !isVipOpen2 && !isVipOpen && card2.iQQLevel < 0) {
                z36 = false;
            } else {
                z36 = true;
            }
            if (z16) {
                z36 = false;
            }
            z17 = z29;
            z18 = z36;
            z19 = z28;
            j3 = card2.uCurMulType;
            z26 = isVipOpen;
            z27 = isVipOpen2;
        } else {
            z17 = false;
            z18 = false;
            z19 = false;
            j3 = 0;
            z26 = false;
            z27 = false;
        }
        if (!z18) {
            if (QLog.isColorLevel()) {
                QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, "update not show account info");
            }
            setVisibility(8);
            return;
        }
        this.mSB.setLength(0);
        setVisibility(0);
        if (card2 != null && !card2.isHidePrettyGroutIdentity) {
            if (card2.isPrettyGroupOwner) {
                this.mPrettyOwner.setVisibility(0);
                ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A580", 0, 0, "", "", "", "");
            } else {
                this.mPrettyOwner.setVisibility(8);
            }
        } else {
            this.mPrettyOwner.setVisibility(8);
        }
        String checkVip = checkVip(this.mSB, z17, z27, z26, card2);
        this.mVipIcon.setColorFilter(0);
        this.mVipExtIcon.setColorFilter(0);
        this.mKingInfo.setColorFilter(0);
        QLog.e("BaseProfileQQLevelView", 1, "update level view :" + checkVip + " , " + j3);
        if (!TextUtils.isEmpty(checkVip)) {
            boolean decorateVipToken = decorateVipToken(this.mVipInfo, checkVip);
            if (PrettyAccountUtil.manageOpen() && decorateVipToken) {
                this.mVipInfo.setVisibility(8);
            } else if (this.mVipIcon.getVisibility() != 0 || this.mVipInfo.getText() == null || !"N".equals(this.mVipInfo.getText().toString())) {
                this.mVipInfo.setVisibility(0);
            }
        } else {
            this.mVipInfo.setVisibility(8);
        }
        updateVipIconNew((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), card2);
        IGameCardManager.a aVar = new IGameCardManager.a(card2.uin, card2.namePlateOfKingGameId, card2.namePlateOfKingDan, card2.namePlateOfKingDanDisplatSwitch, card2.gameCardId);
        aVar.f312733a = IGameCardManager.CARD;
        VipGrayConfigHelper.getsInstance().updateNamePlateOfKingIconView(this.mKingInfo, z27, card2.namePlateOfKingLoginTime, aVar);
        this.mZPlanNameplateManager.a(new UpdateParams(profileCardInfo.card));
        int i3 = card2.iQQLevel;
        if (i3 >= 0) {
            this.mQQLevelType = card2.mQQLevelType;
            this.mQQLevel = i3;
            updateQQLevelContent();
            StringBuilder sb5 = this.mSB;
            sb5.append(" \u7b49\u7ea7 ");
            sb5.append(card2.iQQLevel);
            sb5.append("\u7ea7 ");
            this.mLevelInfo.setVisibility(0);
            this.mLevelInfo.setContentDescription("\u7b49\u7ea7\uff1a" + card2.iQQLevel + "\u7ea7");
            ProfileVipReport.reportLevelBadge(profileCardInfo, false);
        } else {
            this.mLevelInfo.setVisibility(8);
        }
        setDarenIcon();
        setContentDescription(this.mSB.toString());
        if (QLog.isColorLevel()) {
            QLog.d(LevelUtil.PROFILE_CARD_TAG, 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", Boolean.valueOf(z26), Boolean.valueOf(z27), Boolean.valueOf(z19), Boolean.valueOf(z17), Boolean.valueOf(z18)));
        }
        this.mPagLayout.setVisibility(8);
        this.mPagLayout.setDynamicEnable(false);
        updateQQValueCard(profileCardInfo);
        updateCardNameplate(card2);
        ProfileVipReport.reportLevelItem(profileCardInfo, false);
        ProfileCardDtReportUtil.initElementWithExposureClick(this.mVipIcon, ProfileCardDtReportUtil.DT_REPORT_NAMEPLATE);
    }

    public void updateQQLevelContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseProfileQQLevelView", 2, String.format("updateQQLevelContent level=%s levelType=%s iconLength=%s", Integer.valueOf(this.mQQLevel), Integer.valueOf(this.mQQLevelType), Integer.valueOf(this.mIconLength)));
        }
        this.mLevelInfo.setText(LevelUtil.parseQQLevel(getContext(), this.mIconLength, this.mQQLevelType, this.mQQLevel, true), TextView.BufferType.SPANNABLE);
    }

    public void updateQQValueCard(ProfileCardInfo profileCardInfo) {
        Card card;
        QQValuePagView qQValuePagView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) profileCardInfo);
            return;
        }
        if (profileCardInfo == null) {
            card = null;
        } else {
            card = profileCardInfo.card;
        }
        if (card != null && (qQValuePagView = this.mPagLayout) != null) {
            qQValuePagView.B(card.uin, IndividuationUrlHelper.UrlId.CARD_HOME, false);
        }
    }

    public BaseProfileQQLevelView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public BaseProfileQQLevelView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSB = new StringBuilder(200);
        this.mIconLength = 10;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mDensity = getResources().getDisplayMetrics().density;
        initViews();
    }
}
