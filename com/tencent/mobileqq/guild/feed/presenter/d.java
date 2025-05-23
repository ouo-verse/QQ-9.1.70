package com.tencent.mobileqq.guild.feed.presenter;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;

/* compiled from: P */
/* loaded from: classes13.dex */
public class d extends GuildBaseFeedChildPresenter<ij1.g> {
    public d(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.f165493wa3), this);
    }
}
