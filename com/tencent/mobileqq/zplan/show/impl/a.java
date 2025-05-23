package com.tencent.mobileqq.zplan.show.impl;

import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/msg/d;", "", "e", "", "a", "g", "d", "c", "b", "f", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {
    public static final String a(d dVar) {
        Object first;
        String replace$default;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.a().elements.isEmpty()) {
            return "";
        }
        ArrayList<MsgElement> arrayList = dVar.a().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        MsgElement msgElement = (MsgElement) first;
        TextElement textElement = msgElement.textElement;
        if (textElement == null) {
            return "";
        }
        String content = textElement.content;
        if (msgElement.elementType == 1) {
            MsgAttributeInfo msgAttributeInfo = dVar.a().msgAttrs.get(11);
            if ((msgAttributeInfo != null ? msgAttributeInfo.zPlanMsgInfo : null) != null) {
                Intrinsics.checkNotNullExpressionValue(content, "content");
                replace$default = StringsKt__StringsJVMKt.replace$default(content, IZPlanMsgService.ZPLAN_MSG_PREFIX, "", false, 4, (Object) null);
                return replace$default;
            }
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        return content;
    }

    public static final boolean b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return dVar.a().msgType == 3;
    }

    public static final boolean c(d dVar) {
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.a().msgType == 11 && (arrayList = dVar.a().elements) != null) {
            arrayList.isEmpty();
            if (dVar.a().elements.get(0).elementType == 10 && dVar.a().elements.get(0).arkElement != null) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return dVar.a().msgType == 10;
    }

    public static final boolean e(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.a().msgType != 2) {
            return false;
        }
        ArrayList<MsgElement> arrayList = dVar.a().elements;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        ArrayList<MsgElement> arrayList2 = dVar.a().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 6 && i3 != 1) {
                return false;
            }
        }
        return true;
    }

    public static final boolean f(d dVar) {
        Object first;
        Object first2;
        Object first3;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.a().msgType != 10 || dVar.a().elements.isEmpty()) {
            return false;
        }
        ArrayList<MsgElement> arrayList = dVar.a().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        if (((MsgElement) first).walletElement != null) {
            ArrayList<MsgElement> arrayList2 = dVar.a().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
            if (((MsgElement) first2).walletElement.sender != null) {
                ArrayList<MsgElement> arrayList3 = dVar.a().elements;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "msgRecord.elements");
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList3);
                if (((MsgElement) first3).walletElement.sender.content.equals("QQ\u8f6c\u8d26")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean g(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        return dVar.a().msgType == 6;
    }
}
