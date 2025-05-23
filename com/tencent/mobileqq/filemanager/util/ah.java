package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TimeoutParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ah {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static Executor f209326a;

        static {
            ThreadPoolParams threadPoolParams = new ThreadPoolParams();
            threadPoolParams.poolThreadName = "fileassistant_pool";
            threadPoolParams.corePoolsize = 2;
            threadPoolParams.maxPooolSize = 2;
            threadPoolParams.priority = 8;
            threadPoolParams.queue = new LinkedBlockingQueue();
            threadPoolParams.keepAliveTime = 10;
            f209326a = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
        }

        public static Executor a() {
            return f209326a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void onSuccess(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void onResult(String str);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f209327a;

        /* renamed from: b, reason: collision with root package name */
        public int f209328b;

        /* renamed from: c, reason: collision with root package name */
        public String f209329c;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        void onClick(View view);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public int f209330a;

        /* renamed from: b, reason: collision with root package name */
        public String f209331b;

        /* renamed from: c, reason: collision with root package name */
        public int f209332c;

        /* renamed from: d, reason: collision with root package name */
        public int f209333d;
    }

    public static boolean A(int i3, String str) {
        return V().dealWithErrCode(i3, str);
    }

    public static int A0(String str) {
        return V().getQlinkIntroShowTime(str);
    }

    public static void A1(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10) {
        V().reportFilemanagerFaildInfo(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10);
    }

    public static void B(int i3) {
        V().dealWithErrCodeById(i3);
    }

    public static String B0(int i3) {
        return V().getReportFileTypeStr(i3);
    }

    public static void B1(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10, Bundle bundle) {
        V().reportFilemanagerFaildInfoEx(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10, bundle);
    }

    public static void C(long j3, int i3, String str) {
        V().dealWithTransFileFaild(j3, i3, str);
    }

    public static byte[] C0(String str) {
        return V().getSHA(str);
    }

    public static void C1(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6) {
        V().reportFilemanagerSuccessInfo(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6);
    }

    public static void D(long j3) {
        V().dealWithTransFileSuc(j3);
    }

    public static byte[] D0(String str) {
        return V().getSha3(str);
    }

    public static void D1(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6, Bundle bundle) {
        V().reportFilemanagerSuccessInfoEx(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6, bundle);
    }

    public static void E(long j3) {
        V().delCloseButtonSessionId(j3);
    }

    public static void E0(TreeMap<Long, FileInfo> treeMap, int i3, LinkedHashMap<String, List<FileInfo>> linkedHashMap, LinkedHashMap<String, List<FileInfo>> linkedHashMap2, List<FileInfo> list) {
        V().getSortMap(treeMap, i3, linkedHashMap, linkedHashMap2, list);
    }

    public static String E1(int i3, int i16) {
        return V().reportSrcType(i3, i16);
    }

    public static int F(String str) {
        return V().delExternalFileFromFMRecv(str);
    }

    public static int F0(int i3) {
        return V().getStatus(i3);
    }

    public static void F1(Context context, FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, boolean z16) {
        V().resume(context, fileManagerEntity, baseQQAppInterface, z16);
    }

    public static void G(Context context, String str, Bundle bundle) {
        V().downloadUniformQQBrowser(context, str, bundle);
    }

    public static byte[] G0(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        return V().getTempSessionSig(baseQQAppInterface, str, i3);
    }

    public static void G1(String str, int i3) {
        V().saveQlinkIntroShowTime(str, i3);
    }

    public static String H(String str) {
        return V().enCodecString(str);
    }

    public static long H0(int i3) {
        return V().getTempSessionType(i3);
    }

    public static void H1(Context context, String str) {
        V().saveToAlbum(context, str);
    }

    public static boolean I(String str) {
        return V().fileExist(str);
    }

    public static TimeoutParam I0() {
        return V().getTimeOutParamer();
    }

    public static void I1(String str, String str2, boolean z16) {
        V().setBuddyIntroShow(str, str2, z16);
    }

    public static boolean J(FileManagerEntity fileManagerEntity) {
        return V().fileWhetherExpire(fileManagerEntity);
    }

    public static long J0(long j3) {
        return V().getWeiyunZipTargetId(j3);
    }

    public static void J1(ImageView imageView, FileManagerEntity fileManagerEntity) {
        V().setFileIcon(imageView, fileManagerEntity);
    }

    public static String K(long j3) {
        return V().filesizeToString(j3);
    }

    public static String K0(FileManagerEntity fileManagerEntity) {
        return V().getZipThumbSavePath(fileManagerEntity);
    }

    public static void K1(ImageView imageView, String str) {
        V().setFileIcon(imageView, str);
    }

    public static void L(ChatMessage chatMessage, MessageForFile messageForFile) {
        V().fillFileMessageRecord(chatMessage, messageForFile);
    }

    public static String L0(String str) {
        return V().getZipThumbUrlWithFileUrl(str);
    }

    public static void L1(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        V().setFileIcon(asyncImageView, fileManagerEntity);
    }

    public static boolean M(String str, String str2) {
        return V().filterFiles(str, str2);
    }

    public static String M0(String str, boolean z16, int i3, TextPaint textPaint, int i16) {
        return V().handleLongFileName(str, z16, i3, textPaint, i16);
    }

    public static void M1(AsyncImageView asyncImageView, String str, int i3) {
        V().setFileIcon(asyncImageView, str, i3);
    }

    public static void N(FileManagerEntity fileManagerEntity) {
        V().fixEntityThumbSize(fileManagerEntity);
    }

    public static boolean N0(FileManagerEntity fileManagerEntity) {
        return V().hasNoThumb(fileManagerEntity);
    }

    public static void N1(AsyncImageView asyncImageView, String str, boolean z16) {
        V().setFileIcon(asyncImageView, str, z16);
    }

    public static void O(List<FileManagerEntity> list, Activity activity) {
        V().forwardRencentFiles(list, activity);
    }

    public static boolean O0(Context context, String str) {
        return V().hasShortCut(context, str);
    }

    public static void O1(BaseQQAppInterface baseQQAppInterface, String str, String str2, FileManagerEntity fileManagerEntity) {
        V().setTempParam(baseQQAppInterface, str, str2, fileManagerEntity);
    }

    public static long P() {
        return V().genMsgSeq();
    }

    public static boolean P0(FileManagerEntity fileManagerEntity) {
        return V().hasThumb(fileManagerEntity);
    }

    public static void P1(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        V().setZipImageFileIcon(asyncImageView, fileManagerEntity);
    }

    public static long Q() {
        return V().genMsgUid();
    }

    public static String Q0(byte[] bArr) {
        return V().hexToString(bArr);
    }

    public static void Q1(boolean z16, Context context, FMDialogUtil.c cVar) {
        V().showFlowDialog(z16, context, cVar);
    }

    public static Long R() {
        return V().genSessionId();
    }

    public static boolean R0(Context context, FileManagerEntity fileManagerEntity) {
        return V().ifShowFileMask(context, fileManagerEntity);
    }

    public static void R1(boolean z16, Context context, FMDialogUtil.c cVar, int i3) {
        V().showFlowDialog(z16, context, cVar, i3);
    }

    public static byte[] S(String str) {
        return V().get3SHA(str);
    }

    public static void S0() {
        V().initNoMedia();
    }

    public static void S1(Activity activity, TextView textView) {
        V().startLoadingAnim(activity, textView);
    }

    public static ArrayList<FileInfo> T(boolean z16, int i3) {
        return V().getAllFMRecvFiles(z16, i3);
    }

    public static void T0(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context) {
        V().initSaveToPc(baseQQAppInterface, chatMessage, context);
    }

    public static void T1(TextView textView) {
        V().stopLoadingAnim(textView);
    }

    public static Map<String, File> U(Context context) {
        return V().getAllStorageLocations(context);
    }

    public static boolean U0(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context) {
        return V().initSaveToWeiYun(baseQQAppInterface, chatMessage, context);
    }

    public static g U1(String str) {
        return V().syncCreateVideoThumb(str);
    }

    public static IFileManagerUtil V() {
        return (IFileManagerUtil) QRoute.api(IFileManagerUtil.class);
    }

    public static boolean V0(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context, boolean z16) {
        return V().initSaveToWeiYun(baseQQAppInterface, chatMessage, context, z16);
    }

    public static void V1(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        V().updateBatProcessTips(baseQQAppInterface, str, str2, i3);
    }

    public static BaseQQAppInterface W() {
        return V().getApp();
    }

    public static void W0(Context context, String str) {
        V().installApkFile(context, str);
    }

    public static String W1(BaseQQAppInterface baseQQAppInterface, Message message) {
        return V().updateRecentListTxt(baseQQAppInterface, message);
    }

    public static Bitmap X(Context context, Bitmap bitmap, int i3) {
        return V().getCircleFaceBitmap(context, bitmap, i3);
    }

    public static boolean X0() {
        return V().is2GOr3G();
    }

    public static String X1(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        return V().updateRecentListTxtByMessageRecord(baseQQAppInterface, messageRecord);
    }

    public static SpannableString Y(String str, String str2, f fVar) {
        return V().getClickableTips(str, str2, fVar);
    }

    public static boolean Y0(String str, String str2) {
        return V().isBuddyIntroShow(str, str2);
    }

    public static w Z(BaseQQAppInterface baseQQAppInterface, int i3) {
        return V().getDatalineProcessCallBack(baseQQAppInterface, i3);
    }

    public static boolean Z0(String str) {
        return V().isContainChinese(str);
    }

    public static void a(long j3) {
        V().addCloseButtonSessionId(j3);
    }

    public static HashMap<String, String> a0(String str) {
        return V().getDocsImportConfigGroupFromStr(str);
    }

    public static boolean a1(Context context) {
        return V().isImportLocaFilesForH5(context);
    }

    public static int b(String str) {
        return V().addExternalFileToFMRecv(str);
    }

    public static long b0(String str) {
        return V().getDocsImportFileMaxSize(str);
    }

    public static boolean b1(String str) {
        return V().isLocalFile(str);
    }

    public static void c(BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3) {
        V().addShortcut(baseQQAppInterface, context, str, str2, i3);
    }

    public static String c0() {
        return V().getFMDownloadPath();
    }

    public static boolean c1(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage) {
        return V().isMultiMessageSender(baseQQAppInterface, chatMessage);
    }

    public static void d(BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3, Bundle bundle) {
        V().addShortcut(baseQQAppInterface, context, str, str2, i3, bundle);
    }

    public static int d0(int i3) {
        return V().getFileIconResId(i3);
    }

    public static boolean d1() {
        return V().isPreDownloadThumb();
    }

    public static void e(FileManagerEntity fileManagerEntity) {
        V().associateLocalWithCloud(fileManagerEntity);
    }

    public static int e0(int i3, int i16) {
        return V().getFileIconResId(i3, i16);
    }

    public static boolean e1(long j3, long j16, TimeZone timeZone) {
        return V().isSameDay(j3, j16, timeZone);
    }

    public static boolean f(boolean z16, ArrayList<FileManagerEntity> arrayList) {
        return V().bShowFlowDlg(z16, arrayList);
    }

    public static int f0(String str) {
        return V().getFileIconResId(str);
    }

    public static boolean f1(FileManagerEntity fileManagerEntity) {
        return V().isSupportFavorite(fileManagerEntity);
    }

    public static boolean g(int i3) {
        return V().bZip(i3);
    }

    public static FileManagerEntity g0(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile) {
        return V().getFileManagerEntityByMsgFile(baseQQAppInterface, messageForFile);
    }

    public static boolean g1(FileManagerEntity fileManagerEntity) {
        return V().isTroopFile(fileManagerEntity);
    }

    public static String h(ByteStringMicro byteStringMicro) {
        return V().binToHEX(byteStringMicro);
    }

    public static String h0(String str) {
        return V().getFileName(str);
    }

    public static LinkedHashMap h1(String str) {
        return V().jsonToMap(str);
    }

    public static int i(List<FileInfo> list, long j3) {
        return V().binanrySearch(list, j3);
    }

    public static String i0(FileManagerEntity fileManagerEntity) {
        return V().getFileOperationTypeToPeer(fileManagerEntity);
    }

    public static String i1(Map map) {
        return V().mapToJson(map);
    }

    public static void j(TextView textView, FileManagerEntity fileManagerEntity) {
        V().calcFileDescription(textView, fileManagerEntity);
    }

    public static FileManagerEntity j0(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3, ChatMessage chatMessage) {
        return V().getFileRecordForMultiMsg(baseQQAppInterface, j3, str, i3, chatMessage);
    }

    public static String j1(long j3, int i3) {
        return V().millsTimeToString(j3, i3);
    }

    public static boolean k(FileManagerEntity fileManagerEntity) {
        return V().canCreateThumb(fileManagerEntity);
    }

    public static String k0(FileManagerEntity fileManagerEntity) {
        return V().getFileSizeInvalidTime(fileManagerEntity);
    }

    public static FileManagerEntity k1(FileInfo fileInfo) {
        return V().newEntityByLocalFileInfo(fileInfo);
    }

    public static boolean l(Context context, String str, long j3) {
        return V().canPreview(context, str, j3);
    }

    public static long l0(String str) {
        return V().getFileSizes(str);
    }

    public static FileManagerEntity l1(OfflineFileInfo offlineFileInfo, int i3) {
        return V().newEntityByOfflineFileInfo(offlineFileInfo, i3);
    }

    public static int m(FileManagerEntity fileManagerEntity) {
        return V().chechFileType(fileManagerEntity);
    }

    public static int m0(FileManagerEntity fileManagerEntity) {
        return V().getFileSrcCloudType(fileManagerEntity);
    }

    public static FileManagerEntity m1(WeiYunFileInfo weiYunFileInfo) {
        return V().newEntityByWeiYunFileInfo(weiYunFileInfo);
    }

    public static int n(FileManagerEntity fileManagerEntity) {
        return V().chechZipFileType(fileManagerEntity);
    }

    public static String n0(String str) {
        return V().getFileSuffix(str);
    }

    public static FileManagerEntity n1(Bundle bundle) {
        return V().newEntityByWeiYunMiniAppParams(bundle);
    }

    public static void o(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, a aVar) {
        V().checkFileExisted(fileManagerEntity, baseQQAppInterface, aVar);
    }

    public static synchronized int o0(String str) {
        int fileType;
        synchronized (ah.class) {
            fileType = V().getFileType(str);
        }
        return fileType;
    }

    public static void o1(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, Activity activity, int i3) {
        V().onDatalineForward(fileManagerEntity, baseQQAppInterface, activity, i3);
    }

    public static boolean p(ChatMessage chatMessage, BaseQQAppInterface baseQQAppInterface, Context context) {
        return V().checkMultiFileBubbleClickable(chatMessage, baseQQAppInterface, context);
    }

    public static String p0(int i3) {
        return V().getFileType(i3);
    }

    public static void p1(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        V().onQlinkFileErrIconClicked(baseQQAppInterface, context, fileManagerEntity);
    }

    public static void q() {
        V().clearAllRecentFileForTest();
    }

    public static synchronized int q0(String str) {
        int fileTypeByExtension;
        synchronized (ah.class) {
            fileTypeByExtension = V().getFileTypeByExtension(str);
        }
        return fileTypeByExtension;
    }

    public static void q1(Context context, String str) {
        V().openFileWithOtherAppWithSystem(context, str);
    }

    public static void r(Context context) {
        V().clearRememberPicSelectForQlink(context);
    }

    public static int r0(ChatMessage chatMessage) {
        return V().getFileTypeFromMultiMsgRecord(chatMessage);
    }

    public static void r1(Activity activity, String str) {
        V().openWithOtherApp(activity, str);
    }

    public static void s(FileManagerEntity fileManagerEntity) {
        V().correctFileInfo(fileManagerEntity);
    }

    public static byte[] s0(String str) {
        return V().getFullMd5(str);
    }

    public static void s1(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        V().preLoadThumb(baseQQAppInterface, fileManagerEntity);
    }

    public static FileManagerEntity t(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage) {
        return V().createFileRecordForMultiMsg(baseQQAppInterface, chatMessage);
    }

    public static String t0(String str) {
        return V().getHardCodeConfig(str);
    }

    public static String t1(FileManagerEntity fileManagerEntity) {
        return V().printFileManagerEntityInfo(fileManagerEntity);
    }

    public static void u(FileManagerEntity fileManagerEntity) {
        V().createMediThumbnail(fileManagerEntity);
    }

    public static String u0(FileManagerEntity fileManagerEntity) {
        return V().getImageUrl(fileManagerEntity);
    }

    public static synchronized String u1() {
        String printStack;
        synchronized (ah.class) {
            printStack = V().printStack();
        }
        return printStack;
    }

    public static String v(String str, int i3, int i16, d dVar) {
        return V().createMediaThumbnail(str, i3, i16, dVar);
    }

    public static byte[] v0(String str) {
        return V().getMd5(str);
    }

    public static void v1(BaseQQAppInterface baseQQAppInterface, long j3) {
        V().processAIOTimGraytips(baseQQAppInterface, j3);
    }

    public static String w(String str) {
        return V().createVideoThumbPath(str);
    }

    public static byte[] w0(String str, long j3) {
        return V().getMd5(str, j3);
    }

    public static String w1(String str) {
        return V().recreateFilePath(str);
    }

    public static String x(String str, int i3) {
        return V().cutLongLongFileName(str, i3);
    }

    public static int[] x0(String str) {
        return V().getMediaFileWidthHeight(str);
    }

    public static boolean x1(VFSFile vFSFile, VFSFile vFSFile2) {
        return V().renameFile(vFSFile, vFSFile2);
    }

    public static String y(String str) {
        return V().cutLongName(str);
    }

    public static String y0(ChatMessage chatMessage) {
        return V().getMultiFileThumbPath(chatMessage);
    }

    public static boolean y1(File file, File file2) {
        return V().renameFile(file, file2);
    }

    public static void z(String str) {
        V().dealWithErrCode(str);
    }

    public static String z0(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        return V().getPeerNick(baseQQAppInterface, str, str2, i3);
    }

    public static void z1(BaseQQAppInterface baseQQAppInterface, Context context) {
        V().reportFileAssistans(baseQQAppInterface, context);
    }
}
