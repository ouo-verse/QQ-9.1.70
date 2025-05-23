package com.tencent.mobileqq.guild.api;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    protected d f214360d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f214361e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f214362f;

    /* renamed from: h, reason: collision with root package name */
    protected e f214363h;

    public void a(Context context, RecyclerView recyclerView, d dVar, e eVar) {
        QLog.d("FeedBaseScroller", 1, "[bindEnvironment]");
        this.f214362f = context;
        this.f214361e = recyclerView;
        this.f214360d = dVar;
        this.f214363h = eVar;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    public void c() {
    }

    public void onDestroy() {
    }

    public void b(RecyclerView recyclerView) {
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
    }

    public void g(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    public void d(RecyclerView recyclerView, int i3, int i16, boolean z16) {
    }

    public void h(int i3, int i16, int i17, int i18, boolean z16) {
    }

    public void e(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
    }
}
