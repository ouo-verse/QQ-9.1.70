package com.tencent.mobileqq.exportfile.fragment.filelist.download;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.exportfile.fragment.filelist.download.data.a;
import com.tencent.mobileqq.exportfile.fragment.filelist.download.data.b;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.exportfile.global.o;
import com.tencent.mobileqq.exportfile.global.p;
import com.tencent.mobileqq.exportfile.global.r;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDownloadState;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/FileDownloadViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/data/a;", "Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/data/b;", "Landroidx/lifecycle/LifecycleObserver;", "", "T1", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeDownloadState;", "state", "Q1", "Lcom/tencent/mobileqq/exportfile/global/o;", "body", "U1", "onCreate", "userIntent", "R1", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "fileId", "P1", "()Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/data/b;", "mNoneValueIntent", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "D", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FileDownloadViewModel extends BaseViewModel<com.tencent.mobileqq.exportfile.fragment.filelist.download.data.a, com.tencent.mobileqq.exportfile.fragment.filelist.download.data.b> implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String fileId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/filelist/download/FileDownloadViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f205443a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22520);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FileBridgeDownloadState.values().length];
            try {
                iArr[FileBridgeDownloadState.KNULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileBridgeDownloadState.KWAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileBridgeDownloadState.KDOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f205443a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22812);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FileDownloadViewModel(@NotNull LifecycleOwner owner, @NotNull String fileId) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) owner, (Object) fileId);
        } else {
            this.fileId = fileId;
            owner.getLifecycle().addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(FileBridgeDownloadState state) {
        QLog.d("FileListViewModel", 1, "handleFileState state: " + state);
        int i3 = b.f205443a[state.ordinal()];
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                obtainUiState().setValue(a.c.f205452a);
                return;
            }
            return;
        }
        obtainUiState().setValue(a.d.f205453a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(FileDownloadViewModel this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("FileListViewModel", 1, "handleIntent getFile fileId: " + this$0.fileId + ", result: " + i3 + ", msg: " + str);
    }

    private final void T1() {
        QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
        final Flow<r> v3 = qFileBridgeService.v();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(new Flow<r>(this) { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FileDownloadViewModel f205432e;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<r> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f205433d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FileDownloadViewModel f205434e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$1$2", f = "FileDownloadViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    static IPatchRedirector $redirector_;
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector, FileDownloadViewModel fileDownloadViewModel) {
                    this.f205433d = flowCollector;
                    this.f205434e = fileDownloadViewModel;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector, (Object) fileDownloadViewModel);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(r rVar, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) rVar, (Object) continuation);
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
                                FlowCollector flowCollector = this.f205433d;
                                str = this.f205434e.fileId;
                                if (TextUtils.equals(str, rVar.a())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(rVar, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
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
                this.f205432e = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Flow.this, (Object) this);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super r> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return iPatchRedirector.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                }
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this.f205432e), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new FileDownloadViewModel$observeState$2(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
        final Flow<o> s16 = qFileBridgeService.s();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(new Flow<o>(this) { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FileDownloadViewModel f205436e;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$2$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<o> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f205437d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FileDownloadViewModel f205438e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$2$2", f = "FileDownloadViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$2$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    static IPatchRedirector $redirector_;
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector, FileDownloadViewModel fileDownloadViewModel) {
                    this.f205437d = flowCollector;
                    this.f205438e = fileDownloadViewModel;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector, (Object) fileDownloadViewModel);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(o oVar, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar, (Object) continuation);
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
                                FlowCollector flowCollector = this.f205437d;
                                str = this.f205438e.fileId;
                                if (TextUtils.equals(str, oVar.b())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(oVar, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
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
                this.f205436e = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Flow.this, (Object) this);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super o> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return iPatchRedirector.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                }
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this.f205436e), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new FileDownloadViewModel$observeState$4(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
        final Flow<p> t16 = qFileBridgeService.t();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(new Flow<p>(this) { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$3
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FileDownloadViewModel f205440e;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$3$2, reason: invalid class name */
            /* loaded from: classes12.dex */
            public static final class AnonymousClass2 implements FlowCollector<p> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f205441d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FileDownloadViewModel f205442e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$3$2", f = "FileDownloadViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.exportfile.fragment.filelist.download.FileDownloadViewModel$observeState$$inlined$filter$3$2$1, reason: invalid class name */
                /* loaded from: classes12.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    static IPatchRedirector $redirector_;
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector, FileDownloadViewModel fileDownloadViewModel) {
                    this.f205441d = flowCollector;
                    this.f205442e = fileDownloadViewModel;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) flowCollector, (Object) fileDownloadViewModel);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(p pVar, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return iPatchRedirector.redirect((short) 2, (Object) this, (Object) pVar, (Object) continuation);
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
                                FlowCollector flowCollector = this.f205441d;
                                str = this.f205442e.fileId;
                                if (TextUtils.equals(str, pVar.b())) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(pVar, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
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
                this.f205440e = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Flow.this, (Object) this);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super p> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return iPatchRedirector.redirect((short) 2, (Object) this, (Object) flowCollector, (Object) continuation);
                }
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this.f205440e), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new FileDownloadViewModel$observeState$6(this, null)), Dispatchers.getMain()), ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(o body) {
        if (body.a() == null) {
            return;
        }
        obtainUiState().setValue(new a.C7512a(body.a()));
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.exportfile.fragment.filelist.download.data.b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.exportfile.fragment.filelist.download.data.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.C7513b.f205455a;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.exportfile.fragment.filelist.download.data.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
            if (A != null) {
                A.getFile(this.fileId, new IOperateCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.download.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        FileDownloadViewModel.S1(FileDownloadViewModel.this, i3, str);
                    }
                });
            }
            obtainUiState().setValue(a.c.f205452a);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            T1();
        }
    }
}
