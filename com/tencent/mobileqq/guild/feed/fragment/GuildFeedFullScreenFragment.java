package com.tencent.mobileqq.guild.feed.fragment;

import android.os.Bundle;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedFullScreenFragment extends GuildQBasePartFragment {
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.guild.feed.part.h());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eru;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedFullScreenFrag";
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getActivity().setRequestedOrientation(0);
        getActivity().getWindow().addFlags(1024);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
