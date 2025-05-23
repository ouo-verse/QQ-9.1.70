package com.tencent.biz.qqcircle.push;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.push.j;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class QFSPushRocketRecyclerView extends RecyclerView {
    private static List<Integer> D;
    private boolean C;

    /* renamed from: f, reason: collision with root package name */
    private int f91813f;

    /* renamed from: h, reason: collision with root package name */
    private final j f91814h;

    /* renamed from: i, reason: collision with root package name */
    private j.b f91815i;

    /* renamed from: m, reason: collision with root package name */
    private int f91816m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends LinearLayoutManager {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    class b implements j.b {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.push.j.b
        public void onItemClick(int i3) {
            QFSPushRocketRecyclerView.this.E(i3, false);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
    }

    static {
        ArrayList arrayList = new ArrayList();
        D = arrayList;
        arrayList.add(6);
        D.add(66);
        D.add(166);
        D.add(400);
    }

    public QFSPushRocketRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, boolean z16) {
        if (fb0.a.b("QFSPushRocketRecyclerView", 100L)) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i3);
        if (!(findViewHolderForAdapterPosition instanceof j.c)) {
            D(i3, z16);
            return;
        }
        j.c cVar = (j.c) findViewHolderForAdapterPosition;
        if (cVar.p() == 0) {
            return;
        }
        cVar.o();
        for (int i16 = 0; i16 < this.f91814h.getNUM_BACKGOURND_ICON(); i16++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i16);
            if ((findViewHolderForAdapterPosition2 instanceof j.c) && i3 != i16) {
                ((j.c) findViewHolderForAdapterPosition2).q();
            }
        }
        D(i3, z16);
    }

    private void init() {
        a aVar = new a(getContext());
        aVar.setOrientation(0);
        setLayoutManager(aVar);
        setAdapter(this.f91814h);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (!this.C) {
            return;
        }
        for (int i3 = 0; i3 < this.f91814h.getNUM_BACKGOURND_ICON(); i3++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof j.c) {
                ((j.c) findViewHolderForAdapterPosition).m();
            }
        }
    }

    public void setData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, c cVar) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.f91816m = com.tencent.biz.qqcircle.f.v().t();
        ArrayList arrayList = new ArrayList();
        int i3 = feedCloudMeta$StFeed.quick_push_info.divide_num.get();
        if (i3 == 0) {
            arrayList.addAll(D);
        } else if (i3 > 0 && i3 < this.f91816m) {
            arrayList.addAll(feedCloudMeta$StFeed.quick_push_info.high_rockets.get());
        } else {
            arrayList.addAll(feedCloudMeta$StFeed.quick_push_info.low_rockets.get());
        }
        if (arrayList.size() > 0) {
            this.f91813f = ((Integer) arrayList.get(0)).intValue();
        }
        if (this.f91815i == null) {
            this.f91815i = new b();
        }
        this.f91814h.o0(arrayList, this.f91815i);
    }

    public void setIsShowing(boolean z16) {
        this.C = z16;
    }

    public QFSPushRocketRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPushRocketRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91813f = 6;
        this.f91814h = new j();
        this.f91816m = 0;
        init();
    }

    private void D(int i3, boolean z16) {
    }
}
