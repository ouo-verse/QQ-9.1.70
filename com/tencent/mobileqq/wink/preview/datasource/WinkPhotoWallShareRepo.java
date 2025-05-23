package com.tencent.mobileqq.wink.preview.datasource;

import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.preview.datasource.WinkPhotoWallShareRepo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u0004\u0018\u00010\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/datasource/WinkPhotoWallShareRepo;", "Lcom/tencent/mobileqq/wink/preview/datasource/WinkBasePreviewShareDataSource;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", "", "urlOrPath", "", "holderCount", "e", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "d", "Ljava/util/List;", "getTEMPLATE_IDS", "()Ljava/util/List;", "TEMPLATE_IDS", "I", "template_max_photo_num", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkPhotoWallShareRepo extends WinkBasePreviewShareDataSource {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final WinkPhotoWallShareRepo f325392c = new WinkPhotoWallShareRepo();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> TEMPLATE_IDS;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int template_max_photo_num;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/preview/datasource/WinkPhotoWallShareRepo$a", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "t", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Observer<List<? extends MetaCategory>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<MetaMaterial> f325395d;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super MetaMaterial> cancellableContinuation) {
            this.f325395d = cancellableContinuation;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> t16) {
            MetaMaterial templateLibraryMaterial = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getTemplateLibraryMaterial(WinkPhotoWallShareRepo.f325392c.q());
            if (templateLibraryMaterial == null) {
                b.g("WinkPhotoWallShareDataSource", "empty metaCategory");
                this.f325395d.resumeWith(Result.m476constructorimpl(null));
            } else {
                this.f325395d.resumeWith(Result.m476constructorimpl(templateLibraryMaterial));
            }
            WinkEditorResourceManager.a1().h2().removeObserver(this);
        }
    }

    static {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("dapian_dianranxiwang", "dapian_shenghuojilu_dt", "dapian_wennuan", "dapian_yuanxiangji_dt");
        TEMPLATE_IDS = mutableListOf;
        template_max_photo_num = 9;
    }

    WinkPhotoWallShareRepo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ec -> B:11:0x00ed). Please report as a decompilation issue!!! */
    @Override // com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object e(@NotNull List<String> list, int i3, @NotNull Continuation<? super List<String>> continuation) {
        WinkPhotoWallShareRepo$downloadAndCopyResources$1 winkPhotoWallShareRepo$downloadAndCopyResources$1;
        Object coroutine_suspended;
        int i16;
        int collectionSizeOrDefault;
        Iterator it;
        Collection collection;
        boolean isBlank;
        String substringAfterLast$default;
        boolean startsWith$default;
        Collection collection2;
        String str;
        if (continuation instanceof WinkPhotoWallShareRepo$downloadAndCopyResources$1) {
            winkPhotoWallShareRepo$downloadAndCopyResources$1 = (WinkPhotoWallShareRepo$downloadAndCopyResources$1) continuation;
            int i17 = winkPhotoWallShareRepo$downloadAndCopyResources$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                winkPhotoWallShareRepo$downloadAndCopyResources$1.label = i17 - Integer.MIN_VALUE;
                Object obj = winkPhotoWallShareRepo$downloadAndCopyResources$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = winkPhotoWallShareRepo$downloadAndCopyResources$1.label;
                if (i16 == 0) {
                    if (i16 != 1) {
                        if (i16 == 2) {
                            collection = (Collection) winkPhotoWallShareRepo$downloadAndCopyResources$1.L$2;
                            it = (Iterator) winkPhotoWallShareRepo$downloadAndCopyResources$1.L$1;
                            collection2 = (Collection) winkPhotoWallShareRepo$downloadAndCopyResources$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            str = (String) obj;
                            collection.add(str);
                            collection = collection2;
                            if (it.hasNext()) {
                                String str2 = (String) it.next();
                                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                                if (!isBlank) {
                                    substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str2, "/", (String) null, 2, (Object) null);
                                    WinkPhotoWallShareRepo winkPhotoWallShareRepo = f325392c;
                                    String j3 = winkPhotoWallShareRepo.j(substringAfterLast$default);
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "http", false, 2, null);
                                    if (startsWith$default) {
                                        b.a("WinkPhotoWallShareDataSource", "download image: " + str2);
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.L$0 = collection;
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.L$1 = it;
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.L$2 = collection;
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.label = 1;
                                        Object g16 = winkPhotoWallShareRepo.g(str2, j3, winkPhotoWallShareRepo$downloadAndCopyResources$1);
                                        if (g16 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        collection2 = collection;
                                        str = (String) g16;
                                        collection.add(str);
                                        collection = collection2;
                                        if (it.hasNext()) {
                                            return (List) collection;
                                        }
                                    } else {
                                        b.a("WinkPhotoWallShareDataSource", "copy image: " + str2);
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.L$0 = collection;
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.L$1 = it;
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.L$2 = collection;
                                        winkPhotoWallShareRepo$downloadAndCopyResources$1.label = 2;
                                        obj = winkPhotoWallShareRepo.d(str2, j3, winkPhotoWallShareRepo$downloadAndCopyResources$1);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        collection2 = collection;
                                        str = (String) obj;
                                        collection.add(str);
                                        collection = collection2;
                                        if (it.hasNext()) {
                                        }
                                    }
                                } else {
                                    throw new IllegalArgumentException("invalid photo path");
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        collection = (Collection) winkPhotoWallShareRepo$downloadAndCopyResources$1.L$2;
                        it = (Iterator) winkPhotoWallShareRepo$downloadAndCopyResources$1.L$1;
                        collection2 = (Collection) winkPhotoWallShareRepo$downloadAndCopyResources$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = (String) obj;
                        collection.add(str);
                        collection = collection2;
                        if (it.hasNext()) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (list.size() > i3) {
                        list = list.subList(0, i3);
                    }
                    List<String> list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    it = list2.iterator();
                    collection = arrayList;
                    if (it.hasNext()) {
                    }
                }
            }
        }
        winkPhotoWallShareRepo$downloadAndCopyResources$1 = new WinkPhotoWallShareRepo$downloadAndCopyResources$1(this, continuation);
        Object obj2 = winkPhotoWallShareRepo$downloadAndCopyResources$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = winkPhotoWallShareRepo$downloadAndCopyResources$1.label;
        if (i16 == 0) {
        }
    }

    @Override // com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource
    @Nullable
    public Object l(@NotNull Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QRouteApi api = QRoute.api(IWinkEditorResourceAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkEditorResourceAPI::class.java)");
        ((IWinkEditorResourceAPI) api).fetchEditorResource();
        final a aVar = new a(cancellableContinuationImpl);
        WinkEditorResourceManager.a1().p3();
        WinkEditorResourceManager.a1().h2().observeForever(aVar);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.preview.datasource.WinkPhotoWallShareRepo$getMaterial$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                WinkEditorResourceManager.a1().h2().removeObserver(WinkPhotoWallShareRepo.a.this);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.wink.preview.datasource.WinkBasePreviewShareDataSource
    @Nullable
    public Map<String, String> o() {
        return null;
    }

    @NotNull
    public String q() {
        Random.Companion companion = Random.INSTANCE;
        List<String> list = TEMPLATE_IDS;
        companion.nextInt(0, list.size() - 1);
        return list.get(2);
    }
}
