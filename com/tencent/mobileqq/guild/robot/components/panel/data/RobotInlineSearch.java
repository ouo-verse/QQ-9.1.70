package com.tencent.mobileqq.guild.robot.components.panel.data;

import android.os.Handler;
import com.tencent.guild.aio.input.at.quickAt.search.SearchException;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineLayout;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineSearchReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInlineSearchRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotInlineSearchCallback;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotInlineSearch extends uo0.k {

    /* renamed from: i, reason: collision with root package name */
    public static Long f232175i = Long.valueOf(MiniBoxNoticeInfo.MIN_5);

    /* renamed from: j, reason: collision with root package name */
    public static int f232176j = 5000;

    /* renamed from: c, reason: collision with root package name */
    private final String f232177c;

    /* renamed from: d, reason: collision with root package name */
    private final String f232178d;

    /* renamed from: e, reason: collision with root package name */
    private final String f232179e;

    /* renamed from: f, reason: collision with root package name */
    private final String f232180f;

    /* renamed from: g, reason: collision with root package name */
    private Long f232181g;

    /* renamed from: h, reason: collision with root package name */
    private List<GProGuildRobotInlineLayout> f232182h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends qx1.a<GProGuildRobotInlineSearchRsp> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(int i3, String str, GProGuildRobotInlineSearchRsp gProGuildRobotInlineSearchRsp) {
            RobotInlineSearch.this.e(new SearchException(i3, str, RobotInlineSearch.this));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // qx1.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(GProGuildRobotInlineSearchRsp gProGuildRobotInlineSearchRsp) {
            RobotInlineSearch.this.f232182h = gProGuildRobotInlineSearchRsp.getLayoutList();
            if (RobotInlineSearch.this.f232182h == null) {
                RobotInlineSearch.this.f232182h = Collections.emptyList();
            }
            RobotInlineSearch.this.d();
        }
    }

    public RobotInlineSearch(AppRuntime appRuntime, String str, String str2, String str3, String str4) {
        this.f232177c = str;
        this.f232178d = str2;
        this.f232179e = str3;
        this.f232180f = str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final int i3, final String str, final GProGuildRobotInlineSearchRsp gProGuildRobotInlineSearchRsp) {
        final a aVar = new a();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.j
            @Override // java.lang.Runnable
            public final void run() {
                qx1.a.this.a(i3, str, gProGuildRobotInlineSearchRsp);
            }
        });
    }

    private void u() {
        ac g16 = sx1.f.g();
        if (g16 == null) {
            e(new SearchException(-94, "\u63a5\u53e3\u8c03\u7528\u5931\u8d25", this));
        } else {
            g16.getGuildRobotInlineSearch(new GProGuildRobotInlineSearchReq(az.d(this.f232178d, 0L), az.d(this.f232179e, 0L), az.d(this.f232177c, 0L), this.f232180f), new IGetGuildRobotInlineSearchCallback() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.i
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGuildRobotInlineSearchCallback
                public final void onGetGuildRobotInlineSearch(int i3, String str, GProGuildRobotInlineSearchRsp gProGuildRobotInlineSearchRsp) {
                    RobotInlineSearch.this.t(i3, str, gProGuildRobotInlineSearchRsp);
                }
            });
        }
    }

    @Override // uo0.k
    public String f() {
        return this.f232177c + ":" + this.f232180f;
    }

    @Override // uo0.k
    public String h() {
        return this.f232180f;
    }

    @Override // uo0.k
    public List<GProGuildRobotInlineLayout> i() {
        return this.f232182h;
    }

    @Override // uo0.k
    public boolean l() {
        if (System.currentTimeMillis() - this.f232181g.longValue() > f232175i.longValue()) {
            return true;
        }
        return false;
    }

    @Override // uo0.k
    public void m() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.e("GuildRobotTag:RobotInlineSearch", 1, "app is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildRobotTag:RobotInlineSearch", 2, "new RobotInlineSearch start, mKeyWords:" + this.f232180f + ", mRobotId:" + this.f232177c);
        }
        this.f232181g = Long.valueOf(System.currentTimeMillis());
        u();
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.robot.components.panel.data.RobotInlineSearch.1
            @Override // java.lang.Runnable
            public void run() {
                RobotInlineSearch.this.c();
            }
        }, f232176j);
    }
}
