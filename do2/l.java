package do2;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l extends x {

    /* renamed from: m, reason: collision with root package name */
    public static final String f394384m = HardCodeUtil.qqStr(R.string.n5y);

    /* renamed from: h, reason: collision with root package name */
    private final List<y> f394385h;

    /* renamed from: i, reason: collision with root package name */
    private final String f394386i;

    public l(List<y> list, String str) {
        this.f394385h = list;
        this.f394386i = str;
        r(2);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return f394384m;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String m() {
        return this.f394386i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394385h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
    }
}
