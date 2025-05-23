package com.tencent.mobileqq.webview.html;

import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\bH&J\u001a\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\rH&J$\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0011H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0002H&J\b\u0010\u0015\u001a\u00020\u0002H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/webview/html/k;", "", "", "reqUrl", "Lcom/tencent/mobileqq/webview/html/m;", "sessionConfig", "Lcom/tencent/mobileqq/webview/html/SessionData;", "sessionData", "", "b", "", UploadQualityReportBuilder.STATE_CONNECT, "disconnect", "", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "key", "g", "d", "", "saveInputStream", "f", "e", "Ljava/io/InputStream;", "getInputStream", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface k {
    @NotNull
    HashMap<String, String> a();

    void b(@NotNull String reqUrl, @NotNull m sessionConfig, @Nullable SessionData sessionData) throws Exception;

    @NotNull
    Map<String, List<String>> c();

    int connect() throws IOException;

    @NotNull
    String d();

    void disconnect();

    @Nullable
    SessionData e();

    @Nullable
    String f(boolean saveInputStream) throws IOException;

    @Nullable
    String g(@NotNull String key);

    @Nullable
    InputStream getInputStream();
}
