package com.tencent.mobileqq.avatar.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi;
import com.tencent.mobileqq.avatar.picker.AvatarPickerCustomization;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.TabType;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001b\u0010\u0003\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/AvatarPhotoPickerHelperApiImpl;", "Lcom/tencent/mobileqq/avatar/api/IAvatarPhotoPickerHelperApi;", "", "useNewPhotoPicker", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "", "startPhotoPicker", "needInsertVasShoppingPageInfo", "useNewPhotoPicker$delegate", "Lkotlin/Lazy;", "getUseNewPhotoPicker", "()Z", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AvatarPhotoPickerHelperApiImpl implements IAvatarPhotoPickerHelperApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AvatarPhotoPickerHelperApiImpl";

    /* renamed from: useNewPhotoPicker$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy useNewPhotoPicker;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/AvatarPhotoPickerHelperApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.api.impl.AvatarPhotoPickerHelperApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvatarPhotoPickerHelperApiImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AvatarPhotoPickerHelperApiImpl$useNewPhotoPicker$2.INSTANCE);
            this.useNewPhotoPicker = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean getUseNewPhotoPicker() {
        return ((Boolean) this.useNewPhotoPicker.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi
    public boolean needInsertVasShoppingPageInfo(@Nullable Activity activity) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity)).booleanValue();
        }
        try {
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "needInsertVasShoppingPageInfo error", th5);
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fold_device_vas_shopping_page_set_avatar_fix", true) || activity == null) {
            return false;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            z16 = intent.getBooleanExtra("FROM_VAS_SHOPPING_PAGE", false);
        } else {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "needInsertVasShoppingPageInfo fromVasShoppingPage: " + z16);
        }
        if (z16) {
            if (PadUtil.a(BaseApplication.context) == DeviceType.FOLD) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.i(TAG, 1, "needInsertVasShoppingPageInfo: " + z17);
            return z17;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi
    public void startPhotoPicker(@NotNull Activity activity, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Config.a aVar = new Config.a();
        aVar.f(TabType.TAB_IMAGE);
        aVar.k(false);
        aVar.q(true);
        aVar.l(false);
        aVar.j(true);
        aVar.m(false);
        Intent e16 = com.tencent.qqnt.qbasealbum.a.e(com.tencent.qqnt.qbasealbum.a.f360732a, activity, aVar.a(), null, AvatarPickerCustomization.class, null, 20, null);
        e16.putExtras(bundle);
        activity.startActivity(e16);
    }

    @Override // com.tencent.mobileqq.avatar.api.IAvatarPhotoPickerHelperApi
    public boolean useNewPhotoPicker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return getUseNewPhotoPicker();
    }
}
