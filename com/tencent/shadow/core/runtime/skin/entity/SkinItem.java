package com.tencent.shadow.core.runtime.skin.entity;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SkinItem {
    private List<SkinAttr> mAttrs;
    private View mView;

    public SkinItem(View view, List<SkinAttr> list) {
        ArrayList arrayList = new ArrayList();
        this.mAttrs = arrayList;
        this.mView = view;
        arrayList.clear();
        this.mAttrs.addAll(list);
    }

    private void removeAttr(Class cls) {
        Iterator<SkinAttr> it = this.mAttrs.iterator();
        while (it.hasNext()) {
            if (it.next().getClass() == cls) {
                it.remove();
            }
        }
    }

    public void addItem(List<SkinAttr> list) {
        for (SkinAttr skinAttr : list) {
            removeAttr(skinAttr.getClass());
            this.mAttrs.add(skinAttr);
        }
    }

    public void apply() {
        List<SkinAttr> list;
        if (this.mView != null && (list = this.mAttrs) != null && !list.isEmpty()) {
            Iterator<SkinAttr> it = this.mAttrs.iterator();
            while (it.hasNext()) {
                it.next().apply(this.mView);
            }
        }
    }

    public void clean() {
        this.mView = null;
        List<SkinAttr> list = this.mAttrs;
        if (list != null) {
            list.clear();
        }
    }

    public void removeItem(List<Class> list) {
        Iterator<Class> it = list.iterator();
        while (it.hasNext()) {
            removeAttr(it.next());
        }
    }

    public String toString() {
        return "SkinItem [mView=" + this.mView.getClass().getSimpleName() + ", mAttrs=" + this.mAttrs + "]";
    }
}
