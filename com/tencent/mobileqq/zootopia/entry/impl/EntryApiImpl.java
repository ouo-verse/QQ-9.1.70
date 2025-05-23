package com.tencent.mobileqq.zootopia.entry.impl;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.authorize.api.CheckResult;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.a;
import com.tencent.mobileqq.zplan.authorize.api.c;
import com.tencent.mobileqq.zplan.entry.impl.entry.SameStyleEntry;
import com.tencent.mobileqq.zplan.entry.impl.entry.SubSceneAvatarEntry;
import com.tencent.mobileqq.zplan.entry.impl.entry.d;
import com.tencent.mobileqq.zplan.entry.impl.entry.e;
import com.tencent.mobileqq.zplan.entry.impl.entry.f;
import com.tencent.mobileqq.zplan.entry.impl.entry.g;
import com.tencent.mobileqq.zplan.entry.impl.entry.h;
import com.tencent.mobileqq.zplan.entry.impl.entry.i;
import com.tencent.mobileqq.zplan.entry.impl.entry.j;
import com.tencent.mobileqq.zplan.entry.impl.entry.k;
import com.tencent.mobileqq.zplan.entry.impl.entry.l;
import com.tencent.mobileqq.zplan.entry.impl.entry.m;
import com.tencent.mobileqq.zplan.entry.impl.entry.n;
import com.tencent.mobileqq.zplan.entry.impl.entry.o;
import com.tencent.mobileqq.zplan.entry.impl.entry.p;
import com.tencent.mobileqq.zplan.entry.impl.entry.q;
import com.tencent.mobileqq.zplan.entry.impl.entry.r;
import com.tencent.mobileqq.zplan.entry.impl.entry.s;
import com.tencent.mobileqq.zplan.entry.impl.entry.t;
import com.tencent.mobileqq.zplan.entry.impl.entry.u;
import com.tencent.mobileqq.zplan.entry.impl.entry.v;
import com.tencent.mobileqq.zplan.entry.impl.entry.w;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import wc3.AigcPreviewParams;
import wc3.ExtraReportParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016JL\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00152\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019H\u0016J2\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010$\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J2\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J,\u0010)\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010*\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010+\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010,\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010-\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010.\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\"\u0010/\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u00100\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J \u00102\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u00103\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u00104\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J0\u00105\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000eH\u0016J\"\u00106\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zootopia/entry/impl/EntryApiImpl;", "Lcom/tencent/mobileqq/zootopia/entry/IEntryApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lqh3/b;", "entry", "", "handleEntry", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "", "mapId", "Landroid/os/Bundle;", "bundle", "tryOpenDetailPageWhenMapNotReady", "startSimpleAvatarFragment", "startAvatarSubSceneFragment", "startPortalActivity", "startSeparateSceneFragment", "", "", "", "ueParams", "Lkotlin/Function1;", "callback", "startMap", "pageBundle", "ueBundle", "startMapWithDetail", "startProfileCustomerFragment", "startDetailFragment", "startSameStyleFragment", "startMapListFragment", "startBrandListFragment", "startCommonCardFeedsFragment", "uin", "tabType", "startFriendListFragment", "localUgcPaths", "startAigcPreviewActivity", "startAvatarOutfitFragment", "startSuitCustomColorFragment", "startUEWithHippyFragment", "startFriendsDressUpFragment", "startUserCenterFragment", "startTaskSystemFragment", "startDressDetailFragment", "from", "startCreateRoleFragment", "startThirdPage", "startAIGCCreationPage", "startCloudModFragment", "startDownloadManagerFragment", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class EntryApiImpl implements IEntryApi {
    public static final String TAG = "EntryApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/entry/impl/EntryApiImpl$b", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", "result", "", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements a<CheckResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ qh3.b f328303a;

        b(qh3.b bVar) {
            this.f328303a = bVar;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(CheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.isPassed()) {
                this.f328303a.c();
            }
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(CheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    private final void handleEntry(Context context, ZootopiaSource source, qh3.b entry) {
        if (entry.d()) {
            ((c) vb3.a.f441346a.a(c.class)).S(entry.getSceneId(), entry.a(), source, new b(entry));
        } else {
            entry.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryOpenDetailPageWhenMapNotReady(Context context, EnterModCheckResult result, int mapId, ZootopiaSource source, Bundle bundle) {
        boolean isBlank;
        if (result.isPassed()) {
            QLog.d(TAG, 4, "tryOpenDetailPageWhenMapNotReady success");
            return;
        }
        if (!bundle.getBoolean("openDetailNotReady", false)) {
            QLog.d(TAG, 4, "tryOpenDetailPageWhenMapNotReady not set");
            return;
        }
        if (result.getProcessInner()) {
            QLog.d(TAG, 4, "tryOpenDetailPageWhenMapNotReady inner has processed");
            return;
        }
        if (bundle.getInt("openDetailType", 0) == 1) {
            String string = bundle.getString("openDetailScheme");
            if (string == null) {
                string = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (isBlank) {
                string = "mqqapi://hippy/open?bundleName=QQSmallHouseCenter&domain=vip.qq.com&isAnimated=true&pathPluginType=3&url=https%3A%2F%2Ftq-act.vip.qq.com%2Findex.bundle%2Fhippyurl%3D%252F%253Fparams%253DZnJvbT1lbV96cGxhbl9lbnRyYW5jZV9jcmVhdGVfYXZhdGFyJmZyb21DcmVhdGVSb2xlPXRydWU%3D";
            }
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, string);
            return;
        }
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startDetailActivity(context, mapId, source, bundle.getBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, false), bundle);
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startAIGCCreationPage(Context context, ZootopiaSource from, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        handleEntry(context, from, new com.tencent.mobileqq.zplan.entry.impl.entry.a(context, from, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startAigcPreviewActivity(Context context, ZootopiaSource source, Bundle bundle, String localUgcPaths) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        AigcPreviewParams aigcPreviewParams = localUgcPaths != null ? (AigcPreviewParams) new Gson().fromJson(localUgcPaths, AigcPreviewParams.class) : null;
        if (aigcPreviewParams == null) {
            aigcPreviewParams = new AigcPreviewParams(null, new ExtraReportParams("", "", null, 0L, 12, null), 1, null);
        }
        handleEntry(context, source, new com.tencent.mobileqq.zplan.entry.impl.entry.c(context, source, bundle, aigcPreviewParams));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startAvatarOutfitFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new d(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startAvatarSubSceneFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new SubSceneAvatarEntry(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startBrandListFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new e(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startCloudModFragment(Context context, ZootopiaSource source, int mapId, Bundle pageBundle, Bundle ueBundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pageBundle, "pageBundle");
        Intrinsics.checkNotNullParameter(ueBundle, "ueBundle");
        new f(context, mapId, source, pageBundle, ueBundle).c();
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startCommonCardFeedsFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new g(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startCreateRoleFragment(Context context, ZootopiaSource from, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        handleEntry(context, from, new i(context, from, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startDetailFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new o(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startDownloadManagerFragment(Context context, ZootopiaSource from, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        handleEntry(context, from, new j(context, from, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startDressDetailFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new k(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startFriendListFragment(Context context, ZootopiaSource source, String uin, int tabType, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(uin, "uin");
        handleEntry(context, source, new l(context, source, uin, tabType, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startFriendsDressUpFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new m(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startMap(Context context, int mapId, ZootopiaSource source, Map<String, ? extends Object> ueParams, final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        ((si3.c) vb3.a.f441346a.a(si3.c.class)).u(mapId, source, ueParams, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.entry.impl.EntryApiImpl$startMap$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                invoke2(enterModCheckResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterModCheckResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function1<Integer, Unit> function1 = callback;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(it.getResultCode()));
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startMapListFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new n(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startPortalActivity(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new p(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startProfileCustomerFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new q(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startSameStyleFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        handleEntry(context, source, new SameStyleEntry(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startSeparateSceneFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new r(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startSimpleAvatarFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new s(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startSuitCustomColorFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new t(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startTaskSystemFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new u(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startThirdPage(Context context, ZootopiaSource from, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QLog.i(TAG, 1, "startThirdPage from:" + from);
        handleEntry(context, from, new h(context, from, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startUEWithHippyFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        handleEntry(context, source, new v(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startUserCenterFragment(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        handleEntry(context, source, new w(context, source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.entry.IEntryApi
    public void startMapWithDetail(final Context context, final int mapId, final ZootopiaSource source, final Bundle pageBundle, Bundle ueBundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(pageBundle, "pageBundle");
        pageBundle.get("serverExtraInfo");
        si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
        DataConvertUtil dataConvertUtil = DataConvertUtil.f329546a;
        cVar.l0(mapId, source, dataConvertUtil.c(ueBundle), dataConvertUtil.c(pageBundle), new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.entry.impl.EntryApiImpl$startMapWithDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                invoke2(enterModCheckResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterModCheckResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                EntryApiImpl.this.tryOpenDetailPageWhenMapNotReady(context, it, mapId, source, pageBundle);
            }
        });
        com.tencent.sqshow.dresskey.b.f369818a.t(ZPlanPublishSource.FROM_SCHEME, true);
    }
}
