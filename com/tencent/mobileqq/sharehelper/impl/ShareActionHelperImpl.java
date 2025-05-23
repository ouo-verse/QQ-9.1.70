package com.tencent.mobileqq.sharehelper.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.ImageShareInfo;
import com.tencent.mobileqq.sharehelper.g;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShareActionHelperImpl implements IShareActionHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String HTTP_METHOD_GET = "GET";
    public static final int MAX_BITMAP_ICON_SIZE = 8000;
    public static final String TAG = "ShareActionHelperImpl";
    public static final String WRAP_IMAGE_KEY = "image";
    private static com.tencent.mobileqq.sharehelper.b sShareActionInjectInterface;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f287138d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WXShareHelper.a[] f287139e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f287140f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f287141h;

        a(String str, WXShareHelper.a[] aVarArr, String str2, int i3) {
            this.f287138d = str;
            this.f287139e = aVarArr;
            this.f287140f = str2;
            this.f287141h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ShareActionHelperImpl.this, str, aVarArr, str2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                return;
            }
            if (baseResp != null && (str = baseResp.transaction) != null) {
                if (!str.equals(this.f287138d)) {
                    QLog.e(ShareActionHelperImpl.TAG, 1, "onWXShareResp: mWXTransaction is wrong");
                    return;
                }
                WXShareHelper.b0().q0(this.f287139e[0]);
                this.f287139e[0] = null;
                int i3 = baseResp.errCode;
                if (i3 != -2) {
                    if (i3 != 0) {
                        ShareActionHelperImpl.this.dispatchHandleWXLinkRespDenied(this.f287140f, this.f287141h);
                        return;
                    } else {
                        ShareActionHelperImpl.this.dispatchHandleWXLinkRespOK(this.f287140f, this.f287141h);
                        return;
                    }
                }
                ShareActionHelperImpl.this.dispatchHandleWXLinkRespCancel(this.f287140f, this.f287141h);
                return;
            }
            QLog.e(ShareActionHelperImpl.TAG, 1, "onWXShareResp: respData is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f287143d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WXShareHelper.a[] f287144e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f287145f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f287146h;

        b(String str, WXShareHelper.a[] aVarArr, String str2, int i3) {
            this.f287143d = str;
            this.f287144e = aVarArr;
            this.f287145f = str2;
            this.f287146h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ShareActionHelperImpl.this, str, aVarArr, str2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                return;
            }
            if (baseResp != null && (str = baseResp.transaction) != null) {
                if (!str.equals(this.f287143d)) {
                    QLog.e(ShareActionHelperImpl.TAG, 1, "onWXShareResp: mWXTransaction is wrong");
                    return;
                }
                WXShareHelper.b0().q0(this.f287144e[0]);
                this.f287144e[0] = null;
                int i3 = baseResp.errCode;
                if (i3 != -2) {
                    if (i3 != 0) {
                        ShareActionHelperImpl.this.dispatchHandleWXLinkRespDenied(this.f287145f, this.f287146h);
                        return;
                    } else {
                        ShareActionHelperImpl.this.dispatchHandleWXLinkRespOK(this.f287145f, this.f287146h);
                        ShareActionHelperImpl.this.showShareWxSuccess();
                        return;
                    }
                }
                ShareActionHelperImpl.this.dispatchHandleWXLinkRespCancel(this.f287145f, this.f287146h);
                return;
            }
            QLog.e(ShareActionHelperImpl.TAG, 1, "onWXShareResp: respData is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f287148d;

        c(Runnable runnable) {
            this.f287148d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionHelperImpl.this, (Object) runnable);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ShareActionHelperImpl.this.callRunnable(this.f287148d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f287150d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WXShareHelper.a[] f287151e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f287152f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f287153h;

        d(String str, WXShareHelper.a[] aVarArr, String str2, int i3) {
            this.f287150d = str;
            this.f287151e = aVarArr;
            this.f287152f = str2;
            this.f287153h = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ShareActionHelperImpl.this, str, aVarArr, str2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                return;
            }
            if (baseResp != null && (str = baseResp.transaction) != null) {
                if (!str.equals(this.f287150d)) {
                    QLog.e(ShareActionHelperImpl.TAG, 1, "onWXShareResp: mWXTransaction is wrong");
                    return;
                }
                WXShareHelper.b0().q0(this.f287151e[0]);
                this.f287151e[0] = null;
                int i3 = baseResp.errCode;
                if (i3 != -2) {
                    if (i3 != 0) {
                        ShareActionHelperImpl.this.dispatchHandleWXPicRespDenied(this.f287152f, this.f287153h);
                        return;
                    } else {
                        ShareActionHelperImpl.this.dispatchHandleWXPicRespOK(this.f287152f, this.f287153h);
                        return;
                    }
                }
                ShareActionHelperImpl.this.dispatchHandleWXPicRespCancel(this.f287152f, this.f287153h);
                return;
            }
            QLog.e(ShareActionHelperImpl.TAG, 1, "onWXShareResp: respData is null");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        try {
            if (g.f287107b.size() > 0) {
                sShareActionInjectInterface = g.f287107b.get(0).newInstance();
                QLog.d(TAG, 1, "ShareActionSheetInjectUtil newInstance");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "ShareActionSheetInjectUtil static statement: ", e16);
        }
    }

    public ShareActionHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRunnable(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    private com.tencent.mobileqq.sharehelper.c createInjectShare(String str) {
        QLog.d(TAG, 1, "createInjectShare type: " + str);
        try {
            return g.f287106a.get(str).newInstance();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createInjectShare type: " + str + " error: " + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShareWxSuccess() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareActionHelperImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQToast.makeText(BaseApplication.getContext(), R.string.hj9, 0).show();
                }
            }
        });
    }

    void dispatchAfterShareLinkToWX(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.e(i3);
        }
    }

    void dispatchAfterSharePicToWX(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.f(i3);
        }
    }

    void dispatchBeforeShareLinkToWX(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.j(i3);
        }
    }

    void dispatchBeforeSharePicToWX(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.h(i3);
        }
    }

    void dispatchHandleWXLinkRespCancel(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.a(i3);
        }
    }

    void dispatchHandleWXLinkRespDenied(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.d(i3);
        }
    }

    void dispatchHandleWXLinkRespOK(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.i(i3);
        }
    }

    void dispatchHandleWXPicRespCancel(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.c(i3);
        }
    }

    void dispatchHandleWXPicRespDenied(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.g(i3);
        }
    }

    void dispatchHandleWXPicRespOK(String str, int i3) {
        com.tencent.mobileqq.sharehelper.c createInjectShare = createInjectShare(str);
        if (createInjectShare != null) {
            createInjectShare.b(i3);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doSharTextToWeChat(String str, int i3, Activity activity, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), activity, str2, str3);
            return;
        }
        WXShareHelper.a[] aVarArr = {new a(str2, aVarArr, str, i3)};
        WXShareHelper.b0().A(aVarArr[0]);
        dispatchBeforeShareLinkToWX(str, i3);
        if (i3 != 9) {
            i16 = 1;
        }
        WXShareHelper.b0().H0(str3, i16, str2);
        QLog.d(TAG, 1, "shareTextToWeChat success");
        dispatchAfterShareLinkToWX(str, i3);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareArkBySelect(String str, Activity activity, com.tencent.mobileqq.sharehelper.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, activity, aVar);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_ark_app_name", aVar.a());
        intent.putExtra("forward_ark_app_view", aVar.c());
        intent.putExtra("forward_ark_app_ver", aVar.b());
        intent.putExtra("forward_ark_app_prompt", aVar.i());
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(aVar.e(), true);
        QLog.d(TAG, 1, "getShareArkIntent metaDataString: " + aVar.h());
        intent.putExtra("forward_ark_app_meta", aVar.h());
        intent.putExtras(aVar.f());
        if ("guildShare".equals(str)) {
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
        }
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
        QLog.d(TAG, 1, "shareToQQ success");
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareArkDirectly(String str, Activity activity, com.tencent.mobileqq.sharehelper.a aVar, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, activity, aVar, Integer.valueOf(i3), str2);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_ark_app_name", aVar.a());
        intent.putExtra("forward_ark_app_view", aVar.c());
        intent.putExtra("forward_ark_app_ver", aVar.b());
        intent.putExtra("forward_ark_app_prompt", aVar.i());
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(aVar.e(), true);
        String h16 = aVar.h();
        QLog.d(TAG, 1, "getShareArkIntent metaDataString: " + h16);
        intent.putExtra("forward_ark_app_meta", h16);
        intent.putExtras(aVar.f());
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", i3);
        bundle.putString("key_direct_show_uin", str2);
        intent.putExtras(bundle);
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareImageToQQBySelect(String str, Activity activity, ImageShareInfo imageShareInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, activity, imageShareInfo);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtra("forward_type", 1);
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(imageShareInfo.getBroadCastKey(), true);
        intent.setData(Uri.parse(imageShareInfo.getImageFilePath()));
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareImageToQQDirectly(String str, Activity activity, ImageShareInfo imageShareInfo, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, activity, imageShareInfo, Integer.valueOf(i3), str2);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtra("forward_type", 1);
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        intent.putExtra(imageShareInfo.getBroadCastKey(), true);
        intent.setData(Uri.parse(imageShareInfo.getImageFilePath()));
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", i3);
        bundle.putString("key_direct_show_uin", str2);
        intent.putExtras(bundle);
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareLinkToWeChat(String str, int i3, String str2, Activity activity, String str3, String str4, String str5, String str6, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Integer.valueOf(i3), str2, activity, str3, str4, str5, str6, runnable);
            return;
        }
        HashMap hashMap = new HashMap(1);
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "shareLinkToWeChat error: params wrong");
            QQToast.makeText(activity, 1, R.string.f170547zd4, 0).show();
            callRunnable(runnable);
            return;
        }
        if (!WXShareHelper.b0().e0()) {
            QLog.e(TAG, 1, "shareLinkToWeChat error: wechat not install");
            QQToast.makeText(activity, 1, R.string.f173257ih1, 0).show();
            callRunnable(runnable);
        } else {
            if (!WXShareHelper.b0().f0()) {
                QLog.e(TAG, 1, "shareLinkToWeChat error: wechat version not support");
                QQToast.makeText(activity, 1, R.string.f173258ih2, 0).show();
                callRunnable(runnable);
                return;
            }
            WXShareHelper.a[] aVarArr = {new b(str3, aVarArr, str, i3)};
            WXShareHelper.b0().A(aVarArr[0]);
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity);
            qQProgressDialog.setOnDismissListener(new c(runnable));
            Runnable runnable2 = new Runnable(str, i3, qQProgressDialog, hashMap, str3, str5, str4, str2) { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ String C;
                final /* synthetic */ String D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f287118d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f287119e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ QQProgressDialog f287120f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Map f287121h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f287122i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f287123m;

                {
                    this.f287118d = str;
                    this.f287119e = i3;
                    this.f287120f = qQProgressDialog;
                    this.f287121h = hashMap;
                    this.f287122i = str3;
                    this.f287123m = str5;
                    this.C = str4;
                    this.D = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ShareActionHelperImpl.this, str, Integer.valueOf(i3), qQProgressDialog, hashMap, str3, str5, str4, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ShareActionHelperImpl.this.dispatchBeforeShareLinkToWX(this.f287118d, this.f287119e);
                    QQProgressDialog qQProgressDialog2 = this.f287120f;
                    if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                        this.f287120f.dismiss();
                    }
                    Bitmap bitmap = (Bitmap) this.f287121h.remove("image");
                    if (this.f287119e == 9) {
                        i16 = 0;
                    } else {
                        i16 = 1;
                    }
                    WXShareHelper.b0().L0(this.f287122i, this.f287123m, bitmap, this.C, this.D, i16);
                    QLog.d(ShareActionHelperImpl.TAG, 1, "shareLinkToWeChat success");
                    ShareActionHelperImpl.this.dispatchAfterShareLinkToWX(this.f287118d, this.f287119e);
                }
            };
            qQProgressDialog.setMessage(R.string.c7z);
            qQProgressDialog.show();
            ThreadManagerV2.post(new Runnable(activity, str6, runnable2, hashMap) { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f287124d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f287125e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Runnable f287126f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Map f287127h;

                {
                    this.f287124d = activity;
                    this.f287125e = str6;
                    this.f287126f = runnable2;
                    this.f287127h = hashMap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ShareActionHelperImpl.this, activity, str6, runnable2, hashMap);
                    }
                }

                private void a(Bitmap bitmap) {
                    if (bitmap != null) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        int i16 = width * height;
                        if (i16 > 8000) {
                            double sqrt = Math.sqrt(8000.0d / i16);
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width * sqrt), (int) (height * sqrt), true);
                            bitmap.recycle();
                            bitmap = createScaledBitmap;
                        }
                        this.f287127h.put("image", bitmap);
                        Activity activity2 = this.f287124d;
                        if (activity2 != null) {
                            activity2.runOnUiThread(this.f287126f);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QLog.d(ShareActionHelperImpl.TAG, 1, "shareLinkToWeChat share url icon");
                        byte[] openUrlForByte = HttpUtil.openUrlForByte(this.f287124d, this.f287125e, "GET", null, null);
                        if (openUrlForByte != null) {
                            a(BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length));
                        } else {
                            Activity activity2 = this.f287124d;
                            if (activity2 != null) {
                                activity2.runOnUiThread(this.f287126f);
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e(ShareActionHelperImpl.TAG, 1, "shareLinkToWeChat  Exception : " + e16.getMessage());
                    } catch (OutOfMemoryError e17) {
                        QLog.e(ShareActionHelperImpl.TAG, 1, "shareLinkToWeChat  OutOfMemoryError : " + e17.getMessage());
                    }
                }
            }, 8, null, false);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doSharePicToWX(String str, Activity activity, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, activity, str2, str3, Integer.valueOf(i3));
            return;
        }
        HashMap hashMap = new HashMap(1);
        if (!WXShareHelper.b0().e0()) {
            QLog.e(TAG, 1, "shareToWeChat error: wechat not install");
            QQToast.makeText(activity, 1, R.string.f173257ih1, 0).show();
            return;
        }
        if (!WXShareHelper.b0().f0()) {
            QLog.e(TAG, 1, "shareToWeChat error: wechat version not support");
            QQToast.makeText(activity, 1, R.string.f173258ih2, 0).show();
            return;
        }
        WXShareHelper.a[] aVarArr = {new d(str2, aVarArr, str, i3)};
        WXShareHelper.b0().A(aVarArr[0]);
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity);
        Runnable runnable = new Runnable(str, i3, qQProgressDialog, hashMap, str3, str2) { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f287128d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f287129e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQProgressDialog f287130f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Map f287131h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f287132i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ String f287133m;

            {
                this.f287128d = str;
                this.f287129e = i3;
                this.f287130f = qQProgressDialog;
                this.f287131h = hashMap;
                this.f287132i = str3;
                this.f287133m = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ShareActionHelperImpl.this, str, Integer.valueOf(i3), qQProgressDialog, hashMap, str3, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ShareActionHelperImpl.this.dispatchBeforeSharePicToWX(this.f287128d, this.f287129e);
                QQProgressDialog qQProgressDialog2 = this.f287130f;
                if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                    this.f287130f.dismiss();
                }
                Bitmap bitmap = (Bitmap) this.f287131h.remove("image");
                WXShareHelper b06 = WXShareHelper.b0();
                String str4 = this.f287132i;
                if (this.f287129e == 9) {
                    i16 = 0;
                } else {
                    i16 = 1;
                }
                b06.x0(str4, bitmap, i16, false, this.f287133m);
                QLog.d(ShareActionHelperImpl.TAG, 1, "shareToWeChat success");
                ShareActionHelperImpl.this.dispatchAfterSharePicToWX(this.f287128d, this.f287129e);
            }
        };
        qQProgressDialog.setMessage(R.string.c7z);
        qQProgressDialog.show();
        ThreadManagerV2.post(new Runnable(str3, hashMap, activity, runnable) { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f287134d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Map f287135e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Activity f287136f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ Runnable f287137h;

            {
                this.f287134d = str3;
                this.f287135e = hashMap;
                this.f287136f = activity;
                this.f287137h = runnable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ShareActionHelperImpl.this, str3, hashMap, activity, runnable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    QLog.d(ShareActionHelperImpl.TAG, 1, "shareToWeChat decodeFile");
                    this.f287135e.put("image", BitmapFactory.decodeFile(this.f287134d));
                    Activity activity2 = this.f287136f;
                    if (activity2 != null) {
                        activity2.runOnUiThread(this.f287137h);
                    }
                } catch (Exception e16) {
                    QLog.e(ShareActionHelperImpl.TAG, 1, "shareToWeChat  Exception : " + e16.getMessage());
                } catch (OutOfMemoryError e17) {
                    QLog.e(ShareActionHelperImpl.TAG, 1, "shareToWeChat  OutOfMemoryError : " + e17.getMessage());
                }
            }
        }, 8, null, false);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareTextBySelect(String str, Activity activity, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, activity, str2);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "doShareTextDirectly: error, content is empty");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", -1);
        bundle.putString(AppConstants.Key.FORWARD_TEXT, str2);
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtras(bundle);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareTextDirectly(String str, Activity activity, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, activity, str2, Integer.valueOf(i3), str3);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "doShareTextDirectly: error, content is empty");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", -1);
        bundle.putString(AppConstants.Key.FORWARD_TEXT, str2);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putInt("key_direct_show_uin_type", i3);
        bundle.putString("key_direct_show_uin", str3);
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtras(bundle);
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS, -1);
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareToQZoneWithLink(String str, Context context, com.tencent.mobileqq.sharehelper.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, context, dVar);
        } else {
            sShareActionInjectInterface.a(context, dVar);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareToQZoneWithPics(String str, Context context, ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, context, arrayList, Integer.valueOf(i3));
        } else {
            sShareActionInjectInterface.b(context, arrayList, i3);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void shareQQMiniProgramToWX(String str, String str2, Bitmap bitmap, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            WXShareHelper.b0().B0(str, str2, bitmap, str3, str4, str5);
        } else {
            iPatchRedirector.redirect((short) 14, this, str, str2, bitmap, str3, str4, str5);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void shareTargetMiniProgramToWX(String str, String str2, String str3, Bitmap bitmap, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, str3, bitmap, str4, str5, str6);
        } else {
            WXShareHelper.b0().G0(str, str2, str3, bitmap, str4, str5, str6);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void shareQQMiniProgramToWX(String str, int i3, String str2, Activity activity, String str3, String str4, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), str2, activity, str3, str4, str5, str6, str7, str8);
            return;
        }
        HashMap hashMap = new HashMap(1);
        if (TextUtils.isEmpty(str2)) {
            QLog.e(TAG, 1, "shareQQMiniProgramToWX error: params wrong");
            QQToast.makeText(activity, 1, R.string.f170547zd4, 0).show();
            return;
        }
        if (!WXShareHelper.b0().e0()) {
            QLog.e(TAG, 1, "shareQQMiniProgramToWX error: wechat not install");
            QQToast.makeText(activity, 1, R.string.f173257ih1, 0).show();
        } else {
            if (!WXShareHelper.b0().f0()) {
                QLog.e(TAG, 1, "shareQQMiniProgramToWX error: wechat version not support");
                QQToast.makeText(activity, 1, R.string.f173258ih2, 0).show();
                return;
            }
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity);
            Runnable runnable = new Runnable(qQProgressDialog, hashMap, str7, str8, str5, str4, str2) { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.10
                static IPatchRedirector $redirector_;
                final /* synthetic */ String C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQProgressDialog f287108d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f287109e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f287110f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f287111h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f287112i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f287113m;

                {
                    this.f287108d = qQProgressDialog;
                    this.f287109e = hashMap;
                    this.f287110f = str7;
                    this.f287111h = str8;
                    this.f287112i = str5;
                    this.f287113m = str4;
                    this.C = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ShareActionHelperImpl.this, qQProgressDialog, hashMap, str7, str8, str5, str4, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQProgressDialog qQProgressDialog2 = this.f287108d;
                    if (qQProgressDialog2 != null && qQProgressDialog2.isShowing()) {
                        this.f287108d.dismiss();
                    }
                    WXShareHelper.b0().F0(this.f287110f, this.f287111h, (Bitmap) this.f287109e.remove("image"), this.f287112i, this.f287113m, this.C);
                    QLog.d(ShareActionHelperImpl.TAG, 1, "shareQQMiniProgramToWX success");
                }
            };
            qQProgressDialog.setMessage(R.string.c7z);
            qQProgressDialog.show();
            ThreadManagerV2.post(new Runnable(activity, str6, hashMap, runnable) { // from class: com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f287114d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f287115e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Map f287116f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Runnable f287117h;

                {
                    this.f287114d = activity;
                    this.f287115e = str6;
                    this.f287116f = hashMap;
                    this.f287117h = runnable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ShareActionHelperImpl.this, activity, str6, hashMap, runnable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QLog.d(ShareActionHelperImpl.TAG, 1, "shareQQMiniProgramToWX share url icon");
                        byte[] openUrlForByte = HttpUtil.openUrlForByte(this.f287114d, this.f287115e, "GET", null, null);
                        int i17 = 0;
                        if (openUrlForByte != null) {
                            i16 = openUrlForByte.length;
                        } else {
                            i16 = 0;
                        }
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(openUrlForByte, 0, i16);
                        int width = decodeByteArray.getWidth();
                        int height = decodeByteArray.getHeight();
                        int round = (int) Math.round(width * 0.8d);
                        int i18 = (height - round) / 2;
                        if (round > height) {
                            int round2 = (int) Math.round(height * 1.25d);
                            i18 = 0;
                            i17 = (width - round2) / 2;
                            width = round2;
                        } else {
                            height = round;
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, i17, i18, width, height);
                        decodeByteArray.recycle();
                        this.f287116f.put("image", createBitmap);
                        Activity activity2 = this.f287114d;
                        if (activity2 != null) {
                            activity2.runOnUiThread(this.f287117h);
                        }
                    } catch (Exception e16) {
                        QLog.e(ShareActionHelperImpl.TAG, 1, "shareQQMiniProgramToWX  Exception : " + e16);
                    } catch (OutOfMemoryError e17) {
                        QLog.e(ShareActionHelperImpl.TAG, 1, "shareQQMiniProgramToWX  OutOfMemoryError : " + e17);
                    }
                }
            }, 8, null, false);
        }
    }

    @Override // com.tencent.mobileqq.sharehelper.IShareActionHelper
    public void doShareLinkToWeChat(String str, int i3, String str2, Activity activity, String str3, String str4, String str5, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            doShareLinkToWeChat(str, i3, str2, activity, str3, str4, str5, str6, null);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), str2, activity, str3, str4, str5, str6);
        }
    }
}
