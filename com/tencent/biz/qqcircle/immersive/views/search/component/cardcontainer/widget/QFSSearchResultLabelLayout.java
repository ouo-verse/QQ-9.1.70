package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultLabelLayout extends FrameLayout implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f91086d;

    /* renamed from: e, reason: collision with root package name */
    private QFSPagAnimView f91087e;

    /* renamed from: f, reason: collision with root package name */
    private View f91088f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f91089h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f91090i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f91091m;

    public QFSSearchResultLabelLayout(Context context) {
        super(context);
    }

    @Nullable
    private static String b(Iterable<FeedCloudCommon$Entry> iterable) {
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : iterable) {
            if (feedCloudCommon$Entry != null && "tag".equals(feedCloudCommon$Entry.key.get())) {
                String str = feedCloudCommon$Entry.value.get();
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    private void c() {
        if (this.f91091m) {
            return;
        }
        this.f91091m = true;
        LayoutInflater.from(getContext()).inflate(R.layout.f168758gs3, (ViewGroup) this, true);
        this.f91086d = (ImageView) findViewById(R.id.f45881t3);
        this.f91087e = (QFSPagAnimView) findViewById(R.id.f45861t1);
        this.f91088f = findViewById(R.id.f43861nm);
        this.f91089h = (TextView) findViewById(R.id.f43871nn);
        this.f91090i = (ImageView) findViewById(R.id.f43841nk);
    }

    private void d() {
        e();
        this.f91087e.M("https://qq-video.cdn-go.cn/android/latest/defaultmode/8918/search/qvideo_search_label_living.pag");
    }

    private void e() {
        Object context = getContext();
        if (context instanceof LifecycleOwner) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) context;
            lifecycleOwner.getLifecycle().removeObserver(this);
            lifecycleOwner.getLifecycle().addObserver(this);
        }
    }

    private void f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudCommon$Entry> list;
        if (this.f91091m) {
            this.f91088f.setVisibility(8);
            this.f91090i.setImageDrawable(null);
            this.f91090i.setVisibility(8);
        }
        if (!p.y(feedCloudMeta$StFeed) && (list = feedCloudMeta$StFeed.extInfo.get()) != null && !list.isEmpty()) {
            String b16 = b(list);
            if (TextUtils.isEmpty(b16)) {
                return;
            }
            c();
            setVisibility(0);
            this.f91088f.setVisibility(0);
            this.f91089h.setText(b16);
        }
    }

    private void g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.f91091m) {
            this.f91086d.setImageDrawable(null);
            this.f91086d.setVisibility(8);
            this.f91087e.setVisibility(8);
        }
        if (!p.y(feedCloudMeta$StFeed)) {
            return;
        }
        c();
        int j3 = p.j(feedCloudMeta$StFeed);
        if (j3 != 0) {
            if (j3 != 1) {
                if (j3 != 2) {
                    return;
                }
            } else {
                setVisibility(0);
                this.f91087e.setVisibility(0);
                d();
                return;
            }
        }
        setVisibility(0);
        this.f91086d.setVisibility(0);
        this.f91086d.setImageResource(R.drawable.f162087nu2);
    }

    private void h() {
        if (!this.f91091m || this.f91087e.getVisibility() != 0) {
            return;
        }
        this.f91087e.L();
    }

    private void i() {
        if (!this.f91091m) {
            return;
        }
        this.f91087e.V();
    }

    public void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        setVisibility(8);
        f(feedCloudMeta$StFeed);
        g(feedCloudMeta$StFeed);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        i();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        h();
    }

    public QFSSearchResultLabelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchResultLabelLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
