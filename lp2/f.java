package lp2;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.CommonInfo;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection;
import com.tencent.mobileqq.search.searchdetail.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J*\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Llp2/f;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchReportSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/model/d;", "Landroid/view/View;", "containerView", "", "onInitView", "", "getViewStubLayoutId", "data", "", "position", "", "", "payload", "u", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTvContent", "()Landroid/widget/TextView;", "setTvContent", "(Landroid/widget/TextView;)V", "tvContent", h.F, "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends BaseSearchReportSection<com.tencent.mobileqq.search.searchdetail.content.model.d> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvContent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View containerView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(f this$0, com.tencent.mobileqq.search.searchdetail.content.model.d dVar) {
        String str;
        JSONObject jSONObject;
        CommonInfo commonInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.containerView;
        if (view != null) {
            r rVar = r.f284572a;
            if (dVar == null || (commonInfo = dVar.getCommonInfo()) == null || (str = commonInfo.getTraceId()) == null) {
                str = "";
            }
            if (dVar != null) {
                jSONObject = dVar.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String();
            } else {
                jSONObject = null;
            }
            rVar.e(view, "em_bas_parting_line", this$0.q(str, String.valueOf(jSONObject)));
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
            textView = (TextView) containerView.findViewById(R.id.k6s);
        } else {
            textView = null;
        }
        this.tvContent = textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchReportSection, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final com.tencent.mobileqq.search.searchdetail.content.model.d data, int position, @Nullable List<Object> payload) {
        String str;
        super.onBindData(data, position, payload);
        TextView textView = this.tvContent;
        if (textView != null) {
            if (data == null || (str = data.getText()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        View view = this.containerView;
        if (view != null) {
            view.post(new Runnable() { // from class: lp2.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.v(f.this, data);
                }
            });
        }
    }
}
