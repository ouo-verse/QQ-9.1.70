package com.tencent.aelight.camera.ae.config;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetBulkImageClassifyRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetImgValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetOnlineUserNumRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetRecommandTextByEmotionRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetTextValidStatusRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterRspItem;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class CameraPeakServiceHandler extends CameraDataServiceHandler {

    /* renamed from: m, reason: collision with root package name */
    private static final String f63467m = "CameraPeakServiceHandler";

    /* renamed from: i, reason: collision with root package name */
    public AppInterface f63468i;

    public CameraPeakServiceHandler(AppInterface appInterface) {
        super(appInterface);
        this.f63468i = appInterface;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
    
        if (r14.isRecycled() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
    
        r14.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0132, code lost:
    
        com.tencent.mobileqq.utils.BaseImageUtil.compressImagetoSize(r13, r2, r1, r4, r5);
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0136, code lost:
    
        r0 = new java.io.File(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0144, code lost:
    
        if (r0.length() <= com.tencent.mobileqq.app.face.FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0146, code lost:
    
        r7 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x014a, code lost:
    
        if (r14 >= 10) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x014c, code lost:
    
        r4 = (int) (r4 * 0.8d);
        r5 = (int) (r5 * 0.8d);
        com.tencent.mobileqq.utils.BaseImageUtil.compressImagetoSize(r13, r2, r1, java.lang.Math.max(100, r4), java.lang.Math.max(100, r5));
        r14 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x016a, code lost:
    
        if (r0.length() <= com.tencent.mobileqq.app.face.FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x016c, code lost:
    
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x016d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012e, code lost:
    
        if (r14.isRecycled() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ec, code lost:
    
        if (r14.isRecycled() != false) goto L51;
     */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x016f: MOVE (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:61:0x016f */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0172 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b3(Context context, Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        OutOfMemoryError e16;
        Exception e17;
        OutputStream outputStream;
        File file = new File(g.a.C0559a.f65248b);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(file.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(System.currentTimeMillis());
        sb5.append(".jpg");
        String sb6 = sb5.toString();
        String str2 = file.getPath() + str + System.currentTimeMillis() + ".jpg";
        if (bitmap == null) {
            return "";
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > 250) {
            height = 250;
        }
        if (width > 250) {
            width = 250;
        }
        OutputStream outputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FileUtils.createFile(sb6)));
            } catch (Exception e18) {
                bufferedOutputStream = null;
                e17 = e18;
            } catch (OutOfMemoryError e19) {
                bufferedOutputStream = null;
                e16 = e19;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream2 != null) {
                }
                if (bitmap.isRecycled()) {
                }
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                try {
                    bufferedOutputStream.close();
                } catch (Exception e26) {
                    ms.a.c(f63467m, "compress error: " + e26.toString());
                }
            } catch (Exception e27) {
                e17 = e27;
                ms.a.c(f63467m, "compress error: " + e17.toString());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e28) {
                        ms.a.c(f63467m, "compress error: " + e28.toString());
                    }
                }
            } catch (OutOfMemoryError e29) {
                e16 = e29;
                ms.a.c(f63467m, "compress error: " + e16.toString());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e36) {
                        ms.a.c(f63467m, "compress error: " + e36.toString());
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e37) {
                    ms.a.c(f63467m, "compress error: " + e37.toString());
                }
            }
            if (bitmap.isRecycled()) {
                bitmap.recycle();
                throw th;
            }
            throw th;
        }
    }

    private void f3(FromServiceMsg fromServiceMsg, Object obj) {
        GetImgValidStatusRsp getImgValidStatusRsp = (GetImgValidStatusRsp) obj;
        int i3 = (fromServiceMsg == null || !fromServiceMsg.isSuccess() || getImgValidStatusRsp == null) ? -2 : getImgValidStatusRsp.ValidStatus;
        if (fromServiceMsg != null && getImgValidStatusRsp != null) {
            com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_FACE_DETECT) ? this.f63466e.get(AECameraConstants.CMD_FACE_DETECT).longValue() : 0L)), AECameraConstants.CMD_FACE_DETECT, getImgValidStatusRsp.Code);
        }
        notifyUI(5, fromServiceMsg != null && fromServiceMsg.isSuccess(), Integer.valueOf(i3));
    }

    private void g3(FromServiceMsg fromServiceMsg, Object obj) {
        notifyUI(4, fromServiceMsg.isSuccess(), obj);
        if (!fromServiceMsg.isSuccess()) {
            QLog.e(f63467m, 2, "getFont fail: " + fromServiceMsg);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(MobileQQ.sMobileQQ, R.string.y6a, 1).show();
                }
            });
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_GET_FONT_DATA) ? this.f63466e.get(AECameraConstants.CMD_GET_FONT_DATA).longValue() : 0L)), AECameraConstants.CMD_GET_FONT_DATA, ((GetFontDataRsp) obj).Code);
    }

    private void h3(FromServiceMsg fromServiceMsg, Object obj) {
        GetOnlineUserNumRsp getOnlineUserNumRsp = (GetOnlineUserNumRsp) obj;
        if (fromServiceMsg.isSuccess()) {
            notifyUI(3, true, Integer.valueOf(getOnlineUserNumRsp.OnlineUserNum));
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_QQ_ONLINE_NUMBER) ? this.f63466e.get(AECameraConstants.CMD_QQ_ONLINE_NUMBER).longValue() : 0L)), AECameraConstants.CMD_QQ_ONLINE_NUMBER, getOnlineUserNumRsp.Code);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.json.JSONObject] */
    private void i3(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        ?? r36;
        ArrayList<String> arrayList = new ArrayList<>();
        String str = null;
        GetRecommandTextByEmotionRsp getRecommandTextByEmotionRsp = obj instanceof GetRecommandTextByEmotionRsp ? (GetRecommandTextByEmotionRsp) obj : null;
        if (fromServiceMsg == null || !fromServiceMsg.isSuccess() || getRecommandTextByEmotionRsp == null) {
            z16 = false;
            r36 = 0;
        } else {
            arrayList = getRecommandTextByEmotionRsp.RecTexts;
            String str2 = getRecommandTextByEmotionRsp.Emo;
            try {
                str = new JSONObject(getRecommandTextByEmotionRsp.UiNumConfig);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            z16 = true;
            r36 = str;
            str = str2;
        }
        if (fromServiceMsg != null && getRecommandTextByEmotionRsp != null) {
            com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_EMOTION) ? this.f63466e.get(AECameraConstants.CMD_EMOTION).longValue() : 0L)), AECameraConstants.CMD_EMOTION, getRecommandTextByEmotionRsp.Code);
        }
        notifyUI(1, z16, new com.tencent.aelight.camera.ae.gif.c(arrayList, str, r36));
    }

    private void j3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        GetBulkImageClassifyRsp getBulkImageClassifyRsp = (GetBulkImageClassifyRsp) obj;
        if (fromServiceMsg.isSuccess()) {
            if (getBulkImageClassifyRsp != null && getBulkImageClassifyRsp.MiltiRsps != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<SmartFilterRspItem> it = getBulkImageClassifyRsp.MiltiRsps.iterator();
                while (it.hasNext()) {
                    SmartFilterRspItem next = it.next();
                    arrayList.add(new com.tencent.aelight.camera.aeeditor.module.aifilter.b(next.PituLabel, next.DisplayLabels));
                }
                com.tencent.aelight.camera.aeeditor.module.aifilter.a.a().c(arrayList, toServiceMsg.hashCode());
            }
        } else if (1002 == fromServiceMsg.getResultCode()) {
            com.tencent.aelight.camera.aeeditor.module.aifilter.a.a().b(-6, toServiceMsg.hashCode());
        } else {
            com.tencent.aelight.camera.aeeditor.module.aifilter.a.a().b(-1, toServiceMsg.hashCode());
        }
        com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_SMART_FILTER) ? this.f63466e.get(AECameraConstants.CMD_SMART_FILTER).longValue() : 0L)), AECameraConstants.CMD_SMART_FILTER, 0);
    }

    private void k3(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        GetTextValidStatusRsp getTextValidStatusRsp = (GetTextValidStatusRsp) obj;
        if (fromServiceMsg == null || !fromServiceMsg.isSuccess() || getTextValidStatusRsp == null) {
            z16 = false;
        } else {
            z16 = getTextValidStatusRsp.ValidStatus == 0;
            r0 = true;
        }
        if (fromServiceMsg != null && getTextValidStatusRsp != null) {
            com.tencent.aelight.camera.ae.report.b.b().w(fromServiceMsg.getResultCode(), String.valueOf(System.currentTimeMillis() - (this.f63466e.containsKey(AECameraConstants.CMD_TEXT_VALID) ? this.f63466e.get(AECameraConstants.CMD_TEXT_VALID).longValue() : 0L)), AECameraConstants.CMD_TEXT_VALID, getTextValidStatusRsp.Code);
        }
        notifyUI(2, r0, Boolean.valueOf(z16));
    }

    private void l3(FromServiceMsg fromServiceMsg, Object obj) {
        notifyUI(6, fromServiceMsg.isSuccess(), obj);
        if (fromServiceMsg.isSuccess()) {
            return;
        }
        QLog.e(f63467m, 2, "get watermark location failed: " + fromServiceMsg);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler.4
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(MobileQQ.sMobileQQ, R.string.y6a, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m3(String str, PTFaceAttr pTFaceAttr) {
        FaceChangeUtils.cropFace(c3(str), pTFaceAttr, new b(new ToServiceMsg("ShadowBackendSvc", this.f63468i.getCurrentAccountUin(), AECameraConstants.CMD_FACE_DETECT)), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(ToServiceMsg toServiceMsg, String str) {
        Bitmap decodeFile = SafeBitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            Bundle bundle = toServiceMsg.extraData;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            bundle.putByteArray("Rawdata", byteArrayOutputStream.toByteArray());
        }
        send(toServiceMsg);
    }

    @Override // com.tencent.aelight.camera.ae.config.CameraDataServiceHandler
    protected void H2(FromServiceMsg fromServiceMsg, Object obj) {
        super.H2(fromServiceMsg, obj);
    }

    public void o3() {
        if (!NetworkUtil.isNetworkAvailable()) {
            LogUtils.w("111", "[reqOnlineUserNum] no network....");
        } else {
            this.f63466e.put(AECameraConstants.CMD_QQ_ONLINE_NUMBER, Long.valueOf(System.currentTimeMillis()));
            send(new ToServiceMsg("ShadowBackendSvc", this.f63468i.getCurrentAccountUin(), AECameraConstants.CMD_QQ_ONLINE_NUMBER));
        }
    }

    @Override // com.tencent.aelight.camera.ae.config.CameraDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return g.class;
    }

    @Override // com.tencent.aelight.camera.ae.config.CameraDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_EMOTION)) {
            i3(fromServiceMsg, obj);
        } else if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_TEXT_VALID)) {
            k3(fromServiceMsg, obj);
        } else {
            if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_CAMERA_CONFIG)) {
                H2(fromServiceMsg, obj);
                return;
            }
            if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_QQ_ONLINE_NUMBER)) {
                h3(fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equals(AECameraConstants.CMD_GET_FONT_DATA)) {
                g3(fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_FACE_DETECT)) {
                f3(fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_SMART_FILTER)) {
                j3(toServiceMsg, fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_WATERMARK_LOCATION)) {
                l3(fromServiceMsg, obj);
            } else if (fromServiceMsg.getServiceCmd().equalsIgnoreCase(AECameraConstants.CMD_CAMERA_PROPERTY_AI)) {
                d3(fromServiceMsg, obj);
            }
        }
        super.onReceive(toServiceMsg, fromServiceMsg, obj);
    }

    public void p3(Bitmap bitmap) {
        if (!NetworkUtil.isNetworkAvailable()) {
            LogUtils.w("111", "[reqRecommandTextByEmotion] no network....");
            i3(null, null);
            return;
        }
        this.f63466e.put(AECameraConstants.CMD_EMOTION, Long.valueOf(System.currentTimeMillis()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.f63468i.getCurrentAccountUin(), AECameraConstants.CMD_EMOTION);
        if (bitmap != null) {
            Bundle bundle = toServiceMsg.extraData;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            bundle.putByteArray("Rawdata", byteArrayOutputStream.toByteArray());
        }
        send(toServiceMsg);
    }

    public void q3(String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            LogUtils.w("111", "[reqTextValidStatus] no network....");
            k3(null, null);
        } else {
            this.f63466e.put(AECameraConstants.CMD_TEXT_VALID, Long.valueOf(System.currentTimeMillis()));
            ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.f63468i.getCurrentAccountUin(), AECameraConstants.CMD_TEXT_VALID);
            toServiceMsg.extraData.putString(AECameraConstants.REQ_FIELD_TEXT, str);
            send(toServiceMsg);
        }
    }

    public void r3(String str) {
        this.f63466e.put(AECameraConstants.CMD_FACE_DETECT, Long.valueOf(System.currentTimeMillis()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.f63468i.getCurrentAccountUin(), AECameraConstants.CMD_FACE_DETECT);
        String detectFacePath = AETakeFacePhotoPreviewFragment.getDetectFacePath();
        if (detectFacePath != null && detectFacePath.length() > 0) {
            n3(toServiceMsg, detectFacePath);
        } else {
            FaceChangeUtils.cropFace(c3(str), new a(toServiceMsg));
        }
    }

    public void s3(final String str, final PTFaceAttr pTFaceAttr) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.config.f
            @Override // java.lang.Runnable
            public final void run() {
                CameraPeakServiceHandler.this.m3(str, pTFaceAttr);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements FaceChangeUtils.CropFaceCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f63469a;

        a(ToServiceMsg toServiceMsg) {
            this.f63469a = toServiceMsg;
        }

        @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
        public void onFail(int i3) {
            CameraPeakServiceHandler.this.e3();
        }

        @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
        public void onSuccess(Bitmap bitmap) {
            if (bitmap == null) {
                CameraPeakServiceHandler.this.e3();
                return;
            }
            String b36 = CameraPeakServiceHandler.b3(CameraPeakServiceHandler.this.f63468i.getApp(), bitmap);
            if (b36 == null || b36.length() < 1) {
                CameraPeakServiceHandler.this.e3();
            } else {
                CameraPeakServiceHandler.this.n3(this.f63469a, b36);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements FaceChangeUtils.CropFaceCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f63471a;

        b(ToServiceMsg toServiceMsg) {
            this.f63471a = toServiceMsg;
        }

        @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
        public void onFail(int i3) {
            CameraPeakServiceHandler.this.e3();
        }

        @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
        public void onSuccess(Bitmap bitmap) {
            if (bitmap == null) {
                CameraPeakServiceHandler.this.e3();
                return;
            }
            String b36 = CameraPeakServiceHandler.b3(CameraPeakServiceHandler.this.f63468i.getApp(), bitmap);
            if (b36 == null || b36.length() < 1) {
                CameraPeakServiceHandler.this.e3();
            } else {
                CameraPeakServiceHandler.this.n3(this.f63471a, b36);
            }
        }
    }

    public static Bitmap c3(String str) {
        int i3;
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i16 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i17 = options.outWidth;
            if (i17 > 0 && (i3 = options.outHeight) > 0) {
                int max = Math.max(i17, i3);
                while (true) {
                    int i18 = i16 * 2;
                    if (max / i18 <= 512) {
                        break;
                    }
                    i16 = i18;
                }
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i16;
            bitmap = SafeBitmapFactory.decodeFile(str, options2);
            int exifOrientation = BaseImageUtil.getExifOrientation(str);
            if (exifOrientation != 0) {
                Matrix matrix = new Matrix();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
        } catch (Exception e16) {
            ms.a.e(f63467m, e16);
        }
        return bitmap != null ? bitmap : SafeBitmapFactory.decodeFile(str);
    }

    private void d3(FromServiceMsg fromServiceMsg, Object obj) {
        notifyUI(7, fromServiceMsg.isSuccess(), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3() {
        notifyUI(5, false, -100);
    }
}
