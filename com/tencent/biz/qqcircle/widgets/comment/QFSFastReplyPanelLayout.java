package com.tencent.biz.qqcircle.widgets.comment;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes5.dex */
public class QFSFastReplyPanelLayout extends LinearLayout {
    private TextView C;
    private ImageView D;
    private TextView E;
    private Size F;
    private final int[] G;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f93558d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93559e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f93560f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f93561h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93562i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f93563m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends CharacterStyle {
        a() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            RFWTypefaceUtil.setNumberTypeface((Paint) textPaint, false);
        }
    }

    public QFSFastReplyPanelLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        if (this.f93560f == null) {
            return;
        }
        i();
        if (af.h()) {
            this.f93560f.setVisibility(0);
            g(h.a(R.string.f1901341_));
            l();
        } else {
            this.f93560f.setVisibility(8);
            m();
        }
    }

    private String c(int i3) {
        if (!af.h()) {
            return "";
        }
        char c16 = 2;
        if (i3 == 0) {
            return this.G[0] + "," + this.G[1] + "," + this.G[2];
        }
        if (i3 == R.id.f372516r) {
            c16 = 0;
        } else if (i3 == R.id.f372716t) {
            c16 = 1;
        }
        return String.valueOf(this.G[c16]);
    }

    private void f() {
        View.inflate(getContext(), R.layout.f168667ga2, this);
        this.f93558d = (QCircleAvatarView) findViewById(R.id.f372416q);
        this.f93559e = (TextView) findViewById(R.id.f373216y);
        this.f93560f = (RelativeLayout) findViewById(R.id.f373116x);
        this.f93561h = (ImageView) findViewById(R.id.f372516r);
        this.f93563m = (ImageView) findViewById(R.id.f372716t);
        this.D = (ImageView) findViewById(R.id.f372916v);
        this.f93562i = (TextView) findViewById(R.id.f372616s);
        this.C = (TextView) findViewById(R.id.f372816u);
        this.E = (TextView) findViewById(R.id.f373016w);
    }

    private void g(String str) {
        if (this.f93559e != null && !TextUtils.isEmpty(str)) {
            this.f93559e.setHint(str);
        }
    }

    private void i() {
        if (this.f93558d == null) {
            return;
        }
        if (this.F == null) {
            this.F = n.a(getContext(), R.dimen.d4w);
        }
        this.f93558d.setAvatar(QCirclePluginGlobalInfo.m(), this.F);
    }

    private void j(ImageView imageView, String str, int i3) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return;
            }
            String str2 = split[new Random().nextInt(split.length)];
            int c16 = cu.c(str2, -1);
            if (c16 == -1) {
                QLog.w("QFSFastReplyPanel", 1, "parseStr2Int error, str=" + str2);
                return;
            }
            int convertToLocal = QQSysFaceUtil.convertToLocal(c16);
            QLog.d("QFSFastReplyPanel", 4, "updateFastReplyEmoji localId: " + convertToLocal);
            imageView.setImageDrawable(QQSysFaceUtil.getFaceDrawable(convertToLocal));
            imageView.setTag(Integer.valueOf(convertToLocal));
            this.G[i3] = c16;
        }
    }

    private void k(TextView textView) {
        if (textView == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("x3");
        spannableStringBuilder.setSpan(new a(), 0, spannableStringBuilder.length(), 33);
        textView.setText(spannableStringBuilder);
    }

    private void l() {
        List<String> E = com.tencent.biz.qqcircle.comment.h.G().E();
        if (E != null && E.size() >= 3) {
            j(this.f93561h, E.get(0), 0);
            j(this.f93563m, E.get(1), 1);
            j(this.D, E.get(2), 2);
            k(this.f93562i);
            k(this.C);
            k(this.E);
        }
    }

    private void m() {
        List<String> F = com.tencent.biz.qqcircle.comment.h.G().F();
        if (F != null && F.size() > 0) {
            String str = F.get(new Random().nextInt(F.size()));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            g(str);
        }
    }

    public void b(String str, String str2, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        if (feedCloudMeta$StComment != null && feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.poster != null) {
            VideoReport.setElementId(this, str);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StComment.f398447id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_WITH_STICKER, Integer.valueOf(af.h() ? 1 : 0));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, c(i3));
            VideoReport.reportEvent(str2, this, buildElementParams);
        }
    }

    public void d(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        QLog.d("QFSFastReplyPanel", 1, "hideFastReplyPanel");
        if (af.y(feedCloudMeta$StComment)) {
            af.J("");
        }
        setVisibility(8);
    }

    public void e(View.OnClickListener onClickListener) {
        if (this.f93561h != null && this.f93563m != null && this.D != null) {
            setOnClickListener(onClickListener);
            this.f93561h.setOnClickListener(onClickListener);
            this.f93563m.setOnClickListener(onClickListener);
            this.D.setOnClickListener(onClickListener);
        }
    }

    public void h(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        String str;
        QLog.d("QFSFastReplyPanel", 1, "showFastReplyPanel");
        a();
        af.N();
        if (feedCloudMeta$StComment != null) {
            str = feedCloudMeta$StComment.f398447id.get();
        } else {
            str = "";
        }
        af.J(str);
        setVisibility(0);
        b(QCircleDaTongConstant.ElementId.EM_XSJ_FAST_REPLY_PANEL, "dt_imp", feedCloudMeta$StFeed, feedCloudMeta$StComment, 0);
    }

    public QFSFastReplyPanelLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = new int[3];
        f();
    }
}
