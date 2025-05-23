package com.tencent.mobileqq.avatar.api.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.avatar.aigc.QQAvatarMagicAvatarModifyDelegate;
import com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarMagicAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/QQAvatarAigcMagicAvatarApiImpl;", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarAigcMagicAvatarApi;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "showRedDot", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "launchAigcAvatarPicker", "", "enableAigcMagicAvatar", "Lorg/json/JSONObject;", "jsonObj", "checkIsMagicAvatar", "handleAigcMagicAvatarBannerClick", "handleActionSheetItemClick", "Landroid/view/View;", "view", "showRedPoint", "updateEntryRedTouch", "<init>", "()V", "Companion", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQAvatarAigcMagicAvatarApiImpl implements IQQAvatarAigcMagicAvatarApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String CONFIG_AVATAR_AIGC_SETTING_SWITCH = "aigc_magic_avatar_entry_switch";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String JSON_KEY_IS_MAGIC_AVATAR = "isAigcMagicAvatar";

    @NotNull
    public static final String JSON_KEY_TYPE = "type";

    @NotNull
    public static final String JSON_KEY_VAS_SCHEMA = "vas_schema";

    @NotNull
    private static final String MMKV_AIGC_MAGIC_AVATAR_NEED_SHOW_RED_POINT = "QQ_AVATAR_AIGC_MAGIC_AVATAR_NEED_SHOW_RED_POINT_";

    @NotNull
    public static final String TAG = "magicAvatar.QQAvatarAigcMagicAvatarApiImpl";

    @NotNull
    private static final com.tencent.mobileqq.avatar.a configSwitch;

    @NotNull
    private static final Lazy<MMKVOptionEntity> mmkvEntity$delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/QQAvatarAigcMagicAvatarApiImpl$a;", "", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkvEntity", "", "CONFIG_AVATAR_AIGC_SETTING_SWITCH", "Ljava/lang/String;", "JSON_KEY_IS_MAGIC_AVATAR", "JSON_KEY_TYPE", "JSON_KEY_VAS_SCHEMA", "MMKV_AIGC_MAGIC_AVATAR_NEED_SHOW_RED_POINT", "TAG", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.api.impl.QQAvatarAigcMagicAvatarApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MMKVOptionEntity a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MMKVOptionEntity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (MMKVOptionEntity) QQAvatarAigcMagicAvatarApiImpl.mmkvEntity$delegate.getValue();
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
        Lazy<MMKVOptionEntity> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17262);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        configSwitch = new com.tencent.mobileqq.avatar.a(CONFIG_AVATAR_AIGC_SETTING_SWITCH, false);
        lazy = LazyKt__LazyJVMKt.lazy(QQAvatarAigcMagicAvatarApiImpl$Companion$mmkvEntity$2.INSTANCE);
        mmkvEntity$delegate = lazy;
    }

    public QQAvatarAigcMagicAvatarApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void launchAigcAvatarPicker(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject(configSwitch.a());
            int i3 = jSONObject.getInt("type");
            String schema = jSONObject.getString(JSON_KEY_VAS_SCHEMA);
            boolean syncQzoneSwitch = ((IQQAvatarMagicAvatarUtilsApi) QRoute.api(IQQAvatarMagicAvatarUtilsApi.class)).getSyncQzoneSwitch(activity);
            String syncQzoneTips = ((IQQAvatarMagicAvatarUtilsApi) QRoute.api(IQQAvatarMagicAvatarUtilsApi.class)).getSyncQzoneTips(activity);
            QLog.i(TAG, 1, "launchAigcAvatarPicker type: " + i3 + ", syncQzone: " + syncQzoneSwitch + ", tips: " + syncQzoneTips);
            ModifyAvatarConfig modifyAvatarConfig = new ModifyAvatarConfig();
            modifyAvatarConfig.setAvatarSource(i3);
            modifyAvatarConfig.setMagicAvatarDelegateClassName(QQAvatarMagicAvatarModifyDelegate.class.getName());
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            modifyAvatarConfig.setOpenVipSchema(schema);
            modifyAvatarConfig.setSelectShareByDefault(syncQzoneSwitch);
            modifyAvatarConfig.setShareTipsText(syncQzoneTips);
            QRouteApi api = QRoute.api(IQQWinkLauncher.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IQQWinkLauncher::class.java)");
            IQQWinkLauncher.DefaultImpls.modifyMagicAvatar$default((IQQWinkLauncher) api, activity, modifyAvatarConfig, 0, 4, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "launchAigcAvatarPicker exception", e16);
        }
    }

    private final void showRedDot(RedTouch redTouch) {
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        redTypeInfo.red_type.set(0);
        redTypeInfo.red_desc.set("");
        redTypeInfo.red_content.set("");
        appInfo.red_display_info.red_type_info.add(redTypeInfo);
        appInfo.iNewFlag.set(1);
        redTouch.parseRedTouch(redTypeInfo);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi
    public boolean checkIsMagicAvatar(@Nullable JSONObject jsonObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jsonObj)).booleanValue();
        }
        if (jsonObj == null || !jsonObj.optBoolean(JSON_KEY_IS_MAGIC_AVATAR)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067 A[Catch: Exception -> 0x007e, TRY_LEAVE, TryCatch #0 {Exception -> 0x007e, blocks: (B:13:0x002a, B:15:0x0043, B:18:0x005b, B:23:0x0067), top: B:12:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d A[RETURN] */
    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enableAigcMagicAvatar() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.avatar.a aVar = configSwitch;
        if (!aVar.b()) {
            QLog.i(TAG, 1, "enableAigcMagicAvatar switch false");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(aVar.a());
            int i3 = jSONObject.getInt("type");
            String string = jSONObject.getString(JSON_KEY_VAS_SCHEMA);
            if (i3 <= 0) {
                QLog.e(TAG, 1, "enableAigcMagicAvatar type: " + i3);
                return false;
            }
            if (string != null && string.length() != 0) {
                z16 = false;
                if (z16) {
                    return true;
                }
                QLog.e(TAG, 1, "enableAigcMagicAvatar vasSchema: " + string);
                return false;
            }
            z16 = true;
            if (z16) {
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "enableAigcMagicAvatar catch exp", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi
    public void handleActionSheetItemClick(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            QLog.e(TAG, 1, "handleActionSheetItemClick activity is null");
        } else if (!enableAigcMagicAvatar()) {
            QLog.e(TAG, 1, "handleActionSheetItemClick not enable");
        } else {
            launchAigcAvatarPicker(activity);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi
    public boolean handleAigcMagicAvatarBannerClick(@Nullable Activity activity, @Nullable JSONObject jsonObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) jsonObj)).booleanValue();
        }
        if (activity == null) {
            QLog.e(TAG, 1, "handleAigcMagicAvatarBannerClick act is null");
            return false;
        }
        if (!checkIsMagicAvatar(jsonObj)) {
            QLog.e(TAG, 1, "handleAigcMagicAvatarClick not magicAvatar");
            return false;
        }
        if (!enableAigcMagicAvatar()) {
            QLog.e(TAG, 1, "handleAigcMagicAvatarBannerClick aigc not enable");
            return false;
        }
        launchAigcAvatarPicker(activity);
        return true;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarAigcMagicAvatarApi
    public void updateEntryRedTouch(@NotNull Activity activity, @NotNull View view, boolean showRedPoint) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, view, Boolean.valueOf(showRedPoint));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            QLog.e(TAG, 1, "updateEntryRedTouch cur uin is null");
            return;
        }
        String str2 = "QQ_AVATAR_AIGC_MAGIC_AVATAR_NEED_SHOW_RED_POINT__" + str;
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "view.parent");
        try {
            if (showRedPoint) {
                if (!INSTANCE.a().decodeBool(str2, true)) {
                    QLog.e(TAG, 1, "updateEntryRedTouch not needShowRedPoint");
                    return;
                } else {
                    if (parent instanceof RedTouch) {
                        showRedDot((RedTouch) parent);
                        return;
                    }
                    RedTouch applyTo = new RedTouch(activity, view).setGravity(53).applyTo();
                    Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(activity, view)\u2026               .applyTo()");
                    showRedDot(applyTo);
                    return;
                }
            }
            if (parent instanceof RedTouch) {
                ((RedTouch) parent).clearRedTouch();
            }
            INSTANCE.a().encodeBool(str2, false);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateEntryRedTouch catch exception", e16);
        }
    }
}
