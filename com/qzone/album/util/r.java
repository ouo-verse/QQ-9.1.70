package com.qzone.album.util;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class r {

    /* renamed from: c, reason: collision with root package name */
    private int f44398c;

    /* renamed from: a, reason: collision with root package name */
    private int f44396a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f44397b = null;

    /* renamed from: d, reason: collision with root package name */
    private List<Integer> f44399d = new ArrayList();

    private void a() {
        this.f44399d.clear();
        while (true) {
            int i3 = this.f44398c;
            if (i3 >= this.f44396a) {
                return;
            }
            char charAt = this.f44397b.charAt(i3);
            if ('A' <= charAt && charAt <= 'Z') {
                this.f44399d.add(Integer.valueOf(this.f44398c));
            } else if ('a' <= charAt && charAt <= 'z') {
                this.f44399d.add(Integer.valueOf(this.f44398c));
            }
            this.f44398c++;
        }
    }

    private String[] b(int i3) {
        String substring;
        int intValue = this.f44399d.get(i3).intValue();
        int i16 = i3 + 1;
        if (i16 >= this.f44399d.size()) {
            substring = this.f44397b.substring(intValue + 1, this.f44396a);
        } else {
            substring = this.f44397b.substring(intValue + 1, this.f44399d.get(i16).intValue());
        }
        return substring.split(",");
    }

    public Path c(String str) {
        int i3;
        this.f44397b = str;
        this.f44396a = str.length();
        this.f44398c = 0;
        Path path = new Path();
        path.setFillType(Path.FillType.WINDING);
        PointF pointF = new PointF();
        a();
        for (0; i3 < this.f44399d.size(); i3 + 1) {
            char charAt = str.charAt(this.f44399d.get(i3).intValue());
            if (charAt != 'C') {
                if (charAt != 'H') {
                    if (charAt != 'Q') {
                        if (charAt != 'V') {
                            if (charAt != 'Z') {
                                if (charAt != 'c') {
                                    if (charAt != 'h') {
                                        if (charAt != 'q') {
                                            if (charAt != 'v') {
                                                if (charAt != 'z') {
                                                    if (charAt != 'L') {
                                                        if (charAt != 'M') {
                                                            if (charAt != 'S') {
                                                                if (charAt != 'T') {
                                                                    if (charAt != 'l') {
                                                                        if (charAt != 'm') {
                                                                            if (charAt != 's') {
                                                                                i3 = charAt != 't' ? i3 + 1 : 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                String[] b16 = b(i3);
                                                                path.quadTo(pointF.x, pointF.y, Float.parseFloat(b16[0]), Float.parseFloat(b16[1]));
                                                                pointF.set(Float.parseFloat(b16[0]), Float.parseFloat(b16[1]));
                                                            }
                                                            String[] b17 = b(i3);
                                                            path.cubicTo(pointF.x, pointF.y, Float.parseFloat(b17[0]), Float.parseFloat(b17[1]), Float.parseFloat(b17[2]), Float.parseFloat(b17[3]));
                                                            pointF.set(Float.parseFloat(b17[2]), Float.parseFloat(b17[3]));
                                                        }
                                                        String[] b18 = b(i3);
                                                        pointF.set(Float.parseFloat(b18[0]), Float.parseFloat(b18[1]));
                                                        path.moveTo(pointF.x, pointF.y);
                                                    }
                                                    String[] b19 = b(i3);
                                                    pointF.set(Float.parseFloat(b19[0]), Float.parseFloat(b19[1]));
                                                    path.lineTo(pointF.x, pointF.y);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            path.close();
                        }
                        pointF.set(pointF.x, Float.parseFloat(b(i3)[0]));
                        path.lineTo(pointF.x, pointF.y);
                    }
                    String[] b26 = b(i3);
                    pointF.set(Float.parseFloat(b26[2]), Float.parseFloat(b26[3]));
                    path.quadTo(Float.parseFloat(b26[0]), Float.parseFloat(b26[1]), Float.parseFloat(b26[2]), Float.parseFloat(b26[3]));
                }
                pointF.set(Float.parseFloat(b(i3)[0]), pointF.y);
                path.lineTo(pointF.x, pointF.y);
            }
            String[] b27 = b(i3);
            pointF.set(Float.parseFloat(b27[4]), Float.parseFloat(b27[5]));
            path.cubicTo(Float.parseFloat(b27[0]), Float.parseFloat(b27[1]), Float.parseFloat(b27[2]), Float.parseFloat(b27[3]), Float.parseFloat(b27[4]), Float.parseFloat(b27[5]));
        }
        return path;
    }
}
