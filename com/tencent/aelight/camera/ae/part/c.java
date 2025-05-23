package com.tencent.aelight.camera.ae.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart;
import com.tencent.aelight.camera.ae.camera.ui.aiscene.VideoStoryAIScenePart;
import com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart;
import com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart;
import com.tencent.aelight.camera.ae.camera.ui.gallery.AECaptureCustomMaterialPart;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart;
import com.tencent.aelight.camera.ae.camera.ui.simple.AESimpleCapturePart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEAIONewTopBarPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AETopRightBarPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart;
import com.tencent.aelight.camera.ae.play.AEPlayShowPart;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Activity f65652a;

    /* renamed from: b, reason: collision with root package name */
    private AEBaseCameraUnit f65653b;

    /* renamed from: c, reason: collision with root package name */
    private View f65654c;

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, b> f65655d = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f65657f = false;

    /* renamed from: e, reason: collision with root package name */
    private Set<Integer> f65656e = d();

    public c(Activity activity, View view, AEBaseCameraUnit aEBaseCameraUnit) {
        this.f65652a = activity;
        this.f65654c = view;
        this.f65653b = aEBaseCameraUnit;
    }

    private void a(int i3) {
        View view;
        b aEBottomListPart;
        Activity activity = this.f65652a;
        if (activity == null || (view = this.f65654c) == null) {
            return;
        }
        switch (i3) {
            case 131072:
                aEBottomListPart = new AEBottomListPart(activity, view, this);
                break;
            case 196608:
                aEBottomListPart = new VideoStoryAIScenePart(activity, view, this);
                break;
            case 262144:
                aEBottomListPart = new VideoStoryCapturePart(activity, view, this);
                break;
            case 327680:
                aEBottomListPart = new VideoStoryPiecesPart(this.f65652a, this.f65654c, this);
                break;
            case 393216:
                aEBottomListPart = new com.tencent.aelight.camera.ae.mode.a(activity, view, this);
                break;
            case 458752:
                aEBottomListPart = new AEVideoStoryTopBarPart(activity, view, this);
                break;
            case 524288:
                aEBottomListPart = new AEGIFStickerListPart(activity, view, this);
                break;
            case 589824:
                aEBottomListPart = new com.tencent.aelight.camera.ae.camera.ui.watermark.a(this.f65652a, this.f65654c, this);
                break;
            case 655360:
                aEBottomListPart = new AEPlayShowPart(activity, (ViewStub) view.findViewById(R.id.rnh), this);
                break;
            case 720896:
                aEBottomListPart = new AEVideoStoryDashboardPart(activity, view, this);
                break;
            case 786432:
                aEBottomListPart = new com.tencent.aelight.camera.ae.camera.ui.bottom.b(activity, view, this);
                break;
            case 851968:
                aEBottomListPart = new AECaptureCustomMaterialPart(activity, view, this);
                break;
            case 917505:
                aEBottomListPart = new AETopRightBarPart(activity, view, this);
                break;
            case 917506:
                aEBottomListPart = new AEAIONewTopBarPart(activity, view, this);
                break;
            case 983041:
                aEBottomListPart = new AEBottomPanelPart(this.f65652a, this.f65654c, this);
                break;
            case 1048576:
                aEBottomListPart = new AESimpleCapturePart(activity, (ViewStub) view.findViewById(R.id.s1_), this);
                break;
            default:
                aEBottomListPart = null;
                break;
        }
        if (aEBottomListPart != null) {
            this.f65655d.put(Integer.valueOf(i3), aEBottomListPart);
        }
    }

    private Set<Integer> d() {
        return e();
    }

    private Set<Integer> e() {
        int k3 = this.f65653b.C().k();
        HashSet hashSet = new HashSet();
        if (js.a.M.d(k3)) {
            hashSet.add(458752);
            hashSet.add(262144);
            hashSet.add(327680);
            hashSet.add(131072);
        } else {
            js.a aVar = js.a.f410906f;
            if (!aVar.d(k3) && !js.a.f410923w.d(k3) && !js.a.f410917q.d(k3) && !js.a.f410908h.d(k3) && !gq.a.g(k3) && !js.a.S.d(k3)) {
                if (!js.a.V.d(k3) && !js.a.U.d(k3)) {
                    if (js.a.f410926z.d(k3)) {
                        hashSet.add(458752);
                        hashSet.add(262144);
                        hashSet.add(327680);
                        hashSet.add(524288);
                        hashSet.add(131072);
                        hashSet.add(393216);
                        hashSet.add(917505);
                    } else if (js.a.L.d(k3)) {
                        hashSet.add(458752);
                        hashSet.add(262144);
                        hashSet.add(327680);
                        hashSet.add(131072);
                        hashSet.add(393216);
                        hashSet.add(917505);
                    } else if (js.a.Q.d(k3)) {
                        hashSet.add(262144);
                        hashSet.add(327680);
                        hashSet.add(131072);
                        hashSet.add(1048576);
                        hashSet.add(983041);
                    } else {
                        hashSet.add(458752);
                        hashSet.add(917505);
                        if (gq.a.q(k3)) {
                            hashSet.add(786432);
                        } else {
                            hashSet.add(131072);
                        }
                        hashSet.add(196608);
                        hashSet.add(262144);
                        hashSet.add(327680);
                        hashSet.add(393216);
                        hashSet.add(524288);
                        hashSet.add(589824);
                    }
                } else {
                    hashSet.add(458752);
                    hashSet.add(131072);
                    hashSet.add(262144);
                    hashSet.add(327680);
                    hashSet.add(393216);
                    hashSet.add(917505);
                }
            } else {
                hashSet.add(458752);
                hashSet.add(131072);
                hashSet.add(196608);
                hashSet.add(262144);
                hashSet.add(327680);
                hashSet.add(393216);
                hashSet.add(524288);
                hashSet.add(589824);
                hashSet.add(655360);
                hashSet.add(917505);
                if (js.a.f410908h.d(k3) || js.a.f410910j.d(k3) || js.a.f410923w.d(k3) || aVar.d(k3) || js.a.S.d(k3)) {
                    hashSet.add(851968);
                }
            }
        }
        int b16 = gq.a.b(this.f65653b);
        if (b16 == 201) {
            hashSet.add(655360);
        } else if (b16 == 204) {
            hashSet.remove(524288);
        } else if (b16 == 205) {
            hashSet.remove(655360);
        }
        if (!gq.a.q(k3) && !js.a.O.d(k3)) {
            hashSet.add(983041);
        }
        if (b16 == 207 || b16 == 205 || b16 == 201 || b16 == 203 || b16 == 202) {
            hashSet.remove(458752);
            hashSet.add(917506);
        }
        if (AEDashboardUtil.x()) {
            boolean c16 = AECameraPrefsUtil.f().c(AECameraConstants.DEBUG_KEY_TEST_LAUNCH_SPEED_MODE, false, 4);
            if (AEDashboardUtil.x() && !c16) {
                hashSet.add(720896);
            }
        }
        return hashSet;
    }

    private void i() {
        Iterator<Integer> it = this.f65656e.iterator();
        while (it.hasNext()) {
            a(it.next().intValue());
        }
    }

    private void j() {
        Iterator<Integer> it = this.f65655d.keySet().iterator();
        while (it.hasNext()) {
            this.f65655d.get(it.next()).initView();
        }
    }

    private int s(int i3) {
        if ((i3 >> 16) == 2) {
            return 786432;
        }
        return 65536;
    }

    public <T> T b(int i3, Object... objArr) {
        b bVar = this.f65655d.get(Integer.valueOf(t(i3)));
        if (bVar != null) {
            return (T) bVar.get(i3, objArr);
        }
        return (T) c(i3, objArr);
    }

    public AEMaterialManager f(int i3) {
        b bVar = this.f65655d.get(Integer.valueOf(t(i3)));
        if (bVar instanceof AEBottomListPart) {
            return ((AEBottomListPart) bVar).N();
        }
        return null;
    }

    public boolean g(int i3) {
        return this.f65655d.get(Integer.valueOf(t(i3))) != null;
    }

    public synchronized void h() {
        if (!this.f65657f) {
            i();
            j();
            this.f65657f = true;
        }
    }

    public void k() {
        Iterator<Integer> it = this.f65655d.keySet().iterator();
        while (it.hasNext()) {
            this.f65655d.get(it.next()).onActivityPause();
        }
    }

    public void l(int i3, int i16, Intent intent) {
        Iterator<Integer> it = this.f65655d.keySet().iterator();
        while (it.hasNext()) {
            this.f65655d.get(it.next()).onActivityResult(i3, i16, intent);
        }
    }

    public void m() {
        Iterator<Integer> it = this.f65655d.keySet().iterator();
        while (it.hasNext()) {
            this.f65655d.get(it.next()).onActivityResume();
        }
    }

    public void n() {
        Iterator<Integer> it = this.f65655d.keySet().iterator();
        while (it.hasNext()) {
            this.f65655d.get(it.next()).onActivityStart();
        }
    }

    public void o() {
        Iterator<Integer> it = this.f65655d.keySet().iterator();
        while (it.hasNext()) {
            this.f65655d.get(it.next()).onActivityStop();
        }
    }

    public void p() {
        Iterator<b> it = this.f65655d.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.f65655d.clear();
        this.f65652a = null;
        this.f65654c = null;
    }

    public void q(int i3, Object... objArr) {
        int t16 = t(i3);
        if (t16 == 65536) {
            t16 = s(i3);
        }
        b bVar = this.f65655d.get(Integer.valueOf(t16));
        if (bVar != null) {
            bVar.send(i3, objArr);
        } else {
            r(i3, objArr);
        }
    }

    private int t(int i3) {
        int i16 = i3 >> 16;
        for (Integer num : this.f65656e) {
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
        return (T) this.f65653b;
    }

    private void r(int i3, Object... objArr) {
    }
}
