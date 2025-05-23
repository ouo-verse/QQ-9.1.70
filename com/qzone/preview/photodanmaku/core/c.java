package com.qzone.preview.photodanmaku.core;

import android.content.Context;
import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends a {

    /* renamed from: g, reason: collision with root package name */
    private final int f49966g;

    /* renamed from: h, reason: collision with root package name */
    private int f49967h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f49968i;

    /* renamed from: j, reason: collision with root package name */
    private AbsDanmaku[] f49969j;

    /* renamed from: k, reason: collision with root package name */
    private List<List<AbsDanmaku>> f49970k;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, n8.a aVar, n8.c cVar, PhotoDanmakuConfig photoDanmakuConfig, Comparator<AbsDanmaku> comparator) {
        super(context, aVar, cVar, photoDanmakuConfig, comparator);
        this.f49966g = photoDanmakuConfig.mScreenWidth;
    }

    private void l(AbsDanmaku absDanmaku) {
        if (absDanmaku.isMeasured()) {
            return;
        }
        absDanmaku.onMeasure(this.f49963e);
    }

    @Override // com.qzone.preview.photodanmaku.core.a
    public void d() {
        int size = this.f49970k.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (AbsDanmaku absDanmaku : this.f49970k.get(i3)) {
                absDanmaku.reLayout();
                absDanmaku.onDraw(this.f49963e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        r4 = true;
     */
    @Override // com.qzone.preview.photodanmaku.core.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        boolean z16;
        boolean z17;
        Iterator<AbsDanmaku> it = this.f49961c.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AbsDanmaku next = it.next();
            l(next);
            it.remove();
            if (next.isTimeOut()) {
                this.f49962d.add(next);
            } else {
                int perferredLine = next.getPerferredLine(this.f49967h);
                int i16 = Integer.MAX_VALUE;
                int i17 = perferredLine;
                while (true) {
                    z16 = true;
                    if (i17 >= this.f49967h + perferredLine) {
                        z17 = false;
                        break;
                    }
                    int i18 = i17;
                    while (true) {
                        int i19 = this.f49967h;
                        if (i18 < i19) {
                            break;
                        } else {
                            i18 -= i19;
                        }
                    }
                    AbsDanmaku[] absDanmakuArr = this.f49969j;
                    AbsDanmaku absDanmaku = absDanmakuArr[i18];
                    if (absDanmaku == null) {
                        absDanmakuArr[i18] = next;
                        this.f49970k.get(i18).add(next);
                        this.f49960b++;
                        next.layout(this.f49963e, this.f49966g, this.f49968i[i18]);
                        break;
                    }
                    int b16 = n8.b.b(absDanmaku, next, next.getTimer().a());
                    if (b16 < i16) {
                        i3 = i18;
                        i16 = b16;
                    }
                    if (i16 < 0) {
                        this.f49969j[i18] = next;
                        this.f49970k.get(i18).add(next);
                        this.f49960b++;
                        next.layout(this.f49963e, this.f49966g, this.f49968i[i18]);
                        break;
                    }
                    i17++;
                }
                if (z17 || !next.repeat(i16)) {
                    z16 = z17;
                } else {
                    this.f49969j[i3] = next;
                    this.f49970k.get(i3).add(next);
                    this.f49960b++;
                    next.layout(this.f49963e, this.f49966g, this.f49968i[i3]);
                }
                if (!z16) {
                    this.f49962d.add(next);
                }
            }
        }
    }

    @Override // com.qzone.preview.photodanmaku.core.a
    public void i() {
        int size = this.f49970k.size();
        for (int i3 = 0; i3 < size; i3++) {
            Iterator<AbsDanmaku> it = this.f49970k.get(i3).iterator();
            while (it.hasNext()) {
                AbsDanmaku next = it.next();
                l(next);
                if (next.isTimeOut() || !next.isShown()) {
                    AbsDanmaku[] absDanmakuArr = this.f49969j;
                    if (next == absDanmakuArr[i3]) {
                        absDanmakuArr[i3] = null;
                    }
                    it.remove();
                    this.f49960b--;
                    this.f49962d.add(next);
                }
            }
        }
    }

    @Override // com.qzone.preview.photodanmaku.core.a
    public void j() {
        super.j();
        if (this.f49968i == null) {
            int i3 = this.f49964f.mRowCount;
            this.f49967h = i3;
            this.f49968i = new int[i3];
            this.f49969j = new AbsDanmaku[i3];
            this.f49970k = new ArrayList();
            for (int i16 = 0; i16 < this.f49967h; i16++) {
                this.f49970k.add(new LinkedList());
            }
        }
        int q16 = (int) (PhotoDanmakuDrawer.q(this.f49964f) + 0.99999f);
        for (int i17 = 0; i17 < this.f49967h; i17++) {
            this.f49968i[i17] = (i17 * q16) + this.f49959a;
        }
    }

    @Override // com.qzone.preview.photodanmaku.core.a
    public void c() {
        for (int i3 = 0; i3 < this.f49967h; i3++) {
            this.f49969j[i3] = null;
        }
        int size = this.f49970k.size();
        for (int i16 = 0; i16 < size; i16++) {
            Iterator<AbsDanmaku> it = this.f49970k.get(i16).iterator();
            while (it.hasNext()) {
                AbsDanmaku next = it.next();
                it.remove();
                this.f49960b--;
                this.f49962d.add(next);
            }
        }
    }
}
