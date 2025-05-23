package com.tencent.state.library.focus.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.focus.FocusGroupListener;
import com.tencent.state.library.focus.GroupAvatarAnimator;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.view.LibraryTableView;
import com.tencent.state.map.AvatarLocationConfig;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapViewConfigKt;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareSummaryView;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.databinding.VasSquareLibraryGroupViewBinding;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.PlayConfig;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.publicchat.view.CallMateButtonView;
import com.tencent.state.view.BaseAvatarAnimator;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\u0016\u0010-\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010.\u001a\u00020\u0019J \u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u000205J\"\u00106\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010#2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010=J\b\u0010>\u001a\u00020\u0019H\u0002J\u001e\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020DJ\u0018\u0010E\u001a\u00020\u00192\u0006\u00104\u001a\u0002052\b\u0010F\u001a\u0004\u0018\u00010GJ\u0018\u0010H\u001a\u00020\u00192\u0006\u00100\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010I\u001a\u00020\u00192\u0006\u0010B\u001a\u00020A2\b\u0010C\u001a\u0004\u0018\u00010DJ\u0006\u0010J\u001a\u00020\u0019J\u0016\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020:2\u0006\u0010M\u001a\u00020NJ\"\u0010O\u001a\u00020\u00192\u0006\u0010P\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010Q\u001a\u00020\u0019J$\u0010R\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010B\u001a\u00020A2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\"\u0010S\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020#2\u0006\u0010P\u001a\u0002012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/tencent/state/library/focus/view/FocusGroupView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/library/focus/IFocusParentView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Lcom/tencent/state/library/focus/GroupAvatarAnimator;", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryGroupViewBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareLibraryGroupViewBinding;", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/AvatarLocationConfig;", "data", "Lcom/tencent/state/library/focus/data/FocusGroupItem;", "listener", "Lcom/tencent/state/library/focus/FocusGroupListener;", "summaryView", "Lcom/tencent/state/square/api/ISquareSummaryView;", "bindChatView", "", "bindTableView", "table", "Lcom/tencent/state/library/view/LibraryTableView;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "location", "Lcom/tencent/state/map/Location;", "clickChatMessage", "v", "Landroid/view/View;", "clickHitArea", "type", "getCommonView", "Lcom/tencent/state/library/focus/view/FocusCommonView;", "getGroupBetweenMargin", "Landroid/util/Size;", "getView", "initAvatarAndTableLocation", "initClickListener", "initView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "playAvatar", "view", "Lcom/tencent/state/square/avatar/SquareAvatarView;", "hideTableView", "playTargetAvatar", "isLeft", "", "refreshAlpha", c.f123400v, "", "desc", "", "setUnReadView", "message", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "startEnterAnima", "switchTable", "roomId", "", "tabId", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "updateAvatar", "resource", "Lcom/tencent/state/square/data/Resource;", "updateAvatarTableLocation", "updateBubbleData", "updateCallMateBtn", "updateDeskMateTag", "uin", "tag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "updateTableUI", "avatar", "updateTableView", "updateUser", "updateViewAlpha", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusGroupView extends FrameLayout implements IFocusParentView {
    private static final String MAX_COUNT_TEXT = "99+";
    private static final String TAG = "FocusGroupView";
    private GroupAvatarAnimator animator;
    private final VasSquareLibraryGroupViewBinding binding;
    private final AvatarLocationConfig config;
    private FocusGroupItem data;
    private FocusGroupListener listener;
    private ISquareSummaryView summaryView;

    public FocusGroupView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void bindChatView() {
        boolean z16 = SquareBaseKt.getSquareCommon().getNeedShieldTeenager() && SquareBaseKt.getSquareCommon().getStudyMode();
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bindChatView: hasMe=");
        FocusGroupItem focusGroupItem = this.data;
        sb5.append(focusGroupItem != null ? Boolean.valueOf(FocusDataKt.hasMe(focusGroupItem)) : null);
        sb5.append(" data=");
        sb5.append(this.data);
        squareLog.i(TAG, sb5.toString());
        FocusGroupItem focusGroupItem2 = this.data;
        if (focusGroupItem2 != null && FocusDataKt.hasMe(focusGroupItem2) && !z16) {
            LinearLayout linearLayout = this.binding.customChatView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customChatView");
            linearLayout.setVisibility(0);
            FocusGroupItem focusGroupItem3 = this.data;
            if (focusGroupItem3 != null && !focusGroupItem3.isSingleUser()) {
                TextView textView = this.binding.customNewMessageTips;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.customNewMessageTips");
                textView.setText(getResources().getString(R.string.xg_));
                this.binding.customNewMessageTips.setTextColor(Color.parseColor("#888888"));
                refreshAlpha(this.binding.customChatBox, 1.0f, "bindChatView");
            } else {
                TextView textView2 = this.binding.customNewMessageTips;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.customNewMessageTips");
                textView2.setText(getResources().getString(R.string.xga));
                this.binding.customNewMessageTips.setTextColor(Color.parseColor("#666666"));
                refreshAlpha(this.binding.customChatBox, 0.3f, "bindChatView");
            }
        } else {
            LinearLayout linearLayout2 = this.binding.customChatView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.customChatView");
            linearLayout2.setVisibility(4);
        }
        FocusGroupItem focusGroupItem4 = this.data;
        if (focusGroupItem4 == null || !focusGroupItem4.isSingleUser()) {
            return;
        }
        LinearLayout linearLayout3 = this.binding.customBubbleParent;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.customBubbleParent");
        if (linearLayout3.getVisibility() == 0) {
            LinearLayout linearLayout4 = this.binding.customBubbleParent;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.customBubbleParent");
            linearLayout4.setVisibility(4);
        }
    }

    private final void bindTableView(LibraryTableView table, FocusItem item, Location location) {
        table.updateHitAreaLocation(new Rect(location.getX(), location.getY(), location.getX() + location.getWidth(), location.getY() + location.getHeight()), location);
        table.bindTableImage(item.getTable().getImage().getUrl(), new Size(this.config.getAvatarWidth(), this.config.getAvatarHeight()));
        table.bindBrandOrExpect(item.getTable(), this.config.getAvatarWidth() / item.getTable().getLocation().getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickChatMessage(View v3) {
        FocusGroupItem focusGroupItem;
        String meDeskUin;
        FocusGroupItem focusGroupItem2 = this.data;
        if ((focusGroupItem2 != null && focusGroupItem2.isSingleUser()) || (focusGroupItem = this.data) == null || (meDeskUin = FocusDataKt.meDeskUin(focusGroupItem)) == null) {
            return;
        }
        FocusGroupListener focusGroupListener = this.listener;
        if (focusGroupListener != null) {
            focusGroupListener.clearUnReadCache(meDeskUin);
        }
        FocusGroupListener focusGroupListener2 = this.listener;
        if (focusGroupListener2 != null) {
            FocusGroupItem focusGroupItem3 = this.data;
            focusGroupListener2.onChatBoxClicked(v3, meDeskUin, focusGroupItem3 != null ? FocusDataKt.meDeskNick(focusGroupItem3) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickHitArea(int type, FocusItem item) {
        FocusGroupListener focusGroupListener;
        if (item.getTable().getUser() == null && (focusGroupListener = this.listener) != null) {
            focusGroupListener.onEmptyTableClicked(type, item);
        }
    }

    private final Size getGroupBetweenMargin() {
        if (this.data != null) {
            float avatarWidth = this.config.getAvatarWidth() / r0.getRightItem().getTable().getLocation().getWidth();
            return new Size((int) ((r0.getRightItem().getTable().getLocation().getX() - r0.getLeftItem().getTable().getLocation().getX()) * avatarWidth), (int) ((r0.getRightItem().getTable().getLocation().getY() - r0.getLeftItem().getTable().getLocation().getY()) * avatarWidth));
        }
        return new Size(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initAvatarAndTableLocation() {
        Location leftAvatarLocation;
        GroupAvatarAnimator groupAvatarAnimator;
        Location rightAvatarLocation;
        GroupAvatarAnimator groupAvatarAnimator2 = this.animator;
        if (groupAvatarAnimator2 == null || (leftAvatarLocation = groupAvatarAnimator2.getLeftAvatarLocation()) == null || (groupAvatarAnimator = this.animator) == null || (rightAvatarLocation = groupAvatarAnimator.getRightAvatarLocation()) == null) {
            return;
        }
        SquareAvatarView squareAvatarView = this.binding.leftAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.leftAvatarImage");
        updateAvatarTableLocation(squareAvatarView, leftAvatarLocation);
        LibraryTableView libraryTableView = this.binding.leftTab;
        Intrinsics.checkNotNullExpressionValue(libraryTableView, "binding.leftTab");
        updateAvatarTableLocation(libraryTableView, leftAvatarLocation);
        SquareAvatarView squareAvatarView2 = this.binding.rightAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView2, "binding.rightAvatarImage");
        updateAvatarTableLocation(squareAvatarView2, rightAvatarLocation);
        LibraryTableView libraryTableView2 = this.binding.rightTab;
        Intrinsics.checkNotNullExpressionValue(libraryTableView2, "binding.rightTab");
        updateAvatarTableLocation(libraryTableView2, rightAvatarLocation);
    }

    private final void initClickListener() {
        this.binding.commonView.setClickListener(new Function1<ClickType, Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$initClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClickType clickType) {
                invoke2(clickType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClickType it) {
                FocusGroupListener focusGroupListener;
                Intrinsics.checkNotNullParameter(it, "it");
                focusGroupListener = FocusGroupView.this.listener;
                if (focusGroupListener != null) {
                    focusGroupListener.doFuncBtnClick(it);
                }
            }
        });
        this.binding.customBubbleParent.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.FocusGroupView$initClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                FocusGroupView focusGroupView = FocusGroupView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                focusGroupView.clickChatMessage(it);
            }
        });
        this.binding.customChatBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.library.focus.view.FocusGroupView$initClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                FocusGroupView focusGroupView = FocusGroupView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                focusGroupView.clickChatMessage(it);
            }
        });
        this.binding.leftTab.setClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$initClickListener$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
            
                r2 = r1.this$0.data;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(View view, int i3) {
                FocusGroupItem focusGroupItem;
                FocusItem leftItem;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                if ((i3 != 0 && i3 != 1) || focusGroupItem == null || (leftItem = focusGroupItem.getLeftItem()) == null) {
                    return;
                }
                FocusGroupView.this.clickHitArea(i3, leftItem);
            }
        });
        this.binding.rightTab.setClickListener(new Function2<View, Integer, Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$initClickListener$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num) {
                invoke(view, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
            
                r2 = r1.this$0.data;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(View view, int i3) {
                FocusGroupItem focusGroupItem;
                FocusItem rightItem;
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                if ((i3 != 0 && i3 != 1) || focusGroupItem == null || (rightItem = focusGroupItem.getRightItem()) == null) {
                    return;
                }
                FocusGroupView.this.clickHitArea(i3, rightItem);
            }
        });
    }

    private final void playAvatar(final SquareAvatarView view, final View hideTableView, final FocusItem item) {
        UserCommon info;
        Resource focusResource = FocusDataKt.focusResource(item);
        if (focusResource != null) {
            Integer num = null;
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("playAvatar, ");
                sb5.append(item != null ? item.getUser() : null);
                sb5.append(", ");
                sb5.append(focusResource);
                squareLog.d(TAG, sb5.toString());
            }
            User user = item.getUser();
            if (user != null && (info = user.getInfo()) != null) {
                num = Integer.valueOf(info.getDefaultResourceId());
            }
            view.setAnimSource(SquareItemKt.toLibraryMapPlayableSource(focusResource, num), new BaseAvatarAnimator.AvatarViewListener() { // from class: com.tencent.state.library.focus.view.FocusGroupView$playAvatar$1
                @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                public void onFirstFrame() {
                    super.onFirstFrame();
                    String str = "playAvatar, firstFrame, " + item;
                    FocusGroupView.this.refreshAlpha(hideTableView, 0.0f, str);
                    view.setVideoViewVisibility(true);
                    FocusGroupView.this.refreshAlpha(view, 1.0f, str);
                }

                @Override // com.tencent.state.view.BaseAvatarAnimator.AvatarViewListener, com.tencent.state.square.avatar.IAvatarAnimListener
                public void onPlayError(int errorCode) {
                    super.onPlayError(errorCode);
                    FocusGroupView.this.refreshAlpha(hideTableView, 0.0f, "playAvatar, onPlayError, " + item);
                    view.setImageViewVisibility(true);
                    view.setVideoViewVisibility(false);
                }
            }, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startEnterAnima() {
        FocusItem rightItem;
        Resource focusResource;
        FocusItem rightItem2;
        User user;
        UserCommon info;
        SquareAvatarView squareAvatarView = this.binding.leftAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.leftAvatarImage");
        SquareAvatarView squareAvatarView2 = this.binding.rightAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView2, "binding.rightAvatarImage");
        GroupAvatarAnimator groupAvatarAnimator = new GroupAvatarAnimator(squareAvatarView, squareAvatarView2, new Size(getWidth(), getHeight()), this.config, getGroupBetweenMargin());
        this.animator = groupAvatarAnimator;
        BaseAvatarAnimator rightAnimator = groupAvatarAnimator.getRightAnimator();
        if (rightAnimator != null) {
            FocusGroupItem focusGroupItem = this.data;
            MapPlayableSource mapPlayableSource = null;
            r2 = null;
            r2 = null;
            r2 = null;
            Integer num = null;
            mapPlayableSource = null;
            mapPlayableSource = null;
            if (focusGroupItem != null && (rightItem = focusGroupItem.getRightItem()) != null && (focusResource = FocusDataKt.focusResource(rightItem)) != null) {
                FocusGroupItem focusGroupItem2 = this.data;
                if (focusGroupItem2 != null && (rightItem2 = focusGroupItem2.getRightItem()) != null && (user = rightItem2.getUser()) != null && (info = user.getInfo()) != null) {
                    num = Integer.valueOf(info.getDefaultResourceId());
                }
                mapPlayableSource = SquareItemKt.toLibraryMapPlayableSource(focusResource, num);
            }
            rightAnimator.enterScaleAnim(mapPlayableSource, false, new Function0<Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$startEnterAnima$1
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
                    FocusGroupItem focusGroupItem3;
                    GroupAvatarAnimator groupAvatarAnimator2;
                    BaseAvatarAnimator leftAnimator;
                    FocusGroupItem focusGroupItem4;
                    FocusItem leftItem;
                    Resource focusResource2;
                    FocusGroupItem focusGroupItem5;
                    FocusItem leftItem2;
                    User user2;
                    UserCommon info2;
                    FocusGroupView focusGroupView = FocusGroupView.this;
                    LibraryTableView libraryTableView = focusGroupView.getBinding().rightTab;
                    Intrinsics.checkNotNullExpressionValue(libraryTableView, "binding.rightTab");
                    SquareAvatarView squareAvatarView3 = FocusGroupView.this.getBinding().rightAvatarImage;
                    Intrinsics.checkNotNullExpressionValue(squareAvatarView3, "binding.rightAvatarImage");
                    focusGroupItem3 = FocusGroupView.this.data;
                    MapPlayableSource mapPlayableSource2 = null;
                    r4 = null;
                    r4 = null;
                    r4 = null;
                    Integer num2 = null;
                    mapPlayableSource2 = null;
                    mapPlayableSource2 = null;
                    focusGroupView.updateViewAlpha(libraryTableView, squareAvatarView3, focusGroupItem3 != null ? focusGroupItem3.getRightItem() : null);
                    groupAvatarAnimator2 = FocusGroupView.this.animator;
                    if (groupAvatarAnimator2 == null || (leftAnimator = groupAvatarAnimator2.getLeftAnimator()) == null) {
                        return;
                    }
                    focusGroupItem4 = FocusGroupView.this.data;
                    if (focusGroupItem4 != null && (leftItem = focusGroupItem4.getLeftItem()) != null && (focusResource2 = FocusDataKt.focusResource(leftItem)) != null) {
                        focusGroupItem5 = FocusGroupView.this.data;
                        if (focusGroupItem5 != null && (leftItem2 = focusGroupItem5.getLeftItem()) != null && (user2 = leftItem2.getUser()) != null && (info2 = user2.getInfo()) != null) {
                            num2 = Integer.valueOf(info2.getDefaultResourceId());
                        }
                        mapPlayableSource2 = SquareItemKt.toLibraryMapPlayableSource(focusResource2, num2);
                    }
                    leftAnimator.enterScaleAnim(mapPlayableSource2, false, new Function0<Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$startEnterAnima$1.1
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
                            FocusGroupItem focusGroupItem6;
                            FocusGroupView focusGroupView2 = FocusGroupView.this;
                            LibraryTableView libraryTableView2 = focusGroupView2.getBinding().leftTab;
                            Intrinsics.checkNotNullExpressionValue(libraryTableView2, "binding.leftTab");
                            SquareAvatarView squareAvatarView4 = FocusGroupView.this.getBinding().leftAvatarImage;
                            Intrinsics.checkNotNullExpressionValue(squareAvatarView4, "binding.leftAvatarImage");
                            focusGroupItem6 = FocusGroupView.this.data;
                            focusGroupView2.updateViewAlpha(libraryTableView2, squareAvatarView4, focusGroupItem6 != null ? focusGroupItem6.getLeftItem() : null);
                        }
                    });
                }
            });
        }
    }

    private final void updateAvatarTableLocation(View view, Location location) {
        view.setX(location.getX());
        view.setY(location.getY());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.config.getAvatarWidth();
        layoutParams.height = this.config.getAvatarHeight();
    }

    public final VasSquareLibraryGroupViewBinding getBinding() {
        return this.binding;
    }

    @Override // com.tencent.state.library.focus.IFocusParentView
    public FocusCommonView getCommonView() {
        FocusCommonView focusCommonView = this.binding.commonView;
        Intrinsics.checkNotNullExpressionValue(focusCommonView, "binding.commonView");
        return focusCommonView;
    }

    public final void initView(FocusGroupItem data, FocusGroupListener listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.data = data;
        this.binding.commonView.initView(data, listener);
        bindChatView();
        post(new Runnable() { // from class: com.tencent.state.library.focus.view.FocusGroupView$initView$1
            @Override // java.lang.Runnable
            public final void run() {
                FocusGroupView.this.startEnterAnima();
                FocusGroupView.this.initAvatarAndTableLocation();
                FocusGroupView.this.updateTableView();
            }
        });
    }

    public final void onDestroy() {
        this.binding.commonView.onDestroy();
    }

    public final void setUnReadView(SquareBaseMessageRecord message) {
        FocusGroupItem focusGroupItem = this.data;
        if (focusGroupItem == null || !focusGroupItem.isSingleUser()) {
            FocusGroupItem focusGroupItem2 = this.data;
            if (focusGroupItem2 == null || FocusDataKt.hasMe(focusGroupItem2)) {
                if (message != null && message.getUnreadCount() != 0) {
                    if (this.summaryView == null) {
                        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        ISquareSummaryView summaryView$default = ICommonUtils.DefaultImpls.getSummaryView$default(commonUtils, context, null, 2, null);
                        this.summaryView = summaryView$default;
                        this.binding.customChatBubble.addView(summaryView$default != null ? summaryView$default.getView() : null, 0);
                    }
                    ISquareSummaryView iSquareSummaryView = this.summaryView;
                    if (iSquareSummaryView != null) {
                        ISquareSummaryView.DefaultImpls.setSummaryData$default(iSquareSummaryView, message.getSummaryData(), null, 2, null);
                    }
                    LinearLayout linearLayout = this.binding.customBubbleParent;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customBubbleParent");
                    if (linearLayout.getVisibility() != 0) {
                        LinearLayout linearLayout2 = this.binding.customBubbleParent;
                        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.customBubbleParent");
                        linearLayout2.setVisibility(0);
                    }
                    if (message.getUnreadCount() > 99) {
                        TextView textView = this.binding.customNewMessageRedPoint;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.customNewMessageRedPoint");
                        textView.setText(MAX_COUNT_TEXT);
                        return;
                    } else {
                        TextView textView2 = this.binding.customNewMessageRedPoint;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.customNewMessageRedPoint");
                        textView2.setText(String.valueOf(message.getUnreadCount()));
                        return;
                    }
                }
                LinearLayout linearLayout3 = this.binding.customBubbleParent;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.customBubbleParent");
                linearLayout3.setVisibility(4);
            }
        }
    }

    public final void switchTable(long roomId, long tabId, User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        FocusGroupItem focusGroupItem = this.data;
        if (focusGroupItem == null || !focusGroupItem.switchTable(roomId, tabId, user)) {
            return;
        }
        updateBubbleData(tabId, user);
    }

    public final void updateBubbleData(long tabId, User user) {
        SquareBaseKt.getSquareLog().i(TAG, "updateBubbleData: tableId=" + tabId + ", user=" + user);
        FocusGroupItem focusGroupItem = this.data;
        updateUser(focusGroupItem != null ? focusGroupItem.getLeftItem() : null, tabId, user);
        FocusGroupItem focusGroupItem2 = this.data;
        updateUser(focusGroupItem2 != null ? focusGroupItem2.getRightItem() : null, tabId, user);
        FocusGroupItem focusGroupItem3 = this.data;
        if (focusGroupItem3 != null) {
            this.binding.commonView.updateBubble(focusGroupItem3);
        }
        bindChatView();
        SquareAvatarView squareAvatarView = this.binding.leftAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.leftAvatarImage");
        LibraryTableView libraryTableView = this.binding.leftTab;
        Intrinsics.checkNotNullExpressionValue(libraryTableView, "binding.leftTab");
        FocusGroupItem focusGroupItem4 = this.data;
        updateTableUI(squareAvatarView, libraryTableView, focusGroupItem4 != null ? focusGroupItem4.getLeftItem() : null);
        SquareAvatarView squareAvatarView2 = this.binding.rightAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView2, "binding.rightAvatarImage");
        LibraryTableView libraryTableView2 = this.binding.rightTab;
        Intrinsics.checkNotNullExpressionValue(libraryTableView2, "binding.rightTab");
        FocusGroupItem focusGroupItem5 = this.data;
        updateTableUI(squareAvatarView2, libraryTableView2, focusGroupItem5 != null ? focusGroupItem5.getRightItem() : null);
        updateCallMateBtn();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        if (r3.isPublicChatEnabled() == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateCallMateBtn() {
        FocusGroupItem focusGroupItem = this.data;
        FocusItem focusItem = focusGroupItem != null ? focusGroupItem.getFocusItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin()) : null;
        FocusGroupListener focusGroupListener = this.listener;
        boolean z16 = focusGroupListener != null;
        if (z16 && focusGroupItem != null && focusItem != null) {
            Table neighbor = focusItem.getTable().getNeighbor();
            if ((neighbor != null ? neighbor.getUser() : null) == null) {
                FocusGroupListener focusGroupListener2 = this.listener;
                if (focusGroupListener2 != null) {
                    CallMateButtonView callMateButtonView = this.binding.callMateBtn;
                    Scene scene = Scene.LIB;
                    String string = getResources().getString(R.string.xg6);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026e_library_call_mate_tips)");
                    callMateButtonView.show(scene, string, new FocusGroupView$updateCallMateBtn$1$1(focusGroupListener2));
                    return;
                }
                return;
            }
        }
        this.binding.callMateBtn.hide();
    }

    public final void updateDeskMateTag(String uin, CommonTagInfo tag) {
        FocusGroupItem focusGroupItem;
        FocusItem rightItem;
        FocusItem rightItem2;
        User user;
        FocusItem leftItem;
        FocusItem leftItem2;
        User user2;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(tag, "tag");
        FocusGroupItem focusGroupItem2 = this.data;
        User user3 = null;
        if (TextUtils.equals((focusGroupItem2 == null || (leftItem2 = focusGroupItem2.getLeftItem()) == null || (user2 = leftItem2.getUser()) == null) ? null : user2.getUin(), uin)) {
            FocusGroupItem focusGroupItem3 = this.data;
            if (focusGroupItem3 != null && (leftItem = focusGroupItem3.getLeftItem()) != null) {
                user3 = leftItem.getUser();
            }
        } else {
            FocusGroupItem focusGroupItem4 = this.data;
            if (TextUtils.equals((focusGroupItem4 == null || (rightItem2 = focusGroupItem4.getRightItem()) == null || (user = rightItem2.getUser()) == null) ? null : user.getUin(), uin) && (focusGroupItem = this.data) != null && (rightItem = focusGroupItem.getRightItem()) != null) {
                user3 = rightItem.getUser();
            }
        }
        if (user3 != null) {
            SitDownInfo sitDown = user3.getSitDown();
            if (sitDown != null) {
                sitDown.setSubTag(tag);
            }
            updateTableView();
        }
    }

    public final void updateTableView() {
        Location location;
        Location location2;
        FocusGroupItem focusGroupItem = this.data;
        if (focusGroupItem != null) {
            GroupAvatarAnimator groupAvatarAnimator = this.animator;
            if (groupAvatarAnimator == null || (location = groupAvatarAnimator.getLeftAvatarLocation()) == null) {
                location = focusGroupItem.getLeftItem().getTable().getLocation();
            }
            GroupAvatarAnimator groupAvatarAnimator2 = this.animator;
            if (groupAvatarAnimator2 == null || (location2 = groupAvatarAnimator2.getRightAvatarLocation()) == null) {
                location2 = focusGroupItem.getRightItem().getTable().getLocation();
            }
            LibraryTableView libraryTableView = this.binding.leftTab;
            Intrinsics.checkNotNullExpressionValue(libraryTableView, "binding.leftTab");
            bindTableView(libraryTableView, focusGroupItem.getLeftItem(), location);
            LibraryTableView libraryTableView2 = this.binding.rightTab;
            Intrinsics.checkNotNullExpressionValue(libraryTableView2, "binding.rightTab");
            bindTableView(libraryTableView2, focusGroupItem.getRightItem(), location2);
            updateCallMateBtn();
        }
    }

    public FocusGroupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FocusGroupView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAlpha(View view, float alpha, String desc) {
        if (view != null) {
            view.setAlpha(alpha);
        }
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshAlpha, ");
            sb5.append(view != null ? view.getClass().getSimpleName() : null);
            sb5.append(", ");
            sb5.append(alpha);
            sb5.append(", ");
            sb5.append(desc);
            squareLog.d(TAG, sb5.toString());
        }
    }

    private final void updateTableUI(SquareAvatarView avatar, LibraryTableView table, FocusItem item) {
        if ((item != null ? item.getUser() : null) != null) {
            if (FocusDataKt.focusResource(item) != null) {
                playAvatar(avatar, table, item);
                return;
            }
            return;
        }
        String str = "updateTableUI, " + item;
        refreshAlpha(table, 1.0f, str);
        refreshAlpha(avatar, 0.0f, str);
        try {
            avatar.stop();
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "updateTableUI, stop err.", th5);
        }
    }

    private final void updateUser(FocusItem item, long tabId, User user) {
        Table table;
        Table table2;
        if (item != null && (table2 = item.getTable()) != null && table2.getId() == tabId) {
            item.setUser(user);
            item.getTable().setUser(user);
            return;
        }
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateUser, diff table, ");
            sb5.append((item == null || (table = item.getTable()) == null) ? null : Long.valueOf(table.getId()));
            sb5.append(", ");
            sb5.append(tabId);
            sb5.append(", ");
            sb5.append(user);
            squareLog.d(TAG, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateViewAlpha(View table, SquareAvatarView avatar, FocusItem item) {
        FocusGroupListener focusGroupListener;
        if (item != null && (focusGroupListener = this.listener) != null) {
            focusGroupListener.updateLibraryItemVisible(FocusDataKt.getId(item), FocusDataKt.getType(item), false);
        }
        String str = "updateViewAlpha, " + item;
        if ((item != null ? item.getUser() : null) == null) {
            refreshAlpha(table, 1.0f, str);
            refreshAlpha(avatar, 0.0f, str);
        } else {
            refreshAlpha(table, 0.0f, str);
            refreshAlpha(avatar, 1.0f, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusGroupView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareLibraryGroupViewBinding inflate = VasSquareLibraryGroupViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryGroupVie\u2026ater.from(context), this)");
        this.binding = inflate;
        this.config = MapViewConfigKt.defaultFocusAnimaConfig();
        AvatarAnimConfig avatarAnimConfig = new AvatarAnimConfig(true, SquareMedia.INSTANCE.getCommonPlayerPool(), new PlayConfig(-1, true, null, 4, null), true);
        inflate.leftAvatarImage.setConfig(avatarAnimConfig);
        inflate.rightAvatarImage.setConfig(avatarAnimConfig);
        initClickListener();
    }

    public final void playTargetAvatar(boolean isLeft) {
        if (isLeft) {
            SquareAvatarView squareAvatarView = this.binding.leftAvatarImage;
            Intrinsics.checkNotNullExpressionValue(squareAvatarView, "binding.leftAvatarImage");
            LibraryTableView libraryTableView = this.binding.leftTab;
            Intrinsics.checkNotNullExpressionValue(libraryTableView, "binding.leftTab");
            FocusGroupItem focusGroupItem = this.data;
            updateTableUI(squareAvatarView, libraryTableView, focusGroupItem != null ? focusGroupItem.getLeftItem() : null);
            return;
        }
        SquareAvatarView squareAvatarView2 = this.binding.rightAvatarImage;
        Intrinsics.checkNotNullExpressionValue(squareAvatarView2, "binding.rightAvatarImage");
        LibraryTableView libraryTableView2 = this.binding.rightTab;
        Intrinsics.checkNotNullExpressionValue(libraryTableView2, "binding.rightTab");
        FocusGroupItem focusGroupItem2 = this.data;
        updateTableUI(squareAvatarView2, libraryTableView2, focusGroupItem2 != null ? focusGroupItem2.getRightItem() : null);
    }

    public final void updateAvatar(boolean isLeft, Resource resource) {
        GroupAvatarAnimator groupAvatarAnimator;
        BaseAvatarAnimator rightAnimator;
        GroupAvatarAnimator groupAvatarAnimator2;
        BaseAvatarAnimator leftAnimator;
        if (isLeft) {
            if (resource == null || (groupAvatarAnimator2 = this.animator) == null || (leftAnimator = groupAvatarAnimator2.getLeftAnimator()) == null) {
                return;
            }
            leftAnimator.updateAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$updateAvatar$1$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (resource == null || (groupAvatarAnimator = this.animator) == null || (rightAnimator = groupAvatarAnimator.getRightAnimator()) == null) {
            return;
        }
        rightAnimator.updateAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.view.FocusGroupView$updateAvatar$2$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.state.library.focus.IFocusParentView
    public View getView() {
        return this;
    }
}
