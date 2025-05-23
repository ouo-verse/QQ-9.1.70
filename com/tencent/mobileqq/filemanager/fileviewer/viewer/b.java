package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.filemanager.fileviewer.k;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends com.tencent.mobileqq.filemanager.fileviewer.viewer.a {
    private DragGallery H;
    private LinearLayout I;
    private DragView J;
    private k K;
    private RelativeLayout L;
    private ImageButton M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private DragView.OnGestureChangeListener R;

    public b(Activity activity) {
        super(activity);
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = new a();
    }

    public void A(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener != null) {
            this.H.setOnItemSelectedListener(onItemSelectedListener);
        }
    }

    public void B(boolean z16) {
        int i3;
        ImageButton imageButton = this.M;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageButton.setVisibility(i3);
    }

    public void C(List<FileBrowserModelBase.b> list) {
        this.K.b(list);
        this.K.notifyDataSetChanged();
    }

    public void D(boolean z16) {
        if (z16) {
            DragView dragView = this.J;
            if (dragView != null) {
                dragView.setOriginRect(b());
                return;
            }
            return;
        }
        DragView dragView2 = this.J;
        if (dragView2 != null) {
            dragView2.setOriginRect(null);
        }
    }

    public void E() {
        k kVar = this.K;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void f() {
        QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: PictureFileViewer initFileView");
        if (this.f208606e == null) {
            View inflate = ((LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater")).inflate(R.layout.amr, this.f208605d, false);
            this.f208606e = inflate;
            this.L = (RelativeLayout) inflate.findViewById(R.id.c_p);
            this.H = (DragGallery) this.f208606e.findViewById(R.id.gallery);
            this.M = (ImageButton) this.f208606e.findViewById(R.id.f165047bs3);
            k kVar = new k(BaseApplication.getContext());
            this.K = kVar;
            this.H.setAdapter((SpinnerAdapter) kVar);
            this.H.setOnNoBlankListener(this.K);
            this.H.setSpacing(this.f208606e.getResources().getDimensionPixelSize(R.dimen.f158920sg));
            this.I = (LinearLayout) this.f208606e.findViewById(R.id.fdo);
            this.J = (DragView) this.f208606e.findViewById(R.id.bq8);
            Rect b16 = b();
            if (b16 != null) {
                b16.top -= ImmersiveUtils.getStatusBarHeight(this.f208607f);
                b16.bottom -= ImmersiveUtils.getStatusBarHeight(this.f208607f);
            }
            this.J.setOriginRect(b16);
            this.J.setRatioModify(true);
            this.J.setGestureChangeListener(this.R);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void n(boolean z16) {
        boolean z17;
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            int i3 = 0;
            if (z16 && !this.Q) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
        this.N = z16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a
    public void o(boolean z16) {
        boolean z17;
        if (z16 && !this.Q) {
            z17 = true;
        } else {
            z17 = false;
        }
        super.o(z17);
        this.P = z16;
    }

    public void u(boolean z16) {
        Rect b16;
        if (this.J != null && (b16 = b()) != null) {
            if (!z16) {
                b16.top -= ImmersiveUtils.getStatusBarHeight(this.f208607f);
                b16.bottom -= ImmersiveUtils.getStatusBarHeight(this.f208607f);
                if (LiuHaiUtils.hasInitHasNotch && LiuHaiUtils.sHasNotch) {
                    int notchInScreenHeight = LiuHaiUtils.getNotchInScreenHeight(this.f208607f);
                    b16.top += notchInScreenHeight;
                    b16.bottom += notchInScreenHeight;
                }
            } else {
                b16.top += ImmersiveUtils.getStatusBarHeight(this.f208607f);
                b16.bottom += ImmersiveUtils.getStatusBarHeight(this.f208607f);
                if (LiuHaiUtils.hasInitHasNotch && LiuHaiUtils.sHasNotch) {
                    int notchInScreenHeight2 = LiuHaiUtils.getNotchInScreenHeight(this.f208607f);
                    b16.top -= notchInScreenHeight2;
                    b16.bottom -= notchInScreenHeight2;
                }
            }
            this.J.setOriginRect(b16);
        }
    }

    public void v() {
        this.H.reset();
    }

    public void w(int i3) {
        this.H.setSelection(i3);
    }

    public void x(View.OnClickListener onClickListener) {
        this.M.setOnClickListener(onClickListener);
    }

    public void y(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener != null) {
            this.H.setOnItemClickListener(onItemClickListener);
        }
    }

    public void z(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener != null) {
            this.H.setOnItemLongClickListener(onItemLongClickListener);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DragView.OnGestureChangeListener {
        a() {
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onContentMove(float f16) {
            Drawable background;
            b.this.Q = true;
            if (b.this.L != null && (background = b.this.L.getBackground()) != null) {
                background.mutate().setAlpha((int) (255.0f * f16));
            }
            if (f16 < 0.8f) {
                if (b.this.I != null) {
                    b.this.I.setVisibility(8);
                }
                RelativeLayout relativeLayout = b.this.f208608h;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
            }
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onGestureFinish() {
            b.this.Q = false;
            b.this.F.q();
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onResetPosition() {
            b.this.Q = false;
            if (b.this.P) {
                b.this.o(true);
            }
            if (b.this.N) {
                b.this.n(true);
            }
        }

        @Override // com.tencent.widget.DragView.OnGestureChangeListener
        public void onClickDragView() {
        }
    }
}
