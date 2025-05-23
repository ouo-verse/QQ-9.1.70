package cooperation.pluginbridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BridgeHelper implements Runnable {
    private static BridgeHelper C;
    private static final byte[] D = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    private Context f390367d;

    /* renamed from: e, reason: collision with root package name */
    private String f390368e;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f390370h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    private boolean f390371i = false;

    /* renamed from: m, reason: collision with root package name */
    private int f390372m = 0;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, String> f390369f = new HashMap<>();

    BridgeHelper(Context context, String str) {
        this.f390367d = context.getApplicationContext();
        this.f390368e = str;
        this.f390370h.set(false);
    }

    public static synchronized BridgeHelper b(Context context, String str) {
        BridgeHelper bridgeHelper;
        synchronized (BridgeHelper.class) {
            if (QLog.isColorLevel()) {
                QLog.i("GeneralEntryConfigManager", 2, "get GeneralEntryConfigManager instancegInstance:" + C + "uin:" + str);
            }
            if (C == null) {
                synchronized (BridgeHelper.class) {
                    if (C == null) {
                        C = new BridgeHelper(context, str);
                    }
                }
            } else if (TextUtils.isEmpty(str) || (!TextUtils.isEmpty(str) && !str.equals(C.f390368e))) {
                C.f390370h.set(false);
                BridgeHelper bridgeHelper2 = C;
                bridgeHelper2.f390371i = false;
                bridgeHelper2.f390368e = str;
                bridgeHelper2.f390369f.clear();
            }
            bridgeHelper = C;
        }
        return bridgeHelper;
    }

    public String a(String str) {
        e();
        return this.f390369f.get(str);
    }

    public void e() {
        if (!this.f390370h.get() && !this.f390371i) {
            this.f390371i = true;
            this.f390372m = 2;
            ThreadManager.getFileThreadHandler().post(C);
        }
    }

    public void f(ConfigurationService$Config configurationService$Config) {
        if (configurationService$Config.version != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,version: " + configurationService$Config.version.get());
            }
            ea.U3(this.f390367d, configurationService$Config.version.get(), this.f390368e);
        }
        if (configurationService$Config.content_list != null) {
            synchronized (D) {
                this.f390369f.clear();
            }
            this.f390370h.set(true);
            List<String> list = configurationService$Config.content_list.get();
            if (list != null && list.size() != 0) {
                for (String str : list) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,content: " + str);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        try {
                            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
                            String str2 = "";
                            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                                if (eventType == 2) {
                                    if (newPullParser.getDepth() == 2) {
                                        str2 = newPullParser.getName();
                                    } else if (newPullParser.getDepth() == 3) {
                                        String name = newPullParser.getName();
                                        newPullParser.next();
                                        String str3 = str2 + "_" + name;
                                        String text = newPullParser.getText();
                                        synchronized (D) {
                                            this.f390369f.put(str3, text);
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.i("GeneralEntryConfigManager", 2, "config put. " + str3 + ProgressTracer.SEPARATOR + text);
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        } catch (XmlPullParserException e17) {
                            e17.printStackTrace();
                        }
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,content_list is empty ");
                }
                File file = new File(this.f390367d.getFilesDir(), "entry_config_file_" + this.f390368e);
                if (file.exists()) {
                    file.delete();
                }
            }
            ThreadManager.getFileThreadHandler().removeCallbacks(C);
            this.f390372m = 1;
            ThreadManager.getFileThreadHandler().post(C);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] fileToBytes;
        int i3 = this.f390372m;
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.w("GeneralEntryConfigManager", 2, "Write configContent to file: " + this.f390369f);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(this.f390369f);
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("GeneralEntryConfigManager", 2, "Exception happened while construct ObjectOutputStream. ", e16);
                }
            }
            FileUtils.pushData2File(new File(this.f390367d.getFilesDir(), "entry_config_file_" + this.f390368e).getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
            return;
        }
        if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.w("GeneralEntryConfigManager", 2, "Read configContent from file.");
            }
            File file = new File(this.f390367d.getFilesDir(), "entry_config_file_" + this.f390368e);
            if (file.exists() && (fileToBytes = FileUtils.fileToBytes(file)) != null) {
                try {
                    Object readObject = new ObjectInputStream(new ByteArrayInputStream(fileToBytes)).readObject();
                    if (!this.f390370h.get() && (readObject instanceof HashMap)) {
                        synchronized (D) {
                            this.f390369f.clear();
                            this.f390369f.putAll((HashMap) readObject);
                        }
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e("GeneralEntryConfigManager", 2, "Exception happened while construct ObjectInputStream. ", e17);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("GeneralEntryConfigManager", 2, "configContent: " + this.f390369f.toString());
            }
        }
    }
}
