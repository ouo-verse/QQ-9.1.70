package com.tencent.mobileqq.vas.social.record;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.record.RecordType;
import com.tencent.zplan.meme.action.MODE;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/d;", "Lcom/tencent/mobileqq/vas/social/record/a;", "com/tencent/mobileqq/vas/social/record/d$c", "H", "Lcom/tencent/mobileqq/vas/social/record/d$c;", "childrenHandleListener", "Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", "Lcom/tencent/mobileqq/vas/social/record/c;", "listener", "<init>", "(Lcom/tencent/mobileqq/vas/data/b;Lcom/tencent/mobileqq/vas/social/record/c;)V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private final c childrenHandleListener;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f310815a;

        static {
            int[] iArr = new int[RecordType.values().length];
            try {
                iArr[RecordType.MP4_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordType.FILAMENT_SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecordType.FILAMENT_NEARBY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f310815a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/vas/social/record/d$c", "Lcom/tencent/mobileqq/vas/social/record/c;", "", "code", "", "message", "", "onError", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "stepState", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "", "timeCost", "a", "", "Z", "hadError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.vas.social.record.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean hadError;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.vas.social.record.c f310817b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f310818c;

        c(com.tencent.mobileqq.vas.social.record.c cVar, d dVar) {
            this.f310817b = cVar;
            this.f310818c = dVar;
        }

        @Override // com.tencent.mobileqq.vas.social.record.c
        public void a(RecordState stepState, RecordStepProduct product, long timeCost) {
            Intrinsics.checkNotNullParameter(stepState, "stepState");
            Intrinsics.checkNotNullParameter(product, "product");
            QLog.d("RecordParallelUpload", 1, "onStepDone product:" + product + " hadError:" + this.hadError);
            if (this.hadError) {
                return;
            }
            Bundle extra = product.getExtra();
            Object obj = null;
            String string = extra != null ? extra.getString("upload_mode") : null;
            if (Intrinsics.areEqual(string, MODE.MP4.name())) {
                this.f310818c.getStepProduct().j(product.getServiceMp4());
            } else if (Intrinsics.areEqual(string, MODE.FRAME.name())) {
                this.f310818c.getStepProduct().i(product.getServiceCover());
            }
            Iterator<T> it = this.f310818c.s().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!((com.tencent.mobileqq.vas.social.record.b) next).getIsStepDone()) {
                    obj = next;
                    break;
                }
            }
            boolean z16 = obj == null;
            QLog.d("RecordParallelUpload", 1, "onStepDone isAllDone:" + z16);
            if (z16) {
                this.f310818c.n();
            }
        }

        @Override // com.tencent.mobileqq.vas.social.record.c
        public void onError(int code, String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.hadError = true;
            com.tencent.mobileqq.vas.social.record.c cVar = this.f310817b;
            if (cVar != null) {
                cVar.onError(code, message);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.tencent.mobileqq.vas.data.b taskInfo, com.tencent.mobileqq.vas.social.record.c cVar) {
        super(taskInfo, RecordState.RECORDED, cVar);
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        c cVar2 = new c(cVar, this);
        this.childrenHandleListener = cVar2;
        int i3 = b.f310815a[taskInfo.getCom.tencent.ecommerce.base.report.api.IECDtReport.ACTION_IDENTIFIER java.lang.String().getType().ordinal()];
        if (i3 == 1) {
            r(new RecordStepUpload(taskInfo, MODE.MP4, cVar2));
            r(new RecordStepUpload(taskInfo, MODE.FRAME, cVar2));
        } else if (i3 == 2 || i3 == 3) {
            r(new RecordStepUpload(taskInfo, MODE.FRAME, cVar2));
        }
    }
}
