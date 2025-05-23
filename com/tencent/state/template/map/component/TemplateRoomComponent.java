package com.tencent.state.template.map.component;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.map.TemplateMapViewKt;
import com.tencent.state.template.map.TemplateMapViewModel;
import com.tencent.state.template.service.ITemplateRoomService;
import com.tencent.state.view.SquareLoadingDialog;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 ?2\u00020\u0001:\u0001?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H$J\b\u0010\u0016\u001a\u00020\u0014H\u0016J!\u0010\u0017\u001a\u00020\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00142\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001fJ\r\u0010 \u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u0004\u0018\u00010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010'\u001a\u00020(H$J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H&J\u001a\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010'\u001a\u00020(H\u0016J\u001c\u00100\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\n\b\u0002\u00101\u001a\u0004\u0018\u000102H\u0016J$\u00103\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010'\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010'\u001a\u00020(H\u0016J,\u00107\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010'\u001a\u00020(2\u0006\u00108\u001a\u0002092\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u0010:\u001a\u00020\u0014J\b\u0010;\u001a\u00020\u0014H\u0002J(\u0010<\u001a\u00020\u00142\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00140>R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006@"}, d2 = {"Lcom/tencent/state/template/map/component/TemplateRoomComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "service", "Lcom/tencent/state/template/service/ITemplateRoomService;", "(Lcom/tencent/state/template/service/ITemplateRoomService;)V", ToastView.ICON_LOADING, "Lcom/tencent/state/view/SquareLoadingDialog;", "getLoading", "()Lcom/tencent/state/view/SquareLoadingDialog;", "loading$delegate", "Lkotlin/Lazy;", "getService", "()Lcom/tencent/state/template/service/ITemplateRoomService;", "vm", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "getVm", "()Lcom/tencent/state/template/map/TemplateMapViewModel;", "setVm", "(Lcom/tencent/state/template/map/TemplateMapViewModel;)V", "dismissLoading", "", "dispatchLeaveEvent", "ensureLibraryTop", "enterRoom", "roomId", "", "silence", "", "(Ljava/lang/Long;Z)V", "enterRoomByUin", "uin", "(Ljava/lang/Long;)V", "getMyRoomId", "()Ljava/lang/Long;", "getRoomFullTips", "", "getRoomThemeInfo", "Lcom/tencent/state/template/data/RoomThemeData;", "getViewModel", "f", "Landroidx/fragment/app/Fragment;", "handleRoomSwitched", "result", "Lcom/tencent/state/template/data/EnterRoomInfo;", "needAbortStudyMood", "onBackPressed", "fm", "Landroidx/fragment/app/FragmentManager;", "onEnterRoomRsp", "focusParams", "Lcom/tencent/state/template/data/SitDownTagParams;", "onFragmentCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onFragmentViewCreated", "v", "Landroid/view/View;", "reenterRoom", UIJsPlugin.EVENT_SHOW_LOADING, "switchRoom", "onFinish", "Lkotlin/Function1;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateRoomComponent extends TemplateMapBaseComponent {
    private static final String TAG = "TemplateRoomComponent";

    /* renamed from: loading$delegate, reason: from kotlin metadata */
    private final Lazy com.tencent.qqmini.sdk.widget.ToastView.ICON_LOADING java.lang.String;
    private final ITemplateRoomService service;
    private TemplateMapViewModel vm;

    public TemplateRoomComponent(ITemplateRoomService service) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareLoadingDialog>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$loading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareLoadingDialog invoke() {
                QBaseActivity activity;
                activity = TemplateRoomComponent.this.getActivity();
                if (activity != null) {
                    return new SquareLoadingDialog(activity, false, 2, null);
                }
                return null;
            }
        });
        this.com.tencent.qqmini.sdk.widget.ToastView.ICON_LOADING java.lang.String = lazy;
    }

    public final void dismissLoading() {
        try {
            SquareLoadingDialog loading = getLoading();
            if (loading != null) {
                loading.dismiss();
            }
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "dismissLoading err.", th5);
        }
    }

    private final SquareLoadingDialog getLoading() {
        return (SquareLoadingDialog) this.com.tencent.qqmini.sdk.widget.ToastView.ICON_LOADING java.lang.String.getValue();
    }

    private final void showLoading() {
        QBaseActivity activity = getActivity();
        if (activity == null || !activity.isFinishing()) {
            QBaseActivity activity2 = getActivity();
            if (activity2 == null || !activity2.isDestroyed()) {
                try {
                    SquareLoadingDialog loading = getLoading();
                    if (loading != null) {
                        loading.show();
                    }
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e(TAG, "showLoading err.", th5);
                }
            }
        }
    }

    protected abstract void dispatchLeaveEvent();

    public final void enterRoom(Long roomId, final boolean silence) {
        SquareBaseKt.getSquareLog().i(TAG, "enterRoom: appId=" + getAppId() + " roomId=" + roomId);
        if (!silence) {
            showLoading();
        }
        this.service.enterRoom(roomId, null, new ResultCallback<EnterRoomInfo>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$enterRoom$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                if (silence) {
                    return;
                }
                TemplateRoomComponent.this.dismissLoading();
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(EnterRoomInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                result.setReenter(false);
                TemplateRoomComponent.onEnterRoomRsp$default(TemplateRoomComponent.this, result, null, 2, null);
                if (silence) {
                    return;
                }
                TemplateRoomComponent.this.dismissLoading();
            }
        });
    }

    public final void enterRoomByUin(Long uin) {
        SquareBaseKt.getSquareLog().i(TAG, "enterRoomByUin: appId=" + getAppId() + " uin=" + uin);
        showLoading();
        this.service.enterRoom(null, uin, new ResultCallback<EnterRoomInfo>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$enterRoomByUin$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                TemplateRoomComponent.this.dismissLoading();
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(EnterRoomInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                result.setReenter(false);
                TemplateRoomComponent.onEnterRoomRsp$default(TemplateRoomComponent.this, result, null, 2, null);
                TemplateRoomComponent.this.dismissLoading();
            }
        });
    }

    public final Long getMyRoomId() {
        LiveData<EnterRoomInfo> enterRoomInfo;
        EnterRoomInfo value;
        CommonRoomInfo room;
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel == null || (enterRoomInfo = templateMapViewModel.getEnterRoomInfo()) == null || (value = enterRoomInfo.getValue()) == null || (room = value.getRoom()) == null) {
            return null;
        }
        return Long.valueOf(room.getId());
    }

    public abstract String getRoomFullTips();

    public final RoomThemeData getRoomThemeInfo() {
        LiveData<EnterRoomInfo> enterRoomInfo;
        EnterRoomInfo value;
        CommonRoomInfo room;
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel == null || (enterRoomInfo = templateMapViewModel.getEnterRoomInfo()) == null || (value = enterRoomInfo.getValue()) == null || (room = value.getRoom()) == null) {
            return null;
        }
        return room.getTheme();
    }

    public final ITemplateRoomService getService() {
        return this.service;
    }

    protected abstract TemplateMapViewModel getViewModel(Fragment f16);

    protected final TemplateMapViewModel getVm() {
        return this.vm;
    }

    public final void handleRoomSwitched(EnterRoomInfo result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ensureLibraryTop();
        result.setReenter(true);
        onEnterRoomRsp$default(this, result, null, 2, null);
    }

    public abstract boolean needAbortStudyMood(EnterRoomInfo result);

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        boolean isMeSeated = TemplateMapViewKt.isMeSeated(getMapView());
        SquareBaseKt.getSquareLog().i(TAG, "[EndFocus] onBackPressed, " + isMeSeated + TokenParser.SP + f16);
        if (!isMeSeated) {
            ITemplateRoomService.DefaultImpls.leaveRoom$default(this.service, null, 1, null);
        }
        dispatchLeaveEvent();
        return false;
    }

    public void onEnterRoomRsp(EnterRoomInfo result, SitDownTagParams focusParams) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        SitDownTagParams copy;
        Intrinsics.checkNotNullParameter(result, "result");
        final CommonRoomInfo room = result.getRoom();
        if (room == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "sendMapDataRequest success, but room is null", null, 4, null);
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "onEnterRoom appId=" + room.getAppId() + " roomId=" + room.getId() + " \u652f\u6301\u81ea\u7531\u70b9\u4f4d\uff1a" + room.isSupportFlexTable());
        if (needAbortStudyMood(result)) {
            return;
        }
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel != null) {
            templateMapViewModel.updateEnterRoomInfo(result);
        }
        if (focusParams != null) {
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateSitComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateSitComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateSitComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateSitComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            TemplateSitComponent templateSitComponent = (TemplateSitComponent) fragmentComponent;
            if (templateSitComponent != null) {
                copy = focusParams.copy((r18 & 1) != 0 ? focusParams.roomId : room.getId(), (r18 & 2) != 0 ? focusParams.tableId : 0L, (r18 & 4) != 0 ? focusParams.targetTagId : null, (r18 & 8) != 0 ? focusParams.subTagId : null, (r18 & 16) != 0 ? focusParams.isShowInSquare : false, (r18 & 32) != 0 ? focusParams.sitLocation : null);
                templateSitComponent.doFocus(copy, new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$onEnterRoomRsp$$inlined$let$lambda$1
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
                        VasBaseFragment fragment;
                        ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                        fragment = TemplateRoomComponent.this.getFragment();
                        ICommonUtils.DefaultImpls.showToastSafely$default(squareCommon, fragment != null ? fragment.requireContext() : null, TemplateRoomComponent.this.getRoomFullTips(), 0, 4, null);
                    }
                });
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle r36) {
        Intrinsics.checkNotNullParameter(f16, "f");
        this.vm = getViewModel(f16);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        SquareBaseKt.getSquareLog().i(TAG, "onFragmentDestroyed");
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle r46) {
        LiveData<EnterRoomInfo> enterRoomInfo;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel == null || (enterRoomInfo = templateMapViewModel.getEnterRoomInfo()) == null) {
            return;
        }
        enterRoomInfo.observe(f16.getViewLifecycleOwner(), new Observer<EnterRoomInfo>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$onFragmentViewCreated$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(final EnterRoomInfo enterRoomInfo2) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u623f\u95f4\u6570\u636e\u53d8\u66f4 appId=");
                CommonRoomInfo room = enterRoomInfo2.getRoom();
                sb5.append(room != null ? Integer.valueOf(room.getAppId()) : null);
                sb5.append(" roomId=");
                CommonRoomInfo room2 = enterRoomInfo2.getRoom();
                sb5.append(room2 != null ? Long.valueOf(room2.getId()) : null);
                squareLog.d("TemplateRoomComponent", sb5.toString());
                TemplateRoomComponent templateRoomComponent = TemplateRoomComponent.this;
                Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$onFragmentViewCreated$1.1
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
                        EnterRoomInfo room3 = EnterRoomInfo.this;
                        Intrinsics.checkNotNullExpressionValue(room3, "room");
                        it.onEnterRoom(room3);
                    }
                };
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templateRoomComponent).fragment;
                if (vasBaseFragment != null) {
                    WeakReference<VasBaseFragmentComponentGroup> parent = templateRoomComponent.getParent();
                    vasBaseFragment.forEachComponent(ITemplateMapEvent.class, parent != null ? parent.get() : null, null, function1);
                }
            }
        });
    }

    public final void reenterRoom() {
        LiveData<EnterRoomInfo> enterRoomInfo;
        EnterRoomInfo value;
        CommonRoomInfo room;
        TemplateMapViewModel templateMapViewModel = this.vm;
        if (templateMapViewModel == null || (enterRoomInfo = templateMapViewModel.getEnterRoomInfo()) == null || (value = enterRoomInfo.getValue()) == null || (room = value.getRoom()) == null) {
            return;
        }
        long id5 = room.getId();
        SquareBaseKt.getSquareLog().i(TAG, "reenterRoom: appId=" + getAppId() + " roomId=" + id5);
        showLoading();
        this.service.enterRoom(Long.valueOf(id5), null, new ResultCallback<EnterRoomInfo>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$reenterRoom$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                TemplateRoomComponent.this.dismissLoading();
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(EnterRoomInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TemplateRoomComponent.this.ensureLibraryTop();
                result.setReenter(true);
                TemplateRoomComponent.onEnterRoomRsp$default(TemplateRoomComponent.this, result, null, 2, null);
                TemplateRoomComponent.this.dismissLoading();
            }
        });
    }

    protected final void setVm(TemplateMapViewModel templateMapViewModel) {
        this.vm = templateMapViewModel;
    }

    public final void switchRoom(final SitDownTagParams focusParams, final Function1<? super Boolean, Unit> onFinish) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplatePushComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplatePushComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplatePushComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplatePushComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        TemplatePushComponent templatePushComponent = (TemplatePushComponent) fragmentComponent;
        if (templatePushComponent != null) {
            templatePushComponent.stopPush();
        }
        SquareBaseKt.getSquareLog().i(TAG, "switchRoom: appId=" + getAppId() + " focusParams=" + focusParams);
        showLoading();
        this.service.switchRoom(new ResultCallback<EnterRoomInfo>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$switchRoom$2
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                WeakReference<VasBaseFragmentComponentGroup> parent2;
                FragmentComponent fragmentComponent3;
                FragmentComponent component$default2;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
                TemplateRoomComponent.this.dismissLoading();
                onFinish.invoke(Boolean.FALSE);
                TemplateRoomComponent templateRoomComponent = TemplateRoomComponent.this;
                FragmentComponent fragmentComponent4 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(templateRoomComponent instanceof VasBaseFragmentComponentGroup) ? null : templateRoomComponent);
                if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent3 = vasBaseFragmentComponentGroup4.getComponent(TemplatePushComponent.class, null)) == null) && ((parent2 = templateRoomComponent.getParent()) == null || (vasBaseFragmentComponentGroup3 = parent2.get()) == null || (fragmentComponent3 = vasBaseFragmentComponentGroup3.getComponent(TemplatePushComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) templateRoomComponent).fragment;
                    if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, TemplatePushComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) templateRoomComponent).parentFragment;
                        if (vasBaseFragment4 != null) {
                            fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, TemplatePushComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent4 = component$default2;
                    }
                    fragmentComponent3 = fragmentComponent4;
                }
                TemplatePushComponent templatePushComponent2 = (TemplatePushComponent) fragmentComponent3;
                if (templatePushComponent2 != null) {
                    templatePushComponent2.restartPush();
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(EnterRoomInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                TemplateRoomComponent.this.ensureLibraryTop();
                result.setReenter(true);
                TemplateRoomComponent.this.onEnterRoomRsp(result, focusParams);
                TemplateRoomComponent.this.dismissLoading();
                onFinish.invoke(Boolean.TRUE);
            }
        });
    }

    public void ensureLibraryTop() {
        int i3 = 5;
        while (true) {
            VasBaseFragment fragment = getFragment();
            if (fragment != null && fragment.isTopFragment()) {
                return;
            }
            int i16 = i3 - 1;
            if (i3 <= 0) {
                return;
            }
            VasBaseFragment fragment2 = getFragment();
            Fragment topFragment = fragment2 != null ? fragment2.getTopFragment() : null;
            VasBaseFragment vasBaseFragment = (VasBaseFragment) (topFragment instanceof VasBaseFragment ? topFragment : null);
            if (vasBaseFragment != null) {
                vasBaseFragment.onBackPressed();
            }
            i3 = i16;
        }
    }

    public static /* synthetic */ void enterRoomByUin$default(TemplateRoomComponent templateRoomComponent, Long l3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                l3 = null;
            }
            templateRoomComponent.enterRoomByUin(l3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRoomByUin");
    }

    public static /* synthetic */ void onEnterRoomRsp$default(TemplateRoomComponent templateRoomComponent, EnterRoomInfo enterRoomInfo, SitDownTagParams sitDownTagParams, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                sitDownTagParams = null;
            }
            templateRoomComponent.onEnterRoomRsp(enterRoomInfo, sitDownTagParams);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEnterRoomRsp");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void switchRoom$default(TemplateRoomComponent templateRoomComponent, SitDownTagParams sitDownTagParams, Function1 function1, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                sitDownTagParams = null;
            }
            if ((i3 & 2) != 0) {
                function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.state.template.map.component.TemplateRoomComponent$switchRoom$1
                    public final void invoke(boolean z16) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                };
            }
            templateRoomComponent.switchRoom(sitDownTagParams, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchRoom");
    }

    public static /* synthetic */ void enterRoom$default(TemplateRoomComponent templateRoomComponent, Long l3, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                l3 = null;
            }
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            templateRoomComponent.enterRoom(l3, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterRoom");
    }
}
