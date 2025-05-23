package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.FeedListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendCampusSearchFragment extends ExtendFriendSearchBaseFragment implements ExtendFriendSearchHistoryManager.a, FeedListView.LoadFeedCallback {
    private com.tencent.mobileqq.qqexpand.manager.e V;
    private ExtendFriendSearchHistoryManager W;
    private FeedListView X;
    private b Y;
    private boolean Z;

    private void Fh() {
        List<String> q16 = this.V.q(1);
        List<String> d16 = this.W.d();
        yh("");
        xh((ArrayList) q16);
        zh((ArrayList) d16);
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager.a
    public void Db() {
        zh((ArrayList) this.W.d());
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        int i17;
        FeedListView feedListView;
        super.onActivityResult(i3, i16, intent);
        switch (i3) {
            case 1205:
                i17 = 1205;
                break;
            case 1206:
                i17 = 1206;
                break;
            case 1207:
                i17 = 1207;
                break;
            case 1208:
                i17 = 1208;
                break;
            default:
                i17 = -1;
                break;
        }
        if (i17 == -1 || (feedListView = this.X) == null) {
            return;
        }
        feedListView.doActivityResult(i17, i16, intent);
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.D.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        this.V = eVar;
        ExtendFriendSearchHistoryManager e06 = eVar.e0();
        this.W = e06;
        e06.g(this);
        this.Z = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FeedListView feedListView = this.X;
        if (feedListView != null) {
            feedListView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Fh();
        FeedListView feedListView = this.X;
        if (feedListView != null) {
            feedListView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        FeedListView feedListView = this.X;
        if (feedListView != null) {
            feedListView.onStart();
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FeedListView feedListView = this.X;
        if (feedListView != null) {
            feedListView.onStop();
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment
    void uh(ViewGroup viewGroup) {
        if (this.X != null || getBaseActivity() == null) {
            return;
        }
        View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.f168805gx3, viewGroup, false);
        this.Y = new b(inflate);
        FeedListView feedListView = (FeedListView) inflate.findViewById(R.id.f80124am);
        this.X = feedListView;
        feedListView.setExtArgs(Collections.singletonMap(FeedListView.EXT_KEY_SEARCH_MODE, "1"));
        this.X.setOverScrollMode(0);
        this.X.setEdgeEffectEnabled(false);
        this.X.setVerticalScrollBarEnabled(false);
        this.X.attach(this.D, getBaseActivity(), this.D.getLongAccountUin());
        viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment
    void vh() {
        this.W.c();
    }

    @Override // com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSearchBaseFragment
    void wh(final String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", str));
        }
        this.W.b(str);
        if (this.X == null) {
            return;
        }
        this.Y.g();
        this.X.setOverScrollMode(0);
        if (this.Z) {
            this.X.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExtendFriendCampusSearchFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    ExtendFriendCampusSearchFragment.this.X.switchTag(str, ExtendFriendCampusSearchFragment.this);
                }
            }, 800L);
            this.Z = false;
        } else {
            this.X.switchTag(str, this);
        }
    }

    @Override // cooperation.qzone.api.FeedListView.LoadFeedCallback
    public void onLoadOver(boolean z16) {
        if (z16) {
            if (this.X.getFeedCnt() == 0) {
                this.Y.c();
                return;
            } else {
                this.Y.f();
                return;
            }
        }
        if (NetworkUtil.isNetworkAvailable()) {
            this.Y.d();
        } else {
            this.Y.e();
        }
    }
}
