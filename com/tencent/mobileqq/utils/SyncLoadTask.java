package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.util.AudioHelperUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class SyncLoadTask {
    public String mTAG;
    int mTaskStatus = 1;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(boolean z16, ArrayList<SyncLoadTask> arrayList);
    }

    public SyncLoadTask(String str) {
        this.mTAG = str + "_" + AudioHelperUtil.genDebugSeq();
    }

    public static void requestSyncTask(final Resources resources, final ArrayList<SyncLoadTask> arrayList, final a aVar) {
        final ArrayList arrayList2 = new ArrayList();
        Iterator<SyncLoadTask> it = arrayList.iterator();
        while (it.hasNext()) {
            SyncLoadTask next = it.next();
            if (next.isNeedRunTask()) {
                arrayList2.add(next);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            ((SyncLoadTask) it5.next()).setRunning();
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.SyncLoadTask.1
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList arrayList3 = new ArrayList();
                final ArrayList arrayList4 = new ArrayList();
                Iterator it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    SyncLoadTask syncLoadTask = (SyncLoadTask) it6.next();
                    if (syncLoadTask.runOnSubThread(resources)) {
                        arrayList3.add(syncLoadTask);
                    } else {
                        syncLoadTask.clean();
                        arrayList4.add(syncLoadTask);
                    }
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.SyncLoadTask.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        Iterator it7 = arrayList3.iterator();
                        while (true) {
                            z16 = true;
                            if (!it7.hasNext()) {
                                break;
                            } else {
                                ((SyncLoadTask) it7.next()).setComplete(true);
                            }
                        }
                        Iterator it8 = arrayList4.iterator();
                        while (it8.hasNext()) {
                            z16 = false;
                            ((SyncLoadTask) it8.next()).setComplete(false);
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        aVar.a(z16, arrayList);
                    }
                });
            }
        }, 8, null, true);
    }

    public final void clean() {
        this.mTaskStatus = 1;
        innerClean();
    }

    public abstract void innerClean();

    public final boolean isNeedRunTask() {
        int i3 = this.mTaskStatus;
        if (i3 != 20 && i3 != 2) {
            return true;
        }
        return false;
    }

    final boolean isRunning() {
        if ((this.mTaskStatus & 2) == 2) {
            return true;
        }
        return false;
    }

    final boolean isSuc() {
        if ((this.mTaskStatus & 20) == 20) {
            return true;
        }
        return false;
    }

    public abstract boolean runOnSubThread(Resources resources);

    final void setComplete(boolean z16) {
        if (z16) {
            this.mTaskStatus = 20;
        } else {
            this.mTaskStatus = 36;
        }
    }

    final void setRunning() {
        this.mTaskStatus = 2;
    }
}
