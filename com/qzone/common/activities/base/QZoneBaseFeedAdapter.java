package com.qzone.common.activities.base;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qzone.common.event.EventCenter;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneBaseFeedAdapter extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    protected List<BusinessFeedData> f45220d;

    /* renamed from: e, reason: collision with root package name */
    protected final QZoneBaseFeedFragment f45221e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f45222f = false;

    /* renamed from: h, reason: collision with root package name */
    private BusinessFeedData f45223h = null;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f45224i;

    public QZoneBaseFeedAdapter(QZoneBaseFeedFragment qZoneBaseFeedFragment) {
        this.f45221e = qZoneBaseFeedFragment;
    }

    public void b(final String str, final String str2, final boolean z16) {
        QZoneBaseFeedFragment qZoneBaseFeedFragment = this.f45221e;
        if (qZoneBaseFeedFragment != null) {
            final com.qzone.feed.business.service.a si5 = qZoneBaseFeedFragment.si();
            Runnable runnable = new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    com.qzone.feed.business.service.a aVar = si5;
                    if (aVar != null) {
                        if (aVar instanceof QZoneFeedService) {
                            ((QZoneFeedService) aVar).R(str, str2, z16);
                        } else if (aVar instanceof y6.e) {
                            com.qzone.adapter.feedcomponent.f.e0((y6.e) aVar, str, str2);
                        }
                    }
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
            } else {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).post(runnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        QZoneBaseFeedFragment qZoneBaseFeedFragment;
        BusinessFeedData businessFeedData;
        boolean z16;
        if (!this.f45222f || (qZoneBaseFeedFragment = this.f45221e) == null || qZoneBaseFeedFragment.vi() != 0 || (businessFeedData = this.f45223h) == null || !businessFeedData.isDeleteOnTimeFeed()) {
            return;
        }
        if (this.f45221e.isStarted()) {
            h(businessFeedData.getFeedCommInfo().ugckey);
            this.f45221e.Gi(businessFeedData);
            if (!this.f45221e.isResumed(2)) {
                z16 = false;
                if (z16) {
                    return;
                }
                List<BusinessFeedData> list = this.f45220d;
                if (list != null && list.contains(businessFeedData)) {
                    this.f45220d.remove(businessFeedData);
                }
                b(businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().clientkey, true);
                this.f45222f = false;
                this.f45223h = null;
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public void d() {
        List<BusinessFeedData> list = this.f45220d;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
        if (this.f45224i != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).removeTask(this.f45224i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.qzone.proxy.feedcomponent.ui.g e() {
        d5.o ti5 = this.f45221e.ti();
        if (ti5 instanceof BaseFeedFragmentFeedPresenterImp) {
            return ((BaseFeedFragmentFeedPresenterImp) ti5).g();
        }
        return null;
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public BusinessFeedData getItem(int i3) {
        List<BusinessFeedData> list = this.f45220d;
        if (list != null && list.size() >= i3 + 1 && i3 >= 0) {
            return this.f45220d.get(i3);
        }
        return null;
    }

    public String g(int i3) {
        List<BusinessFeedData> list = this.f45220d;
        if (list == null || list.size() < i3 + 1 || this.f45220d.get(i3) == null || this.f45220d.get(i3).getFeedCommInfo() == null) {
            return null;
        }
        return this.f45220d.get(i3).getFeedCommInfo().feedskey;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<BusinessFeedData> list = this.f45220d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return null;
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.qzone.hide_feed_actionpanel");
        intent.putExtra("extra_key_need_showtoast", true);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_CACHE_UNIKEY, str);
        BaseApplicationImpl.getApplication().doSendBroadcast(intent);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public void i(List<BusinessFeedData> list, boolean z16) {
        if (this.f45220d == null) {
            this.f45220d = new ArrayList();
        }
        this.f45220d.clear();
        if (list != null && list.size() > 0) {
            this.f45220d.addAll(com.qzone.proxy.feedcomponent.model.c.e(list));
        }
        j();
        if (z16) {
            notifyDataSetChanged();
        }
        EventCenter.getInstance().post("Feed", 20);
    }

    protected void j() {
        if (this.f45224i != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).removeTask(this.f45224i);
        }
        this.f45223h = null;
        this.f45222f = false;
        if (this.f45220d != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            int i3 = 0;
            long j3 = 0;
            while (i3 < this.f45220d.size()) {
                BusinessFeedData businessFeedData = this.f45220d.get(i3);
                if (businessFeedData != null && businessFeedData.isDeleteOnTimeFeed()) {
                    long j16 = businessFeedData.getFeedCommInfo().feedsDelTime - currentTimeMillis;
                    if (j16 <= 0) {
                        this.f45220d.remove(businessFeedData);
                        i3--;
                        b(businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().clientkey, false);
                    } else if (j3 == 0 || j3 > j16) {
                        this.f45223h = businessFeedData;
                        j3 = j16;
                    }
                }
                i3++;
            }
            if (j3 > 0) {
                if (this.f45224i == null) {
                    this.f45224i = new Runnable() { // from class: com.qzone.common.activities.base.QZoneBaseFeedAdapter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QZoneBaseFeedAdapter.this.f45222f = true;
                            QZoneBaseFeedAdapter.this.c();
                        }
                    };
                }
                if (this.f45224i != null) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.FeedDeleteOnTimeThread).postDelayed(this.f45224i, j3 * 1000);
                }
            }
        }
    }

    public void setData(List<BusinessFeedData> list) {
        i(list, true);
    }
}
