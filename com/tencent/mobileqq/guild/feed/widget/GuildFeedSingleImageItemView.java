package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedSingleImageItemView extends GuildFeedBaseItemView {
    public GuildFeedSingleImageItemView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildFeedBaseItemView
    protected List<GuildBaseFeedChildPresenter<ij1.g>> q0() {
        return new ArrayList(Arrays.asList(new com.tencent.mobileqq.guild.feed.presenter.g(this.f224139f), new com.tencent.mobileqq.guild.feed.presenter.m(this.f224139f)));
    }

    public GuildFeedSingleImageItemView(Context context, int i3, GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(context, Integer.valueOf(i3), guildFeedDefaultInitBean);
    }
}
