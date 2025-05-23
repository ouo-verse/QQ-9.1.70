package com.tencent.qqnt.aio.api.impl;

import android.net.Uri;
import android.os.Looper;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOSession;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.api.IAIOFileTransfer;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IArkMsgService;
import com.tencent.qqnt.msg.api.IMsgService;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J&\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016JD\u0010\u001a\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0016j\b\u0012\u0004\u0012\u00020\u0014`\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016JJ\u0010$\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J8\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J:\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016J:\u0010,\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010+\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010-\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J \u00100\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0016J \u00101\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u00106\u001a\u00020\b2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0016J(\u00108\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J(\u00108\u001a\u00020\b2\u0006\u0010:\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/MsgSendHelperImpl;", "Lcom/tencent/qqnt/aio/api/IMsgSendHelper;", "", "peerUid", "", "chatType", "Lcom/tencent/mobileqq/aio/msg/data/a;", DTConstants.TAG.ELEMENT, "", "send", "", "doSendMsg", "sendVideo", "content", "syncSendText", "sendText", "", "rootMsgIds", "", "forwardMsgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "srcContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dstContacts", "comment", "forward", "path", "", CustomImageProps.QUALITY, QCircleLpReportDc010001.KEY_SUBTYPE, "", "maxPicSize", "md5", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "sendPic", "Landroid/net/Uri;", "imageUri", "sendPicByUri", "origPath", "businessType", "thumbPath", "mediaUri", "sendVideoByUri", "sendFile", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "sendArk", "sendArkWithMsgId", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "reSendMsg", "atUid", "sendAtTextMsg", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "atTextElement", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MsgSendHelperImpl implements IMsgSendHelper {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "MsgSendHelperImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/MsgSendHelperImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.MsgSendHelperImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65500);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgSendHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void doSendMsg(String peerUid, int chatType, List<com.tencent.mobileqq.aio.msg.data.a> element) {
        FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.z(new com.tencent.aio.msgservice.k(new AIOSession(new AIOContact(chatType, peerUid, "", null, 8, null)), element)), new MsgSendHelperImpl$doSendMsg$1(null)), Dispatchers.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forward$lambda$2(String str, long[] jArr, long j3, Contact srcContact, ArrayList dstContacts) {
        boolean z16;
        ArrayList<MsgElement> m3;
        ArrayList<Long> arrayListOf;
        boolean z17;
        Collection collection;
        ArrayList<Long> arrayListOf2;
        Intrinsics.checkNotNullParameter(srcContact, "$srcContact");
        Intrinsics.checkNotNullParameter(dstContacts, "$dstContacts");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            m3 = null;
        } else {
            m3 = AIOObjectTransform.m(AIOObjectTransform.f194080a, com.tencent.mobileqq.aio.utils.y.d(com.tencent.mobileqq.aio.utils.y.f194180a, str, 0, 0L, 0L, null, 30, null), 0, 2, null);
        }
        if (jArr != null) {
            if (jArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    collection = ArraysKt___ArraysKt.toCollection(jArr, new ArrayList());
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(j3));
                    e16.k((ArrayList) collection, arrayListOf2, srcContact, dstContacts, m3, new IForwardOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.y
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
                        public final void onResult(int i3, String str2, HashMap hashMap) {
                            MsgSendHelperImpl.forward$lambda$2$lambda$0(i3, str2, hashMap);
                        }
                    });
                    return;
                }
                return;
            }
        }
        com.tencent.qqnt.kernel.api.w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(j3));
            e17.forwardMsg(arrayListOf, srcContact, dstContacts, m3, new IForwardOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.z
                @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
                public final void onResult(int i3, String str2, HashMap hashMap) {
                    MsgSendHelperImpl.forward$lambda$2$lambda$1(i3, str2, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forward$lambda$2$lambda$0(int i3, String str, HashMap hashMap) {
        QLog.d(TAG, 1, "forwardSubMsg result " + i3 + " msg: " + str + ", err: " + hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forward$lambda$2$lambda$1(int i3, String str, HashMap hashMap) {
        QLog.d(TAG, 1, "forwardMsg result=" + i3 + " err=" + str + ", " + hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reSendMsg$lambda$5(int i3, String str) {
        QLog.d("AIOMsgStatusVM", 1, "resendMsg result=" + i3 + ", errMsg=" + str);
    }

    private final void send(String peerUid, int chatType, com.tencent.mobileqq.aio.msg.data.a element) {
        List<com.tencent.mobileqq.aio.msg.data.a> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(element);
        send(peerUid, chatType, listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void send$lambda$3(MsgSendHelperImpl this$0, String peerUid, int i3, List element) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(element, "$element");
        this$0.doSendMsg(peerUid, i3, element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendVideo$lambda$4(int i3, String peerUid, com.tencent.mobileqq.aio.msg.data.a element) {
        List listOf;
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(element, "$element");
        AIOMsgService aIOMsgService = AIOMsgService.f190196a;
        AIOSession aIOSession = new AIOSession(new AIOContact(i3, peerUid, "", null, 8, null));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(element);
        aIOMsgService.d(new com.tencent.aio.msgservice.k(aIOSession, listOf));
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void forward(@Nullable final long[] rootMsgIds, final long forwardMsgId, @NotNull final Contact srcContact, @NotNull final ArrayList<Contact> dstContacts, @Nullable final String comment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, rootMsgIds, Long.valueOf(forwardMsgId), srcContact, dstContacts, comment);
            return;
        }
        Intrinsics.checkNotNullParameter(srcContact, "srcContact");
        Intrinsics.checkNotNullParameter(dstContacts, "dstContacts");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.ad
            @Override // java.lang.Runnable
            public final void run() {
                MsgSendHelperImpl.forward$lambda$2(comment, rootMsgIds, forwardMsgId, srcContact, dstContacts);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void reSendMsg(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aioContext, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        aioContext.e().h(new AIOMsgListEvent.ResendingMsg(msgItem.getMsgId()));
        if (((AIOMsgItem) msgItem).getMsgRecord().msgType == 7) {
            aioContext.e().h(new AIOMsgListEvent.ResendVideoMsg(msgItem.getMsgId()));
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).resendMsg(com.tencent.mobileqq.aio.utils.o.a(aioContext.g().r()), msgItem.getMsgId(), new IOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.aa
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MsgSendHelperImpl.reSendMsg$lambda$5(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendArk(@NotNull String peerUid, int chatType, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, peerUid, Integer.valueOf(chatType), arkMsgModel);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        ((IArkMsgService) QRoute.api(IArkMsgService.class)).sendMsg(new Contact(chatType, peerUid, ""), arkMsgModel, null);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public long sendArkWithMsgId(@NotNull String peerUid, int chatType, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, this, peerUid, Integer.valueOf(chatType), arkMsgModel)).longValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        return ((IArkMsgService) QRoute.api(IArkMsgService.class)).sendMsgWithMsgId(new Contact(chatType, peerUid, ""), arkMsgModel, null);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendAtTextMsg(@NotNull String peerUid, @NotNull String atUid, int chatType, @NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, peerUid, atUid, Integer.valueOf(chatType), content);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(atUid, "atUid");
        Intrinsics.checkNotNullParameter(content, "content");
        AIOElementType.h hVar = new AIOElementType.h("", 2, 0L, 0L, atUid);
        List d16 = com.tencent.mobileqq.aio.utils.y.d(com.tencent.mobileqq.aio.utils.y.f194180a, content, 0, 0L, 0L, null, 30, null);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(d16);
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(1, 0, 2, null);
        aVar.t(hVar);
        arrayList.add(aVar);
        Unit unit = Unit.INSTANCE;
        send(peerUid, chatType, arrayList);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendFile(@NotNull String peerUid, int chatType, @NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, peerUid, Integer.valueOf(chatType), path);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(path, "path");
        if (!com.tencent.qqnt.aio.utils.m.e(path)) {
            QLog.d(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
        } else {
            ((IAIOFileTransfer) QRoute.api(IAIOFileTransfer.class)).sendLocalFile(new Contact(chatType, peerUid, ""), path, null);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendPic(@NotNull String peerUid, int chatType, @NotNull String path, boolean quality, int subType, float maxPicSize, @NotNull String md5, @Nullable com.tencent.qqnt.msg.data.g picExtBizInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, peerUid, Integer.valueOf(chatType), path, Boolean.valueOf(quality), Integer.valueOf(subType), Float.valueOf(maxPicSize), md5, picExtBizInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(md5, "md5");
        if (!com.tencent.qqnt.aio.utils.m.e(path)) {
            QLog.d(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
            return;
        }
        if (MsgExtKt.v(subType)) {
            str = BaseApplication.getContext().getString(R.string.ypo);
        } else {
            str = null;
        }
        send(peerUid, chatType, new com.tencent.mobileqq.aio.msg.data.a(2, 0, 2, null).q(new AIOElementType.e(path, null, quality, subType, str, maxPicSize, picExtBizInfo, md5, false, 256, null)));
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendPicByUri(@NotNull String peerUid, int chatType, @NotNull Uri imageUri, boolean quality, int subType, float maxPicSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, peerUid, Integer.valueOf(chatType), imageUri, Boolean.valueOf(quality), Integer.valueOf(subType), Float.valueOf(maxPicSize));
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        send(peerUid, chatType, new com.tencent.mobileqq.aio.msg.data.a(2, 0, 2, null).q(new AIOElementType.e("", imageUri, quality, subType, null, maxPicSize, null, null, false, 464, null)));
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendText(@NotNull String peerUid, int chatType, @NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, peerUid, Integer.valueOf(chatType), content);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(content, "content");
        send(peerUid, chatType, com.tencent.mobileqq.aio.utils.y.d(com.tencent.mobileqq.aio.utils.y.f194180a, content, 0, 0L, 0L, null, 30, null));
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendVideo(@NotNull String peerUid, int chatType, @NotNull String origPath, int businessType, boolean quality, @Nullable String thumbPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, peerUid, Integer.valueOf(chatType), origPath, Integer.valueOf(businessType), Boolean.valueOf(quality), thumbPath);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(origPath, "origPath");
        if (!com.tencent.qqnt.aio.utils.m.e(origPath)) {
            QLog.d(TAG, 1, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
        } else {
            sendVideo(peerUid, chatType, new com.tencent.mobileqq.aio.msg.data.a(5, 0, 2, null).u(new AIOElementType.i(origPath, null, businessType, quality, thumbPath, null, 32, null)));
        }
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendVideoByUri(@NotNull String peerUid, int chatType, @NotNull Uri mediaUri, int businessType, boolean quality, @Nullable String thumbPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, peerUid, Integer.valueOf(chatType), mediaUri, Integer.valueOf(businessType), Boolean.valueOf(quality), thumbPath);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(mediaUri, "mediaUri");
        sendVideo(peerUid, chatType, new com.tencent.mobileqq.aio.msg.data.a(5, 0, 2, null).u(new AIOElementType.i("", mediaUri, businessType, quality, thumbPath, null, 32, null)));
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void syncSendText(@NotNull String peerUid, int chatType, @NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, peerUid, Integer.valueOf(chatType), content);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(content, "content");
        doSendMsg(peerUid, chatType, com.tencent.mobileqq.aio.utils.y.d(com.tencent.mobileqq.aio.utils.y.f194180a, content, 0, 0L, 0L, null, 30, null));
    }

    private final void send(final String peerUid, final int chatType, final List<com.tencent.mobileqq.aio.msg.data.a> element) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            doSendMsg(peerUid, chatType, element);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.ab
                @Override // java.lang.Runnable
                public final void run() {
                    MsgSendHelperImpl.send$lambda$3(MsgSendHelperImpl.this, peerUid, chatType, element);
                }
            }, 16, null, false);
        }
    }

    private final void sendVideo(final String peerUid, final int chatType, final com.tencent.mobileqq.aio.msg.data.a element) {
        List listOf;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            AIOMsgService aIOMsgService = AIOMsgService.f190196a;
            AIOSession aIOSession = new AIOSession(new AIOContact(chatType, peerUid, "", null, 8, null));
            listOf = CollectionsKt__CollectionsJVMKt.listOf(element);
            aIOMsgService.d(new com.tencent.aio.msgservice.k(aIOSession, listOf));
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.ac
            @Override // java.lang.Runnable
            public final void run() {
                MsgSendHelperImpl.sendVideo$lambda$4(chatType, peerUid, element);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqnt.aio.api.IMsgSendHelper
    public void sendAtTextMsg(@NotNull AIOElementType.h atTextElement, @NotNull String peerUid, int chatType, @NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, atTextElement, peerUid, Integer.valueOf(chatType), content);
            return;
        }
        Intrinsics.checkNotNullParameter(atTextElement, "atTextElement");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(content, "content");
        List d16 = com.tencent.mobileqq.aio.utils.y.d(com.tencent.mobileqq.aio.utils.y.f194180a, content, 0, 0L, 0L, null, 30, null);
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(1, 0, 2, null);
        aVar.t(atTextElement);
        arrayList.add(aVar);
        arrayList.addAll(d16);
        Unit unit = Unit.INSTANCE;
        send(peerUid, chatType, arrayList);
    }
}
