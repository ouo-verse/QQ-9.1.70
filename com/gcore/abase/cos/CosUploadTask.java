package com.gcore.abase.cos;

import android.net.http.Headers;
import androidx.core.app.NotificationCompat;
import com.gcore.abase.log.XLog;
import com.gcore.abase.utils.FileUtils;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.UUID;
import org.apache.http.client.methods.HttpPut;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CosUploadTask implements Runnable {
    private static final String TAG = "GCloud.CosUploadTask";
    private CosResultListener mResultListener = null;
    private String mUploadid = null;
    private String mFilePath = null;
    private long mPartSize = 0;
    private String mComParams = null;
    private long mNextPos = 0;
    private String mNextUrl = "";
    private String mUploadUrl = "";

    private int prepareFile(String str, String str2, String str3, Credential credential) {
        HttpURLConnection httpURLConnection;
        String fileToSHA1 = FileUtils.fileToSHA1(str);
        long length = new File(str).length();
        InputStream inputStream = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("upload_id", str3);
            jSONObject.put("total_size", length);
            jSONObject.put("total_sha1", fileToSHA1);
            String str4 = "com_params=" + URLEncoder.encode(str2, "UTF-8") + "&biz_params=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
            String str5 = this.mUploadUrl + "/upload/prepareFile?" + str4;
            XLog.i("GCloud", "preparefile url is " + URLDecoder.decode(str5, "UTF-8"));
            httpURLConnection = (HttpURLConnection) new URL(str5).openConnection();
        } catch (Exception e16) {
            e16.printStackTrace();
            XLog.e(TAG, "prepareFile excepiton " + e16.getMessage());
            httpURLConnection = null;
        }
        int i3 = -1;
        if (httpURLConnection == null) {
            return -1;
        }
        try {
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                inputStream = httpURLConnection.getInputStream();
                String readStreamToString = FileUtils.readStreamToString(inputStream);
                XLog.i(TAG, readStreamToString);
                JSONObject jSONObject2 = new JSONObject(readStreamToString);
                int i16 = jSONObject2.getInt("ret");
                String optString = jSONObject2.optString(NotificationCompat.CATEGORY_ERROR);
                if (i16 == 0) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("biz_data");
                    String string = jSONObject3.getString(QZoneAdTianshuFeedData.KEY_SOURCE_URL);
                    Long valueOf = Long.valueOf(jSONObject3.getLong("next_pos"));
                    credential.uploadUrl = string;
                    credential.nextPos = valueOf.longValue();
                    i3 = 0;
                } else if (i16 > 0) {
                    XLog.e(TAG, "prepareFile failed ret:" + i16 + ",err:" + optString);
                    i3 = 1;
                } else {
                    XLog.e(TAG, "prepareFile failed ret:" + i16 + ",err:" + optString);
                }
            } else {
                XLog.e(TAG, "http error code " + responseCode);
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            XLog.e(TAG, "prepareFile excepiton " + e17.getMessage());
        }
        try {
            httpURLConnection.disconnect();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        return i3;
    }

    private void uploadInner(String str, String str2) {
        int i3;
        Credential credential = new Credential();
        int prepareFile = prepareFile(str2, this.mComParams, str, credential);
        if (prepareFile == 0) {
            long j3 = credential.nextPos;
            String str3 = credential.uploadUrl;
            this.mNextPos = j3;
            this.mNextUrl = str3;
            long length = new File(this.mFilePath).length();
            while (true) {
                i3 = 0;
                boolean z16 = false;
                if (this.mNextPos >= length) {
                    break;
                }
                int i16 = 3;
                while (true) {
                    int i17 = i16 - 1;
                    if (i16 <= 0 || (z16 = uploadPart(this.mNextUrl, this.mNextPos))) {
                        break;
                    } else {
                        i16 = i17;
                    }
                }
                if (!z16) {
                    i3 = 3;
                    break;
                }
            }
            if (this.mNextPos >= length) {
                XLog.i(TAG, "upload file success!");
            }
        } else {
            i3 = 1;
            if (prepareFile != 1) {
                i3 = 2;
            }
        }
        CosResultListener cosResultListener = this.mResultListener;
        if (cosResultListener != null) {
            cosResultListener.onFinished(i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0288 A[Catch: Exception -> 0x0291, TryCatch #9 {Exception -> 0x0291, blocks: (B:34:0x0283, B:36:0x0288, B:38:0x028d), top: B:33:0x0283 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x028d A[Catch: Exception -> 0x0291, TRY_LEAVE, TryCatch #9 {Exception -> 0x0291, blocks: (B:34:0x0283, B:36:0x0288, B:38:0x028d), top: B:33:0x0283 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean uploadPart(String str, long j3) {
        HttpURLConnection httpURLConnection;
        RandomAccessFile randomAccessFile;
        boolean z16;
        OutputStream outputStream;
        InputStream inputStream;
        boolean z17;
        String name;
        String filePartToSHA1;
        String uuid = UUID.randomUUID().toString();
        try {
            XLog.i(TAG, "url is " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e16) {
            e16.printStackTrace();
            XLog.e(TAG, "prepareFile excepiton " + e16.getMessage());
            httpURLConnection = null;
        }
        if (httpURLConnection == null) {
            return false;
        }
        try {
            try {
                httpURLConnection.setReadTimeout(100000);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
                httpURLConnection.setRequestProperty("Accept", "*/*");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                name = new File(this.mFilePath).getName();
                filePartToSHA1 = FileUtils.filePartToSHA1(this.mFilePath, j3, this.mPartSize);
                outputStream = httpURLConnection.getOutputStream();
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
            }
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--" + uuid + "\r\n");
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Content-Disposition: form-data; name=\"part_sha1\"");
                sb5.append("\r\n");
                stringBuffer.append(sb5.toString());
                stringBuffer.append("\r\n");
                stringBuffer.append(filePartToSHA1 + "\r\n");
                stringBuffer.append("--" + uuid + "\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"myfile\"; filename=\"" + name + "\"\r\n");
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Content-Type: application/octet-stream");
                sb6.append("\r\n");
                stringBuffer.append(sb6.toString());
                stringBuffer.append("\r\n");
                dataOutputStream.write(stringBuffer.toString().getBytes(Charset.forName("UTF-8")));
                randomAccessFile = new RandomAccessFile(this.mFilePath, "r");
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        randomAccessFile.seek(j3);
                        for (int i3 = 0; i3 < this.mPartSize / 1024; i3++) {
                            try {
                                int read = randomAccessFile.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                z16 = false;
                                try {
                                    dataOutputStream.write(bArr, 0, read);
                                } catch (Exception e17) {
                                    e = e17;
                                    inputStream = null;
                                    e.printStackTrace();
                                    XLog.e(TAG, "uploadPart excepiton " + e.getMessage());
                                    FileUtils.closeQuietly(randomAccessFile);
                                    z17 = z16;
                                    httpURLConnection.disconnect();
                                    if (outputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    return z17;
                                }
                            } catch (Exception e18) {
                                e = e18;
                                z16 = false;
                            }
                        }
                        z16 = false;
                        randomAccessFile.close();
                        dataOutputStream.write("\r\n".getBytes());
                        dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
                        dataOutputStream.flush();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            InputStream inputStream2 = httpURLConnection.getInputStream();
                            try {
                                String readStreamToString = FileUtils.readStreamToString(inputStream2);
                                XLog.i(TAG, "uploadPart response:" + readStreamToString);
                                JSONObject jSONObject = new JSONObject(readStreamToString);
                                int i16 = jSONObject.getInt("ret");
                                String optString = jSONObject.optString(NotificationCompat.CATEGORY_ERROR);
                                if (i16 == 0) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("biz_data");
                                    this.mNextPos = jSONObject2.getLong("next_pos");
                                    this.mNextUrl = jSONObject2.getString(QZoneAdTianshuFeedData.KEY_SOURCE_URL);
                                    z17 = true;
                                } else {
                                    XLog.e(TAG, "uploadpart error ret:" + i16 + ", errMsg:" + optString);
                                    z17 = false;
                                }
                                inputStream = inputStream2;
                            } catch (Exception e19) {
                                e = e19;
                                inputStream = inputStream2;
                                e.printStackTrace();
                                XLog.e(TAG, "uploadPart excepiton " + e.getMessage());
                                FileUtils.closeQuietly(randomAccessFile);
                                z17 = z16;
                                httpURLConnection.disconnect();
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                return z17;
                            }
                        } else {
                            XLog.e(TAG, "http error code : " + responseCode);
                            z17 = false;
                            inputStream = null;
                        }
                        FileUtils.closeQuietly(randomAccessFile);
                    } catch (Exception e26) {
                        e = e26;
                        z16 = false;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    FileUtils.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (Exception e27) {
                e = e27;
                z16 = false;
                randomAccessFile = null;
            }
        } catch (Exception e28) {
            e = e28;
            z16 = false;
            randomAccessFile = null;
            outputStream = null;
        }
        try {
            httpURLConnection.disconnect();
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
        return z17;
    }

    @Override // java.lang.Runnable
    public void run() {
        uploadInner(this.mUploadid, this.mFilePath);
    }

    public void setCredentialInfo(String str) {
        this.mComParams = str;
    }

    public void setResultListener(CosResultListener cosResultListener) {
        this.mResultListener = cosResultListener;
    }

    public void upload(String str, String str2, long j3, String str3) {
        this.mUploadid = str;
        this.mFilePath = str2;
        this.mPartSize = j3;
        this.mUploadUrl = str3;
        new BaseThread(this).start();
    }
}
