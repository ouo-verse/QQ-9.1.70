package com.tencent.qqnt.aio.icebreak;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.album.media.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014R&\u0010\"\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010#R(\u0010(\u001a\u0004\u0018\u00010\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00028B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010#\"\u0004\b&\u0010'R\u001c\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWording;", "", "", "url", "md5", "", "Ljava/io/File;", "g", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "l", "k", "Lcom/tencent/mobileqq/album/media/c;", "j", "b", "Ljava/lang/String;", "rawConfig", "", "", "c", "Ljava/util/List;", "randomWordingIndices", "d", "randomPictureIndices", "e", "defaultWordings", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "f", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkv", "wordings", "Lkotlinx/coroutines/Deferred;", h.F, "Lkotlinx/coroutines/Deferred;", "downloadPicturesJob", "()Ljava/lang/String;", "prevWelcomePicturesMd5Key", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "prevWelcomePicturesMd5", "()Ljava/util/List;", "pictures", "<init>", "()V", "ConfigFace", "ConfigRoot", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class IceBreakingWelcomeWording {

    /* renamed from: a, reason: collision with root package name */
    public static final IceBreakingWelcomeWording f351145a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String rawConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static List<Integer> randomWordingIndices;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static List<Integer> randomPictureIndices;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final List<String> defaultWordings;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final MMKVOptionEntityV2 mmkv;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static List<String> wordings;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Deferred<? extends List<? extends File>> downloadPicturesJob;

    static {
        List<String> listOf;
        IceBreakingWelcomeWording iceBreakingWelcomeWording = new IceBreakingWelcomeWording();
        f351145a = iceBreakingWelcomeWording;
        rawConfig = "";
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u6b22\u8fce\u8fdb\u7fa4\uff01\u7fa4\u804a\u70ed\u95f9\u5ea6+1~ \u0014/\u5472\u7259", "\u6b22\u8fce\u65b0\u4f19\u4f34\uff5e\u4e00\u8d77\u55e8\u76ae\u5427\uff01(\u3065\uff61\u25d5\u203f\u203f\u25d5\uff61)\u3065", "\u7ea2\u674f\u679d\u5934\u6625\u610f\u95f9\uff0c\u65b0\u4eba\u8981\u4e0d\u7206\u4e2a\u7167\uff1f \u0014/\u6c6a\u6c6a", "\u8fd9\u4e2a\u7fa4\uff0c\u7adf\u7136\u6709\u65b0\u4eba\u4e86\uff01\uff01\uff08\u9707\u58f0\uff09", "\u65b0\u4eba\u8fdb\u7fa4\uff0c\u8fd8\u4e0d\u5f00\u59cb\u9f13\u638c\u6b22\u8fce\uff1f \u0014/\u6c6a\u6c6a", "\u65b0\u4eba\u9a7e\u5230\uff0c\u901a\u901a\u95ea\u5f00~", "\u6b22\u8fce\u6b22\u8fce\uff01  #\u9753\u5973 #\u5e05\u54e5 #\u4ea4\u53cb #ootd #\u6269\u5217 #\u7206\u7167 #QQ\u7fa4 #\u641e\u7b11\uff08\u542c\u8bf4\u8fd9\u6837\u6211\u7684\u8bdd\u4f1a\u66f4\u5bb9\u6613\u88ab\u4f60\u770b\u5230~\u0014/\u6bd4\u5fc3\uff09", "\u6b22\u8fce\u65b0\u6210\u5458\u1f973", "Hi~\u6b22\u8fce\u65b0\u670b\u53cb\u1f44f", "\u624d\u6765\uff1f\u5750\u4e0b\u5520\u4f1a\u513f~", "\u6b22\u8fce\uff0c\u6492\u82b1\u6b22\u8fce(\u0e51\u25d5\u072b\uffe9\u0e51)b", "\u9f13\u638c\u6b22\u8fce\uff0c\u5471\u5527\u5471\u5527\u10e6( \u00b4\uff65\u1d17\uff65` )"});
        defaultWordings = listOf;
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        mmkv = fromV2;
        wordings = listOf;
        iceBreakingWelcomeWording.l();
    }

    IceBreakingWelcomeWording() {
    }

    private final List<File> d() {
        List<File> emptyList;
        try {
            Deferred<? extends List<? extends File>> deferred = downloadPicturesJob;
            if (deferred != null) {
                return (List) deferred.getCompleted();
            }
            return null;
        } catch (IllegalStateException unused) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    private final String e() {
        return mmkv.getString(f(), null);
    }

    private final String f() {
        return "prev_welcome_pictures-" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0138, code lost:
    
        r11 = kotlin.collections.ArraysKt___ArraysJvmKt.asList(r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x012b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(String str, final String str2, Continuation<? super List<? extends File>> continuation) {
        IceBreakingWelcomeWording$loadPictures$1 iceBreakingWelcomeWording$loadPictures$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        File file;
        final File file2;
        IceBreakingWelcomeWording iceBreakingWelcomeWording;
        File file3;
        File file4;
        File[] listFiles;
        List emptyList;
        List emptyList2;
        if (continuation instanceof IceBreakingWelcomeWording$loadPictures$1) {
            iceBreakingWelcomeWording$loadPictures$1 = (IceBreakingWelcomeWording$loadPictures$1) continuation;
            int i16 = iceBreakingWelcomeWording$loadPictures$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                iceBreakingWelcomeWording$loadPictures$1.label = i16 - Integer.MIN_VALUE;
                obj = iceBreakingWelcomeWording$loadPictures$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = iceBreakingWelcomeWording$loadPictures$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    File externalCacheDir = BaseApplicationImpl.getApplication().getExternalCacheDir();
                    String e16 = e();
                    if (e16 != null) {
                        file = new File(externalCacheDir, "welcome_pictures-" + e16);
                    } else {
                        file = null;
                    }
                    String upperCase = str2.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                    file2 = new File(externalCacheDir, "welcome_pictures-" + upperCase);
                    if (!file2.exists()) {
                        final File file5 = new File(externalCacheDir, "welcome_pictures.zip");
                        Downloader downloader = DownloaderFactory.getInstance(BaseApplication.context).getCommonDownloader();
                        downloader.enableResumeTransfer();
                        Intrinsics.checkNotNullExpressionValue(downloader, "downloader");
                        String absolutePath = file5.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "localZipPath.absolutePath");
                        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.icebreak.IceBreakingWelcomeWording$loadPictures$downloadSucceed$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                boolean equals;
                                String calcMd5 = FileUtils.calcMd5(file5.getAbsolutePath());
                                Intrinsics.checkNotNullExpressionValue(calcMd5, "calcMd5(localZipPath.absolutePath)");
                                String upperCase2 = calcMd5.toUpperCase();
                                Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase()");
                                equals = StringsKt__StringsJVMKt.equals(str2, upperCase2, true);
                                if (!equals) {
                                    QLog.e("IceBreakingWelcomeWording", 1, "reload md5 check failed source:" + upperCase2 + " target:" + str2);
                                    return Boolean.FALSE;
                                }
                                try {
                                    FileUtils.uncompressZip(file5.getAbsolutePath(), file2.getAbsolutePath(), false);
                                    return Boolean.TRUE;
                                } catch (IOException e17) {
                                    QLog.e("IceBreakingWelcomeWording", 1, "reload uncompressZip failed from:" + file5 + " to:" + file2, e17);
                                    try {
                                        FilesKt__UtilsKt.deleteRecursively(file2);
                                    } catch (IOException e18) {
                                        QLog.e("IceBreakingWelcomeWording", 1, "reload uncompressZip undo failed from:" + file5 + " to:" + file2, e18);
                                    }
                                    return Boolean.FALSE;
                                }
                            }
                        };
                        iceBreakingWelcomeWording$loadPictures$1.L$0 = this;
                        iceBreakingWelcomeWording$loadPictures$1.L$1 = str2;
                        iceBreakingWelcomeWording$loadPictures$1.L$2 = file;
                        iceBreakingWelcomeWording$loadPictures$1.L$3 = file2;
                        iceBreakingWelcomeWording$loadPictures$1.label = 1;
                        obj = IceBreakingWelcomeWordingKt.c(downloader, str, absolutePath, function0, iceBreakingWelcomeWording$loadPictures$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        iceBreakingWelcomeWording = this;
                        file3 = file2;
                    }
                    listFiles = file2.listFiles(new FileFilter() { // from class: com.tencent.qqnt.aio.icebreak.a
                        @Override // java.io.FileFilter
                        public final boolean accept(File file6) {
                            boolean h16;
                            h16 = IceBreakingWelcomeWording.h(file6);
                            return h16;
                        }
                    });
                    if (listFiles != null) {
                        emptyList = ArraysKt___ArraysJvmKt.asList(listFiles);
                    }
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    if (!emptyList.isEmpty()) {
                    }
                    QLog.i("IceBreakingWelcomeWording", 1, "reload finished pictures:" + emptyList);
                    return emptyList;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        file3 = (File) iceBreakingWelcomeWording$loadPictures$1.L$1;
                        file4 = (File) iceBreakingWelcomeWording$loadPictures$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        file2 = file3;
                        file = file4;
                        listFiles = file2.listFiles(new FileFilter() { // from class: com.tencent.qqnt.aio.icebreak.a
                            @Override // java.io.FileFilter
                            public final boolean accept(File file6) {
                                boolean h16;
                                h16 = IceBreakingWelcomeWording.h(file6);
                                return h16;
                            }
                        });
                        if (listFiles != null || emptyList == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        if (!emptyList.isEmpty() && file != null) {
                            File[] listFiles2 = file.listFiles(new FileFilter() { // from class: com.tencent.qqnt.aio.icebreak.b
                                @Override // java.io.FileFilter
                                public final boolean accept(File file6) {
                                    boolean i17;
                                    i17 = IceBreakingWelcomeWording.i(file6);
                                    return i17;
                                }
                            });
                            if (listFiles2 == null || emptyList2 == null) {
                                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                            }
                            QLog.e("IceBreakingWelcomeWording", 1, "reload fullback to prevPictures:" + emptyList2);
                            return emptyList2;
                        }
                        QLog.i("IceBreakingWelcomeWording", 1, "reload finished pictures:" + emptyList);
                        return emptyList;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file3 = (File) iceBreakingWelcomeWording$loadPictures$1.L$3;
                File file6 = (File) iceBreakingWelcomeWording$loadPictures$1.L$2;
                String str3 = (String) iceBreakingWelcomeWording$loadPictures$1.L$1;
                iceBreakingWelcomeWording = (IceBreakingWelcomeWording) iceBreakingWelcomeWording$loadPictures$1.L$0;
                ResultKt.throwOnFailure(obj);
                file = file6;
                str2 = str3;
                if (Intrinsics.areEqual((Boolean) obj, Boxing.boxBoolean(true))) {
                    iceBreakingWelcomeWording.m(str2);
                    if (file != null) {
                        IceBreakingWelcomeWording$loadPictures$2 iceBreakingWelcomeWording$loadPictures$2 = new IceBreakingWelcomeWording$loadPictures$2(file, null);
                        iceBreakingWelcomeWording$loadPictures$1.L$0 = file;
                        iceBreakingWelcomeWording$loadPictures$1.L$1 = file3;
                        iceBreakingWelcomeWording$loadPictures$1.L$2 = null;
                        iceBreakingWelcomeWording$loadPictures$1.L$3 = null;
                        iceBreakingWelcomeWording$loadPictures$1.label = 2;
                        if (CoroutineScopeKt.coroutineScope(iceBreakingWelcomeWording$loadPictures$2, iceBreakingWelcomeWording$loadPictures$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        file4 = file;
                        file2 = file3;
                        file = file4;
                        listFiles = file2.listFiles(new FileFilter() { // from class: com.tencent.qqnt.aio.icebreak.a
                            @Override // java.io.FileFilter
                            public final boolean accept(File file62) {
                                boolean h16;
                                h16 = IceBreakingWelcomeWording.h(file62);
                                return h16;
                            }
                        });
                        if (listFiles != null) {
                        }
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        if (!emptyList.isEmpty()) {
                        }
                        QLog.i("IceBreakingWelcomeWording", 1, "reload finished pictures:" + emptyList);
                        return emptyList;
                    }
                }
                file2 = file3;
                listFiles = file2.listFiles(new FileFilter() { // from class: com.tencent.qqnt.aio.icebreak.a
                    @Override // java.io.FileFilter
                    public final boolean accept(File file62) {
                        boolean h16;
                        h16 = IceBreakingWelcomeWording.h(file62);
                        return h16;
                    }
                });
                if (listFiles != null) {
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                if (!emptyList.isEmpty()) {
                }
                QLog.i("IceBreakingWelcomeWording", 1, "reload finished pictures:" + emptyList);
                return emptyList;
            }
        }
        iceBreakingWelcomeWording$loadPictures$1 = new IceBreakingWelcomeWording$loadPictures$1(this, continuation);
        obj = iceBreakingWelcomeWording$loadPictures$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = iceBreakingWelcomeWording$loadPictures$1.label;
        if (i3 != 0) {
        }
        if (Intrinsics.areEqual((Boolean) obj, Boxing.boxBoolean(true))) {
        }
        file2 = file3;
        listFiles = file2.listFiles(new FileFilter() { // from class: com.tencent.qqnt.aio.icebreak.a
            @Override // java.io.FileFilter
            public final boolean accept(File file62) {
                boolean h16;
                h16 = IceBreakingWelcomeWording.h(file62);
                return h16;
            }
        });
        if (listFiles != null) {
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (!emptyList.isEmpty()) {
        }
        QLog.i("IceBreakingWelcomeWording", 1, "reload finished pictures:" + emptyList);
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(File file) {
        return file.isFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(File file) {
        return file.isFile();
    }

    private final void m(String str) {
        mmkv.putString(f(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0021 A[Catch: all -> 0x007a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x000d, B:11:0x0015, B:16:0x0021, B:17:0x0031, B:19:0x0037, B:22:0x003d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x000d, B:11:0x0015, B:16:0x0021, B:17:0x0031, B:19:0x0037, B:22:0x003d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d A[Catch: all -> 0x007a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x000d, B:11:0x0015, B:16:0x0021, B:17:0x0031, B:19:0x0037, B:22:0x003d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized List<c> j() {
        boolean z16;
        List<c> emptyList;
        IntRange indices;
        List<c> emptyList2;
        List<File> d16 = d();
        if (d16 == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        List<Integer> list = randomPictureIndices;
        List<Integer> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
            if (z16) {
                indices = CollectionsKt__CollectionsKt.getIndices(d16);
                list = CollectionsKt___CollectionsKt.toMutableList(indices);
                Collections.shuffle(list);
                randomPictureIndices = list;
            }
            if (list.size() != 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            File file = d16.get(list.remove(list.size() - 1).intValue());
            List<c> singletonList = Collections.singletonList(new c(null, file.getAbsolutePath(), com.tencent.guild.api.media.album.c.a(), null, null, FileUtils.calcMd5(file.getAbsolutePath()), 25, null));
            Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(PickPhotoR\u2026.absolutePath)\n        ))");
            return singletonList;
        }
        z16 = true;
        if (z16) {
        }
        if (list.size() != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015 A[Catch: all -> 0x004a, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:10:0x0015, B:11:0x0026, B:17:0x0031), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031 A[Catch: all -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:10:0x0015, B:11:0x0026, B:17:0x0031), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String k() {
        boolean z16;
        IntRange indices;
        List<Integer> list = randomWordingIndices;
        List<Integer> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
            if (z16) {
                indices = CollectionsKt__CollectionsKt.getIndices(wordings);
                list = CollectionsKt___CollectionsKt.toMutableList(indices);
                Collections.shuffle(list);
                randomWordingIndices = list;
            }
            if (list.size() != 0) {
                return "";
            }
            return wordings.get(list.remove(list.size() - 1).intValue());
        }
        z16 = true;
        if (z16) {
        }
        if (list.size() != 0) {
        }
    }

    public final synchronized void l() {
        String replace$default;
        Deferred<? extends List<? extends File>> deferred;
        com.tencent.mobileqq.qcoroutine.api.coroutine.a c16;
        QLog.i("IceBreakingWelcomeWording", 1, DKWebViewController.DKHippyWebviewFunction.RELOAD);
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103096", "");
        replace$default = StringsKt__StringsJVMKt.replace$default(loadAsString, '\n', TokenParser.SP, false, 4, (Object) null);
        QLog.i("IceBreakingWelcomeWording", 1, "reload loadConfig " + replace$default);
        if (Intrinsics.areEqual(loadAsString, rawConfig)) {
            return;
        }
        try {
            ConfigRoot configRoot = (ConfigRoot) new Gson().fromJson(loadAsString, ConfigRoot.class);
            rawConfig = loadAsString;
            List<String> welcome = configRoot.getWelcome();
            if (welcome.isEmpty()) {
                welcome = defaultWordings;
            }
            wordings = welcome;
            randomWordingIndices = null;
            Deferred<? extends List<? extends File>> deferred2 = downloadPicturesJob;
            if (deferred2 != null) {
                Job.DefaultImpls.cancel$default((Job) deferred2, (CancellationException) null, 1, (Object) null);
            }
            if (configRoot.getFace().isEmpty()) {
                deferred = null;
            } else {
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                deferred = (f16 == null || (c16 = CorountineFunKt.c(f16, "IceBreakingWelcomeWording preloadPictures", null, null, new IceBreakingWelcomeWording$reload$deferred$1(configRoot, null), 6, null)) == null) ? null : c16.o();
                if (deferred == null) {
                    QLog.e("IceBreakingWelcomeWording", 1, "reload create deferred failed");
                }
            }
            downloadPicturesJob = deferred;
            randomPictureIndices = null;
        } catch (JsonSyntaxException e16) {
            QLog.e("IceBreakingWelcomeWording", 1, "reload parse json failed", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0083\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0006\u0010\u0011\u001a\u00020\rJ\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWording$ConfigFace;", "", "url", "", "md5", "(Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final /* data */ class ConfigFace {
        private final String md5;
        private final String url;

        public ConfigFace(String url, String md5) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(md5, "md5");
            this.url = url;
            this.md5 = md5;
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final String getMd5() {
            return this.md5;
        }

        public final ConfigFace copy(String url, String md5) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(md5, "md5");
            return new ConfigFace(url, md5);
        }

        public final String getMd5() {
            return this.md5;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.md5.hashCode();
        }

        public final boolean isEmpty() {
            if (this.url.length() == 0) {
                return true;
            }
            return this.md5.length() == 0;
        }

        public String toString() {
            return "ConfigFace(url=" + this.url + ", md5=" + this.md5 + ")";
        }

        public static /* synthetic */ ConfigFace copy$default(ConfigFace configFace, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = configFace.url;
            }
            if ((i3 & 2) != 0) {
                str2 = configFace.md5;
            }
            return configFace.copy(str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigFace)) {
                return false;
            }
            ConfigFace configFace = (ConfigFace) other;
            return Intrinsics.areEqual(this.url, configFace.url) && Intrinsics.areEqual(this.md5, configFace.md5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWording$ConfigRoot;", "", "welcome", "", "", PreDetect.FACE_DETECT, "Lcom/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWording$ConfigFace;", "(Ljava/util/List;Lcom/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWording$ConfigFace;)V", "getFace", "()Lcom/tencent/qqnt/aio/icebreak/IceBreakingWelcomeWording$ConfigFace;", "getWelcome", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final /* data */ class ConfigRoot {
        private final ConfigFace face;
        private final List<String> welcome;

        public ConfigRoot(List<String> welcome, ConfigFace face2) {
            Intrinsics.checkNotNullParameter(welcome, "welcome");
            Intrinsics.checkNotNullParameter(face2, "face");
            this.welcome = welcome;
            this.face = face2;
        }

        public final List<String> component1() {
            return this.welcome;
        }

        /* renamed from: component2, reason: from getter */
        public final ConfigFace getFace() {
            return this.face;
        }

        public final ConfigRoot copy(List<String> welcome, ConfigFace face2) {
            Intrinsics.checkNotNullParameter(welcome, "welcome");
            Intrinsics.checkNotNullParameter(face2, "face");
            return new ConfigRoot(welcome, face2);
        }

        public final ConfigFace getFace() {
            return this.face;
        }

        public final List<String> getWelcome() {
            return this.welcome;
        }

        public int hashCode() {
            return (this.welcome.hashCode() * 31) + this.face.hashCode();
        }

        public String toString() {
            return "ConfigRoot(welcome=" + this.welcome + ", face=" + this.face + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConfigRoot copy$default(ConfigRoot configRoot, List list, ConfigFace configFace, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = configRoot.welcome;
            }
            if ((i3 & 2) != 0) {
                configFace = configRoot.face;
            }
            return configRoot.copy(list, configFace);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConfigRoot)) {
                return false;
            }
            ConfigRoot configRoot = (ConfigRoot) other;
            return Intrinsics.areEqual(this.welcome, configRoot.welcome) && Intrinsics.areEqual(this.face, configRoot.face);
        }
    }
}
