package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import e30.d;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends p70.a {
    protected final MutableLiveData<UIStateData<List<e30.b>>> C = new MutableLiveData<>();
    private Object D;
    private long E;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(List list) {
        ArrayList<e30.b> b16 = d.b(list);
        UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
        obtainSuccess.setData(false, b16);
        obtainSuccess.setFinish(true);
        this.C.postValue(obtainSuccess);
    }

    private void a2() {
        this.C.setValue(null);
        L1();
    }

    protected void T1(QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent) {
        if (!TextUtils.equals(qFSVideoFeedPlayEvent.globalKey, U1()) || TextUtils.isEmpty(qFSVideoFeedPlayEvent.feedId)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.E < 500) {
            return;
        }
        this.E = currentTimeMillis;
        e30.b g16 = p.g(this.C.getValue(), qFSVideoFeedPlayEvent.feedId);
        if (g16 != null && TextUtils.equals(p.m(g16.g()), qFSVideoFeedPlayEvent.playUrl)) {
            R1(qFSVideoFeedPlayEvent.feedId, qFSVideoFeedPlayEvent.progress);
        }
    }

    public String U1() {
        return String.valueOf(hashCode());
    }

    public void X1(final List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.W1(list);
                }
            });
        } else {
            this.C.setValue(null);
        }
    }

    public void Z1(Object obj) {
        if (this.D == obj) {
            return;
        }
        this.D = obj;
        a2();
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        int i3;
        UIStateData<List<e30.b>> value = this.C.getValue();
        if (value != null) {
            List<e30.b> data = value.getData();
            boolean z16 = false;
            if (data != null && !data.isEmpty()) {
                Iterator<e30.b> it = data.iterator();
                i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (p.y(it.next().g())) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
            } else {
                i3 = -1;
            }
            if (z16) {
                UIStateData<List<e30.b>> copy = value.copy();
                ArrayList arrayList = new ArrayList(data);
                arrayList.remove(i3);
                copy.setDataList(arrayList);
                return new MutableLiveData<>(copy);
            }
        }
        return this.C;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>(1);
        arrayList.add(QFSVideoFeedPlayEvent.class);
        return arrayList;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> j() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            T1((QFSVideoFeedPlayEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
    }
}
