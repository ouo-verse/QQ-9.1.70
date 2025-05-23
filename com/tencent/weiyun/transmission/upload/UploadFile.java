package com.tencent.weiyun.transmission.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.utils.TsLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadFile implements Cloneable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UploadFile";
    public String album;
    public String artist;
    public boolean autoBackupFlag;
    public final String batchDesc;
    public String batchId;
    public final int batchIndex;
    public final int batchTotal;
    public final int cmdType;
    public String compressedPath;
    public String compressedSha;
    public long compressedSize;
    public String[] compressedSliceSha;
    public String coverFileId;
    public String coverFileVersion;
    public long duration;
    public String fileName;
    public long fileSize;
    public String groupRootDirKey;
    public int height;
    public final boolean isCompress;
    public long lastModified;
    public double latitude;
    public String localPath;
    public double longitude;
    public String mimeType;
    public String pDirKey;
    public String pDirName;
    public String pPDirKey;
    public final String rootDirUid;
    public UploadServerInfo serverInfo;
    public String sha;
    public String[] sliceSha;
    public long takenTime;
    public String thumbUrl;
    public UploadType uploadType;
    public int width;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class UploadBatch {
        static IPatchRedirector $redirector_;
        private String desc;

        /* renamed from: id, reason: collision with root package name */
        private String f384462id;
        private int total;

        public UploadBatch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class UploadServerInfo implements Cloneable {
        static IPatchRedirector $redirector_;
        public int channelCount;
        public String checkKey;
        public boolean fileExist;
        public String fileId;
        public String fileVersion;
        public String serverIp;
        public String serverName;
        public int serverPort;

        public UploadServerInfo(boolean z16, String str, String str2, String str3, int i3, String str4, int i16, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UploadFile.this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), str4, Integer.valueOf(i16), str5);
                return;
            }
            this.fileExist = z16;
            this.fileId = str;
            this.serverName = str2;
            this.serverIp = str3;
            this.serverPort = i3;
            this.checkKey = str4;
            this.channelCount = i16;
            this.fileVersion = str5;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public UploadServerInfo m291clone() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (UploadServerInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            try {
                return (UploadServerInfo) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    UploadFile(int i3, String str, String str2, String str3, String str4, String str5, boolean z16, UploadBatch uploadBatch, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, str3, str4, str5, Boolean.valueOf(z16), uploadBatch, Integer.valueOf(i16));
            return;
        }
        this.cmdType = i3;
        this.rootDirUid = str;
        this.pDirName = str2;
        this.pDirKey = str3;
        this.pPDirKey = str4;
        this.localPath = str5;
        this.isCompress = z16;
        this.batchId = uploadBatch.f384462id;
        this.batchTotal = uploadBatch.total;
        this.batchIndex = i16;
        this.batchDesc = uploadBatch.desc;
    }

    public static UploadBatch createUploadBatch(int i3, String str) {
        if (i3 <= 0) {
            return null;
        }
        UploadBatch uploadBatch = new UploadBatch();
        uploadBatch.f384462id = Long.toString(System.currentTimeMillis());
        uploadBatch.total = i3;
        uploadBatch.desc = str;
        return uploadBatch;
    }

    public static UploadFile createUploadFile(int i3, String str, String str2, String str3, String str4, String str5, boolean z16, UploadBatch uploadBatch, int i16) {
        if (!TextUtils.isEmpty(str5) && uploadBatch != null && i16 >= 1 && i16 <= uploadBatch.total) {
            return new UploadFile(i3, str, str2, str3, str4, str5, z16, uploadBatch, i16);
        }
        throw new IllegalArgumentException("The params localPath, batch and batchIndex should be valid.");
    }

    public void setServerInfo(boolean z16, String str, String str2, String str3, int i3, String str4, int i16, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3), str4, Integer.valueOf(i16), str5);
        } else if (!z16 && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            TsLog.w(TAG, "UploadServerInfo create error: the params serverName and serverIp are all empty.");
        } else {
            this.serverInfo = new UploadServerInfo(z16, str, str2, str3, i3, str4, i16, str5);
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public UploadFile m290clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UploadFile) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            return (UploadFile) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
