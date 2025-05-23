package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaScene;
import org.light.aigc.bean.MediaType;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {977, 979}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Pair<AIGCContentOutput, Map<String, String>> $aigcResponse;
    final /* synthetic */ Ref.ObjectRef<MediaType> $mediaType;
    final /* synthetic */ AtomicInteger $successCount;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1(Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair, Ref.ObjectRef<MediaType> objectRef, AtomicInteger atomicInteger, Continuation<? super MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1> continuation) {
        super(2, continuation);
        this.$aigcResponse = pair;
        this.$mediaType = objectRef;
        this.$successCount = atomicInteger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1(this.$aigcResponse, this.$mediaType, this.$successCount, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007f A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:6:0x0014, B:7:0x00b8, B:13:0x0022, B:14:0x00a5, B:16:0x002d, B:18:0x0040, B:19:0x004b, B:21:0x0051, B:26:0x0063, B:33:0x006a, B:35:0x0072, B:38:0x007b, B:40:0x007f, B:42:0x0087, B:44:0x008b, B:45:0x008d, B:47:0x0097, B:50:0x00a8), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:6:0x0014, B:7:0x00b8, B:13:0x0022, B:14:0x00a5, B:16:0x002d, B:18:0x0040, B:19:0x004b, B:21:0x0051, B:26:0x0063, B:33:0x006a, B:35:0x0072, B:38:0x007b, B:40:0x007f, B:42:0x0087, B:44:0x008b, B:45:0x008d, B:47:0x0097, B:50:0x00a8), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:6:0x0014, B:7:0x00b8, B:13:0x0022, B:14:0x00a5, B:16:0x002d, B:18:0x0040, B:19:0x004b, B:21:0x0051, B:26:0x0063, B:33:0x006a, B:35:0x0072, B:38:0x007b, B:40:0x007f, B:42:0x0087, B:44:0x008b, B:45:0x008d, B:47:0x0097, B:50:0x00a8), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a8 A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:6:0x0014, B:7:0x00b8, B:13:0x0022, B:14:0x00a5, B:16:0x002d, B:18:0x0040, B:19:0x004b, B:21:0x0051, B:26:0x0063, B:33:0x006a, B:35:0x0072, B:38:0x007b, B:40:0x007f, B:42:0x0087, B:44:0x008b, B:45:0x008d, B:47:0x0097, B:50:0x00a8), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007a  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [T] */
    /* JADX WARN: Type inference failed for: r1v5, types: [org.light.aigc.bean.MediaType] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        String str;
        String str2;
        Object firstOrNull;
        Object firstOrNull2;
        boolean z16;
        String str3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        str3 = (String) obj;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    str3 = (String) obj;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                w53.b.a("MagicStudioCreationViewModel", "download aigcImg");
                List<ContentInfo> list = this.$aigcResponse.getFirst().contentInfos;
                ?? r16 = 0;
                r16 = 0;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (((ContentInfo) obj2).scene == MediaScene.SceneResult) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            arrayList.add(obj2);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                    ContentInfo contentInfo = (ContentInfo) firstOrNull2;
                    if (contentInfo != null) {
                        str = contentInfo.stringData;
                        if (str != null) {
                            str2 = "";
                        } else {
                            str2 = str;
                        }
                        Ref.ObjectRef<MediaType> objectRef = this.$mediaType;
                        if (arrayList != null) {
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                            ContentInfo contentInfo2 = (ContentInfo) firstOrNull;
                            if (contentInfo2 != null) {
                                r16 = contentInfo2.type;
                            }
                        }
                        if (r16 == 0) {
                            r16 = MediaType.TypeImage;
                        }
                        objectRef.element = r16;
                        if (this.$successCount.get() != 0) {
                            MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                            this.label = 1;
                            obj = magicStudioDataSource.y(str2, true, IPrefRecorder.MILESTONE_MAGIC_GALLERY_DOWNLOAD_FIRST_IMAGE, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = (String) obj;
                        } else {
                            MagicStudioDataSource magicStudioDataSource2 = MagicStudioDataSource.f323652a;
                            this.label = 2;
                            obj = MagicStudioDataSource.z(magicStudioDataSource2, str2, false, null, this, 4, null);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = (String) obj;
                        }
                    }
                }
                str = null;
                if (str != null) {
                }
                Ref.ObjectRef<MediaType> objectRef2 = this.$mediaType;
                if (arrayList != null) {
                }
                if (r16 == 0) {
                }
                objectRef2.element = r16;
                if (this.$successCount.get() != 0) {
                }
            }
            return str3;
        } catch (Exception e16) {
            w53.b.h("MagicStudioCreationViewModel", "imgResult error", e16);
            return "";
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((MagicStudioCreationViewModel$onReceiveAigcResp$imgPath$imgResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
