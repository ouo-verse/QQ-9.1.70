package com.tencent.qqmini.proxyimpl;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy;
import com.tencent.qqmini.sdk.launcher.model.InnerFavoritesData;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@ProxyService(proxy = FavoritesProxy.class)
/* loaded from: classes34.dex */
public class FavoritesProxyImpl implements FavoritesProxy {

    /* renamed from: a, reason: collision with root package name */
    String f347352a = "arkAppInfo";

    /* renamed from: b, reason: collision with root package name */
    String f347353b = "appName";

    /* renamed from: c, reason: collision with root package name */
    String f347354c = QQCustomArkDialogUtil.APP_VIEW;

    /* renamed from: d, reason: collision with root package name */
    String f347355d = QQCustomArkDialogUtil.META_DATA;

    /* renamed from: e, reason: collision with root package name */
    String f347356e = QQCustomArkDialogUtil.APP_MIN_VERSION;

    /* renamed from: f, reason: collision with root package name */
    String f347357f = "appConfig";

    /* renamed from: g, reason: collision with root package name */
    String f347358g = "appDesc";

    /* renamed from: h, reason: collision with root package name */
    String f347359h = QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT;

    /* renamed from: i, reason: collision with root package name */
    String f347360i = MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT;

    public void a(InnerFavoritesData innerFavoritesData) {
        if (innerFavoritesData == null) {
            QLog.e("FavoritesProxyImpl", 1, "addFavorites: favoritesData == null");
            return;
        }
        try {
            b(innerFavoritesData);
        } catch (Throwable th5) {
            QLog.e("FavoritesProxyImpl", 1, "shareToFavorite: error: ", th5.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.FavoritesProxy
    public void onJsAddToFavorites(Object obj) {
        if (!(obj instanceof InnerFavoritesData)) {
            QLog.w("FavoritesProxyImpl", 1, "onJsAddToFavorites. Unknown type of data");
            return;
        }
        QLog.d("FavoritesProxyImpl", 1, "onJsAddToFavorites. data = " + obj);
        InnerFavoritesData innerFavoritesData = (InnerFavoritesData) obj;
        if (innerFavoritesData.action != 1) {
            return;
        }
        a(innerFavoritesData);
    }

    private void b(InnerFavoritesData innerFavoritesData) {
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                final QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                final String str = qQAppInterface.getApplication().getString(R.string.zxl) + innerFavoritesData.title;
                final String str2 = innerFavoritesData.entryPath;
                final String string = qQAppInterface.getApplication().getString(R.string.zxk);
                final String str3 = innerFavoritesData.summary;
                final String str4 = innerFavoritesData.picPath;
                JSONObject jSONObject = new JSONObject(innerFavoritesData.bizDataList);
                final ArrayList arrayList = new ArrayList();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(this.f347353b, jSONObject.optString("appName"));
                jSONObject2.put(this.f347354c, jSONObject.optString(QQCustomArkDialogUtil.APP_VIEW));
                jSONObject2.put(this.f347355d, jSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA).toString());
                jSONObject2.put(this.f347356e, jSONObject.optString(QQCustomArkDialogUtil.APP_MIN_VERSION));
                jSONObject2.put(this.f347357f, jSONObject.optJSONObject("appConfig").toString());
                jSONObject2.put(this.f347359h, jSONObject.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(this.f347352a, jSONObject2);
                arrayList.add(jSONObject3.toString().getBytes());
                final MessageRecord messageRecord = new MessageRecord();
                messageRecord.senderuin = qQAppInterface.getAccount();
                final Context applicationContext = runtime.getApplication().getApplicationContext();
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.FavoritesProxyImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str5 = str;
                        String str6 = str2;
                        String str7 = string;
                        String str8 = str3;
                        String str9 = str4;
                        QLog.d("FavoritesProxyImpl", 2, "addToQQFavorites done, res = " + QfavBuilder.Z(8, str5, str6, str7, str8, str9, str9, null, true, 0L).G("sBizDataList", arrayList).R(qQAppInterface, messageRecord).z(applicationContext));
                    }
                });
            } else {
                QLog.d("FavoritesProxyImpl", 1, "addToQQFavorites: failed runtime not instanceof QQAppInterface");
            }
        } catch (Throwable th5) {
            QLog.e("FavoritesProxyImpl", 1, "addToQQFavorites: failed ", th5);
        }
    }
}
