package com.tencent.mobileqq.aio.msglist.holder;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.TraceCompat;
import androidx.core.util.SparseArrayKt;
import androidx.recyclerview.widget.AIOCoreLayoutParam;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.select.SelectComponentUIState;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.template.l;
import com.tencent.mobileqq.aio.msglist.holder.template.n;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.x;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.holder.template.ChatItemAnimLayout;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0088\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0089\u0001B3\u0012\u0006\u0010*\u001a\u00020\u0012\u0012\u0006\u0010X\u001a\u00020\u0014\u0012\u0006\u0010]\u001a\u00020\u000e\u0012\u0006\u0010c\u001a\u00020^\u0012\b\b\u0002\u0010g\u001a\u00020\u0017\u00a2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\"\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J.\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020 H\u0002J\"\u0010+\u001a\u0004\u0018\u00010\u00142\u0006\u0010'\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u00100\u001a\u00020/H\u0016J&\u00107\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u000205\u0012\u0006\b\u0001\u0012\u00020604032\u0006\u00102\u001a\u00020\u0014H\u0016J\u0010\u00109\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u000108J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030:H\u0016J\u0016\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030<03H\u0016J\u0010\u0010?\u001a\u00020\f2\u0006\u0010>\u001a\u00020\u0003H\u0016J,\u0010B\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010A\u001a\u00020@J\u0010\u0010E\u001a\u00020 2\u0006\u0010D\u001a\u00020CH\u0016J\u0010\u0010F\u001a\u00020 2\u0006\u0010D\u001a\u00020CH\u0016J\b\u0010G\u001a\u00020\fH\u0016J\u0010\u0010I\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u0017H\u0016J\u0010\u0010K\u001a\u00020\f2\u0006\u0010J\u001a\u00020\u0017H\u0016J\u0010\u0010L\u001a\u00020\f2\u0006\u0010J\u001a\u00020\u0017H\u0016J\b\u0010M\u001a\u00020\fH\u0016J\u0010\u0010O\u001a\u00020\f2\u0006\u0010N\u001a\u00020\u0007H\u0016R\u0017\u0010*\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010X\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0017\u0010]\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0017\u0010c\u001a\u00020^8\u0006\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0017\u0010g\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\bd\u0010O\u001a\u0004\be\u0010fR$\u0010n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010s\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010O\u001a\u0004\bp\u0010f\"\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR$\u0010{\u001a\u0012\u0012\u0004\u0012\u00020(0wj\b\u0012\u0004\u0012\u00020(`x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010zR\u001a\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020(0|8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b}\u0010~R!\u0010\u0085\u0001\u001a\u00030\u0080\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/AIOBubbleMsgItemVB;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "Lcom/tencent/qqnt/aio/holder/template/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper$b;", "Lcom/tencent/qqnt/aio/holder/template/ChatItemAnimLayout$b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/g;", "provider", "", "o1", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "animViewWrapper", "Landroid/view/View;", "animView", "l1", "", "componentKey", "h1", Constants.BASE_IN_PLUGIN_ID, "position", "Lcom/tencent/aio/data/msglist/a;", "k1", "u1", "v1", "", "y1", "B1", "x1", "z1", "A1", "C1", "key", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", HippyQQConstants.URL_COMPONENT_NAME, "template", "g1", "E1", "F1", Constants.APK_CERTIFICATE, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/aio/api/list/b;", "b1", "Ljava/lang/Class;", "getObserverStates", "state", "w1", "Landroid/os/Bundle;", "params", "i1", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "X", "dx", "O0", "scrollX", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "k", "chatMessage", "I", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "getTemplate", "()Lcom/tencent/mobileqq/aio/msglist/holder/template/n;", "e", "Landroid/view/View;", "q1", "()Landroid/view/View;", "itemView", "f", "Lcom/tencent/mobileqq/aio/msglist/holder/g;", "m1", "()Lcom/tencent/mobileqq/aio/msglist/holder/g;", "componentProvider", "Lcom/tencent/mobileqq/aio/msglist/x;", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/x;", "getFactoryProvider", "()Lcom/tencent/mobileqq/aio/msglist/x;", "factoryProvider", "i", "getViewType", "()I", "viewType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "p1", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "setCurrentMsgItem", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "currentMsgItem", BdhLogUtil.LogTag.Tag_Conn, "getCurrentPosition", "setCurrentPosition", "(I)V", "currentPosition", "D", "Z", "shieldTouchItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "components", "Landroid/util/SparseArray;", UserInfo.SEX_FEMALE, "Landroid/util/SparseArray;", "loadedLazyComponent", "Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper;", "G", "Lkotlin/Lazy;", "r1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/leftswipearea/AIOContentLeftSwipeHelper;", "leftSwipeHelper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/template/n;Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/g;Lcom/tencent/mobileqq/aio/msglist/x;I)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOBubbleMsgItemVB extends com.tencent.aio.api.list.a<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> implements com.tencent.qqnt.aio.holder.template.d, AIOContentLeftSwipeHelper.b, ChatItemAnimLayout.b {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int currentPosition;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean shieldTouchItem;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.c> components;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> loadedLazyComponent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftSwipeHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n template;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g componentProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final x factoryProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem currentMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/AIOBubbleMsgItemVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.AIOBubbleMsgItemVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/AIOBubbleMsgItemVB$b", "Lcom/tencent/qqnt/aio/holder/template/c;", "", "action", "Landroid/os/Bundle;", "arguments", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.qqnt.aio.holder.template.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOBubbleMsgItemVB.this);
            }
        }

        @Override // com.tencent.qqnt.aio.holder.template.c
        public void a(int action, @Nullable Bundle arguments) {
            AIOMsgItem p16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, action, (Object) arguments);
                return;
            }
            if (action == 16 && (p16 = AIOBubbleMsgItemVB.this.p1()) != null) {
                AIOBubbleMsgItemVB aIOBubbleMsgItemVB = AIOBubbleMsgItemVB.this;
                if (aIOBubbleMsgItemVB.A1(p16)) {
                    aIOBubbleMsgItemVB.sendIntent(new d.al(p16));
                    ((TemplateLayout) aIOBubbleMsgItemVB.q1()).setSelected(false);
                } else {
                    ((TemplateLayout) aIOBubbleMsgItemVB.q1()).setSelected(true);
                    aIOBubbleMsgItemVB.sendIntent(new d.c(p16));
                }
                aIOBubbleMsgItemVB.sendIntent(d.ai.f192303d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOBubbleMsgItemVB(@NotNull n template, @NotNull View itemView, @NotNull g componentProvider, @NotNull x factoryProvider, int i3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, template, itemView, componentProvider, factoryProvider, Integer.valueOf(i3));
            return;
        }
        this.template = template;
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
        this.components = new ArrayList<>();
        this.loadedLazyComponent = new SparseArray<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOContentLeftSwipeHelper>() { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOBubbleMsgItemVB$leftSwipeHelper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOBubbleMsgItemVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOContentLeftSwipeHelper invoke() {
                boolean B1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AIOContentLeftSwipeHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                View q16 = AIOBubbleMsgItemVB.this.q1();
                Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) q16;
                com.tencent.mobileqq.aio.msglist.holder.component.c cVar = AIOBubbleMsgItemVB.this.m1().get().get(2);
                AIOContentLeftSwipeHelper aIOContentLeftSwipeHelper = new AIOContentLeftSwipeHelper(viewGroup, cVar != null ? cVar.f1() : null);
                AIOBubbleMsgItemVB aIOBubbleMsgItemVB = AIOBubbleMsgItemVB.this;
                aIOContentLeftSwipeHelper.e(aIOBubbleMsgItemVB);
                B1 = aIOBubbleMsgItemVB.B1();
                aIOContentLeftSwipeHelper.n(B1);
                return aIOContentLeftSwipeHelper;
            }
        });
        this.leftSwipeHelper = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A1(AIOMsgItem msgItem) {
        d.t tVar = new d.t(msgItem, false, 2, null);
        sendIntent(tVar);
        return tVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B1() {
        d.u uVar = new d.u(false, 1, null);
        sendIntent(uVar);
        if (!uVar.a() || this.componentProvider.a().get(8) == null) {
            return false;
        }
        return true;
    }

    private final boolean C1() {
        d.l lVar = new d.l(false, 1, null);
        sendIntent(lVar);
        return lVar.a();
    }

    private final void D1(int componentKey) {
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar = this.loadedLazyComponent.get(componentKey);
        if (cVar == null) {
            return;
        }
        this.loadedLazyComponent.remove(componentKey);
        View f16 = cVar.f1();
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) f16).removeAllViews();
    }

    private final void E1(AIOMsgItem msgItem) {
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar;
        View e16;
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar2;
        if (msgItem.isSelf() && (cVar = this.componentProvider.get().get(2)) != null && (e16 = cVar.e1()) != null && (cVar2 = this.componentProvider.get().get(0)) != null) {
            cVar2.m1(e16);
        }
    }

    private final void F1(AIOMsgItem msgItem) {
        TemplateLayout templateLayout;
        int i3 = 0;
        if (msgItem.S0()) {
            this.itemView.setImportantForAccessibility(1);
            SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray = this.componentProvider.get();
            int size = sparseArray.size();
            while (i3 < size) {
                sparseArray.keyAt(i3);
                com.tencent.mobileqq.aio.msglist.holder.component.c valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    valueAt.l1(2);
                }
                i3++;
            }
            View view = this.itemView;
            if (view instanceof TemplateLayout) {
                templateLayout = (TemplateLayout) view;
            } else {
                templateLayout = null;
            }
            if (templateLayout != null) {
                templateLayout.setOnAccessibilityActionListener(new b());
                return;
            }
            return;
        }
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray2 = this.componentProvider.get();
        int size2 = sparseArray2.size();
        while (i3 < size2) {
            sparseArray2.keyAt(i3);
            com.tencent.mobileqq.aio.msglist.holder.component.c valueAt2 = sparseArray2.valueAt(i3);
            if (valueAt2 != null) {
                valueAt2.l1(1);
            }
            i3++;
        }
    }

    private final void G1(AIOMsgItem msgItem) {
        ViewGroup.LayoutParams layoutParams;
        View f16;
        Rect z16 = msgItem.z();
        if (z16 != null) {
            com.tencent.mobileqq.aio.msglist.holder.component.c cVar = this.componentProvider.get().get(2);
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (cVar != null && (f16 = cVar.f1()) != null) {
                layoutParams = f16.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams != null) {
                int i3 = z16.top;
                if (i3 <= 0) {
                    i3 = 0;
                }
                marginLayoutParams.topMargin = i3;
            }
        }
    }

    private final View g1(int key, com.tencent.mobileqq.aio.msglist.holder.component.c component, n template) {
        if (key == 8) {
            return template.j(component.c1());
        }
        QLog.i("AIOBubbleMsgItemVB", 1, "[addContentView] wrong componentKey: " + key);
        return null;
    }

    private final void h1(int componentKey) {
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar;
        if (this.loadedLazyComponent.get(componentKey) == null && (cVar = this.componentProvider.a().get(componentKey)) != null) {
            this.loadedLazyComponent.put(componentKey, cVar);
            View g16 = g1(componentKey, cVar, this.template);
            if (g16 != null) {
                cVar.k1(g16);
            } else {
                View f16 = cVar.f1();
                Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) f16).addView(cVar.c1());
            }
            addChildVB(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j1(com.tencent.mobileqq.aio.msglist.holder.component.c cVar, AIOBubbleMsgItemVB this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOMsgItem aIOMsgItem = this$0.currentMsgItem;
        Intrinsics.checkNotNull(aIOMsgItem);
        cVar.sendIntent(new d.x(aIOMsgItem));
        return true;
    }

    private final void k1(int componentKey, int position, com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar;
        if (this.loadedLazyComponent.get(componentKey) != null && (cVar = this.componentProvider.a().get(componentKey)) != null) {
            cVar.b1(position, msgItem, payloads);
        }
    }

    private final void l1(n animViewWrapper, View animView, AIOMsgItem msgItem) {
        if (msgItem == null || !msgItem.N() || !(animView instanceof ChatItemAnimLayout)) {
            return;
        }
        if (!(animViewWrapper instanceof com.tencent.mobileqq.aio.msglist.holder.template.g) && !(animViewWrapper instanceof l)) {
            ((ChatItemAnimLayout) animView).z0(msgItem);
            return;
        }
        float a16 = com.tencent.mobileqq.utils.x.a(30.0f);
        if (!msgItem.isSelf()) {
            a16 *= -1;
        }
        ((ChatItemAnimLayout) animView).F0(msgItem, a16, 0.0f, 0.0f, 1.0f, this);
    }

    private final String o1(g provider) {
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar = provider.get().get(2);
        Intrinsics.checkNotNull(cVar);
        String simpleName = cVar.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "provider.get()[AIO_MSG_C\u2026!!::class.java.simpleName");
        return simpleName;
    }

    private final AIOContentLeftSwipeHelper r1() {
        return (AIOContentLeftSwipeHelper) this.leftSwipeHelper.getValue();
    }

    private final void s1(AIOMsgItem msgItem, List<Object> payloads) {
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.SHOT_MODE_PAYLOAD) != null) {
                    F1(msgItem);
                }
                if (map.get(AIOMsgItemPayloadType.LOADING_CHANGE_PAYLOAD) != null) {
                    G1(msgItem);
                }
            }
        }
    }

    private final void u1() {
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.mobileqq.aio.msglist.holder.component.c cVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) valueIterator.next();
            if (cVar != null) {
                cVar.i1();
            }
        }
    }

    private final void v1() {
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.mobileqq.aio.msglist.holder.component.c cVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) valueIterator.next();
            if (cVar != null) {
                cVar.j1();
            }
        }
    }

    private final boolean x1(AIOMsgItem msgItem) {
        d.r rVar = new d.r(msgItem, false, 2, null);
        sendIntent(rVar);
        return rVar.b();
    }

    private final boolean y1() {
        d.n nVar = new d.n(false, 1, null);
        sendIntent(nVar);
        return nVar.a();
    }

    private final boolean z1() {
        d.o oVar = new d.o(false, 1, null);
        sendIntent(oVar);
        return oVar.a();
    }

    @Override // com.tencent.qqnt.aio.holder.template.ChatItemAnimLayout.b
    public void I(@NotNull AIOMsgItem chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) chatMessage);
            return;
        }
        Intrinsics.checkNotNullParameter(chatMessage, "chatMessage");
        Iterator<T> it = this.components.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.aio.msglist.holder.component.c) it.next()).I(chatMessage);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void O0(int dx5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, dx5);
            return;
        }
        com.tencent.mvi.mvvm.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) this.loadedLazyComponent.get(8);
        if (bVar != null && (bVar instanceof AIOContentLeftSwipeHelper.b)) {
            ((AIOContentLeftSwipeHelper.b) bVar).O0(dx5);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        h1(8);
        com.tencent.mvi.mvvm.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) this.loadedLazyComponent.get(8);
        if (bVar instanceof AIOContentLeftSwipeHelper.b) {
            ((AIOContentLeftSwipeHelper.b) bVar).X();
        }
        int i3 = this.currentPosition;
        AIOMsgItem aIOMsgItem = this.currentMsgItem;
        Intrinsics.checkNotNull(aIOMsgItem);
        k1(8, i3, aIOMsgItem, new ArrayList());
        sendIntent(d.f.f192343d);
        sendIntent(new d.z(true));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void Z0(int scrollX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, scrollX);
            return;
        }
        com.tencent.mvi.mvvm.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) this.loadedLazyComponent.get(8);
        if (bVar != null && (bVar instanceof AIOContentLeftSwipeHelper.b)) {
            ((AIOContentLeftSwipeHelper.b) bVar).Z0(scrollX);
        }
        D1(8);
        sendIntent(new d.z(false));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void a1(int scrollX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, scrollX);
            return;
        }
        com.tencent.mvi.mvvm.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) this.loadedLazyComponent.get(8);
        if (bVar != null && (bVar instanceof AIOContentLeftSwipeHelper.b)) {
            ((AIOContentLeftSwipeHelper.b) bVar).a1(scrollX);
        }
    }

    @Override // com.tencent.aio.api.list.a
    @NotNull
    public com.tencent.aio.api.list.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> b1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.aio.api.list.b) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        i a16 = this.factoryProvider.a(this.viewType);
        Intrinsics.checkNotNull(a16);
        return a16.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends IMsgItemMviUIState>> getObserverStates() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AIOMsgItemUIState.AIOMsgItemState.class);
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    public final void i1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads, @NotNull Bundle params) {
        int measuredHeight;
        View f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(position), msgItem, payloads, params);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Intrinsics.checkNotNullParameter(params, "params");
        TraceCompat.beginSection("bind." + msgItem.getViewType());
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        this.currentMsgItem = aIOMsgItem;
        this.currentPosition = position;
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) QRoute.api(IMsgUtilApi.class);
        AIOMsgItem aIOMsgItem2 = this.currentMsgItem;
        Intrinsics.checkNotNull(aIOMsgItem2);
        StopWatch i3 = new StopWatch("AIOBind.AIOBubbleMsgItemVB(" + iMsgUtilApi.msgTypeToString(aIOMsgItem2.getMsgRecord()) + "-" + msgItem.getMsgId() + "-" + msgItem.getViewType() + ")", QLog.isDevelopLevel()).i();
        s1(aIOMsgItem, payloads);
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.mobileqq.aio.msglist.holder.component.c cVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) valueIterator.next();
            if (cVar != null) {
                cVar.b1(position, msgItem, payloads);
                i3.e(cVar.getClass().getSimpleName() + ".bind");
            }
        }
        TraceCompat.endSection();
        final com.tencent.mobileqq.aio.msglist.holder.component.c cVar2 = this.componentProvider.get().get(2);
        if (cVar2 != null && (f16 = cVar2.f1()) != null) {
            f16.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.a
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean j16;
                    j16 = AIOBubbleMsgItemVB.j1(com.tencent.mobileqq.aio.msglist.holder.component.c.this, this, view);
                    return j16;
                }
            });
        }
        this.shieldTouchItem = params.getBoolean("key_shield_item_touch", false);
        l1(this.template, this.itemView, this.currentMsgItem);
        AIOMsgItem aIOMsgItem3 = this.currentMsgItem;
        if (aIOMsgItem3 != null) {
            aIOMsgItem3.x1(false);
        }
        this.template.q(C1());
        boolean isEmpty = payloads.isEmpty();
        AIOCoreLayoutParam aIOCoreLayoutParam = null;
        if (isEmpty) {
            E1(aIOMsgItem);
            F1(aIOMsgItem);
            Object tag = this.itemView.getTag(R.id.siv);
            if (tag instanceof AnimatorSet) {
                this.itemView.setTag(R.id.siv, null);
                ((AnimatorSet) tag).end();
                QLog.i("AIOBubbleMsgItemVB", 1, "[bind]: bind new Item, end highLightAnimator");
            }
            G1(aIOMsgItem);
        }
        i3.b(o1(this.componentProvider));
        AIOMsgItem aIOMsgItem4 = this.currentMsgItem;
        if (aIOMsgItem4 != null && aIOMsgItem4.T() == 0) {
            if (this.itemView.getMeasuredHeight() == 0) {
                measuredHeight = 1000;
            } else {
                measuredHeight = this.itemView.getMeasuredHeight();
            }
            aIOMsgItem4.z1(measuredHeight);
        }
        if (!(msgItem instanceof MarkdownMsgItem) && (!(msgItem instanceof com.tencent.mobileqq.aio.msg.l) || !((com.tencent.mobileqq.aio.msg.l) msgItem).d())) {
            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
            if (layoutParams instanceof AIOCoreLayoutParam) {
                aIOCoreLayoutParam = (AIOCoreLayoutParam) layoutParams;
            }
            if (aIOCoreLayoutParam != null) {
                aIOCoreLayoutParam.whenOutScreenLocation = false;
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.itemView.getLayoutParams();
        if (layoutParams2 instanceof AIOCoreLayoutParam) {
            aIOCoreLayoutParam = (AIOCoreLayoutParam) layoutParams2;
        }
        if (aIOCoreLayoutParam != null) {
            aIOCoreLayoutParam.whenOutScreenLocation = true;
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.mobileqq.aio.msglist.holder.component.c cVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) valueIterator.next();
            if (cVar != null) {
                view = cVar.f1();
            } else {
                view = null;
            }
            if (view != null) {
                arrayList.add(cVar);
                this.components.add(cVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOContentLeftSwipeHelper.b
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        com.tencent.mvi.mvvm.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.c) this.loadedLazyComponent.get(8);
        if (bVar != null && (bVar instanceof AIOContentLeftSwipeHelper.b)) {
            ((AIOContentLeftSwipeHelper.b) bVar).k();
        }
    }

    @NotNull
    public final g m1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (g) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.componentProvider;
    }

    @Nullable
    public final BaseContentComponent<? extends AIOMsgItem> n1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BaseContentComponent) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        for (com.tencent.mobileqq.aio.msglist.holder.component.c cVar : this.components) {
            if (cVar instanceof BaseContentComponent) {
                return (BaseContentComponent) cVar;
            }
        }
        return null;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return this.itemView;
    }

    @Override // com.tencent.qqnt.aio.holder.template.d
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.shieldTouchItem) {
            return true;
        }
        if (ev5.getAction() == 0) {
            r1().n(B1());
            if (this.currentMsgItem != null && (y1() || z1())) {
                return true;
            }
        }
        return r1().j(ev5);
    }

    @Override // com.tencent.qqnt.aio.holder.template.d
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        AIOMsgItem aIOMsgItem;
        boolean b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (this.shieldTouchItem) {
            if (action == 1) {
                QQToast.makeText(getMContext(), R.string.zd5, 0).show();
            }
            return true;
        }
        if (action == 0 && (y1() || z1())) {
            return true;
        }
        if (action == 1) {
            if (z1()) {
                AIOMsgItem aIOMsgItem2 = this.currentMsgItem;
                if (aIOMsgItem2 != null) {
                    if (A1(aIOMsgItem2)) {
                        sendIntent(new d.al(aIOMsgItem2));
                    } else {
                        sendIntent(new d.c(aIOMsgItem2));
                    }
                    sendIntent(d.ai.f192303d);
                }
            } else if (y1() && (aIOMsgItem = this.currentMsgItem) != null && aIOMsgItem.e2()) {
                boolean x16 = x1(aIOMsgItem);
                if (x16) {
                    sendIntent(new d.ak(aIOMsgItem));
                    b16 = true;
                } else {
                    d.b bVar = new d.b(aIOMsgItem, false, 2, null);
                    sendIntent(bVar);
                    b16 = bVar.b();
                }
                if (b16) {
                    com.tencent.mobileqq.aio.msglist.holder.component.c cVar = this.componentProvider.get().get(3);
                    if (cVar != null) {
                        cVar.handleUIState(new SelectComponentUIState.SetCheck(!x16));
                    }
                    sendIntent(d.ap.f192317d);
                }
            }
        }
        return r1().k(ev5);
    }

    @Nullable
    public final AIOMsgItem p1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.currentMsgItem;
    }

    @NotNull
    public final View q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.itemView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOMsgItemUIState.AIOMsgItemState) {
            AIOMsgItemUIState.AIOMsgItemState aIOMsgItemState = (AIOMsgItemUIState.AIOMsgItemState) state;
            i1(aIOMsgItemState.d(), aIOMsgItemState.b(), aIOMsgItemState.c(), aIOMsgItemState.a());
        } else if (state instanceof AIOMsgItemUIState.ScrollIntoScreen) {
            u1();
        } else if (state instanceof AIOMsgItemUIState.ScrollOutScreen) {
            v1();
        }
    }
}
