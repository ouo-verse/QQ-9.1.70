package com.tencent.sqshow.zootopia.report;

import av4.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0003J/\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/report/MsgBodyContent;", "Ljava/io/Serializable;", "Lav4/b;", "convertToMsgBodyCommon", "", "component1", "", "component2", "", "Lcom/tencent/sqshow/zootopia/report/ExtItem;", "component3", "uin", "event_ts", "extData", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "J", "getEvent_ts", "()J", "Ljava/util/List;", "getExtData", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;JLjava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class MsgBodyContent implements Serializable {
    private final long event_ts;
    private final List<ExtItem> extData;
    private final String uin;

    public MsgBodyContent(String uin, long j3, List<ExtItem> list) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.event_ts = j3;
        this.extData = list;
    }

    /* renamed from: component1, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEvent_ts() {
        return this.event_ts;
    }

    public final List<ExtItem> component3() {
        return this.extData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
    
        if (r1 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final av4.b convertToMsgBodyCommon() {
        c[] cVarArr;
        int collectionSizeOrDefault;
        av4.b bVar = new av4.b();
        bVar.f27007a = Long.parseLong(this.uin);
        bVar.f27009c = this.event_ts;
        List<ExtItem> list = this.extData;
        if (list != null) {
            List<ExtItem> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((ExtItem) it.next()).convertToMsgExtItem());
            }
            Object[] array = arrayList.toArray(new c[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            cVarArr = (c[]) array;
        }
        cVarArr = new c[0];
        bVar.f27008b = cVarArr;
        return bVar;
    }

    public final MsgBodyContent copy(String uin, long event_ts, List<ExtItem> extData) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new MsgBodyContent(uin, event_ts, extData);
    }

    public final long getEvent_ts() {
        return this.event_ts;
    }

    public final List<ExtItem> getExtData() {
        return this.extData;
    }

    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int hashCode = ((this.uin.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.event_ts)) * 31;
        List<ExtItem> list = this.extData;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "MsgBodyContent(uin=" + this.uin + ", event_ts=" + this.event_ts + ", extData=" + this.extData + ")";
    }

    public /* synthetic */ MsgBodyContent(String str, long j3, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, (i3 & 4) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgBodyContent copy$default(MsgBodyContent msgBodyContent, String str, long j3, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = msgBodyContent.uin;
        }
        if ((i3 & 2) != 0) {
            j3 = msgBodyContent.event_ts;
        }
        if ((i3 & 4) != 0) {
            list = msgBodyContent.extData;
        }
        return msgBodyContent.copy(str, j3, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgBodyContent)) {
            return false;
        }
        MsgBodyContent msgBodyContent = (MsgBodyContent) other;
        return Intrinsics.areEqual(this.uin, msgBodyContent.uin) && this.event_ts == msgBodyContent.event_ts && Intrinsics.areEqual(this.extData, msgBodyContent.extData);
    }
}
