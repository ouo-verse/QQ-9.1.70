package com.tencent.mobileqq.guild.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.widget.u;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes14.dex */
class ListItemAnimator$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f236031d;
    final /* synthetic */ u this$0;

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f236031d.iterator();
        if (it.hasNext()) {
            RecyclerView.ViewHolder viewHolder = ((u.b) it.next()).f236640a;
            throw null;
        }
        this.f236031d.clear();
        throw null;
    }
}
