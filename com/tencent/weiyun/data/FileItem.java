package com.tencent.weiyun.data;

import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileItem extends CNativeObject {
    static IPatchRedirector $redirector_ = null;
    public static final int DATA_FROM_CLOUD = 2;
    public static final int DATA_FROM_DB = 1;
    public static final int LIB_AUDIO = 3;
    public static final int LIB_CLOUD_GALLERY = 24;
    public static final int LIB_DOC = 1;
    public static final int LIB_IMAGE = 2;
    public static final int LIB_OTHER = 5;
    public static final int LIB_VIDEO = 4;
    private String batchId;
    private int commentCount;
    private long createTime;
    private long currentSize;
    private DownloadServerInfo downloadServerInfo;
    private long duration;
    private String eventId;
    private String fileId;
    private String fileName;
    private long fileSize;
    private int fileVersion;
    private String fullPath;
    private int height;
    private double latitude;
    private int libId;
    private int likeCount;
    private double longitude;
    private String md5;
    private long modifyTime;
    private String orgSha;
    private long orgSize;
    private String pDirKey;
    private String pDirName;
    private String ppDirKey;
    private String sha;
    private boolean starFlag;
    private long starTime;
    private long takenTime;
    private String thumbUrl;
    private UploadServerInfo uploadServerInfo;
    private String uploaderNickname;
    private long uploaderUin;
    private int width;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class DownloadServerInfo {
        static IPatchRedirector $redirector_;
        public String cookie;
        public String downloadKey;
        public String serverDns;
        public String serverIp;
        public String serverName;
        public int serverPort;
        public String url;
        public String videoUrl;

        public DownloadServerInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class UploadServerInfo {
        static IPatchRedirector $redirector_;
        public int channelCount;
        public String checkKey;
        public boolean fileExist;
        public boolean isAuto;
        public String serverIp;
        public String serverName;
        public int serverPort;
        public String url;

        public UploadServerInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    FileItem() {
        super(0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            this.modifyTime = -1L;
            this.takenTime = -1L;
        }
    }

    public static FileItem createFile(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            FileItem fileItem = new FileItem();
            fileItem.fileId = str;
            fileItem.fileName = str2;
            fileItem.pDirKey = str3;
            return fileItem;
        }
        throw new IllegalArgumentException("createFile: the params fileId, fileName and pDirKey should be valid.");
    }

    public static FileItem newInstance(long j3) {
        if (j3 == 0) {
            return null;
        }
        return new FileItem(j3);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (this.nativePtr != 0) {
            this.fileName = null;
            this.pDirKey = null;
            this.sha = null;
            this.fileId = null;
            this.md5 = null;
        }
    }

    public String getBatchId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, JobDbManager.COL_UP_BATCH_ID);
    }

    public int getCommentCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return CBundleReader.getInt(this.nativePtr, "comment_count", 0);
    }

    public long getCreateTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return CBundleReader.getLong(this.nativePtr, AlbumCacheData.CREATE_TIME, 0L);
    }

    public long getCurrentSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return CBundleReader.getLong(this.nativePtr, "current_size", 0L);
    }

    public DownloadServerInfo getDownloadServerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (DownloadServerInfo) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        DownloadServerInfo downloadServerInfo = new DownloadServerInfo();
        String string = CBundleReader.getString(this.nativePtr, "download_key");
        downloadServerInfo.downloadKey = string;
        if (TextUtils.isEmpty(string)) {
            downloadServerInfo.downloadKey = CBundleReader.getString(this.nativePtr, "share_key");
        }
        downloadServerInfo.url = CBundleReader.getString(this.nativePtr, "download_url");
        downloadServerInfo.videoUrl = CBundleReader.getString(this.nativePtr, "download_video_url");
        downloadServerInfo.serverName = CBundleReader.getString(this.nativePtr, "download_server_name");
        downloadServerInfo.serverIp = CBundleReader.getString(this.nativePtr, "download_server_ip");
        downloadServerInfo.serverPort = CBundleReader.getInt(this.nativePtr, "download_server_port", 80);
        downloadServerInfo.serverDns = CBundleReader.getString(this.nativePtr, "download_server_dns");
        String string2 = CBundleReader.getString(this.nativePtr, "download_cookie");
        downloadServerInfo.cookie = string2;
        if (TextUtils.isEmpty(string2)) {
            String string3 = CBundleReader.getString(this.nativePtr, "download_cookie_name");
            String string4 = CBundleReader.getString(this.nativePtr, "download_cookie_value");
            if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                downloadServerInfo.cookie = string3 + '=' + string4;
            }
        }
        return downloadServerInfo;
    }

    public long getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return CBundleReader.getLong(this.nativePtr, "duration", 0L);
    }

    public String getEventId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, "event_id");
    }

    public String getFileId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, "file_id");
    }

    public String getFileName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (TextUtils.isEmpty(this.fileName)) {
            return CBundleReader.getString(this.nativePtr, "file_name");
        }
        return this.fileName;
    }

    public long getFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return CBundleReader.getLong(this.nativePtr, "file_size", 0L);
    }

    public int getFileVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return CBundleReader.getInt(this.nativePtr, "file_version", 0);
    }

    public String getFullPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, "full_path");
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return CBundleReader.getInt(this.nativePtr, "height", 0);
    }

    public double getLatitude() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Double) iPatchRedirector.redirect((short) 21, (Object) this)).doubleValue();
        }
        return CBundleReader.getDouble(this.nativePtr, "latitude", 0.0d);
    }

    public int getLibId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return CBundleReader.getInt(this.nativePtr, "lib_id", 5);
    }

    public int getLikeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return CBundleReader.getInt(this.nativePtr, "like_count", 0);
    }

    public double getLongitude() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Double) iPatchRedirector.redirect((short) 20, (Object) this)).doubleValue();
        }
        return CBundleReader.getDouble(this.nativePtr, "longitude", 0.0d);
    }

    public String getMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return CBundleReader.getHexString(this.nativePtr, "md5").toLowerCase();
    }

    public long getModifyTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        if (this.modifyTime == -1) {
            this.modifyTime = CBundleReader.getLong(this.nativePtr, "modify_time", 0L);
        }
        return this.modifyTime;
    }

    public String getOrgSha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        long j3 = this.nativePtr;
        if (j3 != 0) {
            return CBundleReader.getHexString(j3, "org_file_sha").toLowerCase();
        }
        return this.orgSha;
    }

    public long getOrgSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Long) iPatchRedirector.redirect((short) 41, (Object) this)).longValue();
        }
        long j3 = this.nativePtr;
        if (j3 != 0) {
            return CBundleReader.getLong(j3, "org_file_size", 0L);
        }
        return this.orgSize;
    }

    public String getPpDirKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return CBundleReader.getHexString(this.nativePtr, JobDbManager.COL_UP_PP_DIR_KEY);
    }

    public String getSha() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return CBundleReader.getHexString(this.nativePtr, WidgetCacheLunarData.SHA).toLowerCase();
    }

    public long getStarTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return CBundleReader.getLong(this.nativePtr, "star_time", 0L);
    }

    public long getTakenTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        if (this.takenTime == -1) {
            this.takenTime = CBundleReader.getLong(this.nativePtr, JobDbManager.COL_UP_TAKEN_TIME, 0L);
        }
        return this.takenTime;
    }

    public String getThumbUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, FacadeCacheData.THUMB_URL);
    }

    public String getUploadFullPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, "backup_path");
    }

    public UploadServerInfo getUploadServerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (UploadServerInfo) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        UploadServerInfo uploadServerInfo = new UploadServerInfo();
        uploadServerInfo.url = CBundleReader.getString(this.nativePtr, "upload_server_url");
        uploadServerInfo.isAuto = CBundleReader.getBoolean(this.nativePtr, "is_auto", false);
        uploadServerInfo.fileExist = CBundleReader.getBoolean(this.nativePtr, "file_exist", false);
        uploadServerInfo.checkKey = CBundleReader.getHexString(this.nativePtr, "upload_check_key");
        uploadServerInfo.serverName = CBundleReader.getString(this.nativePtr, "upload_server_name");
        uploadServerInfo.serverIp = CBundleReader.getString(this.nativePtr, "upload_server_ip");
        uploadServerInfo.serverPort = CBundleReader.getInt(this.nativePtr, "upload_server_port", 80);
        uploadServerInfo.channelCount = CBundleReader.getInt(this.nativePtr, "upload_channel_count", 0);
        return uploadServerInfo;
    }

    public String getUploaderNickname() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, "uploader_nickname");
    }

    public long getUploaderUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return CBundleReader.getLong(this.nativePtr, "uploader_uin", 0L);
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return CBundleReader.getInt(this.nativePtr, "width", 0);
    }

    public String getpDirKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return CBundleReader.getHexString(this.nativePtr, "p_dir_key");
    }

    public String getpDirName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CBundleReader.getString(this.nativePtr, JobDbManager.COL_UP_P_DIR_NAME);
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        if (this.nativePtr != 0) {
            this.fileName = getFileName();
            this.pDirKey = getpDirKey();
            this.sha = getSha();
            this.fileId = getFileId();
            this.fileSize = getFileSize();
            this.latitude = getLatitude();
            this.longitude = getLongitude();
            this.takenTime = getTakenTime();
            this.duration = getDuration();
            this.width = getWidth();
            this.height = getHeight();
            this.md5 = getMd5();
        }
    }

    public boolean isStarFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return CBundleReader.getBoolean(this.nativePtr, "star_flag", false);
    }

    @Override // com.tencent.weiyun.data.CNativeObject
    public /* bridge */ /* synthetic */ void releaseNative() {
        super.releaseNative();
    }

    public void setFileName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) str);
        } else {
            this.fileName = str;
        }
    }

    public void setModifyTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
        } else {
            this.modifyTime = j3;
        }
    }

    public void setTakenTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, j3);
        } else {
            this.takenTime = j3;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FileItem m289clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (FileItem) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        try {
            return (FileItem) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    FileItem(long j3) {
        super(j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, j3);
        } else {
            this.modifyTime = -1L;
            this.takenTime = -1L;
        }
    }
}
