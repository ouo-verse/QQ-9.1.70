package com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.QFSBottomCommentDisplayView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import feedcloud.FeedCloudMeta$StComment;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomCommentDisplayView extends FrameLayout implements View.OnClickListener {
    private a C;
    private View D;
    private FeedCloudMeta$StComment E;
    private int F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private QFSBottomCommentTextView f90607d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f90608e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90609f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f90610h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90611i;

    /* renamed from: m, reason: collision with root package name */
    private View f90612m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, FeedCloudMeta$StComment feedCloudMeta$StComment);

        void b(View view, FeedCloudMeta$StComment feedCloudMeta$StComment);
    }

    public QFSBottomCommentDisplayView(@NonNull Context context) {
        super(context);
        this.F = 0;
        this.G = 0;
        e();
    }

    private void e() {
        int i3;
        try {
            if (o.s1()) {
                i3 = R.layout.gjx;
            } else {
                i3 = R.layout.gah;
            }
            LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, true);
            this.f90612m = findViewById(R.id.f39461bq);
            this.f90608e = (ImageView) findViewById(R.id.f39481bs);
            this.f90607d = (QFSBottomCommentTextView) findViewById(R.id.f39521bw);
            this.f90609f = (TextView) findViewById(R.id.f39531bx);
            this.f90610h = (ImageView) findViewById(R.id.f39501bu);
            this.f90611i = (TextView) findViewById(R.id.f39511bv);
            this.f90610h.setOnClickListener(this);
            this.f90611i.setOnClickListener(this);
            View findViewById = findViewById(R.id.f39471br);
            this.D = findViewById;
            findViewById.setOnClickListener(this);
            this.f90607d.setSpecialClickAreaColor(R.color.f158017al3);
            this.f90607d.setNeedSpecialAreaBold(true);
            this.f90607d.setOnClickListener(this);
            this.f90607d.setOnClickNicknameListener(new RFWAsyncRichTextView.OnClickNicknameListener() { // from class: t70.a
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickNicknameListener
                public final void onClick(String str) {
                    QFSBottomCommentDisplayView.this.f(str);
                }
            });
            this.f90607d.setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: t70.b
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
                public final void onClick(String str) {
                    QFSBottomCommentDisplayView.this.g(str);
                }
            });
            this.f90607d.setOnClickHashTagTextListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: t70.c
                @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
                public final void onClick(String str) {
                    QFSBottomCommentDisplayView.this.h(str);
                }
            });
        } catch (Throwable th5) {
            RFWLog.e("DPC-QFSBottomCommentDisplayView", RFWLog.USR, "[initView] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str) {
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str) {
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str) {
        i();
    }

    private void i() {
        a aVar = this.C;
        if (aVar == null) {
            return;
        }
        aVar.b(this.D, this.E);
    }

    private void j() {
        a aVar = this.C;
        if (aVar == null) {
            return;
        }
        aVar.a(this.D, this.E);
    }

    private void m(@NonNull FeedCloudMeta$StComment feedCloudMeta$StComment) {
        q(this.f90608e, 0);
        ViewGroup.LayoutParams layoutParams = this.f90607d.getLayoutParams();
        if (layoutParams.width != -2) {
            layoutParams.width = -2;
            this.f90607d.setLayoutParams(layoutParams);
        }
        this.f90607d.setEllipsize(TextUtils.TruncateAt.END);
        this.f90607d.setMaxLines(1);
        this.f90607d.setText(feedCloudMeta$StComment.content.get());
        boolean z16 = !TextUtils.isEmpty(feedCloudMeta$StComment.commentPic.picUrl.get());
        boolean z17 = !TextUtils.isEmpty(feedCloudMeta$StComment.expressionInfo.expressionURL.get());
        if (z16) {
            this.f90609f.setText(R.string.f184253ld);
            q(this.f90609f, 0);
        } else if (z17) {
            this.f90609f.setText(R.string.f182983hy);
            q(this.f90609f, 0);
        } else {
            q(this.f90609f, 8);
        }
        RFWLog.d("DPC-QFSBottomCommentDisplayView", RFWLog.USR, "[updateHotCommentUI] id: " + feedCloudMeta$StComment.f398447id.get() + " | content: " + feedCloudMeta$StComment.content.get() + " | isExistsPicUrl: " + z16 + " | isExistsExpression: " + z17);
        o(feedCloudMeta$StComment);
    }

    private void o(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        boolean z16;
        Drawable drawable;
        if (feedCloudMeta$StComment == null) {
            RFWLog.d("DPC-QFSBottomCommentDisplayView", RFWLog.USR, "[updateLikeUI] comment should not be null.");
            return;
        }
        if (feedCloudMeta$StComment.likeInfo.status.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            drawable = getContext().getDrawable(this.G);
        } else {
            drawable = getContext().getDrawable(this.F);
        }
        RFWLog.d("DPC-QFSBottomCommentDisplayView", RFWLog.USR, "[updateLikeUI] unLikeStatus: " + z16 + " | mUnLikeResId: " + this.G + " | mLikeResId: " + this.F);
        if (z16 && drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_allwhite_tertiary), PorterDuff.Mode.SRC_IN));
        }
        this.f90610h.setImageDrawable(drawable);
        if (feedCloudMeta$StComment.likeInfo.count.get() == 0) {
            q(this.f90611i, 8);
        } else {
            q(this.f90611i, 0);
            this.f90611i.setText(r.f(feedCloudMeta$StComment.likeInfo.count.get()));
        }
    }

    private void q(View view, int i3) {
        if (view == null || view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }

    public View d() {
        return this.D;
    }

    public void k(Drawable drawable) {
        ImageView imageView = this.f90608e;
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void l(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            RFWLog.d("DPC-QFSBottomCommentDisplayView", RFWLog.USR, "[updateComment] comment should not be null.");
        } else {
            m(feedCloudMeta$StComment);
            this.E = feedCloudMeta$StComment;
        }
    }

    public void n(int i3, int i16) {
        this.F = i3;
        this.G = i16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.f39501bu && view.getId() != R.id.f39511bv) {
            if (view.getId() == R.id.f39471br || view.getId() == R.id.f39521bw) {
                i();
            }
        } else {
            j();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(int i3) {
        q(this.f90610h, i3);
        q(this.f90611i, i3);
    }

    public void setOnBottomCommentListener(a aVar) {
        this.C = aVar;
    }

    public QFSBottomCommentDisplayView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = 0;
        this.G = 0;
        e();
    }

    public QFSBottomCommentDisplayView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = 0;
        this.G = 0;
        e();
    }
}
