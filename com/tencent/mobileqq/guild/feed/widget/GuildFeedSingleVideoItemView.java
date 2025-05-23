package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedSingleVideoItemView extends GuildFeedBaseItemView implements eo1.a {
    public GuildFeedSingleVideoItemView(@NonNull Context context) {
        super(context);
    }

    @Override // eo1.a
    public void a() {
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f224137d;
        if (dVar != null && dVar.d() != null) {
            for (RFWLayoutPreLoader.RequestPreloadViewListener requestPreloadViewListener : this.f224137d.d().values()) {
                if (requestPreloadViewListener instanceof eo1.a) {
                    ((eo1.a) requestPreloadViewListener).a();
                }
            }
        }
    }

    @Override // eo1.a
    public GuildFeedListBaseVideoView d() {
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f224137d;
        if (dVar != null && dVar.d() != null) {
            for (RFWLayoutPreLoader.RequestPreloadViewListener requestPreloadViewListener : this.f224137d.d().values()) {
                if (requestPreloadViewListener instanceof eo1.a) {
                    return ((eo1.a) requestPreloadViewListener).d();
                }
            }
        }
        return null;
    }

    @Override // eo1.a
    public void pause() {
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f224137d;
        if (dVar != null && dVar.d() != null) {
            for (RFWLayoutPreLoader.RequestPreloadViewListener requestPreloadViewListener : this.f224137d.d().values()) {
                if (requestPreloadViewListener instanceof eo1.a) {
                    ((eo1.a) requestPreloadViewListener).pause();
                }
            }
        }
    }

    @Override // eo1.a
    public void play() {
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f224137d;
        if (dVar != null && dVar.d() != null) {
            for (RFWLayoutPreLoader.RequestPreloadViewListener requestPreloadViewListener : this.f224137d.d().values()) {
                if (requestPreloadViewListener instanceof eo1.a) {
                    ((eo1.a) requestPreloadViewListener).play();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildFeedBaseItemView
    protected List<GuildBaseFeedChildPresenter<ij1.g>> q0() {
        return new ArrayList(Arrays.asList(new com.tencent.mobileqq.guild.feed.presenter.h(this.f224139f), new com.tencent.mobileqq.guild.feed.presenter.m(this.f224139f)));
    }

    public GuildFeedSingleVideoItemView(Context context, int i3, GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(context, Integer.valueOf(i3), guildFeedDefaultInitBean);
    }
}
