package am;

import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lam/d;", "Lam/c;", "", com.tencent.luggage.wxa.c8.c.G, "", "path", "", "F9", "Lcom/qzone/publish/ui/activity/QZonePublishMoodNewStyleActivity;", "e", "Lcom/qzone/publish/ui/activity/QZonePublishMoodNewStyleActivity;", "publishActivity", "<init>", "(Lcom/qzone/publish/ui/activity/QZonePublishMoodNewStyleActivity;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QZonePublishMoodNewStyleActivity publishActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(QZonePublishMoodNewStyleActivity publishActivity) {
        super(publishActivity);
        Intrinsics.checkNotNullParameter(publishActivity, "publishActivity");
        this.publishActivity = publishActivity;
    }

    @Override // am.c
    public void F9(int pos, String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity = this.publishActivity;
        if ((path.length() > 0) && qZonePublishMoodNewStyleActivity.rj() != null && qZonePublishMoodNewStyleActivity.rj().size() > 0) {
            qZonePublishMoodNewStyleActivity.rj().remove(path);
        }
        if (qZonePublishMoodNewStyleActivity.oj() != null && qZonePublishMoodNewStyleActivity.oj().size() < qZonePublishMoodNewStyleActivity.dj()) {
            qZonePublishMoodNewStyleActivity.T.o0(true, true);
        }
        qZonePublishMoodNewStyleActivity.ui();
        qZonePublishMoodNewStyleActivity.rq();
    }
}
