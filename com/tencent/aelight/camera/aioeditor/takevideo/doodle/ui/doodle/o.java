package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class o extends c {

    /* renamed from: b, reason: collision with root package name */
    public Path f68427b;

    /* renamed from: c, reason: collision with root package name */
    public int f68428c;

    /* renamed from: d, reason: collision with root package name */
    public int f68429d;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<n> f68430e;

    public o(Path path, int i3, int i16, int i17) {
        super(i3);
        this.f68427b = path;
        this.f68428c = i16;
        this.f68429d = i17;
        this.f68430e = new ArrayList<>();
    }

    public o(c cVar, float f16) {
        super(cVar.f68320a);
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            Matrix matrix = new Matrix();
            matrix.postScale(f16, f16);
            Path path = new Path();
            this.f68427b = path;
            path.addPath(oVar.f68427b, matrix);
            this.f68320a = oVar.f68320a;
            this.f68428c = oVar.f68428c;
            this.f68429d = (int) (oVar.f68429d * f16);
        }
    }
}
