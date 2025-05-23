package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qzone.util.CreditLevelMonitor;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedpro/part/h;", "Lcom/qzone/reborn/feedpro/part/b;", "Landroid/os/Handler;", "getHandler", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "mCheckCreditLevelRunnable", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Runnable mCheckCreditLevelRunnable = new Runnable() { // from class: com.qzone.reborn.feedpro.part.f
        @Override // java.lang.Runnable
        public final void run() {
            h.G9(h.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F9(h this$0, Message msg2) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == -4015) {
            Activity activity2 = this$0.getActivity();
            if (activity2 != null) {
                Activity activity3 = activity2.isFinishing() ^ true ? activity2 : null;
                if (activity3 != null) {
                    com.qzone.util.o.c(activity3);
                }
            }
        } else if (i3 == -88 && (activity = this$0.getActivity()) != null) {
            if (!(!activity.isFinishing())) {
                activity = null;
            }
            if (activity != null) {
                CreditLevelMonitor c16 = CreditLevelMonitor.c();
                Object obj = msg2.obj;
                String str = obj instanceof String ? (String) obj : null;
                if (str == null) {
                    str = "";
                }
                c16.e(activity, str);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CreditLevelMonitor.c().b(this$0.getHandler());
    }

    private final Handler getHandler() {
        return new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.qzone.reborn.feedpro.part.g
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean F9;
                F9 = h.F9(h.this, message);
                return F9;
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RFWThreadManager.getInstance().remove(this.mCheckCreditLevelRunnable);
        RFWThreadManager.getInstance().execOnSubThread(this.mCheckCreditLevelRunnable);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        RFWThreadManager.getInstance().remove(this.mCheckCreditLevelRunnable);
        CreditLevelMonitor.c().d();
    }
}
