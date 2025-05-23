package com.tencent.mobileqq.profilecard.bussiness.qzone;

import SummaryCard.PhotoInfo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CommonUsedSystemEmojiManagerServiceProxy;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzonestatus.d;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Marker;

@Deprecated
/* loaded from: classes16.dex */
public class ProfileQZoneComponent extends BaseProfileQZoneComponent {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileQZoneComponent";

    public ProfileQZoneComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean createPhotoView(QQAppInterface qQAppInterface, Card card, ViewGroup viewGroup, PhotoInfo photoInfo, int i3, int i16, int[] iArr, int i17) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        URLDrawable.URLDrawableOptions obtain;
        boolean z18;
        boolean z19;
        String str3 = photoInfo.strPicUrl;
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.b0m, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dkv);
        View findViewById = inflate.findViewById(R.id.f165805dl0);
        View findViewById2 = inflate.findViewById(R.id.dku);
        View findViewById3 = inflate.findViewById(R.id.dkz);
        TextView textView = (TextView) inflate.findViewById(R.id.dks);
        UnderlineTextView underlineTextView = (UnderlineTextView) inflate.findViewById(R.id.dkr);
        underlineTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        Map<String, String> map = photoInfo.mapEx;
        if (map != null) {
            String str4 = map.get(CommonUsedSystemEmojiManagerServiceProxy.INFO_TYPE);
            String str5 = photoInfo.mapEx.get("feeds_content");
            z16 = "1".equals(photoInfo.mapEx.get(BaseProfileQZoneComponent.KEY_IS_VIDEO));
            str2 = str5;
            str = str4;
        } else {
            str = "";
            str2 = str;
            z16 = false;
        }
        if (TextUtils.equals(str, "1") && !TextUtils.isEmpty(str2)) {
            underlineTextView.setText(str2);
            underlineTextView.setVisibility(0);
            imageView.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = underlineTextView.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i3;
            int lineHeight = underlineTextView.getLineHeight();
            if (lineHeight > 0) {
                underlineTextView.setMaxLines(getTextCount(card));
            } else {
                QLog.w(TAG, 1, "makeOrRefreshQZone: invalid lineHeight:" + lineHeight);
            }
            z17 = true;
            str2 = TAG;
        } else if (!TextUtils.isEmpty(str3)) {
            if (this.mQzoneDefaultPic == null) {
                this.mQzoneDefaultPic = new ColorDrawable(this.mActivity.getResources().getColor(R.color.f157194kw));
            }
            try {
                obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = this.mQzoneDefaultPic;
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mFailedDrawable = colorDrawable;
                obtain.mRequestHeight = i3;
                obtain.mRequestWidth = i3;
                try {
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(LevelUtil.PROFILE_CARD_TAG, 1, "makeOrRefreshQZone fail!", e);
                    z17 = true;
                    if (z17) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str2 = TAG;
            }
            if (!str3.startsWith("http://") && !str3.startsWith("https://")) {
                if (z16) {
                    QBaseActivity qBaseActivity = this.mActivity;
                    str2 = TAG;
                    Bitmap videoThumbnail = ShortVideoUtils.getVideoThumbnail(qBaseActivity, str3, i3, 0L);
                    if (videoThumbnail != null) {
                        imageView.setImageBitmap(videoThumbnail);
                    } else {
                        imageView.setImageDrawable(this.mQzoneDefaultPic);
                    }
                } else {
                    str2 = TAG;
                    imageView.setImageDrawable(URLDrawable.getFileDrawable(str3, obtain));
                }
                if (!str3.contains("video=1") && !z16) {
                    z18 = false;
                    BaseProfileQZoneComponent.setVisible(findViewById, z18);
                    if (photoInfo.IsOnlySelf != 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    BaseProfileQZoneComponent.setVisible(findViewById3, z19);
                    z17 = true;
                }
                z18 = true;
                BaseProfileQZoneComponent.setVisible(findViewById, z18);
                if (photoInfo.IsOnlySelf != 1) {
                }
                BaseProfileQZoneComponent.setVisible(findViewById3, z19);
                z17 = true;
            }
            str2 = TAG;
            imageView.setImageDrawable(URLDrawable.getDrawable(str3, obtain));
            if (!str3.contains("video=1")) {
                z18 = false;
                BaseProfileQZoneComponent.setVisible(findViewById, z18);
                if (photoInfo.IsOnlySelf != 1) {
                }
                BaseProfileQZoneComponent.setVisible(findViewById3, z19);
                z17 = true;
            }
            z18 = true;
            BaseProfileQZoneComponent.setVisible(findViewById, z18);
            if (photoInfo.IsOnlySelf != 1) {
            }
            BaseProfileQZoneComponent.setVisible(findViewById3, z19);
            z17 = true;
        } else {
            str2 = TAG;
            z17 = false;
        }
        if (z17) {
            QLog.w(str2, 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
            return false;
        }
        viewGroup.addView(inflate);
        ViewGroup.LayoutParams layoutParams2 = inflate.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
            layoutParams3.rightMargin = i16;
            inflate.setLayoutParams(layoutParams3);
        }
        ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
        if (isDIYTemplateProfile()) {
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        } else {
            layoutParams4.width = i3;
            layoutParams4.height = i3;
        }
        imageView.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = findViewById2.getLayoutParams();
        if (isDIYTemplateProfile()) {
            layoutParams5.width = -1;
            layoutParams5.height = -1;
        } else {
            layoutParams5.width = i3;
            layoutParams5.height = i3;
        }
        findViewById2.setLayoutParams(layoutParams5);
        int i18 = iArr[0];
        if (i18 > 0) {
            iArr[0] = i18 + i16;
        }
        int i19 = iArr[0] + i3;
        iArr[0] = i19;
        if (i19 + i3 + i16 > i17) {
            log(String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", Integer.valueOf(iArr[0]), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
            return true;
        }
        findViewById2.setVisibility(8);
        textView.setVisibility(8);
        return false;
    }

    private String getNoPhotoInfoStr(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo, Card card, boolean z16, ViewGroup viewGroup) {
        String format;
        int i3;
        if (!z16 && card.isShowFeeds() && !TextUtils.isEmpty(card.strQzoneFeedsDesc)) {
            return d.e(card.strQzoneFeedsDesc, qQAppInterface);
        }
        if (!TextUtils.isEmpty(card.strSpaceName)) {
            return card.strSpaceName;
        }
        String genderName = getGenderName(profileCardInfo);
        if (profileCardInfo.allInOne.f260789pa == 0) {
            genderName = HardCodeUtil.qqStr(R.string.pel);
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity != null) {
            format = String.format("%s%s", genderName, qBaseActivity.getString(R.string.bwp));
        } else {
            format = String.format("%s", genderName);
        }
        if (profileCardInfo.allInOne.f260789pa == 0 && card.showPublishButton && viewGroup != null && (LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, qQAppInterface.getLongAccountUin()) & 16384) != 0) {
            viewGroup.removeAllViews();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.topMargin = ViewUtils.dpToPx(10.0f);
            viewGroup.setLayoutParams(layoutParams);
            viewGroup.setVisibility(0);
            log("no photo, show writeMoodContainer view.");
            QBaseActivity qBaseActivity2 = this.mActivity;
            if (qBaseActivity2 == null) {
                return format;
            }
            View inflate = LayoutInflater.from(qBaseActivity2).inflate(R.layout.aca, (ViewGroup) null);
            if (!this.mActivity.isFinishing()) {
                QBaseActivity qBaseActivity3 = this.mActivity;
                if (QQTheme.isNowThemeIsNight()) {
                    i3 = R.drawable.f162308lf0;
                } else {
                    i3 = R.drawable.a9w;
                }
                inflate.setBackground(qBaseActivity3.getDrawable(i3));
            }
            viewGroup.addView(inflate);
            ((ImageView) inflate.findViewById(R.id.cqt)).setImageResource(TokenResUtils.getTokenRes(R.drawable.hya, R.drawable.qui_add_brand_standard));
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQZoneComponent.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        ProfileQZoneComponent.this.forwardToWriteMood();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            LpReportInfo_pf00064.allReport(699, 7);
        }
        return format;
    }

    private static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    private void resetPhotoContainer(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo, Card card, ViewGroup viewGroup, List<PhotoInfo> list) {
        int i3;
        if (list.isEmpty()) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(this.mActivity);
        int dimensionPixelSize = this.mActivity.getResources().getDimensionPixelSize(R.dimen.aie);
        int dimensionPixelSize2 = (int) ((this.mScreenWidth - r1.getDimensionPixelSize(R.dimen.a06)) - ViewUtils.dpToPx(30.0f));
        int columnCount = ((int) ((dimensionPixelSize2 - ((r1 - 1) * dimensionPixelSize)) * 1.0f)) / getColumnCount(card);
        log(String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", Integer.valueOf(list.size()), Integer.valueOf(columnCount), Integer.valueOf(dimensionPixelSize), Integer.valueOf(dimensionPixelSize2)));
        if (profileCardInfo.allInOne.f260789pa == 0 && (LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, qQAppInterface.getLongAccountUin()) & 16384) != 0) {
            View inflate = from.inflate(R.layout.cbp, (ViewGroup) null);
            viewGroup.addView(inflate);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.width = columnCount;
                layoutParams2.height = columnCount;
                layoutParams2.rightMargin = dimensionPixelSize;
                inflate.setLayoutParams(layoutParams2);
            }
            i3 = 0 + columnCount;
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileQZoneComponent.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        ProfileQZoneComponent.this.forwardToWriteMood();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            LpReportInfo_pf00064.allReport(699, 7);
        } else {
            i3 = 0;
        }
        int[] iArr = {i3};
        Iterator<PhotoInfo> it = list.iterator();
        while (it.hasNext() && !createPhotoView(qQAppInterface, card, viewGroup, it.next(), columnCount, dimensionPixelSize, iArr, dimensionPixelSize2)) {
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
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
        return 1012;
    }

    public String getGenderName(ProfileCardInfo profileCardInfo) {
        Card card;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) profileCardInfo);
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            return "\u4ed6";
        }
        String string2 = qBaseActivity.getString(R.string.f207375_u);
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            if (card.shGender == 1) {
                string = this.mActivity.getString(R.string.f207365_t);
            } else {
                string = this.mActivity.getString(R.string.f207375_u);
            }
            return string;
        }
        return string2;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IProfileContentKey.MAP_KEY_QZONE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v24, types: [android.view.View, VIEW] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v29 */
    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent
    public boolean makeOrRefreshQZone(Card card) {
        int i3;
        boolean z16;
        View view;
        View view2;
        boolean z17;
        boolean z18;
        TextView textView;
        View view3;
        String str;
        PhotoInfo photoInfo;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) card)).booleanValue();
        }
        ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        LayoutInflater from = LayoutInflater.from(this.mActivity);
        HashMap hashMap = new HashMap();
        if (card != null && card.hasGotPhotoUrl()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put(ProfileCardDtReportUtil.DT_REPORT_PARAM_IS_EMPTY, Integer.valueOf(i3));
        VideoReport.setElementParams(this.mViewContainer, hashMap);
        if (ProfilePAUtils.isPaTypeHasUin(profileCardInfo.allInOne) && card != null && !this.mIsFromArkBabyQ && !ProfilePAUtils.isFromGuild(profileCardInfo.allInOne.f260789pa)) {
            int i16 = 8;
            ThreadManagerV2.post(new Runnable(profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ProfileCardInfo val$cardInfo;

                {
                    this.val$cardInfo = profileCardInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileQZoneComponent.this, (Object) profileCardInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!TextUtils.isEmpty(this.val$cardInfo.allInOne.uin)) {
                            String str2 = this.val$cardInfo.allInOne.uin;
                            if (str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                str2 = this.val$cardInfo.allInOne.uin.substring(1);
                            }
                            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(699, 2, Long.valueOf(str2).longValue()), false, false);
                        }
                    } catch (Exception e16) {
                        QZLog.e("QzoneReport", "makeOrRefreshQZone", e16);
                    }
                }
            }, 8, null, true);
            View view4 = (View) this.mViewContainer;
            if (isDIYTemplateProfile()) {
                view4 = null;
            }
            if (view4 == null) {
                View qZoneDiyView = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).getQZoneDiyView(IProfileContentKey.MAP_KEY_QZONE);
                ?? r26 = qZoneDiyView;
                if (qZoneDiyView == null) {
                    r26 = from.inflate(R.layout.b0l, (ViewGroup) null);
                }
                view2 = r26.findViewById(R.id.icon);
                if (view2 != null) {
                    view2.setBackgroundResource(TokenResUtils.getTokenRes(R.drawable.qq_profilecard_item_qzone, R.drawable.qui_qq_zone));
                }
                this.mViewContainer = r26;
                view = r26;
                z17 = true;
            } else {
                view = view4;
                view2 = null;
                z17 = false;
            }
            if (view2 == null) {
                view2 = view.findViewById(R.id.icon);
            }
            View view5 = view2;
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.dkt);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.ax7);
            TextView textView2 = (TextView) view.findViewById(R.id.jj7);
            ImageView imageView = (ImageView) view.findViewById(R.id.dcv);
            if (textView2 != null) {
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            int i17 = card.ulShowControl;
            if ((i17 & 128) != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            log(String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", Integer.valueOf(i17), Boolean.valueOf(z18)));
            if (!z18 && ((card.isShowPhoto() || card.hasFakeData) && card.hasGotPhotoUrl())) {
                List<PhotoInfo> qZonePhotoList = card.getQZonePhotoList();
                if (qZonePhotoList == null) {
                    qZonePhotoList = Collections.emptyList();
                }
                List<PhotoInfo> list = qZonePhotoList;
                if (profileCardInfo.allInOne.f260789pa == 0) {
                    if (list.size() >= this.qzonePicNums) {
                        this.qzonePicNums = list.size();
                    } else {
                        card.hasFakeData = false;
                        return true;
                    }
                }
                if (viewGroup2 != null && viewGroup2.getVisibility() != 8) {
                    viewGroup2.removeAllViews();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup2.getLayoutParams();
                    layoutParams.topMargin = 0;
                    viewGroup2.setLayoutParams(layoutParams);
                    viewGroup2.setVisibility(8);
                }
                if (list.isEmpty()) {
                    photoInfo = null;
                } else {
                    photoInfo = list.get(0);
                }
                if (!z17 && isSamePhotoInfo(this.mLastPhotoInfo, photoInfo) && this.mLastPhotoListSize == list.size()) {
                    log("makeOrRefreshQZone don't update photo area,photo count:" + list.size());
                    textView = textView2;
                    view3 = viewGroup;
                } else {
                    viewGroup.removeAllViews();
                    viewGroup.setVisibility(0);
                    this.photoVisibilityState = 0;
                    textView = textView2;
                    view3 = viewGroup;
                    resetPhotoContainer(qQAppInterface, profileCardInfo, card, viewGroup, list);
                    this.mLastPhotoInfo = photoInfo;
                    this.mLastPhotoListSize = list.size();
                    log("makeOrRefreshQZone update photo area,photo count:" + list.size());
                }
                if (textView != null) {
                    if (!TextUtils.isEmpty(card.strQzoneHeader)) {
                        textView.setText(getGenderName(profileCardInfo) + card.strQzoneHeader);
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (profileCardInfo.allInOne.f260789pa == 0) {
                        textView.setText(HardCodeUtil.qqStr(R.string.pdj));
                        z19 = true;
                    }
                    if (z19) {
                        i16 = 0;
                    }
                    textView.setVisibility(i16);
                }
            } else {
                textView = textView2;
                view3 = viewGroup;
                view3.setVisibility(8);
                this.photoVisibilityState = 8;
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setText(getNoPhotoInfoStr(qQAppInterface, profileCardInfo, card, z18, viewGroup2));
                }
            }
            if (textView != null && textView.getText() != null) {
                str = textView.getText().toString();
            } else {
                str = "";
            }
            String str2 = str;
            view.setOnClickListener(this);
            view.setContentDescription(this.mActivity.getString(R.string.ac5));
            updateItemTheme(view, textView, view5, null, imageView);
            if (z17) {
                IDiyMoreInfoManager diyMoreInfoManager = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
                if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
                    diyMoreInfoManager.updateQzoneForDeepDiy(view);
                }
            }
            checkBlackListForbid(view3, null);
            String[] strArr = profileCardInfo.nameArray;
            log(String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", card.strQzoneHeader, card.strQzoneFeedsDesc, card.strSpaceName, strArr[4], strArr[0], str2));
            return z17;
        }
        if (this.mViewContainer != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mViewContainer = null;
        return z16;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.onActivityResult(i3, i16, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else {
            ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
            QQAppInterface qQAppInterface = this.mQQAppInterface;
            startQzoneShowFeed();
            ThreadManagerV2.post(new Runnable(profileCardInfo) { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ ProfileCardInfo val$cardInfo;

                {
                    this.val$cardInfo = profileCardInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileQZoneComponent.this, (Object) profileCardInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!TextUtils.isEmpty(this.val$cardInfo.allInOne.uin)) {
                            String str = this.val$cardInfo.allInOne.uin;
                            if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                                str = this.val$cardInfo.allInOne.uin.substring(1);
                            }
                            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(BaseProfileQZoneComponent.ACTION_TYPE, BaseProfileQZoneComponent.SUB_ACTION_TYPE_3, Long.valueOf(str).longValue()), false, false);
                        }
                    } catch (Exception e16) {
                        QZLog.e("QzoneReport", "makeOrRefreshQZone", e16);
                    }
                }
            }, 8, null, true);
            ReportController.o(qQAppInterface, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileEntryUtils.getProfileEntryType(profileCardInfo.allInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(profileCardInfo.allInOne)), "", "", "");
            if (profileCardInfo.allInOne.f260789pa == 0) {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
            } else {
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
            }
            if (profileCardInfo.isTroopMemberCard) {
                new q(qQAppInterface).i("dc00899").a("Grp_mem_card").f("page").d("zone_clk").b(profileCardInfo.troopUin).g();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) bundle);
        } else {
            super.onCreate(qBaseActivity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
        }
    }
}
