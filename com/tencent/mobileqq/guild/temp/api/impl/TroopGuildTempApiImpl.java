package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildAIOApi;
import com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J2\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J8\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J0\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J \u0010\"\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0012H\u0016J\u001c\u0010*\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010)2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016J'\u0010/\u001a\u00020\n2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030+2\u0006\u0010.\u001a\u00020-H\u0016\u00a2\u0006\u0004\b/\u00100J8\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J.\u00103\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016J8\u00103\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0016\u00104\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/TroopGuildTempApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/ITroopGuildTempApi;", "Lcom/tencent/libra/request/Option;", "", "imageUrl", "Landroid/widget/ImageView;", "imageView", "Lkotlin/Pair;", "", "referSize", "", "setUpBy", "logTag", "Lcom/tencent/common/app/AppInterface;", "app", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "troopUin", "", "chatPie", "", "examineWhetherShouldRestart", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lcom/tencent/mobileqq/app/BaseActivity;", "Lcom/tencent/mobileqq/guild/temp/api/ITroopGuildAIOApi;", "troopGuildAIOApi", "restartAIOProcedure", "isTroopAssistantInitData", "isInTroopAssistantList", "Lmqq/app/AppRuntime;", "appRuntime", "addTroopToTroopAssistantList", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadCntInfo", "updateTroopAssistantNewMsgSet", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "shouldShowInRecentList", "tryToShowTroopAssistantForTroopGuild", "aioContext", "createTroopGuildUpgradeHelper", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "createTroopSettingUpgradeRedDotProcessor", "", CoverDBCacheData.URLS, "Ljava/lang/Runnable;", "onFinish", "preDownloadImage", "([Ljava/lang/String;Ljava/lang/Runnable;)V", "url", "loadImageByGuildPicLoader", "restartAIOToTroopGuildIfNeeded", "isInRestartStack", "Z", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TroopGuildTempApiImpl implements ITroopGuildTempApi {
    private static final String TAG = "TroopGuildTempApiImpl";
    private boolean isInRestartStack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/temp/api/impl/TroopGuildTempApiImpl$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f235266e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(true);
            this.f235266e = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState state, Option option) {
            QLog.d(TroopGuildTempApiImpl.TAG, 4, this.f235266e + " | state code = " + (state != null ? Integer.valueOf(state.ordinal()) : null));
        }
    }

    private final boolean examineWhetherShouldRestart(String logTag, AppInterface app, Activity activity, String troopUin, Object chatPie) {
        os2.d dVar;
        if (this.isInRestartStack) {
            QLog.e(logTag, 1, "restartAIOToTroopGuild | " + troopUin + " shouldn't be called twice");
            return false;
        }
        if ((app instanceof QQAppInterface) && (activity instanceof BaseActivity) && troopUin != null && chatPie != null) {
            a61.e eVar = chatPie instanceof a61.e ? (a61.e) chatPie : null;
            if (!((eVar == null || (dVar = (os2.d) eVar.k(203)) == null || !dVar.getHasReceivedTroopUpgradeNotification()) ? false : true)) {
                QLog.d(logTag, 1, "no guildId change push");
                return false;
            }
            if (!((ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class)).didUserConfirmUpgrade(troopUin)) {
                QLog.d(logTag, 1, "restartAIOToTroopGuild | " + troopUin + " user did not confirm");
                return false;
            }
            if (((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).isTroopGuild(troopUin)) {
                return true;
            }
            QLog.i(logTag, 1, "restartAIOToTroopGuild | " + troopUin + " isn't troop guild now");
            return false;
        }
        QLog.e(logTag, 1, "restartAIOToTroopGuild | " + troopUin + " args is null");
        return false;
    }

    private final void setUpBy(Option option, String str, ImageView imageView, Pair<Integer, Integer> pair) {
        option.setUrl(str);
        option.setTargetView(imageView);
        if (pair != null) {
            option.setRequestWidth(pair.getFirst().intValue());
            option.setRequestHeight(pair.getSecond().intValue());
        }
        option.setLoadingDrawableColor(0);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public void addTroopToTroopAssistantList(AppRuntime appRuntime, String troopUin) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (appRuntime instanceof QQAppInterface) {
            EntityManager createEntityManager = ((QQAppInterface) appRuntime).getEntityManagerFactory().createEntityManager();
            Intrinsics.checkNotNullExpressionValue(createEntityManager, "appRuntime.entityManager\u2026ory.createEntityManager()");
            createEntityManager.close();
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public Object createTroopGuildUpgradeHelper(Object aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        a61.a aVar = aioContext instanceof a61.a ? (a61.a) aioContext : null;
        if (aVar != null) {
            return new os2.d(aVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public Object createTroopSettingUpgradeRedDotProcessor(BaseQQAppInterface app, String troopUin) {
        return new gs2.a(app instanceof QQAppInterface ? (QQAppInterface) app : null, troopUin);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public boolean isInTroopAssistantList(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        troopUin.length();
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public boolean isTroopAssistantInitData() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public void loadImageByGuildPicLoader(String url, ImageView imageView, Pair<Integer, Integer> referSize, String logTag) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
        Option loadImageByGuildPicLoader$lambda$3 = Option.obtain();
        Intrinsics.checkNotNullExpressionValue(loadImageByGuildPicLoader$lambda$3, "loadImageByGuildPicLoader$lambda$3");
        setUpBy(loadImageByGuildPicLoader$lambda$3, url, imageView, referSize);
        a16.f(loadImageByGuildPicLoader$lambda$3, new b(logTag));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public void preDownloadImage(String[] urls, Runnable onFinish) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        Ref.IntRef intRef = new Ref.IntRef();
        WeakReference weakReference = new WeakReference(onFinish);
        for (String str : urls) {
            com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
            Option obtain = Option.obtain();
            obtain.setUrl(str);
            a16.f(obtain, new c(intRef, urls, weakReference));
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public void restartAIOToTroopGuildIfNeeded(AppInterface app, Activity activity, String troopUin, String logTag) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        a61.c cVar = null;
        SplashActivity splashActivity = activity instanceof SplashActivity ? (SplashActivity) activity : null;
        if (splashActivity != null) {
            Fragment findFragmentByTag = splashActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            ChatFragment chatFragment = findFragmentByTag instanceof ChatFragment ? (ChatFragment) findFragmentByTag : null;
            if (chatFragment != null) {
                cVar = chatFragment.C;
            }
        }
        restartAIOToTroopGuildIfNeeded(app, activity, cVar, troopUin, logTag);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public boolean shouldShowInRecentList(AppRuntime appRuntime, RecentUser recentUser) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(recentUser, "recentUser");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public boolean tryToShowTroopAssistantForTroopGuild(AppRuntime appRuntime, String troopUin) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public boolean updateTroopAssistantNewMsgSet(AppRuntime appRuntime, UnreadCntInfo unreadCntInfo, String troopUin) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(unreadCntInfo, "unreadCntInfo");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }

    private final void restartAIOProcedure(QQAppInterface app, BaseActivity activity, ITroopGuildAIOApi troopGuildAIOApi, String troopUin, String logTag) {
        this.isInRestartStack = true;
        QLog.d(logTag, 4, "openAioToAIOByMT retCode = " + l.Q(app, activity, troopGuildAIOApi.getJumpToTroopGuildIntent(activity, troopUin, new Bundle())));
        this.isInRestartStack = false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/temp/api/impl/TroopGuildTempApiImpl$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f235267e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String[] f235268f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WeakReference<Runnable> f235269h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Ref.IntRef intRef, String[] strArr, WeakReference<Runnable> weakReference) {
            super(true);
            this.f235267e = intRef;
            this.f235268f = strArr;
            this.f235269h = weakReference;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState state, Option option) {
            Runnable runnable;
            boolean z16 = false;
            if (state != null && state.isFinishSuccess()) {
                z16 = true;
            }
            if (z16) {
                Ref.IntRef intRef = this.f235267e;
                int i3 = intRef.element + 1;
                intRef.element = i3;
                if (i3 != this.f235268f.length || (runnable = this.f235269h.get()) == null) {
                    return;
                }
                runnable.run();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ITroopGuildTempApi
    public void restartAIOToTroopGuildIfNeeded(AppInterface app, Activity activity, Object chatPie, String troopUin, String logTag) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        QRouteApi api = QRoute.api(ITroopGuildAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopGuildAIOApi::class.java)");
        ITroopGuildAIOApi iTroopGuildAIOApi = (ITroopGuildAIOApi) api;
        if (examineWhetherShouldRestart(logTag, app, activity, troopUin, chatPie)) {
            Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.BaseActivity");
            Intrinsics.checkNotNull(troopUin);
            restartAIOProcedure((QQAppInterface) app, (BaseActivity) activity, iTroopGuildAIOApi, troopUin, logTag);
        }
    }
}
