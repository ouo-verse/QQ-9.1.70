package com.tencent.qqnt.msgselect;

import android.os.Bundle;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/msgselect/c;", "Lcom/tencent/qqnt/msgselect/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "Landroid/os/Bundle;", "result", "", "a", "<init>", "()V", "aio-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((AIOMsgItem) t16).getMsgSeq()), Long.valueOf(((AIOMsgItem) t17).getMsgSeq()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.msgselect.b
    public void a(@NotNull com.tencent.aio.api.runtime.a context, @NotNull List<? extends AIOMsgItem> msgList, @NotNull Bundle result) {
        List sortedWith;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        long[] longArray;
        long[] longArray2;
        long[] longArray3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, msgList, result);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(result, "result");
        if (QLog.isColorLevel()) {
            QLog.i("InviteGroupMsgSelectProcessor", 1, "msgList: " + msgList.size());
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(msgList, new a());
        List list = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgId()));
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(Long.valueOf(((AIOMsgItem) it5.next()).getMsgRecord().msgTime));
        }
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        Iterator it6 = list.iterator();
        while (it6.hasNext()) {
            arrayList3.add(Long.valueOf(((AIOMsgItem) it6.next()).getMsgSeq()));
        }
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        result.putLongArray("key_select_msg_ids", longArray);
        longArray2 = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
        result.putLongArray("key_select_msg_times", longArray2);
        longArray3 = CollectionsKt___CollectionsKt.toLongArray(arrayList3);
        result.putLongArray("key_select_msg_seqs", longArray3);
    }
}
