package com.tencent.mobileqq.businessCard.utilities;

import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.b;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c$CardInfo;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BusinessCardUtils {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f200908d;

        a(URLImageView uRLImageView) {
            this.f200908d = uRLImageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uRLImageView);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, uRLDrawable, th5);
            } else {
                this.f200908d.setVisibility(8);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) uRLDrawable);
            } else {
                this.f200908d.setVisibility(0);
            }
        }
    }

    public static BusinessCard a(AppInterface appInterface, ProfileCardInfo profileCardInfo) {
        BusinessCard businessCard;
        BusinessCardManager businessCardManager = (BusinessCardManager) appInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            businessCard = businessCardManager.l();
        } else {
            Card card = profileCardInfo.card;
            if (card != null) {
                BusinessCard b16 = b(card.bCardInfo);
                if (profileCardInfo.card.bCardInfo != null && !TextUtils.isEmpty(b16.cardId)) {
                    businessCardManager.d(profileCardInfo.allInOne.uin, b16);
                    businessCard = b16;
                } else {
                    businessCard = businessCardManager.m(profileCardInfo.allInOne.uin);
                }
            } else {
                businessCard = null;
            }
        }
        if (businessCard == null) {
            return new BusinessCard();
        }
        return businessCard;
    }

    public static BusinessCard b(byte[] bArr) {
        Oidb_0x43c$CardInfo oidb_0x43c$CardInfo = new Oidb_0x43c$CardInfo();
        BusinessCard businessCard = new BusinessCard();
        if (bArr != null) {
            try {
                oidb_0x43c$CardInfo.mergeFrom(bArr);
                b.b(businessCard, oidb_0x43c$CardInfo);
            } catch (Exception e16) {
                QLog.e("BusinessCardUtils", 1, "getBusinessCardInfo fail.", e16);
            }
        }
        return businessCard;
    }

    public static BusinessCard c(QQAppInterface qQAppInterface) {
        BusinessCard businessCard;
        BusinessCardManager businessCardManager = (BusinessCardManager) qQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
        if (businessCardManager != null) {
            businessCard = businessCardManager.l();
        } else {
            businessCard = null;
        }
        if (businessCard == null) {
            return new BusinessCard();
        }
        return businessCard;
    }

    public static void d(String str) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = 1000;
            obtain.mRequestHeight = 600;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) URLDrawable.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        URLDrawable.this.downloadImediatly();
                    }
                }
            }, 8, null, true);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void e(String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("errorCode", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "ocr_user_edit_action_report", true, 0L, 0L, hashMap, null);
    }

    public static void f(String str, URLImageView uRLImageView, int i3, int i16) {
        if (!TextUtils.isEmpty(str) && uRLImageView != null) {
            try {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = i3;
                obtain.mRequestHeight = i16;
                obtain.mLoadingDrawable = uRLImageView.getContext().getResources().getDrawable(R.drawable.ab_);
                uRLImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
                uRLImageView.setURLDrawableDownListener(new a(uRLImageView));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BusinessCard", 2, "error " + e16.toString());
                }
            }
        }
    }
}
