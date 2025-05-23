package com.tencent.qqnt.chathistory.util;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.chathistory.exception.HistoryException;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\u001a.\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\f\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u000f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0010\u001a\u00020\r*\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u00a8\u0006\u0011"}, d2 = {"Landroid/widget/TextView;", "", "chatType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lkotlinx/coroutines/CoroutineScope;", "scope", "emoSize", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "textView", "c", "", "nickString", "f", "b", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MsgRecordExKt {
    private static final CharSequence b(CharSequence charSequence, int i3) {
        return ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getQQText(charSequence, 29, i3, null, null);
    }

    public static final void c(MemberInfo memberInfo, TextView textView, int i3) {
        if (!TextUtils.isEmpty(memberInfo.cardName)) {
            String cardName = memberInfo.cardName;
            Intrinsics.checkNotNullExpressionValue(cardName, "cardName");
            f(textView, cardName, i3);
            d.f354054a.a("bindDisplayName", "deal troop cardName " + memberInfo.cardName);
            return;
        }
        if (!TextUtils.isEmpty(memberInfo.remark)) {
            String remark = memberInfo.remark;
            Intrinsics.checkNotNullExpressionValue(remark, "remark");
            f(textView, remark, i3);
            d.f354054a.a("bindDisplayName", "deal troop remark " + memberInfo.remark);
            return;
        }
        String nick = memberInfo.nick;
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        f(textView, nick, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.String] */
    public static final void d(@NotNull TextView textView, int i3, @NotNull MsgRecord msgRecord, @NotNull CoroutineScope scope, int i16) {
        com.tencent.qqnt.kernel.api.m buddyService;
        ArrayList<String> arrayListOf;
        String str;
        ArrayList<String> arrayListOf2;
        com.tencent.qqnt.chathistory.service.e eVar;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = msgRecord.senderUid;
        String str2 = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    textView.setText("");
                    return;
                }
                throw new HistoryException("can not deal aio type " + i3);
            }
            Object tag = textView.getTag(R.id.tt5);
            if (tag instanceof com.tencent.qqnt.chathistory.service.e) {
                eVar = (com.tencent.qqnt.chathistory.service.e) tag;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                str2 = eVar.b();
            }
            if (Intrinsics.areEqual(str2, objectRef.element)) {
                return;
            }
            if (eVar != null) {
                eVar.a();
            }
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new MsgRecordExKt$setDisplayNickByMsgRecord$2(msgRecord, objectRef, textView, i16, null), 3, null);
            return;
        }
        if (MsgExtKt.S(msgRecord)) {
            objectRef.element = msgRecord.peerUid;
        }
        d dVar = d.f354054a;
        dVar.a("bindDisplayName", "deal c2c DisplayName");
        IKernelService i17 = com.tencent.qqnt.msg.f.i();
        if (i17 != null && (buddyService = i17.getBuddyService()) != null) {
            T displayUid = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(displayUid, "displayUid");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf((String) displayUid);
            Map<String, String> buddyRemark = buddyService.getBuddyRemark(arrayListOf);
            if (buddyRemark != null) {
                str = buddyRemark.get(objectRef.element);
            } else {
                str = null;
            }
            dVar.a("bindDisplayName", "remark " + str);
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                f(textView, str, i16);
                return;
            }
            T displayUid2 = objectRef.element;
            Intrinsics.checkNotNullExpressionValue(displayUid2, "displayUid");
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf((String) displayUid2);
            Map<String, String> buddyNick = buddyService.getBuddyNick(arrayListOf2);
            if (buddyNick != null) {
                str2 = buddyNick.get(objectRef.element);
            }
            dVar.a("bindDisplayName", "buddyNick " + str2);
            if (!TextUtils.isEmpty(str2)) {
                Intrinsics.checkNotNull(str2);
                f(textView, str2, i16);
                return;
            }
        }
        if (!TextUtils.isEmpty(msgRecord.sendMemberName)) {
            String str3 = msgRecord.sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.sendMemberName");
            f(textView, str3, i16);
            dVar.a("bindDisplayName", "msgRecord " + msgRecord.sendMemberName);
            return;
        }
        String str4 = msgRecord.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str4, "msgRecord.sendNickName");
        f(textView, str4, i16);
        dVar.a("bindDisplayName", "msgRecord " + msgRecord.sendNickName);
    }

    public static /* synthetic */ void e(TextView textView, int i3, MsgRecord msgRecord, CoroutineScope coroutineScope, int i16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            i16 = com.tencent.qqnt.emotion.constant.b.b();
        }
        d(textView, i3, msgRecord, coroutineScope, i16);
    }

    public static final void f(@NotNull TextView textView, @NotNull CharSequence nickString, int i3) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(nickString, "nickString");
        if (TextUtils.equals(textView.getText(), nickString)) {
            return;
        }
        textView.setText(b(nickString, i3));
    }
}
