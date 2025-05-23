package com.tencent.mobileqq.vas.social.record;

import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.social.SocialActionRecordHelper;
import com.tencent.mobileqq.vas.social.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.data.RecordSource;
import com.tencent.zplan.meme.action.MODE;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/RecordStepUpload;", "Lcom/tencent/mobileqq/vas/social/record/b;", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "k", "Lcom/tencent/zplan/meme/action/MODE;", UserInfo.SEX_FEMALE, "Lcom/tencent/zplan/meme/action/MODE;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/mobileqq/vas/social/v;", "G", "Lcom/tencent/mobileqq/vas/social/v;", "uploadHelper", "Lcom/tencent/mobileqq/vas/social/v$b;", "H", "Lcom/tencent/mobileqq/vas/social/v$b;", "uploadHandler", "Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", "Lcom/tencent/mobileqq/vas/social/record/c;", "listener", "<init>", "(Lcom/tencent/mobileqq/vas/data/b;Lcom/tencent/zplan/meme/action/MODE;Lcom/tencent/mobileqq/vas/social/record/c;)V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RecordStepUpload extends b {

    /* renamed from: F, reason: from kotlin metadata */
    private final MODE mode;

    /* renamed from: G, reason: from kotlin metadata */
    private final v uploadHelper;

    /* renamed from: H, reason: from kotlin metadata */
    private final v.b uploadHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordStepUpload(final com.tencent.mobileqq.vas.data.b taskInfo, MODE mode, final c cVar) {
        super(taskInfo, RecordState.RECORDED, cVar);
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this.uploadHelper = new v();
        this.uploadHandler = new v.b(new Function3<TransProcessorHandler, Integer, FileMsg, Unit>() { // from class: com.tencent.mobileqq.vas.social.record.RecordStepUpload$uploadHandler$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes35.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f310803a;

                static {
                    int[] iArr = new int[MODE.values().length];
                    try {
                        iArr[MODE.MP4.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MODE.FRAME.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f310803a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(TransProcessorHandler transProcessorHandler, Integer num, FileMsg fileMsg) {
                invoke(transProcessorHandler, num.intValue(), fileMsg);
                return Unit.INSTANCE;
            }

            public final void invoke(TransProcessorHandler handler, int i3, FileMsg fileMsg) {
                v vVar;
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(fileMsg, "fileMsg");
                boolean z16 = i3 == 1003 || i3 == 1008;
                if (!z16) {
                    if (i3 == 1005) {
                        QLog.d("RecordStepUpload", 1, "upload handle error");
                        return;
                    }
                    return;
                }
                try {
                    String str = fileMsg.stepTrans.extraInfo.get("actionId");
                    Intrinsics.checkNotNull(str);
                    int parseInt = Integer.parseInt(str);
                    String str2 = fileMsg.stepTrans.extraInfo.get("type");
                    Intrinsics.checkNotNull(str2);
                    int parseInt2 = Integer.parseInt(str2);
                    String str3 = fileMsg.stepTrans.extraInfo.get(IECDtReport.ACTION_IDENTIFIER);
                    Intrinsics.checkNotNull(str3);
                    String str4 = str3;
                    if (parseInt == com.tencent.mobileqq.vas.data.b.this.getActionId() && Intrinsics.areEqual(str4, com.tencent.mobileqq.vas.data.b.this.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().key()) && this.getMode() == SocialActionRecordHelper.f310651d.q(parseInt2)) {
                        vVar = this.uploadHelper;
                        vVar.c(handler);
                        Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                        String str5 = fileMsg.fileMd5;
                        Intrinsics.checkNotNullExpressionValue(str5, "fileMsg.fileMd5");
                        String lowerCase = str5.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                        String str6 = null;
                        try {
                            byte[] bArr = fileMsg.bdhExtendInfo;
                            uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
                            String stringUtf8 = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                            String old = new URL(stringUtf8).getHost();
                            Intrinsics.checkNotNullExpressionValue(old, "old");
                            str6 = StringsKt__StringsJVMKt.replaceFirst$default(stringUtf8, old, "img.meta.qq.com", false, 4, (Object) null);
                            if (QLog.isColorLevel()) {
                                QLog.d("RecordStepUpload", 2, "upload handle what:" + i3 + "\uff0cactionId:" + parseInt + ", mode:" + this.getMode() + ", md5:" + lowerCase + ", url:" + str6);
                            }
                        } catch (Exception e16) {
                            c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.onError(-2, "upload handler throw: " + e16);
                            }
                            QLog.e("RecordStepUpload", 2, "upload handler throw:", e16);
                        }
                        if (z16 && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(lowerCase)) {
                            QLog.d("RecordStepUpload", 1, "[RECORD] 5-2.2 handle receiver upload rsp: uin:" + com.tencent.mobileqq.vas.data.b.this.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String() + ", actionId:" + com.tencent.mobileqq.vas.data.b.this.getActionId() + ", mode:" + this.getMode().name());
                            try {
                                Intrinsics.checkNotNull(str6);
                                RecordSource recordSource = new RecordSource(str6, lowerCase);
                                int i16 = a.f310803a[this.getMode().ordinal()];
                                if (i16 == 1) {
                                    this.getStepProduct().j(recordSource);
                                } else {
                                    if (i16 != 2) {
                                        c cVar3 = cVar;
                                        if (cVar3 != null) {
                                            cVar3.onError(-9, "upload done but mode not support");
                                            return;
                                        }
                                        return;
                                    }
                                    this.getStepProduct().i(recordSource);
                                }
                                if (this.getStepProduct().getExtra() == null) {
                                    this.getStepProduct().f(new Bundle());
                                }
                                Bundle extra = this.getStepProduct().getExtra();
                                Intrinsics.checkNotNull(extra);
                                extra.putString("upload_mode", this.getMode().name());
                                this.n();
                                return;
                            } catch (Exception e17) {
                                c cVar4 = cVar;
                                if (cVar4 != null) {
                                    cVar4.onError(-3, "notifyUpload throw: " + e17);
                                }
                                QLog.e("RecordStepUpload", 1, "notifyUpload throw:", e17);
                                return;
                            }
                        }
                        c cVar5 = cVar;
                        if (cVar5 != null) {
                            cVar5.onError(-4, "url error:" + str6);
                        }
                    }
                } catch (Exception e18) {
                    QLog.e("RecordStepUpload", 1, "notifyUpload throw:", e18);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.social.record.b
    public void k(RecordStepProduct product) {
        c listener;
        Intrinsics.checkNotNullParameter(product, "product");
        if (!getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getNeedUpload()) {
            QLog.d("RecordStepUpload", 1, "[RECORD] 5-2.0 handle task no need upload, info:" + getTaskInfo() + ", product:" + product);
            n();
            return;
        }
        if (this.uploadHelper.d(getTaskInfo().getActionId(), product, getTaskInfo().getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String(), this.mode, this.uploadHandler) || (listener = getListener()) == null) {
            return;
        }
        listener.onError(-10, "uploader init error");
    }

    /* renamed from: s, reason: from getter */
    public final MODE getMode() {
        return this.mode;
    }
}
