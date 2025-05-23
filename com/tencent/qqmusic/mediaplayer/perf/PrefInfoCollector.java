package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Xml;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes23.dex */
public class PrefInfoCollector implements PlayerInfoCollector {
    private static final String ENCODING_UTF_8 = "utf-8";
    private static final String FILE_NAME = "pref_infos.xml";
    private static final String NAMESPACE = null;
    private static final String ROOT = "root";
    private static final String TAG = "PrefInfoCollector";
    private static PrefInfoCollector instance;
    private HandlerThread mHandlerThread;
    private Handler mReportHandler;
    private FileOutputStream outputStream;
    private HashMap<String, Long> prefInfos;
    private String reportFilePath;
    private XmlSerializer xmlSerializer;

    PrefInfoCollector() {
        this.prefInfos = null;
        this.xmlSerializer = null;
        this.prefInfos = new HashMap<>();
        this.xmlSerializer = Xml.newSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createOutputs() {
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), FILE_NAME);
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
            String str = TAG;
            Logger.d(str, "setInstrumentation: outputFile: " + file);
            this.reportFilePath = file.getAbsolutePath();
            this.outputStream = new FileOutputStream(file);
            Logger.d(str, "setInstrumentation: outputFilepath: " + this.reportFilePath);
            try {
                this.xmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                this.xmlSerializer.setOutput(this.outputStream, "utf-8");
                this.xmlSerializer.startDocument("utf-8", Boolean.TRUE);
            } catch (IOException e16) {
                Logger.e(TAG, "Unable to open serializer", e16);
                throw new RuntimeException("Unable to open serializer: " + e16.getMessage(), e16);
            }
        } catch (FileNotFoundException e17) {
            Logger.e(TAG, "Unable to open report file: pref_infos.xml", e17);
            throw new RuntimeException("Unable to open report file: " + e17.getMessage(), e17);
        } catch (IOException e18) {
            Logger.e(TAG, "Unable to create report file: pref_infos.xml", e18);
            throw new RuntimeException("Unable to create report file: " + e18.getMessage(), e18);
        }
    }

    public static synchronized PrefInfoCollector getInstance() {
        PrefInfoCollector prefInfoCollector;
        synchronized (PrefInfoCollector.class) {
            if (instance == null) {
                instance = new PrefInfoCollector();
            }
            prefInfoCollector = instance;
        }
        return prefInfoCollector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printPrefInfos(AudioInformation audioInformation) throws IOException {
        ArrayList<Map.Entry> arrayList = new ArrayList(this.prefInfos.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Long>>() { // from class: com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
                if (entry.getKey().charAt(0) > entry2.getKey().charAt(0)) {
                    return 1;
                }
                return entry.getKey().charAt(0) == entry2.getKey().charAt(0) ? 0 : -1;
            }
        });
        if (!arrayList.isEmpty()) {
            this.xmlSerializer.startTag(NAMESPACE, ROOT);
            printProperty("device.manufacturer", Build.MANUFACTURER);
            printProperty("device.model", DeviceInfoMonitor.getModel());
            printProperty("device.apiLevel", String.valueOf(Build.VERSION.SDK_INT));
            printAudioInfomation(audioInformation);
            for (Map.Entry entry : arrayList) {
                long longValue = ((Long) entry.getValue()).longValue();
                printProperty((String) entry.getKey(), longValue + "");
            }
            this.xmlSerializer.endTag(NAMESPACE, ROOT);
            this.xmlSerializer.endDocument();
            this.xmlSerializer.flush();
        }
    }

    private void printProperty(String str, String str2) throws IOException {
        XmlSerializer xmlSerializer = this.xmlSerializer;
        String str3 = NAMESPACE;
        xmlSerializer.startTag(str3, str);
        this.xmlSerializer.text(str2);
        this.xmlSerializer.endTag(str3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upLoadByCommonPost() throws IOException {
        Logger.i(TAG, "upLoadByCommonPost");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(" http://musict.proxy.music.qq.com/qmtm2/PlayPerformanceReport.fcg").openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty(HttpHeader.RSP.CHARSET, "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", MediaType.TEXT_XML_VALUE);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        FileInputStream fileInputStream = new FileInputStream(this.reportFilePath);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read != -1) {
                dataOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                String readLine = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")).readLine();
                Logger.i(TAG, "upload result:" + readLine);
                dataOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }

    public void printAudioInfomation(AudioInformation audioInformation) throws IOException {
        printProperty("audio.format", audioInformation.getAudioType() + "");
        printProperty("audio.sampleRate", audioInformation.getSampleRate() + "");
        printProperty("audio.PlaySample", audioInformation.getPlaySample() + "");
        printProperty("audio.bitDepth", audioInformation.getBitDepth() + "");
        printProperty("audio.channels", audioInformation.getChannels() + "");
        printProperty("audio.duration", audioInformation.getDuration() + "");
        printProperty("audio.bitRate", audioInformation.getBitrate() + "");
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putLong(String str, long j3) {
        this.prefInfos.put(str, Long.valueOf(j3));
    }

    public void upLoadPrefInfos(final AudioInformation audioInformation) {
        HashMap<String, Long> hashMap = this.prefInfos;
        if (hashMap != null && !hashMap.isEmpty()) {
            if (this.mHandlerThread == null || this.mReportHandler == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG);
                this.mHandlerThread = baseHandlerThread;
                baseHandlerThread.start();
                this.mReportHandler = new Handler(this.mHandlerThread.getLooper());
            }
            this.mReportHandler.post(new Runnable() { // from class: com.tencent.qqmusic.mediaplayer.perf.PrefInfoCollector.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PrefInfoCollector.this.createOutputs();
                        PrefInfoCollector.this.printPrefInfos(audioInformation);
                        PrefInfoCollector.this.upLoadByCommonPost();
                    } catch (Exception e16) {
                        Logger.e(PrefInfoCollector.TAG, e16);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putBoolean(String str, boolean z16) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putInt(String str, int i3) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putString(String str, String str2) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector
    public void putUri(String str, Uri uri) {
    }
}
