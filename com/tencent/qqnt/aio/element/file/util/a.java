package com.tencent.qqnt.aio.element.file.util;

import android.annotation.SuppressLint;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0010\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u001a\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0000\u001a\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0007\u001a\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010\"2\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u0013j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", DTConstants.TAG.ELEMENT, "", "f", "g", "", "lDeadTime", "", "a", LayoutAttrDefine.CLICK_URI, "c", "fileElement", "", "d", "filePath", "e", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", TagName.FILE_TYPE, "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static HashMap<String, Integer> f349872a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51041);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f349872a = new HashMap<>();
        }
    }

    @NotNull
    public static final String a(long j3) {
        long j16 = j3 * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (j16 <= currentTimeMillis) {
            return "\u5df2\u8fc7\u671f";
        }
        return (((j16 - currentTimeMillis) / 86400000) + 1) + "\u5929\u540e\u5230\u671f";
    }

    public static final boolean b(@NotNull AIOMsgItem msgItem) {
        String str;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(3);
        if (firstTypeElement == null) {
            QLog.i("FileUtil", 1, "fileNeedDownload, element is null, msg=" + msgItem);
            return false;
        }
        FileElement fileElement = firstTypeElement.fileElement;
        if (fileElement != null) {
            str = fileElement.filePath;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return !FileUtils.fileExistsAndNotEmpty(str);
    }

    @NotNull
    public static final String c(@Nullable String str) {
        boolean endsWith$default;
        int lastIndexOf$default;
        String replace$default;
        int lastIndexOf$default2;
        String replace$default2;
        String replace$default3;
        boolean equals;
        if (str == null) {
            return "";
        }
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, ".rename", false, 2, null);
        if (endsWith$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, ".rename", "", false, 4, (Object) null);
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) replace$default, ".", 0, false, 6, (Object) null);
            if (lastIndexOf$default2 == -1) {
                return "";
            }
            String substring = replace$default.substring(lastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            replace$default2 = StringsKt__StringsJVMKt.replace$default(new Regex("[0-9]*").replace(substring, ""), "(", "", false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, ")", "", false, 4, (Object) null);
            equals = StringsKt__StringsJVMKt.equals(replace$default3, ".apk", true);
            if (equals) {
                return ".apk.rename";
            }
        }
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
        if (lastIndexOf$default < 0) {
            return "";
        }
        String substring2 = str.substring(lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return substring2;
    }

    public static final int d(@NotNull FileElement fileElement) {
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        String str = fileElement.fileName;
        Intrinsics.checkNotNullExpressionValue(str, "fileElement.fileName");
        int e16 = e(str);
        if (e16 == -1) {
            Integer num = fileElement.subElementType;
            if (num != null && num.intValue() == 1) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileUtil", 2, "fileElement.subElementType is pic, fileUuid: " + fileElement.fileUuid + ", fileMd5: " + fileElement.fileMd5);
                    return 0;
                }
                return 0;
            }
            Integer num2 = fileElement.subElementType;
            if (num2 != null && num2.intValue() == 2) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileUtil", 2, "fileElement.subElementType is video, fileUuid: " + fileElement.fileUuid + ", fileMd5: " + fileElement.fileMd5);
                }
                return 2;
            }
        }
        return e16;
    }

    @SuppressLint({"DefaultLocale"})
    public static final synchronized int e(@NotNull String filePath) {
        boolean z16;
        synchronized (a.class) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            String c16 = c(filePath);
            if (c16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = -1;
            if (z16) {
                return -1;
            }
            String lowerCase = c16.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (f349872a.isEmpty()) {
                f349872a.put(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION, 1);
                f349872a.put(".3gpp", 1);
                f349872a.put(".flac", 1);
                f349872a.put(".ogg", 1);
                f349872a.put(".wav", 1);
                f349872a.put(".m4a", 1);
                f349872a.remove(".flv");
                f349872a.remove(".m");
                f349872a.remove(".webp");
                f349872a.remove(".vcf");
                f349872a.put(".bmp", 0);
                f349872a.put(".jpg", 0);
                f349872a.put(".jpeg", 0);
                f349872a.put(".png", 0);
                f349872a.put(QzoneEmotionUtils.SIGN_ICON_URL_END, 0);
                f349872a.put(".webp", 0);
                f349872a.put(".psd", 12);
                f349872a.put(".mov", 2);
                f349872a.put(".mp4", 2);
                f349872a.put(".3gp", 2);
                f349872a.put(".avi", 2);
                f349872a.put(".rmvb", 2);
                f349872a.put(".mpg", 2);
                f349872a.put(".rm", 2);
                f349872a.put(".asf", 2);
                f349872a.put(".mpeg", 2);
                f349872a.put(".mkv", 2);
                f349872a.put(".wmv", 2);
                f349872a.put(".flv", 2);
                f349872a.put(".f4v", 2);
                f349872a.put(".webm", 2);
                f349872a.put(".mod", 2);
                f349872a.put(".mpe", 2);
                f349872a.put(".m4r", 2);
                f349872a.put(".m4u", 2);
                f349872a.put(".m4v", 2);
                f349872a.put(".vob", 2);
                f349872a.put(".doc", 3);
                f349872a.put(".docx", 3);
                f349872a.put(".wps", 3);
                f349872a.put(".pages", 3);
                f349872a.put(".zip", 4);
                f349872a.put(".rar", 4);
                f349872a.put(".7z", 4);
                f349872a.put(".tar", 4);
                f349872a.put(".iso", 4);
                f349872a.put(".gz", 4);
                f349872a.put(".apk", 5);
                f349872a.put(".apk.rename", 5);
                f349872a.put(".xls", 6);
                f349872a.put(".xlsx", 6);
                f349872a.put(".csv", 6);
                f349872a.put(".numbers", 6);
                f349872a.put(".et", 6);
                f349872a.put(".ppt", 7);
                f349872a.put(".pptx", 7);
                f349872a.put(".pps", 7);
                f349872a.put(".dps", 7);
                f349872a.put(".keynotes", 7);
                f349872a.put(".htm", 8);
                f349872a.put(".html", 8);
                f349872a.put(".php", 8);
                f349872a.put(".pdf", 9);
                f349872a.put(".txt", 10);
                f349872a.put(".epub", 10);
                f349872a.put(".rtf", 10);
                f349872a.put(".c", 10);
                f349872a.put(".conf", 10);
                f349872a.put(".cpp", 10);
                f349872a.put(".h", 10);
                f349872a.put(".java", 10);
                f349872a.put(".log", 10);
                f349872a.put(".prop", 10);
                f349872a.put(".rc", 10);
                f349872a.put(".sh", 10);
                f349872a.put(".csv", 10);
                f349872a.put(".xml", 10);
                f349872a.put(".ai", 14);
                f349872a.put(".font", 15);
                f349872a.put(".ipa", 16);
                f349872a.put(".keynote", 17);
                f349872a.put(".note", 18);
                f349872a.put(".numbers", 19);
                f349872a.put(".pages", 20);
                f349872a.put(".sketch", 21);
            }
            HashMap<String, Integer> hashMap = f349872a;
            Locale locale = Locale.ROOT;
            String lowerCase2 = lowerCase.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (hashMap.containsKey(lowerCase2)) {
                HashMap<String, Integer> hashMap2 = f349872a;
                String lowerCase3 = lowerCase.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                Integer num = hashMap2.get(lowerCase3);
                if (num != null) {
                    i3 = num.intValue();
                }
                return i3;
            }
            return 11;
        }
    }

    public static final boolean f(@NotNull FileElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        Long l3 = element.expireTime;
        if ((l3 == null || l3.longValue() != 0) && NetConnInfoCenter.getServerTimeMillis() > element.expireTime.longValue() * 1000) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull FileElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        Integer num = element.invalidState;
        if (num != null && num.intValue() == 0) {
            return true;
        }
        return false;
    }
}
