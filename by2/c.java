package by2;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends RFWBasePlayerManager {

    /* renamed from: a, reason: collision with root package name */
    private int f29389a;

    public c() {
        this(true);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public RFWPlayer getPlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QFSTVideoPlayerManagerProxy", 1, "getPlayer uniquekey = " + str + ", playerType = " + this.f29389a);
        int i3 = this.f29389a;
        if (i3 == 0) {
            return b.b().getPlayer(str);
        }
        if (i3 != 1) {
            return null;
        }
        return a.b().getPlayer(str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized RFWPlayer newAQCirclePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QLog.d("QFSTVideoPlayerManagerProxy", 1, "new circle player, uniqueKey = " + str + ", playerType = " + this.f29389a);
        releaseAll();
        int i3 = this.f29389a;
        if (i3 == 0) {
            return b.b().newAQCirclePlayer(str);
        }
        if (i3 != 1) {
            return null;
        }
        return a.b().newAQCirclePlayer(str);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public void putPlayer(String str, RFWPlayer rFWPlayer) {
        if (rFWPlayer == null) {
            return;
        }
        releaseAll();
        int i3 = this.f29389a;
        if (i3 == 0) {
            b.b().putPlayer(str, rFWPlayer);
        } else if (i3 == 1) {
            a.b().putPlayer(str, rFWPlayer);
        }
    }

    public void releaseAll() {
        QLog.d("QFSTVideoPlayerManagerProxy", 1, "release all");
        b.b().releaseAll();
        a.b().releaseAll();
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWBasePlayerManager
    public synchronized boolean releasePlayer(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        QLog.d("QFSTVideoPlayerManagerProxy", 2, "releasePlayer uniquekey = " + str + ", playerType = " + this.f29389a);
        int i3 = this.f29389a;
        if (i3 == 0) {
            return b.b().releasePlayer(str);
        }
        if (i3 != 1) {
            return false;
        }
        return a.b().releasePlayer(str);
    }

    public c(boolean z16) {
        this.f29389a = !z16 ? 1 : 0;
    }
}
