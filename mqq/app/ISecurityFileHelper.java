package mqq.app;

import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ISecurityFileHelper {
    public static final int REPORT_INFO_FILE_AMOUNT = 1;
    public static final int REPORT_INFO_FILE_SIZE = 0;
    public static final String TAG = "ISecurityFileHelper";

    String declareBusinessFileName();

    boolean doMigrate(File file);

    boolean needMigration();

    File oldBusinessDir(String str);

    boolean oldBusinessDirExist(String str);

    String[] reportHistoryFileInfo();
}
