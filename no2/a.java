package no2;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoItemView;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lo2.z;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a extends BaseAdapter {
    private final com.tencent.mobileqq.search.business.qcircle.video.base.a C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final HorizontalListView f420621d;

    /* renamed from: e, reason: collision with root package name */
    private String f420622e;

    /* renamed from: f, reason: collision with root package name */
    private z f420623f;

    /* renamed from: h, reason: collision with root package name */
    private List<FeedCloudMeta$StFeed> f420624h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final mo2.a f420625i;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a f420626m;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(HorizontalListView horizontalListView, mo2.a aVar, com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a aVar2, com.tencent.mobileqq.search.business.qcircle.video.base.a aVar3) {
        this.f420621d = horizontalListView;
        this.f420625i = aVar;
        this.f420626m = aVar2;
        this.C = aVar3;
    }

    private void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, View view, int i3) {
        HashMap hashMap = new HashMap();
        String str = "1";
        hashMap.put("search_single_is_hot_search", "1");
        if (!TextUtils.isEmpty(this.f420622e)) {
            hashMap.put("hot_search_text_id", this.f420622e);
        }
        hashMap.put("search_single_headlines_video_rowkey", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
        hashMap.put("search_single_vided_play_number", String.valueOf(feedCloudMeta$StFeed.visitorInfo.viewCount.get()));
        hashMap.put("search_single_headlines_video_position", String.valueOf(i3));
        if (!this.f420625i.f417103i) {
            str = "0";
        }
        hashMap.put("search_single_headlines_video_mute", str);
        am.t(view, this.f420623f.X(), x.e(this.f420623f), this.f420623f.z(), i3, i3, String.valueOf(feedCloudMeta$StFeed.hashCode()), "normal", null, hashMap);
    }

    private void f() {
        this.D = false;
        if (this.f420624h.isEmpty()) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f420624h.get(0);
        int i3 = feedCloudMeta$StFeed.video.width.get();
        int i16 = feedCloudMeta$StFeed.video.height.get();
        if (i16 > 0 && i3 > i16) {
            this.D = true;
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FeedCloudMeta$StFeed getItem(int i3) {
        return this.f420624h.get(i3);
    }

    protected abstract QCircleSearchDoubleVideoItemView c(ViewGroup viewGroup);

    public void d(z zVar) {
        this.f420623f = zVar;
        this.f420624h = zVar.W();
        f();
        notifyDataSetChanged();
    }

    public void e(String str) {
        this.f420622e = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.D) {
            return 1;
        }
        return Math.min(this.f420624h.size(), 2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        QCircleSearchDoubleVideoItemView c16;
        if (view instanceof QCircleSearchDoubleVideoItemView) {
            c16 = (QCircleSearchDoubleVideoItemView) view;
        } else {
            c16 = c(viewGroup);
            c16.setup(this.f420621d, this.f420623f, this.C, this.f420626m);
        }
        c16.setHorizontalMode(this.D);
        boolean z16 = true;
        if (getCount() != 1) {
            z16 = false;
        }
        c16.setLoop(z16);
        FeedCloudMeta$StFeed item = getItem(i3);
        c16.setData(item, i3);
        a(item, view, i3);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return c16;
    }
}
