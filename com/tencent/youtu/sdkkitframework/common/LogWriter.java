package com.tencent.youtu.sdkkitframework.common;

import android.os.Environment;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LogWriter {
    static IPatchRedirector $redirector_ = null;
    public static final String LOGFILE_TAG_NAME = "logfile";
    public static final String LOG_CONFIGFILE_NAME = "log.properties";
    public static LogWriter logWriter;
    private final String DEFAULT_LOG_FILE_NAME;
    private String logDirName;
    private String logFileName;
    private PrintWriter writer;

    LogWriter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb5.append(str);
        sb5.append("NativeLog");
        sb5.append(str);
        sb5.append("default.log");
        this.DEFAULT_LOG_FILE_NAME = sb5.toString();
        init();
    }

    private String getLogFileNameFromConfigFile() {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = getClass().getResourceAsStream(LOG_CONFIGFILE_NAME);
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                resourceAsStream.close();
                return properties.getProperty(LOGFILE_TAG_NAME);
            }
            System.err.println("\u65e0\u6cd5\u6253\u5f00\u5c5e\u6027\u914d\u7f6e\u6587\u4ef6: log.properties");
            return null;
        } catch (IOException unused) {
            System.err.println("\u65e0\u6cd5\u6253\u5f00\u5c5e\u6027\u914d\u7f6e\u6587\u4ef6: log.properties");
            return null;
        }
    }

    public static synchronized LogWriter getLogWriter() {
        LogWriter logWriter2;
        synchronized (LogWriter.class) {
            if (logWriter == null) {
                logWriter = new LogWriter();
            }
            logWriter2 = logWriter;
        }
        return logWriter2;
    }

    private void init() {
        YtLogger.d("LogWriter", "init()");
        File file = new File(this.logDirName);
        if (!file.exists()) {
            file.mkdir();
        }
        if (this.logFileName == null) {
            String logFileNameFromConfigFile = getLogFileNameFromConfigFile();
            this.logFileName = logFileNameFromConfigFile;
            if (logFileNameFromConfigFile == null) {
                this.logFileName = this.DEFAULT_LOG_FILE_NAME;
            }
        }
        YtLogger.d("LogWriter", "logFileName: " + this.logFileName);
        File file2 = new File(this.logFileName);
        try {
            this.writer = new PrintWriter((Writer) new FileWriter(file2, false), true);
            System.out.println("\u65e5\u5fd7\u6587\u4ef6\u7684\u4f4d\u7f6e\uff1a" + file2.getAbsolutePath());
        } catch (IOException e16) {
            throw new Exception("\u65e0\u6cd5\u6253\u5f00\u65e5\u5fd7\u6587\u4ef6:" + file2.getAbsolutePath(), e16);
        }
    }

    public static void main(String[] strArr) {
        try {
            LogWriter logWriter2 = getLogWriter("./workspace/temp/logger.log", "./workspace");
            logWriter2.log("First log!");
            logWriter2.log("\u7b2c\u4e8c\u4e2a\u65e5\u5fd7\u4fe1\u606f");
            logWriter2.log("Third log");
            logWriter2.log("\u7b2c\u56db\u4e2a\u65e5\u5fd7\u4fe1\u606f");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < 1000000; i3++) {
                stringBuffer.append("tableaA|device_number|13701010");
                stringBuffer.append(i3);
                stringBuffer.append(";\n");
            }
            String stringBuffer2 = stringBuffer.toString();
            long currentTimeMillis = System.currentTimeMillis();
            logWriter2.log(stringBuffer2);
            long currentTimeMillis2 = System.currentTimeMillis();
            System.out.println("\u603b\u6d88\u8017\u65f6\u95f4\uff1a" + (currentTimeMillis2 - currentTimeMillis));
            logWriter2.close();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        logWriter = null;
        PrintWriter printWriter = this.writer;
        if (printWriter != null) {
            printWriter.close();
        }
    }

    public synchronized void log(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        this.writer.println(new Date() + MsgSummary.STR_COLON + str);
    }

    public synchronized void log(Exception exc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) exc);
            return;
        }
        this.writer.println(new Date() + MsgSummary.STR_COLON);
        exc.printStackTrace(this.writer);
    }

    LogWriter(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory());
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append("NativeLog");
        sb5.append(str3);
        sb5.append("default.log");
        this.DEFAULT_LOG_FILE_NAME = sb5.toString();
        this.logDirName = str2;
        this.logFileName = str;
        init();
    }

    public static synchronized LogWriter getLogWriter(String str, String str2) {
        LogWriter logWriter2;
        synchronized (LogWriter.class) {
            if (logWriter == null) {
                logWriter = new LogWriter(str, str2);
            }
            logWriter2 = logWriter;
        }
        return logWriter2;
    }
}
