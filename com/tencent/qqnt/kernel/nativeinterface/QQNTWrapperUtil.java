package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface QQNTWrapperUtil {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements QQNTWrapperUtil {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        public static native ArrayList<RecentContactInfo> DecoderRecentInfo(byte[] bArr);

        public static native HashMap<String, BaseEmojiPathInfo> GetBaseEmojiPathByIds(ArrayList<GetBaseEmojiPathReq> arrayList);

        public static native String GetMobileBaseEmojiPath();

        public static native String SetMobileBaseEmojiPath(String str, String str2);

        public static native ThumbResult calcThumbSize(int i3, int i16, ThumbOpt thumbOpt);

        public static native void calculateDirectoryTotalSize(String str, CalculateDirectoryTotalSizeCallback calculateDirectoryTotalSizeCallback);

        public static native void checkNewUserDataSaveDirAvailable(String str, IOperateCallback iOperateCallback);

        public static native boolean copyFile(String str, String str2);

        public static native void copyUserData(String str, String str2, IOperateCallback iOperateCallback);

        public static native void createThumbnailImage(String str, String str2, String str3, RichMediaImgSize richMediaImgSize, String str4, Float f16, IOperateCallback iOperateCallback);

        public static native UnregisterRes decodeOffLine(byte[] bArr);

        public static native void emptyWorkingSet(int i3);

        public static native byte[] encodeOffLine(UnregisterInfo unregisterInfo);

        public static native boolean fileIsExist(String str);

        public static native String fullWordToHalfWord(String str);

        public static native ArrayList<byte[]> genFileCumulateSha1(String str);

        public static native byte[] genFileMd5Buf(String str);

        public static native String genFileMd5Hex(String str);

        public static native HashMap<Integer, String> genFileShaAndMd5Hex(String str, int i3);

        public static native byte[] genFileShaBuf(String str);

        public static native String genFileShaHex(String str);

        public static native long getFileSize(String str);

        public static native String getFuzzyStr(String str, int i3);

        public static native String getNTUserDataInfoConfig();

        public static native OidbRspInfo getOidbRspInfo(byte[] bArr);

        public static native ArrayList<ArrayList<String>> getPinyin(String str, boolean z16);

        public static native ArrayList<ArrayList<String>> getPinyinExt(String str, boolean z16);

        public static native String getSecurityScopedBookmarkData(String str);

        public static native String getSoBuildInfo();

        public static native byte[] getSsoBufferOfOidbReq(int i3, int i16, byte[] bArr);

        public static native String getSsoCmdOfOidbReq(int i3, int i16);

        public static native boolean hasOtherRunningQQProcess();

        public static native boolean makeDirByPath(String str);

        public static native boolean matchInPinyin(ArrayList<ArrayList<String>> arrayList, String str);

        private native void nativeDestroy(long j3);

        public static native PathPermission pathIsReadableAndWriteable(String str);

        public static native void quitAllRunningQQProcess(boolean z16, IOperateCallback iOperateCallback);

        public static native boolean registerCountInstruments(String str, HashSet<String> hashSet, int i3, int i16);

        public static native boolean registerValueInstruments(String str, HashSet<String> hashSet, int i3, int i16);

        public static native boolean registerValueInstrumentsWithBoundary(String str, HashSet<String> hashSet, ArrayList<Double> arrayList, int i3, int i16);

        public static native boolean reportCountIndicators(String str, HashMap<String, String> hashMap, String str2, double d16, boolean z16);

        public static native boolean reportValueIndicators(String str, HashMap<String, String> hashMap, String str2, double d16, boolean z16);

        public static native void resetUserDataSavePathToDocument();

        public static native int runProcess(String str, boolean z16);

        public static native int runProcessArgs(String str, ArrayList<String> arrayList, boolean z16);

        public static native void setCreateThumbailSupportedFileExtensions(String str, ArrayList<String> arrayList);

        public static native void setFileDropNativeWindowHide(boolean z16);

        public static native void setFileDropWindowNativeWindowHandle(byte[] bArr);

        public static native boolean setTraceInfo(OpentelemetryTrace opentelemetryTrace);

        public static native void setUserDataSaveDirectory(String str, IOperateCallback iOperateCallback);

        public static native void startDebugFileDropNativeWindow();

        public static native void startListenFileDragEvent(FileDragEventListener fileDragEventListener);

        public static native ISpan startTrace(String str);

        public static native void stopAllDirectoryTotalSizeCaculation();

        public static native void stopListenFileDragEvent();

        public static native void updateFileDropWindowFrame();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }
    }
}
