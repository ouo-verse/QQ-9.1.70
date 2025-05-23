package pn4;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TextMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.MessageOuterClass$TimiEmoData;
import trpc.yes.common.MessageOuterClass$TimiEmoMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\f\n\u0002\b\u0006*\u0001@\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u00020\u001e\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0002H&J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0016J\"\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0017\u00101\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u00020\u001e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010.R(\u00109\u001a\b\u0012\u0004\u0012\u00020\u0018038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0010038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00104R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010A\u00a8\u0006E"}, d2 = {"Lpn4/b;", "Lcom/tencent/timi/game/tim/api/message/c;", "", "w", "Lcom/tencent/timi/game/tim/api/message/a;", "lastMsg", "", "count", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "sender", "needAccurateSeq", "u", "Lpn4/g;", "msgInfo", HippyTKDListViewAdapter.X, "resend", "y", "p", "r", "v", "Lcom/tencent/timi/game/tim/api/message/b;", "listener", "b", "k", "i", "userId", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", h.F, "j", "Ltrpc/yes/common/MessageOuterClass$TimiEmoData;", "emoData", "d", "type", "c", "msg", "e", "f", "g", "a", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "chatId", "TAG", "", "Ljava/util/List;", "t", "()Ljava/util/List;", "setListeners", "(Ljava/util/List;)V", "listeners", "Z", "isLoadingHistory", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "images", "pn4/b$f", "Lpn4/b$f;", "msgListener", "<init>", "(Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class b implements com.tencent.timi.game.tim.api.message.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String chatId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.timi.game.tim.api.message.b> listeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isLoadingHistory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<g> images;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f msgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"pn4/b$a", "Lkn4/a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements kn4.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f426549b;

        a(g gVar) {
            this.f426549b = gVar;
        }

        @Override // kn4.a
        public void onError(int errorCode, @Nullable String errorMsg) {
            this.f426549b.q(MsgStatus.FAILED);
            List<com.tencent.timi.game.tim.api.message.b> t16 = b.this.t();
            g gVar = this.f426549b;
            Iterator<T> it = t16.iterator();
            while (it.hasNext()) {
                ((com.tencent.timi.game.tim.api.message.b) it.next()).f(gVar, errorCode, errorMsg);
            }
        }

        @Override // kn4.a
        public void onSuccess() {
            b.this.r(this.f426549b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"pn4/b$b", "Lkn4/a;", "", "onSuccess", "", "errorCode", "", "errorMsg", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pn4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11031b implements kn4.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f426551b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f426552c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pn4/b$b$a", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "p0", "", "a", "", "", "p1", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: pn4.b$b$a */
        /* loaded from: classes26.dex */
        public static final class a implements V2TIMValueCallback<List<V2TIMMessage>> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f426553a;

            a(b bVar) {
                this.f426553a = bVar;
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable List<V2TIMMessage> p06) {
                List reversed;
                int collectionSizeOrDefault;
                l.b(this.f426553a.TAG, "checkLoginGetHistoryMsgList onSuccess");
                this.f426553a.A(false);
                if (p06 != null) {
                    for (com.tencent.timi.game.tim.api.message.b bVar : this.f426553a.t()) {
                        reversed = CollectionsKt___CollectionsKt.reversed(p06);
                        List list = reversed;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new g((V2TIMMessage) it.next()));
                        }
                        bVar.g(arrayList);
                    }
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int p06, @Nullable String p16) {
                l.b(this.f426553a.TAG, "checkLoginGetHistoryMsgList onError");
                this.f426553a.A(false);
            }
        }

        C11031b(int i3, com.tencent.timi.game.tim.api.message.a aVar) {
            this.f426551b = i3;
            this.f426552c = aVar;
        }

        @Override // kn4.a
        public void onError(int errorCode, @Nullable String errorMsg) {
            l.b(b.this.TAG, "checkLoginGetHistoryMsgList login onError");
            b.this.A(false);
        }

        @Override // kn4.a
        public void onSuccess() {
            l.b(b.this.TAG, "checkLoginGetHistoryMsgList begin getHistory");
            a aVar = new a(b.this);
            V2TIMMessage v2TIMMessage = null;
            if (b.this.v()) {
                V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
                String chatId = b.this.getChatId();
                int i3 = this.f426551b;
                com.tencent.timi.game.tim.api.message.a aVar2 = this.f426552c;
                if (aVar2 instanceof g) {
                    v2TIMMessage = ((g) aVar2).getV2TIMMessage();
                }
                messageManager.getGroupHistoryMessageList(chatId, i3, v2TIMMessage, aVar);
                return;
            }
            V2TIMMessageManager messageManager2 = V2TIMManager.getMessageManager();
            String chatId2 = b.this.getChatId();
            int i16 = this.f426551b;
            com.tencent.timi.game.tim.api.message.a aVar3 = this.f426552c;
            if (aVar3 instanceof g) {
                v2TIMMessage = ((g) aVar3).getV2TIMMessage();
            }
            messageManager2.getC2CHistoryMessageList(chatId2, i16, v2TIMMessage, aVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"pn4/b$c", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "", "onSuccess", "", "code", "", "desc", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements V2TIMCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f426554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f426555b;

        c(com.tencent.timi.game.tim.api.message.a aVar, b bVar) {
            this.f426554a = aVar;
            this.f426555b = bVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int code, @Nullable String desc) {
            l.i(this.f426555b.TAG, "delete error: " + code + ", " + desc);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            this.f426554a.q(MsgStatus.DELETE);
            List<com.tencent.timi.game.tim.api.message.b> t16 = this.f426555b.t();
            com.tencent.timi.game.tim.api.message.a aVar = this.f426554a;
            Iterator<T> it = t16.iterator();
            while (it.hasNext()) {
                ((com.tencent.timi.game.tim.api.message.b) it.next()).h(aVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pn4/b$e", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "p0", "", "a", "", "code", "", "desc", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements V2TIMValueCallback<V2TIMMessage> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f426559b;

        e(g gVar) {
            this.f426559b = gVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable V2TIMMessage p06) {
            l.e(b.this.TAG, "insertGroupMsg onSuccess: " + this.f426559b.id());
            this.f426559b.q(MsgStatus.SUCCESS);
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int code, @Nullable String desc) {
            l.i(b.this.TAG, "insertGroupMsg error: " + code + ", " + desc);
            this.f426559b.q(MsgStatus.FAILED);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"pn4/b$f", "Lcom/tencent/imsdk/v2/V2TIMAdvancedMsgListener;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "msg", "", "onRecvNewMessage", "", "msgID", "onRecvMessageRevoked", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f extends V2TIMAdvancedMsgListener {
        f() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvMessageRevoked(@NotNull String msgID) {
            Intrinsics.checkNotNullParameter(msgID, "msgID");
            Iterator<T> it = b.this.t().iterator();
            while (it.hasNext()) {
                ((com.tencent.timi.game.tim.api.message.b) it.next()).a(msgID);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMAdvancedMsgListener
        public void onRecvNewMessage(@NotNull V2TIMMessage msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            l.b(b.this.TAG, "onRecvNewMessage: " + msg2.getGroupID() + ", " + msg2.getSender());
            List<com.tencent.timi.game.tim.api.message.b> t16 = b.this.t();
            b bVar = b.this;
            for (com.tencent.timi.game.tim.api.message.b bVar2 : t16) {
                g gVar = new g(msg2);
                if (bVar.v()) {
                    if (gVar.i() && gVar.j() == UStringsKt.toULong(bVar.getChatId())) {
                        bVar2.c(new g(msg2));
                    }
                } else if (!gVar.i() && gVar.c().uid.get() == UStringsKt.toULong(bVar.getChatId())) {
                    bVar2.c(new g(msg2));
                }
            }
        }
    }

    public b(@NotNull String chatId) {
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        this.chatId = chatId;
        this.TAG = "BaseMsgManager";
        this.listeners = new ArrayList();
        this.images = new ArrayList();
        this.msgListener = new f();
    }

    private final void p(g msgInfo) {
        ((kn4.b) mm4.b.b(kn4.b.class)).T1(new a(msgInfo));
    }

    private final void q(com.tencent.timi.game.tim.api.message.a lastMsg, int count) {
        if (this.isLoadingHistory) {
            return;
        }
        l.b(this.TAG, "lastMsg = [" + lastMsg + "], count = [" + count + "]");
        this.isLoadingHistory = true;
        ((kn4.b) mm4.b.b(kn4.b.class)).T1(new C11031b(count, lastMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(g msgInfo) {
        String str;
        V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
        V2TIMMessage v2TIMMessage = msgInfo.getV2TIMMessage();
        String str2 = null;
        if (!v()) {
            str = this.chatId;
        } else {
            str = null;
        }
        if (v()) {
            str2 = this.chatId;
        }
        messageManager.sendMessage(v2TIMMessage, str, str2, 0, false, null, new d(msgInfo, this));
    }

    private final boolean u(MessageOuterClass$TimMsgBody timMsgBody, CommonOuterClass$QQUserId sender, boolean needAccurateSeq) {
        PBUInt64Field pBUInt64Field;
        if (!w()) {
            l.e(this.TAG, "insertGroupMsg failt: so is not load");
            return false;
        }
        timMsgBody.from_user.set(sender);
        V2TIMMessage v2TIMMessage = V2TIMManager.getMessageManager().createCustomMessage(PluginBaseInfoHelper.Base64Helper.encode(timMsgBody.toByteArray(), 2));
        if (needAccurateSeq) {
            v2TIMMessage.setLocalCustomData(String.valueOf(yn4.d.d()));
        }
        Intrinsics.checkNotNullExpressionValue(v2TIMMessage, "v2TIMMessage");
        g gVar = new g(v2TIMMessage);
        V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
        String str = this.chatId;
        if (sender.yes_uid.get() != 0) {
            pBUInt64Field = sender.yes_uid;
        } else {
            pBUInt64Field = sender.uid;
        }
        messageManager.insertGroupMessageToLocalStorage(v2TIMMessage, str, nn4.a.a(pBUInt64Field.get()), new e(gVar));
        gVar.q(MsgStatus.SUCCESS);
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.timi.game.tim.api.message.b) it.next()).c(new g(v2TIMMessage));
        }
        return true;
    }

    private final boolean w() {
        return ((kn4.b) mm4.b.b(kn4.b.class)).isLoaded();
    }

    private final void x(g msgInfo) {
        y(msgInfo, false);
    }

    private final void y(final g msgInfo, final boolean resend) {
        p(msgInfo);
        w.c(new Runnable() { // from class: pn4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.z(g.this, this, resend);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(g msgInfo, b this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(msgInfo, "$msgInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        msgInfo.q(MsgStatus.SENDING);
        for (com.tencent.timi.game.tim.api.message.b bVar : this$0.listeners) {
            if (z16) {
                bVar.d(msgInfo);
            } else {
                bVar.e(msgInfo);
            }
        }
        l.i(this$0.TAG, "sendMessage " + msgInfo.id() + ", resend=" + z16);
    }

    public final void A(boolean z16) {
        this.isLoadingHistory = z16;
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public boolean a(@NotNull MessageOuterClass$TimMsgBody timMsgBody, @NotNull CommonOuterClass$QQUserId sender) {
        Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
        Intrinsics.checkNotNullParameter(sender, "sender");
        return u(timMsgBody, sender, true);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public void b(@Nullable com.tencent.timi.game.tim.api.message.b listener) {
        this.isLoadingHistory = false;
        if (listener == null) {
            return;
        }
        if (this.listeners.isEmpty()) {
            V2TIMManager.getMessageManager().addAdvancedMsgListener(this.msgListener);
        }
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    @Nullable
    public com.tencent.timi.game.tim.api.message.a c(@NotNull CommonOuterClass$QQUserId userId, int type, @NotNull MessageOuterClass$MsgContent content) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(content, "content");
        if (!w()) {
            com.tencent.timi.game.ui.widget.f.c("\u7f51\u7edc\u5f02\u5e38\u65e0\u6cd5\u53d1\u9001");
            return null;
        }
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(type);
        messageOuterClass$TimMsgBody.content.set(content);
        messageOuterClass$TimMsgBody.from_user.set(userId);
        V2TIMMessage v2TIMMessage = V2TIMManager.getMessageManager().createCustomMessage(PluginBaseInfoHelper.Base64Helper.encode(messageOuterClass$TimMsgBody.toByteArray(), 2));
        Intrinsics.checkNotNullExpressionValue(v2TIMMessage, "v2TIMMessage");
        g gVar = new g(v2TIMMessage);
        x(gVar);
        return gVar;
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    @Nullable
    public com.tencent.timi.game.tim.api.message.a d(@NotNull CommonOuterClass$QQUserId userId, @NotNull MessageOuterClass$TimiEmoData emoData) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(emoData, "emoData");
        if (!xg4.l.a(emoData)) {
            com.tencent.timi.game.ui.widget.f.d(true, "\u8868\u60c5\u4fe1\u606f\u7f3a\u5931\uff0c\u53d1\u9001\u5931\u8d25\u3002");
            l.e(this.TAG, "sendTimiEmo error");
            return null;
        }
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
        MessageOuterClass$TimiEmoMsg messageOuterClass$TimiEmoMsg = messageOuterClass$MsgContent.timi_emo_msg;
        MessageOuterClass$TimiEmoMsg messageOuterClass$TimiEmoMsg2 = new MessageOuterClass$TimiEmoMsg();
        messageOuterClass$TimiEmoMsg2.msg_data.set(emoData);
        messageOuterClass$TimiEmoMsg.set(messageOuterClass$TimiEmoMsg2);
        Unit unit = Unit.INSTANCE;
        return c(userId, 89, messageOuterClass$MsgContent);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public void e(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        y((g) msg2, true);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public void f(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        V2TIMManager.getMessageManager().deleteMessageFromLocalStorage(((g) msg2).getV2TIMMessage(), new c(msg2, this));
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public boolean g(@NotNull MessageOuterClass$TimMsgBody timMsgBody, @NotNull CommonOuterClass$QQUserId sender) {
        Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
        Intrinsics.checkNotNullParameter(sender, "sender");
        return u(timMsgBody, sender, false);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    @Nullable
    public com.tencent.timi.game.tim.api.message.a h(@NotNull CommonOuterClass$QQUserId userId, @NotNull String text, @NotNull MessageOuterClass$MsgContent content) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(content, "content");
        return c(userId, 70, content);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public void i(@Nullable com.tencent.timi.game.tim.api.message.a lastMsg) {
        q(lastMsg, 20);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    @Nullable
    public com.tencent.timi.game.tim.api.message.a j(@NotNull CommonOuterClass$QQUserId userId, @NotNull String text) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(text, "text");
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
        MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent.text_msg;
        MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
        messageOuterClass$TextMsg2.text.set(text);
        messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
        Unit unit = Unit.INSTANCE;
        return c(userId, 1, messageOuterClass$MsgContent);
    }

    @Override // com.tencent.timi.game.tim.api.message.c
    public void k(@Nullable com.tencent.timi.game.tim.api.message.b listener) {
        TypeIntrinsics.asMutableCollection(this.listeners).remove(listener);
        if (this.listeners.isEmpty()) {
            V2TIMManager.getMessageManager().removeAdvancedMsgListener(this.msgListener);
        }
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    @NotNull
    public final List<com.tencent.timi.game.tim.api.message.b> t() {
        return this.listeners;
    }

    public abstract boolean v();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"pn4/b$d", "Lcom/tencent/imsdk/v2/V2TIMSendCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "", "progress", "", "onProgress", "code", "", "desc", "onError", "p0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements V2TIMSendCallback<V2TIMMessage> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f426556a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f426557b;

        d(g gVar, b bVar) {
            this.f426556a = gVar;
            this.f426557b = bVar;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable V2TIMMessage p06) {
            this.f426556a.q(MsgStatus.SUCCESS);
            List<com.tencent.timi.game.tim.api.message.b> t16 = this.f426557b.t();
            g gVar = this.f426556a;
            Iterator<T> it = t16.iterator();
            while (it.hasNext()) {
                ((com.tencent.timi.game.tim.api.message.b) it.next()).b(gVar);
            }
            l.i(this.f426557b.TAG, "sendMessage onSuccess: " + this.f426556a.id());
            this.f426557b.images.remove(this.f426556a);
            if (!this.f426557b.images.isEmpty()) {
                b bVar = this.f426557b;
                bVar.r((g) bVar.images.get(0));
                this.f426557b.images.remove(0);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int code, @Nullable String desc) {
            this.f426556a.q(MsgStatus.FAILED);
            List<com.tencent.timi.game.tim.api.message.b> t16 = this.f426557b.t();
            g gVar = this.f426556a;
            Iterator<T> it = t16.iterator();
            while (it.hasNext()) {
                ((com.tencent.timi.game.tim.api.message.b) it.next()).f(gVar, code, desc);
            }
            l.e(this.f426557b.TAG, "sendMessage error: " + code + ", " + desc);
            this.f426557b.images.remove(this.f426556a);
            if (!this.f426557b.images.isEmpty()) {
                b bVar = this.f426557b;
                bVar.r((g) bVar.images.get(0));
                this.f426557b.images.remove(0);
            }
            if (code == 10017 || code == 20012) {
                QQToast.makeText(BaseApplication.getContext(), 4, "\u4f60\u5df2\u88ab\u7981\u8a00\uff0c\u6682\u65f6\u65e0\u6cd5\u53d1\u8a00", 0).show();
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMSendCallback
        public void onProgress(int progress) {
        }
    }
}
