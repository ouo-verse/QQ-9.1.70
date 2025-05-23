package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;
import com.tencent.component.network.utils.thread.AsyncTask;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends com.tencent.aelight.camera.aioeditor.capture.data.a {
    public float C;
    public boolean D;
    b E;

    /* renamed from: m, reason: collision with root package name */
    FilterDesc f66710m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f66711a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f66712b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f66713c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f66714d;

        a(boolean z16, boolean z17, List list, boolean z18) {
            this.f66711a = z16;
            this.f66712b = z17;
            this.f66713c = list;
            this.f66714d = z18;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.component.network.utils.thread.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            Exception e16;
            Bitmap bitmap;
            Error e17;
            Bitmap bitmap2 = null;
            try {
                bitmap = m.n().s();
                if (bitmap == null) {
                    return bitmap;
                }
                try {
                    if (bitmap.isRecycled()) {
                        return bitmap;
                    }
                    if (!this.f66711a) {
                        if (this.f66712b) {
                            if (EditVideoPartManager.f67776s0 != null) {
                                mr.a aVar = new mr.a();
                                aVar.f(EditVideoPartManager.f67776s0.f417219h, bitmap.getWidth(), bitmap.getHeight());
                                bitmap2 = aVar.j(bitmap, this.f66713c, EditVideoPartManager.f67776s0);
                            }
                        } else {
                            mr.a aVar2 = new mr.a();
                            aVar2.e(bitmap.getWidth(), bitmap.getHeight());
                            Bitmap i3 = aVar2.i(bitmap, this.f66713c, this.f66714d);
                            aVar2.b();
                            bitmap2 = i3;
                        }
                        return bitmap2 != null ? bitmap2 : bitmap;
                    }
                    return bitmap.copy(bitmap.getConfig(), true);
                } catch (Error e18) {
                    e17 = e18;
                    if (!QLog.isColorLevel()) {
                        return bitmap;
                    }
                    QLog.d("QCombo", 1, "applyFiltersForEditPic error!", e17);
                    return bitmap;
                } catch (Exception e19) {
                    e16 = e19;
                    if (!QLog.isColorLevel()) {
                        return bitmap;
                    }
                    QLog.d("QCombo", 1, "applyFiltersForEditPic excep!", e16);
                    return bitmap;
                }
            } catch (Error e26) {
                e17 = e26;
                bitmap = null;
            } catch (Exception e27) {
                e16 = e27;
                bitmap = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.component.network.utils.thread.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            EditVideoPartManager p16 = m.n().p();
            if (p16 == null || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            p16.e1(bitmap, true);
            p16.d1();
        }
    }

    public c(FilterDesc filterDesc) {
        super(filterDesc);
        this.C = -1.0f;
        this.D = false;
        this.E = new b();
        this.f66710m = filterDesc;
    }

    public static void s(Context context, List<FilterDesc> list) {
        String resFold;
        m n3 = m.n();
        QQFilterRenderManager b16 = com.tencent.mobileqq.filter.f.b(com.tencent.mobileqq.filter.f.f209752b);
        if (b16 == null && ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FilterDesc> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FilterDesc next = it.next();
            if (next.name.equals(PatternUtils.NO_MATCH)) {
                if (!((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()) {
                    ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
                    ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(null);
                }
                arrayList = null;
            } else {
                if (next.f281357id == 9) {
                    arrayList.clear();
                    arrayList.add(next);
                    break;
                }
                arrayList.add(next);
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("applyFiltersForCapture filters:");
            sb5.append(arrayList == null ? 0 : arrayList.size());
            QLog.d("QCombo", 2, sb5.toString());
        }
        n3.N(null);
        if (b16 != null) {
            b16.getBusinessOperation().setFilterEffectList(arrayList);
        }
        if (((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty() || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        String filterResPath = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        FilterDesc filterDesc = arrayList.get(0);
        if (!TextUtils.isEmpty(filterDesc.resRootPath)) {
            resFold = filterDesc.getResFold(filterDesc.resRootPath);
        } else {
            resFold = filterDesc.getResFold(filterResPath);
        }
        String str = resFold + filterDesc.respicname;
        if (new File(str).exists()) {
            ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
            ((IAEFilterManagerHolder) QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(str);
        }
    }

    public static void t(List<FilterDesc> list, boolean z16) {
        m n3 = m.n();
        QQFilterRenderManager b16 = com.tencent.mobileqq.filter.f.b(com.tencent.mobileqq.filter.f.f209752b);
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCombo", 2, "applyFiltersForCapture QQFilterRenderManager null");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FilterDesc> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FilterDesc next = it.next();
            if (next.name.equals(PatternUtils.NO_MATCH)) {
                arrayList = null;
                break;
            } else {
                if (next.f281357id == 9) {
                    arrayList.clear();
                    arrayList.add(next);
                    break;
                }
                arrayList.add(next);
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("applyFiltersForCapture filters:");
            sb5.append(arrayList == null ? 0 : arrayList.size());
            QLog.d("QCombo", 2, sb5.toString());
        }
        n3.N(null);
        b16.getBusinessOperation().setFilterEffectList(arrayList, z16);
    }

    public static void u(List<FilterDesc> list, boolean z16) {
        boolean z17;
        boolean z18;
        ArrayList arrayList = new ArrayList();
        Iterator<FilterDesc> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z17 = false;
                z18 = false;
                break;
            }
            FilterDesc next = it.next();
            z18 = true;
            if (next.name.equals(PatternUtils.NO_MATCH)) {
                arrayList.clear();
                z17 = false;
                break;
            } else {
                if (next.f281357id == 9) {
                    arrayList.clear();
                    arrayList.add(next);
                    z17 = true;
                    z18 = false;
                    break;
                }
                arrayList.add(next);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "applyFiltersForEditPic filters:" + arrayList.size());
        }
        new a(z18, z17, arrayList, z16).execute(new Void[0]);
    }

    public static void v(List<FilterDesc> list, boolean z16) {
        m n3 = m.n();
        QQFilterRenderManager b16 = com.tencent.mobileqq.filter.f.b(com.tencent.mobileqq.filter.f.f209753c);
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QCombo", 2, "applyFiltersForEditVideo null manager");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<FilterDesc> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            FilterDesc next = it.next();
            if (next.name.equals(PatternUtils.NO_MATCH)) {
                arrayList = null;
                break;
            } else {
                if (next.f281357id == 9) {
                    arrayList.clear();
                    arrayList.add(next);
                    break;
                }
                arrayList.add(next);
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("applyFiltersForEditVideo filters:");
            sb5.append(arrayList == null ? 0 : arrayList.size());
            QLog.d("QCombo", 2, sb5.toString());
        }
        b16.getBusinessOperation().setFilterEffectList(arrayList);
        n3.N(null);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int g(Activity activity, int i3) {
        return 0;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int h() {
        if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "download: " + this.f66710m.predownload + ", iconurl: " + this.f66710m.iconurl + ", resurl:" + this.f66710m.resurl);
        }
        VideoFilterListDownloader.f().c(this.f66710m, this.E);
        l();
        return super.h();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public float i() {
        return 0.5f;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public int j() {
        float f16 = this.C;
        if (f16 == 1.0f) {
            x(3);
            return 3;
        }
        if (f16 >= 0.0f) {
            x(1);
            return 1;
        }
        String resFold = this.f66710m.getResFold(com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j);
        if (!TextUtils.isEmpty(this.f66710m.resurl) && !TextUtils.isEmpty(resFold) && VideoFilterListDownloader.e(this.f66710m)) {
            x(2);
            return 2;
        }
        x(3);
        return 3;
    }

    public String toString() {
        return "Filter@" + this.f66710m.name + "@" + hashCode();
    }

    public void x(int i3) {
        this.f66706e = i3;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements VideoFilterListDownloader.c {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader.c
        public void a(boolean z16) {
            if (z16) {
                c.this.n();
            } else {
                c.this.m(4);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.data.a
    public void q(Activity activity, int i3) {
        if (i3 == 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f66710m);
            t(arrayList, false);
        }
    }

    public static int r(Context context, List<FilterDesc> list, CaptureSet captureSet, int i3) {
        if (i3 == 0) {
            s(context, list);
        } else {
            if (i3 == 2 || i3 == 4) {
                v(list, i3 == 2);
            } else if (i3 == 1 || i3 == 3) {
                u(list, i3 == 1);
            }
        }
        return 0;
    }

    public static boolean w(h hVar, int i3) {
        if (hVar == null) {
            return false;
        }
        h hVar2 = m.n().f66502i[i3];
        boolean z16 = hVar2 != null && hVar.t().equals(hVar2.t());
        if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "isApplying :" + hVar + " ", Boolean.valueOf(z16));
        }
        return z16;
    }
}
