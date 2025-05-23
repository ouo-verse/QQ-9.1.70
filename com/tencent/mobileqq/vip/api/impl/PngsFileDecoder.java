package com.tencent.mobileqq.vip.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0010\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0010\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u001c\u0010\u0015\u001a\u00020\u00022\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/PngsFileDecoder;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "", "j", "Landroid/content/Context;", "context", "", "filePath", "", tl.h.F, "", "index", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "", "i", "b", "Lkotlin/Function1;", "block", "e", "a", "Landroid/graphics/Bitmap;", "mFirstFrame", "", "Ljava/util/List;", "mFrameList", "d", "Ljava/lang/String;", "mFilePath", "J", "getMInvalidateTimeMs", "()J", "setMInvalidateTimeMs", "(J)V", "mInvalidateTimeMs", "invalidateTimeMs", "<init>", "(Ljava/lang/String;J)V", "f", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PngsFileDecoder extends AbsFileDecoder {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f312827g;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mFirstFrame;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> mFrameList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mFilePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mInvalidateTimeMs;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/PngsFileDecoder$a;", "", "", "VAS_BUG_FIX_137631363_PNGS", "Z", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.PngsFileDecoder$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49710);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
            f312827g = ar.INSTANCE.b("shouyouye", "2025-02-07", "vas_bugfix_137631363_PNGS").isEnable(true);
        }
    }

    public PngsFileDecoder(@NotNull String filePath, long j3) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, filePath, Long.valueOf(j3));
        } else {
            this.mFilePath = filePath;
            this.mInvalidateTimeMs = j3;
        }
    }

    private final float h(Context context, String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        int i3 = options.outWidth;
        int i16 = options.outHeight;
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i17 = point.x;
        int i18 = point.y;
        if (i3 <= i17 && i16 <= i18) {
            return 1.0f;
        }
        return Math.max(i3 / i17, i16 / i18);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j() {
        Bitmap.Config config;
        boolean endsWith$default;
        boolean z16;
        boolean endsWith$default2;
        File file = new File(this.mFilePath);
        if (file.exists()) {
            String[] list = file.list();
            List<String> list2 = null;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (String it : list) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(it, ".png", false, 2, null);
                    if (!endsWith$default) {
                        endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(it, ".webp", false, 2, null);
                        if (!endsWith$default2) {
                            z16 = false;
                            if (!z16) {
                                arrayList.add(it);
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
                list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            }
            this.mFrameList = list2;
            if (list2 != null) {
                final PngsFileDecoder$initDecoder$2$1 pngsFileDecoder$initDecoder$2$1 = PngsFileDecoder$initDecoder$2$1.INSTANCE;
                Collections.sort(list2, new Comparator() { // from class: com.tencent.mobileqq.vip.api.impl.i
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int k3;
                        k3 = PngsFileDecoder.k(Function2.this, obj, obj2);
                        return k3;
                    }
                });
            }
        }
        List<String> list3 = this.mFrameList;
        if (list3 != null && (!list3.isEmpty())) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 26 && d()) {
                config = Bitmap.Config.HARDWARE;
                options.inPreferredConfig = config;
            }
            this.mFirstFrame = BitmapFactory.decodeFile(this.mFilePath + File.separator + ((Object) list3.get(0)), options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b */
    public int getMFrameCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        List<String> list = this.mFrameList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    @Nullable
    public AbsFileDecoder.a c(int index, @Nullable Bitmap bitmap) {
        boolean z16;
        Bitmap.Config config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AbsFileDecoder.a) iPatchRedirector.redirect((short) 5, (Object) this, index, (Object) bitmap);
        }
        if (this.mFrameList == null) {
            j();
        }
        if (com.tencent.cachedrawable.dynamicdrawable.utils.d.f99062a.d()) {
            return null;
        }
        List<String> list = this.mFrameList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            List<String> list2 = this.mFrameList;
            Intrinsics.checkNotNull(list2);
            if (index < list2.size()) {
                String str = this.mFilePath;
                String str2 = File.separator;
                List<String> list3 = this.mFrameList;
                Intrinsics.checkNotNull(list3);
                String str3 = str + str2 + ((Object) list3.get(index));
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (bitmap != null) {
                    options.inMutable = true;
                    options.inBitmap = bitmap;
                } else if (Build.VERSION.SDK_INT >= 26 && d()) {
                    config = Bitmap.Config.HARDWARE;
                    options.inPreferredConfig = config;
                }
                if (f312827g) {
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    options.inSampleSize = (int) h(context, str3);
                }
                Bitmap frameBitmap = BitmapFactory.decodeFile(str3, options);
                Intrinsics.checkNotNullExpressionValue(frameBitmap, "frameBitmap");
                return new AbsFileDecoder.a(frameBitmap, i());
            }
        }
        return null;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull Function1<? super AbsFileDecoder, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) block);
        } else {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(this);
        }
    }

    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mInvalidateTimeMs;
    }

    public /* synthetic */ PngsFileDecoder(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 100L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
