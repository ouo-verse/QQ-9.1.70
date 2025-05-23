package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.drawer.DrawerOnlineStatusView;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.k;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.theme.BusinessTintManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.api.c;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.e;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQSettingMeApiImpl implements IQQSettingMeApi {
    static IPatchRedirector $redirector_ = null;
    private static final String DRAWER_TYPE = "qq_setting_me_drawer_type_";
    private static final String TAG = "QQSettingMeApiImpl";

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements DarkModeManager.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i71.a f184834a;

        a(i71.a aVar) {
            this.f184834a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeApiImpl.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f184834a.a();
            }
        }
    }

    public QQSettingMeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDrawerType$1(long j3, MMKVOptionEntityV2 mMKVOptionEntityV2, String str) {
        AccessibleDetail zplanAccessibleDetail = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetail(1006L, j3);
        if (zplanAccessibleDetail != null && mMKVOptionEntityV2.decodeInt(str, -1) != zplanAccessibleDetail.getEntranceType()) {
            mMKVOptionEntityV2.encodeInt(str, zplanAccessibleDetail.getEntranceType());
            QLog.i(TAG, 1, "getDrawerType setToMMKV: " + zplanAccessibleDetail.getEntranceType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportCoverBg$0(AppRuntime appRuntime, Card card) {
        int i3;
        if (appRuntime != null && card != null) {
            if (e.h(card)) {
                i3 = 2;
            } else if (e.g()) {
                i3 = 3;
            } else if (!card.isNoCover()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
        } else {
            i3 = -1;
        }
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X800C35A", "0X800C35A", i3, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean canShowNamePlateInSimpleMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return ff.d();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void checkAndGetSelfNickName(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        } else {
            ((QQAppInterface) appRuntime).checkAndGetSelfNickName();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void closeDrawer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            FrameHelperActivity.Zh();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void getCover(Card card, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            e.o(card, kVar);
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) card, (Object) kVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public Drawable getDefaultCoverDrawable(Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Drawable) iPatchRedirector.redirect((short) 23, (Object) this, (Object) resources);
        }
        return resources.getDrawable(R.drawable.f2v);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public int getDrawerType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        final long longAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        final String str = DRAWER_TYPE + longAccountUin;
        final MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = fromV2.decodeInt(str, 2);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeApiImpl.lambda$getDrawerType$1(longAccountUin, fromV2, str);
            }
        }, 16, null, false);
        return decodeInt;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public URLDrawable getGameCardIcon(View view, long j3, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 3, this, view, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }
        return QQSettingUtil.c(view, new IGameCardManager.a(j3, i3, z16, i16));
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    @Nullable
    public View getOnlineStatusEntranceView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (View) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context);
        }
        if (be.l()) {
            return new DrawerOnlineStatusView(context);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public Integer getPlateColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        return BusinessTintManager.instance().getPlateColor(str);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public long getQQBigMemberId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 6L;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public int getStrokeVisible(String str, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) appRuntime)).intValue();
        }
        return VasFaceManager.h(str, (QQAppInterface) appRuntime);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean hasCover(AppRuntime appRuntime, Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) appRuntime, (Object) card)).booleanValue();
        }
        if (appRuntime == null || card == null || QQTheme.isNowSimpleUI()) {
            return false;
        }
        if (!e.g() && !e.h(card) && card.isNoCover()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public View.OnTouchListener headVipReport(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View.OnTouchListener) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime, (Object) str);
        }
        ff.j.b c16 = ff.j.b.c((QQAppInterface) appRuntime, str, "VIA_SETTINGME");
        c16.d();
        return c16;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean isBigVipClub(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        return ff.C(i3);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean isCanOpenHippy(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && VasUtil.getTempApi().isCanOpenHippyPage(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean isSettingMeViewBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        return QQSettingUtil.f();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean isSuperVip(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        return ff.H(i3);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public SpannableString parseQQLevel(Resources resources, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? parseQQLevel(resources, i3, i16, i17, true) : (SpannableString) iPatchRedirector.redirect((short) 4, this, resources, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void reportCoverBg(final AppRuntime appRuntime, final Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) appRuntime, (Object) card);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeApiImpl.lambda$reportCoverBg$0(AppRuntime.this, card);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setAvatarDrawable(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) view);
            return;
        }
        if (!(view instanceof QQProAvatarView)) {
            QLog.e(TAG, 1, "setAvatar avatarView is not QQProAvatarView");
            return;
        }
        if (((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3()) {
            setAvatarDrawableV3(view);
            return;
        }
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        QLog.i(TAG, 1, "setAvatarDrawable uin:" + currentAccountUin);
        ((QQProAvatarView) view).x(1, currentAccountUin, new e.a().e(((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(currentAccountUin) ^ true).b(true).j(true).p(6).c(true).m(6).d(SimpleUIUtil.isNowSimpleMode() ^ true).n(0).o(6).g(200).a());
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setAvatarDrawableV3(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) view);
            return;
        }
        if (!(view instanceof QQProAvatarView)) {
            QLog.e(TAG, 1, "setAvatar avatarView is not QQProAvatarView");
            return;
        }
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        QLog.i(TAG, 1, "setAvatarDrawable uin:" + currentAccountUin);
        QQProAvatarView qQProAvatarView = (QQProAvatarView) view;
        qQProAvatarView.x(1, currentAccountUin, new e.a().b(true).j(true).p(6).c(true).m(6).n(0).o(6).g(200).a());
        qQProAvatarView.setDisableVasSpecialMask(true);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setIsToCloseDrawer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            DrawerFrame.f185113z0 = i3;
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setTextForAnimation(View view, SpannableStringBuilder spannableStringBuilder, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, view, spannableStringBuilder, bufferType);
        } else {
            ((AnimationTextView) view).setText(spannableStringBuilder, bufferType);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setVipCardDrawable(Resources resources, ImageView imageView, String[] strArr, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            setVipCardDrawable(resources, imageView, strArr, drawable, true);
        } else {
            iPatchRedirector.redirect((short) 13, this, resources, imageView, strArr, drawable);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setVipExtIcon(Context context, ImageView imageView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            setVipExtIcon(context, imageView, i3, true);
        } else {
            iPatchRedirector.redirect((short) 11, this, context, imageView, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void updateOnlineStatusViewPadding(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else if (view instanceof DrawerOnlineStatusView) {
            ((DrawerOnlineStatusView) view).setDrawablePadding(2);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void updateOnlineTextColor(@ColorRes int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) view);
        } else if (view instanceof DrawerOnlineStatusView) {
            ((DrawerOnlineStatusView) view).setOnlineTextColor(i3);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void updateTextColorGradientWithColor(TextView textView, String str, ColorStateList colorStateList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, textView, str, colorStateList, Boolean.valueOf(z16));
        } else if (!((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(textView, str, false, z16)) {
            textView.setTextColor(colorStateList);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public boolean userSetThemeAction(Activity activity, i71.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) activity, (Object) aVar)).booleanValue();
        }
        return DarkModeManager.w(activity, "", new a(aVar));
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void getCover(k kVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            com.tencent.util.e.n(kVar, z16);
        } else {
            iPatchRedirector.redirect((short) 22, this, kVar, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public SpannableString parseQQLevel(Resources resources, int i3, int i16, int i17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? QQSettingUtil.g(resources, i3, i16, i17, z16) : (SpannableString) iPatchRedirector.redirect((short) 5, this, resources, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setVipCardDrawable(Resources resources, ImageView imageView, String[] strArr, Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, resources, imageView, strArr, drawable, Boolean.valueOf(z16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            c.a().setVipCardDrawable(imageView, peekAppRuntime.getCurrentUin(), z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi
    public void setVipExtIcon(Context context, ImageView imageView, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            ff.j.m(context, imageView, i3, 1, z16);
        } else {
            iPatchRedirector.redirect((short) 12, this, context, imageView, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }
}
