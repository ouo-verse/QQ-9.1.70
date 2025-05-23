package com.tencent.mobileqq.guild.profile.profilecard;

import android.os.Bundle;
import com.tencent.mobileqq.activity.home.aj;
import com.tencent.mobileqq.activity.home.al;
import com.tencent.mobileqq.activity.home.t;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes14.dex */
public class GuildProfileRequestProcessor extends AbsProfileCommonProcessor {

    /* renamed from: a, reason: collision with root package name */
    private long f231320a;

    /* loaded from: classes14.dex */
    static class a implements aj {
        a() {
        }

        @Override // com.tencent.mobileqq.activity.home.aj
        public void a(al alVar) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.profile.GuildProfileRequestProcessor", 2, "onTabFrameAdd: ", alVar);
            }
        }
    }

    public GuildProfileRequestProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        t.c().b(new a());
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        return "Guild.profile.GuildProfileRequestProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        oidb_0x5eb_reqbody.uint32_guild_gray_flag.set(1);
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.profile.GuildProfileRequestProcessor", 4, "onGetProfileDetailRequestForLogin: ", 45091);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint32_guild_gray_flag.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_guild_gray_flag.get();
            QLog.d("Guild.profile.GuildProfileRequestProcessor", 1, "onGetProfileDetailResponse: ", Integer.toBinaryString(i3));
            ((QQGuildHandler) ch.j(QQGuildHandler.class)).e3(i3, 1);
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        if (i3 != 45091) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.profile.GuildProfileRequestProcessor", 4, "onProcessProfileModifyPush: don't care id:", Integer.valueOf(i3));
                return;
            }
            return;
        }
        if (this.f231320a != this.appRuntime.getLongAccountUin()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Guild.profile.GuildProfileRequestProcessor", 4, "onProcessProfileModifyPush: don't care uin:", Long.valueOf(this.f231320a));
                return;
            }
            return;
        }
        int size = byteStringMicro.size();
        if (size != 2) {
            StringBuilder sb5 = new StringBuilder();
            for (int i16 = 0; i16 < size; i16++) {
                sb5.append(Integer.toBinaryString(byteStringMicro.byteAt(i16)));
            }
            QLog.w("Guild.profile.GuildProfileRequestProcessor", 1, "onProcessProfileModifyPush, type: 45091 size=" + size + " which!=2! content=" + sb5.toString());
            return;
        }
        short s16 = ByteBuffer.wrap(byteStringMicro.toByteArray()).order(ByteOrder.BIG_ENDIAN).getShort();
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.profile.GuildProfileRequestProcessor", 4, "onProcessProfileModifyPush, type: ", 45091, " flag: ", Integer.toBinaryString(s16));
        }
        ((QQGuildHandler) ch.j(QQGuildHandler.class)).e3(s16, 2);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushBegin(long j3) {
        this.f231320a = j3;
    }
}
