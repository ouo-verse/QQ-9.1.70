package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import hr.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import wr.a;

/* loaded from: classes32.dex */
public class CaptureComboNormalPaster extends com.tencent.aelight.camera.aioeditor.capture.data.a implements IEventReceiver {
    public static HashMap<String, Drawable> J = new HashMap<>();
    f C;
    int D;
    private float E;
    private float F;
    private float G;
    private String H;
    private b I;

    /* renamed from: m, reason: collision with root package name */
    private final String f66812m;

    /* loaded from: classes32.dex */
    public static class b extends QQUIEventReceiver<CaptureComboNormalPaster, a.g> {
        public b(CaptureComboNormalPaster captureComboNormalPaster) {
            super(captureComboNormalPaster);
        }

        @Override // com.tribe.async.dispatch.QQUIEventReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(CaptureComboNormalPaster captureComboNormalPaster, a.g gVar) {
            if (gVar.f446105e.pack_id.equals(captureComboNormalPaster.f66812m)) {
                if (gVar.f446106f == 0) {
                    if (gVar.f446107h) {
                        hd0.c.a(this.TAG, "notify ui we finish downloading");
                        f fVar = captureComboNormalPaster.C;
                        fVar.f406067q = false;
                        fVar.f406065o = gVar.f446105e.getLocalEmojiFolderPath();
                        f fVar2 = captureComboNormalPaster.C;
                        fVar2.f406068r = 0;
                        fVar2.f406069s = 0;
                        captureComboNormalPaster.D = 3;
                        captureComboNormalPaster.n();
                        if (QLog.isColorLevel()) {
                            QLog.d(this.TAG, 2, "download finished id=" + captureComboNormalPaster.f66812m + " name=" + captureComboNormalPaster.H);
                        }
                        if (captureComboNormalPaster.I != null) {
                            com.tencent.biz.qqstory.base.c.a().unRegisterSubscriber(captureComboNormalPaster.I);
                            return;
                        }
                        return;
                    }
                    hd0.c.s(this.TAG, "notify ui we new progress : " + gVar.C + " / " + gVar.f446109m);
                    f fVar3 = captureComboNormalPaster.C;
                    fVar3.f406067q = true;
                    fVar3.f406065o = null;
                    fVar3.f406068r = (int) gVar.f446109m;
                    fVar3.f406069s = (int) gVar.C;
                    captureComboNormalPaster.D = 1;
                    if (QLog.isColorLevel()) {
                        QLog.d(this.TAG, 2, "downloading=" + captureComboNormalPaster.C.f406069s + " max=" + captureComboNormalPaster.C.f406068r);
                        return;
                    }
                    return;
                }
                f fVar4 = captureComboNormalPaster.C;
                fVar4.f406067q = false;
                fVar4.f406065o = null;
                fVar4.f406068r = 0;
                fVar4.f406069s = 0;
                hd0.c.g(this.TAG, "DoodleEmojiDownloadEventReceiver download error = " + gVar.f446106f);
                id0.b.i("0X80076C9");
                id0.b.f("0X80075DE");
                captureComboNormalPaster.D = 2;
                captureComboNormalPaster.m(gVar.f446106f);
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "download error id=" + captureComboNormalPaster.f66812m + " name=" + captureComboNormalPaster.H);
                }
                if (captureComboNormalPaster.I != null) {
                    com.tencent.biz.qqstory.base.c.a().unRegisterSubscriber(captureComboNormalPaster.I);
                }
            }
        }

        @Override // com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect
        public Class acceptEventClass() {
            return a.g.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Drawable drawable, String str, String str2, f fVar, int i3, int i16, float f16, float f17, float f18, SegmentKeeper segmentKeeper, k kVar, int i17) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int intrinsicWidth = drawable.getIntrinsicWidth();
            float f19 = i3;
            float f26 = (f19 * f18) / intrinsicWidth;
            if (QLog.isColorLevel()) {
                QLog.d("QComboNPaster", 2, "applyNormalPaster w=" + intrinsicWidth + " scale=" + f26 + " px=" + f16 + " py=" + f17);
            }
            kVar.e(new vr.a(fVar.f405989b, str, drawable, i17), f19 * f16, i16 * f17, f26, str2, segmentKeeper);
            return;
        }
        hd0.c.g("QComboNPaster", "can not create drawable from name:" + str);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, final int i3) {
        List<f.b> list = this.C.f406066p;
        if (list == null || list.size() == 0) {
            f fVar = this.C;
            fVar.l(fVar.k());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster.1
            @Override // java.lang.Runnable
            public void run() {
                DoodleLayout b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3);
                if (b16 != null) {
                    CaptureComboNormalPaster captureComboNormalPaster = CaptureComboNormalPaster.this;
                    CaptureComboNormalPaster.A(captureComboNormalPaster.C, captureComboNormalPaster.H, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, CaptureComboNormalPaster.this.E, CaptureComboNormalPaster.this.F, CaptureComboNormalPaster.this.G, ((com.tencent.aelight.camera.aioeditor.capture.data.a) CaptureComboNormalPaster.this).f66708h, b16.m0());
                }
            }
        }, 64, null, true);
        if (!QLog.isColorLevel()) {
            return 0;
        }
        QLog.d("QComboNPaster", 2, "apply id=" + this.f66812m + " name=" + this.H);
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int h() {
        ((wr.a) fr.f.c(14)).g(this.f66812m, false);
        l();
        Dispatcher a16 = com.tencent.biz.qqstory.base.c.a();
        b bVar = new b(this);
        this.I = bVar;
        a16.registerSubscriber(bVar);
        this.D = 1;
        if (QLog.isColorLevel()) {
            QLog.d("QComboNPaster", 2, "create mState=" + this.D + " id=" + this.f66812m);
        }
        return this.D;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized float i() {
        if (!StringUtil.isEmpty(this.C.f406065o)) {
            j();
            return 1.0f;
        }
        int i3 = this.C.f406068r;
        if (i3 != 100.0f && i3 > 0.0f) {
            return (r0.f406069s * 1.0f) / i3;
        }
        return 0.0f;
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return this.D == 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public synchronized int j() {
        if (!StringUtil.isEmpty(this.C.f406065o)) {
            this.D = 3;
        } else if (this.C.f406067q) {
            this.D = 1;
        }
        return this.D;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        List<f.b> list = this.C.f406066p;
        if (list == null || list.size() == 0) {
            f fVar = this.C;
            fVar.l(fVar.k());
        }
        String h16 = this.C.h(this.H);
        if (QLog.isColorLevel()) {
            QLog.d("QComboNPaster", 2, "unApply id=" + this.f66812m + " name=" + this.H + "url=" + h16);
        }
        if (TextUtils.isEmpty(h16)) {
            return;
        }
        try {
            String name = new File(Uri.parse(h16).getPath()).getName();
            DoodleLayout b16 = com.tencent.aelight.camera.aioeditor.capture.util.b.c().b(i3);
            if (b16 != null) {
                b16.m0().g(this.C.f405989b, name);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public String toString() {
        return "NP@" + this.f66812m + "@" + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements URLDrawable.URLDrawableListener {
        final /* synthetic */ float C;
        final /* synthetic */ float D;
        final /* synthetic */ SegmentKeeper E;
        final /* synthetic */ k F;
        final /* synthetic */ int G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f66814d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f66815e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f66816f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f66817h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f66818i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f66819m;

        a(String str, String str2, f fVar, int i3, int i16, float f16, float f17, float f18, SegmentKeeper segmentKeeper, k kVar, int i17) {
            this.f66814d = str;
            this.f66815e = str2;
            this.f66816f = fVar;
            this.f66817h = i3;
            this.f66818i = i16;
            this.f66819m = f16;
            this.C = f17;
            this.D = f18;
            this.E = segmentKeeper;
            this.F = kVar;
            this.G = i17;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            CaptureComboNormalPaster.J.remove(this.f66815e);
            if (QLog.isColorLevel()) {
                QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadFialed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (QLog.isColorLevel()) {
                QLog.d("QComboNPaster", 2, "urlDrawableListener onLoadSuccessed");
            }
            CaptureComboNormalPaster.z(uRLDrawable, this.f66814d, this.f66815e, this.f66816f, this.f66817h, this.f66818i, this.f66819m, this.C, this.D, this.E, this.F, this.G);
            CaptureComboNormalPaster.J.remove(this.f66815e);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    public CaptureComboNormalPaster(f fVar, String str, String str2, float f16, float f17, float f18) {
        super(null);
        this.D = 2;
        this.f66812m = str;
        this.H = str2;
        this.C = fVar;
        this.E = f16;
        this.F = f17;
        this.G = f18;
        if (QLog.isColorLevel()) {
            QLog.d("QComboNPaster", 2, "create id=" + str + " name=" + str2);
        }
    }

    private static Drawable B(String str, URLDrawable.URLDrawableListener uRLDrawableListener) {
        new File(str).getName();
        URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str, "-Dynamic-", null, new int[]{13}, "-Dynamic-", null);
        if (apngDrawable == null) {
            return null;
        }
        int status = apngDrawable.getStatus();
        if (status == 1) {
            return apngDrawable;
        }
        if (QLog.isColorLevel()) {
            QLog.e("QComboNPaster", 2, "urlDrawable is not  SUCCESSED :" + status);
        }
        apngDrawable.setURLDrawableListener(uRLDrawableListener);
        if (status == 2) {
            apngDrawable.restartDownload();
        } else {
            apngDrawable.startDownload();
        }
        J.put(str, apngDrawable);
        return null;
    }

    public static void A(f fVar, String str, int i3, int i16, float f16, float f17, float f18, SegmentKeeper segmentKeeper, k kVar) {
        if (kVar != null) {
            int j3 = fVar.j(str);
            String h16 = fVar.h(str);
            if (TextUtils.isEmpty(h16)) {
                try {
                    com.tencent.biz.qqstory.utils.d.v(fVar.f406065o);
                } catch (Exception unused) {
                }
                if (QLog.isColorLevel()) {
                    QLog.e("QComboNPaster", 2, "applyNormalPaster uriString error!");
                    return;
                }
                return;
            }
            String path = Uri.parse(h16).getPath();
            String name = new File(path).getName();
            a aVar = new a(name, path, fVar, i3, i16, f16, f17, f18, segmentKeeper, kVar, j3);
            if (j3 != 1) {
                try {
                    z(Drawable.createFromPath(path), name, path, fVar, i3, i16, f16, f17, f18, segmentKeeper, kVar, j3);
                    return;
                } catch (OutOfMemoryError e16) {
                    hd0.c.h("QComboNPaster", "createFromPath error", e16);
                    return;
                }
            }
            try {
                if (!ApngDrawable.isApngFile(new File(path))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QComboNPaster", 2, "applyNormalPaster isApngFile not valid path=" + path);
                        return;
                    }
                    return;
                }
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            z(B(path, aVar), name, path, fVar, i3, i16, f16, f17, f18, segmentKeeper, kVar, j3);
            return;
        }
        throw new IllegalStateException("applyNormalPaster listener is null!");
    }
}
