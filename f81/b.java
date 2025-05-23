package f81;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.qwallet.api.IQWalletAIOApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lf81/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "getViewType", "", "e2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends AIOMsgItem {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public List<CharSequence> Q() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("[QQ\u7ea2\u5305]");
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new b(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        boolean z16;
        WalletElement b16 = a.b(getMsgRecord());
        if (b16 != null && f.c(b16.msgType)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && ((IQWalletAIOApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQWalletAIOApi.class)).isHbMsgMultiSelect()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        if (getMsgRecord().msgType == 10) {
            WalletElement b16 = a.b(getMsgRecord());
            boolean z16 = false;
            if (b16 != null && f.d(b16.msgType)) {
                z16 = true;
            }
            if (z16) {
                if (isSelf()) {
                    return 43;
                }
                return 42;
            }
            if (isSelf()) {
                return 28;
            }
            return 27;
        }
        return super.getViewType();
    }
}
