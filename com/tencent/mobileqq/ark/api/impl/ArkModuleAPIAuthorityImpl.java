package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority;
import com.tencent.mobileqq.ark.module.f;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public class ArkModuleAPIAuthorityImpl implements IArkModuleAPIAuthority {
    @Override // com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority
    public ArrayList<String> getArkAuthorityAppList(String str) {
        return ArkModuleAPIAuthority.b(str);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority
    public int getArkAuthorityInfo(String str, String str2, String str3) {
        return ArkModuleAPIAuthority.c(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority
    public void showAuthDialog(String str, String str2, String str3, String str4, String str5, f fVar) {
        ArkModuleAPIAuthority.e(str, str2, str3, str4, str5, fVar);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority
    public void updateArkAuthorityAppList(String str, String str2) {
        ArkModuleAPIAuthority.f(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkModuleAPIAuthority
    public void updateArkAuthorityInfo(String str, String str2, String str3, int i3) {
        ArkModuleAPIAuthority.g(str, str2, str3, i3);
    }
}
