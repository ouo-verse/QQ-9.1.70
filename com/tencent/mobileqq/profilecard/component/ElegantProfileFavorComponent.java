package com.tencent.mobileqq.profilecard.component;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profilecard.view.ProfileCardFavorItemDetailView;
import com.tencent.mobileqq.profilecard.widget.ElegantProfileContentTitleView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes35.dex */
public class ElegantProfileFavorComponent extends BaseProfileFavorComponent {
    private static final int HEIGHT = 70;
    private static final String TAG = "ElegantProfileFavorComponent";
    private static final int WIDTH = 70;

    public ElegantProfileFavorComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    private void handleHobbyClick(com.tencent.mobileqq.profile.b bVar) {
        Object obj = bVar.f260136b;
        if (obj instanceof ProfileSummaryHobbiesEntry) {
            ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry = (ProfileSummaryHobbiesEntry) obj;
            startBrowserActivity(profileSummaryHobbiesEntry.strServiceUrl, profileSummaryHobbiesEntry.serviceType);
        }
    }

    private void handleHobbyItemClick(com.tencent.mobileqq.profile.b bVar) {
        Object obj = bVar.f260136b;
        if (obj instanceof ProfileSummaryHobbiesItem) {
            ProfileSummaryHobbiesItem profileSummaryHobbiesItem = (ProfileSummaryHobbiesItem) obj;
            startBrowserActivity(profileSummaryHobbiesItem.strJmpUrl, profileSummaryHobbiesItem.serviceType);
        }
    }

    private void startBrowserActivity(String str, int i3) {
        if (this.mActivity == null) {
            QLog.e(TAG, 1, "startBrowserActivity is error \uff5c mActivity is null.");
            return;
        }
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            Intent intent = new Intent(this.mActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            if (2 == i3) {
                intent.putExtra("big_brother_source_key", "biz_src_qqmusic");
            } else if (4 == i3) {
                intent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
            }
            this.mActivity.startActivity(intent);
            return;
        }
        QLog.e(TAG, 1, "startBrowserActivity is error \uff5c jumpUrl = " + str + " serviceType = " + i3);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.component.BaseProfileFavorComponent, android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        ProfileCardDtReportUtil.dtReportClick(view);
        if (tag instanceof com.tencent.mobileqq.profile.b) {
            com.tencent.mobileqq.profile.b bVar = (com.tencent.mobileqq.profile.b) view.getTag();
            if (bVar.f260135a != 61) {
                return;
            }
            handleHobbyClick(bVar);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.component.BaseProfileFavorComponent
    public void addFavorItem(ProfileSummaryHobbiesEntry profileSummaryHobbiesEntry, LinearLayout linearLayout, Resources resources) {
        ElegantProfileContentTitleView elegantProfileContentTitleView = new ElegantProfileContentTitleView(this.mActivity);
        elegantProfileContentTitleView.setTitle(profileSummaryHobbiesEntry.strName);
        int i3 = 2;
        if (2 == profileSummaryHobbiesEntry.serviceType) {
            elegantProfileContentTitleView.setIcon(resources.getDrawable(R.drawable.qui_earpods));
        }
        int i16 = 0;
        while (i16 < profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.size()) {
            ProfileSummaryHobbiesItem profileSummaryHobbiesItem = profileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.get(i16);
            ProfileCardFavorItemDetailView profileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.mActivity);
            profileCardFavorItemDetailView.setTitle(profileSummaryHobbiesItem.strTitle);
            profileCardFavorItemDetailView.setContent(profileSummaryHobbiesItem.strSubInfo);
            profileCardFavorItemDetailView.setDesc(profileSummaryHobbiesItem.strDesc);
            Drawable drawable = resources.getDrawable(R.color.f74147);
            if (!TextUtils.isEmpty(profileSummaryHobbiesItem.strCoverUrl)) {
                drawable = URLDrawable.getDrawable(profileSummaryHobbiesItem.strCoverUrl, 70, 70, drawable, drawable);
            }
            profileCardFavorItemDetailView.setIcon(drawable);
            if (!TextUtils.isEmpty(profileSummaryHobbiesItem.strTitleIconUrl)) {
                profileCardFavorItemDetailView.addLabel(profileSummaryHobbiesItem.strTitleIconUrl, i3);
            }
            ArrayList<ProfileGroupLabel> arrayList = profileSummaryHobbiesItem.labels;
            if (arrayList != null && arrayList.size() > 0) {
                for (int i17 = 0; i17 < profileSummaryHobbiesItem.labels.size(); i17++) {
                    ProfileGroupLabel profileGroupLabel = profileSummaryHobbiesItem.labels.get(i17);
                    ProfileColor profileColor = profileGroupLabel.edgingColor;
                    profileCardFavorItemDetailView.addLabel(null, profileGroupLabel.strWording, Color.rgb((int) profileColor.red, (int) profileColor.green, (int) profileColor.blue), 3);
                }
            }
            elegantProfileContentTitleView.setBackground(this.mActivity.getResources().getDrawable(R.drawable.ktt));
            elegantProfileContentTitleView.addContentView(profileCardFavorItemDetailView);
            profileCardFavorItemDetailView.setNeedTopMargin(i16 != 0);
            updateItemTheme(profileCardFavorItemDetailView.row1Content, profileCardFavorItemDetailView.row2Content);
            updateItemTheme((TextView) null, profileCardFavorItemDetailView.row3Content);
            i16++;
            i3 = 2;
        }
        linearLayout.setTag(new com.tencent.mobileqq.profile.b(61, profileSummaryHobbiesEntry));
        linearLayout.setOnClickListener(this);
        linearLayout.addView(elegantProfileContentTitleView);
    }
}
