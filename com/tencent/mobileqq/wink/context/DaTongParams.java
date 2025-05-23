package com.tencent.mobileqq.wink.context;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0011\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0014B\t\b\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0013\u0010\u0016R+\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/context/DaTongParams;", "Landroid/os/Parcelable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "toString", "", "d", "Ljava/util/Map;", "map", "<set-?>", "e", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", DTParamKey.REPORT_KEY_APPKEY, "f", "c", WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, "<init>", "()V", "(Landroid/os/Parcel;)V", tl.h.F, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DaTongParams implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, String> map;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map dt_appkey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map xsj_camera_session_id;

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f318017i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(DaTongParams.class, DTParamKey.REPORT_KEY_APPKEY, "getDt_appkey()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DaTongParams.class, WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, "getXsj_camera_session_id()Ljava/lang/String;", 0))};

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<DaTongParams> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/context/DaTongParams$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/context/DaTongParams;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/context/DaTongParams;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<DaTongParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DaTongParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DaTongParams(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DaTongParams[] newArray(int size) {
            return new DaTongParams[size];
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/context/DaTongParams$b;", "", "", "a", "CAMERA_SESSION_ID_FORMAT", "Ljava/lang/String;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/context/DaTongParams;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.context.DaTongParams$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String a() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "android_camera_session_wink_%s_%d_%d", Arrays.copyOf(new Object[]{((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(new Random().nextInt(100))}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            return format;
        }

        Companion() {
        }
    }

    public /* synthetic */ DaTongParams(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @NotNull
    public final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putAll(this.map);
        return hashMap;
    }

    @NotNull
    public final String b() {
        Object orImplicitDefaultNullable;
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.dt_appkey, f318017i[0].getName());
        return (String) orImplicitDefaultNullable;
    }

    @NotNull
    public final String c() {
        Object orImplicitDefaultNullable;
        orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.xsj_camera_session_id, f318017i[1].getName());
        return (String) orImplicitDefaultNullable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dt_appkey.put(f318017i[0].getName(), str);
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.xsj_camera_session_id.put(f318017i[1].getName(), str);
    }

    @NotNull
    public String toString() {
        return this.map.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.map.size());
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    public DaTongParams() {
        Map<String, String> withDefaultMutable;
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new HashMap(), DaTongParams$map$1.INSTANCE);
        this.map = withDefaultMutable;
        this.dt_appkey = withDefaultMutable;
        this.xsj_camera_session_id = withDefaultMutable;
    }

    DaTongParams(Parcel parcel) {
        Map<String, String> withDefaultMutable;
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new HashMap(), DaTongParams$map$1.INSTANCE);
        this.map = withDefaultMutable;
        this.dt_appkey = withDefaultMutable;
        this.xsj_camera_session_id = withDefaultMutable;
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            String readString = parcel.readString();
            if (readString != null) {
                Map<String, String> map = this.map;
                String readString2 = parcel.readString();
                readString2 = readString2 == null ? "" : readString2;
                Intrinsics.checkNotNullExpressionValue(readString2, "parcel.readString() ?: \"\"");
                map.put(readString, readString2);
            }
        }
    }
}
