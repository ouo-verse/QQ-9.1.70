package com.tencent.luggage.wxa.mc;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q0 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap f134356a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayMap f134357b;

    /* renamed from: c, reason: collision with root package name */
    public static final b f134355c = new b(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<q0> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q0 createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new q0(source);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q0[] newArray(int i3) {
            return new q0[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public q0(Parcel p16) {
        Intrinsics.checkNotNullParameter(p16, "p");
        int readInt = p16.readInt();
        this.f134356a = new ArrayMap(readInt);
        this.f134357b = new ArrayMap();
        for (int i3 = 0; i3 < readInt; i3++) {
            String readString = p16.readString();
            Intrinsics.checkNotNull(readString);
            this.f134356a.put(new r0(readString), a(p16));
        }
    }

    public final WxaPluginPkgInfo a(String pluginId) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(pluginId, "pluginId");
        ArrayMap arrayMap = this.f134357b;
        if (arrayMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
            arrayMap = null;
        }
        LinkedList linkedList = (LinkedList) arrayMap.get(new s0(pluginId));
        if (linkedList == null) {
            return null;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) linkedList);
        return (WxaPluginPkgInfo) firstOrNull;
    }

    public final List b(String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return (List) this.f134356a.get(new r0(moduleName));
    }

    public final void c() {
        if (this.f134357b == null) {
            this.f134357b = new ArrayMap();
            Collection<List> values = this.f134356a.values();
            Intrinsics.checkNotNullExpressionValue(values, "mPrimaryMap.values");
            for (List<WxaPluginPkgInfo> list : values) {
                Intrinsics.checkNotNullExpressionValue(list, "list");
                for (WxaPluginPkgInfo wxaPluginPkgInfo : list) {
                    ArrayMap arrayMap = this.f134357b;
                    if (arrayMap == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
                        arrayMap = null;
                    }
                    a(arrayMap, wxaPluginPkgInfo);
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.f134356a.size());
        for (Map.Entry entry : this.f134356a.entrySet()) {
            r0 r0Var = (r0) entry.getKey();
            List value = (List) entry.getValue();
            dest.writeString(r0Var.a());
            Intrinsics.checkNotNullExpressionValue(value, "value");
            a(dest, value);
        }
    }

    public final void a(String moduleName, List list) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f134356a.put(new r0(moduleName), list);
    }

    public final boolean b() {
        return a() <= 0;
    }

    public final int a() {
        return this.f134356a.size();
    }

    public final void a(WxaPluginPkgInfo updated) {
        Intrinsics.checkNotNullParameter(updated, "updated");
        ArrayMap arrayMap = this.f134357b;
        if (arrayMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
            arrayMap = null;
        }
        String str = updated.provider;
        Intrinsics.checkNotNullExpressionValue(str, "updated.provider");
        LinkedList<WxaPluginPkgInfo> linkedList = (LinkedList) arrayMap.get(new s0(str));
        if (linkedList != null) {
            for (WxaPluginPkgInfo wxaPluginPkgInfo : linkedList) {
                if (updated.isAssignable(wxaPluginPkgInfo)) {
                    wxaPluginPkgInfo.pkgPath = updated.pkgPath;
                    wxaPluginPkgInfo.md5 = updated.md5;
                    wxaPluginPkgInfo.stringVersion = updated.stringVersion;
                    int i3 = updated.version;
                    if (i3 > 0) {
                        wxaPluginPkgInfo.version = i3;
                    }
                }
            }
        }
    }

    public q0() {
        this.f134356a = new ArrayMap();
    }

    public final void a(Parcel parcel, List list) {
        parcel.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((WxaPluginPkgInfo) it.next()).writeToParcel(parcel, 0);
        }
    }

    public final List a(Parcel parcel) {
        LinkedList linkedList = new LinkedList();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            WxaPluginPkgInfo p16 = WxaPluginPkgInfo.CREATOR.createFromParcel(parcel);
            ArrayMap arrayMap = this.f134357b;
            if (arrayMap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSecondaryMap");
                arrayMap = null;
            }
            Intrinsics.checkNotNullExpressionValue(p16, "p");
            a(arrayMap, p16);
            linkedList.add(p16);
        }
        return linkedList;
    }

    public final void a(ArrayMap arrayMap, WxaPluginPkgInfo wxaPluginPkgInfo) {
        String str = wxaPluginPkgInfo.provider;
        Intrinsics.checkNotNullExpressionValue(str, "plugin.provider");
        s0 s0Var = new s0(str);
        LinkedList linkedList = (LinkedList) arrayMap.get(s0Var);
        if (linkedList == null) {
            linkedList = new LinkedList();
            arrayMap.put(s0Var, linkedList);
        }
        linkedList.add(wxaPluginPkgInfo);
    }
}
