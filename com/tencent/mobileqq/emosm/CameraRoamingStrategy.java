package com.tencent.mobileqq.emosm;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.impl.CameraEmotionRoamingDBManagerServiceImpl;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CameraRoamingStrategy extends BaseEmosmStrategy {

    /* renamed from: h, reason: collision with root package name */
    private ICameraEmotionRoamingDBManagerService f204079h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f204080i;

    /* renamed from: j, reason: collision with root package name */
    protected List<CameraEmoticonInfo> f204081j;

    /* renamed from: k, reason: collision with root package name */
    CameraEmoRoamingObserver f204082k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements CustomEmotionRoamingDBManagerBase.a {
        a() {
        }

        @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.a
        public void callbackInMainThread(List<EmoticonInfo> list) {
            k kVar = CameraRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.C(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements CustomEmotionRoamingDBManagerBase.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomEmotionRoamingDBManagerBase.a f204085a;

        b(CustomEmotionRoamingDBManagerBase.a aVar) {
            this.f204085a = aVar;
        }

        @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase.a
        public void callbackInMainThread(List<EmoticonInfo> list) {
            CameraRoamingStrategy.this.w(list);
            CustomEmotionRoamingDBManagerBase.a aVar = this.f204085a;
            if (aVar != null) {
                aVar.callbackInMainThread(list);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c extends CameraEmoRoamingObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.app.CameraEmoRoamingObserver
        protected void doOnDeleteEmoResult(int i3) {
            CameraRoamingStrategy.this.f204080i = false;
            k kVar = CameraRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.K();
            }
        }

        @Override // com.tencent.mobileqq.app.CameraEmoRoamingObserver
        protected void doOnGetEmoListResult(int i3) {
            k kVar;
            if (i3 == 0 && (kVar = CameraRoamingStrategy.this.f204071b) != null) {
                kVar.K();
            }
        }

        @Override // com.tencent.mobileqq.app.CameraEmoRoamingObserver
        protected void onCameraEmoSend(boolean z16, int i3) {
            k kVar = CameraRoamingStrategy.this.f204071b;
            if (kVar != null) {
                kVar.K();
            }
        }
    }

    public CameraRoamingStrategy(BaseQQAppInterface baseQQAppInterface, k kVar) {
        super(baseQQAppInterface, kVar);
        this.f204080i = false;
        this.f204081j = new ArrayList();
        this.f204082k = new c();
    }

    private List<? extends EmoticonInfo> x() {
        return this.f204081j;
    }

    @Override // com.tencent.mobileqq.emosm.n
    public CustomEmotionRoamingDBManagerBase<CameraEmotionData> a() {
        if (this.f204079h == null) {
            this.f204079h = (ICameraEmotionRoamingDBManagerService) this.f204070a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        }
        return (CameraEmotionRoamingDBManagerServiceImpl) this.f204079h;
    }

    @Override // com.tencent.mobileqq.emosm.n
    public void b() {
        if (this.f204080i) {
            QLog.e("CameraRoamingStrategy", 1, "doDelEmotion,  camera data deleting");
            return;
        }
        this.f204080i = true;
        final ArrayList arrayList = new ArrayList();
        List<CameraEmotionData> emoticonDataList = a().getEmoticonDataList();
        List<? extends EmoticonInfo> x16 = x();
        if (emoticonDataList != null) {
            for (EmoticonInfo emoticonInfo : x16) {
                if (emoticonInfo instanceof CameraEmoticonInfo) {
                    CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
                    for (CameraEmotionData cameraEmotionData : emoticonDataList) {
                        if (cameraEmotionData != null && cameraEmoticonInfo.emoId == cameraEmotionData.emoId && cameraEmoticonInfo.isChecked) {
                            cameraEmoticonInfo.isChecked = false;
                            arrayList.add(cameraEmotionData);
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.emosm.CameraRoamingStrategy.3
                @Override // java.lang.Runnable
                public void run() {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        CameraEmotionData cameraEmotionData2 = (CameraEmotionData) arrayList.get(i3);
                        if (!TextUtils.isEmpty(cameraEmotionData2.resid)) {
                            cameraEmotionData2.RomaingType = "needDel";
                            CameraRoamingStrategy.this.a().updateCustomEmotion(cameraEmotionData2);
                            ReportController.o(CameraRoamingStrategy.this.f204070a, "dc00898", "", "", "0X800A372", "0X800A372", 0, 0, "", "", cameraEmotionData2.resid, "");
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("CameraRoamingStrategy", 2, "delete from local, Roma Type: " + cameraEmotionData2.RomaingType);
                            }
                            CameraRoamingStrategy.this.a().deleteCustomEmotion(cameraEmotionData2);
                        }
                    }
                    ((ICameraEmoRoamingManagerService) CameraRoamingStrategy.this.f204070a.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncLocalDel();
                    ((CameraEmoRoamingHandler) CameraRoamingStrategy.this.f204070a.getBusinessHandler(CameraEmoRoamingHandler.f194459e)).H2(3, true, 0);
                }
            }, 5, null, false);
        } else {
            this.f204080i = false;
        }
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void c(CustomEmotionRoamingDBManagerBase.a aVar) {
        a().asyncGetFavEmotionInfoShowedInPanel(new b(aVar));
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void d() {
        if (QLog.isColorLevel()) {
            QLog.d("CameraRoamingStrategy", 2, "doSyncEmotion");
        }
        if (this.f204070a == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
            @Override // java.lang.Runnable
            public void run() {
                BaseQQAppInterface baseQQAppInterface = CameraRoamingStrategy.this.f204070a;
                if (baseQQAppInterface != null && NetworkUtil.isNetSupport(baseQQAppInterface.getApp())) {
                    ((ICameraEmoRoamingManagerService) CameraRoamingStrategy.this.f204070a.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncRoaming();
                }
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public String f(EmoticonInfo emoticonInfo) {
        if (emoticonInfo instanceof CameraEmoticonInfo) {
            String str = ((CameraEmoticonInfo) emoticonInfo).contextKey;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            return String.format(BaseApplication.getContext().getString(R.string.cl5), str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void n() {
        super.n();
        this.f204070a.addObserver(this.f204082k);
        this.f204071b.Q(R.string.f170879in3);
        this.f204080i = false;
        if (this.f204079h == null) {
            this.f204079h = (ICameraEmotionRoamingDBManagerService) this.f204070a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class);
        }
        y();
        z();
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void o() {
        super.o();
        this.f204070a.removeObserver(this.f204082k);
        this.f204080i = false;
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void s() {
        ReportController.o(this.f204070a, "dc00898", "", "", "ep_mall", "0X800A6AC", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void t() {
        ReportController.o(this.f204070a, "dc00898", "", "", "ep_mall", "0X800A6AD", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.emosm.BaseEmosmStrategy
    public void u(GridView gridView, int i3, IFavoriteEmoticonInfo iFavoriteEmoticonInfo) {
        List<CameraEmotionData> emoticonDataList = ((ICameraEmotionRoamingDBManagerService) this.f204070a.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getEmoticonDataList();
        if (emoticonDataList == null) {
            return;
        }
        int emoId = iFavoriteEmoticonInfo.getEmoId();
        for (CameraEmotionData cameraEmotionData : emoticonDataList) {
            int i16 = cameraEmotionData.emoId;
            if (i16 == emoId) {
                QLog.d("CameraRoamingStrategy", 1, "resend, emoId:", Integer.valueOf(i16));
                cameraEmotionData.RomaingType = "needUpload";
                ((CameraEmoticonInfo) iFavoriteEmoticonInfo).roamingType = "needUpload";
                k kVar = this.f204071b;
                if (kVar != null) {
                    kVar.Y(gridView, i3);
                }
                CameraEmoAllSend.S = false;
                ThreadManagerV2.excute(new CameraEmoSingleSend(cameraEmotionData, true), 64, null, false);
            }
        }
    }

    public void w(List<EmoticonInfo> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (EmoticonInfo emoticonInfo : list) {
                if (emoticonInfo instanceof CameraEmoticonInfo) {
                    CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
                    cameraEmoticonInfo.isChecked = false;
                    Iterator<CameraEmoticonInfo> it = this.f204081j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CameraEmoticonInfo next = it.next();
                        if (cameraEmoticonInfo.emoId == next.emoId) {
                            cameraEmoticonInfo.isChecked = next.isChecked;
                            break;
                        }
                    }
                    arrayList.add(cameraEmoticonInfo);
                }
            }
            this.f204081j = arrayList;
            return;
        }
        this.f204081j.clear();
    }

    protected void y() {
        this.f204071b.G.setVisibility(8);
        this.f204071b.H.setVisibility(8);
    }

    protected void z() {
        c(new a());
    }
}
