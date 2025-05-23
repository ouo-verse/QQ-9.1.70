package d8;

import NS_MOBILE_MAIN_PAGE.mobile_get_uimbitmap_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_set_uimbitmap_rsp;
import android.os.Bundle;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static a f393199d;

    public static a a() {
        if (f393199d == null) {
            synchronized (a.class) {
                if (f393199d == null) {
                    f393199d = new a();
                }
            }
        }
        return f393199d;
    }

    public boolean b() {
        return LocalMultiProcConfig.getBool("flash_nick_name", false);
    }

    public void e(String str) {
        LocalMultiProcConfig.putString("describe_label", str);
    }

    public void f(boolean z16) {
        LocalMultiProcConfig.putBool("flash_nick_name", z16);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            c(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            d(qZoneTask);
        }
    }

    public void c(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(IChannelType.APP_SUB_CHANNEL_TYPE_CODM);
        mobile_get_uimbitmap_rsp mobile_get_uimbitmap_rspVar = (mobile_get_uimbitmap_rsp) qZoneTask.mRequest.rsp;
        if (result.getSucceed() && mobile_get_uimbitmap_rspVar != null) {
            f(mobile_get_uimbitmap_rspVar.switch_flag);
            result.setSucceed(true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("state", mobile_get_uimbitmap_rspVar.switch_flag);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    public void d(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000071);
        mobile_set_uimbitmap_rsp mobile_set_uimbitmap_rspVar = (mobile_set_uimbitmap_rsp) qZoneTask.mRequest.rsp;
        if (result.getSucceed() && mobile_set_uimbitmap_rspVar != null && mobile_set_uimbitmap_rspVar.ret == 0) {
            result.setSucceed(true);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }
}
