package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.flash.VipFlashNickNameView;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

/* loaded from: classes20.dex */
public class ProfileNameView extends RelativeLayout {
    VipFlashNickNameView C;
    TextView D;
    ETTextViewPlus E;
    ImageView F;
    LinearLayout G;
    LinearLayout H;
    private int I;
    private final Context J;
    private final LayoutInflater K;
    private float L;
    private final int M;
    private final int N;
    private final int P;
    private View.OnClickListener Q;
    private final UnitedProxy R;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f315987d;

    /* renamed from: e, reason: collision with root package name */
    protected ImageView f315988e;

    /* renamed from: f, reason: collision with root package name */
    protected int f315989f;

    /* renamed from: h, reason: collision with root package name */
    String f315990h;

    /* renamed from: i, reason: collision with root package name */
    com.tencent.mobileqq.text.g f315991i;

    /* renamed from: m, reason: collision with root package name */
    int f315992m;

    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f315993d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ProfileCardInfo f315994e;

        a(int i3, ProfileCardInfo profileCardInfo) {
            this.f315993d = i3;
            this.f315994e = profileCardInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MobileReportManager.getInstance().reportAction(SearchConstants.PLATFORM, "data_card", "vip_medal", "", String.valueOf(this.f315993d), "62", 102, 0);
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(view.getContext(), this.f315994e.card.vipMedalJumpUrl);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProfileCardInfo f315996d;

        b(ProfileCardInfo profileCardInfo) {
            this.f315996d = profileCardInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ITroopLinkApi iTroopLinkApi = (ITroopLinkApi) QRoute.api(ITroopLinkApi.class);
            ProfileCardInfo profileCardInfo = this.f315996d;
            String troopMemberHonorUrl = iTroopLinkApi.getTroopMemberHonorUrl(profileCardInfo.troopUin, profileCardInfo.allInOne.uin);
            Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", troopMemberHonorUrl);
            view.getContext().startActivity(intent);
            ReportController.o(null, "dc00898", "", "", "0X800A708", "0X800A708", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ProfileCardInfo f315998d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f315999e;

        c(ProfileCardInfo profileCardInfo, QQAppInterface qQAppInterface) {
            this.f315998d = profileCardInfo;
            this.f315999e = qQAppInterface;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TroopMemberNewLevelView troopMemberNewLevelView;
            EventCollector.getInstance().onViewClickedBefore(view);
            Context context = view.getContext();
            ProfileCardInfo profileCardInfo = this.f315998d;
            String str = profileCardInfo.troopUin;
            String str2 = profileCardInfo.allInOne.uin;
            int i3 = 1;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ((ITroopIdentityApi) QRoute.api(ITroopIdentityApi.class)).openTroopIdentityWearPage(context, str, str2, new Bundle());
                if (view instanceof TroopMemberNewLevelView) {
                    troopMemberNewLevelView = (TroopMemberNewLevelView) view;
                } else {
                    troopMemberNewLevelView = null;
                }
                if (troopMemberNewLevelView != null) {
                    if (troopMemberNewLevelView.c() && troopMemberNewLevelView.d()) {
                        i3 = 3;
                    } else if (!troopMemberNewLevelView.c()) {
                        if (troopMemberNewLevelView.d()) {
                            i3 = 2;
                        }
                    }
                    ReportController.o(this.f315999e, "dc00898", "", "", "0X800B201", "0X800B201", i3, 0, "", "", "", "");
                }
                i3 = 0;
                ReportController.o(this.f315999e, "dc00898", "", "", "0X800B201", "0X800B201", i3, 0, "", "", "", "");
            } else {
                QLog.i("ProfileNameView", 1, "[handleCharmLevelClick] mActivity = " + context + ", troopUin = " + str + ", uin = " + str2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ProfileNameView(Context context) {
        this(context, null);
    }

    private int e(String str, int i3) {
        if (((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("profile_group_name", Boolean.FALSE).booleanValue()) {
            return i3;
        }
        if (str == null) {
            return 0;
        }
        return Math.min(Math.max(0, i3), str.length());
    }

    private void h() {
        this.K.inflate(R.layout.b0v, this);
        this.C = (VipFlashNickNameView) findViewById(R.id.xmn);
        this.D = (TextView) findViewById(R.id.xmo);
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        ETTextViewPlus eTTextViewPlus = (ETTextViewPlus) findViewById(R.id.aww);
        this.E = eTTextViewPlus;
        eTTextViewPlus.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.iar);
        this.H = linearLayout;
        linearLayout.setVisibility(8);
        this.C.setVisibility(0);
        this.C.setTextColor(this.f315989f);
        this.D.setTextColor(this.f315989f);
        this.C.setTextSize(1, this.N);
        this.D.setTextSize(1, this.P);
        this.F = (ImageView) findViewById(R.id.f1198577z);
        this.G = (LinearLayout) findViewById(R.id.zy8);
    }

    private boolean i(Card card) {
        if (!this.R.isEnable(true)) {
            return true;
        }
        int colorName = com.tencent.mobileqq.vip.api.b.a().getVipDataForFriends(card.uin).getColorName();
        if (colorName != 38 && colorName != 39) {
            return true;
        }
        return false;
    }

    private void j(String str, QQAppInterface qQAppInterface) {
        String uidFromUin;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid;
        String valueOf;
        if (!OnlineStatusToggleUtils.t() || this.J == null || TextUtils.isEmpty(str) || qQAppInterface == null || (uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str)) == null || uidFromUin.isEmpty() || !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "ProfileNameView_processOnlineStatusLayout") || (onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(uidFromUin, "ProfileNameView_processOnlineStatusLayout")) == null) {
            return;
        }
        AppRuntime.Status translateNT = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).translateNT(onlineStatusSimpleInfoWithUid);
        this.G.removeAllViews();
        this.G.setOnClickListener(null);
        Map<String, Object> onlineStatusViewAndClickListener = ProfileCardUtils.getOnlineStatusViewAndClickListener(onlineStatusSimpleInfoWithUid, str, translateNT, qQAppInterface, this.J);
        if (onlineStatusViewAndClickListener == null) {
            return;
        }
        Object obj = onlineStatusViewAndClickListener.get(ProfileCardUtils.MAP_KEY_VIEW);
        Object obj2 = onlineStatusViewAndClickListener.get(ProfileCardUtils.MAP_KEY_CLICK_LISTENER);
        Object obj3 = onlineStatusViewAndClickListener.get(ProfileCardUtils.MAP_KEY_WIDTH);
        if ((obj instanceof View) && (obj2 instanceof View.OnClickListener) && (obj3 instanceof Integer)) {
            int intValue = this.f315992m - ((Integer) obj3).intValue();
            this.f315992m = intValue;
            this.C.setMaxWidth(intValue);
            this.D.setMaxWidth(this.f315992m);
            this.E.setMaxWidth(this.f315992m);
            this.G.addView((View) obj);
            this.G.setVisibility(0);
            this.G.setOnClickListener((View.OnClickListener) obj2);
            if (onlineStatusSimpleInfoWithUid.e0() > 0 && translateNT.equals(AppRuntime.Status.online)) {
                valueOf = String.valueOf(onlineStatusSimpleInfoWithUid.e0());
            } else {
                valueOf = String.valueOf(translateNT.getValue());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ProfileCardDtReportUtil.STATUS_ID, valueOf);
            ProfileCardDtReportUtil.initElementWithExposureClickAndParams(this.G, ProfileCardDtReportUtil.DT_REPORT_STATUS_ICON, hashMap);
        }
    }

    private void l(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo, TroopHonorView troopHonorView, float f16) {
        if (profileCardInfo != null && profileCardInfo.troopMemberCard != null) {
            ITroopHonorService iTroopHonorService = (ITroopHonorService) qQAppInterface.getRuntimeService(ITroopHonorService.class, "");
            if (!iTroopHonorService.isSupportTroopHonor(profileCardInfo.troopUin)) {
                troopHonorView.setHonorList(null);
                troopHonorView.setVisibility(8);
                return;
            }
            TroopMemberCard troopMemberCard = profileCardInfo.troopMemberCard;
            List<com.tencent.mobileqq.troop.honor.config.a> convertToHonorList = iTroopHonorService.convertToHonorList(troopMemberCard.honorList, Byte.valueOf(troopMemberCard.honorRichTag));
            troopHonorView.setHonorList(convertToHonorList, f16);
            if (convertToHonorList != null && convertToHonorList.size() > 0) {
                troopHonorView.setVisibility(0);
                troopHonorView.setOnClickListener(new b(profileCardInfo));
            } else {
                troopHonorView.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonor.card", 2, String.format("updateTroopHonorView, honorList: %s", convertToHonorList));
                return;
            }
            return;
        }
        troopHonorView.setHonorList(null);
        troopHonorView.setVisibility(8);
    }

    private void m(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo, TroopMemberNewLevelView troopMemberNewLevelView) {
        TroopInfo troopInfo;
        if (qQAppInterface != null && profileCardInfo != null && troopMemberNewLevelView != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileNameView", 2, "call updateTroopMemberNewLevelView troopUin : " + profileCardInfo.troopUin);
            }
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                troopInfo = troopManager.B(profileCardInfo.troopUin);
            } else {
                troopInfo = null;
            }
            TroopInfo troopInfo2 = troopInfo;
            if (troopInfo2 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileNameView", 2, "updateTroopMemberNewLevelView troopInfo is null. troopUin : " + profileCardInfo.troopUin);
                    return;
                }
                return;
            }
            int i3 = profileCardInfo.troopMemberCard.realLevel;
            ITroopMemberLevelUtilsApi iTroopMemberLevelUtilsApi = (ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class);
            String str = profileCardInfo.allInOne.uin;
            TroopMemberCard troopMemberCard = profileCardInfo.troopMemberCard;
            com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = iTroopMemberLevelUtilsApi.getTroopMemberRankItem(troopInfo2, str, i3, troopMemberCard.titleId, troopMemberCard.mUniqueTitle, troopMemberCard.honorRichTag);
            if (troopMemberRankItem != null) {
                troopMemberNewLevelView.setTroopMemberNewLevel(troopMemberRankItem);
                troopMemberNewLevelView.setOnClickListener(new c(profileCardInfo, qQAppInterface));
            } else if (QLog.isColorLevel()) {
                QLog.d("ProfileNameView", 2, "updateTroopMemberNewLevelView failed - troopUin : " + profileCardInfo.troopUin);
            }
        }
    }

