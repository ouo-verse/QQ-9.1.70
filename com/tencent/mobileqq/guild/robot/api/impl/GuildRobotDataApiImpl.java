package com.tencent.mobileqq.guild.robot.api.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotDataApi;
import com.tencent.mobileqq.guild.robot.api.impl.GuildRobotDataApiImpl;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildReq;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import sx1.f;
import vw1.c;
import xw1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRobotDataApiImpl implements IGuildRobotDataApi {
    private static final String TAG = "GuildRobotDataApiImpl";

    private ArrayList<b> convertDTO(List<GProRobotCommonGuildInfo> list) {
        ArrayList<b> arrayList = new ArrayList<>();
        for (GProRobotCommonGuildInfo gProRobotCommonGuildInfo : list) {
            b bVar = new b();
            bVar.e(Long.valueOf(gProRobotCommonGuildInfo.getGuildId()));
            bVar.f(gProRobotCommonGuildInfo.getGuildName());
            bVar.c(gProRobotCommonGuildInfo.getGuildFace());
            bVar.d(Long.valueOf(gProRobotCommonGuildInfo.getGuildFaceSeq()));
            bVar.g(bVar.b());
            arrayList.add(bVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRobotCommonGuilds$1(c cVar, ArrayList arrayList, GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        cVar.a(arrayList, Integer.valueOf(gProRobotCommonGuildRsp.getTotal()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRobotCommonGuilds$2(final c cVar, final int i3, final String str, final GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
        if (i3 == 0 && gProRobotCommonGuildRsp != null) {
            final ArrayList<b> convertDTO = convertDTO(gProRobotCommonGuildRsp.getGuilds());
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ww1.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildRobotDataApiImpl.lambda$getRobotCommonGuilds$1(vw1.c.this, convertDTO, gProRobotCommonGuildRsp);
                }
            });
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ww1.c
                @Override // java.lang.Runnable
                public final void run() {
                    vw1.c.this.onError(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotDataApi
    public void getRobotCommonGuilds(AppRuntime appRuntime, String str, @NonNull final c<b> cVar) {
        ac g16 = f.g();
        if (g16 == null) {
            return;
        }
        long d16 = az.d(str, 0L);
        if (d16 == 0) {
            QLog.e(TAG, 1, "getRobotCommonGuilds|robotTid=" + str);
            return;
        }
        g16.fetchRobotCommonGuild(new GProRobotCommonGuildReq(0L, 0, 20, d16, 1, 0L, new ArrayList(), new ArrayList()), new IGProFetchRobotCommonGuildCallback() { // from class: ww1.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchRobotCommonGuildCallback
            public final void onFetchRobotCommonGuild(int i3, String str2, GProRobotCommonGuildRsp gProRobotCommonGuildRsp) {
                GuildRobotDataApiImpl.this.lambda$getRobotCommonGuilds$2(cVar, i3, str2, gProRobotCommonGuildRsp);
            }
        });
    }
}
