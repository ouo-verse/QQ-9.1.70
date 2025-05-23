package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.widget.sort.GuildFeedListSortViewController;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ar extends f {

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.guild.feed.widget.sort.g f222534h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f222535i;

    private com.tencent.mobileqq.guild.feed.widget.sort.g B9() {
        com.tencent.mobileqq.guild.feed.widget.sort.g gVar = this.f222534h;
        if (gVar != null) {
            return gVar;
        }
        if (x9() instanceof GuildFeedTroopInitBean) {
            this.f222534h = new com.tencent.mobileqq.guild.feed.widget.sort.f();
        } else {
            this.f222534h = new GuildFeedListSortViewController();
        }
        return this.f222534h;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if ("action_set_sticker_sort_tools".equals(str) && (obj instanceof Integer)) {
            this.f222535i.setVisibility(((Integer) obj).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.part.f
    public void initViewModel() {
        super.initViewModel();
        B9().b2((com.tencent.mobileqq.guild.feed.viewmodel.j) getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.j.class));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ViewStub viewStub;
        super.onInitView(view);
        GuildFeedMainInitBean x95 = x9();
        if (x95 instanceof GuildFeedTroopInitBean) {
            viewStub = (ViewStub) view.findViewById(R.id.f165194v43);
        } else {
            viewStub = (ViewStub) view.findViewById(R.id.v18);
        }
        if (viewStub == null) {
            return;
        }
        this.f222535i = (FrameLayout) viewStub.inflate();
        B9().N7(this.f222535i, x95);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f222534h.destroy();
    }
}
