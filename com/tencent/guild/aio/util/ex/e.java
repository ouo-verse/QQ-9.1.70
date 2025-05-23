package com.tencent.guild.aio.util.ex;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001a\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "T", "", "", "e", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "a", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "g", "msgElementLi", "d", "c", "f", tl.h.F, "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {
    @Nullable
    public static final <T extends MsgElement> FaceElement a(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() > 0) {
            return list.get(0).faceElement;
        }
        return null;
    }

    public static final <T extends MsgElement> int b(@NotNull List<? extends T> list) {
        T t16;
        FaceElement faceElement;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.size() <= 0 || (t16 = list.get(0)) == null || (faceElement = t16.faceElement) == null) {
            return 0;
        }
        return faceElement.faceIndex;
    }

    public static final boolean c(@NotNull MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (msgElement.elementType == 3) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull List<MsgElement> msgElementLi) {
        Intrinsics.checkNotNullParameter(msgElementLi, "msgElementLi");
        if (e(msgElementLi) && ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).isSupportLottie(b(msgElementLi))) {
            return true;
        }
        return false;
    }

    public static final <T extends MsgElement> boolean e(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        boolean z16 = false;
        if (list.size() == 1 && list.get(0).faceElement != null) {
            z16 = true;
        }
        QLog.i("MsgElementEx", 4, "ElementSize=" + list.size() + " isOnlyOneFaceElement=" + z16);
        return z16;
    }

    public static final boolean f(@NotNull MsgElement msgElement) {
        String str;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (!c(msgElement)) {
            return false;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            str = fileElement.fileName;
        } else {
            str = null;
        }
        if (str == null || vp0.b.d(str) != 0) {
            return false;
        }
        return true;
    }

    public static final boolean g(@Nullable com.tencent.aio.data.msglist.a aVar) {
        List filterNotNull;
        if (!(aVar instanceof GuildMsgItem)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = ((GuildMsgItem) aVar).getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        boolean d16 = d(arrayList);
        boolean isAniStickerRandom = ((IRandomLottieProxyApi) QRoute.api(IRandomLottieProxyApi.class)).isAniStickerRandom(b(arrayList));
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("MsgElementEx", 1, "isLottie=" + d16 + " isRandomLottie=" + isAniStickerRandom);
        }
        if (!d16 || !isAniStickerRandom) {
            return false;
        }
        return true;
    }

    public static final boolean h(@NotNull MsgElement msgElement) {
        String str;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        if (!c(msgElement)) {
            return false;
        }
        FileElement fileElement = msgElement.fileElement;
        if (fileElement != null) {
            str = fileElement.fileName;
        } else {
            str = null;
        }
        if (str == null || vp0.b.d(str) != 2) {
            return false;
        }
        return true;
    }
}
