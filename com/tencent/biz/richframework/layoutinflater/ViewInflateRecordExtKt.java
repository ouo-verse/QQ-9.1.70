package com.tencent.biz.richframework.layoutinflater;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.richframework.argus.page.db.HistoryInflateRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007*\u00020\u0002\u00a8\u0006\b"}, d2 = {"addInflateRecord", "", "Landroid/view/View;", "historyInflateRecord", "Lcom/tencent/richframework/argus/page/db/HistoryInflateRecord;", "getInflateRecord", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "layoutinflater_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ViewInflateRecordExtKt {
    public static final void addInflateRecord(@NotNull View addInflateRecord, @NotNull HistoryInflateRecord historyInflateRecord) {
        Intrinsics.checkNotNullParameter(addInflateRecord, "$this$addInflateRecord");
        Intrinsics.checkNotNullParameter(historyInflateRecord, "historyInflateRecord");
        Object tag = addInflateRecord.getTag(R.id.f1187474z);
        if (!(tag instanceof ArrayList)) {
            tag = null;
        }
        ArrayList arrayList = (ArrayList) tag;
        if (arrayList == null) {
            arrayList = new ArrayList();
            addInflateRecord.setTag(R.id.f1187474z, arrayList);
        }
        arrayList.add(historyInflateRecord);
    }

    @Nullable
    public static final ArrayList<HistoryInflateRecord> getInflateRecord(@NotNull View getInflateRecord) {
        Intrinsics.checkNotNullParameter(getInflateRecord, "$this$getInflateRecord");
        Object tag = getInflateRecord.getTag(R.id.f1187474z);
        if (!(tag instanceof ArrayList)) {
            tag = null;
        }
        return (ArrayList) tag;
    }
}
