package bw1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.event.GuildSpeakManageGuideShowEvent;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildProfileCardDismissEvent;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import vh2.cd;

/* compiled from: P */
/* loaded from: classes14.dex */
public class o extends com.tencent.mobileqq.mvvm.c<wy1.a> {
    public static ViewModelProvider.Factory F = new a();
    private final cn<Boolean> C;
    private final cn<Boolean> D;
    private GPServiceObserver E;

    /* renamed from: i, reason: collision with root package name */
    private GuildBaseProfileData f29314i;

    /* renamed from: m, reason: collision with root package name */
    private final cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> f29315m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewModelProvider.Factory {
        a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            return new o(new wy1.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends GPServiceObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f29316d;

        b(boolean z16) {
            this.f29316d = z16;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(String str, int i3) {
            super.onBeKickFromGuild(str, i3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildManageProfileViewModel", 1, String.format("guild: %s, black: %d", str, Integer.valueOf(i3)));
            }
            if (str.equals(o.this.f29314i.e())) {
                o.this.C.setValue(Boolean.TRUE);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int i3, String str, String str2, String str3, ev evVar) {
            super.onUserProfileInfoUpdate(i3, str, str2, str3, evVar);
            boolean z16 = true;
            if (TextUtils.equals(o.this.f29314i.b(), str3) && TextUtils.equals(o.this.f29314i.e(), str2)) {
                o.this.f29314i.w(evVar.n());
                if (!this.f29316d) {
                    GuildBaseProfileData guildBaseProfileData = o.this.f29314i;
                    if (evVar.getIsMember() != 2) {
                        z16 = false;
                    }
                    guildBaseProfileData.x(z16);
                    o.this.D.setValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            QLog.i("Guild.profile.GuildManageProfileViewModel", 1, "onUserProfileInfoUpdate current(guildId, tinyId)=(" + o.this.f29314i.e() + ", " + o.this.f29314i.b() + "), update((guildId, tinyId)=(" + str2 + ", " + str3 + ")");
        }
    }

    public o(wy1.a aVar) {
        super(aVar);
        this.f29315m = new cn<>();
        this.C = new cn<>();
        this.D = new cn<>();
    }

    private int S1(boolean z16) {
        if (z16 && !this.f29314i.p()) {
            return R.string.f152311_2;
        }
        if (z16) {
            return R.string.f152301_1;
        }
        return R.string.f1500413x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit W1(AppInterface appInterface, int i3, Boolean bool) {
        int i16;
        int i17;
        cn<Boolean> cnVar = this.C;
        Boolean bool2 = Boolean.TRUE;
        cnVar.postValue(bool2);
        if (bool.booleanValue()) {
            GuildBaseProfileData guildBaseProfileData = this.f29314i;
            if (guildBaseProfileData.p()) {
                i16 = R.string.f1500513y;
            } else {
                i16 = R.string.f152321_3;
            }
            IGProChannelInfo channelInfo = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(guildBaseProfileData.a());
            if (channelInfo != null && channelInfo.getType() == 6) {
                guildBaseProfileData.B(5);
            }
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String string = BaseApplication.getContext().getString(i16);
            String e16 = guildBaseProfileData.e();
            String a16 = guildBaseProfileData.a();
            Integer valueOf = Integer.valueOf(guildBaseProfileData.g());
            if (guildBaseProfileData.p()) {
                i17 = 1;
            } else {
                i17 = 2;
            }
            simpleEventBus.dispatchEvent(new GuildSpeakManageGuideShowEvent(string, new GuildSpeakParamsInfo(e16, a16, valueOf, i17)));
        } else {
            this.C.setValue(bool2);
            ch.u1(MobileQQ.sMobileQQ.getApplicationContext(), BaseApplication.getContext().getString(i3));
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildProfileCardDismissEvent());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(boolean z16, final AppInterface appInterface, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        int i16;
        com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = new com.tencent.mobileqq.guild.profile.profilecard.main.l();
        lVar.f(i3);
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            final int S1 = S1(z16);
            if (!this.f29314i.q()) {
                GuildSpeakManageGuide.f224623a.f(this.f29314i.e(), new Function1() { // from class: bw1.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit W1;
                        W1 = o.this.W1(appInterface, S1, (Boolean) obj);
                        return W1;
                    }
                });
                return;
            }
            this.C.setValue(Boolean.TRUE);
            ch.u1(MobileQQ.sMobileQQ.getApplicationContext(), BaseApplication.getContext().getString(S1));
            SimpleEventBus.getInstance().dispatchEvent(new GuildProfileCardDismissEvent());
            return;
        }
        if (z16) {
            i16 = R.string.f152291_0;
        } else {
            i16 = R.string.f1500313w;
        }
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(i16);
        }
        lVar.h(str);
        lVar.g(iGProSecurityResult);
        ch.t1(MobileQQ.sMobileQQ.getApplicationContext(), lVar.a(), lVar.c(), lVar.b());
        this.C.setValue(Boolean.TRUE);
        SimpleEventBus.getInstance().dispatchEvent(new GuildProfileCardDismissEvent());
    }

    public cn<Boolean> Q1() {
        return this.C;
    }

    public cn<Boolean> R1() {
        return this.D;
    }

    public void T1(final boolean z16, int i3) {
        final AppInterface l3 = ((wy1.a) this.mRepository).l();
        if (l3 == null) {
            QLog.e("Guild.profile.GuildManageProfileViewModel", 1, "handleGuildRemove app is null!");
            return;
        }
        String b16 = this.f29314i.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(b16);
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).P2(this.f29314i.e(), arrayList, z16, new fm.a().c(i3).b(), new cd() { // from class: bw1.m
            @Override // vh2.cd
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                o.this.X1(z16, l3, i16, str, iGProSecurityResult);
            }
        });
    }

    public void U1(AppInterface appInterface, boolean z16) {
        ((wy1.a) this.mRepository).m(appInterface);
        b bVar = new b(z16);
        this.E = bVar;
        ((wy1.a) this.mRepository).j(bVar);
    }

    public cn<com.tencent.mobileqq.guild.profile.profilecard.main.l> Z1() {
        return this.f29315m;
    }

    public GuildBaseProfileData getGuildBaseProfileData() {
        return this.f29314i;
    }

    public void onDestroy() {
        ((wy1.a) this.mRepository).k(this.E);
    }

    public void setGuildBaseProfileData(GuildBaseProfileData guildBaseProfileData) {
        this.f29314i = guildBaseProfileData;
    }
}
