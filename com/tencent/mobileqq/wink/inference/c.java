package com.tencent.mobileqq.wink.inference;

import android.content.SharedPreferences;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uq3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/inference/c;", "Lcom/tencent/biz/richframework/download/RFWDownloadStrategy;", "", "getBusinessKey", "getDownloadRootPath", "Landroid/content/SharedPreferences;", "getSP", "", "supportUnZipFile", "supportBreakPointDownload", "allowGeneratedNoMedia", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c extends RFWDownloadStrategy {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f322985a = new c();

    c() {
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean allowGeneratedNoMedia() {
        return false;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    @NotNull
    public String getBusinessKey() {
        return "wink_inference_download_strategy";
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    @NotNull
    public String getDownloadRootPath() {
        return b.INFERENCE_MODEL_DOWNLOAD_PATH;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    @NotNull
    public SharedPreferences getSP() {
        SharedPreferences c16 = g.c(false, true);
        Intrinsics.checkNotNullExpressionValue(c16, "getQCircleSp(false, true)");
        return c16;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportBreakPointDownload() {
        return true;
    }

    @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
    public boolean supportUnZipFile() {
        return true;
    }
}
