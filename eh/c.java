package eh;

import NS_FAMOUS_SHARE.get_famous_share_rsp;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedx.repo.QzoneFamousUserInfoRequest;
import eh.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\f"}, d2 = {"Leh/c;", "", "", "uin", "Lcom/qzone/reborn/base/n$a;", "Leh/a;", "dataCallback", "", "b", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(n.a dataCallback, QZoneTask qZoneTask) {
        Intrinsics.checkNotNullParameter(dataCallback, "$dataCallback");
        Integer valueOf = qZoneTask != null ? Integer.valueOf(qZoneTask.mType) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            int i3 = qZoneTask.mResultCode;
            if (i3 == 0) {
                QZoneRequest qZoneRequest = qZoneTask.mRequest;
                if (qZoneRequest instanceof QzoneFamousUserInfoRequest) {
                    Intrinsics.checkNotNull(qZoneRequest, "null cannot be cast to non-null type com.qzone.reborn.feedx.repo.QzoneFamousUserInfoRequest");
                    get_famous_share_rsp rsp = ((QzoneFamousUserInfoRequest) qZoneRequest).getResponse();
                    a.Companion companion = a.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    a a16 = companion.a(rsp);
                    long j3 = qZoneTask.mResultCode;
                    String str = qZoneTask.f45835msg;
                    Intrinsics.checkNotNullExpressionValue(str, "task.msg");
                    dataCallback.onSuccess(a16, j3, str, true);
                    return;
                }
            }
            dataCallback.onFailure(i3, qZoneTask.f45835msg);
        }
    }

    public final void b(long uin, final n.a<a> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneFamousUserInfoRequest(uin), null, new IQZoneServiceListener() { // from class: eh.b
            @Override // com.qzone.common.business.IQZoneServiceListener
            public final void onTaskResponse(QZoneTask qZoneTask) {
                c.c(n.a.this, qZoneTask);
            }
        }, 1));
    }
}
