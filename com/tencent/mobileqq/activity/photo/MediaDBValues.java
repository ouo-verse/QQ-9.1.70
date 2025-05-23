package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaDBValues {
    static IPatchRedirector $redirector_ = null;
    public static final String[] CONTENT_TABLE_COLUMNS;
    public static final String CONTENT_TABLE_NAME = "content_table";
    public static final String DB_NAME = "media_scanner_database";
    public static final int DB_VERSION = 2;
    public static final String DURATION = "duration";
    public static final String FILESIZE = "filesize";
    public static final String FOLDERPATH = "folderpath";
    public static final String[] FOLDER_TABLE_COLUMNS;
    public static final String FOLDER_TABLE_NAME = "folder_table";
    public static final String ID = "id";
    public static final String MD5 = "md5";
    public static final String MIMETYPE = "mimetype";
    public static final String MODIFIEDDATE = "modifieddate";
    public static final String NAME = "name";
    public static final String PATH = "path";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12892);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            CONTENT_TABLE_COLUMNS = new String[]{"id", "name", "path", FOLDERPATH, FILESIZE, MODIFIEDDATE, "duration", "mimetype", "md5"};
            FOLDER_TABLE_COLUMNS = new String[]{"id", FOLDERPATH, MODIFIEDDATE};
        }
    }

    public MediaDBValues() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
