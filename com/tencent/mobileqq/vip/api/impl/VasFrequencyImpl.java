package com.tencent.mobileqq.vip.api.impl;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vip.api.IVasFrequency;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceBody;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItemListBody;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J(\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u001b\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VasFrequencyImpl;", "Lcom/tencent/mobileqq/vip/api/IVasFrequency;", "", "itemId", "", "startPreDownload", "", "cmd", "", "pbBuffer", "requestDownload", "Lcom/tencent/mobileqq/vip/api/i;", "business", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "requestResourceForRecent", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "requestResourceForAIO", "", "isAio", "", "sendUin", "peerUid", "requestDataChangeForUid", "chatType", "requestDataChangeAll", "dataChangeSwitch", "Z", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasFrequencyImpl implements IVasFrequency {
    static IPatchRedirector $redirector_;
    private final boolean dataChangeSwitch;

    public VasFrequencyImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.dataChangeSwitch = VasNtToggle.VAS_FREQUENCY_DATA_CHANGE_SWITCH.isEnable(false);
        }
    }

    private final void requestDownload(String itemId, int cmd, byte[] pbBuffer) {
        startPreDownload(itemId);
        IQQNTWrapperSession k3 = com.tencent.qqnt.msg.f.k();
        if (k3 != null) {
            k3.onDispatchPush(cmd, pbBuffer);
        }
    }

    private final void startPreDownload(String itemId) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) itemId, new String[]{"!"}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 2) {
            QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(Long.parseLong(strArr[0])));
            Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026.getBusinessInstance(bid)");
            try {
                businessInstance.startDownload(Integer.parseInt(strArr[1]));
            } catch (Exception unused) {
                businessInstance.startDownload(strArr[1]);
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVasFrequency
    public void requestDataChangeAll(boolean isAio, int chatType, @NotNull com.tencent.mobileqq.vip.api.i business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(isAio), Integer.valueOf(chatType), business);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("requestDataChangeAll " + business);
        }
        int i3 = 221802;
        if (!this.dataChangeSwitch) {
            IQQNTWrapperSession k3 = com.tencent.qqnt.msg.f.k();
            if (k3 != null) {
                FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody = new FrequencyControlField$ResourceItemListBody();
                PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField = frequencyControlField$ResourceItemListBody.item_list;
                FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
                frequencyControlField$ResourceItem.peer_uid.set("");
                frequencyControlField$ResourceItem.chat_type.set(chatType);
                PBUInt32Field pBUInt32Field = frequencyControlField$ResourceItem.scene_id;
                if (!isAio) {
                    i3 = 221801;
                }
                pBUInt32Field.set(i3);
                frequencyControlField$ResourceItem.update_type.set(221901);
                frequencyControlField$ResourceItem.need_download.set(false);
                PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField2 = frequencyControlField$ResourceItem.resource_body_list;
                FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = new FrequencyControlField$ResourceBody();
                frequencyControlField$ResourceBody.business_id.set(business.a());
                frequencyControlField$ResourceBody.sender_uid.set("");
                frequencyControlField$ResourceBody.sender_uin.set(0L);
                frequencyControlField$ResourceBody.item_id.set(business.b());
                frequencyControlField$ResourceBody.msg_id.set(0L);
                frequencyControlField$ResourceBody.update_scope_type.set(business.c());
                pBRepeatMessageField2.add(frequencyControlField$ResourceBody);
                pBRepeatMessageField.add(frequencyControlField$ResourceItem);
                Unit unit = Unit.INSTANCE;
                k3.onDispatchPush(221010, frequencyControlField$ResourceItemListBody.toByteArray());
                return;
            }
            return;
        }
        String b16 = business.b();
        FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody2 = new FrequencyControlField$ResourceItemListBody();
        PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField3 = frequencyControlField$ResourceItemListBody2.item_list;
        FrequencyControlField$ResourceItem frequencyControlField$ResourceItem2 = new FrequencyControlField$ResourceItem();
        frequencyControlField$ResourceItem2.peer_uid.set("");
        frequencyControlField$ResourceItem2.chat_type.set(chatType);
        PBUInt32Field pBUInt32Field2 = frequencyControlField$ResourceItem2.scene_id;
        if (!isAio) {
            i3 = 221801;
        }
        pBUInt32Field2.set(i3);
        frequencyControlField$ResourceItem2.update_type.set(221901);
        frequencyControlField$ResourceItem2.need_download.set(false);
        PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField4 = frequencyControlField$ResourceItem2.resource_body_list;
        FrequencyControlField$ResourceBody frequencyControlField$ResourceBody2 = new FrequencyControlField$ResourceBody();
        frequencyControlField$ResourceBody2.business_id.set(business.a());
        frequencyControlField$ResourceBody2.sender_uid.set("");
        frequencyControlField$ResourceBody2.sender_uin.set(0L);
        frequencyControlField$ResourceBody2.item_id.set(business.b());
        frequencyControlField$ResourceBody2.msg_id.set(0L);
        frequencyControlField$ResourceBody2.update_scope_type.set(business.c());
        pBRepeatMessageField4.add(frequencyControlField$ResourceBody2);
        pBRepeatMessageField3.add(frequencyControlField$ResourceItem2);
        Unit unit2 = Unit.INSTANCE;
        byte[] byteArray = frequencyControlField$ResourceItemListBody2.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ResourceItemListBody().a\u2026          }.toByteArray()");
        requestDownload(b16, 221010, byteArray);
    }

    @Override // com.tencent.mobileqq.vip.api.IVasFrequency
    public void requestDataChangeForUid(boolean isAio, long sendUin, @NotNull String peerUid, @NotNull com.tencent.mobileqq.vip.api.i business) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isAio), Long.valueOf(sendUin), peerUid, business);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(business, "business");
        if (QLog.isDebugVersion()) {
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("requestDataChange " + business);
        }
        if (!this.dataChangeSwitch) {
            IQQNTWrapperSession k3 = com.tencent.qqnt.msg.f.k();
            if (k3 != null) {
                FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody = new FrequencyControlField$ResourceItemListBody();
                PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField = frequencyControlField$ResourceItemListBody.item_list;
                FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
                frequencyControlField$ResourceItem.peer_uid.set(peerUid);
                frequencyControlField$ResourceItem.chat_type.set(0);
                PBUInt32Field pBUInt32Field = frequencyControlField$ResourceItem.scene_id;
                if (isAio) {
                    i16 = 221802;
                } else {
                    i16 = 221801;
                }
                pBUInt32Field.set(i16);
                frequencyControlField$ResourceItem.update_type.set(221901);
                frequencyControlField$ResourceItem.need_download.set(false);
                PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField2 = frequencyControlField$ResourceItem.resource_body_list;
                FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = new FrequencyControlField$ResourceBody();
                frequencyControlField$ResourceBody.business_id.set(business.a());
                frequencyControlField$ResourceBody.sender_uid.set("");
                frequencyControlField$ResourceBody.sender_uin.set(sendUin);
                frequencyControlField$ResourceBody.item_id.set(business.b());
                frequencyControlField$ResourceBody.msg_id.set(0L);
                frequencyControlField$ResourceBody.update_scope_type.set(business.c());
                pBRepeatMessageField2.add(frequencyControlField$ResourceBody);
                pBRepeatMessageField.add(frequencyControlField$ResourceItem);
                Unit unit = Unit.INSTANCE;
                k3.onDispatchPush(221010, frequencyControlField$ResourceItemListBody.toByteArray());
                return;
            }
            return;
        }
        String b16 = business.b();
        FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody2 = new FrequencyControlField$ResourceItemListBody();
        PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField3 = frequencyControlField$ResourceItemListBody2.item_list;
        FrequencyControlField$ResourceItem frequencyControlField$ResourceItem2 = new FrequencyControlField$ResourceItem();
        frequencyControlField$ResourceItem2.peer_uid.set(peerUid);
        frequencyControlField$ResourceItem2.chat_type.set(0);
        PBUInt32Field pBUInt32Field2 = frequencyControlField$ResourceItem2.scene_id;
        if (isAio) {
            i3 = 221802;
        } else {
            i3 = 221801;
        }
        pBUInt32Field2.set(i3);
        frequencyControlField$ResourceItem2.update_type.set(221901);
        frequencyControlField$ResourceItem2.need_download.set(false);
        PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField4 = frequencyControlField$ResourceItem2.resource_body_list;
        FrequencyControlField$ResourceBody frequencyControlField$ResourceBody2 = new FrequencyControlField$ResourceBody();
        frequencyControlField$ResourceBody2.business_id.set(business.a());
        frequencyControlField$ResourceBody2.sender_uid.set("");
        frequencyControlField$ResourceBody2.sender_uin.set(sendUin);
        frequencyControlField$ResourceBody2.item_id.set(business.b());
        frequencyControlField$ResourceBody2.msg_id.set(0L);
        frequencyControlField$ResourceBody2.update_scope_type.set(business.c());
        pBRepeatMessageField4.add(frequencyControlField$ResourceBody2);
        pBRepeatMessageField3.add(frequencyControlField$ResourceItem2);
        Unit unit2 = Unit.INSTANCE;
        byte[] byteArray = frequencyControlField$ResourceItemListBody2.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ResourceItemListBody().a\u2026)\n        }.toByteArray()");
        requestDownload(b16, 221010, byteArray);
    }

    @Override // com.tencent.mobileqq.vip.api.IVasFrequency
    public void requestResourceForAIO(@NotNull com.tencent.mobileqq.vip.api.i business, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) business, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("requestResourceForAIO " + business);
        }
        String b16 = business.b();
        FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody = new FrequencyControlField$ResourceItemListBody();
        PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField = frequencyControlField$ResourceItemListBody.item_list;
        FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
        frequencyControlField$ResourceItem.chat_type.set(msgItem.getMsgRecord().chatType);
        frequencyControlField$ResourceItem.peer_uid.set(msgItem.getMsgRecord().peerUid);
        frequencyControlField$ResourceItem.scene_id.set(221802);
        frequencyControlField$ResourceItem.update_type.set(221902);
        PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField2 = frequencyControlField$ResourceItem.resource_body_list;
        FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = new FrequencyControlField$ResourceBody();
        frequencyControlField$ResourceBody.business_id.set(business.a());
        frequencyControlField$ResourceBody.item_id.set(business.b());
        frequencyControlField$ResourceBody.sender_uin.set(msgItem.getMsgRecord().senderUin);
        frequencyControlField$ResourceBody.sender_uid.set(msgItem.getMsgRecord().senderUid);
        frequencyControlField$ResourceBody.msg_id.set(msgItem.getMsgRecord().msgId);
        frequencyControlField$ResourceBody.update_scope_type.set(business.c());
        pBRepeatMessageField2.add(frequencyControlField$ResourceBody);
        pBRepeatMessageField.add(frequencyControlField$ResourceItem);
        Unit unit = Unit.INSTANCE;
        byte[] byteArray = frequencyControlField$ResourceItemListBody.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ResourceItemListBody().a\u2026          }.toByteArray()");
        requestDownload(b16, 221001, byteArray);
    }

    @Override // com.tencent.mobileqq.vip.api.IVasFrequency
    public void requestResourceForRecent(@NotNull com.tencent.mobileqq.vip.api.i business, @NotNull RecentContactInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) business, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(info, "info");
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("requestResourceForRecent " + business);
        }
        String b16 = business.b();
        FrequencyControlField$ResourceItemListBody frequencyControlField$ResourceItemListBody = new FrequencyControlField$ResourceItemListBody();
        PBRepeatMessageField<FrequencyControlField$ResourceItem> pBRepeatMessageField = frequencyControlField$ResourceItemListBody.item_list;
        FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
        frequencyControlField$ResourceItem.chat_type.set(info.chatType);
        frequencyControlField$ResourceItem.peer_uid.set(info.peerUid);
        frequencyControlField$ResourceItem.scene_id.set(221801);
        frequencyControlField$ResourceItem.update_type.set(221902);
        PBRepeatMessageField<FrequencyControlField$ResourceBody> pBRepeatMessageField2 = frequencyControlField$ResourceItem.resource_body_list;
        FrequencyControlField$ResourceBody frequencyControlField$ResourceBody = new FrequencyControlField$ResourceBody();
        frequencyControlField$ResourceBody.business_id.set(business.a());
        frequencyControlField$ResourceBody.item_id.set(business.b());
        frequencyControlField$ResourceBody.sender_uin.set(info.senderUin);
        frequencyControlField$ResourceBody.sender_uid.set(info.senderUid);
        frequencyControlField$ResourceBody.msg_id.set(info.msgId);
        frequencyControlField$ResourceBody.update_scope_type.set(business.c());
        pBRepeatMessageField2.add(frequencyControlField$ResourceBody);
        pBRepeatMessageField.add(frequencyControlField$ResourceItem);
        Unit unit = Unit.INSTANCE;
        byte[] byteArray = frequencyControlField$ResourceItemListBody.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ResourceItemListBody().a\u2026)\n        }.toByteArray()");
        requestDownload(b16, 221001, byteArray);
    }
}
