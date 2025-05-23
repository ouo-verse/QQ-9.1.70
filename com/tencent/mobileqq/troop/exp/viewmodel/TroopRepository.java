package com.tencent.mobileqq.troop.exp.viewmodel;

import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J:\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0012\u001a\u00020\u000bR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/exp/viewmodel/TroopRepository;", "Lcom/tencent/mobileqq/mvvm/a;", "", "styleType", "", "k", "itemType", "", "keyWord", "keyWordName", "curPage", "", FeedManager.LOAD_MORE, "l", "from", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "info", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "j", "()Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/troop/recommend/a;", "b", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/troop/recommend/a;", "searchRecommendHandler", "Lcom/tencent/mobileqq/troop/api/IRecommendTroopService;", "c", "Lcom/tencent/mobileqq/troop/api/IRecommendTroopService;", "mRecommendTroopService", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopRepository extends com.tencent.mobileqq.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchRecommendHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecommendTroopService mRecommendTroopService;

    public TroopRepository(@NotNull AppInterface app) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
            return;
        }
        this.app = app;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.recommend.a>() { // from class: com.tencent.mobileqq.troop.exp.viewmodel.TroopRepository$searchRecommendHandler$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopRepository.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.troop.recommend.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.troop.recommend.a) TroopRepository.this.j().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopSearchRecommendHandlerName()) : (com.tencent.mobileqq.troop.recommend.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.searchRecommendHandler = lazy;
        IRuntimeService runtimeService = app.getRuntimeService(IRecommendTroopService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IR\u2026va, ProcessConstant.MAIN)");
        this.mRecommendTroopService = (IRecommendTroopService) runtimeService;
    }

    private final com.tencent.mobileqq.troop.recommend.a m() {
        return (com.tencent.mobileqq.troop.recommend.a) this.searchRecommendHandler.getValue();
    }

    @NotNull
    public final AppInterface j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.app;
    }

    public final void k(int styleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, styleType);
            return;
        }
        com.tencent.mobileqq.troop.recommend.a m3 = m();
        if (m3 != null) {
            m3.D(-1, null, null, 0, styleType, true, false, true);
        }
    }

    public final void l(int itemType, @Nullable String keyWord, @Nullable String keyWordName, int curPage, int styleType, boolean loadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(itemType), keyWord, keyWordName, Integer.valueOf(curPage), Integer.valueOf(styleType), Boolean.valueOf(loadMore));
            return;
        }
        com.tencent.mobileqq.troop.recommend.a m3 = m();
        if (m3 != null) {
            m3.D(itemType, keyWord, keyWordName, curPage, styleType, false, loadMore, false);
        }
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.mRecommendTroopService.isEnd() == 1) {
            return true;
        }
        return false;
    }

    public final void o(@NotNull String from, @Nullable ByteStringMicro info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) from, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        com.tencent.mobileqq.troop.recommend.a m3 = m();
        if (m3 != null) {
            m3.q0(from, info);
        }
    }
}
