package com.tencent.kuikly.core.render.android.turbo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SizeF;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010*\u001a\u00020\b\u0012\u0006\u0010/\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u00101B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b0\u00102J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0000R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u0014\u0010*\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0017\u0010/\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow;", "Landroid/os/Parcelable;", "", "key", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp;", "f", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Landroid/util/SizeF;", "constraintSize", "b", "", "propValue", "k", "name", "params", "a", "c", "d", "Landroid/util/SizeF;", "e", "()Landroid/util/SizeF;", "setConstraintSize", "(Landroid/util/SizeF;)V", "", "Ljava/util/List;", "g", "()Ljava/util/List;", "setProps", "(Ljava/util/List;)V", "props", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNodeMethod;", "getCallMethods", "setCallMethods", "callMethods", h.F, "I", "tag", "i", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "viewName", "<init>", "(ILjava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayShadow implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SizeF constraintSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<KRTurboDisplayProp> props;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<KRTurboDisplayNodeMethod> callMethods;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int tag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String viewName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayShadow;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayShadow$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion implements Parcelable.Creator<KRTurboDisplayShadow> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayShadow createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new KRTurboDisplayShadow(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayShadow[] newArray(int size) {
            return new KRTurboDisplayShadow[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRTurboDisplayShadow(int i3, @NotNull String viewName) {
        Intrinsics.checkNotNullParameter(viewName, "viewName");
        this.tag = i3;
        this.viewName = viewName;
        this.constraintSize = new SizeF(0.0f, 0.0f);
        this.props = new ArrayList();
        this.callMethods = new ArrayList();
    }

    private final KRTurboDisplayProp f(String key) {
        for (KRTurboDisplayProp kRTurboDisplayProp : this.props) {
            if (Intrinsics.areEqual(kRTurboDisplayProp.getPropKey(), key)) {
                return kRTurboDisplayProp;
            }
        }
        return null;
    }

    public final void a(@NotNull String name, @NotNull String params) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(params, "params");
        KRTurboDisplayNodeMethod kRTurboDisplayNodeMethod = new KRTurboDisplayNodeMethod();
        kRTurboDisplayNodeMethod.j(name);
        kRTurboDisplayNodeMethod.l(params);
        this.callMethods.add(kRTurboDisplayNodeMethod);
    }

    public final void b(@NotNull SizeF constraintSize) {
        Intrinsics.checkNotNullParameter(constraintSize, "constraintSize");
        this.constraintSize = new SizeF(constraintSize.getWidth(), constraintSize.getHeight());
    }

    @NotNull
    public final KRTurboDisplayShadow c() {
        KRTurboDisplayShadow kRTurboDisplayShadow = new KRTurboDisplayShadow(this.tag, this.viewName);
        if (!this.props.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<KRTurboDisplayProp> it = this.props.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().b());
            }
            kRTurboDisplayShadow.props = arrayList;
        }
        if (!this.callMethods.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<KRTurboDisplayNodeMethod> it5 = this.callMethods.iterator();
            while (it5.hasNext()) {
                arrayList2.add(it5.next().a());
            }
            kRTurboDisplayShadow.callMethods = arrayList2;
        }
        return kRTurboDisplayShadow;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final SizeF getConstraintSize() {
        return this.constraintSize;
    }

    @NotNull
    public final List<KRTurboDisplayProp> g() {
        return this.props;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getViewName() {
        return this.viewName;
    }

    public final void k(@NotNull String key, @Nullable Object propValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        KRTurboDisplayProp f16 = f(key);
        if (f16 == null) {
            this.props.add(new KRTurboDisplayProp(0, key, propValue));
        } else {
            f16.m(propValue);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.tag);
        parcel.writeString(this.viewName);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.constraintSize.getWidth());
        sb5.append(QbAddrData.DATA_SPLITER);
        sb5.append(this.constraintSize.getHeight());
        parcel.writeString(sb5.toString());
        if (!this.props.isEmpty()) {
            parcel.writeInt(1);
            Object[] array = this.props.toArray(new KRTurboDisplayProp[0]);
            if (array != null) {
                parcel.writeParcelableArray((Parcelable[]) array, flags);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            parcel.writeInt(0);
        }
        if (!this.callMethods.isEmpty()) {
            parcel.writeInt(1);
            Object[] array2 = this.callMethods.toArray(new KRTurboDisplayNodeMethod[0]);
            if (array2 != null) {
                parcel.writeParcelableArray((Parcelable[]) array2, flags);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        parcel.writeInt(0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KRTurboDisplayShadow(@NotNull Parcel parcel) {
        this(r0, r1);
        List split$default;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString() ?: \"\"");
        String readString2 = parcel.readString();
        String str = readString2 == null ? "0.0|0.0" : readString2;
        Intrinsics.checkNotNullExpressionValue(str, "parcel.readString() ?: \"0.0|0.0\"");
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null);
        this.constraintSize = new SizeF(Float.parseFloat((String) split$default.get(0)), Float.parseFloat((String) split$default.get(1)));
        if (parcel.readInt() == 1) {
            List<KRTurboDisplayProp> list = this.props;
            Parcelable[] readParcelableArray = parcel.readParcelableArray(KRTurboDisplayShadow.class.getClassLoader());
            List mutableList = readParcelableArray != null ? ArraysKt___ArraysKt.toMutableList(readParcelableArray) : null;
            if (mutableList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayProp>");
            }
            list.addAll(TypeIntrinsics.asMutableList(mutableList));
        }
        if (parcel.readInt() == 1) {
            List<KRTurboDisplayNodeMethod> list2 = this.callMethods;
            Parcelable[] readParcelableArray2 = parcel.readParcelableArray(KRTurboDisplayShadow.class.getClassLoader());
            List mutableList2 = readParcelableArray2 != null ? ArraysKt___ArraysKt.toMutableList(readParcelableArray2) : null;
            if (mutableList2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayNodeMethod>");
            }
            list2.addAll(TypeIntrinsics.asMutableList(mutableList2));
        }
    }
}
