package com.tencent.luggage.wxa.k5;

import android.content.Intent;
import android.preference.Preference;
import android.view.MenuItem;
import android.view.View;
import com.tencent.luggage.setting.ui.WxaSettingUserInfoUI;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.MiniRewardedVideoAdServlet;
import com.tencent.weui.base.preference.IPreferenceScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\nB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/luggage/wxa/k5/m;", "Lcom/tencent/luggage/wxa/w3/a;", "Lcom/tencent/luggage/wxa/m5/a;", "", "b", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "screen", "Landroid/preference/Preference;", "pref", "", "a", "i", "finish", "Lcom/tencent/luggage/wxa/g6/a;", "e", "Lcom/tencent/luggage/wxa/n5/d;", tl.h.F, "Lcom/tencent/luggage/wxa/n5/d;", "presenter", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class m extends com.tencent.luggage.wxa.w3.a implements com.tencent.luggage.wxa.m5.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.n5.d presenter;

    @NotNull
    private static final Class<WxaSettingUserInfoUI> ACTIVITY_CLASS = WxaSettingUserInfoUI.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements MenuItem.OnMenuItemClickListener {
        public b() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            m.this.finish();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.presenter = new com.tencent.luggage.wxa.n5.d(this);
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
        setContentView(R.layout.dqk);
        com.tencent.luggage.wxa.n5.d dVar = this.presenter;
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        dVar.a((com.tencent.luggage.wxa.g5.b) intent.getParcelableExtra(MiniRewardedVideoAdServlet.KEY_USER_INFO));
        com.tencent.luggage.wxa.n5.d dVar2 = this.presenter;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNull(intent2);
        dVar2.a(intent2.getStringExtra("key_app_id"));
        com.tencent.luggage.wxa.n5.d dVar3 = this.presenter;
        Intent intent3 = getIntent();
        Intrinsics.checkNotNull(intent3);
        dVar3.b(intent3.getBooleanExtra("key_is_state_open", false));
        com.tencent.luggage.wxa.n5.d dVar4 = this.presenter;
        Intent intent4 = getIntent();
        Intrinsics.checkNotNull(intent4);
        String stringExtra = intent4.getStringExtra("key_nickname");
        if (stringExtra == null) {
            stringExtra = "";
        }
        dVar4.b(stringExtra);
        com.tencent.luggage.wxa.n5.d dVar5 = this.presenter;
        View findViewById = getWindow().getDecorView().findViewById(android.R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "window.decorView.findVie\u2026yId(android.R.id.content)");
        dVar5.a(findViewById);
        setBackBtn(new b());
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void finish() {
        this.presenter.b();
        super.finish();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        finish();
        super.i();
    }

    @Override // com.tencent.luggage.wxa.m5.a
    public com.tencent.luggage.wxa.g6.a e() {
        return this;
    }
}
