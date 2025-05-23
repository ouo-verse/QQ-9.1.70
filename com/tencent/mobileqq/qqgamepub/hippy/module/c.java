package com.tencent.mobileqq.qqgamepub.hippy.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountMsgViewController;
import com.tencent.mobileqq.qqgamepub.hippy.view.GameViewPagerController;
import com.tencent.mobileqq.qqgamepub.hippy.view.GpArkViewController;
import com.tencent.mobileqq.qqgamepub.hippy.view.GpMsgHelperViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements HippyAPIProvider {

    /* renamed from: a, reason: collision with root package name */
    private String f264546a;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f264547a;

        a(HippyEngineContext hippyEngineContext) {
            this.f264547a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new GamePubAccountModule(this.f264547a);
        }
    }

    public c(String str) {
        this.f264546a = str;
    }

    private boolean b() {
        if (TextUtils.isEmpty(this.f264546a)) {
            return false;
        }
        if (this.f264546a.startsWith(HippyQQConstants.ModuleName.QQ_GAME_CENTER) || ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).isQQGamePubHippyBundle(this.f264546a)) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(HippyQQConstants.ModuleName.QQ_GAME_ZONE);
        arrayList.add(HippyQQConstants.ModuleName.QQ_GAME_MIE);
        return arrayList.contains(this.f264546a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase c(HippyEngineContext hippyEngineContext) {
        return new QQWadlModule(hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(GamePubAccountMsgViewController.class);
        arrayList.add(GpMsgHelperViewController.class);
        arrayList.add(GpArkViewController.class);
        arrayList.add(GameViewPagerController.class);
        return arrayList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        if (b()) {
            hashMap.put(QQWadlModule.class, new Provider() { // from class: com.tencent.mobileqq.qqgamepub.hippy.module.b
                @Override // com.tencent.mtt.hippy.common.Provider
                public final Object get() {
                    HippyNativeModuleBase c16;
                    c16 = c.c(HippyEngineContext.this);
                    return c16;
                }
            });
        }
        hashMap.put(GamePubAccountModule.class, new a(hippyEngineContext));
        return hashMap;
    }
}
