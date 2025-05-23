package com.tencent.luggage.wxa.g5;

import android.app.Activity;
import android.content.Context;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.luggage.wxa.g5.b;
import com.tencent.luggage.wxa.k5.o;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.menu.MMPopupMenu;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: j, reason: collision with root package name */
    public static final a f126446j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f126447a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.g5.b f126448b;

    /* renamed from: c, reason: collision with root package name */
    public final String f126449c;

    /* renamed from: d, reason: collision with root package name */
    public final b f126450d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f126451e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicInteger f126452f;

    /* renamed from: g, reason: collision with root package name */
    public final int f126453g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.g5.a f126454h;

    /* renamed from: i, reason: collision with root package name */
    public MMPopupMenu f126455i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(List list);

        void a(boolean z16, boolean z17, String str, String str2, Function2 function2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function2 {
        public c() {
            super(2);
        }

        public final void a(Activity activity, String appId) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(appId, "appId");
            d.this.a(activity, appId);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((Activity) obj, (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g5.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class ViewOnCreateContextMenuListenerC6230d implements View.OnCreateContextMenuListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f126457a;

        public ViewOnCreateContextMenuListenerC6230d(View view) {
            this.f126457a = view;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.add(0, 1, 0, this.f126457a.getContext().getResources().getString(R.string.z2f));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements u {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f126459b;

        public e(int i3) {
            this.f126459b = i3;
        }

        @Override // com.tencent.luggage.wxa.mo.u
        public final void a(MenuItem menuItem, int i3) {
            d dVar = d.this;
            dVar.a(this.f126459b, dVar.a());
        }
    }

    public d(Context context, com.tencent.luggage.wxa.g5.b mUserAvatarInfo, String scope, b mListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mUserAvatarInfo, "mUserAvatarInfo");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.f126447a = context;
        this.f126448b = mUserAvatarInfo;
        this.f126449c = scope;
        this.f126450d = mListener;
        ArrayList arrayList = new ArrayList();
        this.f126451e = arrayList;
        this.f126452f = new AtomicInteger(mUserAvatarInfo.d());
        this.f126453g = com.tencent.luggage.wxa.e5.a.a(this);
        arrayList.addAll(a(scope, mUserAvatarInfo));
        a(arrayList);
    }

    public void a(Activity activity, String appId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appId, "appId");
    }

    public final void b(View view, int i3, int i16, int i17) {
        MMPopupMenu mMPopupMenu = new MMPopupMenu(view.getContext());
        this.f126455i = mMPopupMenu;
        if (i3 == 0) {
            return;
        }
        Intrinsics.checkNotNull(mMPopupMenu);
        mMPopupMenu.openPopupMenu(view, i3, 0L, new ViewOnCreateContextMenuListenerC6230d(view), new e(i3), i16, i17);
    }

    public final com.tencent.luggage.wxa.g5.a a() {
        return this.f126454h;
    }

    public final void a(com.tencent.luggage.wxa.g5.a aVar) {
        this.f126454h = aVar;
    }

    public final void a(ArrayList arrayList) {
        this.f126450d.a(arrayList);
        b bVar = this.f126450d;
        boolean f16 = this.f126448b.f();
        boolean z16 = this.f126448b.a() <= arrayList.size();
        String e16 = this.f126448b.e();
        String str = e16 == null ? "" : e16;
        String c16 = this.f126448b.c();
        bVar.a(f16, z16, str, c16 == null ? "" : c16, new c());
    }

    public void a(int i3, com.tencent.luggage.wxa.g5.a aVar) {
        w.d("WxaUserInfoListOperationController", "[deleteUser] index=" + i3);
    }

    public void a(View view, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(view, "view");
        b(view, i3, i16, i17);
    }

    public void a(o.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.f126452f.set(item.a());
    }

    public final List a(String str, com.tencent.luggage.wxa.g5.b bVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList b16 = bVar.b();
        int size = b16.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = b16.get(i3);
            Intrinsics.checkNotNullExpressionValue(obj, "avatar_list[i]");
            b.C6229b c6229b = (b.C6229b) obj;
            arrayList.add(new o.a(c6229b.d(), c6229b.b(), str, bVar.d() == c6229b.c(), c6229b.a(), c6229b.c()));
        }
        return arrayList;
    }
}
