package f81;

import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\"\u0017\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "c", "", "chatType", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", "b", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", "firstWalletElement", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "MsgRecordExt")
/* loaded from: classes11.dex */
public final class a {
    public static final int a(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 != 4) {
            return 0;
        }
        return 11;
    }

    @Nullable
    public static final WalletElement b(@NotNull MsgRecord msgRecord) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).walletElement != null) {
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
        if (msgElement == null) {
            return null;
        }
        return msgElement.walletElement;
    }

    public static final boolean c(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        int i3 = msgRecord.sendType;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.getLongAccountUin() == msgRecord.senderUin) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }
}
