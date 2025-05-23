package com.tencent.av.avgesture;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCosUpload {
    static final String Appid = "";
    public static final String Bucket = "";
    private static final int MaxUploadCount = 5;
    private static final int MinUploadInterval = 3;
    static final String SecretID = "";
    static final String SecretKey = "";
    public static final String TAG = "";
    public static final int UPLOAD_FILE_ACCESSERROR = 8193;
    public static final int UPLOAD_NETWORK_FAIL = 8195;
    public static final int UPLOAD_SUCCESS = 0;
    private static AVCosUpload s_instance;
    static final ExecutorService singleThreadPool = ProxyExecutors.newSingleThreadExecutor();
    public boolean IsUploading = false;
    public boolean ShouldUpload = false;
    private Timer mUploadTimer;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface UploadFileListener {
        void onCompleted(int i3, String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class UploadTimerTask extends TimerTask {
        UploadTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AVCosUpload aVCosUpload = AVCosUpload.this;
            aVCosUpload.IsUploading = false;
            aVCosUpload.mUploadTimer.cancel();
        }
    }

    AVCosUpload() {
    }

    private static String ReadFile(String str) {
        File file = new File(str);
        String str2 = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str2 = str2 + readLine;
                        } catch (IOException e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str2;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                    bufferedReader2.close();
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (IOException unused2) {
        }
        return str2;
    }

    private static void WriteFile(String str, String str2) throws IOException {
        FileWriter fileWriter = new FileWriter(str);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write(str2);
        printWriter.println();
        fileWriter.close();
        printWriter.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cacheInputImageTo(String str, byte[] bArr, int i3, int i16) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static AVCosUpload createInstance() {
        if (s_instance == null) {
            synchronized (AVCosUpload.class) {
                if (s_instance == null) {
                    s_instance = new AVCosUpload();
                }
            }
        }
        return s_instance;
    }

    private String getParamString(Map<String, String> map, String str) {
        String str2 = "";
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str2 = ((str2 + "--" + str + "\r\n") + "Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n") + entry.getValue() + "\r\n";
            }
        }
        return str2;
    }

    private File openFile(String str) {
        if (str != null && !str.equals("")) {
            File file = new File(str);
            if (!file.exists()) {
                Log.e("", "checkFile| filePath is not exist. path=" + str);
                return null;
            }
            return file;
        }
        Log.e("", "checkFile| filePath == null.");
        return null;
    }

    private boolean shouldUpload(String str, String str2) {
        int i3;
        if (this.ShouldUpload && !this.IsUploading) {
            String str3 = str + "/av_cos_uploaded_count.json";
            File file = new File(str3);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str2, 1);
                    WriteFile(str3, jSONObject.toString());
                    return true;
                }
                String ReadFile = ReadFile(str3);
                if (!ReadFile.equals("")) {
                    JSONObject jSONObject2 = new JSONObject(ReadFile);
                    if (jSONObject2.has(str2)) {
                        i3 = jSONObject2.getInt(str2) + 1;
                    } else {
                        i3 = 1;
                    }
                    if (i3 < 5) {
                        jSONObject2.put(str2, i3);
                        WriteFile(str3, jSONObject2.toString());
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void startUploadTimer(int i3) {
        this.IsUploading = true;
        BaseTimer baseTimer = new BaseTimer();
        this.mUploadTimer = baseTimer;
        baseTimer.schedule(new UploadTimerTask(), i3 * 1000);
    }

    public void uploadFile(final String str, final String str2, final byte[] bArr, final int i3, final int i16, final UploadFileListener uploadFileListener) {
        if (!shouldUpload(str, str2)) {
            return;
        }
        singleThreadPool.execute(new Runnable() { // from class: com.tencent.av.avgesture.AVCosUpload.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str3 = str2 + "_" + new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date()) + "_" + UUID.randomUUID().toString() + ".jpeg";
                    String str4 = str + str3;
                    if (AVCosUpload.this.cacheInputImageTo(str4, bArr, i3, i16)) {
                        AVGestureWrapper.AVUploadReport aVUploadReport = AVGestureWrapper.mReport;
                        if (aVUploadReport != null) {
                            aVUploadReport.avGestureUploadReport(AVGestureWrapper.UPLOAD_REPORT_START, "0");
                        }
                        AVCosUpload.this.uploadFileImpl(str4, str2, str3, "", AVGestureWrapper.getMultiSign("", "", "", ""), 20971520, uploadFileListener);
                        AVCosUpload.this.startUploadTimer(3);
                    }
                } catch (Exception e16) {
                    Log.e("uploadFile", e16.toString());
                    uploadFileListener.onCompleted(8193, null, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFileImpl(String str, String str2, String str3, String str4, String str5, int i3, UploadFileListener uploadFileListener) {
    }
}
