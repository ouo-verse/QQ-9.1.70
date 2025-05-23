package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.InputStyleConfig;
import wk1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u0018\u001a\u00020\u00042\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "j", tl.h.F, "k", "g", "", "commentCount", "l", "init", "", "action", "", "msg", "c", "", "enable", "u1", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "bottomInteractData", "b", "Lwk1/h;", "d", "Lwk1/h;", "inputContext", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "commentTv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "commentBtn", "Landroid/view/ViewGroup;", "commentLayout", "<init>", "(Lwk1/h;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView commentTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView commentBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup commentLayout;

    public b(@NotNull wk1.h inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
    }

    private final void g() {
        HashMap<String, Object> hashMap;
        Map<? extends String, ? extends Object> mapOf;
        ViewGroup viewGroup = this.commentLayout;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
            viewGroup = null;
        }
        if (o.a(viewGroup)) {
            QLog.i("MainInputCommentUI", 1, "handleCommentLayoutClick isFastClick");
            return;
        }
        wk1.e c16 = this.inputContext.c();
        if (c16 == null || (hashMap = c16.b()) == null) {
            hashMap = new HashMap<>();
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_click_region", 2));
        hashMap.putAll(mapOf);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ViewGroup viewGroup3 = this.commentLayout;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
        } else {
            viewGroup2 = viewGroup3;
        }
        iGuildDTReportApi.reportDtEventManual(viewGroup2, "em_sgrp_forum_comment", "clck", hashMap);
        QLog.i("MainInputCommentUI", 1, "handleCommentLayoutClick comment feed");
        this.inputContext.getDelegate().lh("message_comment_icon_feed", new a.CommentFeedMessage("MainInputCommentUI", new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_COMMENT_FEED, null, 0, (short) 2, null, 16, null)));
    }

    private final void h(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.b4g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.comment_layout)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.commentLayout = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.i(b.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(ViewGroup rootView) {
        Integer iconColor;
        View findViewById = rootView.findViewById(R.id.f164861b54);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.comment_tv)");
        this.commentTv = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.b4f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.comment_iv)");
        this.commentBtn = (ImageView) findViewById2;
        InputStyleConfig d16 = this.inputContext.d();
        if (d16 != null && (iconColor = d16.getIconColor()) != null) {
            int intValue = iconColor.intValue();
            TextView textView = this.commentTv;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentTv");
                textView = null;
            }
            textView.setTextColor(intValue);
            ImageView imageView2 = this.commentBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentBtn");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(GuildUIUtils.y(this.inputContext.getContext(), R.drawable.guild_feed_item_comment_icon_normal, intValue));
        }
    }

    private final void k() {
        Map mapOf;
        wk1.e c16 = this.inputContext.c();
        boolean z16 = false;
        if (c16 != null && c16.a()) {
            z16 = true;
        }
        if (z16) {
            ViewGroup viewGroup = this.commentLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
                viewGroup = null;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_click_region", 2));
            bt.d(viewGroup, "em_sgrp_forum_comment", mapOf, ClickPolicy.REPORT_NONE, null, EndExposurePolicy.REPORT_NONE, 16, null);
        }
    }

    private final void l(int commentCount) {
        boolean z16;
        String str;
        String h16 = bl1.b.h(bl1.b.f28597a, commentCount, null, null, 6, null);
        TextView textView = this.commentTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentTv");
            textView = null;
        }
        if (h16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = this.inputContext.getContext().getString(R.string.f144490ox);
            Intrinsics.checkNotNullExpressionValue(str, "inputContext.context.get\u2026tive_detail_comment_tips)");
        } else {
            str = h16;
        }
        textView.setText(str);
        QLog.i("MainInputCommentUI", 1, "updateCommentUI commentCount = " + commentCount + " showCount = " + h16);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void a() {
        d.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void b(@NotNull qj1.b bottomInteractData) {
        Intrinsics.checkNotNullParameter(bottomInteractData, "bottomInteractData");
        l(bottomInteractData.getCommentCount());
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        wk1.e c16;
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "message_on_bottom_interact_exposure") && (c16 = this.inputContext.c()) != null) {
            ViewGroup viewGroup = this.commentLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
                viewGroup = null;
            }
            e.a.c(c16, viewGroup, 3, null, 4, null);
        }
    }

    @Override // wk1.j
    @Nullable
    public Object d(@NotNull String str, @Nullable Object obj) {
        return d.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void e(@NotNull SpeakPermissionType speakPermissionType) {
        d.a.e(this, speakPermissionType);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void init(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        j(rootView);
        h(rootView);
        k();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void u1(boolean enable) {
        bl1.d dVar = bl1.d.f28604a;
        ViewGroup viewGroup = this.commentLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentLayout");
            viewGroup = null;
        }
        dVar.a(viewGroup, enable);
    }
}
