package com.tencent.mobileqq.webview.injector;

import android.app.Activity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.webview.swift.injector.h;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class e implements com.tencent.mobileqq.webview.swift.injector.h {

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a f313970a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f313971b;

        a(h.a aVar, String[] strArr) {
            this.f313970a = aVar;
            this.f313971b = strArr;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            h.a aVar = this.f313970a;
            if (aVar != null) {
                aVar.a(this.f313971b, true);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            if (this.f313970a == null || list == null) {
                return;
            }
            this.f313970a.a((String[]) list.toArray(new String[list.size()]), false);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.h
    public int a(Activity activity, String[] strArr, h.a aVar) {
        QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_USERMEDIA)).requestPermissions(strArr, 2, new a(aVar, strArr));
        return 0;
    }
}
