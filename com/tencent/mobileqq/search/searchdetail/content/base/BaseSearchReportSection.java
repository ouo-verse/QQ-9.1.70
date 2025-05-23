package com.tencent.mobileqq.search.searchdetail.content.base;

import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.part.r;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J1\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchReportSection;", "T", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "data", "", "position", "", "", "payload", "", "onBindData", "(Ljava/lang/Object;ILjava/util/List;)V", "", "traceId", CacheTable.TABLE_NAME, "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "d", "Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", "p", "()Lcom/tencent/mobileqq/search/searchdetail/content/base/c;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/search/searchdetail/content/base/c;)V", "dtReportIoc", "Lcom/tencent/mobileqq/search/searchdetail/content/part/r;", "e", "Lkotlin/Lazy;", "r", "()Lcom/tencent/mobileqq/search/searchdetail/content/part/r;", "videoControlIoc", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseSearchReportSection<T> extends Section<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c dtReportIoc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoControlIoc;

    public BaseSearchReportSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<r>(this) { // from class: com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection$videoControlIoc$2
            final /* synthetic */ BaseSearchReportSection<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final r invoke() {
                return (r) SectionIOCKt.getIocInterface(this.this$0, r.class);
            }
        });
        this.videoControlIoc = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onBindData(@Nullable T data, int position, @Nullable List<Object> payload) {
        if (this.dtReportIoc == null) {
            this.dtReportIoc = (c) SectionIOCKt.getIocInterface(this, c.class);
        }
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final c getDtReportIoc() {
        return this.dtReportIoc;
    }

    @NotNull
    public final JSONObject q(@NotNull String traceId, @Nullable String reportInfo) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        JSONObject jSONObject = new JSONObject();
        c cVar = this.dtReportIoc;
        if (cVar != null) {
            jSONObject.put("search_query_text", cVar.getKeyword());
            jSONObject.put("search_trace_id", traceId);
            jSONObject.put("tab_name", cVar.getTabName());
            jSONObject.put("tab_mask", (int) cVar.getTabMask());
            jSONObject.put("query_source", String.valueOf(cVar.getQuerySource()));
            jSONObject.put("user_source", String.valueOf(cVar.getUserSource()));
            jSONObject.put("net_search_session_id", cVar.getSessionId());
            jSONObject.put("sug_trace_id", cVar.getSugTraceId());
        }
        BaseSearchTemplateSection.Companion companion = BaseSearchTemplateSection.INSTANCE;
        if (reportInfo == null) {
            reportInfo = "{}";
        }
        jSONObject.put("transfer_info", companion.c(reportInfo, jSONObject));
        return jSONObject;
    }

    @Nullable
    public final r r() {
        return (r) this.videoControlIoc.getValue();
    }

    public final void s(@Nullable c cVar) {
        this.dtReportIoc = cVar;
    }
}
