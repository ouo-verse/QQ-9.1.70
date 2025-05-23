package org.libpag;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00c2: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:195), block:B:79:0x00c2 */
    public static byte[] a(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2;
        byte[] ReadFile = PAGDiskCache.ReadFile(str);
        if (ReadFile != null && ReadFile.length > 0) {
            return ReadFile;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream3 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode / 100 != 2) {
                        Log.e("NetworkFetcher", "Error: HTTP response code " + responseCode);
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        httpURLConnection.disconnect();
                        return null;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        PAGDiskCache.WriteFile(str, byteArray);
                        try {
                            inputStream.close();
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                        httpURLConnection.disconnect();
                        return byteArray;
                    } catch (IOException e19) {
                        e = e19;
                        Log.e("NetworkFetcher", "Error: " + e.getMessage());
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e26) {
                                e26.printStackTrace();
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e27) {
                            e27.printStackTrace();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (IOException e28) {
                    e = e28;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (Exception e29) {
                            e29.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e36) {
                        e36.printStackTrace();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                    throw th;
                }
            } catch (IOException e37) {
                e = e37;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream3 = inputStream2;
        }
    }
}
