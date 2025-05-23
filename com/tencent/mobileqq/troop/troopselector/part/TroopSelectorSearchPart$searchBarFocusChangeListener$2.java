package com.tencent.mobileqq.troop.troopselector.part;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorVM;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$onActionListener$2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View$OnFocusChangeListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopSelectorSearchPart$searchBarFocusChangeListener$2 extends Lambda implements Function0<View.OnFocusChangeListener> {
    final /* synthetic */ TroopSelectorSearchPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSelectorSearchPart$searchBarFocusChangeListener$2(TroopSelectorSearchPart troopSelectorSearchPart) {
        super(0);
        this.this$0 = troopSelectorSearchPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSelectorSearchPart this$0, View view, boolean z16) {
        com.tencent.mobileqq.search.view.f fVar;
        com.tencent.mobileqq.search.view.f fVar2;
        TroopSelectorVM M9;
        com.tencent.mobileqq.search.view.f fVar3;
        List<String> emptyList;
        TroopSelectorConfig troopSelectorConfig;
        TroopSelectorConfig troopSelectorConfig2;
        long j3;
        TroopSelectorSearchPart$onActionListener$2.a I9;
        com.tencent.mobileqq.search.view.f fVar4;
        Fragment fragment;
        Bundle requireArguments;
        TroopSelectorConfig troopSelectorConfig3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            fVar = this$0.searchFragment;
            if (fVar == null) {
                ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
                troopSelectorConfig = this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
                boolean z17 = false;
                boolean z18 = troopSelectorConfig != null && troopSelectorConfig.e();
                troopSelectorConfig2 = this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
                if (troopSelectorConfig2 != null && !troopSelectorConfig2.j()) {
                    z17 = true;
                }
                if (z17) {
                    troopSelectorConfig3 = this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
                    if (!troopSelectorConfig3.g()) {
                        j3 = 2;
                        I9 = this$0.I9();
                        this$0.searchFragment = iSearchViewCreator.createNTContactSearchFragment(8, 2097176, null, null, z18, 2, j3, I9, false, null);
                        fVar4 = this$0.searchFragment;
                        if (fVar4 != null && (fragment = fVar4.getFragment()) != null && (requireArguments = fragment.requireArguments()) != null) {
                            requireArguments.putBoolean(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_FILTER_BLOCK_GROUP, true);
                        }
                    }
                }
                j3 = -1;
                I9 = this$0.I9();
                this$0.searchFragment = iSearchViewCreator.createNTContactSearchFragment(8, 2097176, null, null, z18, 2, j3, I9, false, null);
                fVar4 = this$0.searchFragment;
                if (fVar4 != null) {
                    requireArguments.putBoolean(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_FILTER_BLOCK_GROUP, true);
                }
            }
            fVar2 = this$0.searchFragment;
            if (fVar2 != null) {
                ArrayList arrayList = new ArrayList();
                M9 = this$0.M9();
                ArrayList<SharedNode> value = M9.S1().getValue();
                if (value != null) {
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((SharedNode) it.next()).getKey());
                    }
                }
                fVar3 = this$0.searchFragment;
                if (fVar3 != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    fVar3.B5(arrayList, emptyList);
                    FragmentActivity activity = this$0.getPartHost().getActivity();
                    FragmentManager supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
                    FragmentTransaction beginTransaction = supportFragmentManager != null ? supportFragmentManager.beginTransaction() : null;
                    if (beginTransaction != null) {
                        beginTransaction.remove(fVar3.getFragment());
                    }
                    if (beginTransaction != null) {
                        beginTransaction.add(R.id.result_layout, fVar3.getFragment());
                    }
                    if (beginTransaction != null) {
                        beginTransaction.commitAllowingStateLoss();
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View.OnFocusChangeListener invoke() {
        final TroopSelectorSearchPart troopSelectorSearchPart = this.this$0;
        return new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.troop.troopselector.part.d
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                TroopSelectorSearchPart$searchBarFocusChangeListener$2.b(TroopSelectorSearchPart.this, view, z16);
            }
        };
    }
}
