package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.search.view.d;
import com.tencent.mobileqq.search.view.f;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchViewCreator extends QRouteApi {
    f createContactSearchFragment(int i3, int i16, String str, List<String> list, d dVar, int i17, long j3, boolean z16, k kVar);

    f createContactSearchFragment(int i3, int i16, String str, List<String> list, d dVar, boolean z16, k kVar);

    f createNTContactSearchFragment(int i3, int i16, String str, List<String> list, boolean z16, int i17, long j3, d dVar, boolean z17, k kVar);
}
