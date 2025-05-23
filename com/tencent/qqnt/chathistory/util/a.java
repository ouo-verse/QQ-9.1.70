package com.tencent.qqnt.chathistory.util;

import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.exception.HistoryException;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0010\u001a\u00020\u000f*\u00020\r\u001a\n\u0010\u0012\u001a\u00020\u000f*\u00020\u0011\u001a\n\u0010\u0013\u001a\u00020\u000f*\u00020\u0000\u001a\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0007*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\u0015\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001e\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016*\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0001\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "Lcom/tencent/qqnt/chathistory/util/PicSize;", "picSize", "", "c", "e", "size", "", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "b", "d", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "i", "", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", tl.h.F, "g", "Lkotlin/Pair;", "f", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chathistory.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public /* synthetic */ class C9559a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f354053a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51745);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
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
            f354053a = iArr;
        }
    }

    private static final PicSize a(PicElement picElement) {
        if (MsgExtKt.x(picElement)) {
            return PicSize.PIC_DOWNLOAD_ORI;
        }
        return PicSize.PIC_DOWNLOAD_THUMB;
    }

    public static final int b(@NotNull FileElement fileElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C9559a.f354053a[picSize.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return i16;
    }

    public static final int c(@NotNull PicElement picElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C9559a.f354053a[picSize.ordinal()];
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

    public static final int d(@NotNull FileElement fileElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C9559a.f354053a[picSize.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return 750;
    }

    public static final int e(@NotNull PicElement picElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C9559a.f354053a[picSize.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return e(picElement, a(picElement));
                }
                throw new NoWhenBranchMatchedException();
            }
            return 198;
        }
        return 0;
    }

    @NotNull
    public static final Pair<Integer, Integer> f(@NotNull MsgElement msgElement, @NotNull PicSize size) {
        Pair<Integer, Integer> pair;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = msgElement.elementType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 5) {
                    return new Pair<>(2, 0);
                }
                throw new HistoryException("can not deal elementType " + msgElement.elementType + "  in getDownloadTypeAndThumbLevel");
            }
            FileElement fileElement = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
            Integer valueOf = Integer.valueOf(b(fileElement, size));
            FileElement fileElement2 = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement2, "fileElement");
            pair = new Pair<>(valueOf, Integer.valueOf(d(fileElement2, size)));
        } else {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
            Integer valueOf2 = Integer.valueOf(c(picElement, size));
            PicElement picElement2 = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement2, "picElement");
            pair = new Pair<>(valueOf2, Integer.valueOf(e(picElement2, size)));
        }
        return pair;
    }

    public static final int g(@NotNull FileElement fileElement, @NotNull PicSize picSize) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        int i3 = C9559a.f354053a[picSize.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return 750;
    }

    @Nullable
    public static final String h(@NotNull FileElement fileElement, @NotNull PicSize size) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        if (size == PicSize.PIC_DOWNLOAD_ORI) {
            return fileElement.filePath;
        }
        return fileElement.picThumbPath.get(Integer.valueOf(g(fileElement, size)));
    }

    @NotNull
    public static final String i(@NotNull MsgElement msgElement, @NotNull PicSize size) {
        String j3;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = msgElement.elementType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    j3 = "";
                } else {
                    VideoElement videoElement = msgElement.videoElement;
                    Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
                    j3 = aj.f(videoElement);
                }
            } else {
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
                j3 = h(fileElement, size);
            }
        } else {
            PicElement picElement = msgElement.picElement;
            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
            j3 = j(picElement, size);
        }
        if (j3 == null) {
            return "";
        }
        return j3;
    }

    @Nullable
    public static final String j(@NotNull PicElement picElement, @NotNull PicSize size) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Intrinsics.checkNotNullParameter(size, "size");
        int i3 = C9559a.f354053a[size.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    String a16 = aj.a(picElement);
                    if (!MsgExtKt.x(picElement) || !new File(a16).exists()) {
                        return aj.b(picElement, 720);
                    }
                    return a16;
                }
                throw new NoWhenBranchMatchedException();
            }
            return aj.b(picElement, 198);
        }
        return aj.a(picElement);
    }

    public static final boolean k(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        int i3 = msgElement.elementType;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    return false;
                }
                VideoElement videoElement = msgElement.videoElement;
                Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
                return m(videoElement);
            }
            FileElement fileElement = msgElement.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "fileElement");
            return com.tencent.qqnt.aio.element.file.util.a.f(fileElement);
        }
        PicElement picElement = msgElement.picElement;
        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
        return l(picElement);
    }

    public static final boolean l(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "<this>");
        Integer num = picElement.invalidState;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }

    public static final boolean m(@NotNull VideoElement videoElement) {
        Intrinsics.checkNotNullParameter(videoElement, "<this>");
        Integer num = videoElement.invalidState;
        if (num == null || num.intValue() != 0) {
            return true;
        }
        return false;
    }
}
