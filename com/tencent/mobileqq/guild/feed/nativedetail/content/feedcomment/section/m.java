package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import jl1.CommentCommonInfo;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0002\u0005\bB\u000f\u0012\u0006\u0010 \u001a\u00020\u001c\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\u000f\u0010\u001b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0017R\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m;", "Landroid/view/View$OnClickListener;", "Ljl1/a;", "commonInfo", "", "a", "c", "Lvl1/a;", "b", "Landroid/view/View;", "containerView", "e", "data", "", "position", "", "", "payload", "d", "remainingCount", tl.h.F, "(Ljl1/a;I)V", "g", "()V", "i", "v", NodeProps.ON_CLICK, "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;", "getDepends", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;", "depends", "I", "state", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/widget/TextView;", "Landroid/widget/TextView;", "foldTv", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "foldIv", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/LinearLayout;", "foldContainer", BdhLogUtil.LogTag.Tag_Conn, "loadingIv", "D", "loadingContainer", "Landroid/graphics/drawable/Drawable;", "E", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", UserInfo.SEX_FEMALE, "foldDrawable", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;)V", "G", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView loadingIv;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout loadingContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable loadingDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Drawable foldDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView foldTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView foldIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout foldContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/section/m$b;", "", "Lvl1/a;", "b", "", "d", "a", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a();

        @Nullable
        vl1.a b();

        void c();

        void d();
    }

    public m(@NotNull b depends) {
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
    }

    private final void a(CommentCommonInfo commonInfo) {
        FrameLayout frameLayout;
        Map mapOf;
        vl1.a b16 = b();
        if (b16 == null) {
            return;
        }
        String S3 = b16.S3(commonInfo.getItemGroupPosition());
        if (S3 == null) {
            S3 = "";
        }
        FrameLayout frameLayout2 = this.container;
        FrameLayout frameLayout3 = null;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout = null;
        } else {
            frameLayout = frameLayout2;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_p_comment_id", S3));
        com.tencent.mobileqq.guild.feed.report.d.f(frameLayout, "em_sgrp_expand_comment", clickPolicy, exposurePolicy, null, mapOf, 16, null);
        FrameLayout frameLayout4 = this.container;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            frameLayout3 = frameLayout4;
        }
        VideoReport.setElementReuseIdentifier(frameLayout3, S3);
    }

    private final vl1.a b() {
        return this.depends.b();
    }

    private final void c() {
        int i3 = this.state;
        if (i3 != 1) {
            if (i3 == 2) {
                this.depends.d();
                return;
            }
            return;
        }
        this.depends.a();
    }

    public final void d(@NotNull CommentCommonInfo data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.loadingIv;
        LinearLayout linearLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingIv");
            imageView = null;
        }
        imageView.setImageDrawable(this.loadingDrawable);
        ImageView imageView2 = this.foldIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldIv");
            imageView2 = null;
        }
        imageView2.setImageDrawable(this.foldDrawable);
        LinearLayout linearLayout2 = this.loadingContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(8);
        this.depends.c();
        a(data);
    }

    public final void e(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f73153ss);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.reply_item_fold_iv)");
        this.foldIv = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f73173su);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026(R.id.reply_item_fold_tv)");
        this.foldTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f73193sw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ply_item_loading_more_iv)");
        this.loadingIv = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f73143sr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026eply_item_fold_container)");
        this.container = (FrameLayout) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f73163st);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026em_fold_status_container)");
        this.foldContainer = (LinearLayout) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f73183sv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026y_item_loading_container)");
        this.loadingContainer = (LinearLayout) findViewById6;
        ol1.b bVar = ol1.b.f423088a;
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        this.loadingDrawable = bVar.d(context);
        FrameLayout frameLayout = this.container;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        FrameLayout frameLayout3 = this.container;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            frameLayout2 = frameLayout3;
        }
        yl1.n.f(frameLayout2, 12.0f);
        Context context2 = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "containerView.context");
        this.foldDrawable = GuildUIUtils.w(context2, R.drawable.qui_arrow_down, Integer.valueOf(R.color.qui_common_text_secondary_light));
    }

    public final void f() {
        LinearLayout linearLayout = this.foldContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        LinearLayout linearLayout3 = this.loadingContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setVisibility(0);
    }

    public final void g() {
        FrameLayout frameLayout = this.container;
        TextView textView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        LinearLayout linearLayout = this.foldContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        ImageView imageView = this.foldIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldIv");
            imageView = null;
        }
        imageView.setRotation(180.0f);
        TextView textView2 = this.foldTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldTv");
        } else {
            textView = textView2;
        }
        textView.setText("\u6536\u8d77\u56de\u590d");
        this.state = 2;
    }

    public final void h(@NotNull CommentCommonInfo commonInfo, int remainingCount) {
        Intrinsics.checkNotNullParameter(commonInfo, "commonInfo");
        FrameLayout frameLayout = this.container;
        ImageView imageView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
        LinearLayout linearLayout = this.foldContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        if (commonInfo.getExpandReplyListCount() >= 5) {
            TextView textView = this.foldTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("foldTv");
                textView = null;
            }
            TextView textView2 = this.foldTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("foldTv");
                textView2 = null;
            }
            textView.setText(textView2.getContext().getString(R.string.f144540p2));
        } else {
            TextView textView3 = this.foldTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("foldTv");
                textView3 = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            TextView textView4 = this.foldTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("foldTv");
                textView4 = null;
            }
            String string = textView4.getContext().getString(R.string.f144530p1);
            Intrinsics.checkNotNullExpressionValue(string, "foldTv.context.getString\u2026guild_feed_native_expand)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(remainingCount)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView3.setText(format);
        }
        ImageView imageView2 = this.foldIv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldIv");
        } else {
            imageView = imageView2;
        }
        imageView.setRotation(0.0f);
        this.state = 1;
    }

    public final void i() {
        FrameLayout frameLayout = this.container;
        LinearLayout linearLayout = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
        LinearLayout linearLayout2 = this.foldContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("foldContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(8);
        this.state = 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f73143sr) {
            c();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
