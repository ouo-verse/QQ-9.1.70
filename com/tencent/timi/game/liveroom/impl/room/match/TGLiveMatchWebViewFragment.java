package com.tencent.timi.game.liveroom.impl.room.match;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.timi.game.app.event.AudienceActivityOnResultEvent;
import com.tencent.timi.game.web.business.impl.common.TimiBrowserFragment;
import java.util.ArrayList;
import tj4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TGLiveMatchWebViewFragment extends TimiBrowserFragment implements SimpleEventReceiver {
    private int E = -1;
    private String F = "";

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements b.d {
        a() {
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.d
        public Object a(int i3) {
            if (i3 != 2) {
                return null;
            }
            return new b();
        }
    }

    public static TGLiveMatchWebViewFragment Bh(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        TGLiveMatchWebViewFragment tGLiveMatchWebViewFragment = new TGLiveMatchWebViewFragment();
        tGLiveMatchWebViewFragment.setArguments(bundle);
        return tGLiveMatchWebViewFragment;
    }

    public int Ah() {
        return this.E;
    }

    public void Ch(String str) {
        this.F = str;
    }

    public void Dh(int i3) {
        this.E = i3;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new a());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public WebViewWrapper createWebViewWrapper(boolean z16) {
        return new c(getWebViewProvider().getHostActivity(), this.webViewKernel, this.intent, z16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AudienceActivityOnResultEvent.class);
        return arrayList;
    }

    @Override // com.tencent.timi.game.web.business.impl.common.TimiBrowserFragment
    protected void initView() {
        super.initView();
        getUIStyleHandler().T.setVisibility(0);
        getUIStyleHandler().f314505f = false;
        getSwiftTitleUI().f314047e.f314634q = Boolean.TRUE;
        if (getUIStyleHandler() != null) {
            getUIStyleHandler().f0();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AudienceActivityOnResultEvent) {
            AudienceActivityOnResultEvent audienceActivityOnResultEvent = (AudienceActivityOnResultEvent) simpleBaseEvent;
            doOnActivityResult(audienceActivityOnResultEvent.requestCode, audienceActivityOnResultEvent.resultCode, new Intent());
        }
    }

    @Override // com.tencent.timi.game.web.business.impl.common.TimiBrowserFragment
    protected void rh(WebBrowserViewContainerKt webBrowserViewContainerKt) {
        super.rh(webBrowserViewContainerKt);
        TGLiveTabLoadingView tGLiveTabLoadingView = this.D;
        if (tGLiveTabLoadingView != null) {
            tGLiveTabLoadingView.setBlackMode();
        }
    }

    public String zh() {
        return this.F;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b extends v {
        b() {
        }

        @Override // com.tencent.mobileqq.webview.swift.component.v
        public void f0() {
        }
    }
}
