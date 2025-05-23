package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.w;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TimeoutParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileManagerUtilImpl implements IFileManagerUtil {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Comparator<Map.Entry<String, Integer>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry2.getValue().intValue() - entry.getValue().intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements Comparator<FileInfo> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(FileInfo fileInfo, FileInfo fileInfo2) {
            return (int) ((fileInfo2.e() / 1000) - (fileInfo.e() / 1000));
        }
    }

    private static String getDocFileType(String str) {
        if (str != null && str.length() != 0) {
            String lowerCase = str.toLowerCase();
            if (".doc|.docx|.wps|.pages|".indexOf(lowerCase) >= 0) {
                return "WORD";
            }
            if (".ppt|.pptx|.dps|.keynote|".indexOf(lowerCase) >= 0) {
                return "PPT";
            }
            if (".xls|.xlsx|.et|.numbers|".indexOf(lowerCase) >= 0) {
                return "EXCEL";
            }
            if (".pdf|".indexOf(lowerCase) >= 0) {
                return "PDF";
            }
            return HardCodeUtil.qqStr(R.string.bae);
        }
        return HardCodeUtil.qqStr(R.string.bae);
    }

    private String getGroupName(String str, int i3) {
        String qqStr = HardCodeUtil.qqStr(R.string.bae);
        if (i3 != 3) {
            if (i3 == 11) {
                return getOtherFileType(str);
            }
            return qqStr;
        }
        return getDocFileType(str);
    }

    private static String getOtherFileType(String str) {
        if (str != null && str.length() != 0) {
            String lowerCase = str.toLowerCase();
            if (".rar|.zip|.7z|.iso|.tar|.gz|".indexOf(lowerCase) >= 0) {
                return HardCodeUtil.qqStr(R.string.f1354901l);
            }
            if (".txt|.html|.lit|.wdl|.ceb|.pdg|.epub|.caj|.umd|.jar|.mobi|".indexOf(lowerCase) >= 0) {
                return HardCodeUtil.qqStr(R.string.f1354801k);
            }
            if (".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|".indexOf(lowerCase) >= 0) {
                return HardCodeUtil.qqStr(R.string.f1354601i);
            }
            return HardCodeUtil.qqStr(R.string.f1354501h);
        }
        return HardCodeUtil.qqStr(R.string.f1354501h);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void addCloseButtonSessionId(long j3) {
        QQFileManagerUtilImpl.m(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int addExternalFileToFMRecv(String str) {
        return QQFileManagerUtilImpl.n(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void addShortcut(BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3) {
        QQFileManagerUtilImpl.o(baseQQAppInterface, context, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void associateLocalWithCloud(FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.s(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean bShowFlowDlg(boolean z16, ArrayList<FileManagerEntity> arrayList) {
        return QQFileManagerUtilImpl.t(z16, arrayList);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean bZip(int i3) {
        return QQFileManagerUtilImpl.u(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String binToHEX(ByteStringMicro byteStringMicro) {
        return QQFileManagerUtilImpl.v(byteStringMicro);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int binanrySearch(List<FileInfo> list, long j3) {
        return QQFileManagerUtilImpl.w(list, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void calcFileDescription(TextView textView, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.x(textView, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean canCreateThumb(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.y(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean canPreview(Context context, String str, long j3) {
        return QQFileManagerUtilImpl.A(context, str, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int chechFileType(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.C(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int chechZipFileType(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.D(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void checkFileExisted(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, ah.a aVar) {
        QQFileManagerUtilImpl.E(fileManagerEntity, baseQQAppInterface, aVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean checkMultiFileBubbleClickable(ChatMessage chatMessage, BaseQQAppInterface baseQQAppInterface, Context context) {
        return QQFileManagerUtilImpl.F(chatMessage, baseQQAppInterface, context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void clearAllRecentFileForTest() {
        QQFileManagerUtilImpl.H();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void clearRememberPicSelectForQlink(Context context) {
        QQFileManagerUtilImpl.I(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void correctFileInfo(FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.K(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity createFileRecordForMultiMsg(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage) {
        return QQFileManagerUtilImpl.L(baseQQAppInterface, chatMessage);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void createMediThumbnail(FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.M(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public ah.e createMediaFileThumbSizeInfo(int i3, String str) {
        return QQFileManagerUtilImpl.N(i3, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String createMediaThumbnail(String str, int i3, int i16, ah.d dVar) {
        return QQFileManagerUtilImpl.O(str, i3, i16, dVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String createVideoThumbPath(String str) {
        return QQFileManagerUtilImpl.S(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String cutLongLongFileName(String str, int i3) {
        return QQFileManagerUtilImpl.T(str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String cutLongName(String str) {
        return QQFileManagerUtilImpl.U(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void dealWithErrCode(String str) {
        QQFileManagerUtilImpl.a0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void dealWithErrCodeById(int i3) {
        QQFileManagerUtilImpl.c0(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void dealWithTransFileFaild(long j3, int i3, String str) {
        QQFileManagerUtilImpl.f0(j3, i3, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void dealWithTransFileSuc(long j3) {
        QQFileManagerUtilImpl.g0(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void delCloseButtonSessionId(long j3) {
        QQFileManagerUtilImpl.i0(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int delExternalFileFromFMRecv(String str) {
        return QQFileManagerUtilImpl.j0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void downloadUniformQQBrowser(Context context, String str, Bundle bundle) {
        QQFileManagerUtilImpl.l0(context, str, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String enCodecString(String str) {
        return QQFileManagerUtilImpl.m0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean fileExist(String str) {
        return QQFileManagerUtilImpl.n0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean fileWhetherExpire(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.o0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String filesizeToString(long j3) {
        return QQFileManagerUtilImpl.p0(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void fillFileMessageRecord(ChatMessage chatMessage, MessageForFile messageForFile) {
        QQFileManagerUtilImpl.q0(chatMessage, messageForFile);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean filterFiles(String str, String str2) {
        return QQFileManagerUtilImpl.r0(str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void fixEntityThumbSize(FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.s0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void forwardRencentFiles(List<FileManagerEntity> list, Activity activity) {
        QQFileManagerUtilImpl.t0(list, activity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public long genMsgSeq() {
        return QQFileManagerUtilImpl.u0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public long genMsgUid() {
        return QQFileManagerUtilImpl.v0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public Long genSessionId() {
        return QQFileManagerUtilImpl.w0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] get3SHA(String str) {
        return QQFileManagerUtilImpl.x0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public ArrayList<FileInfo> getAllFMRecvFiles(boolean z16, int i3) {
        return QQFileManagerUtilImpl.y0(z16, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public Map<String, File> getAllStorageLocations(Context context) {
        return QQFileManagerUtilImpl.z0(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public BaseQQAppInterface getApp() {
        return QQFileManagerUtilImpl.A0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public Bitmap getCircleFaceBitmap(Context context, Bitmap bitmap, int i3) {
        return QQFileManagerUtilImpl.B0(context, bitmap, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public SpannableString getClickableTips(String str, String str2, ah.f fVar) {
        return QQFileManagerUtilImpl.C0(str, str2, fVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public w getDatalineProcessCallBack(BaseQQAppInterface baseQQAppInterface, int i3) {
        return QQFileManagerUtilImpl.D0(baseQQAppInterface, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public HashMap<String, String> getDocsImportConfigGroupFromStr(String str) {
        return QQFileManagerUtilImpl.F0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public long getDocsImportFileMaxSize(String str) {
        return QQFileManagerUtilImpl.G0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getFMDownloadPath() {
        return QQFileManagerUtilImpl.H0();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileIconResId(int i3, int i16) {
        return QQFileManagerUtilImpl.J0(i3, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity getFileManagerEntityByMsgFile(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile) {
        return QQFileManagerUtilImpl.L0(baseQQAppInterface, messageForFile);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getFileName(String str) {
        return QQFileManagerUtilImpl.M0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getFileOperationTypeToPeer(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.N0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity getFileRecordForMultiMsg(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3, ChatMessage chatMessage) {
        return QQFileManagerUtilImpl.O0(baseQQAppInterface, j3, str, i3, chatMessage);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getFileSizeInvalidTime(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.P0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public long getFileSizes(String str) {
        return QQFileManagerUtilImpl.Q0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileSrcCloudType(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.R0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getFileSuffix(String str) {
        return QQFileManagerUtilImpl.S0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileType(String str) {
        return QQFileManagerUtilImpl.T0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileTypeByExtension(String str) {
        return QQFileManagerUtilImpl.V0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileTypeFromMultiMsgRecord(ChatMessage chatMessage) {
        return QQFileManagerUtilImpl.W0(chatMessage);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] getFullMd5(String str) {
        return QQFileManagerUtilImpl.X0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getHardCodeConfig(String str) {
        return QQFileManagerUtilImpl.Y0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getImageUrl(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.Z0(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] getMd5(String str, long j3) {
        return QQFileManagerUtilImpl.d1(str, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int[] getMediaFileWidthHeight(String str) {
        return QQFileManagerUtilImpl.e1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getMultiFileThumbPath(ChatMessage chatMessage) {
        return QQFileManagerUtilImpl.f1(chatMessage);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getPeerNick(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        return QQFileManagerUtilImpl.l1(baseQQAppInterface, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getQQStr(int i3) {
        return QQFileManagerUtilImpl.m1(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getQlinkIntroShowTime(String str) {
        return QQFileManagerUtilImpl.n1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getReportFileTypeStr(int i3) {
        return QQFileManagerUtilImpl.p1(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public AppRuntime getRuntime() {
        return QQFileManagerUtilImpl.r1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] getSHA(String str) {
        return QQFileManagerUtilImpl.s1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity getSelectedEntity() {
        return QQFileManagerUtilImpl.t1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] getSha3(String str) {
        return QQFileManagerUtilImpl.u1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void getSortMap(TreeMap<Long, FileInfo> treeMap, int i3, LinkedHashMap<String, List<FileInfo>> linkedHashMap, LinkedHashMap<String, List<FileInfo>> linkedHashMap2, List<FileInfo> list) {
        if (treeMap == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Iterator<Map.Entry<Long, FileInfo>> it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            FileInfo value = it.next().getValue();
            if (value == null) {
                return;
            }
            list.add(0, value);
            if (linkedHashMap2 != null) {
                String groupName = getGroupName(QQFileManagerUtilImpl.S0(value.j()), i3);
                if (!linkedHashMap2.containsKey(groupName)) {
                    linkedHashMap2.put(groupName, new ArrayList());
                }
                linkedHashMap2.get(groupName).add(value);
            }
            long e16 = value.e();
            String historyGroupByTime = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getHistoryGroupByTime(e16);
            if (!hashMap.containsValue(historyGroupByTime)) {
                hashMap.put(historyGroupByTime, Integer.valueOf((int) (e16 / 1000)));
            } else if (((Integer) hashMap.get(historyGroupByTime)).intValue() > e16) {
                hashMap.put(historyGroupByTime, Integer.valueOf((int) (e16 / 1000)));
            }
            if (!linkedHashMap3.containsKey(historyGroupByTime)) {
                linkedHashMap3.put(historyGroupByTime, new ArrayList());
            }
            ((List) linkedHashMap3.get(historyGroupByTime)).add(value);
        }
        ArrayList<Map.Entry> arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new a());
        for (Map.Entry entry : arrayList) {
            List<FileInfo> list2 = (List) linkedHashMap3.get(entry.getKey());
            if (list2.size() > 0) {
                Collections.sort(list2, new b());
                linkedHashMap.put((String) entry.getKey(), list2);
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getStatus(int i3) {
        return QQFileManagerUtilImpl.v1(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] getTempSessionSig(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        return QQFileManagerUtilImpl.x1(baseQQAppInterface, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public long getTempSessionType(int i3) {
        return QQFileManagerUtilImpl.y1(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public TimeoutParam getTimeOutParamer() {
        return QQFileManagerUtilImpl.z1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public long getWeiyunZipTargetId(long j3) {
        return QQFileManagerUtilImpl.C1(j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getZipThumbSavePath(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.D1(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getZipThumbUrlWithFileUrl(String str) {
        return QQFileManagerUtilImpl.E1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String handleLongFileName(String str, boolean z16, int i3, TextPaint textPaint, int i16) {
        return QQFileManagerUtilImpl.F1(str, z16, i3, textPaint, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean hasNoThumb(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.G1(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean hasShortCut(Context context, String str) {
        return QQFileManagerUtilImpl.H1(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean hasThumb(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.I1(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String hexToString(byte[] bArr) {
        return QQFileManagerUtilImpl.J1(bArr);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean ifShowFileMask(Context context, FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.K1(context, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void initNoMedia() {
        QQFileManagerUtilImpl.L1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void initSaveToPc(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context) {
        QQFileManagerUtilImpl.M1(baseQQAppInterface, chatMessage, context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean initSaveToWeiYun(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context) {
        return QQFileManagerUtilImpl.N1(baseQQAppInterface, chatMessage, context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void installApkFile(Context context, String str) {
        QQFileManagerUtilImpl.P1(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean is2GOr3G() {
        return QQFileManagerUtilImpl.R1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isBuddyIntroShow(String str, String str2) {
        return QQFileManagerUtilImpl.S1(str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isContainChinese(String str) {
        return QQFileManagerUtilImpl.T1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isDebugVersion() {
        return QQFileManagerUtilImpl.U1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isImportLocaFilesForH5(Context context) {
        return QQFileManagerUtilImpl.V1(context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isLocalFile(String str) {
        return QQFileManagerUtilImpl.W1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isMultiMessageSender(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage) {
        return QQFileManagerUtilImpl.X1(baseQQAppInterface, chatMessage);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isPreDownloadThumb() {
        return QQFileManagerUtilImpl.Y1();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isSameDay(long j3, long j16, TimeZone timeZone) {
        return QQFileManagerUtilImpl.Z1(j3, j16, timeZone);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isSelectedFavImageEntity() {
        return QQFileManagerUtilImpl.a2();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isSupportFavorite(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.c2(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean isTroopFile(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.d2(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public LinkedHashMap jsonToMap(String str) {
        return QQFileManagerUtilImpl.e2(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String mapToJson(Map map) {
        return QQFileManagerUtilImpl.g2(map);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String millsTimeToString(long j3, int i3) {
        return QQFileManagerUtilImpl.i2(j3, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity newEntityByFav(String str, String str2, String str3, String str4, long j3, String str5, String str6, int i3) {
        return QQFileManagerUtilImpl.j2(str, str2, str3, str4, j3, str5, str6, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity newEntityByLocalFileInfo(FileInfo fileInfo) {
        return QQFileManagerUtilImpl.k2(fileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity newEntityByOfflineFileInfo(OfflineFileInfo offlineFileInfo, int i3) {
        return QQFileManagerUtilImpl.l2(offlineFileInfo, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity newEntityByWeiYunFileInfo(WeiYunFileInfo weiYunFileInfo) {
        return QQFileManagerUtilImpl.m2(weiYunFileInfo);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle bundle) {
        return QQFileManagerUtilImpl.n2(bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void onDatalineForward(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, Activity activity, int i3) {
        QQFileManagerUtilImpl.o2(fileManagerEntity, baseQQAppInterface, activity, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void onQlinkFileErrIconClicked(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.p2(baseQQAppInterface, context, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void openFileWithOtherAppWithSystem(Context context, String str) {
        QQFileManagerUtilImpl.r2(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void openWithOtherApp(Activity activity, String str) {
        QQFileManagerUtilImpl.s2(activity, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void preLoadThumb(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.t2(baseQQAppInterface, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String printFileManagerEntityInfo(FileManagerEntity fileManagerEntity) {
        return QQFileManagerUtilImpl.v2(fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String printStack() {
        return QQFileManagerUtilImpl.w2();
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void processAIOTimGraytips(BaseQQAppInterface baseQQAppInterface, long j3) {
        QQFileManagerUtilImpl.x2(baseQQAppInterface, j3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String recreateFilePath(String str) {
        return QQFileManagerUtilImpl.y2(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean renameFile(VFSFile vFSFile, VFSFile vFSFile2) {
        return QQFileManagerUtilImpl.z2(vFSFile, vFSFile2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void reportFileAssistans(BaseQQAppInterface baseQQAppInterface, Context context) {
        QQFileManagerUtilImpl.B2(baseQQAppInterface, context);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void reportFilemanagerFaildInfo(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10) {
        QQFileManagerUtilImpl.C2(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void reportFilemanagerFaildInfoEx(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10, Bundle bundle) {
        QQFileManagerUtilImpl.D2(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void reportFilemanagerSuccessInfo(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6) {
        QQFileManagerUtilImpl.E2(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void reportFilemanagerSuccessInfoEx(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6, Bundle bundle) {
        QQFileManagerUtilImpl.F2(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String reportSrcType(int i3, int i16) {
        return QQFileManagerUtilImpl.G2(i3, i16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void resume(Context context, FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, boolean z16) {
        QQFileManagerUtilImpl.I2(context, fileManagerEntity, baseQQAppInterface, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void saveQlinkIntroShowTime(String str, int i3) {
        QQFileManagerUtilImpl.K2(str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void saveToAlbum(Context context, String str) {
        QQFileManagerUtilImpl.L2(context, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setBuddyIntroShow(String str, String str2, boolean z16) {
        QQFileManagerUtilImpl.M2(str, str2, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setFileIcon(ImageView imageView, String str) {
        QQFileManagerUtilImpl.O2(imageView, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setTempParam(BaseQQAppInterface baseQQAppInterface, String str, String str2, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.T2(baseQQAppInterface, str, str2, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setZipImageFileIcon(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.U2(asyncImageView, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void showFlowDialog(boolean z16, Context context, FMDialogUtil.c cVar) {
        QQFileManagerUtilImpl.V2(z16, context, cVar);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void startLoadingAnim(Activity activity, TextView textView) {
        QQFileManagerUtilImpl.X2(activity, textView);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void stopLoadingAnim(TextView textView) {
        QQFileManagerUtilImpl.Y2(textView);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public ah.g syncCreateVideoThumb(String str) {
        return QQFileManagerUtilImpl.Z2(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void updateBatProcessTips(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        QQFileManagerUtilImpl.b3(baseQQAppInterface, str, str2, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String updateRecentListTxt(BaseQQAppInterface baseQQAppInterface, Message message) {
        return QQFileManagerUtilImpl.c3(baseQQAppInterface, message);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String updateRecentListTxtByMessageRecord(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        return QQFileManagerUtilImpl.d3(baseQQAppInterface, messageRecord);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void addShortcut(BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3, Bundle bundle) {
        QQFileManagerUtilImpl.p(baseQQAppInterface, context, str, str2, i3, bundle);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean dealWithErrCode(int i3, String str) {
        return QQFileManagerUtilImpl.b0(i3, str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileIconResId(int i3) {
        return QQFileManagerUtilImpl.I0(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public String getFileType(int i3) {
        return QQFileManagerUtilImpl.U0(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public byte[] getMd5(String str) {
        return QQFileManagerUtilImpl.c1(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean initSaveToWeiYun(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context, boolean z16) {
        return QQFileManagerUtilImpl.O1(baseQQAppInterface, chatMessage, context, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public boolean renameFile(File file, File file2) {
        return QQFileManagerUtilImpl.A2(file, file2);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setFileIcon(ImageView imageView, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.N2(imageView, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void showFlowDialog(boolean z16, Context context, FMDialogUtil.c cVar, int i3) {
        QQFileManagerUtilImpl.W2(z16, context, cVar, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public int getFileIconResId(String str) {
        return QQFileManagerUtilImpl.K0(str);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setFileIcon(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        QQFileManagerUtilImpl.P2(asyncImageView, fileManagerEntity);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setFileIcon(AsyncImageView asyncImageView, String str, int i3) {
        QQFileManagerUtilImpl.R2(asyncImageView, str, i3);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setFileIcon(AsyncImageView asyncImageView, String str, boolean z16) {
        QQFileManagerUtilImpl.S2(asyncImageView, str, z16);
    }

    @Override // com.tencent.mobileqq.filemanager.api.IFileManagerUtil
    public void setFileIcon(AsyncImageView asyncImageView, String str) {
        QQFileManagerUtilImpl.Q2(asyncImageView, str);
    }
}
