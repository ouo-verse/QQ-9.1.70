package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import android.content.res.AssetManager;
import com.qq.wx.voice.embedqqegg.util.LogTool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40938a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f40939b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f40940c = "libwxvoiceembedqqegg.bin";

    public final String a() {
        return this.f40939b;
    }

    public final String b() {
        return this.f40940c;
    }

    public final int a(Context context) {
        String str;
        if (this.f40938a) {
            return 0;
        }
        if (InfoRecognizer.f40912c == null) {
            String str2 = String.valueOf(context.getFilesDir().getAbsolutePath()) + "/wxvoiceembed/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
            String str3 = String.valueOf(str2) + "grammar/";
            File file2 = new File(str3);
            if (!file2.exists()) {
                file2.mkdir();
            }
            String str4 = String.valueOf(str3) + SDKVersion.Ver;
            File file3 = new File(str4);
            AssetManager assets = context.getAssets();
            if (!file3.exists()) {
                File[] listFiles = new File(str3).listFiles();
                if (listFiles != null) {
                    for (File file4 : listFiles) {
                        a(file4);
                    }
                }
                file3.mkdir();
                str = String.valueOf(str4) + "/";
                try {
                    a(assets, this.f40940c, str);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return -1;
                }
            } else {
                str = String.valueOf(str4) + "/";
                try {
                    if (!new File(String.valueOf(str) + this.f40940c).exists()) {
                        a(assets, this.f40940c, str);
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return -1;
                }
            }
            this.f40939b = str;
        } else {
            if (!new File(InfoRecognizer.f40912c).exists()) {
                LogTool.d("no found " + InfoRecognizer.f40912c);
                return -1;
            }
            this.f40939b = "";
            this.f40940c = "";
            int lastIndexOf = InfoRecognizer.f40912c.lastIndexOf("/");
            if (lastIndexOf != -1) {
                this.f40939b = InfoRecognizer.f40912c.substring(0, lastIndexOf);
                this.f40940c = InfoRecognizer.f40912c.substring(lastIndexOf + 1);
            }
            LogTool.d("init by binWXVoiceEmbedPath: " + InfoRecognizer.f40912c);
            LogTool.d("mPath = " + this.f40939b);
            LogTool.d("mData = " + this.f40940c);
        }
        this.f40938a = true;
        return 0;
    }

    private static void a(AssetManager assetManager, String str, String str2) {
        InputStream open = assetManager.open(str);
        byte[] bArr = new byte[2048];
        File file = new File(String.valueOf(str2) + str);
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            int read = open.read(bArr);
            if (read == -1) {
                fileOutputStream.close();
                open.close();
                return;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    private void a(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    a(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }
}