    public void a(@NonNull QQAppInterface qQAppInterface, @Nullable TextView textView, @Nullable String str) {
        if (textView != null && str != null) {
            textView.setTextColor(this.f315989f);
            SpannableString j3 = new com.tencent.mobileqq.text.c(str, (int) (textView.getTextSize() / this.L)).j();
            textView.setText(j3);
            com.tencent.mobileqq.vas.f.q(qQAppInterface, textView, j3);
        }
    }

    public ETTextViewPlus b() {
        if (this.E != null) {
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            this.E.setVisibility(0);
            return this.E;
        }
        return null;
    }

    public int c() {
        int i3;
        int paddingLeft = this.E.getPaddingLeft() + ((int) this.E.getPaint().measureText(this.E.getText().toString())) + this.E.getPaddingRight();
        if (OnlineStatusToggleUtils.t()) {
            i3 = this.G.getWidth() + ViewUtils.dip2px(5.0f);
        } else {
            i3 = 0;
        }
        int dip2px = paddingLeft + ScreenUtil.dip2px(40.0f) + i3;
        TextView textView = (TextView) findViewById(R.id.ar8);
        if (textView.getVisibility() == 0 && !TextUtils.isEmpty(textView.getText())) {
            dip2px = (int) (dip2px + ViewUtils.dpToPx(4.0f) + textView.getPaddingLeft() + textView.getPaint().measureText(textView.getText().toString()) + textView.getPaddingRight());
        }
        TroopHonorView troopHonorView = (TroopHonorView) this.H.findViewById(R.id.lc_);
        if (troopHonorView.getVisibility() == 0) {
            dip2px += troopHonorView.getPaddingLeft() + troopHonorView.b() + troopHonorView.getPaddingRight();
        }
        TroopMemberNewLevelView troopMemberNewLevelView = (TroopMemberNewLevelView) this.H.findViewById(R.id.f102615yd);
        if (troopMemberNewLevelView != null && troopMemberNewLevelView.getVisibility() == 0) {
            return (int) (dip2px + troopMemberNewLevelView.b() + ViewUtils.dip2px(2.0f));
        }
        return dip2px;
    }

