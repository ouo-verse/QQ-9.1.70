package com.tencent.qqnt.aio.api.impl;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IMsgForwardNtUtil;
import com.tencent.qqnt.forwardaio.ForwardMiniAIOActivity;
import com.tencent.qqnt.forwardaio.ForwardMsgStore;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import defpackage.MsgListUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016JN\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016JN\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J0\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/MsgForwardNtUtilImpl;", "Lcom/tencent/qqnt/aio/api/IMsgForwardNtUtil;", "()V", "getForwardPreviewView", "Landroid/view/View;", "context", "Landroid/content/Context;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "previewMsg", "", "chatType", "", "uid", "", "nick", "aioMsgItems", "", "isMultiForwardMsg", "", "forwardType", "needClearBg", "previewMsgWithMsgRecord", "aioMsgRecords", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "startForwardMiniAIO", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class MsgForwardNtUtilImpl implements IMsgForwardNtUtil {
    static IPatchRedirector $redirector_;

    public MsgForwardNtUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IMsgForwardNtUtil
    @Nullable
    public View getForwardPreviewView(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        return null;
    }

    @Override // com.tencent.qqnt.aio.api.IMsgForwardNtUtil
    public void previewMsg(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @NotNull List<? extends AIOMsgItem> aioMsgItems, boolean isMultiForwardMsg, int forwardType, boolean needClearBg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(chatType), uid, nick, aioMsgItems, Boolean.valueOf(isMultiForwardMsg), Integer.valueOf(forwardType), Boolean.valueOf(needClearBg));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(aioMsgItems, "aioMsgItems");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = aioMsgItems.iterator();
        while (it.hasNext()) {
            AIOMsgItem cloneNewInstance = ((AIOMsgItem) it.next()).cloneNewInstance();
            cloneNewInstance.k1(forwardType);
            arrayList.add(cloneNewInstance);
        }
        ForwardMsgStore.INSTANCE.a().c(arrayList);
        Intent intent = new Intent(context, (Class<?>) ForwardMiniAIOActivity.class);
        intent.putExtra("key_chat_type", chatType);
        intent.putExtra("key_peerId", uid);
        intent.putExtra("key_chat_name", nick);
        intent.putExtra("key_is_forward_aio", true);
        intent.putExtra("key_forward_aio_show_custom_msg", true);
        intent.putExtra("key_forward_aio_is_multi_msg", isMultiForwardMsg);
        intent.putExtra("key_forward_aio_forward_type", forwardType);
        intent.putExtra("key_forward_activity_bg", needClearBg);
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgForwardNtUtil
    public void previewMsgWithMsgRecord(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, @NotNull List<MsgRecord> aioMsgRecords, boolean isMultiForwardMsg, int forwardType, boolean needClearBg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, Integer.valueOf(chatType), uid, nick, aioMsgRecords, Boolean.valueOf(isMultiForwardMsg), Integer.valueOf(forwardType), Boolean.valueOf(needClearBg));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(aioMsgRecords, "aioMsgRecords");
        ForwardMsgStore a16 = ForwardMsgStore.INSTANCE.a();
        ArrayList arrayList = new ArrayList();
        List q16 = MsgListUtil.q(MsgListUtil.f24918a, aioMsgRecords, context, null, 4, null);
        Iterator it = q16.iterator();
        while (it.hasNext()) {
            ((AIOMsgItem) it.next()).k1(forwardType);
        }
        arrayList.addAll(q16);
        a16.c(arrayList);
        Intent intent = new Intent(context, (Class<?>) ForwardMiniAIOActivity.class);
        intent.putExtra("key_chat_type", chatType);
        intent.putExtra("key_peerId", uid);
        intent.putExtra("key_chat_name", nick);
        intent.putExtra("key_is_forward_aio", true);
        intent.putExtra("key_forward_aio_show_custom_msg", true);
        intent.putExtra("key_forward_aio_is_multi_msg", isMultiForwardMsg);
        intent.putExtra("key_forward_activity_bg", needClearBg);
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgForwardNtUtil
    public void startForwardMiniAIO(@NotNull Context context, int chatType, @NotNull String uid, @NotNull String nick, boolean needClearBg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(chatType), uid, nick, Boolean.valueOf(needClearBg));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intent intent = new Intent(context, (Class<?>) ForwardMiniAIOActivity.class);
        intent.putExtra("key_chat_type", chatType);
        intent.putExtra("key_peerId", uid);
        intent.putExtra("key_chat_name", nick);
        intent.putExtra("key_is_forward_aio", true);
        intent.putExtra("key_forward_activity_bg", needClearBg);
        context.startActivity(intent);
    }
}
