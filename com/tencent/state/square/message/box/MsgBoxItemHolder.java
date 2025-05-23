package com.tencent.state.square.message.box;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.IVasBaseServiceProvider;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.CircleBoarderImageView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000207H\u0002J\u0010\u0010;\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010<\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010=\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u001a\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020BH\u0002J\u001c\u0010C\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0D2\u0006\u00108\u001a\u000209H\u0002J\u0018\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020EH\u0002J\b\u0010J\u001a\u000207H\u0002J\u0010\u0010K\u001a\u0002072\u0006\u00108\u001a\u000209H\u0014J\u0012\u0010L\u001a\u0002072\b\u0010M\u001a\u0004\u0018\u00010\bH\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010&\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\rR\u0011\u0010,\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00104\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001d\u00a8\u0006O"}, d2 = {"Lcom/tencent/state/square/message/box/MsgBoxItemHolder;", "Lcom/tencent/state/square/message/box/MsgBoxBaseHolder;", "Landroid/view/View$OnClickListener;", "msgBoxContext", "Lcom/tencent/state/square/message/box/MsgBoxContext;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/message/box/MsgBoxPanel;", "itemView", "Landroid/view/View;", "(Lcom/tencent/state/square/message/box/MsgBoxContext;Lcom/tencent/state/square/message/box/MsgBoxPanel;Landroid/view/View;)V", "avatarContainer", "Landroid/widget/FrameLayout;", "getAvatarContainer", "()Landroid/widget/FrameLayout;", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getAvatarFaceDecoder", "()Lcom/tencent/state/square/api/IFaceDecoder;", "avatarIcon", "Lcom/tencent/state/view/CircleBoarderImageView;", "getAvatarIcon", "()Lcom/tencent/state/view/CircleBoarderImageView;", "contentContainer", "Landroid/widget/RelativeLayout;", "getContentContainer", "()Landroid/widget/RelativeLayout;", "fromTextView", "Landroid/widget/TextView;", "getFromTextView", "()Landroid/widget/TextView;", "nickTextView", "getNickTextView", "operateAddGroup", "getOperateAddGroup", "operateContainer", "getOperateContainer", "operateLocateGroup", "getOperateLocateGroup", "reddotIcon", "getReddotIcon", "reporter", "Lcom/tencent/state/square/IReporter;", "summaryContainer", "getSummaryContainer", "summaryTextView", "getSummaryTextView", "summaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", "getSummaryView", "()Lcom/tencent/state/square/api/ISquareSummaryView;", "setSummaryView", "(Lcom/tencent/state/square/api/ISquareSummaryView;)V", "timeTextView", "getTimeTextView", "bindAvatarInfo", "", "data", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "bindListener", "bindOperateIcon", "bindPreviewInfo", "bindUnReadNum", "bindUnReadNumWithoutCheck", "number", "", "gray", "", "getCommonReportParams", "", "", "", "getUserName", "nick", "uin", "initReport", "onBindData", NodeProps.ON_CLICK, "v", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MsgBoxItemHolder extends MsgBoxBaseHolder implements View.OnClickListener {
    private static final String TAG = "SquareMsgBoxItemHolder";
    private final FrameLayout avatarContainer;
    private final IFaceDecoder avatarFaceDecoder;
    private final CircleBoarderImageView avatarIcon;
    private final RelativeLayout contentContainer;
    private final TextView fromTextView;
    private final TextView nickTextView;
    private final RelativeLayout operateAddGroup;
    private final FrameLayout operateContainer;
    private final RelativeLayout operateLocateGroup;
    private final TextView reddotIcon;
    private final IReporter reporter;
    private final FrameLayout summaryContainer;
    private final TextView summaryTextView;
    private ISquareSummaryView summaryView;
    private final TextView timeTextView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageRecordType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageRecordType.RECORD_TYPE_SQUARE_TEMP.ordinal()] = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBoxItemHolder(MsgBoxContext msgBoxContext, MsgBoxPanel panel, View itemView) {
        super(msgBoxContext, panel, 1, itemView);
        Intrinsics.checkNotNullParameter(msgBoxContext, "msgBoxContext");
        Intrinsics.checkNotNullParameter(panel, "panel");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.qxi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026ox_item_avatar_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.avatarContainer = frameLayout;
        View findViewById2 = frameLayout.findViewById(R.id.qxh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "avatarContainer.findView\u2026uare_msg_box_item_avatar)");
        this.avatarIcon = (CircleBoarderImageView) findViewById2;
        View findViewById3 = frameLayout.findViewById(R.id.qxv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "avatarContainer.findView\u2026uare_msg_box_item_reddot)");
        this.reddotIcon = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.qxk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026x_item_content_container)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById4;
        this.contentContainer = relativeLayout;
        View findViewById5 = relativeLayout.findViewById(R.id.qxm);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentContainer.findVie\u2026square_msg_box_item_nick)");
        this.nickTextView = (TextView) findViewById5;
        View findViewById6 = relativeLayout.findViewById(R.id.qxy);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentContainer.findVie\u2026square_msg_box_item_time)");
        this.timeTextView = (TextView) findViewById6;
        View findViewById7 = relativeLayout.findViewById(R.id.qxl);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentContainer.findVie\u2026square_msg_box_item_from)");
        this.fromTextView = (TextView) findViewById7;
        View findViewById8 = relativeLayout.findViewById(R.id.qxw);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentContainer.findVie\u2026x_item_summary_container)");
        FrameLayout frameLayout2 = (FrameLayout) findViewById8;
        this.summaryContainer = frameLayout2;
        View findViewById9 = relativeLayout.findViewById(R.id.qxx);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "contentContainer.findVie\u2026sg_box_item_summary_text)");
        TextView textView = (TextView) findViewById9;
        this.summaryTextView = textView;
        View findViewById10 = itemView.findViewById(R.id.qxq);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.\u2026x_item_operate_container)");
        FrameLayout frameLayout3 = (FrameLayout) findViewById10;
        this.operateContainer = frameLayout3;
        View findViewById11 = frameLayout3.findViewById(R.id.qxn);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "operateContainer.findVie\u2026msg_box_item_operate_add)");
        this.operateAddGroup = (RelativeLayout) findViewById11;
        View findViewById12 = frameLayout3.findViewById(R.id.qxr);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "operateContainer.findVie\u2026_box_item_operate_locate)");
        this.operateLocateGroup = (RelativeLayout) findViewById12;
        Square square = Square.INSTANCE;
        this.avatarFaceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
        this.reporter = square.getConfig().getReporter();
        ISquareSummaryView iSquareSummaryView = null;
        ISquareSummaryView summaryView$default = ICommonUtils.DefaultImpls.getSummaryView$default(square.getConfig().getCommonUtils(), msgBoxContext.getActivity(), null, 2, null);
        if (summaryView$default != null) {
            View view = summaryView$default.getView();
            frameLayout2.addView(view, new FrameLayout.LayoutParams(-1, -1));
            view.setVisibility(0);
            textView.setVisibility(8);
            Unit unit = Unit.INSTANCE;
            iSquareSummaryView = summaryView$default;
        }
        this.summaryView = iSquareSummaryView;
        initReport();
    }

    private final void bindAvatarInfo(final SquareBaseMessageRecord data) {
        if (data.isSquareLibrary()) {
            getMsgBoxContext().getMsgBoxManager().getStrangerNickName(data.getUin(), new Function2<String, String, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxItemHolder$bindAvatarInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final String uin, final String nick) {
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    Intrinsics.checkNotNullParameter(nick, "nick");
                    MsgBoxItemHolder.this.getMsgBoxContext().runOnUiThread(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxItemHolder$bindAvatarInfo$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (Intrinsics.areEqual(uin, data.getUin())) {
                                data.setNickName(nick);
                                MsgBoxItemHolder.this.getNickTextView().setText(nick);
                            }
                        }
                    });
                }
            });
        } else {
            this.nickTextView.setText(getUserName(data.getNickName(), data.getUin()));
        }
        FaceUtils.INSTANCE.loadHeadIcon(this.avatarFaceDecoder, this.avatarIcon, data.getUin(), data.isTroop(), new Function1<String, Boolean>() { // from class: com.tencent.state.square.message.box.MsgBoxItemHolder$bindAvatarInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(String str) {
                SquareBaseMessageRecord msgData = MsgBoxItemHolder.this.getMsgData();
                return TextUtils.equals(str, msgData != null ? msgData.getUin() : null);
            }
        });
    }

    private final void bindListener() {
        this.operateAddGroup.setOnClickListener(this);
        this.operateLocateGroup.setOnClickListener(this);
        this.itemView.setOnClickListener(this);
    }

    private final void bindOperateIcon(SquareBaseMessageRecord data) {
        if (getMsgBoxContext().getMsgBoxManager().getSource() == MsgBoxSource.SQUARE && !data.isSquareLibrary()) {
            this.operateContainer.setVisibility(0);
            ISquareViewUpdater squareViewUpdater = getMsgBoxContext().getManagerProxy().getSquareViewUpdater();
            boolean z16 = !(squareViewUpdater != null ? squareViewUpdater.isNotInSquare(data.getUin(), getMsgBoxContext().getMsgBoxManager().covert2SquareItemType(data)) : true);
            this.operateAddGroup.setVisibility(!z16 ? 0 : 8);
            this.operateLocateGroup.setVisibility(z16 ? 0 : 8);
            return;
        }
        this.operateContainer.setVisibility(8);
    }

    private final void bindPreviewInfo(SquareBaseMessageRecord data) {
        ISquareBaseMessageService messageService;
        TextView textView = this.timeTextView;
        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
        Context context = this.timeTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "timeTextView.context");
        textView.setText(commonUtils.formatTimeForMsgBox(context, data.getLastTimeStamp() * 1000));
        boolean z16 = true;
        if (WhenMappings.$EnumSwitchMapping$0[data.getRecordType().ordinal()] != 1) {
            this.fromTextView.setVisibility(8);
        } else {
            IVasBaseServiceProvider provider = getMsgBoxContext().getProvider();
            if (provider != null && (messageService = provider.getMessageService()) != null) {
                z16 = messageService.isFriend(data.getUin());
            }
            if (!z16) {
                this.fromTextView.setVisibility(0);
                this.fromTextView.setText(R.string.xgy);
            } else {
                this.fromTextView.setVisibility(8);
                this.fromTextView.setText((CharSequence) null);
            }
        }
        ISquareSummaryView iSquareSummaryView = this.summaryView;
        if (iSquareSummaryView != null) {
            ISquareSummaryView.DefaultImpls.setSummaryData$default(iSquareSummaryView, data.getSummaryData(), null, 2, null);
        }
        TextView textView2 = this.summaryTextView;
        String lastMsg = data.getLastMsg();
        if (lastMsg == null) {
            lastMsg = "";
        }
        textView2.setText(lastMsg);
    }

    private final void bindUnReadNum(SquareBaseMessageRecord data) {
        if (data.getUnreadCount() <= 0) {
            boolean unReadMark = data.getUnReadMark();
            bindUnReadNumWithoutCheck(unReadMark ? 1 : 0, data.getForbiddenNotify());
            return;
        }
        bindUnReadNumWithoutCheck(data.getUnreadCount(), data.getForbiddenNotify());
    }

    private final void bindUnReadNumWithoutCheck(int number, boolean gray) {
        String valueOf;
        this.reddotIcon.setVisibility(number <= 0 ? 8 : 0);
        this.reddotIcon.setBackgroundResource(gray ? R.drawable.gwn : R.drawable.gwm);
        TextView textView = this.reddotIcon;
        if (number > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(number);
        }
        textView.setText(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getCommonReportParams(SquareBaseMessageRecord data) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_MSG_BOX_FRIEND_TYPE, Integer.valueOf(!data.isFriend() ? 1 : 0));
        return linkedHashMap;
    }

    private final String getUserName(String nick, String uin) {
        return nick.length() == 0 ? SquareBaseKt.getSquareCommon().getFriendRemarkName(uin, uin) : nick;
    }

    private final void initReport() {
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            View rootView = getPanel().getRootView();
            View rootView2 = getPanel().getRootView();
            String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(itemView.getContext()));
            Unit unit = Unit.INSTANCE;
            iReporter.setPageInfo(rootView, rootView2, checkNearby, linkedHashMap);
        }
        IReporter iReporter2 = this.reporter;
        if (iReporter2 != null) {
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            iReporter2.setElementInfo(itemView2, SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_ITEM, new LinkedHashMap(), false, false);
        }
        IReporter iReporter3 = this.reporter;
        if (iReporter3 != null) {
            iReporter3.setElementInfo(this.operateAddGroup, SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_ADD_BTN, new LinkedHashMap(), false, false);
        }
        IReporter iReporter4 = this.reporter;
        if (iReporter4 != null) {
            iReporter4.setElementInfo(this.operateLocateGroup, SquareReportConst.ElementId.ELEMENT_ID_MSG_BOX_FIND_BTN, new LinkedHashMap(), false, false);
        }
    }

    public final FrameLayout getAvatarContainer() {
        return this.avatarContainer;
    }

    public final IFaceDecoder getAvatarFaceDecoder() {
        return this.avatarFaceDecoder;
    }

    public final CircleBoarderImageView getAvatarIcon() {
        return this.avatarIcon;
    }

    public final RelativeLayout getContentContainer() {
        return this.contentContainer;
    }

    public final TextView getFromTextView() {
        return this.fromTextView;
    }

    public final TextView getNickTextView() {
        return this.nickTextView;
    }

    public final RelativeLayout getOperateAddGroup() {
        return this.operateAddGroup;
    }

    public final FrameLayout getOperateContainer() {
        return this.operateContainer;
    }

    public final RelativeLayout getOperateLocateGroup() {
        return this.operateLocateGroup;
    }

    public final TextView getReddotIcon() {
        return this.reddotIcon;
    }

    public final FrameLayout getSummaryContainer() {
        return this.summaryContainer;
    }

    public final TextView getSummaryTextView() {
        return this.summaryTextView;
    }

    public final ISquareSummaryView getSummaryView() {
        return this.summaryView;
    }

    public final TextView getTimeTextView() {
        return this.timeTextView;
    }

    @Override // com.tencent.state.square.message.box.MsgBoxBaseHolder
    protected void onBindData(final SquareBaseMessageRecord data) {
        Intrinsics.checkNotNullParameter(data, "data");
        bindAvatarInfo(data);
        bindUnReadNum(data);
        bindPreviewInfo(data);
        bindOperateIcon(data);
        bindListener();
        this.itemView.post(new Runnable() { // from class: com.tencent.state.square.message.box.MsgBoxItemHolder$onBindData$1
            @Override // java.lang.Runnable
            public final void run() {
                IReporter iReporter;
                Map<String, Object> commonReportParams;
                iReporter = MsgBoxItemHolder.this.reporter;
                if (iReporter != null) {
                    View itemView = MsgBoxItemHolder.this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    commonReportParams = MsgBoxItemHolder.this.getCommonReportParams(data);
                    iReporter.reportEvent("imp", itemView, commonReportParams);
                }
            }
        });
    }

    public final void setSummaryView(ISquareSummaryView iSquareSummaryView) {
        this.summaryView = iSquareSummaryView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        ISquareBaseMessageService messageService;
        ISquareBaseMessageService messageService2;
        ISquareBaseMessageService messageService3;
        MainScene mainScene;
        ArrayList arrayListOf;
        final SquareBaseMessageRecord msgData = getMsgData();
        if (msgData == null || v3 == null) {
            return;
        }
        int id5 = v3.getId();
        if (id5 == R.id.qxr) {
            getMsgBoxContext().getMsgBoxManager().hideMsgListPanel(MsgBoxOperateFlag.CLICK_ITEM_LOCATE);
            IMapViewManipulator squareViewAbility = getMsgBoxContext().getManagerProxy().getSquareViewAbility();
            if (squareViewAbility != null) {
                squareViewAbility.locateTo(msgData.getUin(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.message.box.MsgBoxItemHolder$onClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        ISquareViewUpdater squareViewUpdater = MsgBoxItemHolder.this.getMsgBoxContext().getManagerProxy().getSquareViewUpdater();
                        if (squareViewUpdater != null) {
                            squareViewUpdater.playRingAnim(msgData.getUin());
                        }
                    }
                });
            }
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                iReporter.reportEvent("clck", this.operateLocateGroup, getCommonReportParams(msgData));
                return;
            }
            return;
        }
        if (id5 == R.id.qxn) {
            getMsgBoxContext().getMsgBoxManager().hideMsgListPanel(MsgBoxOperateFlag.CLICK_ITEM_ADD);
            VasBaseFragment vasBaseFragment = getMsgBoxContext().getFragment().get();
            Fragment topFragment = vasBaseFragment != null ? vasBaseFragment.getTopFragment() : null;
            VasBaseFragment vasBaseFragment2 = (VasBaseFragment) (topFragment instanceof VasBaseFragment ? topFragment : null);
            if (vasBaseFragment2 == null || (mainScene = vasBaseFragment2.getMainScene()) == null) {
                mainScene = MainScene.UNKNOWN;
            }
            MainScene mainScene2 = mainScene;
            ISquareRoleManager squareRoleManager = getMsgBoxContext().getManagerProxy().getSquareRoleManager();
            if (squareRoleManager != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new MoveItem(msgData.getUin(), getMsgBoxContext().getMsgBoxManager().covert2SquareItemType(msgData), false, null, 12, null));
                ISquareRoleManager.DefaultImpls.addMultiRoles$default(squareRoleManager, arrayListOf, 3, mainScene2, null, false, false, null, 120, null);
            }
            IReporter iReporter2 = this.reporter;
            if (iReporter2 != null) {
                iReporter2.reportEvent("clck", this.operateAddGroup, getCommonReportParams(msgData));
                return;
            }
            return;
        }
        if (msgData.isFriend()) {
            IVasBaseServiceProvider provider = getMsgBoxContext().getProvider();
            if (provider != null && (messageService3 = provider.getMessageService()) != null) {
                ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService3, getMsgBoxContext().getFragment().get(), 0, msgData.getUin(), MessageRecordType.RECORD_TYPE_FRIEND, false, false, null, null, null, w.CTRL_INDEX, null);
            }
        } else if (msgData.isTroop()) {
            IVasBaseServiceProvider provider2 = getMsgBoxContext().getProvider();
            if (provider2 != null && (messageService2 = provider2.getMessageService()) != null) {
                ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService2, getMsgBoxContext().getFragment().get(), 0, msgData.getUin(), MessageRecordType.RECORD_TYPE_TROOP, false, false, null, null, null, w.CTRL_INDEX, null);
            }
        } else if (msgData.isSquareLibrary()) {
            IVasBaseServiceProvider provider3 = getMsgBoxContext().getProvider();
            if (provider3 != null && (messageService = provider3.getMessageService()) != null) {
                ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService, getMsgBoxContext().getFragment().get(), 0, msgData.getUin(), MessageRecordType.RECORD_TYPE_SQUARE_TEMP, false, false, null, msgData.getNickName(), null, 368, null);
            }
        } else {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "click item but unSupport", null, 4, null);
        }
        IReporter iReporter3 = this.reporter;
        if (iReporter3 != null) {
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            iReporter3.reportEvent("clck", itemView, getCommonReportParams(msgData));
        }
    }

    static /* synthetic */ void bindUnReadNumWithoutCheck$default(MsgBoxItemHolder msgBoxItemHolder, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        msgBoxItemHolder.bindUnReadNumWithoutCheck(i3, z16);
    }
}
