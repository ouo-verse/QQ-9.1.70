package com.tencent.mobileqq.zplan.download;

import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/SourceDownloadUtils;", "Lcom/tencent/mobileqq/zplan/download/api/ISourceDownloadHelper;", "()V", "downloadSource", "", "sourceUrl", "", "category", "", "getFileByUrl", "getFilePath", "isSourceExit", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class SourceDownloadUtils implements ISourceDownloadHelper {
    public static final SourceDownloadUtils INSTANCE = new SourceDownloadUtils();

    SourceDownloadUtils() {
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public void downloadSource(final String sourceUrl, final int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.download.SourceDownloadUtils$downloadSource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b.f332804a.a(category).a(sourceUrl);
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public void getFileByUrl(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        b.f332804a.a(category).b(sourceUrl);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public void getFilePath(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        b.f332804a.a(category).getFilePath(sourceUrl);
    }

    @Override // com.tencent.mobileqq.zplan.download.api.ISourceDownloadHelper
    public String isSourceExit(String sourceUrl, int category) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        return b.f332804a.a(category).c(sourceUrl);
    }
}
