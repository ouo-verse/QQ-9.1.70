package com.tencent.mobileqq.guild.feed.util;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.feed.nativepublish.fragment.FeedThirdPlatformVideoWebFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J9\u0010\u0012\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\tj\u0002`\n2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/GuildFeedTencentDocUI;", "", "Landroid/content/Context;", "context", "", "url", "", "f", "e", "Lqj1/w;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/TencentDocInfo;", "docInfo", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "onClickListener", "c", "a", "Landroid/view/View;", "containerView", "b", "docLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "docTitle", "d", "docDsc", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedTencentDocUI {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View containerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View docLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView docTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView docDsc;

    public GuildFeedTencentDocUI(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.containerView = containerView;
        View findViewById = containerView.findViewById(R.id.f94055b9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026id.tencent_doc_container)");
        this.docLayout = findViewById;
        View findViewById2 = containerView.findViewById(R.id.uk7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.doc_title)");
        this.docTitle = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f165005uk4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.doc_dsc)");
        this.docDsc = (TextView) findViewById3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(GuildFeedTencentDocUI guildFeedTencentDocUI, qj1.w wVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        guildFeedTencentDocUI.c(wVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Context context, String url) {
        boolean z16 = true;
        Logger.f235387a.d().i("GuildFeedTencentDocUI", 1, "openNormalUrl " + url);
        if (url.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("fragment_class", FeedThirdPlatformVideoWebFragment.class.getCanonicalName());
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public final void c(@NotNull final qj1.w docInfo, @Nullable final Function1<? super View, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(docInfo, "docInfo");
        if (QLog.isColorLevel()) {
            QLog.d("GuildFeedTencentDocUI", 2, "bindTencentDocHolder coverUlr=" + docInfo.getUrl() + " docUrl=" + docInfo.getDocJumpUrl());
        }
        this.docTitle.setText(docInfo.getTitle());
        this.docDsc.setText(docInfo.getPlatformName() + "\uff5c" + docInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String());
        final View view = this.docLayout;
        final long j3 = 200;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedTencentDocUI$bind$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(final View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                view.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                final GuildFeedTencentDocUI guildFeedTencentDocUI = this;
                final qj1.w wVar = docInfo;
                final Function1 function1 = onClickListener;
                yl1.n.i("click_area_feed_item", 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedTencentDocUI$bind$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        View view2;
                        GuildFeedTencentDocUI guildFeedTencentDocUI2 = GuildFeedTencentDocUI.this;
                        view2 = guildFeedTencentDocUI2.containerView;
                        Context context = view2.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
                        guildFeedTencentDocUI2.f(context, wVar.getDocJumpUrl());
                        Function1<View, Unit> function12 = function1;
                        if (function12 != null) {
                            function12.invoke(it);
                        }
                    }
                }, 2, null);
                final View view2 = view;
                view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedTencentDocUI$bind$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view2.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        this.docLayout.setVisibility(0);
    }

    public final void e() {
        this.docLayout.setVisibility(8);
    }
}
