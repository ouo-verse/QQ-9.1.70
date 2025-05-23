package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.GuildShareActionSheetV2;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.mobileqq.guild.share.event.GuildShareActionSheetClickEvent;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.usecases.b;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final FetchGuildArkInfo f235046a;

    /* renamed from: b, reason: collision with root package name */
    protected final WeakReference<Activity> f235047b;

    /* renamed from: c, reason: collision with root package name */
    protected final IGProGuildInfo f235048c;

    /* renamed from: d, reason: collision with root package name */
    private final f f235049d;

    /* renamed from: e, reason: collision with root package name */
    private final c f235050e;

    /* renamed from: f, reason: collision with root package name */
    private final d f235051f;

    /* renamed from: g, reason: collision with root package name */
    private final b.InterfaceC7909b f235052g;

    /* renamed from: h, reason: collision with root package name */
    protected final QQGuildUIUtil.a f235053h;

    /* renamed from: i, reason: collision with root package name */
    protected final IGProChannelInfo f235054i;

    /* renamed from: j, reason: collision with root package name */
    protected final Bundle f235055j;

    /* renamed from: k, reason: collision with root package name */
    private final List<Integer> f235056k;

    /* renamed from: l, reason: collision with root package name */
    protected final Map<Integer, e> f235057l;

    /* renamed from: m, reason: collision with root package name */
    protected ShareActionSheetBuilder.ActionSheetItem f235058m;

    /* renamed from: n, reason: collision with root package name */
    protected b.c f235059n;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f235060o;

    /* renamed from: p, reason: collision with root package name */
    protected ShareActionSheet f235061p;

    /* renamed from: q, reason: collision with root package name */
    protected w f235062q;

    /* renamed from: r, reason: collision with root package name */
    protected Bundle f235063r;

    /* renamed from: s, reason: collision with root package name */
    protected final GuildSharePageSource f235064s;

    /* renamed from: t, reason: collision with root package name */
    protected int f235065t;

    /* renamed from: u, reason: collision with root package name */
    protected String f235066u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements b.InterfaceC7909b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.usecases.b.InterfaceC7909b
        public void a(@NonNull ri1.a aVar, @Nullable b.c cVar) {
            Activity activity = m.this.f235047b.get();
            if (activity == null) {
                return;
            }
            m.this.f235053h.a();
            int i3 = aVar.f431477a;
            if (i3 == -200) {
                m.l(aVar, activity);
                return;
            }
            if (i3 == 0 && cVar != null) {
                m mVar = m.this;
                mVar.f235059n = cVar;
                mVar.f235060o = true;
                mVar.z();
                return;
            }
            ch.q1(activity, i3, aVar.f431478b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            m.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            m.this.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface e {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f implements ShareActionSheet.c {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(GuildShareActionSheetClickEvent guildShareActionSheetClickEvent) {
            SimpleEventBus.getInstance().dispatchEvent(guildShareActionSheetClickEvent);
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3 = actionSheetItem.action;
            m.this.f235058m = actionSheetItem;
            final GuildShareActionSheetClickEvent guildShareActionSheetClickEvent = new GuildShareActionSheetClickEvent();
            guildShareActionSheetClickEvent.setChannelInfo(m.this.f235054i);
            guildShareActionSheetClickEvent.setGuildInfo(m.this.f235048c);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.share.n
                @Override // java.lang.Runnable
                public final void run() {
                    m.f.b(GuildShareActionSheetClickEvent.this);
                }
            });
            m.this.y(i3);
            m.this.g();
        }
    }

    public m(@NonNull Activity activity, @NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NonNull GuildSharePageSource guildSharePageSource, @NonNull String str, @Nullable ShareServiceType shareServiceType) {
        this.f235049d = new f();
        this.f235050e = new c();
        this.f235051f = new d();
        this.f235052g = u();
        this.f235055j = new Bundle();
        this.f235056k = new ArrayList();
        this.f235057l = new LinkedHashMap();
        this.f235059n = new b.c("", "");
        this.f235060o = false;
        this.f235061p = null;
        this.f235065t = 0;
        if (!(activity instanceof GuildActivityWrapper) && (activity instanceof FragmentActivity)) {
            activity = new GuildActivityWrapper((FragmentActivity) activity);
        }
        this.f235047b = new WeakReference<>(activity);
        this.f235053h = QQGuildUIUtil.D(activity);
        this.f235048c = iGProGuildInfo;
        this.f235054i = iGProChannelInfo;
        this.f235064s = guildSharePageSource;
        this.f235066u = str;
        this.f235046a = new FetchGuildArkInfo(iGProGuildInfo, iGProChannelInfo, shareServiceType == null ? com.tencent.mobileqq.guild.share.shorturl.b.a(guildSharePageSource) : shareServiceType);
        B();
        if (ch.C0(iGProGuildInfo.getCreatorId()) || !AppSetting.isDebugVersion()) {
            return;
        }
        throw new IllegalArgumentException("CreateId \u4e0d\u5408\u6cd5 gId:" + iGProGuildInfo.getGuildID() + " tId:" + iGProGuildInfo.getCreatorId());
    }

    private void B() {
        IGProChannelInfo iGProChannelInfo = this.f235054i;
        if (iGProChannelInfo == null) {
            this.f235065t = 9;
            return;
        }
        int type = iGProChannelInfo.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 5) {
                    if (type != 6) {
                        if (type != 7) {
                            if (type == 8) {
                                this.f235065t = 12;
                                return;
                            }
                            return;
                        }
                        this.f235065t = 10;
                        return;
                    }
                    if (this.f235054i.getApplicationId() == 1000050) {
                        this.f235065t = 8;
                        return;
                    } else if (TextUtils.isEmpty(this.f235054i.getAppChannelJumpUrl()) && this.f235054i.getAppChannelJumpUrl().startsWith("mqqapi://miniapp/")) {
                        this.f235065t = 11;
                        return;
                    } else {
                        this.f235065t = 6;
                        return;
                    }
                }
                this.f235065t = 3;
                return;
            }
            this.f235065t = 4;
            return;
        }
        this.f235065t = 7;
    }

    private ShareActionSheet f(Activity activity) {
        String str;
        GuildSharePageSource guildSharePageSource = this.f235064s;
        IGProGuildInfo iGProGuildInfo = this.f235048c;
        String str2 = null;
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildID();
        } else {
            str = null;
        }
        IGProChannelInfo iGProChannelInfo = this.f235054i;
        if (iGProChannelInfo != null) {
            str2 = iGProChannelInfo.getChannelUin();
        }
        return new x(activity, guildSharePageSource, str, str2).g(this.f235057l.keySet()).i(this.f235055j).h(this.f235056k).b();
    }

    private void h() {
        com.tencent.mobileqq.guild.safety.j.c(this.f235061p);
    }

    public static void l(@NonNull ri1.a aVar, Context context) {
        IGProSecurityResult iGProSecurityResult = (IGProSecurityResult) aVar.f431479c;
        if (iGProSecurityResult.get$actionCode() == 102) {
            try {
                cx.a(context, new JSONObject(iGProSecurityResult.getStrDetail()).optString("verify_url"));
                return;
            } catch (Exception e16) {
                QLog.e("Guild.share.GuildShareAction", 1, e16, new Object[0]);
                return;
            }
        }
        QQToast.makeText(context, 1, iGProSecurityResult.getStrPrompt(), 1).show();
    }

    private void n(Activity activity) {
        this.f235061p = f(activity);
        if (this.f235064s != GuildSharePageSource.UNKNOWN) {
            if (this.f235063r == null) {
                this.f235063r = new Bundle();
            }
            this.f235063r.putBoolean("no_need_report", true);
        }
        this.f235061p.setExtras(this.f235063r);
        this.f235061p.setItemClickListenerV3(this.f235049d);
        this.f235061p.setOnDismissListener(this.f235051f);
        this.f235061p.setCancelListener(this.f235050e);
        this.f235061p.show();
    }

    private void o() {
        if (this.f235062q != null) {
            return;
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit q(com.tencent.mobileqq.guild.share.b bVar) {
        QLog.d("Guild.share.GuildShareAction", 1, "receive ark data:" + bVar);
        if (bVar != null) {
            this.f235062q.y(bVar);
            this.f235062q.q();
            return null;
        }
        QQToastUtil.showQQToast(1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit r(String str, int i3, com.tencent.mobileqq.guild.share.b bVar) {
        QLog.d("Guild.share.GuildShareAction", 1, "receive ark data:" + bVar);
        if (bVar != null) {
            this.f235062q.y(bVar);
            this.f235062q.s(str, i3);
            return null;
        }
        QQToastUtil.showQQToast(1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit s(com.tencent.mobileqq.guild.share.b bVar) {
        QLog.d("Guild.share.GuildShareAction", 1, "receive ark data:" + bVar);
        if (bVar != null) {
            this.f235062q.y(bVar);
            return null;
        }
        return null;
    }

    private static void t(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        }
    }

    private b.InterfaceC7909b u() {
        return new a();
    }

    public void A(boolean z16) {
        String str;
        String str2;
        Activity activity = this.f235047b.get();
        if (activity == null) {
            QLog.e("Guild.share.GuildShareAction", 1, "showActionSheet(), context null");
            return;
        }
        boolean z17 = false;
        if (!ch.C0(this.f235048c.getCreatorId())) {
            QLog.e("Guild.share.GuildShareAction", 1, "CreateId \u4e0d\u5408\u6cd5 gId:" + this.f235048c.getGuildID() + " tId:" + this.f235048c.getCreatorId());
            QQToast.makeText(activity, "\u6682\u4e0d\u652f\u6301\u5206\u4eab", 0).show();
            return;
        }
        if (TextUtils.isEmpty(this.f235059n.f235319a) && !this.f235060o) {
            this.f235053h.b();
            com.tencent.mobileqq.guild.usecases.b.g(this.f235048c, this.f235054i, this.f235065t, this.f235052g);
            return;
        }
        this.f235046a.h(this.f235064s, this.f235059n);
        boolean useNewSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel(this.f235066u);
        if (z16 || !useNewSharePanel) {
            z17 = true;
        }
        QLog.i("Guild.share.GuildShareAction", 1, "show share panel isOpenOldSharePanel=" + z17 + ", mShareSceneId: " + this.f235066u + ", useNewSharePanel: " + useNewSharePanel);
        o();
        t(activity);
        if (z17) {
            this.f235062q.n();
            n(activity);
            this.f235046a.g(new Function1() { // from class: com.tencent.mobileqq.guild.share.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s16;
                    s16 = m.this.s((b) obj);
                    return s16;
                }
            });
            h();
            return;
        }
        if (!(activity instanceof FragmentActivity)) {
            QLog.e("Guild.share.GuildShareAction", 1, "initShareActionSheetInNewPanel activity not FragmentActivity");
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        FetchGuildArkInfo fetchGuildArkInfo = this.f235046a;
        w wVar = this.f235062q;
        GuildSharePageSource guildSharePageSource = this.f235064s;
        IGProGuildInfo iGProGuildInfo = this.f235048c;
        if (iGProGuildInfo != null) {
            str = iGProGuildInfo.getGuildID();
        } else {
            str = null;
        }
        IGProChannelInfo iGProChannelInfo = this.f235054i;
        if (iGProChannelInfo != null) {
            str2 = iGProChannelInfo.getChannelUin();
        } else {
            str2 = null;
        }
        new GuildShareActionSheetV2(fragmentActivity, this, null, fetchGuildArkInfo, wVar, guildSharePageSource, str, str2, this.f235066u).o();
    }

    protected void C() {
        y yVar = new y(this.f235048c, this.f235054i, this.f235059n);
        int i3 = this.f235065t;
        if (i3 != 0) {
            yVar.E(i3);
        }
        w wVar = new w(this.f235047b.get(), yVar, this.f235064s);
        this.f235062q = wVar;
        this.f235063r = wVar.g().getExtras();
    }

    public void d(int i3, @Nullable e eVar) {
        this.f235057l.put(Integer.valueOf(i3), eVar);
    }

    protected void e() {
        ShareActionSheet shareActionSheet = this.f235061p;
        if (shareActionSheet == null) {
            return;
        }
        shareActionSheet.dismiss();
    }

    public IGProChannelInfo i() {
        return this.f235054i;
    }

    public IGProGuildInfo j() {
        return this.f235048c;
    }

    public Set<Integer> k() {
        return this.f235057l.keySet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i3) {
        Activity activity = this.f235047b.get();
        if (activity != null && this.f235048c != null) {
            e();
            o();
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 72) {
                                    if (i3 != 73) {
                                        if (i3 != 123) {
                                            if (i3 != 171) {
                                                if (i3 != 213) {
                                                    if (i3 != 196) {
                                                        if (i3 != 197) {
                                                            e eVar = this.f235057l.get(Integer.valueOf(i3));
                                                            if (eVar != null) {
                                                                eVar.a(i3);
                                                                return;
                                                            } else {
                                                                QLog.e("Guild.share.GuildShareAction", 1, "handleShare activity null");
                                                                QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                                                                return;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    this.f235062q.c();
                                                    return;
                                                }
                                            } else {
                                                this.f235062q.t();
                                                return;
                                            }
                                        }
                                        this.f235062q.k();
                                        return;
                                    }
                                } else {
                                    ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.f235058m;
                                    final String str = actionSheetItem.uin;
                                    final int i16 = actionSheetItem.uinType;
                                    this.f235046a.g(new Function1() { // from class: com.tencent.mobileqq.guild.share.l
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            Unit r16;
                                            r16 = m.this.r(str, i16, (b) obj);
                                            return r16;
                                        }
                                    });
                                    return;
                                }
                            } else {
                                this.f235062q.w();
                                return;
                            }
                        } else {
                            this.f235062q.x();
                            return;
                        }
                    } else {
                        this.f235062q.u();
                        return;
                    }
                }
                this.f235046a.g(new Function1() { // from class: com.tencent.mobileqq.guild.share.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit q16;
                        q16 = m.this.q((b) obj);
                        return q16;
                    }
                });
                return;
            }
            this.f235062q.p();
            return;
        }
        QLog.e("Guild.share.GuildShareAction", 1, "handleShare activity null");
        QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
    }

    public boolean p() {
        ShareActionSheet shareActionSheet = this.f235061p;
        if (shareActionSheet != null && shareActionSheet.isShowing()) {
            return true;
        }
        return false;
    }

    public void v(int i3) {
        this.f235065t = i3;
    }

    public void w(b.c cVar) {
        this.f235059n = cVar;
    }

    public void x(@NonNull Bundle bundle) {
        this.f235055j.putAll(bundle);
    }

    public void y(int i3) {
        if (this.f235047b.get() == null) {
            QLog.e("Guild.share.GuildShareAction", 1, "share(), activity is null");
            QQToast.makeText(ch.i(), "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
        } else {
            m(i3);
        }
    }

    public void z() {
        A(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
    }

    public m(@NonNull Activity activity, @NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NonNull GuildSharePageSource guildSharePageSource) {
        this(activity, iGProGuildInfo, iGProChannelInfo, guildSharePageSource, com.tencent.mobileqq.guild.share.util.e.f235124a.a(guildSharePageSource), null);
    }
}
