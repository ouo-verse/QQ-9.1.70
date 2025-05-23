package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.InnerDetailCommentLoadingStatusSection;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u001b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/InnerDetailCommentLoadingStatusSection;", "Lhl1/b;", "Ljl1/g;", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "", "d", UserInfo.SEX_FEMALE, "emptyStateTopMarginDP", "e", "I", "emptyStateTitleTextColor", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "loadingIv", "i", "Landroid/view/View;", "emptyStateView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/InnerDetailCommentLoadingStatusSection$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/InnerDetailCommentLoadingStatusSection$b;", "debounceExecutor", "<init>", "(FI)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class InnerDetailCommentLoadingStatusSection extends hl1.b<jl1.g> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float emptyStateTopMarginDP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int emptyStateTitleTextColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View emptyStateView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b debounceExecutor = new b(300);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/InnerDetailCommentLoadingStatusSection$b;", "", "Lkotlin/Function0;", "", "action", "b", "", "a", "J", "minInterval", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "c", "lastExecutionTime", "", "d", "Z", "isPending", "<init>", "(J)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long minInterval;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler handler = new Handler(Looper.getMainLooper());

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long lastExecutionTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isPending;

        public b(long j3) {
            this.minInterval = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, Function0 action) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(action, "$action");
            this$0.isPending = false;
            action.invoke();
            this$0.lastExecutionTime = System.currentTimeMillis();
        }

        public final void b(@NotNull final Function0<Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            long currentTimeMillis = System.currentTimeMillis() - this.lastExecutionTime;
            if (currentTimeMillis >= this.minInterval) {
                action.invoke();
                this.lastExecutionTime = System.currentTimeMillis();
            } else if (!this.isPending) {
                this.isPending = true;
                this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        InnerDetailCommentLoadingStatusSection.b.c(InnerDetailCommentLoadingStatusSection.b.this, action);
                    }
                }, this.minInterval - currentTimeMillis);
            }
        }
    }

    public InnerDetailCommentLoadingStatusSection(float f16, int i3) {
        this.emptyStateTopMarginDP = f16;
        this.emptyStateTitleTextColor = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View s() {
        View view = this.emptyStateView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            return view;
        }
        ViewGroup viewGroup = this.container;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        GuildQUIEmptyState.a s16 = new GuildQUIEmptyState.a(viewGroup.getContext()).s(4);
        String qqStr = HardCodeUtil.qqStr(R.string.f144660pd);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_feed_no_more_comment)");
        GuildQUIEmptyState a16 = s16.u(qqStr).r(true).o(0).p("\u53bb\u8bc4\u8bba", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InnerDetailCommentLoadingStatusSection.t(InnerDetailCommentLoadingStatusSection.this, view2);
            }
        }).a();
        a16.setTitleColor(R.color.qui_common_text_secondary, 1000);
        this.emptyStateView = a16;
        TextView textView = (TextView) a16.findViewById(R.id.uup);
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            viewGroup2 = viewGroup3;
        }
        View view2 = this.emptyStateView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = ViewUtils.dpToPx(this.emptyStateTopMarginDP);
        Unit unit = Unit.INSTANCE;
        viewGroup2.addView(view2, layoutParams);
        View view3 = this.emptyStateView;
        Intrinsics.checkNotNull(view3);
        return view3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(InnerDetailCommentLoadingStatusSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View rootView = this$0.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        wk1.i iVar = (wk1.i) yl1.n.s(rootView, wk1.i.class);
        if (iVar != null) {
            iVar.lh("message_comment_box_feed", new a.CommentFeedMessage("DetailCommentLoadingSection", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_COMMENT_FEED, null, 0, (short) 5, null, 16, null)));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w7z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026detail_loading_container)");
        this.container = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.w8h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026omment_status_loading_iv)");
        this.loadingIv = (ImageView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final jl1.g data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        Iterator<View> it = ViewGroupKt.getChildren(viewGroup).iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        this.debounceExecutor.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section.InnerDetailCommentLoadingStatusSection$onBindData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                View s16;
                ImageView imageView;
                ImageView imageView2;
                int loadingStatus = jl1.g.this.getLoadingStatus();
                if (loadingStatus != 0) {
                    if (loadingStatus == 1) {
                        imageView = this.loadingIv;
                        ImageView imageView3 = null;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingIv");
                            imageView = null;
                        }
                        ol1.b bVar = ol1.b.f423088a;
                        Context context = this.getRootView().getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                        imageView.setImageDrawable(bVar.d(context));
                        imageView2 = this.loadingIv;
                        if (imageView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingIv");
                        } else {
                            imageView3 = imageView2;
                        }
                        imageView3.setVisibility(0);
                        return;
                    }
                    if (loadingStatus != 2) {
                        return;
                    }
                }
                s16 = this.s();
                s16.setVisibility(0);
            }
        });
    }
}
