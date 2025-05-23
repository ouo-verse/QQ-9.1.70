package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.vectordrawable.graphics.drawable.GuildVectorDrawableCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.main.view.GuildSummaryView;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import er1.DrawableType;
import er1.UnreadDotType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B+\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010#\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildManageNoticeItemView;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildBaseWidgetView;", "Lij1/n;", "", "initView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "n0", "", "m0", "data", "o0", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "objData", com.tencent.luggage.wxa.c8.c.G, "l0", "", "d", "Ljava/lang/String;", "guildId", "Lui1/b;", "e", "Lui1/b;", "feedUnreadRedPointDragHandler", "Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "f", "Lcom/tencent/mobileqq/guild/main/view/GuildSummaryView;", "mSummaryView", "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", tl.h.F, "Lcom/tencent/mobileqq/guild/mainframe/view/GuildDragTextView;", "mUnreadDotTextView", "Landroid/content/Context;", "context", "viewType", "<init>", "(Landroid/content/Context;ILjava/lang/String;Lui1/b;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildManageNoticeItemView extends GuildBaseWidgetView<ij1.n> {

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static WeakReference<DragFrameLayout> f224253m = new WeakReference<>(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ui1.b feedUnreadRedPointDragHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildSummaryView mSummaryView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildDragTextView mUnreadDotTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildManageNoticeItemView(@NotNull Context context, int i3, @NotNull String guildId, @NotNull ui1.b feedUnreadRedPointDragHandler) {
        super(context, null, 0, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(feedUnreadRedPointDragHandler, "feedUnreadRedPointDragHandler");
        this.guildId = guildId;
        this.feedUnreadRedPointDragHandler = feedUnreadRedPointDragHandler;
        initView();
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(m0(), (ViewGroup) this, true);
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        n0(rootView);
    }

    private final int m0() {
        return R.layout.exq;
    }

    private final void n0(View rootView) {
        View findViewById = rootView.findViewById(R.id.ztn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026impl.R.id.notice_summary)");
        this.mSummaryView = (GuildSummaryView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ztq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(co\u2026l.R.id.notice_unread_dot)");
        this.mUnreadDotTextView = (GuildDragTextView) findViewById2;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.yws);
        imageView.setImageDrawable(GuildVectorDrawableCompat.create(imageView.getResources(), R.drawable.guild_remind_icon, imageView.getContext().getTheme()));
    }

    private final void o0(ij1.n data) {
        final Bundle bundle = new Bundle();
        if (data != null) {
            bundle.putInt(IFileBrowserService.FILE_BROWSER_PAGE_FROM, data.getPageFrom());
        }
        final LinearLayout linearLayout = (LinearLayout) getRootView().findViewById(R.id.ywt);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.widget.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildManageNoticeItemView.p0(linearLayout, this, bundle, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(LinearLayout this_apply, GuildManageNoticeItemView this$0, Bundle extras, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        GuildNoticeFragment.Nh(this_apply.getContext(), this$0.guildId, 1, true, extras);
        ch.Y0(view, "em_sgrp_manage_notice_entry", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(@Nullable ij1.n objData, int pos) {
        boolean isBlank;
        o0(objData);
        GuildDragTextView guildDragTextView = null;
        if (objData != null) {
            GuildSummaryView guildSummaryView = this.mSummaryView;
            if (guildSummaryView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSummaryView");
                guildSummaryView = null;
            }
            guildSummaryView.setTextColor(R.color.qui_common_feedback_error, R.color.qui_common_text_secondary_light);
            GuildSummaryView guildSummaryView2 = this.mSummaryView;
            if (guildSummaryView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSummaryView");
                guildSummaryView2 = null;
            }
            String message = objData.b().getMessage();
            isBlank = StringsKt__StringsJVMKt.isBlank(message);
            if (!(!isBlank)) {
                message = null;
            }
            if (message == null) {
                message = "\u6682\u65e0\u6d88\u606f";
            }
            guildSummaryView2.setSummaryData(com.tencent.mobileqq.guild.summary.c.b(message));
            int count = objData.b().getRedPoint().getCount();
            int redPointType = objData.b().getRedPoint().getRedPointType();
            if (count <= 0) {
                GuildDragTextView guildDragTextView2 = this.mUnreadDotTextView;
                if (guildDragTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
                } else {
                    guildDragTextView = guildDragTextView2;
                }
                guildDragTextView.setVisibility(8);
                return;
            }
            GuildDragTextView guildDragTextView3 = this.mUnreadDotTextView;
            if (guildDragTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
                guildDragTextView3 = null;
            }
            guildDragTextView3.setVisibility(0);
            if (redPointType != 1 && redPointType != 2 && redPointType != 4) {
                GuildDragTextView guildDragTextView4 = this.mUnreadDotTextView;
                if (guildDragTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
                } else {
                    guildDragTextView = guildDragTextView4;
                }
                guildDragTextView.setVisibility(8);
                return;
            }
            GuildDragTextView guildDragTextView5 = this.mUnreadDotTextView;
            if (guildDragTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
                guildDragTextView5 = null;
            }
            QQGuildUIUtil.P(guildDragTextView5, count, new UnreadDotType(new DrawableType(R.drawable.guild_page_strong_unread_red_bg, null, 2, null), R.color.qui_common_text_allwhite_primary));
            return;
        }
        GuildDragTextView guildDragTextView6 = this.mUnreadDotTextView;
        if (guildDragTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
        } else {
            guildDragTextView = guildDragTextView6;
        }
        guildDragTextView.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GuildDragTextView guildDragTextView = null;
        f224253m = new WeakReference<>(null);
        ViewParent parent = getParent();
        while (true) {
            if (parent != null) {
                if (parent instanceof DragFrameLayout) {
                    break;
                } else {
                    parent = parent.getParent();
                }
            } else {
                parent = null;
                break;
            }
        }
        DragFrameLayout dragFrameLayout = (DragFrameLayout) parent;
        if (dragFrameLayout == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onAttachedToWindow: can not find DragFrameLayout");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildNoticeItemView", 1, (String) it.next(), null);
            }
            return;
        }
        f224253m = new WeakReference<>(dragFrameLayout);
        this.feedUnreadRedPointDragHandler.a(dragFrameLayout);
        GuildDragTextView guildDragTextView2 = this.mUnreadDotTextView;
        if (guildDragTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
            guildDragTextView2 = null;
        }
        guildDragTextView2.setOnModeChangeListener(this.feedUnreadRedPointDragHandler.c());
        GuildDragTextView guildDragTextView3 = this.mUnreadDotTextView;
        if (guildDragTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnreadDotTextView");
        } else {
            guildDragTextView = guildDragTextView3;
        }
        guildDragTextView.setDragViewType(10, getRootView());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DragFrameLayout dragFrameLayout = f224253m.get();
        if (dragFrameLayout == null) {
            return;
        }
        this.feedUnreadRedPointDragHandler.b(dragFrameLayout);
    }
}
