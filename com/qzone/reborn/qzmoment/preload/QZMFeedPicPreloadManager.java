package com.qzone.reborn.qzmoment.preload;

import android.text.TextUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;
import java.util.Iterator;
import java.util.List;
import qzonemoment.QZMomentMeta$StImage;

/* loaded from: classes37.dex */
public class QZMFeedPicPreloadManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile QZMFeedPicPreloadManager f58997a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            QLog.d("QZMFeedPicPreloadManager", 1, "handlePreloadSinglePic  preload pic success.  | seq = " + option.getSeq());
        }
    }

    public static QZMFeedPicPreloadManager c() {
        if (f58997a == null) {
            synchronized (QZMFeedPicPreloadManager.class) {
                if (f58997a == null) {
                    f58997a = new QZMFeedPicPreloadManager();
                }
            }
        }
        return f58997a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, bn.b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        Option priority = Option.obtain().setUrl(str).setPredecode(false).setPriority(1);
        QLog.i("QZMFeedPicPreloadManager", 1, "start preload pic  | seq = " + priority.getSeq() + " | cacheKey = " + priority.getCacheKey() + " | feedId = " + bVar.a().f430362id.get() + " | url = " + str);
        com.tencent.mobileqq.qzone.picload.c.a().i(priority, new a());
    }

    private void e(final bn.b bVar) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.preload.QZMFeedPicPreloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                bn.b bVar2 = bVar;
                if (bVar2 == null) {
                    return;
                }
                Iterator<QZMomentMeta$StImage> it = bVar2.a().images.get().iterator();
                while (it.hasNext()) {
                    QZMFeedPicPreloadManager.this.d(it.next().picUrl.get(), bVar);
                }
            }
        });
    }

    public void b(List<bn.b> list) {
        if (QZoneConfigHelper.u0() && !bl.b(list)) {
            Iterator<bn.b> it = list.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
        }
    }
}
