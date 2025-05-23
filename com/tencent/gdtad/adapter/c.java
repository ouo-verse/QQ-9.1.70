package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.device.AdDeviceAdapter;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements AdDeviceAdapter {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f108458a = false;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f108459b = 0;

    private static int a(Context context) {
        if (PadUtil.e(context)) {
            return 3;
        }
        DeviceType a16 = PadUtil.a(context);
        if (a16 == DeviceType.PHONE) {
            return 1;
        }
        if (a16 == DeviceType.TABLET) {
            return 2;
        }
        if (a16 == DeviceType.FOLD) {
            return 4;
        }
        return 0;
    }

    @Override // com.tencent.ad.tangram.device.AdDeviceAdapter
    public int getDeviceType(Context context) {
        if (!this.f108458a) {
            this.f108459b = a(context);
            this.f108458a = true;
        }
        return this.f108459b;
    }
}
