package com.tencent.timi.game.liveroom.impl.room.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.widget.chat.data.DressUpBubble;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.timi.game.liveroom.impl.room.anchor.UserSelfSendMsgEvent;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TextMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0003\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u001d\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b7\u00108J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0017\u001a\u00020\nH\u0004J\u0012\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010,\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010'\u00a8\u0006;"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout;", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout;", "", "com/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout$b", "h0", "()Lcom/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout$b;", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "msgBody", "", "text", "", "m0", "toastContent", "Z", "Landroid/view/View;", "view", ReportConstant.COSTREPORT_PREFIX, "", "isManually", "l0", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "k0", "n0", "recover", "i0", "j0", "", "roomId", "d0", "Landroid/widget/EditText;", "c0", ExifInterface.LATITUDE_SOUTH, "J", "g0", "()J", "setRoomId", "(J)V", "T", "Ljava/lang/String;", "f0", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "platform", "Lcom/tencent/mobileqq/widget/QQToast;", "U", "Lcom/tencent/mobileqq/widget/QQToast;", "qqToast", "V", "lastToastContent", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "W", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class AnchorInputLayout extends LiveInputLayout {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: S, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private String platform;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private QQToast qqToast;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String lastToastContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\b\u001a\u00020\u00072\u001e\u0010\u0006\u001a\u001a\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0002j\f\u0012\b\u0012\u00060\u0003R\u00020\u0004`\u0005H\u0002J \u0010\t\u001a\u001a\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0002j\f\u0012\b\u0012\u00060\u0003R\u00020\u0004`\u0005H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "extData", "", "b", "a", "", "TAG", "Ljava/lang/String;", "", "TIMI_LIVE_DATA_ID", "I", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(ArrayList<LiveMessageData.ExtData> extData) {
            byte[] bytes;
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            LiveLoginInfo u16 = cVar.u();
            if (u16 != null) {
                long p16 = cVar.p();
                com.tencent.timi.game.liveroom.impl.room.util.f fVar = com.tencent.timi.game.liveroom.impl.room.util.f.f378635a;
                if (fVar.g(p16, u16.q())) {
                    String str = "TOP_THREE_CROWN_UIN_" + u16.q() + "_" + p16;
                    if (!rm4.a.b(str, false)) {
                        rm4.a.h(str, true);
                    }
                    LiveMessageData.ExtData extData2 = new LiveMessageData.ExtData();
                    extData2.mId = 100010;
                    byte[] bytes2 = String.valueOf(fVar.e(p16, u16.q())).getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    extData2.mValue = bytes2;
                    extData.add(extData2);
                }
                lk4.c cVar2 = lk4.c.f414972a;
                if (cVar2.m()) {
                    LiveMessageData.ExtData extData3 = new LiveMessageData.ExtData();
                    extData3.mId = BusinessInfoCheckUpdateItem.UIAPPID_SECOND_SUIT;
                    if (cVar2.m()) {
                        bytes = "1".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    } else {
                        bytes = "0".getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    }
                    extData3.mValue = bytes;
                    extData.add(extData3);
                }
            }
        }

        @JvmStatic
        @NotNull
        public final ArrayList<LiveMessageData.ExtData> a() {
            DressUpBubble dressUpBubble;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Input|AnchorInputLayout", "buildExtData");
            com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
            long p16 = cVar.p();
            long G = cVar.G();
            QQLiveMedalServiceSupplier qQLiveMedalServiceSupplier = QQLiveMedalServiceSupplier.f377955a;
            com.tencent.mobileqq.qqlive.widget.chat.data.b b16 = qQLiveMedalServiceSupplier.a().b(G, p16, cVar.q());
            qQLiveMedalServiceSupplier.a().a(G, p16, cVar.q(), null);
            oz0.a aVar = new oz0.a();
            if (b16 != null) {
                List<sr4.g> list = b16.f273762g;
                Intrinsics.checkNotNullExpressionValue(list, "userMedal.medalInfoNewList");
                Object[] array = list.toArray(new sr4.g[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                aVar.f424558b = (sr4.g[]) array;
            }
            ArrayList<LiveMessageData.ExtData> arrayList = new ArrayList<>();
            LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
            extData.mId = 230;
            byte[] bArr = new byte[aVar.getSerializedSize()];
            extData.mValue = bArr;
            aVar.writeTo(CodedOutputByteBufferNano.newInstance(bArr));
            arrayList.add(extData);
            pq4.c cVar2 = null;
            if (b16 != null) {
                dressUpBubble = b16.f273760e;
            } else {
                dressUpBubble = null;
            }
            if (dressUpBubble != null) {
                String bubbleInfo = b16.f273760e.toJsonStr();
                companion.i("Input|AnchorInputLayout", "sendMsgReally", "qqChatBubble=" + b16.f273760e + ", json bubbleInfo=" + bubbleInfo);
                Intrinsics.checkNotNullExpressionValue(bubbleInfo, "bubbleInfo");
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                byte[] bytes = bubbleInfo.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                LiveMessageData.ExtData extData2 = new LiveMessageData.ExtData();
                extData2.mId = 299;
                extData2.mValue = bytes;
                arrayList.add(extData2);
            }
            if (b16 != null) {
                cVar2 = b16.f273761f;
            }
            if (cVar2 != null) {
                byte[] bArr2 = new byte[b16.f273761f.getSerializedSize()];
                b16.f273761f.writeTo(CodedOutputByteBufferNano.newInstance(bArr2));
                LiveMessageData.ExtData extData3 = new LiveMessageData.ExtData();
                extData3.mId = 298;
                extData3.mValue = bArr2;
                arrayList.add(extData3);
            }
            AnchorInputLayout.INSTANCE.b(arrayList);
            return arrayList;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout$b", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$b;", "", "text", "", "b", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements LiveInputLayout.b {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout.b
        public void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            AnchorInputLayout.this.k0(content, text, true);
        }

        @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout.b
        public void b(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            AnchorInputLayout.this.l0(text, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout$c", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "", "isLocal", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "onIllegalMsg", "msg", "onUserForbid", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IQQLiveMessageCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.w("Input|AnchorInputLayout", "sendMessage onFail, errCode:" + errCode + ", errMsg:" + errMsg);
            AnchorInputLayout anchorInputLayout = AnchorInputLayout.this;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u7801");
            sb5.append(errCode);
            anchorInputLayout.Z(sb5.toString());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onIllegalMsg() {
            AegisLogger.INSTANCE.w("Input|AnchorInputLayout", "sendMessage onIllegalMsg");
            AnchorInputLayout.this.Z("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u780110003");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onSuccess(boolean isLocal) {
            AegisLogger.INSTANCE.i("Input|AnchorInputLayout", "sendMessage onSuccess, isLocal:" + isLocal);
            AnchorInputLayout.this.l();
            if (!isLocal) {
                SimpleEventBus.getInstance().dispatchEvent(new UserSelfSendMsgEvent(AnchorInputLayout.this.getRoomId()));
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onUserForbid(@Nullable String msg2) {
            AegisLogger.INSTANCE.w("Input|AnchorInputLayout", "sendMessage onUserForbid, msg:" + msg2);
            AnchorInputLayout.this.Z("\u8bc4\u8bba\u53d1\u8868\u5931\u8d25\uff0c\u9519\u8bef\u780110002");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorInputLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String toastContent) {
        if (this.qqToast == null) {
            QQToast qQToast = new QQToast(getContext());
            qQToast.setToastIcon(QQToast.getIconRes(1));
            qQToast.setType(1);
            qQToast.setDuration(0);
            this.qqToast = qQToast;
        }
        QQToast qQToast2 = this.qqToast;
        if (qQToast2 != null) {
            if (!qQToast2.isShowing() || !Intrinsics.areEqual(toastContent, this.lastToastContent)) {
                this.lastToastContent = toastContent;
                qQToast2.setToastMsg(toastContent);
                qQToast2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map e0(AnchorInputLayout this$0, String str) {
        Object obj;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[4];
        String str2 = "1";
        if (this$0.Q()) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[0] = TuplesKt.to("qqlive_is_at", obj);
        if (!this$0.R()) {
            str2 = "0";
        }
        pairArr[1] = TuplesKt.to("qqlive_is_with_sticker", str2);
        pairArr[2] = TuplesKt.to("qqlive_text_content", this$0.t());
        pairArr[3] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_inputbar");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final b h0() {
        return new b();
    }

    private final void m0(MessageOuterClass$TimMsgBody msgBody, String text) {
        String str;
        uq4.a[] aVarArr;
        boolean z16;
        CharSequence trim;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Input|AnchorInputLayout", "sendMsgReally:" + text);
        uq4.a aVar = null;
        if (text != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) text);
            str = trim.toString();
        } else {
            str = null;
        }
        boolean z17 = false;
        if (TextUtils.isEmpty(str)) {
            QQToast.makeText(getContext(), 1, R.string.f210705iu, 0).show();
            companion.e("Input|AnchorInputLayout", "sendMsgReally", "message text is empty, invalid text!");
            return;
        }
        ArrayList<LiveMessageData.ExtData> a16 = INSTANCE.a();
        LiveMessageData.ExtData extData = new LiveMessageData.ExtData();
        extData.mId = 100001;
        extData.mValue = PluginBaseInfoHelper.Base64Helper.encode(msgBody.toByteArray(), 2);
        a16.add(extData);
        uq4.c cVar = BusConfigHelper.f378723a.j().get(Long.valueOf(this.roomId));
        if (cVar != null && (aVarArr = cVar.f439826a) != null) {
            int length = aVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                uq4.a aVar2 = aVarArr[i3];
                if (aVar2.f439822a == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    aVar = aVar2;
                    break;
                }
                i3++;
            }
            if (aVar != null) {
                z17 = aVar.f439823b;
            }
        }
        if (z17) {
            LiveLoginInfo u16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.u();
            if (u16 != null) {
                SimpleEventBus.getInstance().dispatchEvent(new LiveLocalMsg(this.roomId, text, u16));
                l();
                return;
            }
            return;
        }
        com.tencent.timi.game.liveroom.impl.room.message.i.f378067a.b(this.roomId, text, a16, new c());
    }

    @Nullable
    public EditText c0() {
        return C();
    }

    public final void d0(long roomId) {
        Map mutableMapOf;
        ConcurrentHashMap a16 = com.tencent.timi.game.liveroom.impl.room.more.d.a(roomId);
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        aVar.b(this, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, a16);
        View H = H();
        if (H != null) {
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.b((ug4.a) b16, H, false, null, "em_qqlive_send_message", null, 22, null);
            VideoReport.setEventDynamicParams(H, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.input.a
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map e06;
                    e06 = AnchorInputLayout.e0(AnchorInputLayout.this, str);
                    return e06;
                }
            });
        }
        View x16 = x();
        if (x16 != null) {
            mm4.a b17 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_qqlive_inputbar"));
            a.C11346a.a((ug4.a) b17, x16, false, null, "em_qqlive_emoji_entrance", mutableMapOf, 6, null);
        }
    }

    @Nullable
    /* renamed from: f0, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: g0, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k0(@NotNull MessageOuterClass$MsgContent content, @NotNull String text, boolean isManually) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(text, "text");
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(70);
        messageOuterClass$TimMsgBody.content.set(content);
        m0(messageOuterClass$TimMsgBody, text);
        if (isManually) {
            n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l0(@NotNull String text, boolean isManually) {
        Intrinsics.checkNotNullParameter(text, "text");
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
        messageOuterClass$TimMsgBody.msg_type.set(1);
        MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
        MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent2.text_msg;
        MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
        messageOuterClass$TextMsg2.text.set(text);
        messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
        messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
        m0(messageOuterClass$TimMsgBody, text);
        if (isManually) {
            n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n0() {
        l();
        setState(1);
    }

    @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout
    protected void s(@NotNull View view) {
        Map<String, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("clck", view, new LinkedHashMap());
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_WAY, "2"), TuplesKt.to(DTParamKey.REPORT_KEY_SUBMIT_TYPE, DTConstants.KeyBoardAction.ACTION_SEND));
        aVar.reportEvent(DTEventKey.SUBMIT, view, mutableMapOf);
    }

    public final void setPlatform(@Nullable String str) {
        this.platform = str;
    }

    public final void setRoomId(long j3) {
        this.roomId = j3;
    }

    public /* synthetic */ AnchorInputLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorInputLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lastToastContent = "";
        X(h0());
    }

    public void j0() {
    }

    public void i0(boolean recover) {
    }
}
