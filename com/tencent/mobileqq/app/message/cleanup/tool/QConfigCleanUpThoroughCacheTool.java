package com.tencent.mobileqq.app.message.cleanup.tool;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.ap;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/QConfigCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Lcom/tencent/mobileqq/config/ap;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/config/ap;", "<init>", "()V", "Companion", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QConfigCleanUpThoroughCacheTool implements y {
    public static final String TAG = "QConfigCleanUpThoroughCacheTool";
    private final ap config = ap.INSTANCE.a();

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        Long longOrNull;
        Integer intOrNull;
        if (!this.config.getEnableClean()) {
            QLog.i(TAG, 1, "disable clean, return");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return;
        }
        String str = d.f195978a.a() + "/qstore/" + account + "/conf";
        for (String str2 : this.config.c()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(account);
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
            if (longOrNull != null && intOrNull != null) {
                am.s().P(intOrNull.intValue(), -1);
            }
            File file = new File(str + "/" + str2);
            if (file.exists()) {
                QLog.i(TAG, 4, "delete dir: " + file.getPath());
                FilesKt__UtilsKt.deleteRecursively(file);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        return y.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public ArrayList<String> getWhiteList() {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(d.f195978a.a() + "/qstore");
        return arrayListOf;
    }
}
