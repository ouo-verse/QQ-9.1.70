package ep2;

import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.model.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class d extends z {
    protected String G;
    protected String H;
    protected ArrayList<String> I;
    protected CharSequence J;
    protected CharSequence K;
    protected CharSequence L;
    protected CharSequence M;
    public int N = -1;
    public int P = -1;
    public int Q = -1;
    public int R = -1;
    protected List<? extends FTSEntity> S;

    public d(String str, String str2, ArrayList<String> arrayList, List<? extends FTSEntity> list) {
        this.G = str;
        this.H = str2;
        this.I = arrayList;
        this.S = list;
    }

    public abstract CharSequence G();

    public abstract CharSequence H();

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public String s() {
        return this.G;
    }
}
