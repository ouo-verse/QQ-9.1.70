package com.tencent.robot.adelie.homepage.download;

import android.annotation.SuppressLint;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.preprocess.WinkMaterialResourceLoader;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager;
import com.tencent.robot.adelie.homepage.ugc.view.AdelieAvatarUgcTemplateMaterial;
import com.tencent.robot.adelie.homepage.ugc.view.Item;
import com.tencent.ttpic.openapi.filter.LightConstants;
import d24.SingleTagConfig;
import d24.UgcAdelieAvatarTemplateData;
import d24.UgcBasicConfig;
import d24.UgcTagConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0003$%&B\u0007\u00a2\u0006\u0004\b\"\u0010#J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006JF\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u000226\u0010 \u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\b0\u001b\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "gender", "Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$b;", "listener", "", "l", "Ld24/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$c;", "r", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "p", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "subCategory", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "t", "Landroidx/lifecycle/LifecycleOwner;", "owner", "j", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "id", "styleItem", "callback", DomainData.DOMAIN_NAME, "<init>", "()V", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieAvatarResourceManager {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$b;", "", "Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$c;", DownloadInfo.spKey_Config, "", "d", "Ld24/m;", "c", "", "Lcom/tencent/robot/adelie/homepage/ugc/view/x;", "styleItemList", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "materials", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void a(@NotNull List<MetaMaterial> materials);

        void b(@NotNull List<Item> styleItemList);

        void c(@NotNull UgcBasicConfig config);

        void d(@NotNull TagConfig config);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012 \b\u0002\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n0\t\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R/\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\f\u0010\u000fR%\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lkotlin/Pair;", "", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "tagCategoryList", "b", "emptyConfigList", "", "Ljava/util/Map;", "()Ljava/util/Map;", "referMap", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager$c, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class TagConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Pair<String, List<String>>> tagCategoryList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<String> emptyConfigList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Map<String, String> referMap;

        public TagConfig() {
            this(null, null, null, 7, null);
        }

        @Nullable
        public final List<String> a() {
            return this.emptyConfigList;
        }

        @Nullable
        public final Map<String, String> b() {
            return this.referMap;
        }

        @NotNull
        public final List<Pair<String, List<String>>> c() {
            return this.tagCategoryList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TagConfig)) {
                return false;
            }
            TagConfig tagConfig = (TagConfig) other;
            if (Intrinsics.areEqual(this.tagCategoryList, tagConfig.tagCategoryList) && Intrinsics.areEqual(this.emptyConfigList, tagConfig.emptyConfigList) && Intrinsics.areEqual(this.referMap, tagConfig.referMap)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.tagCategoryList.hashCode() * 31;
            List<String> list = this.emptyConfigList;
            int i3 = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            Map<String, String> map = this.referMap;
            if (map != null) {
                i3 = map.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "TagConfig(tagCategoryList=" + this.tagCategoryList + ", emptyConfigList=" + this.emptyConfigList + ", referMap=" + this.referMap + ")";
        }

        public TagConfig(@NotNull List<Pair<String, List<String>>> tagCategoryList, @Nullable List<String> list, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(tagCategoryList, "tagCategoryList");
            this.tagCategoryList = tagCategoryList;
            this.emptyConfigList = list;
            this.referMap = map;
        }

        public /* synthetic */ TagConfig(List list, List list2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? null : list2, (i3 & 4) != 0 ? null : map);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366316a;

        static {
            int[] iArr = new int[BotGender.values().length];
            try {
                iArr[BotGender.KMALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BotGender.KFEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f366316a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final MetaMaterial material, final BotGender gender, final b listener) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.download.c
            @Override // java.lang.Runnable
            public final void run() {
                AdelieAvatarResourceManager.m(MetaMaterial.this, listener, this, gender);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MetaMaterial material, b listener, AdelieAvatarResourceManager this$0, BotGender gender) {
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gender, "$gender");
        WinkEditorResourceManager.a1().f(material, new e(material, listener, this$0, gender));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MetaMaterial material, AdelieAvatarResourceManager this$0, Function2 callback) {
        Intrinsics.checkNotNullParameter(material, "$material");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        WinkEditorResourceManager.a1().f(material, new f(material, this$0, callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(BotGender gender, String materialId) {
        int i3 = d.f366316a[gender.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return Intrinsics.areEqual(materialId, "default");
            }
            return Intrinsics.areEqual(materialId, LightConstants.FEMALE);
        }
        return Intrinsics.areEqual(materialId, LightConstants.MALE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UgcBasicConfig q(MetaMaterial material) {
        Gson gson = new Gson();
        String h16 = h.h(new File(WinkEditorResourceManager.a1().m(material) + File.separator + "ugcbot_config_basic.json"));
        if (h16 == null) {
            return new UgcBasicConfig(0, 0, 3, null);
        }
        Object fromJson = gson.fromJson(h16, (Class<Object>) UgcBasicConfig.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(content, UgcBasicConfig::class.java)");
        return (UgcBasicConfig) fromJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TagConfig r(MetaMaterial material, BotGender gender) {
        List<String> b16;
        Gson gson = new Gson();
        String h16 = h.h(new File(WinkEditorResourceManager.a1().m(material) + File.separator + "ugcbot_config_tags.json"));
        if (h16 == null) {
            return new TagConfig(null, null, null, 7, null);
        }
        UgcTagConfig ugcTagConfig = (UgcTagConfig) gson.fromJson(h16, UgcTagConfig.class);
        ArrayList arrayList = new ArrayList();
        int i3 = d.f366316a[gender.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                for (SingleTagConfig singleTagConfig : ugcTagConfig.d()) {
                    arrayList.add(TuplesKt.to(singleTagConfig.getGroupId(), singleTagConfig.b()));
                }
                b16 = ugcTagConfig.getEmptyConfig().c();
            } else {
                for (SingleTagConfig singleTagConfig2 : ugcTagConfig.b()) {
                    arrayList.add(TuplesKt.to(singleTagConfig2.getGroupId(), singleTagConfig2.b()));
                }
                b16 = ugcTagConfig.getEmptyConfig().a();
            }
        } else {
            for (SingleTagConfig singleTagConfig3 : ugcTagConfig.c()) {
                arrayList.add(TuplesKt.to(singleTagConfig3.getGroupId(), singleTagConfig3.b()));
            }
            b16 = ugcTagConfig.getEmptyConfig().b();
        }
        return new TagConfig(arrayList, b16, ugcTagConfig.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(BotGender gender, List<MetaCategory> subCategory, b listener) {
        Map mapOf;
        ArrayList<MetaMaterial> arrayList;
        Object obj;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(BotGender.KOTHER, "templistDefault"), TuplesKt.to(BotGender.KMALE, "templistMale"), TuplesKt.to(BotGender.KFEMALE, "templistFemale"));
        Iterator<T> it = subCategory.iterator();
        while (true) {
            arrayList = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, mapOf.get(gender))) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MetaCategory metaCategory = (MetaCategory) obj;
        if (metaCategory != null) {
            arrayList = metaCategory.materials;
        }
        if (arrayList != null) {
            listener.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdelieAvatarUgcTemplateMaterial t(MetaMaterial material) {
        boolean z16;
        String str;
        Gson gson = new Gson();
        String m3 = WinkEditorResourceManager.a1().m(material);
        String str2 = File.separator;
        String h16 = h.h(new File(m3 + str2 + TemplateBean.TEMPLATE_JSON));
        if (h16 == null) {
            return new AdelieAvatarUgcTemplateMaterial(null, null, null, 7, null);
        }
        UgcAdelieAvatarTemplateData ugcAdelieAvatarTemplateData = (UgcAdelieAvatarTemplateData) gson.fromJson(h16, UgcAdelieAvatarTemplateData.class);
        if (ugcAdelieAvatarTemplateData.getRefer_img_path().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = WinkEditorResourceManager.a1().m(material) + str2 + ugcAdelieAvatarTemplateData.getRefer_img_path();
        } else {
            str = "";
        }
        return new AdelieAvatarUgcTemplateMaterial(str, ugcAdelieAvatarTemplateData, null, 4, null);
    }

    public final void j(@NotNull LifecycleOwner owner, @NotNull final BotGender gender, @NotNull final b listener) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MutableLiveData<List<MetaCategory>> e26 = WinkEditorResourceManager.a1().e2();
        final Function1<List<MetaCategory>, Unit> function1 = new Function1<List<MetaCategory>, Unit>() { // from class: com.tencent.robot.adelie.homepage.download.AdelieAvatarResourceManager$downloadAvatarResource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<MetaCategory> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MetaCategory> metaCategories) {
                boolean p16;
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullExpressionValue(metaCategories, "metaCategories");
                AdelieAvatarResourceManager adelieAvatarResourceManager = AdelieAvatarResourceManager.this;
                BotGender botGender = gender;
                AdelieAvatarResourceManager.b bVar = listener;
                for (MetaCategory metaCategory : metaCategories) {
                    if (metaCategory.f30532id.equals(DownloadInfo.spKey_Config)) {
                        ArrayList<MetaMaterial> arrayList = metaCategory.materials;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "metaCategory.materials");
                        for (MetaMaterial material : arrayList) {
                            Intrinsics.checkNotNullExpressionValue(material, "material");
                            adelieAvatarResourceManager.l(material, botGender, bVar);
                        }
                    } else {
                        String str = metaCategory.f30532id;
                        Intrinsics.checkNotNullExpressionValue(str, "metaCategory.id");
                        p16 = adelieAvatarResourceManager.p(botGender, str);
                        if (p16) {
                            ArrayList<MetaMaterial> arrayList2 = metaCategory.materials;
                            Intrinsics.checkNotNullExpressionValue(arrayList2, "metaCategory.materials");
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                            for (MetaMaterial material2 : arrayList2) {
                                String str2 = material2.thumbUrl;
                                Intrinsics.checkNotNullExpressionValue(str2, "material.thumbUrl");
                                Intrinsics.checkNotNullExpressionValue(material2, "material");
                                String a06 = com.tencent.mobileqq.wink.editor.c.a0(material2);
                                String str3 = material2.f30533id;
                                Intrinsics.checkNotNullExpressionValue(str3, "material.id");
                                arrayList3.add(new Item(str2, a06, str3));
                            }
                            bVar.b(arrayList3);
                        } else if (metaCategory.f30532id.equals("templateList")) {
                            ArrayList<MetaCategory> arrayList4 = metaCategory.subCategories;
                            Intrinsics.checkNotNullExpressionValue(arrayList4, "metaCategory.subCategories");
                            adelieAvatarResourceManager.s(botGender, arrayList4, bVar);
                        }
                    }
                }
            }
        };
        e26.observe(owner, new Observer() { // from class: com.tencent.robot.adelie.homepage.download.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieAvatarResourceManager.k(Function1.this, obj);
            }
        });
        WinkMaterialResourceLoader.f325333a.j("UGCBotStyle");
    }

    public final void n(@NotNull final MetaMaterial material, @NotNull final Function2<? super String, ? super AdelieAvatarUgcTemplateMaterial, Unit> callback) {
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.download.b
            @Override // java.lang.Runnable
            public final void run() {
                AdelieAvatarResourceManager.o(MetaMaterial.this, this, callback);
            }
        }, 128, null, false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$e", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f366317a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f366318b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdelieAvatarResourceManager f366319c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BotGender f366320d;

        e(MetaMaterial metaMaterial, b bVar, AdelieAvatarResourceManager adelieAvatarResourceManager, BotGender botGender) {
            this.f366317a = metaMaterial;
            this.f366318b = bVar;
            this.f366319c = adelieAvatarResourceManager;
            this.f366320d = botGender;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            QLog.i("AdelieAvatarResourceManager", 1, "downloadConfig id = " + this.f366317a.f30533id + " result = " + isSuccess + " finish");
            if (Intrinsics.areEqual("ugcbot_config_tags", this.f366317a.f30533id)) {
                this.f366318b.d(this.f366319c.r(this.f366317a, this.f366320d));
            } else if (Intrinsics.areEqual("ugcbot_config_basic", this.f366317a.f30533id)) {
                this.f366318b.c(this.f366319c.q(this.f366317a));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/robot/adelie/homepage/download/AdelieAvatarResourceManager$f", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f366321a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdelieAvatarResourceManager f366322b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<String, AdelieAvatarUgcTemplateMaterial, Unit> f366323c;

        /* JADX WARN: Multi-variable type inference failed */
        f(MetaMaterial metaMaterial, AdelieAvatarResourceManager adelieAvatarResourceManager, Function2<? super String, ? super AdelieAvatarUgcTemplateMaterial, Unit> function2) {
            this.f366321a = metaMaterial;
            this.f366322b = adelieAvatarResourceManager;
            this.f366323c = function2;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        @SuppressLint({"NotifyDataSetChanged"})
        public void onDownloadFinish(boolean isSuccess) {
            AdelieAvatarUgcTemplateMaterial t16;
            QLog.i("AdelieAvatarResourceManager", 1, "downloadSingleMaterial id = " + this.f366321a.f30533id + " result = " + isSuccess + " finish");
            if (isSuccess) {
                t16 = this.f366322b.t(this.f366321a);
            } else {
                t16 = new AdelieAvatarUgcTemplateMaterial(null, null, null, 7, null);
            }
            Function2<String, AdelieAvatarUgcTemplateMaterial, Unit> function2 = this.f366323c;
            String str = this.f366321a.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            function2.invoke(str, t16);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
        }
    }
}
