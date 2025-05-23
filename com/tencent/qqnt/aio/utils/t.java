package com.tencent.qqnt.aio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.multiforward.MultiForwardEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMultiforwardDetailApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ.\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bJ>\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/utils/t;", "", "Landroid/content/Context;", "context", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "title", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "c", "sourceMsgRecord", "rootMsgRecord", "b", "peerUid", "", "chatType", "", "msgId", "Landroid/content/Intent;", "lastIntent", "d", "a", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f352318a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f352318a = new t();
        }
    }

    t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a(@NotNull MsgRecord msgRecord) {
        Object first;
        Object first2;
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (!al.c(msgRecord) || msgRecord.elements.isEmpty()) {
            return "";
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        if (((MsgElement) first).arkElement == null) {
            return "";
        }
        ArrayList<MsgElement> arrayList2 = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
        try {
            JSONObject optJSONObject = new JSONObject(((MsgElement) first2).arkElement.bytesData).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            String str = null;
            if (optJSONObject != null) {
                jSONObject = optJSONObject.optJSONObject("detail");
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                str = jSONObject.optString("source", "");
            }
            if (str == null) {
                return "";
            }
            return str;
        } catch (JSONException unused) {
            return "";
        }
    }

    public final void b(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String title, @NotNull MsgRecord sourceMsgRecord, @NotNull MsgRecord rootMsgRecord) {
        MsgRecordParams msgRecordParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, aioContext, title, sourceMsgRecord, rootMsgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(sourceMsgRecord, "sourceMsgRecord");
        Intrinsics.checkNotNullParameter(rootMsgRecord, "rootMsgRecord");
        Intent intent = new Intent(context, ((IMultiforwardDetailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiforwardDetailApi.class)).getDetailActivity());
        long j3 = aioContext.g().l().getLong("key_multiforward_root_msgid");
        if (j3 != 0) {
            intent.putExtra("key_multiforward_root_msgid", j3);
        } else {
            intent.putExtra("key_multiforward_root_msgid", rootMsgRecord.msgId);
        }
        String j16 = aioContext.g().r().c().j();
        int e16 = aioContext.g().r().c().e();
        intent.putExtra("key_multiforward_parent_msgid", sourceMsgRecord.msgId);
        intent.putExtra("key_peerId", j16);
        intent.putExtra("key_chat_type", e16);
        intent.putExtra("key_chat_name", title);
        com.tencent.qqnt.aio.utils.multiForward.a.f352306a.a().add(sourceMsgRecord);
        MsgRecordParams msgRecordParams2 = (MsgRecordParams) aioContext.g().l().getParcelable("key_multiforward_root_msg_record");
        if (msgRecordParams2 == null) {
            long j17 = rootMsgRecord.msgId;
            int i3 = rootMsgRecord.chatType;
            int i16 = rootMsgRecord.sendType;
            String str = rootMsgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "rootMsgRecord.peerUid");
            msgRecordParams2 = new MsgRecordParams(j17, i3, i16, str, rootMsgRecord.peerUin, null, 32, null);
        }
        intent.putExtra("key_multiforward_root_msg_record", msgRecordParams2);
        MsgRecordParams msgRecordParams3 = (MsgRecordParams) aioContext.g().l().getParcelable("key_multiforward_parent_msg_record");
        if (msgRecordParams3 == null) {
            long j18 = sourceMsgRecord.msgId;
            int i17 = sourceMsgRecord.chatType;
            int i18 = sourceMsgRecord.sendType;
            String str2 = sourceMsgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "sourceMsgRecord.peerUid");
            msgRecordParams = new MsgRecordParams(j18, i17, i18, str2, sourceMsgRecord.peerUin, msgRecordParams2);
        } else {
            long j19 = rootMsgRecord.msgId;
            int i19 = rootMsgRecord.chatType;
            int i26 = rootMsgRecord.sendType;
            String str3 = rootMsgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str3, "rootMsgRecord.peerUid");
            MsgRecordParams msgRecordParams4 = new MsgRecordParams(j19, i19, i26, str3, rootMsgRecord.peerUin, msgRecordParams3);
            long j26 = sourceMsgRecord.msgId;
            int i27 = sourceMsgRecord.chatType;
            int i28 = sourceMsgRecord.sendType;
            String str4 = sourceMsgRecord.peerUid;
            Intrinsics.checkNotNullExpressionValue(str4, "sourceMsgRecord.peerUid");
            msgRecordParams = new MsgRecordParams(j26, i27, i28, str4, sourceMsgRecord.peerUin, msgRecordParams4);
        }
        intent.putExtra("key_multiforward_parent_msg_record", msgRecordParams);
        context.startActivity(intent);
        aioContext.e().h(MultiForwardEvent.JumpToChildPage.f251491d);
    }

    public final void c(@NotNull Context context, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String title, @NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, aioContext, title, msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intent intent = new Intent(context, ((IMultiforwardDetailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiforwardDetailApi.class)).getDetailActivity());
        long j3 = aioContext.g().l().getLong("key_multiforward_root_msgid");
        if (j3 != 0) {
            intent.putExtra("key_multiforward_root_msgid", j3);
        }
        String j16 = aioContext.g().r().c().j();
        int e16 = aioContext.g().r().c().e();
        intent.putExtra("key_multiforward_parent_msgid", msgRecord.msgId);
        intent.putExtra("key_peerId", j16);
        intent.putExtra("key_chat_type", e16);
        intent.putExtra("key_chat_name", title);
        MsgRecordParams msgRecordParams = (MsgRecordParams) aioContext.g().l().getParcelable("key_multiforward_root_msg_record");
        if (msgRecordParams != null) {
            intent.putExtra("key_multiforward_root_msg_record", msgRecordParams);
        }
        MsgRecordParams msgRecordParams2 = (MsgRecordParams) aioContext.g().l().getParcelable("key_multiforward_parent_msg_record");
        long j17 = msgRecord.msgId;
        int i3 = msgRecord.chatType;
        int i16 = msgRecord.sendType;
        String str = msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        intent.putExtra("key_multiforward_parent_msg_record", new MsgRecordParams(j17, i3, i16, str, msgRecord.peerUin, msgRecordParams2));
        context.startActivity(intent);
        aioContext.e().h(MultiForwardEvent.JumpToChildPage.f251491d);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(@NotNull Context context, @NotNull String peerUid, int chatType, @NotNull String title, long msgId, @NotNull MsgRecord msgRecord, @NotNull Intent lastIntent) {
        int i3;
        String str;
        FragmentActivity fragmentActivity;
        QBaseActivity qBaseActivity;
        AIOContact a16;
        long j3;
        MsgRecordParams msgRecordParams;
        MsgRecordParams msgRecordParams2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, peerUid, Integer.valueOf(chatType), title, Long.valueOf(msgId), msgRecord, lastIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(lastIntent, "lastIntent");
        if (chatType == 0) {
            try {
                Activity resumeActivity = MobileQQ.sMobileQQ.getResumeActivity();
                QLog.i("MultiForwardDetailUtil", 1, "[checkResumedActivity]: activity is " + resumeActivity);
                if (resumeActivity instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) resumeActivity;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    QLog.i("MultiForwardDetailUtil", 1, "[checkResumedActivity]: contact is " + a.f352276a.a(fragmentActivity));
                }
                qBaseActivity = QBaseActivity.sTopActivity;
                if (!(qBaseActivity instanceof FragmentActivity)) {
                    qBaseActivity = null;
                }
            } catch (Exception e16) {
                e = e16;
                i3 = chatType;
            }
            if (qBaseActivity != null && (a16 = a.f352276a.a(qBaseActivity)) != null) {
                i3 = a16.e();
                try {
                    str = a16.j();
                    try {
                        QLog.i("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: getContact from topActivity " + a16);
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: ", e);
                        Intent intent = new Intent(context, ((IMultiforwardDetailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiforwardDetailApi.class)).getDetailActivity());
                        if (!lastIntent.hasExtra("key_multiforward_root_msgid")) {
                        }
                        intent.putExtra("key_multiforward_root_msgid", j3);
                        intent.putExtra("key_multiforward_parent_msgid", msgId);
                        intent.putExtra("key_peerId", str);
                        intent.putExtra("key_chat_type", i3);
                        intent.putExtra("key_chat_name", title);
                        QLog.i("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: peerId=" + ((Object) str) + ", chatType=" + i3 + ", rootMsgId=" + j3 + ", parentMsgId=" + msgId);
                        com.tencent.qqnt.aio.utils.multiForward.a.f352306a.a().add(msgRecord);
                        Activity activity = (Activity) context;
                        msgRecordParams = (MsgRecordParams) activity.getIntent().getParcelableExtra("key_multiforward_root_msg_record");
                        if (msgRecordParams != null) {
                        }
                        if (msgRecordParams2 != null) {
                        }
                        intent.putExtra("key_multiforward_parent_msg_record", new MsgRecordParams(msgId, chatType, 0, peerUid, 0L, (MsgRecordParams) activity.getIntent().getParcelableExtra("key_multiforward_parent_msg_record")));
                        context.startActivity(intent);
                        c.f352293a.b((FragmentActivity) context, peerUid, MultiForwardEvent.JumpToChildPage.f251491d);
                    }
                } catch (Exception e18) {
                    e = e18;
                    str = peerUid;
                    QLog.e("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: ", e);
                    Intent intent2 = new Intent(context, ((IMultiforwardDetailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiforwardDetailApi.class)).getDetailActivity());
                    if (!lastIntent.hasExtra("key_multiforward_root_msgid")) {
                    }
                    intent2.putExtra("key_multiforward_root_msgid", j3);
                    intent2.putExtra("key_multiforward_parent_msgid", msgId);
                    intent2.putExtra("key_peerId", str);
                    intent2.putExtra("key_chat_type", i3);
                    intent2.putExtra("key_chat_name", title);
                    QLog.i("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: peerId=" + ((Object) str) + ", chatType=" + i3 + ", rootMsgId=" + j3 + ", parentMsgId=" + msgId);
                    com.tencent.qqnt.aio.utils.multiForward.a.f352306a.a().add(msgRecord);
                    Activity activity2 = (Activity) context;
                    msgRecordParams = (MsgRecordParams) activity2.getIntent().getParcelableExtra("key_multiforward_root_msg_record");
                    if (msgRecordParams != null) {
                    }
                    if (msgRecordParams2 != null) {
                    }
                    intent2.putExtra("key_multiforward_parent_msg_record", new MsgRecordParams(msgId, chatType, 0, peerUid, 0L, (MsgRecordParams) activity2.getIntent().getParcelableExtra("key_multiforward_parent_msg_record")));
                    context.startActivity(intent2);
                    c.f352293a.b((FragmentActivity) context, peerUid, MultiForwardEvent.JumpToChildPage.f251491d);
                }
                Intent intent22 = new Intent(context, ((IMultiforwardDetailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiforwardDetailApi.class)).getDetailActivity());
                if (!lastIntent.hasExtra("key_multiforward_root_msgid")) {
                    j3 = lastIntent.getLongExtra("key_multiforward_root_msgid", 0L);
                } else {
                    Activity activity3 = (Activity) context;
                    if (activity3.getIntent().hasExtra("key_multiforward_root_msgid")) {
                        j3 = activity3.getIntent().getLongExtra("key_multiforward_root_msgid", 0L);
                    } else {
                        j3 = msgId;
                    }
                }
                intent22.putExtra("key_multiforward_root_msgid", j3);
                intent22.putExtra("key_multiforward_parent_msgid", msgId);
                intent22.putExtra("key_peerId", str);
                intent22.putExtra("key_chat_type", i3);
                intent22.putExtra("key_chat_name", title);
                QLog.i("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: peerId=" + ((Object) str) + ", chatType=" + i3 + ", rootMsgId=" + j3 + ", parentMsgId=" + msgId);
                com.tencent.qqnt.aio.utils.multiForward.a.f352306a.a().add(msgRecord);
                Activity activity22 = (Activity) context;
                msgRecordParams = (MsgRecordParams) activity22.getIntent().getParcelableExtra("key_multiforward_root_msg_record");
                if (msgRecordParams != null) {
                    msgRecordParams2 = null;
                } else {
                    msgRecordParams2 = msgRecordParams;
                }
                if (msgRecordParams2 != null) {
                    intent22.putExtra("key_multiforward_root_msg_record", msgRecordParams2);
                }
                intent22.putExtra("key_multiforward_parent_msg_record", new MsgRecordParams(msgId, chatType, 0, peerUid, 0L, (MsgRecordParams) activity22.getIntent().getParcelableExtra("key_multiforward_parent_msg_record")));
                context.startActivity(intent22);
                c.f352293a.b((FragmentActivity) context, peerUid, MultiForwardEvent.JumpToChildPage.f251491d);
            }
        }
        i3 = chatType;
        str = peerUid;
        Intent intent222 = new Intent(context, ((IMultiforwardDetailApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMultiforwardDetailApi.class)).getDetailActivity());
        if (!lastIntent.hasExtra("key_multiforward_root_msgid")) {
        }
        intent222.putExtra("key_multiforward_root_msgid", j3);
        intent222.putExtra("key_multiforward_parent_msgid", msgId);
        intent222.putExtra("key_peerId", str);
        intent222.putExtra("key_chat_type", i3);
        intent222.putExtra("key_chat_name", title);
        QLog.i("MultiForwardDetailUtil", 1, "[navigateToMultiforwardDetail]: peerId=" + ((Object) str) + ", chatType=" + i3 + ", rootMsgId=" + j3 + ", parentMsgId=" + msgId);
        com.tencent.qqnt.aio.utils.multiForward.a.f352306a.a().add(msgRecord);
        Activity activity222 = (Activity) context;
        msgRecordParams = (MsgRecordParams) activity222.getIntent().getParcelableExtra("key_multiforward_root_msg_record");
        if (msgRecordParams != null) {
        }
        if (msgRecordParams2 != null) {
        }
        intent222.putExtra("key_multiforward_parent_msg_record", new MsgRecordParams(msgId, chatType, 0, peerUid, 0L, (MsgRecordParams) activity222.getIntent().getParcelableExtra("key_multiforward_parent_msg_record")));
        context.startActivity(intent222);
        c.f352293a.b((FragmentActivity) context, peerUid, MultiForwardEvent.JumpToChildPage.f251491d);
    }
}
