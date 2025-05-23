package com.tencent.mobileqq.qwallet.hb.grap.keep.draw;

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
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.qwallet.hb.grap.keep.draw.DoodleView;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ag;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DoodleLayout extends RelativeLayout implements com.tencent.mobileqq.scribble.b {

    /* renamed from: d, reason: collision with root package name */
    private DoodleView f277425d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f277426e;

    /* renamed from: f, reason: collision with root package name */
    private int f277427f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f277428h;

    /* renamed from: i, reason: collision with root package name */
    private QQToast f277429i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements DoodleView.b {
        a() {
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.DoodleView.b
        public void a() {
            DoodleLayout.a(DoodleLayout.this);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.DoodleView.b
        public void b(int i3, int i16) {
            DoodleLayout.a(DoodleLayout.this);
        }

        @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.DoodleView.b
        public void c() {
            DoodleLayout.a(DoodleLayout.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
    }

    public DoodleLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f277427f = 0;
        f();
    }

    static /* bridge */ /* synthetic */ b a(DoodleLayout doodleLayout) {
        doodleLayout.getClass();
        return null;
    }

    private Drawable e(int i3, int i16) {
        ag agVar = new ag(d(), 0, false);
        agVar.setBounds(new Rect(0, 0, i3, i16));
        return agVar;
    }

    private void f() {
        if (this.f277426e == null) {
            this.f277426e = new ImageView(getContext());
            this.f277426e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            addView(this.f277426e);
        }
        if (this.f277425d == null) {
            this.f277425d = new DoodleView(getContext(), null);
            this.f277425d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f277425d.setBackgroundColor(getResources().getColor(R.color.ajr));
            addView(this.f277425d);
            this.f277425d.c(new a());
        }
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        c(true, false);
    }

    private boolean g(boolean z16) {
        if (!z16) {
            ImageView imageView = this.f277428h;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            return false;
        }
        int c16 = x.c(getContext(), 50.0f);
        int c17 = x.c(getContext(), 37.0f);
        if (this.f277428h == null) {
            this.f277428h = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c16, c17);
            layoutParams.addRule(13, -1);
            this.f277428h.setLayoutParams(layoutParams);
            this.f277428h.setImageDrawable(e(c16, c17));
            addView(this.f277428h);
        }
        ImageView imageView2 = this.f277428h;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.scribble.b
    public void b(View view, int i3, com.tencent.mobileqq.scribble.c cVar, int i16) {
        int i17;
        if (i3 == 2 && cVar != null && (i17 = cVar.f282547b) == this.f277427f) {
            if (1 == i16) {
                this.f277427f = -1;
                setTemplateID(i17);
            } else if (2 == i16 || 3 == i16) {
                g(false);
                if (this.f277429i == null) {
                    this.f277429i = QQToast.makeText(getContext(), getResources().getString(R.string.it), 0);
                }
                if (!this.f277429i.isShowing()) {
                    this.f277429i.show();
                }
            }
        }
    }

    public void c(boolean z16, boolean z17) {
        DoodleView doodleView = this.f277425d;
        if (doodleView != null) {
            doodleView.b(z17);
        }
        if (z16) {
            this.f277427f = 0;
            setTemplateVisible(Boolean.FALSE);
        }
    }

    protected Bitmap d() {
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("aio_doodle_progress_list");
        if (f16 == null && (f16 = j.g(BaseApplication.getContext().getResources(), R.drawable.common_loading6_0)) != null) {
            imageCacheHelper.i("aio_doodle_progress_list", f16, Business.AIO);
        }
        return f16;
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
        DoodleView doodleView = this.f277425d;
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
        if (this.f277427f == i3) {
            return;
        }
        this.f277427f = i3;
        if (i3 > 0) {
            Bitmap b16 = DoodleResHelper.k().b(3, this.f277427f);
            if (b16 != null && (imageView2 = this.f277426e) != null) {
                imageView2.setImageBitmap(b16);
                setTemplateVisible(Boolean.TRUE);
                g(false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "load bitmap failed:" + this.f277427f);
            }
            if (!DoodleResHelper.k().l(3, this.f277427f)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "file not exist, start download:" + this.f277427f);
                }
                g(true);
                setTemplateVisible(Boolean.FALSE);
                DoodleResHelper.k().p(1, i3, this, this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleLayout", 2, "try use drawable:" + this.f277427f);
            }
            Drawable j3 = DoodleResHelper.k().j(3, this.f277427f, false);
            if (j3 != null && (imageView = this.f277426e) != null) {
                imageView.setImageDrawable(j3);
                setTemplateVisible(Boolean.TRUE);
                g(false);
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleLayout", 2, "use drawable succ:" + this.f277427f);
                    return;
                }
                return;
            }
            return;
        }
        setTemplateVisible(Boolean.FALSE);
        g(false);
    }

    public void setTemplateVisible(Boolean bool) {
        if (this.f277426e != null) {
            if (bool.booleanValue()) {
                this.f277426e.setVisibility(0);
            } else {
                this.f277426e.setVisibility(8);
            }
        }
    }

    public void setTexture(int i3) {
        DoodleView doodleView = this.f277425d;
        if (doodleView != null) {
            doodleView.setLineTexture(i3);
        }
    }

    public DoodleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f277427f = 0;
        f();
    }

    public void setDoodleLayoutListener(b bVar) {
    }
}
