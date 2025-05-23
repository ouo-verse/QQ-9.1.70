package do2;

import com.tencent.mobileqq.search.model.w;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a extends x implements w {

    /* renamed from: h, reason: collision with root package name */
    protected List<y> f394359h;

    /* renamed from: i, reason: collision with root package name */
    protected String f394360i;

    /* renamed from: m, reason: collision with root package name */
    protected int f394361m;

    public a(List<y> list, String str) {
        this.f394359h = list;
        this.f394360i = str;
        if (list != null) {
            this.f394361m = list.size();
        }
    }

    @Override // com.tencent.mobileqq.search.model.w
    public int getItemCount() {
        return this.f394361m;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String m() {
        return this.f394360i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394359h;
    }
}
