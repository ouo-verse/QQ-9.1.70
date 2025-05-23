package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import com.qzone.util.CreditLevelMonitor;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends g {

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f55318d = new Runnable() { // from class: com.qzone.reborn.feedx.part.s
        @Override // java.lang.Runnable
        public final void run() {
            t.this.E9();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E9() {
        CreditLevelMonitor.c().b(getMainHandler());
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        int i3 = message.what;
        if (i3 == -88) {
            if (getActivity() == null || getActivity().isFinishing()) {
                return;
            }
            CreditLevelMonitor.c().e(getActivity(), (String) message.obj);
            return;
        }
        if (i3 != -4015 || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        com.qzone.util.o.c(getActivity());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).removeTask(this.f55318d);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(this.f55318d);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).removeTask(this.f55318d);
        CreditLevelMonitor.c().d();
    }
}
