package com.tencent.biz.qqcircle.immersive.album.view;

import android.content.Context;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cv;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAlbumItemView extends QCircleBaseWidgetView<b40.a> implements View.OnClickListener {
    private QCircleAsyncTextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private View G;
    private int H;
    private Context I;
    private a J;
    private View K;
    private View L;
    private QFSPagAnimView M;
    int N;
    int P;

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f84822d;

    /* renamed from: e, reason: collision with root package name */
    private FeedCloudMeta$FeedAlbum f84823e;

    /* renamed from: f, reason: collision with root package name */
    private b40.a f84824f;

    /* renamed from: h, reason: collision with root package name */
    private z30.a f84825h;

    /* renamed from: i, reason: collision with root package name */
    private View f84826i;

    /* renamed from: m, reason: collision with root package name */
    private RoundCornerImageView f84827m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f84828a;

        /* renamed from: b, reason: collision with root package name */
        public int f84829b;

        /* renamed from: c, reason: collision with root package name */
        public int f84830c;

        /* renamed from: d, reason: collision with root package name */
        public FeedCloudMeta$StFeed f84831d;

        /* renamed from: e, reason: collision with root package name */
        public int f84832e;

        public a(boolean z16, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i17) {
            this.f84828a = z16;
            this.f84829b = i3;
            this.f84830c = i16;
            this.f84831d = feedCloudMeta$StFeed;
            this.f84832e = i17;
        }
    }

    public QCircleAlbumItemView(@NonNull Context context) {
        this(context, null);
    }

    private void l0(Context context) {
        o0(this);
        this.I = context;
        this.N = QFSQUIUtilsKt.d(context, R.color.qui_common_bg_middle_light);
        this.P = QFSQUIUtilsKt.d(context, R.color.qui_common_fill_standard_primary);
    }

    private void m0() {
        View view;
        a aVar = this.J;
        if (aVar == null) {
            return;
        }
        if ((aVar.f84829b > 0 || aVar.f84830c > 0) && (view = this.K) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a aVar2 = this.J;
            layoutParams.width = aVar2.f84829b;
            layoutParams.height = aVar2.f84830c;
            this.K.setLayoutParams(layoutParams);
        }
    }

    private void n0() {
        this.f84826i.setOnClickListener(this);
    }

    private void o0(View view) {
        setOnClickListener(this);
        this.K = view.findViewById(R.id.f39091aq);
        this.L = view.findViewById(R.id.f39141av);
        this.M = (QFSPagAnimView) view.findViewById(R.id.f39131au);
        this.G = view.findViewById(R.id.f54462f_);
        this.f84826i = view.findViewById(R.id.f33680x4);
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.f33740x_);
        this.f84827m = roundCornerImageView;
        roundCornerImageView.setCorner(cx.a(4.0f));
        QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) view.findViewById(R.id.f33750xa);
        this.C = qCircleAsyncTextView;
        qCircleAsyncTextView.setSpecialClickAreaColor(QFSQUIUtilsKt.d(view.getContext(), R.color.qui_common_text_primary), true);
        this.C.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= 28) {
            this.C.setLineHeight(cx.a(22.0f));
        }
        this.D = (TextView) view.findViewById(R.id.f33690x5);
        this.E = (TextView) view.findViewById(R.id.f33700x6);
        this.F = (TextView) view.findViewById(R.id.f33720x8);
        m0();
        n0();
    }

    private void p0() {
        a aVar = this.J;
        if (aVar != null && aVar.f84828a) {
            View view = this.L;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.G;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            QFSPagAnimView qFSPagAnimView = this.M;
            if (qFSPagAnimView != null) {
                qFSPagAnimView.Q(com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.nsk));
                this.M.M("https://downv6.qq.com/video_story/qcircle/fullscreen/icon_music_wave_animation.pag");
            }
        }
    }

    private void q0(TextView textView, b40.a aVar) {
        String string;
        String b16 = aVar.b();
        int j3 = aVar.j();
        if (!TextUtils.isEmpty(b16)) {
            String string2 = getResources().getString(R.string.f195754fg, Integer.valueOf(j3), b16);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
            int indexOf = string2.indexOf("\uff5c");
            int i3 = indexOf + 1;
            spannableStringBuilder.setSpan(new ForegroundColorSpan(QCircleSkinHelper.getInstance().getColor(R.color.qui_common_text_primary)), indexOf, i3, 33);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.8f), indexOf, i3, 33);
            string = spannableStringBuilder.toString();
        } else {
            string = getResources().getString(R.string.f195764fh, Integer.valueOf(j3));
        }
        if (textView instanceof QCircleAsyncTextView) {
            ((QCircleAsyncTextView) textView).setText((CharSequence) string, false);
        } else {
            textView.setText(string);
        }
    }

    private void r0() {
        View view = this.L;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.G;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        QFSPagAnimView qFSPagAnimView = this.M;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.Q(null);
            this.M.V();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleAlbumItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(b40.a aVar, int i3) {
        if (aVar != null && aVar.f() != null && aVar.f().album != null) {
            QLog.d("QCircleAlbumItemView", 1, "[bindData] albumInfo: ", aVar);
            this.H = i3;
            this.f84824f = aVar;
            com.tencent.biz.qqcircle.utils.j.a(this.f84827m, aVar.c(), 56.0f, 74.0f);
            this.f84823e = this.f84824f.f().album.get();
            q0(this.C, aVar);
            this.D.setText(cv.a(aVar.d() / 1000));
            this.E.setText(aVar.h());
            this.F.setText(aVar.i());
            if (aVar.n()) {
                this.f84826i.setBackgroundColor(this.P);
                p0();
            } else {
                this.f84826i.setBackgroundColor(this.N);
                r0();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f84825h.onClick(view, 1, this.H, this.f84824f);
        QLog.d("QCircleAlbumItemView", 1, "[onClick] v: ", view, ", mPosition: ", Integer.valueOf(this.H));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f84826i.setBackgroundColor(this.N);
            }
            return super.onTouchEvent(motionEvent);
        }
        this.f84826i.setBackgroundColor(this.P);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f84822d = feedCloudMeta$StFeed;
    }

    public void setOnAlbumElementClickListener(z30.a aVar) {
        this.f84825h = aVar;
    }

    public QCircleAlbumItemView(@NonNull Context context, a aVar) {
        super(context);
        this.J = aVar;
        l0(context);
    }
}
