package com.tencent.mobileqq.winkpublish.outbox.task.feature.feat;

import androidx.core.util.Consumer;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/feat/d;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/feature/base/b;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "a", "(Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "e", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends com.tencent.mobileqq.winkpublish.outbox.task.feature.base.b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(UploadMediaInfo it, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(it, "$it");
        if (QLog.isColorLevel()) {
            QLog.i("WinkPublish-upload2--SaveMediaFeat", 2, "saveMediaToSystem result " + rFWSaveMediaResultBean.isSuccess + ", srcPath=" + it.l());
        }
    }

    @Override // com.tencent.mobileqq.winkpublish.outbox.task.feature.base.a
    public Object a(TaskContext taskContext, Continuation<? super Unit> continuation) {
        List<UploadMediaInfo> plus;
        try {
            plus = CollectionsKt___CollectionsKt.plus((Collection) taskContext.x(), (Iterable) taskContext.l());
            for (final UploadMediaInfo uploadMediaInfo : plus) {
                try {
                    RFWSaveUtil.insertMedia(BaseApplication.context, uploadMediaInfo.l(), new Consumer() { // from class: com.tencent.mobileqq.winkpublish.outbox.task.feature.feat.c
                        @Override // androidx.core.util.Consumer
                        public final void accept(Object obj) {
                            d.e(UploadMediaInfo.this, (RFWSaveMediaResultBean) obj);
                        }
                    });
                } catch (Exception e16) {
                    QLog.e("WinkPublish-upload2--SaveMediaFeat", 1, "saveMediaToSystem exception", e16);
                }
            }
        } catch (Exception e17) {
            QLog.w("WinkPublish-upload2--SaveMediaFeat", 1, "[run] save error", e17);
        }
        return Unit.INSTANCE;
    }

    public d() {
        super(null, 1, null);
    }
}
