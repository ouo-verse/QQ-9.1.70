package com.tencent.sqshow.zootopia.player;

import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/b;", "", "", "url", "", "c", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "onFirstFrameCome", "b", "a", "onRelease", "", "errorCode", "msg", "onError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b {
    void a();

    void b();

    void c(String url);

    void onError(int errorCode, String msg2);

    void onFirstFrameCome();

    void onPause();

    void onPlay();

    void onRelease();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static void a(b bVar) {
        }

        public static void b(b bVar) {
        }
    }
}
