package com.tencent.comic.api;

import com.tencent.comic.api.hippy.IBoodoHippyApiBuilder;
import com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicHippyUtil extends QRouteApi {
    HippyAPIProvider createHippyAPIProvider();

    HippyCustomViewCreator createHippyCustomViewCreator();

    Class getComicModuleClass();

    IComicHippyBackEventInterceptor getHippyBackEventInterceptor();

    Class getHippyFragmentClass();

    HippyNativeModuleBase getHippyQQComicModule(HippyEngineContext hippyEngineContext);

    Class<? extends HippyNativeModuleBase> getHippyQQComicModuleClass();

    boolean isBoodoModule(String str);

    boolean isRuntimeReady();

    void setHippyApiBuilder(IBoodoHippyApiBuilder iBoodoHippyApiBuilder);

    void setHippyBackEventInterceptor(IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor);

    void setRuntimeReady(boolean z16);
}
