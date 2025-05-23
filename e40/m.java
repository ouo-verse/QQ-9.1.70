package e40;

import android.widget.SeekBar;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f395653a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        long f395654a;

        /* renamed from: b, reason: collision with root package name */
        long f395655b;

        a() {
        }
    }

    public String a() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.f395653a.size(); i3++) {
            a aVar = this.f395653a.get(i3);
            sb5.append(aVar.f395654a);
            sb5.append("-");
            sb5.append(aVar.f395655b);
            if (i3 != this.f395653a.size() - 1) {
                sb5.append("|");
            }
        }
        return sb5.toString();
    }

    public boolean b() {
        boolean z16;
        if (this.f395653a.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWLog.d("QFSSeekReportDataDC", RFWLog.USR, "hasSeek:" + z16);
        return z16;
    }

    public void c(SeekBar seekBar) {
        a aVar = new a();
        aVar.f395654a = seekBar.getProgress();
        this.f395653a.add(aVar);
    }

    public void d(SeekBar seekBar) {
        if (this.f395653a.size() == 0) {
            return;
        }
        this.f395653a.get(r0.size() - 1).f395655b = seekBar.getProgress();
    }
}
