package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class MinFileUtils {
    static IPatchRedirector $redirector_;

    MinFileUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
            throw new IOException("\u521b\u5efa\u7236\u76ee\u5f55\u5931\u8d25,\u6587\u4ef6\u76ee\u5f55:" + file.getAbsolutePath() + " parent dir exists=" + parentFile.exists());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> b(File file) {
        File[] listFiles = file.listFiles();
        LinkedList linkedList = new LinkedList();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    linkedList.add(file2);
                }
            }
            Collections.sort(linkedList, new Comparator<File>() { // from class: com.tencent.hydevteam.pluginframework.pluginmanager.MinFileUtils.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file3, File file4) {
                    return (int) (file4.lastModified() - file3.lastModified());
                }
            });
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e16 = null;
                    for (File file2 : listFiles) {
                        try {
                            if (file2.isDirectory()) {
                                if (file2.exists()) {
                                    c(file2);
                                    if (!file2.delete()) {
                                        throw new IOException("Unable to delete directory " + file2 + ".");
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                boolean exists = file2.exists();
                                if (!file2.delete()) {
                                    if (!exists) {
                                        throw new FileNotFoundException("File does not exist: " + file2);
                                    }
                                    throw new IOException("Unable to delete file: " + file2);
                                }
                            }
                        } catch (IOException e17) {
                            e16 = e17;
                        }
                    }
                    if (e16 == null) {
                        return;
                    } else {
                        throw e16;
                    }
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }
}
