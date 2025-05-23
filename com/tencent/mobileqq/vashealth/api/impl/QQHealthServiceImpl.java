package com.tencent.mobileqq.vashealth.api.impl;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.vashealth.f;
import com.tencent.mobileqq.vashealth.x;
import g43.c;
import java.util.HashMap;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J:\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vashealth/api/impl/QQHealthServiceImpl;", "Lcom/tencent/mobileqq/vashealth/api/IQQHealthService;", "()V", "appRuntime", "Lmqq/app/AppRuntime;", "onCreate", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "openSportHippy", "context", "Landroid/content/Context;", "dataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "redirectAIOToMainPage", "", "src", "", "redirectAIOToMainPageInPA", "health-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QQHealthServiceImpl implements IQQHealthService {

    @Nullable
    private AppRuntime appRuntime;

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        this.appRuntime = appRuntime;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthService
    public void openSportHippy(@Nullable Context context, @Nullable HashMap<String, String> dataMap) {
        if (f.f312270a.j()) {
            x.m(context, "");
        } else {
            x.l(context, dataMap);
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthService
    public boolean redirectAIOToMainPage(@Nullable Context context, int src) {
        BaseQQAppInterface baseQQAppInterface;
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        } else {
            baseQQAppInterface = null;
        }
        return x.f(context, baseQQAppInterface, src, false);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IQQHealthService
    public void redirectAIOToMainPageInPA(@Nullable Context context) {
        AppInterface appInterface;
        String str;
        AppRuntime appRuntime = this.appRuntime;
        Context context2 = null;
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        c cVar = (c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100502");
        if (cVar != null) {
            str = cVar.getMainPageUrlSearchPA();
        } else {
            str = null;
        }
        if (appInterface != null) {
            context2 = appInterface.getApplicationContext();
        }
        x.h(context2, str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
