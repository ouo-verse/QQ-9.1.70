package kz1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz1.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001f\u0010 J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\f\u0010\rJ>\u0010\u0017\u001a\u00020\t*\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lkz1/i;", "Lmz1/c;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "Llz1/a;", "clickIoc", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lmz1/c;ILlz1/a;)V", DomainData.DOMAIN_NAME, "(Lmz1/c;I)V", "Landroid/view/View;", "", "elementId", "", "needAsync", "", "", "elementParams", IECDtReport.ACTION_IDENTIFIER, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "Llz1/a;", "o", "()Llz1/a;", "p", "(Llz1/a;)V", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class i<T extends mz1.c> extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    public lz1.a clickIoc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String str, Map map, String str2, View this_vr) {
        Intrinsics.checkNotNullParameter(this_vr, "$this_vr");
        if (str != null) {
            VideoReport.setElementId(this_vr, str);
        }
        if (map != null) {
            VideoReport.setElementParams(this_vr, map);
        }
        if (str2 != null) {
            VideoReport.setElementReuseIdentifier(this_vr, str2);
        }
        VideoReport.setElementExposePolicy(this_vr, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this_vr, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this_vr, ClickPolicy.REPORT_ALL);
    }

    public final void m(@NotNull T item, int position, @NotNull lz1.a clickIoc) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(clickIoc, "clickIoc");
        this.itemView.setTag(item);
        n(item, position);
    }

    public abstract void n(@NotNull T item, int position);

    @NotNull
    public final lz1.a o() {
        lz1.a aVar = this.clickIoc;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clickIoc");
        return null;
    }

    public final void p(@NotNull lz1.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.clickIoc = aVar;
    }

    public void q(@NotNull final View view, @Nullable final String str, boolean z16, @Nullable final Map<String, ? extends Object> map, @Nullable final String str2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Runnable runnable = new Runnable() { // from class: kz1.h
            @Override // java.lang.Runnable
            public final void run() {
                i.r(str, map, str2, view);
            }
        };
        if (z16) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }
}
