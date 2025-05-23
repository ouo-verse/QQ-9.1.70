package jv;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.av.utils.ar;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Ljv/c;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "a", "actionInfo", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class c implements com.tencent.qqnt.graytips.handler.b {
    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public com.tencent.qqnt.graytips.action.f a(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        int optInt = jsonObject.optInt(IPublicAccountBrowser.KEY_UIN_TYPE);
        String optString = jsonObject.optString("uin");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_UIN)");
        String optString2 = jsonObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY_URL)");
        return new a(optInt, optString, optString2, jsonObject.optInt("effect_time"), jsonObject.optLong(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME));
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public JSONObject b(@NotNull com.tencent.qqnt.graytips.action.f actionInfo) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        JSONObject jSONObject = new JSONObject();
        a aVar = (a) actionInfo;
        jSONObject.put(IPublicAccountBrowser.KEY_UIN_TYPE, aVar.getUinType());
        jSONObject.put("uin", aVar.getUin());
        jSONObject.put("url", aVar.getUrl());
        jSONObject.put("effect_time", aVar.getEffectTime());
        jSONObject.put(ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, aVar.getMessageTime());
        return jSONObject;
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(@NotNull AppRuntime app, @NotNull Context context, @NotNull com.tencent.qqnt.graytips.action.f actionInfo, @Nullable gv3.a aioAbility) {
        boolean z16;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        a aVar = (a) actionInfo;
        if (QLog.isDebugVersion()) {
            QLog.d("QavImproveCallQualityHandler", 4, "handleOnClick, uinType=" + aVar.getUinType() + ", uin=" + aVar.getUin() + ", url=" + aVar.getUrl() + ", effectTime=" + aVar.getEffectTime() + ", messageTime=" + aVar.getMessageTime());
        }
        int i3 = 1;
        if ((System.currentTimeMillis() / 1000) - aVar.getMessageTime() > aVar.getEffectTime() * 60 * 60) {
            z16 = true;
        } else {
            z16 = false;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        if (z16) {
            DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, qBaseActivity.getString(R.string.f17823364), "", "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: jv.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    c.e(dialogInterface, i16);
                }
            }, (DialogInterface.OnClickListener) null).show();
            return;
        }
        Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", aVar.getUrl());
        intent.putExtra("show_right_close_button", true);
        intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
        qBaseActivity.startActivity(intent);
        if (aVar.getUinType() != 0) {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C2CF", "0X800C2CF", i3, 0, "", "", ar.d(aVar.getUrl()), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(DialogInterface dialogInterface, int i3) {
    }
}
