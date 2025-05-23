package com.tencent.mobileqq.wink.context;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b93.OutputData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001&B\u001b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\"\u0010#B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\"\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010!\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b\u001b\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/context/WinkExodus;", "Landroid/os/Parcelable;", "", "f", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "j", "Lb93/b;", "outputData", "k", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "path", "g", "d", "Ljava/lang/String;", "routePath", "", "e", "J", "routePoint", "Lb93/a;", "Lkotlin/Lazy;", "()Lb93/a;", "router", "<init>", "(Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", tl.h.F, "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkExodus implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String routePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long routePoint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy router;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WinkExodus> CREATOR = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/context/WinkExodus$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/context/WinkExodus;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/context/WinkExodus;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<WinkExodus> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkExodus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkExodus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkExodus[] newArray(int size) {
            return new WinkExodus[size];
        }
    }

    public WinkExodus(@Nullable String str, long j3) {
        Lazy lazy;
        this.routePath = str;
        this.routePoint = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b93.a>() { // from class: com.tencent.mobileqq.wink.context.WinkExodus$router$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:3:0x0008, B:5:0x0010, B:10:0x001c, B:11:0x002b), top: B:2:0x0008 }] */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final b93.a invoke() {
                b93.a aVar;
                String str2;
                boolean z16;
                String str3;
                boolean isBlank;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    str2 = WinkExodus.this.routePath;
                } catch (Exception e16) {
                    QLog.e("WinkExodus", 1, "[router] not found router, " + e16);
                    aVar = null;
                }
                if (str2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                    if (!isBlank) {
                        z16 = false;
                        if (z16) {
                            WinkExodus.this.routePath = QQWinkConstants.QCIRCLE_OUTPUT_ROUTE;
                            WinkExodus.this.routePoint = 64L;
                        }
                        BaseApplication baseApplication = BaseApplication.context;
                        str3 = WinkExodus.this.routePath;
                        aVar = (b93.a) QRoute.createNavigator(baseApplication, str3).requestWithReturn();
                        QLog.d("WinkExodus", 1, "[router] cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", result=" + aVar);
                        return aVar;
                    }
                }
                z16 = true;
                if (z16) {
                }
                BaseApplication baseApplication2 = BaseApplication.context;
                str3 = WinkExodus.this.routePath;
                aVar = (b93.a) QRoute.createNavigator(baseApplication2, str3).requestWithReturn();
                QLog.d("WinkExodus", 1, "[router] cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", result=" + aVar);
                return aVar;
            }
        });
        this.router = lazy;
    }

    private final b93.a e() {
        return (b93.a) this.router.getValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean f() {
        if (QLog.isColorLevel()) {
            QLog.d("WinkExodus", 2, "[onBack] router=" + e());
        }
        if (e() == null) {
            QLog.w("WinkExodus", 1, "[onBack] invalid router");
            return false;
        }
        b93.a e16 = e();
        Intrinsics.checkNotNull(e16);
        return e16.interceptExitWink();
    }

    public final boolean g(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return Intrinsics.areEqual(this.routePath, path);
    }

    public final boolean j(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (QLog.isColorLevel()) {
            QLog.d("WinkExodus", 2, "[onBack] router=" + e());
        }
        if (!WinkContext.INSTANCE.d().getIsFirstPage()) {
            return false;
        }
        if (e() == null) {
            QLog.w("WinkExodus", 1, "[onBack] invalid router");
            return false;
        }
        b93.a e16 = e();
        Intrinsics.checkNotNull(e16);
        e16.onBack(context, bundle);
        QLog.i("WinkExodus", 1, "[onBack] back to router, " + e());
        return true;
    }

    public final boolean k(@Nullable Context context, @Nullable OutputData outputData) {
        Long l3;
        if (outputData != null) {
            l3 = Long.valueOf(outputData.getOutputPoint());
        } else {
            l3 = null;
        }
        QLog.i("WinkExodus", 1, "[onOutput] point=" + l3 + ", routePoint=" + this.routePoint + ", router=" + e());
        if (context != null && outputData != null) {
            if (e() == null || (this.routePoint & outputData.getOutputPoint()) == 0) {
                return false;
            }
            b93.a e16 = e();
            Intrinsics.checkNotNull(e16);
            e16.onOutput(context, outputData);
            return true;
        }
        QLog.w("WinkExodus", 1, "[onOutput] invalid params");
        return false;
    }

    @NotNull
    public String toString() {
        return "{routePath=" + this.routePath + ", routePoint=" + this.routePoint + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.routePath);
        parcel.writeLong(this.routePoint);
    }

    public /* synthetic */ WinkExodus(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0L : j3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkExodus(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readLong());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
