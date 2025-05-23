package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.RegionDrawableData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.Gallery;

/* loaded from: classes10.dex */
public class ProGallery extends Gallery {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private c f184066d;

    /* renamed from: e, reason: collision with root package name */
    private int f184067e;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public ProGallery(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f184067e = 1;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.widget.Gallery, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // com.tencent.widget.Gallery, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) scaleGestureDetector)).booleanValue();
        }
        return super.onScale(scaleGestureDetector);
    }

    @Override // com.tencent.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        return super.onScroll(motionEvent, motionEvent2, f16, f17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public void onShowAreaChanged(int i3, View view, RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), view, regionDrawableData);
            return;
        }
        super.onShowAreaChanged(i3, view, regionDrawableData);
        c cVar = this.f184066d;
        if (cVar != null) {
            cVar.onShowAreaChanged(i3, view, regionDrawableData);
        }
    }

    @Override // com.tencent.widget.Gallery
    protected void onSlotChanged(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            return;
        }
        c cVar = this.f184066d;
        if (cVar != null) {
            cVar.onSlot(i3, view, viewGroup);
        }
    }

    @Override // com.tencent.widget.Gallery
    protected void onViewCreated(int i3, ViewGroup viewGroup, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), viewGroup, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        int i16 = this.f184067e;
        if (i16 != 0 && this.f184066d != null) {
            int i17 = this.mItemCount;
            int i18 = i3;
            for (int i19 = 0; i19 < i16 && i18 - 1 >= 0; i19++) {
                this.f184066d.onCreateView(i18, null, viewGroup);
            }
            int i26 = i3;
            for (int i27 = 0; i27 < i16; i27++) {
                i26++;
                if (i26 >= i17) {
                    break;
                }
                this.f184066d.onCreateView(i26, null, viewGroup);
            }
            if (!z17) {
                return;
            }
            if (z16) {
                int i28 = (i3 - i16) - 1;
                if (i28 >= 0) {
                    this.f184066d.onDestroyView(i28, null, viewGroup);
                    return;
                }
                return;
            }
            int i29 = i3 + i16 + 1;
            if (i29 < i17) {
                this.f184066d.onDestroyView(i29, null, viewGroup);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public void onViewDetached(int i3, View view, ViewGroup viewGroup, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup, Boolean.valueOf(z16));
            return;
        }
        c cVar = this.f184066d;
        if (cVar != null) {
            cVar.onViewDetached(i3, view, viewGroup, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.Gallery
    public void onZoomBegin(int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), view, viewGroup);
            return;
        }
        c cVar = this.f184066d;
        if (cVar != null) {
            cVar.onscaleBegin(i3, view, viewGroup);
        }
    }

    public void setGalleryScaleListener(ad1.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        }
    }

    public void setGestureListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    public void setOnNoBlankListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else if (cVar != this.f184066d) {
            this.f184066d = cVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0049 A[ADDED_TO_REGION, LOOP:0: B:29:0x0049->B:30:0x004b, LOOP_START, PHI: r4
  0x0049: PHI (r4v3 int) = (r4v2 int), (r4v4 int) binds: [B:28:0x0047, B:30:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.widget.AbsSpinner, com.tencent.widget.AdapterView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        super.setSelection(i3);
        int i16 = this.f184067e;
        if (i16 != 0 && this.f184066d != null) {
            int i17 = this.mItemCount;
            int i18 = this.mOldSelectedPosition;
            int i19 = i18 - i16;
            int i26 = i18 + i16;
            int i27 = 0;
            if (i19 < 0) {
                i19 = 0;
            }
            if (i26 >= i17) {
                i26 = i17 - 1;
            }
            int i28 = i3 - i16;
            int i29 = i3 + i16;
            if (i28 < 0) {
                i28 = 0;
            }
            if (i29 >= i17) {
                i29 = i17 - 1;
            }
            if (i28 <= i26 && i29 >= i19) {
                if (i28 > i19) {
                    i26 = i28 - 1;
                } else {
                    if (i29 < i26) {
                        i27 = i29 + 1;
                    } else {
                        i26 = 0;
                    }
                    if (i27 >= i26) {
                        while (i27 <= i26) {
                            this.f184066d.onDestroyView(i27, null, this);
                            i27++;
                        }
                        return;
                    }
                    return;
                }
            }
            i27 = i19;
            if (i27 >= i26) {
            }
        }
    }

    public ProGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f184067e = 1;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ProGallery(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f184067e = 1;
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
