package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativepublish.fragment.FeedThirdPlatformVideoWebFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextCardContent;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J4\u0010\u001a\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014R\u0018\u0010!\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedSourceCardSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Landroid/widget/ImageView;", "targetView", "", "url", "", "size", "", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "context", "y", "moduleId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "d", "Landroid/view/View;", "cardLayout", "e", "Landroid/widget/ImageView;", "image", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "title", tl.h.F, QQWinkConstants.TAB_SUBTITLE, "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSourceCardSection extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View cardLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView image;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView subTitle;

    private final void x(ImageView targetView, String url, int size) {
        try {
            ColorDrawable colorDrawable = new ColorDrawable(0);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mRequestWidth = size;
            obtain.mRequestHeight = size;
            targetView.setImageDrawable(URLDrawable.getDrawable(new URL(url), obtain));
        } catch (Exception e16) {
            QLog.e("FeedSourceCardSection", 1, "loadDrawable error: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Context context, String url) {
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

    private final void z(String moduleId) {
        Map mapOf;
        View view = this.cardLayout;
        if (view != null) {
            ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_module_id", moduleId));
            com.tencent.mobileqq.guild.feed.report.d.d(view, "em_sgrp_module", clickPolicy, exposurePolicy, endExposurePolicy, mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1g};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView == null) {
            return;
        }
        this.cardLayout = containerView.findViewById(R.id.f87004t7);
        ImageView imageView = (ImageView) containerView.findViewById(R.id.f87014t8);
        this.image = imageView;
        if (imageView != null) {
            imageView.setAdjustViewBounds(false);
        }
        ImageView imageView2 = this.image;
        if (imageView2 != null) {
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        this.title = (TextView) containerView.findViewById(R.id.ar_);
        this.subTitle = (TextView) containerView.findViewById(R.id.tnj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!super.q(payload) && payload.getType() != 5) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        final GProStRichTextCardContent D = data.getFeedDetail().D();
        if (D != null) {
            ImageView imageView = this.image;
            if (imageView != null) {
                String str = D.logoUrl;
                Intrinsics.checkNotNullExpressionValue(str, "cardInfo.logoUrl");
                x(imageView, str, AlbumThumbDownloader.THUMB_WIDHT);
            }
            TextView textView = this.title;
            if (textView != null) {
                textView.setText(D.title);
            }
            TextView textView2 = this.subTitle;
            if (textView2 != null) {
                textView2.setText(D.stringAbstract);
            }
            final View view = this.cardLayout;
            if (view != null) {
                final long j3 = 200;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedSourceCardSection$onBindDataReally$$inlined$setSingleClickListener$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(final View it) {
                        EventCollector.getInstance().onViewClickedBefore(it);
                        view.setClickable(false);
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        final FeedSourceCardSection feedSourceCardSection = this;
                        final GProStRichTextCardContent gProStRichTextCardContent = D;
                        yl1.n.i("click_area_feed_item", 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedSourceCardSection$onBindDataReally$2$1
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
                                View view2;
                                Map mapOf;
                                FeedSourceCardSection feedSourceCardSection2 = FeedSourceCardSection.this;
                                Context context = it.getContext();
                                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                                String str2 = gProStRichTextCardContent.redirectUrl;
                                Intrinsics.checkNotNullExpressionValue(str2, "cardInfo.redirectUrl");
                                feedSourceCardSection2.y(context, str2);
                                view2 = FeedSourceCardSection.this.cardLayout;
                                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_module_id", gProStRichTextCardContent.cardId));
                                VideoReport.reportEvent("dt_clck", view2, mapOf);
                            }
                        }, 2, null);
                        final View view2 = view;
                        view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedSourceCardSection$onBindDataReally$$inlined$setSingleClickListener$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                view2.setClickable(true);
                            }
                        }, j3);
                        EventCollector.getInstance().onViewClicked(it);
                    }
                });
            }
            View view2 = this.cardLayout;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            String str2 = D.cardId;
            Intrinsics.checkNotNullExpressionValue(str2, "cardInfo.cardId");
            z(str2);
            return;
        }
        View view3 = this.cardLayout;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }
}
