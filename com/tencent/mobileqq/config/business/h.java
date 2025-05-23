package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.h;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/config/business/h;", "", "a", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f202659b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/config/business/h$a;", "", "Lmqq/app/AppRuntime;", "app", "", "g", "", "c", "b", "f", "hide", "e", ViewStickEventHelper.IS_SHOW, "d", "", "DIY_EMOTICON_DISABLED", "Ljava/lang/String;", "KEY_HIDE_DIY_EMOTICON", "TAG", "diySwitch", "Z", "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.h$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean c(AppRuntime app) {
            BaseQQAppInterface baseQQAppInterface;
            if (app instanceof BaseQQAppInterface) {
                baseQQAppInterface = (BaseQQAppInterface) app;
            } else {
                baseQQAppInterface = null;
            }
            if (baseQQAppInterface == null) {
                QLog.i("DIYEmoticonConfig", 1, "isDIYEmoticonEmpty, NOT in main process");
                return false;
            }
            IRuntimeService runtimeService = baseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "qqApp.getRuntimeService(\u2026nagerService::class.java)");
            String listVersion = ((ICameraEmoRoamingManagerService) runtimeService).getListVersion();
            if (TextUtils.isEmpty(listVersion)) {
                QLog.i("DIYEmoticonConfig", 1, "isDIYEmoticonEmpty, version is empty");
                return false;
            }
            IRuntimeService runtimeService2 = baseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
            Intrinsics.checkNotNullExpressionValue(runtimeService2, "qqApp.getRuntimeService(\u2026nagerService::class.java)");
            List<CameraEmotionData> dataList = ((ICameraEmotionRoamingDBManagerService) runtimeService2).getEmoticonDataList();
            Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
            if (!dataList.isEmpty()) {
                QLog.i("DIYEmoticonConfig", 1, "isDIYEmoticonEmpty, data is not empty, version=" + listVersion);
                return false;
            }
            QLog.i("DIYEmoticonConfig", 1, "isDIYEmoticonEmpty, data is empty, version=" + listVersion);
            return true;
        }

        private final void g(final AppRuntime app) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.Companion.h(AppRuntime.this);
                }
            }, 32, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(AppRuntime app) {
            Intrinsics.checkNotNullParameter(app, "$app");
            Companion companion = h.INSTANCE;
            if (companion.c(app)) {
                QLog.i("DIYEmoticonConfig", 1, "update flag, hide the entrance");
                companion.e(app, true);
            } else {
                QLog.i("DIYEmoticonConfig", 1, "update flag, show the entrance");
                companion.e(app, false);
            }
        }

        public final boolean b() {
            return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("diy_emoticon_entrance_hiding", false);
        }

        public final void d(boolean isShow) {
            h.f202659b = isShow;
        }

        public final void e(@NotNull AppRuntime app, boolean hide) {
            Intrinsics.checkNotNullParameter(app, "app");
            QLog.i("DIYEmoticonConfig", 1, "setEntranceHidden, hide=" + hide);
            app.getPreferences().edit().putBoolean("hide_diy_emoticon_entrance", hide).apply();
        }

        public final boolean f(@NotNull AppRuntime app) {
            Intrinsics.checkNotNullParameter(app, "app");
            if (!b()) {
                return false;
            }
            g(app);
            if (!app.getPreferences().getBoolean("hide_diy_emoticon_entrance", false)) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }
}
