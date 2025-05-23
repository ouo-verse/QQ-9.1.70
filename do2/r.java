package do2;

import android.view.View;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class r extends x {

    /* renamed from: h, reason: collision with root package name */
    public int f394399h;

    /* renamed from: i, reason: collision with root package name */
    public int f394400i;

    /* renamed from: m, reason: collision with root package name */
    public int f394401m;

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String m() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return null;
    }

    public int s(int i3) {
        int i16;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = -1;
                } else {
                    i16 = this.f394401m;
                }
            } else {
                i16 = this.f394400i;
            }
        } else {
            i16 = this.f394399h;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchResultGroupModelImpl", 2, "getPosition(). type=" + i3 + "  position=" + i16);
        }
        return i16;
    }

    public void t(int i3, int i16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f394401m = i16;
                    return;
                }
                return;
            }
            this.f394400i = i16;
            return;
        }
        this.f394399h = i16;
    }

    public void u(int i3, int i16, int i17) {
        t(2, i3);
        t(1, i16);
        t(3, i17);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
    }
}
