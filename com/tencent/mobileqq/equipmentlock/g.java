package com.tencent.mobileqq.equipmentlock;

import com.tencent.mobileqq.ntpush.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x51.SubMsgType0x51$DevInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x51.SubMsgType0x51$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/equipmentlock/g;", "Lcom/tencent/mobileqq/ntpush/a;", "", "c", "", "rawData", "", "b", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g implements com.tencent.mobileqq.ntpush.a {
    @Override // com.tencent.mobileqq.ntpush.a
    public long a() {
        return a.C8170a.a(this);
    }

    @Override // com.tencent.mobileqq.ntpush.a
    public long c() {
        return 81L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    @Override // com.tencent.mobileqq.ntpush.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(byte[] rawData) {
        Exception exc;
        boolean z16;
        String str;
        String str2;
        String str3;
        String str4;
        SubMsgType0x51$DevInfo subMsgType0x51$DevInfo;
        String str5;
        int i3;
        String str6;
        String str7;
        boolean z17;
        String str8;
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        if (QLog.isColorLevel()) {
            QLog.d("DevLock", 2, "recv ntpush 0x51");
        }
        try {
            SubMsgType0x51$MsgBody subMsgType0x51$MsgBody = new SubMsgType0x51$MsgBody();
            subMsgType0x51$MsgBody.mergeFrom(rawData);
            if (subMsgType0x51$MsgBody.bytes_qrsig_url.has()) {
                byte[] byteArray = subMsgType0x51$MsgBody.bytes_qrsig_url.get().toByteArray();
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                str8 = new String(byteArray, UTF_8);
            } else {
                str8 = null;
            }
            try {
                if (subMsgType0x51$MsgBody.bytes_hint1.has()) {
                    byte[] byteArray2 = subMsgType0x51$MsgBody.bytes_hint1.get().toByteArray();
                    Charset UTF_82 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                    str3 = new String(byteArray2, UTF_82);
                } else {
                    str3 = null;
                }
            } catch (Exception e16) {
                exc = e16;
                z16 = false;
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            try {
                if (subMsgType0x51$MsgBody.bytes_hint2.has()) {
                    byte[] byteArray3 = subMsgType0x51$MsgBody.bytes_hint2.get().toByteArray();
                    Charset UTF_83 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_83, "UTF_8");
                    str4 = new String(byteArray3, UTF_83);
                } else {
                    str4 = null;
                }
                try {
                    if (subMsgType0x51$MsgBody.bytes_appname.has()) {
                        byte[] byteArray4 = subMsgType0x51$MsgBody.bytes_appname.get().toByteArray();
                        Charset UTF_84 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_84, "UTF_8");
                        str2 = new String(byteArray4, UTF_84);
                    } else {
                        str2 = null;
                    }
                    try {
                        z16 = subMsgType0x51$MsgBody.support_auto_renew_ticket.has() ? subMsgType0x51$MsgBody.support_auto_renew_ticket.get() : false;
                    } catch (Exception e17) {
                        exc = e17;
                        z16 = false;
                    }
                } catch (Exception e18) {
                    exc = e18;
                    z16 = false;
                    str = null;
                    str2 = null;
                    subMsgType0x51$DevInfo = null;
                }
            } catch (Exception e19) {
                exc = e19;
                z16 = false;
                str = null;
                str2 = null;
                str4 = null;
                subMsgType0x51$DevInfo = str4;
                r4 = str8;
                QLog.e("DevLock", 1, "failed to parse msg0x210.Submsgtype0x51, ", exc);
                str5 = str;
                i3 = 0;
                str6 = r4;
                str7 = str2;
                z17 = z16;
                SubMsgType0x51$DevInfo subMsgType0x51$DevInfo2 = subMsgType0x51$DevInfo;
                if (QLog.isColorLevel()) {
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("devlock_quick_login_open_in_background", false)) {
                }
            }
            try {
                subMsgType0x51$DevInfo = subMsgType0x51$MsgBody.dev_info.has() ? subMsgType0x51$MsgBody.dev_info.get() : null;
                try {
                    r4 = subMsgType0x51$MsgBody.auto_renew_tips.has() ? subMsgType0x51$MsgBody.auto_renew_tips.get() : null;
                    i3 = subMsgType0x51$MsgBody.appid.has() ? subMsgType0x51$MsgBody.appid.get() : 0;
                    str5 = r4;
                    str7 = str2;
                    z17 = z16;
                    str6 = str8;
                } catch (Exception e26) {
                    exc = e26;
                    str = r4;
                    r4 = str8;
                    QLog.e("DevLock", 1, "failed to parse msg0x210.Submsgtype0x51, ", exc);
                    str5 = str;
                    i3 = 0;
                    str6 = r4;
                    str7 = str2;
                    z17 = z16;
                    SubMsgType0x51$DevInfo subMsgType0x51$DevInfo22 = subMsgType0x51$DevInfo;
                    if (QLog.isColorLevel()) {
                    }
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("devlock_quick_login_open_in_background", false)) {
                    }
                }
            } catch (Exception e27) {
                exc = e27;
                str = null;
                subMsgType0x51$DevInfo = null;
                r4 = str8;
                QLog.e("DevLock", 1, "failed to parse msg0x210.Submsgtype0x51, ", exc);
                str5 = str;
                i3 = 0;
                str6 = r4;
                str7 = str2;
                z17 = z16;
                SubMsgType0x51$DevInfo subMsgType0x51$DevInfo222 = subMsgType0x51$DevInfo;
                if (QLog.isColorLevel()) {
                }
                AppRuntime peekAppRuntime22 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("devlock_quick_login_open_in_background", false)) {
                }
            }
        } catch (Exception e28) {
            exc = e28;
            z16 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            subMsgType0x51$DevInfo = null;
        }
        SubMsgType0x51$DevInfo subMsgType0x51$DevInfo2222 = subMsgType0x51$DevInfo;
        if (QLog.isColorLevel()) {
            QLog.d("DevLock", 2, "recv devlock quicklogin push qrcode=" + str6 + " maintip=" + str3 + " smalltip" + str4);
        }
        AppRuntime peekAppRuntime222 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("devlock_quick_login_open_in_background", false)) {
            EquipmentLockImpl.o().v(peekAppRuntime222, str6, str3, str4, str7, z17, i3, str5, subMsgType0x51$DevInfo2222);
        } else {
            EquipmentLockImpl.o().u(peekAppRuntime222, str6, str3, str4, str7, z17, i3, str5, subMsgType0x51$DevInfo2222);
        }
    }
}
