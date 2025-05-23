package com.tencent.comic.api.impl;

import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.comic.api.hippy.IBoodoHippyApiBuilder;
import com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.hippy.VipComicHippyFragment;
import com.tencent.comic.hippy.api.BoodoApiProvider;
import com.tencent.comic.hippy.api.ComicHippyBackEventInterceptorProxy;
import com.tencent.comic.hippy.module.ComicModule;
import com.tencent.comic.hippy.module.HippyQQComicModule;
import com.tencent.comic.hippy.view.QQCustomViewCreator;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes32.dex */
public class QQComicHippyUtilImpl implements IQQComicHippyUtil {
    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public HippyAPIProvider createHippyAPIProvider() {
        return new BoodoApiProvider();
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public HippyCustomViewCreator createHippyCustomViewCreator() {
        return new QQCustomViewCreator();
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public Class getComicModuleClass() {
        return ComicModule.class;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public IComicHippyBackEventInterceptor getHippyBackEventInterceptor() {
        return ComicHippyBackEventInterceptorProxy.INSTANCE.mProxy;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public Class getHippyFragmentClass() {
        return VipComicHippyFragment.class;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public HippyNativeModuleBase getHippyQQComicModule(HippyEngineContext hippyEngineContext) {
        return new HippyQQComicModule(hippyEngineContext);
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public Class<? extends HippyNativeModuleBase> getHippyQQComicModuleClass() {
        return HippyQQComicModule.class;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public boolean isBoodoModule(String str) {
        return BoodoHippyBirdge.isBoodoModule(str);
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public boolean isRuntimeReady() {
        return BoodoHippyBirdge.sBoodoRuntimeReady;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public void setHippyApiBuilder(IBoodoHippyApiBuilder iBoodoHippyApiBuilder) {
        BoodoHippyBirdge.sHippyApiBuilder = iBoodoHippyApiBuilder;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public void setHippyBackEventInterceptor(IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor) {
        ComicHippyBackEventInterceptorProxy.INSTANCE.mProxy = iComicHippyBackEventInterceptor;
    }

    @Override // com.tencent.comic.api.IQQComicHippyUtil
    public void setRuntimeReady(boolean z16) {
        BoodoHippyBirdge.sBoodoRuntimeReady = z16;
    }
}
