package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.event.partevent.GuildPartPanelDismissEvent;
import com.tencent.mobileqq.guild.event.partevent.GuildPartSelectEvent;
import com.tencent.mobileqq.guild.feed.partpanel.ui.a;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class GuildPartTransFragment extends QPublicBaseFragment implements SimpleEventReceiver {
    private View C;
    private com.tencent.mobileqq.guild.feed.partpanel.ui.b D;
    private int E;
    private String F;
    private int G;

    private void initData() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            Bundle bundleExtra = getActivity().getIntent().getBundleExtra("guild_key_part_selection");
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            final String string = bundleExtra.getString("key_guild_id");
            this.G = bundleExtra.getInt("key_request_id");
            this.F = bundleExtra.getString("key_channel_id");
            this.E = bundleExtra.getInt("part_panel_biz_type", 2);
            com.tencent.mobileqq.guild.feed.partpanel.ui.b bVar = new com.tencent.mobileqq.guild.feed.partpanel.ui.b(string, this.F, getContext(), 1, this.E);
            this.D = bVar;
            bVar.x(true);
            this.D.y(bundleExtra.getBoolean("key_toast_if_only_one_section_exist"));
            this.D.z(new a.InterfaceC7770a() { // from class: com.tencent.mobileqq.guild.feed.fragment.i
                @Override // com.tencent.mobileqq.guild.feed.partpanel.ui.a.InterfaceC7770a
                public final void a(bn1.c cVar) {
                    GuildPartTransFragment.this.uh(string, cVar);
                }
            });
            th(bundleExtra);
        }
    }

    private void showGuildHashtag() {
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.fragment.GuildPartTransFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GuildPartTransFragment.this.D.B(GuildPartTransFragment.this.C, GuildPartTransFragment.this.F, "");
            }
        });
    }

    private void th(Bundle bundle) {
        if (bundle != null && bundle.containsKey("KEY_NEED_CHECK_PERMISSION_TYPE")) {
            this.D.A(bundle.getInt("KEY_NEED_CHECK_PERMISSION_TYPE"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(String str, bn1.c cVar) {
        if (this.E == 1 && cVar.f28687a.equals(this.F)) {
            this.D.dismiss();
            return;
        }
        boolean z16 = false;
        if (this.E == 2 && !cVar.f28690d.booleanValue()) {
            QQToast.makeText(getActivity(), "\u5728\u8be5\u7248\u5757\u6682\u65e0\u53d1\u5e16\u6743\u9650", 0).show();
            return;
        }
        String valueOf = String.valueOf(cVar.f28687a);
        String str2 = cVar.f28689c;
        if (cVar.f28688b == 2) {
            z16 = true;
        }
        GuildPartSelectEvent guildPartSelectEvent = new GuildPartSelectEvent(str, valueOf, str2, z16);
        guildPartSelectEvent.sourceChannelId = this.F;
        guildPartSelectEvent.mHashCode = this.G;
        SimpleEventBus.getInstance().dispatchEvent(guildPartSelectEvent, true);
        this.D.dismiss();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildPartPanelDismissEvent.class);
        arrayList.add(GuildPartSelectEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
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
        View inflate = layoutInflater.inflate(R.layout.et9, viewGroup, false);
        this.C = inflate.findViewById(R.id.lzi);
        showGuildHashtag();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.guild.feed.partpanel.ui.b bVar = this.D;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        if (getActivity() != null) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        Class<?> cls = simpleBaseEvent.getClass();
        if (cls == GuildPartPanelDismissEvent.class || cls == GuildPartSelectEvent.class) {
            ax.J(getActivity(), new Consumer() { // from class: com.tencent.mobileqq.guild.feed.fragment.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((FragmentActivity) obj).finish();
                }
            });
        }
    }
}
