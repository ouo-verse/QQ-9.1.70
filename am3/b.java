package am3;

import android.graphics.Color;
import com.tencent.mobileqq.R;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends a {

    /* renamed from: e, reason: collision with root package name */
    private static final int f26300e = 2131886380;

    /* renamed from: b, reason: collision with root package name */
    private int f26301b;

    /* renamed from: c, reason: collision with root package name */
    private int f26302c = f26300e;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f26303d;

    private void d(int i3, boolean z16) {
        this.f26301b = i3;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 == 1) {
                    h(R.drawable.f161941nl3);
                    g(-1);
                    i(R.string.yj9);
                    com.tencent.now.app.music.controller.b bVar = this.f26303d;
                    if (bVar != null && z16) {
                        bVar.setNoLyricsMode();
                        return;
                    }
                    return;
                }
                return;
            }
            h(R.drawable.f161940nl2);
            g(-1);
            i(R.string.yj8);
            com.tencent.now.app.music.controller.b bVar2 = this.f26303d;
            if (bVar2 != null && z16) {
                bVar2.c();
                return;
            }
            return;
        }
        h(R.drawable.f161942nl4);
        g(Color.parseColor("#7AFFFFFF"));
        i(R.string.yj9);
        com.tencent.now.app.music.controller.b bVar3 = this.f26303d;
        if (bVar3 != null && z16) {
            bVar3.setNoLyricsMode();
        }
    }

    private void e() {
        HashMap hashMap = new HashMap();
        int i3 = this.f26301b;
        if (i3 == 0) {
            hashMap.put("qqlive_music_lyric_result", "1");
        } else if (i3 == 1) {
            hashMap.put("qqlive_music_lyric_result", "2");
        }
        com.tencent.report.a.f364907a.d(this.f26299a, true, null, "em_qqlive_music_lyric_click", hashMap);
    }

    @Override // am3.a
    public void b() {
        f(-1);
    }

    public void c() {
        int i3 = this.f26301b;
        if (i3 == -1) {
            return;
        }
        int i16 = i3 + 1;
        this.f26301b = i16;
        d(i16 % 2, true);
        e();
    }

    public void f(int i3) {
        d(i3 % 2, false);
    }

    public void g(int i3) {
        this.f26299a.setTextColor(i3);
    }

    public void h(int i3) {
        this.f26299a.setMenuIcon(i3);
    }

    public void i(int i3) {
        this.f26302c = i3;
        this.f26299a.setText(i3);
    }

    public void j(int i3) {
        this.f26299a.setVisibility(i3);
    }

    public void k(com.tencent.now.app.music.controller.b bVar) {
        this.f26303d = bVar;
    }
}
