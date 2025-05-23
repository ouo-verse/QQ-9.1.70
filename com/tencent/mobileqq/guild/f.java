package com.tencent.mobileqq.guild;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSummaryDecodersApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/f;", "", "", "normalContent", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "abstract", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contactInfo", "", "d", "", "selfTinyId", "Lcom/tencent/mobileqq/guild/f$a;", "a", "<init>", "()V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f217908a = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/f$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getType", "()I", "setType", "(I)V", "type", "", "b", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "setMsgContent", "(Ljava/lang/CharSequence;)V", RemoteMessageConst.MessageBody.MSG_CONTENT, "<init>", "(ILjava/lang/CharSequence;)V", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.f$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class GuildChatMsgAbstract {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private CharSequence msgContent;

        public GuildChatMsgAbstract(int i3, @NotNull CharSequence msgContent) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            this.type = i3;
            this.msgContent = msgContent;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CharSequence getMsgContent() {
            return this.msgContent;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildChatMsgAbstract)) {
                return false;
            }
            GuildChatMsgAbstract guildChatMsgAbstract = (GuildChatMsgAbstract) other;
            if (this.type == guildChatMsgAbstract.type && Intrinsics.areEqual(this.msgContent, guildChatMsgAbstract.msgContent)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.type * 31) + this.msgContent.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildChatMsgAbstract(type=" + this.type + ", msgContent=" + ((Object) this.msgContent) + ")";
        }
    }

    f() {
    }

    public static /* synthetic */ GuildChatMsgAbstract b(f fVar, RecentContactInfo recentContactInfo, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        return fVar.a(recentContactInfo, str);
    }

    private final CharSequence c(CharSequence normalContent, MsgAbstract r46) {
        Object first;
        CalendarElement calendarElement;
        if (r46.elements.size() > 0) {
            ArrayList<MsgAbstractElement> arrayList = r46.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "abstract.elements");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            MsgAbstractElement msgAbstractElement = (MsgAbstractElement) first;
            if (msgAbstractElement.elementType == 19 && (calendarElement = msgAbstractElement.calendarElement) != null) {
                return calendarElement.summary + ((Object) normalContent);
            }
            return normalContent;
        }
        return normalContent;
    }

    private final boolean d(RecentContactInfo contactInfo) {
        ArrayList<MsgAbstractElement> arrayList;
        if (ex3.a.h(contactInfo) == 0 && ((arrayList = contactInfo.abstractContent) == null || arrayList.isEmpty())) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GuildChatMsgAbstract a(@NotNull RecentContactInfo contactInfo, @NotNull String selfTinyId) {
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        int i3 = (int) ex3.a.i(contactInfo);
        if (i3 == 1) {
            return new GuildChatMsgAbstract(1, "");
        }
        if (d(contactInfo)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = BaseApplication.getContext().getString(R.string.f158491pr);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ild_welcome_msg_abstract)");
            String format = String.format(string, Arrays.copyOf(new Object[]{ex3.a.g(contactInfo)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return new GuildChatMsgAbstract(2, format);
        }
        MsgAbstract msgAbstract = new MsgAbstract(new Contact(16, ex3.a.b(contactInfo), ex3.a.f(contactInfo)), contactInfo.senderUid, contactInfo.sendMemberName, contactInfo.sendNickName, contactInfo.sendStatus, contactInfo.abstractContent, contactInfo.msgTime, i3, contactInfo.msgSeq);
        CharSequence normalContent = ((IGuildMsgSummaryDecodersApi) QRoute.api(IGuildMsgSummaryDecodersApi.class)).decodeMsg(msgAbstract, selfTinyId);
        f fVar = f217908a;
        Intrinsics.checkNotNullExpressionValue(normalContent, "normalContent");
        CharSequence normalContent2 = fVar.c(normalContent, msgAbstract);
        Intrinsics.checkNotNullExpressionValue(normalContent2, "normalContent");
        return new GuildChatMsgAbstract(1, normalContent2);
    }
}
