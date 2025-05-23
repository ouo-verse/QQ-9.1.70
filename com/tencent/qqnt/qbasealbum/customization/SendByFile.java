package com.tencent.qqnt.qbasealbum.customization;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.ktx.b;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0004J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ&\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "", "", "url", "", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "c", "", "chatType", "e", "isQuality", "d", "Landroid/content/Context;", "context", "onlyOne", "", "f", "", "infos", "g", "", "a", "J", "maxPicLimit", "maxVideoLimit", "compressVideLimit", "I", "pixelLimit", "totalPixelLimit", "Z", "canByFile", "<init>", "(JJJIIZ)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class SendByFile {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long maxPicLimit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long maxVideoLimit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long compressVideLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int pixelLimit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int totalPixelLimit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean canByFile;

    public SendByFile(long j3, long j16, long j17, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        this.maxPicLimit = j3;
        this.maxVideoLimit = j16;
        this.compressVideLimit = j17;
        this.pixelLimit = i3;
        this.totalPixelLimit = i16;
        this.canByFile = z16;
    }

    private final boolean b(String url) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        Intrinsics.checkNotNull(url);
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
            if (!startsWith$default2) {
                if (!URLUtil.isFileUrl(url)) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "avatar://", false, 2, null);
                    if (startsWith$default3) {
                        return false;
                    }
                    return URLUtil.isNetworkUrl(url);
                }
                return false;
            }
        }
        return true;
    }

    private final boolean c(final LocalMediaInfo info) {
        boolean z16;
        if (info.getMediaWidth() <= this.pixelLimit && info.getMediaHeight() <= this.pixelLimit && info.getMediaWidth() * info.getMediaHeight() <= this.totalPixelLimit) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ox3.a.a("SendByFile", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.customization.SendByFile$needSendByFile$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "need send by file because of pixel. info: " + LocalMediaInfo.this;
                }
            });
        }
        return z16;
    }

    private final boolean e(int chatType) {
        if (chatType != 8 && chatType != 6 && chatType != 10000000 && chatType != 10000001) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, String fToastText) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(fToastText, "$fToastText");
        g.f361234b.showToast(context, fToastText, 0);
    }

    public final boolean d(@Nullable LocalMediaInfo info, boolean isQuality) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, info, Boolean.valueOf(isQuality))).booleanValue();
        }
        if (info == null || b(info.getPath())) {
            return false;
        }
        long fileSize = info.getFileSize();
        if (fileSize <= 0) {
            String path = info.getPath();
            Intrinsics.checkNotNull(path);
            File file = new File(path);
            if (file.exists()) {
                fileSize = file.length();
            }
        }
        if (c(info)) {
            return true;
        }
        if (b.o(info)) {
            if (fileSize > this.maxVideoLimit || fileSize > this.compressVideLimit) {
                return true;
            }
        } else if (fileSize > this.maxPicLimit) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(@NotNull final Context context, @Nullable LocalMediaInfo info, boolean onlyOne, int chatType) {
        String string;
        String format;
        double d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, info, Boolean.valueOf(onlyOne), Integer.valueOf(chatType));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (info != null && !b(info.getPath()) && e(chatType)) {
            long fileSize = info.getFileSize();
            if (fileSize <= 0) {
                String path = info.getPath();
                Intrinsics.checkNotNull(path);
                File file = new File(path);
                if (file.exists()) {
                    fileSize = file.length();
                }
            }
            final String str = "";
            if (b.o(info) && (fileSize > this.maxVideoLimit || fileSize > this.compressVideLimit)) {
                if (this.canByFile && onlyOne) {
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    long j3 = this.maxVideoLimit;
                    String str2 = "M";
                    if (fileSize > j3) {
                        float f16 = 1024;
                        d16 = (((((float) j3) * 1.0f) / f16) / f16) + 1;
                        if (d16 > 1000.0d) {
                            d16 /= 1024.0d;
                            str2 = "G";
                        }
                    } else {
                        long j16 = 1024;
                        d16 = ((this.compressVideLimit / j16) / j16) + 1;
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string2 = context.getString(R.string.f1773533q);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026um_warning_video_by_file)");
                    format = String.format(string2, Arrays.copyOf(new Object[]{decimalFormat.format(d16).toString(), str2}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else if (onlyOne) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string3 = context.getString(R.string.f1773233n);
                    Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ideo_warning_cannot_send)");
                    long j17 = 1024;
                    format = String.format(string3, Arrays.copyOf(new Object[]{String.valueOf(((this.compressVideLimit / j17) / j17) + 1)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
                str = format;
            } else {
                if (!b.o(info) && fileSize > this.maxPicLimit) {
                    if (this.canByFile && onlyOne) {
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String string4 = context.getString(R.string.f17716338);
                        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026um_photo_warning_by_file)");
                        long j18 = 1024;
                        str = String.format(string4, Arrays.copyOf(new Object[]{String.valueOf((this.maxPicLimit / j18) / j18)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    } else if (onlyOne) {
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String string5 = context.getString(R.string.f17717339);
                        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026hoto_warning_cannot_send)");
                        long j19 = 1024;
                        str = String.format(string5, Arrays.copyOf(new Object[]{String.valueOf((this.maxPicLimit / j19) / j19)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    }
                }
                if (z16 && !onlyOne) {
                    if (!this.canByFile) {
                        string = context.getString(R.string.f1773333o);
                        Intrinsics.checkNotNullExpressionValue(string, "{ // \u591a\u5f20\u56fe\u80fd\u4ee5\u6587\u4ef6\u5f62\u5f0f\u53d1\u9001\n       \u2026em_by_file)\n            }");
                    } else {
                        string = context.getString(R.string.f1773433p);
                        Intrinsics.checkNotNullExpressionValue(string, "{ // \u591a\u5f20\u56fe \u4e0d\u80fd\u4ee5\u6587\u4ef6\u5f62\u5f0f\u53d1\u9001\uff0c\u5e76\u4e14\u6700\u7ec8\u56fe\u2026annot_send)\n            }");
                    }
                    str = string;
                }
                if (!z16) {
                    z16 = c(info);
                    str = context.getString(R.string.f1773333o);
                    Intrinsics.checkNotNullExpressionValue(str, "context.getString(R.stri\u2026rning_multi_item_by_file)");
                }
                if (!z16) {
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.customization.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            SendByFile.h(context, str);
                        }
                    });
                    return;
                }
                return;
            }
            z16 = true;
            if (z16) {
                if (!this.canByFile) {
                }
                str = string;
            }
            if (!z16) {
            }
            if (!z16) {
            }
        }
    }

    public final void g(@NotNull Context context, @Nullable List<LocalMediaInfo> infos, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, infos, Integer.valueOf(chatType));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (infos != null) {
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                f(context, (LocalMediaInfo) it.next(), false, chatType);
            }
        }
    }

    public /* synthetic */ SendByFile(long j3, long j16, long j17, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 31457280L : j3, (i17 & 2) != 0 ? 1048576000L : j16, (i17 & 4) != 0 ? 104345600L : j17, (i17 & 8) != 0 ? 30000 : i3, (i17 & 16) != 0 ? 250000000 : i16, (i17 & 32) != 0 ? true : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
