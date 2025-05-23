package com.tencent.biz.pubaccount.api.impl;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PublicAccountAttrs;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
import tencent.im.msg.ExtBufForUI$ExtData;
import tencent.im.msg.ExtBufForUI$PublicAccount;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J0\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/biz/pubaccount/api/impl/PublicAccountMsgExtMrgImpl;", "Lcom/tencent/biz/pubaccount/api/IPublicAccountMsgExtMrg;", "Ltencent/im/msg/ExtBufForUI$PublicAccount;", "paDate", "", "key", "", "default", "getItemValue", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "getPublicAccount", "Ltencent/im/msg/nt_im_msg_body$GeneralFlags;", "generalFlags", "Ltencent/im/msg/nt_im_msg_general_flags_body$ResvAttr;", "getResvAttr", "", "key2Value", "", "setExt", "key2Default", "getExt", "value", "setItemValue", "", "getPubMsgId", "msg", "getBusiIdExtra", "getBytesOacMsgExtend", PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, "getOriginalParam", "<init>", "()V", "Companion", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PublicAccountMsgExtMrgImpl implements IPublicAccountMsgExtMrg {
    public static final String TAG = "PublicAccountMsgExtMrgImpl";

    private final Object getItemValue(ExtBufForUI$PublicAccount paDate, String key, Object r56) {
        switch (key.hashCode()) {
            case -1852562574:
                return !key.equals(IPublicAccountMsgExtMrg.PA_SHOULD_REPORT) ? r56 : Integer.valueOf(paDate.shouldReport.get());
            case -1850513424:
                return !key.equals(IPublicAccountMsgExtMrg.PA_MSG_UNREAD_FLAG) ? r56 : Integer.valueOf(paDate.msgUnreadFlag.get());
            case -1674077017:
                if (!key.equals(IPublicAccountMsgExtMrg.PA_MSG_ID) || Intrinsics.areEqual("", paDate.msgId.get())) {
                    return r56;
                }
                String str = paDate.msgId.get();
                Intrinsics.checkNotNullExpressionValue(str, "paDate.msgId.get()");
                return str;
            case -848859472:
                return !key.equals(IPublicAccountMsgExtMrg.PA_MSG_EXTRA_INFO_TYPE) ? r56 : Integer.valueOf(paDate.msgExtraInfoType.get());
            case -396573017:
                return key.equals(IPublicAccountMsgExtMrg.PA_MSG_HAS_READ) ? Integer.valueOf(paDate.msgHasRead.get()) : r56;
            case 964544756:
                if (!key.equals(IPublicAccountMsgExtMrg.PA_MSG_TEMPLATE_ID) || Intrinsics.areEqual("", paDate.msgTemplateId.get())) {
                    return r56;
                }
                String str2 = paDate.msgTemplateId.get();
                Intrinsics.checkNotNullExpressionValue(str2, "paDate.msgTemplateId.get()");
                return str2;
            case 1899130101:
                return !key.equals(IPublicAccountMsgExtMrg.PA_SEND_FLAG) ? r56 : Integer.valueOf(paDate.sendFlag.get());
            default:
                return r56;
        }
    }

    private final ExtBufForUI$PublicAccount getPublicAccount(MsgRecord msgRecord) {
        ExtBufForUI$ExtData j3 = MsgExtKt.j(msgRecord);
        if (j3 != null) {
            return j3.publicAccount;
        }
        return null;
    }

    private final nt_im_msg_general_flags_body$ResvAttr getResvAttr(nt_im_msg_body$GeneralFlags generalFlags) {
        try {
            nt_im_msg_general_flags_body$ResvAttr nt_im_msg_general_flags_body_resvattr = new nt_im_msg_general_flags_body$ResvAttr();
            nt_im_msg_general_flags_body_resvattr.mergeFrom(generalFlags.bytes_pb_reserve.get().toByteArray());
            return nt_im_msg_general_flags_body_resvattr;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 1, "", e16);
            return null;
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg
    public String getBusiIdExtra(MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return getBytesOacMsgExtend(msg2);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg
    public String getBytesOacMsgExtend(MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.generalFlags == null) {
            QLog.i(TAG, 1, "getBytesOacMsgExtend, generalFlags = null");
            return "";
        }
        nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
        nt_im_msg_body_generalflags.mergeFrom(msg2.generalFlags);
        nt_im_msg_general_flags_body$ResvAttr resvAttr = getResvAttr(nt_im_msg_body_generalflags);
        if (resvAttr == null) {
            return "";
        }
        if (!resvAttr.bytes_oac_msg_extend.has()) {
            QLog.i(TAG, 1, "getBytesOacMsgExtend, bytes_oac_msg_extend.has() = false");
            return "";
        }
        String stringUtf8 = resvAttr.bytes_oac_msg_extend.get().toStringUtf8();
        Intrinsics.checkNotNullExpressionValue(stringUtf8, "attr.bytes_oac_msg_extend.get().toStringUtf8()");
        return stringUtf8;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg
    public Map<String, Object> getExt(MsgRecord msgRecord, Map<String, ? extends Object> key2Default) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(key2Default, "key2Default");
        HashMap hashMap = new HashMap();
        ExtBufForUI$PublicAccount publicAccount = getPublicAccount(msgRecord);
        if (publicAccount == null) {
            return hashMap;
        }
        for (Map.Entry<String, ? extends Object> entry : key2Default.entrySet()) {
            hashMap.put(entry.getKey(), getItemValue(publicAccount, entry.getKey(), entry.getValue()));
        }
        return hashMap;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg
    public String getOriginalParam(String actionData) {
        List split$default;
        boolean startsWith$default;
        List split$default2;
        Intrinsics.checkNotNullParameter(actionData, "actionData");
        if (TextUtils.isEmpty(actionData)) {
            return "";
        }
        try {
            String triggle = new JSONObject(actionData).getString("oac_triggle");
            Intrinsics.checkNotNullExpressionValue(triggle, "triggle");
            split$default = StringsKt__StringsKt.split$default((CharSequence) triggle, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (String str : (String[]) array) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "busi_id", false, 2, null);
                if (startsWith$default) {
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                    Object[] array2 = split$default2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String decodeUrl = URLUtil.decodeUrl(((String[]) array2)[1]);
                    Intrinsics.checkNotNullExpressionValue(decodeUrl, "decodeUrl(field.split(\"=\").toTypedArray()[1])");
                    return decodeUrl;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg
    public long getPubMsgId(MsgRecord msgRecord) {
        PublicAccountAttrs publicAccountAttrs;
        Long l3;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(4);
        if (msgAttributeInfo == null || (publicAccountAttrs = msgAttributeInfo.publicAccountAttrs) == null || (l3 = publicAccountAttrs.pubMsgId) == null) {
            return 0L;
        }
        Intrinsics.checkNotNullExpressionValue(l3, "it.pubMsgId ?: 0L");
        return l3.longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [tencent.im.msg.ExtBufForUI$PublicAccount, T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [tencent.im.msg.ExtBufForUI$PublicAccount, T] */
    @Override // com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg
    public void setExt(MsgRecord msgRecord, Map<String, ? extends Object> key2Value) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(key2Value, "key2Value");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? publicAccount = getPublicAccount(msgRecord);
        objectRef.element = publicAccount;
        if (publicAccount == 0) {
            objectRef.element = new ExtBufForUI$PublicAccount();
        }
        for (Map.Entry<String, ? extends Object> entry : key2Value.entrySet()) {
            setItemValue((ExtBufForUI$PublicAccount) objectRef.element, entry.getKey(), entry.getValue());
        }
        MsgExtKt.c0(msgRecord, new Function1<ExtBufForUI$ExtData, Unit>() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountMsgExtMrgImpl$setExt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ExtBufForUI$ExtData extBufForUI$ExtData) {
                invoke2(extBufForUI$ExtData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ExtBufForUI$ExtData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.publicAccount.set(objectRef.element);
            }
        }, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.api.impl.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                PublicAccountMsgExtMrgImpl.setExt$lambda$0(i3, str);
            }
        });
    }

    public final void setItemValue(ExtBufForUI$PublicAccount paDate, String key, Object value) {
        Intrinsics.checkNotNullParameter(paDate, "paDate");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            return;
        }
        switch (key.hashCode()) {
            case -1852562574:
                if (key.equals(IPublicAccountMsgExtMrg.PA_SHOULD_REPORT)) {
                    paDate.shouldReport.set(((Integer) value).intValue());
                    return;
                }
                return;
            case -1850513424:
                if (key.equals(IPublicAccountMsgExtMrg.PA_MSG_UNREAD_FLAG)) {
                    paDate.msgUnreadFlag.set(((Integer) value).intValue());
                    return;
                }
                return;
            case -1674077017:
                if (key.equals(IPublicAccountMsgExtMrg.PA_MSG_ID)) {
                    paDate.msgId.set((String) value);
                    return;
                }
                return;
            case -848859472:
                if (key.equals(IPublicAccountMsgExtMrg.PA_MSG_EXTRA_INFO_TYPE)) {
                    paDate.msgExtraInfoType.set(((Integer) value).intValue());
                    return;
                }
                return;
            case -396573017:
                if (key.equals(IPublicAccountMsgExtMrg.PA_MSG_HAS_READ)) {
                    paDate.msgHasRead.set(((Integer) value).intValue());
                    return;
                }
                return;
            case 964544756:
                if (key.equals(IPublicAccountMsgExtMrg.PA_MSG_TEMPLATE_ID)) {
                    paDate.msgTemplateId.set((String) value);
                    return;
                }
                return;
            case 1899130101:
                if (key.equals(IPublicAccountMsgExtMrg.PA_SEND_FLAG)) {
                    paDate.sendFlag.set(((Integer) value).intValue());
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setExt$lambda$0(int i3, String str) {
        if (i3 != 0) {
            QLog.e(TAG, 1, "updateExt res=" + i3 + ", errMsg=" + str);
        }
    }
}
