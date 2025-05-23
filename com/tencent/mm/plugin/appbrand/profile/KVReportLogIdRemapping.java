package com.tencent.mm.plugin.appbrand.profile;

import android.util.SparseIntArray;
import com.tencent.luggage.wxa.hn.n6;
import com.tencent.luggage.wxa.hn.q4;
import com.tencent.luggage.wxa.i3.h;
import com.tencent.luggage.wxa.i3.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z8.b;
import com.tencent.mm.sdk.event.IListener;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class KVReportLogIdRemapping {

    /* renamed from: a, reason: collision with root package name */
    public static final KVReportLogIdRemapping f152267a;

    /* renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f152268b;

    static {
        KVReportLogIdRemapping kVReportLogIdRemapping = new KVReportLogIdRemapping();
        f152267a = kVReportLogIdRemapping;
        f152268b = new SparseIntArray();
        kVReportLogIdRemapping.a(y.f129448a.f());
        new IListener<h>(b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.profile.KVReportLogIdRemapping.1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(h event) {
                Intrinsics.checkNotNullParameter(event, "event");
                KVReportLogIdRemapping.f152267a.a(y.f129448a.f());
                return false;
            }
        }.alive();
    }

    public final int b(n6 n6Var) {
        Intrinsics.checkNotNullParameter(n6Var, "<this>");
        return n6Var.f128266e;
    }

    public final void a(q4 q4Var) {
        if (q4Var == null) {
            return;
        }
        LinkedList linkedList = q4Var.f128496d;
        if ((linkedList != null ? linkedList.size() : 0) > 0) {
            SparseIntArray sparseIntArray = f152268b;
            synchronized (sparseIntArray) {
                sparseIntArray.clear();
                LinkedList<n6> log_id_list = q4Var.f128496d;
                if (log_id_list != null) {
                    Intrinsics.checkNotNullExpressionValue(log_id_list, "log_id_list");
                    for (n6 n6Var : log_id_list) {
                        KVReportLogIdRemapping kVReportLogIdRemapping = f152267a;
                        Intrinsics.checkNotNullExpressionValue(n6Var, "(wxid, ilinkid)");
                        kVReportLogIdRemapping.a(f152268b, kVReportLogIdRemapping.a(n6Var), kVReportLogIdRemapping.b(n6Var));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            w.d("Luggage.KVReportLogIdRemapping", ">>>>>> onGetUpdatedRemappingInfo <<<<<<");
            LinkedList<n6> linkedList2 = q4Var.f128496d;
            Intrinsics.checkNotNullExpressionValue(linkedList2, "info.log_id_list");
            for (n6 n6Var2 : linkedList2) {
                KVReportLogIdRemapping kVReportLogIdRemapping2 = f152267a;
                Intrinsics.checkNotNullExpressionValue(n6Var2, "(wxid, ilinkid)");
                w.d("Luggage.KVReportLogIdRemapping", ">> wx_log_id:" + kVReportLogIdRemapping2.a(n6Var2) + " -> ilink_log_id:" + kVReportLogIdRemapping2.b(n6Var2));
            }
            w.d("Luggage.KVReportLogIdRemapping", ">>>>>> onGetUpdatedRemappingInfo <<<<<<");
        }
    }

    public final int a(int i3) {
        int i16;
        SparseIntArray sparseIntArray = f152268b;
        synchronized (sparseIntArray) {
            i16 = sparseIntArray.get(i3, 0);
        }
        return i16;
    }

    public final int a(n6 n6Var) {
        Intrinsics.checkNotNullParameter(n6Var, "<this>");
        return n6Var.f128265d;
    }

    public final void a(SparseIntArray sparseIntArray, int i3, int i16) {
        Intrinsics.checkNotNullParameter(sparseIntArray, "<this>");
        sparseIntArray.put(i3, i16);
    }
}
