package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.component.banner.Banner;
import com.qzone.component.banner.MusicPlayerBanner;
import com.qzone.personalize.model.CustomPlayerData;
import e8.e;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class an extends g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private gf.n f55009d;

    /* renamed from: e, reason: collision with root package name */
    private a f55010e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a implements e8.e {

        /* renamed from: d, reason: collision with root package name */
        private boolean f55011d = false;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<gf.n> f55012e;

        public a(gf.n nVar) {
            this.f55012e = new WeakReference<>(nVar);
        }

        @Override // e8.e
        public void a(e.a aVar) {
            if (this.f55012e.get() == null || !this.f55012e.get().d() || aVar == null || aVar.f395852b == null || this.f55011d) {
                return;
            }
            Banner e16 = this.f55012e.get().e(4);
            if (e16 instanceof MusicPlayerBanner) {
                ((MusicPlayerBanner) e16).setPageUin(LoginData.getInstance().getUin());
                this.f55011d = true;
            }
        }
    }

    private void E9(Object[] objArr) {
        if (!this.f55009d.d() || D9() == null || objArr == null || objArr.length <= 0) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof CustomPlayerData) {
            CustomPlayerData customPlayerData = (CustomPlayerData) obj;
            if (customPlayerData.uin == LoginData.getInstance().getUin()) {
                D9().v(customPlayerData);
            }
        }
    }

    private void F9(Event event, Object[] objArr) {
        if (event.what == 1) {
            E9(objArr);
        }
    }

    private void G9(Event event) {
        if (event.what == 1 && this.f55009d.d() && D9() != null) {
            D9().u();
        }
    }

    private void H9() {
        if (this.f55010e == null) {
            this.f55010e = new a(this.f55009d);
            e8.f.a().b().g(this.f55010e);
        }
    }

    public MusicPlayerBanner D9() {
        Banner e16 = this.f55009d.e(4);
        if (e16 instanceof MusicPlayerBanner) {
            return (MusicPlayerBanner) e16;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxMusicTopBannerPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        H9();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        Object[] objArr = (Object[]) event.params;
        String name = event.source.getName();
        name.hashCode();
        if (!name.equals("MusicPlayer")) {
            if (name.equals("CustomPlayer")) {
                F9(event, objArr);
                return;
            }
            return;
        }
        G9(event);
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55009d = (gf.n) getIocInterface(gf.n.class);
        EventCenter.getInstance().addUIObserver(this, "CustomPlayer", 1);
        EventCenter.getInstance().addUIObserver(this, "MusicPlayer", 1);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
    }
}
