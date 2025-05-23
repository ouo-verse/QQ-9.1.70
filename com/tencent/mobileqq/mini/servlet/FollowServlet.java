package com.tencent.mobileqq.mini.servlet;

import NS_FOLLOW.Follow$StBatchGetFollowingCountRsp;
import NS_FOLLOW.Follow$StCountResult;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.Packet;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FollowServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID_LIST = "key_appid_list";
    public static final String KEY_RSP_FOLLOW_COUNT = "key_follow_count";
    private static final String TAG = "FollowServlet";

    public FollowServlet() {
        this.observerId = MiniAppObserver.MINI_APP_BATCH_GET_GAME_FOLLOW_COUNT;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3 A[Catch: Exception -> 0x00cf, TRY_LEAVE, TryCatch #0 {Exception -> 0x00cf, blocks: (B:3:0x000d, B:5:0x0016, B:7:0x001c, B:9:0x0042, B:10:0x0063, B:12:0x0069, B:14:0x0089, B:16:0x008f, B:17:0x00a9, B:19:0x00c3), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                if (stQWebRsp.retCode.get() == 0) {
                    Follow$StBatchGetFollowingCountRsp follow$StBatchGetFollowingCountRsp = new Follow$StBatchGetFollowingCountRsp();
                    follow$StBatchGetFollowingCountRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                    List<Follow$StCountResult> list = follow$StBatchGetFollowingCountRsp.followingCounts.get();
                    JSONObject jSONObject = new JSONObject();
                    for (Follow$StCountResult follow$StCountResult : list) {
                        jSONObject.put(follow$StCountResult.follower.get().replace(BatchGetFollowingCountRequest.APPID_SUFFIX, ""), follow$StCountResult.count.get());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "jsonObject=" + jSONObject.toString());
                    }
                    bundle.putString(KEY_RSP_FOLLOW_COUNT, jSONObject.toString());
                    notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
                    z16 = true;
                    if (z16) {
                        notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
                        return;
                    }
                    return;
                }
            }
            z16 = false;
            if (z16) {
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onReceive error!", e16);
            notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] encode = new BatchGetFollowingCountRequest(intent.getStringArrayListExtra("key_appid_list")).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(BatchGetFollowingCountRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
