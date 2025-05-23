package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.publish.event.GuildOnPhotoSelectedEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rk1.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1", f = "GuildMediaUploadCoroutineHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {46, 51, 56}, m = "invokeSuspend", n = {ForwardMiniChooseFriendOption.RESULT_LIST, "taskIdMap", "index$iv", "index", ForwardMiniChooseFriendOption.RESULT_LIST, "taskIdMap", "index$iv", "index", "taskIdMap"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0"})
/* loaded from: classes13.dex */
public final class GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuildOnPhotoSelectedEvent $event;
    final /* synthetic */ GuildUploadHelper $instance;
    final /* synthetic */ n $publishConfigMethod;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1(GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent, n nVar, GuildUploadHelper guildUploadHelper, Continuation<? super GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1> continuation) {
        super(2, continuation);
        this.$event = guildOnPhotoSelectedEvent;
        this.$publishConfigMethod = nVar;
        this.$instance = guildUploadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1(this.$event, this.$publishConfigMethod, this.$instance, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x016e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x014f -> B:14:0x0157). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0160 -> B:15:0x0163). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GuildUploadHelper guildUploadHelper;
        Iterator it;
        int i3;
        GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1;
        Object obj2;
        HashMap hashMap;
        Deferred[] deferredArr;
        Object i16;
        Object obj3;
        boolean z16;
        char c16;
        String path;
        Object f16;
        GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12 = this;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.label;
        boolean z17 = true;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        hashMap = (HashMap) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$13 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$13.$instance.p(guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$13.$event.originalPic, hashMap);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i18 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.I$1;
                int i19 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.I$0;
                it = (Iterator) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$3;
                guildUploadHelper = (GuildUploadHelper) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$2;
                HashMap hashMap2 = (HashMap) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$1;
                Deferred[] deferredArr2 = (Deferred[]) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$0;
                ResultKt.throwOnFailure(obj);
                guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12;
                c16 = 2;
                HashMap hashMap3 = hashMap2;
                Deferred[] deferredArr3 = deferredArr2;
                Object g16 = obj;
                i3 = i18;
                z16 = true;
                deferredArr3[i3] = (Deferred) g16;
                obj3 = coroutine_suspended;
                i3 = i19;
                hashMap = hashMap3;
                deferredArr = deferredArr3;
                Object obj4 = obj3;
                z17 = z16;
                obj2 = obj4;
                if (!it.hasNext()) {
                    Object next = it.next();
                    int i26 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
                    String taskId = guildUploadHelper.g();
                    Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
                    Intrinsics.checkNotNullExpressionValue(localMediaInfo, "localMediaInfo");
                    hashMap.put(taskId, localMediaInfo);
                    String path2 = localMediaInfo.path;
                    if (AlbumUtil.isImage(localMediaInfo)) {
                        boolean isHeifFile = Utils.isHeifFile(path2);
                        Object obj5 = obj2;
                        Logger.f235387a.d().d("GuildMediaUploadCoroutineHelper", 1, "launchBlockingUploadCoroutine: isHeif=" + isHeifFile);
                        if (isHeifFile) {
                            path = GuildUploadHelper.e(path2);
                        } else {
                            path = path2;
                        }
                        GuildMediaUploadCoroutineHelper guildMediaUploadCoroutineHelper = GuildMediaUploadCoroutineHelper.f220036a;
                        Intrinsics.checkNotNullExpressionValue(path, "path");
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.L$0 = deferredArr;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.L$1 = hashMap;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.L$2 = guildUploadHelper;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.L$3 = it;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.I$0 = i26;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.I$1 = i3;
                        z16 = true;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1.label = 1;
                        String str = path;
                        GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$14 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1;
                        f16 = guildMediaUploadCoroutineHelper.f(guildUploadHelper, localMediaInfo, taskId, str, guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1);
                        if (f16 == obj5) {
                            return obj5;
                        }
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$14;
                        HashMap hashMap4 = hashMap;
                        Deferred[] deferredArr4 = deferredArr;
                        deferredArr4[i3] = (Deferred) f16;
                        obj3 = obj5;
                        i3 = i26;
                        deferredArr = deferredArr4;
                        c16 = 2;
                        hashMap = hashMap4;
                    } else {
                        GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1;
                        boolean z18 = z17;
                        obj3 = obj2;
                        z16 = z18;
                        if (AlbumUtil.isVideo(localMediaInfo)) {
                            GuildMediaUploadCoroutineHelper guildMediaUploadCoroutineHelper2 = GuildMediaUploadCoroutineHelper.f220036a;
                            Intrinsics.checkNotNullExpressionValue(path2, "path");
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.L$0 = deferredArr;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.L$1 = hashMap;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.L$2 = guildUploadHelper;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.L$3 = it;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.I$0 = i26;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.I$1 = i3;
                            c16 = 2;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15.label = 2;
                            g16 = guildMediaUploadCoroutineHelper2.g(guildUploadHelper, localMediaInfo, path2, taskId, guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15);
                            if (g16 == obj3) {
                                return obj3;
                            }
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15;
                            hashMap3 = hashMap;
                            coroutine_suspended = obj3;
                            Deferred[] deferredArr5 = deferredArr;
                            i19 = i26;
                            deferredArr3 = deferredArr5;
                            deferredArr3[i3] = (Deferred) g16;
                            obj3 = coroutine_suspended;
                            i3 = i19;
                            hashMap = hashMap3;
                            deferredArr = deferredArr3;
                        } else {
                            c16 = 2;
                            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$15;
                            i3 = i26;
                        }
                    }
                    Object obj42 = obj3;
                    z17 = z16;
                    obj2 = obj42;
                    if (!it.hasNext()) {
                        Object obj6 = obj2;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1;
                        GuildMediaUploadCoroutineHelper guildMediaUploadCoroutineHelper3 = GuildMediaUploadCoroutineHelper.f220036a;
                        n nVar = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.$publishConfigMethod;
                        GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.$event;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$0 = hashMap;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$1 = null;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$2 = null;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$3 = null;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.label = 3;
                        i16 = guildMediaUploadCoroutineHelper3.i(deferredArr, nVar, guildOnPhotoSelectedEvent, guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12);
                        if (i16 == obj6) {
                            return obj6;
                        }
                        GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$132 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12;
                        guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$132.$instance.p(guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$132.$event.originalPic, hashMap);
                        return Unit.INSTANCE;
                    }
                }
            } else {
                int i27 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.I$1;
                int i28 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.I$0;
                it = (Iterator) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$3;
                guildUploadHelper = (GuildUploadHelper) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$2;
                HashMap hashMap5 = (HashMap) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$1;
                Deferred[] deferredArr6 = (Deferred[]) guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.L$0;
                ResultKt.throwOnFailure(obj);
                guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12;
                z16 = true;
                deferredArr6[i27] = (Deferred) obj;
                obj3 = coroutine_suspended;
                i3 = i28;
                deferredArr = deferredArr6;
                c16 = 2;
                hashMap = hashMap5;
                Object obj422 = obj3;
                z17 = z16;
                obj2 = obj422;
                if (!it.hasNext()) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Deferred[] deferredArr7 = new Deferred[guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.$event.localMediaInfos.size()];
            HashMap hashMap6 = new HashMap();
            List<LocalMediaInfo> list = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.$event.localMediaInfos;
            Intrinsics.checkNotNullExpressionValue(list, "event.localMediaInfos");
            guildUploadHelper = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12.$instance;
            it = list.iterator();
            i3 = 0;
            guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1 = guildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$12;
            obj2 = coroutine_suspended;
            hashMap = hashMap6;
            deferredArr = deferredArr7;
            if (!it.hasNext()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaUploadCoroutineHelper$launchBlockingUploadCoroutine$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
