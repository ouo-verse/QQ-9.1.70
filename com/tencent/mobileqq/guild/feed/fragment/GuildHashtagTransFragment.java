package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.event.GuildHashtagDialogDismissEvent;
import com.tencent.mobileqq.guild.event.GuildHashtagEvent;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.guild.util.bj;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildHashtagTransFragment extends QPublicBaseFragment implements SimpleEventReceiver {
    private View C;
    private com.tencent.guild.aio.input.at.hashtag.ui.g D;

    private void initData() {
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("guild_key_hashtag");
        final String string = bundleExtra.getString("key_guild_id");
        com.tencent.guild.aio.input.at.hashtag.ui.g gVar = new com.tencent.guild.aio.input.at.hashtag.ui.g(string, "", getActivity(), 1);
        this.D = gVar;
        gVar.w(new GuildHashtagListAdapter.b() { // from class: com.tencent.mobileqq.guild.feed.fragment.g
            @Override // com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter.b
            public final void a(String str, String str2, HashTagViewType hashTagViewType) {
                GuildHashtagTransFragment.this.xh(string, str, str2, hashTagViewType);
            }
        });
        vh(bundleExtra);
        wh(bundleExtra);
        uh(bundleExtra);
    }

    private void sh(GuildHashtagEvent guildHashtagEvent) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void showGuildHashtag() {
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.fragment.GuildHashtagTransFragment.1
            @Override // java.lang.Runnable
            public void run() {
                GuildHashtagTransFragment.this.D.z(GuildHashtagTransFragment.this.C, "");
            }
        });
    }

    private void th(GuildHashtagDialogDismissEvent guildHashtagDialogDismissEvent) {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void uh(Bundle bundle) {
        if (bundle != null && bundle.containsKey("key_channel_id")) {
            this.D.u(bundle.getString("key_channel_id"));
        }
    }

    private void vh(Bundle bundle) {
        if (bundle != null && bundle.containsKey("key_channel_type")) {
            this.D.v(bundle.getInt("key_channel_type"));
        }
    }

    private void wh(Bundle bundle) {
        if (bundle != null && bundle.containsKey("KEY_NEED_CHECK_PERMISSION_TYPE")) {
            this.D.x(bundle.getInt("KEY_NEED_CHECK_PERMISSION_TYPE"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xh(String str, String str2, String str3, HashTagViewType hashTagViewType) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildHashtagEvent(str, str2, bj.a(str3, hashTagViewType), hashTagViewType), true);
        this.D.dismissPanel();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildHashtagDialogDismissEvent.class);
        arrayList.add(GuildHashtagEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
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
        com.tencent.guild.aio.input.at.hashtag.ui.g gVar = this.D;
        if (gVar != null) {
            gVar.q();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildHashtagDialogDismissEvent) {
            th((GuildHashtagDialogDismissEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildHashtagEvent) {
            sh((GuildHashtagEvent) simpleBaseEvent);
        }
    }
}
