package o94;

import b94.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskChannel;
import com.tencent.sqshow.zootopia.nativeui.ue.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.i;
import qu4.j;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lo94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "Lm94/a;", "l", "Lb94/d;", "dressController", "", "i", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", "", "taskName", "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Ljava/lang/String;Lm94/i;)V", "g", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a extends com.tencent.sqshow.zootopia.nativeui.data.dress.task.b {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f422266h = new AtomicInteger(0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(DressTaskChannel dressTaskChannel, String taskName, i callback) {
        super(dressTaskChannel, taskName + "-" + f422266h.getAndIncrement(), callback, false, false, 24, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(d dressController) {
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        m94.a b16 = cVar.m().b();
        HashSet<Integer> x16 = cVar.x();
        m94.a l3 = l();
        Map<Integer, az> b17 = b16.b();
        Map<Integer, az> b18 = l3.b();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<T> it = b17.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            x16.add(entry.getKey());
            if (r94.b.G((az) entry.getValue()) || r94.b.C((az) entry.getValue())) {
                hashMap.put(entry.getKey(), entry.getValue());
                hashMap2.put(entry.getKey(), r94.b.a((az) entry.getValue()));
            }
        }
        ArrayList arrayList = new ArrayList();
        Collection<az> values = b18.values();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : values) {
            if (r94.b.z((az) obj)) {
                arrayList2.add(obj);
            }
        }
        p.f371394a.f(hashMap, r94.b.n(arrayList2));
        HashSet hashSet = new HashSet();
        Iterator<T> it5 = b18.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it5.next();
            x16.add(entry2.getKey());
            if (r94.b.z((az) entry2.getValue())) {
                String str = (String) hashMap2.get(entry2.getKey());
                if (str != null) {
                    hashSet.add(str);
                }
                hashMap.put(entry2.getKey(), entry2.getValue());
                arrayList.add(entry2.getValue());
            }
        }
        QLog.i("ResetDressBaseTask_", 1, "dressOffItem :" + hashSet);
        Map<Integer, az> b19 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.p().b().b();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry3 : hashMap.entrySet()) {
            if (hashSet.contains(r94.b.a((az) entry3.getValue()))) {
                az azVar = b19.get(entry3.getKey());
                if (azVar != null) {
                    hashMap3.put(entry3.getKey(), azVar);
                    arrayList.add(azVar);
                }
            } else {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
        }
        HashMap<Integer, az> g16 = p.f371394a.g(hashMap3, b19, x16, arrayList);
        Collection<az> values2 = g16.values();
        Intrinsics.checkNotNullExpressionValue(values2, "finalDressMap.values");
        qu4.a a16 = bj3.a.a(values2);
        qu4.a a17 = bj3.a.a(arrayList);
        qu4.a h16 = bj3.a.h(b16.getAvatarCharacter());
        a16.f429576e = h16.f429576e;
        j jVar = a16.f429573b;
        Intrinsics.checkNotNullExpressionValue(jVar, "newAvatar.faceInfo");
        bj3.a.f(jVar, h16.f429573b);
        j jVar2 = a16.f429573b;
        Intrinsics.checkNotNullExpressionValue(jVar2, "newAvatar.faceInfo");
        bj3.a.f(jVar2, a17.f429573b);
        qu4.c cVar2 = a16.f429575d;
        Intrinsics.checkNotNullExpressionValue(cVar2, "newAvatar.colorInfo");
        bj3.a.e(cVar2, h16.f429575d);
        qu4.c cVar3 = a16.f429575d;
        Intrinsics.checkNotNullExpressionValue(cVar3, "newAvatar.colorInfo");
        bj3.a.e(cVar3, a17.f429575d);
        com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, new m94.a(b16.getGender(), g16, a16), false, null, 12, null);
    }

    public abstract m94.a l();
}
