package com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel;

import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.p;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeDirectoryType;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeNodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetRootPageContentCallback;
import com.tencent.qqnt.kernel.nativeinterface.RootPageContentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.RootPageRepositoryKt$getRootPage$2", f = "RootPageRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class RootPageRepositoryKt$getRootPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Function2<Integer, List<a>, Unit> $callback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RootPageRepositoryKt$getRootPage$2(Function2<? super Integer, ? super List<a>, Unit> function2, Continuation<? super RootPageRepositoryKt$getRootPage$2> continuation) {
        super(2, continuation);
        this.$callback = function2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2, (Object) continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 function2, int i3, ArrayList rootPageContent) {
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(rootPageContent, "rootPageContent");
        Iterator it = rootPageContent.iterator();
        while (it.hasNext()) {
            RootPageContentInfo rootPageContentInfo = (RootPageContentInfo) it.next();
            String str = rootPageContentInfo.groupName;
            Intrinsics.checkNotNullExpressionValue(str, "it.groupName");
            arrayList.add(new b(str));
            ArrayList<FileBridgeNodeInfo> arrayList2 = rootPageContentInfo.groupContent;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "it.groupContent");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (FileBridgeNodeInfo fileBridgeNodeInfo : arrayList2) {
                String str2 = fileBridgeNodeInfo.name;
                Intrinsics.checkNotNullExpressionValue(str2, "item.name");
                String str3 = fileBridgeNodeInfo.pathOnDesktop;
                Intrinsics.checkNotNullExpressionValue(str3, "item.pathOnDesktop");
                String str4 = fileBridgeNodeInfo.fileId;
                Intrinsics.checkNotNullExpressionValue(str4, "item.fileId");
                FileBridgeDirectoryType fileBridgeDirectoryType = fileBridgeNodeInfo.dirType;
                Intrinsics.checkNotNullExpressionValue(fileBridgeDirectoryType, "item.dirType");
                arrayList3.add(new c(str2, str3, str4, fileBridgeDirectoryType));
            }
            arrayList.addAll(arrayList3);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RootPageRepositoryKt$getRootPage$2$1$2(function2, i3, arrayList, null), 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new RootPageRepositoryKt$getRootPage$2(this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                p A = QFileBridgeService.f205517a.A();
                if (A != null) {
                    final Function2<Integer, List<a>, Unit> function2 = this.$callback;
                    A.getRootPageContent(new IKernelGetRootPageContentCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.rootpage.viewmodel.e
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetRootPageContentCallback
                        public final void onResult(int i3, ArrayList arrayList) {
                            RootPageRepositoryKt$getRootPage$2.b(Function2.this, i3, arrayList);
                        }
                    });
                    return Unit.INSTANCE;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((RootPageRepositoryKt$getRootPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
