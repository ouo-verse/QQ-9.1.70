package com.tencent.mobileqq.filemanager.fileassistant.forward;

import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class DatalineForwardHandler {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class SendFileTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private List<String> f207997d;
        final /* synthetic */ DatalineForwardHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            Iterator<String> it = this.f207997d.iterator();
            if (!it.hasNext()) {
                return;
            }
            it.next();
            throw null;
        }
    }
}
