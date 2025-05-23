package com.tencent.mobileqq.guild.feed.adapter;

import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.data.GuildFeedOptionClickEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPicPreloadScroller;
import com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPreloadDetailScroller;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class c extends cj1.a implements SimpleEventReceiver {
    protected final GuildFeedMainInitBean F;
    private boolean G;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends ti1.a {
        a() {
        }

        @Override // ti1.a
        public boolean e() {
            if (c.this.G) {
                return true;
            }
            return false;
        }
    }

    public c(GuildFeedMainInitBean guildFeedMainInitBean) {
        super(new Bundle());
        this.F = guildFeedMainInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s0(Runnable runnable) {
        RFWThreadManager.getUIHandler().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(List list) {
        setDatasDefault(list);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    protected DiffUtil.ItemCallback<ij1.g> getDiffCallBack() {
        return new a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedOptionClickEvent.class);
        return arrayList;
    }

    @Override // cj1.a
    protected List<com.tencent.mobileqq.guild.feed.manager.b> k0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GuildFeedPicPreloadScroller());
        arrayList.add(new GuildFeedPreloadDetailScroller());
        arrayList.add(new fo1.d());
        return arrayList;
    }

    @Override // cj1.a, com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // cj1.a, com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedOptionClickEvent) {
            GuildFeedOptionClickEvent guildFeedOptionClickEvent = (GuildFeedOptionClickEvent) simpleBaseEvent;
            List<ij1.g> dataList = getDataList();
            ArrayList arrayList = new ArrayList(dataList);
            int i3 = 0;
            while (true) {
                if (i3 < dataList.size()) {
                    if (guildFeedOptionClickEvent.getFeedId().equals(dataList.get(i3).b().idd)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                arrayList.remove(i3);
                u0(arrayList, true, null);
            }
            QLog.i("GuildFakeAdapter", 1, "[onReceiveEvent] index:" + i3);
        }
    }

    public void u0(final List<ij1.g> list, boolean z16, final Runnable runnable) {
        if (list != null) {
            this.G = z16;
            if (this.mDiffer != null) {
                submitList(list, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.adapter.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.s0(runnable);
                    }
                });
                return;
            } else if (Looper.getMainLooper() == Looper.myLooper()) {
                setDatasDefault(list);
                n0();
                return;
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.adapter.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.t0(list);
                    }
                });
                return;
            }
        }
        throw new UnsupportedOperationException("can't setDataList with null list");
    }
}
