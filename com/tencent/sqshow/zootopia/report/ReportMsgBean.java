package com.tencent.sqshow.zootopia.report;

import av4.d;
import av4.f;
import com.tencent.hippy.qq.api.TabPreloadItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", "Ljava/io/Serializable;", "Lav4/f;", "convertToReportMsgReq", "", "Lcom/tencent/sqshow/zootopia/report/ReportMsgInfo;", "component1", TabPreloadItem.TAB_NAME_MESSAGE, "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getMsgList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class ReportMsgBean implements Serializable {
    private final List<ReportMsgInfo> msgList;

    public ReportMsgBean(List<ReportMsgInfo> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        this.msgList = msgList;
    }

    public final List<ReportMsgInfo> component1() {
        return this.msgList;
    }

    public final f convertToReportMsgReq() {
        int collectionSizeOrDefault;
        f fVar = new f();
        List<ReportMsgInfo> list = this.msgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ReportMsgInfo) it.next()).convertToMsgInfo());
        }
        Object[] array = arrayList.toArray(new d[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        fVar.f27019a = (d[]) array;
        return fVar;
    }

    public final ReportMsgBean copy(List<ReportMsgInfo> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        return new ReportMsgBean(msgList);
    }

    public final List<ReportMsgInfo> getMsgList() {
        return this.msgList;
    }

    public int hashCode() {
        return this.msgList.hashCode();
    }

    public String toString() {
        return "ReportMsgBean(msgList=" + this.msgList + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReportMsgBean copy$default(ReportMsgBean reportMsgBean, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = reportMsgBean.msgList;
        }
        return reportMsgBean.copy(list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ReportMsgBean) && Intrinsics.areEqual(this.msgList, ((ReportMsgBean) other).msgList);
    }
}
