package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes16.dex */
public class ElegantProfilePresentWallComponent extends BaseProfilePresentWallComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ElegantProfilePresentWallComponent";
    private boolean isInitDtReport;

    public ElegantProfilePresentWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.isInitDtReport = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v67, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.presentwall.BaseProfilePresentWallComponent
    public boolean makeOrRefreshPresent(Card card, boolean z16) {
        boolean z17;
        String str;
        String str2;
        ColorDrawable colorDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, card, Boolean.valueOf(z16))).booleanValue();
        }
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
            if (this.mViewContainer != 0) {
                z18 = true;
            }
            this.mViewContainer = null;
            return z18;
        }
        if (card == null) {
            return false;
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            ReportController.o(this.mApp, "", "", "", "0X800A1C6", "0X800A1C6", 0, 0, "", "", "", "");
        } else {
            ReportController.o(this.mApp, "", "", "", "0X800A1C8", "0X800A1C8", 0, 0, "", "", "", "");
        }
        QZLog.d("cardInfo.allinone.pa", 2, Integer.valueOf(((ProfileCardInfo) this.mData).allInOne.f260789pa));
        if (card.presentSwitch && !ProfilePAUtils.isNotShowPresent(((ProfileCardInfo) this.mData).allInOne)) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).allInOne.f260789pa == 20 || ((ProfileCardInfo) data).allInOne.f260789pa == 21) {
                troopMemberGiftWallReport(101);
            }
            if (this.mViewContainer == 0) {
                ?? inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.cbo, (ViewGroup) null);
                inflate.findViewById(R.id.icon).setBackgroundResource(R.drawable.qui_gift);
                this.mViewContainer = inflate;
                if (!this.isInitDtReport) {
                    this.isInitDtReport = true;
                    inflate.post(new Runnable(card) { // from class: com.tencent.mobileqq.profilecard.bussiness.presentwall.ElegantProfilePresentWallComponent.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Card val$card;

                        {
                            this.val$card = card;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ElegantProfilePresentWallComponent.this, (Object) card);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            int i3 = 2;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            HashMap hashMap = new HashMap();
                            List<String> list = this.val$card.presentUrl;
                            if (list == null || list.isEmpty()) {
                                i3 = 1;
                            }
                            hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i3));
                            ProfileCardDtReportUtil.initElementWithExposure((View) ((AbsComponent) ElegantProfilePresentWallComponent.this).mViewContainer, ProfileCardDtReportUtil.DT_REPORT_GIFT_GET, hashMap);
                            VideoReport.reportEvent("imp", ((AbsComponent) ElegantProfilePresentWallComponent.this).mViewContainer, hashMap);
                        }
                    });
                }
            }
            ((View) this.mViewContainer).setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
            ViewGroup viewGroup = (ViewGroup) ((View) this.mViewContainer).findViewById(R.id.llx);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = ViewUtils.dpToPx(16.0f);
            layoutParams.rightMargin = ViewUtils.dpToPx(15.0f);
            viewGroup.setLayoutParams(layoutParams);
            TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.jj7);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.lly);
            ImageView imageView2 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.llz);
            ImageView imageView3 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f165803lm0);
            ImageView imageView4 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.f165804lm1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(imageView);
            arrayList.add(imageView2);
            arrayList.add(imageView3);
            arrayList.add(imageView4);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            if (card.showPresent && card.presentUrl != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            changeEmptyAndRefreshStatus(!z17);
            if (z17) {
                viewGroup.setVisibility(0);
                List<String> list = card.presentUrl;
                Resources resources = this.mActivity.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.aie);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.a06);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.f159311a03);
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                int min = (int) ((Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - dimensionPixelSize2) - dimensionPixelSize3);
                int i3 = (int) ((min - ((dimensionPixelSize * 3) * 1.0f)) / 3.0f);
                int i16 = 4;
                if (QLog.isColorLevel()) {
                    QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", Integer.valueOf(arrayList.size()), Integer.valueOf(i3), Integer.valueOf(dimensionPixelSize), Integer.valueOf(min)));
                }
                if (list != null && !list.isEmpty()) {
                    if (list.size() <= 4) {
                        i16 = list.size();
                    }
                    ColorDrawable colorDrawable2 = null;
                    for (int i17 = 0; i17 < i16; i17++) {
                        String str3 = list.get(i17);
                        if (!TextUtils.isEmpty(str3)) {
                            if (colorDrawable2 == null) {
                                colorDrawable = new ColorDrawable(this.mActivity.getResources().getColor(R.color.f157194kw));
                            } else {
                                colorDrawable = colorDrawable2;
                            }
                            try {
                                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                                obtain.mLoadingDrawable = colorDrawable;
                                obtain.mFailedDrawable = colorDrawable;
                                obtain.mRequestHeight = i3;
                                obtain.mRequestWidth = i3;
                                ((ImageView) arrayList.get(i17)).setImageDrawable(URLDrawable.getDrawable(str3, obtain));
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(LevelUtil.PROFILE_CARD_TAG, 2, "makeOrRefreshPresent fail!", e16);
                                }
                            }
                            colorDrawable2 = colorDrawable;
                        }
                    }
                }
            }
            DATA data2 = this.mData;
            if (((ProfileCardInfo) data2).allInOne.f260789pa == 0) {
                str = HardCodeUtil.qqStr(R.string.pe7);
            } else {
                str = ((ProfileCardInfo) data2).nameArray[0];
            }
            if (!TextUtils.isEmpty(card.presentDesc)) {
                str2 = MsgSummary.STR_COLON + card.presentDesc;
            } else {
                str2 = "";
            }
            textView.setText(str + HardCodeUtil.qqStr(R.string.ped) + str2);
            ((View) this.mViewContainer).setTag(new b(94, null));
            ((View) this.mViewContainer).setOnClickListener(this.mOnClickListener);
            ((View) this.mViewContainer).setContentDescription(this.mActivity.getString(R.string.imj));
            return true;
        }
        if (this.mViewContainer != 0) {
            z18 = true;
        }
        this.mViewContainer = null;
        return z18;
    }
}
