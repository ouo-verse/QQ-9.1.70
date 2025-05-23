package com.tencent.mobileqq.qqexpand.entrance.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qqexpand.entrance.INativeNavigateApi;
import com.tencent.mobileqq.qqexpand.flutter.router.RouterManager;
import com.tencent.mobileqq.qqexpand.flutter.router.a;
import com.tencent.mobileqq.qqexpand.utils.m;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class NativeNavigateApiImpl implements INativeNavigateApi {
    @Override // com.tencent.mobileqq.qqexpand.entrance.INativeNavigateApi
    public void navigateBySchema(String str) {
        m.f264104a.a(MobileQQ.sMobileQQ, str);
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.INativeNavigateApi
    public void navigateMiniApp(String str) {
        m.f264104a.b(MobileQQ.sMobileQQ, str);
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.INativeNavigateApi
    public void navigateWebView(String str) {
        m.f264104a.c(MobileQQ.sMobileQQ, str);
    }

    @Override // com.tencent.mobileqq.qqexpand.entrance.INativeNavigateApi
    public void navigateWithoutSchema(String str, Map<Object, Object> map, Map<Object, Object> map2) {
        Uri parse;
        a f16;
        if (!RouterManager.d().e()) {
            RouterManager.d().b();
        }
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || !TextUtils.equals(parse.getScheme(), SchemaUtils.SCHEMA_MQQAPI) || (f16 = RouterManager.d().f(parse.getAuthority())) == null) {
            return;
        }
        f16.b(parse, map, map2);
    }
}
