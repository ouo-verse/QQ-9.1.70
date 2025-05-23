package com.tencent.mobileqq.troop.troopnotification.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopnotification.render.TroopNotificationRender;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationTagParser;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bJ\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/utils/e;", "", "Landroid/widget/TextView;", "levelView", "", "bSuperVipOpen", "bQQVipOpen", "", "iVipLevel", "Landroid/text/SpannableString;", "b", "", "memberUin", "", "d", "Landroid/content/Context;", "ctx", "uin", "a", "", "Lcom/tencent/qqnt/notification/f;", "notificationList", "c", "Lcom/tencent/mobileqq/data/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "e", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f300928a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/utils/e$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", "progress", "onLoadProgressed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<TextView> f300929d;

        a(WeakReference<TextView> weakReference) {
            this.f300929d = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            } else {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable drawable, @NotNull Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable, (Object) cause);
            } else {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                Intrinsics.checkNotNullParameter(cause, "cause");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, progress);
            } else {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable drawable) {
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            WeakReference<TextView> weakReference = this.f300929d;
            if (weakReference != null && (textView = weakReference.get()) != null) {
                textView.postInvalidate();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59768);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f300928a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SpannableString b(TextView levelView, boolean bSuperVipOpen, boolean bQQVipOpen, int iVipLevel) {
        URLDrawable uRLDrawable;
        WeakReference weakReference = new WeakReference(levelView);
        Resources resources = levelView.getContext().getResources();
        SpannableString spannableString = new SpannableString("");
        int dimension = (int) resources.getDimension(R.dimen.b65);
        if (bSuperVipOpen && iVipLevel > 0) {
            spannableString = new SpannableString("sb");
            Drawable drawable = resources.getDrawable(R.drawable.bhl);
            uRLDrawable = URLDrawable.getDrawable("https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_" + iVipLevel + ".png", drawable, drawable);
            int i3 = (int) (68 * (dimension / 24.0d));
            if (uRLDrawable != null) {
                uRLDrawable.setBounds(0, 0, i3, dimension);
            }
        } else if (bQQVipOpen && iVipLevel > 0) {
            spannableString = new SpannableString("vb");
            Drawable drawable2 = resources.getDrawable(R.drawable.bhm);
            uRLDrawable = URLDrawable.getDrawable("https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_" + iVipLevel + ".png", drawable2, drawable2);
            int i16 = (int) (58 * (dimension / 24.0d));
            if (uRLDrawable != null) {
                uRLDrawable.setBounds(0, 0, i16, dimension);
            }
        } else {
            uRLDrawable = null;
        }
        if (uRLDrawable != null) {
            uRLDrawable.mutate();
            uRLDrawable.setURLDrawableListener(new a(weakReference));
            spannableString.setSpan(new ImageSpan(uRLDrawable), 0, 1, 33);
            Drawable drawable3 = resources.getDrawable(R.drawable.f57);
            drawable3.setBounds(0, 0, (int) resources.getDimension(R.dimen.f159034uh), dimension);
            spannableString.setSpan(new ImageSpan(drawable3), 1, 2, 33);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("TroopNotificationLevelViewHelper", 4, "parseClubLevel, bSuperVipOpen=" + bSuperVipOpen + ", bQQVipOpen=" + bQQVipOpen + ",iVipLevel=" + iVipLevel);
        }
        return spannableString;
    }

    public final int a(@NotNull Context ctx, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ctx, (Object) uin)).intValue();
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return PreferenceManager.getDefaultSharedPreferences(ctx).getInt(uin + "_show", 0);
    }

    @NotNull
    public final List<String> c(@NotNull List<com.tencent.qqnt.notification.f> notificationList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) notificationList);
        }
        Intrinsics.checkNotNullParameter(notificationList, "notificationList");
        ArrayList arrayList = new ArrayList();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) bg.l(ITroopRobotService.class);
        for (com.tencent.qqnt.notification.f fVar : notificationList) {
            Map<String, Object> b16 = fVar.i().b();
            TroopNotificationTagParser troopNotificationTagParser = TroopNotificationTagParser.f300743a;
            Object obj = b16.get(troopNotificationTagParser.getKey());
            if (obj instanceof String) {
                String h16 = troopNotificationTagParser.h(TroopNotificationRender.f300720a.w((String) obj, fVar.i().a()));
                boolean z17 = false;
                if (h16 != null && h16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (iTroopRobotService != null && iTroopRobotService.isRobotUin(h16)) {
                        z17 = true;
                    }
                    if (!z17) {
                        arrayList.add(h16);
                        fVar.p(h16);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void d(@NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) memberUin);
            return;
        }
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        AppRuntime f16 = bg.f();
        if (f16 == null) {
            return;
        }
        String curAccount = f16.getCurrentAccountUin();
        IProfileProtocolService iProfileProtocolService = (IProfileProtocolService) bg.l(IProfileProtocolService.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Intrinsics.checkNotNullExpressionValue(curAccount, "curAccount");
        byte a16 = (byte) a(context, curAccount);
        byte[] bArr = {0};
        byte[] bArr2 = {0};
        if (iProfileProtocolService != null) {
            iProfileProtocolService.requestProfileCard(curAccount, memberUin, 1, 0L, (byte) 1, 0L, 0L, bArr, "", 1L, 10004, bArr2, a16);
        }
    }

    public final void e(@NotNull TextView levelView, @NotNull Card card) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) levelView, (Object) card);
            return;
        }
        Intrinsics.checkNotNullParameter(levelView, "levelView");
        Intrinsics.checkNotNullParameter(card, "card");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z17 = true;
        if (card.bSuperVipOpen == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (card.bQQVipOpen != 1) {
            z17 = false;
        }
        int i3 = card.iQQVipLevel;
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationLevelViewHelper", 2, "updateLevelAndVip bSuperVipOpen=" + z16 + ",bQQVipOpen=" + z17 + ",VipLevel=" + i3 + ",QQLevel=" + card.iQQLevel);
        }
        if (z16 || z17) {
            spannableStringBuilder.append((CharSequence) b(levelView, z16, z17, (int) Math.max(i3, 1.0d)));
        }
        if (card.iQQLevel >= 0) {
            spannableStringBuilder.append((CharSequence) LevelUtil.parseQQLevel(levelView.getContext(), 15, card.mQQLevelType, card.iQQLevel, false));
        }
        levelView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }
}
