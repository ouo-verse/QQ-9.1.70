package com.tencent.mobileqq.wink.templatelibrary;

import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.templatelibrary.viewmodel.WinkTemplateViewModel;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;
import u53.f;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u0011J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0014J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/WinkTemplateServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcamera/SHADOW_BACKEND_INTERFACE/GetCatMatTreeRsp;", "response", "", "materialServiceId", "", "Q2", "Lcom/tencent/common/app/AppInterface;", "e", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "setAppInterface", "(Lcom/tencent/common/app/AppInterface;)V", "appInterface", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "f", "Lkotlin/Lazy;", "r3", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv", "<init>", h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkTemplateServiceHandler extends WinkDataServiceHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AppInterface appInterface;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mmkv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkTemplateServiceHandler(@NotNull AppInterface appInterface) {
        super(appInterface);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.appInterface = appInterface;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.wink.templatelibrary.WinkTemplateServiceHandler$mmkv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(BaseApplication.getContext(), "QCIRCLE_MMKV_COMMON");
            }
        });
        this.mmkv = lazy;
    }

    private final MMKVOptionEntity r3() {
        return (MMKVOptionEntity) this.mmkv.getValue();
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    protected void Q2(@NotNull GetCatMatTreeRsp response, @NotNull String materialServiceId) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(materialServiceId, "materialServiceId");
        int i3 = response.Code;
        ArrayList arrayList = null;
        if (i3 != 0) {
            w53.b.g("WinkTemplateServiceHandler", "[handleEditorMaterials] invalid code=" + i3);
            notifyUI(119, false, null);
            return;
        }
        ArrayList<MetaCategory> arrayList2 = response.Categories;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            AECameraPrefsUtil.c().k(AECameraPrefsUtil.f318466d, response.ETag, 4);
            ArrayList<MetaCategory> arrayList3 = response.Categories;
            if (arrayList3 != null) {
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
                arrayList = new ArrayList(collectionSizeOrDefault2);
                for (MetaCategory it : arrayList3) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(y53.b.a(it));
                }
            }
            if (arrayList != null) {
                String json = new Gson().toJson(arrayList);
                String b16 = com.tencent.mobileqq.wink.edit.manager.h.d().b(f.f438406s, "editor_template_library.json");
                boolean writeFile = FileUtils.writeFile(b16, json);
                if (writeFile) {
                    r3().encodeString(AECameraPrefsUtil.f318467e, response.ETag);
                }
                w53.b.a("WinkTemplateServiceHandler", "[handleEditorMaterials] savePath=" + b16 + ", write success=" + writeFile + ", json=" + json);
            }
            notifyUI(119, true, arrayList);
            return;
        }
        w53.b.g("WinkTemplateServiceHandler", "[handleEditorMaterials] empty Categories");
        List<MetaCategory> N1 = WinkEditorResourceManager.a1().N1();
        Intrinsics.checkNotNullExpressionValue(N1, "getInstance().templateLibraryCategory");
        List<MetaCategory> list = N1;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (MetaCategory it5 : list) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList4.add(y53.b.a(it5));
        }
        notifyUI(119, true, arrayList4);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return WinkTemplateViewModel.class;
    }
}
