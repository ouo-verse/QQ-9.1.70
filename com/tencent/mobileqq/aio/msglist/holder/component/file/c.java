package com.tencent.mobileqq.aio.msglist.holder.component.file;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.utils.AIOOptConfigKt;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", DTConstants.TAG.ELEMENT, "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    public static final int a(int i3, @NotNull FileElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (!AIOOptConfigKt.e()) {
            return i3;
        }
        if (i3 == 3) {
            return i3;
        }
        Integer num = element.picHeight;
        Intrinsics.checkNotNullExpressionValue(num, "element.picHeight");
        if (num.intValue() > 0) {
            Integer num2 = element.picWidth;
            Intrinsics.checkNotNullExpressionValue(num2, "element.picWidth");
            if (num2.intValue() > 0) {
                return i3;
            }
        }
        QLog.d("AIOFileViewExt", 1, "\u964d\u7ea7\u4e3a\u666e\u901a\u6587\u4ef6UI");
        return 3;
    }
}
