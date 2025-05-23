package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1", f = "FeedEditorLaunchApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelName;
    final /* synthetic */ String $finalRichContentJson;
    final /* synthetic */ Function3<String, String, Map<String, ? extends Serializable>, Unit> $ignition;
    final /* synthetic */ ArrayList<LocalMediaInfo> $mediaList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1(Function3<? super String, ? super String, ? super Map<String, ? extends Serializable>, Unit> function3, String str, String str2, ArrayList<LocalMediaInfo> arrayList, Continuation<? super FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1> continuation) {
        super(2, continuation);
        this.$ignition = function3;
        this.$finalRichContentJson = str;
        this.$channelName = str2;
        this.$mediaList = arrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1(this.$ignition, this.$finalRichContentJson, this.$channelName, this.$mediaList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Map<String, ? extends Serializable> map;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function3<String, String, Map<String, ? extends Serializable>, Unit> function3 = this.$ignition;
            String str = this.$finalRichContentJson;
            String str2 = this.$channelName;
            ArrayList<LocalMediaInfo> arrayList = this.$mediaList;
            if (arrayList != null) {
                map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("local_media_info_list", arrayList));
            } else {
                map = null;
            }
            function3.invoke(str, str2, map);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorLaunchApiImpl$processRichContentJsonAndStartLongFeedEditorAsync$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
