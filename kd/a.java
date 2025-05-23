package kd;

import com.qzone.reborn.feedpro.part.h;
import com.qzone.reborn.feedx.part.ax;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import ve.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lkd/a;", "", "Lve/i;", "builder", "", "Lcom/tencent/biz/richframework/part/Part;", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {
    public List<Part> a(i builder) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.qzone.reborn.feedpro.part.d());
        arrayList.add(new com.qzone.reborn.feedpro.part.e());
        arrayList.add(new ax());
        arrayList.add(new h());
        return arrayList;
    }

    public abstract List<Part> b(i builder);

    public final List<Part> c(i builder) {
        ArrayList arrayList = new ArrayList();
        if (builder == null) {
            return arrayList;
        }
        List<Part> a16 = a(builder);
        if (a16 != null) {
            arrayList.addAll(a16);
        }
        List<Part> b16 = b(builder);
        if (b16 != null) {
            arrayList.addAll(b16);
        }
        return arrayList;
    }
}
