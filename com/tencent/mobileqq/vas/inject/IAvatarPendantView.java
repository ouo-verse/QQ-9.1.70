package com.tencent.mobileqq.vas.inject;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantItem;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public interface IAvatarPendantView {

    /* loaded from: classes20.dex */
    public interface OnZplanAvatarUpdateListener {
        void onZplanAvatarUpdate();
    }

    /* loaded from: classes20.dex */
    public interface a {
        void a();
    }

    void cancelPreviewAvatar();

    void cancelPreviewPendant();

    void doOnActivityResult(int i3, int i16, Intent intent);

    void doOnDestroy();

    void doOnNewIntent(Intent intent);

    void doOnPause();

    void doOnResume();

    boolean enableZplanAvatar();

    View getHeadView();

    List<AvatarPendantItem> getZplanData();

    boolean handleMagicAvatarBannerClick(View view, JSONObject jSONObject);

    void initView(QBaseActivity qBaseActivity);

    boolean isCurrentPreviewSplendidAvatar();

    boolean isEnable();

    boolean isUserWearPendant();

    void previewAvatar(int i3, boolean z16);

    void previewPendant(int i3, boolean z16);

    void setAvatar(int i3, String str);

    void setAvatarChangeListener(a aVar);

    void setOnZplanAvatarUpdateListener(OnZplanAvatarUpdateListener onZplanAvatarUpdateListener);

    void setPendant(int i3);

    void showSelfMenu();
}
