package com.tencent.mobileqq.vas.theme.api.impl;

import android.os.Parcel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/SimpleUIHandlerImpl;", "Lcom/tencent/mobileqq/vas/theme/api/ISimpleUIHandler;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "onPostThemeChanged", "", "sendSwitchAndSetSimpleUI", "", "bSwitch", "", "prefId", "", "bSwitchElsePref", "setReqTs", "ts", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SimpleUIHandlerImpl implements ISimpleUIHandler {
    public SimpleUIHandlerImpl() {
    }

    @Override // com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler
    public void onPostThemeChanged() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
        ((SimpleUIHandler) businessHandler).onPostThemeChanged();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler
    public long sendSwitchAndSetSimpleUI(boolean bSwitch, int prefId, boolean bSwitchElsePref) {
        boolean t16 = StudyModeManager.t();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
        return ((SimpleUIHandler) businessHandler).c3(bSwitch, prefId, bSwitchElsePref, t16);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler
    public void setReqTs(long ts5) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        BusinessHandler businessHandler = ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
        ((SimpleUIHandler) businessHandler).setReqTs(ts5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleUIHandlerImpl(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
