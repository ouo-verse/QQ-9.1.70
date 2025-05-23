package com.tencent.ecommerce.biz.comment;

import com.tencent.ecommerce.base.device.ECNetworkManager;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/ECBatchUploaderReporter;", "Lcom/tencent/ecommerce/biz/comment/IUploadReporter;", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "mediaInfo", "", QzoneIPCModule.RESULT_CODE, "", "duration", "errCode", "", "reportFileUploadResult", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBatchUploaderReporter implements IUploadReporter {

    /* renamed from: a, reason: collision with root package name */
    public static final ECBatchUploaderReporter f101368a = new ECBatchUploaderReporter();

    ECBatchUploaderReporter() {
    }

    @Override // com.tencent.ecommerce.biz.comment.IUploadReporter
    public void reportFileUploadResult(final ECMediaInfo mediaInfo, final int resultCode, final long duration, final int errCode) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.comment.ECBatchUploaderReporter$reportFileUploadResult$1
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
                IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_quality_upload_state", new com.tencent.ecommerce.biz.common.e().b("result_code", String.valueOf(resultCode)).b("file_size", String.valueOf(mediaInfo.getFileSizeByte())).b("duration", String.valueOf(duration)).b(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, ECNetworkManager.f100683a.a().value).b("error_code", String.valueOf(errCode)).f(), false, 4, null);
            }
        });
    }
}
