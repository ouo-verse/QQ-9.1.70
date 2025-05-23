package la3;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z93.c;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lla3/b;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/holder/new/BaseNewAlbumViewHolder;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "data", "", "U", "", "subTitleList", "", "timestamp", "W", "Landroid/view/View;", "view", "", "T", "N", "itemView", "Lia3/b;", "clickListener", "<init>", "(Landroid/view/View;Lia3/b;)V", "M", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends BaseNewAlbumViewHolder {

    @NotNull
    private static final List<String> N;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u5f80\u5e74\u5c81\u6708", "\u90a3\u4e9b\u5e74", "\u65e7\u65f6\u5149"});
        N = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View itemView, @Nullable ia3.b bVar) {
        super(itemView, bVar);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    private final String U(WinkNewMemoryAlbumResult data) {
        Object next;
        Iterator<T> it = data.i().iterator();
        Object obj = null;
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                long timestamp = ((z83.a) next).getTimestamp();
                do {
                    Object next2 = it.next();
                    long timestamp2 = ((z83.a) next2).getTimestamp();
                    if (timestamp < timestamp2) {
                        next = next2;
                        timestamp = timestamp2;
                    }
                } while (it.hasNext());
            }
        }
        z83.a aVar = (z83.a) next;
        Iterator<T> it5 = data.i().iterator();
        if (it5.hasNext()) {
            obj = it5.next();
            if (it5.hasNext()) {
                long timestamp3 = ((z83.a) obj).getTimestamp();
                do {
                    Object next3 = it5.next();
                    long timestamp4 = ((z83.a) next3).getTimestamp();
                    if (timestamp3 > timestamp4) {
                        obj = next3;
                        timestamp3 = timestamp4;
                    }
                } while (it5.hasNext());
            }
        }
        z83.a aVar2 = (z83.a) obj;
        if (aVar != null && aVar2 != null) {
            if (aVar.getYear() != aVar2.getYear()) {
                return W(N, aVar.getTimestamp());
            }
            if (aVar.getMonth() != aVar2.getMonth()) {
                return aVar.getYear() + "\u5e74";
            }
            if (aVar.getDayOfMonth() != aVar2.getDayOfMonth()) {
                return aVar.getYear() + "\u5e74" + aVar.getMonth() + "\u6708";
            }
            return aVar.getYear() + "\u5e74" + aVar.getMonth() + "\u6708" + aVar.getDayOfMonth() + "\u65e5";
        }
        return W(N, 0L);
    }

    private final String W(List<String> subTitleList, long timestamp) {
        return subTitleList.get(RandomKt.Random(timestamp).nextInt(subTitleList.size()));
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.holder.p009new.BaseNewAlbumViewHolder, ja3.b
    /* renamed from: N */
    public void q(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.q(data);
        TextView date = getDate();
        if (date != null) {
            date.setText(U(data));
            date.requestLayout();
        }
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
