package com.tencent.luggage.wxa.q7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCLeakFreeWrapper;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v implements WxaAppCustomActionSheetDelegate, com.tencent.luggage.wxaapi.m {

    /* renamed from: a, reason: collision with root package name */
    public static final v f138193a = new v();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<a> CREATOR = new C6636a();

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f138194a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.v$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6636a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    arrayList.add(parcel.readParcelable(a.class.getClassLoader()));
                }
                return new a(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(ArrayList list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f138194a = list;
        }

        public final ArrayList a() {
            return this.f138194a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            ArrayList arrayList = this.f138194a;
            out.writeInt(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                out.writeParcelable((Parcelable) it.next(), i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/q7/v$b;", "kotlin.jvm.PlatformType", "invokeWrapper", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "ipcCallback", "", "a", "(Lcom/tencent/luggage/wxa/q7/v$b;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class c<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final c f138208a = new c();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements WxaAppCustomActionSheetDelegate.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f138209a;

            public a(b bVar) {
                this.f138209a = bVar;
            }

            @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
            public void onCancel() {
                this.f138209a.e().a(Bundle.EMPTY);
            }

            @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
            public void onFail(String str) {
                this.f138209a.f().a(new com.tencent.luggage.wxa.va.d(str));
            }

            @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate.a
            public void onSuccess() {
                this.f138209a.g().a(Bundle.EMPTY);
            }
        }

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(b bVar, com.tencent.luggage.wxa.ka.i iVar) {
            WxaAppCustomActionSheetDelegate b16;
            try {
                s d16 = s.d.f138074a.d();
                if (d16 == null || (b16 = d16.b()) == null) {
                    if (iVar != null) {
                        iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                        return;
                    }
                    return;
                }
                if (bVar == null) {
                    if (iVar != null) {
                        return;
                    } else {
                        return;
                    }
                }
                String h16 = bVar.h();
                int i3 = bVar.i();
                int d17 = bVar.d();
                String b17 = bVar.b();
                JSONObject jSONObject = b17 != null ? new JSONObject(b17) : null;
                WxaAppCustomActionSheetDelegate.ActionType a16 = bVar.a();
                Map<String, Object> c16 = bVar.c();
                a aVar = new a(bVar);
                if (b16 instanceof com.tencent.luggage.wxaapi.m) {
                    ((com.tencent.luggage.wxaapi.m) b16).handleCustomAction(h16, i3, d17, jSONObject, aVar, a16, c16);
                } else {
                    b16.handleCustomAction(h16, i3, d17, jSONObject, aVar);
                }
                if (iVar != null) {
                    iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                }
            } finally {
                if (iVar != null) {
                    iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/va/d;", "it", "Lcom/tencent/luggage/wxa/q7/v$a;", "a", "(Lcom/tencent/luggage/wxa/va/d;)Lcom/tencent/luggage/wxa/q7/v$a;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class d<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

        /* renamed from: a, reason: collision with root package name */
        public static final d f138210a = new d();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke(com.tencent.luggage.wxa.va.d dVar) {
            String str;
            boolean z16;
            WxaAppCustomActionSheetDelegate b16;
            List<WxaAppCustomActionSheetDelegate.ActionItem> list = null;
            if (dVar != null) {
                str = dVar.f143315a;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return new a(new ArrayList());
            }
            s d16 = s.d.f138074a.d();
            if (d16 != null && (b16 = d16.b()) != null) {
                list = b16.provideCustomActionItems(str);
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return new a(new ArrayList(list));
        }
    }

    @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate
    public void handleCustomAction(String wxaAppID, int i3, int i16, JSONObject jSONObject, WxaAppCustomActionSheetDelegate.a callback) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        throw new IllegalStateException("Deprecated".toString());
    }

    @Override // com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate
    public List provideCustomActionItems(String str) {
        try {
            String g16 = com.tencent.luggage.wxa.tn.z.g();
            Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
            a aVar = (a) com.tencent.luggage.wxa.ka.b.a(g16, new com.tencent.luggage.wxa.va.d(str), d.f138210a);
            if (aVar == null) {
                return null;
            }
            return aVar.a();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.luggage.wxaapi.m
    public void handleCustomAction(String wxaAppID, int i3, int i16, JSONObject jSONObject, WxaAppCustomActionSheetDelegate.a callback, WxaAppCustomActionSheetDelegate.ActionType actionType, Map map) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        b bVar = new b(wxaAppID, i3, i16, jSONObject, callback, actionType, map);
        String g16 = com.tencent.luggage.wxa.tn.z.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
        com.tencent.luggage.wxa.ka.b.a(g16, bVar, c.f138208a, null, 8, null);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        public final String f138196a;

        /* renamed from: b, reason: collision with root package name */
        public final int f138197b;

        /* renamed from: c, reason: collision with root package name */
        public final int f138198c;

        /* renamed from: d, reason: collision with root package name */
        public final String f138199d;

        /* renamed from: e, reason: collision with root package name */
        public final com.tencent.luggage.wxa.v4.e f138200e;

        /* renamed from: f, reason: collision with root package name */
        public final com.tencent.luggage.wxa.v4.e f138201f;

        /* renamed from: g, reason: collision with root package name */
        public final com.tencent.luggage.wxa.v4.e f138202g;

        /* renamed from: h, reason: collision with root package name */
        public final WxaAppCustomActionSheetDelegate.ActionType f138203h;

        /* renamed from: i, reason: collision with root package name */
        public final Map f138204i;

        /* renamed from: j, reason: collision with root package name */
        public static final e f138195j = new e(null);

        @JvmField
        @NotNull
        public static final Parcelable.Creator<b> CREATOR = new d();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements com.tencent.luggage.wxa.v4.f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WxaAppCustomActionSheetDelegate.a f138205a;

            public a(WxaAppCustomActionSheetDelegate.a aVar) {
                this.f138205a = aVar;
            }

            @Override // com.tencent.luggage.wxa.v4.f
            public final void a(Bundle bundle) {
                this.f138205a.onSuccess();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.v$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6637b implements com.tencent.luggage.wxa.v4.f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WxaAppCustomActionSheetDelegate.a f138206a;

            public C6637b(WxaAppCustomActionSheetDelegate.a aVar) {
                this.f138206a = aVar;
            }

            @Override // com.tencent.luggage.wxa.v4.f
            public final void a(com.tencent.luggage.wxa.va.d dVar) {
                this.f138206a.onFail(dVar != null ? dVar.f143315a : null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements com.tencent.luggage.wxa.v4.f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WxaAppCustomActionSheetDelegate.a f138207a;

            public c(WxaAppCustomActionSheetDelegate.a aVar) {
                this.f138207a = aVar;
            }

            @Override // com.tencent.luggage.wxa.v4.f
            public final void a(Bundle bundle) {
                this.f138207a.onCancel();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new b(source);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e {
            public e() {
            }

            public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final WxaAppCustomActionSheetDelegate.ActionType a(int i3) {
                Object obj;
                boolean z16;
                List<WxaAppCustomActionSheetDelegate.ActionType> entries = WxaAppCustomActionSheetDelegate.ActionType.getEntries();
                Intrinsics.checkNotNullExpressionValue(entries, "getEntries()");
                Iterator<T> it = entries.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((WxaAppCustomActionSheetDelegate.ActionType) obj).ordinal() == i3) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                WxaAppCustomActionSheetDelegate.ActionType actionType = (WxaAppCustomActionSheetDelegate.ActionType) obj;
                if (actionType == null) {
                    return WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage;
                }
                return actionType;
            }
        }

        public b(String wxaAppID, int i3, int i16, String str, com.tencent.luggage.wxa.v4.e onSuccess, com.tencent.luggage.wxa.v4.e onFail, com.tencent.luggage.wxa.v4.e onCancel, WxaAppCustomActionSheetDelegate.ActionType actionType, Map map) {
            Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onFail, "onFail");
            Intrinsics.checkNotNullParameter(onCancel, "onCancel");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            this.f138196a = wxaAppID;
            this.f138197b = i3;
            this.f138198c = i16;
            this.f138199d = str;
            this.f138200e = onSuccess;
            this.f138201f = onFail;
            this.f138202g = onCancel;
            this.f138203h = actionType;
            this.f138204i = map;
        }

        public final WxaAppCustomActionSheetDelegate.ActionType a() {
            return this.f138203h;
        }

        public final String b() {
            return this.f138199d;
        }

        public final Map c() {
            return this.f138204i;
        }

        public final int d() {
            return this.f138198c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final com.tencent.luggage.wxa.v4.e e() {
            return this.f138202g;
        }

        public final com.tencent.luggage.wxa.v4.e f() {
            return this.f138201f;
        }

        public final void finalize() {
            j();
        }

        public final com.tencent.luggage.wxa.v4.e g() {
            return this.f138200e;
        }

        public final String h() {
            return this.f138196a;
        }

        public final int i() {
            return this.f138197b;
        }

        public final void j() {
            OnWXAppResultXPCLeakFreeWrapper.a(this.f138200e);
            OnWXAppResultXPCLeakFreeWrapper.a(this.f138201f);
            OnWXAppResultXPCLeakFreeWrapper.a(this.f138202g);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.f138196a);
            dest.writeInt(this.f138197b);
            dest.writeInt(this.f138198c);
            dest.writeString(this.f138199d);
            OnWXAppResultXPCLeakFreeWrapper.a(this.f138200e, dest, i3);
            OnWXAppResultXPCLeakFreeWrapper.a(this.f138201f, dest, i3);
            OnWXAppResultXPCLeakFreeWrapper.a(this.f138202g, dest, i3);
            dest.writeInt(this.f138203h.ordinal());
            String str = null;
            if (this.f138204i != null) {
                str = new com.tencent.luggage.wxa.i3.n(this.f138204i, false, 2, (DefaultConstructorMarker) null).c();
            }
            dest.writeString(str);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(String wxaAppID, int i3, int i16, JSONObject jSONObject, WxaAppCustomActionSheetDelegate.a callback, WxaAppCustomActionSheetDelegate.ActionType actionType, Map map) {
            this(wxaAppID, i3, i16, r6, r7, r8, r9, actionType, map);
            Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            String jSONObject2 = jSONObject != null ? jSONObject.toString() : null;
            com.tencent.luggage.wxa.v4.e a16 = com.tencent.luggage.wxa.v4.e.a(new a(callback));
            Intrinsics.checkNotNullExpressionValue(a16, "callback: ActionHandleCa\u2026 { callback.onSuccess() }");
            com.tencent.luggage.wxa.v4.e a17 = com.tencent.luggage.wxa.v4.e.a(new C6637b(callback));
            Intrinsics.checkNotNullExpressionValue(a17, "callback: ActionHandleCa\u2026k.onFail(result?.value) }");
            com.tencent.luggage.wxa.v4.e a18 = com.tencent.luggage.wxa.v4.e.a(new c(callback));
            Intrinsics.checkNotNullExpressionValue(a18, "callback: ActionHandleCa\u2026> { callback.onCancel() }");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(Parcel source) {
            this(r2, r3, r4, r5, r6, r7, r8, r9, r12 != null ? r12.d() : null);
            Intrinsics.checkNotNullParameter(source, "source");
            String readString = source.readString();
            Intrinsics.checkNotNull(readString);
            int readInt = source.readInt();
            int readInt2 = source.readInt();
            String readString2 = source.readString();
            com.tencent.luggage.wxa.v4.e a16 = OnWXAppResultXPCLeakFreeWrapper.a(source);
            Intrinsics.checkNotNull(a16);
            com.tencent.luggage.wxa.v4.e a17 = OnWXAppResultXPCLeakFreeWrapper.a(source);
            Intrinsics.checkNotNull(a17);
            com.tencent.luggage.wxa.v4.e a18 = OnWXAppResultXPCLeakFreeWrapper.a(source);
            Intrinsics.checkNotNull(a18);
            WxaAppCustomActionSheetDelegate.ActionType a19 = f138195j.a(source.readInt());
            com.tencent.luggage.wxa.i3.n a26 = com.tencent.luggage.wxa.i3.n.f129339b.a(source.readString());
        }
    }
}
