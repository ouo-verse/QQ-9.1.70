package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends c {

    /* renamed from: b, reason: collision with root package name */
    public Path f68347b;

    /* renamed from: c, reason: collision with root package name */
    public int f68348c;

    /* renamed from: d, reason: collision with root package name */
    public int f68349d;

    /* renamed from: e, reason: collision with root package name */
    List<Integer> f68350e;

    /* renamed from: f, reason: collision with root package name */
    List<Integer> f68351f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<n> f68352g;

    public g(int i3, int i16) {
        super(i3);
        this.f68349d = i16;
        this.f68347b = new Path();
        this.f68350e = new LinkedList();
        this.f68351f = new LinkedList();
        this.f68352g = new ArrayList<>();
    }

    public g(c cVar, float f16) {
        super(cVar.f68320a);
        if (cVar instanceof g) {
            g gVar = (g) cVar;
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            Path path = new Path();
            this.f68347b = path;
            path.addPath(gVar.f68347b, matrix);
            this.f68320a = gVar.f68320a;
            this.f68348c = gVar.f68348c;
            this.f68349d = (int) (gVar.f68349d * f16);
        }
    }
}
