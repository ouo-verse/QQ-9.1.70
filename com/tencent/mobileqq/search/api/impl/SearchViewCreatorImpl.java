package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactsSearchNTFragment;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.search.view.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchViewCreatorImpl implements ISearchViewCreator {
    @Override // com.tencent.mobileqq.search.api.ISearchViewCreator
    public f createContactSearchFragment(int i3, int i16, String str, List<String> list, com.tencent.mobileqq.search.view.d dVar, boolean z16, k kVar) {
        return ContactSearchFragment.zh(i3, i16, str, list, dVar, z16, kVar);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchViewCreator
    public f createNTContactSearchFragment(int i3, int i16, String str, List<String> list, boolean z16, int i17, long j3, com.tencent.mobileqq.search.view.d dVar, boolean z17, k kVar) {
        return ContactsSearchNTFragment.INSTANCE.a(i3, i16, str, list, dVar, i17, j3, z16, z17, kVar);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchViewCreator
    public f createContactSearchFragment(int i3, int i16, String str, List<String> list, com.tencent.mobileqq.search.view.d dVar, int i17, long j3, boolean z16, k kVar) {
        return ContactSearchFragment.xh(i3, i16, str, list, dVar, i17, j3, z16, kVar);
    }
}
