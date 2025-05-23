package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R!\u0010\u000b\u001a\u00020\u00048FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/utils/JumpActionSdkShareHelper;", "", "", "localImagePath", "", "a", "b", "Lkotlin/Lazy;", "()Z", "getEnableShareLocalImageFile$annotations", "()V", "enableShareLocalImageFile", "<init>", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class JumpActionSdkShareHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final JumpActionSdkShareHelper f307023a = new JumpActionSdkShareHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableShareLocalImageFile;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.utils.JumpActionSdkShareHelper$enableShareLocalImageFile$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_share_msg_forbid_local_image_path_switch", false);
                QLog.i("JumpActionSdkShareHelper", 1, "enableShareLocalImageFile: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        enableShareLocalImageFile = lazy;
    }

    JumpActionSdkShareHelper() {
    }

    @JvmStatic
    public static final boolean a(@NotNull String localImagePath) {
        String str;
        boolean z16;
        boolean z17;
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(localImagePath, "localImagePath");
        if (TextUtils.isEmpty(localImagePath)) {
            QLog.i("JumpActionSdkShareHelper", 1, "checkLocalImageFileEnable: param path is empty");
            return false;
        }
        if (b()) {
            QLog.i("JumpActionSdkShareHelper", 1, "checkLocalImageFileEnable: enableShareLocalImageFile");
            return true;
        }
        File externalFilesDir = BaseApplication.getContext().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getParent();
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(localImagePath, str, false, 2, null);
            if (startsWith$default2) {
                QLog.i("JumpActionSdkShareHelper", 1, "checkLocalImageFileEnable: isAppDir");
                return true;
            }
        }
        String parent = BaseApplication.getContext().getFilesDir().getParent();
        if (parent != null) {
            str2 = parent;
        }
        if (str2.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(localImagePath, str2, false, 2, null);
            if (startsWith$default) {
                QLog.i("JumpActionSdkShareHelper", 1, "checkLocalImageFileEnable: isInternal");
                return true;
            }
        }
        QLog.i("JumpActionSdkShareHelper", 1, "checkLocalImageFileEnable: false");
        return false;
    }

    public static final boolean b() {
        return ((Boolean) enableShareLocalImageFile.getValue()).booleanValue();
    }
}
