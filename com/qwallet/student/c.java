package com.qwallet.student;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.jsp.invoke.ChsiCertificationParams;
import com.tencent.mobileqq.qwallet.jsp.invoke.GuideParamItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001\bB\u001f\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qwallet/student/c;", "", "", "f", "", "url", "e", "Lcom/qwallet/student/ChsiCertificationFragment;", "a", "Lcom/qwallet/student/ChsiCertificationFragment;", "fragment", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "b", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "getParams", "()Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "params", "Landroid/view/View;", "c", "Landroid/view/View;", "guideLayout", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "guideText", "guideCloseBtn", "guideMoreText", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "g", "Ljava/util/HashSet;", "closedUrl", tl.h.F, "Ljava/lang/String;", "currentGuideUrl", "contentLayout", "<init>", "(Lcom/qwallet/student/ChsiCertificationFragment;Landroid/view/View;Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;)V", "i", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChsiCertificationFragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChsiCertificationParams params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View guideLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView guideText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View guideCloseBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View guideMoreText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> closedUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentGuideUrl;

    public c(@NotNull ChsiCertificationFragment fragment, @NotNull View contentLayout, @NotNull ChsiCertificationParams params) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(contentLayout, "contentLayout");
        Intrinsics.checkNotNullParameter(params, "params");
        this.fragment = fragment;
        this.params = params;
        View findViewById = contentLayout.findViewById(R.id.f8954502);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentLayout.findViewBy\u2026dent_verify_guide_layout)");
        this.guideLayout = findViewById;
        View findViewById2 = contentLayout.findViewById(R.id.f8956504);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentLayout.findViewBy\u2026tudent_verify_guide_text)");
        this.guideText = (TextView) findViewById2;
        View findViewById3 = contentLayout.findViewById(R.id.f8953501);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentLayout.findViewBy\u2026t_verify_guide_close_btn)");
        this.guideCloseBtn = findViewById3;
        View findViewById4 = contentLayout.findViewById(R.id.f8955503);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentLayout.findViewBy\u2026t_verify_guide_more_text)");
        this.guideMoreText = findViewById4;
        this.closedUrl = new HashSet<>();
        findViewById.setClickable(true);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.c(c.this, view);
            }
        });
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.d(c.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.guideLayout.setVisibility(8);
        String str = this$0.currentGuideUrl;
        if (str != null) {
            this$0.closedUrl.add(str);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.k.h(this$0.fragment.getContext(), this$0.params.getMoreURL());
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void e(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        for (GuideParamItem guideParamItem : this.params.a()) {
            if (!this.closedUrl.contains(guideParamItem.getGuideUrl()) && Pattern.compile(guideParamItem.getGuideUrl()).matcher(url).find()) {
                this.currentGuideUrl = guideParamItem.getGuideUrl();
                this.guideLayout.setVisibility(0);
                this.guideText.setText(guideParamItem.getGuideText());
                com.tencent.mobileqq.qwallet.c.f("studentAuth.chsiPage.show", guideParamItem.getGuideId(), null, null, null, 28, null);
                return;
            }
        }
    }

    public final void f() {
        this.guideLayout.setVisibility(8);
    }
}
