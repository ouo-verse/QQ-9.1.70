package com.tencent.mobileqq.fts.v2.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class FTSEntityV2 {
    static IPatchRedirector $redirector_;
    public String ext1;
    public String ext2;
    public String ext3;

    @notIndex
    public byte[] exts;

    @notColumn
    public Map<String, String> indexContentMap;

    @notColumn
    public long rowid;

    public FTSEntityV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.ext1 = null;
        this.ext2 = null;
        this.ext3 = null;
        this.exts = null;
        this.rowid = 0L;
        this.indexContentMap = new HashMap();
    }

    protected void doDeserialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    protected void doSerialize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public String getIndexColumnName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return str + "_index";
    }

    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return getClass().getSimpleName();
    }

    public boolean needCompress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public synchronized void preWrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        for (Field field : a.b(getClass())) {
            try {
                String str = (String) field.get(this);
                if (!TextUtils.isEmpty(str)) {
                    this.indexContentMap.put(field.getName(), a.e(str));
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            }
        }
    }
}
