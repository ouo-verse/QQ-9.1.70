package com.tencent.mobileqq.search.searchdetail.content.part;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.SearchDetailTabContentFragment;
import com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel;
import com.tencent.mobileqq.search.util.as;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchFloatButton;
import com.tencent.qqnt.kernel.nativeinterface.SearchFloatButtonIcon;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/part/FloatButtonPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchFloatButton;", "buttonInfo", "", "J9", "F9", "initView", "D9", "I9", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchFloatButton;)Lkotlin/Unit;", "C9", "Landroid/content/Context;", "ctx", "", "url", "G9", "", "isPartEnable", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroid/view/ViewStub;", "f", "Landroid/view/ViewStub;", "floatBtnStub", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "floatBtnContainer", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "topicView", "<init>", "(Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/k;Landroidx/lifecycle/LifecycleOwner;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class FloatButtonPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewStub floatBtnStub;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout floatBtnContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView iconView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView topicView;

    public FloatButtonPart(@NotNull com.tencent.mobileqq.search.searchdetail.content.viewmodel.k viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    private final void C9(SearchFloatButton buttonInfo) {
        boolean z16;
        boolean z17;
        ImageView imageView = this.iconView;
        if (imageView != null) {
            SearchFloatButtonIcon searchFloatButtonIcon = buttonInfo.icon;
            String iconToken = searchFloatButtonIcon.iconToken;
            Intrinsics.checkNotNullExpressionValue(iconToken, "iconToken");
            boolean z18 = true;
            if (iconToken.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            imageView.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, imageView)) == null) {
                imageView.setVisibility(8);
            }
            String iconToken2 = searchFloatButtonIcon.iconToken;
            Intrinsics.checkNotNullExpressionValue(iconToken2, "iconToken");
            if (iconToken2.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                try {
                    com.tencent.mobileqq.search.searchdetail.multimedia.o oVar = com.tencent.mobileqq.search.searchdetail.multimedia.o.f284545a;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    String iconToken3 = searchFloatButtonIcon.iconToken;
                    Intrinsics.checkNotNullExpressionValue(iconToken3, "iconToken");
                    Drawable e16 = oVar.e(context, iconToken3);
                    String iconColorToken = searchFloatButtonIcon.iconColorToken;
                    Intrinsics.checkNotNullExpressionValue(iconColorToken, "iconColorToken");
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    Integer c16 = oVar.c(iconColorToken, context2);
                    if (c16 != null) {
                        c16.intValue();
                        if (e16 != null) {
                            e16.setColorFilter(new PorterDuffColorFilter(c16.intValue(), PorterDuff.Mode.SRC_IN));
                        }
                    }
                    if (e16 != null) {
                        imageView.setImageDrawable(e16);
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    QLog.e(getTAG(), 4, "loadTokenImage error:" + e17);
                    return;
                }
            }
            String iconLink = searchFloatButtonIcon.iconLink;
            Intrinsics.checkNotNullExpressionValue(iconLink, "iconLink");
            if (iconLink.length() <= 0) {
                z18 = false;
            }
            if (z18) {
                String iconLink2 = searchFloatButtonIcon.iconLink;
                Intrinsics.checkNotNullExpressionValue(iconLink2, "iconLink");
                com.tencent.mobileqq.search.searchdetail.content.template.u.c(imageView, iconLink2, null, 2, null);
            }
        }
    }

    private final void D9(final SearchFloatButton buttonInfo) {
        LinearLayout linearLayout = this.floatBtnContainer;
        if (linearLayout != null) {
            C9(buttonInfo);
            TextView textView = this.topicView;
            if (textView != null) {
                textView.setText(buttonInfo.title);
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FloatButtonPart.E9(SearchFloatButton.this, this, view);
                }
            });
            I9(buttonInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void E9(SearchFloatButton buttonInfo, FloatButtonPart this$0, View view) {
        boolean z16;
        boolean isBlank;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(buttonInfo, "$buttonInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSearch.NetDetail.FloatButtonPart_buttonJump", 500L)) {
            String str = buttonInfo.jumpUrl;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        Logger.f235387a.d().w("QQSearch.NetDetail.FloatButtonPart", 1, "jump url is empty " + buttonInfo);
                    } else {
                        Context context = view.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "view.context");
                        String str2 = buttonInfo.jumpUrl;
                        Intrinsics.checkNotNullExpressionValue(str2, "buttonInfo.jumpUrl");
                        this$0.G9(context, str2);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        LinearLayout linearLayout = this.floatBtnContainer;
        if (linearLayout != null) {
            com.tencent.mobileqq.search.searchdetail.multimedia.p.b(linearLayout, false);
        }
    }

    private final void G9(Context ctx, String url) {
        if (as.c(url)) {
            ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).jumpTo(ctx, url, null);
        } else {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(ctx, url);
        }
        Logger.f235387a.d().i("QQSearch.NetDetail.FloatButtonPart", 1, "jumpPage url=" + url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Unit I9(SearchFloatButton buttonInfo) {
        String str;
        String str2;
        long j3;
        Object obj;
        Object obj2;
        String sugTraceId;
        SearchDetailTabListViewModel.TabInfo tabInfo;
        SearchDetailTabListViewModel.TabInfo tabInfo2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        String str3 = "";
        if (pageData == null || (str = pageData.getKeyword()) == null) {
            str = "";
        }
        linkedHashMap.put("search_query_text", str);
        SearchDetailTabContentFragment.PageData pageData2 = this.viewModel.getPageData();
        if (pageData2 == null || (tabInfo2 = pageData2.getTabInfo()) == null || (str2 = tabInfo2.getTabName()) == null) {
            str2 = "";
        }
        linkedHashMap.put("tab_name", str2);
        SearchDetailTabContentFragment.PageData pageData3 = this.viewModel.getPageData();
        if (pageData3 != null && (tabInfo = pageData3.getTabInfo()) != null) {
            j3 = tabInfo.getTabMask();
        } else {
            j3 = 1;
        }
        linkedHashMap.put("tab_mask", Long.valueOf(j3));
        SearchDetailTabContentFragment.PageData pageData4 = this.viewModel.getPageData();
        if (pageData4 == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(pageData4.getQuerySource());
        }
        linkedHashMap.put("query_source", obj);
        SearchDetailTabContentFragment.PageData pageData5 = this.viewModel.getPageData();
        if (pageData5 == null) {
            obj2 = "";
        } else {
            obj2 = Integer.valueOf(pageData5.getUserSource());
        }
        linkedHashMap.put("user_source", obj2);
        linkedHashMap.put("trace_id", this.viewModel.getLastRequestLocalTraceId());
        SearchDetailTabContentFragment.PageData pageData6 = this.viewModel.getPageData();
        if (pageData6 != null && (sugTraceId = pageData6.getSugTraceId()) != null) {
            str3 = sugTraceId;
        }
        linkedHashMap.put("sug_trace_id", str3);
        linkedHashMap.put("topic_name", this.viewModel.getTopicName());
        LinearLayout linearLayout = this.floatBtnContainer;
        if (linearLayout != null) {
            com.tencent.mobileqq.search.searchdetail.r rVar = com.tencent.mobileqq.search.searchdetail.r.f284572a;
            String str4 = buttonInfo.reportInfo.eid;
            Intrinsics.checkNotNullExpressionValue(str4, "buttonInfo.reportInfo.eid");
            rVar.d(linearLayout, str4, linkedHashMap);
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(SearchFloatButton buttonInfo) {
        initView();
        LinearLayout linearLayout = this.floatBtnContainer;
        if (linearLayout != null) {
            com.tencent.mobileqq.search.searchdetail.multimedia.p.b(linearLayout, true);
        }
        D9(buttonInfo);
    }

    private final void initView() {
        ImageView imageView;
        if (this.floatBtnContainer == null) {
            ViewStub viewStub = this.floatBtnStub;
            TextView textView = null;
            if (viewStub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatBtnStub");
                viewStub = null;
            }
            View inflate = viewStub.inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.floatBtnContainer = linearLayout;
            if (linearLayout != null) {
                imageView = (ImageView) linearLayout.findViewById(R.id.icon);
            } else {
                imageView = null;
            }
            this.iconView = imageView;
            LinearLayout linearLayout2 = this.floatBtnContainer;
            if (linearLayout2 != null) {
                textView = (TextView) linearLayout2.findViewById(R.id.f100175rs);
            }
            this.topicView = textView;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        SearchDetailTabListViewModel.TabInfo tabInfo;
        SearchDetailTabContentFragment.PageData pageData = this.viewModel.getPageData();
        if (pageData == null || (tabInfo = pageData.getTabInfo()) == null || tabInfo.getTabMask() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.vaw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.float_button_stub)");
        this.floatBtnStub = (ViewStub) findViewById;
        MutableLiveData<SearchFloatButton> j26 = this.viewModel.j2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<SearchFloatButton, Unit> function1 = new Function1<SearchFloatButton, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.FloatButtonPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SearchFloatButton searchFloatButton) {
                invoke2(searchFloatButton);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SearchFloatButton it) {
                boolean isBlank;
                String str = it.title;
                Intrinsics.checkNotNullExpressionValue(str, "it.title");
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!(!isBlank)) {
                    FloatButtonPart.this.F9();
                    return;
                }
                FloatButtonPart floatButtonPart = FloatButtonPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                floatButtonPart.J9(it);
            }
        };
        j26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.search.searchdetail.content.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FloatButtonPart.H9(Function1.this, obj);
            }
        });
    }
}
