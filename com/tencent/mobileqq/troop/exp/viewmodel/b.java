package com.tencent.mobileqq.troop.exp.viewmodel;

import android.os.Handler;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.exp.viewmodel.b;
import com.tencent.mobileqq.troop.recommend.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0014J\b\u0010\u001c\u001a\u00020\u0005H\u0014R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/exp/viewmodel/b;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/troop/exp/viewmodel/TroopRepository;", "Lcom/tencent/mobileqq/troop/exp/viewmodel/d;", "observer", "", "O1", "U1", "Lcom/tencent/mobileqq/troop/exp/viewmodel/e;", "P1", "W1", "Lcom/tencent/mobileqq/troop/exp/viewmodel/f;", "Q1", "X1", "", "styleType", "R1", "", "keywordName", "curPage", "", FeedManager.LOAD_MORE, "S1", "from", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "info", "Z1", "T1", "onCleared", "Lcom/tencent/common/app/AppInterface;", "i", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "uiGuildSearchRecommendObservers", BdhLogUtil.LogTag.Tag_Conn, "uiGuildSearchRecommendObserverV2s", "D", "uiTroopMngObservers", "Lcom/tencent/mobileqq/troop/recommend/c;", "E", "Lcom/tencent/mobileqq/troop/recommend/c;", "guildSearchRecommendObserver", "Lcom/tencent/mobileqq/troop/api/observer/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/api/observer/b;", "mTroopMngObserver", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends com.tencent.mobileqq.mvvm.c<TroopRepository> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<e> uiGuildSearchRecommendObserverV2s;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<f> uiTroopMngObservers;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.recommend.c guildSearchRecommendObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.api.observer.b mTroopMngObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> uiGuildSearchRecommendObservers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JX\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0014\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/troop/exp/viewmodel/b$a", "Lcom/tencent/mobileqq/troop/recommend/c;", "", "isSuccess", "", "itemType", "", "keyWord", "serverPageID", "isEnd", "", "Lcom/tencent/mobileqq/troop/recommend/c$a;", "dataList", "Ltencent/im/oidb/guild_search_recommend_svr/guildSearchRecommendSvr$FirstShow;", "firstShow", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "sessionInfo", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends com.tencent.mobileqq.troop.recommend.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b this$0, boolean z16, int i3, String keyWord, int i16, boolean z17, List list, guildSearchRecommendSvr$FirstShow firstShow, ByteStringMicro sessionInfo, boolean z18) {
            ArrayList arrayList;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(keyWord, "$keyWord");
            Intrinsics.checkNotNullParameter(firstShow, "$firstShow");
            Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
            Iterator it = this$0.uiGuildSearchRecommendObservers.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(z16, i3, keyWord, i16, z17, list, firstShow, sessionInfo, z18);
            }
            for (e eVar : this$0.uiGuildSearchRecommendObserverV2s) {
                if (list != null) {
                    List list2 = list;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        arrayList2.add(((c.a) it5.next()).a());
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                eVar.a(z16, i3, keyWord, i16, z17, arrayList, firstShow, sessionInfo, z18);
            }
        }

        @Override // com.tencent.mobileqq.troop.recommend.c
        protected void a(final boolean isSuccess, final int itemType, @NotNull final String keyWord, final int serverPageID, final boolean isEnd, @Nullable final List<? extends c.a> dataList, @NotNull final guildSearchRecommendSvr$FirstShow firstShow, @NotNull final ByteStringMicro sessionInfo, final boolean isLoadMore) {
            Intrinsics.checkNotNullParameter(keyWord, "keyWord");
            Intrinsics.checkNotNullParameter(firstShow, "firstShow");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final b bVar = b.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.exp.viewmodel.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.d(b.this, isSuccess, itemType, keyWord, serverPageID, isEnd, dataList, firstShow, sessionInfo, isLoadMore);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/exp/viewmodel/b$b", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "reqtype", "result", "", "troopUin", "", "l", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.exp.viewmodel.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8681b extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        C8681b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(b this$0, int i3, int i16, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator it = this$0.uiTroopMngObservers.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(i3, i16, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(final int reqtype, final int result, @Nullable final String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(reqtype), Integer.valueOf(result), troopUin);
            } else if (1 == reqtype) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final b bVar = b.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.troop.exp.viewmodel.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.C8681b.z(b.this, reqtype, result, troopUin);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull AppInterface app) {
        super(new TroopRepository(app));
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
            return;
        }
        this.app = app;
        this.uiGuildSearchRecommendObservers = new ArrayList();
        this.uiGuildSearchRecommendObserverV2s = new ArrayList();
        this.uiTroopMngObservers = new ArrayList();
        a aVar = new a();
        this.guildSearchRecommendObserver = aVar;
        C8681b c8681b = new C8681b();
        this.mTroopMngObserver = c8681b;
        app.addObserver(aVar);
        app.addObserver(c8681b);
    }

    public final void O1(@NotNull d observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.uiGuildSearchRecommendObservers.contains(observer)) {
            return;
        }
        this.uiGuildSearchRecommendObservers.add(observer);
    }

    public final void P1(@NotNull e observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.uiGuildSearchRecommendObserverV2s.contains(observer)) {
            return;
        }
        this.uiGuildSearchRecommendObserverV2s.add(observer);
    }

    public final void Q1(@NotNull f observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.uiTroopMngObservers.contains(observer)) {
            return;
        }
        this.uiTroopMngObservers.add(observer);
    }

    public final void R1(int styleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, styleType);
        } else {
            getRepository().k(styleType);
        }
    }

    public final void S1(@NotNull String keywordName, int curPage, boolean loadMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, keywordName, Integer.valueOf(curPage), Boolean.valueOf(loadMore));
        } else {
            Intrinsics.checkNotNullParameter(keywordName, "keywordName");
            getRepository().l(-1, null, keywordName, curPage, 2, loadMore);
        }
    }

    public final boolean T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return getRepository().n();
    }

    public final void U1(@NotNull d observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.uiGuildSearchRecommendObservers.contains(observer)) {
            return;
        }
        this.uiGuildSearchRecommendObservers.remove(observer);
    }

    public final void W1(@NotNull e observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.uiGuildSearchRecommendObserverV2s.contains(observer)) {
            return;
        }
        this.uiGuildSearchRecommendObserverV2s.remove(observer);
    }

    public final void X1(@NotNull f observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.uiTroopMngObservers.contains(observer)) {
            return;
        }
        this.uiTroopMngObservers.remove(observer);
    }

    public final void Z1(@NotNull String from, @Nullable ByteStringMicro info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) from, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            getRepository().o(from, info);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.app.removeObserver(this.guildSearchRecommendObserver);
        this.app.removeObserver(this.mTroopMngObserver);
        super.onCleared();
    }
}
