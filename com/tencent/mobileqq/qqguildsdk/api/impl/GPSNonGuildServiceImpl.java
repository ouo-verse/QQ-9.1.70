package com.tencent.mobileqq.qqguildsdk.api.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqguildsdk.api.IGPSNonGuildService;
import com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0x1164.oidb_0x1164$IsNewUserReq;
import com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0x1164.oidb_0x1164$IsNewUserRsp;
import com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$Filter;
import com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ReqBody;
import com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$RspBody;
import com.tencent.mobileqq.qqguildsdk.util.GProNonGuildServlet;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Arrays;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes17.dex */
public class GPSNonGuildServiceImpl implements IGPSNonGuildService {
    public static final String TAG = "[gpro_sdk]";
    protected AppRuntime mApp;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchIsJoinedGuild$0(vh2.y yVar, int i3, int i16, String str, byte[] bArr) {
        int i17;
        cmd0xf88$RspBody cmd0xf88_rspbody = new cmd0xf88$RspBody();
        if (bArr != null) {
            try {
            } catch (Exception e16) {
                com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsJoinedGuild", "decode pbData error " + Arrays.toString(e16.getStackTrace()));
            }
            if (bArr.length > 0) {
                cmd0xf88_rspbody.mergeFrom(bArr);
                if (cmd0xf88_rspbody.msg_user_info.uint64_join_group_pro_timestamp.get() != 0) {
                    i17 = 2;
                    com.tencent.mobileqq.qqguildsdk.util.h.u("sdkWrapper interface", true, "fetchIsJoinedGuild", "resultCode=" + i16 + "resultMsg=" + str + ", hasJoinedGuild=" + i17);
                    yVar.a(i16, str, i17);
                }
            }
        }
        i17 = 1;
        com.tencent.mobileqq.qqguildsdk.util.h.u("sdkWrapper interface", true, "fetchIsJoinedGuild", "resultCode=" + i16 + "resultMsg=" + str + ", hasJoinedGuild=" + i17);
        yVar.a(i16, str, i17);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSNonGuildService
    public void fetchIsJoinedGuild(final vh2.y yVar) {
        if (this.mApp == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsJoinedGuild", "mApp is null");
            return;
        }
        if (BaseApplication.getContext() == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsJoinedGuild", "context is null");
            return;
        }
        cmd0xf88$ReqBody cmd0xf88_reqbody = new cmd0xf88$ReqBody();
        cmd0xf88$Filter cmd0xf88_filter = new cmd0xf88$Filter();
        cmd0xf88_filter.uint32_join_group_pro_timestamp.set(1);
        cmd0xf88_reqbody.msg_filter.set(cmd0xf88_filter);
        cmd0xf88_reqbody.uint64_member_id.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
        GProNonGuildServlet.b(this.mApp, cmd0xf88_reqbody.toByteArray(), 3976, 1, new GProNonGuildServlet.a(yVar) { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.bu
            @Override // com.tencent.mobileqq.qqguildsdk.util.GProNonGuildServlet.a
            public final void a(int i3, int i16, String str, byte[] bArr) {
                GPSNonGuildServiceImpl.lambda$fetchIsJoinedGuild$0(null, i3, i16, str, bArr);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGPSNonGuildService
    public void fetchIsNewUser(vh2.bm bmVar) {
        if (this.mApp == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsNewUser", "mApp is null");
            return;
        }
        String str = IGPSNonGuildService.SP_KEY_IS_NEWUSER_KEY + this.mApp.getCurrentAccountUin();
        if (BaseApplication.getContext() == null) {
            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsNewUser", "context is null");
            return;
        }
        boolean z16 = false;
        if (this.mApp != null) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            if (from.isAccessible()) {
                z16 = from.decodeBool(str, false);
            }
        }
        com.tencent.mobileqq.qqguildsdk.util.h.u("sdkWrapper interface", true, "fetchIsNewUser", "alreadyRequested=" + z16);
        if (z16) {
            new Handler(Looper.getMainLooper()).post(new Runnable(bmVar) { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GPSNonGuildServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        } else {
            GProNonGuildServlet.b(this.mApp, new MessageMicro<oidb_0x1164$IsNewUserReq>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0x1164.oidb_0x1164$IsNewUserReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x1164$IsNewUserReq.class);
            }.toByteArray(), 4452, 1, new GProNonGuildServlet.a(str, bmVar) { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GPSNonGuildServiceImpl.2

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f265064a;

                @Override // com.tencent.mobileqq.qqguildsdk.util.GProNonGuildServlet.a
                public void a(int i3, final int i16, final String str2, byte[] bArr) {
                    oidb_0x1164$IsNewUserRsp oidb_0x1164_isnewuserrsp = new oidb_0x1164$IsNewUserRsp();
                    final boolean z17 = false;
                    if (bArr != null) {
                        try {
                            if (bArr.length > 0) {
                                oidb_0x1164_isnewuserrsp.mergeFrom(bArr);
                                z17 = oidb_0x1164_isnewuserrsp.is_new.get();
                            }
                        } catch (InvalidProtocolBufferMicroException unused) {
                            str2 = "decode pbData error";
                            com.tencent.mobileqq.qqguildsdk.util.h.v("[gpro_sdk]", "fetchIsNewUser", "decode pbData error");
                            i16 = -1;
                        }
                    }
                    com.tencent.mobileqq.qqguildsdk.util.h.u("sdkWrapper interface", true, "fetchIsNewUser", "resultCode=" + i16 + ", isNew=" + z17);
                    if (GPSNonGuildServiceImpl.this.mApp != null) {
                        MMKVOptionEntity from2 = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                        if (from2.isAccessible()) {
                            from2.encodeBool(this.f265064a, true).commitAsync();
                        }
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GPSNonGuildServiceImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            getClass();
                        }
                    });
                }
            });
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mApp = null;
    }
}
