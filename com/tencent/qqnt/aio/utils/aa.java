package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgAvatarPendant;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/utils/aa;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lkotlin/Pair;", "", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "b", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "c", "msgRecord", "d", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final aa f352277a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f352277a = new aa();
        }
    }

    aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Pair<Long, Integer> a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return b(msgItem.getMsgRecord());
    }

    @Nullable
    public final Pair<Long, Integer> b(@NotNull MsgRecord record) {
        HashMap<Integer, MsgAttributeInfo> hashMap;
        VASMsgAvatarPendant vASMsgAvatarPendant;
        VASMsgElement vASMsgElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) record);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        if (!SimpleUIUtil.getSimpleUISwitch() && (hashMap = record.msgAttrs) != null && (!hashMap.isEmpty())) {
            MsgAttributeInfo msgAttributeInfo = hashMap.get(1);
            if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null) {
                vASMsgAvatarPendant = vASMsgElement.avatarPendantInfo;
            } else {
                vASMsgAvatarPendant = null;
            }
            if (vASMsgAvatarPendant != null) {
                return new Pair<>(vASMsgAvatarPendant.pendantId, vASMsgAvatarPendant.pendantDiyInfoId);
            }
        }
        return null;
    }

    @Nullable
    public final VASPersonalVipNumberInfo c(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return d(msgItem.getMsgRecord());
    }

    @Nullable
    public final VASPersonalVipNumberInfo d(@NotNull MsgRecord msgRecord) {
        VASAIOPersonalElement vASAIOPersonalElement;
        ArrayList<VASPersonalVipNumberInfo> vipNumbers;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        HashMap<Integer, MsgAttributeInfo> hashMap = msgRecord.msgAttrs;
        Object obj = null;
        if (hashMap == null || !(!hashMap.isEmpty())) {
            return null;
        }
        MsgAttributeInfo msgAttributeInfo = hashMap.get(1);
        if (msgAttributeInfo != null) {
            vASAIOPersonalElement = msgAttributeInfo.vasPersonalInfo;
        } else {
            vASAIOPersonalElement = null;
        }
        if (vASAIOPersonalElement == null || (vipNumbers = vASAIOPersonalElement.vipNumbers) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(vipNumbers, "vipNumbers");
        Iterator<T> it = vipNumbers.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Integer num = ((VASPersonalVipNumberInfo) next).appId;
            if (num != null && num.intValue() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (VASPersonalVipNumberInfo) obj;
    }
}
