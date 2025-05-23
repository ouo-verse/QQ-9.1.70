package p70;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.richframework.data.idata.IDataDisplaySurface;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a extends com.tencent.biz.qqcircle.viewmodels.a implements IDataDisplaySurface<e30.b>, SimpleEventReceiver {

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.immersive.views.search.util.h f425447m = new com.tencent.biz.qqcircle.immersive.views.search.util.h();

    public void L1() {
        this.f425447m.e();
    }

    public MutableLiveData<String> M1() {
        return this.f425447m.b();
    }

    public int N1(String str) {
        return this.f425447m.c(str);
    }

    public void O1(Context context) {
        this.f425447m.a(context);
    }

    public void P1(String str) {
        this.f425447m.f(str);
    }

    public void Q1(String str) {
        this.f425447m.g(str);
    }

    public void R1(String str, int i3) {
        this.f425447m.h(str, i3);
    }
}
