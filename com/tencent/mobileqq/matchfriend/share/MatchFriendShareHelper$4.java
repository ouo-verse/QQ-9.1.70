package com.tencent.mobileqq.matchfriend.share;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
class MatchFriendShareHelper$4 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Activity f245585d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ArrayList f245586e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ShareActionSheet f245587f;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        Activity activity = this.f245585d;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key_share_match_friends", this.f245586e);
        bundle.putBoolean("key_share_to_match_friend", true);
        this.f245587f.setExtras(bundle);
        this.f245587f.show();
        this.f245587f.refresh();
    }
}
