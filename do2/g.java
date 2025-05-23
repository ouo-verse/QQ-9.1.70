package do2;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.w;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends x implements w {
    private int C;

    /* renamed from: h, reason: collision with root package name */
    public final List<y> f394370h;

    /* renamed from: i, reason: collision with root package name */
    private final String f394371i;

    /* renamed from: m, reason: collision with root package name */
    private int f394372m;

    public g(List<y> list, String str, int i3) {
        int i16;
        this.f394370h = list;
        this.f394371i = str;
        this.f394372m = i3;
        if (list != null) {
            this.C = list.size();
        }
        if (t()) {
            i16 = 4;
        } else {
            i16 = 11;
        }
        r(i16);
    }

    @Override // com.tencent.mobileqq.search.model.w
    public int getItemCount() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return nn2.a.c();
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String m() {
        return this.f394371i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f394370h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToFunctionSearchActivity(view.getContext(), this.f394371i);
        ((ISearchReportFetcher) QRoute.api(ISearchReportFetcher.class)).onReportClick898(null, 0, this.f394372m, "0X8009D4B", 0, 0, null, null);
    }

    public int s() {
        return this.f394372m;
    }

    public boolean t() {
        List<y> list = this.f394370h;
        if (list != null && list.size() == 1) {
            y yVar = this.f394370h.get(0);
            if (yVar instanceof z) {
                return ((z) yVar).B();
            }
        }
        return false;
    }
}
