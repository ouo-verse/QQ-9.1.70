package com.tencent.qqnt.qbasealbum.query;

import android.graphics.BitmapFactory;
import androidx.core.internal.view.SupportMenu;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/b;", "", "", "imagePath", "Landroid/graphics/BitmapFactory$Options;", "options", "", "whArray", "", "d", "a", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "index", "b", "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;Ljava/lang/Integer;)Ljava/lang/String;", "", "Ljava/util/Map;", "pathWHMap", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "sDateFormatForMinute", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f361494a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> pathWHMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SimpleDateFormat sDateFormatForMinute;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f361494a = new b();
        pathWHMap = new HashMap();
        sDateFormatForMinute = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH\u70b9mm\u5206", Locale.getDefault());
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ String c(b bVar, LocalMediaInfo localMediaInfo, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        return bVar.b(localMediaInfo, num);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            pathWHMap.clear();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r8 == null) goto L16;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(@NotNull LocalMediaInfo info, @Nullable Integer index) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info, (Object) index);
        }
        Intrinsics.checkNotNullParameter(info, "info");
        String format = sDateFormatForMinute.format(new Date(info.getModifiedDate() * 1000));
        if (info.getMMediaType() == 1) {
            str = "\u89c6\u9891";
        } else {
            str = "\u7167\u7247";
        }
        String str3 = "";
        if (index != null) {
            str2 = index.intValue() + " ";
        }
        str2 = "";
        if (info.getMMediaType() == 1) {
            str3 = " \u89c6\u9891\u65f6\u957f: " + f.f361654a.a(com.tencent.qqnt.qbasealbum.ktx.b.f(info));
        }
        return str + " " + str2 + " \u62cd\u6444\u65f6\u95f4: " + format + str3;
    }

    public final void d(@Nullable String imagePath, @NotNull BitmapFactory.Options options, @NotNull int[] whArray) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, imagePath, options, whArray);
            return;
        }
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(whArray, "whArray");
        Map<String, Integer> map = pathWHMap;
        Integer num = map.get(imagePath);
        if (num != null) {
            whArray[0] = (num.intValue() >> 16) & 65535;
            whArray[1] = num.intValue() & 65535;
            return;
        }
        try {
            if (g.f361234b.isDebugVersion()) {
                QLog.d("QBaseAlbum.MediaQuery", 1, "getWHByPath true imagePath: " + imagePath);
            }
            SafeBitmapFactory.decodeFile(imagePath, options);
            i16 = options.outWidth;
            try {
                i3 = options.outHeight;
                if (i16 <= 65535 && i3 <= 65535) {
                    try {
                        map.put(imagePath, Integer.valueOf((65535 & i3) | ((i16 << 16) & SupportMenu.CATEGORY_MASK)));
                    } catch (OutOfMemoryError e16) {
                        e = e16;
                        QLog.e("QBaseAlbum.MediaQuery", 1, "getWHByPath error. ", e);
                        whArray[0] = i16;
                        whArray[1] = i3;
                    }
                }
            } catch (OutOfMemoryError e17) {
                e = e17;
                i3 = 0;
            }
        } catch (OutOfMemoryError e18) {
            e = e18;
            i3 = 0;
            i16 = 0;
        }
        whArray[0] = i16;
        whArray[1] = i3;
    }
}
