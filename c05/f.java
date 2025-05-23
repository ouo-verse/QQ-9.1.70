package c05;

import android.net.http.Headers;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class f {
    @WorkerThread
    public static String a(String str, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (sb5.length() != 0) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(map.get(str2));
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(sb5.length()));
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(8000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(sb5.toString());
            printWriter.flush();
            printWriter.close();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder sb6 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb6.append(readLine);
                    } else {
                        bufferedReader.close();
                        inputStream.close();
                        String sb7 = sb6.toString();
                        httpURLConnection.disconnect();
                        return sb7;
                    }
                }
            } else {
                httpURLConnection.disconnect();
                throw new com.xingin.xhssharesdk.l.b(httpURLConnection.getResponseCode());
            }
        } else {
            throw new com.xingin.xhssharesdk.l.c();
        }
    }
}
