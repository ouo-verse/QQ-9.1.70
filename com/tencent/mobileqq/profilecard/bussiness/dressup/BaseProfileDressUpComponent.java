package com.tencent.mobileqq.profilecard.bussiness.dressup;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DressUpShowType;
import com.tencent.mobileqq.data.GxhIPCollectionData;
import com.tencent.mobileqq.data.GxhSuitItemData;
import com.tencent.mobileqq.data.UsingDressUpItemData;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* loaded from: classes16.dex */
public class BaseProfileDressUpComponent extends AbsQQProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    protected static final float QQ_CARD_ASPECT_RATE = 1.42f;
    private static final String TAG = "BaseProfileDressUpComponent";
    private IVasKuiklyNestPageFrame.b bindLogic;
    protected boolean isInitDtReport;

    public BaseProfileDressUpComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.bindLogic = null;
            this.isInitDtReport = false;
        }
    }

    private void bindKuiklyViewToContainer(final ViewGroup viewGroup, byte[] bArr, int i3) {
        if (this.bindLogic == null) {
            ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).setMqqToKuiklyData("cards_data", Base64.encodeToString(bArr, 2));
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
            arrayMap.put("show_type", String.valueOf(i3));
            final String buildVasKuiklySchema = ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).buildVasKuiklySchema("vas_profile_gxh_display", "vas_profile_gxh_display", arrayMap);
            this.bindLogic = ((IVasKuiklyNestPageFrame) QRoute.api(IVasKuiklyNestPageFrame.class)).newFrame("vas_profile_gxh_suit", new Function0() { // from class: com.tencent.mobileqq.profilecard.bussiness.dressup.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String lambda$bindKuiklyViewToContainer$1;
                    lambda$bindKuiklyViewToContainer$1 = BaseProfileDressUpComponent.lambda$bindKuiklyViewToContainer$1(buildVasKuiklySchema);
                    return lambda$bindKuiklyViewToContainer$1;
                }
            });
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.dressup.c
                @Override // java.lang.Runnable
                public final void run() {
                    BaseProfileDressUpComponent.this.lambda$bindKuiklyViewToContainer$2(viewGroup);
                }
            });
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", Base64.encodeToString(bArr, 2));
        this.bindLogic.sentEvent("refresh", hashMap);
    }

    private String getJumpUrl(Card card) {
        if (isShowSuit(card)) {
            return card.dressSuitJumpUrl;
        }
        if (isShowIP(card)) {
            return card.ipCardsJumpUrl;
        }
        return card.dressUpJumpUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindKuiklyViewToContainer$2(ViewGroup viewGroup) {
        IVasKuiklyNestPageFrame.b bVar = this.bindLogic;
        if (bVar != null) {
            bVar.h0(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setTitles$0(View view) {
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        ProfileCardDtReportUtil.dtReportClick(view);
        if (!hf0.a.a("BaseProfileDressUpComponentdress")) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                QQToast.makeText(view.getContext(), "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee", 0).show();
            } else {
                Object tag = view.getTag();
                if ((tag instanceof com.tencent.mobileqq.profile.b) && ((com.tencent.mobileqq.profile.b) tag).f260135a == 113) {
                    String jumpUrl = getJumpUrl(((ProfileCardInfo) this.mData).card);
                    if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.mActivity, jumpUrl, 1039, null);
                    } else {
                        Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                        intent.putExtra("url", jumpUrl);
                        this.mActivity.startActivityForResult(intent, 1039);
                    }
                    DATA data = this.mData;
                    if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
                        Card card = ((ProfileCardInfo) data).card;
                        if (isShowSuit(((ProfileCardInfo) data).card)) {
                            str2 = "0X800C5E9";
                        } else {
                            str2 = "0X800C4D1";
                        }
                        onReport(card, str2);
                    } else {
                        Card card2 = ((ProfileCardInfo) data).card;
                        if (isShowSuit(((ProfileCardInfo) data).card)) {
                            str = "0X800C5EB";
                        } else {
                            str = "0X800C4D3";
                        }
                        onReport(card2, str);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void onReport(Card card, String str) {
        try {
            if (isShowSuit(card)) {
                List<GxhSuitItemData> list = card.dressSuits;
                if (list != null && !list.isEmpty()) {
                    int min = Math.min(list.size(), 4);
                    for (int i3 = 0; i3 < min; i3++) {
                        ReportController.o(this.mApp, "dc00898", "", "", str, str, list.get(i3).getId(), 0, "", "", "", "");
                    }
                    return;
                }
                return;
            }
            List<UsingDressUpItemData> list2 = card.dressUpList;
            if (list2 != null && !list2.isEmpty()) {
                int min2 = Math.min(list2.size(), 4);
                for (int i16 = 0; i16 < min2; i16++) {
                    ReportController.o(this.mApp, "dc00898", "", "", str, str, list2.get(i16).reportAppid, 0, "", "", "", "");
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
    }

    private void setItemBackground(Card card, List<ImageView> list, int i3) {
        String str = card.dressUpList.get(i3).itemBgColor;
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            list.get(i3).setBackground(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{Color.parseColor(str.replace("#", "#7F")), Color.parseColor(str.replace("#", "#4C"))}));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showImageView(boolean z16) {
        int i3;
        int i16;
        int i17;
        View findViewById = ((View) this.mViewContainer).findViewById(R.id.f7844473);
        int i18 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        View findViewById2 = ((View) this.mViewContainer).findViewById(R.id.f7845474);
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        findViewById2.setVisibility(i16);
        View findViewById3 = ((View) this.mViewContainer).findViewById(R.id.f7846475);
        if (z16) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        findViewById3.setVisibility(i17);
        View findViewById4 = ((View) this.mViewContainer).findViewById(R.id.f7847476);
        if (!z16) {
            i18 = 8;
        }
        findViewById4.setVisibility(i18);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1043;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public List<ImageView> getImageViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.xmp);
        ImageView imageView2 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.xmq);
        ImageView imageView3 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.xmr);
        ImageView imageView4 = (ImageView) ((View) this.mViewContainer).findViewById(R.id.xms);
        ArrayList arrayList = new ArrayList();
        arrayList.add(imageView);
        arrayList.add(imageView2);
        arrayList.add(imageView3);
        arrayList.add(imageView4);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLayoutRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.layout.h0t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPhotoSize() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        Resources resources = this.mActivity.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.aie);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.a06);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.f159311a03) + ViewUtils.dpToPx(32.0f);
        View containerView = getContainerView();
        if (containerView != null) {
            i3 = containerView.getMeasuredWidth();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            i3 = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        int i16 = (i3 - dimensionPixelSize2) - dimensionPixelSize3;
        int i17 = (int) ((i16 - ((dimensionPixelSize * 3) * 1.0f)) / 4.0f);
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, String.format(Locale.getDefault(), "makeOrRefresh photo:%s, margin:%s, max: %s", Integer.valueOf(i17), Integer.valueOf(dimensionPixelSize), Integer.valueOf(i16)));
        }
        return i17;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_DRESSUP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public List<TextView> getTextViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.xmy);
        TextView textView2 = (TextView) ((View) this.mViewContainer).findViewById(R.id.xmz);
        TextView textView3 = (TextView) ((View) this.mViewContainer).findViewById(R.id.f165807xn0);
        TextView textView4 = (TextView) ((View) this.mViewContainer).findViewById(R.id.f165808xn1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(textView);
        arrayList.add(textView2);
        arrayList.add(textView3);
        arrayList.add(textView4);
        return arrayList;
    }

    protected boolean hasToShow(Card card) {
        List<UsingDressUpItemData> list;
        List<GxhSuitItemData> list2;
        List<GxhIPCollectionData> list3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) card)).booleanValue();
        }
        if (card != null && card.dressUpIsOn && (((list = card.dressUpList) != null && !list.isEmpty()) || (((list2 = card.dressSuits) != null && !list2.isEmpty()) || ((list3 = card.ipCards) != null && !list3.isEmpty())))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View, VIEW] */
    public void initStyle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (this.mViewContainer == 0) {
            ?? inflate = LayoutInflater.from(this.mActivity).inflate(getLayoutRes(), (ViewGroup) null);
            inflate.findViewById(R.id.icon).setBackgroundResource(R.drawable.qui_skin);
            this.mViewContainer = inflate;
        }
    }

    protected boolean isDressUp(Card card) {
        DressUpShowType dressUpShowType;
        List<UsingDressUpItemData> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) card)).booleanValue();
        }
        if (card != null && card.dressUpIsOn && (dressUpShowType = card.dressUpShowType) != null && dressUpShowType == DressUpShowType.DRESSUP && (list = card.dressUpList) != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    protected boolean isOn(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) card)).booleanValue();
        }
        if (card != null && card.dressUpIsOn) {
            return true;
        }
        return false;
    }

    protected boolean isShowIP(Card card) {
        DressUpShowType dressUpShowType;
        List<GxhIPCollectionData> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) card)).booleanValue();
        }
        if (card != null && card.dressUpIsOn && (dressUpShowType = card.dressUpShowType) != null && dressUpShowType == DressUpShowType.IP && (list = card.ipCards) != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    protected boolean isShowSuit(Card card) {
        DressUpShowType dressUpShowType;
        List<GxhSuitItemData> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) card)).booleanValue();
        }
        if (card != null && card.dressUpIsOn && (dressUpShowType = card.dressUpShowType) != null && dressUpShowType == DressUpShowType.SUIT && (list = card.dressSuits) != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean makeOrRefreshDressUp(Card card, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, card, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (!ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy() && card != null && z16 && !skipShow(z17) && !ProfilePAUtils.isNotShowPresent(((ProfileCardInfo) this.mData).allInOne)) {
            initStyle((View) this.mViewContainer);
            ViewGroup viewGroup = (ViewGroup) ((View) this.mViewContainer).findViewById(R.id.xmj);
            TextView textView = (TextView) ((View) this.mViewContainer).findViewById(R.id.jj7);
            ImageView imageView = (ImageView) ((View) this.mViewContainer).findViewById(R.id.dcv);
            View findViewById = ((View) this.mViewContainer).findViewById(R.id.icon);
            List<ImageView> imageViews = getImageViews();
            List<TextView> textViews = getTextViews();
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            changeEmptyAndRefreshStatus(!z17);
            if (z17) {
                viewGroup.setVisibility(0);
                onExposeReport();
                resetViews(imageViews, textViews);
                bindKuiklyViewToContainer(viewGroup, card.dressByte, DressUpShowType.toInt(card.dressUpShowType));
            } else {
                viewGroup.setVisibility(8);
            }
            setTitles(textView);
            updateItemTheme((View) this.mViewContainer, textView, findViewById, null, imageView);
            return true;
        }
        if (this.mViewContainer != 0 && card != null) {
            z18 = true;
        }
        this.mViewContainer = null;
        return z18;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onDestroy();
        IVasKuiklyNestPageFrame.b bVar = this.bindLogic;
        if (bVar != null) {
            bVar.detachView();
            this.bindLogic = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onExposeReport() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        if (!this.isInitDtReport) {
            this.isInitDtReport = true;
            DATA data = this.mData;
            Card card = ((ProfileCardInfo) data).card;
            if (((ProfileCardInfo) data).allInOne.f260789pa == 0) {
                if (isShowSuit(((ProfileCardInfo) data).card)) {
                    str = "0X800C5E8";
                } else {
                    str = "0X800C4D0";
                }
            } else if (isShowSuit(((ProfileCardInfo) data).card)) {
                str = "0X800C5EA";
            } else {
                str = "0X800C4D2";
            }
            onReport(card, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetViews(List<ImageView> list, List<TextView> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) list, (Object) list2);
            return;
        }
        showImageView(false);
        for (ImageView imageView : list) {
            imageView.setBackground(null);
            imageView.setImageDrawable(null);
        }
        for (TextView textView : list2) {
            textView.setText("");
            textView.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setTitles(TextView textView) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) textView);
            return;
        }
        String str2 = ((ProfileCardInfo) this.mData).card.dressUpTitle;
        TextView textView2 = (TextView) ((View) this.mViewContainer).findViewById(R.id.f95745ft);
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            textView2.setText("\u53bb\u88c5\u626e");
            if (str2.length() > 1) {
                str = "\u6211" + ((ProfileCardInfo) this.mData).card.dressUpTitle.substring(1);
            } else {
                str = "\u6211\u6b63\u5728\u7528\u7684\u88c5\u626e";
            }
        } else {
            textView2.setText("");
            DATA data = this.mData;
            if (((ProfileCardInfo) data).card.shGender == 1) {
                if (str2.length() > 2) {
                    str = "\u5979" + ((ProfileCardInfo) this.mData).card.dressUpTitle.substring(2);
                } else {
                    str = "\u5979\u6b63\u5728\u7528\u7684\u88c5\u626e";
                }
            } else if (((ProfileCardInfo) data).card.shGender == 0) {
                if (str2.length() > 2) {
                    str = "\u4ed6" + ((ProfileCardInfo) this.mData).card.dressUpTitle.substring(2);
                } else {
                    str = "\u4ed6\u6b63\u5728\u7528\u7684\u88c5\u626e";
                }
            } else {
                str = ((ProfileCardInfo) data).card.dressUpTitle;
            }
        }
        textView.setText(str);
        ((View) this.mViewContainer).setTag(new com.tencent.mobileqq.profile.b(113, null));
        ((View) this.mViewContainer).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.dressup.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseProfileDressUpComponent.this.lambda$setTitles$0(view);
            }
        });
        ((View) this.mViewContainer).setContentDescription(this.mActivity.getString(R.string.f175862zp));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean skipShow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, z16)).booleanValue();
        }
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 0 && !z16) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileDressUpComponent) profileCardInfo);
        DATA data = this.mData;
        return lambda$checkValidComponent$3 | makeOrRefreshDressUp(((ProfileCardInfo) data).card, isOn(((ProfileCardInfo) data).card), hasToShow(((ProfileCardInfo) this.mData).card));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$bindKuiklyViewToContainer$1(String str) {
        return str;
    }
}
