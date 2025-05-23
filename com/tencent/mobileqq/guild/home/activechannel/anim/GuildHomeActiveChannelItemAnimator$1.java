package com.tencent.mobileqq.guild.home.activechannel.anim;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.home.activechannel.anim.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes13.dex */
class GuildHomeActiveChannelItemAnimator$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ArrayList f224761d;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f224761d.iterator();
        if (it.hasNext()) {
            RecyclerView.ViewHolder viewHolder = ((a.C7788a) it.next()).f224763a;
            throw null;
        }
        this.f224761d.clear();
        throw null;
    }
}
