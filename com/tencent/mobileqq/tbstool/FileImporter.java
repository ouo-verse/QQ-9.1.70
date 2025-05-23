package com.tencent.mobileqq.tbstool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0005J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/tbstool/FileImporter;", "", "", "Ljava/io/File;", "fileList", "", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "grantCallback", "d", "Landroidx/activity/ComponentActivity;", tl.h.F, "i", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "g", "args", "result", "e", "f", "k", "Landroidx/activity/result/ActivityResultLauncher;", "b", "Landroidx/activity/result/ActivityResultLauncher;", "albumPhotoPickLauncher", "Landroid/webkit/ValueCallback;", "c", "Landroid/webkit/ValueCallback;", "photoCallback", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class FileImporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FileImporter f291396a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ActivityResultLauncher<Intent> albumPhotoPickLauncher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ValueCallback<List<File>> photoCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/tbstool/FileImporter$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDeniedWithoutShowDlg", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f291399a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f291400b;

        a(Function0<Unit> function0, Activity activity) {
            this.f291399a = function0;
            this.f291400b = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0, (Object) activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Activity activity, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            activity.finish();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                this.f291399a.invoke();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
            } else {
                super.onDeniedWithoutShowDlg(permissions, results);
                this.f291400b.finish();
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) dialog, (Object) deniedPermissions);
                return;
            }
            super.onDialogShow(dialog, deniedPermissions);
            if (dialog != null) {
                final Activity activity = this.f291400b;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.tbstool.b
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        FileImporter.a.b(activity, dialogInterface);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f291396a = new FileImporter();
        }
    }

    FileImporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(Activity activity, Function0<Unit> grantCallback) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.TBS_TOOL, QQPermissionConstants.Business.SCENE.TBS_TOOL));
        if (qQPermission.hasPermission(QQPermissionConstants.Business.ID.TBS_TOOL, QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE}, 2, new a(grantCallback, activity));
        } else {
            grantCallback.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(List<? extends File> fileList) {
        ValueCallback<List<File>> valueCallback = photoCallback;
        if (valueCallback != null) {
            Intrinsics.checkNotNull(valueCallback);
            valueCallback.onReceiveValue(fileList);
        }
        photoCallback = null;
    }

    public final void e(@NotNull final Activity activity, @NotNull Object args, @NotNull Object result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, args, result);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!(result instanceof ValueCallback)) {
            QLog.d("FileImporter", 1, "importPhoto error callback type");
            return;
        }
        final ValueCallback<List<File>> valueCallback = (ValueCallback) result;
        int i3 = 0;
        if (args instanceof Bundle) {
            i3 = ((Bundle) args).getInt("from", 0);
        }
        if (i3 == 0 && albumPhotoPickLauncher != null) {
            d(activity, new Function0<Unit>(valueCallback, activity) { // from class: com.tencent.mobileqq.tbstool.FileImporter$importPhoto$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Activity $activity;
                final /* synthetic */ ValueCallback<List<File>> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callback = valueCallback;
                    this.$activity = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) valueCallback, (Object) activity);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ActivityResultLauncher activityResultLauncher;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    FileImporter fileImporter = FileImporter.f291396a;
                    FileImporter.photoCallback = this.$callback;
                    activityResultLauncher = FileImporter.albumPhotoPickLauncher;
                    if (activityResultLauncher != null) {
                        activityResultLauncher.launch(FileImporter.f291396a.k(this.$activity));
                    }
                }
            });
        } else if (i3 == 1) {
            photoCallback = valueCallback;
            f(activity);
        }
    }

    public final void f(@NotNull Activity activity) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "filetbstool");
        bundle.putString("app_key", "");
        bundle.putString("wink_output_route", "/wink/output/filetbstool");
        bundle.putLong("wink_output_point", 2L);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putString(QQWinkConstants.EDITOR_NEXT_BUTTON_TEXT, "\u5b8c\u6210");
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
        bundle.putBoolean(QQWinkConstants.EDITOR_NEED_DRAFT, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_DISABLE_SAVE_PUBLISH_DRAFT, true);
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 1001);
        bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, 2);
        QQWinkPage qQWinkPage = QQWinkPage.Capture;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qQWinkPage);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkIndex(activity, new QQWinkConfig(listOf, qQWinkPage, null, null, 12, null), bundle);
    }

    public final void g(int requestCode, int resultCode, @Nullable Intent data) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (requestCode != 1001 || resultCode != -1 || data == null) {
            return;
        }
        Serializable serializableExtra = data.getSerializableExtra("OUTPUT_MEDIA");
        if (serializableExtra instanceof ArrayList) {
            arrayList = (ArrayList) serializableExtra;
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("FileImporter", 1, "onActivityResult outputMedia is null");
        } else {
            j(arrayList);
        }
    }

    public final void h(@NotNull ComponentActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("FileImporter", 1, "onCreate activity: " + activity);
        albumPhotoPickLauncher = TBSToolClientUtils.f291401a.E(activity, FileImporter$onCreate$1.INSTANCE);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = albumPhotoPickLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
        albumPhotoPickLauncher = null;
        photoCallback = null;
    }

    @NotNull
    public final Intent k(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Intent) iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Config.a aVar = new Config.a();
        aVar.f(TabType.TAB_IMAGE);
        aVar.e(10000000);
        PickerInitBean.a aVar2 = new PickerInitBean.a();
        aVar2.b("\u5b8c\u6210");
        return com.tencent.qqnt.qbasealbum.a.e(com.tencent.qqnt.qbasealbum.a.f360732a, activity, aVar.a(), aVar2.a(), null, TBSToolPreviewCustomization.class, 8, null);
    }
}
