package com.tencent.luggage.wxa.k5;

import android.content.Intent;
import android.preference.Preference;
import android.view.MenuItem;
import com.tencent.luggage.setting.ui.WxaSettingAuthorizeDetailUI;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.weui.base.preference.IPreferenceScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u00012\u00020\u0002:\u0001\u000bB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/luggage/wxa/k5/h;", "Lcom/tencent/luggage/wxa/w3/a;", "Lcom/tencent/luggage/wxa/m5/a;", "", "b", "i", "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "screen", "Landroid/preference/Preference;", "pref", "", "a", "Lcom/tencent/luggage/wxa/g6/a;", "e", "Lcom/tencent/luggage/wxa/n5/a;", tl.h.F, "Lcom/tencent/luggage/wxa/n5/a;", "presenter", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class h extends com.tencent.luggage.wxa.w3.a implements com.tencent.luggage.wxa.m5.a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.n5.a presenter;

    @NotNull
    private static final Class<WxaSettingAuthorizeDetailUI> ACTIVITY_CLASS = WxaSettingAuthorizeDetailUI.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements MenuItem.OnMenuItemClickListener {
        public b() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            h.this.presenter.b();
            h.this.finish();
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.presenter = new com.tencent.luggage.wxa.n5.a(this);
    }

    @Override // com.tencent.luggage.wxa.w3.a, com.tencent.luggage.wxa.g6.r
    public void b() {
        String string;
        super.b();
        com.tencent.luggage.wxa.n5.a aVar = this.presenter;
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        boolean z16 = false;
        aVar.a(intent.getIntExtra("key_state", 0));
        Intent intent2 = getIntent();
        Intrinsics.checkNotNull(intent2);
        String stringExtra = intent2.getStringExtra("key_desc");
        if (stringExtra == null) {
            stringExtra = "";
        }
        aVar.a(stringExtra);
        Intent intent3 = getIntent();
        Intrinsics.checkNotNull(intent3);
        aVar.a(intent3.getBooleanExtra("key_three_state", false));
        aVar.a(j());
        Intent intent4 = getIntent();
        Intrinsics.checkNotNull(intent4);
        String stringExtra2 = intent4.getStringExtra("key_title");
        if (stringExtra2 == null || stringExtra2.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            Intent intent5 = getIntent();
            Intrinsics.checkNotNull(intent5);
            string = intent5.getStringExtra("key_title");
            Intrinsics.checkNotNull(string);
        } else {
            string = getContext().getString(R.string.f170351yx2);
        }
        setTitle(string);
        setBackBtn(new b());
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        this.presenter.b();
        super.i();
    }

    @Override // com.tencent.luggage.wxa.w3.a
    public boolean a(IPreferenceScreen screen, Preference pref) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(pref, "pref");
        w.d("MicroMsg.AppBrandAuthorizeDetailUI", "onPreferenceTreeClick, key:%s", pref.getKey());
        return this.presenter.a(pref);
    }

    @Override // com.tencent.luggage.wxa.m5.a
    public com.tencent.luggage.wxa.g6.a e() {
        return this;
    }
}
