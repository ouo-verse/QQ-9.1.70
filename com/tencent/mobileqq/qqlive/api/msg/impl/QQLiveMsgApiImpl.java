package com.tencent.mobileqq.qqlive.api.msg.impl;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.msg.IQQLiveMsgApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/msg/impl/QQLiveMsgApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/msg/IQQLiveMsgApi;", "()V", "getAdIdFromMsgRecord", "", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveMsgApiImpl implements IQQLiveMsgApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String AD_ID_KEY = "ad_id=";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String MESSAGE_EXTRA_OAC_TRIGGLE_KEY = "oac_triggle";

    @NotNull
    private static final String TAG = "QQLiveMsgApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/msg/impl/QQLiveMsgApiImpl$Companion;", "", "()V", "AD_ID_KEY", "", "MESSAGE_EXTRA_OAC_TRIGGLE_KEY", "TAG", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveMsgApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[Catch: Exception -> 0x00b0, TryCatch #0 {Exception -> 0x00b0, blocks: (B:10:0x001a, B:12:0x0043, B:18:0x0050, B:21:0x0063, B:23:0x0089, B:27:0x0094), top: B:9:0x001a }] */
    @Override // com.tencent.mobileqq.qqlive.api.msg.IQQLiveMsgApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getAdIdFromMsgRecord(@NotNull MsgRecord msgRecord) {
        String stringUtf8;
        boolean z16;
        boolean contains$default;
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        try {
            nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
            nt_im_msg_body_generalflags.mergeFrom(msgRecord.generalFlags);
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.mergeFrom(nt_im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
            stringUtf8 = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAdIdFromMsgRecord exception:", e16);
        }
        if (stringUtf8 != null && stringUtf8.length() != 0) {
            z16 = false;
            if (!z16) {
                return null;
            }
            String oacValue = new JSONObject(stringUtf8).optString(MESSAGE_EXTRA_OAC_TRIGGLE_KEY);
            if (TextUtils.isEmpty(oacValue)) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(oacValue, "oacValue");
            Object[] array = new Regex(ContainerUtils.FIELD_DELIMITER).split(oacValue, 0).toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (String str : (String[]) array) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) AD_ID_KEY, false, 2, (Object) null);
                if (contains$default) {
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, AD_ID_KEY, 0, false, 6, (Object) null);
                    String substring = str.substring(indexOf$default + 6);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    return substring;
                }
            }
            return null;
        }
        z16 = true;
        if (!z16) {
        }
    }
}
