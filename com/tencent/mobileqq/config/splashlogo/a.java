package com.tencent.mobileqq.config.splashlogo;

import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.biz.qqstory.model.h;
import com.tencent.biz.qqstory.model.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import xc0.c;
import xc0.d;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends MSFServlet {

    /* renamed from: d, reason: collision with root package name */
    public static int[][] f202940d = {new int[]{R.integer.f167218z, -128}, new int[]{R.integer.f167219a0, -150}, new int[]{R.integer.f167215v, -151}};

    /* renamed from: e, reason: collision with root package name */
    public static SparseIntArray f202941e = new SparseIntArray(f202940d.length);

    static {
        for (int[] iArr : f202940d) {
            int i3 = iArr[0];
            int i16 = iArr[1];
            if (i3 != -1) {
                f202941e.put(c.b(i3), i16);
            } else {
                f202941e.put(i16, i16);
            }
        }
    }

    private void a(QQAppInterface qQAppInterface, Intent intent, Packet packet) {
        int P1;
        ConfigurationService$ReqGetConfig configurationService$ReqGetConfig = new ConfigurationService$ReqGetConfig();
        String stringExtra = intent.getStringExtra("key_uin");
        int size = f202941e.size();
        ArrayList arrayList = new ArrayList(size);
        boolean o26 = ea.o2(qQAppInterface.getApp(), "Q.qqstory.config.QQStoryConfigServlet");
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = f202941e.keyAt(i3);
            String k3 = h.k(f202941e.valueAt(i3));
            ConfigurationService$ConfigSeq configurationService$ConfigSeq = new ConfigurationService$ConfigSeq();
            configurationService$ConfigSeq.type.set(keyAt);
            if (o26) {
                ea.w2(qQAppInterface.getApp(), k3, stringExtra);
                P1 = 0;
            } else {
                P1 = ea.P1(qQAppInterface.getApp(), k3, stringExtra);
            }
            configurationService$ConfigSeq.version.set(P1);
            arrayList.add(configurationService$ConfigSeq);
            arrayList2.add(Integer.valueOf(keyAt));
            if (QLog.isColorLevel()) {
                QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, "addAllConfigs|send type: " + keyAt, " version: ", Integer.valueOf(P1));
            }
        }
        if (o26) {
            ea.u2(qQAppInterface.getApp(), "Q.qqstory.config.QQStoryConfigServlet");
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, "addAllConfigs|send length: " + arrayList2.size());
        }
        configurationService$ReqGetConfig.setHasFlag(true);
        configurationService$ReqGetConfig.seq_list.addAll(arrayList);
        SosoLbsInfo sosoInfo = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
        hd0.c.a("Q.qqstory.config.QQStoryConfigServlet", "addAllConfigs");
        if (sosoInfo == null) {
            hd0.c.a("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo is null.");
        } else {
            SosoLocation sosoLocation = sosoInfo.mLocation;
            if (sosoLocation == null) {
                hd0.c.a("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo.location is null.");
            } else if (TextUtils.isEmpty(sosoLocation.cityCode)) {
                hd0.c.a("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo.location.cityCode is null");
            } else {
                hd0.c.b("Q.qqstory.config.QQStoryConfigServlet", "adcode:%s", sosoInfo.mLocation.cityCode);
                configurationService$ReqGetConfig.adcode.set(Long.valueOf(sosoInfo.mLocation.cityCode).longValue());
            }
        }
        byte[] c16 = c(configurationService$ReqGetConfig);
        if (c16 != null && c16.length > 0) {
            packet.putSendData(c16);
        }
        packet.setSSOCommand(BaseConstants.CMD_REQUEST_CONFIG);
    }

    public static void b(QQAppInterface qQAppInterface, String str) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), a.class);
        newIntent.putExtra("key_uin", str);
        newIntent.putExtra("k_req_occasion", 0);
        qQAppInterface.startServlet(newIntent);
    }

    public static byte[] c(ConfigurationService$ReqGetConfig configurationService$ReqGetConfig) {
        byte[] byteArray = configurationService$ReqGetConfig.toByteArray();
        long length = byteArray.length;
        int i3 = (int) length;
        byte[] bArr = new byte[i3 + 4];
        PkgTools.dWord2Byte(bArr, 0, length + 4);
        PkgTools.copyData(bArr, 4, byteArray, i3);
        return bArr;
    }

    public static byte[] d(byte[] bArr) {
        int length = bArr.length - 4;
        byte[] bArr2 = new byte[length];
        PkgTools.copyData(bArr2, 0, bArr, 4, length);
        return bArr2;
    }

    private void e(ConfigurationService$RespGetConfig configurationService$RespGetConfig, QQAppInterface qQAppInterface, Intent intent, boolean z16) {
        PBRepeatMessageField<ConfigurationService$Config> pBRepeatMessageField;
        ArrayList arrayList;
        long j3;
        ConfigurationService$RespGetConfig configurationService$RespGetConfig2 = configurationService$RespGetConfig;
        if (z16 && configurationService$RespGetConfig2.result.get() == 0 && (pBRepeatMessageField = configurationService$RespGetConfig2.config_list) != null && pBRepeatMessageField.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            int size = configurationService$RespGetConfig2.config_list.size();
            ArrayList arrayList2 = new ArrayList(f202941e.size());
            for (int i3 = 0; i3 < f202941e.size(); i3++) {
                arrayList2.add(Integer.valueOf(f202941e.keyAt(i3)));
            }
            h hVar = (h) i.c(10);
            int i16 = 0;
            while (i16 < size) {
                ConfigurationService$Config configurationService$Config = configurationService$RespGetConfig2.config_list.get(i16);
                if (configurationService$Config == null || !configurationService$Config.type.has()) {
                    j3 = currentTimeMillis;
                    arrayList = arrayList2;
                } else {
                    int i17 = configurationService$Config.type.get();
                    arrayList2.remove(Integer.valueOf(i17));
                    int i18 = f202941e.get(i17, i17);
                    hd0.c.d("Q.qqstory.config.QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(size));
                    String stringExtra = intent.getStringExtra("key_uin");
                    String k3 = h.k(i18);
                    int P1 = ea.P1(qQAppInterface.getApp(), k3, stringExtra);
                    String k16 = ConfigServlet.k(configurationService$Config, P1, i18);
                    arrayList = arrayList2;
                    if (configurationService$Config.content_list.size() > 0) {
                        j3 = currentTimeMillis;
                        hd0.c.c("Q.qqstory.config.QQStoryConfigServlet", "%d --> %s", Integer.valueOf(i18), configurationService$Config.content_list.get(0));
                    } else {
                        j3 = currentTimeMillis;
                    }
                    hd0.c.c("Q.qqstory.config.QQStoryConfigServlet", "%d ---> %s", Integer.valueOf(i18), k16);
                    boolean l3 = hVar.l(i18, intent, configurationService$Config);
                    if (l3) {
                        ea.l5(qQAppInterface.getApp(), k3, stringExtra, configurationService$Config.version.get());
                    }
                    hd0.c.f("Q.qqstory.config.QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d, localVersion:%d, newVersion: %d, handled: %b", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(size), Integer.valueOf(P1), Integer.valueOf(configurationService$Config.version.get()), Boolean.valueOf(l3));
                }
                i16++;
                configurationService$RespGetConfig2 = configurationService$RespGetConfig;
                arrayList2 = arrayList;
                currentTimeMillis = j3;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isColorLevel()) {
                QLog.w("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|executeSpendTime: " + currentTimeMillis2);
                return;
            }
            return;
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|isSuccess == false");
            }
        } else if (configurationService$RespGetConfig.result.get() != 0) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|resultCode != 0");
            }
        } else {
            PBRepeatMessageField<ConfigurationService$Config> pBRepeatMessageField2 = configurationService$RespGetConfig.config_list;
            if ((pBRepeatMessageField2 == null || pBRepeatMessageField2.size() == 0) && QLog.isColorLevel()) {
                QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|config_list empty data");
            }
        }
        for (int i19 = 0; i19 < f202941e.size(); i19++) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|failed type: " + f202941e.keyAt(i19));
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (f202941e.size() == 0) {
            d.a(this, intent, false);
            return;
        }
        if (QLog.isColorLevel()) {
            int size = f202941e.size();
            for (int i3 = 0; i3 < f202941e.size(); i3++) {
                QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "onReceive|shouldReceive cmd: " + f202941e.keyAt(i3) + ",length: " + size);
            }
        }
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer != null && wupBuffer.length >= 4) {
            fromServiceMsg.putWupBuffer(d(wupBuffer));
            ConfigurationService$RespGetConfig configurationService$RespGetConfig = new ConfigurationService$RespGetConfig();
            try {
                configurationService$RespGetConfig.mergeFrom(fromServiceMsg.getWupBuffer());
                try {
                    e(configurationService$RespGetConfig, qQAppInterface, intent, isSuccess);
                } catch (Exception unused) {
                }
                d.a(this, intent, true);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, "error: " + e16.toString());
                }
                e16.printStackTrace();
                d.a(this, intent, false);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, "wup buf is null!!!");
        }
        d.a(this, intent, false);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        if (f202941e.size() == 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            int size = f202941e.size();
            for (int i3 = 0; i3 < f202941e.size(); i3++) {
                QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "onSend. cmd: " + f202941e.keyAt(i3) + ",length: " + size);
            }
        }
        a(qQAppInterface, intent, packet);
    }
}
