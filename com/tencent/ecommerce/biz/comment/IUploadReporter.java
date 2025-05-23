package com.tencent.ecommerce.biz.comment;

import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/IUploadReporter;", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "mediaInfo", "", QzoneIPCModule.RESULT_CODE, "", "duration", "errCode", "", "reportFileUploadResult", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IUploadReporter {
    public static final int CANCELED = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f101410a;
    public static final int FAILED = 1;
    public static final int SUCCEED = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/IUploadReporter$a;", "", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.comment.IUploadReporter$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f101410a = new Companion();

        Companion() {
        }
    }

    void reportFileUploadResult(ECMediaInfo mediaInfo, int resultCode, long duration, int errCode);

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b {
        public static /* synthetic */ void a(IUploadReporter iUploadReporter, ECMediaInfo eCMediaInfo, int i3, long j3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    i16 = 0;
                }
                iUploadReporter.reportFileUploadResult(eCMediaInfo, i3, j3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportFileUploadResult");
        }
    }
}
