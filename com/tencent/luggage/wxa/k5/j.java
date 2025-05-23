package com.tencent.luggage.wxa.k5;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.Preference;
import android.view.MenuItem;
import com.tencent.luggage.setting.ui.WxaSettingActivity;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.hn.s;
import com.tencent.luggage.wxa.n5.b;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.servlet.MiniRewardedVideoAdServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.weui.base.preference.IPreferenceScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001\u0007B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001fR\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/luggage/wxa/k5/j;", "Lcom/tencent/luggage/wxa/w3/a;", "Lcom/tencent/luggage/wxa/m5/b;", "", "b", "i", "f", "a", "", NodeProps.VISIBLE, "Lcom/tencent/weui/base/preference/IPreferenceScreen;", "screen", "Landroid/preference/Preference;", "pref", "Lcom/tencent/luggage/wxa/g6/a;", "e", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "p", "o", "", tl.h.F, "Ljava/lang/String;", "mAppId", "mNickName", "j", "mUsername", "Lcom/tencent/luggage/wxa/n5/b;", "Lcom/tencent/luggage/wxa/n5/b;", "mPresenter", "Z", "isLoading", "Landroid/app/ProgressDialog;", "Landroid/app/ProgressDialog;", "progressDialog", BdhLogUtil.LogTag.Tag_Conn, "mKeyChange", "", "D", "I", "mSelectedUserInfoId", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "E", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class j extends com.tencent.luggage.wxa.w3.a implements com.tencent.luggage.wxa.m5.b {

    /* renamed from: C, reason: from kotlin metadata */
    public boolean mKeyChange;

    /* renamed from: D, reason: from kotlin metadata */
    public int mSelectedUserInfoId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public String mAppId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public String mNickName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public String mUsername;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.n5.b mPresenter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean isLoading;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public ProgressDialog progressDialog;

    @NotNull
    private static final Class<WxaSettingActivity> ACTIVITY_CLASS = WxaSettingActivity.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (j.this.isLoading) {
                j.this.isLoading = false;
                ProgressDialog progressDialog = j.this.progressDialog;
                Intrinsics.checkNotNull(progressDialog);
                progressDialog.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements LuggageActivityHelper.d {
        public c() {
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            if (i3 == -1) {
                int n3 = j.this.mPresenter.n();
                if (intent != null && intent.hasExtra("key_result_state")) {
                    j.this.mPresenter.b(intent.getIntExtra("key_result_state", n3));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements LuggageActivityHelper.d {
        public d() {
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            if (i3 == -1) {
                int j3 = j.this.mPresenter.j();
                if (intent != null && intent.hasExtra("key_result_state")) {
                    j.this.mPresenter.c(intent.getIntExtra("key_result_state", j3));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements LuggageActivityHelper.d {
        public e() {
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            if (i3 == -1) {
                int o16 = j.this.mPresenter.o();
                if (intent != null && intent.hasExtra("key_result_state")) {
                    j.this.mPresenter.d(intent.getIntExtra("key_result_state", o16));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements LuggageActivityHelper.d {
        public f() {
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            com.tencent.luggage.wxa.g5.c cVar;
            if (i3 == -1) {
                if (intent != null) {
                    cVar = (com.tencent.luggage.wxa.g5.c) intent.getParcelableExtra("key_biz_data");
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    j.this.mPresenter.a(cVar);
                    j.this.f();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements LuggageActivityHelper.d {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f131528b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements b.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ j f131529a;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.k5.j$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6361a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ j f131530a;

                public RunnableC6361a(j jVar) {
                    this.f131530a = jVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f131530a.a();
                }
            }

            public a(j jVar) {
                this.f131529a = jVar;
            }

            @Override // com.tencent.luggage.wxa.n5.b.c
            public void a(boolean z16) {
                c0.a(new RunnableC6361a(this.f131529a));
            }
        }

        public g(s sVar) {
            this.f131528b = sVar;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public final void a(int i3, Intent intent) {
            int i16;
            if (intent.getBooleanExtra("key_result_is_open", true)) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            int intExtra = intent.getIntExtra("key_result_selected_user_id", 0);
            boolean booleanExtra = intent.getBooleanExtra("key_result_user_info_list_been_modified", false);
            if (j.this.mSelectedUserInfoId != intExtra || this.f131528b.f128645f != i16 || booleanExtra) {
                j.this.mKeyChange = true;
                j.this.mSelectedUserInfoId = intExtra;
                this.f131528b.f128645f = i16;
                w.d("WMPF.FloatWindowSetting", "userinfo select id" + j.this.mSelectedUserInfoId);
                w.d("WMPF.FloatWindowSetting", "userinfo main switch state" + this.f131528b.f128645f);
                j.this.mPresenter.a(new a(j.this));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements MenuItem.OnMenuItemClickListener {
        public h() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.luggage.wxa.n5.b.a(j.this.mPresenter, false, 1, (Object) null);
            j.this.finish();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f131533b;

        public i(boolean z16) {
            this.f131533b = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Preference preference = new Preference(j.this.getContext());
            preference.setPersistent(false);
            String str = null;
            if (this.f131533b) {
                preference.setLayoutResource(R.layout.dxn);
                Context context = j.this.getContext();
                Object[] objArr = new Object[1];
                String str2 = j.this.mNickName;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickName");
                } else {
                    str = str2;
                }
                objArr[0] = str;
                preference.setTitle(context.getString(R.string.yws, objArr));
            } else {
                preference.setLayoutResource(R.layout.dxo);
                Context context2 = j.this.getContext();
                Object[] objArr2 = new Object[1];
                String str3 = j.this.mNickName;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickName");
                } else {
                    str = str3;
                }
                objArr2[0] = str;
                preference.setTitle(context2.getString(R.string.ywt, objArr2));
            }
            j.this.j().addPreference(preference);
            j.this.j().notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.mPresenter = new com.tencent.luggage.wxa.n5.b(this);
    }

    @Override // com.tencent.luggage.wxa.m5.a
    public com.tencent.luggage.wxa.g6.a e() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        w.a("WMPF.FloatWindowSetting", "onBackPressed !");
        com.tencent.luggage.wxa.n5.b.a(this.mPresenter, false, 1, (Object) null);
        finish();
        super.i();
    }

    public final boolean k() {
        s mAuthItemBluetooth = this.mPresenter.getMAuthItemBluetooth();
        if (mAuthItemBluetooth == null) {
            w.d("WMPF.FloatWindowSetting", "onClickBluetoothPreference, auth item bluetooth is null");
            return false;
        }
        int n3 = this.mPresenter.n();
        w.d("WMPF.FloatWindowSetting", "onClickBluetoothPreference, current bluetooth state:%s", Integer.valueOf(n3));
        Intent intent = new Intent(getContext(), (Class<?>) com.tencent.luggage.wxa.k5.h.class);
        intent.putExtra("key_title", mAuthItemBluetooth.f128644e);
        String str = this.mAppId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str = null;
        }
        intent.putExtra("key_desc", com.tencent.luggage.wxa.uc.a.a(str));
        intent.putExtra("key_state", n3);
        intent.putExtra("key_three_state", this.mPresenter.getMShouldShowBluetoothBackground());
        p.a aVar = p.f126564o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p a16 = aVar.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        a16.a(context2, intent, new c());
        return true;
    }

    public final boolean l() {
        s mAuthItemFuzzyLocation = this.mPresenter.getMAuthItemFuzzyLocation();
        int i3 = 0;
        if (mAuthItemFuzzyLocation == null) {
            w.d("WMPF.FloatWindowSetting", "onClickFuzzyLocationPreference, auth item location is null");
            return false;
        }
        w.d("WMPF.FloatWindowSetting", "onClickFuzzyLocationPreference, current location state:%s", Integer.valueOf(mAuthItemFuzzyLocation.f128645f));
        if (mAuthItemFuzzyLocation.f128645f == 1) {
            i3 = 1;
        }
        Intent intent = new Intent(getContext(), (Class<?>) com.tencent.luggage.wxa.k5.h.class);
        intent.putExtra("key_title", mAuthItemFuzzyLocation.f128644e);
        intent.putExtra("key_desc", getContext().getString(R.string.f170353yx4));
        intent.putExtra("key_state", i3);
        p.a aVar = p.f126564o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p a16 = aVar.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        a16.a(context2, intent, new d());
        return true;
    }

    public final boolean m() {
        s mAuthItemLocation = this.mPresenter.getMAuthItemLocation();
        if (mAuthItemLocation == null) {
            w.d("WMPF.FloatWindowSetting", "onClickLocationPreference, auth item location is null");
            return false;
        }
        int o16 = this.mPresenter.o();
        w.d("WMPF.FloatWindowSetting", "onClickLocationPreference, current location state:%s", Integer.valueOf(o16));
        Intent intent = new Intent(getContext(), (Class<?>) com.tencent.luggage.wxa.k5.h.class);
        intent.putExtra("key_title", mAuthItemLocation.f128644e);
        String str = this.mAppId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str = null;
        }
        intent.putExtra("key_desc", com.tencent.luggage.wxa.uc.a.b(str));
        intent.putExtra("key_state", o16);
        intent.putExtra("key_three_state", this.mPresenter.getMShouldShowLocationBackground());
        p.a aVar = p.f126564o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p a16 = aVar.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        a16.a(context2, intent, new e());
        return true;
    }

    public final boolean o() {
        Intent intent = new Intent(getContext(), (Class<?>) l.class);
        String str = this.mUsername;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUsername");
            str = null;
        }
        intent.putExtra("key_biz_username", str);
        intent.putExtra("key_biz_presenter_class", com.tencent.luggage.wxa.h5.c.class.getName());
        String str3 = this.mNickName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickName");
            str3 = null;
        }
        intent.putExtra("key_biz_nickname", str3);
        String str4 = this.mAppId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
        } else {
            str2 = str4;
        }
        intent.putExtra("key_biz_app_id", str2);
        intent.putExtra("key_biz_data", this.mPresenter.getMSubscribeMsgSettingData());
        p.a aVar = p.f126564o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p a16 = aVar.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        a16.a(context2, intent, new f());
        return true;
    }

    public final boolean p() {
        s mUserInfoItem = this.mPresenter.getMUserInfoItem();
        boolean z16 = false;
        if (mUserInfoItem == null) {
            w.d("WMPF.FloatWindowSetting", "onClickUserInfoPreference, user info item location is null");
            return false;
        }
        Intent intent = new Intent(getContext(), (Class<?>) m.class);
        String str = this.mAppId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str = null;
        }
        intent.putExtra("key_app_id", str);
        String str3 = this.mNickName;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickName");
        } else {
            str2 = str3;
        }
        intent.putExtra("key_nickname", str2);
        intent.putExtra(MiniRewardedVideoAdServlet.KEY_USER_INFO, this.mPresenter.getMWxaUserInfoData());
        if (mUserInfoItem.f128645f == 1) {
            z16 = true;
        }
        intent.putExtra("key_is_state_open", z16);
        p.a aVar = p.f126564o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        p a16 = aVar.a(context);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        a16.a(context2, intent, new g(mUserInfoItem));
        return true;
    }

    @Override // com.tencent.luggage.wxa.m5.b
    public void f() {
        com.tencent.luggage.wxa.zp.h.f146825d.a(new RunnableC6362j());
    }

    @Override // com.tencent.luggage.wxa.w3.a, com.tencent.luggage.wxa.g6.r
    public void b() {
        super.b();
        Intent intent = getIntent();
        Intrinsics.checkNotNull(intent);
        String stringExtra = intent.getStringExtra("KEY_NICKNAME");
        String str = null;
        if (stringExtra != null) {
            this.mNickName = stringExtra;
        } else {
            stringExtra = null;
        }
        if (w0.c(stringExtra)) {
            finish();
            return;
        }
        Intent intent2 = getIntent();
        Intrinsics.checkNotNull(intent2);
        String stringExtra2 = intent2.getStringExtra("KEY_APPID");
        if (stringExtra2 != null) {
            this.mAppId = stringExtra2;
        } else {
            stringExtra2 = null;
        }
        if (w0.c(stringExtra2)) {
            finish();
            return;
        }
        Intent intent3 = getIntent();
        Intrinsics.checkNotNull(intent3);
        String stringExtra3 = intent3.getStringExtra("KEY_USERNAME");
        if (stringExtra3 != null) {
            this.mUsername = stringExtra3;
        } else {
            stringExtra3 = null;
        }
        if (w0.c(stringExtra3)) {
            w.b("WMPF.FloatWindowSetting", "username is null");
            finish();
            return;
        }
        setTitle(R.string.f170351yx2);
        setBackBtn(new h());
        com.tencent.luggage.wxa.n5.b bVar = this.mPresenter;
        String str2 = this.mAppId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
            str2 = null;
        }
        bVar.b(str2);
        com.tencent.luggage.wxa.n5.b bVar2 = this.mPresenter;
        String str3 = this.mUsername;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUsername");
            str3 = null;
        }
        bVar2.c(str3);
        this.mPresenter.a(j());
        this.mPresenter.p();
        com.tencent.luggage.wxa.n5.b bVar3 = this.mPresenter;
        String str4 = this.mUsername;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUsername");
        } else {
            str = str4;
        }
        bVar3.a(str);
    }

    @Override // com.tencent.luggage.wxa.m5.b
    public void a() {
        com.tencent.luggage.wxa.zp.h.f146825d.a(new b());
    }

    @Override // com.tencent.luggage.wxa.m5.b
    public void a(boolean visible) {
        runOnUiThread(new i(visible));
    }

    @Override // com.tencent.luggage.wxa.w3.a
    public boolean a(IPreferenceScreen screen, Preference pref) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(pref, "pref");
        w.a("WMPF.FloatWindowSetting", "onPreferenceTreeClick.(key : %s)", pref.getKey());
        String key = pref.getKey();
        if (w0.c(key)) {
            w.b("WMPF.FloatWindowSetting", "key is null");
            return false;
        }
        if (this.mPresenter.a(screen, pref)) {
            return true;
        }
        if (key != null) {
            String str = null;
            switch (key.hashCode()) {
                case -1750762604:
                    if (key.equals("scope.bluetooth")) {
                        return k();
                    }
                    break;
                case -653473286:
                    if (key.equals(AuthorizeCenter.SCOPE_USER_LOCATION)) {
                        return m();
                    }
                    break;
                case -412042658:
                    if (key.equals("preference_key_user_info")) {
                        p.a aVar = p.f126564o;
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        p a16 = aVar.a(context);
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        Intent intent = new Intent(getContext(), (Class<?>) n.class);
                        String str2 = this.mAppId;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAppId");
                        } else {
                            str = str2;
                        }
                        Intent putExtra = intent.putExtra("appid", str);
                        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, WxaSetti\u2026NTENT_KEY_APP_ID, mAppId)");
                        a16.a(context2, putExtra);
                        return true;
                    }
                    break;
                case 583039347:
                    if (key.equals(AuthorizeCenter.SCOPE_USER_INFO)) {
                        return p();
                    }
                    break;
                case 1106420424:
                    if (key.equals("preference_key_subscribe_msg")) {
                        return o();
                    }
                    break;
                case 1962421476:
                    if (key.equals("preference_key_privacy_use_record")) {
                        p.a aVar2 = p.f126564o;
                        Context context3 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "context");
                        p a17 = aVar2.a(context3);
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "context");
                        Intent intent2 = new Intent(getContext(), (Class<?>) k.class);
                        String str3 = this.mUsername;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mUsername");
                        } else {
                            str = str3;
                        }
                        Intent putExtra2 = intent2.putExtra("username", str);
                        Intrinsics.checkNotNullExpressionValue(putExtra2, "Intent(context, WxaSetti\u2026_KEY_USERNAME, mUsername)");
                        a17.a(context4, putExtra2);
                        return true;
                    }
                    break;
                case 2106603706:
                    if (key.equals("scope.userFuzzyLocation")) {
                        return l();
                    }
                    break;
            }
        }
        return false;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k5.j$j, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6362j implements Runnable {
        public RunnableC6362j() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!j.this.isLoading) {
                j.this.isLoading = true;
                if (j.this.progressDialog == null) {
                    j jVar = j.this;
                    p.a aVar = p.f126564o;
                    Context context = jVar.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    p a16 = aVar.a(context);
                    Context context2 = j.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    jVar.progressDialog = a16.f(context2);
                    ProgressDialog progressDialog = j.this.progressDialog;
                    Intrinsics.checkNotNull(progressDialog);
                    progressDialog.setTitle(R.string.z28);
                    ProgressDialog progressDialog2 = j.this.progressDialog;
                    Intrinsics.checkNotNull(progressDialog2);
                    progressDialog2.setMessage(j.this.getContext().getResources().getText(R.string.f170402z51));
                    ProgressDialog progressDialog3 = j.this.progressDialog;
                    Intrinsics.checkNotNull(progressDialog3);
                    progressDialog3.setIndeterminate(true);
                    ProgressDialog progressDialog4 = j.this.progressDialog;
                    Intrinsics.checkNotNull(progressDialog4);
                    progressDialog4.setOnCancelListener(a.f131535a);
                }
                ProgressDialog progressDialog5 = j.this.progressDialog;
                Intrinsics.checkNotNull(progressDialog5);
                progressDialog5.show();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.k5.j$j$a */
        /* loaded from: classes8.dex */
        public static final class a implements DialogInterface.OnCancelListener {

            /* renamed from: a, reason: collision with root package name */
            public static final a f131535a = new a();

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
            }
        }
    }
}
