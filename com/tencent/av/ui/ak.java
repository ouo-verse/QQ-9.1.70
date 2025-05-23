package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ak {

    /* renamed from: i, reason: collision with root package name */
    public static final String f75340i = "ak";

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f75341a;

    /* renamed from: b, reason: collision with root package name */
    private Context f75342b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.av.opengl.ui.c f75343c;

    /* renamed from: d, reason: collision with root package name */
    private final int f75344d = 15;

    /* renamed from: h, reason: collision with root package name */
    private int f75348h = 1000;

    /* renamed from: e, reason: collision with root package name */
    private LongSparseArray<GLVideoView> f75345e = new LongSparseArray<>(15);

    /* renamed from: f, reason: collision with root package name */
    private LongSparseArray<GLVideoView> f75346f = new LongSparseArray<>(15);

    /* renamed from: g, reason: collision with root package name */
    private LongSparseArray<GLVideoView> f75347g = new LongSparseArray<>(15);

    public ak(Context context, VideoAppInterface videoAppInterface, com.tencent.av.opengl.ui.c cVar) {
        this.f75342b = context;
        this.f75341a = videoAppInterface;
        this.f75343c = cVar;
    }

    private boolean b(ArrayList<am> arrayList, long j3) {
        Iterator<am> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().f75350b == j3) {
                return true;
            }
        }
        return false;
    }

    public GLVideoView a(long j3) {
        GLVideoView gLVideoView = this.f75345e.get(j3);
        boolean z16 = true;
        if (gLVideoView == null && (gLVideoView = this.f75347g.get(j3)) == null) {
            if (this.f75347g.size() > 0) {
                int size = this.f75347g.size() - 1;
                GLVideoView valueAt = this.f75347g.valueAt(size);
                this.f75345e.put(j3, valueAt);
                this.f75347g.removeAt(size);
                gLVideoView = valueAt;
            }
            if (gLVideoView == null) {
                gLVideoView = new GLVideoView(this.f75342b, this.f75341a, String.format("%s_%s", f75340i, 1000), 0L, false);
                gLVideoView.l1(R.drawable.n78, R.drawable.n77);
                gLVideoView.h1(String.valueOf(j3), 0);
                gLVideoView.t1(this.f75341a.getCurrentAccountUin());
                gLVideoView.L(true);
                gLVideoView.r1(false);
                int i3 = this.f75348h;
                this.f75348h = i3 + 1;
                gLVideoView.S(i3);
                gLVideoView.y1(ba.dp2px(this.f75342b, 12.0f));
                gLVideoView.k1(12);
                gLVideoView.v1(-1);
                gLVideoView.w1(true);
                gLVideoView.R(1);
                this.f75345e.put(j3, gLVideoView);
                this.f75343c.X(gLVideoView);
            }
            z16 = false;
        }
        gLVideoView.Q(2, Boolean.valueOf(z16));
        return gLVideoView;
    }

    public void c(ArrayList<am> arrayList) {
        int size = this.f75345e.size();
        if (size <= 0) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            long keyAt = this.f75345e.keyAt(i3);
            GLVideoView valueAt = this.f75345e.valueAt(i3);
            if (b(arrayList, keyAt)) {
                this.f75346f.put(keyAt, valueAt);
            } else if (this.f75347g.size() + this.f75345e.size() < 15) {
                this.f75347g.put(keyAt, valueAt);
            } else {
                this.f75343c.h0(valueAt);
            }
        }
        LongSparseArray<GLVideoView> longSparseArray = this.f75345e;
        this.f75345e = this.f75346f;
        this.f75346f = longSparseArray;
        longSparseArray.clear();
    }

    public void d() {
        this.f75345e.clear();
        this.f75346f.clear();
        this.f75347g.clear();
    }
}
