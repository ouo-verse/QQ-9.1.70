package com.tencent.qqnt.aio.api.impl;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.utils.AIOObjectTransform;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IPicEmotionApi;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicAioType;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchReqBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchRspBody;
import com.tencent.qqnt.kernel.nativeinterface.EmojiHotPicSearchSceneType;
import com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicSearchResultCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%Jh\u0010\u0013\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J.\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00120\u0017H\u0002JH\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016JH\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016J \u0010!\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001fH\u0016J@\u0010\"\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOEmoApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOEmoApi;", "Lcom/tencent/qqnt/kernel/api/w;", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "result", "", "sendMsgWithAttr", "", "peerUid", "searchWord", "Lkotlin/Function1;", "callback", "randomGetPicEmotion", "qsid", "", "isSingleLottie", "sendEmoMsgFromOther", "syncSendEmoMsgFromOther", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "sendEmoMsgFromAIO", "sendRandomPicEmotionMsgFromOther", "sendRandomPicEmotionMsgFromAIO", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOEmoApiImpl implements IAIOEmoApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "AIOEmoApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOEmoApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.api.impl.AIOEmoApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65435);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOEmoApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void randomGetPicEmotion(String peerUid, final String searchWord, final Function1<? super String, Unit> callback) {
        long j3;
        EmojiHotPicSearchReqBody emojiHotPicSearchReqBody = new EmojiHotPicSearchReqBody();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            j3 = peekAppRuntime.getLongAccountUin();
        } else {
            j3 = 0;
        }
        emojiHotPicSearchReqBody.srcUin = j3;
        emojiHotPicSearchReqBody.userText = searchWord;
        emojiHotPicSearchReqBody.pageSize = 10;
        emojiHotPicSearchReqBody.pageIndex = 0;
        emojiHotPicSearchReqBody.sceneType = EmojiHotPicSearchSceneType.KHOTPICPANEL.ordinal();
        emojiHotPicSearchReqBody.aioType = EmojiHotPicAioType.KC2C.ordinal();
        emojiHotPicSearchReqBody.guestUid = peerUid;
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getHotPicSearchResult(emojiHotPicSearchReqBody, new IEmojiGetHotPicSearchResultCallback() { // from class: com.tencent.qqnt.aio.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IEmojiGetHotPicSearchResultCallback
                public final void onResult(int i3, String str, EmojiHotPicSearchRspBody emojiHotPicSearchRspBody) {
                    AIOEmoApiImpl.randomGetPicEmotion$lambda$8(Function1.this, searchWord, i3, str, emojiHotPicSearchRspBody);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void randomGetPicEmotion$lambda$8(final Function1 callback, final String searchWord, int i3, String str, EmojiHotPicSearchRspBody emojiHotPicSearchRspBody) {
        int i16;
        EmojiHotPicSearchEmojiInfo emojiHotPicSearchEmojiInfo;
        ArrayList<EmojiHotPicSearchEmojiInfo> arrayList;
        Object orNull;
        ArrayList<EmojiHotPicSearchEmojiInfo> arrayList2;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(searchWord, "$searchWord");
        QLog.d(TAG, 1, "getHotPicSearchResult result=" + i3 + " errMsg=" + str);
        if (emojiHotPicSearchRspBody != null && (arrayList2 = emojiHotPicSearchRspBody.infoArray) != null) {
            i16 = arrayList2.size();
        } else {
            i16 = 0;
        }
        if (i16 <= 0) {
            QLog.d(TAG, 1, "getHotPicSearchResult infoArray is empty");
            callback.invoke(null);
            return;
        }
        if (emojiHotPicSearchRspBody != null && (arrayList = emojiHotPicSearchRspBody.infoArray) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, new Random().nextInt(i16));
            emojiHotPicSearchEmojiInfo = (EmojiHotPicSearchEmojiInfo) orNull;
        } else {
            emojiHotPicSearchEmojiInfo = null;
        }
        if (emojiHotPicSearchEmojiInfo == null) {
            QLog.e(TAG, 1, "getHotPicSearchResult emojiInfo is null");
            callback.invoke(null);
        } else {
            ((IPicEmotionApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicEmotionApi.class)).downloadPicEmotion(emojiHotPicSearchEmojiInfo, new Function1<String, Unit>(searchWord, callback) { // from class: com.tencent.qqnt.aio.api.impl.AIOEmoApiImpl$randomGetPicEmotion$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<String, Unit> $callback;
                final /* synthetic */ String $searchWord;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$searchWord = searchWord;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) searchWord, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str2);
                        return;
                    }
                    QLog.d(AIOEmoApiImpl.TAG, 1, "downloadPicEmotion end searchWord=" + this.$searchWord);
                    this.$callback.invoke(str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendEmoMsgFromOther$lambda$3$lambda$2(com.tencent.qqnt.kernel.api.w it, Contact peer, int i3, boolean z16, AIOEmoApiImpl this$0, HashMap hashMap) {
        long j3;
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(peer, "$peer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Long j06 = it.j0(peer.chatType);
        if (j06 != null) {
            j3 = j06.longValue();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        AIOElementType.b a16 = com.tencent.mobileqq.aio.utils.y.f194180a.a(i3, z16);
        com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, null);
        aVar.m(a16);
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVar);
        this$0.sendMsgWithAttr(it, j16, peer, AIOObjectTransform.m(AIOObjectTransform.f194080a, arrayListOf, 0, 2, null), hashMap, new IOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                AIOEmoApiImpl.sendEmoMsgFromOther$lambda$3$lambda$2$lambda$1(i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendEmoMsgFromOther$lambda$3$lambda$2$lambda$1(int i3, String str) {
        QLog.d(TAG, 1, "[sendMsg] err=" + i3 + ", msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMsgWithAttr(com.tencent.qqnt.kernel.api.w wVar, long j3, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback) {
        if (hashMap == null) {
            wVar.F(j3, contact, arrayList, iOperateCallback);
        } else {
            wVar.sendMsg(j3, contact, arrayList, hashMap, iOperateCallback);
        }
    }

    static /* synthetic */ void sendMsgWithAttr$default(AIOEmoApiImpl aIOEmoApiImpl, com.tencent.qqnt.kernel.api.w wVar, long j3, Contact contact, ArrayList arrayList, HashMap hashMap, IOperateCallback iOperateCallback, int i3, Object obj) {
        HashMap hashMap2;
        if ((i3 & 8) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        aIOEmoApiImpl.sendMsgWithAttr(wVar, j3, contact, arrayList, hashMap2, iOperateCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void syncSendEmoMsgFromOther$lambda$6$lambda$5(int i3, String str) {
        QLog.d(TAG, 1, "[sendMsg] err=" + i3 + ", msg=" + str);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoApi
    public void sendEmoMsgFromAIO(int qsid, boolean isSingleLottie, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(qsid), Boolean.valueOf(isSingleLottie), aioContext);
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            aioContext.e().h(new AIOMsgSendEvent.EmojiFaceSendEvent(qsid, isSingleLottie));
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoApi
    public void sendEmoMsgFromOther(final int qsid, @NotNull final Contact peer, final boolean isSingleLottie, @Nullable final HashMap<Integer, MsgAttributeInfo> msgAttrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(qsid), peer, Boolean.valueOf(isSingleLottie), msgAttrs);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        final com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOEmoApiImpl.sendEmoMsgFromOther$lambda$3$lambda$2(com.tencent.qqnt.kernel.api.w.this, peer, qsid, isSingleLottie, this, msgAttrs);
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoApi
    public void sendRandomPicEmotionMsgFromAIO(@NotNull final String searchWord, @NotNull final com.tencent.aio.api.runtime.a aioContext) {
        String str;
        AIOSession r16;
        AIOContact c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) searchWord, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOParam g16 = aioContext.g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        randomGetPicEmotion(str, searchWord, new Function1<String, Unit>(searchWord, aioContext) { // from class: com.tencent.qqnt.aio.api.impl.AIOEmoApiImpl$sendRandomPicEmotionMsgFromAIO$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.aio.api.runtime.a $aioContext;
            final /* synthetic */ String $searchWord;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$searchWord = searchWord;
                this.$aioContext = aioContext;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) searchWord, (Object) aioContext);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str2);
                    return;
                }
                if (str2 != null && com.tencent.qqnt.aio.utils.m.f352305a.f(str2)) {
                    QLog.d(AIOEmoApiImpl.TAG, 1, "[sendPicEmotionMsg] sendRandomPicEmotionMsgFromAIO searchWord=" + this.$searchWord);
                    this.$aioContext.e().h(new AIOMsgSendEvent.PicEmotionSendEvent(str2, 13, null, null, null, 28, null));
                    return;
                }
                QLog.e(AIOEmoApiImpl.TAG, 1, "sendRandomPicEmotionMsgFromAIO path not exists, " + str2);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoApi
    public void sendRandomPicEmotionMsgFromOther(@NotNull String searchWord, @NotNull Contact peer, @Nullable HashMap<Integer, MsgAttributeInfo> msgAttrs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, searchWord, peer, msgAttrs);
            return;
        }
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(peer, "peer");
        String str = peer.peerUid;
        if (str == null) {
            str = "";
        }
        randomGetPicEmotion(str, searchWord, new AIOEmoApiImpl$sendRandomPicEmotionMsgFromOther$1(peer, this, msgAttrs));
    }

    @Override // com.tencent.qqnt.aio.api.IAIOEmoApi
    public void syncSendEmoMsgFromOther(int qsid, @NotNull Contact peer, boolean isSingleLottie, @Nullable HashMap<Integer, MsgAttributeInfo> msgAttrs) {
        long j3;
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(qsid), peer, Boolean.valueOf(isSingleLottie), msgAttrs);
            return;
        }
        Intrinsics.checkNotNullParameter(peer, "peer");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Long j06 = e16.j0(peer.chatType);
            if (j06 != null) {
                j3 = j06.longValue();
            } else {
                j3 = 0;
            }
            AIOElementType.b a16 = com.tencent.mobileqq.aio.utils.y.f194180a.a(qsid, isSingleLottie);
            com.tencent.mobileqq.aio.msg.data.a aVar = new com.tencent.mobileqq.aio.msg.data.a(6, 0, 2, null);
            aVar.m(a16);
            Unit unit = Unit.INSTANCE;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVar);
            sendMsgWithAttr(e16, j3, peer, AIOObjectTransform.m(AIOObjectTransform.f194080a, arrayListOf, 0, 2, null), msgAttrs, new IOperateCallback() { // from class: com.tencent.qqnt.aio.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AIOEmoApiImpl.syncSendEmoMsgFromOther$lambda$6$lambda$5(i3, str);
                }
            });
        }
    }
}
