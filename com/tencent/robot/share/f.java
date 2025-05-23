package com.tencent.robot.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.share.f;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/share/f;", "", "", tl.h.F, "", "copyText", "e", "f", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "actionItem", "", "specifiedFriend", "supportChannelMultiSelection", "k", "shareTitle", "robotDesc", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "toWeChatCircle", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "mActivity", "b", "Ljava/lang/String;", "mQRFilePath", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "preview", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity mActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mQRFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bitmap preview;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/share/f$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(f this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.h();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            final f fVar = f.this;
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.robot.share.g
                @Override // java.lang.Runnable
                public final void run() {
                    f.b.b(f.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            QLog.i("robot.share.RobotQRCodeShareActionExecutor", 1, "saveSnapshot, request permission denied");
        }
    }

    public f(@NotNull Activity mActivity, @NotNull String mQRFilePath, @NotNull Bitmap preview) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(mQRFilePath, "mQRFilePath");
        Intrinsics.checkNotNullParameter(preview, "preview");
        this.mActivity = mActivity;
        this.mQRFilePath = mQRFilePath;
        this.preview = preview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        ?? r95;
        ?? r96;
        ?? r97;
        OutputStream openOutputStream;
        String message;
        StringBuilder sb5;
        Object obj;
        if (this.preview.isRecycled()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.i();
                }
            });
            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal failed, bitmap is null");
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ?? contentResolver = this.mActivity.getContentResolver();
        if (contentResolver == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb6 = new StringBuilder();
        String str = "robot_qrcode_";
        sb6.append("robot_qrcode_");
        sb6.append(currentTimeMillis);
        String sb7 = sb6.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", sb7);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, sb7);
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
        ?? insert = contentResolver.insert(uri, contentValues);
        objectRef.element = insert;
        ?? r75 = null;
        try {
            if (insert != 0) {
                try {
                    openOutputStream = contentResolver.openOutputStream(insert);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    r97 = 0;
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal, error = " + e.getMessage());
                    str = r97;
                    if (r97 != 0) {
                    }
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                } catch (IllegalStateException e17) {
                    e = e17;
                    r96 = 0;
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal, error = " + e.getMessage());
                    str = r96;
                    if (r96 != 0) {
                    }
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    r95 = 0;
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal, error = " + e.getMessage());
                    str = r95;
                    if (r95 != 0) {
                    }
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                } catch (Throwable th5) {
                    th = th5;
                    if (r75 != null) {
                    }
                    throw th;
                }
            } else {
                openOutputStream = null;
            }
            if (openOutputStream != null) {
                try {
                    booleanRef.element = this.preview.compress(Bitmap.CompressFormat.PNG, 75, openOutputStream);
                } catch (FileNotFoundException e19) {
                    r97 = openOutputStream;
                    e = e19;
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal, error = " + e.getMessage());
                    str = r97;
                    if (r97 != 0) {
                        try {
                            r97.close();
                            str = r97;
                        } catch (IOException e26) {
                            message = e26.getMessage();
                            sb5 = new StringBuilder();
                            sb5.append("saveQRCodeInternal finally, error = ");
                            sb5.append(message);
                            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, sb5.toString());
                            if (!booleanRef.element) {
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.j(Ref.BooleanRef.this, this, objectRef);
                                }
                            });
                        }
                    }
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                } catch (IllegalStateException e27) {
                    r96 = openOutputStream;
                    e = e27;
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal, error = " + e.getMessage());
                    str = r96;
                    if (r96 != 0) {
                        try {
                            r96.close();
                            str = r96;
                        } catch (IOException e28) {
                            message = e28.getMessage();
                            sb5 = new StringBuilder();
                            sb5.append("saveQRCodeInternal finally, error = ");
                            sb5.append(message);
                            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, sb5.toString());
                            if (!booleanRef.element) {
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.j(Ref.BooleanRef.this, this, objectRef);
                                }
                            });
                        }
                    }
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                } catch (OutOfMemoryError e29) {
                    r95 = openOutputStream;
                    e = e29;
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal, error = " + e.getMessage());
                    str = r95;
                    if (r95 != 0) {
                        try {
                            r95.close();
                            str = r95;
                        } catch (IOException e36) {
                            message = e36.getMessage();
                            sb5 = new StringBuilder();
                            sb5.append("saveQRCodeInternal finally, error = ");
                            sb5.append(message);
                            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, sb5.toString());
                            if (!booleanRef.element) {
                                py3.b.e(contentResolver, (Uri) obj, null, null);
                            }
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f.j(Ref.BooleanRef.this, this, objectRef);
                                }
                            });
                        }
                    }
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                } catch (Throwable th6) {
                    th = th6;
                    r75 = openOutputStream;
                    if (r75 != null) {
                        try {
                            r75.close();
                        } catch (IOException e37) {
                            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveQRCodeInternal finally, error = " + e37.getMessage());
                        }
                    }
                    throw th;
                }
            }
            if (openOutputStream != null) {
                try {
                    openOutputStream.close();
                } catch (IOException e38) {
                    message = e38.getMessage();
                    sb5 = new StringBuilder();
                    sb5.append("saveQRCodeInternal finally, error = ");
                    sb5.append(message);
                    QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, sb5.toString());
                    if (!booleanRef.element) {
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.j(Ref.BooleanRef.this, this, objectRef);
                        }
                    });
                }
            }
            if (!booleanRef.element && (obj = objectRef.element) != null) {
                py3.b.e(contentResolver, (Uri) obj, null, null);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.share.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.j(Ref.BooleanRef.this, this, objectRef);
                }
            });
        } catch (Throwable th7) {
            th = th7;
            r75 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        v44.c.f440966a.g(1, R.string.f222856en);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Ref.BooleanRef isSuccess, f this$0, Ref.ObjectRef insertUri) {
        Intrinsics.checkNotNullParameter(isSuccess, "$isSuccess");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(insertUri, "$insertUri");
        if (isSuccess.element) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData((Uri) insertUri.element);
            this$0.mActivity.sendBroadcast(intent);
            v44.c.f440966a.g(2, R.string.f222876ep);
            return;
        }
        v44.c.f440966a.g(1, R.string.f222896er);
    }

    public static /* synthetic */ void l(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        fVar.k(actionSheetItem, z16, z17);
    }

    public final void e(@NotNull String copyText) {
        Intrinsics.checkNotNullParameter(copyText, "copyText");
        Object systemService = this.mActivity.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("robot_jump_url", copyText));
        v44.c.f440966a.g(2, R.string.f222846em);
    }

    public final void f() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(this.mActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            v44.c.f440966a.g(1, R.string.f222856en);
            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "saveSnapshot, qqPermission is null");
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.robot.share.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.g(f.this);
                }
            });
        } else {
            QLog.i("robot.share.RobotQRCodeShareActionExecutor", 1, "saveSnapshot, request permission");
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
        }
    }

    public final void k(@NotNull ShareActionSheetBuilder.ActionSheetItem actionItem, boolean specifiedFriend, boolean supportChannelMultiSelection) {
        int i3;
        Intrinsics.checkNotNullParameter(actionItem, "actionItem");
        File file = new File(this.mQRFilePath);
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, false);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, this.mQRFilePath);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, this.mQRFilePath);
        AIOPictureData aIOPictureData = new AIOPictureData();
        String str = this.mQRFilePath;
        aIOPictureData.largeImageFile = str;
        aIOPictureData.originImageFile = str;
        aIOPictureData.thumbImageFile = str;
        if (specifiedFriend) {
            i3 = 72;
        } else {
            i3 = actionItem.action;
        }
        int i16 = i3;
        if (actionItem.action == 171) {
            if (supportChannelMultiSelection) {
                Intent forwardPicToFriendIntent = ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getForwardPicToFriendIntent(file, false, aIOPictureData, bundle, this.mActivity);
                forwardPicToFriendIntent.putExtra("call_by_forward", true);
                ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(this.mActivity, forwardPicToFriendIntent, 103);
                return;
            }
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(file, false, aIOPictureData, bundle, this.mActivity, i16, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
            return;
        }
        ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardPicToFriend(file, false, aIOPictureData, bundle, this.mActivity, i16, actionItem.uin, actionItem.uinType, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
    }

    public final void m(@NotNull String shareTitle, @NotNull String robotDesc) {
        Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
        Intrinsics.checkNotNullParameter(robotDesc, "robotDesc");
        QZoneHelper.forwardToPublishMood(this.mActivity, QZoneHelper.UserInfo.getInstance(), this.mQRFilePath, shareTitle, robotDesc, 1);
    }

    public final void n(boolean toWeChatCircle) {
        if (!WXShareHelper.b0().e0()) {
            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "shareToWeChat failed, wx not installed");
            QQToastUtil.showQQToast(1, R.string.f173257ih1);
        } else if (!WXShareHelper.b0().f0()) {
            QLog.e("robot.share.RobotQRCodeShareActionExecutor", 1, "shareToWeChat failed, wx version too low");
            QQToastUtil.showQQToast(1, R.string.f173258ih2);
        } else {
            WXShareHelper.b0().w0(this.mQRFilePath, this.preview, toWeChatCircle ? 1 : 0, false);
        }
    }
}
