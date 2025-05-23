package com.tencent.mobileqq.colornote.list;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.HttpDownloader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j extends HttpDownloader {
    @Override // com.tencent.mobileqq.transfile.HttpDownloader, com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        try {
            String str = "";
            HttpResponse openRequest = HttpUtil.openRequest(BaseApplicationImpl.getApplication(), String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", BaseApplicationImpl.getApplication().getRuntime().getAccount(), downloadParams.url.getHost()), null, "GET", null, null, 5000, 5000);
            if (openRequest != null && openRequest.getStatusLine().getStatusCode() == 200) {
                str = HttpUtil.readHttpResponse(openRequest);
            }
            JSONObject jSONObject = new JSONObject(str);
            if (Integer.parseInt(jSONObject.getString("ret")) == 0) {
                String string = jSONObject.getString("thumbUrl");
                downloadParams.url = new URL(string);
                downloadParams.urlStr = string;
                return super.downloadImage(outputStream, downloadParams, uRLDrawableHandler);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return super.downloadImage(outputStream, downloadParams, uRLDrawableHandler);
    }
}
