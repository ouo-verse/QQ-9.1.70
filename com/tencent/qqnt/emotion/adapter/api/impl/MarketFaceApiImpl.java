package com.tencent.qqnt.emotion.adapter.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi;
import com.tencent.qqnt.emotion.adapter.api.a;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J#\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\"H\u0016JH\u0010/\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0016J:\u0010/\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u000102H\u0016J.\u00106\u001a\u00020\u001a2\b\u00104\u001a\u0004\u0018\u00010$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u00105\u001a\u0004\u0018\u00010(2\u0006\u0010.\u001a\u00020-H\u0016R\u0014\u00107\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/api/impl/MarketFaceApiImpl;", "Lcom/tencent/qqnt/emotion/adapter/api/IMarketFaceApi;", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "emoticonInfo", "Lcom/tencent/qqnt/emotion/adapter/api/a;", "createEmoInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "marketFaceElement", "queryEmoticonInfoFromDB", "Lkotlin/Pair;", "", "calculateMarketFaceViewSize", "emoWidth", "emoHeight", "emoExtWidth", "emoExtHeight", "Lcom/tencent/qqnt/msg/api/c;", "fetchMarketFaceInfoSuspend", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markFaceMessage", "Landroid/widget/ImageView;", "bubbleIv", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "bindMagicMarketFaceToView", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Landroid/widget/ImageView;JLcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "data", "addToFavEmo", "(Landroid/content/Context;Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "createMarketFaceElement", "Lmqq/app/AppRuntime;", "runtime", "Landroid/widget/EditText;", "input", "Landroid/os/Parcelable;", "sessionInfoParcelable", "", "isFroward", "forwardID", "Lcom/tencent/mobileqq/emoticonview/PicEmoticonInfo;", "picEmoticonInfo", "send", "Lcom/tencent/mobileqq/data/Emoticon;", "emoticon", "Lcom/tencent/mobileqq/emoticon/StickerInfo;", "stickerInfo", "app", "sessionInfo", "sendFromGuild", "sDensity", "I", "tDensity", "<init>", "()V", "Companion", "a", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MarketFaceApiImpl implements IMarketFaceApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "MarketFaceApiImpl";
    private final int sDensity;
    private final int tDensity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/api/impl/MarketFaceApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.adapter.api.impl.MarketFaceApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MarketFaceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sDensity = 320;
            this.tDensity = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
        }
    }

    private final Pair<Integer, Integer> calculateMarketFaceViewSize(IPicEmoticonInfo emoticonInfo) {
        if (emoticonInfo == null) {
            return new Pair<>(0, 0);
        }
        return calculateMarketFaceViewSize(emoticonInfo.emoWidth(), emoticonInfo.emoHeight(), emoticonInfo.emoExtWidth(), emoticonInfo.emoExtHeight());
    }

    private final a createEmoInfo(IPicEmoticonInfo emoticonInfo) {
        int i3;
        Pair<Integer, Integer> calculateMarketFaceViewSize = calculateMarketFaceViewSize(emoticonInfo);
        int intValue = calculateMarketFaceViewSize.component1().intValue();
        int intValue2 = calculateMarketFaceViewSize.component2().intValue();
        if (emoticonInfo != null) {
            i3 = emoticonInfo.getImageJobType();
        } else {
            i3 = 0;
        }
        return new a(emoticonInfo, i3, new Pair(Integer.valueOf(intValue), Integer.valueOf(intValue2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPicEmoticonInfo queryEmoticonInfoFromDB(MarketFaceElement marketFaceElement) {
        IEmoticonManagerService iEmoticonManagerService;
        MarkFaceMessage d16 = com.tencent.qqnt.emotion.adapter.a.f356140a.d(marketFaceElement);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Parcelable parcelable = null;
        if (waitAppRuntime != null) {
            iEmoticonManagerService = (IEmoticonManagerService) waitAppRuntime.getRuntimeService(IEmoticonManagerService.class, "");
        } else {
            iEmoticonManagerService = null;
        }
        if (iEmoticonManagerService != null) {
            parcelable = iEmoticonManagerService.syncGetEmoticonInfo(d16);
        }
        return (IPicEmoticonInfo) parcelable;
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi
    @Nullable
    public Object addToFavEmo(@NotNull Context context, @NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, this, context, marketFaceElement, continuation);
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi
    @Nullable
    public Object bindMagicMarketFaceToView(@NotNull MarketFaceElement marketFaceElement, @NotNull ImageView imageView, long j3, @NotNull Contact contact, @NotNull Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, marketFaceElement, imageView, Long.valueOf(j3), contact, continuation);
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi
    @NotNull
    public MarketFaceElement createMarketFaceElement(@NotNull MarkFaceMessage markFaceMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MarketFaceElement) iPatchRedirector.redirect((short) 6, (Object) this, (Object) markFaceMessage);
        }
        Intrinsics.checkNotNullParameter(markFaceMessage, "markFaceMessage");
        return com.tencent.qqnt.emotion.msg.utils.a.f356292a.a(markFaceMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    @Override // com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetchMarketFaceInfoSuspend(@NotNull MarketFaceElement marketFaceElement, @NotNull Continuation<? super c<a>> continuation) {
        MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1 marketFaceApiImpl$fetchMarketFaceInfoSuspend$1;
        Object coroutine_suspended;
        int i3;
        MarketFaceApiImpl marketFaceApiImpl;
        Ref.ObjectRef objectRef;
        T t16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) marketFaceElement, (Object) continuation);
        }
        if (continuation instanceof MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1) {
            marketFaceApiImpl$fetchMarketFaceInfoSuspend$1 = (MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1) continuation;
            int i16 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label = i16 - Integer.MIN_VALUE;
                Object obj = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label;
                int i17 = 1;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$1;
                        marketFaceApiImpl = (MarketFaceApiImpl) marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2 marketFaceApiImpl$fetchMarketFaceInfoSuspend$2 = new MarketFaceApiImpl$fetchMarketFaceInfoSuspend$2(objectRef2, this, marketFaceElement, null);
                    marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$0 = this;
                    marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.L$1 = objectRef2;
                    marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label = 1;
                    if (BuildersKt.withContext(io5, marketFaceApiImpl$fetchMarketFaceInfoSuspend$2, marketFaceApiImpl$fetchMarketFaceInfoSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    marketFaceApiImpl = this;
                    objectRef = objectRef2;
                }
                a createEmoInfo = marketFaceApiImpl.createEmoInfo((IPicEmoticonInfo) objectRef.element);
                t16 = objectRef.element;
                if (t16 != 0) {
                    i17 = 0;
                }
                if (t16 != 0) {
                    str = "emoticonInfo is Empty";
                } else {
                    str = "";
                }
                return new c(createEmoInfo, i17, str);
            }
        }
        marketFaceApiImpl$fetchMarketFaceInfoSuspend$1 = new MarketFaceApiImpl$fetchMarketFaceInfoSuspend$1(this, continuation);
        Object obj2 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = marketFaceApiImpl$fetchMarketFaceInfoSuspend$1.label;
        int i172 = 1;
        if (i3 == 0) {
        }
        a createEmoInfo2 = marketFaceApiImpl.createEmoInfo((IPicEmoticonInfo) objectRef.element);
        t16 = objectRef.element;
        if (t16 != 0) {
        }
        if (t16 != 0) {
        }
        return new c(createEmoInfo2, i172, str);
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi
    public void send(@Nullable AppRuntime runtime, @Nullable Context context, @Nullable EditText input, @Nullable Parcelable sessionInfoParcelable, boolean isFroward, int forwardID, @NotNull PicEmoticonInfo picEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, runtime, context, input, sessionInfoParcelable, Boolean.valueOf(isFroward), Integer.valueOf(forwardID), picEmoticonInfo);
        } else {
            Intrinsics.checkNotNullParameter(picEmoticonInfo, "picEmoticonInfo");
            ((IPicEmoticonInfoSenderApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicEmoticonInfoSenderApi.class)).send(runtime, context, input, sessionInfoParcelable, isFroward, forwardID, picEmoticonInfo);
        }
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi
    public void sendFromGuild(@Nullable AppRuntime app, @Nullable Context context, @Nullable Parcelable sessionInfo, @NotNull PicEmoticonInfo picEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, app, context, sessionInfo, picEmoticonInfo);
        } else {
            Intrinsics.checkNotNullParameter(picEmoticonInfo, "picEmoticonInfo");
            ((IPicEmoticonInfoSenderApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicEmoticonInfoSenderApi.class)).sendFromGuild(app, context, sessionInfo, picEmoticonInfo);
        }
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi
    public void send(@Nullable AppRuntime runtime, @Nullable Context context, @Nullable Parcelable sessionInfoParcelable, @Nullable Emoticon emoticon, @Nullable StickerInfo stickerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            ((IPicEmoticonInfoSenderApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPicEmoticonInfoSenderApi.class)).send(runtime, context, sessionInfoParcelable, emoticon, stickerInfo);
        } else {
            iPatchRedirector.redirect((short) 8, this, runtime, context, sessionInfoParcelable, emoticon, stickerInfo);
        }
    }

    private final Pair<Integer, Integer> calculateMarketFaceViewSize(int emoWidth, int emoHeight, int emoExtWidth, int emoExtHeight) {
        if (emoWidth <= 0) {
            emoWidth = 200;
        }
        if (emoHeight <= 0) {
            emoHeight = 200;
        }
        if (emoExtWidth <= 0 || emoExtHeight <= 0) {
            emoExtWidth = emoWidth;
            emoExtHeight = emoHeight;
        }
        if (emoExtWidth != emoExtHeight) {
            emoExtWidth = emoExtHeight;
        }
        int i3 = this.tDensity;
        int i16 = this.sDensity;
        int i17 = ((emoExtWidth * i3) + (i16 >> 1)) / i16;
        int i18 = ((emoExtHeight * i3) + (i16 >> 1)) / i16;
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "calculateMarketFaceViewSize width=" + i17 + " height=" + i18);
        }
        return new Pair<>(Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi
    @NotNull
    public Pair<Integer, Integer> calculateMarketFaceViewSize(@NotNull MarketFaceElement marketFaceElement) {
        IEmoticonManagerService iEmoticonManagerService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) marketFaceElement);
        }
        Intrinsics.checkNotNullParameter(marketFaceElement, "marketFaceElement");
        Integer num = marketFaceElement.emojiType;
        ArrayList<MarketFaceSupportSize> arrayList = (num != null && num.intValue() == 2) ? marketFaceElement.apngSupportSize : marketFaceElement.supportSize;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int extensionSizeByScreenSize = (peekAppRuntime == null || (iEmoticonManagerService = (IEmoticonManagerService) peekAppRuntime.getRuntimeService(IEmoticonManagerService.class, "")) == null) ? 0 : iEmoticonManagerService.getExtensionSizeByScreenSize(arrayList);
        return calculateMarketFaceViewSize(marketFaceElement.imageWidth, marketFaceElement.imageHeight, extensionSizeByScreenSize, extensionSizeByScreenSize);
    }
}
