package com.tencent.mobileqq.wink.aiavatar.base;

import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R8\u0010\u0011\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Lcamera/SHADOW_BACKEND_INTERFACE/GetCatMatTreeRsp;", "response", "", "materialServiceId", "", "Q2", "Lkotlin/Function1;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "e", "Lkotlin/jvm/functions/Function1;", "getResponseCallback", "()Lkotlin/jvm/functions/Function1;", "r3", "(Lkotlin/jvm/functions/Function1;)V", "responseCallback", "Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarServiceHandler extends WinkDataServiceHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super List<MetaCategory>, Unit> responseCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIAvatarServiceHandler(@NotNull AppInterface appInterface) {
        super(appInterface);
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    protected void Q2(@NotNull GetCatMatTreeRsp response, @NotNull String materialServiceId) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(materialServiceId, "materialServiceId");
        int i3 = response.Code;
        if (i3 != 0) {
            w53.b.g("WinkAIAvatarServiceHandler", "[handleEditorMaterials] invalid code=" + i3);
            Function1<? super List<MetaCategory>, Unit> function1 = this.responseCallback;
            if (function1 != null) {
                function1.invoke(null);
                return;
            }
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
                Function1<? super List<MetaCategory>, Unit> function12 = this.responseCallback;
                if (function12 != null) {
                    function12.invoke(arrayList3);
                }
                FileUtils.writeFile(h.d().b(u53.f.f438408u, "wink_ai_avatar_update_material.json"), new Gson().toJson(arrayList3));
                return;
            }
            return;
        }
        w53.b.g("WinkAIAvatarServiceHandler", "[handleEditorMaterials] empty Categories");
        List<MetaCategory> u06 = WinkEditorResourceManager.a1().u0();
        Intrinsics.checkNotNullExpressionValue(u06, "getInstance().aiAvatarCategory");
        List<MetaCategory> list = u06;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (MetaCategory it5 : list) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList4.add(y53.b.a(it5));
        }
        Function1<? super List<MetaCategory>, Unit> function13 = this.responseCallback;
        if (function13 != null) {
            function13.invoke(arrayList4);
        }
    }

    public final void r3(@Nullable Function1<? super List<MetaCategory>, Unit> function1) {
        this.responseCallback = function1;
    }
}
