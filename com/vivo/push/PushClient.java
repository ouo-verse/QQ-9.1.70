package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class PushClient extends a implements com.vivo.push.d.a {
    public static final String DEFAULT_REQUEST_ID = "1";
    private static volatile PushClient sPushClient;
    private Context mContext;
    private boolean mIsInitSdk;
    private boolean mIsSdkInited = true;
    private com.vivo.push.d.a mSyncProfileInfo;

    PushClient(Context context) {
        this.mContext = ContextDelegate.getContext(context);
        com.vivo.push.restructure.a.a().a(context);
        m.a().a(context);
        this.mSyncProfileInfo = new com.vivo.push.d.d();
    }

    private boolean checkAgreePrivacyStatementAndInitSdk() {
        if (!com.vivo.push.restructure.a.a().e().l().isAgreePrivacyStatement()) {
            return false;
        }
        inidSdk(this.mContext);
        return true;
    }

    private void checkParam(String str) {
        if (str != null) {
        } else {
            throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(str)));
        }
    }

    private String getAppId(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return com.vivo.push.restructure.a.a().e().a();
    }

    private String getAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return com.vivo.push.restructure.a.a().e().c();
    }

    public static synchronized PushClient getInstance(Context context) {
        PushClient pushClient;
        synchronized (PushClient.class) {
            if (sPushClient == null) {
                sPushClient = new PushClient(context.getApplicationContext());
            }
            pushClient = sPushClient;
        }
        return pushClient;
    }

    private void inidSdk(Context context) {
        synchronized (this) {
            if (!this.mIsInitSdk) {
                m.a().a(context);
                this.mIsInitSdk = true;
            }
        }
    }

    private boolean isSdkInited() {
        return this.mIsSdkInited;
    }

    @Override // com.vivo.push.d.a
    public void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            com.vivo.push.d.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.addProfileId(str, iPushRequestCallback);
            }
        }
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (!isSdkInited()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(8011);
            }
        } else {
            checkParam(str);
            m.a().a(str, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    public void checkManifest() throws VivoPushException {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return;
        }
        m.a().b();
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (!isSdkInited()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(8011);
            }
        } else {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            m.a().b(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    @Override // com.vivo.push.d.a
    public void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            com.vivo.push.d.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.deleteAllProfileId(iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.d.a
    public void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            com.vivo.push.d.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.deleteProfileId(str, iPushRequestCallback);
            }
        }
    }

    public void deleteRegid(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            if (!isSdkInited()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(8011);
                    return;
                }
                return;
            }
            super.deleteRegid(iPushActionListener, getAppId(""), getAppKey(""));
        }
    }

    public String getAlias() {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return null;
        }
        return m.a().i();
    }

    @Override // com.vivo.push.a
    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onFail(104);
            }
        } else {
            if (!isSdkInited()) {
                if (iPushQueryActionListener != null) {
                    iPushQueryActionListener.onFail(8011);
                    return;
                }
                return;
            }
            super.getRegId(iPushQueryActionListener);
        }
    }

    public List<String> getTopics() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return new ArrayList();
        }
        if (!isSdkInited()) {
            return new ArrayList();
        }
        m.a();
        return m.c();
    }

    public String getVersion() {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return null;
        }
        return "3.4.0.0";
    }

    public void initialize(PushConfig pushConfig) throws VivoPushException {
        if (pushConfig != null) {
            com.vivo.push.restructure.a.a().e().a(pushConfig);
            initialize();
            return;
        }
        throw new VivoPushException("initialize error config is null");
    }

    public boolean isSupport() {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return false;
        }
        return m.a().d();
    }

    public int isSupportNewControlStrategies() {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return -1;
        }
        return com.vivo.push.restructure.a.a().g().a();
    }

    public int isSupportSyncProfileInfo() {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return -1;
        }
        return com.vivo.push.restructure.a.a().g().b();
    }

    @Override // com.vivo.push.d.a
    public void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else if (!isSdkInited()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8011);
            }
        } else {
            com.vivo.push.d.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.queryProfileIds(iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.a
    public void querySubscribeState(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
        if (!isSdkInited() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(8011);
        }
        super.querySubscribeState(iPushActionListener);
    }

    public void setSystemModel(boolean z16) {
        if (!checkAgreePrivacyStatementAndInitSdk() || !isSdkInited()) {
            return;
        }
        m.a().a(z16);
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (!isSdkInited()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(8011);
            }
        } else {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            m.a().a(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            if (!isSdkInited()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(8011);
                    return;
                }
                return;
            }
            m.a().c(iPushActionListener, getAppId(""), getAppKey(""));
        }
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            if (!isSdkInited()) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(8011);
                    return;
                }
                return;
            }
            m.a().a(iPushActionListener, getAppId(""), getAppKey(""));
        }
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else if (!isSdkInited()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(8011);
            }
        } else {
            checkParam(str);
            m.a().b(str, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    private void initialize() throws VivoPushException {
        if (checkAgreePrivacyStatementAndInitSdk()) {
            checkManifest();
            m a16 = m.a();
            com.vivo.push.b.f fVar = new com.vivo.push.b.f();
            com.vivo.push.restructure.a.a();
            fVar.d();
            a16.a(fVar);
            if (this.mIsSdkInited) {
                return;
            }
            this.mIsSdkInited = true;
        }
    }
}
