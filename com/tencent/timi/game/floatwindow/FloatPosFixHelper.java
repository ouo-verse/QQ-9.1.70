package com.tencent.timi.game.floatwindow;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import vh4.d;

/* loaded from: classes26.dex */
public class FloatPosFixHelper {

    /* renamed from: b, reason: collision with root package name */
    private int f377040b;

    /* renamed from: c, reason: collision with root package name */
    private int f377041c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, FloatPosItem> f377039a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f377042d = ViewUtils.dip2px(6.0f);

    /* loaded from: classes26.dex */
    public static class FloatPosItem implements Serializable {
        public int centerX;
        public int centerY;
        public String key;
        public int side;
        public int sizeH;
    }

    public FloatPosFixHelper(int i3, int i16) {
        this.f377040b = i16;
        this.f377041c = i3;
    }

    private FloatPosItem a(FloatPosItem floatPosItem, FloatPosItem floatPosItem2, List<FloatPosItem> list) {
        FloatPosItem h16;
        if (floatPosItem != null && floatPosItem2 != null && list != null && (h16 = h(floatPosItem, floatPosItem2, list, floatPosItem.centerY, i(floatPosItem, floatPosItem2, list, true))) != null) {
            return h16;
        }
        return null;
    }

    private void d(List<FloatPosItem> list, ArrayList<FloatPosItem> arrayList, Map.Entry<String, FloatPosItem> entry) {
        for (FloatPosItem floatPosItem : list) {
            if (e(floatPosItem, entry.getValue())) {
                FloatPosItem a16 = a(entry.getValue(), floatPosItem, arrayList);
                if (a16 != null) {
                    arrayList.add(a16);
                    b(a16);
                    return;
                }
                Iterator<FloatPosItem> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FloatPosItem a17 = a(entry.getValue(), it.next(), arrayList);
                    if (a17 != null) {
                        arrayList.add(a17);
                        b(a17);
                        break;
                    }
                }
                arrayList.add(entry.getValue());
            }
        }
    }

    private boolean e(FloatPosItem floatPosItem, FloatPosItem floatPosItem2) {
        if (floatPosItem != null && floatPosItem2 != null && floatPosItem.side == floatPosItem2.side) {
            int i3 = floatPosItem.centerY;
            int i16 = floatPosItem.sizeH;
            float f16 = i3 - (i16 * 0.5f);
            float f17 = i3 + (i16 * 0.5f);
            int i17 = floatPosItem2.centerY;
            int i18 = floatPosItem2.sizeH;
            float f18 = i17 - (i18 * 0.5f);
            if (f16 <= i17 + (i18 * 0.5f) && f17 >= f18) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    private FloatPosItem h(FloatPosItem floatPosItem, FloatPosItem floatPosItem2, List<FloatPosItem> list, int i3, boolean z16) {
        if (!z16) {
            float f16 = floatPosItem2.centerY + (floatPosItem2.sizeH * 0.5f) + this.f377042d;
            int i16 = floatPosItem.sizeH;
            int i17 = (int) (f16 + (i16 * 0.5f));
            floatPosItem.centerY = i17;
            if (i17 + (i16 * 0.5f) < this.f377040b) {
                Iterator<FloatPosItem> it = list.iterator();
                while (it.hasNext() && !e(floatPosItem, it.next())) {
                }
                z16 = true;
            }
        }
        if (!z16) {
            floatPosItem.centerY = i3;
            return null;
        }
        return floatPosItem;
    }

    private boolean i(FloatPosItem floatPosItem, FloatPosItem floatPosItem2, List<FloatPosItem> list, boolean z16) {
        float f16 = (floatPosItem2.centerY - (floatPosItem2.sizeH * 0.5f)) - this.f377042d;
        int i3 = floatPosItem.sizeH;
        int i16 = (int) (f16 - (i3 * 0.5f));
        floatPosItem.centerY = i16;
        if (i16 - (i3 * 0.5f) <= this.f377041c) {
            return false;
        }
        Iterator<FloatPosItem> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (e(floatPosItem, it.next())) {
                z16 = false;
                break;
            }
        }
        return z16;
    }

    public void b(FloatPosItem floatPosItem) {
        d.INSTANCE.a().e(floatPosItem);
    }

    public FloatPosItem c(String str) {
        return this.f377039a.get(str);
    }

    public void f(FloatPosItem floatPosItem) {
        if (floatPosItem != null) {
            this.f377039a.put(floatPosItem.key, floatPosItem);
        }
    }

    public void g(List<FloatPosItem> list, boolean z16) {
        boolean z17;
        if (list == null) {
            return;
        }
        ArrayList<FloatPosItem> arrayList = new ArrayList<>(list);
        for (Map.Entry<String, FloatPosItem> entry : this.f377039a.entrySet()) {
            Iterator<FloatPosItem> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (TextUtils.equals(it.next().key, entry.getKey())) {
                        z17 = true;
                        break;
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
            if (!z17) {
                d(list, arrayList, entry);
            }
        }
        if (z16) {
            d.INSTANCE.a().h();
        }
    }
}
