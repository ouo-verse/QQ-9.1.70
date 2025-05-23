package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqnt.aio.adapter.api.IMsgForwardApi;
import com.tencent.qqnt.forwardaio.ForwardMsgStore;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MsgForwardApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMsgForwardApi;", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOContact;", "contact", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/mvi/base/route/j;", "messenger", "", "forwardMsgSelect", "", "text", "forwardText", "Lyw3/a;", "getMemberViewController", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MsgForwardApiNtImpl implements IMsgForwardApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/MsgForwardApiNtImpl$a", "Lyw3/a;", "Landroid/content/Context;", "context", "", "uid", "", "chatType", "", "scale", "Landroid/view/View;", "a", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements yw3.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // yw3.a
        @NotNull
        public View a(@NotNull Context context, @NotNull String uid, int chatType, float scale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, this, context, uid, Integer.valueOf(chatType), Float.valueOf(scale));
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uid, "uid");
            TextView textView = new TextView(context);
            textView.setText("member list show. need to implement");
            return textView;
        }

        @Override // yw3.a
        public void onDestroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public MsgForwardApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgForwardApi
    public void forwardMsgSelect(@NotNull Context context, @NotNull AIOContact contact, @NotNull AIOMsgItem msgItem, @NotNull com.tencent.mvi.base.route.j messenger) {
        List<? extends AIOMsgItem> listOf;
        long[] longArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, contact, msgItem, messenger);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        ArrayList arrayList = new ArrayList();
        for (MsgRecordParams h06 = msgItem.h0(); h06 != null; h06 = h06.c()) {
            arrayList.add(Long.valueOf(h06.b()));
        }
        CollectionsKt___CollectionsJvmKt.reverse(arrayList);
        ForwardMsgStore a16 = ForwardMsgStore.INSTANCE.a();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msgItem);
        a16.c(listOf);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/base/main/forward");
        activityURIRequest.extra().putLong("Key_Msg_Id", msgItem.getMsgId());
        Bundle extra = activityURIRequest.extra();
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        extra.putLongArray("Key_Root_Msg_Id", longArray);
        activityURIRequest.extra().putString("KEY_SRC_PEER_ID", msgItem.v().peerUid);
        activityURIRequest.extra().putInt("KEY_SRC_CHAT_TYPE", msgItem.v().chatType);
        activityURIRequest.extra().putBoolean("KEY_FROM_SINGLE_FORWARD", true);
        QRoute.startUri(activityURIRequest);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgForwardApi
    public void forwardText(@NotNull Context context, @NotNull AIOContact contact, @NotNull String text, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, contact, text, msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Toast.makeText(context, "forwardText " + text, 0).show();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMsgForwardApi
    @NotNull
    public yw3.a getMemberViewController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (yw3.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a();
    }
}
