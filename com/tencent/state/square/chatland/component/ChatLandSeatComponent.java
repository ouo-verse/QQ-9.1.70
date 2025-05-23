package com.tencent.state.square.chatland.component;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.data.ChatLandAvatarExtra;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandAvatarItemKt;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.square.chatland.view.ChatLandDialogTips;
import com.tencent.state.square.chatland.viewmodel.ChatLandMapViewModel;
import com.tencent.state.square.chatland.viewmodel.ChatLandViewModel;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.detail.BaseDetailFragmentConfig;
import com.tencent.state.square.detail.DetailFragmentLauncher;
import com.tencent.state.square.detail.DetailGuestFragmentConfig;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import com.tencent.state.square.detail.EntranceSource;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.SubScene;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.QuickSeatTable;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.TableType;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import com.tencent.state.template.service.VasSquareRoomService;
import com.tencent.state.utils.FastClickUtils;
import com.tencent.state.utils.VMUtils;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001bB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016Jf\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"2<\b\u0002\u0010#\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e\u0018\u00010$H\u0002J\u001e\u0010)\u001a\u00020\u001e2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/J\u0006\u00101\u001a\u000202J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\u000e\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u0016J\u0010\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020-H\u0002J\u001a\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@H\u0016J\u001a\u0010A\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=H\u0016J,\u0010B\u001a\u00020\u001e2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J<\u0010G\u001a\u00020\u001e2\u000e\u0010H\u001a\n\u0012\u0002\b\u00030Ij\u0002`J2\u0006\u0010K\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u0001002\u0006\u0010M\u001a\u00020\u00052\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020\u001eH\u0016J\u0010\u0010Q\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010R\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020-2\u0006\u00108\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u0010J\u000e\u0010V\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010W\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u00162\b\b\u0002\u0010X\u001a\u00020\u0010J\u001e\u0010W\u001a\u00020\u001e2\u0006\u00108\u001a\u00020-2\u0006\u0010Y\u001a\u00020-2\u0006\u0010X\u001a\u00020\u0010J\"\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u00162\u0006\u00108\u001a\u00020-2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002Jv\u0010^\u001a\u00020\u001e2\u0006\u00108\u001a\u00020-2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010_\u001a\u00020\u00102\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e\u0018\u00010\"2<\b\u0002\u0010#\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e\u0018\u00010$J\u0016\u0010`\u001a\u00020\u001e2\f\u0010a\u001a\b\u0012\u0004\u0012\u0002000/H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006c"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandSeatComponent;", "Lcom/tencent/state/square/chatland/component/ChatLandMapBaseComponent;", "Lcom/tencent/state/square/chatland/component/ChatLandSeatInterface;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "appId", "", WadlProxyConsts.KEY_JUMP_URL, "", "(ILjava/lang/String;)V", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "currentRoom", "Lcom/tencent/state/template/data/CommonRoomInfo;", "service", "Lcom/tencent/state/template/service/VasSquareRoomService;", "serviceLeaveRoom", "", "vmChatLand", "Lcom/tencent/state/square/chatland/viewmodel/ChatLandViewModel;", "vmChatLandMap", "Lcom/tencent/state/square/chatland/viewmodel/ChatLandMapViewModel;", "createAvatarItem", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "createTableItem", "Lcom/tencent/state/square/chatland/data/ChatLandTableItem;", "table", "Lcom/tencent/state/template/data/Table;", "doFocus", "", "params", "Lcom/tencent/state/template/data/SitDownTagParams;", "onFocusSuccess", "Lkotlin/Function1;", "onFocusFailed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_ERROR, "prompt", "doLeave", "onLeaveCallback", "doSwitchTableOnUI", "preTableId", "", "getChatLandMapList", "", "Lcom/tencent/state/map/MapItem;", "getCurrentRoomSeatInfo", "Lcom/tencent/state/square/chatland/component/RoomSeatInfo;", "getSquare", "Lcom/tencent/state/square/chatland/component/ChatLandSquareComponent;", "gotoDetail", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "isFixActionTable", "tableId", "onBackPressed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentDestroyed", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "data", "viewId", "extra", "", "onMeFocusEnd", "onMeFocusStart", "onTableSwitched", "roomId", "quickTakeSeat", "autoSwitch", "sitDown", "standUp", "skipAnim", "uin", "switchTable", "currentItem", "sitLocation", "Landroid/graphics/Point;", "takeSeat", "checkQuickClick", "updateChatLandList", "list", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSeatComponent extends ChatLandMapBaseComponent implements ChatLandSeatInterface, IChatLandEventListener {
    private static final int ERR_NO_FREE_TABLE = -24022;
    private static final String TAG = "ChatLandSeatComponent";
    private static boolean isSwitchingSeat;
    private final FastClickUtils clickUtils;
    private CommonRoomInfo currentRoom;
    private final String jumpUrl;
    private final VasSquareRoomService service;
    private boolean serviceLeaveRoom;
    private ChatLandViewModel vmChatLand;
    private ChatLandMapViewModel vmChatLandMap;

    public /* synthetic */ ChatLandSeatComponent(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doFocus(SitDownTagParams params, final Function1<? super User, Unit> onFocusSuccess, final Function2<? super Integer, ? super String, Unit> onFocusFailed) {
        this.service.sitDown(params, new ResultCallback<User>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$doFocus$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ChatLandSeatComponent", "doFocus failed. error: " + error + ", message: " + message + ", prompt: " + prompt, null, 4, null);
                Function2 function2 = onFocusFailed;
                if (function2 != null) {
                }
                ChatLandSeatComponent.isSwitchingSeat = false;
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(final User result) {
                if (result != null) {
                    if (result.isMe()) {
                        ChatLandSeatComponent chatLandSeatComponent = ChatLandSeatComponent.this;
                        Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$doFocus$1$onResultSuccess$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                                invoke2(iTemplateMapEvent);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(ITemplateMapEvent it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.onMeFocusStart(User.this);
                            }
                        };
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment;
                        if (vasBaseFragment != null) {
                            WeakReference<VasBaseFragmentComponentGroup> parent = chatLandSeatComponent.getParent();
                            vasBaseFragment.forEachComponent(ITemplateMapEvent.class, parent != null ? parent.get() : null, null, function1);
                        }
                    }
                    Function1 function12 = onFocusSuccess;
                    if (function12 != null) {
                    }
                    SquareBaseKt.getSquareLog().d("ChatLandSeatComponent", "doFocus success. isMe: " + result.isMe());
                } else {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "ChatLandSeatComponent", "doFocus success but result user is null.", null, 4, null);
                }
                ChatLandSeatComponent.isSwitchingSeat = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSwitchTableOnUI(long preTableId, final User user) {
        standUp(preTableId, Long.parseLong(user.getUin()), true);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$doSwitchTableOnUI$1
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
                ChatLandSeatComponent.this.sitDown(user);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatLandSquareComponent getSquare() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        return (ChatLandSquareComponent) fragmentComponent;
    }

    private final boolean isFixActionTable(long tableId) {
        ChatLandSquareComponent square = getSquare();
        Integer valueOf = square != null ? Integer.valueOf(square.findTableIndex(tableId)) : null;
        if (valueOf == null || valueOf.intValue() < 0) {
            return false;
        }
        ChatLandSquareComponent square2 = getSquare();
        MapItem itemDataByIndex = square2 != null ? square2.getItemDataByIndex(valueOf.intValue()) : null;
        ChatLandTableItem chatLandTableItem = (ChatLandTableItem) (itemDataByIndex instanceof ChatLandTableItem ? itemDataByIndex : null);
        return chatLandTableItem != null && chatLandTableItem.getTable().getTableType() == TableType.TABLE_TYPE_FIXED;
    }

    private final void switchTable(ChatLandAvatarItem currentItem, long tableId, Point sitLocation) {
        CommonRoomInfo commonRoomInfo = this.currentRoom;
        if (commonRoomInfo != null) {
            long id5 = commonRoomInfo.getId();
            SitDownInfo sitDown = currentItem.getUser().getSitDown();
            if (sitDown != null) {
                final long tableId2 = sitDown.getTableId();
                this.service.switchTable(SquareBaseKt.getSquareCommon().getCurrentAccountUin(), id5, tableId, sitLocation, new ResultCallback<User>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$switchTable$1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int i3, String str) {
                        ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // com.tencent.state.service.ResultCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onResultFailure(int error, String message, String prompt) {
                        boolean z16;
                        VasBaseFragment fragment;
                        boolean isBlank;
                        ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                        if (prompt != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(prompt);
                            if (!isBlank) {
                                z16 = false;
                                if (!z16) {
                                    ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                                    fragment = ChatLandSeatComponent.this.getFragment();
                                    squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, prompt, 1);
                                }
                                ChatLandSeatComponent.isSwitchingSeat = false;
                            }
                        }
                        z16 = true;
                        if (!z16) {
                        }
                        ChatLandSeatComponent.isSwitchingSeat = false;
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultSuccess(User result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        ChatLandSeatComponent.this.doSwitchTableOnUI(tableId2, result);
                        ChatLandSeatComponent.isSwitchingSeat = false;
                    }
                });
            }
        }
    }

    private final void updateChatLandList(List<? extends MapItem> list) {
        SquareBaseKt.getSquareLog().d(TAG, "updateChatLandList");
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            for (MapItem mapItem : list) {
                if (!(mapItem instanceof SquareEntranceItem)) {
                    mapItem = null;
                }
                SquareEntranceItem squareEntranceItem = (SquareEntranceItem) mapItem;
                if (squareEntranceItem != null) {
                    if (this.jumpUrl.length() > 0) {
                        squareEntranceItem.getLink().setLink(this.jumpUrl);
                    }
                }
            }
        }
        ChatLandSquareComponent square = getSquare();
        if (square != null) {
            square.removeAllFlexAvatarItem();
        }
        ChatLandSquareComponent square2 = getSquare();
        if (square2 != null) {
            square2.appendOrUpdateChatLandUserItem(list, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$updateChatLandList$2
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
                    ChatLandSeatComponent chatLandSeatComponent = ChatLandSeatComponent.this;
                    AnonymousClass1 anonymousClass1 = new Function1<IChatLandEventListener, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$updateChatLandList$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IChatLandEventListener iChatLandEventListener) {
                            invoke2(iChatLandEventListener);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IChatLandEventListener it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.onChatLandSeatAdded();
                        }
                    };
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment;
                    if (vasBaseFragment != null) {
                        WeakReference<VasBaseFragmentComponentGroup> parent = chatLandSeatComponent.getParent();
                        vasBaseFragment.forEachComponent(IChatLandEventListener.class, parent != null ? parent.get() : null, null, anonymousClass1);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        if ((r3.length() > 0) == true) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @Override // com.tencent.state.square.chatland.component.ChatLandSeatInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatLandAvatarItem createAvatarItem(User user, int appId) {
        CommonRoomInfo commonRoomInfo;
        Intrinsics.checkNotNullParameter(user, "user");
        ChatLandAvatarItem chatLandAvatarItem = new ChatLandAvatarItem(user, appId);
        if (!user.isMe()) {
            SquareBubbleInfo focusAnimationSkin = user.getFocusAnimationSkin();
            if (focusAnimationSkin != null && (r3 = focusAnimationSkin.getSkinLink()) != null) {
            }
            commonRoomInfo = this.currentRoom;
            if (commonRoomInfo != null) {
                ChatLandAvatarItemKt.setupPKOption(chatLandAvatarItem, commonRoomInfo);
            }
            return chatLandAvatarItem;
        }
        Object extra = chatLandAvatarItem.getExtra();
        if (!(extra instanceof ChatLandAvatarExtra)) {
            extra = null;
        }
        ChatLandAvatarExtra chatLandAvatarExtra = (ChatLandAvatarExtra) extra;
        if (chatLandAvatarExtra != null) {
            chatLandAvatarExtra.setNeedRingPagAnim(true);
        }
        commonRoomInfo = this.currentRoom;
        if (commonRoomInfo != null) {
        }
        return chatLandAvatarItem;
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandSeatInterface
    public ChatLandTableItem createTableItem(Table table, int appId) {
        Intrinsics.checkNotNullParameter(table, "table");
        return new ChatLandTableItem(table, appId);
    }

    public final void doLeave(final Function1<? super Boolean, Unit> onLeaveCallback) {
        ChatLandSeatComponent$doLeave$1 chatLandSeatComponent$doLeave$1 = new Function1<ChatLandMapBaseComponent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$doLeave$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandMapBaseComponent chatLandMapBaseComponent) {
                invoke2(chatLandMapBaseComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandMapBaseComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onBeforeMeEndFocus();
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
            vasBaseFragment.forEachComponent(ChatLandMapBaseComponent.class, parent != null ? parent.get() : null, null, chatLandSeatComponent$doLeave$1);
        }
        this.service.standUp("ChatLandFocusPage", new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$doLeave$2
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
                if (z16) {
                    ChatLandSeatComponent chatLandSeatComponent = ChatLandSeatComponent.this;
                    AnonymousClass1 anonymousClass1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$doLeave$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                            invoke2(iTemplateMapEvent);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ITemplateMapEvent it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            it.onMeFocusEnd();
                        }
                    };
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment;
                    if (vasBaseFragment2 != null) {
                        WeakReference<VasBaseFragmentComponentGroup> parent2 = chatLandSeatComponent.getParent();
                        vasBaseFragment2.forEachComponent(ITemplateMapEvent.class, parent2 != null ? parent2.get() : null, null, anonymousClass1);
                    }
                }
                Function1 function1 = onLeaveCallback;
                if (function1 != null) {
                }
                SquareBaseKt.getSquareLog().d("ChatLandSeatComponent", "doLeave :" + z16);
            }
        });
    }

    public final List<MapItem> getChatLandMapList() {
        ChatLandMapViewModel chatLandMapViewModel = this.vmChatLandMap;
        if (chatLandMapViewModel != null) {
            return chatLandMapViewModel.getMapDataList(this.currentRoom);
        }
        return null;
    }

    public final RoomSeatInfo getCurrentRoomSeatInfo() {
        CommonRoomInfo commonRoomInfo = this.currentRoom;
        long id5 = commonRoomInfo != null ? commonRoomInfo.getId() : 0L;
        int appId = getAppId();
        int currentUserCount = getCurrentUserCount();
        CommonRoomInfo commonRoomInfo2 = this.currentRoom;
        return new RoomSeatInfo(id5, appId, currentUserCount, commonRoomInfo2 != null ? commonRoomInfo2.getMaxPeople() : 0);
    }

    public final void gotoDetail(ChatLandAvatarItem item) {
        String str;
        BaseDetailFragmentConfig detailGuestFragmentConfig;
        Context it;
        Intrinsics.checkNotNullParameter(item, "item");
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            VasBaseFragment fragment = getFragment();
            if (fragment == null || (it = fragment.getContext()) == null) {
                return;
            }
            IRouter router = Square.INSTANCE.getConfig().getRouter();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            router.routeToNearbyDetailPage(it, item.getUin());
            return;
        }
        DetailFragmentLauncher detailFragmentLauncher = DetailFragmentLauncher.INSTANCE;
        VasBaseFragment fragment2 = getFragment();
        MainScene parse = MainScene.INSTANCE.parse(Integer.valueOf(getAppId()));
        SubScene subScene = SubScene.UNKNOWN;
        QBaseActivity activity = getActivity();
        if (activity == null || (str = SquareGroupReportComponentKt.getSourceFrom(activity)) == null) {
            str = "";
        }
        EntranceSource entranceSource = new EntranceSource(parse, subScene, str);
        String uin = item.getUin();
        if (item.isMe()) {
            detailGuestFragmentConfig = new DetailMeFragmentConfig();
        } else {
            detailGuestFragmentConfig = new DetailGuestFragmentConfig();
        }
        BaseDetailFragmentConfig baseDetailFragmentConfig = detailGuestFragmentConfig;
        baseDetailFragmentConfig.setEnterWithScaleAnim(true);
        Unit unit = Unit.INSTANCE;
        DetailFragmentLauncher.launch$default(detailFragmentLauncher, fragment2, entranceSource, uin, baseDetailFragmentConfig, null, 16, null);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        ChatLandAvatarItem meAvatarItem;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(f16, "f");
        boolean isMeSeatedInLands = isMeSeatedInLands();
        SquareBaseKt.getSquareLog().i(TAG, "[EndFocus] onBackPressed, " + isMeSeatedInLands + TokenParser.SP + this.serviceLeaveRoom);
        if (!isMeSeatedInLands || this.serviceLeaveRoom || (meAvatarItem = getMeAvatarItem()) == null || meAvatarItem.getAppId() != getAppId()) {
            return false;
        }
        Integer valueOf = Integer.valueOf(getAppId());
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandPKComponent.class, valueOf)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, valueOf)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, valueOf, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPKComponent.class, null, null, 6, null) : null;
        }
        ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) component$default;
        if (chatLandPKComponent != null) {
            chatLandPKComponent.hidePKPanel();
        }
        ChatLandDialogTips chatLandDialogTips = ChatLandDialogTips.INSTANCE;
        VasBaseFragment fragment = getFragment();
        chatLandDialogTips.showLeaveConfirmTip(fragment != null ? fragment.getContext() : null, getAppId(), true, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onBackPressed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                VasBaseFragment fragment2;
                if (z16) {
                    ChatLandSeatComponent.doLeave$default(ChatLandSeatComponent.this, null, 1, null);
                    ChatLandSeatComponent.this.serviceLeaveRoom = true;
                    fragment2 = ChatLandSeatComponent.this.getFragment();
                    if (fragment2 != null) {
                        fragment2.onBackPressed();
                    }
                }
            }
        });
        return true;
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        IChatLandEventListener.DefaultImpls.onChatLandLeaveRoom(this);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandSeatAdded() {
        IChatLandEventListener.DefaultImpls.onChatLandSeatAdded(this);
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.currentRoom = info.getRoom();
        this.serviceLeaveRoom = false;
        CommonRoomInfo room = info.getRoom();
        if (room != null) {
            boolean isMeSeated = isMeSeated();
            SquareBaseKt.getSquareLog().d(TAG, "onEnterRoom isReenter=" + info.getIsReenter() + ", isMePreSeated=" + isMeSeated);
            Object obj = null;
            if (info.getIsReenter() && isMeSeated) {
                ChatLandSeatComponent$onEnterRoom$1 chatLandSeatComponent$onEnterRoom$1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onEnterRoom$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                        invoke2(iTemplateMapEvent);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ITemplateMapEvent it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onMeFocusEnd();
                    }
                };
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment != null) {
                    WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
                    vasBaseFragment.forEachComponent(ITemplateMapEvent.class, parent != null ? parent.get() : null, null, chatLandSeatComponent$onEnterRoom$1);
                }
            }
            List<MapItem> chatLandMapList = getChatLandMapList();
            if (chatLandMapList != null) {
                updateChatLandList(chatLandMapList);
            }
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onEnterRoom$3
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
                    WeakReference<VasBaseFragmentComponentGroup> parent2;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    ChatLandSeatComponent chatLandSeatComponent = ChatLandSeatComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSeatComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSeatComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent2 = chatLandSeatComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent2.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment;
                        if (vasBaseFragment2 == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) chatLandSeatComponent).parentFragment;
                            if (vasBaseFragment3 != null) {
                                fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSquareComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent2 = component$default;
                        }
                        fragmentComponent = fragmentComponent2;
                    }
                    ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
                    if (chatLandSquareComponent != null) {
                        chatLandSquareComponent.playFadeInAnim();
                    }
                }
            });
            if (CommonDataKt.isMeSeated(room)) {
                Iterator<T> it = room.getUsers().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((User) next).isMe()) {
                        obj = next;
                        break;
                    }
                }
                final User user = (User) obj;
                if (user != null) {
                    SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onEnterRoom$$inlined$let$lambda$1
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
                            WeakReference<VasBaseFragmentComponentGroup> parent2;
                            FragmentComponent fragmentComponent;
                            FragmentComponent component$default;
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                            ChatLandSeatComponent chatLandSeatComponent = this;
                            Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onEnterRoom$$inlined$let$lambda$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                                    invoke2(iTemplateMapEvent);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ITemplateMapEvent it5) {
                                    Intrinsics.checkNotNullParameter(it5, "it");
                                    it5.onMeFocusStart(User.this);
                                }
                            };
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment;
                            FragmentComponent fragmentComponent2 = null;
                            if (vasBaseFragment2 != null) {
                                WeakReference<VasBaseFragmentComponentGroup> parent3 = chatLandSeatComponent.getParent();
                                vasBaseFragment2.forEachComponent(ITemplateMapEvent.class, parent3 != null ? parent3.get() : null, null, function1);
                            }
                            ChatLandSeatComponent chatLandSeatComponent2 = this;
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSeatComponent2 instanceof VasBaseFragmentComponentGroup) ? null : chatLandSeatComponent2);
                            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent2 = chatLandSeatComponent2.getParent()) == null || (vasBaseFragmentComponentGroup = parent2.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) chatLandSeatComponent2).fragment;
                                if (vasBaseFragment3 == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                                    VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) chatLandSeatComponent2).parentFragment;
                                    if (vasBaseFragment4 != null) {
                                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null);
                                    }
                                } else {
                                    fragmentComponent2 = component$default;
                                }
                                fragmentComponent = fragmentComponent2;
                            }
                            ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
                            if (chatLandSquareComponent != null) {
                                chatLandSquareComponent.locateToUin(User.this.getUin());
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        IChatLandEventListener.DefaultImpls.onFragmentDestroyed(this, fm5, f16);
        ChatLandSeatComponent$onFragmentDestroyed$1 chatLandSeatComponent$onFragmentDestroyed$1 = new Function1<IChatLandEventListener, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onFragmentDestroyed$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IChatLandEventListener iChatLandEventListener) {
                invoke2(iChatLandEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IChatLandEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onChatLandLeaveRoom();
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
            vasBaseFragment.forEachComponent(IChatLandEventListener.class, parent != null ? parent.get() : null, null, chatLandSeatComponent$onFragmentDestroyed$1);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        VMUtils vMUtils = VMUtils.INSTANCE;
        this.vmChatLandMap = (ChatLandMapViewModel) vMUtils.safelyGet(f16, ChatLandMapViewModel.class, String.valueOf(getAppId()));
        this.vmChatLand = (ChatLandViewModel) vMUtils.safelyGet(f16, ChatLandViewModel.class, String.valueOf(getAppId()));
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, Object extra) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        FragmentComponent fragmentComponent2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        FragmentComponent fragmentComponent3 = null;
        switch (viewId) {
            case 17:
                if (!(data instanceof ChatLandTableItem)) {
                    data = null;
                }
                ChatLandTableItem chatLandTableItem = (ChatLandTableItem) data;
                if (chatLandTableItem != null) {
                    takeSeat$default(this, chatLandTableItem.getTable().getId(), null, true, null, null, 24, null);
                    return;
                }
                return;
            case 18:
                if (!(data instanceof ChatLandAvatarItem)) {
                    data = null;
                }
                ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) data;
                if (chatLandAvatarItem != null) {
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                    if ((vasBaseFragmentComponentGroup3 == null || (fragmentComponent = vasBaseFragmentComponentGroup3.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                            if (vasBaseFragment2 != null) {
                                fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent3 = component$default;
                        }
                        fragmentComponent = fragmentComponent3;
                    }
                    ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
                    if (chatLandSquareComponent != null) {
                        chatLandSquareComponent.panelShow(chatLandAvatarItem);
                        return;
                    }
                    return;
                }
                return;
            case 19:
                if (!(data instanceof ChatLandAvatarItem)) {
                    data = null;
                }
                final ChatLandAvatarItem chatLandAvatarItem2 = (ChatLandAvatarItem) data;
                if (chatLandAvatarItem2 != null) {
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                    if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup4.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
                        if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                            if (vasBaseFragment4 != null) {
                                fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent3 = component$default2;
                        }
                        fragmentComponent2 = fragmentComponent3;
                    }
                    ChatLandSquareComponent chatLandSquareComponent2 = (ChatLandSquareComponent) fragmentComponent2;
                    if (chatLandSquareComponent2 != null) {
                        chatLandSquareComponent2.scaleToDetailAmin(chatLandAvatarItem2.getUin(), new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onItemClicked$2
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
                                SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$onItemClicked$2.1
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
                                        ChatLandSeatComponent$onItemClicked$2 chatLandSeatComponent$onItemClicked$2 = ChatLandSeatComponent$onItemClicked$2.this;
                                        ChatLandSeatComponent.this.gotoDetail(chatLandAvatarItem2);
                                    }
                                });
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        ChatLandAvatarItem meAvatarItemData;
        ChatLandSquareComponent square = getSquare();
        if (square == null || (meAvatarItemData = square.getMeAvatarItemData()) == null) {
            return;
        }
        standUp$default(this, meAvatarItemData, false, 2, null);
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(User user) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(user, "user");
        sitDown(user);
        Integer valueOf = Integer.valueOf(getAppId());
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandPKComponent.class, valueOf)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, valueOf)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, valueOf, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPKComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) fragmentComponent;
        if (chatLandPKComponent != null) {
            chatLandPKComponent.refreshPKOption();
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onPublicChatConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener.DefaultImpls.onPublicChatConfigLoaded(this, conf);
    }

    public final void onTableSwitched(long roomId, long tableId, User user) {
        SitDownInfo sitDown;
        Intrinsics.checkNotNullParameter(user, "user");
        SquareBaseKt.getSquareLog().d(TAG, "onTableSwitched roomId=" + roomId + ", tableId=" + tableId + ", user=" + user.getInfo());
        if (user.isMe()) {
            SquareBaseKt.getSquareLog().i(TAG, "onTableSwitched isMe");
            return;
        }
        CommonRoomInfo commonRoomInfo = this.currentRoom;
        if (commonRoomInfo != null && roomId == commonRoomInfo.getId()) {
            ChatLandAvatarItem findAvatarItemByUin = findAvatarItemByUin(user.getUin());
            if (findAvatarItemByUin == null || (sitDown = findAvatarItemByUin.getUser().getSitDown()) == null) {
                return;
            }
            doSwitchTableOnUI(sitDown.getTableId(), user);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "onTableSwitched roomId not match");
    }

    public final void quickTakeSeat(boolean autoSwitch) {
        List<QuickSeatTable> emptyList;
        Object randomOrNull;
        RoomConfig config;
        Location backgroundLocation;
        RoomConfig config2;
        Location backgroundLocation2;
        RoomThemeData theme;
        CommonRoomInfo commonRoomInfo = this.currentRoom;
        if (commonRoomInfo != null) {
            long id5 = commonRoomInfo.getId();
            CommonRoomInfo commonRoomInfo2 = this.currentRoom;
            if (commonRoomInfo2 == null || (theme = commonRoomInfo2.getTheme()) == null || (emptyList = theme.getQuickSeatTables()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(emptyList, Random.INSTANCE);
            QuickSeatTable quickSeatTable = (QuickSeatTable) randomOrNull;
            SquareBaseKt.getSquareLog().d(TAG, "\u5feb\u6377\u5165\u5ea7: appId=" + getAppId() + " roomId=" + id5 + " selectedTable=" + quickSeatTable + " autoSwitch=" + autoSwitch);
            if (quickSeatTable != null) {
                int i3 = quickSeatTable.getLocation().x;
                CommonRoomInfo commonRoomInfo3 = this.currentRoom;
                int i16 = 0;
                int x16 = i3 + ((commonRoomInfo3 == null || (config2 = commonRoomInfo3.getConfig()) == null || (backgroundLocation2 = config2.getBackgroundLocation()) == null) ? 0 : backgroundLocation2.getX());
                int i17 = quickSeatTable.getLocation().y;
                CommonRoomInfo commonRoomInfo4 = this.currentRoom;
                if (commonRoomInfo4 != null && (config = commonRoomInfo4.getConfig()) != null && (backgroundLocation = config.getBackgroundLocation()) != null) {
                    i16 = backgroundLocation.getY();
                }
                takeSeat(quickSeatTable.getTableId(), new Point(x16, i17 + i16), false, new Function1<User, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$quickTakeSeat$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(User user) {
                        invoke2(user);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final User it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$quickTakeSeat$1.1
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
                                ChatLandSquareComponent square;
                                square = ChatLandSeatComponent.this.getSquare();
                                if (square != null) {
                                    square.locateToUin(it.getUin());
                                }
                                SquareBaseKt.getSquareLog().d("ChatLandSeatComponent", "\u5feb\u6377\u5165\u5ea7\u6210\u529f");
                            }
                        });
                    }
                }, new ChatLandSeatComponent$quickTakeSeat$2(this, autoSwitch));
            }
        }
    }

    public final void sitDown(User user) {
        SitDownInfo sitDown;
        Intrinsics.checkNotNullParameter(user, "user");
        ChatLandSquareComponent square = getSquare();
        if (square == null || (sitDown = user.getSitDown()) == null) {
            return;
        }
        long tableId = sitDown.getTableId();
        SquareBaseKt.getSquareLog().i(TAG, "sitDown: tableId=" + tableId + ", user=" + user.getInfo());
        SitDownInfo sitDown2 = user.getSitDown();
        if (sitDown2 != null && sitDown2.getIsFlexTable()) {
            square.insertItem(createAvatarItem(user, getAppId()));
            return;
        }
        int findTableIndex = square.findTableIndex(tableId);
        if (findTableIndex > -1) {
            MapItem itemDataByIndex = square.getItemDataByIndex(findTableIndex);
            if (!(itemDataByIndex instanceof ChatLandTableItem)) {
                itemDataByIndex = null;
            }
            ChatLandTableItem chatLandTableItem = (ChatLandTableItem) itemDataByIndex;
            if (chatLandTableItem != null) {
                SitDownInfo sitDown3 = user.getSitDown();
                if (sitDown3 != null) {
                    sitDown3.setTable(chatLandTableItem.getTable());
                }
                SitDownInfo sitDown4 = user.getSitDown();
                if (sitDown4 != null) {
                    SitDownInfo sitDown5 = user.getSitDown();
                    sitDown4.setFixedResource(sitDown5 != null ? sitDown5.getResource() : null);
                }
                chatLandTableItem.getTable().setUser(user);
                square.updateByIndex(findTableIndex, createAvatarItem(user, getAppId()));
                return;
            }
            return;
        }
        SquareBaseKt.getSquareLog().w(TAG, "sitDown failed: index=" + findTableIndex);
    }

    public final void standUp(long tableId, long uin, boolean skipAnim) {
        Table table;
        ChatLandSquareComponent square = getSquare();
        if (square != null) {
            SquareBaseKt.getSquareLog().i(TAG, "standUp: tableId=" + tableId + ", uin=" + uin);
            if (tableId == -1) {
                ChatLandAvatarItem findAvatarItemByUin = findAvatarItemByUin(String.valueOf(uin));
                if (findAvatarItemByUin != null) {
                    square.removeItem(findAvatarItemByUin, skipAnim);
                    return;
                }
                return;
            }
            int findTableIndex = square.findTableIndex(tableId);
            if (findTableIndex > -1) {
                MapItem itemDataByIndex = square.getItemDataByIndex(findTableIndex);
                if (!(itemDataByIndex instanceof ChatLandAvatarItem)) {
                    itemDataByIndex = null;
                }
                ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) itemDataByIndex;
                if (chatLandAvatarItem != null) {
                    if (chatLandAvatarItem.getUser().getInfo().getUin() == uin) {
                        SitDownInfo sitDown = chatLandAvatarItem.getUser().getSitDown();
                        if (sitDown == null || (table = sitDown.getTable()) == null) {
                            return;
                        }
                        table.setUser(null);
                        square.updateByIndex(findTableIndex, createTableItem(table, getAppId()));
                        return;
                    }
                    SquareBaseKt.getSquareLog().w(TAG, "standUp failed: uin=" + uin + ", currentTableUin=" + chatLandAvatarItem.getUser().getInfo().getUin());
                    return;
                }
                return;
            }
            SquareBaseKt.getSquareLog().w(TAG, "standUp failed: index=" + findTableIndex);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSeatComponent(int i3, String jumpUrl) {
        super(i3);
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.jumpUrl = jumpUrl;
        this.clickUtils = new FastClickUtils(900L);
        this.service = new VasSquareRoomService(i3, ChatLandRoomComponentKt.getChatLandRoomConfParser(), new Function0<Size>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$service$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                WeakReference<VasBaseFragmentComponentGroup> parent;
                VasBaseFragment vasBaseFragment;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                ChatLandSeatComponent chatLandSeatComponent = ChatLandSeatComponent.this;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSeatComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSeatComponent);
                if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = chatLandSeatComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSeatComponent).parentFragment;
                    component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
                }
                ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
                if (chatLandSquareComponent != null) {
                    return chatLandSquareComponent.getMapSize();
                }
                return null;
            }
        });
    }

    public final void takeSeat(final long tableId, final Point sitLocation, boolean checkQuickClick, final Function1<? super User, Unit> onFocusSuccess, final Function2<? super Integer, ? super String, Unit> onFocusFailed) {
        VasBaseFragment fragment;
        Context context;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        FragmentComponent fragmentComponent2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        if ((checkQuickClick && this.clickUtils.isFastDoubleClick()) || isSwitchingSeat || (fragment = getFragment()) == null || (context = fragment.getContext()) == null) {
            return;
        }
        final ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1 chatLandSeatComponent$takeSeat$$inlined$let$lambda$1 = new ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1(context, this, tableId, sitLocation, onFocusSuccess, onFocusFailed);
        if (isMeSeatedInLands()) {
            ChatLandAvatarItem meAvatarItemInLands = getMeAvatarItemInLands();
            if (meAvatarItemInLands != null) {
                FragmentComponent fragmentComponent3 = null;
                if (meAvatarItemInLands.getAppId() == getAppId()) {
                    isSwitchingSeat = true;
                    if (isFixActionTable(tableId)) {
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                        if ((vasBaseFragmentComponentGroup3 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup3.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                            if (vasBaseFragment == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                                if (vasBaseFragment2 != null) {
                                    fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                                }
                            } else {
                                fragmentComponent3 = component$default2;
                            }
                            fragmentComponent2 = fragmentComponent3;
                        }
                        ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent2;
                        if (chatLandInteractionMotionComponent != null) {
                            chatLandInteractionMotionComponent.endInteraction();
                        }
                    }
                    switchTable(meAvatarItemInLands, tableId, sitLocation);
                    return;
                }
                Integer valueOf = Integer.valueOf(meAvatarItemInLands.getAppId());
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent = vasBaseFragmentComponentGroup4.getComponent(ChatLandSeatComponent.class, valueOf)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSeatComponent.class, valueOf)) == null)) {
                    VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment3 == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSeatComponent.class, null, valueOf, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment4 != null) {
                            fragmentComponent3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSeatComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent3 = component$default;
                    }
                    fragmentComponent = fragmentComponent3;
                }
                ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) fragmentComponent;
                if (chatLandSeatComponent != null) {
                    isSwitchingSeat = true;
                    chatLandSeatComponent.doLeave(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$takeSeat$$inlined$let$lambda$2
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
                            if (!z16) {
                                ChatLandSeatComponent.isSwitchingSeat = false;
                            } else {
                                Function0.this.invoke();
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        isSwitchingSeat = true;
        chatLandSeatComponent$takeSeat$$inlined$let$lambda$1.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doLeave$default(ChatLandSeatComponent chatLandSeatComponent, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        chatLandSeatComponent.doLeave(function1);
    }

    public static /* synthetic */ void standUp$default(ChatLandSeatComponent chatLandSeatComponent, ChatLandAvatarItem chatLandAvatarItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        chatLandSeatComponent.standUp(chatLandAvatarItem, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void doFocus$default(ChatLandSeatComponent chatLandSeatComponent, SitDownTagParams sitDownTagParams, Function1 function1, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            function2 = null;
        }
        chatLandSeatComponent.doFocus(sitDownTagParams, function1, function2);
    }

    public final void standUp(ChatLandAvatarItem data, boolean skipAnim) {
        Intrinsics.checkNotNullParameter(data, "data");
        SquareBaseKt.getSquareLog().d(TAG, "standUp isMe=" + data.isMe() + " uin=" + data.getUin());
        SitDownInfo sitDown = data.getUser().getSitDown();
        if (sitDown != null) {
            standUp(sitDown.getTableId(), data.getUser().getInfo().getUin(), skipAnim);
        }
    }

    public static /* synthetic */ void takeSeat$default(ChatLandSeatComponent chatLandSeatComponent, long j3, Point point, boolean z16, Function1 function1, Function2 function2, int i3, Object obj) {
        chatLandSeatComponent.takeSeat(j3, point, z16, (i3 & 8) != 0 ? null : function1, (i3 & 16) != 0 ? null : function2);
    }
}
