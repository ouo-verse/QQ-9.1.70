package com.tencent.mobileqq.profilecard.bussiness.qqcard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQCardItemData;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.ErrorCode;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class BaseProfileQQCardComponent extends BaseProfileDressUpComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BaseProfileQQCardComponent";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class BgDrawable extends Drawable {
        static IPatchRedirector $redirector_;
        private int bgColor;

        public BgDrawable(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseProfileQQCardComponent.this, (Object) context);
            } else {
                this.bgColor = context.getColor(R.color.qui_common_bg_bottom_standard);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            } else {
                canvas.drawColor(this.bgColor);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorFilter);
            }
        }
    }

    public BaseProfileQQCardComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$setTitles$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ProfileCardDtReportUtil.dtReportClick(view);
        Object tag = view.getTag();
        if ((tag instanceof b) && ((b) tag).f260135a == 114) {
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this.mActivity, ((ProfileCardInfo) this.mData).card.qqCardJumpUrl, 1039, null);
            } else {
                Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", ((ProfileCardInfo) this.mData).card.qqCardJumpUrl);
                this.mActivity.startActivityForResult(intent, 1039);
            }
            onReport(124);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onReport(int i3) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                str = "owner";
            } else {
                str = IGameCardManager.VISITOR;
            }
            jSONObject.putOpt("status", str);
            MobileReportManager.getInstance().reportAction("", "0", "data_card", "data_card_page", "qq_card", i3, 1, System.currentTimeMillis(), jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1044;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_QQCARD;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    protected boolean hasToShow(Card card) {
        List<QQCardItemData> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) card)).booleanValue();
        }
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        QLog.e(TAG, 1, "hasToShow isStudyMode=" + studyModeSwitch);
        if (card != null && card.qqCardIsOn && (list = card.qqCardList) != null && !list.isEmpty() && !studyModeSwitch) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View, VIEW] */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    public void initStyle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        if (this.mViewContainer == 0) {
            ?? inflate = LayoutInflater.from(this.mActivity).inflate(getLayoutRes(), (ViewGroup) null);
            inflate.findViewById(R.id.icon).setBackgroundResource(R.drawable.qui_qq_card);
            this.mViewContainer = inflate;
        }
        for (ImageView imageView : getImageViews()) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            int photoSize = getPhotoSize();
            layoutParams.width = photoSize;
            layoutParams.height = (int) (photoSize * 1.42f);
            imageView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    protected boolean isOn(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) card)).booleanValue();
        }
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (card != null && card.qqCardIsOn && !studyModeSwitch) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    protected boolean isShowSuit(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) card)).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    public boolean makeOrRefreshDressUp(Card card, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, card, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
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
                setViews(card, imageViews, textViews);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    protected void onExposeReport() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!this.isInitDtReport) {
            this.isInitDtReport = true;
            onReport(111);
            try {
                List<QQCardItemData> list = ((ProfileCardInfo) this.mData).card.qqCardList;
                JSONObject jSONObject = new JSONObject();
                if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                    str = "owner";
                } else {
                    str = IGameCardManager.VISITOR;
                }
                jSONObject.putOpt("status", str);
                if (list != null && !list.isEmpty()) {
                    int min = Math.min(list.size(), 4);
                    for (int i3 = 0; i3 < min; i3++) {
                        MobileReportManager.getInstance().reportAction(list.get(i3).cardId, ErrorCode.ERR_NET, "data_card", "data_card_page", "qq_card", 101, 1, System.currentTimeMillis(), jSONObject.toString());
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.getCause(), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    public void resetViews(List<ImageView> list, List<TextView> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) list, (Object) list2);
            return;
        }
        super.resetViews(list, list2);
        ((RoundRelativeLayout) ((View) this.mViewContainer).findViewById(R.id.f7844473)).f316195e = ViewUtils.dpToPx(2.0f);
        ((RoundRelativeLayout) ((View) this.mViewContainer).findViewById(R.id.f7845474)).f316195e = ViewUtils.dpToPx(2.0f);
        ((RoundRelativeLayout) ((View) this.mViewContainer).findViewById(R.id.f7846475)).f316195e = ViewUtils.dpToPx(2.0f);
        ((RoundRelativeLayout) ((View) this.mViewContainer).findViewById(R.id.f7847476)).f316195e = ViewUtils.dpToPx(2.0f);
        ((View) this.mViewContainer).findViewById(R.id.f7844473).setVisibility(0);
        ((View) this.mViewContainer).findViewById(R.id.f7845474).setVisibility(0);
        ((View) this.mViewContainer).findViewById(R.id.f7846475).setVisibility(0);
        ((View) this.mViewContainer).findViewById(R.id.f7847476).setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    protected void setTitles(TextView textView) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) textView);
            return;
        }
        try {
            jSONObject = new JSONObject(new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("vas_profile_qqcard", new byte[0]), StandardCharsets.UTF_8).trim());
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getCause(), new Object[0]);
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("self_main_title", HardCodeUtil.qqStr(R.string.f1761030c));
        String optString2 = jSONObject.optString("guest_main_title", this.mActivity.getString(R.string.f1761030c));
        String optString3 = jSONObject.optString("self_subtitle", "\u53bb\u62bd\u5361\u8bd5\u8bd5\u624b\u6c14");
        String optString4 = jSONObject.optString("guest_subtitle", "\u53bb\u62bd\u5361\u8bd5\u8bd5\u624b\u6c14");
        TextView textView2 = (TextView) ((View) this.mViewContainer).findViewById(R.id.f95745ft);
        if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
            textView2.setText(optString3);
        } else {
            textView2.setText(optString4);
            optString = optString2;
        }
        if (!hasToShow(((ProfileCardInfo) this.mData).card)) {
            textView2.setText("\u53bb\u62bd\u5361");
        }
        textView.setText(optString);
        ((View) this.mViewContainer).setTag(new b(114, null));
        ((View) this.mViewContainer).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.qqcard.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseProfileQQCardComponent.this.lambda$setTitles$0(view);
            }
        });
        ((View) this.mViewContainer).setContentDescription(this.mActivity.getString(R.string.f1761030c));
    }

    protected void setViews(Card card, List<ImageView> list, List<TextView> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, card, list, list2);
            return;
        }
        int photoSize = getPhotoSize();
        List<QQCardItemData> list3 = card.qqCardList;
        if (list3 != null && !list3.isEmpty()) {
            int min = Math.min(list3.size(), 4);
            ColorDrawable colorDrawable = null;
            for (int i3 = 0; i3 < min; i3++) {
                String str = list3.get(i3).url;
                if (!TextUtils.isEmpty(str)) {
                    if (colorDrawable == null) {
                        colorDrawable = new ColorDrawable(this.mActivity.getResources().getColor(R.color.f157194kw));
                    }
                    try {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mLoadingDrawable = colorDrawable;
                        obtain.mFailedDrawable = colorDrawable;
                        obtain.mRequestHeight = (int) (photoSize * 1.42f);
                        obtain.mRequestWidth = photoSize;
                        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
                        ImageView imageView = list.get(i3);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setImageDrawable(drawable);
                        imageView.setBackground(new BgDrawable(imageView.getContext()));
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "makeOrRefreshPresent fail!", e16);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.dressup.BaseProfileDressUpComponent
    protected boolean skipShow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, z16)).booleanValue();
        }
        return false;
    }
}
