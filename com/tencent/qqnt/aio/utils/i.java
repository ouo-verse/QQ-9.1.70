package com.tencent.qqnt.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/utils/i;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "d", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalVipNumberInfo;", "a", "b", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f352300a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f352300a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final VASPersonalVipNumberInfo a(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return b(msgItem.getMsgRecord());
    }

    @Nullable
    public final VASPersonalVipNumberInfo b(@NotNull MsgRecord record) {
        VASAIOPersonalElement vASAIOPersonalElement;
        ArrayList<VASPersonalVipNumberInfo> vipNumbers;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (VASPersonalVipNumberInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) record);
        }
        Intrinsics.checkNotNullParameter(record, "record");
        HashMap<Integer, MsgAttributeInfo> hashMap = record.msgAttrs;
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
            if (num != null && num.intValue() == 23) {
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

    public final int c(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return d(msgItem.getMsgRecord());
    }

    public final int d(@NotNull MsgRecord record) {
        Integer num;
        VASMsgElement vASMsgElement;
        VASMsgAvatarPendant vASMsgAvatarPendant;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) record)).intValue();
        }
        Intrinsics.checkNotNullParameter(record, "record");
        HashMap<Integer, MsgAttributeInfo> hashMap = record.msgAttrs;
        if (hashMap == null || !(!hashMap.isEmpty())) {
            return 0;
        }
        MsgAttributeInfo msgAttributeInfo = hashMap.get(1);
        if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgAvatarPendant = vASMsgElement.avatarPendantInfo) != null) {
            num = vASMsgAvatarPendant.avatarId;
        } else {
            num = null;
        }
        if (num == null) {
            return 0;
        }
        Intrinsics.checkNotNullExpressionValue(num, "map[MsgConstant.KATTRIBU\u2026endantInfo?.avatarId ?: 0");
        return num.intValue();
    }
}
