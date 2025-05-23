package com.tencent.aelight.camera.aioeditor.takevideo.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import fr.f;
import java.util.List;
import ms.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFilterContentView extends FrameLayout implements d.c {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f68931d;

    /* renamed from: e, reason: collision with root package name */
    private AEFilterListAdapter f68932e;

    /* renamed from: f, reason: collision with root package name */
    private d f68933f;

    public AEFilterContentView(Context context) {
        this(context, null);
    }

    private void b(int i3) {
        this.f68932e.v(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "FilterProviderView onCreate");
        }
        d dVar = this.f68933f;
        m.a aVar = dVar != null ? dVar.I : null;
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AEFilterContainerView", 2, "filterProviderView get data is null");
            }
        } else {
            m.b c16 = aVar.c(i3);
            if (c16 != null) {
                this.f68932e.u(getContext(), m.a.b(c16.f66517c));
            } else {
                a.c("AEFilterContainerView", "dataSet is null");
            }
        }
    }

    public int a() {
        AEFilterListAdapter aEFilterListAdapter = this.f68932e;
        if (aEFilterListAdapter != null) {
            return aEFilterListAdapter.getItemCount();
        }
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void d(j jVar, boolean z16, int i3, Bundle bundle) {
        this.f68932e.notifyDataSetChanged();
        h(jVar);
    }

    public void g(int i3) {
        b(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.f68933f;
        if (dVar != null) {
            dVar.k(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f68933f;
        if (dVar != null) {
            dVar.G(this);
        }
    }

    public void setProviderViewListener(ProviderView.a aVar) {
        AEFilterListAdapter aEFilterListAdapter = this.f68932e;
        if (aEFilterListAdapter != null) {
            aEFilterListAdapter.w(aVar);
        }
    }

    public AEFilterContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AEFilterContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        addView(LayoutInflater.from(context).inflate(R.layout.f167583du4, (ViewGroup) this, false));
        c(context);
        d dVar = (d) f.c(5);
        this.f68933f = dVar;
        dVar.k(this);
    }

    private void h(j jVar) {
        if (jVar != null) {
            Object obj = jVar.f66709i;
            if (obj instanceof QIMFilterCategoryItem) {
                String str = ((QIMFilterCategoryItem) obj).f66697d;
                List<QIMFilterCategoryItem> r16 = this.f68932e.r();
                if (str == null || r16 == null) {
                    return;
                }
                for (int i3 = 0; i3 < r16.size(); i3++) {
                    if (str.equals(r16.get(i3).f66697d)) {
                        this.f68931d.scrollToPosition(i3);
                        return;
                    }
                }
                return;
            }
        }
        a.c("AEFilterContainerView", "filterSet is null.");
    }

    private void c(Context context) {
        this.f68931d = (RecyclerView) findViewById(R.id.f787647y);
        AEFilterListAdapter aEFilterListAdapter = new AEFilterListAdapter();
        this.f68932e = aEFilterListAdapter;
        this.f68931d.setAdapter(aEFilterListAdapter);
        this.f68931d.setLayoutManager(new LinearLayoutManager(context, 0, false));
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void e(m.a aVar) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void f(h hVar) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.d.c
    public void j(h hVar, boolean z16, int i3, Bundle bundle) {
    }
}
