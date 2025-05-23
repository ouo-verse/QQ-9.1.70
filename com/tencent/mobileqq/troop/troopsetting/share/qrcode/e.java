package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.share.qrcode.e;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.utils.eu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/e;", "Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/AbsQRCodeShareAction;", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfo", "", ReportConstant.COSTREPORT_PREFIX, "", "d", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends AbsQRCodeShareAction {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.qrcode.e$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/share/qrcode/e$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b f301476b;

        b(com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
            this.f301476b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e this$0, com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
            this$0.n(shareContext);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            final e eVar = e.this;
            final com.tencent.mobileqq.troop.troopsetting.share.b bVar = this.f301476b;
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.b(e.this, bVar);
                }
            });
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
            } else {
                super.onDenied(permissions, results);
                QLog.i("QRSaveAction", 1, "saveSnapshot, request permission denied");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61014);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void m(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        TroopInfoData h16 = shareContext.h();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            q d16 = new q(peekAppRuntime).i("P_CliOper").a("Grp_set").f("Grp_data").d("qr_save");
            String[] strArr = new String[2];
            String str = h16.troopUin;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "troopInfoData.troopUin ?: \"\"");
            }
            strArr[0] = str;
            strArr[1] = s(h16);
            d16.b(strArr).g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        Throwable th5;
        OutputStream outputStream;
        String message;
        StringBuilder sb5;
        String str;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Bitmap e16 = shareContext.e();
        final QBaseActivity b16 = shareContext.b();
        TroopInfoData h16 = shareContext.h();
        if (e16 != null && !e16.isRecycled()) {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentResolver contentResolver = b16.getContentResolver();
            if (contentResolver == null) {
                return;
            }
            String str2 = "qrcode_" + System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str2);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str2);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            final Uri insert = contentResolver.insert(uri, contentValues);
            AssetFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = 0;
            try {
                if (insert != null) {
                    try {
                        outputStream = contentResolver.openOutputStream(insert);
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        outputStream = null;
                        QLog.e("QRSaveAction", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr = new String[3];
                        strArr[0] = h16.troopUin;
                        strArr[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    } catch (IllegalStateException e18) {
                        e = e18;
                        outputStream = null;
                        QLog.e("QRSaveAction", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr2 = new String[3];
                        strArr2[0] = h16.troopUin;
                        strArr2[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr2[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        outputStream = null;
                        QLog.e("QRSaveAction", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr22 = new String[3];
                        strArr22[0] = h16.troopUin;
                        strArr22[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr22[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr22);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (autoCloseOutputStream != 0) {
                            try {
                                autoCloseOutputStream.close();
                                throw th5;
                            } catch (IOException e26) {
                                QLog.e("QRSaveAction", 1, "saveQRCodeInternal finally, error = " + e26.getMessage());
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } else {
                    outputStream = null;
                }
                if (outputStream != null) {
                    try {
                        booleanRef.element = e16.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);
                    } catch (FileNotFoundException e27) {
                        e = e27;
                        QLog.e("QRSaveAction", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e28) {
                                message = e28.getMessage();
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeInternal finally, error = ");
                                sb5.append(message);
                                QLog.e("QRSaveAction", 1, sb5.toString());
                                if (!booleanRef.element) {
                                }
                                String[] strArr222 = new String[3];
                                strArr222[0] = h16.troopUin;
                                strArr222[1] = s(h16);
                                if (booleanRef.element) {
                                }
                                strArr222[2] = str;
                                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr222);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        e.p(Ref.BooleanRef.this, b16, insert);
                                    }
                                });
                            }
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr2222 = new String[3];
                        strArr2222[0] = h16.troopUin;
                        strArr2222[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr2222[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    } catch (IllegalStateException e29) {
                        e = e29;
                        QLog.e("QRSaveAction", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e36) {
                                message = e36.getMessage();
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeInternal finally, error = ");
                                sb5.append(message);
                                QLog.e("QRSaveAction", 1, sb5.toString());
                                if (!booleanRef.element) {
                                    py3.b.e(contentResolver, insert, null, null);
                                }
                                String[] strArr22222 = new String[3];
                                strArr22222[0] = h16.troopUin;
                                strArr22222[1] = s(h16);
                                if (booleanRef.element) {
                                }
                                strArr22222[2] = str;
                                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr22222);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        e.p(Ref.BooleanRef.this, b16, insert);
                                    }
                                });
                            }
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr222222 = new String[3];
                        strArr222222[0] = h16.troopUin;
                        strArr222222[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr222222[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr222222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    } catch (OutOfMemoryError e37) {
                        e = e37;
                        QLog.e("QRSaveAction", 1, "saveQRCodeInternal, error = " + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e38) {
                                message = e38.getMessage();
                                sb5 = new StringBuilder();
                                sb5.append("saveQRCodeInternal finally, error = ");
                                sb5.append(message);
                                QLog.e("QRSaveAction", 1, sb5.toString());
                                if (!booleanRef.element) {
                                }
                                String[] strArr2222222 = new String[3];
                                strArr2222222[0] = h16.troopUin;
                                strArr2222222[1] = s(h16);
                                if (booleanRef.element) {
                                }
                                strArr2222222[2] = str;
                                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2222222);
                                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        e.p(Ref.BooleanRef.this, b16, insert);
                                    }
                                });
                            }
                        }
                        if (!booleanRef.element) {
                        }
                        String[] strArr22222222 = new String[3];
                        strArr22222222[0] = h16.troopUin;
                        strArr22222222[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr22222222[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr22222222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e39) {
                        message = e39.getMessage();
                        sb5 = new StringBuilder();
                        sb5.append("saveQRCodeInternal finally, error = ");
                        sb5.append(message);
                        QLog.e("QRSaveAction", 1, sb5.toString());
                        if (!booleanRef.element) {
                        }
                        String[] strArr222222222 = new String[3];
                        strArr222222222[0] = h16.troopUin;
                        strArr222222222[1] = s(h16);
                        if (booleanRef.element) {
                        }
                        strArr222222222[2] = str;
                        eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr222222222);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.p(Ref.BooleanRef.this, b16, insert);
                            }
                        });
                    }
                }
                if (!booleanRef.element && insert != null) {
                    py3.b.e(contentResolver, insert, null, null);
                }
                String[] strArr2222222222 = new String[3];
                strArr2222222222[0] = h16.troopUin;
                strArr2222222222[1] = s(h16);
                if (booleanRef.element) {
                    str = "0";
                } else {
                    str = "1";
                }
                strArr2222222222[2] = str;
                eu.g("Grp_share", "grpData_admin", "qr_save", 0, 0, strArr2222222222);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.p(Ref.BooleanRef.this, b16, insert);
                    }
                });
            } catch (Throwable th7) {
                th5 = th7;
                autoCloseOutputStream = "qrcode_";
            }
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.o(QBaseActivity.this);
                }
            });
            QLog.e("QRSaveAction", 1, "saveQRCodeInternal failed, bitmap is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.hit);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.share_fail)");
        companion.b(activity, 1, qqStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Ref.BooleanRef isSuccess, QBaseActivity activity, Uri uri) {
        Intrinsics.checkNotNullParameter(isSuccess, "$isSuccess");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (isSuccess.element) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            activity.sendBroadcast(intent);
            TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f216545yl);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qr_code_save_success)");
            companion.b(activity, 2, qqStr);
            return;
        }
        TroopSettingShareManager.Companion companion2 = TroopSettingShareManager.INSTANCE;
        String qqStr2 = HardCodeUtil.qqStr(R.string.h3w);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.save_file_error)");
        companion2.b(activity, 1, qqStr2);
    }

    private final void q(final com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        QBaseActivity b16 = shareContext.b();
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(b16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.hit);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.share_fail)");
            companion.b(b16, 1, qqStr);
            QLog.e("QRSaveAction", 1, "saveSnapshot, qqPermission is null");
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.r(e.this, shareContext);
                }
            });
        } else {
            QLog.i("QRSaveAction", 1, "saveSnapshot, request permission");
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(shareContext));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(e this$0, com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        this$0.n(shareContext);
    }

    private final String s(TroopInfoData troopInfo) {
        if (troopInfo.bOwner) {
            return "0";
        }
        if (troopInfo.bAdmin) {
            return "1";
        }
        if (troopInfo.isMember) {
            return "2";
        }
        return "3";
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        q(shareContext);
        m(shareContext);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf("save_to_phone");
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
