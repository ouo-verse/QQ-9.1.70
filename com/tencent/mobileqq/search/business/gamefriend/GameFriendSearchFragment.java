package com.tencent.mobileqq.search.business.gamefriend;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.ui.w;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.widget.ListView;
import mn2.b;
import qn2.d;
import sn2.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GameFriendSearchFragment extends ContactSearchFragment {
    private SparseArray<w> W;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends b<y, c> {
        a(ListView listView, IFaceDecoder iFaceDecoder) {
            super(listView, iFaceDecoder);
        }

        @Override // mn2.a
        protected d<y, c> e(int i3) {
            return new co2.b(this.f417042e, ((ContactSearchFragment) GameFriendSearchFragment.this).S);
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new co2.c(viewGroup, R.layout.hpr, GameFriendSearchFragment.this.W);
        }
    }

    public static GameFriendSearchFragment Fh(int i3, int i16, com.tencent.mobileqq.search.view.d dVar) {
        GameFriendSearchFragment gameFriendSearchFragment = new GameFriendSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        bundle.putInt("contactSearchSource", i16);
        if (dVar != null) {
            bundle.putLong("contactSearchOnActionListener", rn2.b.b().a(dVar));
        }
        gameFriendSearchFragment.setArguments(bundle);
        return gameFriendSearchFragment;
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new a(this.listView, this.faceDecoder);
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        return new co2.a(this.appInterface, this.D, this.C, this.E, this.G);
    }

    @Override // com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment, com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.W = ((IGameCenterFriendApi) QRoute.api(IGameCenterFriendApi.class)).buildIntimacyStyle(getContext());
    }
}
