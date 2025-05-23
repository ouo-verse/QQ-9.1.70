package com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.recommend;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.android.androidbypass.Bypass;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.widget.CommonImageView;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0018B/\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010+\u001a\u00020\f\u0012\u0006\u0010/\u001a\u00020\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J)\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ2\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0016\u001a\u00020\u0002R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010/\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/f;", "", "Landroid/view/View;", "b", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/b;", "lineContent", "", "topViewId", "leftViewId", "e", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/b;Ljava/lang/Integer;I)Landroid/view/View;", "", "url", "width", "height", "Landroid/widget/ImageView;", "targetView", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "", "g", "f", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/d;", "getParseResult", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/d;", "parseResult", "Lcom/tencent/android/androidbypass/Bypass$f;", "c", "Lcom/tencent/android/androidbypass/Bypass$f;", "getOptions", "()Lcom/tencent/android/androidbypass/Bypass$f;", "options", "Ljava/lang/String;", "getAlt", "()Ljava/lang/String;", QCircleSchemeAttr.Polymerize.ALT, "I", "getMkMaxWidth", "()I", "mkMaxWidth", "Landroid/view/View;", "view", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/d;Lcom/tencent/android/androidbypass/Bypass$f;Ljava/lang/String;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d parseResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bypass.f options;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String alt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mkMaxWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/span/recommend/f$a;", "", "", "AVTAR_LEFT_MARGIN", UserInfo.SEX_FEMALE, "AVTAR_SIZE", "AVTAR_TOP_MARGIN", "FIRST_TEXT_TOP_MARGIN", "HEIGHT", "", "TAG", "Ljava/lang/String;", "TEXT_LEFT_MARGIN", "TEXT_RIGHT_MARGIN", "THIRD_TEXT_TOP_MARGIN", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.recommend.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull Context context, @NotNull d parseResult, @NotNull Bypass.f options, @NotNull String alt, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parseResult, "parseResult");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(alt, "alt");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, parseResult, options, alt, Integer.valueOf(i3));
            return;
        }
        this.context = context;
        this.parseResult = parseResult;
        this.options = options;
        this.alt = alt;
        this.mkMaxWidth = i3;
        this.view = b();
    }

    private final View b() {
        Object orNull;
        Object orNull2;
        Object orNull3;
        List<b> b16 = this.parseResult.b();
        ConstraintLayout constraintLayout = new ConstraintLayout(this.context);
        constraintLayout.setBackground(this.context.getResources().getDrawable(R.drawable.jma));
        View d16 = d();
        constraintLayout.addView(d16);
        orNull = CollectionsKt___CollectionsKt.getOrNull(b16, 0);
        b bVar = (b) orNull;
        if (bVar == null) {
            return constraintLayout;
        }
        View e16 = e(bVar, null, d16.getId());
        constraintLayout.addView(e16);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(b16, 1);
        b bVar2 = (b) orNull2;
        if (bVar2 == null) {
            return constraintLayout;
        }
        View e17 = e(bVar2, Integer.valueOf(e16.getId()), d16.getId());
        constraintLayout.addView(e17);
        orNull3 = CollectionsKt___CollectionsKt.getOrNull(b16, 2);
        b bVar3 = (b) orNull3;
        if (bVar3 == null) {
            return constraintLayout;
        }
        constraintLayout.addView(e(bVar3, Integer.valueOf(e17.getId()), d16.getId()));
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.span.recommend.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.c(f.this, view);
            }
        });
        constraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams(this.mkMaxWidth, ViewUtils.dpToPx(81.0f)));
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        tt.a g16 = this$0.options.g();
        Intrinsics.checkNotNullExpressionValue(g16, "options.onReservedHiddenLinkClickListener");
        String c16 = this$0.parseResult.c();
        QLog.i("RecommendViewWrapper", 1, "onClickRecommendSpan|link=" + c16);
        String uri = this$0.parseResult.d().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "parseResult.src.toString()");
        String str = this$0.alt;
        Bundle EMPTY = Bundle.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        g16.a(view, uri, c16, str, 1, EMPTY);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View d() {
        int dpToPx = ViewUtils.dpToPx(48.0f);
        CommonImageView commonImageView = new CommonImageView(this.context);
        commonImageView.setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.topToTop = 0;
        layoutParams.leftToLeft = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(16.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(10.0f);
        commonImageView.setLayoutParams(layoutParams);
        commonImageView.setCornerRadiusAndMode(ViewUtils.dip2px(24.0f), 1);
        g(this.parseResult.a(), dpToPx, dpToPx, commonImageView, new a(commonImageView));
        return commonImageView;
    }

    private final View e(b lineContent, Integer topViewId, int leftViewId) {
        TextView textView = new TextView(this.context);
        textView.setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        if (topViewId == null) {
            layoutParams.topToTop = 0;
        } else {
            layoutParams.topToBottom = topViewId.intValue();
        }
        layoutParams.leftToRight = leftViewId;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(76.0f);
        if (topViewId == null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(10.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(5.0f);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ViewUtils.dpToPx(16.0f);
        textView.setLayoutParams(layoutParams);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (topViewId == null) {
            textView.setTextSize(14.0f);
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_primary));
        } else {
            textView.setTextSize(12.0f);
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_secondary));
        }
        textView.setText(lineContent.b());
        if (!TextUtils.isEmpty(lineContent.a())) {
            int dpToPx = ViewUtils.dpToPx(14.0f);
            g(lineContent.a(), dpToPx, dpToPx, null, new g(textView, this.context.getResources().getColor(R.color.qui_common_text_secondary)));
        }
        return textView;
    }

    private final void g(String url, int width, int height, ImageView targetView, IPicLoadStateListener listener) {
        Option options = Option.obtain().setUrl(url).setTargetView(targetView).setRequestHeight(height).setRequestWidth(width);
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(options, "options");
        iPicAIOApi.loadPic(options, listener);
    }

    @NotNull
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.view;
    }
}
