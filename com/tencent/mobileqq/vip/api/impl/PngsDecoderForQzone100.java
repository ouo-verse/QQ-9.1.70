package com.tencent.mobileqq.vip.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u0014\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/PngsDecoderForQzone100;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "", "i", "", "index", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "", tl.h.F, "b", "Lkotlin/Function1;", "block", "e", "a", "Landroid/graphics/Bitmap;", "mFirstFrame", "", "", "Ljava/util/List;", "mFrameList", "d", "Ljava/lang/String;", "mFilePath", "I", "getMInvalidateTimeMs", "()I", "setMInvalidateTimeMs", "(I)V", "mInvalidateTimeMs", "filePath", "<init>", "(Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PngsDecoderForQzone100 extends AbsFileDecoder {
    static IPatchRedirector $redirector_;

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
    private int mInvalidateTimeMs;

    public PngsDecoderForQzone100(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) filePath);
        } else {
            this.mFilePath = filePath;
        }
    }

    private final void i() {
        boolean endsWith$default;
        File file = new File(this.mFilePath);
        if (file.exists()) {
            String[] list = file.list();
            List<String> list2 = null;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (String it : list) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(it, ".png", false, 2, null);
                    if (endsWith$default) {
                        arrayList.add(it);
                    }
                }
                list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            }
            this.mFrameList = list2;
            if (list2 != null) {
                final PngsDecoderForQzone100$initDecoder$2$1 pngsDecoderForQzone100$initDecoder$2$1 = PngsDecoderForQzone100$initDecoder$2$1.INSTANCE;
                Collections.sort(list2, new Comparator() { // from class: com.tencent.mobileqq.vip.api.impl.c
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int j3;
                        j3 = PngsDecoderForQzone100.j(Function2.this, obj, obj2);
                        return j3;
                    }
                });
            }
        }
        List<String> list3 = this.mFrameList;
        if (list3 != null && (!list3.isEmpty())) {
            this.mFirstFrame = BitmapFactory.decodeFile(this.mFilePath + File.separator + ((Object) list3.get(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b */
    public int getMFrameCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AbsFileDecoder.a) iPatchRedirector.redirect((short) 4, (Object) this, index, (Object) bitmap);
        }
        if (this.mFrameList == null) {
            i();
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
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                options.inBitmap = bitmap;
                String str = this.mFilePath;
                String str2 = File.separator;
                List<String> list3 = this.mFrameList;
                Intrinsics.checkNotNull(list3);
                Bitmap frameBitmap = BitmapFactory.decodeFile(str + str2 + ((Object) list3.get(index)), options);
                Intrinsics.checkNotNullExpressionValue(frameBitmap, "frameBitmap");
                return new AbsFileDecoder.a(frameBitmap, h());
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull Function1<? super AbsFileDecoder, Unit> block) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) block);
        } else {
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(this);
        }
    }

    public long h() {
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mInvalidateTimeMs, 100);
            return coerceAtLeast;
        }
        return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
    }
}
