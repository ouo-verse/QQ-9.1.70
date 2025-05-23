package com.tencent.mobileqq.guild.feed.nativepublish.root;

import android.view.View;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import dm1.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\r\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\f0\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/a;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericBaseVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericChildBaseVB;", "initializeChildVB", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class a extends BaseVB<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> {
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> initializeChildVB(@NotNull View hostView) {
        dm1.d b16;
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> emptyList;
        d.a c16;
        List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> filterNotNull;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        b16 = b.b(this);
        if (b16 == null || (c16 = b16.c()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair c17 = c16.c();
        int intValue = ((Number) c17.component1()).intValue();
        BaseVB baseVB = (BaseVB) c17.component2();
        Integer valueOf = Integer.valueOf(intValue);
        if (baseVB != null) {
            Pair e16 = c16.e();
            if (e16 != null) {
                int intValue2 = ((Number) e16.component1()).intValue();
                BaseVB baseVB2 = (BaseVB) e16.component2();
                Integer valueOf2 = Integer.valueOf(intValue2);
                if (baseVB2 != null) {
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.mvvm.BaseVB<out com.tencent.mvi.base.mvi.MviIntent, out com.tencent.mvi.base.mvi.MviUIState, com.tencent.mvi.api.runtime.MviContext>");
                }
            }
            List a16 = c16.a();
            ArrayList arrayList = new ArrayList();
            for (Object obj : a16) {
                if (obj instanceof Pair) {
                    arrayList.add(obj);
                }
            }
            MapsKt__MapsKt.putAll(linkedHashMap, arrayList);
            int[] b17 = c16.b();
            if (linkedHashMap.size() == b17.length) {
                ArrayList arrayList2 = new ArrayList(b17.length);
                for (int i3 : b17) {
                    arrayList2.add((BaseVB) linkedHashMap.get(Integer.valueOf(i3)));
                }
                filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList2);
                return filterNotNull;
            }
            ArrayList arrayList3 = new ArrayList(linkedHashMap.size());
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList3.add((BaseVB) ((Map.Entry) it.next()).getValue());
            }
            return arrayList3;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.mvvm.BaseVB<out com.tencent.mvi.base.mvi.MviIntent, out com.tencent.mvi.base.mvi.MviUIState, com.tencent.mvi.api.runtime.MviContext>");
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        dm1.d b16;
        d.a c16;
        View onCreateView;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        b16 = b.b(this);
        if (b16 == null || (c16 = b16.c()) == null || (onCreateView = c16.onCreateView(createViewParams)) == null) {
            return createViewParams.b();
        }
        return onCreateView;
    }
}
