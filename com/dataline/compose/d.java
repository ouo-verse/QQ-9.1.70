package com.dataline.compose;

import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/dataline/compose/d;", "", "", "uin", "b", "originScheme", "", "requestCode", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f32301a = new d();

    d() {
    }

    @NotNull
    public final String a(@NotNull String originScheme, int requestCode) {
        Intrinsics.checkNotNullParameter(originScheme, "originScheme");
        return originScheme + "&start_activity_for_result=" + requestCode;
    }

    @NotNull
    public final String b(@NotNull String uin) {
        QQAppInterface qQAppInterface;
        BaseBusinessHandler baseBusinessHandler;
        Intrinsics.checkNotNullParameter(uin, "uin");
        int i3 = 3;
        int i16 = 0;
        if (Intrinsics.areEqual(uin, AppConstants.DATALINE_IPAD_UIN)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            RegisterProxySvcPackHandler registerProxySvcPackHandler = null;
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface != null) {
                baseBusinessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
            } else {
                baseBusinessHandler = null;
            }
            if (baseBusinessHandler instanceof RegisterProxySvcPackHandler) {
                registerProxySvcPackHandler = (RegisterProxySvcPackHandler) baseBusinessHandler;
            }
            if (registerProxySvcPackHandler != null && registerProxySvcPackHandler.U2()) {
                i16 = 1;
            }
            if (i16 != 0) {
                i16 = 1;
            } else {
                i16 = 3;
            }
        } else if (Intrinsics.areEqual(uin, AppConstants.DATALINE_PHONE_UIN)) {
            i16 = 2;
        }
        if (PadUtil.a(BaseApplication.getContext()) != DeviceType.TABLET) {
            i3 = 2;
        }
        String str = "mqqapi://kuikly/open?local_bundle_name=nearbypro&version=1&src_type=web&page_name=dataline_detail&use_host_display_metrics=1&qui_token_theme_mode=0&kr_turbo_display=" + uin + "&target_uin=" + uin + "&target_type=" + i16 + "&self_type=" + i3;
        if (AppSetting.o(BaseApplication.getContext())) {
            return str + "&autorotate=1";
        }
        return str;
    }
}
