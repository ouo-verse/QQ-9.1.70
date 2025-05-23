package com.tenpay.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.impl.e;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.BankImageUtil;
import com.tenpay.api.IApiBankimg;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.download.HttpOpGetFile;
import com.tenpay.util.Utils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiBankimgImpl implements IApiBankimg {
    private static final String TAG = "ApiBankimg";
    private String mBankImagePath;
    private Context mContext;
    private float mDesity;
    private HashMap<String, List<View>> downloadingMap = new HashMap<>();
    private HashMap<String, SoftReference<Bitmap>> mLocalImageMap = new HashMap<>();
    private HashMap<String, Integer> mWhiteLogoMap = new HashMap<>();
    private HashMap<String, Integer> mWhiteBgMapForQQ = new HashMap<>();
    private HashMap<String, Integer> mWhiteLogoMapForQQ = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LoadImgAndToGrayTask extends LoadImgTask {
        List<View> list;

        public LoadImgAndToGrayTask() {
            super(null);
            this.list = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tenpay.impl.ApiBankimgImpl.LoadImgTask, android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tenpay.impl.ApiBankimgImpl.LoadImgTask, android.os.AsyncTask
        public String[] doInBackground(String... strArr) {
            String[] strArr2 = new String[2];
            String str = strArr[0];
            this.list = (List) ApiBankimgImpl.this.downloadingMap.get(str);
            if (TextUtils.isEmpty(str)) {
                return strArr2;
            }
            try {
                int indexOf = str.indexOf("_g");
                if (indexOf > 0) {
                    str = str.substring(0, indexOf);
                }
                strArr2 = super.doInBackground(str);
                strArr2[0] = strArr[0];
                return strArr2;
            } catch (Exception e16) {
                QLog.e(ApiBankimgImpl.TAG, 1, "", e16);
                return strArr2;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tenpay.impl.ApiBankimgImpl.LoadImgTask, android.os.AsyncTask
        public void onPostExecute(String[] strArr) {
            super.onPostExecute(strArr);
            if (ApiBankimgImpl.this.mLocalImageMap != null) {
                ApiBankimgImpl apiBankimgImpl = ApiBankimgImpl.this;
                if (apiBankimgImpl.containKeyBitmap(apiBankimgImpl.mLocalImageMap, strArr[0])) {
                    ApiBankimgImpl apiBankimgImpl2 = ApiBankimgImpl.this;
                    Bitmap softBitmapFromHashMap = apiBankimgImpl2.getSoftBitmapFromHashMap(apiBankimgImpl2.mLocalImageMap, strArr[0]);
                    if (softBitmapFromHashMap != null) {
                        Bitmap grayscale = BankImageUtil.toGrayscale(softBitmapFromHashMap);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(ApiBankimgImpl.this.mContext.getResources(), Utils.getDensityBitmap(ApiBankimgImpl.this.mContext, grayscale, ApiBankimgImpl.this.mDesity));
                        ApiBankimgImpl apiBankimgImpl3 = ApiBankimgImpl.this;
                        apiBankimgImpl3.putSoftBitmapToHashMap(apiBankimgImpl3.mLocalImageMap, strArr[0], grayscale);
                        List<View> list = this.list;
                        if (list != null && list.size() > 0) {
                            Iterator<View> it = this.list.iterator();
                            while (it.hasNext()) {
                                it.next().setBackgroundDrawable(bitmapDrawable);
                            }
                        }
                    }
                    if (softBitmapFromHashMap != null) {
                        try {
                            softBitmapFromHashMap.recycle();
                        } catch (Exception e16) {
                            QLog.e(ApiBankimgImpl.TAG, 1, "", e16);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class LoadImgTask extends AsyncTask<String, Void, String[]> {
        private ResultReceiver mResultReceiver;

        LoadImgTask(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public String[] doInBackground(String... strArr) {
            String[] strArr2 = new String[2];
            String str = strArr[0];
            QwLog.i("start download image");
            File file = new File(ApiBankimgImpl.this.mBankImagePath);
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            String str2 = null;
            try {
                HttpOpGetFile httpOpGetFile = new HttpOpGetFile();
                httpOpGetFile.setFilePathName(ApiBankimgImpl.this.mBankImagePath, str + ".png");
                httpOpGetFile.startRun(ApiBankimgImpl.this.mContext, ApiBankimgImpl.this.getUrlHead() + Cgi.URL_GET_IMG + str + ".png");
                QwLog.i("url=" + ApiBankimgImpl.this.getUrlHead() + Cgi.URL_GET_IMG + str + ".png");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(ApiBankimgImpl.this.mBankImagePath);
                sb5.append(str);
                sb5.append(".png");
                File file2 = new File(sb5.toString());
                if (file2.exists()) {
                    str2 = file2.toString();
                }
            } catch (Exception e16) {
                QwLog.i("download exception" + e16.toString());
            }
            strArr2[0] = str;
            strArr2[1] = str2;
            return strArr2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public void onPostExecute(String[] strArr) {
            Bitmap bitmap;
            String str = strArr[0];
            String str2 = strArr[1];
            List<View> list = (List) ApiBankimgImpl.this.downloadingMap.get(str);
            if (list != null) {
                for (View view : list) {
                    if (view != null) {
                        if (str2 != null) {
                            try {
                                bitmap = BitmapFactory.decodeFile(str2);
                            } catch (OutOfMemoryError e16) {
                                QLog.e(ApiBankimgImpl.TAG, 1, "", e16);
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(ApiBankimgImpl.this.mContext.getResources(), Utils.getDensityBitmap(ApiBankimgImpl.this.mContext, bitmap, ApiBankimgImpl.this.mDesity));
                                ApiBankimgImpl apiBankimgImpl = ApiBankimgImpl.this;
                                apiBankimgImpl.putSoftBitmapToHashMap(apiBankimgImpl.mLocalImageMap, str, bitmap);
                                view.setBackgroundDrawable(bitmapDrawable);
                                ApiBankimgImpl.this.downloadingMap.remove(str);
                            } else {
                                view.setBackgroundResource(R.drawable.dvy);
                            }
                        } else {
                            view.setBackgroundResource(R.drawable.dvy);
                        }
                    }
                }
            }
            if (this.mResultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putString("image_id", str);
                bundle.putString("image_res_path", str2);
                this.mResultReceiver.send(0, bundle);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containKeyBitmap(HashMap<String, SoftReference<Bitmap>> hashMap, String str) {
        Bitmap bitmap;
        SoftReference<Bitmap> softReference;
        if (hashMap.containsKey(str) && (softReference = hashMap.get(str)) != null) {
            bitmap = softReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            return true;
        }
        return false;
    }

    private int getBankCardLogoResId(String str) {
        int drawableId = getDrawableId("qb_tenpay_android_b" + str + "_xh");
        if (drawableId == 0) {
            return R.drawable.dvy;
        }
        return drawableId;
    }

    private int getBankCardWhiteLogoResId(String str) {
        int drawableId = getDrawableId("qb_tenpay_w" + str);
        if (drawableId == 0) {
            int drawableId2 = getDrawableId("qb_tenpay_android_b" + str + "_xh");
            if (drawableId2 == 0) {
                return R.drawable.dvy;
            }
            return drawableId2;
        }
        return drawableId;
    }

    private int getDrawableId(String str) {
        try {
            int i3 = e.class.getField(str).getInt(null);
            QwLog.i("getDrawableId:" + str + ContainerUtils.KEY_VALUE_DELIMITER + i3);
            return i3;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getSoftBitmapFromHashMap(HashMap<String, SoftReference<Bitmap>> hashMap, String str) {
        SoftReference<Bitmap> softReference;
        if (hashMap.containsKey(str) && (softReference = hashMap.get(str)) != null) {
            Bitmap bitmap = softReference.get();
            QwLog.i("\u7f13\u5b58\u6709\uff0c\u76f4\u63a5\u7f13\u5b58\u52a0\u8f7d:" + str);
            return bitmap;
        }
        return null;
    }

    private void initForQQ() {
        this.mWhiteLogoMapForQQ.put("20001", Integer.valueOf(R.drawable.e0b));
        this.mWhiteLogoMapForQQ.put("20002", Integer.valueOf(R.drawable.e0c));
        this.mWhiteLogoMapForQQ.put("20004", Integer.valueOf(R.drawable.e0d));
        this.mWhiteLogoMapForQQ.put("20007", Integer.valueOf(R.drawable.e0e));
        this.mWhiteLogoMapForQQ.put("20009", Integer.valueOf(R.drawable.e0f));
        this.mWhiteLogoMapForQQ.put("20026", Integer.valueOf(R.drawable.e0g));
        this.mWhiteLogoMapForQQ.put("20046", Integer.valueOf(R.drawable.qb_tenpay_w20046));
        this.mWhiteBgMapForQQ.put("20001", Integer.valueOf(R.drawable.dvs));
        this.mWhiteBgMapForQQ.put("20002", Integer.valueOf(R.drawable.dvu));
        this.mWhiteBgMapForQQ.put("20004", Integer.valueOf(R.drawable.dvt));
        this.mWhiteBgMapForQQ.put("20007", Integer.valueOf(R.drawable.dvq));
        this.mWhiteBgMapForQQ.put("20009", Integer.valueOf(R.drawable.dvr));
        this.mWhiteBgMapForQQ.put("20026", Integer.valueOf(R.drawable.dvw));
        this.mWhiteBgMapForQQ.put("20046", Integer.valueOf(R.drawable.dvv));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putSoftBitmapToHashMap(HashMap<String, SoftReference<Bitmap>> hashMap, String str, Bitmap bitmap) {
        hashMap.put(str, new SoftReference<>(bitmap));
    }

    private void setBankCardWhiteLogo(String str, View view) {
        if (this.mWhiteLogoMap.containsKey(str)) {
            int drawableId = getDrawableId("qb_tenpay_w" + str);
            if (drawableId != 0) {
                view.setBackgroundResource(drawableId);
                return;
            }
            return;
        }
        view.setBackgroundResource(R.drawable.dvz);
        setBankImage(str, view);
    }

    private void setBankGrayImage(String str, View view) {
        if (Utils.isEmpty(str)) {
            view.setBackgroundResource(R.drawable.dvy);
            return;
        }
        this.mDesity = Utils.getDensity(this.mContext);
        String str2 = str + "_s";
        String str3 = str + "_s_g";
        if (containKeyBitmap(this.mLocalImageMap, str3)) {
            try {
                view.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), Utils.getDensityBitmap(this.mContext, getSoftBitmapFromHashMap(this.mLocalImageMap, str3), this.mDesity)));
                return;
            } catch (Exception | OutOfMemoryError e16) {
                QLog.e(TAG, 1, "", e16);
                return;
            }
        }
        if (containKeyBitmap(this.mLocalImageMap, str2)) {
            QwLog.i("3");
            Bitmap grayscale = BankImageUtil.toGrayscale(getSoftBitmapFromHashMap(this.mLocalImageMap, str2));
            view.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), Utils.getDensityBitmap(this.mContext, grayscale, this.mDesity)));
            putSoftBitmapToHashMap(this.mLocalImageMap, str3, grayscale);
            return;
        }
        String str4 = this.mBankImagePath + str3 + ".png";
        File file = new File(str4);
        if (file.exists()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(str4);
            if (decodeFile != null) {
                view.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), Utils.getDensityBitmap(this.mContext, decodeFile, this.mDesity)));
                putSoftBitmapToHashMap(this.mLocalImageMap, str3, decodeFile);
                return;
            }
            file.delete();
            List<View> list = this.downloadingMap.get(str3);
            if (list == null) {
                list = new ArrayList<>();
                this.downloadingMap.put(str3, list);
            }
            list.add(view);
            new LoadImgAndToGrayTask().execute(str3);
            return;
        }
        String str5 = this.mBankImagePath + str2 + ".png";
        File file2 = new File(str5);
        if (file2.exists()) {
            Bitmap grayscale2 = BankImageUtil.toGrayscale(BitmapFactory.decodeFile(str5));
            if (grayscale2 != null) {
                view.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), Utils.getDensityBitmap(this.mContext, grayscale2, this.mDesity)));
                putSoftBitmapToHashMap(this.mLocalImageMap, str3, grayscale2);
                return;
            }
            file2.delete();
            List<View> list2 = this.downloadingMap.get(str3);
            if (list2 == null) {
                list2 = new ArrayList<>();
                this.downloadingMap.put(str3, list2);
            }
            list2.add(view);
            new LoadImgAndToGrayTask().execute(str3);
            return;
        }
        List<View> list3 = this.downloadingMap.get(str3);
        if (list3 == null) {
            list3 = new ArrayList<>();
            this.downloadingMap.put(str3, list3);
        }
        list3.add(view);
        new LoadImgAndToGrayTask().execute(str3);
    }

    @Override // com.tenpay.api.IApiBankimg
    public int getBankCardBackgroundId(String str) {
        Integer num = this.mWhiteLogoMap.get(str);
        if (num == null) {
            num = Integer.valueOf(R.drawable.dvv);
        }
        return num.intValue();
    }

    @Override // com.tenpay.api.IApiBankimg
    public int getBankCardBackgroundIdForQQ(String str) {
        Integer num = this.mWhiteBgMapForQQ.get(str);
        if (num == null) {
            num = Integer.valueOf(R.drawable.dvv);
        }
        return num.intValue();
    }

    @Override // com.tenpay.api.IApiBankimg
    public void getBankCardLogoForQQ(String str, ResultReceiver resultReceiver) {
        String str2 = str + "_s";
        QwLog.i("getBankCardLogoForQQ image_id = " + str);
        String str3 = this.mBankImagePath + str2 + ".png";
        if (new File(str3).exists()) {
            Bundle bundle = new Bundle();
            bundle.putString("image_id", str2);
            bundle.putString("image_res_path", str3);
            resultReceiver.send(0, bundle);
            return;
        }
        new LoadImgTask(resultReceiver).execute(str2);
    }

    @Override // com.tenpay.api.IApiBankimg
    public void getBankCardWhiteMark(String str, ResultReceiver resultReceiver) {
        String str2 = str + "_b";
        QwLog.i("getBankCardWhiteMark image_id = " + str);
        String str3 = this.mBankImagePath + str2 + ".png";
        if (new File(str3).exists()) {
            Bundle bundle = new Bundle();
            bundle.putString("image_id", str2);
            bundle.putString("image_res_path", str3);
            resultReceiver.send(0, bundle);
            return;
        }
        new LoadImgTask(resultReceiver).execute(str2);
    }

    protected Object getUrlHead() {
        String str;
        if (TextUtils.isEmpty(Cgi.wallet_domain)) {
            str = Cgi.DOMAIN_YUN_SERVER;
        } else {
            str = Cgi.wallet_domain;
        }
        String str2 = "https://" + str;
        QwLog.i("head=" + str2);
        return str2;
    }

    @Override // com.tenpay.api.IApiBase
    public void init(Context context) {
        this.mContext = context.getApplicationContext();
        this.mBankImagePath = context.getCacheDir().getAbsolutePath() + "/";
        initForQQ();
    }

    @Override // com.tenpay.api.IApiBankimg
    public void setBankCardDisableLogo(String str, View view) {
        QwLog.i("setBankCardDisableLogo");
        if (this.mWhiteLogoMap.containsKey(str)) {
            QwLog.i("get ImageId");
            int drawableId = getDrawableId("qb_tenpay_w" + str);
            if (drawableId != 0) {
                view.setBackgroundResource(drawableId);
                return;
            }
            return;
        }
        QwLog.i("ImageId not find");
        view.setBackgroundResource(R.drawable.dvz);
        setBankGrayImage(str, view);
    }

    @Override // com.tenpay.api.IApiBankimg
    public void setBankCardWhiteLogoForQQ(String str, View view) {
        if (this.mWhiteLogoMapForQQ.containsKey(str)) {
            int intValue = this.mWhiteLogoMapForQQ.get(str).intValue();
            if (intValue != 0) {
                view.setBackgroundResource(intValue);
                return;
            }
            return;
        }
        view.setBackgroundResource(R.drawable.dvz);
        setBankImage(str, view);
    }

    @Override // com.tenpay.api.IApiBankimg
    public void setBankImage(String str, View view) {
        if (Utils.isEmpty(str)) {
            view.setBackgroundResource(R.drawable.dvy);
            return;
        }
        this.mDesity = Utils.getDensity(this.mContext);
        String str2 = str + "_s";
        QwLog.i("image_id = " + str);
        if (containKeyBitmap(this.mLocalImageMap, str2)) {
            QwLog.i("contain tmpImgId=" + str2);
            Bitmap densityBitmap = Utils.getDensityBitmap(this.mContext, getSoftBitmapFromHashMap(this.mLocalImageMap, str2), this.mDesity);
            if (densityBitmap != null) {
                view.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), densityBitmap));
                return;
            }
            return;
        }
        String str3 = this.mBankImagePath + str2 + ".png";
        File file = new File(str3);
        QwLog.i("path=" + str3);
        if (file.exists()) {
            QwLog.i("image exist");
            Bitmap decodeFile = BitmapFactory.decodeFile(str3);
            if (decodeFile != null) {
                view.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), Utils.getDensityBitmap(this.mContext, decodeFile, this.mDesity)));
                putSoftBitmapToHashMap(this.mLocalImageMap, str2, decodeFile);
                return;
            }
            file.delete();
            List<View> list = this.downloadingMap.get(str2);
            if (list == null) {
                list = new ArrayList<>();
                this.downloadingMap.put(str2, list);
            }
            list.add(view);
            new LoadImgTask(null).execute(str2);
            return;
        }
        view.setBackground(null);
        QwLog.i("image download");
        List<View> list2 = this.downloadingMap.get(str2);
        if (list2 == null) {
            list2 = new ArrayList<>();
            this.downloadingMap.put(str2, list2);
        }
        list2.add(view);
        new LoadImgTask(null).execute(str2);
    }

    @Override // com.tenpay.api.IApiBankimg
    public int getBankCardBackgroundId(String str, int i3) {
        Integer num;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            num = Integer.valueOf(R.drawable.dvx);
        } else {
            num = this.mWhiteLogoMap.get(str);
            if (num == null) {
                num = Integer.valueOf(R.drawable.dvv);
            }
        }
        return num.intValue();
    }

    @Override // com.tenpay.api.IApiBankimg
    public int getBankCardBackgroundIdForQQ(String str, int i3) {
        Integer num;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            num = Integer.valueOf(R.drawable.dvx);
        } else {
            num = this.mWhiteBgMapForQQ.get(str);
            if (num == null) {
                num = Integer.valueOf(R.drawable.dvv);
            }
        }
        return num.intValue();
    }
}
