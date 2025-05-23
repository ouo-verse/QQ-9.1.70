package com.tencent.widget.itemtouchhelper;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ItemTouchUIUtilImpl {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Honeycomb implements ItemTouchUIUtil {
        static IPatchRedirector $redirector_;

        public Honeycomb() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchUIUtil
        public void clearView(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            }
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchUIUtil
        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, canvas, recyclerView, view, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                view.setTranslationX(f16);
                view.setTranslationY(f17);
            }
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchUIUtil
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, canvas, recyclerView, view, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchUIUtil
        public void onSelected(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Lollipop extends Honeycomb {
        static IPatchRedirector $redirector_;

        public Lollipop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private float findMaxElevation(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f16 = 0.0f;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (childAt != view) {
                    float elevation = ViewCompat.getElevation(childAt);
                    if (elevation > f16) {
                        f16 = elevation;
                    }
                }
            }
            return f16;
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchUIUtilImpl.Honeycomb, com.tencent.widget.itemtouchhelper.ItemTouchUIUtil
        public void clearView(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            Object tag = view.getTag(R.id.dr8);
            if (tag != null && (tag instanceof Float)) {
                ViewCompat.setElevation(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.dr8, null);
            super.clearView(view);
        }

        @Override // com.tencent.widget.itemtouchhelper.ItemTouchUIUtilImpl.Honeycomb, com.tencent.widget.itemtouchhelper.ItemTouchUIUtil
        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f16, float f17, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, recyclerView, view, Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            if (z16 && view.getTag(R.id.dr8) == null) {
                Float valueOf = Float.valueOf(ViewCompat.getElevation(view));
                ViewCompat.setElevation(view, findMaxElevation(recyclerView, view) + 1.0f);
                view.setTag(R.id.dr8, valueOf);
            }
            super.onDraw(canvas, recyclerView, view, f16, f17, i3, z16);
        }
    }

    public ItemTouchUIUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
