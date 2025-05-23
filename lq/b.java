package lq;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashChallengePart;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPart;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowCustomMaterialPart;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMusicPart;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMusicPartV2;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashshowCapturePart;
import com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart;
import com.tencent.aelight.camera.ae.flashshow.ui.bs;
import com.tencent.aelight.camera.ae.flashshow.ui.dp;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.cx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f415380a;

    /* renamed from: b, reason: collision with root package name */
    protected LSBaseCameraUnit f415381b;

    /* renamed from: c, reason: collision with root package name */
    protected View f415382c;

    /* renamed from: d, reason: collision with root package name */
    protected Map<Integer, a> f415383d = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f415385f = false;

    /* renamed from: e, reason: collision with root package name */
    protected Set<Integer> f415384e = d();

    public b(Activity activity, View view, LSBaseCameraUnit lSBaseCameraUnit) {
        this.f415380a = activity;
        this.f415382c = view;
        this.f415381b = lSBaseCameraUnit;
    }

    private Set<Integer> d() {
        return e();
    }

    private void h() {
        Iterator<Integer> it = this.f415384e.iterator();
        while (it.hasNext()) {
            a(it.next().intValue());
        }
    }

    private void i() {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).e();
        }
    }

    private int s(int i3) {
        return 65536;
    }

    public <T> T b(int i3, Object... objArr) {
        a aVar = this.f415383d.get(Integer.valueOf(t(i3)));
        if (aVar != null) {
            return (T) aVar.d(i3, objArr);
        }
        return (T) c(i3, objArr);
    }

    protected Set<Integer> e() {
        int l3 = this.f415381b.D().l();
        HashSet hashSet = new HashSet();
        if (js.a.O.d(l3)) {
            hashSet.add(917504);
            hashSet.add(262144);
            hashSet.add(Integer.valueOf(RecentBaseData.MENU_FLAG_MASK_READSTATE));
            if (cx.INSTANCE.f()) {
                hashSet.add(1179648);
                hashSet.add(1245184);
            } else {
                hashSet.add(1048576);
            }
            hashSet.remove(524288);
            hashSet.add(589824);
            hashSet.add(851968);
            if (WinkContext.INSTANCE.d().k().a().equals("QCIRCLE")) {
                hashSet.add(1114112);
            }
        }
        if (LSDashboardUtil.p()) {
            boolean z16 = ((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getBoolean(AECameraConstants.DEBUG_KEY_TEST_LAUNCH_SPEED_MODE, false, 4);
            if (LSDashboardUtil.p() && !z16) {
                hashSet.add(720896);
            }
        }
        return hashSet;
    }

    public boolean f(int i3) {
        return this.f415383d.get(Integer.valueOf(t(i3))) != null;
    }

    public synchronized void g() {
        if (!this.f415385f) {
            h();
            i();
            this.f415385f = true;
        }
    }

    public void j() {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).f();
        }
    }

    public void k(int i3, int i16, Intent intent) {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).g(i3, i16, intent);
        }
    }

    public void l() {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).h();
        }
    }

    public void m() {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).i();
        }
    }

    public void n() {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).j();
        }
    }

    public void o() {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).onDestroy();
        }
        this.f415383d.clear();
        this.f415381b = null;
        this.f415382c = null;
        this.f415380a = null;
    }

    public void p(Intent intent) {
        Iterator<Integer> it = this.f415383d.keySet().iterator();
        while (it.hasNext()) {
            this.f415383d.get(it.next()).k(intent);
        }
    }

    public void q(int i3, Object... objArr) {
        int t16 = t(i3);
        if (t16 == 65536) {
            t16 = s(i3);
        }
        a aVar = this.f415383d.get(Integer.valueOf(t16));
        if (aVar != null) {
            aVar.l(i3, objArr);
        } else {
            r(i3, objArr);
        }
    }

    private int t(int i3) {
        int i16 = i3 >> 16;
        for (Integer num : this.f415384e) {
            if (i16 == (num.intValue() >> 16)) {
                return num.intValue();
            }
        }
        return 65536;
    }

    private <T> T c(int i3, Object... objArr) {
        if (i3 != 65537) {
            return null;
        }
        return (T) this.f415381b;
    }

    protected void a(int i3) {
        a aEFlashshowCapturePart;
        if (i3 == 262144) {
            aEFlashshowCapturePart = new AEFlashshowCapturePart(this.f415380a, this.f415382c, this);
        } else if (i3 == 589824) {
            aEFlashshowCapturePart = new com.tencent.aelight.camera.ae.flashshow.ui.watermark.a(this.f415380a, this.f415382c, this);
        } else if (i3 == 720896) {
            aEFlashshowCapturePart = new LSDashboardPart(this.f415380a, this.f415382c, this);
        } else if (i3 == 851968) {
            aEFlashshowCapturePart = new AEFlashShowCustomMaterialPart(this.f415380a, this.f415382c, this);
        } else if (i3 == 917504) {
            aEFlashshowCapturePart = new dp(this.f415380a, this.f415382c, this);
        } else if (i3 == 983040) {
            aEFlashshowCapturePart = new AEFlashShowBottomPart(this.f415380a, this.f415382c, this);
        } else if (i3 == 1048576) {
            aEFlashshowCapturePart = new AEFlashShowMusicPart(this.f415380a, this.f415382c, this);
        } else if (i3 == 1114112) {
            aEFlashshowCapturePart = new AEFlashChallengePart(this.f415380a, this.f415382c, this);
        } else if (i3 != 1179648) {
            aEFlashshowCapturePart = i3 != 1245184 ? null : new bs(this.f415380a, this.f415382c, this);
        } else {
            aEFlashshowCapturePart = new AEFlashShowMusicPartV2(this.f415380a, this.f415382c, this);
        }
        if (aEFlashshowCapturePart != null) {
            this.f415383d.put(Integer.valueOf(i3), aEFlashshowCapturePart);
        }
    }

    private void r(int i3, Object... objArr) {
    }
}
