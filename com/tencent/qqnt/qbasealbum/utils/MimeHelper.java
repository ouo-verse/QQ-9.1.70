package com.tencent.qqnt.qbasealbum.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/utils/MimeHelper;", "", "", "mimeString", "", "a", "(Ljava/lang/String;)[Ljava/lang/String;", QCircleLpReportDc010001.KEY_SUBTYPE, "", "b", "mimeType", "c", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class MimeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MimeHelper f361630a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f361630a = new MimeHelper();
        }
    }

    MimeHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String[] a(@NotNull final String mimeString) {
        List split$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mimeString);
        }
        Intrinsics.checkNotNullParameter(mimeString, "mimeString");
        if (!TextUtils.isEmpty(mimeString)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) mimeString, new String[]{"/"}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length == 2) {
                return strArr;
            }
            ox3.a.a("QQAlbum", new Function0<String>(mimeString) { // from class: com.tencent.qqnt.qbasealbum.utils.MimeHelper$getMimeType$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $mimeString;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$mimeString = mimeString;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mimeString);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "Mimetype error:" + this.$mimeString;
                }
            });
            return null;
        }
        return null;
    }

    public final boolean b(@NotNull String subType) {
        int lastIndexOf$default;
        int lastIndexOf$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) subType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(subType, "subType");
        if (!Intrinsics.areEqual(subType, "jpg") && !Intrinsics.areEqual(subType, "gif") && !Intrinsics.areEqual(subType, "png") && !Intrinsics.areEqual(subType, com.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_JPEG)) {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) subType, "bmp", 0, false, 6, (Object) null);
            if (lastIndexOf$default == -1) {
                lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) subType, com.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP, 0, false, 6, (Object) null);
                if (lastIndexOf$default2 == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean c(@NotNull String mimeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) mimeType)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return Intrinsics.areEqual("video/mp4", mimeType);
    }
}
