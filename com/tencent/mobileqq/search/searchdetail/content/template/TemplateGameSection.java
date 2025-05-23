package com.tencent.mobileqq.search.searchdetail.content.template;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.widgets.bj;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqecommerce.biz.game.api.IECGameButtonApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchGameTemplateItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchGameButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchHeadTopic;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import hp2.ah;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016J(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/TemplateGameSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/e;", "", "p0", "n0", "Landroid/content/Context;", "context", "", "url", "Landroid/view/View;", "d0", "o0", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "icon", "e0", "", "getViewStubLayoutId", "", "G", "()Ljava/lang/Integer;", "containerView", "y", "data", "position", "", "", "payload", "i0", "Lhp2/ah;", "D", "Lhp2/ah;", "binding", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHeadTopic;", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchHeadTopic;", "model", UserInfo.SEX_FEMALE, "I", "itemPosition", "", "Z", "isExpanded", "<init>", "()V", "H", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TemplateGameSection extends BaseSearchTemplateSection<NetSearchGameTemplateItem> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ah binding;

    /* renamed from: E, reason: from kotlin metadata */
    private SearchHeadTopic model;

    /* renamed from: F, reason: from kotlin metadata */
    private int itemPosition = -1;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isExpanded;

    private final View d0(Context context, String url) {
        ImageView imageView = new ImageView(context);
        u.c(imageView, url, null, 2, null);
        u.e(imageView, bj.a(10));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(bj.a(10));
        gradientDrawable.setStroke(bj.a(1), -1);
        imageView.setBackground(gradientDrawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    private final View e0(Context context, final SearchIcon icon) {
        boolean z16;
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setId(View.generateViewId());
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplateGameSection.g0(TemplateGameSection.this, icon, view);
            }
        });
        final SearchReportInfo reportInfo = icon.reportInfo;
        if (reportInfo != null) {
            Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
            V(constraintLayout, reportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateGameSection$buildIcon$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    int i3;
                    TemplateGameSection templateGameSection = TemplateGameSection.this;
                    SearchReportInfo searchReportInfo = reportInfo;
                    i3 = templateGameSection.itemPosition;
                    return BaseSearchTemplateSection.S(templateGameSection, searchReportInfo, templateGameSection.T(i3), null, 2, null);
                }
            }, String.valueOf(reportInfo.hashCode()));
        }
        ImageView imageView = new ImageView(context);
        imageView.setId(View.generateViewId());
        String str = icon.iconLink;
        Intrinsics.checkNotNullExpressionValue(str, "icon.iconLink");
        u.c(imageView, str, null, 2, null);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(bj.a(24), bj.a(24));
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        Unit unit = Unit.INSTANCE;
        constraintLayout.addView(imageView, layoutParams);
        String titleText = icon.title.text;
        Intrinsics.checkNotNullExpressionValue(titleText, "titleText");
        if (titleText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView = new TextView(context);
            textView.setId(View.generateViewId());
            textView.setText(titleText);
            textView.setMaxWidth(bj.a(70));
            textView.setTextSize(2, 14.0f);
            textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextAlignment(4);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, -2);
            layoutParams2.topToBottom = imageView.getId();
            layoutParams2.startToStart = 0;
            layoutParams2.bottomToBottom = 0;
            layoutParams2.endToEnd = 0;
            layoutParams2.setMargins(0, bj.a(4), 0, 0);
            constraintLayout.addView(textView, layoutParams2);
        }
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(TemplateGameSection this$0, SearchIcon icon, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(icon, "$icon");
        g.a.a(this$0, icon.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(TemplateGameSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchHeadTopic searchHeadTopic = this$0.model;
        if (searchHeadTopic == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            searchHeadTopic = null;
        }
        g.a.a(this$0, searchHeadTopic.text.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(TemplateGameSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isExpanded = !this$0.isExpanded;
        this$0.p0();
        this$0.o0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(String str, TemplateGameSection this$0, LoadState loadState, Option option) {
        Bitmap resultBitMap;
        ah ahVar;
        ImageView imageView;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState != null && option != null && loadState.isFinishSuccess() && Intrinsics.areEqual(str, option.getUrl()) && (resultBitMap = option.getResultBitMap()) != null && resultBitMap.getWidth() > 0 && resultBitMap.getHeight() > 0 && (ahVar = this$0.binding) != null && (imageView = ahVar.f405579k) != null && (layoutParams = imageView.getLayoutParams()) != null) {
            layoutParams.width = (layoutParams.height * resultBitMap.getWidth()) / resultBitMap.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(TemplateGameSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchHeadTopic searchHeadTopic = this$0.model;
        if (searchHeadTopic == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
            searchHeadTopic = null;
        }
        g.a.a(this$0, searchHeadTopic.button.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n0() {
        boolean z16;
        boolean z17;
        ah ahVar = this.binding;
        if (ahVar != null) {
            SearchHeadTopic searchHeadTopic = this.model;
            SearchHeadTopic searchHeadTopic2 = null;
            if (searchHeadTopic == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic = null;
            }
            boolean z18 = true;
            if (searchHeadTopic.avatarGroupList.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            SearchHeadTopic searchHeadTopic3 = this.model;
            if (searchHeadTopic3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic3 = null;
            }
            String str = searchHeadTopic3.avatarText;
            Intrinsics.checkNotNullExpressionValue(str, "model.avatarText");
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            Context context = ahVar.f405571c.getContext();
            ahVar.f405571c.removeAllViews();
            ConstraintLayout constraintLayout = ahVar.f405571c;
            Boolean valueOf = Boolean.valueOf(z16);
            constraintLayout.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, constraintLayout)) == null) {
                constraintLayout.setVisibility(8);
            }
            TextView textView = ahVar.f405570b;
            Boolean valueOf2 = Boolean.valueOf(z17);
            textView.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, textView)) == null) {
                textView.setVisibility(8);
            }
            SearchHeadTopic searchHeadTopic4 = this.model;
            if (searchHeadTopic4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic4 = null;
            }
            ArrayList<String> arrayList = searchHeadTopic4.avatarGroupList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "model.avatarGroupList");
            int i3 = 0;
            for (Object obj : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String avatar = (String) obj;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNullExpressionValue(avatar, "avatar");
                View d06 = d0(context, avatar);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(bj.a(20), bj.a(20));
                layoutParams.startToStart = 0;
                layoutParams.topToTop = 0;
                layoutParams.setMargins(i3 * bj.a(12), 0, 0, 0);
                ahVar.f405571c.addView(d06, layoutParams);
                i3 = i16;
            }
            TextView textView2 = ahVar.f405570b;
            SearchHeadTopic searchHeadTopic5 = this.model;
            if (searchHeadTopic5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic5 = null;
            }
            String str2 = searchHeadTopic5.avatarText;
            Intrinsics.checkNotNullExpressionValue(str2, "model.avatarText");
            if (str2.length() <= 0) {
                z18 = false;
            }
            Boolean valueOf3 = Boolean.valueOf(z18);
            textView2.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf3, textView2)) == null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = ahVar.f405570b;
            SearchHeadTopic searchHeadTopic6 = this.model;
            if (searchHeadTopic6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            } else {
                searchHeadTopic2 = searchHeadTopic6;
            }
            textView3.setText(searchHeadTopic2.avatarText);
        }
    }

    private final void o0() {
        boolean z16;
        int min;
        ah ahVar = this.binding;
        if (ahVar != null) {
            ConstraintLayout constraintLayout = ahVar.f405577i;
            SearchHeadTopic searchHeadTopic = this.model;
            if (searchHeadTopic == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic = null;
            }
            if (searchHeadTopic.iconList.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            constraintLayout.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, constraintLayout)) == null) {
                constraintLayout.setVisibility(8);
            }
            ahVar.f405577i.removeAllViews();
            Context context = ahVar.f405577i.getContext();
            if (this.isExpanded) {
                SearchHeadTopic searchHeadTopic2 = this.model;
                if (searchHeadTopic2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic2 = null;
                }
                min = searchHeadTopic2.iconList.size();
            } else {
                SearchHeadTopic searchHeadTopic3 = this.model;
                if (searchHeadTopic3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic3 = null;
                }
                min = Math.min(searchHeadTopic3.iconList.size(), 4);
            }
            for (int i3 = 0; i3 < min; i3++) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                SearchHeadTopic searchHeadTopic4 = this.model;
                if (searchHeadTopic4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic4 = null;
                }
                SearchIcon searchIcon = searchHeadTopic4.iconList.get(i3);
                Intrinsics.checkNotNullExpressionValue(searchIcon, "model.iconList[i]");
                ahVar.f405577i.addView(e0(context, searchIcon), new ConstraintLayout.LayoutParams(0, -2));
            }
            ConstraintLayout iconsLayout = ahVar.f405577i;
            Intrinsics.checkNotNullExpressionValue(iconsLayout, "iconsLayout");
            com.tencent.mobileqq.search.util.l.e(iconsLayout, 4, bj.a(16), bj.a(8), bj.a(16), false);
        }
    }

    private final void p0() {
        String str;
        int i3;
        ah ahVar = this.binding;
        if (ahVar != null) {
            TextView textView = ahVar.f405586r;
            if (this.isExpanded) {
                str = "\u6536\u8d77";
            } else {
                str = "\u67e5\u770b\u66f4\u591a";
            }
            textView.setText(str);
            if (this.isExpanded) {
                i3 = R.drawable.qui_chevron_up_icon_secondary_01;
            } else {
                i3 = R.drawable.qui_chevron_down_icon_secondary;
            }
            ahVar.f405584p.setImageResource(i3);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    @NotNull
    public Integer G() {
        return Integer.valueOf(R.id.b9w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull NetSearchGameTemplateItem data, int position, @Nullable List<Object> payload) {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        SearchHeadTopic searchHeadTopic;
        SearchReportInfo searchReportInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        this.model = data.getHeadTopic();
        this.itemPosition = position;
        ah ahVar = this.binding;
        if (ahVar != null) {
            View view = ahVar.f405576h;
            Boolean valueOf = Boolean.valueOf(data.getLayoutInfo().showDivider);
            view.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, view)) == null) {
                view.setVisibility(8);
            }
            SearchHeadTopic searchHeadTopic2 = this.model;
            if (searchHeadTopic2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic2 = null;
            }
            String str = searchHeadTopic2.background;
            Intrinsics.checkNotNullExpressionValue(str, "model.background");
            boolean z28 = true;
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ImageView imageView = ahVar.f405578j;
            Boolean valueOf2 = Boolean.valueOf(z16);
            imageView.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, imageView)) == null) {
                imageView.setVisibility(8);
            }
            View view2 = ahVar.f405580l;
            Boolean valueOf3 = Boolean.valueOf(z16);
            view2.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf3, view2)) == null) {
                view2.setVisibility(8);
            }
            View view3 = ahVar.f405581m;
            Boolean valueOf4 = Boolean.valueOf(z16);
            view3.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf4, view3)) == null) {
                view3.setVisibility(8);
            }
            if (z16) {
                ImageView imageOverlay = ahVar.f405578j;
                Intrinsics.checkNotNullExpressionValue(imageOverlay, "imageOverlay");
                SearchHeadTopic searchHeadTopic3 = this.model;
                if (searchHeadTopic3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic3 = null;
                }
                String str2 = searchHeadTopic3.background;
                Intrinsics.checkNotNullExpressionValue(str2, "model.background");
                u.c(imageOverlay, str2, null, 2, null);
            }
            ViewGroup.LayoutParams layoutParams = ahVar.f405581m.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (z16) {
                i3 = bj.a((int) (100 - data.getLayoutInfo().marginTop));
            } else {
                i3 = 0;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = i3;
            ahVar.f405581m.setLayoutParams(layoutParams2);
            SearchHeadTopic searchHeadTopic4 = this.model;
            if (searchHeadTopic4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic4 = null;
            }
            final String logoUrl = searchHeadTopic4.topIcon.iconLink;
            Intrinsics.checkNotNullExpressionValue(logoUrl, "logoUrl");
            if (logoUrl.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            ImageView imageView2 = ahVar.f405579k;
            Boolean valueOf5 = Boolean.valueOf(z17);
            imageView2.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf5, imageView2)) == null) {
                imageView2.setVisibility(8);
            }
            if (z17) {
                ImageView logo = ahVar.f405579k;
                Intrinsics.checkNotNullExpressionValue(logo, "logo");
                u.b(logo, logoUrl, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.n
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        TemplateGameSection.l0(logoUrl, this, loadState, option);
                    }
                });
            }
            TextView textView = ahVar.f405583o;
            SearchHeadTopic searchHeadTopic5 = this.model;
            if (searchHeadTopic5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic5 = null;
            }
            textView.setText(searchHeadTopic5.title.text);
            TextView textView2 = ahVar.f405582n;
            SearchHeadTopic searchHeadTopic6 = this.model;
            if (searchHeadTopic6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic6 = null;
            }
            String str3 = searchHeadTopic6.subTitle.text;
            Intrinsics.checkNotNullExpressionValue(str3, "model.subTitle.text");
            if (str3.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            Boolean valueOf6 = Boolean.valueOf(z18);
            textView2.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf6, textView2)) == null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = ahVar.f405582n;
            SearchHeadTopic searchHeadTopic7 = this.model;
            if (searchHeadTopic7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic7 = null;
            }
            textView3.setText(searchHeadTopic7.subTitle.text);
            SearchHeadTopic searchHeadTopic8 = this.model;
            if (searchHeadTopic8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic8 = null;
            }
            String str4 = searchHeadTopic8.appInfo.name;
            Intrinsics.checkNotNullExpressionValue(str4, "model.appInfo.name");
            if (str4.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                Button button = ahVar.f405573e;
                Boolean bool = Boolean.TRUE;
                button.setVisibility(0);
                if (((View) com.tencent.guild.aio.util.ex.g.a(bool, button)) == null) {
                    button.setVisibility(8);
                }
                Context context = ahVar.f405573e.getContext();
                SearchHeadTopic searchHeadTopic9 = this.model;
                if (searchHeadTopic9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic9 = null;
                }
                SearchReportInfo searchReportInfo2 = searchHeadTopic9.appInfo.reportInfo;
                Intrinsics.checkNotNullExpressionValue(searchReportInfo2, "model.appInfo.reportInfo");
                JSONObject S = BaseSearchTemplateSection.S(this, searchReportInfo2, O(position), null, 2, null);
                IECGameButtonApi iECGameButtonApi = (IECGameButtonApi) QRoute.api(IECGameButtonApi.class);
                Intrinsics.checkNotNullExpressionValue(context, "context");
                SearchHeadTopic searchHeadTopic10 = this.model;
                if (searchHeadTopic10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic10 = null;
                }
                SearchGameButton searchGameButton = searchHeadTopic10.appInfo;
                Intrinsics.checkNotNullExpressionValue(searchGameButton, "model.appInfo");
                View createGameButton = iECGameButtonApi.createGameButton(context, m.a(searchGameButton, S));
                createGameButton.setId(View.generateViewId());
                ConstraintLayout constraintLayout = ahVar.f405574f;
                ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(bj.a(60), bj.a(29));
                layoutParams3.startToEnd = ahVar.f405583o.getId();
                layoutParams3.topToTop = ahVar.f405583o.getId();
                layoutParams3.endToEnd = 0;
                Unit unit = Unit.INSTANCE;
                constraintLayout.addView(createGameButton, layoutParams3);
                TextView textView4 = ahVar.f405583o;
                ViewGroup.LayoutParams layoutParams4 = textView4.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams4;
                layoutParams5.endToStart = createGameButton.getId();
                textView4.setLayoutParams(layoutParams5);
            } else {
                SearchHeadTopic searchHeadTopic11 = this.model;
                if (searchHeadTopic11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                    searchHeadTopic11 = null;
                }
                String str5 = searchHeadTopic11.button.title;
                Intrinsics.checkNotNullExpressionValue(str5, "model.button.title");
                if (str5.length() > 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    Button button2 = ahVar.f405573e;
                    Boolean bool2 = Boolean.TRUE;
                    button2.setVisibility(0);
                    if (((View) com.tencent.guild.aio.util.ex.g.a(bool2, button2)) == null) {
                        button2.setVisibility(8);
                    }
                    Button doOnBindData$lambda$14$lambda$7$lambda$6 = ahVar.f405573e;
                    SearchHeadTopic searchHeadTopic12 = this.model;
                    if (searchHeadTopic12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("model");
                        searchHeadTopic12 = null;
                    }
                    doOnBindData$lambda$14$lambda$7$lambda$6.setText(searchHeadTopic12.button.title);
                    doOnBindData$lambda$14$lambda$7$lambda$6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.o
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            TemplateGameSection.m0(TemplateGameSection.this, view4);
                        }
                    });
                    SearchHeadTopic searchHeadTopic13 = this.model;
                    if (searchHeadTopic13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("model");
                        searchHeadTopic13 = null;
                    }
                    final SearchReportInfo reportInfo = searchHeadTopic13.button.reportInfo;
                    if (reportInfo != null) {
                        Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                        String str6 = reportInfo.eid;
                        String valueOf7 = String.valueOf(reportInfo.hashCode());
                        Intrinsics.checkNotNullExpressionValue(doOnBindData$lambda$14$lambda$7$lambda$6, "doOnBindData$lambda$14$lambda$7$lambda$6");
                        V(doOnBindData$lambda$14$lambda$7$lambda$6, str6, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateGameSection$doOnBindData$1$4$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final JSONObject invoke() {
                                int i16;
                                TemplateGameSection templateGameSection = TemplateGameSection.this;
                                SearchReportInfo searchReportInfo3 = reportInfo;
                                i16 = templateGameSection.itemPosition;
                                return BaseSearchTemplateSection.S(templateGameSection, searchReportInfo3, templateGameSection.T(i16), null, 2, null);
                            }
                        }, valueOf7);
                    }
                } else {
                    Button button3 = ahVar.f405573e;
                    Boolean bool3 = Boolean.FALSE;
                    button3.setVisibility(0);
                    if (((View) com.tencent.guild.aio.util.ex.g.a(bool3, button3)) == null) {
                        button3.setVisibility(8);
                    }
                }
            }
            n0();
            TextView doOnBindData$lambda$14$lambda$10$lambda$9 = ahVar.f405575g;
            SearchHeadTopic searchHeadTopic14 = this.model;
            if (searchHeadTopic14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic14 = null;
            }
            String text = searchHeadTopic14.text.getText();
            Intrinsics.checkNotNullExpressionValue(text, "model.text.getText()");
            if (text.length() > 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            Boolean valueOf8 = Boolean.valueOf(z27);
            doOnBindData$lambda$14$lambda$10$lambda$9.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf8, doOnBindData$lambda$14$lambda$10$lambda$9)) == null) {
                doOnBindData$lambda$14$lambda$10$lambda$9.setVisibility(8);
            }
            SearchHeadTopic searchHeadTopic15 = this.model;
            if (searchHeadTopic15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic15 = null;
            }
            doOnBindData$lambda$14$lambda$10$lambda$9.setText(searchHeadTopic15.text.getText());
            doOnBindData$lambda$14$lambda$10$lambda$9.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    TemplateGameSection.j0(TemplateGameSection.this, view4);
                }
            });
            SearchHeadTopic searchHeadTopic16 = this.model;
            if (searchHeadTopic16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic16 = null;
            }
            final SearchReportInfo reportInfo2 = searchHeadTopic16.text.reportInfo;
            if (reportInfo2 != null) {
                Intrinsics.checkNotNullExpressionValue(reportInfo2, "reportInfo");
                String str7 = reportInfo2.eid;
                String valueOf9 = String.valueOf(reportInfo2.hashCode());
                Intrinsics.checkNotNullExpressionValue(doOnBindData$lambda$14$lambda$10$lambda$9, "doOnBindData$lambda$14$lambda$10$lambda$9");
                V(doOnBindData$lambda$14$lambda$10$lambda$9, str7, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateGameSection$doOnBindData$1$5$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final JSONObject invoke() {
                        int i16;
                        TemplateGameSection templateGameSection = TemplateGameSection.this;
                        SearchReportInfo searchReportInfo3 = reportInfo2;
                        i16 = templateGameSection.itemPosition;
                        return BaseSearchTemplateSection.S(templateGameSection, searchReportInfo3, templateGameSection.T(i16), null, 2, null);
                    }
                }, valueOf9);
            }
            o0();
            SearchHeadTopic searchHeadTopic17 = this.model;
            if (searchHeadTopic17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
                searchHeadTopic = null;
            } else {
                searchHeadTopic = searchHeadTopic17;
            }
            if (searchHeadTopic.iconList.size() <= 4) {
                z28 = false;
            }
            LinearLayout linearLayout = ahVar.f405585q;
            Boolean valueOf10 = Boolean.valueOf(z28);
            linearLayout.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf10, linearLayout)) == null) {
                linearLayout.setVisibility(8);
            }
            if (z28) {
                p0();
                ahVar.f405585q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        TemplateGameSection.k0(TemplateGameSection.this, view4);
                    }
                });
                final com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = data.getReportInfoWrapper();
                if (reportInfoWrapper != null && (searchReportInfo = reportInfoWrapper.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String()) != null) {
                    View toggleLayout = ahVar.f405585q;
                    String str8 = searchReportInfo.eid;
                    String valueOf11 = String.valueOf(searchReportInfo.hashCode());
                    Intrinsics.checkNotNullExpressionValue(toggleLayout, "toggleLayout");
                    V(toggleLayout, str8, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.TemplateGameSection$doOnBindData$1$6$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final JSONObject invoke() {
                            int i16;
                            TemplateGameSection templateGameSection = TemplateGameSection.this;
                            com.tencent.mobileqq.search.searchdetail.content.model.g gVar = reportInfoWrapper;
                            i16 = templateGameSection.itemPosition;
                            return BaseSearchTemplateSection.R(templateGameSection, gVar, templateGameSection.T(i16), null, 2, null);
                        }
                    }, valueOf11);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            this.binding = ah.e(containerView);
        }
    }
}
