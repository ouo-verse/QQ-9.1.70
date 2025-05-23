package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/utils/ew;", "", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ew {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ew f307758a = new ew();

    ew() {
    }

    @JvmStatic
    public static final boolean a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(IFe\u2026ava, ProcessConstant.ALL)");
            boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("unread_red_drag_view");
            QLog.d("UnreadRedDragViewFeatureSwitch", 1, "getUnreadRedDragViewFeatureSwitch: " + isFeatureSwitchEnable);
            return isFeatureSwitchEnable;
        }
        QLog.d("UnreadRedDragViewFeatureSwitch", 1, "getUnreadRedDragViewFeatureSwitch: false, do return. ");
        return false;
    }
}
