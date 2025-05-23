package com.tencent.biz.qqcircle.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.broadcast.action.QCircleAuthorityAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleBaseBroadcastAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleClearRedPointAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleConfirmSchoolNameAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleJSRequestAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleMessagePushAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleRefreshIconDecorateAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleRefreshPushEffectAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleShowToastAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleSwitchChangeAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleUpdatePublishDeclaration;
import com.tencent.biz.qqcircle.broadcast.action.QCircleUpdateTagFollowAction;
import com.tencent.biz.qqcircle.broadcast.action.QCircleUpdateUserFollowAction;
import com.tencent.biz.qqcircle.broadcast.action.QFSPersonalReloadMainPageAction;
import com.tencent.biz.qqcircle.broadcast.action.QFSPersonalUserWearMedalUpdateAction;
import com.tencent.biz.qqcircle.broadcast.action.QFSSystemVolumeChangedAction;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGlobalBroadcastHelper {

    /* renamed from: c, reason: collision with root package name */
    private static volatile QFSGlobalBroadcastHelper f83135c;

    /* renamed from: a, reason: collision with root package name */
    private final QCircleGlobalBroadcastReceiver f83136a = new QCircleGlobalBroadcastReceiver();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, QCircleBaseBroadcastAction> f83137b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class QCircleGlobalBroadcastReceiver extends BroadcastReceiver {
        public QCircleGlobalBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            QCircleBaseBroadcastAction qCircleBaseBroadcastAction = (QCircleBaseBroadcastAction) QFSGlobalBroadcastHelper.this.f83137b.get(action);
            if (qCircleBaseBroadcastAction != null) {
                qCircleBaseBroadcastAction.onReceive(context, intent);
                return;
            }
            QLog.e("RHF-QFSGlobalBroadcastHelper", 1, "can't find action handler to handle action:" + action);
        }
    }

    protected QFSGlobalBroadcastHelper() {
        b(new QCircleClearRedPointAction());
        b(new QCircleUpdateUserFollowAction());
        b(new QCircleUpdateTagFollowAction());
        b(new QCircleMessagePushAction());
        b(new QCircleJSRequestAction());
        b(new QCircleAuthorityAction());
        b(new QCircleConfirmSchoolNameAction());
        b(new QCircleRefreshIconDecorateAction());
        b(new QCircleRefreshPushEffectAction());
        b(new QCircleSwitchChangeAction());
        b(new QCircleShowToastAction());
        b(new QFSPersonalReloadMainPageAction());
        b(new QFSPersonalUserWearMedalUpdateAction());
        b(new QFSSystemVolumeChangedAction());
        b(new QCircleUpdatePublishDeclaration());
    }

    public static QFSGlobalBroadcastHelper c() {
        if (f83135c == null) {
            synchronized (QFSGlobalBroadcastHelper.class) {
                if (f83135c == null) {
                    f83135c = new QFSGlobalBroadcastHelper();
                }
            }
        }
        return f83135c;
    }

    protected void b(QCircleBaseBroadcastAction qCircleBaseBroadcastAction) {
        this.f83137b.put(qCircleBaseBroadcastAction.a(), qCircleBaseBroadcastAction);
    }

    public void d() {
        try {
            QLog.d("RHF-QFSGlobalBroadcastHelper", 1, "init");
            IntentFilter intentFilter = new IntentFilter();
            for (String str : this.f83137b.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    intentFilter.addAction(str);
                } else {
                    throw new RuntimeException("can't add empty action");
                }
            }
            QCircleApplication.APP.registerReceiver(this.f83136a, intentFilter);
        } catch (Exception e16) {
            QLog.e("RHF-QFSGlobalBroadcastHelper", 1, "registerReceiver error", e16);
        }
    }

    public void e() {
        try {
            QCircleApplication.APP.unregisterReceiver(this.f83136a);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        f83135c = null;
    }
}
