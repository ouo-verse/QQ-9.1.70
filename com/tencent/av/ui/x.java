package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.foldable.FoldInfoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    Context f76644a;

    /* renamed from: b, reason: collision with root package name */
    VideoAppInterface f76645b;

    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context, VideoAppInterface videoAppInterface) {
        this.f76644a = context;
        this.f76645b = videoAppInterface;
        QLog.d("ScreenLayout", 1, "ScreenLayout. onCreate." + this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0003. Please report as an issue. */
    public static synchronized x b(Context context, VideoAppInterface videoAppInterface, int i3, boolean z16) {
        x acVar;
        synchronized (x.class) {
            switch (i3) {
                case 1:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new ac(context, videoAppInterface);
                    }
                    break;
                case 2:
                    if (z16) {
                        acVar = new af(context, videoAppInterface);
                    } else {
                        acVar = new z(context, videoAppInterface);
                    }
                    break;
                case 3:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new ScreenLayoutMultipleGrid(context, videoAppInterface);
                    }
                    break;
                case 4:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new ae(context, videoAppInterface);
                    }
                    break;
                case 5:
                    if (z16) {
                        acVar = new ah(context, videoAppInterface);
                    } else {
                        acVar = new ae(context, videoAppInterface);
                    }
                    break;
                case 6:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new ab(context, videoAppInterface);
                    }
                    break;
                case 7:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new y(context, videoAppInterface);
                    }
                    break;
                case 8:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new aa(context, videoAppInterface);
                    }
                    break;
                case 9:
                    if (z16) {
                        acVar = new ag(context, videoAppInterface);
                    } else {
                        acVar = new ad(context, videoAppInterface);
                    }
                    break;
                default:
                    acVar = null;
                    break;
            }
        }
        return acVar;
    }

    public static boolean e(int i3) {
        if (i3 != 2 && i3 != 6 && i3 != 7) {
            return false;
        }
        return true;
    }

    public static boolean f(Context context) {
        return context.getResources().getConfiguration().toString().contains("hw-magic-windows");
    }

    public static boolean g(Context context) {
        return FoldInfoUtils.h(context);
    }

    public abstract boolean a();

    public abstract int c();

    public boolean d() {
        if (c() != 2 && c() != 6 && c() != 7) {
            return false;
        }
        return true;
    }

    public abstract void h(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19, boolean z16);

    public void k() {
        QLog.d("ScreenLayout", 1, "ScreenLayout. onDestroy." + this);
        this.f76644a = null;
    }

    public void j(int i3, Rect rect, Rect rect2, ConcurrentHashMap<Long, am> concurrentHashMap) {
    }

    public void i(SessionInfo sessionInfo, GLVideoView[] gLVideoViewArr, int i3, int i16, boolean z16, int i17, int i18) {
    }

    public void l(GLVideoView[] gLVideoViewArr, int i3, int i16, int i17, int i18, int i19) {
    }
}
