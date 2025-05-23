package com.tencent.mobileqq.guild.handler.api.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.IBusinessHandler;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.channel.create.data.IGProChannelInfoForApplicationChannelLink;
import com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig;
import com.tencent.mobileqq.guild.data.x;
import com.tencent.mobileqq.guild.message.registerproxy.IGuildRegisterProxyGaryService;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.fm;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRemoveRiskMembersRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cg;
import com.tencent.mobileqq.qqguildsdk.data.genc.du;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.util.List;
import vh2.bd;
import vh2.cc;
import vh2.cd;
import vh2.ct;
import vh2.cz;
import wh2.dg;
import wh2.dr;
import wh2.ei;

/* compiled from: P */
/* loaded from: classes13.dex */
public class QQGuildHandler extends BusinessHandler implements IBusinessHandler {

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements vh2.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f224634a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vh2.g f224635b;

        a(String str, vh2.g gVar) {
            this.f224634a = str;
            this.f224635b = gVar;
        }

        @Override // vh2.g
        public void a(int i3, String str, IGProChannelInfo iGProChannelInfo, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(iGProSecurityResult)) {
                QQGuildHandler.this.notifyUI(1, true, new x(iGProChannelInfo, this.f224634a));
            }
            vh2.g gVar = this.f224635b;
            if (gVar != null) {
                gVar.a(i3, str, iGProChannelInfo, iGProSecurityResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f224637a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cd f224638b;

        b(IGProChannelInfo iGProChannelInfo, cd cdVar) {
            this.f224637a = iGProChannelInfo;
            this.f224638b = cdVar;
        }

        @Override // vh2.cd
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(iGProSecurityResult)) {
                QQGuildHandler.this.notifyUI(2, true, this.f224637a);
            }
            cd cdVar = this.f224638b;
            if (cdVar != null) {
                cdVar.a(i3, str, iGProSecurityResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class c implements ct {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ct f224640a;

        c(ct ctVar) {
            this.f224640a = ctVar;
        }

        @Override // vh2.ct
        public void a(int i3, IGProChannelInfo iGProChannelInfo, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && ((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).checkSecurityValid(iGProSecurityResult)) {
                QQGuildHandler.this.notifyUI(3, true, iGProChannelInfo);
            }
            ct ctVar = this.f224640a;
            if (ctVar != null) {
                ctVar.a(i3, iGProChannelInfo, str, iGProSecurityResult);
            }
        }
    }

    protected QQGuildHandler(AppInterface appInterface) {
        super(appInterface);
        appInterface.getRuntimeService(IGuildRegisterProxyGaryService.class, "");
    }

    private void M2(final String str, final com.tencent.mobileqq.qqguildsdk.data.d dVar, String str2, long j3, String str3, final vh2.g gVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).createLinkChannel(str, dVar, j3, new bd() { // from class: com.tencent.mobileqq.guild.handler.api.impl.b
            @Override // vh2.bd
            public final void onResult(int i3, String str4) {
                QQGuildHandler.Q2(vh2.g.this, dVar, str, i3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q2(vh2.g gVar, com.tencent.mobileqq.qqguildsdk.data.d dVar, String str, int i3, String str2) {
        if (gVar != null) {
            gVar.a(i3, str2, new IGProChannelInfoForApplicationChannelLink(dVar, str), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(String str, dg dgVar, int i3, String str2, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGuildHandler", 2, String.format("doCheckin guildId:%s, ", str));
            }
            notifyUI(20, true, new Object[]{str, iGProGuildCheckinRsp});
        }
        if (dgVar != null) {
            dgVar.a(i3, str2, iGProGuildCheckinRsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2(String str, List list, boolean z16, cd cdVar, int i3, String str2, IGProSecurityResult iGProSecurityResult) {
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGuildHandler", 2, String.format("kickGuildUsers guildId:%s, tinyIdList:%d,", str, Integer.valueOf(list.size())));
            }
            notifyUI(19, true, new Object[]{str, Boolean.valueOf(z16), list});
        }
        if (cdVar != null) {
            cdVar.a(i3, str2, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T2(String str, List list, cc ccVar, int i3, String str2) {
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGuildHandler", 2, String.format("removeMemberFromGuildBlackList guildId:%s, tinyIdList:%d,", str, Integer.valueOf(list.size())));
            }
            notifyUI(16, true, new Object[]{str, list});
        }
        if (ccVar != null) {
            ccVar.onResult(i3, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2(du duVar, cc ccVar, int i3, String str, IGProRemoveRiskMembersRsp iGProRemoveRiskMembersRsp) {
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGuildHandler", 2, "removeMemberFromGuildRiskList " + duVar);
            }
            notifyUI(18, true, new Object[]{Long.valueOf(duVar.b()), Boolean.valueOf(duVar.a()), Boolean.valueOf(duVar.e()), duVar.f()});
        }
        if (ccVar != null) {
            ccVar.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V2(String str, int i3, int i16, cz czVar, int i17, String str2, int i18) {
        QLog.i("QQGuildHandler", 1, "setGuildUnNotifyType guildId:" + str + " MessageNotifyType:" + i3 + " notifyFlag:" + i16 + " needNotice:" + i18);
        if (czVar != null) {
            czVar.a(i17, str2, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W2(String str, int i3, cz czVar, int i16, String str2, int i17) {
        if (i16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("QQGuildHandler", 2, "setGuildUnNotifyType guildId:" + str + " MessageNotifyType:" + i3 + " needNotice:" + i17);
            }
            notifyUI(15, true, new Object[]{str, Integer.valueOf(i3)});
        }
        if (czVar != null) {
            czVar.a(i16, str2, i17);
        }
    }

    public void K2(rr1.b bVar) {
        notifyUI(7, true, bVar);
    }

    public void L2(String str, com.tencent.mobileqq.qqguildsdk.data.d dVar, String str2, long j3, String str3, vh2.g gVar) {
        if (dVar.p() == 6 && dVar.a() == MiniAppReportManager.MAX_TIME_VALUE) {
            M2(str, dVar, str2, j3, str3, gVar);
        } else {
            ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).createChannel(str, dVar, j3, 0, null, new a(str3, gVar));
        }
    }

    public void N2(IGProChannelInfo iGProChannelInfo, int i3, cd cdVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).removeChannel(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), i3, new b(iGProChannelInfo, cdVar));
    }

    public void O2(final String str, final dg dgVar) {
        cg cgVar = new cg();
        cgVar.b(NumberUtil.stringToLong(str));
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).doGuildCheckin(cgVar, new dg() { // from class: com.tencent.mobileqq.guild.handler.api.impl.d
            @Override // wh2.dg
            public final void a(int i3, String str2, IGProGuildCheckinRsp iGProGuildCheckinRsp) {
                QQGuildHandler.this.R2(str, dgVar, i3, str2, iGProGuildCheckinRsp);
            }
        });
    }

    public void P2(final String str, final List<String> list, final boolean z16, @Nullable fm fmVar, final cd cdVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).kickGuildUsers(str, list, z16, fmVar, new cd() { // from class: com.tencent.mobileqq.guild.handler.api.impl.e
            @Override // vh2.cd
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                QQGuildHandler.this.S2(str, list, z16, cdVar, i3, str2, iGProSecurityResult);
            }
        });
    }

    public void X2(final String str, @NonNull final List<String> list, final cc ccVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).removeMemberFromGuildBlackList(str, list, new cc() { // from class: com.tencent.mobileqq.guild.handler.api.impl.a
            @Override // vh2.cc
            public final void onResult(int i3, String str2) {
                QQGuildHandler.this.T2(str, list, ccVar, i3, str2);
            }
        });
    }

    public void Y2(final du duVar, final cc ccVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).removeRiskMembers(duVar, new dr() { // from class: com.tencent.mobileqq.guild.handler.api.impl.g
            @Override // wh2.dr
            public final void a(int i3, String str, IGProRemoveRiskMembersRsp iGProRemoveRiskMembersRsp) {
                QQGuildHandler.this.U2(duVar, ccVar, i3, str, iGProRemoveRiskMembersRsp);
            }
        });
    }

    public void Z2(final String str, final int i3, final int i16, final cz czVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).setGuildCommonUnNotifyFlag(Long.parseLong(str), i3, i16, new ei() { // from class: com.tencent.mobileqq.guild.handler.api.impl.f
            @Override // wh2.ei
            public final void onSetGuildNotifyDisplay(int i17, String str2, int i18) {
                QQGuildHandler.V2(str, i3, i16, czVar, i17, str2, i18);
            }
        });
    }

    public void a3(final String str, final int i3, final cz czVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).setGuildUnNotifyFlag(str, i3, new cz() { // from class: com.tencent.mobileqq.guild.handler.api.impl.c
            @Override // vh2.cz
            public final void a(int i16, String str2, int i17) {
                QQGuildHandler.this.W2(str, i3, czVar, i16, str2, i17);
            }
        });
    }

    public void b3(IGProChannelInfo iGProChannelInfo, String str, ct ctVar) {
        ((IGPSService) this.appRuntime.getRuntimeService(IGPSService.class, "")).setChannelName(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), str, new c(ctVar));
    }

    public void c3(boolean z16) {
        notifyUI(12, true, Boolean.valueOf(z16));
    }

    public void d3() {
        notifyUI(13, true, null);
    }

    public void e3(int i3, int i16) {
        QQGuildGrayUserTypeConfig a16 = QQGuildGrayUserTypeConfig.a();
        a16.c(i3);
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildHandler", 2, "updateGuildUserType -> notifyUI " + a16.toString() + " from:" + i16);
        }
        notifyUI(5, true, new Object[]{a16, Integer.valueOf(i16)});
    }

    public void f3(IGProChannelInfo iGProChannelInfo) {
        notifyUI(10, true, iGProChannelInfo);
    }

    public void g3(String str) {
        notifyUI(6, true, str);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return oo1.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
