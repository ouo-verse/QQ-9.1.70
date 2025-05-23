package com.tencent.mobileqq.profilecard.bussiness.musicbox;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.api.IListenTogetherManagerApi;
import com.tencent.mobileqq.profile.musicbox.a;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.TokenResUtils;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class ProfileMusicBoxComponent extends AbsQQProfileContentComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String DT_REPORT_PARAM_IS_EMPTY = "profile_em_is_empty";
    private static final int DT_REPORT_PARAM_IS_NOT_EMPTY = 2;
    private static final int DT_REPORT_PARAM_ITEM_IS_EMPTY = 1;
    private static final String TAG = "ProfileMusicBoxComponent";
    private boolean isInitDtReport;

    public ProfileMusicBoxComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        } else {
            this.isInitDtReport = false;
        }
    }

    private void setReportElementParams(Card card) {
        int i3;
        HashMap hashMap = new HashMap();
        if (card != null && !TextUtils.isEmpty(card.songId)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("profile_em_is_empty", Integer.valueOf(i3));
        VideoReport.setElementParams(this.mViewContainer, hashMap);
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
        return 1017;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_MUSIC_BOX;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View, VIEW] */
    public boolean makeOrRefreshMusicBox(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) card)).booleanValue();
        }
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
            return true;
        }
        a aVar = new a(false);
        ?? d16 = aVar.d(this.mActivity, card.uin);
        d16.setTag(R.layout.ccx, aVar);
        if (d16.getTag(R.layout.ccx) != null) {
            ((a) d16.getTag(R.layout.ccx)).m((ProfileCardInfo) this.mData);
        }
        if (this.mViewContainer != 0) {
            return true;
        }
        this.mViewContainer = d16;
        ProfileCardDtReportUtil.initElementWithExposureClick(d16, ProfileCardDtReportUtil.DT_REPORT_MUSICBOX);
        setReportElementParams(card);
        TextView textView = (TextView) d16.findViewById(R.id.jj7);
        ImageView imageView = (ImageView) d16.findViewById(R.id.dcv);
        View findViewById = d16.findViewById(R.id.icon);
        if (findViewById != null) {
            findViewById.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.skin_profilecard_musicbox_icon, R.drawable.qui_music_box));
        }
        if (isVasCard((ProfileCardInfo) this.mData)) {
            updateItemTheme(d16, textView, findViewById, null, imageView);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
            ((IListenTogetherManagerApi) QRoute.api(IListenTogetherManagerApi.class)).setPlayChange(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((ProfileMusicBoxComponent) profileCardInfo);
        if (a.g((ProfileCardInfo) this.mData)) {
            return lambda$checkValidComponent$3 | makeOrRefreshMusicBox(((ProfileCardInfo) this.mData).card);
        }
        boolean z16 = lambda$checkValidComponent$3 | (this.mViewContainer != 0);
        this.mViewContainer = null;
        return z16;
    }
}
