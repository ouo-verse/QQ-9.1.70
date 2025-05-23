package am3;

import android.graphics.Color;
import com.tencent.component.core.storage.StorageCenter;
import com.tencent.mobileqq.R;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private boolean f26304b = true;

    /* renamed from: c, reason: collision with root package name */
    private int f26305c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f26306d;

    private void c(int i3, boolean z16) {
        this.f26305c = i3;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    if (this.f26304b) {
                        j(R.drawable.nkz);
                        i(-1);
                        k(R.string.yjb);
                        StorageCenter.putInt("music_play_menu", 1);
                        com.tencent.now.app.music.controller.b bVar = this.f26306d;
                        if (bVar != null && z16) {
                            bVar.j(z16);
                            return;
                        }
                        return;
                    }
                    j(R.drawable.f161938nl0);
                    i(Color.parseColor("#7AFFFFFF"));
                    k(R.string.yjb);
                    return;
                }
                return;
            }
            if (this.f26304b) {
                j(R.drawable.nkx);
                i(-1);
                k(R.string.yj6);
                StorageCenter.putInt("music_play_menu", 0);
                com.tencent.now.app.music.controller.b bVar2 = this.f26306d;
                if (bVar2 != null && z16) {
                    bVar2.l(z16);
                    return;
                }
                return;
            }
            j(R.drawable.nky);
            i(Color.parseColor("#7AFFFFFF"));
            k(R.string.yj6);
            return;
        }
        l(8);
    }

    private void e() {
        HashMap hashMap = new HashMap();
        int i3 = this.f26305c;
        if (i3 == 0) {
            hashMap.put("qqlive_music_loop_result", "2");
        } else if (i3 == 1) {
            hashMap.put("qqlive_music_loop_result", "1");
        }
        com.tencent.report.a.f364907a.d(this.f26299a, true, null, "em_qqlive_music_loop_click", hashMap);
    }

    public void d() {
        int i3 = this.f26305c + 1;
        this.f26305c = i3;
        c(i3 % 2, true);
        e();
    }

    public void f(int i3) {
        if (i3 != -1) {
            if (i3 != 2) {
                h(true);
            } else {
                h(true);
                i3 %= 2;
            }
        } else {
            h(false);
        }
        c(i3, false);
    }

    public void g(com.tencent.now.app.music.controller.b bVar) {
        this.f26306d = bVar;
    }

    public void h(boolean z16) {
        this.f26304b = z16;
        this.f26299a.setClickable(z16);
    }

    public void i(int i3) {
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
