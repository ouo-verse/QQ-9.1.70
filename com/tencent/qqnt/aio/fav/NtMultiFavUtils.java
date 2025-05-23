package com.tencent.qqnt.aio.fav;

import android.content.Context;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFavApi;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetMultiMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JL\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J(\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J.\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0007J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0007J\u0016\u0010\u001f\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017H\u0002J\b\u0010 \u001a\u00020\u001eH\u0007J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020!H\u0002J\u0016\u0010#\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017H\u0002JF\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017H\u0007J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001eH\u0002J\u001c\u0010)\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017J\u0016\u0010+\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020\r\u00a8\u0006."}, d2 = {"Lcom/tencent/qqnt/aio/fav/NtMultiFavUtils;", "", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "", "listener", "p", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/ChatMessage;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "", "uin2NickMap", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "rootMsgId", "parentMsgId", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", tl.h.F, "msgRecords", "c", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "", "k", "f", "Lmqq/app/AppRuntime;", "g", "j", "Lcom/tencent/mobileqq/data/MessageForStructing;", "e", "l", "msgResId", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "chatMsg", DomainData.DOMAIN_NAME, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NtMultiFavUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NtMultiFavUtils f349920a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f349920a = new NtMultiFavUtils();
        }
    }

    NtMultiFavUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final ArrayList<ChatMessage> c(@NotNull QQAppInterface app, @NotNull List<MsgRecord> msgRecords) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecords, "msgRecords");
        ArrayList<ChatMessage> arrayList = new ArrayList<>();
        for (MsgRecord msgRecord : msgRecords) {
            ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(app, msgRecord);
            if (convertToChatMessage != null) {
                d a16 = e.f349924a.a(msgRecord.msgType);
                boolean z16 = false;
                if (a16 != null && a16.b(msgRecord)) {
                    z16 = true;
                }
                if (z16 && !(convertToChatMessage instanceof MessageForAniSticker) && !com.tencent.mobileqq.aio.utils.d.z(msgRecord)) {
                    arrayList.add(convertToChatMessage);
                } else {
                    arrayList.add(f349920a.n(app, convertToChatMessage));
                }
            }
        }
        return arrayList;
    }

    @JvmStatic
    @NotNull
    public static final List<AIOMsgItem> d(@NotNull List<MsgRecord> msgRecords) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(msgRecords, "msgRecords");
        List<MsgRecord> list = msgRecords;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new AIOMsgItem((MsgRecord) it.next()));
        }
        return arrayList;
    }

    private final MessageForStructing e(QQAppInterface app, Context context, ArrayList<ChatMessage> msgList, Map<String, String> uin2NickMap) {
        Object firstOrNull;
        AbsShareMsg Z = ChatActivityFacade.Z(context, null, msgList, uin2NickMap, true);
        if (Z == null) {
            return null;
        }
        String account = app.getAccount();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        ChatMessage chatMessage = (ChatMessage) firstOrNull;
        if (chatMessage == null) {
            return null;
        }
        String str = chatMessage.frienduin;
        MessageForStructing A = q.A(app, account, str, str, chatMessage.istroop, 0L, Z);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_119213209", true)) {
            A.issend = chatMessage.issend;
            A.senderuin = chatMessage.senderuin;
        }
        A.isReMultiMsg = true;
        return A;
    }

    @JvmStatic
    public static final int f() {
        ma1.b bVar = (ma1.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100813");
        if (bVar == null) {
            return new ma1.b().a();
        }
        return bVar.a();
    }

    private final int g(AppRuntime app) {
        int f16 = f();
        if (f16 <= 0) {
            return 100;
        }
        return f16;
    }

    @JvmStatic
    @Nullable
    public static final List<MsgRecord> h(@NotNull Contact contact, long rootMsgId, long parentMsgId) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getMultiMsg(contact, rootMsgId, parentMsgId, new IGetMultiMsgCallback() { // from class: com.tencent.qqnt.aio.fav.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMultiMsgCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    NtMultiFavUtils.i(Ref.ObjectRef.this, countDownLatch, i3, str, arrayList);
                }
            });
        }
        try {
            countDownLatch.await(20L, TimeUnit.SECONDS);
        } catch (Exception e17) {
            QLog.e("NTMsgFav", 1, "getMultiForwardMsgList await exception", e17);
        }
        return (List) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Ref.ObjectRef resultMsgList, CountDownLatch latch, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(resultMsgList, "$resultMsgList");
        Intrinsics.checkNotNullParameter(latch, "$latch");
        QLog.i("NTMsgFav", 1, "MsgFavUtils getMultiMsg result=" + i3 + " errMsg=" + str);
        if (i3 == 0) {
            resultMsgList.element = arrayList;
        }
        latch.countDown();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002b, code lost:
    
        if (r2 == true) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int j(List<? extends AIOMsgItem> msgList) {
        boolean z16;
        int i3 = 0;
        for (AIOMsgItem aIOMsgItem : msgList) {
            d a16 = e.f349924a.a(aIOMsgItem.getMsgRecord().msgType);
            if (a16 != null) {
                boolean b16 = a16.b(aIOMsgItem.getMsgRecord());
                z16 = true;
            }
            z16 = false;
            if (z16) {
                i3++;
            }
        }
        return i3;
    }

    private final int k(List<? extends AIOMsgItem> msgList) {
        int i3;
        int i16 = 0;
        for (AIOMsgItem aIOMsgItem : msgList) {
            if (com.tencent.mobileqq.aio.utils.d.H(aIOMsgItem)) {
                i3 = aIOMsgItem.S();
            } else {
                i3 = 1;
            }
            i16 += i3;
        }
        return i16;
    }

    @JvmStatic
    @NotNull
    public static final Map<String, String> l(@NotNull List<? extends AIOMsgItem> msgList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (AIOMsgItem aIOMsgItem : msgList) {
            long j3 = aIOMsgItem.getMsgRecord().senderUin;
            String obj = aIOMsgItem.v0().toString();
            if (j3 > 0) {
                if (obj.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    linkedHashMap.put(String.valueOf(j3), obj);
                }
            }
        }
        return linkedHashMap;
    }

    private final void o(final int msgResId) {
        PostUtilKt.b(new Function0<Unit>(msgResId) { // from class: com.tencent.qqnt.aio.fav.NtMultiFavUtils$showToast$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $msgResId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$msgResId = msgResId;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, msgResId);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQToast.makeText(BaseApplication.getContext(), this.$msgResId, 0).show();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private final void p(Context context, Function0<Unit> listener) {
        PostUtilKt.b(new NtMultiFavUtils$showUnSupportMsgDialog$1(context, listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final QQAppInterface app, final Context context, Contact contact, ArrayList<ChatMessage> msgList, Map<String, String> uin2NickMap) {
        MessageForStructing e16 = e(app, context, msgList, uin2NickMap);
        if (e16 == null) {
            QLog.e("NTMsgFav", 1, "multiFav create struct mr fail");
            o(R.string.b3o);
            return;
        }
        final QfavBuilder c06 = QfavBuilder.c0(app, contact, e16, msgList, uin2NickMap);
        if (c06 == null) {
            QLog.e("NTMsgFav", 1, "multiFav favBuilder is null");
            o(R.string.b3o);
        } else {
            c06.R(app, e16);
            PostUtilKt.b(new Function0<Unit>(context, app) { // from class: com.tencent.qqnt.aio.fav.NtMultiFavUtils$startMultiFavorite$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ QQAppInterface $app;
                final /* synthetic */ Context $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$context = context;
                    this.$app = app;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QfavBuilder.this, context, app);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("NTMsgFav", 1, "multiFav success=" + QfavBuilder.this.j(this.$context, this.$app.getAccount()));
                }
            });
        }
    }

    public final void m(@NotNull Context context, @NotNull List<? extends AIOMsgItem> msgList) {
        QQAppInterface qQAppInterface;
        boolean z16;
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) msgList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (msgList.isEmpty()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (k(msgList) > g(qQAppInterface)) {
            o(R.string.c7i);
            return;
        }
        int j3 = j(msgList);
        if (j3 < msgList.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (j3 == 0) {
            o(R.string.cdm);
            return;
        }
        if (msgList.size() == 1) {
            ((IAIOFavApi) QRoute.api(IAIOFavApi.class)).addFav(context, msgList.get(0), null);
            return;
        }
        Contact v3 = msgList.get(0).v();
        List<? extends AIOMsgItem> list = msgList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AIOMsgItem) it.next()).getMsgRecord());
        }
        Map<String, String> l3 = l(msgList);
        ArrayList<ChatMessage> c16 = c(qQAppInterface, arrayList);
        if (c16.isEmpty()) {
            QLog.e("NTMsgFav", 1, "multiFav chatMsgList is null or empty");
            o(R.string.b3o);
            return;
        }
        MultiMsgManager.w().Y(c16);
        if (z16 && !QfavUtil.z(currentAccountUin)) {
            QfavUtil.P(currentAccountUin);
            p(context, new NtMultiFavUtils$multiFav$1(qQAppInterface, context, v3, c16, l3));
        } else {
            q(qQAppInterface, context, v3, c16, l3);
        }
    }

    @NotNull
    public final ChatMessage n(@NotNull QQAppInterface app, @NotNull ChatMessage chatMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ChatMessage) iPatchRedirector.redirect((short) 3, (Object) this, (Object) app, (Object) chatMsg);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(chatMsg, "chatMsg");
        if (chatMsg instanceof MessageForArkApp) {
            return chatMsg;
        }
        byte[] bArr = null;
        boolean z16 = false;
        if (chatMsg instanceof MessageForText) {
            String str = chatMsg.f203106msg;
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (z16) {
                String string = BaseApplication.getContext().getString(R.string.meo);
                chatMsg.f203106msg = string;
                if (string != null) {
                    bArr = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                }
                chatMsg.msgData = bArr;
            }
            return chatMsg;
        }
        try {
            MessageRecord c16 = app.getMultiMessageProxy().c(chatMsg, com.tencent.mobileqq.multimsg.i.h(app, chatMsg), false);
            Intrinsics.checkNotNull(c16, "null cannot be cast to non-null type com.tencent.mobileqq.data.ChatMessage");
            ChatMessage chatMessage = (ChatMessage) c16;
            chatMessage.setStatus(1000);
            String str2 = chatMessage.f203106msg;
            if (str2 != null) {
                bArr = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            }
            chatMessage.msgData = bArr;
            return chatMessage;
        } catch (Exception e16) {
            QLog.w("NTMsgFav", 1, "replaceUnSupportMsg", e16);
            return chatMsg;
        }
    }
}
