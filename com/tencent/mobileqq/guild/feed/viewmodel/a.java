package com.tencent.mobileqq.guild.feed.viewmodel;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/viewmodel/a;", "Lcom/tencent/mobileqq/guild/feed/viewmodel/GuildFeedListViewModel;", "", VideoProxy.PARAM_ENABLE_CACHE, "", "sortMode", "", "p2", ICustomDataEditor.STRING_PARAM_2, "refreshMode", DomainData.DOMAIN_NAME, "", "getLogTag", "J", "Z", "sendRequest", "<init>", "()V", "K", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends GuildFeedListViewModel {

    /* renamed from: J, reason: from kotlin metadata */
    private boolean sendRequest;

    @Override // com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel, com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "Guild_Feed_GuildFeedListGlobalCacheViewModel";
    }

    public final void s2() {
        this.sendRequest = false;
        j().setValue(UIStateData.obtainLoading());
        Z1().setValue(UIStateData.obtainLoading());
        this.D.clear();
        this.C.clear();
        this.E.clear();
        this.G.clear();
    }

    @Override // com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel
    public void n(int refreshMode) {
    }

    @Override // com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel
    public void p2(boolean enableCache, int sortMode) {
    }
}
