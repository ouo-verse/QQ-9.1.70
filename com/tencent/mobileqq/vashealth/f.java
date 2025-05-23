package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.nt_im_msg_body$GeneralFlags;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\"\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0013\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vashealth/f;", "", "Lg43/c;", "e", "", "uin", "", "i", tl.h.F, "", "source", "msgJumpUrl", "hasUnreadMsg", "f", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "srcId", "", "k", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "g", "j", "d", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f312270a = new f();

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("HealthJumpHelper", 1, "[handleBlockResp] setMsgRead: result=" + i3 + ", errMsg=" + msg2);
    }

    private final g43.c e() {
        g43.c cVar = (g43.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100502");
        if (cVar == null) {
            return new g43.c(false, null, null, null, null, 31, null);
        }
        return cVar;
    }

    public final void b() {
        try {
            ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(103, "u_m9X3fOJ4pgkey0OEgpnXHQ", ""), new IOperateCallback() { // from class: com.tencent.mobileqq.vashealth.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    f.c(i3, str);
                }
            });
        } catch (Throwable th5) {
            QLog.d("HealthJumpHelper", 1, th5, new Object[0]);
        }
    }

    @NotNull
    public final String d(@Nullable MsgRecord msg2) {
        List<String> split$default;
        boolean startsWith$default;
        List split$default2;
        if (msg2 == null) {
            return "";
        }
        String bytesOacMsgExtend = ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBytesOacMsgExtend(msg2);
        if (TextUtils.isEmpty(bytesOacMsgExtend)) {
            return "";
        }
        try {
            String triggleStr = new JSONObject(bytesOacMsgExtend).optString("oac_triggle");
            Intrinsics.checkNotNullExpressionValue(triggleStr, "triggleStr");
            split$default = StringsKt__StringsKt.split$default((CharSequence) triggleStr, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            for (String str : split$default) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "ad_id", false, 2, null);
                if (startsWith$default) {
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                    return (String) split$default2.get(1);
                }
            }
        } catch (Exception e16) {
            QLog.e("HealthJumpHelper", 1, "getAdIdFromMsgExtString error..." + e16);
        }
        return "";
    }

    @Nullable
    public final String f(int source, @Nullable String msgJumpUrl, boolean hasUnreadMsg) {
        String mainPageUrl = e().getMainPageUrl();
        if (QLog.isDebugVersion()) {
            QLog.d("HealthJumpHelper", 1, "[redirectAIOToMainPage] healthMainPageJumpUrl: " + mainPageUrl + ", msgJumpUrl: " + msgJumpUrl);
        }
        if (!TextUtils.isEmpty(msgJumpUrl) && source == 161 && hasUnreadMsg) {
            return msgJumpUrl;
        }
        switch (source) {
            case 160:
                return "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1&src_id=805";
            case 161:
                return e().getMainPageUrlContact();
            case 162:
            case 163:
            default:
                return mainPageUrl;
            case 164:
                return e().getMainPageUrlSearch();
            case 165:
                return e().getMainPageUrlContact();
            case 166:
                return "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1&src_id=809";
        }
    }

    @Nullable
    public final String g(@Nullable MsgRecord msg2) {
        String str;
        if (msg2 == null) {
            return null;
        }
        try {
            nt_im_msg_body$GeneralFlags nt_im_msg_body_generalflags = new nt_im_msg_body$GeneralFlags();
            nt_im_msg_body_generalflags.mergeFrom(msg2.generalFlags);
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            generalflags_resvattr.mergeFrom(nt_im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
            str = generalflags_resvattr.bytes_oac_msg_extend.get().toStringUtf8();
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("HealthJumpHelper", 1, "getUrlForNt pb fail, exception is" + e16);
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            String optString = new JSONObject(str).optString(QQHealthReportApiImpl.OAC_CLIENT_PARAMS_SPORTS_EXTRA);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            String optString2 = new JSONObject(optString).optString("h5_url");
            if (TextUtils.isEmpty(optString2)) {
                return null;
            }
            return optString2;
        } catch (JSONException e17) {
            QLog.e("HealthJumpHelper", 1, "getUrlForNt json fail, exception is" + e17);
            return null;
        }
    }

    public final boolean h(@Nullable String uin) {
        return TextUtils.equals(IPublicAccountUtil.UIN_FOR_HEALTH, uin);
    }

    public final boolean i(@Nullable String uin) {
        if (h(uin)) {
            return e().getIsRedirectAIO();
        }
        return false;
    }

    public final boolean j() {
        if (i43.b.f407199a.e()) {
            return true;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101550", true);
    }

    public final void k(@NotNull BaseQQAppInterface app, @Nullable String srcId) {
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.d("HealthJumpHelper", 1, "start report step");
        IRuntimeService runtimeService = app.getRuntimeService(ISportManager.class, ProcessConstant.MULTI);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IS\u2026a, ProcessConstant.MULTI)");
        ((ISportManager) runtimeService).refreshCurrentStep(srcId);
    }
}
