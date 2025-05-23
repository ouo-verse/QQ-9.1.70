package com.tencent.state.library.focus.component;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.focus.FocusGroupFragment;
import com.tencent.state.library.focus.FocusSingleBaseFragment;
import com.tencent.state.library.focus.FocusSingleGuestFragment;
import com.tencent.state.library.focus.FocusSingleMeFragment;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.FocusGroupView;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004J\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u0016\u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/library/focus/component/FocusUIComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "()V", "checkResourceChange", "", "uin", "", "data", "Lcom/tencent/state/library/focus/data/FocusItem;", "resource", "Lcom/tencent/state/square/data/Resource;", "doGroupSitDown", "", "tableId", "", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "doGroupStandUp", "isTimeOut", "doGuestSitDown", "doGuestStandUp", "doMeSitDown", "doMeStandUp", "sitDown", "standUp", "switchTable", "roomId", "updateDeskMateTag", "tag", "Lcom/tencent/state/common/tag/CommonTagInfo;", "updateLikeNum", "toUin", "likeNum", "updateUserResource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusUIComponent extends FocusBaseComponent {
    private final void doGroupSitDown(long tableId, User user) {
        FocusRecordComponent focusRecordComponent;
        FocusBaseFragment focusFragment = getFocusFragment();
        IFocusParentView fragmentView = focusFragment != null ? focusFragment.getFragmentView() : null;
        if (!(fragmentView instanceof FocusGroupView)) {
            fragmentView = null;
        }
        FocusGroupView focusGroupView = (FocusGroupView) fragmentView;
        if (focusGroupView != null) {
            focusGroupView.updateBubbleData(tableId, user);
            VasBaseFragment fragment = getFragment();
            if (fragment == null || (focusRecordComponent = (FocusRecordComponent) VasBaseLifecycleFragment.getComponent$default(fragment, FocusRecordComponent.class, null, null, 6, null)) == null) {
                return;
            }
            FocusBaseItem data = getData();
            focusRecordComponent.doGroupMeRecordAvatar((FocusGroupItem) (data instanceof FocusGroupItem ? data : null));
        }
    }

    private final void doGroupStandUp(long tableId, long uin, boolean isTimeOut) {
        FocusBaseItem data;
        FocusItem rightItem;
        Table table;
        String str;
        FocusItem rightItem2;
        FocusItem item;
        String meUin;
        FocusItem item2;
        User user;
        UserCommon info;
        FocusItem item3;
        Table table2;
        QBaseActivity activity = getActivity();
        if (activity != null) {
            FocusBaseFragment focusFragment = getFocusFragment();
            User user2 = null;
            IFocusParentView fragmentView = focusFragment != null ? focusFragment.getFragmentView() : null;
            if (!(fragmentView instanceof FocusGroupView)) {
                fragmentView = null;
            }
            FocusGroupView focusGroupView = (FocusGroupView) fragmentView;
            if (focusGroupView != null) {
                FocusBaseItem data2 = getData();
                if ((data2 == null || (item3 = data2.getItem()) == null || (table2 = item3.getTable()) == null || table2.getId() != tableId) && ((data = getData()) == null || (rightItem = data.getRightItem()) == null || (table = rightItem.getTable()) == null || table.getId() != tableId)) {
                    return;
                }
                FocusBaseItem data3 = getData();
                if (data3 == null || (item2 = FocusDataKt.getItem(data3, tableId, String.valueOf(uin))) == null || (user = item2.getUser()) == null || (info = user.getInfo()) == null || (str = info.getNick()) == null) {
                    str = "";
                }
                FocusBaseItem data4 = getData();
                if ((data4 != null ? FocusDataKt.meUin(data4) : null) != null) {
                    FocusBaseItem data5 = getData();
                    Long longOrNull = (data5 == null || (meUin = FocusDataKt.meUin(data5)) == null) ? null : StringsKt__StringNumberConversionsKt.toLongOrNull(meUin);
                    if (longOrNull != null && longOrNull.longValue() == uin && isTimeOut) {
                        getFocusDialog().showMaxFocusTimeDialog(activity, new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusUIComponent$doGroupStandUp$1
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
                                FocusBaseFragment focusFragment2 = FocusUIComponent.this.getFocusFragment();
                                if (focusFragment2 != null) {
                                    focusFragment2.onBackClick();
                                }
                            }
                        });
                        return;
                    }
                }
                focusGroupView.updateBubbleData(tableId, null);
                focusGroupView.updateTableView();
                FocusBaseItem data6 = getData();
                if (((data6 == null || (item = data6.getItem()) == null) ? null : item.getUser()) == null) {
                    FocusBaseItem data7 = getData();
                    if (data7 != null && (rightItem2 = data7.getRightItem()) != null) {
                        user2 = rightItem2.getUser();
                    }
                    if (user2 == null) {
                        getFocusDialog().hasLeaveDeskDialog(activity, str, new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusUIComponent$doGroupStandUp$2
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
                                FocusBaseFragment focusFragment2 = FocusUIComponent.this.getFocusFragment();
                                if (focusFragment2 != null) {
                                    focusFragment2.onBackClick();
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private final void doGuestStandUp(long tableId, long uin, boolean isTimeOut) {
        FocusBaseItem data;
        FocusItem singleItem;
        Table table;
        String str;
        FocusItem singleItem2;
        User user;
        UserCommon info;
        FocusItem singleItem3;
        User user2;
        QBaseActivity activity = getActivity();
        if (activity == null || (data = getData()) == null || (singleItem = data.getSingleItem()) == null || (table = singleItem.getTable()) == null || tableId != table.getId()) {
            return;
        }
        String valueOf = String.valueOf(uin);
        FocusBaseItem data2 = getData();
        if (Intrinsics.areEqual(valueOf, (data2 == null || (singleItem3 = data2.getSingleItem()) == null || (user2 = singleItem3.getUser()) == null) ? null : user2.getUin())) {
            FocusDialogTips focusDialog = getFocusDialog();
            FocusBaseItem data3 = getData();
            if (data3 == null || (singleItem2 = data3.getSingleItem()) == null || (user = singleItem2.getUser()) == null || (info = user.getInfo()) == null || (str = info.getNick()) == null) {
                str = "";
            }
            focusDialog.hasLeaveDeskDialog(activity, str, new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusUIComponent$doGuestStandUp$1
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
                    FocusBaseFragment focusFragment = FocusUIComponent.this.getFocusFragment();
                    if (focusFragment != null) {
                        focusFragment.onBackClick();
                    }
                }
            });
        }
    }

    private final void doMeStandUp(long tableId, long uin, boolean isTimeOut) {
        FocusItem singleItem;
        Table table;
        FocusItem singleItem2;
        User user;
        FocusBaseItem data = getData();
        if (data == null || (singleItem = data.getSingleItem()) == null || (table = singleItem.getTable()) == null || tableId != table.getId()) {
            return;
        }
        String valueOf = String.valueOf(uin);
        FocusBaseItem data2 = getData();
        if (Intrinsics.areEqual(valueOf, (data2 == null || (singleItem2 = data2.getSingleItem()) == null || (user = singleItem2.getUser()) == null) ? null : user.getUin()) && isTimeOut) {
            getFocusDialog().showMaxFocusTimeDialog(getActivity(), new Function0<Unit>() { // from class: com.tencent.state.library.focus.component.FocusUIComponent$doMeStandUp$1
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
                    FocusBaseFragment focusFragment = FocusUIComponent.this.getFocusFragment();
                    if (focusFragment != null) {
                        focusFragment.onBackClick();
                    }
                }
            });
        }
    }

    public final void sitDown(long tableId, User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        FocusBaseFragment focusFragment = getFocusFragment();
        if (focusFragment instanceof FocusSingleMeFragment) {
            doMeSitDown(tableId, user);
        } else if (focusFragment instanceof FocusSingleGuestFragment) {
            doGuestSitDown(tableId, user);
        } else if (focusFragment instanceof FocusGroupFragment) {
            doGroupSitDown(tableId, user);
        }
    }

    public final void standUp(long tableId, long uin, boolean isTimeOut) {
        FocusBaseFragment focusFragment = getFocusFragment();
        if (focusFragment instanceof FocusSingleMeFragment) {
            doMeStandUp(tableId, uin, isTimeOut);
        } else if (focusFragment instanceof FocusSingleGuestFragment) {
            doGuestStandUp(tableId, uin, isTimeOut);
        } else if (focusFragment instanceof FocusGroupFragment) {
            doGroupStandUp(tableId, uin, isTimeOut);
        }
    }

    public final void switchTable(long roomId, long tableId, User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        FocusBaseFragment focusFragment = getFocusFragment();
        IFocusParentView fragmentView = focusFragment != null ? focusFragment.getFragmentView() : null;
        FocusGroupView focusGroupView = (FocusGroupView) (fragmentView instanceof FocusGroupView ? fragmentView : null);
        if (focusGroupView != null) {
            focusGroupView.switchTable(roomId, tableId, user);
        }
    }

    public final void updateDeskMateTag(String uin, CommonTagInfo tag) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(tag, "tag");
        FocusBaseFragment focusFragment = getFocusFragment();
        IFocusParentView fragmentView = focusFragment != null ? focusFragment.getFragmentView() : null;
        FocusGroupView focusGroupView = (FocusGroupView) (fragmentView instanceof FocusGroupView ? fragmentView : null);
        if (focusGroupView != null) {
            focusGroupView.updateDeskMateTag(uin, tag);
        }
    }

    public final void updateLikeNum(long toUin, long likeNum) {
        FocusItem focusItem;
        User user;
        SitDownInfo sitDown;
        IFocusParentView fragmentView;
        FocusCommonView commonView;
        FocusBaseItem data = getData();
        if (data == null || (focusItem = data.getFocusItem(String.valueOf(toUin))) == null || (user = focusItem.getUser()) == null || (sitDown = user.getSitDown()) == null) {
            return;
        }
        sitDown.setLikeNum(likeNum);
        FocusBaseFragment focusFragment = getFocusFragment();
        if (focusFragment == null || (fragmentView = focusFragment.getFragmentView()) == null || (commonView = fragmentView.getCommonView()) == null) {
            return;
        }
        commonView.updateLikeView(sitDown);
    }

    public final void updateUserResource(String uin, Resource resource) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        Object obj;
        Object component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FocusItem singleItem;
        User user;
        SitDownInfo sitDown;
        FocusItem rightItem;
        User user2;
        SitDownInfo sitDown2;
        FocusItem item;
        User user3;
        SitDownInfo sitDown3;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(resource, "resource");
        FocusBaseFragment focusFragment = getFocusFragment();
        if (focusFragment instanceof FocusGroupFragment) {
            FocusBaseItem data = getData();
            if (checkResourceChange(uin, data != null ? data.getItem() : null, resource)) {
                FocusBaseItem data2 = getData();
                if (data2 != null && (item = data2.getItem()) != null && (user3 = item.getUser()) != null && (sitDown3 = user3.getSitDown()) != null) {
                    sitDown3.setResource(resource);
                }
                FocusBaseFragment focusFragment2 = getFocusFragment();
                Object fragmentView = focusFragment2 != null ? focusFragment2.getFragmentView() : null;
                FocusGroupView focusGroupView = (FocusGroupView) (fragmentView instanceof FocusGroupView ? fragmentView : null);
                if (focusGroupView != null) {
                    focusGroupView.playTargetAvatar(true);
                    return;
                }
                return;
            }
            FocusBaseItem data3 = getData();
            if (checkResourceChange(uin, data3 != null ? data3.getRightItem() : null, resource)) {
                FocusBaseItem data4 = getData();
                if (data4 != null && (rightItem = data4.getRightItem()) != null && (user2 = rightItem.getUser()) != null && (sitDown2 = user2.getSitDown()) != null) {
                    sitDown2.setResource(resource);
                }
                FocusBaseFragment focusFragment3 = getFocusFragment();
                Object fragmentView2 = focusFragment3 != null ? focusFragment3.getFragmentView() : null;
                FocusGroupView focusGroupView2 = (FocusGroupView) (fragmentView2 instanceof FocusGroupView ? fragmentView2 : null);
                if (focusGroupView2 != null) {
                    focusGroupView2.playTargetAvatar(false);
                    return;
                }
                return;
            }
            return;
        }
        if (focusFragment instanceof FocusSingleBaseFragment) {
            FocusBaseItem data5 = getData();
            if (checkResourceChange(uin, data5 != null ? data5.getSingleItem() : null, resource)) {
                FocusBaseItem data6 = getData();
                if (data6 != null && (singleItem = data6.getSingleItem()) != null && (user = singleItem.getUser()) != null && (sitDown = user.getSitDown()) != null) {
                    sitDown.setResource(resource);
                }
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (obj = vasBaseFragmentComponentGroup2.getComponent(FocusSingleComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (obj = vasBaseFragmentComponentGroup.getComponent(FocusSingleComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, FocusSingleComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment2 != null) {
                            r2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, FocusSingleComponent.class, null, null, 6, null);
                        }
                    } else {
                        r2 = component$default;
                    }
                    obj = r2;
                }
                FocusSingleComponent focusSingleComponent = (FocusSingleComponent) obj;
                if (focusSingleComponent != null) {
                    focusSingleComponent.playAvatar(resource, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.component.FocusUIComponent$updateUserResource$1
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
            }
        }
    }

    private final boolean checkResourceChange(String uin, FocusItem data, Resource resource) {
        User user;
        return Intrinsics.areEqual((data == null || (user = data.getUser()) == null) ? null : user.getUin(), uin) && (Intrinsics.areEqual(FocusDataKt.focusResource(data), resource) ^ true);
    }

    private final void doGuestSitDown(long tableId, User user) {
    }

    private final void doMeSitDown(long tableId, User user) {
    }
}
