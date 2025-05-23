package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.ConfigBannerData;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00032\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/m;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/c;", "", ReportConstant.COSTREPORT_PREFIX, "r", "data", "", "event", "", HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "position", "", "payload", "v", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mPic", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends Section<ConfigBannerData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mPic;

    private final HashMap<String, Object> q(ConfigBannerData data) {
        HashMap<String, Object> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_url", u(data)));
        return hashMapOf;
    }

    private final int r() {
        return s() / 2;
    }

    private final int s() {
        return bi.d();
    }

    private final String t(ConfigBannerData data) {
        Object firstOrNull;
        String iconUrl;
        CharSequence trim;
        boolean isBlank;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data.getRaw().a());
        IGProRecommendContentItem iGProRecommendContentItem = (IGProRecommendContentItem) firstOrNull;
        if (iGProRecommendContentItem != null && (iconUrl = iGProRecommendContentItem.getH5kuikly().getIconUrl()) != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) iconUrl);
            String obj = trim.toString();
            if (obj != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(obj);
                if (!(!isBlank)) {
                    obj = null;
                }
                if (obj == null) {
                    return "";
                }
                return obj;
            }
            return "";
        }
        return "";
    }

    private final String u(ConfigBannerData data) {
        Object firstOrNull;
        String jumpUrl;
        CharSequence trim;
        boolean isBlank;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data.getRaw().a());
        IGProRecommendContentItem iGProRecommendContentItem = (IGProRecommendContentItem) firstOrNull;
        if (iGProRecommendContentItem != null && (jumpUrl = iGProRecommendContentItem.getH5kuikly().getJumpUrl()) != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) jumpUrl);
            String obj = trim.toString();
            if (obj != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(obj);
                if (!(!isBlank)) {
                    obj = null;
                }
                if (obj == null) {
                    return "";
                }
                return obj;
            }
            return "";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(m this$0, String jumpUrl, ConfigBannerData data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(jumpUrl, "$jumpUrl");
        Intrinsics.checkNotNullParameter(data, "$data");
        Logger.f235387a.d().d("RecommendFeedBannerSection", 1, "[openSchema] jumpUrl " + jumpUrl);
        ImageView imageView = this$0.mPic;
        Activity activity = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView = null;
        }
        Context context = imageView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        GuildJumpUtil.w(activity, jumpUrl);
        this$0.x(data, "clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(ConfigBannerData data, String event) {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ImageView imageView = this.mPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView = null;
        }
        iGuildDTReportApi.reportDtEventManual(imageView, "em_sgrp_banner", event, q(data));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        if (containerView != null) {
            ViewGroup.LayoutParams layoutParams2 = containerView.getLayoutParams();
            if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.setFullSpan(true);
            }
            View findViewById = containerView.findViewById(R.id.w5h);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026discovery_v2_feed_banner)");
            this.mPic = (ImageView) findViewById;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final ConfigBannerData data, int position, @Nullable List<Object> payload) {
        boolean z16;
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        boolean z17;
        String str;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(data, "data");
        List<Object> list = payload;
        boolean z18 = false;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.mRootView.getLayoutParams();
        ImageView imageView2 = null;
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
        ImageView imageView3 = this.mPic;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPic");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        String t16 = t(data);
        if (t16.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            str = t16;
        } else {
            str = null;
        }
        if (str != null) {
            ImageView imageView4 = this.mPic;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPic");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
            ImageView imageView5 = this.mPic;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPic");
                imageView = null;
            } else {
                imageView = imageView5;
            }
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, str, s(), r(), false, 16, null);
        }
        final String u16 = u(data);
        if (u16.length() > 0) {
            z18 = true;
        }
        if (!z18) {
            u16 = null;
        }
        if (u16 != null) {
            ImageView imageView6 = this.mPic;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPic");
            } else {
                imageView2 = imageView6;
            }
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.w(m.this, u16, data, view);
                }
            });
        }
        x(data, "imp");
    }
}
