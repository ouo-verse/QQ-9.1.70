package com.tencent.mobileqq.wink.templatelibrary.viewmodel;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.b;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.c;
import com.tencent.mobileqq.wink.templatelibrary.WinkTemplateServiceHandler;
import com.tencent.mobileqq.wink.templatelibrary.request.WinkInspirationTopicRequest;
import com.tencent.mobileqq.wink.utils.aw;
import feedcloud.FeedCloudActivityLandingPage$GetActivityTopicListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0006H\u0014J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016R#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R'\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u000e0$j\b\u0012\u0004\u0012\u00020\u000e`%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001e8\u0006\u00a2\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010\"\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/viewmodel/WinkTemplateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "", "X1", "", "favouriteIds", "", "O1", "metaCategory", "id", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "P1", "serviceId", "W1", "", "limit", "offset", "T1", "onCleared", "type", "", "isSuccess", "", "data", "onUpdate", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "categoriesLiveData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "R1", "()Ljava/util/ArrayList;", "favoriteMaterials", "Lfeedcloud/FeedCloudActivityLandingPage$GetActivityTopicListRsp;", BdhLogUtil.LogTag.Tag_Conn, "S1", "inspirationTopicLiveData", "<init>", "()V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkTemplateViewModel extends BaseViewModel implements BusinessObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<FeedCloudActivityLandingPage$GetActivityTopicListRsp> inspirationTopicLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<MetaCategory>> categoriesLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MetaMaterial> favoriteMaterials;

    public WinkTemplateViewModel() {
        b.a().addDefaultObservers(this);
        this.categoriesLiveData = new MutableLiveData<>();
        this.favoriteMaterials = new ArrayList<>();
        this.inspirationTopicLiveData = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MetaCategory> O1(List<MetaCategory> categories, List<String> favouriteIds) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        MetaCategory metaCategory = new MetaCategory();
        metaCategory.f30532id = "TEMPLATE_FAVORITE";
        metaCategory.name = "\u6536\u85cf";
        metaCategory.materials = this.favoriteMaterials;
        List<MetaCategory> list = categories;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            arrayList.addAll(list);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String str : favouriteIds) {
                Iterator<T> it = categories.iterator();
                while (it.hasNext()) {
                    MetaMaterial P1 = P1((MetaCategory) it.next(), str);
                    if (P1 != null && !linkedHashSet.contains(P1.f30533id)) {
                        metaCategory.materials.add(P1);
                        String str2 = P1.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str2, "material.id");
                        linkedHashSet.add(str2);
                    }
                }
            }
        }
        arrayList.add(0, metaCategory);
        return arrayList;
    }

    private final MetaMaterial P1(MetaCategory metaCategory, String id5) {
        Object obj;
        ArrayList<MetaMaterial> arrayList = metaCategory.materials;
        Intrinsics.checkNotNullExpressionValue(arrayList, "metaCategory.materials");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MetaMaterial) obj).f30533id, id5)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (MetaMaterial) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(WinkTemplateViewModel this$0, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudActivityLandingPage$GetActivityTopicListRsp feedCloudActivityLandingPage$GetActivityTopicListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.a("WinkTemplateViewModel", "success:" + z16 + ", code:" + j3 + ", msg:" + str);
        if (!z16) {
            return;
        }
        Intrinsics.checkNotNull(feedCloudActivityLandingPage$GetActivityTopicListRsp, "null cannot be cast to non-null type feedcloud.FeedCloudActivityLandingPage.GetActivityTopicListRsp");
        w53.b.a("WinkTemplateViewModel", "topics.size:" + feedCloudActivityLandingPage$GetActivityTopicListRsp.topics.size() + ", total:" + feedCloudActivityLandingPage$GetActivityTopicListRsp.total.get() + ", isFinish:" + feedCloudActivityLandingPage$GetActivityTopicListRsp.is_finish.get());
        this$0.inspirationTopicLiveData.postValue(feedCloudActivityLandingPage$GetActivityTopicListRsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(List<MetaCategory> categories) {
        Map<String, Set<String>> b16 = com.tencent.mobileqq.wink.templatelibrary.a.b();
        for (MetaCategory metaCategory : categories) {
            if (b16.containsKey(metaCategory.f30532id)) {
                Set<String> set = b16.get(metaCategory.f30532id);
                Iterator<MetaMaterial> it = metaCategory.materials.iterator();
                while (it.hasNext()) {
                    MetaMaterial material = it.next();
                    Intrinsics.checkNotNull(set);
                    if (set.contains(material.f30533id)) {
                        Intrinsics.checkNotNullExpressionValue(material, "material");
                        c.m1(material, "0");
                    }
                }
            }
        }
    }

    @NotNull
    public final MutableLiveData<List<MetaCategory>> Q1() {
        return this.categoriesLiveData;
    }

    @NotNull
    public final ArrayList<MetaMaterial> R1() {
        return this.favoriteMaterials;
    }

    @NotNull
    public final MutableLiveData<FeedCloudActivityLandingPage$GetActivityTopicListRsp> S1() {
        return this.inspirationTopicLiveData;
    }

    public final void T1(int limit, int offset) {
        w53.b.f("WinkTemplateViewModel", "[requestInspirationTopic]");
        VSNetworkHelper.getInstance().sendRequest(new WinkInspirationTopicRequest(4, limit, offset), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.templatelibrary.viewmodel.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                WinkTemplateViewModel.U1(WinkTemplateViewModel.this, baseRequest, z16, j3, str, (FeedCloudActivityLandingPage$GetActivityTopicListRsp) obj);
            }
        });
    }

    public final void W1(@NotNull String serviceId) {
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        w53.b.f("WinkTemplateViewModel", "[requestTemplates]");
        BusinessHandler businessHandler = b.a().getBusinessHandler(WinkTemplateServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.templatelibrary.WinkTemplateServiceHandler");
        ((WinkTemplateServiceHandler) businessHandler).m3(serviceId);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkTemplateViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        b.a().removeObserver(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[Catch: Exception -> 0x00fa, TryCatch #0 {Exception -> 0x00fa, blocks: (B:3:0x0003, B:5:0x0008, B:6:0x000c, B:8:0x0013, B:13:0x001f, B:15:0x0047, B:18:0x0050, B:21:0x0060, B:23:0x0066, B:24:0x006d, B:26:0x0073, B:30:0x0087, B:32:0x008b, B:33:0x008f, B:35:0x0095, B:36:0x009f, B:38:0x00c5, B:40:0x00da), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073 A[Catch: Exception -> 0x00fa, TryCatch #0 {Exception -> 0x00fa, blocks: (B:3:0x0003, B:5:0x0008, B:6:0x000c, B:8:0x0013, B:13:0x001f, B:15:0x0047, B:18:0x0050, B:21:0x0060, B:23:0x0066, B:24:0x006d, B:26:0x0073, B:30:0x0087, B:32:0x008b, B:33:0x008f, B:35:0x0095, B:36:0x009f, B:38:0x00c5, B:40:0x00da), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: Exception -> 0x00fa, TryCatch #0 {Exception -> 0x00fa, blocks: (B:3:0x0003, B:5:0x0008, B:6:0x000c, B:8:0x0013, B:13:0x001f, B:15:0x0047, B:18:0x0050, B:21:0x0060, B:23:0x0066, B:24:0x006d, B:26:0x0073, B:30:0x0087, B:32:0x008b, B:33:0x008f, B:35:0x0095, B:36:0x009f, B:38:0x00c5, B:40:0x00da), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[Catch: Exception -> 0x00fa, TryCatch #0 {Exception -> 0x00fa, blocks: (B:3:0x0003, B:5:0x0008, B:6:0x000c, B:8:0x0013, B:13:0x001f, B:15:0x0047, B:18:0x0050, B:21:0x0060, B:23:0x0066, B:24:0x006d, B:26:0x0073, B:30:0x0087, B:32:0x008b, B:33:0x008f, B:35:0x0095, B:36:0x009f, B:38:0x00c5, B:40:0x00da), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5 A[Catch: Exception -> 0x00fa, TryCatch #0 {Exception -> 0x00fa, blocks: (B:3:0x0003, B:5:0x0008, B:6:0x000c, B:8:0x0013, B:13:0x001f, B:15:0x0047, B:18:0x0050, B:21:0x0060, B:23:0x0066, B:24:0x006d, B:26:0x0073, B:30:0x0087, B:32:0x008b, B:33:0x008f, B:35:0x0095, B:36:0x009f, B:38:0x00c5, B:40:0x00da), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da A[Catch: Exception -> 0x00fa, TRY_LEAVE, TryCatch #0 {Exception -> 0x00fa, blocks: (B:3:0x0003, B:5:0x0008, B:6:0x000c, B:8:0x0013, B:13:0x001f, B:15:0x0047, B:18:0x0050, B:21:0x0060, B:23:0x0066, B:24:0x006d, B:26:0x0073, B:30:0x0087, B:32:0x008b, B:33:0x008f, B:35:0x0095, B:36:0x009f, B:38:0x00c5, B:40:0x00da), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.app.BusinessObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        List<MetaCategory> list;
        boolean z16;
        Iterator<T> it;
        Object obj;
        MetaCategory metaCategory;
        ArrayList<MetaCategory> arrayList;
        Integer num;
        List<MetaCategory> emptyList;
        try {
            if (data instanceof List) {
                list = (List) data;
            } else {
                list = null;
            }
            List<MetaCategory> list2 = list;
            boolean z17 = false;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
                if (z16) {
                    w53.b.f("WinkTemplateViewModel", "[onUpdate] type=" + type + ", network data isNullOrEmpty");
                    list = WinkEditorResourceManager.a1().N1();
                    List<MetaCategory> list3 = list;
                    if (list3 == null || list3.isEmpty()) {
                        z17 = true;
                    }
                    if (z17) {
                        w53.b.f("WinkTemplateViewModel", "[onUpdate] local data isNullOrEmpty");
                        MutableLiveData<List<MetaCategory>> mutableLiveData = this.categoriesLiveData;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        mutableLiveData.postValue(emptyList);
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(list, "{\n                WinkQL\u2026esFromLocal\n            }");
                }
                it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, HippyQQConstants.HIPPY_CHANNEL)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                metaCategory = (MetaCategory) obj;
                if (metaCategory == null) {
                    arrayList = metaCategory.subCategories;
                } else {
                    arrayList = null;
                }
                int size = list.size();
                if (arrayList == null) {
                    num = Integer.valueOf(arrayList.size());
                } else {
                    num = null;
                }
                w53.b.f("WinkTemplateViewModel", "[onUpdate] category.size=" + size + ", template.size=" + num);
                if (!o83.a.f422212a.d()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkTemplateViewModel$onUpdate$1(this, arrayList, null), 3, null);
                    return;
                }
                List<String> d16 = aw.e().d();
                Intrinsics.checkNotNullExpressionValue(d16, "getInstance().ids");
                List<MetaCategory> O1 = O1(arrayList, d16);
                X1(O1);
                qa3.b.f428767a.b(O1, true);
                this.categoriesLiveData.postValue(O1);
                return;
            }
            z16 = true;
            if (z16) {
            }
            it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                }
            }
            metaCategory = (MetaCategory) obj;
            if (metaCategory == null) {
            }
            int size2 = list.size();
            if (arrayList == null) {
            }
            w53.b.f("WinkTemplateViewModel", "[onUpdate] category.size=" + size2 + ", template.size=" + num);
            if (!o83.a.f422212a.d()) {
            }
        } catch (Exception e16) {
            w53.b.d("WinkTemplateViewModel", "[onUpdate]", e16);
        }
    }
}
