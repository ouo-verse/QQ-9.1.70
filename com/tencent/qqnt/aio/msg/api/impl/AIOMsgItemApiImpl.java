package com.tencent.qqnt.aio.msg.api.impl;

import a81.e;
import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.FoldMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.mobileqq.aio.msglist.holder.component.text.c;
import com.tencent.mobileqq.aio.msglist.holder.component.video.b;
import com.tencent.mobileqq.aio.msglist.holder.component.video.z;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.aio.utils.av;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.aio.utils.n;
import com.tencent.mobileqq.aio.utils.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.data.a;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J0\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0016\u0010\u001f\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0013H\u0016J \u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001d0(j\b\u0012\u0004\u0012\u00020\u001d`)2\u0006\u0010'\u001a\u00020\u001aH\u0016J&\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u001d0(j\b\u0012\u0004\u0012\u00020\u001d`)2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/aio/msg/api/impl/AIOMsgItemApiImpl;", "Lcom/tencent/qqnt/aio/msg/api/IAIOMsgItemApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "transformMsgRecordWithType", "msgItem", "", "getTextFromMsgItem", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTextMapFromMsgItem", "Lcom/tencent/mobileqq/aio/msg/template/d;", "parseTemplateMsgInfo", "Lcom/tencent/qqnt/msg/data/a;", "parseArkModel", "", "arkAppContainer", "", "isNtArkAppContainer", "Landroid/content/Context;", "context", "getPreviewText", "getTranslateText", "getLocalIdOfAniStickerMsg", "", "getResultIdOfAniStickerMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "buildContent", "getLocalPath", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/z;", "sendInfo", "", "generateVideoExtBuf", "hasRead", "generateFlashPicExtBuf", "commentStr", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getForwardCommentElement", "transformAioMsgToElements", "", "updateSkinBubbleInfoForPreview", "Lkotlin/Pair;", "getPaddingLeft", "getPaddingRight", "getPaddingTop", "getPaddingBottom", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMsgItemApiImpl implements IAIOMsgItemApi {
    static IPatchRedirector $redirector_;

    public AIOMsgItemApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public CharSequence buildContent(@NotNull List<MsgElement> msgElements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CharSequence) iPatchRedirector.redirect((short) 12, (Object) this, (Object) msgElements);
        }
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        return c.f191997a.a(msgElements);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public byte[] generateFlashPicExtBuf(boolean hasRead) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this, hasRead);
        }
        com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c cVar = new com.tencent.mobileqq.aio.msglist.holder.component.flashpic.c();
        cVar.b(hasRead);
        return cVar.c();
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public byte[] generateVideoExtBuf(@NotNull z sendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this, (Object) sendInfo);
        }
        Intrinsics.checkNotNullParameter(sendInfo, "sendInfo");
        b bVar = new b();
        z c16 = bVar.c();
        c16.j(sendInfo.b());
        c16.i(sendInfo.a());
        c16.m(sendInfo.e());
        c16.k(sendInfo.c());
        c16.o(sendInfo.g());
        c16.l(sendInfo.d());
        c16.n(sendInfo.f());
        return bVar.d();
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public ArrayList<MsgElement> getForwardCommentElement(@NotNull String commentStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ArrayList) iPatchRedirector.redirect((short) 16, (Object) this, (Object) commentStr);
        }
        Intrinsics.checkNotNullParameter(commentStr, "commentStr");
        return AIOObjectTransform.m(AIOObjectTransform.f194080a, y.d(y.f194180a, commentStr, 0, 0L, 0L, null, 30, null), 0, 2, null);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    public int getLocalIdOfAniStickerMsg(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) msgItem)).intValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof AniStickerMsgItem) {
            return ((AniStickerMsgItem) msgItem).n2();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public String getLocalPath(@NotNull AIOMsgItem msgItem) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof PicMsgItem) {
            String a16 = aj.a(((PicMsgItem) msgItem).p2());
            if (a16 == null) {
                return "";
            }
            return a16;
        }
        if (msgItem instanceof ShortVideoMsgItem) {
            return ((ShortVideoMsgItem) msgItem).I2();
        }
        if (!(msgItem instanceof FileMsgItem)) {
            return "";
        }
        FileElement n26 = ((FileMsgItem) msgItem).n2();
        if (n26 != null) {
            str = n26.filePath;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public Pair<Boolean, Integer> getPaddingBottom(@NotNull AIOMsgItem msgItem) {
        int dimension;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Pair) iPatchRedirector.redirect((short) 22, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ArkMsgItem) {
            ArkMsgItem arkMsgItem = (ArkMsgItem) msgItem;
            if (e.INSTANCE.m(arkMsgItem.t2(), arkMsgItem)) {
                dimension = l.b(10);
            } else {
                dimension = (int) MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.f158192a0);
            }
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(dimension));
        }
        if (msgItem instanceof ShortVideoMsgItem) {
            return TuplesKt.to(Boolean.TRUE, 0);
        }
        if (msgItem instanceof FileMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(7)));
        }
        if (msgItem instanceof ai) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(5)));
        }
        return TuplesKt.to(Boolean.FALSE, 0);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public Pair<Boolean, Integer> getPaddingLeft(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Pair) iPatchRedirector.redirect((short) 19, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ArkMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf((int) MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.f158247b9)));
        }
        if (msgItem instanceof ShortVideoMsgItem) {
            return TuplesKt.to(Boolean.TRUE, 0);
        }
        if (msgItem instanceof FileMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(7)));
        }
        if (msgItem instanceof ai) {
            return TuplesKt.to(Boolean.TRUE, 0);
        }
        return TuplesKt.to(Boolean.FALSE, 0);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public Pair<Boolean, Integer> getPaddingRight(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Pair) iPatchRedirector.redirect((short) 20, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ArkMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf((int) MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.b_)));
        }
        if (msgItem instanceof ShortVideoMsgItem) {
            return TuplesKt.to(Boolean.TRUE, 0);
        }
        if (msgItem instanceof FileMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(7)));
        }
        if (msgItem instanceof ai) {
            return TuplesKt.to(Boolean.TRUE, 0);
        }
        return TuplesKt.to(Boolean.FALSE, 0);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public Pair<Boolean, Integer> getPaddingTop(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Pair) iPatchRedirector.redirect((short) 21, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ArkMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(10)));
        }
        if (msgItem instanceof ShortVideoMsgItem) {
            return TuplesKt.to(Boolean.TRUE, 0);
        }
        if (msgItem instanceof FileMsgItem) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(7)));
        }
        if (msgItem instanceof ai) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(l.b(10)));
        }
        return TuplesKt.to(Boolean.FALSE, 0);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @Nullable
    public CharSequence getPreviewText(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof FoldMsgItem) {
            return ((FoldMsgItem) msgItem).l2(context);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public String getResultIdOfAniStickerMsg(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof AniStickerMsgItem) {
            return ((AniStickerMsgItem) msgItem).q2();
        }
        return "";
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @Nullable
    public CharSequence getTextFromMsgItem(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ae) {
            return ((ae) msgItem).u2();
        }
        if (msgItem instanceof AniStickerMsgItem) {
            return ((AniStickerMsgItem) msgItem).m2();
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @Nullable
    public HashMap<Integer, CharSequence> getTextMapFromMsgItem(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof o) {
            return ((o) msgItem).p2();
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @Nullable
    public CharSequence getTranslateText(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CharSequence) iPatchRedirector.redirect((short) 9, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return av.f194117a.c(msgItem);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    public boolean isNtArkAppContainer(@NotNull Object arkAppContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, arkAppContainer)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(arkAppContainer, "arkAppContainer");
        return arkAppContainer instanceof ArkAppContainer;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @Nullable
    public a parseArkModel(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof ArkMsgItem) {
            return ((ArkMsgItem) msgItem).t2();
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @Nullable
    public d parseTemplateMsgInfo(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof TemplateMsgItem) {
            return ((TemplateMsgItem) msgItem).n2();
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public ArrayList<MsgElement> transformAioMsgToElements(@NotNull List<Object> msgElements) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this, (Object) msgElements);
        }
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        return AIOObjectTransform.m(AIOObjectTransform.f194080a, msgElements, 0, 2, null);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    @NotNull
    public AIOMsgItem transformMsgRecordWithType(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        return MsgListUtil.s(MsgListUtil.f24918a, msgRecord, false, null, null, 14, null);
    }

    @Override // com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi
    public void updateSkinBubbleInfoForPreview(@NotNull AIOMsgItem msgItem) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String b16 = m.f194167a.b(msgItem);
        if (b16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !b16.equals("0")) {
            msgItem.Y1(com.tencent.mobileqq.aio.msg.a.a(msgItem));
        } else {
            msgItem.Y1(n.f194168a.f(BaseApplication.context, msgItem));
        }
    }
}
