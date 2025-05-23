package ox1;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProFetchGuildRobotDirectMsgSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.GProFetchGuildRobotDirectMsgSettingRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProSetGuildRobotDirectMsgSettingReq;
import com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotDirectMsgSettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback;
import vh2.cd;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i extends ef1.b {
    private final IGPSService C;
    private final String D;
    private final String E;
    private final MutableLiveData<Boolean> F = new MutableLiveData<>(Boolean.FALSE);
    private final MutableLiveData<Boolean> G = new MutableLiveData<>(Boolean.TRUE);
    private final MutableLiveData<Long> H = new MutableLiveData<>(0L);
    private final cn<cf1.b> I = new cn<>();

    public i(String str) {
        this.E = str;
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        this.C = iGPSService;
        this.D = iGPSService.getSelfTinyId();
        R1();
        S1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(int i3, String str, boolean z16) {
        this.F.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(int i3, String str, GProFetchGuildRobotDirectMsgSettingRsp gProFetchGuildRobotDirectMsgSettingRsp) {
        if (i3 == 0 && gProFetchGuildRobotDirectMsgSettingRsp != null) {
            this.H.postValue(Long.valueOf(gProFetchGuildRobotDirectMsgSettingRsp.getDailyPushMaxNum()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        if (!TextUtils.isEmpty(str)) {
            QLog.e("GuildRobot.MoreSettingViewModel", 1, "setDirectMsgBlack, errMsg=" + str);
            this.I.setValue(new cf1.b(i3, str, iGProSecurityResult));
            return;
        }
        if (Boolean.TRUE.equals(this.F.getValue())) {
            QLog.i("GuildRobot.MoreSettingViewModel", 1, "setDirectMsgBlack success, robotTid=" + this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(int i3, String str) {
        if (i3 != 0) {
            this.I.postValue(new cf1.b(i3, str));
        }
    }

    public void R1() {
        this.C.fetchDirectMsgBlack(this.E, new vh2.q() { // from class: ox1.f
            @Override // vh2.q
            public final void onResult(int i3, String str, boolean z16) {
                i.this.Z1(i3, str, z16);
            }
        });
    }

    public void S1() {
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        g16.fetchGuildRobotDirectMsgSetting(new GProFetchGuildRobotDirectMsgSettingReq(az.d(this.E, 0L), az.d(this.D, 0L)), new IGProFetchGuildRobotDirectMsgSettingCallback() { // from class: ox1.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProFetchGuildRobotDirectMsgSettingCallback
            public final void onFetchGuildRobotDirectMsgSetting(int i3, String str, GProFetchGuildRobotDirectMsgSettingRsp gProFetchGuildRobotDirectMsgSettingRsp) {
                i.this.a2(i3, str, gProFetchGuildRobotDirectMsgSettingRsp);
            }
        });
    }

    public MutableLiveData<Long> T1() {
        return this.H;
    }

    public MutableLiveData<Boolean> U1() {
        return this.F;
    }

    public cn<cf1.b> W1() {
        return this.I;
    }

    public String X1() {
        return this.E;
    }

    public void d2() {
        this.C.setDirectMsgBlack(this.E, Boolean.TRUE.equals(this.F.getValue()), new cd() { // from class: ox1.g
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                i.this.b2(i3, str, iGProSecurityResult);
            }
        });
    }

    public void e2() {
        long longValue;
        ac g16 = sx1.f.g();
        if (g16 == null) {
            return;
        }
        Long value = this.H.getValue();
        long d16 = az.d(this.E, 0L);
        long d17 = az.d(this.D, 0L);
        if (value == null) {
            longValue = 0;
        } else {
            longValue = value.longValue();
        }
        g16.setGuildRobotDirectMsgSetting(new GProSetGuildRobotDirectMsgSettingReq(d16, d17, longValue), new IGProRobotSimpleResultCallback() { // from class: ox1.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGProRobotSimpleResultCallback
            public final void onResult(int i3, String str) {
                i.this.c2(i3, str);
            }
        });
    }
}
