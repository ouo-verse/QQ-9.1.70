package com.tencent.mobileqq.guild.live.danmu.item;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.LiveGiftElement;
import com.tencent.qqnt.kernel.nativeinterface.LiveGiftMemberInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/item/b;", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/LiveGiftElement;", "k", "", "b", "", "a", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "l", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull GuildMsgItem msgItem) {
        super(msgItem);
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
    }

    private final LiveGiftElement k() {
        Object obj;
        boolean z16;
        ArrayList<MsgElement> arrayList = getMsgItem().getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).liveGiftElement != null) {
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
        return msgElement.liveGiftElement;
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.item.a
    @NotNull
    public String a() {
        return vq1.b.a(d(), 10) + " \u7ed9 " + vq1.b.a(o(), 10) + " \u9001\u4e86 " + m();
    }

    @Override // com.tencent.mobileqq.guild.live.danmu.item.a
    public int b() {
        return 4;
    }

    public final int l() {
        LiveGiftElement k3 = k();
        if (k3 != null) {
            return k3.materialId;
        }
        return 0;
    }

    @NotNull
    public final String m() {
        String str;
        LiveGiftElement k3 = k();
        if (k3 != null) {
            str = k3.kStrGiftName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final long n() {
        LiveGiftElement k3 = k();
        if (k3 != null) {
            return k3.getKUInt64GiftNum();
        }
        return 0L;
    }

    @NotNull
    public final String o() {
        String str;
        LiveGiftMemberInfo liveGiftMemberInfo;
        LiveGiftElement k3 = k();
        if (k3 != null && (liveGiftMemberInfo = k3.receiverMemberInfo) != null) {
            str = liveGiftMemberInfo.nickName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
