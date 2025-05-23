package com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel;

import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import u53.f;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0014J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcamera/SHADOW_BACKEND_INTERFACE/GetCatMatTreeRsp;", "response", "", "materialServiceId", "", "Q2", "Lcom/tencent/common/app/AppInterface;", "e", "Lcom/tencent/common/app/AppInterface;", "getAppInterface", "()Lcom/tencent/common/app/AppInterface;", "setAppInterface", "(Lcom/tencent/common/app/AppInterface;)V", "appInterface", "<init>", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateLibServiceHandler extends WinkDataServiceHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AppInterface appInterface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkQZoneTemplateLibServiceHandler(@NotNull AppInterface appInterface) {
        super(appInterface);
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        this.appInterface = appInterface;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    protected void Q2(@NotNull GetCatMatTreeRsp response, @NotNull String materialServiceId) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(materialServiceId, "materialServiceId");
        int i3 = response.Code;
        if (i3 != 0) {
            b.g("WinkQZoneTemplateLibServiceHandler", "[handleEditorMaterials] invalid code=" + i3);
            notifyUI(119, false, null);
            return;
        }
        ArrayList<MetaCategory> arrayList = response.Categories;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<MetaCategory> arrayList2 = response.Categories;
            if (arrayList2 != null) {
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                for (MetaCategory it : arrayList2) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList3.add(y53.b.a(it));
                }
                notifyUI(119, true, arrayList3);
                FileUtils.writeFile(h.d().b(f.f438407t, "editor_qzone_template_library.json"), new Gson().toJson(arrayList3));
                return;
            }
            return;
        }
        b.g("WinkQZoneTemplateLibServiceHandler", "[handleEditorMaterials] empty Categories");
        List<MetaCategory> x16 = WinkEditorResourceManager.a1().x1();
        Intrinsics.checkNotNullExpressionValue(x16, "getInstance().qZoneTemplateLibraryCategory");
        List<MetaCategory> list = x16;
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
        return WinkQZoneTemplateLibViewModel.class;
    }
}
