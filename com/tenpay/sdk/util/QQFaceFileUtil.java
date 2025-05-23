package com.tenpay.sdk.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.QwLog;
import com.tenpay.proxy.DataProxy;
import com.tenpay.util.Utils;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQFaceFileUtil {
    public static final int QQHEAD_TYPE_GROUP = 4;
    public static final int QQHEAD_TYPE_GROUP_NEW = 8;
    public static final int QQHEAD_TYPE_MOBILE_NUMBER = 11;
    public static final int QQHEAD_TYPE_STRANGER = 32;
    public static final int QQHEAD_TYPE_USER = 1;
    private static final String TAG = "QQFaceFileUtil";
    private OnGetResult onGetResult;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LoadQQIconTask extends AsyncTask<String, Void, Void> {
        private Bitmap mBitmap = null;
        private Context mContext;
        private int mIconSize;
        private ImageView mImageView;

        public LoadQQIconTask(Context context, ImageView imageView, int i3) {
            this.mContext = context;
            this.mImageView = imageView;
            this.mIconSize = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(String... strArr) {
            String str = strArr[0];
            if (!Utils.isStringNull(str)) {
                this.mBitmap = QQFaceFileUtil.getImageByPath(str, this.mIconSize);
            }
            if (this.mBitmap != null) {
                return null;
            }
            this.mBitmap = QQFaceFileUtil.loadDefaultQQIcon(this.mContext, this.mIconSize);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r26) {
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                this.mImageView.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class QQFaceImageGetter extends BroadcastReceiver {
        public static final String Action_GetQQFaceImageResponse = "com.tencent.qqhead.getheadresp";
        public static final String Action_RequestGetQQFaceImage = "com.tencent.qqhead.getheadreq";
        public static final String ReceiverQQFacePermission = "com.tencent.qqhead.permission.getheadresp";
        Activity activity;
        private OnGetResult callBack;
        private int resultNumber;
        private Timer timer;
        private String uin;
        private ArrayList<String> uinList;

        public QQFaceImageGetter(OnGetResult onGetResult, Activity activity) {
            this.callBack = onGetResult;
            this.activity = activity;
        }

        private void getQQFaceByBroadcast(int i3) {
            Intent intent = new Intent("com.tencent.qqhead.getheadreq");
            intent.putExtra("faceType", i3);
            intent.putExtra(SquareJSConst.Params.PARAMS_UIN_LIST, this.uinList);
            this.activity.sendBroadcast(intent);
        }

        private void makesureUnregister(final Object obj, long j3) {
            BaseTimer baseTimer = new BaseTimer();
            this.timer = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tenpay.sdk.util.QQFaceFileUtil.QQFaceImageGetter.1
                private boolean isUIThread = false;

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (this.isUIThread) {
                        QQFaceImageGetter.this.whenDone(obj);
                    } else {
                        this.isUIThread = true;
                        QQFaceImageGetter.this.activity.runOnUiThread(this);
                    }
                }
            }, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void whenDone(Object obj) {
            QwLog.i("\u4efb\u52a1\u5b8c\u6210\uff0c\u53bb\u6ce8\u518c");
            this.callBack.getResult(obj);
            unRegisterReceiver();
        }

        public void getQQFaceImage(String str) {
            this.uin = str;
            ArrayList<String> arrayList = new ArrayList<>();
            this.uinList = arrayList;
            arrayList.add(str);
            registerReceiver();
            makesureUnregister(null, 10000L);
            getQQFaceByBroadcast(1);
        }

        public void getQQFaceImageList(ArrayList<String> arrayList) {
            this.uinList = arrayList;
            this.resultNumber = 0;
            registerReceiver();
            makesureUnregister(Boolean.TRUE, 15000L);
            getQQFaceByBroadcast(1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("headPathList");
            int i3 = 0;
            if (this.uin != null) {
                if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                    while (i3 < stringArrayListExtra.size()) {
                        if (this.uin.equals(stringArrayListExtra.get(i3))) {
                            whenDone((String) stringArrayListExtra2.get(i3));
                            Timer timer = this.timer;
                            if (timer != null) {
                                timer.cancel();
                                this.timer.purge();
                                return;
                            }
                            return;
                        }
                        i3++;
                    }
                    return;
                }
                return;
            }
            if (this.uinList != null) {
                HashMap hashMap = new HashMap();
                while (i3 < stringArrayListExtra.size()) {
                    hashMap.put(stringArrayListExtra.get(i3), stringArrayListExtra2.get(i3));
                    i3++;
                }
                this.resultNumber += hashMap.size();
                QwLog.i("resultNumber:" + this.resultNumber);
                QwLog.i("uinList:" + this.uinList.size());
                if (this.resultNumber == this.uinList.size()) {
                    whenDone(hashMap);
                    Timer timer2 = this.timer;
                    if (timer2 != null) {
                        timer2.cancel();
                        this.timer.purge();
                    }
                }
            }
        }

        public void registerReceiver() {
            QwLog.e("\u6ce8\u518c\u5e7f\u64ad\u63a5\u6536");
            IntentFilter intentFilter = new IntentFilter("com.tencent.qqhead.getheadresp");
            Activity activity = this.activity;
            if (activity != null) {
                try {
                    activity.registerReceiver(this, intentFilter, ReceiverQQFacePermission, null);
                } catch (Exception e16) {
                    QLog.e(QQFaceFileUtil.TAG, 1, "", e16);
                }
            }
        }

        public void unRegisterReceiver() {
            QwLog.e("\u53bb\u6ce8\u518c\u5e7f\u64ad\u63a5\u6536");
            Activity activity = this.activity;
            if (activity != null) {
                try {
                    activity.unregisterReceiver(this);
                } catch (Exception e16) {
                    QLog.e(QQFaceFileUtil.TAG, 1, "", e16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class QQStrangerFaceImageGetter extends IPCGetter {
        public QQStrangerFaceImageGetter(Handler handler, OnGetResult onGetResult) {
            super(handler, onGetResult);
        }

        public void getStrangerFaceImage(String str) {
            startGet(QQFaceFileUtil.getParamsBundle(str, 32));
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            int i16 = this.which;
            Bundle bundle2 = new Bundle();
            this.outBundle = bundle2;
            DataProxy.receiveResult(i16, bundle, bundle2);
            String string = this.outBundle.getString("faceFilePath");
            QwLog.i("faceFilePath");
            this.onGetResult.getResult(string);
        }
    }

    public QQFaceFileUtil(OnGetResult onGetResult) {
        this.onGetResult = onGetResult;
    }

    public static Bitmap getImageByPath(String str, int i3, int i16, int i17) {
        Bitmap bitmap = null;
        if (!Utils.isStringNull(str)) {
            try {
                if (new File(str).exists()) {
                    Bitmap roundBitmap = Utils.toRoundBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), i3, i3, true), i16, i17);
                    QwLog.i("\u83b7\u53d6path\u6210\u529f\uff1a" + str);
                    bitmap = roundBitmap;
                } else {
                    QwLog.i("\u83b7\u53d6path\u5931\u8d25,\u56fe\u50cf\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "", th5);
            }
        } else {
            QwLog.e("\u83b7\u53d6path\u5931\u8d25,path\u4e3a\u7a7a");
        }
        return bitmap;
    }

    public static Bundle getParamsBundle(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("IPCType", 1);
        bundle.putString("uin", str);
        bundle.putInt("faceType", i3);
        bundle.putInt(QCircleLpReportDc010001.KEY_SUBTYPE, 200);
        return bundle;
    }

    public static Bitmap loadDefaultQQIcon(Context context, int i3) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.dxx);
        QwLog.i("load tenpay_ico_qq_default");
        return decodeResource;
    }

    public void getQQFaceImage(String str, Activity activity) {
        if (!Utils.isStringNull(str) && this.onGetResult != null && activity != null) {
            new QQFaceImageGetter(this.onGetResult, activity).getQQFaceImage(str);
        }
    }

    public void getQQFaceImageList(ArrayList<String> arrayList, Activity activity) {
        if (activity != null && arrayList != null && arrayList.size() > 0) {
            new QQFaceImageGetter(this.onGetResult, activity).getQQFaceImageList(arrayList);
        }
    }

    public void getStrangerQQFaceImage(Handler handler, String str) {
        if (!Utils.isStringNull(str) && this.onGetResult != null) {
            new QQStrangerFaceImageGetter(handler, this.onGetResult).getStrangerFaceImage(str);
        }
    }

    public static Bitmap loadDefaultQQIcon(Context context, int i3, int i16) {
        Bitmap decodeResource;
        Resources resources = context.getResources();
        if (i16 != 0) {
            try {
                decodeResource = BitmapFactory.decodeResource(resources, i16);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "", th5);
                return null;
            }
        } else {
            decodeResource = null;
        }
        QwLog.i("load tenpay_ico_qq_default");
        return decodeResource;
    }

    public static Bitmap getImageByPath(String str, int i3) {
        Bitmap bitmap = null;
        if (Utils.isStringNull(str)) {
            QwLog.e("\u83b7\u53d6path\u5931\u8d25,path\u4e3a\u7a7a");
            return null;
        }
        try {
            if (new File(str).exists()) {
                Bitmap roundBitmap = Utils.toRoundBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeFile(str), i3, i3, true), 0, 0);
                QwLog.i("\u83b7\u53d6path\u6210\u529f\uff1a" + str);
                bitmap = roundBitmap;
            } else {
                QwLog.i("\u83b7\u53d6path\u5931\u8d25,\u56fe\u50cf\u6587\u4ef6\u4e0d\u5b58\u5728\uff01");
            }
        } catch (Throwable unused) {
        }
        return bitmap;
    }
}
