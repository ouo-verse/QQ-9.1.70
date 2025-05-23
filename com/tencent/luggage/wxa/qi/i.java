package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static b f138882a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements b {
        @Override // com.tencent.luggage.wxa.qi.i.b
        public void a(long j3, long j16, long j17, boolean z16) {
            w.g("Luggage.RecordStat", "ID:%d, key:%d, val:%d, isImportant:%b", Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Boolean.valueOf(z16));
        }

        @Override // com.tencent.luggage.wxa.qi.i.b
        public void a(ArrayList arrayList, boolean z16) {
            w.g("Luggage.RecordStat", "lstIdKeyDataInfos:%s, isImportant:%b", arrayList, Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(long j3, long j16, long j17, boolean z16);

        void a(ArrayList arrayList, boolean z16);
    }

    public static void a(b bVar) {
        f138882a = bVar;
    }

    public static void b(int i3) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(689);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(689);
        iDKey2.SetKey(h.a(i3));
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        f138882a.a(arrayList, true);
    }

    public static void a() {
        f138882a.a(689L, 0L, 1L, true);
    }

    public static void a(int i3) {
        f138882a.a(689L, h.a(i3), 1L, true);
    }
}
