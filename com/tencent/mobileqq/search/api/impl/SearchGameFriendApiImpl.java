package com.tencent.mobileqq.search.api.impl;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.api.ISearchGameFriendApi;
import com.tencent.mobileqq.search.business.gamefriend.GameFriendSearchFragment;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.model.u;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchGameFriendApiImpl implements ISearchGameFriendApi {
    private static final String TAG = "gameFriInfo.SearchGameFriendApiImpl";
    private GameFriendSearchFragment mGameFriendSearchFragment;
    private u mItemClickedListener;
    private com.tencent.mobileqq.search.view.d mOnActionListener = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.mobileqq.search.view.d {
        a() {
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void onAction(View view) {
            QLog.i(SearchGameFriendApiImpl.TAG, 2, "[onAction]");
            if (SearchGameFriendApiImpl.this.mItemClickedListener == null) {
                return;
            }
            k kVar = (k) view.getTag(R.id.kxb);
            if (!(kVar instanceof wn2.d)) {
                return;
            }
            SearchGameFriendApiImpl.this.mItemClickedListener.a(((wn2.d) kVar).S());
        }

        @Override // com.tencent.mobileqq.search.view.d
        public /* synthetic */ void selectedItemClick(String str, int i3, boolean z16) {
            com.tencent.mobileqq.search.view.c.a(this, str, i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchGameFriendApi
    public Fragment getSearchFragment(u uVar) {
        this.mItemClickedListener = uVar;
        GameFriendSearchFragment Fh = GameFriendSearchFragment.Fh(7, 134217728, this.mOnActionListener);
        this.mGameFriendSearchFragment = Fh;
        return Fh;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchGameFriendApi
    public void onDestroy() {
        if (this.mGameFriendSearchFragment != null) {
            this.mGameFriendSearchFragment = null;
        }
        this.mItemClickedListener = null;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchGameFriendApi
    public void startSearch(String str) {
        if (this.mGameFriendSearchFragment == null) {
            return;
        }
        QLog.i(TAG, 2, "[startSearch]");
        this.mGameFriendSearchFragment.startSearch(str);
    }
}
