package com.qzone.reborn.feedx.block;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.qzone.reborn.feedx.widget.homepage.QZoneMessageBoardView;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/block/QZoneMessageBoardBlock$initBroadcast$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneMessageBoardBlock$initBroadcast$1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ QZoneMessageBoardBlock f54758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QZoneMessageBoardBlock$initBroadcast$1(QZoneMessageBoardBlock qZoneMessageBoardBlock) {
        this.f54758a = qZoneMessageBoardBlock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        r1 = r1.mMessageBoardView;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(QZoneMessageBoardBlock this$0, int i3) {
        com.qzone.reborn.feedx.viewmodel.w wVar;
        QZoneMessageBoardView qZoneMessageBoardView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wVar = this$0.mUserHomeViewModel;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            wVar = null;
        }
        wVar.P1();
        if (i3 != 2 || qZoneMessageBoardView == null) {
            return;
        }
        qZoneMessageBoardView.A0();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean booleanExtra = intent.getBooleanExtra("openMsgBoard", false);
        final int intExtra = intent.getIntExtra("updateMsgBoard", 1);
        com.qzone.proxy.feedcomponent.util.j.e("QZoneMessageBoardBlock", 2, "MsgBoardReceiver onReceive: openMsgBoard=" + booleanExtra + ",updateType=" + intExtra);
        RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
        final QZoneMessageBoardBlock qZoneMessageBoardBlock = this.f54758a;
        rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.block.ac
            @Override // java.lang.Runnable
            public final void run() {
                QZoneMessageBoardBlock$initBroadcast$1.b(QZoneMessageBoardBlock.this, intExtra);
            }
        }, 500L);
    }
}
