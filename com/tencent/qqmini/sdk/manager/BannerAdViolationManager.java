package com.tencent.qqmini.sdk.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BannerAdViolationManager {
    private static final String TAG = "BannerAdViolationManage";
    private static Map<Long, Long> exposureTimestampMap = new HashMap();

    private static View.OnClickListener getOnClickListenerReflected(View view) {
        Field declaredField;
        View.OnClickListener onClickListener = null;
        if (view == null) {
            return null;
        }
        try {
            Field declaredField2 = View.class.getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(view);
                if (obj != null && (declaredField = obj.getClass().getDeclaredField("mOnClickListener")) != null) {
                    declaredField.setAccessible(true);
                    onClickListener = (View.OnClickListener) declaredField.get(obj);
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "getOnClickListenerReflected", th5);
        }
        QMLog.d(TAG, "getOnClickListenerReflected: listener = " + onClickListener);
        return onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleViolationReport(String str, long j3, int i3, long j16) {
        QMLog.d(TAG, "handleViolationReport() called with: miniAppId = [" + str + "], aid = [" + j3 + "], clickArea = [" + i3 + "], expoClickInterval = [" + j16 + "]");
        if (i3 > 0 && i3 < 11 && j16 > 0) {
            String str2 = str + QbAddrData.DATA_SPLITER + j3 + QbAddrData.DATA_SPLITER + i3 + QbAddrData.DATA_SPLITER + j16 + QbAddrData.DATA_SPLITER + System.currentTimeMillis() + QbAddrData.DATA_SPLITER + "Android" + QbAddrData.DATA_SPLITER + "";
            QMLog.d(TAG, "handleViolationReport: report one record " + str2);
            Bundle bundle = new Bundle();
            bundle.putStringArray("data", new String[]{str2});
            bundle.putString("log_key", "dc05439");
            AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", bundle, null);
            return;
        }
        QMLog.w(TAG, "invalid report record clickArea = " + i3 + ", expoClickInterval = " + j16);
    }

    public static void scheduleViolationDetectTask(final String str, final long j3, final View view) {
        QMLog.d(TAG, "scheduleViolationDetectTask() called with: miniAppId = [" + str + "], aid = [" + j3 + "], view = [" + view + "]");
        if (!TextUtils.isEmpty(str) && view != null) {
            exposureTimestampMap.put(Long.valueOf(j3), Long.valueOf(System.currentTimeMillis()));
            final float[] fArr = new float[2];
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qqmini.sdk.manager.BannerAdViolationManager.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        fArr[0] = motionEvent.getX();
                        fArr[1] = motionEvent.getY();
                    }
                    return false;
                }
            });
            final View.OnClickListener onClickListenerReflected = getOnClickListenerReflected(view);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.manager.BannerAdViolationManager.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    long j16;
                    int i3;
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    View.OnClickListener onClickListener = onClickListenerReflected;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    }
                    Long l3 = (Long) BannerAdViolationManager.exposureTimestampMap.get(Long.valueOf(j3));
                    if (l3 != null) {
                        j16 = System.currentTimeMillis() - l3.longValue();
                    } else {
                        j16 = 0;
                    }
                    long j17 = j16;
                    int width = view.getWidth() / 5;
                    int height = view.getHeight() / 2;
                    float[] fArr2 = fArr;
                    if (fArr2[1] > height) {
                        i3 = (((int) fArr2[0]) / width) + 6;
                    } else {
                        i3 = (((int) fArr2[0]) / width) + 1;
                    }
                    int i16 = i3;
                    QMLog.d(BannerAdViolationManager.TAG, "box = " + width + "," + height + " size = " + view.getWidth() + "," + view.getHeight() + " x,y = " + fArr[0] + "," + fArr[1] + " area = " + i16);
                    BannerAdViolationManager.handleViolationReport(str, j3, i16, j17);
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
            QMLog.d(TAG, "scheduleViolationDetectTask: end");
        }
    }
}
