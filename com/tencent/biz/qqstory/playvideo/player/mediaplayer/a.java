package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<c> f94178a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private d f94179b;

    /* renamed from: c, reason: collision with root package name */
    private b f94180c;

    public void a(c cVar) {
        this.f94178a.add(cVar);
        if (cVar instanceof d) {
            this.f94179b = (d) cVar;
        } else if (cVar instanceof b) {
            this.f94180c = (b) cVar;
        }
    }

    public c.a b(boolean z16) {
        while (true) {
            for (boolean z17 = false; !z17; z17 = true) {
                int i3 = 0;
                c.a aVar = null;
                for (c cVar : this.f94178a) {
                    while (true) {
                        c.a c16 = cVar.c();
                        if (c16 == null) {
                            break;
                        }
                        if (cVar == this.f94179b) {
                            aVar = c16;
                            break;
                        }
                        cVar.t(c16, 0L);
                    }
                    do {
                    } while (cVar.n(false));
                    if (cVar.k()) {
                        i3++;
                    }
                }
                if (aVar != null) {
                    return aVar;
                }
                if (!z16) {
                    return null;
                }
                if (i3 == this.f94178a.size()) {
                }
            }
            Log.d("Decoders", "EOS NULL");
            return null;
        }
    }

    public void c() {
        Iterator<c> it = this.f94178a.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public long d() {
        Iterator<c> it = this.f94178a.iterator();
        long j3 = Long.MAX_VALUE;
        while (it.hasNext()) {
            j3 = Math.min(it.next().f(), j3);
        }
        if (j3 == Long.MAX_VALUE) {
            return -1L;
        }
        return j3;
    }

    public long e() {
        Iterator<c> it = this.f94178a.iterator();
        long j3 = Long.MAX_VALUE;
        while (it.hasNext()) {
            long h16 = it.next().h();
            if (h16 != Long.MIN_VALUE && j3 > h16) {
                j3 = h16;
            }
        }
        return j3;
    }

    public List<c> f() {
        return this.f94178a;
    }

    public d g() {
        return this.f94179b;
    }

    public boolean h() {
        Iterator<c> it = this.f94178a.iterator();
        while (it.hasNext()) {
            if (!it.next().j()) {
                return false;
            }
        }
        return true;
    }

    public boolean i() {
        Iterator<c> it = this.f94178a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().k()) {
                i3++;
            }
        }
        if (i3 != this.f94178a.size()) {
            return false;
        }
        return true;
    }

    public void j() {
        Iterator<c> it = this.f94178a.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
        this.f94178a.clear();
    }

    public void k() {
        Iterator<c> it = this.f94178a.iterator();
        while (it.hasNext()) {
            it.next().s();
        }
    }

    public void l(MediaPlayer.c cVar, long j3) throws IOException {
        Iterator<c> it = this.f94178a.iterator();
        while (it.hasNext()) {
            it.next().v(cVar, j3);
        }
    }
}
