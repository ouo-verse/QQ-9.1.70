package com.tencent.biz.qqcircle.immersive.views.search.simpleitem;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StCorrectionInfo;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchQueryFixResultItemView extends QFSSearchBaseWidgetView<Object> {
    private QFSSearchInfo C;
    private com.tencent.biz.qqcircle.immersive.search.a D;
    private String E;

    /* renamed from: e, reason: collision with root package name */
    private TextView f91193e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f91194f;

    /* renamed from: h, reason: collision with root package name */
    private View f91195h;

    /* renamed from: i, reason: collision with root package name */
    private String f91196i;

    /* renamed from: m, reason: collision with root package name */
    private String f91197m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            QFSSearchQueryFixResultItemView.this.p0();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setColor(textPaint.linkColor);
            textPaint.setUnderlineText(false);
        }
    }

    public QFSSearchQueryFixResultItemView(@NonNull Context context) {
        super(context);
        this.f91196i = "";
        this.f91197m = "";
        initView();
    }

    private void initView() {
        this.f91194f = (LinearLayout) findViewById(R.id.f54132ed);
        this.f91195h = findViewById(R.id.f54152ef);
        TextView textView = (TextView) findViewById(R.id.f54162eg);
        this.f91193e = textView;
        textView.setText("");
    }

    private boolean l0(@NonNull FeedCloudRead$StCorrectionInfo feedCloudRead$StCorrectionInfo) {
        return !TextUtils.isEmpty(feedCloudRead$StCorrectionInfo.correction_word.get());
    }

    private void m0() {
        TextView textView = this.f91193e;
        if (textView == null) {
            return;
        }
        i.k(textView, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_KEYWORD_CORRECTION_EXPLAIN, o0(), 0);
    }

    private String n0(String str, String str2) {
        return String.format(QCircleApplication.getAPP().getString(R.string.f195144dt), str, str2);
    }

    private Map<String, Object> o0() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ORIGINAL_QUERY_TEXT, this.f91197m);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AFTER_CORRECTION_QUERY_TEXT, this.f91196i);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        EventCollector.getInstance().onViewClicked(this.f91193e);
        if (this.D != null) {
            QFSSearchInfo qFSSearchInfo = new QFSSearchInfo();
            qFSSearchInfo.k(this.f91197m);
            qFSSearchInfo.j(20);
            this.D.a(qFSSearchInfo);
        }
    }

    private void q0() {
        LinearLayout linearLayout = this.f91194f;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private void r0(SpannableStringBuilder spannableStringBuilder) {
        int indexOf = this.E.indexOf(this.f91196i);
        int length = this.f91196i.length() + indexOf;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ie0.a.f().g(getContext(), R.color.qui_common_text_primary, 1000)), indexOf, length, 17);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 17);
        this.f91193e.setText(spannableStringBuilder);
    }

    private void s0(SpannableStringBuilder spannableStringBuilder) {
        int lastIndexOf = this.E.lastIndexOf(this.f91197m);
        int length = this.f91197m.length() + lastIndexOf;
        int g16 = ie0.a.f().g(getContext(), R.color.qui_common_text_link_selector, 1000);
        spannableStringBuilder.setSpan(new StyleSpan(1), lastIndexOf, length, 17);
        spannableStringBuilder.setSpan(new a(), lastIndexOf, length, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(g16), lastIndexOf, length, 17);
        this.f91193e.setText(spannableStringBuilder);
    }

    private void u0(FeedCloudRead$StCorrectionInfo feedCloudRead$StCorrectionInfo) {
        if (feedCloudRead$StCorrectionInfo == null) {
            return;
        }
        this.f91196i = feedCloudRead$StCorrectionInfo.correction_word.get();
        QFSSearchInfo qFSSearchInfo = this.C;
        if (qFSSearchInfo != null) {
            this.f91197m = qFSSearchInfo.f();
        }
        this.E = n0(this.f91196i, this.f91197m);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.E);
        r0(spannableStringBuilder);
        s0(spannableStringBuilder);
        this.f91193e.setText(spannableStringBuilder);
        this.f91193e.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void w0() {
        LinearLayout linearLayout = this.f91194f;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        q0();
        if (obj instanceof FeedCloudRead$StCorrectionInfo) {
            FeedCloudRead$StCorrectionInfo feedCloudRead$StCorrectionInfo = (FeedCloudRead$StCorrectionInfo) obj;
            if (l0(feedCloudRead$StCorrectionInfo)) {
                w0();
                u0(feedCloudRead$StCorrectionInfo);
                m0();
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.grr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchQueryFixResultItemView";
    }

    public void setQueryFixClickListener(com.tencent.biz.qqcircle.immersive.search.a aVar) {
        this.D = aVar;
    }

    public void setSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.C = qFSSearchInfo;
    }

    public void v0() {
        View view = this.f91195h;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
