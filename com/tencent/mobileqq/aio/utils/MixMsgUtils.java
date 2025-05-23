package com.tencent.mobileqq.aio.utils;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\u000b\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/MixMsgUtils;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "parseLottieAsYellowFace", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b", "Lkotlin/Lazy;", "a", "()Z", "aioMixMsgSubTypeUseHashMap", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MixMsgUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final MixMsgUtils f194090a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Lazy aioMixMsgSubTypeUseHashMap;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f194090a = new MixMsgUtils();
        lazy = LazyKt__LazyJVMKt.lazy(MixMsgUtils$aioMixMsgSubTypeUseHashMap$2.INSTANCE);
        aioMixMsgSubTypeUseHashMap = lazy;
    }

    MixMsgUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ AIOMsgItem c(MixMsgUtils mixMsgUtils, MsgRecord msgRecord, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return mixMsgUtils.b(msgRecord, z16);
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) aioMixMsgSubTypeUseHashMap.getValue()).booleanValue();
    }

    @NotNull
    public final AIOMsgItem b(@NotNull MsgRecord msgRecord, boolean parseLottieAsYellowFace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 3, this, msgRecord, Boolean.valueOf(parseLottieAsYellowFace));
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        int i3 = msgRecord.msgType;
        if (i3 != 2) {
            z16 = false;
        }
        if (z16) {
            if (d.G(msgRecord)) {
                return new MarkdownMsgItem(msgRecord);
            }
            if (!parseLottieAsYellowFace && d.r(msgRecord)) {
                if (d.p(msgRecord)) {
                    return new com.tencent.mobileqq.aio.msg.e(msgRecord);
                }
                return new AniStickerMsgItem(msgRecord);
            }
            if (MsgExtKt.M(msgRecord)) {
                return new PicMsgItem(msgRecord);
            }
            if (!d.a0(msgRecord) && !MsgExtKt.M(msgRecord)) {
                return new com.tencent.mobileqq.aio.msg.o(msgRecord);
            }
            if (d.X(msgRecord)) {
                return new com.tencent.mobileqq.aio.msg.ad(msgRecord);
            }
            return new com.tencent.mobileqq.aio.msg.ae(msgRecord);
        }
        throw new IllegalStateException(("can not deal " + i3 + " !!").toString());
    }
}
