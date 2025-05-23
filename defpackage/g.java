package defpackage;

import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0007j\b\u0012\u0004\u0012\u00020\u0001`\b*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001c\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003\u001a\u0014\u0010\u0010\u001a\u00020\r*\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u001a\f\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "picSize", "", "b", "", "isImportMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "thumbLevel", "", "filePath", "", "f", "d", "e", "c", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f400985a;

        static {
            int[] iArr = new int[PicSize.values().length];
            try {
                iArr[PicSize.PIC_DOWNLOAD_ORI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_THUMB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PicSize.PIC_LOCAL_HD_THUMB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PicSize.PIC_DOWNLOAD_BIG_THUMB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f400985a = iArr;
        }
    }

    @NotNull
    public static final ArrayList<PicSize> a(@NotNull PicElement picElement, boolean z16) {
        ArrayList<PicSize> arrayListOf;
        ArrayList<PicSize> arrayListOf2;
        ArrayList<PicSize> arrayListOf3;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (!MsgExtKt.u(picElement)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(PicSize.PIC_LOCAL_HD_THUMB, PicSize.PIC_DOWNLOAD_THUMB, PicSize.PIC_DOWNLOAD_BIG_THUMB, PicSize.PIC_DOWNLOAD_ORI);
            return arrayListOf;
        }
        if (z16) {
            arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(PicSize.PIC_DOWNLOAD_ORI, PicSize.PIC_DOWNLOAD_THUMB, PicSize.PIC_DOWNLOAD_BIG_THUMB);
            return arrayListOf3;
        }
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(PicSize.PIC_DOWNLOAD_ORI, PicSize.PIC_DOWNLOAD_THUMB);
        return arrayListOf2;
    }

    public static final int b(@NotNull PicElement picElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = a.f400985a[picSize.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                return 0;
            }
            if (i3 == 4) {
                return 720;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 198;
    }

    @Nullable
    public static final String c(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        return picElement.sourcePath;
    }

    @Nullable
    public static final String d(@NotNull PicElement picElement, int i3) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        HashMap<Integer, String> hashMap = picElement.thumbPath;
        if (hashMap != null) {
            return hashMap.get(Integer.valueOf(i3));
        }
        return null;
    }

    public static final void e(@NotNull PicElement picElement, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        picElement.sourcePath = str;
    }

    public static final void f(@NotNull PicElement picElement, int i3, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        if (picElement.thumbPath == null) {
            picElement.thumbPath = new HashMap<>();
        }
        HashMap<Integer, String> thumbPath = picElement.thumbPath;
        Intrinsics.checkNotNullExpressionValue(thumbPath, "thumbPath");
        thumbPath.put(Integer.valueOf(i3), str);
    }
}
