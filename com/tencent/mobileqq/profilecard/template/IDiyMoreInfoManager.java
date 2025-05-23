package com.tencent.mobileqq.profilecard.template;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IDiyMoreInfoManager {
    <V extends View> V getPhotoWallDiyView(ProfileCardInfo profileCardInfo);

    <T extends View> T getQZoneDiyView(String str);

    void initDiyTemplate(QBaseActivity qBaseActivity, ProfileCardInfo profileCardInfo);

    boolean isDiy();

    void updateAccountInfoForDeepDiy(View view);

    void updateBaseInfoForDeepDiy(View view);

    void updateItemThemeForDIYTemplate(TextView textView, View view, ImageView imageView, View view2, View view3, View view4);

    void updateLevelForDeepDiy(View view);

    void updateMetalForDeepDiy(View view);

    void updatePhotoWallForDeepDiy(View view);

    void updateQzoneForDeepDiy(View view);

    void updateSignForDeepDiy(View view);

    void updateTroopMemInfoForDeepDiy(View view);
}
