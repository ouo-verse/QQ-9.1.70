package com.tencent.state.publicchat.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.ShowMsgPanelAction;
import com.tencent.state.publicchat.action.ShowUserPanelAction;
import com.tencent.state.publicchat.action.ViewTaFocusAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.UserInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.publicchat.action.ApplyCallGatherAction;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FastClickUtils;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yr4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 12\u00020\u0001:\u00011BN\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00020!\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 R2\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00020!8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010)\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "Landroid/widget/FrameLayout;", "", "initView", "Lcom/tencent/state/publicchat/action/MsgAction;", "action", "doDispatchAction", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/state/publicchat/data/MsgInfo;", "msg", "Lcom/tencent/state/publicchat/data/UserInfo;", QCircleAlphaUserReporter.KEY_USER, "triggerUserPanel", "triggerMsgPanel", "triggerViewTaAction", "Lyr4/d;", "info", "triggerFocusAction", "", "isOuterMsgPanelEnabled", "Lcom/tencent/state/utils/FastClickUtils;", "fastClickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "getConf", "()Lcom/tencent/state/publicchat/data/MsgConfInfo;", "Lcom/tencent/state/publicchat/data/MsgInfo;", "getMsg", "()Lcom/tencent/state/publicchat/data/MsgInfo;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dispatchAction", "Lkotlin/jvm/functions/Function1;", "getDispatchAction", "()Lkotlin/jvm/functions/Function1;", "Lcom/tencent/state/template/data/RoomThemeData;", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "getThemeData", "()Lcom/tencent/state/template/data/RoomThemeData;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;Lcom/tencent/state/template/data/RoomThemeData;)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class AbstractMessageItemView extends FrameLayout {
    private static final int DEFAULT_BG_RES_ID = R.drawable.gvf;
    private static final int DEFAULT_BG_RES_ID_ME = R.drawable.gvg;
    private static final int PADDING_HORIZONTAL_DP = 9;
    private static final int PADDING_VERTICAL_DP = 8;
    private final MsgConfInfo conf;
    private final Function1<MsgAction, Unit> dispatchAction;
    private FastClickUtils fastClickUtils;
    private final MsgInfo msg;
    private final RoomThemeData themeData;

    public /* synthetic */ AbstractMessageItemView(Context context, MsgConfInfo msgConfInfo, MsgInfo msgInfo, Function1 function1, RoomThemeData roomThemeData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, msgConfInfo, msgInfo, function1, (i3 & 16) != 0 ? null : roomThemeData);
    }

    private final void initView() {
        int i3;
        DrawableUtil drawableUtil = DrawableUtil.INSTANCE;
        if (CommonDataKt.isMe(this.msg.getUser().getUin())) {
            i3 = DEFAULT_BG_RES_ID_ME;
        } else {
            i3 = DEFAULT_BG_RES_ID;
        }
        setBackground(drawableUtil.getDrawable(i3));
        setPadding(ViewExtensionsKt.dip(getContext(), 9), ViewExtensionsKt.dip(getContext(), 8), ViewExtensionsKt.dip(getContext(), 9), ViewExtensionsKt.dip(getContext(), 8));
        if (isOuterMsgPanelEnabled()) {
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.view.AbstractMessageItemView$initView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    AbstractMessageItemView abstractMessageItemView = AbstractMessageItemView.this;
                    abstractMessageItemView.triggerMsgPanel(iArr[0] + ViewExtensionsKt.dip(abstractMessageItemView.getContext(), 41), iArr[1]);
                }
            });
        }
    }

    public final void doDispatchAction(final MsgAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.AbstractMessageItemView$doDispatchAction$1
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
                AbstractMessageItemView.this.getDispatchAction().invoke(action);
            }
        });
    }

    public final MsgConfInfo getConf() {
        return this.conf;
    }

    public final Function1<MsgAction, Unit> getDispatchAction() {
        return this.dispatchAction;
    }

    public final MsgInfo getMsg() {
        return this.msg;
    }

    public final RoomThemeData getThemeData() {
        return this.themeData;
    }

    public boolean isOuterMsgPanelEnabled() {
        return true;
    }

    public final void triggerFocusAction(d info) {
        Intrinsics.checkNotNullParameter(info, "info");
        doDispatchAction(new ApplyCallGatherAction(this.msg, info));
    }

    public final void triggerMsgPanel(int x16, int y16) {
        doDispatchAction(new ShowMsgPanelAction(x16, y16, this.msg));
    }

    public final void triggerUserPanel(int x16, int y16, MsgInfo msg2, UserInfo user) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        doDispatchAction(new ShowUserPanelAction(x16, y16, msg2, user));
    }

    public final void triggerViewTaAction(UserInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        doDispatchAction(new ViewTaFocusAction(user));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMessageItemView(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData roomThemeData) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        this.conf = conf;
        this.msg = msg2;
        this.dispatchAction = dispatchAction;
        this.themeData = roomThemeData;
        this.fastClickUtils = new FastClickUtils(800L);
        initView();
    }
}
