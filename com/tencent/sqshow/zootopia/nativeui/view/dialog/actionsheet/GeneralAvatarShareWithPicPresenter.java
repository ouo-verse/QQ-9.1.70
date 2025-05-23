package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishApiImpl;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.publish.a;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001a\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicPresenter;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/m;", "Landroid/app/Activity;", "context", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "p", "", "r", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "c", "b", "a", "", "action", "d", "g", "e", "f", "destroy", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/n;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/n;", "shareWithPicView", "com/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicPresenter$c", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicPresenter$c;", "xhsCallback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/n;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GeneralAvatarShareWithPicPresenter implements m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n shareWithPicView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final c xhsCallback;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicPresenter$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f371748b;

        b(Bitmap bitmap) {
            this.f371748b = bitmap;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            GeneralAvatarShareWithPicPresenter.this.r(this.f371748b);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/GeneralAvatarShareWithPicPresenter$c", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements XhsShareHelper.e {
        c() {
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onError(String sessionId, int errorCode, String errorMessage, Throwable throwable) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToXHS onError " + errorCode + " " + errorMessage);
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onSuccess(String sessionId) {
            QLog.i("GeneralAvatarShareWithPicPresenter", 1, "shareToXHS onSuccess");
        }
    }

    public GeneralAvatarShareWithPicPresenter(n shareWithPicView) {
        Intrinsics.checkNotNullParameter(shareWithPicView, "shareWithPicView");
        this.shareWithPicView = shareWithPicView;
        this.xhsCallback = new c();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String p(Activity context, Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        String str = "temp_zplan_avatar_share_" + System.currentTimeMillis() + ".png";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "zplan_cache_dir").getAbsolutePath()));
        if (!file.exists() && file.mkdirs()) {
            file = context.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(file, "context.cacheDir");
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), str);
            if (file2.exists()) {
                file2.delete();
            }
            String absolutePath = file2.getAbsolutePath();
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 75, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e17) {
                        QLog.d("GeneralAvatarShareWithPicPresenter", 2, e17.getMessage());
                    }
                    return absolutePath;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e18) {
                            QLog.d("GeneralAvatarShareWithPicPresenter", 2, e18.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                QLog.d("GeneralAvatarShareWithPicPresenter", 2, e.getMessage());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e26) {
                        QLog.d("GeneralAvatarShareWithPicPresenter", 2, e26.getMessage());
                    }
                }
                return null;
            }
        }
        return null;
    }

    private final boolean q(Activity context) {
        if (!WXShareHelper.b0().e0()) {
            QQToast.makeText(context, context.getString(R.string.f173257ih1), 0).show();
            return false;
        }
        if (WXShareHelper.b0().f0()) {
            return true;
        }
        QQToast.makeText(context, context.getString(R.string.f173258ih2), 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final Bitmap bitmap) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.k
            @Override // java.lang.Runnable
            public final void run() {
                GeneralAvatarShareWithPicPresenter.s(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00d6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void s(Bitmap bitmap) {
        OutputStream outputStream;
        OutputStream openOutputStream;
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        final boolean z16 = false;
        final Uri uri = null;
        if (!bitmap.isRecycled()) {
            Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContext().contentResolver");
            String str = "zplan_share_avatar_poster_" + String.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/png");
            Uri insert = contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
            if (insert != null) {
                try {
                    openOutputStream = contentResolver.openOutputStream(insert);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    try {
                        QLog.e("GeneralAvatarShareWithPicPresenter", 1, "saveToLocalInner, error = " + th);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("GeneralAvatarShareWithPicPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                GeneralAvatarShareWithPicPresenter.t(z16, uri);
                            }
                        });
                    } catch (Throwable th6) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e16) {
                                QLog.e("GeneralAvatarShareWithPicPresenter", 1, "saveToLocalInner finally, error = " + e16);
                            }
                        }
                        throw th6;
                    }
                }
            } else {
                openOutputStream = null;
            }
            if (openOutputStream != null) {
                try {
                    z16 = bitmap.compress(Bitmap.CompressFormat.PNG, 75, openOutputStream);
                } catch (Throwable th7) {
                    outputStream = openOutputStream;
                    th = th7;
                    QLog.e("GeneralAvatarShareWithPicPresenter", 1, "saveToLocalInner, error = " + th);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e17) {
                            e = e17;
                            sb5 = new StringBuilder();
                            sb5.append("saveToLocalInner finally, error = ");
                            sb5.append(e);
                            QLog.e("GeneralAvatarShareWithPicPresenter", 1, sb5.toString());
                            if (!z16) {
                                QLog.e("GeneralAvatarShareWithPicPresenter", 1, "saveToLocalInner delete file:" + insert);
                                py3.b.e(contentResolver, insert, null, null);
                            }
                            uri = insert;
                            QLog.d("GeneralAvatarShareWithPicPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GeneralAvatarShareWithPicPresenter.t(z16, uri);
                                }
                            });
                        }
                    }
                    if (!z16) {
                    }
                    uri = insert;
                    QLog.d("GeneralAvatarShareWithPicPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            GeneralAvatarShareWithPicPresenter.t(z16, uri);
                        }
                    });
                }
            }
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (IOException e18) {
                    e = e18;
                    sb5 = new StringBuilder();
                    sb5.append("saveToLocalInner finally, error = ");
                    sb5.append(e);
                    QLog.e("GeneralAvatarShareWithPicPresenter", 1, sb5.toString());
                    if (!z16) {
                    }
                    uri = insert;
                    QLog.d("GeneralAvatarShareWithPicPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            GeneralAvatarShareWithPicPresenter.t(z16, uri);
                        }
                    });
                }
            }
            if (!z16 && insert != null) {
                QLog.e("GeneralAvatarShareWithPicPresenter", 1, "saveToLocalInner delete file:" + insert);
                py3.b.e(contentResolver, insert, null, null);
            }
            uri = insert;
        }
        QLog.d("GeneralAvatarShareWithPicPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.l
            @Override // java.lang.Runnable
            public final void run() {
                GeneralAvatarShareWithPicPresenter.t(z16, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GeneralAvatarShareWithPicPresenter this$0, final Activity activity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            final String p16 = this$0.p(activity, bitmap);
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToQQ$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = p16;
                    if (str == null || str.length() == 0) {
                        QQToastUtil.showQQToast(1, R.string.xlf);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("forward_type", 1);
                    bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                    bundle.putString(AppConstants.Key.FORWARD_FILEPATH, p16);
                    bundle.putString(AppConstants.Key.FORWARD_THUMB, p16);
                    bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, p16);
                    bundle.putString(AppConstants.Key.FORWARD_EXTRA, p16);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(activity, intent, 21);
                }
            });
        } catch (OutOfMemoryError unused) {
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToQQ$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToastUtil.showQQToast(1, R.string.xlg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(GeneralAvatarShareWithPicPresenter this$0, final Activity activity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            final String p16 = this$0.p(activity, bitmap);
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToQZone$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = p16;
                    if (str == null || str.length() == 0) {
                        QQToastUtil.showQQToast(1, R.string.xlf);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        QQToastUtil.showQQToast(1, R.string.hiu);
                        QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToQZone failed\uff0c appRuntime is null!");
                    } else {
                        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                        userInfo.qzone_uin = peekAppRuntime.getAccount();
                        Activity activity2 = activity;
                        QZoneHelper.forwardToPublishMood(activity2, userInfo, p16, activity2.getResources().getString(R.string.xlh), "", 20001);
                    }
                }
            });
        } catch (OutOfMemoryError unused) {
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToQZone$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToastUtil.showQQToast(1, R.string.xlg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(GeneralAvatarShareWithPicPresenter this$0, Activity activity, final Bitmap bitmap, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            final String p16 = this$0.p(activity, bitmap);
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToWeChat$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str = p16;
                    if (str == null || str.length() == 0) {
                        QQToastUtil.showQQToast(1, R.string.xlf);
                        return;
                    }
                    int i16 = i3;
                    if (i16 == 9) {
                        WXShareHelper.b0().u0(p16, bitmap, 0);
                        return;
                    }
                    if (i16 != 10) {
                        QLog.d("GeneralAvatarShareWithPicPresenter", 1, "[shareToWeChat] unexpected action:" + i16);
                        return;
                    }
                    WXShareHelper.b0().u0(p16, bitmap, 1);
                }
            });
        } catch (OutOfMemoryError unused) {
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToWeChat$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToastUtil.showQQToast(1, R.string.xlg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final GeneralAvatarShareWithPicPresenter this$0, final Activity activity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            String p16 = this$0.p(activity, bitmap);
            final File file = p16 != null ? new File(p16) : null;
            final Boolean valueOf = file != null ? Boolean.valueOf(file.exists()) : null;
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToXHS$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ArrayList arrayListOf;
                    GeneralAvatarShareWithPicPresenter.c cVar;
                    if (!Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                        QQToastUtil.showQQToast(1, R.string.xlf);
                        return;
                    }
                    if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                        QQToastUtil.showQQToast(1, R.string.hiu);
                        QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToXHS failed\uff0c appRuntime is null!");
                        return;
                    }
                    XhsShareHelper xhsShareHelper = new XhsShareHelper();
                    if (xhsShareHelper.i("portalShare", activity)) {
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new XhsShareHelper.c(file, null, null));
                        XhsShareHelper.b bVar = new XhsShareHelper.b("", "", arrayListOf);
                        WeakReference<Activity> weakReference = new WeakReference<>(activity);
                        cVar = this$0.xhsCallback;
                        xhsShareHelper.l("portalShare", weakReference, bVar, new WeakReference<>(cVar));
                        return;
                    }
                    QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToXHS failed\uff0c no support");
                }
            });
        } catch (OutOfMemoryError unused) {
            t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.GeneralAvatarShareWithPicPresenter$shareToXHS$1$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToastUtil.showQQToast(1, R.string.xlg);
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void e() {
        Bitmap poster = this.shareWithPicView.getPoster();
        if (poster == null) {
            QQToastUtil.showQQToast(1, R.string.xbs);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            r(poster);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(poster));
        }
    }

    public void u() {
        this.shareWithPicView.show();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void destroy() {
        QLog.d("GeneralAvatarShareWithPicPresenter", 1, "destroy");
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void f(Activity context) {
        if (context == null) {
            QLog.e("GeneralAvatarShareWithPicPresenter", 1, "gotoDressingSquare failed");
        } else {
            QLog.d("GeneralAvatarShareWithPicPresenter", 1, "gotoDressingSquare");
            a.C9834a.a(ZPlanPublishApiImpl.f372397a, context, ZootopiaSource.INSTANCE.g(), ZPlanPublishSource.FROM_DRESS_SAVE_SHARE, null, 8, null);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void g(Activity context) {
        if (context == null) {
            QLog.e("GeneralAvatarShareWithPicPresenter", 1, "gotoSettingIcon failed");
            return;
        }
        QLog.d("GeneralAvatarShareWithPicPresenter", 1, "gotoSettingIcon");
        Context it = context.getApplicationContext();
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        iSchemeApi.launchScheme(it, "mqqapi://zplan/openPage?src_type=app&version=1.0&referer=13&pageID=13&newTask=1&pageData=%7B%22backupUrl%22%3A%20%22https%3A%2F%2Fmweb.superqqshow.qq.com%2Fpages%2F20fe9bc4-qqshow%2Findex.html%3F_cwv%3D1%26_wv%3D1360078691%26_wwv%3D8192%22%7D");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(boolean z16, Uri uri) {
        if (z16) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            BaseApplication.getContext().sendBroadcast(intent);
            QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(R.string.xbt), 1).show();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.xs7, 1).show();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void a(final Activity context) {
        if (context == null) {
            QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToXHS failed, activity is null!");
            return;
        }
        final Bitmap poster = this.shareWithPicView.getPoster();
        if (poster == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
        } else {
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.i
                @Override // java.lang.Runnable
                public final void run() {
                    GeneralAvatarShareWithPicPresenter.y(GeneralAvatarShareWithPicPresenter.this, context, poster);
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void b(final Activity context) {
        if (context == null) {
            QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToQZone failed, activity is null!");
            return;
        }
        final Bitmap poster = this.shareWithPicView.getPoster();
        if (poster == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
        } else {
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.g
                @Override // java.lang.Runnable
                public final void run() {
                    GeneralAvatarShareWithPicPresenter.w(GeneralAvatarShareWithPicPresenter.this, context, poster);
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void c(final Activity context) {
        if (context == null) {
            QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToQQ failed, activity is null!");
            return;
        }
        final Bitmap poster = this.shareWithPicView.getPoster();
        if (poster == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
        } else {
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.h
                @Override // java.lang.Runnable
                public final void run() {
                    GeneralAvatarShareWithPicPresenter.v(GeneralAvatarShareWithPicPresenter.this, context, poster);
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.m
    public void d(final Activity context, final int action) {
        if (context != null && q(context)) {
            final Bitmap poster = this.shareWithPicView.getPoster();
            if (poster == null) {
                QQToastUtil.showQQToast(1, R.string.hiu);
                return;
            } else {
                t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        GeneralAvatarShareWithPicPresenter.x(GeneralAvatarShareWithPicPresenter.this, context, poster, action);
                    }
                });
                return;
            }
        }
        QLog.e("GeneralAvatarShareWithPicPresenter", 1, "shareToWeChat failed");
    }
}