    public int d() {
        return this.I;
    }

    public int f() {
        return this.C.getCurrentTextColor();
    }

    public float g(TextView textView, String str, Paint paint) {
        return new com.tencent.mobileqq.text.g(str, (int) (textView.getTextSize() / this.L)).b(4).f(paint);
    }

    @RequiresApi(api = 16)
    public void k(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        String str;
        AllInOne allInOne;
        String str2;
        float f16;
        TextView textView;
        int i3;
        int i16;
        if (qQAppInterface != null && profileCardInfo != null && (allInOne = profileCardInfo.allInOne) != null && ((!ProfilePAUtils.isFromGuild(allInOne.f260789pa) || profileCardInfo.card != null) && (ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa) || profileCardInfo.profileName != null))) {
            this.I = 3;
            int i17 = 0;
            setVisibility(0);
            this.C.setTextSize(1, this.N);
            this.D.setTextSize(1, this.P);
            int measuredWidth = getMeasuredWidth();
            if (measuredWidth > this.f315992m) {
                this.f315992m = measuredWidth;
            }
            int i18 = profileCardInfo.card.vipMedalId;
            if (i18 > 0) {
                this.f315992m -= ScreenUtil.dip2px(40.0f);
                this.F.setVisibility(0);
                this.F.setTag(new com.tencent.mobileqq.profile.b(115, null));
                this.F.setImageDrawable(((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getMedalIcon(this.F.getResources(), i18));
                this.F.setOnClickListener(this.Q);
                this.C.setMaxWidth(this.f315992m);
                this.D.setMaxWidth(this.f315992m);
                this.E.setMaxWidth(this.f315992m);
                MobileReportManager.getInstance().reportAction(SearchConstants.PLATFORM, "data_card", "vip_medal", "", String.valueOf(i18), "62", 101, 0);
                this.F.setOnClickListener(new a(i18, profileCardInfo));
            } else {
                this.F.setVisibility(8);
                this.C.setMaxWidth(Integer.MAX_VALUE);
                this.D.setMaxWidth(Integer.MAX_VALUE);
                this.E.setMaxWidth(Integer.MAX_VALUE);
            }
            try {
                j(profileCardInfo.allInOne.uin, qQAppInterface);
            } catch (Exception e16) {
                QLog.e("ProfileNameView", 1, "processOnlineStatusLayout " + e16);
            }
            try {
                if (ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
                    Card card = profileCardInfo.card;
                    if (TextUtils.isEmpty(card.strReMark)) {
                        str2 = card.strNick;
                    } else {
                        str2 = card.strReMark;
                    }
                    try {
                        this.C.setBackground(null);
                        this.D.setBackground(null);
                        setBackground(null);
                    } catch (NullPointerException unused) {
                    }
                } else {
                    str2 = profileCardInfo.profileName.f305805a.f305804b;
                }
            } catch (NullPointerException unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() == 0) {
                if (ProfilePAUtils.isPaTypeShowAccount(profileCardInfo.allInOne)) {
                    str2 = String.valueOf(profileCardInfo.allInOne.uin);
                } else {
                    str2 = " ";
                }
            }
            Card card2 = profileCardInfo.card;
            if (card2 != null && !card2.isNoCover() && !profileCardInfo.isQQGuildCard && i(profileCardInfo.card)) {
                this.C.setShadowLayer(ScreenUtil.dip2px(1.0f), 0.0f, 0.0f, -16777216);
                this.D.setShadowLayer(ScreenUtil.dip2px(1.0f), 0.0f, 0.0f, -16777216);
            } else {
                this.C.setShadowLayer(0.0f, 0.0f, 0.0f, this.D.getCurrentTextColor());
                TextView textView2 = this.D;
                textView2.setShadowLayer(0.0f, 0.0f, 0.0f, textView2.getCurrentTextColor());
            }
            com.tencent.mobileqq.text.g gVar = new com.tencent.mobileqq.text.g(str2, (int) (this.C.getTextSize() / this.L));
            this.f315991i = gVar;
            com.tencent.mobileqq.text.g b16 = gVar.b(4);
            this.f315991i.c(4);
            String format = String.format("%s:%s", this.J.getString(R.string.ab7), this.f315991i);
            if (!Utils.G(profileCardInfo.allInOne.uin) && !profileCardInfo.isTroopMemberCard) {
                this.I = 3;
                String gVar2 = this.f315991i.toString();
                this.C.setText(gVar2);
                this.C.setSingleLine(true);
                this.C.setMaxLines(1);
                this.C.setEllipsize(TextUtils.TruncateAt.END);
                this.C.setVisibility(0);
                this.D.setVisibility(8);
                this.H.setVisibility(8);
                TextPaint paint = this.C.getPaint();
                if (paint == null) {
                    paint = new TextPaint(1);
                    paint.density = this.L;
                    paint.setTextSize(this.C.getTextSize());
                }
                if (paint.measureText(gVar2) >= this.f315992m) {
                    this.C.setTextSize(1, this.P);
                }
            } else {
                Resources resources = this.J.getResources();
                this.H.setVisibility(0);
                View findViewById = this.H.findViewById(R.id.f164517a15);
                if (Utils.G(profileCardInfo.allInOne.uin)) {
                    findViewById.setVisibility(0);
                    f16 = resources.getDimensionPixelSize(R.dimen.a0a) + 0.0f;
                } else {
                    findViewById.setVisibility(8);
                    f16 = 0.0f;
                }
                ViewGroup viewGroup = (ViewGroup) this.H.findViewById(R.id.ar9);
                if (profileCardInfo.isTroopMemberCard) {
                    TroopMemberNewLevelView troopMemberNewLevelView = (TroopMemberNewLevelView) findViewById(R.id.f102615yd);
                    if (troopMemberNewLevelView != null) {
                        m(qQAppInterface, profileCardInfo, troopMemberNewLevelView);
                        if (troopMemberNewLevelView.getVisibility() == 0) {
                            f16 += troopMemberNewLevelView.b() + ViewUtils.dip2px(2.0f);
                        }
                    }
                    TroopHonorView troopHonorView = (TroopHonorView) this.H.findViewById(R.id.lc_);
                    l(qQAppInterface, profileCardInfo, troopHonorView, this.f315992m - f16);
                    if (troopHonorView.getVisibility() == 0) {
                        f16 += troopHonorView.b();
                    }
                } else {
                    viewGroup.setVisibility(8);
                }
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.a0b);
                float f17 = f16 + dimensionPixelSize;
                this.C.setSingleLine();
                TextPaint paint2 = this.C.getPaint();
                if (paint2 == null) {
                    paint2 = new TextPaint(1);
                    paint2.density = this.L;
                    paint2.setTextSize(this.C.getTextSize());
                }
                float f18 = b16.f(paint2);
                if (f18 + f17 < this.f315992m) {
                    a(qQAppInterface, this.C, this.f315991i.j());
                    this.D.setVisibility(8);
                    textView = this.C;
                    if (QLog.isColorLevel()) {
                        QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", Float.valueOf(f18), Float.valueOf(f17), Integer.valueOf(this.f315992m)));
                    }
                    this.I = 1;
                } else {
                    paint2.setTextSize(ScreenUtil.dip2px(this.P));
                    float f19 = b16.f(paint2);
                    float f26 = f19 + f17;
                    int i19 = this.f315992m;
                    if (f26 < i19) {
                        this.C.setTextSize(1, this.P);
                        a(qQAppInterface, this.C, this.f315991i.j());
                        this.D.setVisibility(8);
                        textView = this.C;
                        if (QLog.isColorLevel()) {
                            QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", Float.valueOf(f19), Float.valueOf(f17), Integer.valueOf(this.f315992m)));
                        }
                        this.I = 1;
                    } else if (f18 < i19) {
                        a(qQAppInterface, this.C, this.f315991i.j());
                        this.D.setVisibility(8);
                        textView = this.D;
                        if (QLog.isColorLevel()) {
                            i16 = 2;
                            QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", Float.valueOf(f18), Float.valueOf(f17), Integer.valueOf(this.f315992m)));
                        } else {
                            i16 = 2;
                        }
                        this.I = i16;
                    } else if (f19 < i19) {
                        this.C.setTextSize(1, this.P);
                        a(qQAppInterface, this.C, this.f315991i.j());
                        this.D.setVisibility(8);
                        textView = this.D;
                        if (QLog.isColorLevel()) {
                            i3 = 2;
                            QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", Float.valueOf(f19), Float.valueOf(f17), Integer.valueOf(this.f315992m)));
                        } else {
                            i3 = 2;
                        }
                        this.I = i3;
                    } else if (profileCardInfo.isTroopMemberCard) {
                        String j3 = this.f315991i.j();
                        if (!j3.contains("<") && profileCardInfo.troopMemberCard.colorCardId <= 0) {
                            this.I = 2;
                            TextView textView3 = this.D;
                            this.C.setTextSize(1, this.P);
                            this.C.setEllipsize(null);
                            this.D.setTextSize(1, this.P);
                            this.D.setVisibility(0);
                            float dip2px = this.f315992m - ScreenUtil.dip2px(4.0f);
                            int i26 = 1;
                            float f27 = 0.0f;
                            while (f27 <= dip2px && i26 < j3.length()) {
                                i26++;
                                f27 = g(this.C, j3.substring(i17, e(j3, i26)), this.C.getPaint());
                                i17 = 0;
                            }
                            int i27 = i26 - 1;
                            float g16 = g(this.D, j3.substring(e(j3, i27)), this.D.getPaint()) + this.D.getPaddingLeft() + this.D.getPaddingRight();
                            if (g16 + f17 > dip2px) {
                                float f28 = dip2px - f17;
                                if (f28 < g(this.D, j3.substring(e(j3, i27), e(j3, i26 + 1)), this.D.getPaint())) {
                                    this.C.setEllipsize(TextUtils.TruncateAt.END);
                                    this.D.setVisibility(8);
                                    a(qQAppInterface, this.C, j3);
                                } else {
                                    this.D.setWidth((int) f28);
                                    String substring = j3.substring(0, e(j3, i27));
                                    String substring2 = j3.substring(e(j3, i27));
                                    a(qQAppInterface, this.C, substring);
                                    a(qQAppInterface, this.D, substring2);
                                }
                            } else {
                                this.D.setWidth((int) g16);
                                String substring3 = j3.substring(0, e(j3, i27));
                                String substring4 = j3.substring(e(j3, i27));
                                a(qQAppInterface, this.C, substring3);
                                a(qQAppInterface, this.D, substring4);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("ProfileNameView", 2, String.format("update 5 [n: %s, r: %s, max: %s]", Float.valueOf(f18), Float.valueOf(f17), Integer.valueOf(this.f315992m)));
                            }
                            textView = textView3;
                        } else {
                            this.I = 1;
                            a(qQAppInterface, this.C, j3);
                            this.C.setTextSize(1, this.P);
                            this.D.setVisibility(8);
                            textView = this.C;
                            if (QLog.isColorLevel()) {
                                QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", Float.valueOf(f18), Float.valueOf(f17), Integer.valueOf(this.f315992m)));
                            }
                        }
                    } else {
                        this.I = 2;
                        this.C.setTextSize(1, this.P);
                        this.C.setEllipsize(TextUtils.TruncateAt.END);
                        this.C.setWidth((int) (this.f315992m - f17));
                        VipFlashNickNameView vipFlashNickNameView = this.C;
                        a(qQAppInterface, vipFlashNickNameView, this.f315991i.j());
                        textView = vipFlashNickNameView;
                    }
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.H.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                }
                if (this.E.getVisibility() == 0) {
                    layoutParams.addRule(1, 0);
                    layoutParams.addRule(3, this.E.getId());
                    layoutParams.addRule(8, 0);
                    layoutParams.addRule(6, 0);
                    layoutParams.addRule(14);
                    layoutParams.topMargin = 0;
                    layoutParams.leftMargin = dimensionPixelSize;
                    this.H.setLayoutParams(layoutParams);
                } else if (textView.getVisibility() == 0) {
                    layoutParams.addRule(1, textView.getId());
                    layoutParams.addRule(3, 0);
                    layoutParams.addRule(8, textView.getId());
                    layoutParams.addRule(6, textView.getId());
                    layoutParams.topMargin = 0;
                    layoutParams.leftMargin = dimensionPixelSize;
                    this.H.setLayoutParams(layoutParams);
                } else if (textView == this.D) {
                    layoutParams.addRule(1, 0);
                    layoutParams.addRule(3, this.C.getId());
                    layoutParams.addRule(8, 0);
                    layoutParams.addRule(6, 0);
                    layoutParams.topMargin = dimensionPixelSize;
                    layoutParams.leftMargin = 0;
                    this.H.setMinimumHeight(0);
                    this.H.setLayoutParams(layoutParams);
                } else {
                    layoutParams.addRule(1, this.E.getId());
                    layoutParams.addRule(3, 0);
                    layoutParams.addRule(8, this.E.getId());
                    layoutParams.addRule(6, this.E.getId());
                    layoutParams.topMargin = 0;
                    layoutParams.leftMargin = dimensionPixelSize;
                    this.H.setLayoutParams(layoutParams);
                }
            }
            setContentDescription(format);
            setTag(new com.tencent.mobileqq.profile.b(88, this.f315991i.toString()));
            setOnClickListener(this.Q);
            if (!ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
                LongClickCopyAction.attachCopyAction(this, getResources().getString(R.string.aet), this.f315991i.toString());
            }
            if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(this.C, profileCardInfo.card)) {
                this.C.setTextColor(getResources().getColorStateList(R.color.skin_white, null));
            }
            if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByCard(this.D, profileCardInfo.card)) {
                this.D.setTextColor(getResources().getColorStateList(R.color.skin_white, null));
                return;
            }
            return;
        }
        setVisibility(8);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("update failed troopUin : ");
            if (profileCardInfo != null) {
                str = profileCardInfo.troopUin;
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.d("ProfileNameView", 2, sb5.toString());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredWidth;
        super.onLayout(z16, i3, i16, i17, i18);
        Object parent = getParent();
        if ((parent instanceof View) && this.f315992m < (measuredWidth = ((View) parent).getMeasuredWidth())) {
            this.f315992m = measuredWidth;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.Q = onClickListener;
    }

    public void setFontFamily(Typeface typeface) {
        this.C.setTypeface(typeface);
        this.D.setTypeface(typeface);
    }

    public void setTextColor(int i3) {
        if (this.f315989f != i3) {
            this.f315989f = i3;
            this.C.setTextColor(i3);
            this.D.setTextColor(this.f315989f);
        }
    }

    public ProfileNameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileNameView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315987d = false;
        this.f315988e = null;
        this.f315990h = "";
        this.f315992m = 0;
        this.M = 0;
        this.R = com.tencent.mobileqq.vas.ar.b("linkliang", "2024-07-20", "vas_colorname_bugfix_127182129");
        this.J = context;
        this.K = LayoutInflater.from(context);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f16 = displayMetrics.density;
        this.L = f16;
        if (f16 == 0.0f) {
            this.L = 0.1f;
        }
        this.f315992m = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - ScreenUtil.dip2px(188.0f);
        this.f315989f = getResources().getColor(R.color.skin_white);
        this.N = 24;
        this.P = 20;
        h();
    }
}
