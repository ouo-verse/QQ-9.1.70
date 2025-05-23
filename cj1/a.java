package cj1;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.feed.bean.GuildExtraTypeInfo;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedReportScroller;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.k;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.qphone.base.util.QLog;
import ij1.g;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a extends b<g> {
    protected GuildExtraTypeInfo C;
    protected com.tencent.mobileqq.guild.feed.manager.e D;
    protected int E;

    public a(Bundle bundle) {
        super(bundle);
        this.E = 0;
    }

    protected abstract List<com.tencent.mobileqq.guild.feed.manager.b> k0();

    public void l0(boolean z16) {
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.i(z16);
        }
    }

    protected void m0(RecyclerView recyclerView) {
        this.D = new com.tencent.mobileqq.guild.feed.manager.e(getContext(), recyclerView, this);
        List<com.tencent.mobileqq.guild.feed.manager.b> k06 = k0();
        if (k06 != null && k06.size() > 0) {
            Iterator<com.tencent.mobileqq.guild.feed.manager.b> it = k06.iterator();
            while (it.hasNext()) {
                this.D.d(it.next());
            }
        }
        this.D.d(new GuildFeedReportScroller(getPageId(), j0(), k.c(1, ax.q(getContext()))));
        this.D.n(this.C);
        this.D.o(this.E);
        addOnScrollListener(this.D);
        this.D.j(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0() {
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.k();
        }
    }

    public void o0() {
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.p();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        m0(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            removeOnScrollListener(eVar);
            this.D.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.l(viewHolder);
        }
        QLog.d("GuildBaseFeedBlock", 4, "onViewAttachedToWindow:" + viewHolder.getAdapterPosition() + "  " + viewHolder + "  " + this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        com.tencent.mobileqq.guild.feed.manager.e eVar = this.D;
        if (eVar != null) {
            eVar.m(viewHolder);
        }
        QLog.d("GuildBaseFeedBlock", 4, "onViewDetachedFromWindow:" + viewHolder.getAdapterPosition() + "  " + viewHolder + "  " + this);
    }
}
