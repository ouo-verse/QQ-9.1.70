package mo3;

import androidx.lifecycle.ViewModel;
import com.tencent.now.pkgame.pkgame.pklib.model.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private e f417108i;

    public void Q1(jo3.a aVar) {
        e eVar = this.f417108i;
        if (eVar != null) {
            eVar.j().g(aVar);
        }
    }

    public void R1(@NotNull e eVar) {
        this.f417108i = eVar;
        if (eVar != null) {
            eVar.d(this);
        }
    }

    public void L1() {
    }

    public void M1() {
    }

    public void O1() {
    }

    public void N1(com.tencent.now.pkgame.pkgame.pklib.state.a aVar) {
    }

    public void P1(jo3.a aVar) {
    }
}
