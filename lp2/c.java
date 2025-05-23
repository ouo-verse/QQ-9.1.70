package lp2;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection;
import com.tencent.mobileqq.search.searchdetail.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Llp2/c;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchReportSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/model/c;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "f", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "setTvDesc", "(Landroid/widget/TextView;)V", "tvDesc", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends BaseSearchReportSection<com.tencent.mobileqq.search.searchdetail.content.model.c> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvDesc;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(c this$0, com.tencent.mobileqq.search.searchdetail.content.model.c cVar) {
        String str;
        JSONObject jSONObject;
        CommonInfo commonInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.containerView;
        if (view != null) {
            r rVar = r.f284572a;
            if (cVar == null || (commonInfo = cVar.getCommonInfo()) == null || (str = commonInfo.getTraceId()) == null) {
                str = "";
            }
            if (cVar != null) {
                jSONObject = cVar.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String();
            } else {
                jSONObject = null;
            }
            rVar.e(view, "em_search_no_result_card", this$0.q(str, String.valueOf(jSONObject)));
        }
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
        TextView textView;
        this.containerView = containerView;
        if (containerView != null) {
            textView = (TextView) containerView.findViewById(R.id.f167042k73);
        } else {
            textView = null;
        }
        this.tvDesc = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final com.tencent.mobileqq.search.searchdetail.content.model.c data, int position, @Nullable List<Object> payload) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        super.onBindData(data, position, payload);
        TextView textView = this.tvDesc;
        if (textView != null) {
            if (data == null || (str = data.getText()) == null) {
                str = "\u6682\u65e0\u5185\u5bb9";
            }
            textView.setText(str);
        }
        com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
        if (dtReportIoc != null) {
            jSONObject = dtReportIoc.f();
        } else {
            jSONObject = null;
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "extraParam.keys()");
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (data != null && (jSONObject2 = data.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String()) != null) {
                    jSONObject2.put(str2, jSONObject.opt(str2));
                }
            }
        }
        View view = this.containerView;
        if (view != null) {
            view.post(new Runnable() { // from class: lp2.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.v(c.this, data);
                }
            });
        }
    }
}
