package com.tencent.mobileqq.guild.robot.components.auth;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.components.auth.RobotAuthorizeAddInfo;
import com.tencent.mobileqq.guild.robot.components.auth.b;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProAddGuildRobotReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPermissionRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends sx1.b {

    /* renamed from: a, reason: collision with root package name */
    final AppRuntime f232101a;

    /* renamed from: b, reason: collision with root package name */
    final long f232102b;

    /* renamed from: c, reason: collision with root package name */
    final long f232103c;

    /* renamed from: d, reason: collision with root package name */
    final long f232104d;

    /* renamed from: e, reason: collision with root package name */
    final String f232105e;

    /* renamed from: f, reason: collision with root package name */
    private RobotAuthorizeAddFragment f232106f;

    /* renamed from: g, reason: collision with root package name */
    private RobotAuthorizeAddInfo f232107g;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        void a(int i3, String str, RobotAuthorizeAddInfo robotAuthorizeAddInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AppRuntime appRuntime, long j3, long j16, long j17, String str) {
        this.f232101a = appRuntime;
        this.f232102b = j3;
        this.f232103c = j16;
        this.f232104d = j17;
        this.f232105e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i3, String str, int i16) {
        if (i3 != 0) {
            QLog.e("RobotAuthorizeAddContro", 1, "addGuildRobot|result = " + i3 + " errMsg = " + str + " guild = " + this.f232102b + " robotUin = " + this.f232103c + " userType = " + i16);
            this.f232106f.Kh(i3, str);
            return;
        }
        this.f232106f.Eh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(final int i3, final int i16, final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ax1.d
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.mobileqq.guild.robot.components.auth.b.this.h(i16, str, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(final a aVar, final int i3, final String str, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
        final RobotAuthorizeAddInfo a16;
        if (aVar != null) {
            if (i3 != 0) {
                a16 = null;
            } else {
                a16 = RobotAuthorizeAddInfo.a(gProGuildRobotPermissionRsp);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ax1.b
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.this.a(i3, str, a16);
                }
            });
        }
    }

    public static void l(long j3, long j16, final a aVar) {
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchGuildRobotPermission(new GProGuildRobotPermissionReq(j3, j16), new IGProFetchGuildRobotPermissionCallback() { // from class: ax1.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotPermissionCallback
            public final void onFetchGuildRobotPermission(int i3, String str, GProGuildRobotPermissionRsp gProGuildRobotPermissionRsp) {
                com.tencent.mobileqq.guild.robot.components.auth.b.k(b.a.this, i3, str, gProGuildRobotPermissionRsp);
            }
        });
    }

    public static boolean m(RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        if (robotAuthorizeAddInfo != null && !robotAuthorizeAddInfo.e().isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        RobotAuthorizeAddInfo robotAuthorizeAddInfo = this.f232107g;
        if (robotAuthorizeAddInfo == null) {
            return;
        }
        final int i3 = 1;
        if (robotAuthorizeAddInfo.f() != 1) {
            i3 = 0;
        }
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.addGuildRobot(new GProAddGuildRobotReq(this.f232102b, this.f232103c, i3, (ArrayList) RobotAuthorizeAddInfo.Permission.a(new ArrayList(this.f232107g.e().size()), this.f232107g.e())), new IGProRobotSimpleResultCallback() { // from class: ax1.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
            public final void onResult(int i16, String str) {
                com.tencent.mobileqq.guild.robot.components.auth.b.this.i(i3, i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotAuthorizeAddInfo f() {
        return this.f232107g;
    }

    public int g() {
        IGProGuildInfo guildInfo = ((IGPSService) this.f232101a.getRuntimeService(IGPSService.class, "")).getGuildInfo(String.valueOf(this.f232102b));
        if (guildInfo == null) {
            return 1;
        }
        return guildInfo.getUserType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(RobotAuthorizeAddInfo robotAuthorizeAddInfo) {
        this.f232107g = robotAuthorizeAddInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(RobotAuthorizeAddFragment robotAuthorizeAddFragment) {
        this.f232106f = robotAuthorizeAddFragment;
    }
}
