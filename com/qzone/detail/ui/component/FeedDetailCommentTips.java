package com.qzone.detail.ui.component;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDetailCommentTips extends FrameLayout {
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private LinearLayout H;
    private View I;
    private boolean J;
    public boolean K;

    /* renamed from: d, reason: collision with root package name */
    private FeedDetailCommentTips f46961d;

    /* renamed from: e, reason: collision with root package name */
    private Context f46962e;

    /* renamed from: f, reason: collision with root package name */
    private ProgressBar f46963f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f46964h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f46965i;

    /* renamed from: m, reason: collision with root package name */
    private int f46966m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (FeedDetailCommentTips.this.f46966m != 2) {
                if (FeedDetailCommentTips.this.f46966m == 5) {
                    FeedDetailCommentTips feedDetailCommentTips = FeedDetailCommentTips.this;
                    if (feedDetailCommentTips.K) {
                        feedDetailCommentTips.f46965i.sendEmptyMessage(-10001);
                    } else {
                        feedDetailCommentTips.f46965i.sendEmptyMessage(-10000);
                    }
                }
            } else {
                FeedDetailCommentTips.this.f46965i.sendEmptyMessage(2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FeedDetailCommentTips(Context context, Handler handler) {
        super(context);
        this.f46966m = 0;
        this.C = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewLoadingComment", "\u6b63\u5728\u52a0\u8f7d\u8bc4\u8bba...");
        this.D = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewLoadingMoreComment", "\u52a0\u8f7d\u66f4\u591a\u8bc4\u8bba...");
        this.E = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewAddFirstComment", "\u5feb\u6765\u6dfb\u52a0\u7b2c\u4e00\u6761\u8bc4\u8bba\u5427!");
        this.F = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewShowAll", "\u5df2\u663e\u793a\u5168\u90e8");
        this.G = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewLookUp", "\u67e5\u770b\u66f4\u591a");
        this.K = false;
        this.f46961d = this;
        this.f46962e = context;
        this.f46965i = handler;
        f();
        c();
    }

    private void c() {
        this.H.setOnClickListener(new a());
    }

    private void f() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f46962e).inflate(R.layout.bkz, (ViewGroup) null);
        this.H = linearLayout;
        addView(linearLayout);
        this.f46963f = (ProgressBar) this.H.findViewById(R.id.b3h);
        this.f46964h = (TextView) this.H.findViewById(R.id.b3i);
        this.I = this.H.findViewById(R.id.b3g);
    }

    public View d() {
        return this.H;
    }

    public int e() {
        return this.f46966m;
    }

    public boolean g() {
        int i3 = this.f46966m;
        return i3 == 0 || i3 == 1;
    }

    public boolean h() {
        return this.f46966m == 5;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        LinearLayout linearLayout = this.H;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i3);
        }
    }

    public void setDividerVisible(boolean z16) {
        this.I.setVisibility(z16 ? 0 : 8);
    }

    public void setLoadMoreManulText(String str) {
        this.G = str;
    }

    public void setLoadingDataText(String str) {
        this.C = str;
    }

    public void setLoadingMoreDataText(String str) {
        this.D = str;
    }

    public void setNoDataText(String str) {
        this.E = str;
    }

    public void setNoMoreDataText(String str) {
        this.F = str;
    }

    public void setNoMoreDataVisibility(boolean z16) {
        this.J = z16;
    }

    public void setState(int i3) {
        if (this.f46964h == null || this.f46963f == null) {
            return;
        }
        setVisibility(0);
        this.f46966m = i3;
        if (this.f46964h.getVisibility() == 8) {
            this.f46964h.setVisibility(0);
        }
        switch (i3) {
            case 0:
                this.f46963f.setVisibility(0);
                this.f46964h.setText(this.C);
                this.f46964h.setVisibility(0);
                return;
            case 1:
                this.f46963f.setVisibility(0);
                this.f46964h.setText(this.D);
                this.f46964h.setVisibility(0);
                return;
            case 2:
                this.f46963f.setVisibility(8);
                this.f46964h.setText(this.E);
                this.f46964h.setVisibility(0);
                return;
            case 3:
                setVisibility(8);
                this.f46964h.setVisibility(8);
                this.f46963f.setVisibility(8);
                return;
            case 4:
                this.f46963f.setVisibility(8);
                this.f46964h.setText(this.F);
                if (this.J) {
                    this.f46964h.setVisibility(0);
                    return;
                } else {
                    this.f46964h.setVisibility(8);
                    setVisibility(8);
                    return;
                }
            case 5:
                this.f46963f.setVisibility(8);
                this.f46964h.setText(this.G);
                this.f46964h.setVisibility(0);
                return;
            case 6:
                this.f46963f.setVisibility(8);
                this.f46964h.setText(this.F);
                this.f46964h.setVisibility(4);
                setVisibility(4);
                return;
            case 7:
                this.f46963f.setVisibility(8);
                this.f46964h.setText(this.F);
                this.f46964h.setVisibility(0);
                setVisibility(0);
                return;
            default:
                return;
        }
    }
}
