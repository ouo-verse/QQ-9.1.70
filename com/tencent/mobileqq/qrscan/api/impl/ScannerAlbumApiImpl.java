package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.album.PhotoListCustomizationScanner;
import com.tencent.mobileqq.album.PhotoPreviewCustomizationScanner;
import com.tencent.mobileqq.olympic.activity.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qrscan.api.IScannerAlbumApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScannerAlbumApiImpl implements IScannerAlbumApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ScannerAlbumApiImpl";

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f276601a;

        a(Activity activity) {
            this.f276601a = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerAlbumApiImpl.this, (Object) activity);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ScannerAlbumApiImpl.this.realJumpToAlbumForResult(this.f276601a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public ScannerAlbumApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realJumpToAlbumForResult(Activity activity) {
        QLog.i(TAG, 1, "realJumpToAlbumForResult.");
        Config.a aVar = new Config.a();
        aVar.f(TabType.TAB_IMAGE);
        aVar.q(true);
        aVar.g(1);
        PickerInitBean.a aVar2 = new PickerInitBean.a();
        aVar2.b("\u786e\u5b9a");
        activity.startActivityForResult(com.tencent.qqnt.qbasealbum.a.f360732a.d(activity, aVar.a(), aVar2.a(), PhotoListCustomizationScanner.class, PhotoPreviewCustomizationScanner.class), d.f255225b);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IScannerAlbumApi
    public void jumpToAlbumForResult(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            realJumpToAlbumForResult(activity);
        } else {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_ALBUM)).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new a(activity));
        }
    }
}
