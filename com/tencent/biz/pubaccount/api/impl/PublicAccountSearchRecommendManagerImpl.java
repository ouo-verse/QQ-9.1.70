package com.tencent.biz.pubaccount.api.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.ac.ArticleComment$GetRecommendPubAccountRequest;
import tencent.im.oidb.ac.ArticleComment$GetRecommendPubAccountResponse;
import tencent.im.oidb.ac.ArticleComment$Record;

/* loaded from: classes32.dex */
public class PublicAccountSearchRecommendManagerImpl implements IPublicAccountSearchRecommendManager {
    public static final String SSO_COMMAND_GET_RECOMMEND_PUBACCOUNT = "PubAccountArticleCenter.GetRecommendPubAccount";
    private long mRecommendCacheTime;
    private long mRecommendFetchTime;
    private String mRecommendTitle;
    private final String TAG = PublicAccountSearchRecommendManagerImpl.class.getSimpleName();
    private final String KEY_RECOMMEND_TITLE = "recommend_title";
    private final String KEY_RECOMMEND_CACHE_TIME = "recommend_cache_time";
    private final String KEY_RECOMMEND_FETCH_TIME = "recommend_fetch_time";
    private final String KEY_RECOMMEND_CONTENT_LIST = "recommend_content_list";
    private final String KEY_RECOMMEND_IS_FORBIDDEN = "recommend_is_forbidden";
    private final String KEY_SEARCH_HISTORY_LIST = "search_history_list";
    private boolean mInited = false;
    private final int MAX_RECOMMEND_COUNT = 8;
    private final long RECOMMEND_CACHE_TIME_OUT = 86400000;
    private final long RECOMMEND_FETCH_TIME_OUT = 3600000;
    private final long HISTORY_CACHE_TIME_OUT = 2592000000L;
    private boolean mRecommendIsForbidden = false;
    private ArrayList<IPublicAccountSearchRecommendManager.c> mPublicAccountSearchRecommendList = new ArrayList<>();
    private ArrayList<IPublicAccountSearchRecommendManager.b> mPublicAccountSearchHistoryList = new ArrayList<>();
    private HashMap<String, IPublicAccountSearchRecommendManager.b> mPublicAccountSearchHistoryMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewIntent f79523d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppInterface f79524e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IPublicAccountSearchRecommendManager.a f79525f;

