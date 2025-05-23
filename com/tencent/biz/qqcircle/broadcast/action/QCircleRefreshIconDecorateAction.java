package com.tencent.biz.qqcircle.broadcast.action;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.events.QCircleRefreshIconDecorateEvent;
import com.tencent.biz.qqcircle.manager.QCircleAvatarDecorateManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StIconDecorate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleRefreshIconDecorateAction extends QCircleBaseBroadcastAction {
    @Override // com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction
    public String a() {
        return "action_refresh_icon_decorate";
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(ark.ARKMETADATA_JSON);
        QLog.d("QCircleRefreshIconDecorateAction", 1, "QCircleRefreshIconDecorate jsonConfig is " + stringExtra);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            FeedCloudMeta$StIconDecorate feedCloudMeta$StIconDecorate = new FeedCloudMeta$StIconDecorate();
            feedCloudMeta$StIconDecorate.mainpageUrl.set((String) jSONObject.get("mainpageUrl"));
            feedCloudMeta$StIconDecorate.layerUrl.set((String) jSONObject.get("layerUrl"));
            feedCloudMeta$StIconDecorate.comment_url.set((String) jSONObject.get("commentUrl"));
            feedCloudMeta$StIconDecorate.endTime.set(Long.parseLong("" + jSONObject.get("endTime")));
            QCircleAvatarDecorateManager.INSTANCE.setOwnerAvatarDecorateInfo(feedCloudMeta$StIconDecorate);
            QCircleHostGlobalInfo.updateIconDecorate(feedCloudMeta$StIconDecorate);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleRefreshIconDecorateEvent());
        } catch (Exception e16) {
            QLog.e("QCircleRefreshIconDecorateAction", 1, "QCircleRefreshIconDecorate jsonConfig error " + e16);
        }
    }
}
