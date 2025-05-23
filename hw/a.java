package hw;

import com.tencent.av.ui.QavListItemBase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f406498a;

    /* renamed from: b, reason: collision with root package name */
    public String f406499b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f406500c = true;

    /* renamed from: d, reason: collision with root package name */
    public List<QavListItemBase.c> f406501d = new ArrayList();

    public String toString() {
        Object valueOf;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MaterialCategory{categoryId = ");
        sb5.append(this.f406498a);
        sb5.append("categoryName = ");
        sb5.append(this.f406499b);
        sb5.append("materialList size = ");
        List<QavListItemBase.c> list = this.f406501d;
        if (list == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        sb5.append("}");
        return sb5.toString();
    }
}
