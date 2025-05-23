package com.tencent.state.square.detail.components;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.databinding.VasSquareDetailMeViewBinding;
import com.tencent.state.square.detail.DetailCommonView;
import com.tencent.state.square.detail.DetailSelectGuestFragment;
import com.tencent.state.square.detail.DetailSelectGuestView;
import com.tencent.state.square.detail.DetailSelectMeFragment;
import com.tencent.state.square.detail.DetailSelectMeView;
import com.tencent.state.square.detail.IDetailParentView;
import com.tencent.state.square.flower.FlowerDisplayFragment;
import com.tencent.state.square.flower.FlowerGotEvent;
import com.tencent.state.square.flower.FlowerManager;
import com.tencent.state.square.flower.FlowerSyncEvent;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010!\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/state/square/detail/components/DetailFlowerComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/square/detail/components/IDetailEventListener;", "()V", "flowerEventReceiver", "com/tencent/state/square/detail/components/DetailFlowerComponent$flowerEventReceiver$1", "Lcom/tencent/state/square/detail/components/DetailFlowerComponent$flowerEventReceiver$1;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/square/data/SquareAvatarItem;", "getCommonView", "Lcom/tencent/state/square/detail/DetailCommonView;", "getReportParams", "", "", "", "getSelectGuestView", "Lcom/tencent/state/square/detail/DetailSelectGuestView;", "getSelectMeView", "Lcom/tencent/state/square/detail/DetailSelectMeView;", "initReport", "", "btnFlowerEntry", "Landroid/view/View;", "onFragmentEnter", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentViewDestroyed", "openFlowerFragment", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailFlowerComponent extends VasBaseFragmentComponent implements IDetailEventListener {
    private static final String TAG = "DetailFlowerComponent";
    private final DetailFlowerComponent$flowerEventReceiver$1 flowerEventReceiver = new SimpleEventReceiver<FlowerSyncEvent>() { // from class: com.tencent.state.square.detail.components.DetailFlowerComponent$flowerEventReceiver$1
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0085, code lost:
        
            r0 = r8.this$0.getSelectMeView();
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x012e, code lost:
        
            r0 = r8.this$0.getSelectMeView();
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceiveEvent(SimpleBaseEvent event) {
            SquareAvatarItem squareAvatarItem;
            SquareAvatarItem squareAvatarItem2;
            SquareAvatarItem squareAvatarItem3;
            SquareAvatarItem squareAvatarItem4;
            DetailCommonView commonView;
            DetailSelectMeView selectMeView;
            VasSquareDetailMeViewBinding binding;
            TextView textView;
            SquareAvatarExtra extra;
            SquareAvatarExtra extra2;
            SquareAvatarExtra extra3;
            SquareAvatarItem squareAvatarItem5;
            SquareAvatarExtra extra4;
            SquareAvatarItem squareAvatarItem6;
            SquareAvatarItem squareAvatarItem7;
            SquareAvatarItem squareAvatarItem8;
            DetailCommonView commonView2;
            DetailSelectMeView selectMeView2;
            VasSquareDetailMeViewBinding binding2;
            TextView textView2;
            SquareAvatarExtra extra5;
            SquareAvatarExtra extra6;
            SquareBaseKt.getSquareLog().i("DetailFlowerComponent", "[DetailFlowerComponent] onReceive: " + event);
            int i3 = 0;
            if (event instanceof FlowerSyncEvent) {
                squareAvatarItem6 = DetailFlowerComponent.this.item;
                if (squareAvatarItem6 != null && squareAvatarItem6.isMe()) {
                    i3 = 1;
                }
                squareAvatarItem7 = DetailFlowerComponent.this.item;
                if (squareAvatarItem7 != null && (extra6 = squareAvatarItem7.getExtra()) != null) {
                    extra6.setFlowerCount(((FlowerSyncEvent) event).getFlowerCount());
                }
                squareAvatarItem8 = DetailFlowerComponent.this.item;
                if (squareAvatarItem8 != null && (extra5 = squareAvatarItem8.getExtra()) != null) {
                    extra5.setFlowerMedal(((FlowerSyncEvent) event).getFlowerMedal());
                }
                commonView2 = DetailFlowerComponent.this.getCommonView();
                if (commonView2 != null) {
                    FlowerSyncEvent flowerSyncEvent = (FlowerSyncEvent) event;
                    commonView2.updateFlower(flowerSyncEvent.getFlowerCount(), flowerSyncEvent.getFlowerMedal(), i3 ^ 1, new DetailFlowerComponent$flowerEventReceiver$1$onReceiveEvent$1(DetailFlowerComponent.this));
                }
                if (i3 == 0 || selectMeView2 == null || (binding2 = selectMeView2.getBinding()) == null || (textView2 = binding2.flowerCountText) == null) {
                    return;
                }
                textView2.setText("\u82b1\u82b1x" + ((FlowerSyncEvent) event).getFlowerCount());
                return;
            }
            if (event instanceof FlowerGotEvent) {
                squareAvatarItem = DetailFlowerComponent.this.item;
                boolean z16 = squareAvatarItem != null && squareAvatarItem.isMe();
                squareAvatarItem2 = DetailFlowerComponent.this.item;
                if (squareAvatarItem2 != null && (extra3 = squareAvatarItem2.getExtra()) != null) {
                    squareAvatarItem5 = DetailFlowerComponent.this.item;
                    extra3.setFlowerCount(((squareAvatarItem5 == null || (extra4 = squareAvatarItem5.getExtra()) == null) ? 0 : extra4.getFlowerCount()) + ((FlowerGotEvent) event).getCount());
                }
                squareAvatarItem3 = DetailFlowerComponent.this.item;
                if (squareAvatarItem3 != null && (extra2 = squareAvatarItem3.getExtra()) != null) {
                    i3 = extra2.getFlowerCount();
                }
                squareAvatarItem4 = DetailFlowerComponent.this.item;
                MedalData flowerMedal = (squareAvatarItem4 == null || (extra = squareAvatarItem4.getExtra()) == null) ? null : extra.getFlowerMedal();
                commonView = DetailFlowerComponent.this.getCommonView();
                if (commonView != null) {
                    commonView.updateFlower(i3, flowerMedal, !z16, new DetailFlowerComponent$flowerEventReceiver$1$onReceiveEvent$2(DetailFlowerComponent.this));
                }
                if (!z16 || selectMeView == null || (binding = selectMeView.getBinding()) == null || (textView = binding.flowerCountText) == null) {
                    return;
                }
                textView.setText("\u82b1\u82b1x" + (i3 + ((FlowerGotEvent) event).getCount()));
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class<FlowerSyncEvent>> getEventClass() {
            ArrayList<Class<FlowerSyncEvent>> arrayListOf;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FlowerSyncEvent.class);
            return arrayListOf;
        }
    };
    private SquareAvatarItem item;

    /* JADX INFO: Access modifiers changed from: private */
    public final DetailCommonView getCommonView() {
        SquareAvatarItem squareAvatarItem = this.item;
        if (squareAvatarItem != null && squareAvatarItem.isMe()) {
            DetailSelectMeView selectMeView = getSelectMeView();
            if (selectMeView != null) {
                return selectMeView.getCommonView();
            }
            return null;
        }
        DetailSelectGuestView selectGuestView = getSelectGuestView();
        if (selectGuestView != null) {
            return selectGuestView.getCommonView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportParams(SquareAvatarItem item) {
        return new LinkedHashMap();
    }

    private final DetailSelectGuestView getSelectGuestView() {
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof DetailSelectGuestFragment)) {
            fragment = null;
        }
        DetailSelectGuestFragment detailSelectGuestFragment = (DetailSelectGuestFragment) fragment;
        IDetailParentView fragmentView = detailSelectGuestFragment != null ? detailSelectGuestFragment.getFragmentView() : null;
        return (DetailSelectGuestView) (fragmentView instanceof DetailSelectGuestView ? fragmentView : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DetailSelectMeView getSelectMeView() {
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof DetailSelectMeFragment)) {
            fragment = null;
        }
        DetailSelectMeFragment detailSelectMeFragment = (DetailSelectMeFragment) fragment;
        IDetailParentView fragmentView = detailSelectMeFragment != null ? detailSelectMeFragment.getFragmentView() : null;
        return (DetailSelectMeView) (fragmentView instanceof DetailSelectMeView ? fragmentView : null);
    }

    private final void initReport(View btnFlowerEntry, SquareAvatarItem item) {
        IReporter.DefaultImpls.setElementInfo$default(SquareBaseKt.getSquareReporter(), btnFlowerEntry, "em_zplan_square_gain_seed_entrance", getReportParams(item), false, false, 16, null);
    }

    @Override // com.tencent.state.square.detail.components.IDetailEventListener
    public void onFragmentEnter(SquareAvatarItem item) {
        this.item = item;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        SimpleEventBus.getInstance().registerReceiver(this.flowerEventReceiver);
        final SquareAvatarItem squareAvatarItem = this.item;
        if (squareAvatarItem != null) {
            DetailCommonView detailCommonView = null;
            if (squareAvatarItem.isMe()) {
                DetailSelectMeView selectMeView = getSelectMeView();
                if (selectMeView != null) {
                    detailCommonView = selectMeView.getCommonView();
                }
            } else {
                DetailSelectGuestView selectGuestView = getSelectGuestView();
                if (selectGuestView != null) {
                    detailCommonView = selectGuestView.getCommonView();
                }
            }
            if (detailCommonView != null) {
                detailCommonView.updateFlower(squareAvatarItem.getExtra().getFlowerCount(), squareAvatarItem.getExtra().getFlowerMedal(), !squareAvatarItem.isMe(), new DetailFlowerComponent$onFragmentViewCreated$1(this));
            }
            FlowerManager.INSTANCE.syncFlowerInfo(squareAvatarItem.getUin());
            DetailSelectMeView selectMeView2 = getSelectMeView();
            if (selectMeView2 != null) {
                final SquareImageView squareImageView = selectMeView2.getBinding().btnFlowerEntry;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "view.binding.btnFlowerEntry");
                TextView textView = selectMeView2.getBinding().flowerCountText;
                Intrinsics.checkNotNullExpressionValue(textView, "view.binding.flowerCountText");
                textView.setText("\u82b1\u82b1x" + squareAvatarItem.getExtra().getFlowerCount());
                squareImageView.setImageResource(R.drawable.i9q);
                squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.detail.components.DetailFlowerComponent$onFragmentViewCreated$$inlined$let$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VasBaseFragment fragment;
                        Map<String, Object> reportParams;
                        fragment = this.getFragment();
                        if (fragment != null) {
                            fragment.pushFragment(FlowerDisplayFragment.INSTANCE.newInstance(squareAvatarItem.getExtra().getFlowerCount(), squareAvatarItem.getPlayableSource(), 3));
                        }
                        IReporter squareReporter = SquareBaseKt.getSquareReporter();
                        SquareImageView squareImageView2 = SquareImageView.this;
                        reportParams = this.getReportParams(squareAvatarItem);
                        squareReporter.reportEvent("clck", squareImageView2, reportParams);
                    }
                });
                initReport(squareImageView, squareAvatarItem);
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        SimpleEventBus.getInstance().unRegisterReceiver(this.flowerEventReceiver);
    }

    public final void openFlowerFragment() {
        VasBaseFragment fragment;
        SquareAvatarItem squareAvatarItem = this.item;
        if (squareAvatarItem == null || !squareAvatarItem.isMe() || (fragment = getFragment()) == null) {
            return;
        }
        fragment.pushFragment(FlowerDisplayFragment.INSTANCE.newInstance(squareAvatarItem.getExtra().getFlowerCount(), squareAvatarItem.getPlayableSource(), 3));
    }
}
