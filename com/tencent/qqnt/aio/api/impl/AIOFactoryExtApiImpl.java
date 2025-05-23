package com.tencent.qqnt.aio.api.impl;

import com.tencent.aio.api.factory.f;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.aio.input.AIOInputUIState;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.layout.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOFactoryExtApi;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOFactoryExtApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOFactoryExtApi;", "Lcom/tencent/aio/api/factory/f;", "businessApi", "buildBusinessLevelCompactInputHeight", "Lcom/tencent/aio/api/help/d;", "buildStrangerHelperProvider", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOFactoryExtApiImpl implements IAIOFactoryExtApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0002H\u0016J\u0018\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/aio/api/impl/AIOFactoryExtApiImpl$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "", "buildShortcutBarVB", "Lat/e;", "Lcom/tencent/aio/base/mvi/part/TopTipViewState;", "buildTopTipVB", "", "buildBusinessVB", "Lcom/tencent/mobileqq/aio/layout/a;", tl.h.F, "buildBottomBarVB", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements com.tencent.aio.api.factory.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.base.mvvm.a<at.a, InputUIState> f348883a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.base.mvvm.a<Object, Object> f348884b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.base.mvvm.a<at.e, TopTipViewState> f348885c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.base.mvvm.a<Object, TitleUIState> f348886d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> f348887e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.base.mvvm.a<Object, Object> f348888f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/api/impl/AIOFactoryExtApiImpl$a$a", "Lcom/tencent/mobileqq/aio/layout/c;", "", "left", "top", "right", "bottom", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.api.impl.AIOFactoryExtApiImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9451a implements com.tencent.mobileqq.aio.layout.c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.base.mvvm.a<at.a, InputUIState> f348889a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.base.mvvm.a<Object, Object> f348890b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.tencent.aio.base.mvvm.a<Object, Object> f348891c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.aio.layout.a f348892d;

            C9451a(com.tencent.aio.base.mvvm.a<at.a, InputUIState> aVar, com.tencent.aio.base.mvvm.a<Object, Object> aVar2, com.tencent.aio.base.mvvm.a<Object, Object> aVar3, com.tencent.mobileqq.aio.layout.a aVar4) {
                this.f348889a = aVar;
                this.f348890b = aVar2;
                this.f348891c = aVar3;
                this.f348892d = aVar4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, aVar, aVar2, aVar3, aVar4);
                }
            }

            @Override // com.tencent.mobileqq.aio.layout.c
            public void a(int left, int top, int right, int bottom) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
                    return;
                }
                com.tencent.aio.base.mvvm.a<at.a, InputUIState> aVar = this.f348889a;
                if (aVar != null) {
                    com.tencent.mvi.mvvm.b bVar = this.f348890b;
                    com.tencent.aio.base.mvvm.a<Object, Object> aVar2 = this.f348891c;
                    com.tencent.mobileqq.aio.layout.a aVar3 = this.f348892d;
                    com.tencent.qqnt.aio.shortcutbar.d dVar = null;
                    AIOInputUIState.GetInputBarHeight getInputBarHeight = new AIOInputUIState.GetInputBarHeight(0, 1, null);
                    aVar.handleUIState(getInputBarHeight);
                    int a16 = getInputBarHeight.a();
                    if (bVar instanceof com.tencent.qqnt.aio.shortcutbar.d) {
                        dVar = (com.tencent.qqnt.aio.shortcutbar.d) bVar;
                    }
                    if (dVar != null && dVar.getVisibility() == 0) {
                        a16 += ((com.tencent.qqnt.aio.shortcutbar.d) bVar).getMeasuredHeight();
                    }
                    if (aVar2 != null && aVar2.getHostView().getVisibility() == 0) {
                        a16 += aVar2.getHostView().getMeasuredHeight();
                    }
                    aVar.sendIntent(new f.g(aVar3.e()));
                    aVar.sendIntent(new f.c(left, bottom - a16, right, bottom));
                }
            }
        }

        a(com.tencent.aio.base.mvvm.a<at.a, InputUIState> aVar, com.tencent.aio.base.mvvm.a<Object, Object> aVar2, com.tencent.aio.base.mvvm.a<at.e, TopTipViewState> aVar3, com.tencent.aio.base.mvvm.a<Object, TitleUIState> aVar4, HashMap<com.tencent.mobileqq.aio.layout.d, com.tencent.aio.base.mvvm.a<?, ?>> hashMap, com.tencent.aio.base.mvvm.a<Object, Object> aVar5) {
            this.f348883a = aVar;
            this.f348884b = aVar2;
            this.f348885c = aVar3;
            this.f348886d = aVar4;
            this.f348887e = hashMap;
            this.f348888f = aVar5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, aVar2, aVar3, aVar4, hashMap, aVar5);
            }
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f348888f;
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<?, ?>> buildBusinessVB() {
            List<com.tencent.aio.base.mvvm.a<?, ?>> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            com.tencent.aio.base.mvvm.a<Object, TitleUIState> aVar = this.f348886d;
            if (aVar != null) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
                return listOf;
            }
            return null;
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<at.a, InputUIState> buildInputVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f348883a;
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f348884b;
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return f.a.e(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<at.e, TopTipViewState> buildTopTipVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f348885c;
        }

        @Override // com.tencent.aio.api.factory.h
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.aio.layout.a getLayoutDelegate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.mobileqq.aio.layout.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            com.tencent.mobileqq.aio.layout.a aVar = new com.tencent.mobileqq.aio.layout.a(this.f348887e);
            aVar.f(new C9451a(this.f348883a, this.f348884b, this.f348888f, aVar));
            return aVar;
        }
    }

    public AIOFactoryExtApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryExtApi
    @NotNull
    public com.tencent.aio.api.factory.f buildBusinessLevelCompactInputHeight(@NotNull com.tencent.aio.api.factory.f businessApi) {
        com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> aVar;
        com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> aVar2;
        com.tencent.aio.base.mvvm.a<Object, Object> aVar3;
        com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> aVar4;
        com.tencent.aio.base.mvvm.a<Object, Object> aVar5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.api.factory.f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) businessApi);
        }
        Intrinsics.checkNotNullParameter(businessApi, "businessApi");
        com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB = businessApi.buildInputVB();
        if (buildInputVB instanceof com.tencent.aio.base.mvvm.a) {
            aVar = buildInputVB;
        } else {
            aVar = null;
        }
        com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB = businessApi.buildTitleVB();
        if (buildTitleVB instanceof com.tencent.aio.base.mvvm.a) {
            aVar2 = buildTitleVB;
        } else {
            aVar2 = null;
        }
        com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB = businessApi.buildShortcutBarVB();
        if (buildShortcutBarVB instanceof com.tencent.aio.base.mvvm.a) {
            aVar3 = buildShortcutBarVB;
        } else {
            aVar3 = null;
        }
        com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> buildTopTipVB = businessApi.buildTopTipVB();
        if (buildTopTipVB instanceof com.tencent.aio.base.mvvm.a) {
            aVar4 = buildTopTipVB;
        } else {
            aVar4 = null;
        }
        com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB = businessApi.buildBottomBarVB();
        if (buildBottomBarVB instanceof com.tencent.aio.base.mvvm.a) {
            aVar5 = buildBottomBarVB;
        } else {
            aVar5 = null;
        }
        HashMap hashMap = new HashMap();
        if (aVar != null) {
        }
        d.e eVar = d.e.f189939b;
        Intrinsics.checkNotNull(aVar2, "null cannot be cast to non-null type com.tencent.aio.base.mvvm.AIOBaseVB<*, *>");
        hashMap.put(eVar, aVar2);
        if (aVar3 != null) {
        }
        if (aVar4 != null) {
        }
        if (aVar5 != null) {
            hashMap.put(d.a.f189935b, aVar5);
        }
        return new a(aVar, aVar3, aVar4, aVar2, hashMap, aVar5);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOFactoryExtApi
    @NotNull
    public com.tencent.aio.api.help.d buildStrangerHelperProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.api.help.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new com.tencent.mobileqq.aio.helper.provider.c();
    }
}
