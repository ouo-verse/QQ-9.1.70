package aq1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import aq1.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.api.IGuildNewUserMsgNoticeApi;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.GuildBlankActivity;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.event.GuildHashtagDialogEmptyEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartCheckResultEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartEmptyEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.feed.api.IGuildInfoManagerApi;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.ipc.methods.GuildDeleteFeedIPCMethod;
import com.tencent.mobileqq.guild.ipc.methods.GuildFeedChannelTopIPCMethod;
import com.tencent.mobileqq.guild.ipc.methods.GuildGetEnablePicShareIpcMethod;
import com.tencent.mobileqq.guild.ipc.methods.GuildSetSpeakRuleBlockWordRealMethod;
import com.tencent.mobileqq.guild.ipc.methods.ab;
import com.tencent.mobileqq.guild.ipc.methods.ac;
import com.tencent.mobileqq.guild.ipc.methods.ad;
import com.tencent.mobileqq.guild.ipc.methods.ae;
import com.tencent.mobileqq.guild.ipc.methods.af;
import com.tencent.mobileqq.guild.ipc.methods.ag;
import com.tencent.mobileqq.guild.ipc.methods.ah;
import com.tencent.mobileqq.guild.ipc.methods.aj;
import com.tencent.mobileqq.guild.ipc.methods.ak;
import com.tencent.mobileqq.guild.ipc.methods.am;
import com.tencent.mobileqq.guild.ipc.methods.an;
import com.tencent.mobileqq.guild.ipc.methods.ao;
import com.tencent.mobileqq.guild.ipc.methods.ap;
import com.tencent.mobileqq.guild.ipc.methods.aq;
import com.tencent.mobileqq.guild.ipc.methods.as;
import com.tencent.mobileqq.guild.ipc.methods.at;
import com.tencent.mobileqq.guild.ipc.methods.au;
import com.tencent.mobileqq.guild.ipc.methods.aw;
import com.tencent.mobileqq.guild.ipc.methods.i;
import com.tencent.mobileqq.guild.ipc.methods.k;
import com.tencent.mobileqq.guild.ipc.methods.l;
import com.tencent.mobileqq.guild.ipc.methods.m;
import com.tencent.mobileqq.guild.ipc.methods.n;
import com.tencent.mobileqq.guild.ipc.methods.o;
import com.tencent.mobileqq.guild.ipc.methods.p;
import com.tencent.mobileqq.guild.ipc.methods.q;
import com.tencent.mobileqq.guild.ipc.methods.r;
import com.tencent.mobileqq.guild.ipc.methods.u;
import com.tencent.mobileqq.guild.ipc.methods.v;
import com.tencent.mobileqq.guild.ipc.methods.w;
import com.tencent.mobileqq.guild.ipc.methods.x;
import com.tencent.mobileqq.guild.ipc.methods.y;
import com.tencent.mobileqq.guild.ipc.methods.z;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.GuildShareInviteCodeParam;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.ez;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.bd;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import vh2.aa;
import vh2.bn;
import vh2.bv;
import wh2.br;

/* compiled from: P */
/* loaded from: classes13.dex */
public class h extends QIPCModule {

    /* renamed from: e, reason: collision with root package name */
    private static volatile h f26738e;

