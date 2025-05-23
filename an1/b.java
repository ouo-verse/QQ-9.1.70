package an1;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import uo0.k;
import wh2.br;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b extends k {

    /* renamed from: c, reason: collision with root package name */
    private final AppRuntime f26334c;

    /* renamed from: d, reason: collision with root package name */
    private final String f26335d;

    /* renamed from: e, reason: collision with root package name */
    private List<IGProChannel> f26336e;

    public b(@NonNull AppRuntime appRuntime, @NonNull String str) {
        this.f26334c = appRuntime;
        this.f26335d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(ArrayList arrayList) {
        this.f26336e = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IGProCategoryChannelInfoList iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) it.next();
                if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
                    this.f26336e.addAll(iGProCategoryChannelInfoList.getChannelInfoList());
                } else {
                    Iterator<IGProChannel> it5 = iGProCategoryChannelInfoList.getChannelInfoList().iterator();
                    while (it5.hasNext()) {
                        IGProChannel next = it5.next();
                        if (next.getHiddenPostChannel() == 1 && next.getChannelType() == 7) {
                            this.f26336e.add(0, next);
                        }
                    }
                }
            }
        }
        d();
    }

    @Override // uo0.k
    public String f() {
        return this.f26335d;
    }

    @Override // uo0.k
    public String h() {
        return null;
    }

    @Override // uo0.k
    public List<IGProChannel> i() {
        return this.f26336e;
    }

    @Override // uo0.k
    public void m() {
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(this.f26335d));
        bdVar.h(false);
        bdVar.j(false);
        bdVar.i(false);
        ((IGPSService) this.f26334c.getRuntimeService(IGPSService.class, "")).getCategoryChannelInfoListV2(bdVar, new br() { // from class: an1.a
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                b.this.p(arrayList);
            }
        });
    }
}
