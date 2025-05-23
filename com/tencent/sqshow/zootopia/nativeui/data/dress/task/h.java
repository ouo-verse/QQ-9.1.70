package com.tencent.sqshow.zootopia.nativeui.data.dress.task;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.nativeui.ue.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import org.json.JSONObject;
import uv4.az;
import uv4.be;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B5\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lb94/d;", "dressController", "", "i", "", "toString", "", "Luv4/az;", "g", "Ljava/util/List;", "l", "()Ljava/util/List;", "dressItemList", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", "getStrategy", "()Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Z", "mIsUnderDressTask", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;", "dressTaskChannel", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lm94/i;", "callback", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/d;Ljava/lang/String;Lm94/i;Ljava/util/List;Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;)V", "j", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h extends com.tencent.sqshow.zootopia.nativeui.data.dress.task.b {

    /* renamed from: k, reason: collision with root package name */
    private static final boolean f370971k = ZPlanQQMC.INSTANCE.enableRemoveColorInfo();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final List<az> dressItemList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final NormalDressStrategy strategy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsUnderDressTask;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f370975a;

        static {
            int[] iArr = new int[NormalDressStrategy.values().length];
            try {
                iArr[NormalDressStrategy.ON_OR_OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NormalDressStrategy.ONLY_ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NormalDressStrategy.ONLY_OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f370975a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(DressTaskChannel dressTaskChannel, String taskId, m94.i callback, List<az> dressItemList, NormalDressStrategy strategy) {
        super(dressTaskChannel, taskId, callback, false, false, 24, null);
        Intrinsics.checkNotNullParameter(dressTaskChannel, "dressTaskChannel");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(dressItemList, "dressItemList");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.dressItemList = dressItemList;
        this.strategy = strategy;
    }

    public final List<az> l() {
        return this.dressItemList;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getMIsUnderDressTask() {
        return this.mIsUnderDressTask;
    }

    public String toString() {
        return "NormalDressTask, " + this.strategy + ", " + getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String() + ", dressItemList:" + r94.c.y(this.dressItemList);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.dress.task.b
    public void i(b94.d dressController) {
        int[] iArr;
        qu4.c cVar;
        az azVar;
        List list;
        Intrinsics.checkNotNullParameter(dressController, "dressController");
        HashMap hashMap = new HashMap();
        ArrayList<az> arrayList = new ArrayList<>();
        Iterator<az> it = this.dressItemList.iterator();
        do {
            iArr = null;
            if (it.hasNext()) {
                be beVar = it.next().f440290q;
                if (beVar != null) {
                    iArr = beVar.f440325b;
                }
            } else {
                HashSet<Integer> hashSet = new HashSet<>(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.x());
                HashSet hashSet2 = new HashSet();
                Iterator<az> it5 = this.dressItemList.iterator();
                while (it5.hasNext()) {
                    be beVar2 = it5.next().f440290q;
                    if ((beVar2 != null ? beVar2.f440325b : null) != null) {
                        int[] iArr2 = beVar2.f440325b;
                        Intrinsics.checkNotNullExpressionValue(iArr2, "storeItem.slot.occupancySlots");
                        list = ArraysKt___ArraysKt.toList(iArr2);
                        hashSet2.addAll(list);
                    }
                }
                hashSet.addAll(hashSet2);
                ArrayList arrayList2 = new ArrayList();
                for (az azVar2 : this.dressItemList) {
                    int[] iArr3 = azVar2.f440290q.f440325b;
                    Intrinsics.checkNotNullExpressionValue(iArr3, "storeItem.slot.occupancySlots");
                    for (int i3 : iArr3) {
                        hashMap.put(Integer.valueOf(i3), azVar2);
                    }
                    arrayList.add(azVar2);
                    if (r94.b.G(azVar2) || r94.b.F(azVar2)) {
                        az[] azVarArr = azVar2.f440289p;
                        Intrinsics.checkNotNullExpressionValue(azVarArr, "storeItem.containStoreItems");
                        if (!(azVarArr.length == 0)) {
                            arrayList2.add(azVar2);
                        }
                    }
                }
                Iterator it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    az[] subItems = ((az) it6.next()).f440289p;
                    Intrinsics.checkNotNullExpressionValue(subItems, "subItems");
                    for (az subItem : subItems) {
                        int[] iArr4 = subItem.f440290q.f440325b;
                        Intrinsics.checkNotNullExpressionValue(iArr4, "subItem.slot.occupancySlots");
                        for (int i16 : iArr4) {
                            hashSet2.add(Integer.valueOf(i16));
                            Integer valueOf = Integer.valueOf(i16);
                            Intrinsics.checkNotNullExpressionValue(subItem, "subItem");
                            hashMap.put(valueOf, subItem);
                            arrayList.add(subItem);
                        }
                    }
                }
                com.tencent.sqshow.zootopia.nativeui.data.c cVar2 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
                m94.a b16 = cVar2.m().b();
                m94.a b17 = cVar2.p().b();
                HashMap<Integer, az> hashMap2 = new HashMap<>(b16.b());
                int i17 = b.f370975a[this.strategy.ordinal()];
                if (i17 == 1) {
                    this.mIsUnderDressTask = true;
                    Iterator it7 = hashSet2.iterator();
                    while (it7.hasNext()) {
                        Integer num = (Integer) it7.next();
                        az azVar3 = hashMap2.get(num);
                        az azVar4 = (az) hashMap.get(num);
                        if (azVar3 == null || !r94.b.b(azVar3, azVar4)) {
                            this.mIsUnderDressTask = false;
                            break;
                        }
                    }
                } else if (i17 == 2) {
                    this.mIsUnderDressTask = false;
                } else if (i17 == 3) {
                    this.mIsUnderDressTask = true;
                }
                QLog.i("NormalDressTask_", 1, this + ", mIsUnderDressTask:" + this.mIsUnderDressTask);
                HashSet hashSet3 = new HashSet();
                if (this.mIsUnderDressTask) {
                    Iterator it8 = hashSet2.iterator();
                    while (it8.hasNext()) {
                        Integer num2 = (Integer) it8.next();
                        az azVar5 = (az) hashMap.get(num2);
                        if (azVar5 != null && (azVar = hashMap2.get(num2)) != null && r94.b.b(azVar, azVar5)) {
                            hashMap2.remove(num2);
                            hashSet3.add(r94.b.a(azVar5));
                        }
                    }
                    List<String> r16 = r94.b.r(this.dressItemList);
                    Iterator<Map.Entry<Integer, az>> it9 = hashMap2.entrySet().iterator();
                    while (it9.hasNext()) {
                        Map.Entry<Integer, az> next = it9.next();
                        az value = next.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                        if (!r94.b.G(value)) {
                            az value2 = next.getValue();
                            Intrinsics.checkNotNullExpressionValue(value2, "entry.value");
                            if (r94.b.F(value2)) {
                            }
                        }
                        az value3 = next.getValue();
                        Intrinsics.checkNotNullExpressionValue(value3, "entry.value");
                        if (r94.b.N(value3, r16)) {
                            it9.remove();
                        }
                    }
                    arrayList.clear();
                } else {
                    Pair<HashMap<Integer, az>, HashSet<String>> i18 = p.f371394a.i(b16.b(), hashMap);
                    hashSet3.addAll(i18.getSecond());
                    hashMap2 = i18.getFirst();
                }
                p pVar = p.f371394a;
                HashMap<Integer, az> g16 = pVar.g(hashMap2, b17.b(), hashSet, arrayList);
                if (f370971k && !this.mIsUnderDressTask && bj3.a.l(arrayList) && (cVar = b16.getAvatarCharacter().f429575d) != null) {
                    bj3.a.n(cVar, 4);
                }
                qu4.a a16 = bj3.a.a(arrayList);
                m94.a aVar = new m94.a(b16.getGender(), g16, pVar.c(a16.f429573b, a16.f429575d, b16.getAvatarCharacter(), g16));
                if (!this.mIsUnderDressTask && this.dressItemList.size() == 1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("item_id", this.dressItemList.get(0).f440275b);
                    com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, aVar, false, jSONObject, 4, null);
                    return;
                }
                com.tencent.sqshow.zootopia.nativeui.data.dress.task.b.d(this, dressController, aVar, false, null, 12, null);
                return;
            }
        } while (iArr != null);
        getCallback().a(this, DressErrorMsg.INSTANCE.e());
    }
}
