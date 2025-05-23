package com.qzone.module.personalitycomponent;

import android.content.Context;
import android.os.Handler;
import com.qzone.module.Module;
import com.qzone.module.personalitycomponent.coverWidget.k;
import com.qzone.proxy.personalitycomponent.IPersonalityComponentService;
import com.qzone.proxy.personalitycomponent.IPersonalityComponentUI;

/* loaded from: classes39.dex */
public class PersonalityModule extends Module<IPersonalityComponentUI, IPersonalityComponentService> {

    /* renamed from: a, reason: collision with root package name */
    private IPersonalityComponentUI f48794a = new a();

    /* renamed from: b, reason: collision with root package name */
    private IPersonalityComponentService f48795b = new b();

    /* loaded from: classes39.dex */
    class a implements IPersonalityComponentUI {
        a() {
        }

        @Override // com.qzone.proxy.personalitycomponent.IPersonalityComponentUI
        public com.qzone.module.personalitycomponent.coverWidget.b getWidgetController(Context context, Handler handler, int i3) {
            return com.qzone.module.personalitycomponent.coverWidget.b.f(context, handler, i3);
        }
    }

    /* loaded from: classes39.dex */
    class b implements IPersonalityComponentService {
        b() {
        }

        @Override // com.qzone.proxy.personalitycomponent.IPersonalityComponentService
        public void clearVisitorListCache() {
            k.e().b();
        }
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IPersonalityComponentService getServiceInterface() {
        return this.f48795b;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IPersonalityComponentUI getUiInterface() {
        return this.f48794a;
    }

    @Override // com.qzone.module.Proxy
    public String getModuleClassName() {
        return "com.qzone.module.personalitycomponent.PersonalityModule";
    }

    @Override // com.qzone.module.Module
    public String getName() {
        return "PersonalityModule";
    }

    @Override // com.qzone.module.Module
    public int getVersion() {
        return 0;
    }
}
