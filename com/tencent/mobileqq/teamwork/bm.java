package com.tencent.mobileqq.teamwork;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bm extends com.tencent.mobileqq.webview.swift.component.z {
    private com.tencent.mobileqq.armap.f C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements com.tencent.mobileqq.armap.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f292104d;

        a(ImageView imageView) {
            this.f292104d = imageView;
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            if (QLog.isColorLevel()) {
                QLog.i("SwiftMiniAIOHandler", 4, "onFaceUpdate uin: " + str + " -- " + str2 + " head:" + bitmap);
            }
            if (bitmap != null) {
                this.f292104d.setImageDrawable(new BitmapDrawable(bitmap));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l(int i3, String str, ImageView imageView) {
        int i16;
        com.tencent.mobileqq.armap.f fVar;
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 1000 && i3 != 1004) {
                        if (i3 != 3000) {
                            if (i3 != 10008) {
                                i16 = -1;
                            }
                        } else {
                            i16 = 101;
                        }
                    }
                } else {
                    i16 = 4;
                }
                if (i16 != -1) {
                    this.C = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.f314441d.getActivity(), i16);
                }
                fVar = this.C;
                if (fVar == null) {
                    fVar.init();
                    this.C.a(new a(imageView));
                    this.C.b(str, true);
                    return;
                }
                return;
            }
            i16 = 1;
            if (i16 != -1) {
            }
            fVar = this.C;
            if (fVar == null) {
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.z, com.tencent.mobileqq.webview.swift.g
    public void a() {
        Intent intent = this.f314441d.getWebViewProvider().getIntent();
        boolean booleanExtra = intent.getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, false);
        String stringExtra = intent.getStringExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_UIN);
        int intExtra = intent.getIntExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_PEERTYPE, -1);
        String stringExtra2 = intent.getStringExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_NICKNAME);
        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) this.f314441d.getProvider().a(2);
        if (vVar != null && vVar.C != null) {
            if (booleanExtra && !TextUtils.isEmpty(stringExtra) && intExtra != -1) {
                if (this.f314522e == null) {
                    bf bfVar = new bf(this.f314441d.getActivity(), i(), stringExtra, intExtra, stringExtra2);
                    this.f314522e = bfVar;
                    bfVar.onForeground();
                }
                vVar.C.d().setVisibility(0);
                return;
            }
            vVar.C.d().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.z, com.tencent.mobileqq.webview.swift.g
    public void b(boolean z16) {
        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) this.f314441d.getProvider().a(2);
        if (vVar != null && vVar.C != null) {
            Intent intent = this.f314441d.getWebViewProvider().getIntent();
            if (vVar.C.d() != null && intent != null) {
                boolean booleanExtra = intent.getBooleanExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO, false);
                String stringExtra = intent.getStringExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_UIN);
                int intExtra = intent.getIntExtra(ITeamWorkDocEditBrowserProxy.KEY_FROM_AIO_PEERTYPE, -1);
                if (booleanExtra && !TextUtils.isEmpty(stringExtra) && intExtra != -1) {
                    vVar.C.d().setVisibility(0);
                    a();
                    l(intExtra, stringExtra, (ImageView) vVar.C.d().findViewById(R.id.ews));
                    return;
                }
            }
            vVar.C.d().setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        super.e();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.z, com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        com.tencent.mobileqq.armap.f fVar;
        super.f(i3, bundle);
        if (i3 == 3 && (fVar = this.C) != null) {
            fVar.destroy();
        }
    }
}
