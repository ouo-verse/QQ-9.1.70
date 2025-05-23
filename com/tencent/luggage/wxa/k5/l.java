package com.tencent.luggage.wxa.k5;

import android.content.Intent;
import android.preference.Preference;
import android.view.MenuItem;
import android.view.View;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.setting.ui.WxaSettingSubscribeMsgUI;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.weui.base.preference.IPreferenceScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u0011B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/luggage/wxa/k5/l;", "Lcom/tencent/luggage/wxa/w3/a;", "Lcom/tencent/luggage/wxa/m5/a;", "", "b", "onStart", "finish", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "screen", "Landroid/preference/Preference;", "pref", "", "a", "Lcom/tencent/luggage/wxa/g6/a;", "e", "Lcom/tencent/luggage/wxa/n5/c;", tl.h.F, "Lcom/tencent/luggage/wxa/n5/c;", "presenter", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class l extends com.tencent.luggage.wxa.w3.a implements com.tencent.luggage.wxa.m5.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.n5.c presenter;

    @NotNull
    private static final Class<WxaSettingSubscribeMsgUI> ACTIVITY_CLASS = WxaSettingSubscribeMsgUI.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements MenuItem.OnMenuItemClickListener {
        public b() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            l.this.finish();
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.presenter = new com.tencent.luggage.wxa.n5.c(this);
    }

    @Override // com.tencent.luggage.wxa.w3.a
    public boolean a(IPreferenceScreen screen, Preference pref) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(pref, "pref");
        return false;
    }

    @Override // com.tencent.luggage.wxa.w3.a, com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        setContentView(R.layout.dql);
        com.tencent.luggage.wxa.n5.c cVar = this.presenter;
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        String stringExtra = intent.getStringExtra("key_biz_presenter_class");
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        cVar.d(stringExtra);
        com.tencent.luggage.wxa.n5.c cVar2 = this.presenter;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNull(intent2);
        String stringExtra2 = intent2.getStringExtra("key_biz_username");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        cVar2.b(stringExtra2);
        com.tencent.luggage.wxa.n5.c cVar3 = this.presenter;
        Intent intent3 = getIntent();
        Intrinsics.checkNotNull(intent3);
        String stringExtra3 = intent3.getStringExtra("key_biz_nickname");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        cVar3.c(stringExtra3);
        com.tencent.luggage.wxa.n5.c cVar4 = this.presenter;
        Intent intent4 = getIntent();
        Intrinsics.checkNotNull(intent4);
        String stringExtra4 = intent4.getStringExtra("key_biz_app_id");
        if (stringExtra4 != null) {
            str = stringExtra4;
        }
        cVar4.a(str);
        this.presenter.d();
        this.presenter.g();
        this.presenter.b();
        com.tencent.luggage.wxa.n5.c cVar5 = this.presenter;
        View findViewById = getWindow().getDecorView().findViewById(android.R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "window.decorView.findVie\u2026yId(android.R.id.content)");
        cVar5.a(findViewById);
        this.presenter.c();
        setTitle(R.string.zf5);
        setBackBtn(new b());
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void finish() {
        this.presenter.a();
        super.finish();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        this.presenter.f();
        super.i();
        finish();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onDestroy() {
        this.presenter.h();
        super.onDestroy();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onPause() {
        this.presenter.i();
        super.onPause();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onResume() {
        super.onResume();
        this.presenter.j();
    }

    @Override // com.tencent.luggage.wxa.w3.a, com.tencent.luggage.wxa.g6.r
    public void onStart() {
        super.onStart();
        this.presenter.k();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onStop() {
        super.onStop();
        this.presenter.l();
    }

    @Override // com.tencent.luggage.wxa.m5.a
    public com.tencent.luggage.wxa.g6.a e() {
        return this;
    }
}
