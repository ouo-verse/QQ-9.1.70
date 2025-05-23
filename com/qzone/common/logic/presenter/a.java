package com.qzone.common.logic.presenter;

import android.os.Parcelable;
import android.view.View;
import com.qzone.feed.utils.e;
import com.qzone.personalize.ArchiveMemorySettingGuide;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.util.j;
import d5.k;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements b6.a, e, ArchiveMemorySettingGuide.c {

    /* renamed from: d, reason: collision with root package name */
    WeakReference<BaseFeedPresenter> f46109d;

    /* renamed from: e, reason: collision with root package name */
    BaseFeedPresenter f46110e;

    public a(BaseFeedPresenter baseFeedPresenter) {
        this.f46109d = new WeakReference<>(baseFeedPresenter);
    }

    @Override // com.qzone.personalize.ArchiveMemorySettingGuide.c
    public void D4(CharSequence charSequence) {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
        } else {
            baseFeedPresenter.D4(charSequence);
        }
    }

    @Override // d5.n
    public void F7() {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
        } else {
            baseFeedPresenter.F7();
        }
    }

    @Override // d5.n
    public boolean Lc() {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
            return false;
        }
        return baseFeedPresenter.Lc();
    }

    @Override // com.qzone.proxy.feedcomponent.ui.g
    public boolean a(FeedElement feedElement, Object obj, View view, CellTextView.OnTextOperater onTextOperater) {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
            return false;
        }
        return baseFeedPresenter.a(feedElement, obj, view, onTextOperater);
    }

    public void b() {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
            return;
        }
        baseFeedPresenter.t0();
        BaseFeedPresenter baseFeedPresenter2 = this.f46110e;
        if (baseFeedPresenter2 != null) {
            baseFeedPresenter2.t0();
            this.f46110e = null;
        }
    }

    @Override // d5.n
    public void b9(k<BusinessFeedData> kVar) {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
        } else {
            baseFeedPresenter.b9(kVar);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.ui.g
    public void onClick(View view, FeedElement feedElement, int i3, Object obj) {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
        } else {
            baseFeedPresenter.onClick(view, feedElement, i3, obj);
        }
    }

    @Override // com.qzone.feed.utils.e
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
        BaseFeedPresenter baseFeedPresenter = this.f46109d.get();
        if (baseFeedPresenter == null) {
            j.d("LEAK", "\u4f7f\u7528\u4e86\u5df2\u88ab\u91ca\u653e\u7684\u5f15\u7528", new Exception());
        } else {
            baseFeedPresenter.x0(aVar, serializable, parcelable, map);
        }
    }
}
