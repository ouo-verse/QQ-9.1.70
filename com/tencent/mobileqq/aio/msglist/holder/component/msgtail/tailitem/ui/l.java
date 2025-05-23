package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)Ljava/lang/Integer;", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer b(MsgRecord msgRecord) {
        Object obj;
        FaceElement faceElement;
        boolean z16;
        ArrayList<MsgElement> elementList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elementList, "elementList");
        Iterator<T> it = elementList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).elementType == 6) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement != null) {
            faceElement = msgElement.faceElement;
        } else {
            faceElement = null;
        }
        if (faceElement == null) {
            return null;
        }
        return Integer.valueOf(faceElement.faceIndex);
    }
}
