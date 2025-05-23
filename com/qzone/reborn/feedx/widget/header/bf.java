package com.qzone.reborn.feedx.widget.header;

import android.view.View;
import com.qzone.common.account.LoginData;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bf extends ay {
    public bf(View view) {
        super(view);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QzoneFriendFeedxCoverElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    int t() {
        return 1;
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    tc.b v() {
        return (tc.b) k(com.qzone.reborn.feedx.viewmodel.q.class);
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    long w() {
        return LoginData.getInstance().getUin();
    }
}
