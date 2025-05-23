package com.tencent.mobileqq.wink.launcher.network;

import android.net.http.Headers;
import camera.SHADOW_BACKEND_INTERFACE.GetCatMatTreeRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import g83.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u53.f;
import y53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u0016*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R?\u0010\u001f\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\t0\t \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/launcher/network/WinkRecommendDataServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "leveledCategories", "", ICustomDataEditor.STRING_PARAM_3, "category", "", "", "v3", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "W2", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "e", "Lkotlin/Lazy;", "t3", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmkv", "kotlin.jvm.PlatformType", "f", "getEtag", "()Ljava/lang/String;", Headers.ETAG, "", h.F, "u3", "()Ljava/util/Set;", "storedData", "Lcom/tencent/common/app/AppInterface;", "appInterface", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "i", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkRecommendDataServiceHandler extends WinkDataServiceHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mmkv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy etag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy storedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkRecommendDataServiceHandler(@NotNull AppInterface appInterface) {
        super(appInterface);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler$mmkv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(BaseApplication.getContext(), "QCIRCLE_MMKV_COMMON");
            }
        });
        this.mmkv = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler$etag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                MMKVOptionEntity t36;
                t36 = WinkRecommendDataServiceHandler.this.t3();
                return t36.decodeString(AECameraPrefsUtil.f318468f, "");
            }
        });
        this.etag = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Set<String>>() { // from class: com.tencent.mobileqq.wink.launcher.network.WinkRecommendDataServiceHandler$storedData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<String> invoke() {
                MMKVOptionEntity t36;
                Set<String> emptySet;
                t36 = WinkRecommendDataServiceHandler.this.t3();
                emptySet = SetsKt__SetsKt.emptySet();
                return t36.decodeStringSet("WinkRecommendDataServiceHandler.recommendTemplateId", emptySet);
            }
        });
        this.storedData = lazy3;
    }

    private final void s3(List<MetaCategory> leveledCategories) {
        boolean z16;
        Set<String> v3 = v3(leveledCategories);
        Set<String> u36 = u3();
        if (u36 != null && !u36.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || !u3().equals(v3)) {
            a.f401535a.a(0);
            t3().encodeStringSet("WinkRecommendDataServiceHandler.recommendTemplateId", v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKVOptionEntity t3() {
        return (MMKVOptionEntity) this.mmkv.getValue();
    }

    private final Set<String> u3() {
        return (Set) this.storedData.getValue();
    }

    private final Set<String> v3(List<MetaCategory> category) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = category.iterator();
        while (it.hasNext()) {
            ArrayList<MetaMaterial> arrayList = ((MetaCategory) it.next()).materials;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.materials");
            Iterator<T> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                String str = ((MetaMaterial) it5.next()).f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "m.id");
                linkedHashSet.add(str);
            }
        }
        return linkedHashSet;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler
    protected void W2(@Nullable FromServiceMsg res, @Nullable Object data) {
        ArrayList<MetaCategory> arrayList;
        boolean z16;
        List listOf;
        List listOf2;
        GetCatMatTreeRsp getCatMatTreeRsp = (GetCatMatTreeRsp) data;
        if (getCatMatTreeRsp != null && getCatMatTreeRsp.Code == 0 && (arrayList = getCatMatTreeRsp.Categories) != null) {
            Intrinsics.checkNotNullExpressionValue(arrayList, "response.Categories");
            if (!arrayList.isEmpty()) {
                Iterator<MetaCategory> it = getCatMatTreeRsp.Categories.iterator();
                while (it.hasNext()) {
                    MetaCategory next = it.next();
                    if (Intrinsics.areEqual("10002", next.f30532id)) {
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(next);
                        List<MetaCategory> c16 = b.c(listOf2);
                        String json = new Gson().toJson(c16);
                        s3(c16);
                        z16 = FileUtils.writeFile(com.tencent.mobileqq.wink.edit.manager.h.d().b(f.f438393f, "editor_pic_recommend_update_template.json"), json);
                        WinkEditorResourceManager.a1().d3();
                    } else if (Intrinsics.areEqual("10003", next.f30532id)) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(next);
                        List<MetaCategory> c17 = b.c(listOf);
                        String json2 = new Gson().toJson(c17);
                        s3(c17);
                        z16 = FileUtils.writeFile(com.tencent.mobileqq.wink.edit.manager.h.d().b(f.f438402o, "editor_pic_recommend_user_published_update_template.json"), json2);
                        WinkEditorResourceManager.a1().o3();
                    } else {
                        z16 = false;
                    }
                    w53.b.a("WinkDataServiceHandler", next.f30532id + " isWriteFile:" + z16);
                }
            }
        }
    }
}
