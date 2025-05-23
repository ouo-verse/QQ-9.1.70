package com.tencent.mobileqq.settings.business.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.SoundNewFragment;
import com.tencent.mobileqq.fragment.BottomTabSetting.NewBottomTabSettingFragment;
import com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi;
import com.tencent.mobileqq.settings.fragment.PrivacyInterNewSetFragment;
import com.tencent.mobileqq.settings.message.ChatNewSettingFragment;
import com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/settings/business/api/impl/SettingSearchHightApiImpl;", "Lcom/tencent/mobileqq/settings/business/api/ISettingSearchHightApi;", "()V", "startQUIBottomTabSettingPage", "", "context", "Landroid/content/Context;", "params", "Landroid/content/Intent;", "startQUIChatHistorySettingPage", "startQUIPrivacyInteractionSettingPage", "startQUISoundPage", "startQUITempMsgSettingPage", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SettingSearchHightApiImpl implements ISettingSearchHightApi {
    @Override // com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi
    public void startQUIBottomTabSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, NewBottomTabSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi
    public void startQUIChatHistorySettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, ChatNewSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi
    public void startQUIPrivacyInteractionSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null) {
            params = new Intent();
        }
        QPublicFragmentActivity.start(context, params, PrivacyInterNewSetFragment.class);
    }

    @Override // com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi
    public void startQUISoundPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, SoundNewFragment.class);
    }

    @Override // com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi
    public void startQUITempMsgSettingPage(Context context, Intent params) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, params, TempMsgSettingFragment.class);
    }
}
