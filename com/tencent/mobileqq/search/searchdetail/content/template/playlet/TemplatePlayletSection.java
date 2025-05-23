package com.tencent.mobileqq.search.searchdetail.content.template.playlet;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchPlayletTemplateItem;
import com.tencent.mobileqq.search.searchdetail.util.SearchPicLoader;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchPicture;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J(\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010$R\u0016\u0010,\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010$R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010.R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/playlet/TemplatePlayletSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/h;", "", "r0", "data", "g0", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchButton;", "button", "", "isMore", "", "maxSize", "o0", "n0", "k0", "l0", "m0", "i0", "Landroid/view/View;", "containerView", "y", "", "getViewStubLayoutId", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "position", "", "", "payload", "q0", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "imageView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", UserInfo.SEX_FEMALE, "Landroid/view/View;", "subTitleLayout", "G", "createrView", "H", "detailView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "playButton", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "dramaContainer", "K", "itemPosition", "L", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/h;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TemplatePlayletSection extends BaseSearchTemplateSection<NetSearchPlayletTemplateItem> {

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView imageView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView titleView;

    /* renamed from: F, reason: from kotlin metadata */
    private View subTitleLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView createrView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView detailView;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIButton playButton;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout dramaContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private int itemPosition = -1;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private NetSearchPlayletTemplateItem data;

    private final void g0(NetSearchPlayletTemplateItem data) {
        int i3;
        LinearLayout linearLayout = this.dramaContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dramaContainer");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        ArrayList<SearchButton> arrayList = data.getPlayletDetail().playletButtonList;
        if (arrayList != null) {
            int screenWidth = ViewUtils.getScreenWidth();
            if (screenWidth >= 375) {
                i3 = 3;
            } else {
                i3 = 2;
            }
            int i16 = i3 + 2;
            int dpToPx = ((screenWidth - ViewUtils.dpToPx(48.0f)) / i16) - ViewUtils.dpToPx(8.0f);
            Logger.f235387a.d().i("QQSearch.NetDetail.BaseSearchTemplateSection", 1, "bindDramaItems singleWidth=" + dpToPx + " screenWidth=" + screenWidth);
            if (arrayList.size() > i16 + 1) {
                List<SearchButton> subList = arrayList.subList(0, i3);
                Intrinsics.checkNotNullExpressionValue(subList, "playletButtons.subList(0, startCount)");
                List<SearchButton> subList2 = arrayList.subList(arrayList.size() - 2, arrayList.size());
                Intrinsics.checkNotNullExpressionValue(subList2, "playletButtons.subList(p\u2026unt, playletButtons.size)");
                for (SearchButton button : subList) {
                    Intrinsics.checkNotNullExpressionValue(button, "button");
                    o0(button, false, dpToPx);
                }
                SearchButton moreButton = data.getPlayletDetail().moreButton;
                if (moreButton != null) {
                    Intrinsics.checkNotNullExpressionValue(moreButton, "moreButton");
                    o0(moreButton, true, dpToPx);
                }
                for (SearchButton button2 : subList2) {
                    Intrinsics.checkNotNullExpressionValue(button2, "button");
                    o0(button2, false, dpToPx);
                }
                return;
            }
            for (SearchButton button3 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(button3, "button");
                o0(button3, false, dpToPx);
            }
        }
    }

    private final void i0(final NetSearchPlayletTemplateItem data) {
        ImageView imageView;
        Option url = Option.obtain().setUrl(data.getPlayletDetail().mainPic.picLink);
        ImageView imageView2 = this.imageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView2 = null;
        }
        Option option = url.setTargetView(imageView2);
        SearchPicLoader searchPicLoader = SearchPicLoader.f284726a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        searchPicLoader.e(option, null);
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplatePlayletSection.j0(TemplatePlayletSection.this, data, view);
            }
        });
        final SearchReportInfo searchReportInfo = data.getPlayletDetail().mainPic.reportInfo;
        ImageView imageView4 = this.imageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        } else {
            imageView = imageView4;
        }
        V(imageView, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.TemplatePlayletSection$bindImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                int i3;
                TemplatePlayletSection templatePlayletSection = TemplatePlayletSection.this;
                SearchReportInfo reportInfo = searchReportInfo;
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                TemplatePlayletSection templatePlayletSection2 = TemplatePlayletSection.this;
                i3 = templatePlayletSection2.itemPosition;
                return BaseSearchTemplateSection.S(templatePlayletSection, reportInfo, templatePlayletSection2.T(i3), null, 2, null);
            }
        }, String.valueOf(searchReportInfo.hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(TemplatePlayletSection this$0, NetSearchPlayletTemplateItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        g.a.a(this$0, data.getPlayletDetail().mainPic.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k0(NetSearchPlayletTemplateItem data) {
        QUIButton qUIButton;
        QUIButton qUIButton2 = this.playButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            qUIButton2 = null;
        }
        qUIButton2.setText(data.getPlayletDetail().playButton.title);
        final SearchReportInfo searchReportInfo = data.getPlayletDetail().playButton.reportInfo;
        QUIButton qUIButton3 = this.playButton;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
            qUIButton = null;
        } else {
            qUIButton = qUIButton3;
        }
        V(qUIButton, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.TemplatePlayletSection$bindPlayButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                int i3;
                TemplatePlayletSection templatePlayletSection = TemplatePlayletSection.this;
                SearchReportInfo reportInfo = searchReportInfo;
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                TemplatePlayletSection templatePlayletSection2 = TemplatePlayletSection.this;
                i3 = templatePlayletSection2.itemPosition;
                return BaseSearchTemplateSection.S(templatePlayletSection, reportInfo, templatePlayletSection2.T(i3), null, 2, null);
            }
        }, String.valueOf(searchReportInfo.hashCode()));
    }

    private final void l0(NetSearchPlayletTemplateItem data) {
        TextView textView;
        TextView textView2 = this.createrView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createrView");
            textView2 = null;
        }
        textView2.setText(data.getPlayletDetail().subTitle.text);
        final SearchReportInfo searchReportInfo = data.getPlayletDetail().subTitle.reportInfo;
        TextView textView3 = this.createrView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createrView");
            textView = null;
        } else {
            textView = textView3;
        }
        V(textView, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.TemplatePlayletSection$bindSubTitleView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                int i3;
                TemplatePlayletSection templatePlayletSection = TemplatePlayletSection.this;
                SearchReportInfo reportInfo = searchReportInfo;
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                TemplatePlayletSection templatePlayletSection2 = TemplatePlayletSection.this;
                i3 = templatePlayletSection2.itemPosition;
                return BaseSearchTemplateSection.S(templatePlayletSection, reportInfo, templatePlayletSection2.T(i3), null, 2, null);
            }
        }, String.valueOf(searchReportInfo.hashCode()));
    }

    private final void m0(NetSearchPlayletTemplateItem data) {
        TextView textView;
        TextView textView2 = this.titleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView2 = null;
        }
        textView2.setText(data.getPlayletDetail().title.text);
        final SearchReportInfo searchReportInfo = data.getPlayletDetail().title.reportInfo;
        TextView textView3 = this.titleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        } else {
            textView = textView3;
        }
        V(textView, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.TemplatePlayletSection$bindTitleView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                int i3;
                TemplatePlayletSection templatePlayletSection = TemplatePlayletSection.this;
                SearchReportInfo reportInfo = searchReportInfo;
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                TemplatePlayletSection templatePlayletSection2 = TemplatePlayletSection.this;
                i3 = templatePlayletSection2.itemPosition;
                return BaseSearchTemplateSection.S(templatePlayletSection, reportInfo, templatePlayletSection2.T(i3), null, 2, null);
            }
        }, String.valueOf(searchReportInfo.hashCode()));
    }

    private final void n0(NetSearchPlayletTemplateItem data) {
        TextView textView;
        TextView textView2 = this.detailView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailView");
            textView2 = null;
        }
        textView2.setText(data.getPlayletDetail().describe.text);
        final SearchReportInfo searchReportInfo = data.getPlayletDetail().describe.reportInfo;
        TextView textView3 = this.detailView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailView");
            textView = null;
        } else {
            textView = textView3;
        }
        V(textView, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.TemplatePlayletSection$buildDescription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONObject invoke() {
                int i3;
                TemplatePlayletSection templatePlayletSection = TemplatePlayletSection.this;
                SearchReportInfo reportInfo = searchReportInfo;
                Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
                TemplatePlayletSection templatePlayletSection2 = TemplatePlayletSection.this;
                i3 = templatePlayletSection2.itemPosition;
                return BaseSearchTemplateSection.S(templatePlayletSection, reportInfo, templatePlayletSection2.T(i3), null, 2, null);
            }
        }, String.valueOf(searchReportInfo.hashCode()));
    }

    private final void o0(final SearchButton button, boolean isMore, int maxSize) {
        LinearLayout linearLayout = this.dramaContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dramaContainer");
            linearLayout = null;
        }
        FrameLayout frameLayout = new FrameLayout(linearLayout.getContext());
        int min = Math.min(ViewUtils.dpToPx(48.0f), maxSize);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(min, min);
        layoutParams.setMargins(0, 0, ViewUtils.dpToPx(8.0f), 0);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setBackgroundResource(R.drawable.f162416lk3);
        ViewGroup viewGroup = this.dramaContainer;
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dramaContainer");
            viewGroup2 = null;
        }
        viewGroup2.addView(frameLayout);
        final SearchReportInfo searchReportInfo = button.reportInfo;
        if (searchReportInfo != null) {
            V(frameLayout, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.TemplatePlayletSection$buildSingleItem$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    int i3;
                    TemplatePlayletSection templatePlayletSection = TemplatePlayletSection.this;
                    SearchReportInfo searchReportInfo2 = searchReportInfo;
                    i3 = templatePlayletSection.itemPosition;
                    return BaseSearchTemplateSection.S(templatePlayletSection, searchReportInfo2, templatePlayletSection.T(i3), null, 2, null);
                }
            }, String.valueOf(searchReportInfo.hashCode()));
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplatePlayletSection.p0(TemplatePlayletSection.this, button, view);
            }
        });
        if (isMore) {
            LinearLayout linearLayout3 = this.dramaContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dramaContainer");
            } else {
                linearLayout2 = linearLayout3;
            }
            ImageView imageView = new ImageView(linearLayout2.getContext());
            int dpToPx = ViewUtils.dpToPx(14.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dpToPx, dpToPx);
            layoutParams2.gravity = 17;
            imageView.setLayoutParams(layoutParams2);
            imageView.setImageResource(R.drawable.qui_more_dot_icon_primary);
            frameLayout.addView(imageView);
            return;
        }
        LinearLayout linearLayout4 = this.dramaContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dramaContainer");
            linearLayout4 = null;
        }
        TextView textView = new TextView(linearLayout4.getContext());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        textView.setLayoutParams(layoutParams3);
        textView.setText(button.title);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout linearLayout5 = this.dramaContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dramaContainer");
        } else {
            linearLayout2 = linearLayout5;
        }
        textView.setTextColor(AppCompatResources.getColorStateList(linearLayout2.getContext(), R.color.qui_common_text_primary));
        textView.setTextSize(1, 14.0f);
        frameLayout.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(TemplatePlayletSection this$0, SearchButton button, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(button, "$button");
        g.a.a(this$0, button.jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r0() {
        ImageView imageView = this.imageView;
        QUIButton qUIButton = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplatePlayletSection.t0(TemplatePlayletSection.this, view);
            }
        });
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemplatePlayletSection.u0(TemplatePlayletSection.this, view);
            }
        });
        View view = this.subTitleLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subTitleLayout");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemplatePlayletSection.v0(TemplatePlayletSection.this, view2);
            }
        });
        TextView textView2 = this.detailView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailView");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemplatePlayletSection.w0(TemplatePlayletSection.this, view2);
            }
        });
        QUIButton qUIButton2 = this.playButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playButton");
        } else {
            qUIButton = qUIButton2;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.playlet.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TemplatePlayletSection.s0(TemplatePlayletSection.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(TemplatePlayletSection this$0, View view) {
        NetSearchPlayletTemplateItem netSearchPlayletTemplateItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.BaseSearchTemplateSection_buttonJump", 500L) && (netSearchPlayletTemplateItem = this$0.data) != null) {
            g.a.a(this$0, netSearchPlayletTemplateItem.getPlayletDetail().playButton.jumpLink, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(TemplatePlayletSection this$0, View view) {
        NetSearchPlayletTemplateItem netSearchPlayletTemplateItem;
        SearchJump searchJump;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.BaseSearchTemplateSection_buttonJump", 500L) && (netSearchPlayletTemplateItem = this$0.data) != null) {
            SearchPicture searchPicture = netSearchPlayletTemplateItem.getPlayletDetail().mainPic;
            if (searchPicture != null) {
                searchJump = searchPicture.jumpLink;
            } else {
                searchJump = null;
            }
            g.a.a(this$0, searchJump, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(TemplatePlayletSection this$0, View view) {
        NetSearchPlayletTemplateItem netSearchPlayletTemplateItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.BaseSearchTemplateSection_buttonJump", 500L) && (netSearchPlayletTemplateItem = this$0.data) != null) {
            g.a.a(this$0, netSearchPlayletTemplateItem.getPlayletDetail().title.jumpLink, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(TemplatePlayletSection this$0, View view) {
        NetSearchPlayletTemplateItem netSearchPlayletTemplateItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.BaseSearchTemplateSection_buttonJump", 500L) && (netSearchPlayletTemplateItem = this$0.data) != null) {
            g.a.a(this$0, netSearchPlayletTemplateItem.getPlayletDetail().subTitle.jumpLink, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(TemplatePlayletSection this$0, View view) {
        NetSearchPlayletTemplateItem netSearchPlayletTemplateItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.BaseSearchTemplateSection_buttonJump", 500L) && (netSearchPlayletTemplateItem = this$0.data) != null) {
            g.a.a(this$0, netSearchPlayletTemplateItem.getPlayletDetail().describe.jumpLink, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void x(@NotNull NetSearchPlayletTemplateItem item, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.itemPosition = position;
        this.data = item;
        i0(item);
        m0(item);
        l0(item);
        n0(item);
        k0(item);
        g0(item);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.ulx);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.drama_image)");
            this.imageView = (ImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.f83344ja);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.series_title_text)");
            this.titleView = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.zwg);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.official_layout)");
            this.subTitleLayout = findViewById3;
            View findViewById4 = containerView.findViewById(R.id.zwe);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.official_account_text)");
            this.createrView = (TextView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.ugw);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "it.findViewById(R.id.detailed_title_text)");
            this.detailView = (TextView) findViewById5;
            View findViewById6 = containerView.findViewById(R.id.fuz);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "it.findViewById(R.id.play_btn)");
            this.playButton = (QUIButton) findViewById6;
            View findViewById7 = containerView.findViewById(R.id.zvu);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "it.findViewById(R.id.number_container)");
            this.dramaContainer = (LinearLayout) findViewById7;
            r0();
        }
    }
}
