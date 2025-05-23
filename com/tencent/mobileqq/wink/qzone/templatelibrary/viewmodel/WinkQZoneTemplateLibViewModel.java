package com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.b;
import com.tencent.mobileqq.wink.editor.c;
import com.tencent.mobileqq.wink.editor.hdr.e;
import com.tencent.mobileqq.wink.editor.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0003*+,B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\bH\u0016J\"\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0014R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "", "R1", "", "templateId", "materialCategory", "Q1", "", "ignoreCache", "P1", "getLogTag", "", "type", "isSuccess", "", "data", "onUpdate", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "categoriesLiveData", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_detailPageLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "detailPageLiveData", "<init>", "()V", "D", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibViewModel extends BaseViewModel implements BusinessObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<DetailPageData> detailPageLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<CategoriesData> categoriesLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<DetailPageData> _detailPageLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "aiToolCategory", "b", "d", "templateCategory", "c", "picGenPicCategory", "shareCategory", "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class CategoriesData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaCategory aiToolCategory;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaCategory templateCategory;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaCategory picGenPicCategory;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaCategory shareCategory;

        public CategoriesData(@Nullable MetaCategory metaCategory, @Nullable MetaCategory metaCategory2, @Nullable MetaCategory metaCategory3, @Nullable MetaCategory metaCategory4) {
            this.aiToolCategory = metaCategory;
            this.templateCategory = metaCategory2;
            this.picGenPicCategory = metaCategory3;
            this.shareCategory = metaCategory4;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MetaCategory getAiToolCategory() {
            return this.aiToolCategory;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final MetaCategory getPicGenPicCategory() {
            return this.picGenPicCategory;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final MetaCategory getShareCategory() {
            return this.shareCategory;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final MetaCategory getTemplateCategory() {
            return this.templateCategory;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoriesData)) {
                return false;
            }
            CategoriesData categoriesData = (CategoriesData) other;
            if (Intrinsics.areEqual(this.aiToolCategory, categoriesData.aiToolCategory) && Intrinsics.areEqual(this.templateCategory, categoriesData.templateCategory) && Intrinsics.areEqual(this.picGenPicCategory, categoriesData.picGenPicCategory) && Intrinsics.areEqual(this.shareCategory, categoriesData.shareCategory)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            MetaCategory metaCategory = this.aiToolCategory;
            int i3 = 0;
            if (metaCategory == null) {
                hashCode = 0;
            } else {
                hashCode = metaCategory.hashCode();
            }
            int i16 = hashCode * 31;
            MetaCategory metaCategory2 = this.templateCategory;
            if (metaCategory2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = metaCategory2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            MetaCategory metaCategory3 = this.picGenPicCategory;
            if (metaCategory3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = metaCategory3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            MetaCategory metaCategory4 = this.shareCategory;
            if (metaCategory4 != null) {
                i3 = metaCategory4.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "CategoriesData(aiToolCategory=" + this.aiToolCategory + ", templateCategory=" + this.templateCategory + ", picGenPicCategory=" + this.picGenPicCategory + ", shareCategory=" + this.shareCategory + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "targetTemplateId", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "currentMaterialCategory", "<init>", "(Ljava/lang/String;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class DetailPageData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String targetTemplateId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final MetaCategory currentMaterialCategory;

        public DetailPageData(@Nullable String str, @Nullable MetaCategory metaCategory) {
            this.targetTemplateId = str;
            this.currentMaterialCategory = metaCategory;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MetaCategory getCurrentMaterialCategory() {
            return this.currentMaterialCategory;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getTargetTemplateId() {
            return this.targetTemplateId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailPageData)) {
                return false;
            }
            DetailPageData detailPageData = (DetailPageData) other;
            if (Intrinsics.areEqual(this.targetTemplateId, detailPageData.targetTemplateId) && Intrinsics.areEqual(this.currentMaterialCategory, detailPageData.currentMaterialCategory)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.targetTemplateId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            MetaCategory metaCategory = this.currentMaterialCategory;
            if (metaCategory != null) {
                i3 = metaCategory.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "DetailPageData(targetTemplateId=" + this.targetTemplateId + ", currentMaterialCategory=" + this.currentMaterialCategory + ")";
        }
    }

    public WinkQZoneTemplateLibViewModel() {
        b.a().addDefaultObservers(this);
        this.categoriesLiveData = new MutableLiveData<>();
        MutableLiveData<DetailPageData> mutableLiveData = new MutableLiveData<>();
        this._detailPageLiveData = mutableLiveData;
        this.detailPageLiveData = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(final List<MetaCategory> categories) {
        boolean z16;
        List<MetaCategory> list = categories;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w53.b.f("WinkQZoneTemplateLibViewModel", "categories is null");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.a
                @Override // java.lang.Runnable
                public final void run() {
                    WinkQZoneTemplateLibViewModel.S1(WinkQZoneTemplateLibViewModel.this, categories);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143 A[EDGE_INSN: B:74:0x0143->B:72:0x0143 BREAK  A[LOOP:5: B:66:0x012a->B:73:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void S1(WinkQZoneTemplateLibViewModel this$0, List list) {
        MetaCategory metaCategory;
        Object obj;
        MetaCategory metaCategory2;
        Object obj2;
        MetaCategory metaCategory3;
        Iterator it;
        Object obj3;
        ArrayList<MetaCategory> arrayList;
        ArrayList<MetaCategory> arrayList2;
        Iterator<T> it5;
        String str;
        ArrayList<MetaCategory> arrayList3;
        Object obj4;
        ArrayList<MetaMaterial> arrayList4;
        MetaCategory templateCategory;
        ArrayList<MetaCategory> arrayList5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CategoriesData value = this$0.categoriesLiveData.getValue();
        boolean z16 = false;
        if (value != null && (templateCategory = value.getTemplateCategory()) != null && (arrayList5 = templateCategory.subCategories) != null && (!arrayList5.isEmpty())) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List list2 = list;
        Iterator it6 = list2.iterator();
        while (true) {
            metaCategory = null;
            if (it6.hasNext()) {
                obj = it6.next();
                if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, HippyQQConstants.HIPPY_CHANNEL)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MetaCategory metaCategory4 = (MetaCategory) obj;
        if (metaCategory4 != null) {
            qa3.b bVar = qa3.b.f428767a;
            ArrayList<MetaCategory> subCategories = metaCategory4.subCategories;
            Intrinsics.checkNotNullExpressionValue(subCategories, "subCategories");
            bVar.b(subCategories, true);
            metaCategory2 = c.b(metaCategory4);
        } else {
            metaCategory2 = null;
        }
        Iterator it7 = list2.iterator();
        while (true) {
            if (it7.hasNext()) {
                obj2 = it7.next();
                if (Intrinsics.areEqual(((MetaCategory) obj2).f30532id, QQWinkConstants.BUSINESS_MAIGC_STUDIO)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        MetaCategory metaCategory5 = (MetaCategory) obj2;
        if (metaCategory5 != null && (arrayList3 = metaCategory5.subCategories) != null) {
            Iterator<T> it8 = arrayList3.iterator();
            while (true) {
                if (it8.hasNext()) {
                    obj4 = it8.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj4).f30532id, "pic_gen_pic")) {
                        break;
                    }
                } else {
                    obj4 = null;
                    break;
                }
            }
            metaCategory3 = (MetaCategory) obj4;
            if (metaCategory3 != null) {
                e eVar = e.f320476a;
                if (eVar.d() && (arrayList4 = metaCategory3.materials) != null) {
                    arrayList4.addAll(eVar.c());
                }
                ArrayList<MetaMaterial> materials = metaCategory3.materials;
                if (materials != null) {
                    Intrinsics.checkNotNullExpressionValue(materials, "materials");
                    for (MetaMaterial material : materials) {
                        Intrinsics.checkNotNullExpressionValue(material, "material");
                        String id5 = metaCategory3.f30532id;
                        Intrinsics.checkNotNullExpressionValue(id5, "id");
                        c.o1(material, id5);
                        String name = metaCategory3.name;
                        Intrinsics.checkNotNullExpressionValue(name, "name");
                        c.p1(material, name);
                    }
                }
                it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj3 = it.next();
                        String str2 = ((MetaCategory) obj3).f30532id;
                        if (h.f322638a.g()) {
                            str = "single_share";
                        } else {
                            str = "share";
                        }
                        if (Intrinsics.areEqual(str2, str)) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                MetaCategory metaCategory6 = (MetaCategory) obj3;
                if (metaCategory2 != null && (arrayList2 = metaCategory2.subCategories) != null) {
                    it5 = arrayList2.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            break;
                        }
                        Object next = it5.next();
                        if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "100024")) {
                            metaCategory = next;
                            break;
                        }
                    }
                    metaCategory = metaCategory;
                }
                if (metaCategory2 != null && (arrayList = metaCategory2.subCategories) != null) {
                    arrayList.remove(metaCategory);
                }
                this$0.categoriesLiveData.postValue(new CategoriesData(metaCategory, metaCategory2, metaCategory3, metaCategory6));
            }
        }
        metaCategory3 = null;
        it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
            }
        }
        MetaCategory metaCategory62 = (MetaCategory) obj3;
        if (metaCategory2 != null) {
            it5 = arrayList2.iterator();
            while (true) {
                if (it5.hasNext()) {
                }
            }
            metaCategory = metaCategory;
        }
        if (metaCategory2 != null) {
            arrayList.remove(metaCategory);
        }
        this$0.categoriesLiveData.postValue(new CategoriesData(metaCategory, metaCategory2, metaCategory3, metaCategory62));
    }

    @NotNull
    public final MutableLiveData<CategoriesData> N1() {
        return this.categoriesLiveData;
    }

    @NotNull
    public final LiveData<DetailPageData> O1() {
        return this.detailPageLiveData;
    }

    public final void P1(boolean ignoreCache) {
        w53.b.f("WinkTemplateViewModel", "[requestTemplates]");
        if (!ignoreCache) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkQZoneTemplateLibViewModel$requestTemplates$1(this, null), 3, null);
        }
        BusinessHandler businessHandler = b.a().getBusinessHandler(WinkQZoneTemplateLibServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibServiceHandler");
        ((WinkQZoneTemplateLibServiceHandler) businessHandler).m3("qzoneTemplateLibrary");
    }

    public final void Q1(@Nullable String templateId, @Nullable MetaCategory materialCategory) {
        this._detailPageLiveData.postValue(new DetailPageData(templateId, materialCategory));
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkQZoneTemplateLibViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        b.a().removeObserver(this);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        List<MetaCategory> list;
        try {
            if (data instanceof List) {
                list = (List) data;
            } else {
                list = null;
            }
            R1(list);
        } catch (Exception e16) {
            w53.b.d("WinkTemplateViewModel", "[onUpdate]", e16);
        }
    }
}
