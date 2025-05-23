package com.tencent.mobileqq.qwallet.hb.panel.recommend;

import androidx.lifecycle.MutableLiveData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/HbListRecommendSkinViewModel;", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "", "redDotText", "", "x2", NowProxyConstants.AccountInfoKey.A2, "", WadlProxyConsts.SCENE_ID, "z2", "Landroidx/lifecycle/MutableLiveData;", "J", "Landroidx/lifecycle/MutableLiveData;", "w2", "()Landroidx/lifecycle/MutableLiveData;", "redDotLiveData", "<init>", "()V", "K", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbListRecommendSkinViewModel extends SkinRecommendViewModel {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> redDotLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(final String redDotText) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.a
            @Override // java.lang.Runnable
            public final void run() {
                HbListRecommendSkinViewModel.y2(HbListRecommendSkinViewModel.this, redDotText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(HbListRecommendSkinViewModel this$0, String redDotText) {
        ArrayList arrayList;
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(redDotText, "$redDotText");
        List<com.tencent.mobileqq.qwallet.pb.a> value = this$0.Z1().getValue();
        if (value != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : value) {
                if (obj instanceof a.Skin) {
                    arrayList2.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(RedPackSkinExt.f(((a.Skin) it.next()).getValue())));
            }
        } else {
            arrayList = null;
        }
        Set<String> k3 = g.k("seen_hb_skin_set");
        if (k3 == null) {
            k3 = SetsKt__SetsKt.emptySet();
        }
        if (arrayList != null) {
            ArrayList arrayList3 = arrayList;
            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                Iterator it5 = arrayList3.iterator();
                while (it5.hasNext()) {
                    if (!k3.contains(String.valueOf(((Number) it5.next()).intValue()))) {
                        z16 = false;
                        break;
                    }
                }
            }
        }
        z16 = true;
        QLog.d("HbListRecommendSkinViewModel", 1, "allRead = " + z16 + " seenSkinSet = " + k3 + " skinList = " + arrayList);
        if (z16) {
            this$0.redDotLiveData.setValue(null);
        } else {
            this$0.redDotLiveData.setValue(redDotText);
        }
    }

    public final void A2() {
        Set set;
        boolean z16;
        Set emptySet;
        int collectionSizeOrDefault;
        List<com.tencent.mobileqq.qwallet.pb.a> value = Z1().getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (obj instanceof a.Skin) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(RedPackSkinExt.f(((a.Skin) it.next()).getValue())));
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        } else {
            set = null;
        }
        if (set != null && !set.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptySet = SetsKt__SetsKt.emptySet();
            g.r("seen_hb_skin_set", emptySet);
        } else {
            g.r("seen_hb_skin_set", set);
        }
        this.redDotLiveData.postValue(null);
    }

    @NotNull
    public final MutableLiveData<String> w2() {
        return this.redDotLiveData;
    }

    public final void z2(int sceneId) {
        super.m2(sceneId, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.recommend.HbListRecommendSkinViewModel$refreshAllRecommendSkins$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String redDotText) {
                Intrinsics.checkNotNullParameter(redDotText, "redDotText");
                HbListRecommendSkinViewModel.this.x2(redDotText);
            }
        });
    }
}
