package com.tencent.mobileqq.wink.h5native;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeExportManager$downloadImages$2", f = "WinkAiPaintNativeExportManager.kt", i = {}, l = {PlayerResources.ViewId.GET_MORE_JUMP_TIPS_BTN}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAiPaintNativeExportManager$downloadImages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cacheDir;
    final /* synthetic */ List<String> $downloadedImages;
    final /* synthetic */ List<Image> $images;
    final /* synthetic */ Map<String, String> $urlMap;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiPaintNativeExportManager$downloadImages$2(List<Image> list, Map<String, String> map, List<String> list2, String str, Continuation<? super WinkAiPaintNativeExportManager$downloadImages$2> continuation) {
        super(2, continuation);
        this.$images = list;
        this.$urlMap = map;
        this.$downloadedImages = list2;
        this.$cacheDir = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkAiPaintNativeExportManager$downloadImages$2 winkAiPaintNativeExportManager$downloadImages$2 = new WinkAiPaintNativeExportManager$downloadImages$2(this.$images, this.$urlMap, this.$downloadedImages, this.$cacheDir, continuation);
        winkAiPaintNativeExportManager$downloadImages$2.L$0 = obj;
        return winkAiPaintNativeExportManager$downloadImages$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Iterator it;
        Deferred async$default;
        String W;
        Deferred async$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList();
            List<Image> list = this.$images;
            if (list != null) {
                Map<String, String> map = this.$urlMap;
                List<String> list2 = this.$downloadedImages;
                String str = this.$cacheDir;
                int i16 = 0;
                for (Object obj2 : list) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Image image = (Image) obj2;
                    if (image.isURL()) {
                        if (!map.containsKey(image.getContent())) {
                            W = WinkAiPaintNativeExportManager.f322863a.W(image.getContent());
                            String str2 = str + "/" + i16 + W;
                            map.put(image.getContent(), str2);
                            list2.add(str2);
                            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WinkAiPaintNativeExportManager$downloadImages$2$1$1(image, str2, null), 3, null);
                            arrayList.add(async$default2);
                        } else {
                            String str3 = map.get(image.getContent());
                            Intrinsics.checkNotNull(str3);
                            list2.add(str3);
                        }
                    } else if (image.isBase64()) {
                        String str4 = str + "/" + i16 + ".jpg";
                        list2.add(str4);
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new WinkAiPaintNativeExportManager$downloadImages$2$1$2(image, str4, null), 3, null);
                        arrayList.add(async$default);
                    } else {
                        throw new WinkAiPaintNativeExportManager.AiPaintVideoException(-1, "Unknown image type: " + image);
                    }
                    i16 = i17;
                }
            }
            it = arrayList.iterator();
        }
        while (it.hasNext()) {
            Deferred deferred = (Deferred) it.next();
            this.L$0 = it;
            this.label = 1;
            if (deferred.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiPaintNativeExportManager$downloadImages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
