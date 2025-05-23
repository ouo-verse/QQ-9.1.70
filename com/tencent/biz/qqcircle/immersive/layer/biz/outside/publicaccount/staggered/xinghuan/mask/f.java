package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask;

import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/xinghuan/mask/f;", "", "", "filePath", "", "a", "Lcom/tencent/biz/richframework/download/RFWDownloader;", "c", "downloadUrl", "d", "cachedAdStr", "", "Lorg/json/JSONObject;", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f87155a = new f();

    f() {
    }

    public final boolean a(@Nullable String filePath) {
        boolean z16;
        boolean z17 = false;
        if (filePath != null && filePath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        File file = new File(filePath);
        if (file.exists() && file.length() > 0) {
            z17 = true;
        }
        QLog.d("QFSPublicAccountXingHuanAdMaskDownloadHelper", 1, "file path is " + filePath + " exit is " + z17);
        return z17;
    }

    @NotNull
    public final List<JSONObject> b(@NotNull String cachedAdStr) {
        Intrinsics.checkNotNullParameter(cachedAdStr, "cachedAdStr");
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(cachedAdStr);
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "cachedAdJson.keys()");
            while (keys.hasNext()) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(String.valueOf(keys.next()), ""));
                String d16 = d(j.f(jSONObject2));
                if (a(d16)) {
                    jSONObject2.put("pag_res_path", d16);
                }
                String d17 = d(j.d(jSONObject2));
                if (a(d17)) {
                    jSONObject2.put("cover_res_path", d17);
                }
                String d18 = d(j.b(jSONObject2));
                if (a(d18)) {
                    jSONObject2.put("entry_res_path", d18);
                }
                arrayList.add(jSONObject2);
            }
            return arrayList;
        } catch (Throwable th5) {
            QLog.e("QFSPublicAccountXingHuanAdMaskDownloadHelper", 1, "getReadyAdJson failed, error is ", th5);
            return arrayList;
        }
    }

    @NotNull
    public final RFWDownloader c() {
        RFWDownloader downloader = RFWDownloaderFactory.getDownloader(vq3.a.a());
        Intrinsics.checkNotNullExpressionValue(downloader, "getDownloader(QCircleDow\u2026ig.getDownloadStrategy())");
        return downloader;
    }

    @NotNull
    public final String d(@Nullable String downloadUrl) {
        String defaultSavePath = RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(downloadUrl);
        Intrinsics.checkNotNullExpressionValue(defaultSavePath, "getDownloader(QCircleDow\u2026aultSavePath(downloadUrl)");
        return defaultSavePath;
    }
}
