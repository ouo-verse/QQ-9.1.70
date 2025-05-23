package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.search.searchdetail.content.model.SearchNetLabel;
import com.tencent.mobileqq.search.searchdetail.multimedia.p;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.util.AppSetting;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u00011B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b,\u00100J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002J\u001c\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0012\u001a\u00020\u0011J6\u0010 \u001a\u00020\u0007*\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00152\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u001aR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchLabelLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "view", "", NodeProps.MARGIN_LEFT, NodeProps.MARGIN_RIGHT, "", tl.h.F, "childView", "Landroid/widget/ImageView;", "imageView", "g", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/model/SearchNetLabel;", "unit", "c", "Lcom/tencent/mobileqq/search/searchdetail/content/base/g;", "jumpAction", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchIcon;", "", "f", "", "data", "d", "", "elementId", "needAsync", "Lkotlin/Function0;", "getParamsStr", IECDtReport.ACTION_IDENTIFIER, "i", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "getParentReportInfo", "()Lorg/json/JSONObject;", "setParentReportInfo", "(Lorg/json/JSONObject;)V", "parentReportInfo", "I", "initShowSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QSearchLabelLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject parentReportInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int initShowSize;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f284276a;

        static {
            int[] iArr = new int[SearchNetLabel.LabelType.values().length];
            try {
                iArr[SearchNetLabel.LabelType.TYPE_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f284276a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchLabelLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
    }

    private final void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        ViewUtils viewUtils = ViewUtils.f352270a;
        linearLayout.setPadding(viewUtils.a(6.0f), viewUtils.a(4.0f), viewUtils.a(6.0f), viewUtils.a(4.0f));
        ImageView imageView = new ImageView(getContext());
        imageView.setId(R.id.image);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(viewUtils.a(10.0f), viewUtils.a(10.0f));
        layoutParams.rightMargin = viewUtils.a(2.0f);
        layoutParams.gravity = 16;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 10.0f);
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setId(R.id.jfb);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        linearLayout.addView(textView, layoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = viewUtils.a(6.0f);
        addView(linearLayout, marginLayoutParams);
    }

    private final void c(View childView, SearchNetLabel unit) {
        ImageView image = (ImageView) childView.findViewById(R.id.image);
        image.setVisibility(8);
        TextView textView = (TextView) childView.findViewById(R.id.jfb);
        Intrinsics.checkNotNullExpressionValue(image, "image");
        g(childView, image);
        textView.setText(unit.getText());
        textView.setTextColor(unit.getTextColor());
    }

    private final void e(View childView, final SearchNetLabel unit, final com.tencent.mobileqq.search.searchdetail.content.base.g jumpAction) {
        ImageView imageView;
        int i3;
        String str;
        int i16;
        TextView textView;
        Object m476constructorimpl;
        Object obj;
        boolean z16;
        TextView textView2;
        int i17;
        int i18;
        String str2;
        String str3;
        SearchJump searchJump;
        ImageView imageView2 = (ImageView) childView.findViewById(R.id.image);
        TextView textView3 = (TextView) childView.findViewById(R.id.jfb);
        if (unit.getLayoutType() == 4) {
            h(childView, unit.getMarginLeft(), unit.getMarginRight());
            childView.setPadding(0, 0, 0, 0);
            if (textView3 != null) {
                textView3.setTextSize(1, 12.0f);
            }
            SearchText searchTextEntity = unit.getSearchTextEntity();
            if (searchTextEntity != null && (searchJump = searchTextEntity.jumpLink) != null && com.tencent.mobileqq.search.searchdetail.content.base.h.a(searchJump)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                childView.setClickable(true);
                textView2 = textView3;
                i17 = 0;
                i18 = 1;
                str2 = null;
                j.u(j.f431768a, childView, null, 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout$initTemplateLabel$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View it) {
                        SearchJump searchJump2;
                        Intrinsics.checkNotNullParameter(it, "it");
                        com.tencent.mobileqq.search.searchdetail.content.base.g gVar = com.tencent.mobileqq.search.searchdetail.content.base.g.this;
                        SearchText searchTextEntity2 = unit.getSearchTextEntity();
                        Map<String, String> map = null;
                        SearchJump searchJump3 = searchTextEntity2 != null ? searchTextEntity2.jumpLink : null;
                        SearchText searchTextEntity3 = unit.getSearchTextEntity();
                        if (searchTextEntity3 != null && (searchJump2 = searchTextEntity3.jumpLink) != null) {
                            map = com.tencent.mobileqq.search.searchdetail.content.template.model.b.a(searchJump2);
                        }
                        gVar.d(searchJump3, map);
                    }
                }, 3, null);
            } else {
                textView2 = textView3;
                i17 = 0;
                i18 = 1;
                str2 = null;
                childView.setOnClickListener(null);
                childView.setClickable(false);
            }
            Intrinsics.checkNotNullExpressionValue(imageView2, "imageView");
            p.a(imageView2, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout$initTemplateLabel$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull LinearLayout.LayoutParams updateLayoutParams) {
                    Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                    ViewUtils viewUtils = ViewUtils.f352270a;
                    updateLayoutParams.width = viewUtils.b(14);
                    updateLayoutParams.height = viewUtils.b(14);
                }
            });
            SearchReportInfo dataReport = unit.getDataReport();
            if (dataReport != null) {
                str3 = dataReport.eid;
            } else {
                str3 = str2;
            }
            Function0<String> function0 = new Function0<String>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout$initTemplateLabel$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    SearchReportInfo dataReport2 = SearchNetLabel.this.getDataReport();
                    if (dataReport2 != null) {
                        return dataReport2.reportInfo;
                    }
                    return null;
                }
            };
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            i3 = i18;
            str = str2;
            i16 = i17;
            textView = textView2;
            imageView = imageView2;
            i(childView, str3, true, function0, uuid);
        } else {
            imageView = imageView2;
            i3 = 1;
            str = null;
            i16 = 0;
            textView = textView3;
            Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
            g(childView, imageView);
        }
        SearchIcon icon = unit.getIcon();
        if (icon == null || f(icon) != i3) {
            i3 = i16;
        }
        if (i3 == 0) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        try {
            Result.Companion companion = Result.INSTANCE;
            SearchIcon icon2 = unit.getIcon();
            if (icon2 != null) {
                obj = Boolean.valueOf(com.tencent.mobileqq.search.searchdetail.util.e.b(icon2, imageView));
            } else {
                obj = str;
            }
            m476constructorimpl = Result.m476constructorimpl(obj);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            s.e("QSearchLabelLayout", "load image failed,reason:", m479exceptionOrNullimpl);
        }
        if (textView != null) {
            textView.setText(unit.getText());
        }
        if (textView != null) {
            textView.setTextColor(unit.getTextColor());
        }
    }

    private final boolean f(SearchIcon searchIcon) {
        boolean z16;
        boolean z17;
        String str = searchIcon.iconLink;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str2 = searchIcon.iconToken;
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                return false;
            }
        }
        return true;
    }

    private final void g(View childView, ImageView imageView) {
        QSearchLabelLayout$resetAttribute$1 qSearchLabelLayout$resetAttribute$1 = new Function0<String>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout$resetAttribute$1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                return null;
            }
        };
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        i(childView, "", false, qSearchLabelLayout$resetAttribute$1, uuid);
        h(childView, 0, 6);
        ViewUtils viewUtils = ViewUtils.f352270a;
        childView.setPadding(viewUtils.a(6.0f), viewUtils.a(4.0f), viewUtils.a(6.0f), viewUtils.a(4.0f));
        TextView textView = (TextView) childView.findViewById(R.id.jfb);
        if (textView != null) {
            textView.setTextSize(1, 10.0f);
        }
        childView.setOnClickListener(null);
        childView.setClickable(false);
        p.a(imageView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout$resetAttribute$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LinearLayout.LayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                ViewUtils viewUtils2 = ViewUtils.f352270a;
                updateLayoutParams.width = viewUtils2.b(10);
                updateLayoutParams.height = viewUtils2.b(10);
            }
        });
    }

    private final void h(View view, int marginLeft, int marginRight) {
        ViewUtils viewUtils = ViewUtils.f352270a;
        final int b16 = viewUtils.b(marginLeft);
        final int b17 = viewUtils.b(marginRight);
        p.a(view, new Function1<ViewGroup.MarginLayoutParams, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchLabelLayout$updateMargin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ViewGroup.MarginLayoutParams marginLayoutParams) {
                invoke2(marginLayoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ViewGroup.MarginLayoutParams updateLayoutParams) {
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                int i3 = updateLayoutParams.leftMargin;
                int i16 = b16;
                if (i3 == i16 && updateLayoutParams.rightMargin == b17) {
                    return;
                }
                updateLayoutParams.leftMargin = i16;
                updateLayoutParams.rightMargin = b17;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
    
        if (r4 != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void j(String str, Function0 function0, View this_vr, String identifier, QSearchLabelLayout this$0) {
        boolean z16;
        String str2;
        Iterator keys;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(this_vr, "$this_vr");
        Intrinsics.checkNotNullParameter(identifier, "$identifier");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = false;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    VideoReport.setElementExposePolicy(this_vr, ExposurePolicy.REPORT_NONE);
                    VideoReport.setElementEndExposePolicy(this_vr, EndExposurePolicy.REPORT_NONE);
                    VideoReport.setElementClickPolicy(this_vr, ClickPolicy.REPORT_NONE);
                } else {
                    VideoReport.setElementId(this_vr, str);
                    VideoReport.setElementExposePolicy(this_vr, ExposurePolicy.REPORT_ALL);
                    VideoReport.setElementEndExposePolicy(this_vr, EndExposurePolicy.REPORT_ALL);
                    VideoReport.setElementClickPolicy(this_vr, ClickPolicy.REPORT_ALL);
                }
                if (function0 == null) {
                    str2 = (String) function0.invoke();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                }
                z17 = true;
                if (!z17) {
                    VideoReport.resetElementParams(this_vr);
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.length() < 1) {
                            VideoReport.resetElementParams(this_vr);
                        } else {
                            JSONObject jSONObject2 = this$0.parentReportInfo;
                            if (jSONObject2 != null && (keys = jSONObject2.keys()) != null) {
                                Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                                while (keys.hasNext()) {
                                    String str3 = (String) keys.next();
                                    VideoReport.setElementParam(this_vr, str3, jSONObject2.get(str3));
                                    if (!jSONObject.has(str3) && !Intrinsics.areEqual("transfer_info", str3)) {
                                        jSONObject.put(str3, jSONObject2.get(str3));
                                    }
                                }
                            }
                            Iterator keys2 = jSONObject.keys();
                            Intrinsics.checkNotNullExpressionValue(keys2, "curJsonObject.keys()");
                            while (keys2.hasNext()) {
                                String str4 = (String) keys2.next();
                                VideoReport.setElementParam(this_vr, str4, jSONObject.get(str4));
                            }
                            VideoReport.setElementParam(this_vr, "transfer_info", jSONObject.toString());
                        }
                    } catch (JSONException e16) {
                        if (AppSetting.isDebugVersion()) {
                            QLog.e("QQSearch.NetDetail.BaseSearchTemplateSection", 4, "mergeTransferInfo: " + e16.getMessage());
                        }
                    }
                }
                VideoReport.setElementReuseIdentifier(this_vr, identifier);
            }
        }
        z16 = true;
        if (!z16) {
        }
        if (function0 == null) {
        }
        if (str2 != null) {
        }
        z17 = true;
        if (!z17) {
        }
        VideoReport.setElementReuseIdentifier(this_vr, identifier);
    }

    public final void d(@NotNull List<SearchNetLabel> data, @NotNull com.tencent.mobileqq.search.searchdetail.content.base.g jumpAction) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        this.initShowSize = data.size();
        int i3 = 0;
        for (Object obj : data) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SearchNetLabel searchNetLabel = (SearchNetLabel) obj;
            if (i3 > getChildCount() - 1) {
                b();
            }
            View childView = getChildAt(i3);
            if (childView.getVisibility() == 8) {
                childView.setVisibility(0);
            }
            float a16 = ViewUtils.f352270a.a(4.0f);
            childView.setBackground(j.f431768a.g(a16, a16, a16, a16, searchNetLabel.getBgColor()));
            if (b.f284276a[searchNetLabel.getType().ordinal()] == 1) {
                Intrinsics.checkNotNullExpressionValue(childView, "childView");
                e(childView, searchNetLabel, jumpAction);
            } else {
                Intrinsics.checkNotNullExpressionValue(childView, "childView");
                c(childView, searchNetLabel);
            }
            i3 = i16;
        }
        int childCount = getChildCount();
        int i17 = this.initShowSize;
        if (childCount > i17) {
            int childCount2 = getChildCount();
            while (i17 < childCount2) {
                getChildAt(i17).setVisibility(8);
                i17++;
            }
        }
    }

    public final void i(@NotNull final View view, @Nullable final String str, boolean z16, @Nullable final Function0<String> function0, @NotNull final String identifier) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.b
            @Override // java.lang.Runnable
            public final void run() {
                QSearchLabelLayout.j(str, function0, view, identifier, this);
            }
        };
        if (z16) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    public final void setParentReportInfo(@Nullable JSONObject jSONObject) {
        this.parentReportInfo = jSONObject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchLabelLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
    }
}
