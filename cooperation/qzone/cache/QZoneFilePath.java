package cooperation.qzone.cache;

import android.os.Environment;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vfs.b;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* loaded from: classes28.dex */
public class QZoneFilePath {
    public static final String AUDIO_SAVE_PATH;
    public static final String BACKUP_DIR;
    public static final String BEAUTY_IMG_PATH;
    public static final String CACHE_DIR_FEEDS;
    public static final String CACHE_DIR_FILE;
    public static final String CACHE_DIR_IMAGE;
    public static final String CACHE_DIR_IMAGE_SR;
    public static final String CACHE_DIR_VIDEO;
    public static final String CACHE_DIR_VIDEO_PLAY;
    public static final String CACHE_DYNAMIC_ALBUM;
    public static final String DCIMDir;
    public static final String DCIM_CAMERA_PATH;
    public static final String JCE_DATA_DIR;
    public static final String QQ_EMOTICON_DIR;
    public static final String ROOT_PATH;
    public static final String ROOT_QZONE_PATH;
    public static final String SERVER_DIR;
    public static final String TESTSERVER_PATH;
    public static final String THUMB_BASE_PATH;
    public static final String TRACE_FILE_PATH;
    public static final String VGIF_SAVE;
    public static final String VIDEO_CONFIG;
    public static final String VIDEO_COVER_TMP_CACHE_DIR;
    public static final String WNS_PATH;

    static {
        String e16 = b.i().e();
        ROOT_PATH = e16;
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("qzone");
        ROOT_QZONE_PATH = sDKPrivatePath;
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
        DCIMDir = path;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(path);
        String str = File.separator;
        sb5.append(str);
        sb5.append("Camera");
        DCIM_CAMERA_PATH = sb5.toString();
        VGIF_SAVE = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/AlbumAutoVConvGif/");
        AUDIO_SAVE_PATH = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/VoiceMoodAudio/");
        JCE_DATA_DIR = VFSAssistantUtils.getSDKPrivatePath("jcedata/businessdata/");
        THUMB_BASE_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qzone" + str + "thumbs" + str);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(sDKPrivatePath);
        sb6.append(str);
        sb6.append("MaxVideo");
        VIDEO_COVER_TMP_CACHE_DIR = sb6.toString();
        BEAUTY_IMG_PATH = e16 + str + "ix.jpg";
        TRACE_FILE_PATH = e16 + str + "Tencent" + str + "MobileQQ" + str + "trace";
        StringBuilder sb7 = new StringBuilder();
        sb7.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        sb7.append("/testEnv");
        String sb8 = sb7.toString();
        SERVER_DIR = sb8;
        TESTSERVER_PATH = sb8 + str + "testserver";
        BACKUP_DIR = e16 + str + "Tencent" + str + "qzonebackup";
        WNS_PATH = e16 + str + "Tencent" + str + "wns";
        StringBuilder sb9 = new StringBuilder();
        sb9.append(e16);
        sb9.append(str);
        sb9.append("Tencent/Qzone/qzonedynamicalbum/");
        CACHE_DYNAMIC_ALBUM = sb9.toString();
        CACHE_DIR_IMAGE = VFSAssistantUtils.getSDKPrivatePath("qzone" + str + ImageManager.IMAGE_DIR_NAME_V2);
        CACHE_DIR_VIDEO = VFSAssistantUtils.getSDKPrivatePath("qzone" + str + "video");
        CACHE_DIR_VIDEO_PLAY = VFSAssistantUtils.getSDKPrivatePath("qzone" + str + CacheManager.VIDEO_PLAY_CACHE_DIR);
        CACHE_DIR_IMAGE_SR = VFSAssistantUtils.getSDKPrivatePath("qzone" + str + ImageManager.IMAGE_DIR_NAME_SR);
        CACHE_DIR_FILE = VFSAssistantUtils.getSDKPrivatePath("qzone" + str + "file");
        CACHE_DIR_FEEDS = VFSAssistantUtils.getSDKPrivatePath("qzone" + str + "feeds");
        QQ_EMOTICON_DIR = VFSAssistantUtils.getSDKPrivatePath("Tencent/mobileqq/.emotionsm/");
        VIDEO_CONFIG = VFSAssistantUtils.getSDKPrivatePath("Tencent/qzone_video_local_config.json");
    }
}
