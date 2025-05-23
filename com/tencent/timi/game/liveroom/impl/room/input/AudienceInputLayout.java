package com.tencent.timi.game.liveroom.impl.room.input;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$MsgContent;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001_B\u001d\b\u0007\u0012\u0006\u0010Z\u001a\u00020Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u00a2\u0006\u0004\b]\u0010^J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0002J\u0010\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u000f0\u000fH\u0002J\u0010\u0010\u0012\u001a\n \r*\u0004\u0018\u00010\u00110\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0014\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J&\u0010\u001b\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!J\b\u0010%\u001a\u00020$H\u0014J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020&H\u0014J \u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020\u0006H\u0016J2\u00104\u001a\u00020\u00062\u0006\u00100\u001a\u00020/2\"\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000201j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`2J\u0012\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000105H\u0014R\u0016\u0010:\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010?\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u001b\u0010O\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010TR\u001b\u0010X\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010C\u001a\u0004\bV\u0010W\u00a8\u0006`"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/AudienceInputLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/input/AnchorInputLayout;", "", "message", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "", "b1", "", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "barrageDataSet", ICustomDataEditor.NUMBER_PARAM_1, "Landroid/view/View;", "kotlin.jvm.PlatformType", "U0", "Landroidx/recyclerview/widget/RecyclerView;", "T0", "Landroid/widget/TextView;", "W0", "m1", "l1", "barrageData", "o1", "q1", "Lcom/tencent/timi/game/liveroom/impl/room/input/w;", "sendAction", "R0", "S0", "g1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "X0", "Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", "inputViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "setInputViewModel", "", "E", "", "fromFloatWindow", "i0", "j0", "text", "isManually", "l0", "k0", "Y", "", "roomId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "L0", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "a0", "Z", "isRoomEntered", "b0", "isFromFloatWindow", "c0", "Ljava/lang/String;", "qqLiveSendMessage", "d0", "Lcom/tencent/timi/game/liveroom/impl/room/input/QQLiveAudienceBarrageViewModel;", "e0", "Lkotlin/Lazy;", "O0", "()Landroid/view/View;", "barrageModeSwitchContainer", "Landroid/widget/CheckedTextView;", "f0", "N0", "()Landroid/widget/CheckedTextView;", "barrageModeSwitch", "g0", "P0", "()Landroidx/recyclerview/widget/RecyclerView;", "barrageRecyclerView", "Lcom/tencent/timi/game/liveroom/impl/room/input/t;", "h0", "Lcom/tencent/timi/game/liveroom/impl/room/input/t;", "barrageRVAdapter", "Landroid/widget/CheckedTextView;", "ignorePayConfirmDialogCheckbox", "Q0", "()Landroid/widget/TextView;", "inputMarqueeHintTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AudienceInputLayout extends AnchorInputLayout {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isRoomEntered;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isFromFloatWindow;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String qqLiveSendMessage;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveAudienceBarrageViewModel inputViewModel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy barrageModeSwitchContainer;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy barrageModeSwitch;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy barrageRecyclerView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t barrageRVAdapter;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CheckedTextView ignorePayConfirmDialogCheckbox;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy inputMarqueeHintTv;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f377781a;

        static {
            int[] iArr = new int[StatusEnum.values().length];
            try {
                iArr[StatusEnum.NEED_PAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatusEnum.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StatusEnum.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f377781a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceInputLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map M0(AudienceInputLayout this$0, String str) {
        Object obj;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[5];
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
        pairArr[4] = TuplesKt.to("qqlive_message_coming", this$0.qqLiveSendMessage);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final CheckedTextView N0() {
        Object value = this.barrageModeSwitch.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-barrageModeSwitch>(...)");
        return (CheckedTextView) value;
    }

    private final View O0() {
        Object value = this.barrageModeSwitchContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-barrageModeSwitchContainer>(...)");
        return (View) value;
    }

    private final RecyclerView P0() {
        Object value = this.barrageRecyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-barrageRecyclerView>(...)");
        return (RecyclerView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Q0() {
        Object value = this.inputMarqueeHintTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputMarqueeHintTv>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(OnBarrageSendAction sendAction) {
        int i3 = c.f377781a[sendAction.getResult().getStatus().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    gt3.a.b(gt3.a.INSTANCE.a(), sendAction.getResult().getMessage(), 0, null, 6, null);
                    return;
                }
                return;
            } else {
                gt3.a.b(gt3.a.INSTANCE.a(), sendAction.getResult().getMessage(), 0, null, 6, null);
                X0(sendAction.getMessage(), sendAction.getContent());
                return;
            }
        }
        S0(sendAction.getBarrageData(), sendAction.getMessage(), sendAction.getContent());
    }

    private final void S0(BarrageData barrageData, String message, MessageOuterClass$MsgContent content) {
        boolean z16;
        if (barrageData == null) {
            AegisLogger.INSTANCE.i("Input|AudienceInputLayout", "showConfirmPayDialog", "barrageData is null");
            return;
        }
        if (message != null && message.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            AegisLogger.INSTANCE.i("Input|AudienceInputLayout", "showConfirmPayDialog", "message is null or empty");
        } else if (ct3.a.d("qqlive_key_ignore_pay_dialog_for_barrage_payment", com.tencent.mobileqq.qqlive.sail.c.f272176a.G())) {
            a1(barrageData, message, content);
        } else {
            g1(barrageData, message, content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView T0() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f7880482);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new com.tencent.mobileqq.qqlive.widget.util.d(wi2.c.b(12), wi2.c.b(8), wi2.c.b(8)));
        t tVar = new t(this.inputViewModel);
        this.barrageRVAdapter = tVar;
        recyclerView.setAdapter(tVar);
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View U0() {
        View findViewById = findViewById(R.id.f912254l);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.input.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceInputLayout.V0(AudienceInputLayout.this, view);
            }
        });
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(AudienceInputLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N0().toggle();
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this$0.inputViewModel;
        if (qQLiveAudienceBarrageViewModel != null) {
            qQLiveAudienceBarrageViewModel.k2(this$0.N0().isChecked());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView W0() {
        TextView textView = (TextView) findViewById(R.id.xoc);
        textView.setVisibility(0);
        textView.setSelected(true);
        textView.setClickable(false);
        return textView;
    }

    private final void X0(String message, MessageOuterClass$MsgContent content) {
        boolean z16;
        if (message != null && message.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            AegisLogger.INSTANCE.i("Input|AudienceInputLayout", "invokeSuperSendMsg", "message is null or empty");
        } else if (content == null) {
            super.l0(message, false);
        } else {
            super.k0(content, message, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(AudienceInputLayout this$0, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.setState(1);
        if (context instanceof Activity) {
            ((Activity) context).setRequestedOrientation(1);
        }
        context.getResources().getConfiguration();
        view.postDelayed(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.input.j
            @Override // java.lang.Runnable
            public final void run() {
                AudienceInputLayout.Z0();
            }
        }, 200L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0() {
        kl4.s.INSTANCE.b("em_qqlive_quick_dress_center");
    }

    private final void a1(BarrageData barrageData, String message, MessageOuterClass$MsgContent content) {
        Activity activity;
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && !activity.isFinishing() && (qQLiveAudienceBarrageViewModel = this.inputViewModel) != null) {
            qQLiveAudienceBarrageViewModel.g2(activity, barrageData, message, content);
        }
    }

    private final void b1(String message, MessageOuterClass$MsgContent content) {
        OnBarrageSendAction i26;
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
        if (qQLiveAudienceBarrageViewModel != null && (i26 = qQLiveAudienceBarrageViewModel.i2(message, content)) != null) {
            R0(i26);
        }
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void g1(final BarrageData barrageData, final String message, final MessageOuterClass$MsgContent content) {
        DialogUtil.createCustomViewDialog(getContext(), R.string.f210405i1, new DialogUtil.IDialogView() { // from class: com.tencent.timi.game.liveroom.impl.room.input.k
            @Override // com.tencent.mobileqq.utils.DialogUtil.IDialogView
            public final View getView(Context context, Object obj) {
                View h16;
                h16 = AudienceInputLayout.h1(AudienceInputLayout.this, barrageData, context, obj);
                return h16;
            }
        }, null, R.string.cancel, R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.input.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AudienceInputLayout.j1(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.input.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AudienceInputLayout.k1(AudienceInputLayout.this, barrageData, message, content, dialogInterface, i3);
            }
        }, false, false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View h1(AudienceInputLayout this$0, BarrageData barrageData, Context context, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(barrageData, "$barrageData");
        CheckedTextView checkedTextView = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.h_9, (ViewGroup) null);
        final CheckedTextView checkedTextView2 = (CheckedTextView) inflate.findViewById(R.id.axa);
        if (checkedTextView2 != null) {
            checkedTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.input.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudienceInputLayout.i1(checkedTextView2, view);
                }
            });
            checkedTextView = checkedTextView2;
        }
        this$0.ignorePayConfirmDialogCheckbox = checkedTextView;
        ((TextView) inflate.findViewById(R.id.z5m)).setText("\u4f7f\u7528" + barrageData.getConfig().getText() + "\u9700\u652f\u4ed8" + barrageData.getPrice() + "\u91d1\u5e01\uff0c\u786e\u8ba4\u652f\u4ed8\u5e76\u53d1\u9001\u5f39\u5e55\u5417\uff1f");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(CheckedTextView this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.toggle();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(AudienceInputLayout this$0, BarrageData barrageData, String message, MessageOuterClass$MsgContent messageOuterClass$MsgContent, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(barrageData, "$barrageData");
        Intrinsics.checkNotNullParameter(message, "$message");
        this$0.a1(barrageData, message, messageOuterClass$MsgContent);
        CheckedTextView checkedTextView = this$0.ignorePayConfirmDialogCheckbox;
        boolean z16 = false;
        if (checkedTextView != null && checkedTextView.isChecked()) {
            z16 = true;
        }
        if (z16) {
            ct3.a.n("qqlive_key_ignore_pay_dialog_for_barrage_payment", com.tencent.mobileqq.qqlive.sail.c.f272176a.G(), true);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        N0().setChecked(true);
        W(15);
        P0().setVisibility(0);
        p1(this, null, 1, null);
        EditText C = C();
        if (C != null) {
            C.setSingleLine(true);
            C.setSelection(t().length());
        }
        Q0().setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        N0().setChecked(false);
        W(v());
        P0().setVisibility(8);
        EditText C = C();
        if (C != null) {
            C.setSingleLine(false);
            C.setSelection(t().length());
        }
        Q0().setText("\u8bf4\u70b9\u4ec0\u4e48...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(List<BarrageData> barrageDataSet) {
        if (!barrageDataSet.isEmpty() && !Intrinsics.areEqual("huya", getPlatform())) {
            O0().setVisibility(0);
            P0();
            t tVar = this.barrageRVAdapter;
            if (tVar != null) {
                tVar.m0(barrageDataSet);
                return;
            }
            return;
        }
        m1();
        O0().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o1(BarrageData barrageData) {
        CurrentBarrage currentBarrage;
        if (barrageData == null) {
            QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
            if (qQLiveAudienceBarrageViewModel != null && (currentBarrage = qQLiveAudienceBarrageViewModel.getCurrentBarrage()) != null) {
                barrageData = currentBarrage.getBarrageData();
            } else {
                barrageData = null;
            }
        }
        if (barrageData != null) {
            if (barrageData.h()) {
                Q0().setText("\u514d\u8d39\u53d1\u6d3b\u52a8\u5f39\u5e55\uff0c\u6709\u6548\u671f\u5269:" + barrageData.getLeftDay() + "\u5929");
            } else if (barrageData.i()) {
                Q0().setText("\u4f7f\u7528" + barrageData.getPrice() + "\u91d1\u5e01\u53d1\u9001\u4e00\u6761" + barrageData.getConfig().getText());
            }
            Q0().setSelected(true);
        }
    }

    static /* synthetic */ void p1(AudienceInputLayout audienceInputLayout, BarrageData barrageData, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            barrageData = null;
        }
        audienceInputLayout.o1(barrageData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q1() {
        boolean z16;
        float f16;
        EditText C;
        Editable editable;
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
        boolean z17 = true;
        if (qQLiveAudienceBarrageViewModel != null && qQLiveAudienceBarrageViewModel.b2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            EditText C2 = C();
            if (C2 != null) {
                editable = C2.getText();
            } else {
                editable = null;
            }
            if (editable != null && editable.length() != 0) {
                z17 = false;
            }
            if (z17) {
                f16 = 11.0f;
                C = C();
                if (C == null) {
                    C.setTextSize(2, f16);
                    return;
                }
                return;
            }
        }
        f16 = 14.0f;
        C = C();
        if (C == null) {
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout
    protected int E() {
        return R.layout.gxu;
    }

    public final void L0(long roomId, @NotNull HashMap<String, String> pageParams) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        ((ug4.a) mm4.b.b(ug4.a.class)).b(this, IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID, pageParams);
        View H = H();
        if (H != null) {
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.b((ug4.a) b16, H, false, "send", "em_qqlive_send_message", null, 18, null);
            VideoReport.setEventDynamicParams(H, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.input.d
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map M0;
                    M0 = AudienceInputLayout.M0(AudienceInputLayout.this, str);
                    return M0;
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

    @Override // com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout
    public void Y() {
        super.Y();
        if (S()) {
            ((ImageView) findViewById(R.id.uff)).setVisibility(8);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout
    public void i0(boolean fromFloatWindow) {
        super.i0(fromFloatWindow);
        this.isRoomEntered = true;
        this.isFromFloatWindow = fromFloatWindow;
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
        if (qQLiveAudienceBarrageViewModel != null) {
            qQLiveAudienceBarrageViewModel.d2(fromFloatWindow);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout
    public void j0() {
        super.j0();
        this.isRoomEntered = false;
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
        if (qQLiveAudienceBarrageViewModel != null) {
            qQLiveAudienceBarrageViewModel.e2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout
    public void k0(@NotNull MessageOuterClass$MsgContent content, @NotNull String text, boolean isManually) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(text, "text");
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
        boolean z16 = false;
        if (qQLiveAudienceBarrageViewModel != null && qQLiveAudienceBarrageViewModel.b2()) {
            z16 = true;
        }
        if (z16) {
            b1(text, content);
        } else {
            super.k0(content, text, isManually);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout
    public void l0(@NotNull String text, boolean isManually) {
        Intrinsics.checkNotNullParameter(text, "text");
        QQLiveAudienceBarrageViewModel qQLiveAudienceBarrageViewModel = this.inputViewModel;
        boolean z16 = false;
        if (qQLiveAudienceBarrageViewModel != null && qQLiveAudienceBarrageViewModel.b2()) {
            z16 = true;
        }
        if (z16) {
            b1(text, null);
        } else {
            super.l0(text, isManually);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        boolean z16;
        super.onConfigurationChanged(newConfig);
        int i3 = 0;
        if (newConfig != null && newConfig.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageView imageView = (ImageView) findViewById(R.id.uff);
        if (z16) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public final void setInputViewModel(@NotNull final QQLiveAudienceBarrageViewModel inputViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(inputViewModel, "inputViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (this.inputViewModel != null) {
            return;
        }
        this.inputViewModel = inputViewModel;
        if (this.isRoomEntered) {
            inputViewModel.d2(this.isFromFloatWindow);
        }
        LiveData<Boolean> S1 = inputViewModel.S1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$setInputViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    AudienceInputLayout.this.l1();
                } else {
                    AudienceInputLayout.this.m1();
                }
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.input.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudienceInputLayout.c1(Function1.this, obj);
            }
        });
        MutableLiveData<List<BarrageData>> R1 = inputViewModel.R1();
        final Function1<List<BarrageData>, Unit> function12 = new Function1<List<BarrageData>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$setInputViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<BarrageData> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<BarrageData> it) {
                AudienceInputLayout audienceInputLayout = AudienceInputLayout.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                audienceInputLayout.n1(it);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.input.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudienceInputLayout.d1(Function1.this, obj);
            }
        });
        MutableLiveData<OnBarrageCheckedAction> U1 = inputViewModel.U1();
        final Function1<OnBarrageCheckedAction, Unit> function13 = new Function1<OnBarrageCheckedAction, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$setInputViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBarrageCheckedAction onBarrageCheckedAction) {
                invoke2(onBarrageCheckedAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBarrageCheckedAction onBarrageCheckedAction) {
                t tVar;
                CurrentBarrage currentBarrage = onBarrageCheckedAction.getCurrentBarrage();
                if (currentBarrage != null) {
                    tVar = AudienceInputLayout.this.barrageRVAdapter;
                    if (tVar != null) {
                        tVar.n0(onBarrageCheckedAction.getCurrentBarrage().getPosition());
                    }
                    if (inputViewModel.b2()) {
                        AudienceInputLayout.this.o1(currentBarrage.getBarrageData());
                        return;
                    }
                    return;
                }
                gt3.a a16 = gt3.a.INSTANCE.a();
                String errorMsg = onBarrageCheckedAction.getErrorMsg();
                if (errorMsg == null) {
                    errorMsg = "";
                }
                gt3.a.b(a16, errorMsg, 0, null, 6, null);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.input.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudienceInputLayout.e1(Function1.this, obj);
            }
        });
        MutableLiveData<OnBarrageSendAction> W1 = inputViewModel.W1();
        final Function1<OnBarrageSendAction, Unit> function14 = new Function1<OnBarrageSendAction, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$setInputViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBarrageSendAction onBarrageSendAction) {
                invoke2(onBarrageSendAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBarrageSendAction it) {
                AudienceInputLayout audienceInputLayout = AudienceInputLayout.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                audienceInputLayout.R0(it);
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.input.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudienceInputLayout.f1(Function1.this, obj);
            }
        });
    }

    public /* synthetic */ AudienceInputLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceInputLayout(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        this.qqLiveSendMessage = "0";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$barrageModeSwitchContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View U0;
                U0 = AudienceInputLayout.this.U0();
                return U0;
            }
        });
        this.barrageModeSwitchContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CheckedTextView>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$barrageModeSwitch$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CheckedTextView invoke() {
                return (CheckedTextView) AudienceInputLayout.this.findViewById(R.id.f912154k);
            }
        });
        this.barrageModeSwitch = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$barrageRecyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                RecyclerView T0;
                T0 = AudienceInputLayout.this.T0();
                return T0;
            }
        });
        this.barrageRecyclerView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.timi.game.liveroom.impl.room.input.AudienceInputLayout$inputMarqueeHintTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView W0;
                W0 = AudienceInputLayout.this.W0();
                return W0;
            }
        });
        this.inputMarqueeHintTv = lazy4;
        EditText C = C();
        VideoReport.setElementId(C instanceof Object ? C : null, "em_qqlive_inputpanel_box");
        VideoReport.setLogicParent(C(), H());
        EditText C2 = C();
        if (C2 != null) {
            C2.addTextChangedListener(new a());
        }
        ((ImageView) findViewById(R.id.uff)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.input.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudienceInputLayout.Y0(AudienceInputLayout.this, context, view);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/input/AudienceInputLayout$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            AudienceInputLayout.this.q1();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            if (TextUtils.isEmpty(s16)) {
                AudienceInputLayout.this.Q0().setVisibility(0);
                AudienceInputLayout.this.Q0().setSelected(true);
            } else {
                AudienceInputLayout.this.Q0().setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