    /* renamed from: d, reason: collision with root package name */
    private final aq1.a f26739d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements bn {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f26740a;

        a(int i3) {
            this.f26740a = i3;
        }

        @Override // vh2.bn
        public void a(int i3, String str, String str2, String str3, int i16, boolean z16, String str4) {
            if (i3 != 0) {
                QLog.i("QQGuildSvrIPCModule", 1, "OnGetMemberInfoByOpenId result:" + i3 + " errMsg:" + str);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("result", i3);
            bundle.putString("errMsg", str);
            bundle.putString("nick", str2);
            bundle.putString("avatar", str3);
            bundle.putInt("identity", i16);
            bundle.putBoolean("isBind", z16);
            bundle.putString("accountSecret", str4);
            h.this.callbackResult(this.f26740a, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f26742a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f26743b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f26744c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f26745d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f26746e;

        b(int i3, String str, String str2, String str3, int i16) {
            this.f26742a = i3;
            this.f26743b = str;
            this.f26744c = str2;
            this.f26745d = str3;
            this.f26746e = i16;
        }

        @Override // vh2.aa
        public void a(int i3, String str, ez ezVar, IGProSecurityResult iGProSecurityResult, long j3) {
            QLog.d("QQGuildSvrIPCModule", 1, "fetchGuildInfoByInviteCode, errCode = ", Integer.valueOf(i3), ", errMsg = ", str);
            if (i3 != 0 || !ch.p(iGProSecurityResult) || ezVar == null) {
                h.this.G(this.f26742a, -1, str, iGProSecurityResult);
            } else {
                h.this.D(this.f26742a, ezVar.getGuildID(), ezVar.E(), ezVar.getJoinSig(), this.f26743b, this.f26744c, this.f26745d, this.f26746e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface c {
        void a(ArrayList<IGProChannel> arrayList);
    }

    public h(String str) {
        super(str);
        this.f26739d = new aq1.a((Class<? extends AbsIpcMethod>[]) new Class[]{com.tencent.mobileqq.guild.ipc.methods.b.class, com.tencent.mobileqq.guild.ipc.methods.e.class, com.tencent.mobileqq.guild.ipc.methods.g.class, v.class, ah.class, aj.class, ab.class, x.class, ak.class, ae.class, ad.class, ac.class, q.class, z.class, p.class, GuildSetSpeakRuleBlockWordRealMethod.class, ao.class, af.class, ap.class, com.tencent.mobileqq.guild.ipc.methods.aa.class, as.class, aw.class, y.class, k.class, o.class, l.class, m.class, r.class, w.class, at.class, i.class, GuildDeleteFeedIPCMethod.class, com.tencent.mobileqq.guild.ipc.methods.c.class, am.class, com.tencent.mobileqq.guild.ipc.methods.h.class, an.class, n.class, GuildGetEnablePicShareIpcMethod.class, u.class, au.class, com.tencent.mobileqq.guild.ipc.methods.f.class, aq.class, ag.class, com.tencent.mobileqq.guild.ipc.methods.d.class, GuildFeedChannelTopIPCMethod.class});
    }

    private void A(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).exposeRecommend(bundle.getString("info"), bundle.getString("stage"));
    }

    private void B(String str, String str2, String str3, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            F(i16, -1, "empty inviteCode");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildSvrIPCModule", 1, "addGuild inviteCode:", str, ", mainSourceId:", str2, "subSourceId:", str3);
        }
        E(str, str2, str3, i3, "", i16);
    }

    private void C(String str, final String str2, String str3, String str4, String str5, String str6, final int i3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            QLog.d("QQGuildSvrIPCModule", 1, "addGuildByJoinSig guildId:", str2, ", joinSig:", str, ", mainSource:", str4, ", subSource:", str5);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str2, str3, str, str4, str5);
            if (!TextUtils.isEmpty(str6)) {
                jumpGuildParam.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(Uri.parse(str6).getQueryParameter("feedId")));
                jumpGuildParam.businessType = 2;
            }
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(ch.i(), jumpGuildParam, new JoinGuildLogic.JumpParam(), "QQGuildSvrIPCModule", new bv() { // from class: aq1.f
                @Override // vh2.bv
                public final void a(int i16, String str7, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    h.this.S(i3, str2, i16, str7, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
            return;
        }
        QLog.e("QQGuildSvrIPCModule", 1, "[addGuildByJoinSig] empty params key/joinSig");
        F(i3, -1, BaseApplication.getContext().getString(R.string.f138610_1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final int i3, final String str, String str2, String str3, String str4, String str5, String str6, int i16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            QLog.d("QQGuildSvrIPCModule", 1, "addGuildInternal guildId:", str, ", joinSig:", str3);
            JumpGuildParam jumpGuildParam = new JumpGuildParam(str, str2, str3, str4, str5);
            jumpGuildParam.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(Uri.parse(str6).getQueryParameter("feedId")));
            jumpGuildParam.businessType = 2;
            jumpGuildParam.getJoinInfoParam().setPageEntranceId(i16);
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(ch.i(), jumpGuildParam, new JoinGuildLogic.JumpParam(), "QQGuildSvrIPCModule", new bv() { // from class: aq1.g
                @Override // vh2.bv
                public final void a(int i17, String str7, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    h.this.T(i3, str, i17, str7, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
            return;
        }
        QLog.d("QQGuildSvrIPCModule", 1, "[addGuildInternal] empty params key/joinSig");
        F(i3, -1, BaseApplication.getContext().getString(R.string.f138610_1));
    }

    private void E(String str, String str2, String str3, int i3, String str4, int i16) {
        if (TextUtils.isEmpty(str)) {
            F(i16, -1, "empty inviteCode");
        } else {
            QLog.d("QQGuildSvrIPCModule", 1, "addGuildPro inviteCode:", str, ", mainSource:", str2, ", subSource:", str3);
            ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoByInviteCode(str, new b(i16, str2, str3, str4, i3));
        }
    }

    private void F(int i3, int i16, String str) {
        callbackResult(i3, EIPCResult.createSuccessResult(K(i16, str, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i3, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        H(i3, i16, str, "", iGProSecurityResult);
    }

    private void H(int i3, int i16, String str, String str2, IGProSecurityResult iGProSecurityResult) {
        try {
            Bundle K = K(i16, str, iGProSecurityResult);
            K.putString("key", str2);
            callbackResult(i3, EIPCResult.createSuccessResult(K));
        } catch (Exception e16) {
            QLog.e("QQGuildSvrIPCModule", 1, e16.getMessage());
            F(i3, -1, e16.getMessage());
        }
    }

    private boolean I(String str, Bundle bundle) {
        boolean z16;
        List<IGProChannelInfo> channelList;
        List<cy> channelCategoryList = ((IGPSService) ch.S0(IGPSService.class, "")).getChannelCategoryList(str);
        boolean z17 = true;
        if (channelCategoryList != null && !channelCategoryList.isEmpty()) {
            int i3 = bundle.getInt("key_channel_type", 0);
            int i16 = bundle.getInt("KEY_NEED_CHECK_PERMISSION_TYPE", 0);
            if (i16 != 0 && !((IGPSService) ch.R0(IGPSService.class)).getGuildPermission(str).a(i16)) {
                z16 = false;
            } else {
                z16 = true;
            }
            String string = bundle.getString("key_channel_id", "");
            for (int i17 = 0; i17 < channelCategoryList.size(); i17++) {
                cy cyVar = channelCategoryList.get(i17);
                if (cyVar != null && (channelList = cyVar.getChannelList()) != null && !channelList.isEmpty()) {
                    Iterator<IGProChannelInfo> it = channelList.iterator();
                    while (it.hasNext()) {
                        IGProChannelInfo next = it.next();
                        if (!TextUtils.isEmpty(string) && TextUtils.equals(next.getChannelUin(), string)) {
                            it.remove();
                        } else if (i3 != 0 && next.getType() != i3) {
                            it.remove();
                        } else if (!z16 && !next.isChannelOrCategoryAdmin()) {
                            it.remove();
                        }
                    }
                    if (!channelList.isEmpty()) {
                        z17 = false;
                    }
                }
            }
        }
        return z17;
    }

    private void J(final Bundle bundle, final c cVar) {
        final String string = bundle.getString("key_guild_id", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        bd bdVar = new bd();
        bdVar.k(Long.parseLong(string));
        bdVar.h(false);
        bdVar.j(false);
        bdVar.i(false);
        ((IGPSService) ch.S0(IGPSService.class, "")).getCategoryChannelInfoListV2(bdVar, new br() { // from class: aq1.e
            @Override // wh2.br
            public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                h.U(h.c.this, bundle, string, arrayList);
            }
        });
    }

    public static Bundle K(int i3, String str, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt("errCode", i3);
        bundle.putString("errMsg", str);
        if (obj instanceof IGProSecurityResult) {
            IGProSecurityResult iGProSecurityResult = (IGProSecurityResult) obj;
            bundle.putLong("actionCode", iGProSecurityResult.get$actionCode());
            bundle.putString("strPrompt", iGProSecurityResult.getStrPrompt());
            bundle.putString("strDetail", iGProSecurityResult.getStrDetail());
        }
        return bundle;
    }

    public static h L() {
        if (f26738e == null) {
            synchronized (h.class) {
                if (f26738e == null) {
                    f26738e = new h(IGuildIPCService.GUILD_NAME_IPC_NAME);
                }
            }
        }
        return f26738e;
    }

    private void M(Bundle bundle, int i3) {
        String string = bundle.getString("joinGuildSig");
        if (!TextUtils.isEmpty(string)) {
            C(string, bundle.getString("guildId"), bundle.getString("channelId"), bundle.getString("sourceId"), bundle.getString("subSourceId"), bundle.getString("detailUrl"), i3);
        } else {
            E(bundle.getString("inviteCode"), bundle.getString("sourceId"), bundle.getString("subSourceId"), bundle.getInt("entranceId"), bundle.getString("detailUrl"), i3);
        }
    }

    private void N(Bundle bundle, final int i3) {
        final String string = bundle.getString("guildId");
        GuildMainFrameUtils.l(string, true, new Function1() { // from class: aq1.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit V;
                V = h.this.V(i3, string, (IGProGuildInfo) obj);
                return V;
            }
        });
    }

    private EIPCResult O(Context context, String str, int i3) {
        if (context == null) {
            context = ch.i();
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).setShowGuildTab(true);
        Pair<String, String> b16 = QQGuildJumpSource.b(i3, "QQGuildSvrIPCModule");
        GuildJumpUtil.m(context, new GuildShareInviteCodeParam(str, "", b16.first, b16.second));
        return EIPCResult.createSuccessResult(new Bundle());
    }

    private void P(Bundle bundle, int i3) {
        String string = bundle.getString("url");
        QLog.d("QQGuildSvrIPCModule", 1, "[handleOpenGuildShareURLExternal] shareUrl = " + string);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        Context currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        Context baseContext = waitAppRuntime.getApp().getBaseContext();
        if (currentTopActivity == null) {
            QLog.e("QQGuildSvrIPCModule", 1, "currentTopActivity is null");
            currentTopActivity = baseContext;
        }
        if (!com.tencent.mobileqq.guild.share.shorturl.a.m(string)) {
            QLog.d("QQGuildSvrIPCModule", 1, "[handleOpenGuildShareURLExternal] isGuildShareHandleUrlHasContentID = false");
            cx.a(currentTopActivity, string);
        } else {
            GuildJumpUtil.m(currentTopActivity, new GuildShareUrlParam(string));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(Bundle bundle, ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildPartEmptyEvent(), true);
        } else {
            ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).showPartSelection(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        while (it.hasNext()) {
            IGProChannel iGProChannel = (IGProChannel) it.next();
            if (iGProChannel.getHiddenPostChannel() == 1) {
                if (iGProChannel.getSpeakPermission() == 2) {
                    z18 = true;
                }
            } else if (iGProChannel.getMySpeakPermissionType() == 2) {
                z17 = true;
            }
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (arrayList.isEmpty() || arrayList.size() == 1) {
            z16 = true;
        }
        simpleEventBus.dispatchEvent(new GuildPartCheckResultEvent(z16, z17, z18), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(int i3, String str, int i16, String str2, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        QLog.d("QQGuildSvrIPCModule", 1, "onAddGuildResult, result=", Integer.valueOf(i16), ", errMsg=", str2, ",security:", iGProSecurityResult);
        H(i3, i16, str2, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(int i3, String str, int i16, String str2, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        QLog.d("QQGuildSvrIPCModule", 1, "onAddGuildResult, result=", Integer.valueOf(i16), ", errMsg=", str2, ",security:", iGProSecurityResult);
        H(i3, i16, str2, str, iGProSecurityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(c cVar, Bundle bundle, String str, ArrayList arrayList) {
        boolean z16;
        if (arrayList != null && !arrayList.isEmpty()) {
            bundle.getInt("key_channel_type", 0);
            int i3 = bundle.getInt("KEY_NEED_CHECK_PERMISSION_TYPE", 0);
            if (i3 != 0 && !((IGPSService) ch.R0(IGPSService.class)).getGuildPermission(str).a(i3)) {
                z16 = false;
            } else {
                z16 = true;
            }
            bundle.getInt("key_need_check_speak_permission_type", 0);
            bundle.getBoolean("key_need_filter_hide_channel", false);
            ArrayList<IGProChannel> arrayList2 = new ArrayList<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                IGProCategoryChannelInfoList iGProCategoryChannelInfoList = (IGProCategoryChannelInfoList) it.next();
                if (iGProCategoryChannelInfoList.getCategoryType() == 1) {
                    arrayList2.addAll(iGProCategoryChannelInfoList.getChannelInfoList());
                } else {
                    Iterator<IGProChannel> it5 = iGProCategoryChannelInfoList.getChannelInfoList().iterator();
                    while (it5.hasNext()) {
                        IGProChannel next = it5.next();
                        if (next.getHiddenPostChannel() == 1 && next.getChannelType() == 7) {
                            arrayList2.add(0, next);
                        }
                    }
                }
            }
            Iterator<IGProChannel> it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                IGProChannel next2 = it6.next();
                if (!TextUtils.isEmpty("") && TextUtils.equals(String.valueOf(next2.getChannelId()), "")) {
                    it6.remove();
                } else if (next2.getChannelType() != 7) {
                    it6.remove();
                } else if (!z16 && next2.getIsChannelAdmin() != 1) {
                    it6.remove();
                }
            }
            QLog.i("QQGuildSvrIPCModule", 1, "[checkChannelListEmptyWithFilterV2] callback, isEmptyChannelList = " + arrayList2.size());
            cVar.a(arrayList2);
            return;
        }
        QLog.i("QQGuildSvrIPCModule", 1, "[checkChannelListEmptyWithFilterV2] infoList = " + arrayList);
        cVar.a(new ArrayList<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit V(int i3, String str, IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            callbackResult(i3, EIPCResult.createResult(-1, new Bundle()));
            return Unit.INSTANCE;
        }
        Bundle bundle = new Bundle();
        boolean isMember = iGProGuildInfo.isMember();
        bundle.putBoolean("attrs_is_member", isMember);
        QLog.d("QQGuildSvrIPCModule", 1, "[handleAsyncCheckGuildInfoUpdate] isMember: " + isMember);
        if (!isMember) {
            boolean isVisibleForVisitor = iGProGuildInfo.isVisibleForVisitor();
            boolean isVisitorOperate = ((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getIsVisitorOperate(iGProGuildInfo, 1);
            bundle.putBoolean("isEnableVisitorMode", isVisibleForVisitor);
            bundle.putBoolean("isEnableVisitorInteractMode", isVisitorOperate);
            bundle.putBoolean("isVisitorNeedRealName", ch.r(str));
            QLog.d("QQGuildSvrIPCModule", 1, "[handleAsyncCheckGuildInfoUpdate] isVisibleForVisitor: " + isVisibleForVisitor + ", isInteractiveForVisitor: " + isVisitorOperate);
        }
        callbackResult(i3, EIPCResult.createSuccessResult(bundle));
        return Unit.INSTANCE;
    }

    private void j(String str, Bundle bundle) {
        String string = bundle.getString("key_guild_id", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (I(string, bundle)) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildHashtagDialogEmptyEvent(), true);
        } else {
            ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).showGuildHashtag(bundle);
        }
    }

    private void k(AppRuntime appRuntime, String str, long j3, boolean z16, boolean z17, int i3) {
        ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getMemberInfoByOpenId(str, j3, z16, z17, new a(i3));
    }

    private void l(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = ch.i();
        }
        if (context != null) {
            GuildBlankActivity.b.a(context, new JumpGuildParam(bundle.getString("key_guild_id"), bundle.getString("key_channel_id"), (JumpGuildParam.JoinInfoParam) bundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)));
        } else {
            QLog.w("QQGuildSvrIPCModule", 1, "context is null ");
        }
    }

    private boolean m(String str, Bundle bundle) {
        return com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.f.b(bundle.getString(IGuildSpeechApi.KEY_GUILD), bundle.getInt(IGuildSpeechApi.KEY_AT_ALL_NUM), bundle.getInt(IGuildSpeechApi.KEY_AT_ONLINE_NUM), bundle.getInt(IGuildSpeechApi.KEY_AT_ROLE_NUM));
    }

    private boolean n(String str, Bundle bundle) {
        String string = bundle.getString(IGuildSpeechApi.KEY_GUILD);
        String string2 = bundle.getString(IGuildSpeechApi.KEY_CHANNEL);
        int i3 = bundle.getInt(IGuildSpeechApi.KEY_TYPE);
        CharSequence charSequence = bundle.getCharSequence("key_content", "");
        if (com.tencent.mobileqq.guild.setting.mute.c.V(string, string2)) {
            QLog.i("QQGuildSvrIPCModule", 1, "[NeedInterceptSpeech] type:[" + i3 + "] is admin");
            return false;
        }
        return com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.af.c(string, string2, i3, charSequence);
    }

    private void o(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ((IGuildNewUserMsgNoticeApi) QRoute.api(IGuildNewUserMsgNoticeApi.class)).setNewUserStayOrWriteInChannel(bundle.getString("key_guild_id"), bundle.getString("key_channel_id"), bundle.getInt("key_channel_type"));
    }

    private void p(Bundle bundle) {
        com.tencent.mobileqq.guild.setting.guildmanage.speak.rule.af.e(bundle.getString(IGuildSpeechApi.KEY_GUILD));
    }

    private void q(String str, Bundle bundle) {
        if (!com.tencent.mobileqq.guild.util.at.c()) {
            QLog.e("QQGuildSvrIPCModule", 1, "actionRegisterMuteObserver fail, session == null");
        } else {
            ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).registerMuteObserver(bundle);
        }
    }

    private void r(String str, Bundle bundle) {
        String string = bundle.getString("key_guild_id");
        String string2 = bundle.getString("key_channel_id");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            if (!com.tencent.mobileqq.guild.util.at.c()) {
                QLog.e("QQGuildSvrIPCModule", 1, "actionRegisterSpeakThresholdObserver fail, session == null");
                return;
            } else {
                QLog.i("QQGuildSvrIPCModule", 1, "actionRegisterSpeakThresholdObserver");
                ((IGuildInfoManagerApi) QRoute.api(IGuildInfoManagerApi.class)).handlerUpdateSpeakThresholdState(string, string2);
                return;
            }
        }
        QLog.e("QQGuildSvrIPCModule", 1, "actionRegisterSpeakThresholdObserver: channelId or guildId is null.");
    }

    private void s(String str, Bundle bundle) {
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).showGuildAt(bundle);
    }

    private void t(String str, Bundle bundle) {
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).showGuildEmojiInFeed(bundle);
    }

    private void u(String str, Bundle bundle) {
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).showGuildHashtag(bundle);
    }

    private void v(String str, Bundle bundle) {
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).showGuildUserCard(bundle);
    }

    private void w(final Bundle bundle) {
        String string = bundle.getString("key_guild_id", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(string);
        if (guildInfo != null && guildInfo.isMovePostSection()) {
            J(bundle, new c() { // from class: aq1.d
                @Override // aq1.h.c
                public final void a(ArrayList arrayList) {
                    h.Q(bundle, arrayList);
                }
            });
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new GuildPartEmptyEvent(), true);
        }
    }

    private void x(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).showTroopUserCard(bundle.getString("key_troop_id"), bundle.getString("key_uin"));
    }

    private void y(Bundle bundle) {
        String string = bundle.getString("key_guild_id", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(string);
        if (guildInfo != null && guildInfo.isMovePostSection()) {
            J(bundle, new c() { // from class: aq1.b
                @Override // aq1.h.c
                public final void a(ArrayList arrayList) {
                    h.R(arrayList);
                }
            });
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new GuildPartCheckResultEvent(), true);
        }
    }

    private boolean z(Bundle bundle) {
        if (bundle == null || ((IGPSService) ch.R0(IGPSService.class)).getChannelInfo(bundle.getString("channel_id")) == null) {
            return false;
        }
        return true;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        String str2;
        String str3;
        boolean z16 = false;
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildSvrIPCModule", 2, "onCall action:", str, ", callbackId:", Integer.valueOf(i3));
        }
        if (this.f26739d.a(str)) {
            return this.f26739d.c(this, str, bundle, i3);
        }
        if ("addGuild".equals(str)) {
            String string = bundle.getString("sourceId");
            String string2 = bundle.getString("subSourceId");
            int i16 = bundle.getInt("entranceId");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                str3 = string2;
                str2 = string;
            } else {
                Pair<String, String> b16 = QQGuildJumpSource.b(bundle.getInt("from"), "QQGuildSvrIPCModule");
                str2 = b16.first;
                str3 = b16.second;
            }
            B(bundle.getString("inviteCode"), str2, str3, i16, i3);
            return null;
        }
        if ("addGuildExternal".equals(str)) {
            M(bundle, i3);
            return null;
        }
        if ("openGuildShareURL".equals(str)) {
            P(bundle, i3);
            return null;
        }
        if ("handleGuildOpenResult".equals(str)) {
            ((IGuildOpenApi) ch.S0(IGuildOpenApi.class, "")).handleGuildOpenResult(bundle.getString("packageId"), bundle.getString("gamedata"));
            return null;
        }
        if ("handleEnterToTroop".equals(str)) {
            ((IGuildOpenApi) ch.S0(IGuildOpenApi.class, "")).handleEnterToTroop(bundle.getString("packageId"), bundle.getString("troopUin"));
            return null;
        }
        if ("navigateToGuildPageWithInvitedInfo".equals(str)) {
            return O(QBaseActivity.sTopActivity, bundle.getString("inviteCode"), bundle.getInt("from"));
        }
        if ("syncIsShowGuildTab".equals(str)) {
            boolean isShowGuildTab = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("ret", isShowGuildTab);
            return EIPCResult.createSuccessResult(bundle2);
        }
        if (IGuildIPCService.ACTION_GET_MEMBERINFO_BY_OPENID.equals(str)) {
            k(ch.m(), bundle.getString("guildOpenId"), bundle.getLong("miniAppId"), bundle.getBoolean("isNeedBind"), bundle.getBoolean("isNeedAccountSecret"), i3);
            return null;
        }
        if ("sync_show_guild_emoj".equals(str)) {
            t(str, bundle);
            return null;
        }
        if ("sync_show_guild_hashtag".equals(str)) {
            u(str, bundle);
            return null;
        }
        if ("action_sync_check_empty_show_guild_hashtag".equals(str)) {
            IGProGuildInfo guildInfo = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(bundle.getString("key_guild_id", ""));
            if (guildInfo != null && guildInfo.isMovePostSection()) {
                w(bundle);
                return null;
            }
            j(str, bundle);
            return null;
        }
        if ("action_sync_show_part_select_panel".equals(str)) {
            w(bundle);
            return null;
        }
        if ("action_sync_check_part_list_empty".equals(str)) {
            y(bundle);
            return null;
        }
        if ("sync_show_guild_at".equals(str)) {
            s(str, bundle);
            return null;
        }
        if ("sync_show_guild_user_card".equals(str)) {
            v(str, bundle);
            return null;
        }
        if ("async_register_mute_observer".equals(str)) {
            q(str, bundle);
            return null;
        }
        if ("async_register_speakthreshold_observer".equals(str)) {
            r(str, bundle);
            return null;
        }
        if ("sync_check_send_for_speech".equals(str)) {
            boolean n3 = n(str, bundle);
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT, n3);
            return EIPCResult.createSuccessResult(bundle3);
        }
        if ("sync_check_send_for_at".equals(str)) {
            boolean m3 = m(str, bundle);
            Bundle bundle4 = new Bundle();
            bundle4.putBoolean(IGuildSpeechApi.KEY_NEED_INTERCEPT, m3);
            return EIPCResult.createSuccessResult(bundle4);
        }
        if ("async_preload_speak_rule".equals(str)) {
            p(bundle);
            return null;
        }
        if ("async_check_guild_info_update".equals(str)) {
            N(bundle, i3);
            return null;
        }
        if ("sync_show_troop_user_card".equals(str)) {
            x(bundle);
            return null;
        }
        if ("sync_note_user_write_or_stay".equals(str)) {
            o(bundle);
            return null;
        }
        if ("action_launch_feed_channel".equals(str)) {
            l(bundle);
            return null;
        }
        if ("action_to_expose_recommend".equals(str)) {
            A(bundle);
            return null;
        }
        if ("action_to_check_channel_exist".equals(str)) {
            boolean z17 = z(bundle);
            Bundle bundle5 = new Bundle();
            bundle5.putBoolean("result", z17);
            return EIPCResult.createSuccessResult(bundle5);
        }
        if ("action_check_is_guild_gray".equals(str)) {
            IGProGuildInfo guildInfo2 = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildInfo(bundle.getString("guild_id"));
            if (guildInfo2 != null) {
                z16 = guildInfo2.isMovePostSection();
            }
            Bundle bundle6 = new Bundle();
            bundle6.putBoolean("result", z16);
            return EIPCResult.createSuccessResult(bundle6);
        }
        return null;
    }
}
