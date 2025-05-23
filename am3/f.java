package am3;

import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f extends am3.a {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f26311b;

    /* renamed from: c, reason: collision with root package name */
    private Eventor f26312c = new Eventor();

    /* renamed from: d, reason: collision with root package name */
    private int f26313d;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements OnEvent<com.tencent.misc.widget.a> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(com.tencent.misc.widget.a aVar) {
            f.this.d(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        this.f26313d = i3;
        if (i3 != -1) {
            if (i3 == 0 || i3 == 1) {
                k(R.drawable.nl_);
                j(-1);
                l(R.string.yjc);
                return;
            }
            return;
        }
        m(8);
    }

    private void f() {
        com.tencent.report.a.f364907a.d(this.f26299a, true, null, "em_qqlive_music_volume_click", new HashMap());
    }

    @Override // am3.a
    public void b() {
        g(0);
        this.f26312c.addOnEvent(new a());
    }

    public void e() {
        com.tencent.now.app.music.controller.b bVar = this.f26311b;
        if (bVar != null) {
            bVar.p();
            d(1);
        }
        f();
    }

    public void g(int i3) {
        if (i3 != -1) {
            i(true);
        } else {
            i(false);
        }
        d(i3);
    }

    public void h(com.tencent.now.app.music.controller.b bVar) {
        this.f26311b = bVar;
    }

    public void i(boolean z16) {
        this.f26299a.setClickable(z16);
    }

    public void j(int i3) {
        this.f26299a.setTextColor(i3);
    }

    public void k(int i3) {
        this.f26299a.setMenuIcon(i3);
    }

    public void l(int i3) {
        this.f26299a.setText(i3);
    }

    public void m(int i3) {
        this.f26299a.setVisibility(i3);
    }

    public void n() {
        Eventor eventor = this.f26312c;
        if (eventor != null) {
            eventor.removeAll();
        }
        this.f26312c = null;
        this.f26311b = null;
    }
}
