package com.tencent.mobileqq.zplan.proxy;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/z;", "Lzx4/r;", "Lsx4/b;", "listener", "", "a", "b", "", "isSDKReady", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class z implements zx4.r {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/proxy/z$a", "Lcom/tencent/superplayer/api/SuperPlayerSDKMgr$ILogListener;", "", "p0", "p1", "", "v", "d", "i", "w", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements SuperPlayerSDKMgr.ILogListener {
        a() {
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int d(String p06, String p16) {
            QLog.d(p06, 1, p16);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int e(String p06, String p16) {
            QLog.e(p06, 1, p16);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int i(String p06, String p16) {
            QLog.i(p06, 1, p16);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int v(String p06, String p16) {
            QLog.d(p06, 1, p16);
            return 0;
        }

        @Override // com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener
        public int w(String p06, String p16) {
            QLog.w(p06, 1, p16);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(sx4.b listener, boolean z16) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onSDKInited(z16);
    }

    @Override // zx4.r
    public void a(final sx4.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new SDKInitListener() { // from class: com.tencent.mobileqq.zplan.proxy.y
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public final void onSDKInited(boolean z16) {
                z.d(sx4.b.this, z16);
            }
        });
    }

    @Override // zx4.r
    public void b() {
        SuperPlayerSDKMgr.setOnLogListener(new a());
    }

    @Override // zx4.r
    public boolean isSDKReady() {
        return QQVideoPlaySDKManager.isSDKReady();
    }
}
