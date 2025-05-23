package com.tencent.biz.qqcircle.helpers;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBarrageHelper {

    /* renamed from: b, reason: collision with root package name */
    private static volatile QFSBarrageHelper f84560b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f84561a;

    public static QFSBarrageHelper c() {
        if (f84560b == null) {
            synchronized (QFSBarrageHelper.class) {
                if (f84560b == null) {
                    f84560b = new QFSBarrageHelper();
                }
            }
        }
        return f84560b;
    }

    public void d() {
        if (!uq3.c.i0()) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.helpers.QFSBarrageHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (uq3.k.a().c("sp_key_barrage_has_migrate", false)) {
                    return;
                }
                Object readObject = FileUtils.readObject("viola_cache_file_common_video_barrage_enable_key_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
                uq3.k.a().j("sp_key_barrage_has_migrate", true);
                if (!(readObject instanceof String)) {
                    return;
                }
                try {
                    QFSBarrageHelper.this.f84561a = new JSONObject((String) readObject).getBoolean("barrageEnable");
                    QLog.d("QFSBarrageUtils", 1, "mKanDianBarrageEnable = " + QFSBarrageHelper.this.f84561a);
                    com.tencent.biz.qqcircle.manager.d.b().h(QFSBarrageHelper.this.f84561a);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }
}
