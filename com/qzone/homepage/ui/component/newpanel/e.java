package com.qzone.homepage.ui.component.newpanel;

import android.os.Looper;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f47761b;

    /* renamed from: a, reason: collision with root package name */
    private HomePanelList f47762a = b.d(BaseApplication.getContext(), LoginData.getInstance().getUin());

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends HdAsyncAction {
        a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            if (e.this.f47762a != null) {
                long uin = LoginData.getInstance().getUin();
                b.e(BaseApplication.getContext(), uin, e.this.f47762a);
                QZLog.i("HostPanelCacheManager", "success save host home panel list for uin " + uin);
            }
            return doNext(false);
        }
    }

    e() {
    }

    public static e b() {
        if (f47761b == null) {
            synchronized (e.class) {
                if (f47761b == null) {
                    f47761b = new e();
                }
            }
        }
        return f47761b;
    }

    public ArrayList<HomePanelItem> c(long j3) {
        if (LoginData.getInstance().getUin() != j3) {
            QZLog.i("HostPanelCacheManager", "get host home hide panels args error");
            return null;
        }
        HomePanelList homePanelList = this.f47762a;
        if (homePanelList != null) {
            return homePanelList.lst_hide;
        }
        return b.a(j3);
    }

    public ArrayList<HomePanelItem> d(long j3) {
        if (LoginData.getInstance().getUin() != j3) {
            return null;
        }
        HomePanelList homePanelList = this.f47762a;
        if (homePanelList != null) {
            return homePanelList.lst_show;
        }
        return b.b(j3);
    }

    public void e(long j3, HomePanelList homePanelList) {
        if (LoginData.getInstance().getUin() != j3 || homePanelList == null) {
            return;
        }
        if (this.f47762a != null && (TextUtils.isEmpty(homePanelList.toString()) || homePanelList.toString().equals(this.f47762a.toString()))) {
            QZLog.w("HostPanelCacheManager", "no need to save host home panel list");
        } else {
            this.f47762a = homePanelList;
            HdAsync.with(this).then(new a(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.BackGroundThread))).call();
        }
    }
}
