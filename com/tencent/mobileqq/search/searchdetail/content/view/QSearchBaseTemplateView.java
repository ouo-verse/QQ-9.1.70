package com.tencent.mobileqq.search.searchdetail.content.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTopicHeaderItem;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.mobileqq.search.util.s;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchLayOut;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import rn2.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KB\u001b\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bJ\u0010NJ\u0014\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\nJ2\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H&J2\u0010\u0019\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u001aH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0006H\u0016J(\u0010'\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010%H\u0016J4\u0010*\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010)\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010%H\u0016R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010+R$\u00101\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00109\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u00102\u001a\u0004\b7\u00104\"\u0004\b8\u00106R$\u0010?\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010A\u001a\u00020\u000e8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b!\u00102\u001a\u0004\b@\u00104R\u001a\u0010G\u001a\u00020B8\u0014X\u0094D\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/view/QSearchBaseTemplateView;", "Landroid/widget/FrameLayout;", "Lsp2/a;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/g;", "", "dtAppKey", "Lorg/json/JSONObject;", "f", "Landroid/view/View;", "getView", "", "t", "Lcom/tencent/mobileqq/search/searchdetail/a;", "data", "", "position", "", "", "payload", "Lcom/tencent/mobileqq/search/searchdetail/d;", "pageIoc", "a", "Landroid/view/ViewGroup;", "contentFlame", "i", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/SearchLayOut;", "layoutInfo", "k", "p", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "moreJumpInfo", "", "extensionMap", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", CacheTable.TABLE_NAME, "b", "Landroid/view/ViewGroup;", "Lcom/tencent/mobileqq/search/searchdetail/d;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/search/searchdetail/d;", "setPageIOC", "(Lcom/tencent/mobileqq/search/searchdetail/d;)V", "pageIOC", "I", "o", "()I", "setPosition", "(I)V", "r", "setWithoutTitlePosition", "withoutTitlePosition", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "j", "()Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "setDataModel", "(Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;)V", "dataModel", "g", "cardMargin", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "l", "()Z", "overrideBackground", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class QSearchBaseTemplateView extends FrameLayout implements sp2.a, com.tencent.mobileqq.search.searchdetail.content.base.g {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean overrideBackground;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup contentFlame;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.searchdetail.d pageIOC;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int withoutTitlePosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int cardMargin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchBaseTemplateView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.withoutTitlePosition = -1;
        this.cardMargin = 8;
        t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(QSearchBaseTemplateView qSearchBaseTemplateView, SearchJump searchJump, com.tencent.mobileqq.search.searchdetail.content.model.g gVar, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = null;
            }
            qSearchBaseTemplateView.b(searchJump, gVar, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doJump");
    }

    private final JSONObject f(String dtAppKey) {
        long j3;
        String str;
        com.tencent.mobileqq.search.searchdetail.d dVar = this.pageIOC;
        if (dVar != null) {
            j3 = dVar.getTabMask();
        } else {
            j3 = -1;
        }
        com.tencent.mobileqq.search.searchdetail.d dVar2 = this.pageIOC;
        if (dVar2 == null || (str = dVar2.getTabName()) == null) {
            str = "";
        }
        JSONObject a16 = s.f285072a.a(dtAppKey);
        a16.put("tab_name", str);
        a16.put("tab_mask", j3);
        return a16;
    }

    @Override // sp2.a
    public void a(@NotNull final com.tencent.mobileqq.search.searchdetail.a data, final int position, @Nullable List<Object> payload, @Nullable com.tencent.mobileqq.search.searchdetail.d pageIoc) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        SearchReportInfo searchReportInfo;
        float f16;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof com.tencent.mobileqq.search.searchdetail.content.template.model.a)) {
            return;
        }
        this.dataModel = (com.tencent.mobileqq.search.searchdetail.content.template.model.a) data;
        this.position = position;
        this.withoutTitlePosition = data.getWithoutTitlePosition();
        this.pageIOC = pageIoc;
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar = (com.tencent.mobileqq.search.searchdetail.content.template.model.a) data;
        SearchLayOut layoutInfo = aVar.getLayoutInfo();
        boolean z16 = layoutInfo.useOneCard;
        boolean isFirstItem = data.getCommonInfo().getIsFirstItem();
        boolean isLastItem = data.getCommonInfo().getIsLastItem();
        int k3 = k(layoutInfo);
        ViewUtils viewUtils = ViewUtils.f352270a;
        float a16 = viewUtils.a(layoutInfo.topCorner);
        float a17 = viewUtils.a(layoutInfo.bottomCorner);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QQSearch.NetDetail.QSearchBaseTemplateView", "doOnBindData position=" + position + " data=" + data.hashCode() + " isUseWholeCard=" + z16 + " isFirstItem=" + isFirstItem + " isLastItem=" + isLastItem + " marginTop=" + k3 + " topCorner=" + a16 + " bottomCorner=" + a17);
        }
        ViewGroup viewGroup = this.contentFlame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentFlame");
            viewGroup = null;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.setMargins(h(aVar), k3, h(aVar), 0);
        }
        ViewExtKt.d(this, m(aVar));
        ViewExtKt.e(this, m(aVar));
        if (!getOverrideBackground()) {
            if (z16) {
                float f17 = 0.0f;
                if (isFirstItem) {
                    f16 = viewUtils.a(8.0f);
                } else {
                    f16 = 0.0f;
                }
                if (isLastItem) {
                    f17 = viewUtils.a(8.0f);
                }
                BaseSearchTemplateSection.Companion companion = BaseSearchTemplateSection.INSTANCE;
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                setBackground(companion.a(true, f16, f17, resources));
            } else {
                BaseSearchTemplateSection.Companion companion2 = BaseSearchTemplateSection.INSTANCE;
                Resources resources2 = getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                setBackground(companion2.a(true, a16, a17, resources2));
            }
        }
        if (QSearchDetailUtilKt.i(aVar.getJumpLink())) {
            j.u(j.f431768a, this, "QQSearch.NetDetail.QSearchBaseTemplateView", 0L, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView$doOnBindData$2
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
                    Intrinsics.checkNotNullParameter(it, "it");
                    QSearchBaseTemplateView qSearchBaseTemplateView = QSearchBaseTemplateView.this;
                    SearchJump jumpLink = ((com.tencent.mobileqq.search.searchdetail.content.template.model.a) data).getJumpLink();
                    com.tencent.mobileqq.search.searchdetail.content.template.model.a dataModel = QSearchBaseTemplateView.this.getDataModel();
                    QSearchBaseTemplateView.c(qSearchBaseTemplateView, jumpLink, dataModel != null ? dataModel.getReportInfoWrapper() : null, null, 4, null);
                }
            }, 2, null);
        } else {
            setOnClickListener(null);
        }
        final com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = aVar.getReportInfoWrapper();
        if (reportInfoWrapper != null && (searchReportInfo = reportInfoWrapper.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String()) != null) {
            i.i(this, searchReportInfo.eid, true, new Function0<JSONObject>() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.QSearchBaseTemplateView$doOnBindData$3$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    return i.c(com.tencent.mobileqq.search.searchdetail.content.model.g.this, this.p(position, (com.tencent.mobileqq.search.searchdetail.content.template.model.a) data), this.e());
                }
            }, String.valueOf(searchReportInfo.hashCode()));
        }
        s(data, position, payload, pageIoc);
    }

    public void b(@Nullable SearchJump moreJumpInfo, @Nullable com.tencent.mobileqq.search.searchdetail.content.model.g reportInfo, @Nullable Map<String, String> extensionMap) {
        String str;
        long j3;
        boolean z16;
        Map map;
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar = this.dataModel;
        if (aVar != null) {
            com.tencent.mobileqq.search.searchdetail.d dVar = this.pageIOC;
            if (dVar == null || (str = dVar.getKeyword()) == null) {
                str = "";
            }
            String str2 = str;
            com.tencent.mobileqq.search.searchdetail.d dVar2 = this.pageIOC;
            if (dVar2 != null) {
                j3 = dVar2.getTabMask();
            } else {
                j3 = -1;
            }
            long j16 = j3;
            com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar2 = this.dataModel;
            if (aVar2 == null) {
                z16 = true;
            } else {
                z16 = aVar2 instanceof NetSearchTemplateTopicHeaderItem;
            }
            if (z16) {
                com.tencent.mobileqq.guild.report.b.g("functional_qq_search", "QQSearch.NetDetail.QSearchBaseTemplateView");
            }
            if (extensionMap != null) {
                map = MapsKt__MapsKt.toMutableMap(extensionMap);
            } else {
                map = null;
            }
            QSearchDetailUtilKt.g(getContext(), moreJumpInfo, str2, aVar.getCommonInfo().getTraceId(), j16, map, this.pageIOC);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.g
    public void d(@Nullable SearchJump moreJumpInfo, @Nullable Map<String, String> extensionMap) {
        com.tencent.mobileqq.search.searchdetail.content.model.g gVar;
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar = this.dataModel;
        if (aVar != null) {
            gVar = aVar.getReportInfoWrapper();
        } else {
            gVar = null;
        }
        b(moreJumpInfo, gVar, extensionMap);
    }

    @Nullable
    public JSONObject e() {
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar = this.dataModel;
        boolean z16 = false;
        if (aVar != null && aVar.getDocPosition() == -1) {
            z16 = true;
        }
        Integer num = null;
        if (z16) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar2 = this.dataModel;
        if (aVar2 != null) {
            num = Integer.valueOf(aVar2.getDocPosition());
        }
        jSONObject.put("doc_position", String.valueOf(num));
        return jSONObject;
    }

    /* renamed from: g, reason: from getter */
    protected int getCardMargin() {
        return this.cardMargin;
    }

    public int h(@NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getLayoutInfo().fullWidthLayout) {
            return 0;
        }
        return ViewUtils.f352270a.b(getCardMargin());
    }

    @NotNull
    public abstract View i(@NotNull ViewGroup contentFlame);

    @Nullable
    /* renamed from: j, reason: from getter */
    public final com.tencent.mobileqq.search.searchdetail.content.template.model.a getDataModel() {
        return this.dataModel;
    }

    public int k(@NotNull SearchLayOut layoutInfo) {
        Intrinsics.checkNotNullParameter(layoutInfo, "layoutInfo");
        return ViewUtils.f352270a.a(layoutInfo.marginTop);
    }

    /* renamed from: l, reason: from getter */
    protected boolean getOverrideBackground() {
        return this.overrideBackground;
    }

    public int m(@NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return ViewUtils.f352270a.a(16.0f);
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final com.tencent.mobileqq.search.searchdetail.d getPageIOC() {
        return this.pageIOC;
    }

    /* renamed from: o, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public JSONObject p(int position, @NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.a data) {
        String str;
        String str2;
        String str3;
        String str4;
        String sugTraceId;
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.search.searchdetail.d dVar = this.pageIOC;
        String str5 = "";
        if (dVar == null || (str = dVar.getKeyword()) == null) {
            str = "";
        }
        com.tencent.mobileqq.search.searchdetail.d dVar2 = this.pageIOC;
        if (dVar2 != null) {
            str2 = dVar2.getDtAppKey();
        } else {
            str2 = null;
        }
        JSONObject f16 = f(str2);
        com.tencent.mobileqq.search.searchdetail.d dVar3 = this.pageIOC;
        if (dVar3 == null || (str3 = Integer.valueOf(dVar3.getQuerySource()).toString()) == null) {
            str3 = "";
        }
        com.tencent.mobileqq.search.searchdetail.d dVar4 = this.pageIOC;
        if (dVar4 == null || (str4 = Integer.valueOf(dVar4.getUserSource()).toString()) == null) {
            str4 = "";
        }
        f16.put("search_query_text", str);
        f16.put("search_trace_id", data.getCommonInfo().getTraceId());
        f16.put("serial_number", position + 1);
        com.tencent.mobileqq.search.searchdetail.d dVar5 = this.pageIOC;
        if (dVar5 != null && (sugTraceId = dVar5.getSugTraceId()) != null) {
            str5 = sugTraceId;
        }
        f16.put("sug_trace_id", str5);
        f16.put("query_source", str3);
        f16.put("user_source", str4);
        if (data.getDocPosition() != -1) {
            f16.put("doc_position", String.valueOf(data.getDocPosition()));
        }
        return f16;
    }

    @NotNull
    public final JSONObject q(int position, @NotNull com.tencent.mobileqq.search.searchdetail.content.template.model.a data) {
        JSONObject e16;
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.search.searchdetail.content.model.g reportInfoWrapper = data.getReportInfoWrapper();
        if (reportInfoWrapper == null || (e16 = i.e(reportInfoWrapper, p(position, data), null, 2, null)) == null) {
            return p(position, data);
        }
        return e16;
    }

    /* renamed from: r, reason: from getter */
    public final int getWithoutTitlePosition() {
        return this.withoutTitlePosition;
    }

    public abstract void s(@NotNull com.tencent.mobileqq.search.searchdetail.a data, int position, @Nullable List<Object> payload, @Nullable com.tencent.mobileqq.search.searchdetail.d pageIoc);

    public final void setDataModel(@Nullable com.tencent.mobileqq.search.searchdetail.content.template.model.a aVar) {
        this.dataModel = aVar;
    }

    public final void setPageIOC(@Nullable com.tencent.mobileqq.search.searchdetail.d dVar) {
        this.pageIOC = dVar;
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }

    public final void setWithoutTitlePosition(int i3) {
        this.withoutTitlePosition = i3;
    }

    public final void t() {
        this.contentFlame = this;
        addView(i(this), -1, -2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchBaseTemplateView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.withoutTitlePosition = -1;
        this.cardMargin = 8;
        t();
    }

    @Override // sp2.a
    @NotNull
    public View getView() {
        return this;
    }
}
