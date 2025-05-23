package com.tencent.luggage.wxa.q7;

import android.os.Parcel;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements Parceler {

    /* renamed from: a, reason: collision with root package name */
    public static final d f137947a = new d();

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WxaExtendApiJSBridge.ErrMsg[] newArray(int i3) {
        return (WxaExtendApiJSBridge.ErrMsg[]) Parceler.DefaultImpls.newArray(this, i3);
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public WxaExtendApiJSBridge.ErrMsg create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        for (WxaExtendApiJSBridge.ErrMsg errMsg : WxaExtendApiJSBridge.ErrMsg.values()) {
            if (readInt == errMsg.ordinal()) {
                return errMsg;
            }
        }
        return null;
    }

    @Override // kotlinx.parcelize.Parceler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void write(WxaExtendApiJSBridge.ErrMsg errMsg, Parcel parcel, int i3) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (errMsg == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(errMsg.ordinal());
        }
    }
}
