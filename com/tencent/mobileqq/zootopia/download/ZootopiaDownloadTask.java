package com.tencent.mobileqq.zootopia.download;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapFullDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import wg3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001ZB\u0087\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010'\u001a\u00020\u000e\u0012\u0006\u0010)\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u00020*\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\b\b\u0002\u0010>\u001a\u00020\u0004\u0012\b\b\u0002\u0010B\u001a\u00020\u0004\u0012\u0006\u0010H\u001a\u00020C\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010R\u001a\u00020\u000e\u0012\b\b\u0002\u0010S\u001a\u00020\u0004\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0006\u0010\u001a\u001a\u00020\u000eR\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001cR\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001cR\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0017\u00106\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u00109\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00103\u001a\u0004\b;\u00105\"\u0004\b<\u0010=R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u00103\u001a\u0004\b@\u00105\"\u0004\bA\u0010=R\u0017\u0010H\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR$\u0010O\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0017\u0010R\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\bP\u0010\u001c\u001a\u0004\bQ\u0010 R\u0017\u0010S\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u00103\u001a\u0004\bS\u00105R\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadTask;", "Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask;", "", "o0", "", "needDeleteTask", "d0", "isMd5Error", "b0", "c0", "", "diffBeginTime", "", "diffPatchFailReason", "", "failMsg", "k0", "j0", "I", "K", "g", "i", "l", "M", "e", "h0", "g0", HippyTKDListViewAdapter.X, "Ljava/lang/String;", "id", "y", "getUrl", "()Ljava/lang/String;", "t0", "(Ljava/lang/String;)V", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "filePath", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, WadlProxyConsts.PARAM_FILENAME, "B", "title", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "getModVersionSimpleData", "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "q0", "(Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;)V", "modVersionSimpleData", "D", "Z", "l0", "()Z", "isAutoDownload", "E", "n0", "isUpdate", UserInfo.SEX_FEMALE, "m0", "s0", "(Z)V", "isSilentDownload", "G", "getNeedNotification", "r0", "needNotification", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapFullDownloadInfo;", "H", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapFullDownloadInfo;", "f0", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapFullDownloadInfo;", "fullDownloadInfo", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "e0", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "setDiffUpdateInfo", "(Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "diffUpdateInfo", "J", "i0", "oldPakFilePath", "isPlayDownloadTogether", "Lxg3/a;", "L", "Lxg3/a;", "diffUpdateReporter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;ZZZZLcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapFullDownloadInfo;Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;Ljava/lang/String;Z)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadTask extends BaseDownloadTask {

    /* renamed from: A, reason: from kotlin metadata */
    private String fileName;

    /* renamed from: B, reason: from kotlin metadata */
    private final String title;

    /* renamed from: C, reason: from kotlin metadata */
    private ZPlanModVersionSimpleData modVersionSimpleData;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isAutoDownload;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isUpdate;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isSilentDownload;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needNotification;

    /* renamed from: H, reason: from kotlin metadata */
    private final ZPlanMapFullDownloadInfo fullDownloadInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private ZPlanMapDiffPatchInfo diffUpdateInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private final String oldPakFilePath;

    /* renamed from: K, reason: from kotlin metadata */
    private final boolean isPlayDownloadTogether;

    /* renamed from: L, reason: from kotlin metadata */
    private final xg3.a diffUpdateReporter;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final String id;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String url;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final String filePath;

    private final boolean c0() {
        QLog.i("Zootopia_DownloadTask_Mod", 1, this.id + " decompression " + this.fileName);
        String str = this.filePath;
        String str2 = File.separator;
        File file = new File(str + str2 + this.fileName);
        try {
            ZipUtils.unZipFile(file, this.filePath + str2, false);
            return true;
        } catch (IOException e16) {
            QLog.e("Zootopia_DownloadTask_Mod", 1, this.id + " decompression failed " + this.fileName, e16);
            return false;
        } catch (Exception e17) {
            QLog.e("Zootopia_DownloadTask_Mod", 1, this.id + " decompression failed " + this.fileName, e17);
            return false;
        }
    }

    private final void j0() {
        boolean equals;
        pv4.e diffPatchInfo;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffUpdateInfo;
        if (zPlanMapDiffPatchInfo != null) {
            String str = (zPlanMapDiffPatchInfo == null || (diffPatchInfo = zPlanMapDiffPatchInfo.diffPatchInfo()) == null) ? null : diffPatchInfo.f427591c;
            if (str == null) {
                str = "";
            }
            final String pakMd5 = this.modVersionSimpleData.getPakMd5();
            String str2 = this.filePath;
            String str3 = File.separator;
            String str4 = str2 + str3 + this.fileName;
            final long currentTimeMillis = System.currentTimeMillis();
            final long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i("Zootopia_DownloadTask_Mod", 1, "handleDiffPatch BEGIN " + this.id + " " + this.title + ", expectedDiffMd5: " + str + ", realDiffMd5: " + str + ", expectedNewVersionMd5: " + pakMd5 + ", diffMd5CheckCostTime: " + currentTimeMillis2 + ", oldPakPath: " + this.oldPakFilePath + ", diffFilePath: " + str4);
            if (!TextUtils.isEmpty(str)) {
                equals = StringsKt__StringsJVMKt.equals(str, str, true);
                if (!equals) {
                    k0(currentTimeMillis, 1, "diffFile md5 fail, expected: " + str + ", real: " + str);
                    return;
                }
            }
            QLog.i("Zootopia_DownloadTask_Mod", 1, "handleDiffPatch diff md5 check passed, start patch");
            final long currentTimeMillis3 = System.currentTimeMillis();
            final String str5 = this.filePath + str3 + "tmp_" + currentTimeMillis3 + "_" + this.fileName;
            wg3.b.f445625a.b(this.oldPakFilePath, str4, str5, new Function2<Boolean, b.C11482b, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadTask$handleDiffPatch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, b.C11482b c11482b) {
                    invoke(bool.booleanValue(), c11482b);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, b.C11482b params) {
                    boolean contains$default;
                    xg3.a aVar;
                    String str6;
                    pv4.e diffPatchInfo2;
                    pv4.e diffPatchInfo3;
                    pv4.e diffPatchInfo4;
                    boolean equals2;
                    Intrinsics.checkNotNullParameter(params, "params");
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    long patchCostTime = params.getPatchCostTime();
                    QLog.i("Zootopia_DownloadTask_Mod", 1, "hPatch complete: " + z16 + ", params: " + params);
                    if (z16) {
                        long currentTimeMillis5 = System.currentTimeMillis();
                        String e16 = com.tencent.mobileqq.portal.o.e(str5);
                        if (e16 == null) {
                            e16 = "";
                        }
                        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                        if (!TextUtils.isEmpty(pakMd5)) {
                            equals2 = StringsKt__StringsJVMKt.equals(pakMd5, e16, true);
                            if (!equals2) {
                                this.k0(currentTimeMillis, 4, "outputFile md5 fail, expected: " + pakMd5 + ", real: " + e16);
                                return;
                            }
                        }
                        long currentTimeMillis7 = System.currentTimeMillis();
                        FileUtils.deleteFile(this.getOldPakFilePath());
                        boolean rename = FileUtils.rename(str5, this.getOldPakFilePath(), true);
                        long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis7;
                        if (!rename) {
                            this.k0(currentTimeMillis, 5, "outputFile rename failed");
                            return;
                        }
                        long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
                        QLog.i("Zootopia_DownloadTask_Mod", 1, "handleDiffPatch SUCCESS, totalCostTime= " + currentTimeMillis9 + ", diffMd5CheckCostTime= " + currentTimeMillis2 + ", patchCostTime= " + patchCostTime + ", loadAndPatchTotalTime= " + currentTimeMillis4 + ", outputMd5CheckCostTime= " + currentTimeMillis6 + ", outputFileRenameCostTime= " + currentTimeMillis8);
                        this.d0(true);
                        aVar = this.diffUpdateReporter;
                        str6 = this.id;
                        ZPlanMapDiffPatchInfo diffUpdateInfo = this.getDiffUpdateInfo();
                        String str7 = (diffUpdateInfo == null || (diffPatchInfo4 = diffUpdateInfo.diffPatchInfo()) == null) ? null : diffPatchInfo4.f427595g;
                        if (str7 == null) {
                            str7 = "";
                        }
                        String fullDownloadVersion = this.getFullDownloadInfo().getFullDownloadVersion();
                        ZPlanMapDiffPatchInfo diffUpdateInfo2 = this.getDiffUpdateInfo();
                        String str8 = (diffUpdateInfo2 == null || (diffPatchInfo3 = diffUpdateInfo2.diffPatchInfo()) == null) ? null : diffPatchInfo3.f427589a;
                        if (str8 == null) {
                            str8 = "";
                        }
                        ZPlanMapDiffPatchInfo diffUpdateInfo3 = this.getDiffUpdateInfo();
                        aVar.e(true, 0, "", str6, str7, fullDownloadVersion, str8, (diffUpdateInfo3 == null || (diffPatchInfo2 = diffUpdateInfo3.diffPatchInfo()) == null) ? 0L : diffPatchInfo2.f427590b, this.getFullDownloadInfo().getDownloadUrl(), this.getFullDownloadInfo().getFullDownloadSize(), currentTimeMillis9, patchCostTime, currentTimeMillis4, currentTimeMillis6);
                        return;
                    }
                    ZootopiaDownloadTask zootopiaDownloadTask = this;
                    long j3 = currentTimeMillis;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) params.getErrorCode(), (CharSequence) "res_load_patch_so", false, 2, (Object) null);
                    int i3 = contains$default ? 3 : 2;
                    zootopiaDownloadTask.k0(j3, i3, "patch error, reason= " + params.getErrorCode() + ", errMsg= " + params.getErrorMessage() + ", cost " + currentTimeMillis4);
                }
            });
            return;
        }
        QLog.e("Zootopia_DownloadTask_Mod", 1, "handleDiffPatch error, diffUpdateInfo is null!");
    }

    private final void o0() {
        boolean endsWith$default;
        boolean equals;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffUpdateInfo;
        if (zPlanMapDiffPatchInfo != null && zPlanMapDiffPatchInfo.isValid()) {
            j0();
            return;
        }
        String md5 = this.modVersionSimpleData.getMd5();
        boolean enableBizMd5Check = ac3.b.INSTANCE.a().getEnableBizMd5Check();
        QLog.i("Zootopia_DownloadTask_Mod", 1, "decompress expectedMd5:" + md5 + ", enableBizMd5Check:" + enableBizMd5Check);
        if (enableBizMd5Check) {
            if (md5.length() > 0) {
                File file = new File(this.filePath + File.separator + this.fileName);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("decompress file:");
                sb5.append(file);
                QLog.i("Zootopia_DownloadTask_Mod", 1, sb5.toString());
                String e16 = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
                if (e16 == null) {
                    e16 = "";
                }
                QLog.i("Zootopia_DownloadTask_Mod", 1, "decompress realMd5:" + e16);
                equals = StringsKt__StringsJVMKt.equals(md5, e16, true);
                if (equals) {
                    QLog.i("Zootopia_DownloadTask_Mod", 1, "decompress md5 check passed!");
                } else {
                    QLog.e("Zootopia_DownloadTask_Mod", 1, "decompress md5 check failed, title:" + this.title + ", id:" + this.id + ", url:" + this.url + ", excepted:" + md5 + ", realMd5:" + e16);
                    b0(true);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ag
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZootopiaDownloadTask.p0();
                        }
                    });
                    return;
                }
            }
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(this.fileName, ".zip", false, 2, null);
        boolean z16 = !endsWith$default;
        long currentTimeMillis = System.currentTimeMillis();
        boolean c06 = z16 ? true : c0();
        QLog.i("Zootopia_DownloadTask_Mod", 1, "decompress complete " + c06 + ", costTime=" + (System.currentTimeMillis() - currentTimeMillis) + ", skipDecompress= " + z16);
        if (c06) {
            d0(!z16);
        } else {
            b0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0() {
        com.tencent.mobileqq.zootopia.download.ui.f.c(com.tencent.mobileqq.zootopia.download.ui.f.f328286a, null, 1, null);
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    /* renamed from: I */
    public String getCategory() {
        return ZPlanFileCategory.Mod.getDesc();
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    /* renamed from: K, reason: from getter */
    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    public boolean e() {
        return true;
    }

    /* renamed from: e0, reason: from getter */
    public final ZPlanMapDiffPatchInfo getDiffUpdateInfo() {
        return this.diffUpdateInfo;
    }

    /* renamed from: f0, reason: from getter */
    public final ZPlanMapFullDownloadInfo getFullDownloadInfo() {
        return this.fullDownloadInfo;
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    /* renamed from: g, reason: from getter */
    public boolean getIsSilentDownload() {
        return this.isSilentDownload;
    }

    public final String g0() {
        if (!getIsUpdate()) {
            return "0";
        }
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffUpdateInfo;
        boolean z16 = false;
        if (zPlanMapDiffPatchInfo != null && zPlanMapDiffPatchInfo.isValid()) {
            z16 = true;
        }
        if (z16) {
            return "1";
        }
        return "2";
    }

    public long h0() {
        pv4.e diffPatchInfo;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffUpdateInfo;
        boolean z16 = false;
        if (zPlanMapDiffPatchInfo != null && zPlanMapDiffPatchInfo.isValid()) {
            z16 = true;
        }
        if (z16) {
            ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo2 = this.diffUpdateInfo;
            if (zPlanMapDiffPatchInfo2 == null || (diffPatchInfo = zPlanMapDiffPatchInfo2.diffPatchInfo()) == null) {
                return 0L;
            }
            return diffPatchInfo.f427590b;
        }
        return this.fullDownloadInfo.getFullDownloadSize();
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    /* renamed from: i, reason: from getter */
    public boolean getNeedNotification() {
        return this.needNotification;
    }

    /* renamed from: i0, reason: from getter */
    public final String getOldPakFilePath() {
        return this.oldPakFilePath;
    }

    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask, com.tencent.mobileqq.zootopia.download.x
    /* renamed from: l, reason: from getter */
    public boolean getIsPlayDownloadTogether() {
        return this.isPlayDownloadTogether;
    }

    /* renamed from: l0, reason: from getter */
    public final boolean getIsAutoDownload() {
        return this.isAutoDownload;
    }

    public final boolean m0() {
        return this.isSilentDownload;
    }

    public final boolean n0() {
        return this.isUpdate;
    }

    public final void q0(ZPlanModVersionSimpleData zPlanModVersionSimpleData) {
        Intrinsics.checkNotNullParameter(zPlanModVersionSimpleData, "<set-?>");
        this.modVersionSimpleData = zPlanModVersionSimpleData;
    }

    public final void r0(boolean z16) {
        this.needNotification = z16;
    }

    public final void s0(boolean z16) {
        this.isSilentDownload = z16;
    }

    public final void t0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    private final void b0(boolean isMd5Error) {
        R(6);
        HalleyDownloader.f327980a.d(this.url, false);
        Iterator<T> it = F().iterator();
        while (it.hasNext()) {
            ((y) it.next()).h(isMd5Error ? -5 : -2, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(boolean needDeleteTask) {
        R(5);
        if (needDeleteTask) {
            HalleyDownloader.f327980a.d(this.url, true);
        }
        Iterator<T> it = F().iterator();
        while (it.hasNext()) {
            ((y) it.next()).c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zootopia.download.BaseDownloadTask
    public void M() {
        R(3);
        Iterator<T> it = F().iterator();
        while (it.hasNext()) {
            ((y) it.next()).a(this);
        }
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(long diffBeginTime, int diffPatchFailReason, String failMsg) {
        pv4.e diffPatchInfo;
        pv4.e diffPatchInfo2;
        pv4.e diffPatchInfo3;
        QLog.e("Zootopia_DownloadTask_Mod", 1, "handleDiffPatch ERROR " + this.id + " " + this.title + ", reason: " + diffPatchFailReason + ", " + failMsg);
        xg3.a aVar = this.diffUpdateReporter;
        String str = this.id;
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffUpdateInfo;
        String str2 = (zPlanMapDiffPatchInfo == null || (diffPatchInfo3 = zPlanMapDiffPatchInfo.diffPatchInfo()) == null) ? null : diffPatchInfo3.f427595g;
        String str3 = str2 == null ? "" : str2;
        String fullDownloadVersion = this.fullDownloadInfo.getFullDownloadVersion();
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo2 = this.diffUpdateInfo;
        String str4 = (zPlanMapDiffPatchInfo2 == null || (diffPatchInfo2 = zPlanMapDiffPatchInfo2.diffPatchInfo()) == null) ? null : diffPatchInfo2.f427589a;
        if (str4 == null) {
            str4 = "";
        }
        ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo3 = this.diffUpdateInfo;
        aVar.e(false, diffPatchFailReason, failMsg, str, str3, fullDownloadVersion, str4, (zPlanMapDiffPatchInfo3 == null || (diffPatchInfo = zPlanMapDiffPatchInfo3.diffPatchInfo()) == null) ? 0L : diffPatchInfo.f427590b, this.fullDownloadInfo.getDownloadUrl(), this.fullDownloadInfo.getFullDownloadSize(), System.currentTimeMillis() - diffBeginTime, 0L, 0L, 0L);
        ZootopiaDownloadManager.f327992a.U0(this.id);
        R(6);
        HalleyDownloader.f327980a.d(this.url, true);
        QLog.i("Zootopia_DownloadTask_Mod", 1, this.id + " " + this.title + " reStartDownload, newUrl= " + this.fullDownloadInfo.getDownloadUrl() + ", oldUrl= " + this.url);
        this.url = this.fullDownloadInfo.getDownloadUrl();
        String saveFileName = this.fullDownloadInfo.getSaveFileName();
        this.fileName = saveFileName;
        U(this.url, this.filePath, saveFileName);
        this.diffUpdateInfo = null;
        startDownload();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadTask(String id5, String url, String filePath, String fileName, String title, ZPlanModVersionSimpleData modVersionSimpleData, boolean z16, boolean z17, boolean z18, boolean z19, ZPlanMapFullDownloadInfo fullDownloadInfo, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo, String oldPakFilePath, boolean z26) {
        super(id5, url, filePath, fileName, null, 16, null);
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
        Intrinsics.checkNotNullParameter(fullDownloadInfo, "fullDownloadInfo");
        Intrinsics.checkNotNullParameter(oldPakFilePath, "oldPakFilePath");
        this.id = id5;
        this.url = url;
        this.filePath = filePath;
        this.fileName = fileName;
        this.title = title;
        this.modVersionSimpleData = modVersionSimpleData;
        this.isAutoDownload = z16;
        this.isUpdate = z17;
        this.isSilentDownload = z18;
        this.needNotification = z19;
        this.fullDownloadInfo = fullDownloadInfo;
        this.diffUpdateInfo = zPlanMapDiffPatchInfo;
        this.oldPakFilePath = oldPakFilePath;
        this.isPlayDownloadTogether = z26;
        this.diffUpdateReporter = new xg3.a();
    }
}
