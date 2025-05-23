package l43;

import android.text.TextUtils;
import com.tencent.qqnt.chats.biz.eventprocessor.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Ll43/a;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "", "b", "", "", "", "a", "Ljava/util/Map;", "uinToHasReportedMap", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements b.InterfaceC9565b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Boolean> uinToHasReportedMap = new LinkedHashMap();

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> list) {
        b.InterfaceC9565b.a.a(this, list);
    }

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void b(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        String str;
        Object obj;
        boolean z16;
        Object obj2;
        Intrinsics.checkNotNullParameter(items, "items");
        b.InterfaceC9565b.a.b(this, items);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (true) {
            str = null;
            g gVar = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            if (b16 != null) {
                obj2 = b16.get("expo_recent_data");
            } else {
                obj2 = null;
            }
            if (obj2 instanceof g) {
                gVar = (g) obj2;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                obj = listIterator.previous();
                g gVar2 = (g) obj;
                if (gVar2.n() == 103 && Intrinsics.areEqual(gVar2.k(), "u_m9X3fOJ4pgkey0OEgpnXHQ")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        g gVar3 = (g) obj;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (gVar3 != null && (!this.uinToHasReportedMap.containsKey(str) || Intrinsics.areEqual(this.uinToHasReportedMap.get(str), Boolean.FALSE))) {
            e.f413840a.j(gVar3);
            this.uinToHasReportedMap.put(str, Boolean.TRUE);
        } else if (gVar3 == null) {
            this.uinToHasReportedMap.put(str, Boolean.FALSE);
        }
    }
}
