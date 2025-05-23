package com.tencent.mobileqq.emosm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.k;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class BaseEmosmStrategy implements n {

    /* renamed from: a, reason: collision with root package name */
    protected BaseQQAppInterface f204070a;

    /* renamed from: b, reason: collision with root package name */
    k f204071b;

    /* renamed from: c, reason: collision with root package name */
    AtomicBoolean f204072c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    List<FavoriteEmoticonInfo> f204073d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f204074e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f204075f = false;

    /* renamed from: g, reason: collision with root package name */
    MultiEmotionSaveManager f204076g;

    public BaseEmosmStrategy(BaseQQAppInterface baseQQAppInterface, k kVar) {
        this.f204076g = null;
        this.f204070a = baseQQAppInterface;
        this.f204071b = kVar;
        this.f204076g = new MultiEmotionSaveManager(baseQQAppInterface);
    }

    public void c(CustomEmotionRoamingDBManagerBase.a aVar) {
        a().asyncGetFavEmotionInfoShowedInPanel(aVar);
    }

    public abstract void d();

    public List<EmoticonInfo> e(List<EmoticonInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (EmoticonInfo emoticonInfo : list) {
            if (emoticonInfo instanceof CameraEmoticonInfo) {
                CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
                if (!TextUtils.isEmpty(cameraEmoticonInfo.roamingType) && !cameraEmoticonInfo.roamingType.equals("needUpload")) {
                    arrayList.add(emoticonInfo);
                }
            } else if (emoticonInfo instanceof FavoriteEmoticonInfo) {
                FavoriteEmoticonInfo favoriteEmoticonInfo = (FavoriteEmoticonInfo) emoticonInfo;
                if (!TextUtils.isEmpty(favoriteEmoticonInfo.roamingType) && !favoriteEmoticonInfo.roamingType.equals("needUpload")) {
                    arrayList.add(emoticonInfo);
                }
            } else {
                arrayList.add(emoticonInfo);
            }
        }
        return arrayList;
    }

    public abstract String f(EmoticonInfo emoticonInfo);

    public MultiEmotionSaveManager g() {
        return this.f204076g;
    }

    public boolean i(Activity activity) {
        return false;
    }

    public boolean j() {
        return true;
    }

    public boolean k() {
        return false;
    }

    public void l(int i3, int i16, Intent intent) {
        if (i3 == 10015) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseEmosmStrategy", 2, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW");
            }
            if (intent != null) {
                AlbumResult albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT");
                if (albumResult == null) {
                    QLog.e("BaseEmosmStrategy", 1, "onActivityResult, AlbumResult is null");
                    return;
                }
                List<LocalMediaInfo> e16 = albumResult.e();
                if (e16 == null) {
                    QLog.e("BaseEmosmStrategy", 1, "onActivityResult, getSelectList is null");
                    return;
                }
                final ArrayList arrayList = new ArrayList();
                Iterator<LocalMediaInfo> it = e16.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getPath());
                }
                if (!arrayList.isEmpty()) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.BaseEmosmStrategy.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.emosm.favroaming.f.e(arrayList);
                            ReportController.o(null, "dc00898", "", "", "0X800A6E1", "0X800A6E1", 0, 0, "", "", "", "");
                        }
                    }, 64, null, false);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("BaseEmosmStrategy", 2, "onActivityResult, selected is empty");
                        return;
                    }
                    return;
                }
            }
            QLog.e("BaseEmosmStrategy", 1, "onActivityResult, PeakConstants.REQUEST_CODE_FOR_PHOTO_PREVIEW, data is null");
        }
    }

    public boolean m(AdapterView<?> adapterView, View view, int i3, long j3) {
        return false;
    }

    public void n() {
        this.f204072c.set(false);
    }

    public void o() {
        this.f204076g.onDestroy();
        this.f204071b = null;
    }

    public void p(Context context, Intent intent) {
        if (this.f204071b == null) {
            return;
        }
        String action = intent.getAction();
        if ("com.tencent.mobileqq.action.refresh.emotiom".equals(action)) {
            this.f204071b.K();
            return;
        }
        if ("com.tencent.mobileqq.action.upload.emotiom".equals(action)) {
            if (QLog.isColorLevel()) {
                QLog.d("BaseEmosmStrategy", 2, "onReceive ACTION_UPLOAD_EMOTION");
            }
            final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
            if (stringArrayListExtra != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.BaseEmosmStrategy.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.mobileqq.emosm.favroaming.f.e(stringArrayListExtra);
                        ReportController.o(null, "dc00898", "", "", "0X800A6E1", "0X800A6E1", 0, 0, "", "", "", "");
                    }
                }, 64, null, false);
            } else if (QLog.isColorLevel()) {
                QLog.d("BaseEmosmStrategy", 2, "onReceive selected is empty");
            }
        }
    }

    public void q() {
        k kVar = this.f204071b;
        if (kVar == null) {
            return;
        }
        List<EmoticonInfo> list = kVar.N;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (k()) {
            if (list.size() > 0) {
                if (list.get(0).operateType != 1) {
                    EmoticonInfo emoticonInfo = new EmoticonInfo();
                    emoticonInfo.operateType = 1;
                    list.add(0, emoticonInfo);
                }
            } else {
                EmoticonInfo emoticonInfo2 = new EmoticonInfo();
                emoticonInfo2.operateType = 1;
                list.add(0, emoticonInfo2);
            }
        }
        this.f204071b.P(list);
    }

    public void r() {
        k kVar = this.f204071b;
        if (kVar == null) {
            return;
        }
        List<EmoticonInfo> e16 = e(kVar.N);
        if (e16 == null) {
            e16 = new ArrayList<>();
        }
        if (e16.size() > 0 && e16.get(0).operateType == 1) {
            e16.remove(0);
        }
        this.f204071b.P(e16);
    }

    public abstract void s();

    public abstract void t();

    public abstract void u(GridView gridView, int i3, IFavoriteEmoticonInfo iFavoriteEmoticonInfo);

    public View h(int i3, View view, k.e eVar, EmoticonInfo emoticonInfo) {
        return view;
    }
}
