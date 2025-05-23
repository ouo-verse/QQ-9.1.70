package com.tencent.mobileqq.nt.msgpush.troop;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.nt.msgpush.factory.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$GroupBusinessData;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_body$ExtraInfo;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tencent.im.msg.nt_im_msg_body$PubGroup;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;
import tencent.im.msg.nt_msg_common$Group;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/a;", "Lcom/tencent/mobileqq/nt/msgpush/factory/d;", "Lcom/tencent/qqnt/kernel/frequencycontrol/pb/FrequencyControlField$GroupBusinessData;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Ltencent/im/msg/nt_im_msg_body$GeneralFlags;", "c", "generalFlags", "Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "g", "Ltencent/im/msg/nt_im_msg_body$ExtraInfo;", "b", "Ltencent/im/msg/nt_im_msg_body$PubGroup;", "f", "Ltencent/im/msg/nt_msg_common$Group;", "d", "", "e", "", "byteArray", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nt.msgpush.troop.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59425);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final nt_im_msg_body$ExtraInfo b(FrequencyControlField$GroupBusinessData businessData) {
        if (businessData.elem_extra_info.has()) {
            return new nt_im_msg_body$ExtraInfo().mergeFrom(businessData.elem_extra_info.get().toByteArray());
        }
        return null;
    }

    private final nt_im_msg_body$GeneralFlags c(FrequencyControlField$GroupBusinessData businessData) {
        if (businessData.elem_general_flags.has()) {
            return new nt_im_msg_body$GeneralFlags().mergeFrom(businessData.elem_general_flags.get().toByteArray());
        }
        return null;
    }

    private final nt_msg_common$Group d(FrequencyControlField$GroupBusinessData businessData) {
        if (businessData.msg_head_group_info.has()) {
            return new nt_msg_common$Group().mergeFrom(businessData.msg_head_group_info.get().toByteArray());
        }
        return null;
    }

    private final boolean e(FrequencyControlField$GroupBusinessData businessData) {
        if (businessData.is_online_msg.has() && businessData.is_online_msg.get()) {
            return true;
        }
        return false;
    }

    private final nt_im_msg_body$PubGroup f(FrequencyControlField$GroupBusinessData businessData) {
        if (businessData.elem_pub_group.has()) {
            return new nt_im_msg_body$PubGroup().mergeFrom(businessData.elem_pub_group.get().toByteArray());
        }
        return null;
    }

    private final nt_im_msg_general_flags_body$ResvAttr g(nt_im_msg_body$GeneralFlags generalFlags) {
        if (generalFlags != null && generalFlags.has() && generalFlags.bytes_pb_reserve.has()) {
            return new nt_im_msg_general_flags_body$ResvAttr().mergeFrom(generalFlags.bytes_pb_reserve.get().toByteArray());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.d
    @Nullable
    public com.tencent.mobileqq.nt.msgpush.factory.a a(@NotNull byte[] byteArray) {
        com.tencent.mobileqq.nt.msgpush.factory.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.nt.msgpush.factory.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) byteArray);
        }
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        FrequencyControlField$GroupBusinessData frequencyControlField$GroupBusinessData = new FrequencyControlField$GroupBusinessData();
        try {
            frequencyControlField$GroupBusinessData.mergeFrom(byteArray);
            nt_im_msg_body$GeneralFlags c16 = c(frequencyControlField$GroupBusinessData);
            nt_im_msg_general_flags_body$ResvAttr g16 = g(c16);
            nt_im_msg_body$ExtraInfo b16 = b(frequencyControlField$GroupBusinessData);
            nt_im_msg_body$PubGroup f16 = f(frequencyControlField$GroupBusinessData);
            nt_msg_common$Group d16 = d(frequencyControlField$GroupBusinessData);
            boolean e16 = e(frequencyControlField$GroupBusinessData);
            long j3 = frequencyControlField$GroupBusinessData.peer_uin.get();
            String str = frequencyControlField$GroupBusinessData.peer_uid.get();
            long j16 = frequencyControlField$GroupBusinessData.sender_uin.get();
            String str2 = frequencyControlField$GroupBusinessData.sender_uid.get();
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(j3), str);
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(String.valueOf(j16), str2);
            long j17 = frequencyControlField$GroupBusinessData.msg_id.get();
            long j18 = frequencyControlField$GroupBusinessData.msg_seq.get();
            long j19 = frequencyControlField$GroupBusinessData.msg_time.get();
            String valueOf = String.valueOf(frequencyControlField$GroupBusinessData.peer_uin.get());
            String str3 = frequencyControlField$GroupBusinessData.peer_uid.get();
            Intrinsics.checkNotNullExpressionValue(str3, "businessData.peer_uid.get()");
            String valueOf2 = String.valueOf(frequencyControlField$GroupBusinessData.sender_uin.get());
            String str4 = frequencyControlField$GroupBusinessData.sender_uid.get();
            Intrinsics.checkNotNullExpressionValue(str4, "businessData.sender_uid.get()");
            com.tencent.mobileqq.nt.msgpush.troop.processor.a aVar2 = new com.tencent.mobileqq.nt.msgpush.troop.processor.a(j17, j18, j19, valueOf, str3, valueOf2, str4, frequencyControlField$GroupBusinessData, c16, g16, b16, f16, d16, e16);
            aVar = null;
            try {
                return new com.tencent.mobileqq.nt.msgpush.factory.a(aVar2, null, 2, null);
            } catch (Exception e17) {
                e = e17;
                QLog.e("TroopBusinessDataConvertor", 1, "distributeData error! e = " + e.getMessage());
                return aVar;
            }
        } catch (Exception e18) {
            e = e18;
            aVar = null;
        }
    }
}
