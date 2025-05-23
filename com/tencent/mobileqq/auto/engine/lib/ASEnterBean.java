package com.tencent.mobileqq.auto.engine.lib;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASEnterBean implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_QCIRCLE_SCHEME = "key_scheme";
    public static final String REGEX = "\\?";
    public static final String SERVER_NAME = "qcircle";
    public static final String TAG = "QCircleSchemeBean";
    private static final long serialVersionUID = 5838484954956837978L;
    private HashMap<String, String> mAttrs;
    private String mBusinessKey;
    private HashMap<String, byte[]> mByteAttrs;
    private int mLoadAction;
    private String mSchemeAction;
    private List<String> mSourceIds;
    private long mStartTime;

    public ASEnterBean(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.mBusinessKey = str;
        }
    }

    public ASEnterBean convertSchemeToBean(String str) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        try {
            split = str.split("\\?");
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (split.length < 1) {
            return this;
        }
        String[] split2 = split[0].substring(9).split("/");
        if (split2.length != 2) {
            return this;
        }
        if (!"qcircle".equals(split2[0])) {
            return this;
        }
        this.mSchemeAction = split2[1];
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (this.mAttrs == null) {
            this.mAttrs = new HashMap<>();
        }
        this.mAttrs.put("key_scheme", str);
        for (String str2 : queryParameterNames) {
            if (!TextUtils.isEmpty(str2)) {
                String queryParameter = parse.getQueryParameter(str2);
                if (!TextUtils.isEmpty(queryParameter)) {
                    this.mAttrs.put(str2.toLowerCase(), queryParameter);
                }
            }
        }
        return this;
    }

    public HashMap<String, String> getAttrs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mAttrs;
    }

    public String getBusinessKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mBusinessKey;
    }

    public HashMap<String, byte[]> getByteAttrs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mByteAttrs;
    }

    public int getLoadAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mLoadAction;
    }

    public String getSchemeAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mSchemeAction;
    }

    public List<String> getSourceIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mSourceIds;
    }

    public long getStartTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.mStartTime;
    }

    public ASEnterBean setAttrs(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) hashMap);
        }
        this.mAttrs = hashMap;
        return this;
    }

    public ASEnterBean setByteAttrs(HashMap<String, byte[]> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) hashMap);
        }
        this.mByteAttrs = hashMap;
        return this;
    }

    public ASEnterBean setLoadAction(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        this.mLoadAction = i3;
        return this;
    }

    public ASEnterBean setSchemeAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        this.mSchemeAction = str;
        return this;
    }

    public ASEnterBean setSourceIds(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) list);
        }
        this.mSourceIds = list;
        return this;
    }

    public ASEnterBean setStartTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ASEnterBean) iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
        this.mStartTime = j3;
        return this;
    }
}
