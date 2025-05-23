package com.tencent.mobileqq.vas.updatesystem.api;

import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.util.file.b;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/updatesystem/api/a;", "", "", "trueTypeFontPath", "fullTypeFontPath", "tmpTrueFilePath", "", "a", "", MessageForRichState.SIGN_MSG_FONT_ID, "curProcess", "", "b", "Z", "enableSwitch", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "hasCheck", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f311148a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableSwitch = ar.INSTANCE.b("anzaihuang", "2024-05-16", "vas_font_ttf_convet_config").isEnable(true);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, Boolean> hasCheck = new ConcurrentHashMap<>();

    a() {
    }

    public final boolean a(@NotNull String trueTypeFontPath, @NotNull String fullTypeFontPath, @NotNull String tmpTrueFilePath) {
        Intrinsics.checkNotNullParameter(trueTypeFontPath, "trueTypeFontPath");
        Intrinsics.checkNotNullParameter(fullTypeFontPath, "fullTypeFontPath");
        Intrinsics.checkNotNullParameter(tmpTrueFilePath, "tmpTrueFilePath");
        if (!enableSwitch) {
            return true;
        }
        b bVar = b.f362981a;
        String b16 = bVar.b(trueTypeFontPath);
        if (TextUtils.isEmpty(b16)) {
            QLog.e("QzoneFontFileCheck", 1, "calc error");
            return true;
        }
        VipNtMMKV.Companion companion = VipNtMMKV.INSTANCE;
        String str = "";
        String decodeString = VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).decodeString(trueTypeFontPath, "");
        if (decodeString != null) {
            str = decodeString;
        }
        if (TextUtils.isEmpty(str)) {
            VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).encodeString(trueTypeFontPath, b16);
        } else if (!Intrinsics.areEqual(b16, str)) {
            new ReportInfo("qzone_ttf").setValue1(trueTypeFontPath).setValue2(str).setValue3(b16).setValue4("checkFontFileValid").report(false);
            try {
                boolean native_ftf2ttf = ETEngine.native_ftf2ttf(fullTypeFontPath, tmpTrueFilePath);
                if (native_ftf2ttf) {
                    String b17 = bVar.b(tmpTrueFilePath);
                    File file = new File(tmpTrueFilePath);
                    if (Intrinsics.areEqual(b17, b16)) {
                        if (file.exists()) {
                            file.delete();
                        }
                        VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).encodeString(trueTypeFontPath, b17);
                    } else if (Intrinsics.areEqual(b17, str)) {
                        File file2 = new File(trueTypeFontPath);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        native_ftf2ttf = file.renameTo(file2);
                        VipNtMMKV.Companion.getCommon$default(companion, null, 1, null).encodeString(trueTypeFontPath, b17);
                    } else {
                        native_ftf2ttf = false;
                    }
                    new ReportInfo("qzone_ttf").setValue1(trueTypeFontPath).setValue2(str).setValue3(b17).setValue4("checkFontFileValid").report(false);
                }
                return native_ftf2ttf;
            } catch (Throwable th5) {
                QLog.e("QzoneFontFileCheck", 1, "checkFontFileValid call native_ftf2ttf error, errMsg = " + th5);
                return false;
            }
        }
        return true;
    }

    public final synchronized void b(int fontId, @NotNull String trueTypeFontPath, @NotNull String fullTypeFontPath, @NotNull String curProcess) {
        boolean z16;
        Intrinsics.checkNotNullParameter(trueTypeFontPath, "trueTypeFontPath");
        Intrinsics.checkNotNullParameter(fullTypeFontPath, "fullTypeFontPath");
        Intrinsics.checkNotNullParameter(curProcess, "curProcess");
        if (!enableSwitch) {
            return;
        }
        b bVar = b.f362981a;
        String b16 = bVar.b(trueTypeFontPath);
        if (!TextUtils.isEmpty(b16)) {
            if (fullTypeFontPath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String str = trueTypeFontPath + "." + curProcess + ".check.tmp";
                QLog.d("QzoneFontFileCheck", 4, "trueTypeFontPath: " + trueTypeFontPath + ", tmpTrueFilePath: " + str);
                try {
                } catch (Throwable th5) {
                    QLog.e("QzoneFontFileCheck", 1, "checkFontValid call native_ftf2ttf error, errMsg = " + th5);
                }
                if (!new File(fullTypeFontPath).exists()) {
                    return;
                }
                ConcurrentHashMap<Integer, Boolean> concurrentHashMap = hasCheck;
                Boolean bool = concurrentHashMap.get(Integer.valueOf(fontId));
                Boolean bool2 = Boolean.TRUE;
                if (Intrinsics.areEqual(bool, bool2)) {
                    return;
                }
                concurrentHashMap.put(Integer.valueOf(fontId), bool2);
                if (ETEngine.native_ftf2ttf(fullTypeFontPath, str)) {
                    String b17 = bVar.b(str);
                    if (TextUtils.isEmpty(b17)) {
                        return;
                    }
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (Intrinsics.areEqual(b17, b16)) {
                        VipNtMMKV.Companion.getCommon$default(VipNtMMKV.INSTANCE, null, 1, null).encodeString(trueTypeFontPath, b17);
                        return;
                    }
                    File file2 = new File(trueTypeFontPath);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    new ReportInfo("qzone_ttf").setValue1(trueTypeFontPath).setValue2(b16).setValue3(b17).setValue4("scanFontValid").report(false);
                }
            }
        }
    }
}
