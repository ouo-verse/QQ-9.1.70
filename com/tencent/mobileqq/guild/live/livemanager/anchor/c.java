package com.tencent.mobileqq.guild.live.livemanager.anchor;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ff;
import com.tencent.qphone.base.util.QLog;
import vh2.bs;
import vh2.dc;
import vh2.de;

/* compiled from: P */
/* loaded from: classes14.dex */
public final /* synthetic */ class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements bs {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f226758a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f226759b;

        a(d dVar, int i3) {
            this.f226759b = dVar;
            this.f226758a = i3;
        }

        @Override // vh2.bs
        public void a(int i3, String str, ff ffVar) {
            QLog.d("QGL.IBaseAnchorMgr", 1, "getUserLiveInfo res-", Integer.valueOf(i3), " err-", str, " info-", ffVar);
            if (i3 == 0 && ffVar != null) {
                int i16 = this.f226758a;
                if (i16 == 0) {
                    GLiveChannelCore.f226698a.t().m0(ffVar);
                } else if (i16 == 1) {
                    GLiveChannelCore.f226698a.t().X(ffVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements dc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f226760a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f226761b;

        b(d dVar, f fVar) {
            this.f226761b = dVar;
            this.f226760a = fVar;
        }

        @Override // vh2.dc
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            QLog.d("QGL.IBaseAnchorMgr", 1, "setUserLiveInfo res-", Integer.valueOf(i3), " err-", str);
            if (i3 != 0) {
                aa.d(R.string.f148360zd);
                f fVar = this.f226760a;
                if (fVar != null) {
                    fVar.b(Integer.valueOf(i3), str);
                    return;
                }
                return;
            }
            f fVar2 = this.f226760a;
            if (fVar2 != null) {
                fVar2.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.live.livemanager.anchor.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C7813c implements de {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f226762a;

        C7813c(d dVar) {
            this.f226762a = dVar;
        }

        @Override // vh2.de
        public void a(int i3, String str) {
            QLog.i("QGL.IBaseAnchorMgr", 1, "terminateLiveStream, result:" + i3 + ",errMsg:" + str);
        }
    }

    public static void a(d dVar) {
        QLog.i("QGL.IBaseAnchorMgr", 1, "exitLiveRoom");
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        iGPSService.terminateLiveStream(gLiveChannelCore.s().getGuildId(), gLiveChannelCore.s().getChannelId(), 1, new C7813c(dVar));
    }

    public static void b(d dVar, int i3) {
        dVar.getService().getUserLiveInfo(i3, new a(dVar, i3));
    }

    public static void c(d dVar, int i3, GLiveRoomInfo gLiveRoomInfo, int i16, @Nullable f fVar) {
        QLog.d("QGL.IBaseAnchorMgr", 1, "setUserLiveInfo roomType-", Integer.valueOf(i3), " roomInfo-", gLiveRoomInfo);
        dVar.getService().setUserLiveInfo(i3, gLiveRoomInfo.getRoomTitle(), gLiveRoomInfo.getRoomCover(), i16, new b(dVar, fVar));
    }
}
