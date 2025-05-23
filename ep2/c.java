package ep2;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class c extends z {
    protected FTSEntity G;
    protected String H;
    protected ArrayList<String> I;
    protected CharSequence J;
    protected CharSequence K;
    protected CharSequence L;
    private CharSequence M;

    public c(AppInterface appInterface, String str, ArrayList<String> arrayList, FTSEntity fTSEntity) {
        this.H = str;
        this.I = arrayList;
        this.G = fTSEntity;
    }

    public AppInterface G() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public abstract CharSequence H();

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeywords() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitle() {
        if (this.M == null) {
            FTSEntity fTSEntity = this.G;
            this.M = SearchUtils.Y(fTSEntity.mContent, fTSEntity.mProximityStart, this.I);
        }
        return this.M;
    }
}
