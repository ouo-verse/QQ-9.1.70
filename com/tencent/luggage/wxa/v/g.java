package com.tencent.luggage.wxa.v;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.v.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g extends h {

    /* renamed from: o, reason: collision with root package name */
    public static final int f142884o = v.b("Opus");

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f142885p = {79, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 72, 101, 97, 100};

    /* renamed from: n, reason: collision with root package name */
    public boolean f142886n;

    public static boolean b(l lVar) {
        int a16 = lVar.a();
        byte[] bArr = f142885p;
        if (a16 < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        lVar.a(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.tencent.luggage.wxa.v.h
    public void a(boolean z16) {
        super.a(z16);
        if (z16) {
            this.f142886n = false;
        }
    }

    @Override // com.tencent.luggage.wxa.v.h
    public long a(l lVar) {
        return b(a(lVar.f135088a));
    }

    @Override // com.tencent.luggage.wxa.v.h
    public boolean a(l lVar, long j3, h.b bVar) {
        if (!this.f142886n) {
            byte[] copyOf = Arrays.copyOf(lVar.f135088a, lVar.d());
            int i3 = copyOf[9] & 255;
            int i16 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            a(arrayList, i16);
            a(arrayList, 3840);
            bVar.f142900a = com.tencent.luggage.wxa.m.j.a(null, "audio/opus", null, -1, -1, i3, 48000, arrayList, null, 0, null);
            this.f142886n = true;
            return true;
        }
        boolean z16 = lVar.f() == f142884o;
        lVar.e(0);
        return z16;
    }

    public final void a(List list, int i3) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i3 * 1000000000) / 48000).array());
    }

    public final long a(byte[] bArr) {
        int i3;
        int i16 = bArr[0] & 255;
        int i17 = i16 & 3;
        if (i17 != 0) {
            i3 = 2;
            if (i17 != 1 && i17 != 2) {
                i3 = bArr[1] & 63;
            }
        } else {
            i3 = 1;
        }
        int i18 = i16 >> 3;
        return i3 * (i18 >= 16 ? 2500 << r1 : i18 >= 12 ? 10000 << (r1 & 1) : (i18 & 3) == 3 ? 60000 : 10000 << r1);
    }
}
