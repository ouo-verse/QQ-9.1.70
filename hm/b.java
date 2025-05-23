package hm;

import androidx.lifecycle.MutableLiveData;
import com.qzone.common.event.ui.model.PublishEventTag;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends ql.a {
    private String K;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Long> f405275m = new MutableLiveData<>(0L);
    private final MutableLiveData<Long> C = new MutableLiveData<>(0L);
    private final MutableLiveData<Integer> D = new MutableLiveData<>(0);
    public final MutableLiveData<Boolean> E = new MutableLiveData<>(Boolean.FALSE);
    public final MutableLiveData<Integer> F = new MutableLiveData<>(1);
    private final MutableLiveData<Boolean> G = new MutableLiveData<>();
    private final MutableLiveData<Boolean> H = new MutableLiveData<>();
    private final MutableLiveData<PublishEventTag> I = new MutableLiveData<>(null);
    private final MutableLiveData<String> J = new MutableLiveData<>("");
    public final MutableLiveData<ArrayList<String>> L = new MutableLiveData<>(new ArrayList());

    @Override // ql.a
    public boolean M1() {
        return false;
    }

    public MutableLiveData<PublishEventTag> O1() {
        return this.I;
    }

    public MutableLiveData<String> P1() {
        return this.J;
    }

    public MutableLiveData<Boolean> Q1() {
        return this.H;
    }

    public MutableLiveData<Boolean> R1() {
        return this.G;
    }

    public MutableLiveData<Boolean> S1() {
        return this.E;
    }

    public MutableLiveData<Integer> T1() {
        return this.F;
    }

    public int U1() {
        return this.F.getValue().intValue();
    }

    public MutableLiveData<ArrayList<String>> W1() {
        return this.L;
    }

    public MutableLiveData<Long> X1() {
        return this.C;
    }

    public MutableLiveData<Long> Z1() {
        return this.f405275m;
    }

    public MutableLiveData<Integer> a2() {
        return this.D;
    }

    public String b2() {
        return this.K;
    }

    public boolean c2() {
        return this.f405275m.getValue().longValue() > 0 || this.C.getValue().longValue() > 0;
    }

    public boolean d2() {
        return U1() == 64;
    }

    public boolean e2() {
        return U1() == 1;
    }

    public boolean f2() {
        return 1 == this.D.getValue().intValue();
    }

    public void g2(String str) {
        this.K = str;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZonePublishMoodSettingViewModel";
    }
}
