package com.tencent.mobileqq.gamecenter.qa.jumpaction;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameMainQAJumpAction extends ax {
    /* JADX INFO: Access modifiers changed from: protected */
    public GameMainQAJumpAction(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    private void F() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.jumpaction.GameMainQAJumpAction.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                long j3;
                String str;
                String str2;
                int i16;
                try {
                    int i17 = 0;
                    if (GameMainQAJumpAction.this.f307441f.containsKey("appId")) {
                        i3 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("appId"));
                    } else {
                        i3 = 0;
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey("questionId")) {
                        j3 = Long.parseLong(GameMainQAJumpAction.this.f307441f.get("questionId"));
                    } else {
                        j3 = 0;
                    }
                    long j16 = j3;
                    String str3 = "";
                    if (!GameMainQAJumpAction.this.f307441f.containsKey("data")) {
                        str = "";
                    } else {
                        str = GameMainQAJumpAction.this.f307441f.get("data");
                    }
                    if (!GameMainQAJumpAction.this.f307441f.containsKey("questionTitle")) {
                        str2 = "";
                    } else {
                        str2 = GameMainQAJumpAction.this.f307441f.get("questionTitle");
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey(WadlProxyConsts.KEY_JUMP_URL)) {
                        str3 = GameMainQAJumpAction.this.f307441f.get(WadlProxyConsts.KEY_JUMP_URL);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        str3 = URLDecoder.decode(str3, "UTF-8");
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey("scene")) {
                        i16 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("scene"));
                    } else {
                        i16 = 0;
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey("miniGameAppId")) {
                        i17 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("miniGameAppId"));
                    }
                    ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyAnswer(GameMainQAJumpAction.this.f307437b, i3, j16, str2, str3, str, i16, i17);
                    QLog.i("GameMainQAJumpAction", 1, "[openAnswerPage] appId:" + i3 + ",jumpUrl:" + str3 + ",data:" + str + " scene:" + i16);
                } catch (Exception e16) {
                    QLog.e("GameMainQAJumpAction", 1, "openAnswerPage e:", e16);
                }
            }
        });
    }

    private void G() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.jumpaction.GameMainQAJumpAction.3
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String str;
                try {
                    int i16 = 0;
                    if (GameMainQAJumpAction.this.f307441f.containsKey("appid")) {
                        i3 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("appid"));
                    } else {
                        i3 = 0;
                    }
                    String str2 = "";
                    if (!GameMainQAJumpAction.this.f307441f.containsKey("question_title")) {
                        str = "";
                    } else {
                        str = GameMainQAJumpAction.this.f307441f.get("question_title");
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey("jump_url")) {
                        str2 = GameMainQAJumpAction.this.f307441f.get("jump_url");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = URLDecoder.decode(str2, "UTF-8");
                    }
                    String str3 = str2;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("question_title", str);
                    if (GameMainQAJumpAction.this.f307441f.containsKey("miniGameAppId")) {
                        i16 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("miniGameAppId"));
                    }
                    ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyQuestion(GameMainQAJumpAction.this.f307437b, i3, str3, jSONObject.toString(), 0, i16);
                    QLog.i("GameMainQAJumpAction", 1, "[openGameStrategyQuestion] appId:" + i3 + ",jumpUrl:" + str3 + ",data:" + jSONObject);
                } catch (Exception e16) {
                    QLog.e("GameMainQAJumpAction", 1, "openGameStrategyQuestion e:", e16);
                }
            }
        });
    }

    private void H() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.jumpaction.GameMainQAJumpAction.2
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String str;
                int i16;
                try {
                    int i17 = 0;
                    if (GameMainQAJumpAction.this.f307441f.containsKey("appId")) {
                        i3 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("appId"));
                    } else {
                        i3 = 0;
                    }
                    String str2 = "";
                    if (!GameMainQAJumpAction.this.f307441f.containsKey("data")) {
                        str = "";
                    } else {
                        str = GameMainQAJumpAction.this.f307441f.get("data");
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey(WadlProxyConsts.KEY_JUMP_URL)) {
                        str2 = GameMainQAJumpAction.this.f307441f.get(WadlProxyConsts.KEY_JUMP_URL);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = URLDecoder.decode(str2, "UTF-8");
                    }
                    String str3 = str2;
                    if (GameMainQAJumpAction.this.f307441f.containsKey("scene")) {
                        i16 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("scene"));
                    } else {
                        i16 = 0;
                    }
                    if (GameMainQAJumpAction.this.f307441f.containsKey("miniGameAppId")) {
                        i17 = Integer.parseInt(GameMainQAJumpAction.this.f307441f.get("miniGameAppId"));
                    }
                    ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyQuestion(GameMainQAJumpAction.this.f307437b, i3, str3, str, i16, i17);
                    QLog.i("GameMainQAJumpAction", 1, "[openQuestionPage] appId:" + i3 + ",jumpUrl:" + str3 + ",data:" + str + " scene:" + i16);
                } catch (Exception e16) {
                    QLog.e("GameMainQAJumpAction", 1, "openQuestionPage e:", e16);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        QLog.i("GameMainQAJumpAction", 1, "doAction: action=" + this.f307440e);
        if ("newquestion".equals(this.f307440e)) {
            G();
        } else if ("openStrategyQuestion".equals(this.f307440e)) {
            H();
        } else if ("openStrategyAnswer".equals(this.f307440e)) {
            F();
        }
        return true;
    }
}
