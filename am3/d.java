package am3;

import android.app.Activity;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d extends a {
    private void d(int i3) {
        h(R.drawable.nl5);
        g(-1);
        i(R.string.yja);
    }

    @Override // am3.a
    public void b() {
        super.b();
    }

    public void c() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            com.tencent.mobileqq.qqlive.c.b(topActivity);
        }
        com.tencent.report.a.f364907a.a(this.f26299a, true, null, "em_qqlive_music_choose_click", new HashMap());
    }

    public void e(int i3) {
        d(i3);
    }

    public void g(int i3) {
        this.f26299a.setTextColor(i3);
    }

    public void h(int i3) {
        this.f26299a.setMenuIcon(i3);
    }

    public void i(int i3) {
        this.f26299a.setText(i3);
    }

    public void j(int i3) {
        this.f26299a.setVisibility(i3);
    }

    public void f(com.tencent.now.app.music.controller.b bVar) {
    }
}