        a(NewIntent newIntent, AppInterface appInterface, IPublicAccountSearchRecommendManager.a aVar) {
            this.f79523d = newIntent;
            this.f79524e = appInterface;
            this.f79525f = aVar;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            this.f79523d.setObserver(null);
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse failed!");
                }
                PublicAccountSearchRecommendManagerImpl.this.getRecommendListFromLocal(this.f79524e, this.f79525f);
                return;
            }
            try {
                ArticleComment$GetRecommendPubAccountResponse articleComment$GetRecommendPubAccountResponse = new ArticleComment$GetRecommendPubAccountResponse();
                articleComment$GetRecommendPubAccountResponse.mergeFrom(bundle.getByteArray("data"));
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse->retCode:" + articleComment$GetRecommendPubAccountResponse.ret.ret_code.get() + ", title:" + articleComment$GetRecommendPubAccountResponse.recom_title.get() + ", listSize:" + articleComment$GetRecommendPubAccountResponse.recom_list.get().size());
                }
                if (!articleComment$GetRecommendPubAccountResponse.ret.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse failed!(no ret)");
                    }
                    PublicAccountSearchRecommendManagerImpl.this.getRecommendListFromLocal(this.f79524e, this.f79525f);
                    return;
                }
                int i16 = articleComment$GetRecommendPubAccountResponse.ret.ret_code.get();
                if (i16 != -1) {
                    PublicAccountSearchRecommendManagerImpl.this.mRecommendIsForbidden = false;
                    if (articleComment$GetRecommendPubAccountResponse.recom_title.has()) {
                        str = articleComment$GetRecommendPubAccountResponse.recom_title.get().toStringUtf8();
                    } else {
                        str = "";
                    }
                    if (i16 == 0 && !TextUtils.isEmpty(str) && articleComment$GetRecommendPubAccountResponse.recom_list.has() && articleComment$GetRecommendPubAccountResponse.recom_list.get().size() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse update cache!");
                        }
                        PublicAccountSearchRecommendManagerImpl.this.mRecommendTitle = str;
                        PublicAccountSearchRecommendManagerImpl.this.mPublicAccountSearchRecommendList.clear();
                        for (ArticleComment$Record articleComment$Record : articleComment$GetRecommendPubAccountResponse.recom_list.get()) {
                            PublicAccountSearchRecommendManagerImpl.this.mPublicAccountSearchRecommendList.add(new IPublicAccountSearchRecommendManager.c(articleComment$Record.puin.get().toStringUtf8(), articleComment$Record.name.get().toStringUtf8(), true));
                        }
                        PublicAccountSearchRecommendManagerImpl.this.mRecommendCacheTime = NetConnInfoCenter.getServerTimeMillis();
                        PublicAccountSearchRecommendManagerImpl.this.saveRecommendListToLocal(this.f79524e);
                    }
                    PublicAccountSearchRecommendManagerImpl.this.getRecommendListFromLocal(this.f79524e, this.f79525f);
                    if (QLog.isColorLevel()) {
                        QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse update UI->title:" + PublicAccountSearchRecommendManagerImpl.this.mRecommendTitle + ", cacheTime:" + PublicAccountSearchRecommendManagerImpl.this.mRecommendCacheTime + ", isFobidden:" + PublicAccountSearchRecommendManagerImpl.this.mRecommendIsForbidden + ", recommendSize:" + PublicAccountSearchRecommendManagerImpl.this.mPublicAccountSearchRecommendList.size());
                        Iterator it = PublicAccountSearchRecommendManagerImpl.this.mPublicAccountSearchRecommendList.iterator();
                        while (it.hasNext()) {
                            QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, ((IPublicAccountSearchRecommendManager.c) it.next()).toString());
                        }
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse forbidden!");
                }
                PublicAccountSearchRecommendManagerImpl.this.mRecommendIsForbidden = true;
                this.f79525f.a(new ArrayList<>(), null, true);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "OnReceiveGetRecommendPubAccountResponse exception:" + e16);
                }
                PublicAccountSearchRecommendManagerImpl.this.getRecommendListFromLocal(this.f79524e, this.f79525f);
            }
        }
    }

    private boolean checkRecommendCacheValid(AppInterface appInterface) {
        if (!this.mInited) {
            initFromLocalData(appInterface);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        int size = this.mPublicAccountSearchRecommendList.size();
        boolean z16 = serverTimeMillis - this.mRecommendCacheTime < 86400000 && size > 0;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "checkRecommendCacheValid->now:" + serverTimeMillis + ", cacheTime:" + this.mRecommendCacheTime + ", size:" + size + ", result:" + z16);
        }
        return z16;
    }

    private boolean checkShouldFetchData(AppInterface appInterface) {
        if (!this.mInited) {
            initFromLocalData(appInterface);
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        boolean z16 = serverTimeMillis - this.mRecommendFetchTime > 3600000;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "checkShouldFetchData->now:" + serverTimeMillis + ", fetchTime:" + this.mRecommendFetchTime + ", result:" + z16);
        }
        return z16;
    }

    private ArrayList<IPublicAccountSearchRecommendManager.c> getListFromHistory(AppInterface appInterface) {
        if (!this.mInited) {
            initFromLocalData(appInterface);
        }
        ArrayList<IPublicAccountSearchRecommendManager.c> arrayList = new ArrayList<>();
        Iterator<IPublicAccountSearchRecommendManager.b> it = this.mPublicAccountSearchHistoryList.iterator();
        while (it.hasNext()) {
            IPublicAccountSearchRecommendManager.b next = it.next();
            arrayList.add(new IPublicAccountSearchRecommendManager.c(next.f79358a, next.f79359b, next.f79360c));
        }
        return arrayList;
    }

    private ArrayList<IPublicAccountSearchRecommendManager.c> getListFromRecommend() {
        if (this.mPublicAccountSearchRecommendList.size() <= 8) {
            return (ArrayList) this.mPublicAccountSearchRecommendList.clone();
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 8; i3++) {
            arrayList.add(this.mPublicAccountSearchRecommendList.get(i3));
        }
        return (ArrayList) arrayList.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecommendListFromLocal(AppInterface appInterface, IPublicAccountSearchRecommendManager.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "getRecommendListFromLocal->mRecommendIsForbidden:" + this.mRecommendIsForbidden);
        }
        if (this.mRecommendIsForbidden) {
            aVar.a(new ArrayList<>(), null, true);
            return;
        }
        if (checkRecommendCacheValid(appInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getRecommendListFromLocal->\u4f7f\u7528\u63a8\u8350\u5185\u5bb9\u7f13\u5b58!");
            }
            aVar.a(getListFromRecommend(), this.mRecommendTitle, true);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getRecommendListFromLocal->\u4f7f\u7528\u641c\u7d22\u5386\u53f2!");
            }
            aVar.a(getListFromHistory(appInterface), null, false);
        }
    }

    private void loadHistoryListFromLocal(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("public_account_search_history", null);
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "loadHistoryListFromLocal->json:" + string);
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(string);
                if (parseString2Json != null) {
                    JSONArray jSONArray = parseString2Json.getJSONArray("search_history_list");
                    this.mPublicAccountSearchHistoryList.clear();
                    this.mPublicAccountSearchHistoryMap.clear();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                        IPublicAccountSearchRecommendManager.b bVar = new IPublicAccountSearchRecommendManager.b(jSONObject.optString("uin"), jSONObject.optString("name"), jSONObject.optLong("time"), jSONObject.optBoolean("isPA", true));
                        this.mPublicAccountSearchHistoryList.add(bVar);
                        this.mPublicAccountSearchHistoryMap.put(bVar.f79358a, bVar);
                    }
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "loadHistoryListFromLocal->error:" + e16);
                }
            }
        }
    }

    private void loadRecommendListFromLocal(AppInterface appInterface) {
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("public_account_search_recommend", null);
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "loadRecommendListFromLocal->json:" + string);
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject parseString2Json = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).parseString2Json(string);
                if (parseString2Json != null) {
                    this.mRecommendTitle = parseString2Json.getString("recommend_title");
                    this.mRecommendCacheTime = parseString2Json.getLong("recommend_cache_time");
                    this.mRecommendFetchTime = parseString2Json.getLong("recommend_fetch_time");
                    this.mRecommendIsForbidden = parseString2Json.getBoolean("recommend_is_forbidden");
                    JSONArray jSONArray = parseString2Json.getJSONArray("recommend_content_list");
                    this.mPublicAccountSearchRecommendList.clear();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                        this.mPublicAccountSearchRecommendList.add(new IPublicAccountSearchRecommendManager.c(jSONObject.optString("uin"), jSONObject.optString("name"), jSONObject.optBoolean("isPA", true)));
                    }
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "loadRecommendListFromLocal->error:" + e16);
                }
            }
        }
    }

    private void saveHistoryListToLocal(final AppInterface appInterface) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountSearchRecommendManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
                if (sharedPreferences != null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = PublicAccountSearchRecommendManagerImpl.this.mPublicAccountSearchHistoryList.iterator();
                        while (it.hasNext()) {
                            IPublicAccountSearchRecommendManager.b bVar = (IPublicAccountSearchRecommendManager.b) it.next();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("uin", bVar.f79358a);
                            jSONObject.put("name", bVar.f79359b);
                            jSONObject.put("time", bVar.f79361d);
                            jSONObject.put("isPA", bVar.f79360c);
                            jSONArray.mo162put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("search_history_list", jSONArray);
                        String jSONObject3 = jSONObject2.toString();
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "saveHistoryListToLocal->json:" + jSONObject3);
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("public_account_search_history", jSONObject3);
                        edit.commit();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "saveHistoryListToLocal->error:" + e16);
                        }
                        e16.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveRecommendListToLocal(final AppInterface appInterface) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountSearchRecommendManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + appInterface.getCurrentAccountUin(), 0);
                if (sharedPreferences != null) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = PublicAccountSearchRecommendManagerImpl.this.mPublicAccountSearchRecommendList.iterator();
                        while (it.hasNext()) {
                            IPublicAccountSearchRecommendManager.c cVar = (IPublicAccountSearchRecommendManager.c) it.next();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("uin", cVar.f79362a);
                            jSONObject.put("name", cVar.f79363b);
                            jSONObject.put("isPA", cVar.f79364c);
                            jSONArray.mo162put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("recommend_title", PublicAccountSearchRecommendManagerImpl.this.mRecommendTitle);
                        jSONObject2.put("recommend_cache_time", PublicAccountSearchRecommendManagerImpl.this.mRecommendCacheTime);
                        jSONObject2.put("recommend_fetch_time", PublicAccountSearchRecommendManagerImpl.this.mRecommendFetchTime);
                        jSONObject2.put("recommend_is_forbidden", PublicAccountSearchRecommendManagerImpl.this.mRecommendIsForbidden);
                        jSONObject2.put("recommend_content_list", jSONArray);
                        String jSONObject3 = jSONObject2.toString();
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "saveRecommendListToLocal->json:" + jSONObject3);
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("public_account_search_recommend", jSONObject3);
                        edit.commit();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(PublicAccountSearchRecommendManagerImpl.this.TAG, 2, "saveRecommendListToLocal->error:" + e16);
                        }
                        e16.printStackTrace();
                    }
                }
            }
        });
    }

    private void sendGetPublicAccountSearchRecommendRequest(AppInterface appInterface, IPublicAccountSearchRecommendManager.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequest->begin!");
        }
        NewIntent newIntent = new NewIntent(appInterface.getApplication().getApplicationContext(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", SSO_COMMAND_GET_RECOMMEND_PUBACCOUNT);
        ArticleComment$GetRecommendPubAccountRequest articleComment$GetRecommendPubAccountRequest = new ArticleComment$GetRecommendPubAccountRequest();
        articleComment$GetRecommendPubAccountRequest.version.set(((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
        articleComment$GetRecommendPubAccountRequest.cuin.set(Long.parseLong(appInterface.getCurrentAccountUin()));
        articleComment$GetRecommendPubAccountRequest.count.set(8);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequset->versionInfo:" + articleComment$GetRecommendPubAccountRequest.version.get() + ", cuin:" + articleComment$GetRecommendPubAccountRequest.cuin.get() + ", count:" + articleComment$GetRecommendPubAccountRequest.count.get());
        }
        newIntent.putExtra("data", articleComment$GetRecommendPubAccountRequest.toByteArray());
        newIntent.setObserver(new a(newIntent, appInterface, aVar));
        this.mRecommendFetchTime = NetConnInfoCenter.getServerTimeMillis();
        appInterface.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequest->send request, time:" + this.mRecommendFetchTime);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager
    public void getRecommendList(AppInterface appInterface, boolean z16, IPublicAccountSearchRecommendManager.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "getRecommendList->isFromCreate:" + z16);
        }
        if (!z16) {
            aVar.a(getListFromHistory(appInterface), null, false);
            return;
        }
        if (checkShouldFetchData(appInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getRecommendList->sendGetPublicAccountSearchRecommendRequest!");
            }
            sendGetPublicAccountSearchRecommendRequest(appInterface, aVar);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "getRecommendList->getRecommendListFromLocal!");
            }
            getRecommendListFromLocal(appInterface, aVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager
    public void initFromLocalData(AppInterface appInterface) {
        if (this.mInited || appInterface == null) {
            return;
        }
        loadRecommendListFromLocal(appInterface);
        loadHistoryListFromLocal(appInterface);
        this.mInited = true;
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "initFromLocalData!");
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager
    public void updatePublicAccountSearchHistoryItem(AppInterface appInterface, String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem->uin:" + str + ", name:" + str2 + ", isPublicAccount:" + z16 + ", time:" + serverTimeMillis);
        }
        if (this.mPublicAccountSearchHistoryMap.containsKey(str)) {
            IPublicAccountSearchRecommendManager.b bVar = this.mPublicAccountSearchHistoryMap.get(str);
            this.mPublicAccountSearchHistoryList.remove(bVar);
            this.mPublicAccountSearchHistoryList.add(0, bVar);
            bVar.f79361d = serverTimeMillis;
            bVar.f79360c = z16;
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem update!");
            }
        } else {
            IPublicAccountSearchRecommendManager.b bVar2 = new IPublicAccountSearchRecommendManager.b(str, str2, serverTimeMillis, z16);
            this.mPublicAccountSearchHistoryList.add(0, bVar2);
            this.mPublicAccountSearchHistoryMap.put(str, bVar2);
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem insert!");
            }
            int size = this.mPublicAccountSearchHistoryList.size();
            if (size > 8) {
                IPublicAccountSearchRecommendManager.b bVar3 = this.mPublicAccountSearchHistoryList.get(size - 1);
                this.mPublicAccountSearchHistoryList.remove(bVar3);
                this.mPublicAccountSearchHistoryMap.remove(bVar3.f79358a);
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem remove lastItem!");
                }
            }
        }
        saveHistoryListToLocal(appInterface);
        if (QLog.isColorLevel()) {
            Iterator<IPublicAccountSearchRecommendManager.b> it = this.mPublicAccountSearchHistoryList.iterator();
            while (it.hasNext()) {
                QLog.d(this.TAG, 2, it.next().toString());
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager
    public void reset() {
        this.mInited = false;
        this.mRecommendTitle = "";
        this.mRecommendCacheTime = 0L;
        this.mRecommendFetchTime = 0L;
        this.mPublicAccountSearchRecommendList.clear();
        this.mPublicAccountSearchHistoryList.clear();
        this.mPublicAccountSearchHistoryMap.clear();
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "resetManager!");
        }
    }
}
