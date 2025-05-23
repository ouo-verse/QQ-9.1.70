package com.dataline.nt;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/dataline/nt/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/f;", "Landroid/view/View;", "avatarView", "", "tid", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class b implements com.tencent.mobileqq.aio.msglist.holder.f {
    private final void c(final View avatarView, String tid) {
        if (avatarView instanceof ImageView) {
            final int m3 = DataLineRecentContactUtil.f32313a.m(tid);
            QLog.d("DataLineAIOAvatarProcessor", 1, "msgRecord.senderUid is " + tid);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.dataline.nt.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(avatarView, m3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View avatarView, int i3) {
        Intrinsics.checkNotNullParameter(avatarView, "$avatarView");
        ((ImageView) avatarView).setImageResource(i3);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.f
    public void a(@NotNull View avatarView, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        String str = msgRecord.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.senderUid");
        c(avatarView, str);
    }
}
