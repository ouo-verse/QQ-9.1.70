package com.tencent.dbfix;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DBCheckResult {
    static IPatchRedirector $redirector_ = null;
    private static final String DB_STATUS_OK = "ok";
    private static final String INDEX_CORRUPT_DESCRIPTION_AUTO_INDEX_PREFIX = "sqlite_autoindex_";
    private static final String INDEX_CORRUPT_DESCRIPTION_AUTO_INDEX_SUFFIX = "_1";
    private static final String INDEX_CORRUPT_DESCRIPTION_IDX_SUFFIX = "_idx";
    private static final String INDEX_CORRUPT_DESCRIPTION_MISSING = "missing from index";
    private static final String INDEX_CORRUPT_DESCRIPTION_ROW = "row";
    private static final String INDEX_CORRUPT_DESCRIPTION_WRONG_PREFIX = "wrong # of entries in index";
    private static final String PAGE_CORRUPT_NORMAL = "On page";
    private static final String PAGE_CORRUPT_START = "*** in database main ***";
    private static final String PAGE_CORRUPT_TREE = "On tree page";
    private static final int REASON_CODE_EMPTY = 9999;
    public static final int REASON_CODE_INDEX = 1000;
    public static final int REASON_CODE_NONE = -1000;
    public static final int REASON_CODE_OK = 0;
    public static final int REASON_CODE_OTHER = 1002;
    public static final int REASON_CODE_PAGE_TREE_CORRUPT = 1001;
    private static final String TAG = "DBIntegrityCheckManager";
    public long checkCompleteTime;
    public long checkStartTime;
    private final List<DBCheckResultItem> result;

    public DBCheckResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.result = new ArrayList();
        this.checkStartTime = 0L;
        this.checkCompleteTime = 0L;
    }

    private boolean isPageTreeCorrupt(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(PAGE_CORRUPT_START)) {
            return false;
        }
        if (!str.contains(PAGE_CORRUPT_NORMAL) && !str.contains(PAGE_CORRUPT_TREE)) {
            return false;
        }
        return true;
    }

    private boolean isReasonIndexCorrupt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(INDEX_CORRUPT_DESCRIPTION_WRONG_PREFIX)) {
            return true;
        }
        if (!str.contains(INDEX_CORRUPT_DESCRIPTION_MISSING) || !str.contains("row")) {
            return false;
        }
        return true;
    }

    private boolean isStatusOK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals("ok", str);
    }

    private int parseSQLExecuteFailCode(String str) {
        String trim = str.trim();
        if (isReasonIndexCorrupt(trim)) {
            return 1000;
        }
        if (isPageTreeCorrupt(trim)) {
            return 1001;
        }
        if (isStatusOK(trim)) {
            return 0;
        }
        return 1002;
    }

    public String buildDescription() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        int size = this.result.size();
        for (int i3 = 0; i3 < size; i3++) {
            String str = this.result.get(i3).description;
            sb5.append(str);
            if (!str.endsWith(";")) {
                sb5.append(";");
            }
        }
        return sb5.toString();
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.checkStartTime = 0L;
        this.checkCompleteTime = 0L;
        this.result.clear();
    }

    public List<DBCheckResultItem> getCheckResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.result;
    }

    public int getCorruptReasonCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        if (this.result.isEmpty()) {
            return 9999;
        }
        int size = this.result.size();
        int i3 = 1002;
        for (int i16 = 0; i16 < size; i16++) {
            DBCheckResultItem dBCheckResultItem = this.result.get(i16);
            int i17 = dBCheckResultItem.errCode;
            if (i17 != -1000) {
                return i17;
            }
            if (i3 == 1002) {
                i3 = parseSQLExecuteFailCode(dBCheckResultItem.description);
            }
        }
        return i3;
    }

    public List<String> getIndexErrTable() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<DBCheckResultItem> it = this.result.iterator();
        while (it.hasNext()) {
            String str2 = it.next().description;
            if (!TextUtils.isEmpty(str2) && str2.startsWith(INDEX_CORRUPT_DESCRIPTION_WRONG_PREFIX)) {
                String substring = str2.substring(28);
                int length = substring.length();
                if (substring.endsWith(INDEX_CORRUPT_DESCRIPTION_IDX_SUFFIX)) {
                    str = substring.substring(0, length - 4);
                } else if (substring.startsWith(INDEX_CORRUPT_DESCRIPTION_AUTO_INDEX_PREFIX)) {
                    str = substring.substring(17, length - 2);
                } else {
                    str = "";
                }
                if (!arrayList.contains(str)) {
                    DBFixLog.d(TAG, "tableName: ", str);
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public void setResult(List<DBCheckResultItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
        } else {
            this.result.clear();
            this.result.addAll(list);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "DBIntegrityCheckResult{result=" + this.result + ", checkStartTime=" + this.checkStartTime + ", checkCompleteTime=" + this.checkCompleteTime + '}';
    }
}
