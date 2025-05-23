package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareHippyMethodObserver;
import com.tencent.state.square.components.SquareGroupUiComponent;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.detail.StatusPublishHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0019\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareJSComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/state/square/api/ISquareHippyMethodObserver;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "publishHelper", "Lcom/tencent/state/square/detail/StatusPublishHelper;", "addToSquare", "", "hippyMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "bindFriendPickRedDot", WidgetCacheConstellationData.NUM, "", "onFragmentCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onFragmentViewCreated", "v", "Landroid/view/View;", "onMethodCall", "method", "", "readableMap", "publishStatus", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareJSComponent extends SquareBaseComponent implements ISquareHippyMethodObserver {
    private static final String TAG = "SquareJSComponent";
    private VasSquareFragmentSquareBinding binding;
    private final StatusPublishHelper publishHelper = new StatusPublishHelper();

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Square.INSTANCE.getConfig().getHippyEngine().addMethodObserver(this);
        this.publishHelper.init();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Square.INSTANCE.getConfig().getHippyEngine().removeMethodObserver(this);
        this.publishHelper.destroy();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentSquareBinding.bind(v3);
    }

    @Override // com.tencent.state.square.api.ISquareHippyMethodObserver
    public void onMethodCall(String method, HippyMap readableMap, Promise promise) {
        SquareFragment squareFragment;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        SquareBaseKt.getSquareLog().i(TAG, "onMethodCall method:" + method);
        switch (method.hashCode()) {
            case -1778186280:
                if (!method.equals(SquareJSConst.Method.METHOD_HIPPY_REFRESH_SQUARE) || (squareFragment = getSquareFragment()) == null) {
                    return;
                }
                squareFragment.refreshMapDataList();
                return;
            case -235365105:
                if (method.equals("publish")) {
                    publishStatus(readableMap, promise);
                    return;
                }
                return;
            case 1380369783:
                if (method.equals(SquareJSConst.Method.METHOD_HIPPY_ADD_LIST_SQUARE)) {
                    addToSquare(readableMap, promise);
                    return;
                }
                return;
            case 1425330050:
                if (method.equals(SquareJSConst.Method.METHOD_HIPPY_UPDATE_FRIEND_PICK) && readableMap.containsKey(SquareJSConst.Params.PARAMS_NUMS)) {
                    bindFriendPickRedDot(readableMap.getLong(SquareJSConst.Params.PARAMS_NUMS));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void addToSquare(HippyMap hippyMap, Promise promise) {
        SquareGroupUiComponent squareGroupUiComponent;
        HippyArray array = hippyMap.getArray(SquareJSConst.Params.PARAMS_UIN_LIST);
        if (array != null) {
            int i3 = hippyMap.getInt("scene");
            ArrayList arrayList = new ArrayList();
            int size = array.size();
            if (size >= 0) {
                int i16 = 0;
                while (true) {
                    HippyMap map = array.getMap(i16);
                    if (map != null) {
                        arrayList.add(new MoveItem(String.valueOf(map.getLong("id")), map.getInt(SquareJSConst.Params.PARAMS_UNIT_TYPE), false, null, 12, null));
                    }
                    if (i16 == size) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            VasBaseFragment fragment = getFragment();
            if (fragment == null || (squareGroupUiComponent = (SquareGroupUiComponent) VasBaseLifecycleFragment.getComponent$default(fragment, SquareGroupUiComponent.class, null, null, 6, null)) == null) {
                return;
            }
            squareGroupUiComponent.addMultiRoles(arrayList, 5, MainScene.HIPPY, Integer.valueOf(i3), new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareJSComponent$addToSquare$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map2) {
                    invoke2((Map<MoveItem, MoveResult>) map2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<MoveItem, MoveResult> moveResult) {
                    Intrinsics.checkNotNullParameter(moveResult, "moveResult");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareJSComponent", "addToSquare: activity(" + moveResult + ')', null, 4, null);
                }
            });
        }
    }

    private final void publishStatus(HippyMap readableMap, final Promise promise) {
        int i3 = readableMap.getInt("status");
        int i16 = readableMap.getInt(SquareJSConst.Params.PARAMS_RICH_STATUS);
        String string = readableMap.getString(SquareJSConst.Params.PARAMS_CUSTOM_TEXT);
        if (string == null) {
            string = "";
        }
        int i17 = readableMap.getInt(SquareJSConst.Params.PARAMS_MOTION_ID);
        String str = string;
        OnlineStatus onlineStatus = new OnlineStatus(i16, i3, i16, null, null, null, null, str, null, null, 632, null);
        final HippyMap hippyMap = new HippyMap();
        this.publishHelper.doPublish(getActivity(), onlineStatus, i17, str, new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null), new Function1<StatusPublishHelper.PublishResult, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareJSComponent$publishStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StatusPublishHelper.PublishResult publishResult) {
                invoke2(publishResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StatusPublishHelper.PublishResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isStatusSuccess()) {
                    HippyMap.this.pushInt("result", 0);
                } else {
                    HippyMap.this.pushInt("result", -1);
                }
                Promise promise2 = promise;
                if (promise2 != null) {
                    promise2.resolve(HippyMap.this);
                }
            }
        });
    }

    private final void bindFriendPickRedDot(long num) {
    }
}
