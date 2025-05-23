package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes37.dex */
public abstract class QzoneBaseFeedProHeaderContainerView extends BaseWidgetView implements c, b {

    /* renamed from: d, reason: collision with root package name */
    private final LifecycleOwner f54543d;

    /* renamed from: e, reason: collision with root package name */
    public final com.qzone.reborn.feedx.viewmodel.c f54544e;

    /* renamed from: f, reason: collision with root package name */
    private List<c> f54545f;

    /* renamed from: h, reason: collision with root package name */
    protected RecyclerView f54546h;

    public QzoneBaseFeedProHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context);
        this.f54543d = lifecycleOwner;
        this.f54544e = cVar;
        this.f54545f = new ArrayList();
        l0();
        k0();
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void L(RecyclerView recyclerView) {
        RFWLog.d("QzoneBaseFeedProHeaderContainerView", RFWLog.USR, "onAttachedToRecyclerView");
        this.f54546h = recyclerView;
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().L(recyclerView);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void M() {
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().M();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void N(RecyclerView.ViewHolder viewHolder) {
        RFWLog.d("QzoneBaseFeedProHeaderContainerView", RFWLog.USR, "onAttachToWindow");
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().N(viewHolder);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void b(RecyclerView recyclerView, int i3, int i16) {
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().b(recyclerView, i3, i16);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public boolean c(float f16, float f17) {
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
            if (it.next().c(f16, f17)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.b
    public int e() {
        return 0;
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void g0(RecyclerView.ViewHolder viewHolder) {
        RFWLog.d("QzoneBaseFeedProHeaderContainerView", RFWLog.USR, "onDetachToWindow");
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().g0(viewHolder);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.b
    public LifecycleOwner getLifecycleOwner() {
        return this.f54543d;
    }

    public abstract void k0();

    public abstract void l0();

    public void m0(d dVar) {
        try {
            dVar.g(this);
            this.f54545f.add(dVar);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    @Override // android.view.View, com.qzone.reborn.feedpro.widget.header.c
    public void onConfigurationChanged(Configuration configuration) {
        RFWLog.d("QzoneBaseFeedProHeaderContainerView", RFWLog.USR, "onConfigurationChanged");
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().onConfigurationChanged(configuration);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onDestroy() {
        RFWLog.d("QzoneBaseFeedProHeaderContainerView", RFWLog.USR, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDestroy();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onPostThemeChanged() {
        RFWLog.d("QzoneBaseFeedProHeaderContainerView", RFWLog.USR, "onPostThemeChanged");
        Iterator<c> it = this.f54545f.iterator();
        while (it.hasNext()) {
            try {
                it.next().onPostThemeChanged();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.widget.header.b
    public <T extends ViewModel> T p(Class<T> cls) {
        return (T) this.f54544e.W(cls);
    }

    @Override // com.qzone.reborn.feedpro.widget.header.b
    public View getContainerView() {
        return this;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
