package com.tencent.mobileqq.flock.api.impl;

import android.content.Context;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.flock.api.JoinFlockAndTroopResult;
import com.tencent.mobileqq.flock.debug.FlockDebugIndexFragment;
import com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean;
import com.tencent.mobileqq.flock.utils.FlockJumpHelper;
import com.tencent.mobileqq.flock.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.b;
import y45.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002JL\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J&\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J<\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\f2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u001fH\u0016J(\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J)\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/flock/api/impl/FlockLauncherImpl;", "Lcom/tencent/mobileqq/flock/api/IFlockLauncher;", "Landroid/content/Context;", "context", "Ly45/b;", "feed", "", "subSourceId", "Lcom/tencent/mobileqq/flock/api/a;", "callback", "", "joinTroop", "", "userId", "feedId", "", WadlProxyConsts.CREATE_TIME, "troopId", "eUid", "sourceEntranceType", "launchFeedDetailPage", "launchFlockDebugPage", "groupId", "launchGroupFeedListPage", "", "feedDatas", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "scene", "launchSearchRecomFeedListPage", "actionName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "launchFlockBySchemeAction", "addFlockAndJoinTroop", "from", "launchFlockPublishPage", "(Landroid/content/Context;ILjava/lang/Long;)V", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockLauncherImpl implements IFlockLauncher {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/flock/api/impl/FlockLauncherImpl$a", "Lcom/tencent/mobileqq/flock/utils/e$a;", "", "onSuccess", "", "code", "", "msg", "onError", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements e.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f209995b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f209996c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f209997d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.flock.api.a f209998e;

        a(Context context, b bVar, int i3, com.tencent.mobileqq.flock.api.a aVar) {
            this.f209995b = context;
            this.f209996c = bVar;
            this.f209997d = i3;
            this.f209998e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FlockLauncherImpl.this, context, bVar, Integer.valueOf(i3), aVar);
            }
        }

        @Override // com.tencent.mobileqq.flock.utils.e.a
        public void onError(long code, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(code), msg2);
                return;
            }
            this.f209998e.b(JoinFlockAndTroopResult.SYS_ERROR);
            QLog.e("FlockLauncherImpl", 1, "joinFlock error, code:" + code + ", msg:" + msg2);
            QQToastUtil.showQQToast(1, msg2);
        }

        @Override // com.tencent.mobileqq.flock.utils.e.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FlockLauncherImpl.this.joinTroop(this.f209995b, this.f209996c, this.f209997d, this.f209998e);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public FlockLauncherImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void joinTroop(Context context, b feed, int subSourceId, final com.tencent.mobileqq.flock.api.a callback) {
        String valueOf = String.valueOf(feed.f449367b);
        byte[] bArr = feed.f449381p;
        Intrinsics.checkNotNullExpressionValue(bArr, "feed.joinGroupAuthsig");
        FlockJumpHelper.INSTANCE.c(context, new com.tencent.mobileqq.troop.troopjoin.a(valueOf, new String(bArr, Charsets.UTF_8), subSourceId, false, null, false, 56, null), feed.f449382q, true, new Function2<TryJoinTroopResult, Integer, Unit>() { // from class: com.tencent.mobileqq.flock.api.impl.FlockLauncherImpl$joinTroop$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f209999a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23720);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[TryJoinTroopResult.values().length];
                    try {
                        iArr[TryJoinTroopResult.HAS_JOINED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TryJoinTroopResult.HAS_LAUNCH.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[TryJoinTroopResult.PARAMS_ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f209999a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.flock.api.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TryJoinTroopResult tryJoinTroopResult, Integer num) {
                invoke(tryJoinTroopResult, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TryJoinTroopResult result, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) result, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(result, "result");
                int i16 = a.f209999a[result.ordinal()];
                if (i16 == 1 || i16 == 2) {
                    com.tencent.mobileqq.flock.api.a.this.a(JoinFlockAndTroopResult.SUCCESS);
                    QLog.e("FlockLauncherImpl", 1, "joinTroop success, code:" + result);
                    return;
                }
                if (i16 != 3) {
                    com.tencent.mobileqq.flock.api.a.this.b(JoinFlockAndTroopResult.SYS_ERROR);
                    QLog.e("FlockLauncherImpl", 1, "joinTroop error, code:" + result);
                    return;
                }
                com.tencent.mobileqq.flock.api.a.this.b(JoinFlockAndTroopResult.PARAMS_ERROR);
                QLog.e("FlockLauncherImpl", 1, "joinTroop error, code:" + result);
            }
        });
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void addFlockAndJoinTroop(@NotNull Context context, @NotNull b feed, @NotNull com.tencent.mobileqq.flock.api.a callback, int subSourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, feed, callback, Integer.valueOf(subSourceId));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(callback, "callback");
        k kVar = feed.f449379n;
        Intrinsics.checkNotNullExpressionValue(kVar, "feed.joinInfo");
        if (com.tencent.mobileqq.flock.ktx.e.h(kVar)) {
            joinTroop(context, feed, subSourceId, callback);
        } else {
            e.f210484a.b(feed, new a(context, feed, subSourceId, callback));
        }
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void launchFeedDetailPage(@NotNull Context context, @Nullable String userId, @NotNull String feedId, long createTime, long troopId, @Nullable String eUid, int subSourceId, int sourceEntranceType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, userId, feedId, Long.valueOf(createTime), Long.valueOf(troopId), eUid, Integer.valueOf(subSourceId), Integer.valueOf(sourceEntranceType));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        com.tencent.mobileqq.flock.a.f209993a.a(context, new FlockFeedDetailInitBean(userId, feedId, createTime, troopId, null, eUid, sourceEntranceType, subSourceId, 16, null));
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void launchFlockBySchemeAction(@NotNull Context context, @NotNull String actionName, @NotNull HashMap<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, actionName, params);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.mobileqq.flock.scheme.b.INSTANCE.a(context, actionName, params);
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void launchFlockDebugPage(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            CompatPublicActivity.start(context, FlockDebugIndexFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void launchFlockPublishPage(@NotNull Context context, int from, @Nullable Long troopId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(from), troopId);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            com.tencent.mobileqq.flock.a.e(com.tencent.mobileqq.flock.a.f209993a, context, from, troopId, null, null, 24, null);
        }
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void launchGroupFeedListPage(@NotNull Context context, long groupId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Long.valueOf(groupId));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            com.tencent.mobileqq.flock.a.f209993a.g(context, groupId);
        }
    }

    @Override // com.tencent.mobileqq.flock.api.IFlockLauncher
    public void launchSearchRecomFeedListPage(@NotNull Context context, @NotNull List<b> feedDatas, @NotNull FlockConstants$FlockListScene scene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, feedDatas, scene);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedDatas, "feedDatas");
        Intrinsics.checkNotNullParameter(scene, "scene");
        com.tencent.mobileqq.flock.a.f209993a.i(context, feedDatas, scene);
    }
}
