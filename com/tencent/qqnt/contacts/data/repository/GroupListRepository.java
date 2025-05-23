package com.tencent.qqnt.contacts.data.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.contacts.data.datasource.PlatformGroupListDataSource;
import com.tencent.qqnt.contacts.data.f;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/contacts/data/repository/GroupListRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tencent/qqnt/contacts/data/f;", "c", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "operate", "", "g", "", "groupCode", "d", "f", "Lcom/tencent/qqnt/contacts/data/datasource/PlatformGroupListDataSource;", "a", "Lcom/tencent/qqnt/contacts/data/datasource/PlatformGroupListDataSource;", "platformDataSource", "Lcom/tencent/qqnt/contacts/data/datasource/b;", "b", "Lcom/tencent/qqnt/contacts/data/datasource/b;", "localCacheDataSource", "J", "mGroupCode", "<init>", "(Lcom/tencent/qqnt/contacts/data/datasource/PlatformGroupListDataSource;Lcom/tencent/qqnt/contacts/data/datasource/b;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GroupListRepository {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlatformGroupListDataSource platformDataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.contacts.data.datasource.b localCacheDataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mGroupCode;

    public GroupListRepository(@NotNull PlatformGroupListDataSource platformDataSource, @NotNull com.tencent.qqnt.contacts.data.datasource.b localCacheDataSource) {
        Intrinsics.checkNotNullParameter(platformDataSource, "platformDataSource");
        Intrinsics.checkNotNullParameter(localCacheDataSource, "localCacheDataSource");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) platformDataSource, (Object) localCacheDataSource);
        } else {
            this.platformDataSource = platformDataSource;
            this.localCacheDataSource = localCacheDataSource;
        }
    }

    @NotNull
    public final Flow<List<f>> c() {
        boolean z16;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Flow) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        List<f> b16 = this.localCacheDataSource.b();
        List<f> list = b16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            List<GroupSimpleInfo> c16 = this.platformDataSource.c();
            com.tencent.qqnt.contacts.data.converter.a aVar = com.tencent.qqnt.contacts.data.converter.a.f355838a;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                arrayList.add(aVar.a((GroupSimpleInfo) it.next()));
            }
            this.localCacheDataSource.d(arrayList);
            b16 = arrayList;
        }
        return FlowKt.flowOf(b16);
    }

    @NotNull
    public final Flow<List<f>> d(long groupCode) {
        boolean z16;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Flow) iPatchRedirector.redirect((short) 5, (Object) this, groupCode);
        }
        this.mGroupCode = groupCode;
        List<f> c16 = this.localCacheDataSource.c(groupCode);
        List<f> list = c16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            List<MemberInfo> e16 = this.platformDataSource.e(groupCode);
            com.tencent.qqnt.contacts.data.converter.a aVar = com.tencent.qqnt.contacts.data.converter.a.f355838a;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            c16 = new ArrayList<>(collectionSizeOrDefault);
            Iterator<T> it = e16.iterator();
            while (it.hasNext()) {
                c16.add(aVar.b((MemberInfo) it.next()));
            }
        }
        return FlowKt.flowOf(c16);
    }

    @NotNull
    public final Flow<List<f>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        final Flow<List<GroupSimpleInfo>> g16 = this.platformDataSource.g();
        return FlowKt.onEach(new Flow<List<? extends f>>() { // from class: com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupListChanged$$inlined$map$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupListChanged$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes24.dex */
            public static final class AnonymousClass2 implements FlowCollector<List<? extends GroupSimpleInfo>> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f355883d;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupListChanged$$inlined$map$1$2", f = "GroupListRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupListChanged$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes24.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    static IPatchRedirector $redirector_;
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                        }
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f355883d = flowCollector;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(List<? extends GroupSimpleInfo> list, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    int collectionSizeOrDefault;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) continuation);
                    }
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f355883d;
                                List<? extends GroupSimpleInfo> list2 = list;
                                com.tencent.qqnt.contacts.data.converter.a aVar = com.tencent.qqnt.contacts.data.converter.a.f355838a;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                Iterator<T> it = list2.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(aVar.a((GroupSimpleInfo) it.next()));
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Flow.this);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends f>> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return iPatchRedirector2.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                }
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new GroupListRepository$observerGroupListChanged$2(this, null));
    }

    @NotNull
    public final Flow<List<f>> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Flow) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        final Flow<List<MemberInfo>> h16 = this.platformDataSource.h();
        return FlowKt.onEach(new Flow<List<? extends f>>() { // from class: com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupMemberListChanged$$inlined$map$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupMemberListChanged$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes24.dex */
            public static final class AnonymousClass2 implements FlowCollector<List<? extends MemberInfo>> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f355885d;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupMemberListChanged$$inlined$map$1$2", f = "GroupListRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.qqnt.contacts.data.repository.GroupListRepository$observerGroupMemberListChanged$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes24.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    static IPatchRedirector $redirector_;
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) continuation);
                        }
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                        }
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f355885d = flowCollector;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(List<? extends MemberInfo> list, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    int collectionSizeOrDefault;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) continuation);
                    }
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f355885d;
                                List<? extends MemberInfo> list2 = list;
                                com.tencent.qqnt.contacts.data.converter.a aVar = com.tencent.qqnt.contacts.data.converter.a.f355838a;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                                Iterator<T> it = list2.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(aVar.b((MemberInfo) it.next()));
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Flow.this);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends f>> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return iPatchRedirector2.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                }
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new GroupListRepository$observerGroupMemberListChanged$2(this, null));
    }

    public final void g(@NotNull IOperateCallback operate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) operate);
        } else {
            Intrinsics.checkNotNullParameter(operate, "operate");
            this.platformDataSource.i(operate);
        }
    }
}
