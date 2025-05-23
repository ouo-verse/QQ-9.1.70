package com.tencent.mobileqq.vas.VasResEngine;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasResController {
    private static final String TAG = "VasResController";
    private h downloader;
    private int mId;
    f mResDownloadListener = new a();
    private Handler mUIHandler;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends f {
        a() {
        }

        @Override // com.tencent.mobileqq.vip.f
        @TargetApi(9)
        public void onDone(g gVar) {
            super.onDone(gVar);
            VasResController.this.mUIHandler.sendMessage(VasResController.this.mUIHandler.obtainMessage(10002, gVar.i(), 0, gVar.h()));
        }
    }

    public VasResController(int i3, Handler handler) {
        this.mId = i3;
        this.mUIHandler = handler;
    }

    public void downLoad(String str, String str2, Bundle bundle) {
        AppRuntime app = VasUtil.getApp();
        if (this.downloader == null && app != null) {
            try {
                this.downloader = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).getDownloader(app);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16.getMessage());
            }
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "downLoad error url is empty dst =" + str2);
        }
        h hVar = this.downloader;
        if (hVar != null && hVar.getTask(str) == null) {
            this.downloader.startDownload(new g(str, new File(str2)), this.mResDownloadListener, bundle);
        }
    }

    public int getId() {
        return this.mId;
    }

    public String[] getPngs(String str) {
        String str2;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            ArrayList<String> childFiles = FileUtils.getChildFiles(str);
            if (childFiles.size() <= 0) {
                return null;
            }
            int size = childFiles.size();
            String[] strArr = new String[size];
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(File.separator);
            if (childFiles.get(0).contains(".9.png")) {
                str2 = "%d.9.png";
            } else {
                str2 = "%d.png";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            int i3 = 0;
            while (i3 < size) {
                int i16 = i3 + 1;
                strArr[i3] = String.format(sb6, Integer.valueOf(i16));
                i3 = i16;
            }
            return strArr;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "SignatureView DynamicItem png file path error.");
        }
        return null;
    }

    public Handler getUIHanlder() {
        return this.mUIHandler;
    }

    public void loadPngs(final String str, final int i3, final int i16) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vas.VasResEngine.VasResController.2
            @Override // java.lang.Runnable
            public void run() {
                String[] pngs = VasResController.this.getPngs(str);
                Message obtainMessage = VasResController.this.mUIHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                bundle.putStringArray("pngs", pngs);
                bundle.putInt(WidgetCacheConstellationData.INTERVAL, i3);
                bundle.putInt("repeatTimes", i16);
                obtainMessage.setData(bundle);
                obtainMessage.what = 10001;
                VasResController.this.mUIHandler.sendMessage(obtainMessage);
            }
        }, 5, null, true);
    }

    public void update(int i3) {
        this.mId = i3;
    }
}
