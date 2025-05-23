package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.doodle.DoodleView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ag;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoodleLayout extends RelativeLayout implements com.tencent.mobileqq.scribble.b {

    /* renamed from: d, reason: collision with root package name */
    private DoodleView f178358d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f178359e;

    /* renamed from: f, reason: collision with root package name */
    private int f178360f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f178361h;

    /* renamed from: i, reason: collision with root package name */
    private QQToast f178362i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DoodleView.b {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.DoodleView.b
        public void a() {
            DoodleLayout.a(DoodleLayout.this);
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.DoodleView.b
        public void b(int i3, int i16) {
            DoodleLayout.a(DoodleLayout.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
    }

    public DoodleLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f178360f = 0;
        g();
    }

    static /* synthetic */ b a(DoodleLayout doodleLayout) {
        doodleLayout.getClass();
        return null;
    }

    private Drawable f(int i3, int i16) {
        ag agVar = new ag(d(), 0, false);
        agVar.setBounds(new Rect(0, 0, i3, i16));
        return agVar;
    }

    private void g() {
        if (this.f178359e == null) {
            this.f178359e = new ImageView(getContext());
            this.f178359e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            addView(this.f178359e);
        }
        if (this.f178358d == null) {
            this.f178358d = new DoodleView(getContext(), null);
            this.f178358d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f178358d.setBackgroundColor(getResources().getColor(R.color.ajr));
            addView(this.f178358d);
            this.f178358d.d(new a());
        }
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        c(true, false);
    }

    private boolean h(boolean z16) {
        if (!z16) {
            ImageView imageView = this.f178361h;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            return false;
        }
        int n3 = Utils.n(50.0f, getResources());
        int n16 = Utils.n(37.0f, getResources());
        if (this.f178361h == null) {
            this.f178361h = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n3, n16);
            layoutParams.addRule(13, -1);
            this.f178361h.setLayoutParams(layoutParams);
            this.f178361h.setImageDrawable(f(n3, n16));
            addView(this.f178361h);
        }
        ImageView imageView2 = this.f178361h;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.scribble.b
    public void b(View view, int i3, com.tencent.mobileqq.scribble.c cVar, int i16) {
        int i17;
        if (i3 == 2 && cVar != null && (i17 = cVar.f282547b) == this.f178360f) {
            if (1 == i16) {
                this.f178360f = -1;
                setTemplateID(i17);
            } else if (2 == i16 || 3 == i16) {
                h(false);
                if (this.f178362i == null) {
                    this.f178362i = QQToast.makeText(getContext(), getResources().getString(R.string.it), 0);
                }
                if (!this.f178362i.isShowing()) {
                    this.f178362i.show();
                }
            }
        }
    }

    public void c(boolean z16, boolean z17) {
        DoodleView doodleView = this.f178358d;
        if (doodleView != null) {
            doodleView.b(z17);
        }
        if (z16) {
            this.f178360f = 0;
            setTemplateVisible(Boolean.FALSE);
        }
    }

    protected Bitmap d() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("aio_doodle_progress_list");
        if (f16 == null && (f16 = com.tencent.mobileqq.util.j.g(BaseApplication.getContext().getResources(), R.drawable.common_loading6_0)) != null) {
            imageCacheHelper.i("aio_doodle_progress_list", f16, Business.AIO);
        }
        return f16;
    }

    public int e(boolean z16, boolean z17) {
        DoodleView doodleView = this.f178358d;
        int i3 = 1;
        if (doodleView != null) {
            int c16 = doodleView.c(z17);
            if (this.f178360f <= 0) {
                i3 = 0;
            }
            if (z16) {
                return c16 + i3;
            }
            return c16;
        }
        if (z16 && this.f178360f > 0) {
            return 1;
        }
        return 0;
    }

    public void i() {
        DoodleView doodleView = this.f178358d;
        if (doodleView != null && doodleView.c(false) > 0) {
            this.f178358d.f();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setColor(int i3) {
        DoodleView doodleView = this.f178358d;
        if (doodleView != null) {
            doodleView.setLineColor(i3);
        }
    }

    public void setTemplateID(int i3) {
        ImageView imageView;
        ImageView imageView2;
        if (QLog.isColorLevel()) {
            QLog.d("DoodleLayout", 2, "setTemplateID:" + i3);
        }
        if (this.f178360f == i3) {
            return;
        }
        this.f178360f = i3;
        if (i3 > 0) {
            Bitmap b16 = DoodleResHelper.k().b(3, this.f178360f);
            if (b16 != null && (imageView2 = this.f178359e) != null) {
                imageView2.setImageBitmap(b16);
                setTemplateVisible(Boolean.TRUE);
                h(false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "load bitmap failed:" + this.f178360f);
            }
            if (!DoodleResHelper.k().l(3, this.f178360f)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "file not exist, start download:" + this.f178360f);
                }
                h(true);
                setTemplateVisible(Boolean.FALSE);
                DoodleResHelper.k().p(1, i3, this, this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "try use drawable:" + this.f178360f);
            }
            Drawable j3 = DoodleResHelper.k().j(3, this.f178360f, false);
            if (j3 != null && (imageView = this.f178359e) != null) {
                imageView.setImageDrawable(j3);
                setTemplateVisible(Boolean.TRUE);
                h(false);
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "use drawable succ:" + this.f178360f);
                    return;
                }
                return;
            }
            return;
        }
        setTemplateVisible(Boolean.FALSE);
        h(false);
    }

    public void setTemplateVisible(Boolean bool) {
        if (this.f178359e != null) {
            if (bool.booleanValue()) {
                this.f178359e.setVisibility(0);
            } else {
                this.f178359e.setVisibility(8);
            }
        }
    }

    public void setTexture(int i3) {
        DoodleView doodleView = this.f178358d;
        if (doodleView != null) {
            doodleView.setLineTexture(i3);
        }
    }

    public DoodleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178360f = 0;
        g();
    }

    public void setDoodleLayoutListener(b bVar) {
    }
}
