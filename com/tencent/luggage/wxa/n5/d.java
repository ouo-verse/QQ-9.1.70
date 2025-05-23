package com.tencent.luggage.wxa.n5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.luggage.setting.ui.TouchableLayout;
import com.tencent.luggage.wxa.g5.d;
import com.tencent.luggage.wxa.k5.o;
import com.tencent.luggage.wxa.o5.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0005\u001a\u00020\bH\u0002R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0019R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u00109\u001a\n 6*\u0004\u0018\u000105058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/luggage/wxa/n5/d;", "", "Lcom/tencent/luggage/wxa/g5/b;", "infoData", "", "a", "", "appId", "", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "b", "nickname", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "check", "open", "c", "Lcom/tencent/luggage/wxa/m5/a;", "Lcom/tencent/luggage/wxa/m5/a;", "mSettingUIAction", "Lcom/tencent/luggage/wxa/g5/b;", "mWxaUserInfoData", "Ljava/lang/String;", "mAppId", "d", "Z", "mIsOpen", "e", "mNickname", "f", "Landroid/view/View;", "mRootView", "", "Lcom/tencent/luggage/wxa/k5/o$a;", "g", "Ljava/util/List;", "mUserInfoListItems", tl.h.F, "mOriginalToCompare", "i", "hadShowCloseNote", "", "j", "I", "currentSelectedUserId", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "k", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "mainSwitch", "Lcom/tencent/luggage/wxa/ml/i;", "l", "Lcom/tencent/luggage/wxa/ml/i;", "mProgressDialog", "Landroid/content/Context;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "mOverrideContext", "Lcom/tencent/luggage/wxa/g5/d;", DomainData.DOMAIN_NAME, "Lcom/tencent/luggage/wxa/g5/d;", "wxaUserInfoListOperationController", "<init>", "(Lcom/tencent/luggage/wxa/m5/a;)V", "o", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final com.tencent.luggage.wxa.m5.a mSettingUIAction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.g5.b mWxaUserInfoData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String mAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean mIsOpen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public String mNickname;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public View mRootView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final List mUserInfoListItems;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public List mOriginalToCompare;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean hadShowCloseNote;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int currentSelectedUserId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public MMSwitchBtn mainSwitch;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.ml.i mProgressDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public Context mOverrideContext;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.g5.d wxaUserInfoListOperationController;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements MMSwitchBtn.ISwitch {
        public b() {
        }

        @Override // com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch
        public final void onStatusChange(boolean z16) {
            d.this.a(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements d.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f135444b;

        public c(View view) {
            this.f135444b = view;
        }

        @Override // com.tencent.luggage.wxa.g5.d.b
        public void a(boolean z16, boolean z17, String limitWording, String avatarWording, Function2 goAddUserPage) {
            Intrinsics.checkNotNullParameter(limitWording, "limitWording");
            Intrinsics.checkNotNullParameter(avatarWording, "avatarWording");
            Intrinsics.checkNotNullParameter(goAddUserPage, "goAddUserPage");
        }

        @Override // com.tencent.luggage.wxa.g5.d.b
        public void a(List items) {
            Intrinsics.checkNotNullParameter(items, "items");
            if (d.this.mOriginalToCompare == null) {
                d.this.mOriginalToCompare = new ArrayList(items);
            }
            d.this.mUserInfoListItems.clear();
            d.this.mUserInfoListItems.addAll(items);
            RecyclerView.Adapter adapter = ((RecyclerView) this.f135444b.findViewById(R.id.f115346vs)).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n5.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6502d implements com.tencent.luggage.wxa.g5.a {
        public C6502d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements o.c {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.k5.o.c
        public void a(View v3, o.a item, int i3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(item, "item");
            com.tencent.luggage.wxa.g5.d dVar = d.this.wxaUserInfoListOperationController;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaUserInfoListOperationController");
                dVar = null;
            }
            TouchableLayout.Companion companion = TouchableLayout.INSTANCE;
            dVar.a(v3, i3, companion.a(), companion.b());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements o.b {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.k5.o.b
        public void a(o.a item) {
            Intrinsics.checkNotNullParameter(item, "item");
            com.tencent.luggage.wxa.g5.d dVar = d.this.wxaUserInfoListOperationController;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("wxaUserInfoListOperationController");
                dVar = null;
            }
            dVar.a(item);
            d.this.currentSelectedUserId = item.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f135448a;

        public g(Function0 function0) {
            this.f135448a = function0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            this.f135448a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f135449a;

        public h(Function0 function0) {
            this.f135449a = function0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            this.f135449a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f135450a;

        public i(Function0 function0) {
            this.f135450a = function0;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f135450a.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function0 {
        public j() {
            super(0);
        }

        public final void a() {
            MMSwitchBtn mMSwitchBtn = d.this.mainSwitch;
            if (mMSwitchBtn == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainSwitch");
                mMSwitchBtn = null;
            }
            mMSwitchBtn.setCheck(true);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f135453b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(boolean z16) {
            super(0);
            this.f135453b = z16;
        }

        public final void a() {
            d.this.mIsOpen = this.f135453b;
            d dVar = d.this;
            dVar.c(dVar.mIsOpen);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public d(@NotNull com.tencent.luggage.wxa.m5.a mSettingUIAction) {
        Intrinsics.checkNotNullParameter(mSettingUIAction, "mSettingUIAction");
        this.mSettingUIAction = mSettingUIAction;
        this.mNickname = "";
        this.mUserInfoListItems = new ArrayList();
        this.mOverrideContext = mSettingUIAction.e().getContext();
    }

    public void b(boolean isOpen) {
        this.mIsOpen = isOpen;
    }

    public final void c(boolean open) {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        ((LinearLayout) view.findViewById(R.id.f115366vu)).setVisibility(open ? 0 : 8);
    }

    public void b(String nickname) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        this.mNickname = nickname;
    }

    public void a(com.tencent.luggage.wxa.g5.b infoData) {
        this.mWxaUserInfoData = infoData;
    }

    public void b() {
        com.tencent.luggage.wxa.ml.i iVar = this.mProgressDialog;
        if (iVar != null) {
            iVar.dismiss();
        }
        boolean a16 = a();
        Intent intent = new Intent();
        intent.putExtra("key_result_user_info_list_been_modified", a16);
        intent.putExtra("key_result_is_open", this.mIsOpen);
        intent.putExtra("key_result_selected_user_id", this.currentSelectedUserId);
        this.mSettingUIAction.e().setResult(-1, intent);
    }

    public void a(String appId) {
        this.mAppId = appId;
    }

    public void a(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mRootView = rootView;
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.szk);
        frameLayout.addView(LayoutInflater.from(this.mOverrideContext).inflate(R.layout.dqj, (ViewGroup) frameLayout, false), -1, -1);
        c(this.mIsOpen);
        com.tencent.luggage.wxa.g5.b bVar = this.mWxaUserInfoData;
        if (bVar != null && this.mAppId != null) {
            Intrinsics.checkNotNull(bVar);
            this.currentSelectedUserId = bVar.d();
            View findViewById = rootView.findViewById(R.id.ywi);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
            MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById;
            mMSwitchBtn.setCheck(this.mIsOpen);
            mMSwitchBtn.setSwitchListener(new b());
            this.mainSwitch = mMSwitchBtn;
            TextView textView = (TextView) rootView.findViewById(R.id.bg6);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.mOverrideContext.getString(R.string.f170404z53);
            Intrinsics.checkNotNullExpressionValue(string, "mOverrideContext.getStri\u2026g_usernifo_authrize_desc)");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.mNickname}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            TextView textView2 = (TextView) rootView.findViewById(R.id.f115136v8);
            String string2 = this.mOverrideContext.getString(R.string.z56);
            Intrinsics.checkNotNullExpressionValue(string2, "mOverrideContext.getStri\u2026rize_user_info_list_desc)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.mNickname}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView2.setText(format2);
            ((RecyclerView) rootView.findViewById(R.id.f115346vs)).setNestedScrollingEnabled(false);
            Context mOverrideContext = this.mOverrideContext;
            Intrinsics.checkNotNullExpressionValue(mOverrideContext, "mOverrideContext");
            com.tencent.luggage.wxa.g5.b bVar2 = this.mWxaUserInfoData;
            Intrinsics.checkNotNull(bVar2);
            com.tencent.luggage.wxa.g5.d dVar = new com.tencent.luggage.wxa.g5.d(mOverrideContext, bVar2, "", new c(rootView));
            this.wxaUserInfoListOperationController = dVar;
            dVar.a(new C6502d());
            o oVar = new o(this.mUserInfoListItems);
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f115346vs);
            recyclerView.setAdapter(oVar);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mOverrideContext));
            recyclerView.setItemAnimator(null);
            oVar.a(new e());
            oVar.a(new f());
            return;
        }
        w.d("Luggage.STANDALONE.WxaUserInfoLogicImpl", "WxaUserInfoData or appId is null, finish activity");
        b();
    }

    public final void a(boolean check) {
        j jVar = new j();
        k kVar = new k(check);
        if (!check && !this.hadShowCloseNote) {
            this.hadShowCloseNote = true;
            a.C6536a c6536a = com.tencent.luggage.wxa.o5.a.f136190a;
            Context mOverrideContext = this.mOverrideContext;
            Intrinsics.checkNotNullExpressionValue(mOverrideContext, "mOverrideContext");
            c6536a.a(mOverrideContext, new g(kVar), new h(jVar), new i(jVar));
            return;
        }
        kVar.invoke();
    }

    public final boolean a() {
        boolean z16;
        List list = this.mOriginalToCompare;
        if (!(list != null && list.size() == this.mUserInfoListItems.size())) {
            return true;
        }
        boolean z17 = false;
        for (o.a aVar : this.mUserInfoListItems) {
            List list2 = this.mOriginalToCompare;
            if (list2 != null) {
                Iterator it = list2.iterator();
                z16 = false;
                while (it.hasNext()) {
                    if (aVar.a() == ((o.a) it.next()).a()) {
                        z16 = true;
                    }
                }
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        return z17;
    }
}
