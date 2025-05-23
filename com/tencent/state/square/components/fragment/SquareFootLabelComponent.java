package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.VasFocusLikeService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareMapViewModel;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.api.FloatPanelParams;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.ISquarePushListener;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.api.OpenHippyParams;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.template.data.CommonFootLabel;
import com.tencent.state.template.data.FootLabelInfo;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0006\u0010!\u001a\u00020\u000fJ\u0016\u0010\"\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareFootLabelComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "labelPushListener", "com/tencent/state/square/components/fragment/SquareFootLabelComponent$labelPushListener$1", "Lcom/tencent/state/square/components/fragment/SquareFootLabelComponent$labelPushListener$1;", "pushService", "Lcom/tencent/state/square/api/ISquarePushService;", "getPushService", "()Lcom/tencent/state/square/api/ISquarePushService;", "reporter", "Lcom/tencent/state/square/IReporter;", "vm", "Lcom/tencent/state/square/SquareMapViewModel;", "handleClickLabel", "", "label", "Lcom/tencent/state/template/data/CommonFootLabel;", "uin", "", "handleLunchH5", "handleLunchHippy", "handleLunchScheme", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "refreshAvatarFootLabel", "refreshAvatarFootLabelByUin", SquareJSConst.Params.PARAMS_UIN_LIST, "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFootLabelComponent extends SquareBaseComponent {
    private static final int JUMP_TYPE_H5 = 4;
    private static final int JUMP_TYPE_HIPPY = 3;
    private static final int JUMP_TYPE_NO = 1;
    private static final int JUMP_TYPE_SCHEMA = 2;
    private static final String TAG = "SquareFootLabelComponent";
    private SquareMapViewModel vm;
    private IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
    private final SquareFootLabelComponent$labelPushListener$1 labelPushListener = new ISquarePushListener() { // from class: com.tencent.state.square.components.fragment.SquareFootLabelComponent$labelPushListener$1
        @Override // com.tencent.state.square.api.ISquarePushListener
        public void onResult(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                SquareFootLabelComponent.this.refreshAvatarFootLabel();
            } catch (Throwable th5) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareFootLabelComponent", "labelPushListener parse error " + th5, null, 4, null);
            }
        }
    };

    private final ISquarePushService getPushService() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(SquareServiceProvider.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareServiceProvider.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareServiceProvider.class, null, null, 6, null) : null;
        }
        SquareServiceProvider squareServiceProvider = (SquareServiceProvider) component$default;
        if (squareServiceProvider != null) {
            return squareServiceProvider.getPushService();
        }
        return null;
    }

    private final void handleLunchH5(CommonFootLabel label) {
        QBaseActivity activity = getActivity();
        if (activity != null) {
            SquareBaseKt.getSquareLog().i(TAG, "handleLunchH5 " + label.linkUrl());
            String linkUrl = label.linkUrl();
            if (linkUrl != null) {
                SquareBaseKt.getSquareRouter().routeLink(activity, new EntranceLink(linkUrl, 1));
            }
        }
    }

    private final void handleLunchHippy(CommonFootLabel label) {
        QBaseActivity activity = getActivity();
        if (activity != null) {
            SquareBaseKt.getSquareLog().i(TAG, "handleLunchHippy " + label.bundleName() + ", " + label.domainName() + ", " + label.linkUrl());
            String bundleName = label.bundleName();
            if (bundleName == null) {
                bundleName = "";
            }
            String domainName = label.domainName();
            if (domainName == null) {
                domainName = "";
            }
            String linkUrl = label.linkUrl();
            OpenHippyParams openHippyParams = new OpenHippyParams(bundleName, domainName, linkUrl != null ? linkUrl : "");
            FootLabelInfo label2 = label.getLabel();
            if (label2 != null && label2.isAsyncLibraryLabel()) {
                int screenWidth$default = (int) (SquareUtil.getScreenWidth$default(SquareUtil.INSTANCE, 0.0f, 1, null) * 1.376f);
                ISquareHippyEngine hippyEngine = Square.INSTANCE.getConfig().getHippyEngine();
                VasBaseFragment parentFragment = getParentFragment();
                hippyEngine.openHippyPanel(activity, parentFragment != null ? parentFragment.getChildFragmentManager() : null, openHippyParams, new FloatPanelParams(screenWidth$default, false, true, Integer.valueOf(R.drawable.gtg), 2, null));
                return;
            }
            ISquareHippyEngine hippyEngine2 = Square.INSTANCE.getConfig().getHippyEngine();
            VasBaseFragment parentFragment2 = getParentFragment();
            hippyEngine2.openHippyPage(activity, parentFragment2 != null ? parentFragment2.getChildFragmentManager() : null, openHippyParams, true);
        }
    }

    private final void handleLunchScheme(CommonFootLabel label) {
        QBaseActivity activity = getActivity();
        if (activity != null) {
            SquareBaseKt.getSquareLog().i(TAG, "handleLunchScheme " + label.linkUrl());
            String linkUrl = label.linkUrl();
            if (linkUrl != null) {
                SquareBaseKt.getSquareRouter().routeLink(activity, new EntranceLink(linkUrl, 2));
            }
        }
    }

    private final void refreshAvatarFootLabelByUin(List<String> uinList) {
        Long longOrNull;
        if (uinList.isEmpty()) {
            return;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        Iterator<T> it = uinList.iterator();
        while (it.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        VasFocusLikeService.INSTANCE.batchGetFootLabel(arrayList, new Function2<Boolean, ArrayList<CommonFootLabel>, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFootLabelComponent$refreshAvatarFootLabelByUin$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, ArrayList<CommonFootLabel> arrayList2) {
                invoke(bool.booleanValue(), arrayList2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, ArrayList<CommonFootLabel> labels) {
                ISquareViewUpdater updater;
                Intrinsics.checkNotNullParameter(labels, "labels");
                if (z16) {
                    Iterator<CommonFootLabel> it5 = labels.iterator();
                    while (it5.hasNext()) {
                        CommonFootLabel label = it5.next();
                        SquareView mapView = SquareFootLabelComponent.this.getMapView();
                        if (mapView != null && (updater = mapView.getUpdater()) != null) {
                            Intrinsics.checkNotNullExpressionValue(label, "label");
                            updater.onFootLabelChangeNotify(label);
                        }
                    }
                }
            }
        });
    }

    public final void handleClickLabel(CommonFootLabel label, String uin) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (label == null) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "handleClickLabel " + label);
        Integer jumpType = label.jumpType();
        if (jumpType != null && jumpType.intValue() == 2) {
            handleLunchScheme(label);
        } else if (jumpType != null && jumpType.intValue() == 3) {
            handleLunchHippy(label);
        } else if (jumpType != null && jumpType.intValue() == 4) {
            handleLunchH5(label);
        }
        if (label.linkUrl() != null) {
            String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
            IReporter iReporter = this.reporter;
            Pair[] pairArr = new Pair[6];
            pairArr[0] = TuplesKt.to("zplan_other_user_qq", uin);
            pairArr[1] = TuplesKt.to("zplan_action_type", "click");
            pairArr[2] = TuplesKt.to("dt_pgid", checkNearby);
            pairArr[3] = TuplesKt.to("pgid", checkNearby);
            pairArr[4] = TuplesKt.to("zplan_event_source_parameters", Integer.valueOf(label.scene() == FootLabelInfo.Companion.SourceScene.LIBRARY ? 1 : 2));
            pairArr[5] = TuplesKt.to("zplan_footer_type", Integer.valueOf(label.labelType() == FootLabelInfo.Companion.LabelType.SYNC ? 1 : 2));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_FOCUS_AVATAR_LIBRARY_ICON, mutableMapOf);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        ISquarePushService pushService = getPushService();
        if (pushService != null) {
            pushService.removeListener(4, this.labelPushListener);
        }
        ISquarePushService pushService2 = getPushService();
        if (pushService2 != null) {
            pushService2.removeListener(8, this.labelPushListener);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.vm = (SquareMapViewModel) VMUtils.INSTANCE.safelyGet(f16, SquareMapViewModel.class);
        ISquarePushService pushService = getPushService();
        if (pushService != null) {
            pushService.addListener(4, this.labelPushListener);
        }
        ISquarePushService pushService2 = getPushService();
        if (pushService2 != null) {
            pushService2.addListener(8, this.labelPushListener);
        }
    }

    public final void refreshAvatarFootLabel() {
        MapAdapter adapter;
        final ArrayList arrayList = new ArrayList();
        SquareView mapView = getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            adapter.forEachItemData(new Function2<Integer, MapItem, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareFootLabelComponent$refreshAvatarFootLabel$1
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

                public final void invoke(int i3, MapItem mapItem) {
                    String uin;
                    if (!(mapItem instanceof SquareAvatarItem)) {
                        mapItem = null;
                    }
                    SquareAvatarItem squareAvatarItem = (SquareAvatarItem) mapItem;
                    if (squareAvatarItem == null || (uin = squareAvatarItem.getUin()) == null) {
                        return;
                    }
                    arrayList.add(uin);
                }
            });
        }
        refreshAvatarFootLabelByUin(arrayList);
    }
}
