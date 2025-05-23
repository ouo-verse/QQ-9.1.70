package ia3;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lia3/c;", "Lia3/a;", "", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "list", "", "j0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "position", "onBindViewHolder", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "G", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "getReportHelper", "()Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;", "reportHelper", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a reportHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Activity activity, @NotNull com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper.a reportHelper) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
        this.reportHelper = reportHelper;
    }

    public final void j0(@NotNull List<WinkAlbumItemWrapper> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        setData(list);
    }

    @Override // ia3.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        if (position == 0) {
            this.reportHelper.c(getItems().get(0).getWinkNewAlbum());
        }
    }
}
