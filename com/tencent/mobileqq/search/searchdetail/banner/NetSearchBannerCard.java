package com.tencent.mobileqq.search.searchdetail.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateBannerItem;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001\u001cB#\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040!\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/NetSearchBannerCard;", "", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/i;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", DomainData.DOMAIN_NAME, "i", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/LinearLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "option", "f", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "jumpInfo", "k", "r", tl.h.F, "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "imageView", "", "url", "l", "p", "Lhp2/g;", "a", "Lhp2/g;", "getBinding", "()Lhp2/g;", "binding", "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "jumpCallback", "c", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/i;", "currentData", "<init>", "(Lhp2/g;Lkotlin/jvm/functions/Function1;)V", "d", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchBannerCard {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hp2.g binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<SearchJump, Unit> jumpCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NetSearchTemplateBannerItem currentData;

    /* JADX WARN: Multi-variable type inference failed */
    public NetSearchBannerCard(@NotNull hp2.g binding, @NotNull Function1<? super SearchJump, Unit> jumpCallback) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        this.binding = binding;
        this.jumpCallback = jumpCallback;
    }

    private final void e(LinearLayout parent) {
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        View view = new View(context);
        Context context2 = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "binding.root.context");
        view.setBackground(context2.getDrawable(R.drawable.qui_common_border_standard_bg));
        parent.addView(view);
        p.a(view, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.banner.NetSearchBannerCard$addDivider$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LinearLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.width = com.tencent.biz.qui.quicommon.e.c(0.5f);
                updateLayoutParams.height = com.tencent.biz.qui.quicommon.e.c(20.0f);
            }
        });
    }

    private final void f(LinearLayout parent, final SearchText option) {
        String str;
        CommonInfo commonInfo;
        Typeface create;
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        TextView textView = new TextView(context);
        textView.setText(option.text);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchBannerCard.g(NetSearchBannerCard.this, option, view);
            }
        });
        textView.setTextSize(1, 14.0f);
        Context context2 = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "binding.root.context");
        textView.setTextColor(context2.getColor(R.color.qui_common_text_primary));
        textView.setGravity(17);
        if (Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(Typeface.DEFAULT, 400, false);
            Intrinsics.checkNotNullExpressionValue(create, "create(Typeface.DEFAULT, 400, false)");
            textView.setTypeface(create);
        }
        parent.addView(textView);
        p.a(textView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.banner.NetSearchBannerCard$addOptionView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LinearLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.width = -2;
                updateLayoutParams.height = com.tencent.biz.qui.quicommon.e.c(20.0f);
                updateLayoutParams.weight = 1.0f;
            }
        });
        com.tencent.mobileqq.search.searchdetail.util.f fVar = com.tencent.mobileqq.search.searchdetail.util.f.f284742a;
        TextView textView2 = this.binding.f405662h;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.netSearchButton");
        SearchReportInfo searchReportInfo = option.reportInfo;
        NetSearchTemplateBannerItem netSearchTemplateBannerItem = this.currentData;
        if (netSearchTemplateBannerItem == null || (commonInfo = netSearchTemplateBannerItem.getCommonInfo()) == null || (str = commonInfo.getItemId()) == null) {
            str = "";
        }
        com.tencent.mobileqq.search.searchdetail.util.f.b(fVar, textView2, searchReportInfo, str, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NetSearchBannerCard this$0, SearchText option, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(option, "$option");
        this$0.k(option.jumpLink);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h() {
        final NetSearchTemplateBannerItem netSearchTemplateBannerItem = this.currentData;
        if (netSearchTemplateBannerItem == null) {
            return;
        }
        ImageFilterView imageFilterView = this.binding.f405656b;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.bannerContentImage");
        p.a(imageFilterView, new Function1<ConstraintLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.banner.NetSearchBannerCard$adjustViewRatio$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConstraintLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConstraintLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                updateLayoutParams.dimensionRatio = String.valueOf((NetSearchTemplateBannerItem.this.getRateWH() > 0.0f ? 1 : (NetSearchTemplateBannerItem.this.getRateWH() == 0.0f ? 0 : -1)) == 0 ? 2.5f : NetSearchTemplateBannerItem.this.getRateWH());
            }
        });
    }

    private final void i(final NetSearchTemplateBannerItem item) {
        final int c16 = com.tencent.biz.qui.quicommon.e.c(12.0f);
        if (item.getIsFullWidth()) {
            ConstraintLayout root = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            root.setPadding(root.getPaddingLeft(), 0, root.getPaddingRight(), 0);
        } else {
            ConstraintLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            root2.setPadding(root2.getPaddingLeft(), root2.getPaddingTop(), root2.getPaddingRight(), c16);
        }
        final ImageFilterView imageFilterView = this.binding.f405656b;
        imageFilterView.post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.banner.c
            @Override // java.lang.Runnable
            public final void run() {
                NetSearchBannerCard.j(ImageFilterView.this, item, c16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ImageFilterView this_apply, NetSearchTemplateBannerItem item, int i3) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(item, "$item");
        ViewGroup.LayoutParams layoutParams = this_apply.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (item.getIsFullWidth()) {
            i3 = 0;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i3;
        this_apply.requestLayout();
    }

    private final void k(SearchJump jumpInfo) {
        if (jumpInfo == null) {
            QLog.e("QQSearch.NetDetailBannerCard", 1, "jump but jumpInfo is null");
        } else {
            this.jumpCallback.invoke(jumpInfo);
        }
    }

    private final void l(ImageFilterView imageView, String url) {
        o.f284545a.f("QQSearch.NetDetailBannerCard", imageView, url, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                NetSearchBannerCard.m(NetSearchBannerCard.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(NetSearchBannerCard this$0, LoadState loadState, Option option) {
        NetSearchTemplateBannerItem netSearchTemplateBannerItem;
        Bitmap resultBitMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState != null && option != null && (netSearchTemplateBannerItem = this$0.currentData) != null && loadState.isFinishSuccess() && Intrinsics.areEqual(netSearchTemplateBannerItem.getContentImage(), option.getUrl()) && (resultBitMap = option.getResultBitMap()) != null && resultBitMap.getWidth() > 0 && resultBitMap.getHeight() > 0) {
            netSearchTemplateBannerItem.G(resultBitMap.getWidth(), resultBitMap.getHeight());
            this$0.h();
        }
    }

    private final void n(final NetSearchTemplateBannerItem item) {
        String str;
        boolean z16;
        String str2;
        SearchButton button = item.getButton();
        SearchReportInfo searchReportInfo = null;
        if (button != null) {
            str = button.title;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.binding.f405662h.setVisibility(4);
            return;
        }
        this.binding.f405662h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchBannerCard.o(NetSearchBannerCard.this, item, view);
            }
        });
        this.binding.f405662h.setVisibility(0);
        TextView textView = this.binding.f405662h;
        SearchButton button2 = item.getButton();
        if (button2 == null || (str2 = button2.title) == null) {
            str2 = "";
        }
        textView.setText(str2);
        com.tencent.mobileqq.search.searchdetail.util.f fVar = com.tencent.mobileqq.search.searchdetail.util.f.f284742a;
        TextView textView2 = this.binding.f405662h;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.netSearchButton");
        SearchButton button3 = item.getButton();
        if (button3 != null) {
            searchReportInfo = button3.reportInfo;
        }
        com.tencent.mobileqq.search.searchdetail.util.f.b(fVar, textView2, searchReportInfo, item.getCommonInfo().getItemId(), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(NetSearchBannerCard this$0, NetSearchTemplateBannerItem item, View view) {
        SearchJump searchJump;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        SearchButton button = item.getButton();
        if (button != null) {
            searchJump = button.jumpLink;
        } else {
            searchJump = null;
        }
        this$0.k(searchJump);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q(NetSearchTemplateBannerItem item) {
        String str;
        boolean z16;
        boolean z17;
        int i3;
        SearchIcon icon;
        String str2;
        boolean z18;
        boolean z19;
        String str3;
        boolean z26;
        View view = this.binding.f405657c;
        Intrinsics.checkNotNullExpressionValue(view, "binding.bannerImgMask");
        SearchIcon icon2 = item.getIcon();
        String str4 = null;
        if (icon2 != null) {
            str = icon2.iconLink;
        } else {
            str = null;
        }
        boolean z27 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (item.getTitle().length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (item.getDescription().length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    SearchButton button = item.getButton();
                    if (button != null) {
                        str3 = button.title;
                    } else {
                        str3 = null;
                    }
                    if (str3 != null && str3.length() != 0) {
                        z26 = false;
                    } else {
                        z26 = true;
                    }
                    if (z26) {
                        z17 = false;
                        if (!z17) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        view.setVisibility(i3);
                        icon = item.getIcon();
                        if (icon == null) {
                            str2 = icon.iconLink;
                        } else {
                            str2 = null;
                        }
                        if (str2 != null && str2.length() != 0) {
                            z27 = false;
                        }
                        if (!z27) {
                            this.binding.f405659e.setVisibility(8);
                            return;
                        }
                        this.binding.f405659e.setVisibility(0);
                        ImageFilterView imageFilterView = this.binding.f405659e;
                        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.netSearchBannerIcon");
                        SearchIcon icon3 = item.getIcon();
                        if (icon3 != null) {
                            str4 = icon3.iconLink;
                        }
                        if (str4 == null) {
                            str4 = "";
                        }
                        l(imageFilterView, str4);
                        return;
                    }
                }
            }
        }
        z17 = true;
        if (!z17) {
        }
        view.setVisibility(i3);
        icon = item.getIcon();
        if (icon == null) {
        }
        if (str2 != null) {
            z27 = false;
        }
        if (!z27) {
        }
    }

    private final void r(NetSearchTemplateBannerItem item) {
        boolean z16;
        String contentImage = item.getContentImage();
        if (contentImage != null && contentImage.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QQSearch.NetDetailBannerCard", 1, "showImage but iconLink is null");
        }
        ImageFilterView imageFilterView = this.binding.f405656b;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.bannerContentImage");
        l(imageFilterView, item.getContentImage());
    }

    private final void s(NetSearchTemplateBannerItem item) {
        if (item.C().isEmpty()) {
            this.binding.f405663i.setVisibility(8);
            return;
        }
        this.binding.f405663i.setVisibility(0);
        this.binding.f405663i.removeAllViews();
        int size = item.C().size();
        for (int i3 = 0; i3 < size; i3++) {
            LinearLayout linearLayout = this.binding.f405663i;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.optionsContainer");
            SearchText searchText = item.C().get(i3);
            Intrinsics.checkNotNullExpressionValue(searchText, "item.textLinkList[optionIndex]");
            f(linearLayout, searchText);
            if (i3 != item.C().size() - 1) {
                LinearLayout linearLayout2 = this.binding.f405663i;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.optionsContainer");
                e(linearLayout2);
            }
        }
    }

    private final void t(NetSearchTemplateBannerItem item) {
        boolean z16;
        String title = item.getTitle();
        boolean z17 = true;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.binding.f405661g.setVisibility(8);
        } else {
            this.binding.f405661g.setVisibility(0);
            this.binding.f405661g.setText(item.getTitle());
        }
        String description = item.getDescription();
        if (description != null && description.length() != 0) {
            z17 = false;
        }
        if (z17) {
            this.binding.f405658d.setVisibility(8);
        } else {
            this.binding.f405658d.setVisibility(0);
            this.binding.f405658d.setText(item.getDescription());
        }
    }

    public final void p(@NotNull NetSearchTemplateBannerItem item) {
        int i3;
        Intrinsics.checkNotNullParameter(item, "item");
        this.currentData = item;
        View view = this.binding.f405664j;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topDivider");
        if (item.getLayoutInfo().showDivider) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        i(item);
        r(item);
        n(item);
        q(item);
        t(item);
        s(item);
    }
}
