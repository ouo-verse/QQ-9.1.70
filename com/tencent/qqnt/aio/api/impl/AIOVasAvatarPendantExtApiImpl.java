package com.tencent.qqnt.aio.api.impl;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOVasAvatarPendantExtApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOVasAvatarPendantExtApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOVasAvatarPendantExtApi;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "appId", "", "isVipNumberLong", "Lcom/tencent/qqnt/avatar/i;", "getOptionVasAvatarData", "Lcom/tencent/qqnt/avatar/j;", "getOptionVasPendantData", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOVasAvatarPendantExtApiImpl implements IAIOVasAvatarPendantExtApi {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/aio/api/impl/AIOVasAvatarPendantExtApiImpl$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "Lkotlin/collections/ArrayList;", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends TypeToken<ArrayList<VipData.VipNumberInfo>> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public AIOVasAvatarPendantExtApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean isVipNumberLong(AIOMsgItem msgItem, int appId) {
        VASAIOPersonalElement vASAIOPersonalElement;
        HashMap<String, String> hashMap;
        int i3;
        String str;
        boolean z16;
        HashMap<Integer, MsgAttributeInfo> hashMap2 = msgItem.getMsgRecord().msgAttrs;
        if (hashMap2 != null && (!hashMap2.isEmpty())) {
            MsgAttributeInfo msgAttributeInfo = hashMap2.get(1);
            Object obj = null;
            if (msgAttributeInfo != null) {
                vASAIOPersonalElement = msgAttributeInfo.vasPersonalInfo;
            } else {
                vASAIOPersonalElement = null;
            }
            if (vASAIOPersonalElement != null) {
                hashMap = vASAIOPersonalElement.extInfo;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                i3 = hashMap.size();
            } else {
                i3 = 0;
            }
            if (i3 <= 0) {
                return false;
            }
            if (hashMap != null) {
                str = hashMap.get("vipNumberInfoNew");
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    Object fromJson = new Gson().fromJson(str, new a().getType());
                    Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(vipNumbe\u2026ipNumberInfo>>() {}.type)");
                    Iterator it = ((ArrayList) fromJson).iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((VipData.VipNumberInfo) next).getAppId() == appId) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            obj = next;
                            break;
                        }
                    }
                    VipData.VipNumberInfo vipNumberInfo = (VipData.VipNumberInfo) obj;
                    if (vipNumberInfo != null) {
                        return vipNumberInfo.isLongNumber();
                    }
                } catch (Exception e16) {
                    QLog.e("AIOVasAvatarPendantExtApiImpl", 1, e16, new Object[0]);
                }
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOVasAvatarPendantExtApi
    @Nullable
    public com.tencent.qqnt.avatar.i getOptionVasAvatarData(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.i) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        com.tencent.qqnt.aio.utils.i iVar = com.tencent.qqnt.aio.utils.i.f352300a;
        if (iVar.c(msgItem) > 0) {
            int c16 = iVar.c(msgItem);
            VASPersonalVipNumberInfo a16 = iVar.a(msgItem);
            boolean isVipNumberLong = isVipNumberLong(msgItem, 23);
            long j3 = msgItem.getMsgRecord().peerUin;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            String sb6 = sb5.toString();
            String str = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
            return new com.tencent.qqnt.avatar.i(c16, 200, a16, isVipNumberLong, 0, 9, sb6, str);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOVasAvatarPendantExtApi
    @Nullable
    public com.tencent.qqnt.avatar.j getOptionVasPendantData(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.j) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        com.tencent.qqnt.aio.utils.aa aaVar = com.tencent.qqnt.aio.utils.aa.f352277a;
        Pair<Long, Integer> a16 = aaVar.a(msgItem);
        if (a16 == null || a16.getFirst().longValue() <= 0) {
            return null;
        }
        long longValue = a16.getFirst().longValue();
        int intValue = a16.getSecond().intValue();
        VASPersonalVipNumberInfo c16 = aaVar.c(msgItem);
        boolean isVipNumberLong = isVipNumberLong(msgItem, 4);
        long j3 = msgItem.getMsgRecord().peerUin;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        String sb6 = sb5.toString();
        String str = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        return new com.tencent.qqnt.avatar.j(longValue, intValue, c16, isVipNumberLong, 8, sb6, str);
    }
}
