package com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchLiveStatusChangeEvent;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.d;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchResultLiveLayout extends RelativeLayout implements View.OnClickListener {
    private d C;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f91092d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f91093e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f91094f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f91095h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f91096i;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f91097m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a implements d.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSSearchResultLiveLayout> f91098a;

        /* renamed from: b, reason: collision with root package name */
        private final FeedCloudMeta$StFeed f91099b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f91100c;

        a(QFSSearchResultLiveLayout qFSSearchResultLiveLayout, boolean z16) {
            this.f91098a = new WeakReference<>(qFSSearchResultLiveLayout);
            this.f91099b = qFSSearchResultLiveLayout.f91097m;
            this.f91100c = z16;
        }

        private void b(long j3, String str) {
            QLog.w("QFSSearchResultLiveLayout", 1, "#onResp: errCode=" + j3 + ", errMsg=" + str);
            d(false);
            QFSSearchResultLiveLayout qFSSearchResultLiveLayout = this.f91098a.get();
            if (qFSSearchResultLiveLayout != null && qFSSearchResultLiveLayout.f91097m == this.f91099b) {
                qFSSearchResultLiveLayout.f91096i.setEnabled(true);
            }
        }

        private void c() {
            int i3;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f91099b;
            if (this.f91100c) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            p.H(feedCloudMeta$StFeed, i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSSearchLiveStatusChangeEvent(this.f91099b));
            QFSSearchResultLiveLayout qFSSearchResultLiveLayout = this.f91098a.get();
            if (qFSSearchResultLiveLayout != null && qFSSearchResultLiveLayout.f91097m == this.f91099b) {
                qFSSearchResultLiveLayout.h();
                d(true);
            }
        }

        private void d(boolean z16) {
            int i3;
            int i16;
            if (this.f91100c) {
                if (z16) {
                    i3 = R.string.f196044g9;
                } else {
                    i3 = R.string.f196024g7;
                }
            } else if (z16) {
                i3 = R.string.f196284gw;
            } else {
                i3 = R.string.f196274gv;
            }
            if (z16) {
                i16 = QCircleToast.f91646f;
            } else {
                i16 = QCircleToast.f91645e;
            }
            QCircleToast.i(i16, i3, 0);
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.search.util.d.a
        public void a(long j3, String str) {
            if (j3 != 0) {
                b(j3, str);
            } else {
                c();
            }
        }
    }

    public QFSSearchResultLiveLayout(@NonNull Context context) {
        super(context);
    }

    private void e() {
        if (this.f91097m == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.f91097m.poster.get());
        c.d0(getContext(), qCircleInitBean);
    }

    private void f() {
        int j3 = p.j(this.f91097m);
        if (j3 != 0) {
            if (j3 == 2) {
                this.f91096i.setEnabled(false);
                this.C.p(new a(this, false));
                return;
            }
            return;
        }
        this.f91096i.setEnabled(false);
        this.C.n(new a(this, true));
    }

    private void g() {
        this.C.j(getContext().hashCode(), this.f91097m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int i3;
        this.f91096i.setEnabled(true);
        int j3 = p.j(this.f91097m);
        if (j3 != 0) {
            if (j3 != 2) {
                if (j3 == 3) {
                    this.f91096i.setVisibility(4);
                    return;
                }
                return;
            }
            this.f91096i.setVisibility(0);
            if (QCircleSkinHelper.getInstance().isDarkMode()) {
                i3 = -13619152;
            } else {
                i3 = -1;
            }
            this.f91096i.setText(h.a(R.string.f196054g_));
            this.f91096i.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qui_common_text_primary));
            this.f91096i.setBackground(ad.f(i3, 4, 80, 30));
            return;
        }
        this.f91096i.setVisibility(0);
        this.f91096i.setText(h.a(R.string.f196034g8));
        this.f91096i.setTextColor(QCircleSkinHelper.getInstance().getColor(R.color.qui_common_text_allwhite_primary));
        this.f91096i.setBackground(ad.f(RichStatus.TOPIC_COLOR, 4, 80, 30));
    }

    private void i() {
        int j3 = p.j(this.f91097m);
        if (j3 != 0 && j3 != 2) {
            if (j3 == 3) {
                this.f91094f.setText(h.a(R.string.f1914244r));
                return;
            }
            return;
        }
        this.f91094f.setText(p.i(this.f91097m, "live_date"));
    }

    public void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f91097m = feedCloudMeta$StFeed;
        this.f91092d.setUser(feedCloudMeta$StFeed.poster.get(), n.a(getContext(), R.dimen.d5h));
        this.f91093e.setText(feedCloudMeta$StFeed.poster.nick.get());
        this.f91095h.setText(p.i(this.f91097m, "live_summary"));
        i();
        h();
        g();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f91096i) {
            f();
        } else if (view == this.f91092d) {
            e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.gs5, (ViewGroup) this, true);
        if (!FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(getContext(), this);
        }
        this.f91092d = (QCircleAvatarView) findViewById(R.id.f53632d1);
        this.f91093e = (TextView) findViewById(R.id.f53662d4);
        this.f91094f = (TextView) findViewById(R.id.f53672d5);
        this.f91095h = (TextView) findViewById(R.id.f53652d3);
        this.f91096i = (TextView) findViewById(R.id.f53642d2);
        this.f91092d.setOnClickListener(this);
        this.f91096i.setOnClickListener(this);
    }

    public void setLiveSubscribeHelper(@NonNull d dVar) {
        this.C = dVar;
    }

    public QFSSearchResultLiveLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSSearchResultLiveLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
