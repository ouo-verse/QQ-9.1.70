package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernel.nativeinterface.QQNTWrapperUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes24.dex */
public final /* synthetic */ class cq {
    public static ArrayList<ArrayList<String>> A(String str, boolean z16) {
        return QQNTWrapperUtil.CppProxy.getPinyinExt(str, z16);
    }

    public static String B(String str) {
        return QQNTWrapperUtil.CppProxy.getSecurityScopedBookmarkData(str);
    }

    public static String C() {
        return QQNTWrapperUtil.CppProxy.getSoBuildInfo();
    }

    public static byte[] D(int i3, int i16, byte[] bArr) {
        return QQNTWrapperUtil.CppProxy.getSsoBufferOfOidbReq(i3, i16, bArr);
    }

    public static String E(int i3, int i16) {
        return QQNTWrapperUtil.CppProxy.getSsoCmdOfOidbReq(i3, i16);
    }

    public static boolean F() {
        return QQNTWrapperUtil.CppProxy.hasOtherRunningQQProcess();
    }

    public static boolean G(String str) {
        return QQNTWrapperUtil.CppProxy.makeDirByPath(str);
    }

    public static boolean H(ArrayList<ArrayList<String>> arrayList, String str) {
        return QQNTWrapperUtil.CppProxy.matchInPinyin(arrayList, str);
    }

    public static PathPermission I(String str) {
        return QQNTWrapperUtil.CppProxy.pathIsReadableAndWriteable(str);
    }

    public static void J(boolean z16, IOperateCallback iOperateCallback) {
        QQNTWrapperUtil.CppProxy.quitAllRunningQQProcess(z16, iOperateCallback);
    }

    public static boolean K(String str, HashSet<String> hashSet, int i3, int i16) {
        return QQNTWrapperUtil.CppProxy.registerCountInstruments(str, hashSet, i3, i16);
    }

    public static boolean L(String str, HashSet<String> hashSet, int i3, int i16) {
        return QQNTWrapperUtil.CppProxy.registerValueInstruments(str, hashSet, i3, i16);
    }

    public static boolean M(String str, HashSet<String> hashSet, ArrayList<Double> arrayList, int i3, int i16) {
        return QQNTWrapperUtil.CppProxy.registerValueInstrumentsWithBoundary(str, hashSet, arrayList, i3, i16);
    }

    public static boolean N(String str, HashMap<String, String> hashMap, String str2, double d16, boolean z16) {
        return QQNTWrapperUtil.CppProxy.reportCountIndicators(str, hashMap, str2, d16, z16);
    }

    public static boolean O(String str, HashMap<String, String> hashMap, String str2, double d16, boolean z16) {
        return QQNTWrapperUtil.CppProxy.reportValueIndicators(str, hashMap, str2, d16, z16);
    }

    public static void P() {
        QQNTWrapperUtil.CppProxy.resetUserDataSavePathToDocument();
    }

    public static int Q(String str, boolean z16) {
        return QQNTWrapperUtil.CppProxy.runProcess(str, z16);
    }

    public static int R(String str, ArrayList<String> arrayList, boolean z16) {
        return QQNTWrapperUtil.CppProxy.runProcessArgs(str, arrayList, z16);
    }

    public static void S(String str, ArrayList<String> arrayList) {
        QQNTWrapperUtil.CppProxy.setCreateThumbailSupportedFileExtensions(str, arrayList);
    }

    public static void T(boolean z16) {
        QQNTWrapperUtil.CppProxy.setFileDropNativeWindowHide(z16);
    }

    public static void U(byte[] bArr) {
        QQNTWrapperUtil.CppProxy.setFileDropWindowNativeWindowHandle(bArr);
    }

    public static boolean V(OpentelemetryTrace opentelemetryTrace) {
        return QQNTWrapperUtil.CppProxy.setTraceInfo(opentelemetryTrace);
    }

    public static void W(String str, IOperateCallback iOperateCallback) {
        QQNTWrapperUtil.CppProxy.setUserDataSaveDirectory(str, iOperateCallback);
    }

    public static void X() {
        QQNTWrapperUtil.CppProxy.startDebugFileDropNativeWindow();
    }

    public static void Y(FileDragEventListener fileDragEventListener) {
        QQNTWrapperUtil.CppProxy.startListenFileDragEvent(fileDragEventListener);
    }

    public static ISpan Z(String str) {
        return QQNTWrapperUtil.CppProxy.startTrace(str);
    }

    public static ArrayList<RecentContactInfo> a(byte[] bArr) {
        return QQNTWrapperUtil.CppProxy.DecoderRecentInfo(bArr);
    }

    public static void a0() {
        QQNTWrapperUtil.CppProxy.stopAllDirectoryTotalSizeCaculation();
    }

    public static HashMap<String, BaseEmojiPathInfo> b(ArrayList<GetBaseEmojiPathReq> arrayList) {
        return QQNTWrapperUtil.CppProxy.GetBaseEmojiPathByIds(arrayList);
    }

    public static void b0() {
        QQNTWrapperUtil.CppProxy.stopListenFileDragEvent();
    }

    public static String c() {
        return QQNTWrapperUtil.CppProxy.GetMobileBaseEmojiPath();
    }

    public static void c0() {
        QQNTWrapperUtil.CppProxy.updateFileDropWindowFrame();
    }

    public static String d(String str, String str2) {
        return QQNTWrapperUtil.CppProxy.SetMobileBaseEmojiPath(str, str2);
    }

    public static ThumbResult e(int i3, int i16, ThumbOpt thumbOpt) {
        return QQNTWrapperUtil.CppProxy.calcThumbSize(i3, i16, thumbOpt);
    }

    public static void f(String str, CalculateDirectoryTotalSizeCallback calculateDirectoryTotalSizeCallback) {
        QQNTWrapperUtil.CppProxy.calculateDirectoryTotalSize(str, calculateDirectoryTotalSizeCallback);
    }

    public static void g(String str, IOperateCallback iOperateCallback) {
        QQNTWrapperUtil.CppProxy.checkNewUserDataSaveDirAvailable(str, iOperateCallback);
    }

    public static boolean h(String str, String str2) {
        return QQNTWrapperUtil.CppProxy.copyFile(str, str2);
    }

    public static void i(String str, String str2, IOperateCallback iOperateCallback) {
        QQNTWrapperUtil.CppProxy.copyUserData(str, str2, iOperateCallback);
    }

    public static void j(String str, String str2, String str3, RichMediaImgSize richMediaImgSize, String str4, Float f16, IOperateCallback iOperateCallback) {
        QQNTWrapperUtil.CppProxy.createThumbnailImage(str, str2, str3, richMediaImgSize, str4, f16, iOperateCallback);
    }

    public static UnregisterRes k(byte[] bArr) {
        return QQNTWrapperUtil.CppProxy.decodeOffLine(bArr);
    }

    public static void l(int i3) {
        QQNTWrapperUtil.CppProxy.emptyWorkingSet(i3);
    }

    public static byte[] m(UnregisterInfo unregisterInfo) {
        return QQNTWrapperUtil.CppProxy.encodeOffLine(unregisterInfo);
    }

    public static boolean n(String str) {
        return QQNTWrapperUtil.CppProxy.fileIsExist(str);
    }

    public static String o(String str) {
        return QQNTWrapperUtil.CppProxy.fullWordToHalfWord(str);
    }

    public static ArrayList<byte[]> p(String str) {
        return QQNTWrapperUtil.CppProxy.genFileCumulateSha1(str);
    }

    public static byte[] q(String str) {
        return QQNTWrapperUtil.CppProxy.genFileMd5Buf(str);
    }

    public static String r(String str) {
        return QQNTWrapperUtil.CppProxy.genFileMd5Hex(str);
    }

    public static HashMap<Integer, String> s(String str, int i3) {
        return QQNTWrapperUtil.CppProxy.genFileShaAndMd5Hex(str, i3);
    }

    public static byte[] t(String str) {
        return QQNTWrapperUtil.CppProxy.genFileShaBuf(str);
    }

    public static String u(String str) {
        return QQNTWrapperUtil.CppProxy.genFileShaHex(str);
    }

    public static long v(String str) {
        return QQNTWrapperUtil.CppProxy.getFileSize(str);
    }

    public static String w(String str, int i3) {
        return QQNTWrapperUtil.CppProxy.getFuzzyStr(str, i3);
    }

    public static String x() {
        return QQNTWrapperUtil.CppProxy.getNTUserDataInfoConfig();
    }

    public static OidbRspInfo y(byte[] bArr) {
        return QQNTWrapperUtil.CppProxy.getOidbRspInfo(bArr);
    }

    public static ArrayList<ArrayList<String>> z(String str, boolean z16) {
        return QQNTWrapperUtil.CppProxy.getPinyin(str, z16);
    }
}
