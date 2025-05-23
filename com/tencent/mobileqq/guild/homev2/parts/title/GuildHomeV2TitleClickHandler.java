package com.tencent.mobileqq.guild.homev2.parts.title;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.homev2.live.GuildAVListFragment;
import com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment;
import com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.visitor.GuildVisitorUtils;
import com.tencent.mobileqq.guild.widget.banner.BannerTipOffDialog;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.bn;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.cg;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0002\u0018\u0000 \u00032\u00020\u0001:\u0002\u0006\nB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler;", "", "com/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$c", "e", "()Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$c;", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "b", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "c", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$b;", "d", "Lkotlin/Lazy;", "f", "()Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$b;", "mCallback", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2TitleClickHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFacadeType guildFacadeType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomeViewModel viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$b;", "", "", "onBackClick", "b", "a", "f", "d", "c", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void onBackClick();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$c", "Lcom/tencent/mobileqq/guild/homev2/parts/title/GuildHomeV2TitleClickHandler$b;", "", "onBackClick", "b", "a", "f", "d", "c", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(GuildHomeV2TitleClickHandler this$0, bn reqData, ArrayList arrayList) {
            IGProCategoryChannelInfoList iGProCategoryChannelInfoList;
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(reqData, "$reqData");
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((IGProCategoryChannelInfoList) obj).getCategoryType() == 3) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) obj;
            } else {
                iGProCategoryChannelInfoList = null;
            }
            if (iGProCategoryChannelInfoList == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "noLiveCategory! reqData:" + reqData + " resp:" + arrayList;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("GuildHomeV2TitleClickHandler", 1, (String) it5.next(), null);
                }
                return;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "findLiveCategory! reqData:" + reqData + " liveCategory:" + iGProCategoryChannelInfoList;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it6 = bVar2.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("GuildHomeV2TitleClickHandler", 1, (String) it6.next(), null);
            }
            GuildAVListFragment.INSTANCE.a(this$0.activity, this$0.viewModel.getJumpGuildParam(), String.valueOf(iGProCategoryChannelInfoList.getCategoryId()), iGProCategoryChannelInfoList.getCategoryType(), 1);
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void a() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onTipOffClick");
            }
            if (!(GuildHomeV2TitleClickHandler.this.activity instanceof FragmentActivity)) {
                GuildHomeV2TitleClickHandler guildHomeV2TitleClickHandler = GuildHomeV2TitleClickHandler.this;
                Logger.b bVar = new Logger.b();
                String str = "onTipOffClick invalidActivity:" + guildHomeV2TitleClickHandler.activity;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildHomeV2TitleClickHandler", 1, (String) it.next(), null);
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("guildId", GuildHomeV2TitleClickHandler.this.viewModel.getGuildId());
            bundle.putSerializable("facadeType", GuildHomeV2TitleClickHandler.this.guildFacadeType);
            BannerTipOffDialog bannerTipOffDialog = new BannerTipOffDialog();
            bannerTipOffDialog.setArguments(bundle);
            FragmentManager supportFragmentManager = ((FragmentActivity) GuildHomeV2TitleClickHandler.this.activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            supportFragmentManager.beginTransaction().add(bannerTipOffDialog, "BannerTipOff").commitAllowingStateLoss();
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void b() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onShareClick");
            }
            IGProGuildInfo guildInfo = GuildHomeV2TitleClickHandler.this.viewModel.getGuildInfoViewModel().getGuildInfo();
            if (guildInfo == null) {
                logger.d().w("GuildHomeV2TitleClickHandler", 1, "onShareClick liveGuildInfo is null");
                return;
            }
            m mVar = new m(GuildHomeV2TitleClickHandler.this.activity, guildInfo, null, GuildSharePageSource.GUILD_PROFILE);
            com.tencent.mobileqq.guild.share.util.c.c(mVar, 1);
            mVar.z();
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void c() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onProfilePanelClick");
            }
            if (GuildHomeV2TitleClickHandler.this.guildFacadeType == GuildFacadeType.GameCenter) {
                return;
            }
            IGProGuildInfo guildInfo = GuildHomeV2TitleClickHandler.this.viewModel.getGuildInfoViewModel().getGuildInfo();
            if (guildInfo == null) {
                logger.d().w("GuildHomeV2TitleClickHandler", 1, "onProfileClick liveGuildInfo is null");
            } else {
                if (!guildInfo.isMember() && !GuildVisitorUtils.f235701a.b(guildInfo)) {
                    return;
                }
                GuildInfoFragment.INSTANCE.a(GuildHomeV2TitleClickHandler.this.activity, MiscKt.j(GuildHomeV2TitleClickHandler.this.viewModel.getJumpGuildParam()));
            }
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void d() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onManageCLick");
            }
            GuildSettingFragment.INSTANCE.a(GuildHomeV2TitleClickHandler.this.activity, MiscKt.j(GuildHomeV2TitleClickHandler.this.viewModel.getJumpGuildParam()));
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void e() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onLiveClick");
            }
            final bn bnVar = new bn();
            bnVar.e(MiscKt.l(GuildHomeV2TitleClickHandler.this.viewModel.getGuildId()));
            bnVar.f(false);
            bnVar.d(false);
            r rVar = r.f214743a;
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            final GuildHomeV2TitleClickHandler guildHomeV2TitleClickHandler = GuildHomeV2TitleClickHandler.this;
            ((IGPSService) S0).getGuildHomeCategories(bnVar, new cg() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.d
                @Override // wh2.cg
                public final void onGetGuildHomeCategories(ArrayList arrayList) {
                    GuildHomeV2TitleClickHandler.c.h(GuildHomeV2TitleClickHandler.this, bnVar, arrayList);
                }
            });
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void f() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onSearchClick");
            }
            GuildQuickSearchFragment.INSTANCE.a(GuildHomeV2TitleClickHandler.this.activity, GuildHomeV2TitleClickHandler.this.viewModel.getGuildId());
        }

        @Override // com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler.b
        public void onBackClick() {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleClickHandler", 1, "onBackClick");
            }
            if (!GuildHomeV2TitleClickHandler.this.activity.isFinishing() && !GuildHomeV2TitleClickHandler.this.activity.isDestroyed()) {
                GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, GuildHomeV2TitleClickHandler.this.activity, false, 2, null);
            }
        }
    }

    public GuildHomeV2TitleClickHandler(@NotNull Activity activity, @NotNull GuildFacadeType guildFacadeType, @NotNull GuildHomeViewModel viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildFacadeType, "guildFacadeType");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.activity = activity;
        this.guildFacadeType = guildFacadeType;
        this.viewModel = viewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.GuildHomeV2TitleClickHandler$mCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeV2TitleClickHandler.c invoke() {
                GuildHomeV2TitleClickHandler.c e16;
                e16 = GuildHomeV2TitleClickHandler.this.e();
                return e16;
            }
        });
        this.mCallback = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c e() {
        return new c();
    }

    @NotNull
    public final b f() {
        return (b) this.mCallback.getValue();
    }
}
