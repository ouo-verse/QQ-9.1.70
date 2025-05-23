package o81;

import android.util.Base64;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.pb.AssistedChatExtDataPB$MessageExtData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "c", "e", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/assistedchat/pb/AssistedChatExtDataPB$MessageExtData;", "a", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "b", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    @Nullable
    public static final AssistedChatExtDataPB$MessageExtData a(@NotNull InlineKeyboardButton inlineKeyboardButton) {
        boolean z16;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(inlineKeyboardButton, "<this>");
        String str = inlineKeyboardButton.data;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj = null;
        if (z16 || inlineKeyboardButton.type != 100) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(new AssistedChatExtDataPB$MessageExtData().mergeFrom(Base64.decode(inlineKeyboardButton.data, 0)));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl) && QLog.isColorLevel()) {
            QLog.e("decodeExtData", 2, String.valueOf(Result.m479exceptionOrNullimpl(m476constructorimpl)));
        }
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (AssistedChatExtDataPB$MessageExtData) obj;
    }

    public static final boolean b(@Nullable List<MsgRecord> list) {
        if (list != null) {
            for (MsgRecord msgRecord : list) {
                int i3 = msgRecord.msgType;
                if (i3 != 5 && i3 != 23) {
                    if (msgRecord.chatType == 104) {
                        if (i3 != 11 && i3 != 19) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static final boolean c(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem.getMsgRecord().sendType == 1) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        int i3 = aIOMsgItem.getMsgRecord().sendType;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (c(aIOMsgItem) && aIOMsgItem.getMsgRecord().sendStatus == 1) {
            return true;
        }
        return false;
    }
}
