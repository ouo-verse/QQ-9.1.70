package com.tencent.qqnt.aio.gallery;

import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "subId", "a", "base_proj_nt_ext_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    public static final int a(@NotNull MsgRecord msgRecord, int i3) {
        boolean z16;
        boolean z17;
        Integer num;
        Integer num2;
        Integer num3;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgRecord.elements.size() <= i3) {
            return 0;
        }
        MsgElement msgElement = msgRecord.elements.get(i3);
        int i16 = msgElement.elementType;
        boolean z18 = true;
        if (i16 == 2) {
            return 1;
        }
        if (i16 == 5) {
            return 3;
        }
        if (i16 == 3) {
            FileElement fileElement = msgElement.fileElement;
            if (fileElement != null && (num3 = fileElement.subElementType) != null && num3.intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                FileElement fileElement2 = msgElement.fileElement;
                if (fileElement2 != null && (num2 = fileElement2.subElementType) != null && num2.intValue() == 15) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    FileElement fileElement3 = msgElement.fileElement;
                    if (fileElement3 == null || (num = fileElement3.subElementType) == null || num.intValue() != 2) {
                        z18 = false;
                    }
                    if (z18) {
                        return 4;
                    }
                }
            }
            return 2;
        }
        return 0;
    }
}
