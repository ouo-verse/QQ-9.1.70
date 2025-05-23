package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.OnlineFileMsgItem;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msg.PositionMsgItem;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.ad;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msg.ai;
import com.tencent.mobileqq.aio.msg.n;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msg.p;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b;
import com.tencent.mobileqq.aio.utils.d;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u0016\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u001a\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0018\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\t\u001a\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018\u001a\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018\u001a\u0018\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001\u001a\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u001a\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020 H\u0002\"\"\u0010'\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "Lcom/tencent/qqnt/aio/emoreply/h;", "emoReplyAnimationInfo", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/b;", "l", "", "serverId", "emojiType", "a", "", "count", "e", "localId", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/content/Context;", "context", "toast", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", h.F, "g", "type", "f", "i", "", "j", "J", "c", "()J", "k", "(J)V", "lastClickTime", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f191300a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int a(@NotNull String serverId, int i3) {
        boolean z16;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(serverId, "serverId");
        if (serverId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || intOrNull == null) {
            return -1;
        }
        int intValue = intOrNull.intValue();
        if (i3 != 1) {
            if (i3 != 2) {
                return -1;
            }
            return QQSysAndEmojiResMgr.getInstance().getResImpl(2).getLocalId(intValue);
        }
        return QQSysFaceUtil.convertToLocal(intValue);
    }

    @Nullable
    public static final Drawable b(int i3, int i16) {
        if (i3 < 0) {
            QLog.e("AIOEmoReplyUtils", 1, "getEmojiDrawable localId=" + i3 + ", emojiType: " + i16 + ", invalid drawable");
            return null;
        }
        return ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).getEmojiDrawable(i3, i16, ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).isDynamicResReady(i3, i16));
    }

    public static final long c() {
        return f191300a;
    }

    public static final int d(@NotNull MsgEmojiLikes msgEmojiLikes) {
        Intrinsics.checkNotNullParameter(msgEmojiLikes, "<this>");
        String emojiId = msgEmojiLikes.emojiId;
        Intrinsics.checkNotNullExpressionValue(emojiId, "emojiId");
        return a(emojiId, (int) msgEmojiLikes.emojiType);
    }

    @NotNull
    public static final String e(long j3) {
        if (j3 < 0) {
            return "0";
        }
        if (j3 < 100) {
            return String.valueOf(j3);
        }
        return "99+";
    }

    @Nullable
    public static final String f(int i3, int i16) {
        String faceDescription;
        boolean startsWith$default;
        if (i16 != 1) {
            if (i16 != 2) {
                faceDescription = null;
            } else {
                faceDescription = QQEmojiUtil.getEmojiDescription(i3);
            }
        } else {
            faceDescription = QQSysFaceUtil.getFaceDescription(i3);
        }
        if (faceDescription != null && faceDescription.length() > 1) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(faceDescription, "/", false, 2, null);
            if (startsWith$default) {
                faceDescription = faceDescription.substring(1);
                Intrinsics.checkNotNullExpressionValue(faceDescription, "this as java.lang.String).substring(startIndex)");
            }
        }
        if (TextUtils.isEmpty(faceDescription)) {
            return HardCodeUtil.qqStr(R.string.zug);
        }
        return faceDescription;
    }

    public static final boolean g(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof AniStickerMsgItem) {
            return true;
        }
        if (msgItem instanceof ArkMsgItem) {
            return ((ArkMsgItem) msgItem).r2();
        }
        if (msgItem instanceof TemplateMsgItem) {
            return ((TemplateMsgItem) msgItem).o2();
        }
        if ((msgItem instanceof PositionMsgItem) || (msgItem instanceof FileMsgItem)) {
            return true;
        }
        if (msgItem instanceof MarkdownMsgItem) {
            return ((MarkdownMsgItem) msgItem).J2();
        }
        if ((msgItem instanceof n) || (msgItem instanceof p) || (msgItem instanceof OnlineFileMsgItem) || (msgItem instanceof PicMsgItem) || (msgItem instanceof PttMsgItem) || (msgItem instanceof ShortVideoMsgItem) || (msgItem instanceof u) || (msgItem instanceof ad) || (msgItem instanceof ae) || (msgItem instanceof ai) || (msgItem instanceof o)) {
            return true;
        }
        return i(msgItem);
    }

    public static final boolean h(@NotNull AIOMsgItem msgItem) {
        long j3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2) {
            j("chatType is not group");
            return false;
        }
        if (!((IAIOEmoReplyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoReplyApi.class)).isEmoReplyOpen(msgItem.getMsgRecord().peerUin)) {
            j("emoReply not Open");
            return false;
        }
        if (msgItem.getMsgRecord().sendStatus != 2) {
            j("sendStatus not success");
            return false;
        }
        if (d.b0(msgItem)) {
            j("isTogetherForwardDetail");
            return false;
        }
        Long groupMsgStorageTime = ((IMsgService) QRoute.api(IMsgService.class)).getGroupMsgStorageTime();
        if (groupMsgStorageTime != null) {
            j3 = groupMsgStorageTime.longValue();
        } else {
            j3 = 8640000;
        }
        if ((NetConnInfoCenter.getServerTimeMillis() / 1000) - j3 >= msgItem.getMsgRecord().msgTime) {
            j("over groupMsgStorageTime");
            return false;
        }
        return true;
    }

    private static final boolean i(AIOMsgItem aIOMsgItem) {
        if (MsgExtKt.O(aIOMsgItem.getMsgRecord()) || MsgExtKt.b0(aIOMsgItem.getMsgRecord()) || aIOMsgItem.getMsgRecord().msgType == 27) {
            return true;
        }
        return false;
    }

    private static final void j(Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmoReplyUtils", 2, obj.toString());
        }
    }

    public static final void k(long j3) {
        f191300a = j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        if (r8 == true) goto L12;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final b l(@NotNull MsgEmojiLikes msgEmojiLikes, @NotNull MsgRecord msg2, @Nullable com.tencent.qqnt.aio.emoreply.h hVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgEmojiLikes, "<this>");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        b bVar = new b(msgEmojiLikes.isClicked, (int) msgEmojiLikes.emojiType, msgEmojiLikes.likesCnt, d(msgEmojiLikes), msg2);
        if (hVar != null && hVar.e()) {
            MsgEmojiLikes d16 = hVar.d();
            if (d16 != null) {
                boolean l3 = com.tencent.qqnt.aio.msg.d.l(d16, msgEmojiLikes);
                z16 = true;
            }
            z16 = false;
            if (z16) {
                bVar.l(false);
            }
        }
        return bVar;
    }

    public static final void m(@Nullable Context context, @NotNull String toast) {
        Unit unit;
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (context != null) {
            QQToast.makeText(context, 1, toast, 0).show();
            HashMap hashMap = new HashMap();
            hashMap.put("text_content", toast);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_emoji_response_toast", hashMap);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            j("context is null");
        }
    }
}
