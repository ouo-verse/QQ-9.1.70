package com.tencent.state.library.components.fragments;

import android.content.Context;
import bs4.f;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.library.LibraryFragment;
import com.tencent.state.library.LibraryMapView;
import com.tencent.state.library.data.LibraryDataParserKt;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.focus.data.FocusGroupItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.publicchat.LibApplyCallGatherInfo;
import com.tencent.state.library.tag.IEditTagListener;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasSquareFocusService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.components.SquareLibraryOnFocusEvent;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.dialog.SceneCommonDialogs;
import com.tencent.state.template.event.SwitchTableEvent;
import com.tencent.state.template.fragment.TemplateCommonOperateComponent;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.TemplateMapViewKt;
import com.tencent.state.template.map.component.TemplateMapBaseComponent;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.map.component.TemplateSchemeComponent;
import com.tencent.state.template.map.component.TemplateSitComponent;
import com.tencent.state.template.map.component.TemplateUiComponent;
import com.tencent.state.view.SquareLoadingDialog;
import ft4.b;
import ft4.k;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import yr4.d;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J,\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fR\u001d\u0010+\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryPublicChatComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "", "doCallGather", "", "isSeated", "Lkotlin/Function0;", "onContinue", "checkFocusConflict", "Lyr4/d;", "invite", "doApplyCallGather", "Lcom/tencent/state/library/publicchat/LibApplyCallGatherInfo;", "info", "handleApplyCallGatherSuccess", "", "uin", "doViewTaFocusOtherRoom", "Lbs4/f;", "room", "", "msgOffset", "handleViewTaFocusOtherRoomSuccess", "", "error", "", "prompt", "allToast", "handleCommonError", "Lcom/tencent/state/template/data/Table;", "findTableByUin", "Lcom/tencent/state/template/item/TemplateAvatarItem;", "findMapItemByUin", "Lcom/tencent/state/library/focus/data/FocusGroupItem;", VipFunCallConstants.KEY_GROUP, "callGather", "applyCallGather", "viewTaFocus", "Lcom/tencent/state/view/SquareLoadingDialog;", "loading$delegate", "Lkotlin/Lazy;", "getLoading", "()Lcom/tencent/state/view/SquareLoadingDialog;", ToastView.ICON_LOADING, "<init>", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryPublicChatComponent extends TemplateMapBaseComponent {
    private static final int ERR_CODE_USER_LEAVE = -25001;
    private static final String TAG = "LibraryPublicChatComponent";

    /* renamed from: loading$delegate, reason: from kotlin metadata */
    private final Lazy loading;

    public LibraryPublicChatComponent() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareLoadingDialog>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$loading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareLoadingDialog invoke() {
                QBaseActivity activity;
                activity = LibraryPublicChatComponent.this.getActivity();
                if (activity != null) {
                    return new SquareLoadingDialog(activity, false);
                }
                return null;
            }
        });
        this.loading = lazy;
    }

    private final void checkFocusConflict(boolean isSeated, final Function0<Unit> onContinue) {
        Context context;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (!isSeated) {
            SceneCommonDialogs.INSTANCE.checkSceneConflictDialog(context, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$checkFocusConflict$1
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
                    Function0.this.invoke();
                }
            }, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$checkFocusConflict$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
        } else {
            onContinue.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doApplyCallGather(final d invite, final boolean isSeated) {
        checkFocusConflict(isSeated, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$doApplyCallGather$1
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
                SquareLoadingDialog loading;
                loading = LibraryPublicChatComponent.this.getLoading();
                if (loading != null) {
                    loading.showSafely();
                }
                VasSquareFocusService vasSquareFocusService = VasSquareFocusService.INSTANCE;
                int appId = LibraryPublicChatComponent.this.getAppId();
                d dVar = invite;
                vasSquareFocusService.applyCallGather(appId, dVar.f451099a, dVar.f451103e, dVar.f451101c, dVar.f451102d, new ResultCallback<b>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$doApplyCallGather$1.1
                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message, String prompt) {
                        ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                        LibraryPublicChatComponent$doApplyCallGather$1 libraryPublicChatComponent$doApplyCallGather$1 = LibraryPublicChatComponent$doApplyCallGather$1.this;
                        LibraryPublicChatComponent.handleCommonError$default(LibraryPublicChatComponent.this, error, prompt, invite.f451099a, false, 8, null);
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultSuccess(b result) {
                        SquareLoadingDialog loading2;
                        SquareLoadingDialog loading3;
                        Intrinsics.checkNotNullParameter(result, "result");
                        try {
                            LibApplyCallGatherInfo libApplyCallGatherInfo = new LibApplyCallGatherInfo(result);
                            SquareLogger squareLog = SquareBaseKt.getSquareLog();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("\u54cd\u5e94\u53ec\u96c6\u6210\u4e3a\u540c\u684c\u6210\u529f, \u540c\u4e00\u623f\u95f4: ");
                            sb5.append(libApplyCallGatherInfo.getRoom().f29057a == 0);
                            squareLog.d("LibraryPublicChatComponent", sb5.toString());
                            LibraryPublicChatComponent$doApplyCallGather$1 libraryPublicChatComponent$doApplyCallGather$1 = LibraryPublicChatComponent$doApplyCallGather$1.this;
                            LibraryPublicChatComponent.this.handleApplyCallGatherSuccess(libApplyCallGatherInfo, isSeated);
                            loading3 = LibraryPublicChatComponent.this.getLoading();
                            if (loading3 != null) {
                                loading3.dismiss();
                            }
                        } catch (Exception e16) {
                            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "LibraryPublicChatComponent", "lib applyCallGather parse failed " + e16, null, 4, null);
                            loading2 = LibraryPublicChatComponent.this.getLoading();
                            if (loading2 != null) {
                                loading2.dismiss();
                            }
                        }
                    }

                    @Override // com.tencent.state.service.ResultCallback
                    public void onResultFailure(int error, String message) {
                        SquareLoadingDialog loading2;
                        loading2 = LibraryPublicChatComponent.this.getLoading();
                        if (loading2 != null) {
                            loading2.dismiss();
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doCallGather() {
        VasSquareFocusService.INSTANCE.callGather(getAppId(), new ResultCallback<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$doCallGather$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                VasBaseFragment fragment;
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                fragment = LibraryPublicChatComponent.this.getFragment();
                squareCommon.showToastSafely(fragment != null ? fragment.getContext() : null, prompt, 0);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(Unit result) {
                VasBaseFragment fragment;
                Intrinsics.checkNotNullParameter(result, "result");
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                fragment = LibraryPublicChatComponent.this.getFragment();
                squareCommon.showToastSafely(fragment != null ? fragment.getContext() : null, "\u5df2\u53d1\u9001\u5230\u516c\u5c4f\uff0c\u671f\u5f85\u540c\u684c\u52a0\u5165\u5427", 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doViewTaFocusOtherRoom(final long uin) {
        SquareBaseKt.getSquareLog().d(TAG, "\u6267\u884c\u8de8\u623f\u95f4\u67e5\u770b\u7528\u6237\u4e13\u6ce8");
        SquareLoadingDialog loading = getLoading();
        if (loading != null) {
            loading.showSafely();
        }
        VasSquareFocusService.INSTANCE.watchUserRoom(getAppId(), uin, new ResultCallback<k>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$doViewTaFocusOtherRoom$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                LibraryPublicChatComponent.this.handleCommonError(error, prompt, uin, true);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(k result) {
                SquareLoadingDialog loading2;
                Intrinsics.checkNotNullParameter(result, "result");
                f room = f.c(result.f400623a);
                byte[] bArr = result.f400624b;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                LibraryPublicChatComponent libraryPublicChatComponent = LibraryPublicChatComponent.this;
                long j3 = uin;
                Intrinsics.checkNotNullExpressionValue(room, "room");
                libraryPublicChatComponent.handleViewTaFocusOtherRoomSuccess(j3, room, bArr);
                loading2 = LibraryPublicChatComponent.this.getLoading();
                if (loading2 != null) {
                    loading2.dismiss();
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLoadingDialog loading2;
                loading2 = LibraryPublicChatComponent.this.getLoading();
                if (loading2 != null) {
                    loading2.dismiss();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TemplateAvatarItem findMapItemByUin(long uin) {
        LibraryMapView mapView;
        MapAdapter adapter;
        final String valueOf = String.valueOf(uin);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        VasBaseFragment fragment = getFragment();
        LibraryFragment libraryFragment = (LibraryFragment) (fragment instanceof LibraryFragment ? fragment : null);
        if (libraryFragment != null && (mapView = libraryFragment.getMapView()) != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$findMapItemByUin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, MapItem mapItem) {
                    invoke(num.intValue(), mapItem);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r4v2, types: [T, com.tencent.state.template.item.TemplateAvatarItem] */
                public final void invoke(int i3, MapItem mapItem) {
                    if (Intrinsics.areEqual(mapItem != null ? mapItem.getUin() : null, valueOf)) {
                        Ref.ObjectRef objectRef2 = objectRef;
                        if (!(mapItem instanceof TemplateAvatarItem)) {
                            mapItem = null;
                        }
                        objectRef2.element = (TemplateAvatarItem) mapItem;
                    }
                }
            });
        }
        return (TemplateAvatarItem) objectRef.element;
    }

    private final Table findTableByUin(long uin) {
        User user;
        SitDownInfo sitDown;
        TemplateAvatarItem findMapItemByUin = findMapItemByUin(uin);
        if (findMapItemByUin == null || (user = findMapItemByUin.getUser()) == null || (sitDown = user.getSitDown()) == null) {
            return null;
        }
        return sitDown.getTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareLoadingDialog getLoading() {
        return (SquareLoadingDialog) this.loading.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCommonError(int error, String prompt, long uin, boolean allToast) {
        Context context;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (error != ERR_CODE_USER_LEAVE) {
            SquareBaseKt.getSquareCommon().showToastSafely(context, prompt, 0);
            return;
        }
        if (allToast) {
            SquareBaseKt.getSquareCommon().showToastSafely(context, prompt, 0);
            return;
        }
        String friendRemarkName = Square.INSTANCE.getConfig().getCommonUtils().getFriendRemarkName(String.valueOf(uin), "TA");
        boolean z16 = this instanceof VasBaseFragmentComponentGroup;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(TemplateSitComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateSitComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateSitComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, TemplateSitComponent.class, null, null, 6, null) : null;
        }
        TemplateSitComponent templateSitComponent = (TemplateSitComponent) component$default;
        if (templateSitComponent != null) {
            templateSitComponent.setCalendarViewVisible(false);
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(TemplateSchemeComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(TemplateSchemeComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateSchemeComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, TemplateSchemeComponent.class, null, null, 6, null) : null;
        }
        TemplateSchemeComponent templateSchemeComponent = (TemplateSchemeComponent) component$default2;
        if (templateSchemeComponent != null) {
            templateSchemeComponent.onShowUserHasLeaveDialog(context, friendRemarkName, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewTaFocusOtherRoomSuccess(final long uin, f room, byte[] msgOffset) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        if (room.f29057a != 0) {
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) fragmentComponent;
            if (templateRoomComponent != null) {
                templateRoomComponent.handleRoomSwitched(new EnterRoomInfo(msgOffset, LibraryDataParserKt.parse(room), false));
            }
            SquareBaseKt.getSquareThread().postOnUiDelayed(1000L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$handleViewTaFocusOtherRoomSuccess$1
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
                    FragmentComponent fragmentComponent3;
                    FragmentComponent component$default2;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
                    LibraryPublicChatComponent libraryPublicChatComponent = LibraryPublicChatComponent.this;
                    FragmentComponent fragmentComponent4 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(libraryPublicChatComponent instanceof VasBaseFragmentComponentGroup) ? null : libraryPublicChatComponent);
                    if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent3 = vasBaseFragmentComponentGroup4.getComponent(TemplateUiComponent.class, null)) == null) && ((parent2 = libraryPublicChatComponent.getParent()) == null || (vasBaseFragmentComponentGroup3 = parent2.get()) == null || (fragmentComponent3 = vasBaseFragmentComponentGroup3.getComponent(TemplateUiComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) libraryPublicChatComponent).fragment;
                        if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, TemplateUiComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) libraryPublicChatComponent).parentFragment;
                            if (vasBaseFragment4 != null) {
                                fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, TemplateUiComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent4 = component$default2;
                        }
                        fragmentComponent3 = fragmentComponent4;
                    }
                    TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent3;
                    if (templateUiComponent != null) {
                        templateUiComponent.locateToAndScale(String.valueOf(uin));
                    }
                }
            });
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$handleViewTaFocusOtherRoomSuccess$2
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
                FragmentComponent fragmentComponent3;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
                LibraryPublicChatComponent libraryPublicChatComponent = LibraryPublicChatComponent.this;
                FragmentComponent fragmentComponent4 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(libraryPublicChatComponent instanceof VasBaseFragmentComponentGroup) ? null : libraryPublicChatComponent);
                if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent3 = vasBaseFragmentComponentGroup4.getComponent(TemplateUiComponent.class, null)) == null) && ((parent2 = libraryPublicChatComponent.getParent()) == null || (vasBaseFragmentComponentGroup3 = parent2.get()) == null || (fragmentComponent3 = vasBaseFragmentComponentGroup3.getComponent(TemplateUiComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) libraryPublicChatComponent).fragment;
                    if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, TemplateUiComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) libraryPublicChatComponent).parentFragment;
                        if (vasBaseFragment4 != null) {
                            fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, TemplateUiComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent4 = component$default2;
                    }
                    fragmentComponent3 = fragmentComponent4;
                }
                TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent3;
                if (templateUiComponent != null) {
                    templateUiComponent.locateToAndScale(String.valueOf(uin));
                }
            }
        });
    }

    public final void applyCallGather(final d invite) {
        Context context;
        Table neighbor;
        User user;
        Intrinsics.checkNotNullParameter(invite, "invite");
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        if (Intrinsics.areEqual(String.valueOf(invite.f451099a), SquareBaseKt.getSquareCommon().getCurrentAccountUin())) {
            viewTaFocus(invite.f451099a);
            return;
        }
        String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
        Table findTableByUin = findTableByUin(invite.f451099a);
        final boolean z16 = false;
        boolean z17 = findTableByUin != null;
        TemplateMapView<?> mapView = getMapView();
        if (mapView != null && TemplateMapViewKt.isMeSeated(mapView)) {
            z16 = true;
        }
        SquareBaseKt.getSquareLog().d(TAG, "\u54cd\u5e94\u53ec\u96c6\u6210\u4e3a\u540c\u684c isSameRoom: " + z17 + " isMeSeated: " + z16);
        if (!z17) {
            if (!z16) {
                doApplyCallGather(invite, z16);
                return;
            } else {
                FocusDialogTips.INSTANCE.showSeeOtherRoomFocusTips(context, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$applyCallGather$2
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

                    public final void invoke(boolean z18) {
                        SquareBaseKt.getSquareLog().d("LibraryPublicChatComponent", "\u6362\u623f\u9000\u51fa\u4e13\u6ce8\u63d0\u793a\uff0c\u786e\u8ba4: " + z18);
                        if (z18) {
                            LibraryPublicChatComponent.this.doApplyCallGather(invite, z16);
                        }
                    }
                });
                return;
            }
        }
        if (!z16) {
            doApplyCallGather(invite, z16);
            return;
        }
        if (Intrinsics.areEqual((findTableByUin == null || (neighbor = findTableByUin.getNeighbor()) == null || (user = neighbor.getUser()) == null) ? null : user.getUin(), currentAccountUin)) {
            viewTaFocus(invite.f451099a);
        } else {
            FocusDialogTips.showSwitchTableDialog$default(FocusDialogTips.INSTANCE, context, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$applyCallGather$1
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
                    LibraryPublicChatComponent.this.doApplyCallGather(invite, z16);
                }
            }, null, 4, null);
        }
    }

    public final void viewTaFocus(final long uin) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Context context;
        long parseLong = Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
        TemplateMapView<?> mapView = getMapView();
        boolean z16 = mapView != null && TemplateMapViewKt.isMeSeated(mapView);
        if (uin != parseLong || z16) {
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent;
            if (templateUiComponent != null) {
                Table findTableByUin = findTableByUin(uin);
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u6253\u5f00\u7528\u6237\u4e13\u6ce8\u8be6\u60c5\u9875 sameRoom: ");
                sb5.append(findTableByUin != null);
                squareLog.d(TAG, sb5.toString());
                if (findTableByUin != null) {
                    templateUiComponent.locateToAndScale(String.valueOf(uin));
                    SquareLoadingDialog loading = getLoading();
                    if (loading != null) {
                        loading.dismiss();
                        return;
                    }
                    return;
                }
                if (!z16) {
                    doViewTaFocusOtherRoom(uin);
                    return;
                }
                VasBaseFragment fragment = getFragment();
                if (fragment == null || (context = fragment.getContext()) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
                FocusDialogTips.INSTANCE.showSeeOtherRoomFocusTips(context, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$viewTaFocus$1
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

                    public final void invoke(boolean z17) {
                        SquareBaseKt.getSquareLog().d("LibraryPublicChatComponent", "\u6362\u623f\u9000\u51fa\u4e13\u6ce8\u63d0\u793a\uff0c\u786e\u8ba4: " + z17);
                        if (z17) {
                            LibraryPublicChatComponent.this.doViewTaFocusOtherRoom(uin);
                        }
                    }
                });
            }
        }
    }

    public final void callGather(FocusGroupItem group) {
        FocusItem focusItem;
        User user;
        Context context;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        if (group == null || (focusItem = group.getFocusItem(SquareBaseKt.getSquareCommon().getCurrentAccountUin())) == null || (user = focusItem.getUser()) == null) {
            return;
        }
        SitDownInfo sitDown = user.getSitDown();
        FragmentComponent fragmentComponent2 = null;
        CommonTagInfo subTag = sitDown != null ? sitDown.getSubTag() : null;
        if (subTag != null) {
            if (!(subTag.getId().length() == 0)) {
                doCallGather();
                return;
            }
        }
        FocusItem item = group.getItem();
        if (Intrinsics.areEqual(item, focusItem)) {
            item = group.getRightItem();
        }
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateCommonOperateComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateCommonOperateComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateCommonOperateComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateCommonOperateComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        TemplateCommonOperateComponent templateCommonOperateComponent = (TemplateCommonOperateComponent) fragmentComponent;
        if (templateCommonOperateComponent != null) {
            templateCommonOperateComponent.showEditDeskMateTagPanel(context, user, item.getRoomId(), item.getTable().getId(), new IEditTagListener() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$callGather$1
                @Override // com.tencent.state.library.tag.IEditTagListener
                public void onEditTagFailed(int errCode, String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                }

                @Override // com.tencent.state.library.tag.IEditTagListener
                public void onEditTagSuccess(String uin, CommonTagInfo deskMateTag) {
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    Intrinsics.checkNotNullParameter(deskMateTag, "deskMateTag");
                    LibraryPublicChatComponent.this.doCallGather();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleApplyCallGatherSuccess(LibApplyCallGatherInfo info, boolean isSeated) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        WeakReference<VasBaseFragmentComponentGroup> parent3;
        FragmentComponent fragmentComponent2;
        FragmentComponent component$default3;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
        WeakReference<VasBaseFragmentComponentGroup> parent4;
        FragmentComponent fragmentComponent3;
        FragmentComponent component$default4;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4;
        Long myRoomId;
        SquareBaseKt.getSquareLog().d(TAG, "handleApplyCallGatherSuccess " + isSeated + TokenParser.SP + info);
        FragmentComponent fragmentComponent4 = null;
        if (info.getRoom().f29057a == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new SquareLibraryOnFocusEvent());
            if (isSeated) {
                SquareBaseKt.getSquareLog().d(TAG, "\u540c\u623f\u95f4\u6362\u5ea7\u6210\u529f");
                User parse = LibraryDataParserKt.parse(info.getUser());
                SitDownInfo sitDown = parse.getSitDown();
                if (sitDown != null) {
                    long tableId = sitDown.getTableId();
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup5 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                    if ((vasBaseFragmentComponentGroup5 == null || (fragmentComponent3 = vasBaseFragmentComponentGroup5.getComponent(TemplateRoomComponent.class, null)) == null) && ((parent4 = getParent()) == null || (vasBaseFragmentComponentGroup4 = parent4.get()) == null || (fragmentComponent3 = vasBaseFragmentComponentGroup4.getComponent(TemplateRoomComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment;
                        if (vasBaseFragment2 == null || (component$default4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
                            if (vasBaseFragment3 != null) {
                                fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, TemplateRoomComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent4 = component$default4;
                        }
                        fragmentComponent3 = fragmentComponent4;
                    }
                    TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) fragmentComponent3;
                    if (templateRoomComponent == null || (myRoomId = templateRoomComponent.getMyRoomId()) == null) {
                        return;
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new SwitchTableEvent(parse, myRoomId.longValue(), tableId, false));
                    return;
                }
                return;
            }
            SquareBaseKt.getSquareLog().d(TAG, "\u540c\u623f\u95f4\u843d\u5ea7\u6210\u529f");
            User parse2 = LibraryDataParserKt.parse(info.getUser());
            boolean z16 = this instanceof VasBaseFragmentComponentGroup;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup6 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup6 == null || (component$default2 = vasBaseFragmentComponentGroup6.getComponent(TemplateSitComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(TemplateSitComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateSitComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, TemplateSitComponent.class, null, null, 6, null) : null;
            }
            TemplateSitComponent templateSitComponent = (TemplateSitComponent) component$default2;
            if (templateSitComponent != null) {
                templateSitComponent.onFocusSuccess(parse2, true);
            }
            SitDownInfo sitDown2 = parse2.getSitDown();
            if (sitDown2 != null) {
                long tableId2 = sitDown2.getTableId();
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup7 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
                if ((vasBaseFragmentComponentGroup7 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup7.getComponent(TemplateUiComponent.class, null)) == null) && ((parent3 = getParent()) == null || (vasBaseFragmentComponentGroup3 = parent3.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup3.getComponent(TemplateUiComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment5 == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, TemplateUiComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment6 != null) {
                            fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment6, TemplateUiComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent4 = component$default3;
                    }
                    fragmentComponent2 = fragmentComponent4;
                }
                TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent2;
                if (templateUiComponent != null) {
                    templateUiComponent.sitDown(tableId2, parse2);
                    return;
                }
                return;
            }
            return;
        }
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup8 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup8 == null || (fragmentComponent = vasBaseFragmentComponentGroup8.getComponent(TemplateRoomComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment7 = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment7 == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment7, TemplateRoomComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment8 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment8 != null) {
                    fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment8, TemplateRoomComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent4 = component$default;
            }
            fragmentComponent = fragmentComponent4;
        }
        TemplateRoomComponent templateRoomComponent2 = (TemplateRoomComponent) fragmentComponent;
        if (templateRoomComponent2 != null) {
            templateRoomComponent2.handleRoomSwitched(new EnterRoomInfo(info.getMsgOffset(), LibraryDataParserKt.parse(info.getRoom()), false));
        }
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPublicChatComponent$handleApplyCallGatherSuccess$2
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
                LibraryPublicChatComponent.this.viewTaFocus(Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void handleCommonError$default(LibraryPublicChatComponent libraryPublicChatComponent, int i3, String str, long j3, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        libraryPublicChatComponent.handleCommonError(i3, str, j3, z16);
    }
}
