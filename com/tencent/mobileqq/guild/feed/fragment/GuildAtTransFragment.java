package com.tencent.mobileqq.guild.feed.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi;
import com.tencent.mobileqq.guild.event.GuildAtDialogDismissEvent;
import com.tencent.mobileqq.guild.event.GuildAtEvent;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildAtTransFragment extends QPublicBaseFragment implements SimpleEventReceiver {
    private View C;
    private ze1.b D;
    private int E = 0;
    private final ye1.a F = new a();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends ye1.c {
        a() {
        }

        @Override // ye1.a
        public void d(boolean z16, int i3, List<IGProUserInfo> list) {
            if (GuildAtTransFragment.this.D == null) {
                return;
            }
            if ((GuildAtTransFragment.this.D.h() && z16) || !GuildAtTransFragment.this.D.h()) {
                GuildAtEvent guildAtEvent = new GuildAtEvent(list);
                guildAtEvent.mHashCode = GuildAtTransFragment.this.E;
                SimpleEventBus.getInstance().dispatchEvent(guildAtEvent, true);
            }
            GuildAtDialogDismissEvent guildAtDialogDismissEvent = new GuildAtDialogDismissEvent();
            guildAtDialogDismissEvent.mHashCode = GuildAtTransFragment.this.E;
            SimpleEventBus.getInstance().dispatchEvent(guildAtDialogDismissEvent, true);
        }

        @Override // ye1.a
        public void e(boolean z16, String str, IGProUserInfo iGProUserInfo, int i3, int i16) {
            if (GuildAtTransFragment.this.D != null && !GuildAtTransFragment.this.D.h()) {
                GuildAtTransFragment.this.D.dismiss();
            }
        }
    }

    private void initData() {
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("guild_key_at");
        String string = bundleExtra.getString("key_guild_id");
        String string2 = bundleExtra.getString("key_channel_id");
        String string3 = bundleExtra.getString(com.tencent.mobileqq.guild.feed.b.f218120f);
        String string4 = bundleExtra.getString(com.tencent.mobileqq.guild.feed.b.f218126l);
        this.E = bundleExtra.getInt("key_request_id", 0);
        ze1.b bVar = (ze1.b) com.tencent.guild.aio.input.at.utils.j.a(new xe1.b(string, string2, 7, getActivity(), getContext(), (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), 1, xe1.b.h(string4, string3)));
        this.D = bVar;
        bVar.f("");
        this.D.k(this.F);
    }

    private void sh(GuildAtDialogDismissEvent guildAtDialogDismissEvent) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th() {
        ze1.b bVar = this.D;
        if (bVar != null) {
            bVar.j("", this.C);
            this.D.i(this.C);
        }
    }

    private void uh() {
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildAtTransFragment.this.th();
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildAtDialogDismissEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.egb, viewGroup, false);
        this.C = inflate.findViewById(R.id.lzi);
        uh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        if (this.D != null) {
            ((IGuildAIOPopupPanelServiceApi) QRoute.api(IGuildAIOPopupPanelServiceApi.class)).releasePopupPanel(this.D);
            this.D = null;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildAtDialogDismissEvent) {
            sh((GuildAtDialogDismissEvent) simpleBaseEvent);
        }
    }
}
