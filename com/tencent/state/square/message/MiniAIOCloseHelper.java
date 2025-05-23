package com.tencent.state.square.message;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareFragmentKt;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.friendsetting.PlaceInfo;
import com.tencent.state.square.friendsetting.SettingTipsController;
import com.tencent.state.square.holder.TroopViewHolder;
import com.tencent.state.square.message.box.IMsgBoxManager;
import com.tencent.state.square.message.box.MsgBoxOperateFlag;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\"\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/message/MiniAIOCloseHelper;", "", "()V", "TAG", "", "checkAndShowAddDialog", "", "fragment", "Lcom/tencent/state/square/SquareFragment;", "managerProxy", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "addRoleDialogInfo", "Lcom/tencent/state/square/message/AddRoleDialogInfo;", "checkAndShowAddTroopDialog", "debugLog", "msg", "onCloseMiniAIO", "Lcom/tencent/state/VasBaseFragment;", "data", "Landroid/content/Intent;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MiniAIOCloseHelper {
    public static final MiniAIOCloseHelper INSTANCE = new MiniAIOCloseHelper();
    private static final String TAG = "MiniAIOCloseHelper";

    MiniAIOCloseHelper() {
    }

    private final void checkAndShowAddDialog(SquareFragment fragment, ISquareViewManagerProxy managerProxy, AddRoleDialogInfo addRoleDialogInfo) {
        if (addRoleDialogInfo.isTroop()) {
            addRoleDialogInfo.setReportEvent(SquareReportConst.CustomEventId.EVENT_ID_SQUARE_TROOP_POPUP_WINDOW);
            checkAndShowAddTroopDialog(fragment, managerProxy, addRoleDialogInfo);
        }
    }

    private final void debugLog(String msg2) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, msg2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086 A[Catch: all -> 0x009b, TryCatch #0 {all -> 0x009b, blocks: (B:15:0x001b, B:17:0x0040, B:21:0x004a, B:23:0x0068, B:31:0x0077, B:33:0x007d, B:37:0x0086, B:39:0x008d, B:42:0x0093), top: B:14:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d A[Catch: all -> 0x009b, TryCatch #0 {all -> 0x009b, blocks: (B:15:0x001b, B:17:0x0040, B:21:0x004a, B:23:0x0068, B:31:0x0077, B:33:0x007d, B:37:0x0086, B:39:0x008d, B:42:0x0093), top: B:14:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009a A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCloseMiniAIO(VasBaseFragment fragment, ISquareViewManagerProxy managerProxy, Intent data) {
        boolean z16;
        boolean z17;
        ISquareViewUpdater squareViewUpdater;
        Intrinsics.checkNotNullParameter(managerProxy, "managerProxy");
        if (data != null) {
            Fragment topFragment = fragment != null ? fragment.getTopFragment() : null;
            SquareFragment squareFragment = (SquareFragment) (topFragment instanceof SquareFragment ? topFragment : null);
            if (squareFragment != null) {
                try {
                    String stringExtra = data.getStringExtra(SquareConstants.RESULT_KEY_SQUARE_AIO_UIN_STR);
                    int intExtra = data.getIntExtra(SquareConstants.RESULT_KEY_SQUARE_AIO_UIN_TYPE_INT, -1);
                    String stringExtra2 = data.getStringExtra(SquareConstants.RESULT_KEY_SQUARE_AIO_UIN_NAME_STR);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onCloseMiniAIO, uin:");
                    boolean z18 = false;
                    if (stringExtra != null && stringExtra.length() != 0) {
                        z16 = false;
                        sb5.append(z16);
                        sb5.append(", type:");
                        sb5.append(intExtra);
                        sb5.append(", name:");
                        sb5.append(stringExtra2);
                        debugLog(sb5.toString());
                        if (stringExtra != null && stringExtra.length() != 0) {
                            z17 = false;
                            if (z17 && intExtra != -1) {
                                squareViewUpdater = managerProxy.getSquareViewUpdater();
                                if (squareViewUpdater != null && !squareViewUpdater.isNotInSquare(stringExtra, intExtra)) {
                                    z18 = true;
                                }
                                if (!z18) {
                                    debugLog("onCloseMiniAIO, isInSquare");
                                    return;
                                }
                                if (stringExtra2 == null) {
                                    stringExtra2 = stringExtra;
                                }
                                checkAndShowAddDialog(squareFragment, managerProxy, new AddRoleDialogInfo(stringExtra, intExtra, stringExtra2));
                                return;
                            }
                            return;
                        }
                        z17 = true;
                        if (z17) {
                            return;
                        }
                        squareViewUpdater = managerProxy.getSquareViewUpdater();
                        if (squareViewUpdater != null) {
                            z18 = true;
                        }
                        if (!z18) {
                        }
                    }
                    z16 = true;
                    sb5.append(z16);
                    sb5.append(", type:");
                    sb5.append(intExtra);
                    sb5.append(", name:");
                    sb5.append(stringExtra2);
                    debugLog(sb5.toString());
                    if (stringExtra != null) {
                        z17 = false;
                        if (z17) {
                        }
                    }
                    z17 = true;
                    if (z17) {
                    }
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e(TAG, "onCloseMiniAIO, err.", th5);
                }
            } else {
                INSTANCE.debugLog("onCloseMiniAIO, top is not SquareFragment");
            }
        } else {
            INSTANCE.debugLog("onCloseMiniAIO, data is null");
        }
    }

    private final void checkAndShowAddTroopDialog(final SquareFragment fragment, final ISquareViewManagerProxy managerProxy, final AddRoleDialogInfo addRoleDialogInfo) {
        final SettingTipsController tipsController;
        if (managerProxy == null || (tipsController = managerProxy.getTipsController()) == null) {
            return;
        }
        if (!tipsController.canShowAddTroopDialog()) {
            debugLog("checkAndShowAddTroopDialog, can't show");
            return;
        }
        Context context = fragment.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "fragment.context ?: return");
            tipsController.showAddRoleDialog(context, addRoleDialogInfo, new Function1<Integer, Unit>() { // from class: com.tencent.state.square.message.MiniAIOCloseHelper$checkAndShowAddTroopDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    MainScene mainScene;
                    if (i3 == 2) {
                        IMsgBoxManager msgBoxManager = SquareFragmentKt.getMsgBoxManager(SquareFragment.this);
                        if (msgBoxManager != null) {
                            msgBoxManager.hideMsgListPanel(MsgBoxOperateFlag.SHOW_ADD_TROOP_DIALOG);
                        }
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(new MoveItem(addRoleDialogInfo.getUin(), 1, false, null, 12, null));
                        SquareFragment squareFragment = SquareFragment.this;
                        Fragment topFragment = squareFragment != null ? squareFragment.getTopFragment() : null;
                        VasBaseFragment vasBaseFragment = (VasBaseFragment) (topFragment instanceof VasBaseFragment ? topFragment : null);
                        if (vasBaseFragment == null || (mainScene = vasBaseFragment.getMainScene()) == null) {
                            mainScene = MainScene.UNKNOWN;
                        }
                        ISquareRoleManager.DefaultImpls.addMultiRoles$default(SquareFragment.this, arrayList, 1, mainScene, null, false, false, new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.state.square.message.MiniAIOCloseHelper$checkAndShowAddTroopDialog$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map) {
                                invoke2((Map<MoveItem, MoveResult>) map);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Map<MoveItem, MoveResult> it) {
                                PlaceInfo moveTo;
                                MapViewHolder<?> mapViewHolder;
                                IMapItemViewManager screenViewManager;
                                Intrinsics.checkNotNullParameter(it, "it");
                                MoveResult moveResult = it.get(arrayList.get(0));
                                if (moveResult == null || (moveTo = moveResult.getMoveTo()) == null) {
                                    return;
                                }
                                int index = moveTo.getIndex();
                                ISquareViewManagerProxy iSquareViewManagerProxy = managerProxy;
                                if (iSquareViewManagerProxy == null || (screenViewManager = iSquareViewManagerProxy.getScreenViewManager()) == null || (mapViewHolder = screenViewManager.getViewHolder(index)) == null) {
                                    mapViewHolder = null;
                                }
                                if (mapViewHolder instanceof TroopViewHolder) {
                                    MiniAIOCloseHelper$checkAndShowAddTroopDialog$1 miniAIOCloseHelper$checkAndShowAddTroopDialog$1 = MiniAIOCloseHelper$checkAndShowAddTroopDialog$1.this;
                                    tipsController.showTroopOperateBubbleForHolder(SquareFragment.this, (TroopViewHolder) mapViewHolder, managerProxy, null);
                                }
                            }
                        }, 56, null);
                    }
                }
            });
        }
    }
}
