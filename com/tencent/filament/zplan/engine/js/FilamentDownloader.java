package com.tencent.filament.zplan.engine.js;

import androidx.annotation.Keep;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import dl0.b;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J=\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0082 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/engine/js/FilamentDownloader;", "", "()V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Ljava/util/concurrent/atomic/AtomicInteger;", "download", "", "url", "", "callbackPtr", "", "nOnDownloadComplete", "", "path", "isSuccess", "", "errorMsg", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentDownloader {

    @NotNull
    public static final FilamentDownloader INSTANCE = new FilamentDownloader();
    private static final AtomicInteger taskId = new AtomicInteger(0);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/engine/js/FilamentDownloader$a", "Lgl0/a;", "", "errorMsg", "", "b", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class a implements gl0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f105764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f105765b;

        a(long j3, int i3) {
            this.f105764a = j3;
            this.f105765b = i3;
        }

        @Override // gl0.a
        public void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
            FilamentDownloader.INSTANCE.nOnDownloadComplete(this.f105764a, filePath, true, null, statusCode, this.f105765b);
        }

        @Override // gl0.a
        public void b(@NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            FilamentDownloader.INSTANCE.nOnDownloadComplete(this.f105764a, null, false, errorMsg, 0, this.f105765b);
        }
    }

    FilamentDownloader() {
    }

    @JvmStatic
    @NativeMethodProxy
    public static final int download(@NotNull String url, long callbackPtr) {
        Intrinsics.checkNotNullParameter(url, "url");
        int andAdd = taskId.getAndAdd(1);
        b bVar = (b) fl0.a.f399763a.a(b.class);
        if (bVar != null) {
            bVar.a(url, null, new a(callbackPtr, andAdd));
        } else {
            INSTANCE.nOnDownloadComplete(callbackPtr, null, false, "download not support", 0, andAdd);
        }
        return andAdd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nOnDownloadComplete(long callbackPtr, String path, boolean isSuccess, String errorMsg, int statusCode, int taskId2);
}
