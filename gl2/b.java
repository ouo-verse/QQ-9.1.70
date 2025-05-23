package gl2;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.pet.data.DownloadDetail;
import com.tencent.mobileqq.qwallet.pet.data.ModelDownloadState;
import com.tencent.mobileqq.qwallet.pet.data.ModelType;
import com.tencent.mobileqq.qwallet.pet.data.e;
import com.tencent.mobileqq.qwallet.pet.data.f;
import com.tencent.mobileqq.qwallet.pet.data.k;
import com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\u000bJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR3\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\"\u00a8\u0006'"}, d2 = {"Lgl2/b;", "Lcom/tencent/mobileqq/qwallet/pet/download/PetDownloadManager$a;", "", "c", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "downloadDetail", "e", "", "petType", "g", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSucceed", "callback", h.F, "url", "", "process", "onDownloadProgress", "filePath", "onDownloadSucceed", "", "errCode", "a", "", "Ljava/util/List;", "f", "()Ljava/util/List;", "necessaryList", "b", "normalList", "Lkotlin/jvm/functions/Function1;", "ensureCallback", "<init>", "()V", "d", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class b implements PetDownloadManager.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<DownloadDetail> necessaryList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<DownloadDetail> normalList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> ensureCallback;

    private final void c() {
        Iterator<T> it = this.necessaryList.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (!((DownloadDetail) it.next()).e()) {
                z16 = false;
            }
        }
        if (z16) {
            QLog.i("QWallet.Pet.BasePreload", 1, "all preload finish");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: gl2.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(b.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Boolean, Unit> function1 = this$0.ensureCallback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    private final void e(DownloadDetail downloadDetail) {
        String str;
        String downloadUrl;
        Unit unit = null;
        if (downloadDetail != null) {
            str = downloadDetail.getDownloadUrl();
        } else {
            str = null;
        }
        QLog.i("QWallet.Pet.BasePreload", 1, "start download " + str);
        if (downloadDetail != null && (downloadUrl = downloadDetail.getDownloadUrl()) != null) {
            PetDownloadManager.f278805a.u(downloadUrl, this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.w("QWallet.Pet.BasePreload", 1, "url is null");
        }
    }

    @Override // com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager.a
    public void a(@NotNull String url, int errCode) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @NotNull
    public final List<DownloadDetail> f() {
        return this.necessaryList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(@Nullable String petType) {
        List<e> list;
        int collectionSizeOrDefault;
        boolean z16;
        int collectionSizeOrDefault2;
        List<e> list2;
        List filterNotNull;
        List filterNotNull2;
        Collection<List<e>> values;
        int collectionSizeOrDefault3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (petType == null) {
            Map<String, List<e>> f16 = f.f278777a.f();
            if (f16 != null && (values = f16.values()) != null) {
                Iterator<T> it = values.iterator();
                while (it.hasNext()) {
                    List list3 = (List) it.next();
                    ArrayList<e> arrayList3 = new ArrayList();
                    for (Object obj : list3) {
                        if (((e) obj).getIsDefault()) {
                            arrayList3.add(obj);
                        }
                    }
                    for (e eVar : arrayList3) {
                        arrayList.add(jl2.b.f410584a.b(ModelType.PET, eVar.getPetDownloadUrl()));
                        List<k> e16 = eVar.e();
                        if (e16 != null) {
                            List<k> list4 = e16;
                            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault3);
                            Iterator<T> it5 = list4.iterator();
                            while (it5.hasNext()) {
                                arrayList4.add(jl2.b.f410584a.b(ModelType.PET, ((k) it5.next()).getSubActionUrl()));
                            }
                            arrayList.addAll(arrayList4);
                        }
                        arrayList2.add(jl2.b.f410584a.b(ModelType.CLOTH, eVar.getClothDownloadUrl()));
                    }
                }
            }
        } else {
            Map<String, List<e>> f17 = f.f278777a.f();
            e eVar2 = null;
            if (f17 != null && (list2 = f17.get(petType)) != null) {
                Iterator<T> it6 = list2.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next = it6.next();
                    if (((e) next).getIsDefault()) {
                        eVar2 = next;
                        break;
                    }
                }
                eVar2 = eVar2;
            }
            if (eVar2 != null) {
                String petDownloadUrl = eVar2.getPetDownloadUrl();
                boolean z17 = false;
                if (petDownloadUrl != null && petDownloadUrl.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.add(jl2.b.f410584a.b(ModelType.PET, eVar2.getPetDownloadUrl()));
                }
                List<k> e17 = eVar2.e();
                if (e17 != null) {
                    List<k> list5 = e17;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
                    ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
                    Iterator<T> it7 = list5.iterator();
                    while (it7.hasNext()) {
                        arrayList5.add(jl2.b.f410584a.b(ModelType.PET, ((k) it7.next()).getSubActionUrl()));
                    }
                    arrayList.addAll(arrayList5);
                }
                String clothDownloadUrl = eVar2.getClothDownloadUrl();
                if (clothDownloadUrl == null || clothDownloadUrl.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    arrayList.add(jl2.b.f410584a.b(ModelType.CLOTH, eVar2.getClothDownloadUrl()));
                }
            }
            Map<String, List<e>> f18 = f.f278777a.f();
            if (f18 != null && (list = f18.get(petType)) != null) {
                ArrayList<e> arrayList6 = new ArrayList();
                for (Object obj2 : list) {
                    if (!((e) obj2).getIsDefault()) {
                        arrayList6.add(obj2);
                    }
                }
                for (e eVar3 : arrayList6) {
                    arrayList2.add(jl2.b.f410584a.b(ModelType.PET, eVar3.getPetDownloadUrl()));
                    List<k> e18 = eVar3.e();
                    if (e18 != null) {
                        List<k> list6 = e18;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
                        ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault);
                        Iterator<T> it8 = list6.iterator();
                        while (it8.hasNext()) {
                            arrayList7.add(jl2.b.f410584a.b(ModelType.PET, ((k) it8.next()).getSubActionUrl()));
                        }
                        arrayList2.addAll(arrayList7);
                    }
                    arrayList2.add(jl2.b.f410584a.b(ModelType.CLOTH, eVar3.getClothDownloadUrl()));
                }
            }
        }
        List<DownloadDetail> list7 = this.necessaryList;
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        ArrayList arrayList8 = new ArrayList();
        for (Object obj3 : filterNotNull) {
            if (!((DownloadDetail) obj3).e()) {
                arrayList8.add(obj3);
            }
        }
        list7.addAll(arrayList8);
        List<DownloadDetail> list8 = this.normalList;
        filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(arrayList2);
        ArrayList arrayList9 = new ArrayList();
        for (Object obj4 : filterNotNull2) {
            if (!((DownloadDetail) obj4).e()) {
                arrayList9.add(obj4);
            }
        }
        list8.addAll(arrayList9);
    }

    public final void h(@NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.ensureCallback = callback;
        Iterator<T> it = this.necessaryList.iterator();
        while (it.hasNext()) {
            e((DownloadDetail) it.next());
        }
        Iterator<T> it5 = this.normalList.iterator();
        while (it5.hasNext()) {
            e((DownloadDetail) it5.next());
        }
        c();
    }

    @Override // com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager.a
    public void onDownloadProgress(@NotNull String url, float process) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.tencent.mobileqq.qwallet.pet.download.PetDownloadManager.a
    public void onDownloadSucceed(@NotNull String url, @NotNull String filePath) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        QLog.d("QWallet.Pet.BasePreload", 1, "onDownloadSucceed " + url + " " + filePath);
        Iterator<T> it = this.necessaryList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((DownloadDetail) obj).getDownloadUrl(), url)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        DownloadDetail downloadDetail = (DownloadDetail) obj;
        if (downloadDetail != null) {
            downloadDetail.f(ModelDownloadState.DOWNLOADED);
            downloadDetail.g(filePath);
            downloadDetail.h(jl2.b.f410584a.g(downloadDetail.getModelType(), filePath));
            c();
        }
    }
}
