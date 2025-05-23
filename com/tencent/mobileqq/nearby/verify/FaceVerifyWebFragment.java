package com.tencent.mobileqq.nearby.verify;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.h;
import com.tencent.mobileqq.webview.swift.u;
import x92.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FaceVerifyWebFragment extends WebViewFragment implements h {
    private static final String[] C = {QQPermissionConstants.Permission.CAMERA, "android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_NETWORK_STATE", QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.RECORD_AUDIO};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }
    }

    public static FaceVerifyWebFragment ph(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        FaceVerifyWebFragment faceVerifyWebFragment = new FaceVerifyWebFragment();
        faceVerifyWebFragment.setArguments(bundle);
        return faceVerifyWebFragment;
    }

    private void qh() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_NEARBY, QQPermissionConstants.Business.SCENE.NEARBY_SECURE_VERIFY));
        if (qQPermission == null) {
            return;
        }
        for (String str : C) {
            qQPermission.requestPermissions(new String[]{str}, 2, new a());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public WebViewWrapper createWebViewWrapper(boolean z16) {
        return new x92.a(getActivity(), getWebViewKernelCallBack(), this.intent, z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        b.a().c(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        return ph(intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        qh();
    }
}
