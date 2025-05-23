package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import android.app.Activity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorProcessor;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2", f = "BaseWinkAlbumClickDelegator.kt", i = {1, 1}, l = {121, 139, 146}, m = "invokeSuspend", n = {"showLoadingJob", "templateIds"}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
public final class BaseWinkAlbumClickDelegator$onAlbumItemClick2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ T $data;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWinkAlbumClickDelegator$onAlbumItemClick2$2(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, T t16, Continuation<? super BaseWinkAlbumClickDelegator$onAlbumItemClick2$2> continuation) {
        super(2, continuation);
        this.this$0 = baseWinkAlbumClickDelegator;
        this.$data = t16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BaseWinkAlbumClickDelegator$onAlbumItemClick2$2 baseWinkAlbumClickDelegator$onAlbumItemClick2$2 = new BaseWinkAlbumClickDelegator$onAlbumItemClick2$2(this.this$0, this.$data, continuation);
        baseWinkAlbumClickDelegator$onAlbumItemClick2$2.L$0 = obj;
        return baseWinkAlbumClickDelegator$onAlbumItemClick2$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010c  */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.util.Collection, java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Job launch$default;
        Object withContext;
        Job job;
        Ref.ObjectRef objectRef;
        boolean z16;
        final Job job2;
        final Ref.ObjectRef objectRef2;
        Object v3;
        List list;
        boolean z17;
        int collectionSizeOrDefault;
        Object v16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        QLog.w(this.this$0.i(), 1, "onAlbumItemClick, getMaterialInfo failed ");
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$1;
                Job job3 = (Job) this.L$0;
                ResultKt.throwOnFailure(obj);
                job = job3;
                withContext = obj;
                List list2 = (List) withContext;
                list = list2;
                if (list == null && !list.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    this.this$0.n().invoke(Boxing.boxBoolean(false));
                    BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator = this.this$0;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    v16 = baseWinkAlbumClickDelegator.v(this);
                    if (v16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    QLog.w(this.this$0.i(), 1, "onAlbumItemClick, getMaterialInfo failed ");
                    return Unit.INSTANCE;
                }
                List list3 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ?? arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList.add(((MetaMaterial) it.next()).f30533id);
                }
                objectRef.element = arrayList;
                objectRef2 = objectRef;
                job2 = job;
                List<LocalMediaInfo> p16 = this.this$0.p(this.$data);
                final HashMap<String, String> hashMap = new HashMap<>();
                this.this$0.f(hashMap, this.$data, null);
                WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, ((WinkNewMemoryAlbumResult) this.$data).getStoryID() + ((WinkNewMemoryAlbumResult) this.$data).getAlbumID());
                WinkMediaPickerNextStepHelper nextStepHelper = this.this$0.getNextStepHelper();
                Activity activity = this.this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                TabType tabType = TabType.ALL_MEDIA;
                MediaPickerScene mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM;
                final BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator2 = this.this$0;
                final T t16 = this.$data;
                nextStepHelper.h(activity, tabType, p16, false, mediaPickerScene, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2.2

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: P */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                    @DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$2$1", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$2$1, reason: invalid class name */
                    /* loaded from: classes21.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Job $showLoadingJob;
                        int label;
                        final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Job job, BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$showLoadingJob = job;
                            this.this$0 = baseWinkAlbumClickDelegator;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            return new AnonymousClass1(this.$showLoadingJob, this.this$0, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                Job.DefaultImpls.cancel$default(this.$showLoadingJob, (CancellationException) null, 1, (Object) null);
                                this.this$0.n().invoke(Boxing.boxBoolean(true));
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                        invoke2(mediaPickerOutput);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
                    
                        if ((!r0.isEmpty()) == true) goto L8;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@NotNull MediaPickerOutput output) {
                        boolean z18;
                        List<? extends LocalMediaInfo> f16;
                        Intrinsics.checkNotNullParameter(output, "output");
                        if (output.e() != null) {
                            z18 = true;
                        }
                        z18 = false;
                        if (z18) {
                            f16 = output.e();
                        } else {
                            f16 = output.f();
                        }
                        List<? extends LocalMediaInfo> list4 = f16;
                        BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator3 = baseWinkAlbumClickDelegator2;
                        Activity activity2 = baseWinkAlbumClickDelegator3.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                        T t17 = t16;
                        Intrinsics.checkNotNull(t17, "null cannot be cast to non-null type com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult");
                        String storyID = ((WinkNewMemoryAlbumResult) t17).getStoryID();
                        List<String> templateIds = objectRef2.element;
                        Intrinsics.checkNotNullExpressionValue(templateIds, "templateIds");
                        baseWinkAlbumClickDelegator3.r(activity2, storyID, templateIds, list4.get(0).path, list4, null, 35, hashMap);
                        BuildersKt__Builders_commonKt.launch$default(baseWinkAlbumClickDelegator2.getMainScope(), null, null, new AnonymousClass1(job2, baseWinkAlbumClickDelegator2, null), 3, null);
                    }
                });
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        if (NetworkUtil.isNetworkAvailable()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$showLoadingJob$1(this.this$0, null), 3, null);
            List<MetaCategory> v06 = WinkEditorResourceManager.a1().v0();
            MetaCategory e16 = h.d().e();
            if (e16 != null) {
                v06.add(0, e16);
            }
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            T t17 = this.$data;
            Intrinsics.checkNotNull(t17, "null cannot be cast to non-null type com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult");
            objectRef3.element = WinkNewAlbumCollectorProcessor.K(((WinkNewMemoryAlbumResult) t17).getStoryID());
            if (v06.size() != 0) {
                Collection collection = (Collection) objectRef3.element;
                if (collection != null && !collection.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    job2 = launch$default;
                    objectRef2 = objectRef3;
                    List<LocalMediaInfo> p162 = this.this$0.p(this.$data);
                    final HashMap<String, String> hashMap2 = new HashMap<>();
                    this.this$0.f(hashMap2, this.$data, null);
                    WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MEMORIES_ALBUM_ID, ((WinkNewMemoryAlbumResult) this.$data).getStoryID() + ((WinkNewMemoryAlbumResult) this.$data).getAlbumID());
                    WinkMediaPickerNextStepHelper nextStepHelper2 = this.this$0.getNextStepHelper();
                    Activity activity2 = this.this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                    TabType tabType2 = TabType.ALL_MEDIA;
                    MediaPickerScene mediaPickerScene2 = MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM;
                    final BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator22 = this.this$0;
                    final T t162 = this.$data;
                    nextStepHelper2.h(activity2, tabType2, p162, false, mediaPickerScene2, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2.2

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: P */
                        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                        @DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$2$1", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$2$1, reason: invalid class name */
                        /* loaded from: classes21.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Job $showLoadingJob;
                            int label;
                            final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Job job, BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$showLoadingJob = job;
                                this.this$0 = baseWinkAlbumClickDelegator;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new AnonymousClass1(this.$showLoadingJob, this.this$0, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    Job.DefaultImpls.cancel$default(this.$showLoadingJob, (CancellationException) null, 1, (Object) null);
                                    this.this$0.n().invoke(Boxing.boxBoolean(true));
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Override // kotlin.jvm.functions.Function2
                            @Nullable
                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                            invoke2(mediaPickerOutput);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
                        
                            if ((!r0.isEmpty()) == true) goto L8;
                         */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke2(@NotNull MediaPickerOutput output) {
                            boolean z18;
                            List<? extends LocalMediaInfo> f16;
                            Intrinsics.checkNotNullParameter(output, "output");
                            if (output.e() != null) {
                                z18 = true;
                            }
                            z18 = false;
                            if (z18) {
                                f16 = output.e();
                            } else {
                                f16 = output.f();
                            }
                            List<? extends LocalMediaInfo> list4 = f16;
                            BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator3 = baseWinkAlbumClickDelegator22;
                            Activity activity22 = baseWinkAlbumClickDelegator3.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                            T t172 = t162;
                            Intrinsics.checkNotNull(t172, "null cannot be cast to non-null type com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult");
                            String storyID = ((WinkNewMemoryAlbumResult) t172).getStoryID();
                            List<String> templateIds = objectRef2.element;
                            Intrinsics.checkNotNullExpressionValue(templateIds, "templateIds");
                            baseWinkAlbumClickDelegator3.r(activity22, storyID, templateIds, list4.get(0).path, list4, null, 35, hashMap2);
                            BuildersKt__Builders_commonKt.launch$default(baseWinkAlbumClickDelegator22.getMainScope(), null, null, new AnonymousClass1(job2, baseWinkAlbumClickDelegator22, null), 3, null);
                        }
                    });
                    return Unit.INSTANCE;
                }
            }
            CoroutineDispatcher c16 = WinkCoroutineScopes.f317652a.c();
            BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1 baseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1 = new BaseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1(this.this$0, this.$data, null);
            this.L$0 = launch$default;
            this.L$1 = objectRef3;
            this.label = 2;
            withContext = BuildersKt.withContext(c16, baseWinkAlbumClickDelegator$onAlbumItemClick2$2$materialList$1, this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            job = launch$default;
            objectRef = objectRef3;
            List list22 = (List) withContext;
            list = list22;
            if (list == null) {
            }
            z17 = true;
            if (!z17) {
            }
        } else {
            BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator3 = this.this$0;
            this.label = 1;
            v3 = baseWinkAlbumClickDelegator3.v(this);
            if (v3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BaseWinkAlbumClickDelegator$onAlbumItemClick2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
