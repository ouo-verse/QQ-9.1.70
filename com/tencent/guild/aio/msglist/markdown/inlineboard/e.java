package com.tencent.guild.aio.msglist.markdown.inlineboard;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u0005H\u0002J\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b*\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000f\u001a\u00020\u00052\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000e\u001a\u00020\u0003\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/markdown/inlineboard/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "c", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "", "d", "(Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;)[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/guild/aio/msglist/markdown/InlineBtnPayload;", "payload", "btnModel", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f111771a = new e();

    e() {
    }

    private final String b(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a c(InlineKeyboardButton inlineKeyboardButton) {
        String id5 = inlineKeyboardButton.f359191id;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        a.b bVar = new a.b(b(inlineKeyboardButton.label), b(inlineKeyboardButton.visitedLabel), inlineKeyboardButton.style, 0.0f, 0, 24, null);
        int i3 = inlineKeyboardButton.type;
        int i16 = inlineKeyboardButton.permissionType;
        List list = inlineKeyboardButton.specifyRoleIds;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = inlineKeyboardButton.specifyTinyids;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a(id5, bVar, new a.C0720a(i3, new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.c(i16, list, list2), inlineKeyboardButton.clickLimit, b(inlineKeyboardButton.data), inlineKeyboardButton.atBotShowChannelList, b(inlineKeyboardButton.unsupportTips), inlineKeyboardButton.isReply), inlineKeyboardButton, false, false, false, 112, null);
    }

    @NotNull
    public final String a(@NotNull GuildMsgItem payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        return payload.getMsgRecord().msgId + btnModel.c() + btnModel.f().b();
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] d(@NotNull InlineKeyboardElement inlineKeyboardElement) {
        Intrinsics.checkNotNullParameter(inlineKeyboardElement, "<this>");
        int size = inlineKeyboardElement.rows.size();
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] aVarArr = new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[size];
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList<InlineKeyboardButton> arrayList = inlineKeyboardElement.rows.get(i3).buttons;
            int size2 = arrayList.size();
            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr2 = new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                InlineKeyboardButton inlineKeyboardButton = arrayList.get(i16);
                Intrinsics.checkNotNullExpressionValue(inlineKeyboardButton, "row[columnIndex]");
                aVarArr2[i16] = c(inlineKeyboardButton);
            }
            aVarArr[i3] = aVarArr2;
        }
        return aVarArr;
    }
}
