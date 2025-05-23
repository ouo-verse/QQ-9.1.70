package com.tencent.qqnt.msg;

import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a0\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0000j\b\u0012\u0004\u0012\u00020\u0004`\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\u0000\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0001\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0007H\u0000\u00a8\u0006\n"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "mrList", "Lcom/tencent/qqnt/msg/d;", "b", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "", "a", "msg_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class m {
    @NotNull
    public static final String a(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        int i3 = msgElement.elementType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 6) {
                        return GuildMsgElementApiImpl.MSG_ELEMENT_UN_SUPPORT_PROMPT;
                    }
                    String str = msgElement.faceElement.faceText;
                    if (str == null) {
                        return GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI;
                    }
                    return str;
                }
                return GuildMsgElementApiImpl.DESC_ELEMENT_FILE;
            }
            return GuildMsgElementApiImpl.DESC_ELEMENT_PIC;
        }
        String str2 = msgElement.textElement.content;
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @NotNull
    public static final ArrayList<d> b(@NotNull ArrayList<MsgRecord> mrList) {
        Intrinsics.checkNotNullParameter(mrList, "mrList");
        ArrayList<d> arrayList = new ArrayList<>();
        Iterator<T> it = mrList.iterator();
        while (it.hasNext()) {
            arrayList.add(c((MsgRecord) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final d c(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        return j.INSTANCE.a(msgRecord);
    }
}
