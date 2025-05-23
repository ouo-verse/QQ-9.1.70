package com.qzone.reborn.groupalbum.selectmedia.util;

import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\r\u001a\u00020\f*\u00020\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0012\u0010\u0010\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\f*\u00020\u000f\u001a\n\u0010\u0013\u001a\u00020\f*\u00020\u0012\u001a\n\u0010\u0014\u001a\u00020\f*\u00020\u0000\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001e\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0017*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0001\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "Lcom/qzone/reborn/groupalbum/selectmedia/util/PicSize;", "picSize", "", "c", "e", "size", "", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "b", "d", "", DomainData.DOMAIN_NAME, "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "i", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", h.F, "g", "Lkotlin/Pair;", "f", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.qzone.reborn.groupalbum.selectmedia.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public /* synthetic */ class C0478a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56953a;

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
                iArr[PicSize.PIC_DOWNLOAD_AIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f56953a = iArr;
        }
    }

    private static final PicSize a(PicElement picElement) {
        if (n(picElement)) {
            return PicSize.PIC_DOWNLOAD_ORI;
        }
        return PicSize.PIC_DOWNLOAD_THUMB;
    }

    public static final int b(FileElement fileElement, PicSize picSize) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C0478a.f56953a[picSize.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    public static final int c(PicElement picElement, PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C0478a.f56953a[picSize.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return c(picElement, a(picElement));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int d(FileElement fileElement, PicSize picSize) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C0478a.f56953a[picSize.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return 750;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int e(PicElement picElement, PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C0478a.f56953a[picSize.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 198;
        }
        if (i3 == 3) {
            return e(picElement, a(picElement));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Pair<Integer, Integer> f(MsgElement msgElement, PicSize size) {
        Pair<Integer, Integer> pair;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = msgElement.elementType;
        if (i3 == 2) {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
            Integer valueOf = Integer.valueOf(c(picElement, size));
            PicElement picElement2 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "picElement");
            pair = new Pair<>(valueOf, Integer.valueOf(e(picElement2, size)));
        } else {
            if (i3 != 3) {
                if (i3 == 5) {
                    return new Pair<>(2, 0);
                }
                throw new Exception("can not deal elementType " + msgElement.elementType + "  in getDownloadTypeAndThumbLevel");
            }
            FileElement fileElement = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
            Integer valueOf2 = Integer.valueOf(b(fileElement, size));
            FileElement fileElement2 = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement2, "fileElement");
            pair = new Pair<>(valueOf2, Integer.valueOf(d(fileElement2, size)));
        }
        return pair;
    }

    public static final int g(FileElement fileElement, PicSize picSize) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C0478a.f56953a[picSize.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return 750;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String h(FileElement fileElement, PicSize size) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        if (size == PicSize.PIC_DOWNLOAD_ORI) {
            return fileElement.filePath;
        }
        return fileElement.picThumbPath.get(Integer.valueOf(g(fileElement, size)));
    }

    public static final String i(MsgElement msgElement, PicSize size) {
        String j3;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = msgElement.elementType;
        if (i3 == 2) {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
            j3 = j(picElement, size);
        } else if (i3 == 3) {
            FileElement fileElement = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
            j3 = h(fileElement, size);
        } else if (i3 != 5) {
            j3 = "";
        } else {
            VideoElement videoElement = msgElement.videoElement;
            Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
            j3 = aj.f(videoElement);
        }
        return j3 == null ? "" : j3;
    }

    public static final String j(PicElement picElement, PicSize size) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = C0478a.f56953a[size.ordinal()];
        if (i3 == 1) {
            return aj.a(picElement);
        }
        if (i3 == 2) {
            return aj.b(picElement, 198);
        }
        if (i3 == 3) {
            String a16 = aj.a(picElement);
            return (n(picElement) && new File(a16).exists()) ? a16 : aj.b(picElement, 720);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean k(MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        int i3 = msgElement.elementType;
        if (i3 == 2) {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
            return l(picElement);
        }
        if (i3 == 3) {
            FileElement fileElement = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
            return com.tencent.qqnt.aio.element.file.util.a.f(fileElement);
        }
        if (i3 != 5) {
            return false;
        }
        VideoElement videoElement = msgElement.videoElement;
        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
        return m(videoElement);
    }

    public static final boolean l(PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer num = picElement.invalidState;
        return num == null || num.intValue() != 0;
    }

    public static final boolean m(VideoElement videoElement) {
        Intrinsics.checkNotNullParameter(videoElement, "<this>");
        Integer num = videoElement.invalidState;
        return num == null || num.intValue() != 0;
    }

    public static final boolean n(PicElement picElement) {
        Integer num;
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer num2 = picElement.picType;
        return (num2 != null && num2.intValue() == 2000) || ((num = picElement.picType) != null && num.intValue() == 2);
    }
}
