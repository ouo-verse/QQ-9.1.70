package com.tencent.luggage.wxa.t6;

import android.os.Parcel;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001J#\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/luggage/wxa/t6/f;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/p6/d;", "Landroid/os/Parcel;", "parcel", "Lcom/tencent/luggage/wxa/r5/a;", "a", "configParcel", "Lcom/tencent/luggage/wxa/d6/b;", "action", "Lcom/tencent/luggage/wxa/bk/e;", "stat", "Lcom/tencent/luggage/wxa/j4/d;", DownloadInfo.spKey_Config, "", "<init>", "()V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.eo.d implements com.tencent.luggage.wxa.p6.d {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.tencent.luggage.wxa.p6.e f140875h = new com.tencent.luggage.wxa.p6.e();

    @Override // com.tencent.luggage.wxa.p6.d
    public com.tencent.luggage.wxa.r5.a a(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return this.f140875h.a(parcel);
    }

    @Override // com.tencent.luggage.wxa.p6.d
    public com.tencent.luggage.wxa.r5.a a(Parcel configParcel, com.tencent.luggage.wxa.d6.b action, com.tencent.luggage.wxa.bk.e stat) {
        Intrinsics.checkNotNullParameter(configParcel, "configParcel");
        Intrinsics.checkNotNullParameter(action, "action");
        return this.f140875h.a(configParcel, action, stat);
    }

    @Override // com.tencent.luggage.wxa.p6.d
    public void a(com.tencent.luggage.wxa.j4.d config, com.tencent.luggage.wxa.d6.b action, com.tencent.luggage.wxa.bk.e stat) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(action, "action");
        this.f140875h.a(config, action, stat);
    }
}
