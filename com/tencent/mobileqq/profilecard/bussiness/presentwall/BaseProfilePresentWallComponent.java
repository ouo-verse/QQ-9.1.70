package com.tencent.mobileqq.profilecard.bussiness.presentwall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardReport;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ad;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

/* loaded from: classes16.dex */
public class BaseProfilePresentWallComponent extends AbsQQProfileContentComponent implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseProfilePresentWallComponent";
    View.OnClickListener mOnClickListener;
    MqqHandler mReportHandler;

    public BaseProfilePresentWallComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.mReportHandler = new ad(Looper.getMainLooper(), this);
            this.mOnClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.presentwall.BaseProfilePresentWallComponent.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProfilePresentWallComponent.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        ProfileCardDtReportUtil.dtReportClick(view);
                        Object tag = view.getTag();
                        if ((tag instanceof b) && ((b) tag).f260135a == 94) {
                            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(((AbsComponent) BaseProfilePresentWallComponent.this).mActivity, ((ProfileCardInfo) ((AbsComponent) BaseProfilePresentWallComponent.this).mData).card.presentCustourl);
                            } else {
                                Intent intent = new Intent(((AbsComponent) BaseProfilePresentWallComponent.this).mActivity, (Class<?>) QQBrowserActivity.class);
                                intent.putExtra("url", ((ProfileCardInfo) ((AbsComponent) BaseProfilePresentWallComponent.this).mData).card.presentCustourl);
                                ((AbsComponent) BaseProfilePresentWallComponent.this).mActivity.startActivity(intent);
                            }
                            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.presentwall.BaseProfilePresentWallComponent.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences("showPresentRed", 0).edit();
                                    edit.putBoolean("showRed", false);
                                    ea.i(edit);
                                }
                            });
                            if (((ProfileCardInfo) ((AbsComponent) BaseProfilePresentWallComponent.this).mData).allInOne.f260789pa == 0) {
                                ReportController.o(((AbsComponent) BaseProfilePresentWallComponent.this).mApp, "", "", "", "0X800A1C7", "0X800A1C7", 0, 0, "", "", "", "");
                            } else {
                                ReportController.o(((AbsComponent) BaseProfilePresentWallComponent.this).mApp, "", "", "", "0X800A1C9", "0X800A1C9", 0, 0, "", "", "", "");
                            }
                            if (((ProfileCardInfo) ((AbsComponent) BaseProfilePresentWallComponent.this).mData).allInOne.f260789pa == 20 || ((ProfileCardInfo) ((AbsComponent) BaseProfilePresentWallComponent.this).mData).allInOne.f260789pa == 21) {
                                BaseProfilePresentWallComponent.this.troopMemberGiftWallReport(102);
                            }
                            ProfileCardReport.reportPresentClick(((AbsQQProfileContentComponent) BaseProfilePresentWallComponent.this).mQQAppInterface, (ProfileCardInfo) ((AbsComponent) BaseProfilePresentWallComponent.this).mData);
                        }
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1018;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_PRESENT;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        MobileReportManager.getInstance().reportAction("giftwall", "4", "group_gift", "9", "", message.what, 1, System.currentTimeMillis());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshPresent(Card card, boolean z16) {
        boolean z17;
        String str;
        String str2;
        ColorDrawable colorDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, card, Boolean.valueOf(z16))).booleanValue();
        }
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
            if (this.mViewContainer == 0) {
                z18 = false;
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
        QZLog.d(TAG, 2, "cardInfo.allinone.pa" + ((ProfileCardInfo) this.mData).allInOne.f260789pa);
        if (card.presentSwitch && !ProfilePAUtils.isNotShowPresent(((ProfileCardInfo) this.mData).allInOne)) {
            DATA data = this.mData;
            if (((ProfileCardInfo) data).allInOne.f260789pa == 20 || ((ProfileCardInfo) data).allInOne.f260789pa == 21) {
                troopMemberGiftWallReport(101);
            }
            ?? inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.cbo, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.icon);
            findViewById.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_present, R.drawable.qui_gift));
            this.mViewContainer = inflate;
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.llx);
            TextView textView = (TextView) inflate.findViewById(R.id.jj7);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.dcv);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.lly);
            ImageView imageView3 = (ImageView) inflate.findViewById(R.id.llz);
            ImageView imageView4 = (ImageView) inflate.findViewById(R.id.f165803lm0);
            ImageView imageView5 = (ImageView) inflate.findViewById(R.id.f165804lm1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(imageView2);
            arrayList.add(imageView3);
            arrayList.add(imageView4);
            arrayList.add(imageView5);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            if (card.showPresent && card.presentUrl != null) {
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
            inflate.setTag(new b(94, null));
            inflate.setOnClickListener(this.mOnClickListener);
            inflate.setContentDescription(this.mActivity.getString(R.string.imj));
            updateItemTheme(inflate, textView, findViewById, null, imageView);
            return true;
        }
        if (this.mViewContainer != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mViewContainer = null;
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void troopMemberGiftWallReport(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.mReportHandler.removeMessages(i3);
        Message obtain = Message.obtain();
        obtain.what = i3;
        this.mReportHandler.sendMessageDelayed(obtain, 600L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean onDataUpdate = super.onDataUpdate((BaseProfilePresentWallComponent) profileCardInfo);
        DATA data = this.mData;
        return onDataUpdate | makeOrRefreshPresent(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
    }
}
