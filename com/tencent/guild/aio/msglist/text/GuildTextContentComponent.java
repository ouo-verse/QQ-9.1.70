package com.tencent.guild.aio.msglist.text;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvvm.b;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.msglist.text.GuildTextContentUIState;
import com.tencent.guild.aio.msglist.text.a;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.util.c;
import com.tencent.guild.aio.util.ex.e;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IRandomLottieProxyApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 V2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u00106\u001a\u00020*\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0002J&\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001c\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eJ\u0016\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0018\u00010!H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020#H\u0016J\u0016\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020#0(0'H\u0016J\b\u0010+\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00101\u001a\u000200H\u0016R\u0017\u00106\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00109\u001a\u0004\bB\u0010CR$\u0010K\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/GuildTextContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "r1", "", "v1", "", "", "payloads", "p1", "q1", "", "msgSeq", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "", "emoFaceId", "l1", "size", "u1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "tempList", "m1", "position", "b1", "bindData", "Lkotlin/Function0;", "function", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "state", "handleUIState", "", "Ljava/lang/Class;", "getObserverStates", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", h.F, "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_1, "()Landroid/view/ViewGroup;", "contentView", "i", "Z", "isLottie", "Lwq0/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o1", "()Lwq0/l;", "txtView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getRandomLottieResultId", "()Ljava/lang/String;", "setRandomLottieResultId", "(Ljava/lang/String;)V", "randomLottieResultId", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "D", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/guild/aio/msglist/text/util/c;", "E", "Lcom/tencent/guild/aio/msglist/text/util/c;", "bubbleColorObserverDetachHandle", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildTextContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int G = c.b(171);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String randomLottieResultId;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.text.util.c bubbleColorObserverDetachHandle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isLottie;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/GuildTextContentComponent$a;", "", "", "LOTTIE_ANIM_SIZE", "I", "a", "()I", "LongStrLimit", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.text.GuildTextContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildTextContentComponent.G;
        }

        Companion() {
        }
    }

    public GuildTextContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextContentFrameLayout>() { // from class: com.tencent.guild.aio.msglist.text.GuildTextContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextContentFrameLayout invoke() {
                Context context = GuildTextContentComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                final GuildTextContentComponent guildTextContentComponent = GuildTextContentComponent.this;
                return new TextContentFrameLayout(context, new Function1<Integer, Unit>() { // from class: com.tencent.guild.aio.msglist.text.GuildTextContentComponent$contentView$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        boolean z16;
                        z16 = GuildTextContentComponent.this.isLottie;
                        if (z16) {
                            return;
                        }
                        BubbleTextViewUtil.f111916a.b(i3);
                    }
                }, null, 0, 12, null);
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.guild.aio.msglist.text.GuildTextContentComponent$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
                Context context = GuildTextContentComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                return BubbleTextViewUtil.f(bubbleTextViewUtil, context, false, 2, null);
            }
        });
        this.txtView = lazy2;
        this.randomLottieResultId = "";
    }

    private final void l1(long msgSeq, FaceElement faceElement, int emoFaceId) {
        u1(G);
        sendIntent(new a.C1206a(msgSeq, n1(), faceElement, emoFaceId));
        this.randomLottieResultId = faceElement.resultId;
        this.root.findViewById(R.id.f164907u83).setBackgroundResource(R.drawable.lvj);
    }

    private final void m1(com.tencent.aio.data.msglist.a msgItem, ArrayList<MsgElement> tempList) {
        u1(-2);
        AIOParam aIOParam = null;
        s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
        sendIntent(new s.GetAioContext(aioContextWrapper));
        BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
        Context context = this.root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        com.tencent.aio.api.runtime.a context2 = aioContextWrapper.getContext();
        if (context2 != null) {
            aIOParam = context2.g();
        }
        bubbleTextViewUtil.r(context, aIOParam, o1(), msgItem, tempList);
        if (QLog.isColorLevel()) {
            QLog.i("GuildTextContentComponent", 2, "bindNormalText msgId = " + msgItem.getMsgId());
        }
        com.tencent.aio.api.runtime.a context3 = aioContextWrapper.getContext();
        if (context3 == null) {
            QLog.e("GuildTextContentComponent", 1, "bindNormalText aioContext is null");
            return;
        }
        GuildCombineUtil guildCombineUtil = GuildCombineUtil.f111919a;
        View view = this.root;
        LifecycleOwner viewLifecycleOwner = context3.c().getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "aioContext.fragment.viewLifecycleOwner");
        this.bubbleColorObserverDetachHandle = guildCombineUtil.t(view, msgItem, viewLifecycleOwner);
        if (o1().getView().getParent() == null) {
            n1().addView(o1().getView());
        }
    }

    private final ViewGroup n1() {
        return (ViewGroup) this.contentView.getValue();
    }

    private final l o1() {
        return (l) this.txtView.getValue();
    }

    private final boolean p1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(com.tencent.aio.data.msglist.a msgItem) {
        GuildMsgItem guildMsgItem;
        long j3;
        MsgRecord msgRecord;
        List filterNotNull;
        boolean z16 = msgItem instanceof GuildMsgItem;
        GuildMsgItem guildMsgItem2 = null;
        if (z16) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem == null) {
            return;
        }
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = guildMsgItem.getMsgRecord().elements;
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
        GuildMsgItem guildMsgItem3 = (GuildMsgItem) msgItem;
        this.currentMsgItem = guildMsgItem3;
        if (arrayList.isEmpty()) {
            return;
        }
        if (z16) {
            guildMsgItem2 = guildMsgItem3;
        }
        if (guildMsgItem2 != null && (msgRecord = guildMsgItem2.getMsgRecord()) != null) {
            j3 = msgRecord.msgSeq;
        } else {
            j3 = 0;
        }
        boolean d16 = e.d(arrayList);
        if (d16 || this.isLottie != d16) {
            n1().removeAllViews();
        }
        this.isLottie = d16;
        if (d16) {
            FaceElement a16 = e.a(arrayList);
            if (a16 != null) {
                l1(j3, a16, e.b(arrayList));
                return;
            }
            return;
        }
        m1(msgItem, arrayList);
    }

    private final boolean r1(com.tencent.aio.data.msglist.a msgItem) {
        boolean g16 = e.g(msgItem);
        boolean isEmpty = TextUtils.isEmpty(this.randomLottieResultId);
        QLog.i("GuildTextContentComponent", 4, "isRandomLottie=" + g16 + " needUpdate=" + isEmpty + " ");
        if (g16 && isEmpty) {
            return true;
        }
        return false;
    }

    private final void u1(int size) {
        ViewGroup.LayoutParams layoutParams = n1().getLayoutParams();
        layoutParams.width = size;
        layoutParams.height = size;
        n1().setLayoutParams(layoutParams);
    }

    private final void v1(com.tencent.aio.data.msglist.a msgItem) {
        GuildMsgItem guildMsgItem;
        String str;
        MsgRecord msgRecord;
        ArrayList<MsgElement> elements;
        List filterNotNull;
        QLog.i("GuildTextContentComponent", 1, "updateRandomLottieResult");
        ArrayList arrayList = new ArrayList();
        if (msgItem instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msgItem;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null && (elements = msgRecord.elements) != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        FaceElement a16 = e.a(arrayList);
        if (a16 == null) {
            return;
        }
        String str2 = a16.resultId;
        this.randomLottieResultId = str2;
        if (!TextUtils.isEmpty(str2) && (str = this.randomLottieResultId) != null) {
            QRouteApi api = QRoute.api(IRandomLottieProxyApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IRandomLottieProxyApi::class.java)");
            IRandomLottieProxyApi.a.a((IRandomLottieProxyApi) api, str, n1(), null, null, 12, null);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        boolean p16 = p1(payloads);
        boolean r16 = r1(msgItem);
        if (!p16 && r16) {
            v1(msgItem);
        }
        if (p16) {
            s1(msgItem, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.text.GuildTextContentComponent$bind$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    GuildTextContentComponent.this.q1(msgItem);
                }
            });
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return n1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public b<ol3.b, MviUIState> createVM() {
        return new GuildTextContentComponentVM(n1());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MviUIState>> getObserverStates() {
        List<Class<? extends MviUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildTextContentUIState.PostThemeChangedState.class);
        return listOf;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildTextContentComponent";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof GuildTextContentUIState.PostThemeChangedState) {
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            q1(guildMsgItem);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        com.tencent.guild.aio.msglist.text.util.c cVar = this.bubbleColorObserverDetachHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.bubbleColorObserverDetachHandle = null;
        super.onDestroy();
    }

    public final void s1(@NotNull com.tencent.aio.data.msglist.a bindData, @NotNull Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(bindData, "bindData");
        Intrinsics.checkNotNullParameter(function, "function");
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            function.invoke();
            return;
        }
        GuildMsgItem guildMsgItem2 = null;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        if (guildMsgItem.isSameItem(bindData)) {
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            } else {
                guildMsgItem2 = guildMsgItem3;
            }
            if (guildMsgItem2.isSameContent(bindData)) {
                QLog.d("GuildTextContentComponent", 4, "\u60f3\u540c\u547d\u4e2d ");
                return;
            }
        }
        function.invoke();
    }
}
