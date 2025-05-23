package com.tencent.kuikly.core.render.android.turbo;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 02\u00020\u0001:\u00011B!\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020 \u0012\b\u0010,\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0006J3\u0010\u0011\u001a\u00020\u00062+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u000fJ\u0006\u0010\u0012\u001a\u00020\u0000R#\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010!\u001a\u0004\b\u0019\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "j", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "k", "b", "", "d", "Lkotlin/Lazy;", "c", "()Ljava/util/List;", "lazyEventCallbackResults", "e", "I", "f", "()I", "l", "(I)V", "propType", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setPropKey", "(Ljava/lang/String;)V", "propKey", h.F, "Ljava/lang/Object;", "g", "()Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Object;)V", "propValue", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayProp implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy lazyEventCallbackResults;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int propType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String propKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object propValue;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp;", "PROP_TYPE_ATTR", "I", "PROP_TYPE_EVENT", "PROP_TYPE_FRAME", "PROP_TYPE_INSERT", "PROP_TYPE_SHADOW", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayProp$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion implements Parcelable.Creator<KRTurboDisplayProp> {
        Companion() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayProp createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new KRTurboDisplayProp(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public KRTurboDisplayProp[] newArray(int size) {
            return new KRTurboDisplayProp[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/kuikly/core/render/android/turbo/KRTurboDisplayProp$b", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements Function1<Object, Unit> {
        b() {
        }

        public void a(@Nullable Object result) {
            KRTurboDisplayProp.this.c().add(result);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    public KRTurboDisplayProp(int i3, @NotNull String propKey, @Nullable Object obj) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        this.propType = i3;
        this.propKey = propKey;
        this.propValue = obj;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<Object>>() { // from class: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayProp$lazyEventCallbackResults$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<Object> invoke() {
                return new ArrayList();
            }
        });
        this.lazyEventCallbackResults = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Object> c() {
        return (List) this.lazyEventCallbackResults.getValue();
    }

    @NotNull
    public final KRTurboDisplayProp b() {
        Object obj = this.propValue;
        if (this.propType == 3) {
            if (!(obj instanceof KRTurboDisplayShadow)) {
                obj = null;
            }
            KRTurboDisplayShadow kRTurboDisplayShadow = (KRTurboDisplayShadow) obj;
            if (kRTurboDisplayShadow != null) {
                obj = kRTurboDisplayShadow.c();
            } else {
                obj = null;
            }
        }
        return new KRTurboDisplayProp(this.propType, this.propKey, obj);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPropKey() {
        return this.propKey;
    }

    /* renamed from: f, reason: from getter */
    public final int getPropType() {
        return this.propType;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Object getPropValue() {
        return this.propValue;
    }

    public final void j() {
        if (this.propValue != null) {
            return;
        }
        this.propValue = new b();
    }

    public final void k(@Nullable Function1<Object, Unit> callback) {
        if (callback == null) {
            return;
        }
        Iterator<Object> it = c().iterator();
        while (it.hasNext()) {
            callback.invoke(it.next());
        }
    }

    public final void l(int i3) {
        this.propType = i3;
    }

    public final void m(@Nullable Object obj) {
        this.propValue = obj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Object obj;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.propType);
        parcel.writeString(this.propKey);
        int i3 = this.propType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        Object obj2 = this.propValue;
                        if (obj2 instanceof Integer) {
                            if (obj2 != null) {
                                obj = (Integer) obj2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                        } else if (obj2 instanceof Long) {
                            if (obj2 != null) {
                                obj = (Long) obj2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                        } else if (obj2 instanceof Float) {
                            if (obj2 != null) {
                                obj = (Float) obj2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                            }
                        } else if (obj2 instanceof Double) {
                            if (obj2 != null) {
                                obj = (Double) obj2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                            }
                        } else if (obj2 instanceof String) {
                            if (obj2 != null) {
                                obj = (String) obj2;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else {
                            obj = null;
                        }
                        parcel.writeValue(obj);
                        return;
                    }
                    Object obj3 = this.propValue;
                    if (obj3 != null) {
                        parcel.writeInt(((Integer) obj3).intValue());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                Object obj4 = this.propValue;
                if (obj4 != null) {
                    parcel.writeParcelable((Parcelable) obj4, flags);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Parcelable");
            }
            Object obj5 = this.propValue;
            if (obj5 != null) {
                parcel.writeParcelable((RectF) obj5, flags);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.RectF");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public KRTurboDisplayProp(@NotNull Parcel parcel) {
        this(r0, r1, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        String readString = parcel.readString();
        readString = readString == null ? "" : readString;
        Intrinsics.checkNotNullExpressionValue(readString, "parcel.readString() ?: \"\"");
        int i3 = this.propType;
        if (i3 != 1) {
            if (i3 == 2) {
                this.propValue = parcel.readParcelable(RectF.class.getClassLoader());
                return;
            }
            if (i3 == 3) {
                this.propValue = parcel.readParcelable(KRTurboDisplayShadow.class.getClassLoader());
            } else if (i3 != 4) {
                this.propValue = parcel.readValue(KRTurboDisplayProp.class.getClassLoader());
            } else {
                this.propValue = Integer.valueOf(parcel.readInt());
            }
        }
    }
}
