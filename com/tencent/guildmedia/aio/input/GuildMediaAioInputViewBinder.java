package com.tencent.guildmedia.aio.input;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guildmedia.aio.input.GuildMediaAioInputUIState;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.api.IGuildMediaChannelApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import fo0.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u0080\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0081\u0001B\u0017\u0012\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0Z\u00a2\u0006\u0004\b~\u0010\u007fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0016\u0010\u001d\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0002J\u001e\u0010*\u001a\u00020\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u001eH\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\u0012\u00103\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u000201H\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\u0010\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\fH\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020;H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\b\u0010>\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u0004H\u0002J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020\u0004H\u0002J\b\u0010F\u001a\u00020\u0004H\u0002J&\u0010L\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020J\u0012\u0006\b\u0001\u0012\u00020K0\u00010I2\u0006\u0010H\u001a\u00020GH\u0016J\u0014\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030MH\u0016J\u0010\u0010Q\u001a\u00020G2\u0006\u0010P\u001a\u00020OH\u0016J\b\u0010R\u001a\u00020\u0004H\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010\n2\u0006\u0010T\u001a\u00020SH\u0016J\u0016\u0010W\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030V0IH\u0016J\u0010\u0010X\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010Y\u001a\u00020\u0004H\u0016R\u001c\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010[0Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010r\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010qR/\u0010z\u001a\u001d\u0012\u0013\u0012\u00110t\u00a2\u0006\f\bu\u0012\b\bv\u0012\u0004\b\b(w\u0012\u0004\u0012\u00020\u00040s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010}\u001a\u0004\u0018\u00010[8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b{\u0010|\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputUIState;", "", "S1", "O1", "", GlobalUtil.DEF_STRING, "k2", "Landroid/os/Bundle;", "x1", "", "permissions", "H1", "Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputUIState$InputToast;", "state", "g2", "", "emojiCode", "y1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "isInsertAt", "B1", "show", "j2", "Lcom/tencent/aio/msgservice/j;", "resp", "J1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "W1", "La22/c;", "binding", "p1", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "N1", "r1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "Z1", "enable", "l2", "Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputUIState$ReeditMsg;", "I1", "E1", "M1", "", "delay", "d2", "Y1", "msg", "L1", "count", "F1", "Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputUIState$GuildInputHint;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/guildmedia/aio/input/GuildMediaAioInputUIState$GuildInputPanelChange;", "z1", "X1", SemanticAttributes.DbSystemValues.H2, NodeProps.VISIBLE, "w1", "q1", "isSelectMode", Constants.APK_CERTIFICATE, "i2", "P1", "u1", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "Ljava/lang/Class;", "getObserverStates", "K1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/ref/WeakReference;", "Let0/a;", "d", "Ljava/lang/ref/WeakReference;", "aioListenerRef", "e", "La22/c;", "mBinding", "Lgo0/c;", "f", "Lgo0/c;", "mGuildAtCluster", tl.h.F, "Z", "isPanelOrKeyBoardShow", "i", "Ljava/lang/String;", "mInputHintText", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mAioSelectToBottomTv", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mMultiLayout", "Lkotlin/Function1;", "Landroid/widget/EditText;", "Lkotlin/ParameterName;", "name", "editText", "D", "Lkotlin/jvm/functions/Function1;", "onSendMsg", "v1", "()Let0/a;", "aioListener", "<init>", "(Ljava/lang/ref/WeakReference;)V", "E", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAioInputViewBinder extends com.tencent.aio.base.mvvm.a<fo0.e, GuildMediaAioInputUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private View mMultiLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<EditText, Unit> onSendMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<et0.a> aioListenerRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a22.c mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go0.c mGuildAtCluster;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelOrKeyBoardShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mInputHintText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mAioSelectToBottomTv;

    public GuildMediaAioInputViewBinder(@NotNull WeakReference<et0.a> aioListenerRef) {
        Intrinsics.checkNotNullParameter(aioListenerRef, "aioListenerRef");
        this.aioListenerRef = aioListenerRef;
        this.mGuildAtCluster = new go0.c();
        this.mInputHintText = "";
        this.onSendMsg = new Function1<EditText, Unit>() { // from class: com.tencent.guildmedia.aio.input.GuildMediaAioInputViewBinder$onSendMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EditText editText) {
                invoke2(editText);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull EditText it) {
                Intrinsics.checkNotNullParameter(it, "it");
                List<e.InputSendTextIntent> a16 = com.tencent.guild.aio.util.e.f112380a.a(it);
                GuildMediaAioInputViewBinder guildMediaAioInputViewBinder = GuildMediaAioInputViewBinder.this;
                a22.c cVar = guildMediaAioInputViewBinder.mBinding;
                e.ReplyData replyData = null;
                a22.c cVar2 = null;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    cVar = null;
                }
                LinearLayout linearLayout = cVar.f25371b;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
                Long l3 = iq0.a.l(linearLayout);
                if (l3 != null) {
                    GuildMediaAioInputViewBinder guildMediaAioInputViewBinder2 = GuildMediaAioInputViewBinder.this;
                    long longValue = l3.longValue();
                    a22.c cVar3 = guildMediaAioInputViewBinder2.mBinding;
                    if (cVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        cVar3 = null;
                    }
                    String obj = cVar3.f25381l.getText().toString();
                    a22.c cVar4 = guildMediaAioInputViewBinder2.mBinding;
                    if (cVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        cVar2 = cVar4;
                    }
                    replyData = new e.ReplyData(longValue, obj, cVar2.f25382m.getText().toString());
                }
                guildMediaAioInputViewBinder.sendIntent(new e.InputSendMultiTextIntent(a16, replyData));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(GuildMediaAioInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        et0.a v16 = this$0.v1();
        if (v16 != null) {
            v16.be(this$0.isPanelOrKeyBoardShow);
        }
    }

    private final void B1(final com.tencent.aio.data.msglist.a msgItem, boolean isInsertAt) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        j2(true);
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        cVar.f25380k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.input.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAioInputViewBinder.C1(GuildMediaAioInputViewBinder.this, view);
            }
        });
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar3 = null;
        }
        p1(msgItem, cVar3);
        a22.c cVar4 = this.mBinding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar4 = null;
        }
        cVar4.f25371b.setTag(R.id.f73243t1, Long.valueOf(guildMsgItem.getMsgRecord().msgId));
        a22.c cVar5 = this.mBinding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar5;
        }
        cVar2.f25371b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.input.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAioInputViewBinder.D1(GuildMediaAioInputViewBinder.this, msgItem, view);
            }
        });
        if (isInsertAt) {
            W1(guildMsgItem);
        }
        d2(300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C1(GuildMediaAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j2(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(GuildMediaAioInputViewBinder this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new e.c((GuildMsgItem) msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E1(GuildMsgItem msgItem) {
        W1(msgItem);
        e2(this, 0L, 1, null);
    }

    private final void F1(int count) {
        String string = getMContext().getString(R.string.f139520bh);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026ild_aio_select_msg_count)");
        TextView textView = this.mAioSelectToBottomTv;
        if (textView != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAioSelectToBottomTv");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    private final void G1(boolean isSelectMode) {
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputViewBinder", "[handleMultiSelectModeChanged] isSelectMode = " + isSelectMode);
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        vs0.a.p(cVar.f25373d, !isSelectMode);
        i2(isSelectMode);
        F1(1);
        et0.a v16 = v1();
        if (v16 != null) {
            v16.g(isSelectMode);
        }
    }

    private final void H1(int permissions) {
        String str;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null) {
            str = com.tencent.guild.aio.util.a.g(g16);
        } else {
            str = null;
        }
        if (!companion.g(permissions, str)) {
            Logger.f235387a.d().i("GuildMediaAioInputViewBinder", 1, "[handlePermissionChange] clearEditContent");
            this.isPanelOrKeyBoardShow = false;
            q1();
            h2();
        }
    }

    private final void I1(GuildMediaAioInputUIState.ReeditMsg state) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int i3 = 0;
        l2(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        ArrayList<MsgElement> arrayList = state.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "state.msgRecord.elements");
        a22.c cVar2 = this.mBinding;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar2 = null;
        }
        LinearLayout linearLayout = cVar2.f25371b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        guildDraftUtil.c(arrayList, linearLayout, guildAIOInputEditText);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            z16 = iGPSService.isGuest(state.getMsgRecord().guildId);
        } else {
            z16 = true;
        }
        l2(!z16);
        guildAIOInputEditText.requestFocus();
        Editable text = guildAIOInputEditText.getText();
        if (text != null) {
            i3 = text.length();
        }
        guildAIOInputEditText.setSelection(i3);
        e2(this, 0L, 1, null);
        sendIntent(new e.ReeditRecallMsg(state.getMsgRecord()));
    }

    private final void J1(com.tencent.aio.msgservice.j<String> resp) {
        String string;
        boolean z16;
        if (resp.c() == 0) {
            return;
        }
        int c16 = resp.c();
        if (c16 != 100308) {
            switch (c16) {
                case BusinessInfoCheckUpdateItem.UIAPPID_PUBLIC_ACCOUNT /* 104000 */:
                case BusinessInfoCheckUpdateItem.UIAPPID_PUBLIC_ACCOUNT_MESSAGE_POP /* 104001 */:
                    string = getMContext().getString(R.string.f158341pc);
                    Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026sitor_no_permission_tips)");
                    break;
                case 104002:
                    string = getMContext().getString(R.string.f158291p8);
                    Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026visitor_interactive_tips)");
                    break;
                case 104003:
                    string = getMContext().getString(R.string.f158271p6);
                    Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026_visitor_freq_limit_tips)");
                    break;
                default:
                    String b16 = resp.b();
                    if (b16 != null && b16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        string = getMContext().getString(R.string.f139240aq);
                        Intrinsics.checkNotNullExpressionValue(string, "{\n                    mC\u2026s_fail)\n                }");
                        break;
                    } else {
                        string = resp.b();
                        Intrinsics.checkNotNull(string);
                        break;
                    }
                    break;
            }
        } else {
            string = getMContext().getString(R.string.f156871ld);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026d_slow_mode_exceed_limit)");
        }
        if (!TextUtils.isEmpty(string)) {
            QQToast.makeText(BaseApplication.getContext(), 1, string, 1).show();
        }
    }

    private final void L1(String msg2) {
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        cVar.f25375f.setText(msg2);
    }

    private final void M1() {
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        inputMethodManager.hideSoftInputFromWindow(cVar.f25375f.getWindowToken(), 0);
    }

    private final void N1(AIOParam aioParam) {
        go0.c cVar = this.mGuildAtCluster;
        a22.c cVar2 = this.mBinding;
        a22.c cVar3 = null;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar2 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar2.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        a22.c cVar4 = this.mBinding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar4 = null;
        }
        LinearLayout linearLayout = cVar4.f25373d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.guildAioInputBar");
        a22.c cVar5 = this.mBinding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar3 = cVar5;
        }
        Context context = cVar3.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        go0.c.i(cVar, guildAIOInputEditText, linearLayout, context, aioParam, null, null, 48, null);
        r1(aioParam);
    }

    private final void O1() {
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        vs0.a.o(cVar.f25375f, "em_aio_input_box", null, 4, null);
        HashMap hashMap = new HashMap();
        hashMap.put("aio_message_type", 1);
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar3 = null;
        }
        vs0.a.n(cVar3.f25376g, "em_aio_send", hashMap);
        a22.c cVar4 = this.mBinding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar4;
        }
        vs0.a.l("imp", cVar2.f25376g, hashMap);
    }

    private final void P1() {
        a22.c cVar = this.mBinding;
        View view = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        View inflate = cVar.f25383n.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "mBinding.vsMultiLayout.inflate()");
        this.mMultiLayout = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.l9j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mMultiLayout.findViewByI\u2026.aio_select_to_buttom_tv)");
        this.mAioSelectToBottomTv = (TextView) findViewById;
        View view2 = this.mMultiLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
            view2 = null;
        }
        view2.findViewById(R.id.vyd).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.input.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildMediaAioInputViewBinder.Q1(GuildMediaAioInputViewBinder.this, view3);
            }
        });
        View view3 = this.mMultiLayout;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
        } else {
            view = view3;
        }
        view.findViewById(R.id.vye).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.input.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildMediaAioInputViewBinder.R1(GuildMediaAioInputViewBinder.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(GuildMediaAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.h.f400143d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(GuildMediaAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.j.f400145d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void S1() {
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildAIOInputEditText.setEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 16, 0, 2, null));
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar3 = null;
        }
        cVar3.f25375f.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.guildmedia.aio.input.g
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean T1;
                T1 = GuildMediaAioInputViewBinder.T1(GuildMediaAioInputViewBinder.this, view, i3, keyEvent);
                return T1;
            }
        });
        a22.c cVar4 = this.mBinding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar4 = null;
        }
        cVar4.f25376g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.input.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaAioInputViewBinder.U1(GuildMediaAioInputViewBinder.this, view);
            }
        });
        a22.c cVar5 = this.mBinding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar5 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = cVar5.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "mBinding.guildAioInputEdittext");
        guildAIOInputEditText2.addTextChangedListener(new b());
        a22.c cVar6 = this.mBinding;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar6 = null;
        }
        cVar6.f25375f.setFocusableInTouchMode(true);
        sendIntent(e.i.f400144d);
        com.tencent.guild.aio.util.g gVar = com.tencent.guild.aio.util.g.f112400a;
        a22.c cVar7 = this.mBinding;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar7;
        }
        GuildAIOInputEditText guildAIOInputEditText3 = cVar2.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText3, "mBinding.guildAioInputEdittext");
        gVar.c(guildAIOInputEditText3, new Function0<Unit>() { // from class: com.tencent.guildmedia.aio.input.GuildMediaAioInputViewBinder$initView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a22.c cVar8 = GuildMediaAioInputViewBinder.this.mBinding;
                if (cVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    cVar8 = null;
                }
                cVar8.f25376g.performClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T1(GuildMediaAioInputViewBinder this$0, View view, int i3, KeyEvent keyEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 67 && keyEvent.getAction() == 0) {
            a22.c cVar = this$0.mBinding;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar = null;
            }
            Editable text = cVar.f25375f.getText();
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this$0.j2(false);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(final GuildMediaAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<EditText, Unit> function1 = this$0.onSendMsg;
        a22.c cVar = this$0.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        function1.invoke(guildAIOInputEditText);
        a22.c cVar3 = this$0.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar3;
        }
        cVar2.f25373d.postDelayed(new Runnable() { // from class: com.tencent.guildmedia.aio.input.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaAioInputViewBinder.V1(GuildMediaAioInputViewBinder.this);
            }
        }, 500L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(GuildMediaAioInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.d.f400138d);
    }

    private final void W1(GuildMsgItem msgItem) {
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        String u16 = iq0.a.u(str, str2);
        com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        Context context = cVar.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar3;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar2.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
    }

    private final boolean X1() {
        if (!this.isPanelOrKeyBoardShow) {
            a22.c cVar = this.mBinding;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar = null;
            }
            if (cVar.f25371b.getVisibility() != 0) {
                return false;
            }
        }
        return true;
    }

    private final void Y1() {
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        cVar.f25375f.requestFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar3;
        }
        inputMethodManager.showSoftInput(cVar2.f25375f, 0);
    }

    private final void Z1(ArrayList<MsgElement> msgElements, AIOParam aioParam) {
        AppInterface appInterface;
        boolean z16;
        boolean isBlank;
        a22.c cVar = this.mBinding;
        IRuntimeService iRuntimeService = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int i3 = 0;
        l2(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        a22.c cVar2 = this.mBinding;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar2 = null;
        }
        LinearLayout linearLayout = cVar2.f25371b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        guildDraftUtil.c(msgElements, linearLayout, guildAIOInputEditText);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        boolean z17 = true;
        if (iGPSService != null) {
            z16 = iGPSService.isGuest(com.tencent.guild.aio.util.a.g(aioParam));
        } else {
            z16 = true;
        }
        l2(!z16);
        Editable text = guildAIOInputEditText.getText();
        if (text != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(text);
            if (!isBlank) {
                z17 = false;
            }
        }
        if (!z17) {
            Editable text2 = guildAIOInputEditText.getText();
            if (text2 != null) {
                i3 = text2.length();
            }
            guildAIOInputEditText.setSelection(i3);
            h2();
        }
    }

    private final void a2(final GuildMediaAioInputUIState.GuildInputHint state) {
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String string = getMContext().getResources().getString(R.string.f139210an);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026ing.guild_aio_input_hint)");
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar3 = null;
        }
        int measuredWidth = cVar3.f25375f.getMeasuredWidth();
        if (measuredWidth <= 0) {
            a22.c cVar4 = this.mBinding;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                cVar2 = cVar4;
            }
            cVar2.f25375f.post(new Runnable() { // from class: com.tencent.guildmedia.aio.input.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAioInputViewBinder.c2(GuildMediaAioInputViewBinder.this, state);
                }
            });
        }
        this.mInputHintText = UIUtil.q(UIUtil.f112434a, guildAIOInputEditText, measuredWidth, string, state.getChannelName(), null, 16, null);
        h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(GuildMediaAioInputViewBinder this$0, GuildMediaAioInputUIState.GuildInputHint state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.a2(state);
    }

    private final void d2(long delay) {
        if (delay > 0) {
            a22.c cVar = this.mBinding;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar = null;
            }
            cVar.f25375f.postDelayed(new Runnable() { // from class: com.tencent.guildmedia.aio.input.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAioInputViewBinder.f2(GuildMediaAioInputViewBinder.this);
                }
            }, delay);
            return;
        }
        Y1();
    }

    static /* synthetic */ void e2(GuildMediaAioInputViewBinder guildMediaAioInputViewBinder, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        guildMediaAioInputViewBinder.d2(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(GuildMediaAioInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y1();
    }

    private final void g2(GuildMediaAioInputUIState.InputToast state) {
        if (state.getMsg() instanceof Integer) {
            QQToast.makeText(getMContext(), state.getIconType(), ((Number) state.getMsg()).intValue(), 0).show();
        } else if (state.getMsg() instanceof CharSequence) {
            QQToast.makeText(getMContext(), state.getIconType(), (CharSequence) state.getMsg(), 0).show();
        }
    }

    private final void h2() {
        boolean X1 = X1();
        a22.c cVar = null;
        if (X1) {
            a22.c cVar2 = this.mBinding;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar2 = null;
            }
            cVar2.f25374e.setVisibility(0);
            a22.c cVar3 = this.mBinding;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar3 = null;
            }
            if (cVar3.f25378i.getVisibility() != 0) {
                a22.c cVar4 = this.mBinding;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    cVar4 = null;
                }
                cVar4.f25378i.setVisibility(0);
                a22.c cVar5 = this.mBinding;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    cVar5 = null;
                }
                vs0.a.m("imp", cVar5.f25376g, null, 4, null);
            }
            a22.c cVar6 = this.mBinding;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar6 = null;
            }
            cVar6.f25375f.setHint(this.mInputHintText);
        } else {
            a22.c cVar7 = this.mBinding;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar7 = null;
            }
            cVar7.f25374e.setVisibility(4);
            a22.c cVar8 = this.mBinding;
            if (cVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar8 = null;
            }
            cVar8.f25378i.setVisibility(8);
        }
        a22.c cVar9 = this.mBinding;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar9 = null;
        }
        cVar9.f25375f.setCursorVisible(this.isPanelOrKeyBoardShow);
        a22.c cVar10 = this.mBinding;
        if (cVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar = cVar10;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        et0.a v16 = v1();
        if (v16 != null) {
            v16.b7(this.isPanelOrKeyBoardShow, X1);
        }
        et0.a v17 = v1();
        if (v17 != null) {
            v17.Ea(guildAIOInputEditText);
        }
    }

    private final void i2(boolean show) {
        if (this.mMultiLayout == null) {
            P1();
        }
        View view = this.mMultiLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMultiLayout");
            view = null;
        }
        vs0.a.p(view, show);
    }

    private final void j2(boolean show) {
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        vs0.a.p(cVar.f25371b, show);
        h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(boolean empty) {
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        vs0.a.p(cVar.f25376g, !empty);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(boolean enable) {
        this.mGuildAtCluster.l(enable);
    }

    private final void p1(com.tencent.aio.data.msglist.a msgItem, a22.c binding) {
        List filterNotNull;
        binding.f25381l.setText(iq0.a.t(msgItem) + MsgSummary.STR_COLON);
        binding.f25382m.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        ArrayList<MsgElement> elements = ((GuildMsgItem) msgItem).getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        binding.f25382m.setText(iq0.a.p(arrayList, true, false, 4, null));
    }

    private final void q1() {
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        cVar.f25375f.setText("");
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar3;
        }
        cVar2.f25371b.setVisibility(8);
    }

    private final void r1(AIOParam aioParam) {
        int a16 = fo0.h.a(com.tencent.guild.aio.util.a.g(aioParam), com.tencent.guild.aio.util.a.b(aioParam));
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        if (((Unit) com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(!companion.g(a16, com.tencent.guild.aio.util.a.g(aioParam))), new Function0<Unit>() { // from class: com.tencent.guildmedia.aio.input.GuildMediaAioInputViewBinder$configAtWatcher$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildMediaAioInputViewBinder.this.l2(false);
            }
        })) == null) {
            l2(!companion.r(a16));
        }
    }

    private final void u1() {
        this.mGuildAtCluster.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final et0.a v1() {
        return this.aioListenerRef.get();
    }

    private final void w1(boolean visible) {
        int i3;
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        FrameLayout root = cVar.getRoot();
        if (visible) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        root.setVisibility(i3);
    }

    private final Bundle x1() {
        long j3;
        a22.c cVar = this.mBinding;
        a22.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        Editable editableText = cVar.f25375f.getEditableText();
        a22.c cVar3 = this.mBinding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar3 = null;
        }
        String valueOf = String.valueOf(cVar3.f25375f.getText());
        a22.c cVar4 = this.mBinding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar4 = null;
        }
        String obj = cVar4.f25381l.getText().toString();
        a22.c cVar5 = this.mBinding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar5 = null;
        }
        String obj2 = cVar5.f25382m.getText().toString();
        a22.c cVar6 = this.mBinding;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cVar2 = cVar6;
        }
        LinearLayout linearLayout = cVar2.f25371b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        Long l3 = iq0.a.l(linearLayout);
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR;
        }
        Bundle bundle = new Bundle();
        bundle.putString("guild_draft_input_text", valueOf);
        bundle.putCharSequence("guild_draft_input_editable_text", editableText);
        bundle.putLong("guild_draft_input_reply_msg_id", j3);
        bundle.putString("guild_draft_input_reply_nick", obj);
        bundle.putString("guild_draft_input_reply_content", obj2);
        return bundle;
    }

    private final void y1(String emojiCode) {
        a22.c cVar = this.mBinding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int selectionStart = guildAIOInputEditText.getSelectionStart();
        int selectionEnd = guildAIOInputEditText.getSelectionEnd();
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
            guildAIOInputEditText.getEditableText().replace(selectionStart, selectionEnd, emojiCode);
            guildAIOInputEditText.requestFocus();
        }
    }

    private final void z1(GuildMediaAioInputUIState.GuildInputPanelChange state) {
        boolean z16;
        if (!state.getPanelShow() && !state.getKeyboardShow()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isPanelOrKeyBoardShow = z16;
        if (!z16) {
            h2();
            a22.c cVar = this.mBinding;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                cVar = null;
            }
            cVar.f25374e.postDelayed(new Runnable() { // from class: com.tencent.guildmedia.aio.input.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAioInputViewBinder.A1(GuildMediaAioInputViewBinder.this);
                }
            }, 1000L);
            return;
        }
        h2();
        et0.a v16 = v1();
        if (v16 != null) {
            v16.be(this.isPanelOrKeyBoardShow);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildMediaAioInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildMediaAioInputUIState.GuildClearEditInput) {
            q1();
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildReplaceInputEmotion) {
            y1(((GuildMediaAioInputUIState.GuildReplaceInputEmotion) state).getEmotionCode());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildInputReplyMsg) {
            GuildMediaAioInputUIState.GuildInputReplyMsg guildInputReplyMsg = (GuildMediaAioInputUIState.GuildInputReplyMsg) state;
            B1(guildInputReplyMsg.getMsg(), guildInputReplyMsg.getIsInsertAt());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildInputPanelChange) {
            z1((GuildMediaAioInputUIState.GuildInputPanelChange) state);
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildMultiSelectState) {
            G1(((GuildMediaAioInputUIState.GuildMultiSelectState) state).getShow());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildInputHint) {
            a2((GuildMediaAioInputUIState.GuildInputHint) state);
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.MultiSelectCountChanged) {
            F1(((GuildMediaAioInputUIState.MultiSelectCountChanged) state).getCount());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildSendResp) {
            J1(((GuildMediaAioInputUIState.GuildSendResp) state).a());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.UpdateInputText) {
            L1(((GuildMediaAioInputUIState.UpdateInputText) state).getMsg());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuideHideKeyboard) {
            M1();
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildShowKeyboard) {
            e2(this, 0L, 1, null);
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.GuildMediaLongClickAvatar) {
            E1(((GuildMediaAioInputUIState.GuildMediaLongClickAvatar) state).getMsgItem());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.ReeditMsg) {
            I1((GuildMediaAioInputUIState.ReeditMsg) state);
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.RecoverDraft) {
            GuildMediaAioInputUIState.RecoverDraft recoverDraft = (GuildMediaAioInputUIState.RecoverDraft) state;
            Z1(recoverDraft.b(), recoverDraft.getAioParam());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.InitAtCluster) {
            N1(((GuildMediaAioInputUIState.InitAtCluster) state).getAioParam());
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.InputToast) {
            g2((GuildMediaAioInputUIState.InputToast) state);
            return;
        }
        if (state instanceof GuildMediaAioInputUIState.SendSuccessUIState) {
            h2();
        } else if (state instanceof GuildMediaAioInputUIState.SetInputBarVisible) {
            w1(((GuildMediaAioInputUIState.SetInputBarVisible) state).getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
        } else if (state instanceof GuildMediaAioInputUIState.GuildHandlerPermissionsChange) {
            H1(((GuildMediaAioInputUIState.GuildHandlerPermissionsChange) state).getPermissions());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        S1();
        O1();
        if (((IGuildMediaChannelApi) QRoute.api(IGuildMediaChannelApi.class)).curChannelHasInputPermission()) {
            sendIntent(e.m.f400153d);
        }
        sendIntent(e.f.f400141d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof t.a) {
            M1();
            return x1();
        }
        return super.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildMediaAioInputUIState>> getObserverStates() {
        List<Class<? extends GuildMediaAioInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildMediaAioInputUIState.GuildMultiSelectState.class, GuildMediaAioInputUIState.UpdateInputText.class, GuildMediaAioInputUIState.GuildInputHint.class, GuildMediaAioInputUIState.InitAtCluster.class, GuildMediaAioInputUIState.RecoverDraft.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new zs0.b());
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        a22.c g16 = a22.c.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        FrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        u1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.e, GuildMediaAioInputUIState> getViewModel() {
        return new GuildMediaAioInputViewModel();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            et0.a v16;
            boolean isBlank;
            GuildMediaAioInputViewBinder guildMediaAioInputViewBinder = GuildMediaAioInputViewBinder.this;
            if (s16 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(s16);
                if (!isBlank) {
                    z16 = false;
                    guildMediaAioInputViewBinder.k2(z16);
                    v16 = GuildMediaAioInputViewBinder.this.v1();
                    if (v16 == null) {
                        a22.c cVar = GuildMediaAioInputViewBinder.this.mBinding;
                        if (cVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                            cVar = null;
                        }
                        GuildAIOInputEditText guildAIOInputEditText = cVar.f25375f;
                        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
                        v16.Ea(guildAIOInputEditText);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            guildMediaAioInputViewBinder.k2(z16);
            v16 = GuildMediaAioInputViewBinder.this.v1();
            if (v16 == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
