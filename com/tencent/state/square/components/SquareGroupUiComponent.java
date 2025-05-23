package com.tencent.state.square.components;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.IActivityResultHandler;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareDeviceType;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.SquareMiniAioMultiSelectedRecord;
import com.tencent.state.square.databinding.VasSquareGroupFragmentSquareBinding;
import com.tencent.state.square.detail.DetailSelectMeFragment;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.message.MiniAIOCloseHelper;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0003JY\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0016Ji\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0006\u0010 \u001a\u00020\tJ\n\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u0004\u0018\u00010$J\b\u0010%\u001a\u00020\tH\u0002J&\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013J$\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J,\u00101\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000e\u00104\u001a\u00020\t2\u0006\u0010'\u001a\u00020(R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/state/square/components/SquareGroupUiComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/IActivityResultHandler;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareGroupFragmentSquareBinding;", "squareFragment", "Lcom/tencent/state/square/SquareFragment;", "addMultiRoles", "", "list", "", "Lcom/tencent/state/square/MoveItem;", "from", "", "scene", "Lcom/tencent/state/square/detail/MainScene;", "sceneType", "callback", "Lkotlin/Function1;", "", "Lcom/tencent/state/square/MoveResult;", "(Ljava/util/List;ILcom/tencent/state/square/detail/MainScene;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "needToast", "", "needLocateTo", "(Ljava/util/List;ILcom/tencent/state/square/detail/MainScene;Ljava/lang/Integer;ZZLkotlin/jvm/functions/Function1;)V", "doOnActivityResult", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "forbidDialog", "getServiceProvider", "Lcom/tencent/state/square/components/ISquareServiceProvider;", "getSquareViewManagerProxy", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "initSquareFragment", "locateTo", "uin", "", "locateToEndCb", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentViewCreated", "v", "Landroid/view/View;", "playRing", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupUiComponent extends VasBaseFragmentComponent implements IActivityResultHandler {
    private static final String TAG = "SquareUIComponent";
    private VasSquareGroupFragmentSquareBinding binding;
    private SquareFragment squareFragment;

    private final ISquareServiceProvider getServiceProvider() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareGroupServiceComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareGroupServiceComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareGroupServiceComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareGroupServiceComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        return (ISquareServiceProvider) fragmentComponent;
    }

    private final void initSquareFragment() {
        SquareDeviceType deviceType;
        FrameLayout mContainer;
        SquareBaseKt.getSquareLog().i(TAG, "initSquareFragment");
        QBaseActivity activity = getActivity();
        if (activity != null && ((deviceType = Square.INSTANCE.getConfig().getRouter().getDeviceType(activity)) == SquareDeviceType.TABLET || deviceType == SquareDeviceType.FOLD)) {
            VasSquareGroupFragmentSquareBinding vasSquareGroupFragmentSquareBinding = this.binding;
            if (vasSquareGroupFragmentSquareBinding != null && (mContainer = vasSquareGroupFragmentSquareBinding.getMContainer()) != null) {
                mContainer.setBackgroundColor(-1);
            }
            forbidDialog();
            return;
        }
        this.squareFragment = SquareFragment.INSTANCE.newInstance();
        VasBaseFragment fragment = getFragment();
        if (fragment != null) {
            fragment.pushFragment(this.squareFragment);
        }
    }

    public final void addMultiRoles(List<MoveItem> list, int from, MainScene scene, Integer sceneType, Function1<? super Map<MoveItem, MoveResult>, Unit> callback) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(scene, "scene");
        SquareFragment squareFragment = this.squareFragment;
        if (squareFragment != null) {
            ISquareRoleManager.DefaultImpls.addMultiRoles$default(squareFragment, list, from, scene, sceneType, false, false, callback, 48, null);
        }
    }

    public final void forbidDialog() {
        Context context;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        ResStyle resStyle = new ResStyle(null, null, null, 0, 0, null, null, null, Integer.valueOf(R.drawable.f159800gs0), 254, null);
        String string = context.getString(R.string.xhi);
        String string2 = context.getString(R.string.xhj);
        Intrinsics.checkNotNullExpressionValue(string2, "ctx.getString(R.string.v\u2026e_white_list_pad_message)");
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, "", null, null, string, new ContentStyle(string2, 0.0f, 0, false, 0, null, null, 126, null), null, false, null, true, TroopInfo.PAY_PRIVILEGE_ALL, null));
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.square.components.SquareGroupUiComponent$forbidDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                SquareFragment squareFragment;
                squareFragment = SquareGroupUiComponent.this.squareFragment;
                if (squareFragment != null) {
                    squareFragment.onBackPressedNotCheck();
                }
            }
        });
        commonDialog.show();
    }

    public final ISquareViewManagerProxy getSquareViewManagerProxy() {
        return this.squareFragment;
    }

    public final void locateTo(String uin, Function1<? super Boolean, Unit> locateToEndCb) {
        SquareView mapView;
        IMapViewManipulator manipulator;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareFragment squareFragment = this.squareFragment;
        if (squareFragment == null || (mapView = squareFragment.getMapView()) == null || (manipulator = mapView.getManipulator()) == null) {
            return;
        }
        manipulator.locateTo(uin, locateToEndCb);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ApngImage.resumeAll();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareGroupFragmentSquareBinding.bind(v3);
        initSquareFragment();
    }

    public final void playRing(String uin) {
        SquareView mapView;
        ISquareViewUpdater updater;
        Intrinsics.checkNotNullParameter(uin, "uin");
        SquareFragment squareFragment = this.squareFragment;
        if (squareFragment == null || (mapView = squareFragment.getMapView()) == null || (updater = mapView.getUpdater()) == null) {
            return;
        }
        updater.playRingAnim(uin);
    }

    public final void addMultiRoles(List<MoveItem> list, int from, MainScene scene, Integer sceneType, boolean needToast, boolean needLocateTo, Function1<? super Map<MoveItem, MoveResult>, Unit> callback) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(scene, "scene");
        SquareFragment squareFragment = this.squareFragment;
        if (squareFragment != null) {
            squareFragment.addMultiRoles(list, from, scene, sceneType, needToast, needLocateTo, callback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void locateTo$default(SquareGroupUiComponent squareGroupUiComponent, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        squareGroupUiComponent.locateTo(str, function1);
    }

    @Override // com.tencent.state.IActivityResultHandler
    public void doOnActivityResult(int requestCode, int resultCode, Intent data) {
        List<MoveItem> emptyList;
        MainScene mainScene;
        ISquareBaseMessageService messageService;
        if (resultCode == -1 && requestCode == 1208) {
            SquareFragment squareFragment = this.squareFragment;
            Fragment topFragment = squareFragment != null ? squareFragment.getTopFragment() : null;
            if (!(topFragment instanceof DetailSelectMeFragment)) {
                topFragment = null;
            }
            DetailSelectMeFragment detailSelectMeFragment = (DetailSelectMeFragment) topFragment;
            if (detailSelectMeFragment != null) {
                detailSelectMeFragment.getPoiInfo(requestCode, resultCode, data);
            }
        }
        if (resultCode != -1 || requestCode != 1000) {
            if (requestCode == 1001) {
                SquareFragment squareFragment2 = this.squareFragment;
                SquareFragment squareFragment3 = squareFragment2 instanceof ISquareViewManagerProxy ? squareFragment2 : null;
                if (squareFragment3 != null) {
                    MiniAIOCloseHelper.INSTANCE.onCloseMiniAIO(squareFragment2, squareFragment3, data);
                    return;
                }
                return;
            }
            return;
        }
        ISquareServiceProvider serviceProvider = getServiceProvider();
        List<SquareMiniAioMultiSelectedRecord> parseMultiSelectedUinInfo = (serviceProvider == null || (messageService = serviceProvider.getMessageService()) == null) ? null : messageService.parseMultiSelectedUinInfo(data);
        if (parseMultiSelectedUinInfo == null || (emptyList = MoveItem.INSTANCE.covertFromSelectedInfoList(parseMultiSelectedUinInfo)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        List<MoveItem> list = emptyList;
        if (!list.isEmpty()) {
            VasBaseFragment fragment = getFragment();
            Fragment topFragment2 = fragment != null ? fragment.getTopFragment() : null;
            VasBaseFragment vasBaseFragment = (VasBaseFragment) (topFragment2 instanceof VasBaseFragment ? topFragment2 : null);
            if (vasBaseFragment == null || (mainScene = vasBaseFragment.getMainScene()) == null) {
                mainScene = MainScene.UNKNOWN;
            }
            MainScene mainScene2 = mainScene;
            SquareFragment squareFragment4 = this.squareFragment;
            if (squareFragment4 != null) {
                ISquareRoleManager.DefaultImpls.addMultiRoles$default(squareFragment4, list, 0, mainScene2, null, false, false, null, 120, null);
            }
        }
    }
}
