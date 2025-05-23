package com.tencent.mtt.hippy.uimanager;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qqmini.miniapp.widget.CanvasView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f337698a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<double[]> f337699b = new ThreadLocal<double[]>() { // from class: com.tencent.mtt.hippy.uimanager.l.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public double[] initialValue() {
            return new double[16];
        }
    };

    private static double a(HippyMap hippyMap, String str) {
        double doubleValue;
        boolean z16 = true;
        if (hippyMap.get(str) instanceof String) {
            String str2 = (String) hippyMap.get(str);
            z16 = true ^ str2.endsWith("deg");
            if (str2.endsWith("rad") || str2.endsWith("deg")) {
                str2 = str2.substring(0, str2.length() - 3);
            }
            doubleValue = Float.parseFloat(str2);
        } else {
            doubleValue = hippyMap.get(str) instanceof Number ? ((Number) hippyMap.get(str)).doubleValue() : 0.0d;
        }
        return z16 ? doubleValue : g.b(doubleValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(HippyArray hippyArray, double[] dArr) {
        double d16;
        double d17;
        double d18;
        double doubleValue;
        double[] dArr2 = f337699b.get();
        g.e(dArr);
        int size = hippyArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            HippyMap map = hippyArray.getMap(i3);
            String next = map.keySet().iterator().next();
            if (!f337698a && dArr2 == null) {
                throw new AssertionError();
            }
            g.e(dArr2);
            Object obj = map.get(next);
            if ("matrix".equals(next) && (obj instanceof HippyArray)) {
                HippyArray hippyArray2 = (HippyArray) obj;
                for (int i16 = 0; i16 < 16; i16++) {
                    Object object = hippyArray2.getObject(i16);
                    if (object instanceof Number) {
                        dArr2[i16] = ((Number) object).doubleValue();
                    }
                }
            } else if ("perspective".equals(next) && (obj instanceof Number)) {
                g.b(dArr2, ((Number) obj).doubleValue());
            } else if ("rotateX".equals(next)) {
                g.g(dArr2, a(map, next));
            } else if ("rotateY".equals(next)) {
                g.h(dArr2, a(map, next));
            } else if (CanvasView.ACTION_ROTATE.equals(next) || "rotateZ".equals(next)) {
                g.i(dArr2, a(map, next));
            } else {
                if ("scale".equals(next) && (obj instanceof Number)) {
                    doubleValue = ((Number) obj).doubleValue();
                    g.c(dArr2, doubleValue);
                } else if (BasicAnimation.KeyPath.SCALE_X.equals(next) && (obj instanceof Number)) {
                    g.c(dArr2, ((Number) obj).doubleValue());
                } else if (BasicAnimation.KeyPath.SCALE_Y.equals(next)) {
                    doubleValue = ((Number) obj).doubleValue();
                } else if (CanvasView.ACTION_TRANSLATE.equals(next) && (obj instanceof HippyArray)) {
                    HippyArray hippyArray3 = (HippyArray) obj;
                    if (hippyArray3.size() > 0) {
                        Object object2 = hippyArray3.getObject(0);
                        if (object2 instanceof Number) {
                            d16 = ((Number) object2).doubleValue();
                            if (hippyArray3.size() > 1) {
                                Object object3 = hippyArray3.getObject(1);
                                if (object3 instanceof Number) {
                                    d17 = ((Number) object3).doubleValue();
                                    if (hippyArray3.size() > 2) {
                                        Object object4 = hippyArray3.getObject(2);
                                        if (object4 instanceof Number) {
                                            d18 = ((Number) object4).doubleValue();
                                            g.a(dArr2, d16, d17, d18);
                                        }
                                    }
                                    d18 = 0.0d;
                                    g.a(dArr2, d16, d17, d18);
                                }
                            }
                            d17 = 0.0d;
                            if (hippyArray3.size() > 2) {
                            }
                            d18 = 0.0d;
                            g.a(dArr2, d16, d17, d18);
                        }
                    }
                    d16 = 0.0d;
                    if (hippyArray3.size() > 1) {
                    }
                    d17 = 0.0d;
                    if (hippyArray3.size() > 2) {
                    }
                    d18 = 0.0d;
                    g.a(dArr2, d16, d17, d18);
                } else if ("translateX".equals(next) && (obj instanceof Number)) {
                    g.a(dArr2, ((Number) obj).doubleValue(), 0.0d);
                } else if ("translateY".equals(next) && (obj instanceof Number)) {
                    g.a(dArr2, 0.0d, ((Number) obj).doubleValue());
                } else if ("skewX".equals(next)) {
                    g.e(dArr2, a(map, next));
                } else if ("skewY".equals(next)) {
                    g.f(dArr2, a(map, next));
                } else {
                    new RuntimeException("Unsupported transform type: " + next).printStackTrace();
                }
                g.d(dArr2, doubleValue);
            }
            g.a(dArr, dArr, dArr2);
        }
    }
}
