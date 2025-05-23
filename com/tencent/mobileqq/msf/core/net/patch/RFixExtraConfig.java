package com.tencent.mobileqq.msf.core.net.patch;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RFixExtraConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RFixExtraConfig";
    private String commitId;
    private int configId;
    private final String content;
    private final Map<String, String> customContent;
    private boolean disable;
    private final List<Resource> resources;
    private final SparseIntArray systemVersions;
    private int versionCode;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Resource {
        static IPatchRedirector $redirector_;
        public String md5;
        public String patchId;
        public String url;

        public Resource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public RFixExtraConfig(String str) {
        this(-1, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    private void parseContent() throws Exception {
        JSONObject optJSONObject;
        JSONObject jSONObject = new JSONObject(this.content);
        JSONArray optJSONArray = jSONObject.optJSONArray(DKConfiguration.Directory.RESOURCES);
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    Resource resource = new Resource();
                    resource.url = optJSONObject2.optString("url");
                    resource.md5 = optJSONObject2.optString("md5");
                    resource.patchId = optJSONObject2.optString("identify_id");
                    this.resources.add(resource);
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("custom_content");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("data")) != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.customContent.put(str, optJSONObject.optString(str));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("extra_content");
        if (optJSONObject4 != null) {
            this.disable = optJSONObject4.optBoolean("disable", false);
            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("data");
            if (optJSONObject5 != null) {
                String optString = optJSONObject5.optString("config_id");
                if (!TextUtils.isEmpty(optString)) {
                    this.configId = Integer.parseInt(optString);
                }
                this.versionCode = optJSONObject5.optInt("versionCode");
                this.commitId = optJSONObject5.optString("commitId");
                JSONArray optJSONArray2 = optJSONObject5.optJSONArray("systemVersion");
                if (optJSONArray2 != null) {
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        int i17 = optJSONArray2.getInt(i16);
                        this.systemVersions.put(i17, i17);
                    }
                }
            }
        }
    }

    public String getCommitId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.commitId;
    }

    public int getConfigId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.configId;
    }

    public String getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.content;
    }

    public String getCustomContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return this.customContent.get(str);
    }

    public String getPatchName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.resources.size() == 0) {
            return null;
        }
        String str = this.resources.get(0).url;
        if (!str.contains("/")) {
            return null;
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    public String getPatchUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (this.resources.size() == 0) {
            return null;
        }
        return this.resources.get(0).url;
    }

    public List<Resource> getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.resources;
    }

    public int getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.versionCode;
    }

    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.configId > 0 && !this.disable) {
            return true;
        }
        return false;
    }

    public boolean matchSystemVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.systemVersions.size() != 0 && this.systemVersions.get(Build.VERSION.SDK_INT) == 0) {
            return false;
        }
        return true;
    }

    public RFixExtraConfig(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        this.configId = i3;
        this.content = str;
        this.resources = new ArrayList();
        this.customContent = new HashMap();
        this.systemVersions = new SparseIntArray();
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            parseContent();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
