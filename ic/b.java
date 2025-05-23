package ic;

import android.app.Activity;
import com.qzone.reborn.albumx.common.share.QQShareActionManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lic/b;", "Lcom/qzone/reborn/albumx/common/share/b;", "Lxa/c;", "c", "Lxa/c;", "()Lxa/c;", "rsp", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "shareManger", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;Lxa/c;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends com.qzone.reborn.albumx.common.share.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final xa.c rsp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, QQShareActionManager<?> shareManger, xa.c rsp) {
        super(activity, shareManger);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.rsp = rsp;
    }

    /* renamed from: c, reason: from getter */
    public final xa.c getRsp() {
        return this.rsp;
    }
}
