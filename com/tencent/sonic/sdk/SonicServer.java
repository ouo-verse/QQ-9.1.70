package com.tencent.sonic.sdk;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sonic.sdk.SonicSessionStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicServer implements SonicSessionStream.Callback {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SonicSdk_SonicServer";
    protected Map<String, List<String>> cachedResponseHeaders;
    protected final SonicSessionConnection connectionImpl;
    protected String dataString;
    private final ByteArrayOutputStream outputStream;
    protected final Intent requestIntent;
    protected int responseCode;
    protected String serverRsp;
    protected final SonicSession session;
    protected String templateString;

    public SonicServer(SonicSession sonicSession, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sonicSession, (Object) intent);
            return;
        }
        this.outputStream = new ByteArrayOutputStream();
        this.session = sonicSession;
        this.requestIntent = intent;
        this.connectionImpl = SonicSessionConnectionInterceptor.getSonicSessionConnection(sonicSession, intent);
    }

    private void addResponseHeaderFields(String str, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        Collections.addAll(arrayList, strArr);
        getResponseHeaderFields().put(str.toLowerCase(), arrayList);
    }

    private boolean isFirstLoadRequest() {
        if (!TextUtils.isEmpty(this.requestIntent.getStringExtra("eTag")) && !TextUtils.isEmpty(this.requestIntent.getStringExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG))) {
            return false;
        }
        return true;
    }

    private boolean isSonicResponse() {
        Map<String, List<String>> responseHeaderFields = this.connectionImpl.getResponseHeaderFields();
        if (responseHeaderFields != null && !responseHeaderFields.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : responseHeaderFields.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    String lowerCase = entry.getKey().toLowerCase();
                    if (lowerCase.equals(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE) || lowerCase.equals(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_CHANGE) || lowerCase.equals(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private boolean readServerResponse(AtomicBoolean atomicBoolean) {
        if (TextUtils.isEmpty(this.serverRsp)) {
            BufferedInputStream responseStream = this.connectionImpl.getResponseStream();
            if (responseStream == null) {
                SonicUtils.log(TAG, 6, "session(" + this.session.sId + ") readServerResponse error: bufferedInputStream is null!");
                return false;
            }
            try {
                byte[] bArr = new byte[this.session.config.READ_BUF_SIZE];
                int i3 = 0;
                while (true) {
                    if ((atomicBoolean == null || !atomicBoolean.get()) && -1 != (i3 = responseStream.read(bArr))) {
                        this.outputStream.write(bArr, 0, i3);
                    }
                }
                if (i3 == -1) {
                    this.serverRsp = this.outputStream.toString(this.session.getCharsetFromHeaders());
                    return true;
                }
                return true;
            } catch (Exception e16) {
                SonicUtils.log(TAG, 6, "session(" + this.session.sId + ") readServerResponse error:" + e16.getMessage() + ".");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int connect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int connect = this.connectionImpl.connect();
        this.session.statistics.connectionConnectTime = System.currentTimeMillis();
        if (SonicUtils.shouldLog(3)) {
            SonicUtils.log(TAG, 3, "session(" + this.session.f369809id + ") server connect cost = " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        }
        if (connect != 0) {
            return connect;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.responseCode = this.connectionImpl.getResponseCode();
        this.session.statistics.connectionRespondTime = System.currentTimeMillis();
        if (SonicUtils.shouldLog(3)) {
            SonicUtils.log(TAG, 3, "session(" + this.session.f369809id + ") server response cost = " + (System.currentTimeMillis() - currentTimeMillis2) + " ms.");
        }
        int i3 = this.responseCode;
        if (304 == i3 || 200 != i3) {
            return 0;
        }
        String responseHeaderField = getResponseHeaderField("eTag");
        if (!TextUtils.isEmpty(responseHeaderField) && responseHeaderField.toLowerCase().startsWith("w/")) {
            responseHeaderField = responseHeaderField.toLowerCase().replace("w/", "").replace("\"", "");
            addResponseHeaderFields("eTag", responseHeaderField);
        }
        String stringExtra = this.requestIntent.getStringExtra("eTag");
        String responseHeaderField2 = getResponseHeaderField("eTag");
        if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(responseHeaderField2)) {
            this.responseCode = 304;
            return 0;
        }
        if (!isSonicResponse() && this.session.config.SUPPORT_LOCAL_SERVER) {
            String responseHeaderField3 = getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE);
            if ("http".equalsIgnoreCase(responseHeaderField3)) {
                return 0;
            }
            if (TextUtils.isEmpty(responseHeaderField3)) {
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_CACHE_OFFLINE, "true");
            }
            if (isFirstLoadRequest()) {
                return 0;
            }
            if (TextUtils.isEmpty(responseHeaderField)) {
                readServerResponse(null);
                if (TextUtils.isEmpty(this.serverRsp)) {
                    return SonicConstants.ERROR_CODE_CONNECT_IOE;
                }
                String sha1 = SonicUtils.getSHA1(this.serverRsp);
                addResponseHeaderFields("eTag", sha1);
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_HTML_SHA1, sha1);
                if (stringExtra.equals(sha1)) {
                    this.responseCode = 304;
                    return 0;
                }
            }
            String responseHeaderField4 = getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
            if (TextUtils.isEmpty(responseHeaderField4)) {
                if (TextUtils.isEmpty(this.serverRsp)) {
                    readServerResponse(null);
                }
                if (TextUtils.isEmpty(this.serverRsp)) {
                    return SonicConstants.ERROR_CODE_CONNECT_IOE;
                }
                separateTemplateAndData();
                responseHeaderField4 = getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
            }
            if (this.requestIntent.getStringExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG).equals(responseHeaderField4)) {
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_CHANGE, "false");
            } else {
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_CHANGE, "true");
            }
        }
        return 0;
    }

    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            BufferedInputStream responseStream = this.connectionImpl.getResponseStream();
            if (responseStream != null) {
                responseStream.close();
            }
        } catch (Throwable th5) {
            SonicUtils.log(TAG, 6, "session(" + this.session.sId + ") server disconnect error:" + th5.getMessage() + ".");
        }
        this.connectionImpl.disconnect();
    }

    public int getResponseCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.responseCode;
    }

    public synchronized String getResponseData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        if (z16 && TextUtils.isEmpty(this.serverRsp)) {
            readServerResponse(null);
        }
        return this.serverRsp;
    }

    public String getResponseHeaderField(String str) {
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Map<String, List<String>> responseHeaderFields = getResponseHeaderFields();
        if (responseHeaderFields != null && responseHeaderFields.size() != 0 && (list = responseHeaderFields.get(str.toLowerCase())) != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder(list.get(0));
            int size = list.size();
            for (int i3 = 1; i3 < size; i3++) {
                sb5.append(',');
                sb5.append(list.get(i3));
            }
            return sb5.toString();
        }
        return null;
    }

    public Map<String, List<String>> getResponseHeaderFields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.cachedResponseHeaders == null) {
            this.cachedResponseHeaders = new ConcurrentHashMap();
            Map<String, String> map = this.session.config.customResponseHeaders;
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : this.session.config.customResponseHeaders.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        List<String> list = this.cachedResponseHeaders.get(key.toLowerCase());
                        if (list == null) {
                            list = new ArrayList<>(1);
                            this.cachedResponseHeaders.put(key.toLowerCase(), list);
                        }
                        list.add(entry.getValue());
                    }
                }
            }
            Map<String, List<String>> responseHeaderFields = this.connectionImpl.getResponseHeaderFields();
            if (responseHeaderFields != null && !responseHeaderFields.isEmpty()) {
                for (Map.Entry<String, List<String>> entry2 : responseHeaderFields.entrySet()) {
                    String key2 = entry2.getKey();
                    if (!TextUtils.isEmpty(key2)) {
                        this.cachedResponseHeaders.put(key2.toLowerCase(), entry2.getValue());
                    }
                }
            }
        }
        return this.cachedResponseHeaders;
    }

    public synchronized InputStream getResponseStream(AtomicBoolean atomicBoolean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InputStream) iPatchRedirector.redirect((short) 7, (Object) this, (Object) atomicBoolean);
        }
        BufferedInputStream bufferedInputStream = null;
        if (!readServerResponse(atomicBoolean)) {
            return null;
        }
        if (TextUtils.isEmpty(this.serverRsp)) {
            bufferedInputStream = this.connectionImpl.getResponseStream();
        }
        return new SonicSessionStream(this, this.outputStream, bufferedInputStream);
    }

    public synchronized String getTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (TextUtils.isEmpty(this.templateString) && !TextUtils.isEmpty(this.serverRsp)) {
            separateTemplateAndData();
        }
        return this.templateString;
    }

    public synchronized String getUpdatedData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (TextUtils.isEmpty(this.dataString) && !TextUtils.isEmpty(this.serverRsp)) {
            separateTemplateAndData();
        }
        return this.dataString;
    }

    @Override // com.tencent.sonic.sdk.SonicSessionStream.Callback
    public void onClose(boolean z16, ByteArrayOutputStream byteArrayOutputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), byteArrayOutputStream);
            return;
        }
        if (TextUtils.isEmpty(this.serverRsp) && z16 && byteArrayOutputStream != null) {
            try {
                this.serverRsp = byteArrayOutputStream.toString(this.session.getCharsetFromHeaders());
                byteArrayOutputStream.close();
            } catch (Throwable th5) {
                SonicUtils.log(TAG, 6, "session(" + this.session.sId + "), onClose error:" + th5.getMessage() + ".");
            }
        }
        this.session.onServerClosed(this, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void separateTemplateAndData() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.serverRsp)) {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            String str2 = null;
            if (SonicUtils.separateTemplateAndData(this.session.f369809id, this.serverRsp, sb5, sb6)) {
                this.templateString = sb5.toString();
                str = sb6.toString();
            } else {
                str = null;
            }
            String responseHeaderField = getResponseHeaderField("eTag");
            String responseHeaderField2 = getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
            if (TextUtils.isEmpty(responseHeaderField)) {
                str2 = SonicUtils.getSHA1(this.serverRsp);
                addResponseHeaderFields("eTag", str2);
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_HTML_SHA1, str2);
                responseHeaderField = str2;
            }
            if (TextUtils.isEmpty(this.templateString)) {
                this.templateString = this.serverRsp;
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG, responseHeaderField);
            } else if (TextUtils.isEmpty(responseHeaderField2)) {
                addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG, SonicUtils.getSHA1(this.templateString));
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", new JSONObject(str));
                    if (TextUtils.isEmpty(str2)) {
                        addResponseHeaderFields(SonicSessionConnection.CUSTOM_HEAD_FILED_HTML_SHA1, SonicUtils.getSHA1(this.serverRsp));
                    }
                    jSONObject.put("html-sha1", getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_HTML_SHA1));
                    jSONObject.put(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG, getResponseHeaderField(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG));
                    this.dataString = jSONObject.toString();
                } catch (Exception e16) {
                    SonicUtils.log(TAG, 6, "session(" + this.session.sId + ") parse server response data error:" + e16.getMessage() + ".");
                }
            }
        }
    }
}
