package com.tencent.mobileqq.gamecenter.qa.jumpaction;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c extends ax {
    /* JADX INFO: Access modifiers changed from: protected */
    public c(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        Context context = this.f307437b;
        if (context instanceof QBaseActivity) {
            try {
                ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).answerQuestion((QBaseActivity) context, this.f307441f.containsKey("appid") ? Integer.parseInt(this.f307441f.get("appid")) : 0, this.f307441f.containsKey("questionid") ? Long.parseLong(this.f307441f.get("questionid")) : 0L, this.f307441f.get("questiontitle"));
                return;
            } catch (Exception e16) {
                QLog.e("GameQAJumpAction", 1, "parseStrategyAnswer e:", e16);
                return;
            }
        }
        QLog.e("GameQAJumpAction", 1, "parseStrategyAnswer error no chat activity");
    }

    private void H() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.jumpaction.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.G();
            }
        });
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        QLog.i("GameQAJumpAction", 1, "doAction: action=" + this.f307440e);
        if ("openanswer".equals(this.f307440e)) {
            H();
        }
        return true;
    }
}
