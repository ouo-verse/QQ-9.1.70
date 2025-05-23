package com.tencent.qqnt.qbasealbum.albumlist.viewmodel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.albumlist.repository.c;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.model.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel$queryAlbumList$1", f = "AlbumListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AlbumListViewModel$queryAlbumList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TabType $tabType;
    int label;
    final /* synthetic */ AlbumListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumListViewModel$queryAlbumList$1(AlbumListViewModel albumListViewModel, TabType tabType, Continuation<? super AlbumListViewModel$queryAlbumList$1> continuation) {
        super(2, continuation);
        this.this$0 = albumListViewModel;
        this.$tabType = tabType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, albumListViewModel, tabType, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new AlbumListViewModel$queryAlbumList$1(this.this$0, this.$tabType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                cVar = this.this$0.albumRepository;
                c.f(cVar, AlbumListViewModel.INSTANCE.a(), new c.a(currentTimeMillis) { // from class: com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel$queryAlbumList$1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ long f360894b;

                    {
                        this.f360894b = currentTimeMillis;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AlbumListViewModel.this, Long.valueOf(currentTimeMillis));
                        }
                    }

                    @Override // com.tencent.qqnt.qbasealbum.albumlist.repository.c.a
                    public void a(@Nullable List<b> albums) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.f()), null, null, new AlbumListViewModel$queryAlbumList$1$1$onQueryFinished$1(AlbumListViewModel.this, albums, this.f360894b, null), 3, null);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) albums);
                        }
                    }
                }, this.$tabType, false, 8, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AlbumListViewModel$queryAlbumList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
