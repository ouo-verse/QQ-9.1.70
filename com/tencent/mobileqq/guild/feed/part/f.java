package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class f extends d {

    /* renamed from: d, reason: collision with root package name */
    private GuildFeedMainInitBean f222549d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.feed.viewmodel.l f222550e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    protected com.tencent.mobileqq.guild.feed.viewmodel.k f222551f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements Observer<UIStateData<List<ij1.g>>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<ij1.g>> uIStateData) {
            f.this.z9(uIStateData);
        }
    }

    private void A9() {
        GuildFeedBaseInitBean o16 = ax.o(getHostFragment());
        if (o16 instanceof GuildFeedMainInitBean) {
            this.f222549d = (GuildFeedMainInitBean) o16;
            QLog.d(getLogTag(), 1, "getInitBeanSuccess:" + this.f222549d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViewModel() {
        com.tencent.mobileqq.guild.feed.viewmodel.l lVar = (com.tencent.mobileqq.guild.feed.viewmodel.l) getViewModel(GuildFeedListViewModel.class);
        this.f222550e = lVar;
        if (lVar == null) {
            return;
        }
        lVar.j().observeForever(new a());
        if (x9() == null) {
            return;
        }
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = (com.tencent.mobileqq.guild.feed.viewmodel.k) getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.k.class);
        this.f222551f = kVar;
        kVar.Z1(this.f222549d.getGuildId(), this.f222549d.getChannelId());
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        A9();
        initViewModel();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.f222551f;
        if (kVar != null) {
            kVar.onDestroy();
        }
        super.onPartDestroy(activity);
    }

    public GuildFeedMainInitBean x9() {
        if (this.f222549d == null) {
            A9();
        }
        return this.f222549d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z9(UIStateData<List<ij1.g>> uIStateData) {
    }
}
