package com.qzone.reborn.feedx.widget.header;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneBaseFeedxHeaderContainerView extends QZoneBaseWidgetView<BusinessFeedData> implements b, a {

    /* renamed from: e, reason: collision with root package name */
    private final LifecycleOwner f56120e;

    /* renamed from: f, reason: collision with root package name */
    public final com.qzone.reborn.feedx.viewmodel.c f56121f;

    /* renamed from: h, reason: collision with root package name */
    private List<b> f56122h;

    /* renamed from: i, reason: collision with root package name */
    protected RecyclerView f56123i;

    public QZoneBaseFeedxHeaderContainerView(Context context, LifecycleOwner lifecycleOwner, com.qzone.reborn.feedx.viewmodel.c cVar) {
        super(context);
        this.f56120e = lifecycleOwner;
        this.f56121f = cVar;
        this.f56122h = new ArrayList();
        o0();
        n0();
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public <T extends ViewModel> T E(Class<T> cls) {
        return (T) this.f56121f.W(cls);
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void M() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().M();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().a0(qZoneResult);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void b(RecyclerView recyclerView, int i3, int i16) {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().b(recyclerView, i3, i16);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public boolean c(float f16, float f17) {
        Iterator<b> it = this.f56122h.iterator();
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

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().delayShow();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public int e() {
        return 0;
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public LifecycleOwner getLifecycleOwner() {
        return this.f56120e;
    }

    public abstract void n0();

    public abstract void o0();

    @Override // android.view.View, com.qzone.reborn.feedx.widget.header.b
    public void onConfigurationChanged(Configuration configuration) {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onConfigurationChanged(configuration);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDestroy();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onHandleMessage(message);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onPause();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onPostThemeChanged() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onPostThemeChanged();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onResume();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onStart() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStart();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void onStop() {
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStop();
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // android.view.View, com.qzone.reborn.feedx.widget.header.b
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().onWindowFocusChanged(z16);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.b
    public void r(RecyclerView recyclerView) {
        this.f56123i = recyclerView;
        Iterator<b> it = this.f56122h.iterator();
        while (it.hasNext()) {
            try {
                it.next().r(recyclerView);
            } catch (Throwable th5) {
                xe.b.f447841a.d(th5);
            }
        }
    }

    public void r0(d dVar) {
        try {
            dVar.a(this);
            this.f56122h.add(dVar);
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
        }
    }

    public void q0(boolean z16) {
        if (z16) {
            p0();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.a
    public View getContainerView() {
        return this;
    }

    public void p0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
    }
}
