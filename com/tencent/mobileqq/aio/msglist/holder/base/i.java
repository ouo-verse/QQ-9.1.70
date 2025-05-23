package com.tencent.mobileqq.aio.msglist.holder.base;

import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "", "b", "c", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class i {
    public static final boolean a(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (msgElement.elementType == 3) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull MsgElement msgElement) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (!a(msgElement) || (fileElement = msgElement.fileElement) == null || c81.a.j(fileElement) != 0) {
            return false;
        }
        return true;
    }

    public static final boolean c(@NotNull MsgElement msgElement) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (!a(msgElement) || (fileElement = msgElement.fileElement) == null || c81.a.j(fileElement) != 2) {
            return false;
        }
        return true;
    }
}
