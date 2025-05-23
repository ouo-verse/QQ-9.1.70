package com.tencent.mobileqq.search.api.impl;

import android.content.Context;
import ap2.e;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.guildsearch.GuildSearchEntryFragment;
import com.tencent.mobileqq.search.model.al;
import com.tencent.mobileqq.search.qqmc.SearchQQMC;
import com.tencent.mobileqq.search.searchdetail.r;
import com.tencent.mobileqq.search.searchdetail.util.k;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQSearchApiImpl implements IQQSearchApi {
    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public boolean enableDefaultSingleMode() {
        return SearchQQMC.INSTANCE.getDefaultSingleModeConfig().getEnable();
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public CharSequence getHighLightApproximateMatchedMessageForMainTitle(AppInterface appInterface, String str, String str2, al alVar) {
        return SearchUtils.z(appInterface, str, str2, 6, alVar);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public CharSequence getHighLightMatchedMessage(String str, String str2) {
        return SearchUtils.D(str, str2, 6);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public CharSequence getHighLightMatchedMessageForMainTitle(AppInterface appInterface, String str, String str2) {
        return SearchUtils.H(appInterface, str, str2, 6);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public String getKDSearchKeyword(String str) {
        return SearchUtils.M(str);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public CharSequence getMessageWithParenthese(CharSequence charSequence) {
        return SearchUtils.W(charSequence);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public boolean isKDSearchUrl(String str) {
        return SearchUtils.H0(str);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public boolean isOptSearch() {
        e eVar = (e) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101254");
        if (eVar != null && eVar.getIsOptSearch()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public void jump2NetSearchPage(Context context, String str) {
        k.f284749a.d(context, str);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public void jump2SearchFromGuild(Context context) {
        QLog.i("QQSearchApi", 1, "[jump2SearchFromGuild] ");
        GuildSearchEntryFragment.INSTANCE.a(context);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public void openMinGameSearchPage(Context context, String str) {
        k.f284749a.g(context, str);
    }

    @Override // com.tencent.mobileqq.search.api.IQQSearchApi
    public boolean useNativeNetSearchPage() {
        return r.f284572a.c();
    }
}
