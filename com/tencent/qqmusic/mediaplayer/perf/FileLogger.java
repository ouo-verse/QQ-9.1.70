package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FileLogger {
    private static final String TAG = "FileLogger";

    public static void write(StringBuilder sb5, File file, boolean z16) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file, z16);
                    try {
                        fileWriter.write(sb5.toString());
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e16) {
                        e = e16;
                        fileWriter2 = fileWriter;
                        Logger.e(TAG, "[write] failed!", e);
                        if (fileWriter2 != null) {
                            fileWriter2.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e17) {
                    e = e17;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th6) {
            th = th6;
            fileWriter = fileWriter2;
        }
    }
}
