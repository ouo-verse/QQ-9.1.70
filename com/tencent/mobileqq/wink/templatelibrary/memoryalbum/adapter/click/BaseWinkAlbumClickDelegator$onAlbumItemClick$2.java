package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import android.app.Activity;
import android.content.Intent;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.g;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2", f = "BaseWinkAlbumClickDelegator.kt", i = {3}, l = {59, 67, 73, 79, 85}, m = "invokeSuspend", n = {WadlProxyConsts.KEY_MATERIAL}, s = {"L$0"})
/* loaded from: classes21.dex */
public final class BaseWinkAlbumClickDelegator$onAlbumItemClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ T $data;
    Object L$0;
    int label;
    final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWinkAlbumClickDelegator$onAlbumItemClick$2(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, T t16, Continuation<? super BaseWinkAlbumClickDelegator$onAlbumItemClick$2> continuation) {
        super(2, continuation);
        this.this$0 = baseWinkAlbumClickDelegator;
        this.$data = t16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BaseWinkAlbumClickDelegator$onAlbumItemClick$2(this.this$0, this.$data, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object v3;
        MetaMaterial metaMaterial;
        Object v16;
        Long l3;
        final Intent d16;
        Object v17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            metaMaterial = (MetaMaterial) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            l3 = (Long) ((Map) obj).get("loadMateResult");
                            if (l3 != null && l3.longValue() == 0) {
                                this.this$0.n().invoke(Boxing.boxBoolean(false));
                                BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator = this.this$0;
                                this.L$0 = null;
                                this.label = 5;
                                v17 = baseWinkAlbumClickDelegator.v(this);
                                if (v17 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                List<? extends LocalMediaInfo> p16 = this.this$0.p(this.$data);
                                TemplateLibraryData q16 = this.this$0.q(this.$data, metaMaterial);
                                HashMap<String, String> hashMap = new HashMap<>();
                                this.this$0.f(hashMap, this.$data, metaMaterial);
                                BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator2 = this.this$0;
                                Intent intent = baseWinkAlbumClickDelegator2.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getIntent();
                                Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                                d16 = baseWinkAlbumClickDelegator2.d(intent);
                                this.this$0.g(d16, this.$data, metaMaterial, p16);
                                d16.putExtra("key_attrs", hashMap);
                                WinkMediaPickerNextStepHelper nextStepHelper = this.this$0.getNextStepHelper();
                                Activity activity = this.this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                                TabType tabType = TabType.ALL_MEDIA;
                                MediaPickerScene mediaPickerScene = MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM;
                                final BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator3 = this.this$0;
                                nextStepHelper.h(activity, tabType, p16, false, mediaPickerScene, q16, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2.1

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* compiled from: P */
                                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                                    @DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2$1$1", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes21.dex */
                                    public static final class C90891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        int label;
                                        final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C90891(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, Continuation<? super C90891> continuation) {
                                            super(2, continuation);
                                            this.this$0 = baseWinkAlbumClickDelegator;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @NotNull
                                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                            return new C90891(this.this$0, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object obj) {
                                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            if (this.label == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.this$0.n().invoke(Boxing.boxBoolean(true));
                                                return Unit.INSTANCE;
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        @Nullable
                                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                            return ((C90891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@NotNull MediaPickerOutput it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        g.d(baseWinkAlbumClickDelegator3.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), d16, baseWinkAlbumClickDelegator3.u(it));
                                        BuildersKt__Builders_commonKt.launch$default(baseWinkAlbumClickDelegator3.getMainScope(), null, null, new C90891(baseWinkAlbumClickDelegator3, null), 3, null);
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        QLog.w(this.this$0.i(), 1, "onAlbumItemClick, getMaterialInfo failed ");
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    metaMaterial = (MetaMaterial) obj;
                    if (metaMaterial != null) {
                        this.this$0.n().invoke(Boxing.boxBoolean(false));
                        BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator4 = this.this$0;
                        this.label = 3;
                        v16 = baseWinkAlbumClickDelegator4.v(this);
                        if (v16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        QLog.w(this.this$0.i(), 1, "onAlbumItemClick, getMaterialInfo failed ");
                        return Unit.INSTANCE;
                    }
                    CoroutineDispatcher c16 = WinkCoroutineScopes.f317652a.c();
                    BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1 baseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1 = new BaseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1(this.this$0, metaMaterial, null);
                    this.L$0 = metaMaterial;
                    this.label = 4;
                    obj = BuildersKt.withContext(c16, baseWinkAlbumClickDelegator$onAlbumItemClick$2$costMap$1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    l3 = (Long) ((Map) obj).get("loadMateResult");
                    if (l3 != null) {
                        this.this$0.n().invoke(Boxing.boxBoolean(false));
                        BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator5 = this.this$0;
                        this.L$0 = null;
                        this.label = 5;
                        v17 = baseWinkAlbumClickDelegator5.v(this);
                        if (v17 == coroutine_suspended) {
                        }
                    }
                    List<? extends LocalMediaInfo> p162 = this.this$0.p(this.$data);
                    TemplateLibraryData q162 = this.this$0.q(this.$data, metaMaterial);
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    this.this$0.f(hashMap2, this.$data, metaMaterial);
                    BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator22 = this.this$0;
                    Intent intent2 = baseWinkAlbumClickDelegator22.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent2, "activity.intent");
                    d16 = baseWinkAlbumClickDelegator22.d(intent2);
                    this.this$0.g(d16, this.$data, metaMaterial, p162);
                    d16.putExtra("key_attrs", hashMap2);
                    WinkMediaPickerNextStepHelper nextStepHelper2 = this.this$0.getNextStepHelper();
                    Activity activity2 = this.this$0.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String();
                    TabType tabType2 = TabType.ALL_MEDIA;
                    MediaPickerScene mediaPickerScene2 = MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM;
                    final BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator32 = this.this$0;
                    nextStepHelper2.h(activity2, tabType2, p162, false, mediaPickerScene2, q162, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2.1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: P */
                        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                        @DebugMetadata(c = "com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2$1$1", f = "BaseWinkAlbumClickDelegator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator$onAlbumItemClick$2$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes21.dex */
                        public static final class C90891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            int label;
                            final /* synthetic */ BaseWinkAlbumClickDelegator<T> this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C90891(BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator, Continuation<? super C90891> continuation) {
                                super(2, continuation);
                                this.this$0 = baseWinkAlbumClickDelegator;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @NotNull
                            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                                return new C90891(this.this$0, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.this$0.n().invoke(Boxing.boxBoolean(true));
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            @Override // kotlin.jvm.functions.Function2
                            @Nullable
                            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                                return ((C90891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull MediaPickerOutput it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            g.d(baseWinkAlbumClickDelegator32.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String(), d16, baseWinkAlbumClickDelegator32.u(it));
                            BuildersKt__Builders_commonKt.launch$default(baseWinkAlbumClickDelegator32.getMainScope(), null, null, new C90891(baseWinkAlbumClickDelegator32, null), 3, null);
                        }
                    });
                    return Unit.INSTANCE;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (!NetworkUtil.isNetworkAvailable()) {
                BaseWinkAlbumClickDelegator<T> baseWinkAlbumClickDelegator6 = this.this$0;
                this.label = 1;
                v3 = baseWinkAlbumClickDelegator6.v(this);
                if (v3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            this.this$0.o().invoke();
            CoroutineDispatcher c17 = WinkCoroutineScopes.f317652a.c();
            BaseWinkAlbumClickDelegator$onAlbumItemClick$2$material$1 baseWinkAlbumClickDelegator$onAlbumItemClick$2$material$1 = new BaseWinkAlbumClickDelegator$onAlbumItemClick$2$material$1(this.this$0, this.$data, null);
            this.label = 2;
            obj = BuildersKt.withContext(c17, baseWinkAlbumClickDelegator$onAlbumItemClick$2$material$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            metaMaterial = (MetaMaterial) obj;
            if (metaMaterial != null) {
            }
        }
        QLog.w(this.this$0.i(), 1, "onAlbumItemClick, downloadMaterialRes failed ");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BaseWinkAlbumClickDelegator$onAlbumItemClick$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
