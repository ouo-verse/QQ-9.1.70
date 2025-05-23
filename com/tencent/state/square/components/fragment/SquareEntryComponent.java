package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.service.VasSquareEntryService;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.OpenHippyParams;
import com.tencent.state.square.data.SquareEntry;
import com.tencent.state.square.data.SquareHippyInfo;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.utils.FastClickUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareEntryComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentSquareBinding;", "clickUtils", "Lcom/tencent/state/utils/FastClickUtils;", "handleClick", "", "entry", "Lcom/tencent/state/square/data/SquareEntry;", "initEntry", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareEntryComponent extends SquareBaseComponent {
    private static final int H5 = 2;
    private static final int HIPPY = 3;
    private static final int SCHEME = 1;
    private static final String TAG = "SquareEntryComponent";
    private VasSquareFragmentSquareBinding binding;
    private final FastClickUtils clickUtils = new FastClickUtils(500);

    private final void handleClick(SquareEntry entry) {
        String link;
        String str;
        String domainName;
        QBaseActivity activity = getActivity();
        if (activity == null || (link = entry.getLink()) == null || this.clickUtils.isFastDoubleClick()) {
            return;
        }
        int jumpType = entry.getJumpType();
        if (jumpType == 1) {
            Square.INSTANCE.getConfig().getRouter().routeLink(activity, new EntranceLink(link, 2));
            return;
        }
        if (jumpType == 2) {
            Square.INSTANCE.getConfig().getRouter().routeLink(activity, new EntranceLink(link, 1));
            return;
        }
        if (jumpType != 3) {
            return;
        }
        SquareHippyInfo hippyInfo = entry.getHippyInfo();
        String str2 = "";
        if (hippyInfo == null || (str = hippyInfo.getBundleName()) == null) {
            str = "";
        }
        SquareHippyInfo hippyInfo2 = entry.getHippyInfo();
        if (hippyInfo2 != null && (domainName = hippyInfo2.getDomainName()) != null) {
            str2 = domainName;
        }
        OpenHippyParams openHippyParams = new OpenHippyParams(str, str2, entry.getLink());
        ISquareHippyEngine hippyEngine = Square.INSTANCE.getConfig().getHippyEngine();
        VasBaseFragment parentFragment = getParentFragment();
        FragmentManager childFragmentManager = parentFragment != null ? parentFragment.getChildFragmentManager() : null;
        SquareHippyInfo hippyInfo3 = entry.getHippyInfo();
        hippyEngine.openHippyPage(activity, childFragmentManager, openHippyParams, hippyInfo3 != null ? hippyInfo3.isHalfScreen() : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initEntry(SquareEntry entry) {
        entry.getEntryType();
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        this.binding = VasSquareFragmentSquareBinding.bind(v3);
        new VasSquareEntryService().getAllEntry(new Function1<ArrayList<SquareEntry>, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareEntryComponent$onFragmentViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SquareEntry> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<SquareEntry> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Iterator<T> it5 = it.iterator();
                while (it5.hasNext()) {
                    SquareEntryComponent.this.initEntry((SquareEntry) it5.next());
                }
            }
        });
    }
}
