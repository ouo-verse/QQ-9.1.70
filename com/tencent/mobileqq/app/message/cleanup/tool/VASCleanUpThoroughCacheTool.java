package com.tencent.mobileqq.app.message.cleanup.tool;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.nativefilescan.DirSizeData;
import com.tencent.mobileqq.nativefilescan.FileScanCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/VASCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "needReport", "Z", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class VASCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_;
    private final boolean needReport;

    public VASCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.needReport = VasNormalToggle.BUG_CLEANER_REPORT.isEnable(true);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        long totalSize;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getCustomCleanFiles();
        FileScanCore b16 = FileScanCore.Companion.b(FileScanCore.INSTANCE, null, 1, null);
        HashMap hashMap = new HashMap();
        boolean z16 = false;
        if (this.needReport) {
            long j3 = 0;
            for (String str : getWhiteList()) {
                DirSizeData dirSizeData = new DirSizeData(0L, 0, 0, 7, null);
                b16.d(str, false, true, dirSizeData, null);
                VasCommonReporter.getHotFeature("cleaner").setValue2(new File(str).getName()).setValue3("before").setNum1(dirSizeData.getTotalSize()).setNum2(100L).report(false);
                hashMap.put(str, Long.valueOf(dirSizeData.getTotalSize()));
                j3 += dirSizeData.getTotalSize();
            }
            VasCommonReporter.getHotFeature("cleaner").setValue2(PreDownloadConstants.DEPARTMENT_VAS).setValue3("before").setNum1(j3).report(false);
        }
        ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).refreshCustomCleanFiles(true);
        if (this.needReport) {
            long j16 = 0;
            for (String str2 : getWhiteList()) {
                DirSizeData dirSizeData2 = new DirSizeData(0L, 0, 0, 7, null);
                b16.d(str2, false, true, dirSizeData2, null);
                Long l3 = (Long) hashMap.get(str2);
                if (l3 == null) {
                    l3 = 0L;
                }
                Intrinsics.checkNotNullExpressionValue(l3, "tempData[it] ?: 0L");
                long longValue = l3.longValue();
                ReportInfo num1 = VasCommonReporter.getHotFeature("cleaner").setValue2(new File(str2).getName()).setValue3("after").setNum1(dirSizeData2.getTotalSize());
                if (longValue == 0) {
                    totalSize = 0;
                } else {
                    totalSize = (((float) dirSizeData2.getTotalSize()) / ((float) longValue)) * 100;
                }
                num1.setNum2(totalSize).report(false);
                hashMap.put(str2, Long.valueOf(dirSizeData2.getTotalSize()));
                j16 += dirSizeData2.getTotalSize();
                z16 = false;
            }
            VasCommonReporter.getHotFeature("cleaner").setValue2(PreDownloadConstants.DEPARTMENT_VAS).setValue3("after").setNum1(j16).report(z16);
        }
        y.a.a(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).refreshCustomCleanFiles(false);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.a() + "/files/files/vas_material_folder/zip_download", dVar.a() + "/files/files/vas_material_folder/bubble_dir", dVar.a() + "/files/files/vas_material_folder/chat_back_ground", dVar.a() + "/files/files/vas_material_folder/font_info", dVar.a() + "/files/files/vas_material_folder/namePlate_dir", dVar.a() + "/files/files/vas_material_folder/namePlatePendant_dir", dVar.a() + "/files/files/vas_material_folder/font", dVar.a() + "/files/files/vas_material_folder/pendant", dVar.a() + "/files/files/vas_material_folder/face", dVar.a() + "/files/gldrawablelib", dVar.a() + "/files/kcsdk", dVar.a() + "/files/kingcard", dVar.a() + "/files/quickupdate");
        return arrayListOf;
    }
}
