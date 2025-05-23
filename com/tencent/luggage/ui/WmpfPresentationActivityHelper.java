package com.tencent.luggage.ui;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class WmpfPresentationActivityHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final WmpfPresentationActivityHelper f120269a = new WmpfPresentationActivityHelper();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f120270b = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedList f120271c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet f120272d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public static BlockingQueue f120273e = new LinkedBlockingQueue();

    /* renamed from: f, reason: collision with root package name */
    public static final Thread f120274f = new BaseThread(b.f120279a);

    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$IPCOperatePresentationStack;", "Lcom/tencent/luggage/wxa/ka/r;", "Landroid/os/Bundle;", "Lcom/tencent/luggage/wxa/va/b;", "data", "invoke", "<init>", "()V", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes2.dex */
    public static final class IPCOperatePresentationStack implements r {

        /* loaded from: classes2.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bundle f120275a;

            public a(Bundle bundle) {
                this.f120275a = bundle;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Parcelable parcelable = this.f120275a.getParcelable("token");
                Intrinsics.checkNotNull(parcelable);
                a aVar = (a) parcelable;
                String string = this.f120275a.getString("command", "");
                w.d("WMPF.WmpfPresentationActivityHelper", "[%s] -> [%s] [%s] invoke: " + string, aVar.b(), z.i(), aVar.a());
                if (string != null) {
                    switch (string.hashCode()) {
                        case -1964853850:
                            if (string.equals("unregisterToMainProc")) {
                                WmpfPresentationActivityHelper.f120269a.d(aVar);
                                return;
                            }
                            return;
                        case 3529469:
                            if (string.equals("show")) {
                                WmpfPresentationActivityHelper.f120269a.b(aVar);
                                return;
                            }
                            return;
                        case 1030080642:
                            if (string.equals("onForeground")) {
                                Collection values = WmpfPresentationActivityHelper.f120270b.values();
                                Intrinsics.checkNotNullExpressionValue(values, "activityPresentationMap.values");
                                Iterator it = values.iterator();
                                if (!it.hasNext()) {
                                    com.tencent.luggage.wxa.k0.d.a(null);
                                    return;
                                } else {
                                    com.tencent.luggage.wxa.k0.d.a(it.next());
                                    throw null;
                                }
                            }
                            return;
                        case 1320532813:
                            if (string.equals("registerToMainProc")) {
                                WmpfPresentationActivityHelper.f120269a.c(aVar);
                                return;
                            }
                            return;
                        case 1671672458:
                            if (string.equals("dismiss")) {
                                WmpfPresentationActivityHelper.f120269a.a(aVar);
                                return;
                            }
                            return;
                        case 2008396909:
                            if (string.equals("onBackground")) {
                                Collection values2 = WmpfPresentationActivityHelper.f120270b.values();
                                Intrinsics.checkNotNullExpressionValue(values2, "activityPresentationMap.values");
                                Iterator it5 = values2.iterator();
                                if (!it5.hasNext()) {
                                    com.tencent.luggage.wxa.k0.d.a(null);
                                    return;
                                } else {
                                    com.tencent.luggage.wxa.k0.d.a(it5.next());
                                    throw null;
                                }
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        @Override // com.tencent.luggage.wxa.ka.r
        @NotNull
        public com.tencent.luggage.wxa.va.b invoke(@NotNull Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            c0.a(new a(data));
            return new com.tencent.luggage.wxa.va.b(0);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C5972a();

        /* renamed from: a, reason: collision with root package name */
        public final int f120276a;

        /* renamed from: b, reason: collision with root package name */
        public final String f120277b;

        /* renamed from: c, reason: collision with root package name */
        public final String f120278c;

        /* renamed from: com.tencent.luggage.ui.WmpfPresentationActivityHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C5972a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new a(parcel.readInt(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(int i3, String originProcessName, String name) {
            Intrinsics.checkNotNullParameter(originProcessName, "originProcessName");
            Intrinsics.checkNotNullParameter(name, "name");
            this.f120276a = i3;
            this.f120277b = originProcessName;
            this.f120278c = name;
        }

        public final String a() {
            return this.f120278c;
        }

        public final String b() {
            return this.f120277b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f120276a == aVar.f120276a && Intrinsics.areEqual(this.f120277b, aVar.f120277b) && Intrinsics.areEqual(this.f120278c, aVar.f120278c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f120276a * 31) + this.f120277b.hashCode()) * 31) + this.f120278c.hashCode();
        }

        public String toString() {
            return "PresentationToken(presentationRef=" + this.f120276a + ", originProcessName=" + this.f120277b + ", name=" + this.f120278c + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.f120276a);
            out.writeString(this.f120277b);
            out.writeString(this.f120278c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public static final b f120279a = new b();

        @Override // java.lang.Runnable
        public final void run() {
            while (true) {
                ((Function0) WmpfPresentationActivityHelper.f120273e.take()).invoke();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f120280a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f120281b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, Bundle bundle) {
            super(0);
            this.f120280a = aVar;
            this.f120281b = bundle;
        }

        public final void a() {
            o.a(this.f120280a.b(), this.f120281b, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f120282a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f120283b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, Bundle bundle) {
            super(0);
            this.f120282a = aVar;
            this.f120283b = bundle;
        }

        public final void a() {
            o.a(this.f120282a.b(), this.f120283b, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f120284a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Bundle bundle) {
            super(0);
            this.f120284a = bundle;
        }

        public final void a() {
            o.a(z.g(), this.f120284a, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f120285a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f120286b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, Bundle bundle) {
            super(0);
            this.f120285a = aVar;
            this.f120286b = bundle;
        }

        public final void a() {
            o.a(this.f120285a.b(), this.f120286b, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class g extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f120287a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f120288b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, Bundle bundle) {
            super(0);
            this.f120287a = aVar;
            this.f120288b = bundle;
        }

        public final void a() {
            o.a(this.f120287a.b(), this.f120288b, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class h extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f120289a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Bundle bundle) {
            super(0);
            this.f120289a = bundle;
        }

        public final void a() {
            o.a(z.g(), this.f120289a, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f120290a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Bundle bundle) {
            super(0);
            this.f120290a = bundle;
        }

        public final void a() {
            o.a(z.g(), this.f120290a, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f120291a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Bundle bundle) {
            super(0);
            this.f120291a = bundle;
        }

        public final void a() {
            o.a(z.g(), this.f120291a, IPCOperatePresentationStack.class);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public final void c(a aVar) {
        if (z.m()) {
            f120271c.push(aVar);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("command", "registerToMainProc");
        bundle.putParcelable("token", aVar);
        a(new i(bundle));
    }

    public final void d(a aVar) {
        if (z.m()) {
            if (!f120271c.remove(aVar) && !f120272d.remove(aVar)) {
                w.f("WMPF.WmpfPresentationActivityHelper", "unregisterToMainProc: remove failed");
                return;
            } else {
                w.d("WMPF.WmpfPresentationActivityHelper", "unregisterToMainProc: success");
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("command", "unregisterToMainProc");
        bundle.putParcelable("token", aVar);
        a(new j(bundle));
    }

    public final void a(a aVar) {
        if (z.m()) {
            Bundle bundle = new Bundle();
            bundle.putString("command", "onBackground");
            bundle.putParcelable("token", aVar);
            a(new c(aVar, bundle));
            LinkedList linkedList = f120271c;
            linkedList.remove(aVar);
            f120272d.add(aVar);
            a aVar2 = (a) linkedList.peek();
            if (aVar2 != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("command", "onForeground");
                bundle2.putParcelable("token", aVar2);
                a(new d(aVar2, bundle2));
                return;
            }
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("command", "dismiss");
        bundle3.putParcelable("token", aVar);
        a(new e(bundle3));
    }

    public final void b(a aVar) {
        if (z.m()) {
            LinkedList linkedList = f120271c;
            if (!linkedList.remove(aVar) && !f120272d.remove(aVar)) {
                w.h("WMPF.WmpfPresentationActivityHelper", "remove token [%s] fail", aVar.toString());
                return;
            }
            a aVar2 = (a) linkedList.peek();
            if (aVar2 != null) {
                Bundle bundle = new Bundle();
                bundle.putString("command", "onBackground");
                bundle.putParcelable("token", aVar2);
                a(new f(aVar2, bundle));
            }
            linkedList.push(aVar);
            Bundle bundle2 = new Bundle();
            bundle2.putString("command", "onForeground");
            bundle2.putParcelable("token", aVar);
            a(new g(aVar, bundle2));
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("command", "show");
        bundle3.putParcelable("token", aVar);
        a(new h(bundle3));
    }

    public final void a(Function0 function0) {
        Thread thread = f120274f;
        if (!thread.isAlive()) {
            thread.setName("presentation-ipc-thread");
            thread.start();
        }
        f120273e.put(function0);
    }
}
