package com.tencent.mobileqq.friend.contact.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.friend.contact.api.IContactExpandBannerApi;
import com.tencent.mobileqq.friend.contact.view.ContactExpandBannerView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/api/impl/ContactExpandBannerApiImpl;", "Lcom/tencent/mobileqq/friend/contact/api/IContactExpandBannerApi;", "Landroid/view/ViewGroup;", "parentView", "", "initView", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "isEnable", "hasConfigChanged", "", "mConfig", "Ljava/lang/String;", "mLastEnableConfig", "<init>", "()V", "Companion", "a", "qqfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ContactExpandBannerApiImpl implements IContactExpandBannerApi {
    public static final String CONFIG_ID = "101732";
    public static final String TAG = "ContactExpandBannerApiImpl";
    private String mConfig = "";
    private String mLastEnableConfig = "";

    @Override // com.tencent.mobileqq.friend.contact.api.IContactExpandBannerApi
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ContactExpandBannerView(context);
    }

    @Override // com.tencent.mobileqq.friend.contact.api.IContactExpandBannerApi
    public boolean hasConfigChanged() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(CONFIG_ID, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasConfigChanged oldConfig = " + this.mConfig + ", newConfig = " + loadAsString);
        }
        return (Intrinsics.areEqual(this.mConfig, loadAsString) || Intrinsics.areEqual(this.mLastEnableConfig, loadAsString)) ? false : true;
    }

    @Override // com.tencent.mobileqq.friend.contact.api.IContactExpandBannerApi
    public boolean isEnable() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(CONFIG_ID, "");
        if (loadAsString.length() > 0) {
            this.mLastEnableConfig = loadAsString;
        }
        this.mConfig = loadAsString;
        return !TextUtils.isEmpty(loadAsString);
    }

    @Override // com.tencent.mobileqq.friend.contact.api.IContactExpandBannerApi
    public void initView(ViewGroup parentView) {
        if (parentView != null) {
            if (!hasConfigChanged()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initExpandBanner return, hasConfigChanged = false");
                    return;
                }
                return;
            }
            if (!isEnable()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initExpandBanner return, isEnable = false");
                }
                parentView.removeAllViews();
                parentView.setVisibility(8);
                return;
            }
            Context context = parentView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
            View createView = createView(context);
            if (createView == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initExpandBanner return, bannerView == null ");
                }
                parentView.setVisibility(8);
                return;
            }
            parentView.removeAllViews();
            int dpToPx = ViewUtils.dpToPx(16.0f);
            parentView.setPadding(dpToPx, 0, dpToPx, 0);
            int screenWidth = (int) ((ViewUtils.getScreenWidth() - ViewUtils.dip2px(32.0f)) / 4.5d);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initExpandBanner height = " + screenWidth + ", hasConfigChanged = true");
            }
            parentView.addView(createView, new FrameLayout.LayoutParams(-1, screenWidth));
            parentView.setVisibility(0);
        }
    }
}
