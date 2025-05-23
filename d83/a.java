package d83;

import a83.b;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.intermediate.TemplateLibIntermediateServiceHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a extends BaseViewModel implements BusinessObserver {

    /* renamed from: i, reason: collision with root package name */
    private final MutableLiveData<a83.a> f393201i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<b> f393202m = new MutableLiveData<>();
    private String C = "";
    private String D = "";

    public a() {
        com.tencent.mobileqq.wink.b.a().addDefaultObservers(this);
    }

    public LiveData<a83.a> M1() {
        return this.f393201i;
    }

    public LiveData<b> N1() {
        return this.f393202m;
    }

    public void O1(String str) {
        QLog.d("TemplateLibIntermediateViewModel", 1, "requestMateCategory, materialId: " + str);
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.g("TemplateLibIntermediateViewModel", "requestMateCategory, no network....");
            a83.a aVar = new a83.a();
            aVar.f25719b = -1;
            this.f393201i.postValue(aVar);
            return;
        }
        if (TextUtils.isEmpty(this.C)) {
            this.C = str;
        }
        this.D = str;
        ((TemplateLibIntermediateServiceHandler) com.tencent.mobileqq.wink.b.a().getBusinessHandler(TemplateLibIntermediateServiceHandler.class.getName())).n3("MqKuaishanTemplate", str);
    }

    public void P1(MetaMaterial metaMaterial) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestMaterialRes, metaMaterial: ");
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        } else {
            str = "metaMaterial is null";
        }
        sb5.append(str);
        QLog.d("TemplateLibIntermediateViewModel", 1, sb5.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(metaMaterial);
        Boolean[] boolArr = new Boolean[arrayList.size()];
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            MetaMaterial metaMaterial2 = (MetaMaterial) arrayList.get(i3);
            WinkEditorResourceManager.a1().j0(metaMaterial2.f30533id);
            WinkEditorResourceManager.a1().f(metaMaterial2, new C10166a(metaMaterial2, boolArr, i3, metaMaterial));
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TemplateLibIntermediateViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        com.tencent.mobileqq.wink.b.a().removeObserver(this);
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [R, camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory] */
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        QLog.d("TemplateLibIntermediateViewModel", 1, "onUpdate, type: " + i3 + ", isSuccess: " + z16);
        if (z16) {
            try {
                a83.a aVar = new a83.a();
                MetaMaterial metaMaterial = (MetaMaterial) ((Map) obj).get(this.D);
                if (metaMaterial != null) {
                    QLog.d("TemplateLibIntermediateViewModel", 1, "onUpdate postResult");
                    aVar.f25719b = 1;
                    ?? metaCategory = new MetaCategory();
                    ArrayList<MetaMaterial> arrayList = new ArrayList<>();
                    arrayList.add(metaMaterial);
                    metaCategory.materials = arrayList;
                    aVar.f25718a = metaCategory;
                    this.f393201i.postValue(aVar);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("TemplateLibIntermediateViewModel", 1, "onUpdate error ", e16);
                return;
            }
        }
        a83.a aVar2 = new a83.a();
        aVar2.f25719b = -2;
        this.f393201i.postValue(aVar2);
    }

    /* compiled from: P */
    /* renamed from: d83.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class C10166a implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f393203a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Boolean[] f393204b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f393205c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f393206d;

        C10166a(MetaMaterial metaMaterial, Boolean[] boolArr, int i3, MetaMaterial metaMaterial2) {
            this.f393203a = metaMaterial;
            this.f393204b = boolArr;
            this.f393205c = i3;
            this.f393206d = metaMaterial2;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [R, camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial] */
        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean z16) {
            QLog.d("TemplateLibIntermediateViewModel", 1, "onDownloadFinish, isSuccess: " + z16 + "template path:" + WinkEditorResourceManager.a1().m(this.f393203a) + ", isTemplateFileExits:" + WinkEditorResourceManager.a1().s(this.f393203a));
            this.f393204b[this.f393205c] = Boolean.valueOf(z16);
            Boolean[] boolArr = this.f393204b;
            int length = boolArr.length;
            boolean z17 = true;
            boolean z18 = true;
            for (int i3 = 0; i3 < length; i3++) {
                Boolean bool = boolArr[i3];
                if (bool == null) {
                    z17 = false;
                } else if (!bool.booleanValue()) {
                    z18 = false;
                }
            }
            if (z17) {
                b bVar = new b();
                if (z18) {
                    bVar.f25719b = 1;
                    bVar.f25718a = this.f393206d;
                    a.this.f393202m.postValue(bVar);
                    return;
                }
                a.this.f393202m.postValue(bVar);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int i3) {
        }
    }
}
