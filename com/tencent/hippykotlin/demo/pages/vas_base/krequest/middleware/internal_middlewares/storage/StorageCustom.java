package com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Custom;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class StorageCustom extends Custom {
    public final Function1<e, Unit> beforeSetStorage;
    public final Function1<Response, Boolean> isSuccess;
    public final boolean isUpdateImmediately;
    public final Long minVersion;
    public final Function1<e, Unit> onGetStorage;
    public final Function0<Unit> onStorageNull;
    public final Long validPeriod;

    public StorageCustom() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        Function1<e, Unit> function1 = this.onGetStorage;
        int hashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1<Response, Boolean> function12 = this.isSuccess;
        int hashCode2 = (hashCode + (function12 == null ? 0 : function12.hashCode())) * 31;
        Long l3 = this.minVersion;
        int hashCode3 = (hashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l16 = this.validPeriod;
        int hashCode4 = (hashCode3 + (l16 == null ? 0 : l16.hashCode())) * 31;
        Function0<Unit> function0 = this.onStorageNull;
        int hashCode5 = (hashCode4 + (function0 == null ? 0 : function0.hashCode())) * 31;
        Function1<e, Unit> function13 = this.beforeSetStorage;
        int hashCode6 = (hashCode5 + (function13 != null ? function13.hashCode() : 0)) * 31;
        boolean z16 = this.isUpdateImmediately;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode6 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("StorageCustom(onGetStorage=");
        m3.append(this.onGetStorage);
        m3.append(", isSuccess=");
        m3.append(this.isSuccess);
        m3.append(", minVersion=");
        m3.append(this.minVersion);
        m3.append(", validPeriod=");
        m3.append(this.validPeriod);
        m3.append(", onStorageNull=");
        m3.append(this.onStorageNull);
        m3.append(", beforeSetStorage=");
        m3.append(this.beforeSetStorage);
        m3.append(", isUpdateImmediately=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isUpdateImmediately, ')');
    }

    public /* synthetic */ StorageCustom(Function1 function1, Function1 function12, Long l3, Long l16, Function0 function0, Function1 function13, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StorageCustom(Function1<? super e, Unit> function1, Function1<? super Response, Boolean> function12, Long l3, Long l16, Function0<Unit> function0, Function1<? super e, Unit> function13, boolean z16) {
        this.onGetStorage = function1;
        this.isSuccess = function12;
        this.minVersion = l3;
        this.validPeriod = l16;
        this.onStorageNull = function0;
        this.beforeSetStorage = function13;
        this.isUpdateImmediately = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageCustom)) {
            return false;
        }
        StorageCustom storageCustom = (StorageCustom) obj;
        return Intrinsics.areEqual(this.onGetStorage, storageCustom.onGetStorage) && Intrinsics.areEqual(this.isSuccess, storageCustom.isSuccess) && Intrinsics.areEqual(this.minVersion, storageCustom.minVersion) && Intrinsics.areEqual(this.validPeriod, storageCustom.validPeriod) && Intrinsics.areEqual(this.onStorageNull, storageCustom.onStorageNull) && Intrinsics.areEqual(this.beforeSetStorage, storageCustom.beforeSetStorage) && this.isUpdateImmediately == storageCustom.isUpdateImmediately;
    }
}
