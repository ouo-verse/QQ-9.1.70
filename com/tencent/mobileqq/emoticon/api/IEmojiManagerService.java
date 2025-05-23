package com.tencent.mobileqq.emoticon.api;

import android.os.Bundle;
import com.tencent.image.JobQueue;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.ReqInfo;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes12.dex */
public interface IEmojiManagerService extends IRuntimeService {
    int addEmotionTaskByList(EmoticonPackage emoticonPackage, ArrayList<Emoticon> arrayList, List<String> list, Map<String, File> map, Bundle bundle, int i3);

    void addH5MagicChildDownloadTask(EmoticonPackage emoticonPackage, boolean z16);

    void addThumbTask(List<String> list, Map<String, File> map, EmoticonPackage emoticonPackage, Bundle bundle);

    boolean canPlayH5Magic();

    int collectEmoji(Emoticon emoticon);

    int collectEmoji(Emoticon emoticon, boolean z16);

    boolean downloadAIOEmoticon(Emoticon emoticon, int i3);

    void fetchEmoticonEncryptKeys(String str, ArrayList<Emoticon> arrayList);

    void fetchEmoticonEncryptKeys(String str, ArrayList<Emoticon> arrayList, ReqInfo reqInfo);

    void generateFileList(String str, String str2);

    Bundle getAllDownloadProgress(int i3);

    Bundle getDownloadProgress(Bundle bundle);

    h getDownloader();

    JobQueue getEmoQueue();

    IEmojiListenerManager getEmojiListenerManager();

    float getEmoticonPackageLoadingProgress(String str);

    boolean getHaveInitFav();

    boolean getHaveInitSmallAndNormal();

    String[] getImgPreviewTask(String str, String str2, boolean z16);

    boolean getMagicFaceSendAccessControl();

    ConcurrentHashMap<String, TaskStatus> getStatusMap();

    void handleEmoticonPackageDownloaded(Bundle bundle, Object obj, boolean z16, int i3, String str, long j3, int i16);

    void handleEmotionEncryptKey(g gVar);

    void handleMagicOrH5MagicDownloadOnDoneFile(g gVar);

    boolean isDPCSupportH5Magic();

    boolean isEmojiCollected(Emoticon emoticon);

    boolean isH5MagicFacePackageIntact(String str, boolean z16, boolean z17);

    boolean isH5MagicIntact(String str, boolean z16, boolean z17);

    boolean isMagicFacePackageIntact(String str, Boolean bool);

    void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16);

    void pullEmoticonPackage(EmoticonPackage emoticonPackage, boolean z16, boolean z17, int i3);

    boolean sendEmojiToAio(Emoticon emoticon);

    void setHaveInitFav(boolean z16);

    void setHaveInitSmallAndNormal(boolean z16);

    void setStatusMap(ConcurrentHashMap<String, TaskStatus> concurrentHashMap);

    void startCoverDownload(EmoticonPackage emoticonPackage);

    Bundle startDownloadEmoji(Bundle bundle);

    void startDownloadEmosmJson(String str, int i3);

    void startDownloadEmosmJson(String str, int i3, int i16);

    void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16);

    void startDownloadEmosmJson(String str, int i3, Bundle bundle, boolean z16, int i16);

    Bundle stopDownloadPacket(String str, int i3);

    void stopEmoticonPackageDownload(String str);

    boolean supportExtensionDisplay(Emoticon emoticon);

    boolean tasksFileExists(Emoticon emoticon, int i3);

    boolean verifyMagicFacePackageIntact(String str);
}
