package la3;

import android.view.View;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z93.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\r"}, d2 = {"Lla3/a;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/holder/new/BaseNewAlbumViewHolder;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "data", "", "T", "itemView", "Lia3/b;", "clickListener", "<init>", "(Landroid/view/View;Lia3/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends BaseNewAlbumViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView, bVar);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder
    public void T(@Nullable View view, @Nullable WinkNewMemoryAlbumResult data) {
        Float firstOrNull;
        if (data != null && !data.getIsExposed()) {
            WinkPublishQualityReportData.Builder ext2 = new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_EXPOSURE_MEMORY_RESULT").ext1("1").ext2(data.getStoryID());
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(data.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String().getTextSimilaritys());
            WinkPublishQualityReportData reportData = ext2.ext3(String.valueOf(firstOrNull)).ext4("0").attachInfo("Peak").getReportData();
            c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.a(reportData, 1);
            }
        }
        super.T(view, data);
    }
}
