package com.tencent.mobileqq.profilecard.component;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profilecard.view.ProfileCardFavorItemDetailView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class ProfileFavorComponent extends BaseProfileFavorComponent {
    private static final int HEIGHT = 70;
    private static final String TAG = "ProfileFavorComponent";
    private static final int WIDTH = 70;
    public boolean hasReportedBuluo;
    public boolean hasReportedMusic;

    public ProfileFavorComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.hasReportedBuluo = false;
        this.hasReportedMusic = false;
    }

    private void favorHobbyClickReport(int i3) {
        ReportController.o(this.mApp, "dc00898", "", "", "0X80093BF", "0X80093BF", i3, 0, "", "", "", "");
    }

    private void favorHobbyItemExposureReport(ProfileSummaryHobbiesItem profileSummaryHobbiesItem) {
        int i3 = profileSummaryHobbiesItem.serviceType;
        if (i3 != 2) {
            if (i3 == 4 && !this.hasReportedBuluo) {
                ReportController.o(this.mApp, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
                this.hasReportedBuluo = true;
                return;
            }
            return;
        }
        if (this.hasReportedMusic) {
            return;
        }
        ReportController.o(this.mApp, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
        this.hasReportedMusic = true;
    }

    private void handleHobbyClick(com.tencent.mobileqq.profile.b bVar) {
        Object obj = bVar.f260136b;
        if (obj instanceof ProfileSummaryHobbiesEntry) {
            ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry = (ProfileSummaryHobbiesEntry) obj;
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", profileSummaryHobbiesEntry.strServiceUrl);
            int i3 = profileSummaryHobbiesEntry.serviceType;
            if (i3 == 2) {
                intent.putExtra("big_brother_source_key", "biz_src_qqmusic");
            } else if (i3 == 4) {
                intent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
            }
            this.mActivity.startActivity(intent);
            favorHobbyClickReport(profileSummaryHobbiesEntry.serviceType);
        }
    }

    private void handleHobbyItemClick(com.tencent.mobileqq.profile.b bVar) {
        Object obj = bVar.f260136b;
        if (obj instanceof ProfileSummaryHobbiesItem) {
            ProfileSummaryHobbiesItem profileSummaryHobbiesItem = (ProfileSummaryHobbiesItem) obj;
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", profileSummaryHobbiesItem.strJmpUrl);
            int i3 = profileSummaryHobbiesItem.serviceType;
            if (i3 == 2) {
                intent.putExtra("big_brother_source_key", "biz_src_qqmusic");
            } else if (i3 == 4) {
                intent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
            }
            this.mActivity.startActivity(intent);
            favorHobbyItemClickReport(profileSummaryHobbiesItem);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.component.BaseProfileFavorComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof com.tencent.mobileqq.profile.b) {
            com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
            int i3 = bVar.f260135a;
            if (i3 == 61) {
                handleHobbyClick(bVar);
            } else {
                if (i3 != 62) {
                    return;
                }
                handleHobbyItemClick(bVar);
            }
        }
    }

    private void favorHobbyItemClickReport(ProfileSummaryHobbiesItem profileSummaryHobbiesItem) {
        int i3 = profileSummaryHobbiesItem.serviceType;
        if (i3 == 2) {
            ReportController.o(this.mApp, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
        } else {
            if (i3 != 4) {
                return;
            }
            ReportController.o(this.mApp, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.component.BaseProfileFavorComponent
    public void addFavorItem(ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry, LinearLayout linearLayout, Resources resources) {
        ProfileContentTitleView profileContentTitleView = new ProfileContentTitleView(this.mActivity);
        profileContentTitleView.setTitle(profileSummaryHobbiesEntry.strName);
        int i3 = 2;
        int i16 = 0;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("addFavorItem title=%s", profileSummaryHobbiesEntry.strName));
        }
        int i17 = 0;
        while (i17 < profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.size()) {
            ProfileSummaryHobbiesItem profileSummaryHobbiesItem = profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.get(i17);
            ProfileCardFavorItemDetailView profileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.mActivity);
            profileCardFavorItemDetailView.setTitle(profileSummaryHobbiesItem.strTitle);
            profileCardFavorItemDetailView.setContent(profileSummaryHobbiesItem.strSubInfo);
            profileCardFavorItemDetailView.setDesc(profileSummaryHobbiesItem.strDesc);
            Drawable drawable = resources.getDrawable(R.color.f74147);
            if (!TextUtils.isEmpty(profileSummaryHobbiesItem.strCoverUrl)) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = drawable;
                obtain.mRequestWidth = Utils.n(70.0f, resources);
                obtain.mRequestHeight = Utils.n(70.0f, resources);
                drawable = URLDrawable.getDrawable(profileSummaryHobbiesItem.strCoverUrl, obtain);
            }
            profileCardFavorItemDetailView.setIcon(drawable);
            if (!TextUtils.isEmpty(profileSummaryHobbiesItem.strTitleIconUrl)) {
                profileCardFavorItemDetailView.addLabel(profileSummaryHobbiesItem.strTitleIconUrl, i3);
            }
            ArrayList<ProfileGroupLabel> arrayList = profileSummaryHobbiesItem.labels;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i18 = i16; i18 < profileSummaryHobbiesItem.labels.size(); i18++) {
                    ProfileGroupLabel profileGroupLabel = profileSummaryHobbiesItem.labels.get(i18);
                    ProfileColor profileColor = profileGroupLabel.edgingColor;
                    profileCardFavorItemDetailView.addLabel(null, profileGroupLabel.strWording, Color.rgb((int) profileColor.red, (int) profileColor.green, (int) profileColor.blue), 3);
                }
            }
            profileCardFavorItemDetailView.setBackgroundResource(R.drawable.g5n);
            profileContentTitleView.addContentView(profileCardFavorItemDetailView);
            profileCardFavorItemDetailView.setTag(new com.tencent.mobileqq.profile.b(62, profileSummaryHobbiesItem));
            profileCardFavorItemDetailView.setOnClickListener(this);
            profileCardFavorItemDetailView.setNeedTopMargin(i17 != 0);
            favorHobbyItemExposureReport(profileSummaryHobbiesItem);
            updateItemTheme(null, profileCardFavorItemDetailView.row1Content, null, profileCardFavorItemDetailView.row2Content, null);
            updateItemTheme(null, null, null, profileCardFavorItemDetailView.row3Content, null);
            i17++;
            i3 = 2;
            i16 = 0;
        }
        profileContentTitleView.mTitleContainer.setTag(new com.tencent.mobileqq.profile.b(61, profileSummaryHobbiesEntry));
        profileContentTitleView.mTitleContainer.setOnClickListener(this);
        linearLayout.addView(profileContentTitleView);
        updateItemTheme(profileContentTitleView, true);
    }
}
