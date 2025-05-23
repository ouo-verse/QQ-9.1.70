package com.tencent.mobileqq.mini.push;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.minigame.data.SparkIncomeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.minigame.oidb_proxy.s2c_content.s2cContent$Content;
import com.tencent.trpcprotocol.minigame.oidb_proxy.s2c_content.s2cContent$SparkRewardNotify;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes33.dex */
public class MiniAppPushHandler extends BusinessHandler {
    private static final String TAG = "MiniAppPushHandler";
    private Set<String> pushCommandList;

    public MiniAppPushHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private MsgType0x210 decodeMsgType0x210(byte[] bArr) {
        try {
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf-8");
            MsgType0x210 msgType0x210 = new MsgType0x210();
            msgType0x210.readFrom(jceInputStream);
            return msgType0x210;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "decodeMsgType0x210: failed.", e16);
            return null;
        }
    }

    private void dispatchPushEvent(s2cContent$Content s2ccontent_content) {
        if (s2ccontent_content.type.get() == 1) {
            sendSparkRewardReceiver(s2ccontent_content);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x001a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleOnlinePush(Object obj) {
        MsgType0x210 decodeMsgType0x210;
        s2cContent$Content s2ccontent_content;
        if (obj instanceof SvcReqPushMsg) {
            ArrayList<MsgInfo> arrayList = ((SvcReqPushMsg) obj).vMsgInfos;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (MsgInfo msgInfo : arrayList) {
                    if (msgInfo.shMsgType == 528 && (decodeMsgType0x210 = decodeMsgType0x210(msgInfo.vMsg)) != null) {
                        s2cContent$Content s2ccontent_content2 = null;
                        try {
                            s2ccontent_content = new s2cContent$Content();
                            try {
                                s2ccontent_content.mergeFrom(decodeMsgType0x210.vProtobuf);
                            } catch (Exception e16) {
                                e = e16;
                                s2ccontent_content2 = s2ccontent_content;
                                QLog.e(TAG, 1, "handleOnlinePush: parse Content exception.", e);
                                s2ccontent_content = s2ccontent_content2;
                                if (s2ccontent_content == null) {
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                        }
                        if (s2ccontent_content == null) {
                            dispatchPushEvent(s2ccontent_content);
                        }
                    }
                }
                return;
            }
            QLog.e(TAG, 1, "handleOnlinePush: msgInfo is null.");
        }
    }

    private void sendSparkRewardReceiver(s2cContent$Content s2ccontent_content) {
        s2cContent$SparkRewardNotify s2ccontent_sparkrewardnotify = s2ccontent_content.spark_reward_notify.get();
        int i3 = s2ccontent_sparkrewardnotify.type.get();
        String str = s2ccontent_sparkrewardnotify.appid.get();
        String str2 = s2ccontent_sparkrewardnotify.title.get();
        String str3 = s2ccontent_sparkrewardnotify.sub_title.get();
        String str4 = s2ccontent_sparkrewardnotify.icon_url.get();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i3 != 0) {
            SparkIncomeInfo sparkIncomeInfo = new SparkIncomeInfo();
            sparkIncomeInfo.setType(i3);
            sparkIncomeInfo.setAppId(str);
            sparkIncomeInfo.setTitle(str2);
            sparkIncomeInfo.setSubTitle(str3);
            sparkIncomeInfo.setIconUrl(str4);
            Intent intent = new Intent(MiniConst.Spark.RECEIVER_SPARK_REWARD);
            intent.putExtra(MiniConst.Spark.KEY_SPARK_REWARD_INFO, sparkIncomeInfo);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        QLog.e(TAG, 1, "sendSparkRewardReceiver: param invalid. appId=" + str + ";title=" + str2 + ";type=" + i3);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getPushCommandList() {
        if (this.pushCommandList == null) {
            HashSet hashSet = new HashSet();
            this.pushCommandList = hashSet;
            hashSet.add(MiniConst.Spark.CMD_PUSH_SPARK_REWARD);
        }
        return this.pushCommandList;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg == null) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        QLog.d(TAG, 4, "onReceive: cmd=" + serviceCmd);
        if (MiniConst.Spark.CMD_PUSH_SPARK_REWARD.equals(serviceCmd)) {
            handleOnlinePush(obj);
        }
    }
}
