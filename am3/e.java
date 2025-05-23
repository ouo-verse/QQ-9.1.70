package am3;

import android.graphics.Color;
import com.tencent.mobileqq.R;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e extends a {

    /* renamed from: b, reason: collision with root package name */
    private int f26307b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f26308c = true;

    /* renamed from: d, reason: collision with root package name */
    private int f26309d = -1;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f26310e;

    private void c(int i3, boolean z16) {
        this.f26307b = i3;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    if (this.f26308c) {
                        j(R.drawable.nl8);
                        i(-1);
                        k(R.string.yj_);
                    } else {
                        j(R.drawable.nl9);
                        i(Color.parseColor("#7AFFFFFF"));
                        k(R.string.yj_);
                    }
                    com.tencent.now.app.music.controller.b bVar = this.f26310e;
                    if (bVar != null && z16) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f26308c) {
                j(R.drawable.nl6);
                i(-1);
                k(R.string.yj5);
            } else {
                j(R.drawable.nl7);
                i(Color.parseColor("#7AFFFFFF"));
                k(R.string.yj5);
            }
            com.tencent.now.app.music.controller.b bVar2 = this.f26310e;
            if (bVar2 != null && z16) {
                bVar2.h();
                return;
            }
            return;
        }
        h(false);
    }

    private void e() {
        HashMap hashMap = new HashMap();
        int i3 = this.f26307b;
        if (i3 == 0) {
            hashMap.put("qqlive_music_original_result", "2");
        } else if (i3 == 1) {
            hashMap.put("qqlive_music_original_result", "1");
        }
        com.tencent.report.a.f364907a.d(this.f26299a, true, null, "em_qqlive_music_original_click", hashMap);
    }

    @Override // am3.a
    public void b() {
        f(-1, 0, false);
    }

    public void d() {
        int i3 = this.f26307b + 1;
        this.f26307b = i3;
        c(i3 % 2, true);
        e();
    }

    public void f(int i3, int i16, boolean z16) {
        if (i3 != -1) {
            if (i3 != 2) {
                h(z16);
            } else {
                h(z16);
                i3 = 1;
            }
        } else {
            h(z16);
        }
        c(i3, false);
    }

    public void g(com.tencent.now.app.music.controller.b bVar) {
        this.f26310e = bVar;
    }

    public void h(boolean z16) {
        this.f26308c = z16;
        this.f26299a.setClickable(z16);
    }

    public void i(int i3) {
        this.f26309d = i3;
        this.f26299a.setTextColor(i3);
    }

    public void j(int i3) {
        this.f26299a.setMenuIcon(i3);
    }

    public void k(int i3) {
        this.f26299a.setText(i3);
    }

    public void l(int i3) {
        this.f26299a.setVisibility(i3);
    }
}
