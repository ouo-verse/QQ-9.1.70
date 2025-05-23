package com.tencent.aelight.camera.aioeditor.share.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AIOShareHelperImpl implements IAIOShareHelper {
    private static final String TAG = "AIOShareHelperImpl";
    private QQProgressDialog mLoadingDialog;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements WXShareHelper.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IAIOShareHelper.a f67555d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f67556e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f67557f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ pr.a f67558h;

        a(IAIOShareHelper.a aVar, int i3, String str, pr.a aVar2) {
            this.f67555d = aVar;
            this.f67556e = i3;
            this.f67557f = str;
            this.f67558h = aVar2;
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            ms.a.f(AIOShareHelperImpl.TAG, "send to wechat result, errCode = " + baseResp.errCode + ", errStr = " + baseResp.errStr);
            WXShareHelper.b0().q0(this);
            this.f67555d.a(baseResp.errCode == 0, this.f67556e, this.f67557f, this.f67558h);
        }
    }

    private boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper
    public void dismissLoading() {
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.7
            @Override // java.lang.Runnable
            public void run() {
                if (AIOShareHelperImpl.this.mLoadingDialog != null) {
                    if (AIOShareHelperImpl.this.mLoadingDialog.isShowing()) {
                        AIOShareHelperImpl.this.mLoadingDialog.dismiss();
                    }
                    AIOShareHelperImpl.this.mLoadingDialog = null;
                }
            }
        };
        if (isUIThread()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper
    public void shareToQQ(final Activity activity, final int i3, final String str, final pr.a aVar) {
        ms.a.f(TAG, "real shareToQQ: uinType = " + i3 + ", uin = " + str + ", shareObj = " + aVar);
        final Intent intent = new Intent();
        final Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                AIOShareHelperImpl.this.dismissLoading();
                intent.putExtra("caller_name", activity.getClass().getSimpleName());
                intent.putExtra("forward_source_business_type", -1);
                intent.putExtra("forward_source_sub_business_type", "");
                intent.putExtra("key_allow_multiple_forward_from_limit", false);
                intent.putExtra("is_need_show_toast", false);
                intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
                boolean z16 = !TextUtils.isEmpty(str);
                if (z16) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                    bundle.putInt("key_direct_show_uin_type", i3);
                    bundle.putString("key_direct_show_uin", str);
                    intent.putExtras(bundle);
                }
                Activity activity2 = activity;
                Intent intent2 = intent;
                if (z16) {
                    str2 = RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS;
                } else {
                    str2 = RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT;
                }
                RouteUtils.startActivityForResult(activity2, intent2, str2, aVar.d());
            }
        };
        if (aVar.g()) {
            intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
            intent.putExtra("forward_type", 1);
            intent.setData(Uri.parse(aVar.c()));
            ThreadManager.getUIHandler().post(runnable);
            return;
        }
        if (aVar.h()) {
            showLoading(activity);
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    String c16 = aVar.c();
                    File file = new File(c16);
                    if (!file.exists()) {
                        AIOShareHelperImpl.this.dismissLoading();
                        ms.a.c(AIOShareHelperImpl.TAG, "share video to QQ, but video file is not exist");
                        return;
                    }
                    intent.putExtra("forward_type", 21);
                    intent.putExtra("file_send_path", aVar.c());
                    intent.putExtra(ShortVideoConstants.FROM_UIN, BaseApplicationImpl.getApplication().getRuntime().getAccount());
                    intent.putExtra(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
                    int a16 = aVar.a();
                    int f16 = aVar.f();
                    int b16 = aVar.b();
                    intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, (int) file.length());
                    String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(c16));
                    intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, bytes2HexStr);
                    intent.putExtra("file_name", file.getName());
                    ms.a.f(AIOShareHelperImpl.TAG, "video file md5 = " + bytes2HexStr + ", file name = " + file.getName());
                    if (a16 > 0) {
                        intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, (int) Math.round(a16 / 1000.0d));
                    }
                    if (f16 > 0 && b16 > 0) {
                        intent.putExtra(ShortVideoConstants.FILE_WIDTH, f16);
                        intent.putExtra(ShortVideoConstants.FILE_HEIGHT, b16);
                    }
                    String e16 = aVar.e();
                    if (!TextUtils.isEmpty(e16)) {
                        ms.a.f(AIOShareHelperImpl.TAG, "video file has thumbnail");
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(e16, options);
                        int i16 = options.outWidth;
                        int i17 = options.outHeight;
                        if (i16 > 0 && i17 > 0) {
                            String bytes2HexStr2 = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(e16));
                            intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, bytes2HexStr2);
                            intent.putExtra(AppConstants.Key.FORWARD_THUMB, e16);
                            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, e16);
                            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, i16);
                            intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, i17);
                            ms.a.f(AIOShareHelperImpl.TAG, "decode video thumbnail success, width = " + i16 + ", height = " + i17 + ", md5 = " + bytes2HexStr2);
                        } else {
                            ms.a.c(AIOShareHelperImpl.TAG, "decode video thumbnail fail");
                        }
                    }
                    ThreadManager.getUIHandler().post(runnable);
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper
    public void shareToQZone(final Activity activity, final pr.a aVar) {
        ms.a.f(TAG, "real shareToQZone, shareObj = " + aVar);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (aVar.g()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("images", new ArrayList<>(Collections.singletonList(aVar.c())));
                    QZoneShareManager.publishToQzone(com.tencent.aelight.camera.aebase.a.a(), activity, bundle, null, aVar.d());
                } else if (aVar.h()) {
                    QZoneHelper.forwardToPublishMood(activity, QZoneHelper.UserInfo.getInstance(), aVar.c(), aVar.d());
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper
    public void shareToWX(Activity activity, final int i3, final String str, final pr.a aVar, final IAIOShareHelper.a aVar2) {
        ms.a.f(TAG, "real shareToWX, shareType = " + i3 + ", transaction = " + str + ", shareObj = " + aVar);
        if (!WXShareHelper.b0().e0()) {
            ms.a.c(TAG, "shareToWeChat error: wechat not install");
            QQToast.makeText(activity, 1, R.string.f173257ih1, 0).show();
        } else {
            if (!WXShareHelper.b0().f0()) {
                ms.a.c(TAG, "shareToWeChat error: wechat version not support");
                QQToast.makeText(activity, 1, R.string.f173258ih2, 0).show();
                return;
            }
            if (aVar2 != null) {
                WXShareHelper.b0().A(new a(aVar2, i3, str, aVar));
            }
            showLoading(activity);
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar.g()) {
                        final Bitmap decodeFile = BitmapFactory.decodeFile(aVar.c());
                        if (decodeFile == null) {
                            ms.a.c(AIOShareHelperImpl.TAG, "share image to wx, but decode image fail");
                            AIOShareHelperImpl.this.dismissLoading();
                            IAIOShareHelper.a aVar3 = aVar2;
                            if (aVar3 != null) {
                                aVar3.a(false, i3, str, aVar);
                                return;
                            }
                            return;
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AIOShareHelperImpl.this.dismissLoading();
                                WXShareHelper b06 = WXShareHelper.b0();
                                String c16 = aVar.c();
                                Bitmap bitmap = decodeFile;
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                b06.x0(c16, bitmap, i3 == 9 ? 0 : 1, false, str);
                            }
                        });
                        return;
                    }
                    if (aVar.h()) {
                        final Bitmap decodeFile2 = BitmapFactory.decodeFile(aVar.e());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AIOShareHelperImpl.this.dismissLoading();
                                WXShareHelper.b0().t0(aVar.c(), decodeFile2);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.share.IAIOShareHelper
    public void showLoading(final Activity activity) {
        Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.share.impl.AIOShareHelperImpl.6
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 == null || activity2.isFinishing()) {
                    AIOShareHelperImpl.this.mLoadingDialog = null;
                    return;
                }
                if (AIOShareHelperImpl.this.mLoadingDialog == null || !AIOShareHelperImpl.this.mLoadingDialog.isShowing()) {
                    AIOShareHelperImpl.this.mLoadingDialog = new QQProgressDialog(activity);
                    AIOShareHelperImpl.this.mLoadingDialog.setMessage(R.string.c7z);
                    AIOShareHelperImpl.this.mLoadingDialog.show();
                }
            }
        };
        if (isUIThread()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }
}
