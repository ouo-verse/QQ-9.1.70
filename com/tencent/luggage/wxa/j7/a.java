package com.tencent.luggage.wxa.j7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f130880a = b.f130883a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.j7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6330a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public static final C6331a f130881a = new C6331a(null);

        /* renamed from: b, reason: collision with root package name */
        public static final C6330a f130882b = new C6330a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.j7.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6331a {
            public C6331a() {
            }

            public /* synthetic */ C6331a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final C6330a a() {
                return C6330a.f130882b;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            boolean z16;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual("com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION", str)) {
                String stringExtra = intent.getStringExtra("kAction");
                String stringExtra2 = intent.getStringExtra("kContent");
                if (stringExtra2 != null && stringExtra2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                byte[] decode = Base64.decode(stringExtra2, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(rawXml, Base64.DEFAULT)");
                String str2 = new String(decode, Charsets.UTF_8);
                List a16 = a.f130880a.a();
                ArrayList arrayList = new ArrayList();
                for (Object obj : a16) {
                    if (Intrinsics.areEqual(((a) obj).name(), stringExtra)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(intent, str2);
                }
            }
        }
    }

    void a(Intent intent, String str);

    String name();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f130883a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final HashSet f130884b = new HashSet();

        public final void a(a action) {
            Intrinsics.checkNotNullParameter(action, "action");
            HashSet hashSet = f130884b;
            synchronized (hashSet) {
                hashSet.add(action);
                if (hashSet.size() == 1) {
                    w.d("Luggage.DebuggerBroadcastAction.Registry", "register receiver action[%s]", "com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION");
                    Context c16 = z.c();
                    C6330a a16 = C6330a.f130881a.a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION");
                    Unit unit = Unit.INSTANCE;
                    c16.registerReceiver(a16, intentFilter);
                }
                Unit unit2 = Unit.INSTANCE;
            }
        }

        public final List a() {
            LinkedList linkedList;
            HashSet hashSet = f130884b;
            synchronized (hashSet) {
                linkedList = new LinkedList(hashSet);
            }
            return linkedList;
        }
    }
}
