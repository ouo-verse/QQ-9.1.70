package l70;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final com.tencent.rfw.barrage.core.c f413904a;

    /* renamed from: b, reason: collision with root package name */
    protected float f413905b = 1.0f;

    public b(com.tencent.rfw.barrage.core.c cVar) {
        this.f413904a = cVar;
    }

    public abstract com.tencent.rfw.barrage.data.a a(T t16, int i3);

    /* JADX WARN: Multi-variable type inference failed */
    public List<com.tencent.rfw.barrage.data.a> b(@NonNull List<T> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.rfw.barrage.data.a a16 = a(RFSafeListUtils.get(list, i3), i3);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    public void c(float f16) {
        this.f413905b = f16;
    }
}
