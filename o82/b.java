package o82;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lo82/b;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "", VideoTemplateParser.ITEM_LIST, "b", "Lo82/a;", "Ljava/util/List;", "filterList", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<a> filterList;

    public b() {
        List<a> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new c(), new d()});
        this.filterList = listOf;
    }

    private final boolean a(QQStrangerLIAItem item) {
        Iterator<T> it = this.filterList.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).a(item)) {
                QLog.d("QQStrangerLIAFilterUtil", 1, "filter item: (type=" + item.getType() + ", chatType=" + item.getChatType() + ", peerTinyId=" + item.getPeerTinyId() + ")");
                return true;
            }
        }
        return false;
    }

    public final List<QQStrangerLIAItem> b(List<QQStrangerLIAItem> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : itemList) {
            if (!a((QQStrangerLIAItem) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
