package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f337700a;

    /* renamed from: b, reason: collision with root package name */
    private int f337701b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int[] f337702c;

    public m(ViewGroup viewGroup) {
        this.f337700a = viewGroup;
    }

    public int a(int i3, int i16) {
        if (this.f337702c == null) {
            ArrayList arrayList = new ArrayList();
            for (int i17 = 0; i17 < i3; i17++) {
                arrayList.add(this.f337700a.getChildAt(i17));
            }
            Collections.sort(arrayList, new Comparator<View>() { // from class: com.tencent.mtt.hippy.uimanager.m.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(View view, View view2) {
                    Integer viewZIndex = HippyViewGroupController.getViewZIndex(view);
                    Integer num = 0;
                    if (viewZIndex == null) {
                        viewZIndex = num;
                    }
                    Integer viewZIndex2 = HippyViewGroupController.getViewZIndex(view2);
                    if (viewZIndex2 != null) {
                        num = viewZIndex2;
                    }
                    return viewZIndex.intValue() - num.intValue();
                }
            });
            this.f337702c = new int[i3];
            for (int i18 = 0; i18 < i3; i18++) {
                this.f337702c[i18] = this.f337700a.indexOfChild((View) arrayList.get(i18));
            }
        }
        int[] iArr = this.f337702c;
        if (i16 < iArr.length) {
            return iArr[i16];
        }
        LogUtils.d("VGDrawingOrderHelper", "WRONG, index out of mDrawingOrderIndices length");
        return 0;
    }

    public void b() {
        this.f337701b = 0;
        for (int i3 = 0; i3 < this.f337700a.getChildCount(); i3++) {
            if (HippyViewGroupController.getViewZIndex(this.f337700a.getChildAt(i3)) != null) {
                this.f337701b++;
            }
        }
        this.f337702c = null;
    }

    public void a(View view) {
        if (HippyViewGroupController.getViewZIndex(view) != null) {
            this.f337701b++;
        }
        this.f337702c = null;
    }

    public void b(View view) {
        if (HippyViewGroupController.getViewZIndex(view) != null) {
            this.f337701b--;
        }
        this.f337702c = null;
    }

    public boolean a() {
        return this.f337701b > 0;
    }
}
