package iu1;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "abstract", "", "a", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {
    public static final boolean a(@NotNull MsgAbstract msgAbstract, @NotNull MsgAbstract msgAbstract2) {
        Intrinsics.checkNotNullParameter(msgAbstract, "<this>");
        Intrinsics.checkNotNullParameter(msgAbstract2, "abstract");
        if (msgAbstract2.elements.isEmpty()) {
            return false;
        }
        Iterator<MsgAbstractElement> it = msgAbstract2.elements.iterator();
        while (it.hasNext()) {
            if (it.next().elementType == 14) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@NotNull MsgAbstract msgAbstract, @NotNull MsgAbstract msgAbstract2) {
        Intrinsics.checkNotNullParameter(msgAbstract, "<this>");
        Intrinsics.checkNotNullParameter(msgAbstract2, "abstract");
        if (msgAbstract2.elements.isEmpty()) {
            return false;
        }
        Iterator<MsgAbstractElement> it = msgAbstract2.elements.iterator();
        while (it.hasNext()) {
            if (it.next().elementType == 18) {
                return true;
            }
        }
        return false;
    }
}
