package com.qzone.reborn.albumx.qzone.vas.part;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/albumx/qzone/vas/part/QZoneAlbumExpirePicBodyPart$registerRecoveryEvent$1$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneAlbumExpirePicBodyPart$registerRecoveryEvent$1$1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ QZoneAlbumExpirePicBodyPart f52790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QZoneAlbumExpirePicBodyPart$registerRecoveryEvent$1$1(QZoneAlbumExpirePicBodyPart qZoneAlbumExpirePicBodyPart) {
        this.f52790a = qZoneAlbumExpirePicBodyPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QZoneAlbumExpirePicBodyPart this$0) {
        com.qzone.reborn.albumx.qzone.vas.d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dVar = this$0.viewModel;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            dVar = null;
        }
        dVar.T1();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual("photo_pic_recover_status", intent != null ? intent.getStringExtra("event") : null)) {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final QZoneAlbumExpirePicBodyPart qZoneAlbumExpirePicBodyPart = this.f52790a;
            rFWThreadManager.postMainDelay(new Runnable() { // from class: com.qzone.reborn.albumx.qzone.vas.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneAlbumExpirePicBodyPart$registerRecoveryEvent$1$1.b(QZoneAlbumExpirePicBodyPart.this);
                }
            }, 2000L);
        }
    }
}
