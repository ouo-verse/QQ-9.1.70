package pc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.model.UploadVideoObject;
import com.qzone.publish.business.task.qzonealbumx.QZPublishXUploadShuoShuoTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.ui.model.c;
import com.qzone.reborn.albumx.qzonex.activity.QZonePublishXMoodRealActivity;
import com.qzone.reborn.base.n;
import com.qzone.reborn.feedpro.utils.d;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import lc.i;
import lc.m;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0016J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0016"}, d2 = {"Lpc/b;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/publish/ui/model/c;", "params", "", "P1", "", "S1", "Landroid/content/Context;", "context", "N1", "R1", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isMixVideoPic", "Q1", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends n {
    private final void N1(final Context context, final c params) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: pc.a
            @Override // java.lang.Runnable
            public final void run() {
                b.O1(c.this, context, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(c params, Context context, b this$0) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<LocalMediaInfo> list = params.f51940e;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList<MediaWrapper> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        m mVar = m.f414350a;
        boolean g16 = mVar.g(context, params, arrayList, arrayList2);
        params.M = arrayList;
        params.P = arrayList2;
        String R1 = this$0.R1(params);
        if (d.f54318a.b()) {
            le.b.f414397d.c(params, R1);
            return;
        }
        Pair<String, String> c16 = mVar.c(params);
        if (g16) {
            i.f414345a.k(params, R1, c16.getFirst(), c16.getSecond());
        } else {
            i.f414345a.l(params, R1, c16.getFirst());
        }
    }

    private final void P1(c params) {
        UploadVideoObject.setVideoType(params.f51946h, true);
        String S1 = S1(params);
        if (d.f54318a.b()) {
            le.b.f414397d.c(params, S1);
        } else {
            i.f414345a.j(params, S1);
        }
    }

    private final String R1(c params) {
        String clientKey;
        QZPublishXUploadShuoShuoTask qZPublishXUploadShuoShuoTask = new QZPublishXUploadShuoShuoTask(1, params);
        if (TextUtils.isEmpty(params.f51945g0)) {
            clientKey = UUID.randomUUID().toString();
        } else {
            clientKey = params.f51945g0;
        }
        qZPublishXUploadShuoShuoTask.clientKey = clientKey;
        qZPublishXUploadShuoShuoTask.uploadEntrance = params.f51964z;
        qZPublishXUploadShuoShuoTask.refer = params.I;
        qZPublishXUploadShuoShuoTask.addToTaskQueen();
        Intrinsics.checkNotNullExpressionValue(clientKey, "clientKey");
        return clientKey;
    }

    private final String S1(c params) {
        QZPublishXUploadShuoShuoTask qZPublishXUploadShuoShuoTask = new QZPublishXUploadShuoShuoTask(0, params);
        qZPublishXUploadShuoShuoTask.syncToFriendInfo = params.R;
        qZPublishXUploadShuoShuoTask.isVideoToGif = params.A;
        qZPublishXUploadShuoShuoTask.syncToKuolie = params.S;
        qZPublishXUploadShuoShuoTask.kuolieCampus = params.T;
        qZPublishXUploadShuoShuoTask.fromKuolie = params.U;
        String h06 = u5.b.h0("key_dynamic_client_ket", "null");
        if (!TextUtils.isEmpty(params.f51945g0)) {
            h06 = params.f51945g0;
            Intrinsics.checkNotNullExpressionValue(h06, "{ //\u5047feedkey\n           \u2026rams.mClientKey\n        }");
        } else if (qZPublishXUploadShuoShuoTask.isDynamicTask() && !Intrinsics.areEqual(h06, "null")) {
            Intrinsics.checkNotNullExpressionValue(h06, "{\n            prePostClientKey\n        }");
        } else {
            h06 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(h06, "{\n            UUID.rando\u2026ID().toString()\n        }");
        }
        qZPublishXUploadShuoShuoTask.clientKey = h06;
        qZPublishXUploadShuoShuoTask.uploadEntrance = params.f51964z;
        qZPublishXUploadShuoShuoTask.isMakeVideo = params.Q;
        qZPublishXUploadShuoShuoTask.refer = params.I;
        qZPublishXUploadShuoShuoTask.addToTaskQueen();
        return h06;
    }

    public final void Q1(Activity activity, c params, boolean isMixVideoPic) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z16 = activity instanceof QZonePublishXMoodRealActivity;
        QLog.i("QZPublishX_QZonePublishXPublishMoodViewModel", 1, "publishMood | activity=" + activity + " | isNewAlbumx=" + z16 + " | mClientKey=" + params.f51945g0 + " | isMixVideoPic=" + isMixVideoPic);
        if (z16) {
            if (isMixVideoPic) {
                N1(activity, params);
                return;
            } else {
                P1(params);
                return;
            }
        }
        if (isMixVideoPic) {
            QZoneWriteOperationService.v0().R1(activity, params);
        } else {
            QZoneWriteOperationService.v0().O1(params);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZPublishX_QZonePublishXPublishMoodViewModel";
    }
}
