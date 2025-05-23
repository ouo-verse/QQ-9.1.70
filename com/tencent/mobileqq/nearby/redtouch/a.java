package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.oidb.redInfo$RedInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    WeakReference<LocalRedTouchManager> f253055a;

    /* renamed from: b, reason: collision with root package name */
    QQAppInterface f253056b;

    public a(QQAppInterface qQAppInterface, LocalRedTouchManager localRedTouchManager) {
        this.f253055a = new WeakReference<>(localRedTouchManager);
        this.f253056b = qQAppInterface;
    }

    public static String c(int i3) {
        return "file_redpoint_handler_" + BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    @Override // com.tencent.mobileqq.nearby.redtouch.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(List<RedTouchItem> list) {
        List<RedTouchItemExtMsg> list2;
        byte[] bArr;
        String str;
        int optInt;
        String str2;
        LocalRedTouchManager d16 = d();
        if (list != null && d16 != null) {
            Iterator<RedTouchItem> it = list.iterator();
            String str3 = null;
            while (it.hasNext()) {
                if (it.next().taskId == 10005) {
                    str3 = "0X800761B";
                }
                if (str3 != null) {
                    ReportController.o(this.f253056b, "dc00898", "", "", str3, str3, 0, 0, "", "", "", "");
                }
            }
            RedTouchItem j3 = d16.j(10015);
            if (j3 != null && list.contains(j3)) {
                str3 = "0X8007391";
                ReportController.o(this.f253056b, "dc00898", "", "", "0X8007391", "0X8007391", 0, 0, "", "", "", "");
                ((MedalWallMng) this.f253056b.getManager(QQManagerFactory.MEDAL_WALL_MNG)).s();
            }
            RedTouchItem j16 = d16.j(10016);
            if (j16 != null && list.contains(j16) && (bArr = j16.bytes) != null && bArr.length > 0) {
                try {
                    optInt = new JSONObject(new String(bArr, "utf-8")).optInt("type", 1);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DefaultRedPointPrePostHandler", 2, e16, new Object[0]);
                    }
                }
                if (optInt != 4) {
                    if (optInt == 5) {
                        str2 = "0X80073B5";
                    } else {
                        str = str3;
                        if (str != null) {
                            ReportController.o(this.f253056b, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
                        }
                    }
                } else {
                    str2 = "0X8007396";
                }
                str3 = str2;
                str = str3;
                if (str != null) {
                }
            }
            RedTouchItem j17 = d16.j(10018);
            if (j17 != null && list.contains(j17) && (list2 = j17.extMsgs) != null && list2.size() > 0 && j17.unReadFlag) {
                ConfessManager confessManager = (ConfessManager) this.f253056b.getManager(QQManagerFactory.CONFESS_MANAGER);
                ConfessConfig h16 = confessManager.h();
                if (h16 != null && h16.g()) {
                    confessManager.r(j17);
                    return;
                }
                j17.unReadFlag = false;
                d16.B();
                if (QLog.isColorLevel()) {
                    QLog.i("DefaultRedPointPrePostHandler", 2, "onPostDealReachedRedPoints frdRecMsgSwitch is off");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e1  */
    @Override // com.tencent.mobileqq.nearby.redtouch.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(RedTouchItem redTouchItem, int i3) {
        RedTouchItemExtMsg redTouchItemExtMsg;
        boolean z16;
        redInfo$RedInfo redinfo_redinfo;
        Throwable th5;
        if (i3 != 10016 && i3 != 10015) {
            if (i3 == 100601) {
                redTouchItem.isClosed = !((IUtil) QRoute.api(IUtil.class)).checkLikeRankListRedPointConfig(this.f253056b);
                return;
            }
            if (e.a(i3)) {
                String str = "";
                if (redTouchItem.extMsgs.size() > 0) {
                    redTouchItemExtMsg = redTouchItem.extMsgs.get(0);
                    byte[] bArr = redTouchItemExtMsg.bytesData;
                    if (bArr != null && bArr.length > 0) {
                        try {
                            redinfo_redinfo = new redInfo$RedInfo();
                        } catch (Throwable th6) {
                            redinfo_redinfo = null;
                            th5 = th6;
                        }
                        try {
                            redinfo_redinfo.mergeFrom(redTouchItemExtMsg.bytesData);
                        } catch (Throwable th7) {
                            th5 = th7;
                            if (QLog.isColorLevel()) {
                                QLog.i("DefaultRedPointPrePostHandler", 2, th5.getMessage(), th5);
                            }
                            if (redinfo_redinfo == null) {
                            }
                            z16 = false;
                            if (redTouchItemExtMsg.bytesData.length > 102400) {
                            }
                            if (redTouchItem.extMsgs.size() > 1) {
                            }
                            if (!z16) {
                            }
                            QLog.d("DefaultRedPointPrePostHandler", 1, "isQQSettingMeBubbleMsg show=", Boolean.valueOf(z16), " uin=", StringUtil.getSimpleUinForPrint(str));
                            return;
                        }
                        if (redinfo_redinfo == null && redinfo_redinfo.uint64_from_uin.has()) {
                            str = redinfo_redinfo.uint64_from_uin.get() + "";
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (redTouchItemExtMsg.bytesData.length > 102400) {
                            QLog.d("DefaultRedPointPrePostHandler", 1, String.format("onPreHandle() id=[%d] msgs.size=%d bytes_data.len=%d too large !!", Integer.valueOf(i3), Integer.valueOf(redTouchItem.extMsgs.size()), Integer.valueOf(redTouchItemExtMsg.bytesData.length)));
                        }
                    } else {
                        z16 = false;
                    }
                    if (redTouchItem.extMsgs.size() > 1) {
                        for (int size = redTouchItem.extMsgs.size() - 1; size > 0; size--) {
                            redTouchItem.extMsgs.remove(size);
                        }
                    }
                } else {
                    redTouchItemExtMsg = null;
                    z16 = false;
                }
                if (!z16) {
                    FileUtils.writeObject(c(-4), redTouchItemExtMsg);
                } else {
                    redTouchItem.count = 0;
                }
                QLog.d("DefaultRedPointPrePostHandler", 1, "isQQSettingMeBubbleMsg show=", Boolean.valueOf(z16), " uin=", StringUtil.getSimpleUinForPrint(str));
                return;
            }
            return;
        }
        redTouchItem.isClosed = true;
    }

    public LocalRedTouchManager d() {
        WeakReference<LocalRedTouchManager> weakReference = this.f253055a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
