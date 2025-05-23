package com.tencent.guild.api.gift;

import android.text.TextUtils;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASGiftCoinType;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.VASGiftSpendCoinItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/api/gift/c;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "", "a", "msgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/TextGiftElement;", "c", "giftElement", "b", "selfTinyId", "", "d", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f112540a = new c();

    c() {
    }

    @Nullable
    public final String a(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        QQVasUpdateBusiness businessInstance = QQVasUpdateBusinessUtil.getBusinessInstance(com.tencent.mobileqq.qqgift.updatasystem.c.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "getBusinessInstance(VasG\u2026urceBusiness::class.java)");
        QQGiftResourceBusiness qQGiftResourceBusiness = (QQGiftResourceBusiness) businessInstance;
        TextGiftElement c16 = c(guildMsgItem);
        if (c16 == null) {
            return null;
        }
        return qQGiftResourceBusiness.getSavePath(qQGiftResourceBusiness.f((int) c16.tianquanId, 3));
    }

    @NotNull
    public final String b(@Nullable TextGiftElement giftElement) {
        if (giftElement == null) {
            return "";
        }
        ArrayList<VASGiftSpendCoinItem> arrayList = giftElement.spendCoins;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<VASGiftSpendCoinItem> it = arrayList.iterator();
            long j3 = 0;
            long j16 = 0;
            while (it.hasNext()) {
                VASGiftSpendCoinItem next = it.next();
                VASGiftCoinType vASGiftCoinType = VASGiftCoinType.VASGIFTCOINTYPECOIN;
                if (vASGiftCoinType.ordinal() == next.coinType) {
                    j3 += next.amt;
                } else if (vASGiftCoinType.ordinal() == next.coinType) {
                    j16 += next.amt;
                }
            }
            long j17 = j3 + j16;
            if (j17 == j3) {
                return j17 + HardCodeUtil.qqStr(R.string.f1381208p);
            }
            if (j17 == j16) {
                return j17 + HardCodeUtil.qqStr(R.string.f1381308q);
            }
            return j17 + HardCodeUtil.qqStr(R.string.f1381108o);
        }
        return giftElement.price + HardCodeUtil.qqStr(R.string.f1381208p);
    }

    @Nullable
    public final TextGiftElement c(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().elements == null || msgItem.getMsgRecord().elements.isEmpty()) {
            return null;
        }
        Iterator<MsgElement> it = msgItem.getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            TextGiftElement textGiftElement = it.next().textGiftElement;
            if (textGiftElement != null) {
                return textGiftElement;
            }
        }
        return null;
    }

    public final boolean d(@NotNull GuildMsgItem guildMsgItem, @NotNull String selfTinyId) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (Intrinsics.areEqual("false", guildMsgItem.getExtInfoFromExtStr("mNeedShowGift", "true")) || TextUtils.isEmpty(selfTinyId)) {
            return false;
        }
        guildMsgItem.saveExtInfoToExtStr("mNeedShowGift", "false");
        TextGiftElement c16 = c(guildMsgItem);
        if (c16 == null || c16.level < GuildGiftView.INSTANCE.a()) {
            return false;
        }
        boolean areEqual = Intrinsics.areEqual(selfTinyId, String.valueOf(c16.senderUin));
        boolean areEqual2 = Intrinsics.areEqual(selfTinyId, String.valueOf(c16.receiverUin));
        if (!areEqual && !areEqual2) {
            return false;
        }
        return true;
    }
}
