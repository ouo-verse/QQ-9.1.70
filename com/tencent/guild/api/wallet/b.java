package com.tencent.guild.api.wallet;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vk2.QWalletHbModel;
import vk2.QWalletMsgModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u001a\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Lvk2/d;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", "walletElement", "Lvk2/c;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "transferElem", "Lvk2/b;", "a", "Lcom/tencent/mobileqq/data/QQWalletAioBodyReserve;", "b", "nt-guild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {
    @NotNull
    public static final vk2.b a(@NotNull WalletAio transferElem) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(transferElem, "transferElem");
        vk2.b bVar = new vk2.b();
        int i3 = transferElem.background;
        bVar.f441763a = i3;
        bVar.f441764b = transferElem.icon;
        bVar.f441765c = transferElem.title;
        bVar.f441766d = transferElem.subTitle;
        bVar.f441767e = transferElem.content;
        String str = transferElem.notice;
        bVar.f441770h = str;
        String str2 = "";
        if (bVar.f441768f == null) {
            bVar.f441768f = "";
        }
        if (bVar.f441769g == null) {
            bVar.f441769g = "";
        }
        if (str == null) {
            bVar.f441770h = "";
        }
        bVar.f441763a = i3 | (-16777216);
        bVar.f441771i = transferElem.titleColor | (-16777216);
        bVar.f441772j = transferElem.subtitleColor | (-16777216);
        String str3 = transferElem.actionsPriority;
        boolean z18 = false;
        if (str3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str3 = "";
        }
        bVar.f441773k = str3;
        String str4 = transferElem.nativeAndroid;
        if (str4.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            str2 = str4;
        }
        bVar.f441775m = str2;
        bVar.f441782t = 12000;
        byte[] bArr = transferElem.pbReserve;
        Intrinsics.checkNotNullExpressionValue(bArr, "transferElem.pbReserve");
        if (bArr.length == 0) {
            z18 = true;
        }
        if (!z18) {
            bVar.b(transferElem.pbReserve);
        }
        return bVar;
    }

    @NotNull
    public static final QQWalletAioBodyReserve b(@NotNull WalletElement walletElement) {
        Intrinsics.checkNotNullParameter(walletElement, "walletElement");
        QQWalletAioBodyReserve qQWalletAioBodyReserve = new QQWalletAioBodyReserve();
        qQWalletAioBodyReserve.init(walletElement.pbReserve);
        return qQWalletAioBodyReserve;
    }

    @NotNull
    public static final QWalletHbModel c(@NotNull WalletElement walletElement) {
        Intrinsics.checkNotNullParameter(walletElement, "walletElement");
        WalletAio walletAio = walletElement.receiver;
        Intrinsics.checkNotNullExpressionValue(walletAio, "walletElement.receiver");
        vk2.b a16 = a(walletAio);
        QQWalletAioBodyReserve b16 = b(walletElement);
        int i3 = walletElement.channelId;
        int i16 = walletElement.templateId;
        int i17 = walletElement.resend;
        int i18 = walletElement.redType;
        String str = walletElement.billNo;
        String str2 = walletElement.authkey;
        ArrayList<Long> arrayList = walletElement.grapUin;
        Intrinsics.checkNotNullExpressionValue(arrayList, "walletElement.grapUin");
        return new QWalletHbModel(a16, b16, i3, i16, i17, i18, str, str2, arrayList, walletElement.redChannel);
    }

    @NotNull
    public static final QWalletMsgModel d(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        WalletElement walletElement = guildMsgItem.getMsgRecord().elements.get(0).walletElement;
        Intrinsics.checkNotNullExpressionValue(walletElement, "guildMsgItem.msgRecord.elements[0].walletElement");
        return new QWalletMsgModel(c(walletElement), walletElement.msgType, guildMsgItem.getMsgRecord().senderUid, 0, 8, null);
    }
}
