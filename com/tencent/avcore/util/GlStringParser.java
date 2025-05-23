package com.tencent.avcore.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public class GlStringParser {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GlStringParser";
    private Map<String, String> mMap;
    private char mend;
    private char mkey;

    public GlStringParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mkey = '\r';
        this.mend = '\t';
        this.mMap = new HashMap();
    }

    public String flatten() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : this.mMap.keySet()) {
            sb5.append(str);
            sb5.append(this.mkey);
            sb5.append(this.mMap.get(str));
            sb5.append(this.mend);
        }
        sb5.deleteCharAt(sb5.length() - 1);
        return sb5.toString();
    }

    public String get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        return this.mMap.get(str);
    }

    public Boolean getBoolean(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        String str2 = this.mMap.get(str);
        if (str2 != null && (str2.equals("true") || str2.equals("false"))) {
            return Boolean.valueOf(str2);
        }
        return Boolean.FALSE;
    }

    public int getInt(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? getInt(str, 0) : ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).intValue();
    }

    public long getLong(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3))).longValue();
        }
        String str2 = this.mMap.get(str);
        if (str2 != null) {
            try {
                return Long.parseLong(str2);
            } catch (Exception e16) {
                AVCoreLog.e(TAG, "getLong, key[" + str + "], value[" + str2 + "], def[" + j3 + "]", e16);
                return j3;
            }
        }
        return j3;
    }

    public Map<String, String> getMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mMap;
    }

    public void remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.mMap.remove(str);
        }
    }

    public void set(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str != null && str.indexOf(this.mend) == -1 && str.indexOf(this.mkey) == -1 && str2 != null && str2.indexOf(this.mkey) == -1 && str2.indexOf(this.mend) == -1) {
            this.mMap.put(str, str2);
        }
    }

    public void unflatten(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        this.mMap.clear();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mend);
        StringTokenizer stringTokenizer = new StringTokenizer(str, sb5.toString());
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(this.mkey);
            if (indexOf != -1) {
                this.mMap.put(nextToken.substring(0, indexOf), nextToken.substring(indexOf + 1));
            }
        }
    }

    public int getInt(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3)).intValue();
        }
        String str2 = this.mMap.get(str);
        if (str2 == null) {
            return i3;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception e16) {
            AVCoreLog.e(TAG, "getInt, key[" + str + "], value[" + str2 + "], def[" + i3 + "]", e16);
            return i3;
        }
    }

    public void set(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.mMap.put(str, Integer.toString(i3));
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        }
    }

    public GlStringParser(char c16, char c17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Character.valueOf(c16), Character.valueOf(c17));
            return;
        }
        this.mkey = c16;
        this.mend = c17;
        this.mMap = new HashMap();
    }

    public void set(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mMap.put(str, Long.toString(j3));
        } else {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3));
        }
    }

    public GlStringParser(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.mkey = '\r';
        this.mend = '\t';
        this.mMap = new HashMap();
        unflatten(str);
    }

    public GlStringParser(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
            return;
        }
        this.mkey = '\r';
        this.mend = '\t';
        this.mMap = map;
    }
}
