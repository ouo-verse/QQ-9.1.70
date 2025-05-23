package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCreatorRoleFragment extends QQGuildTitleBarFragment {
    private ImageView T;
    private TextView U;
    private String V;
    private int W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private final int f232532a0 = 1;

    /* renamed from: b0, reason: collision with root package name */
    private final int f232533b0 = ViewUtils.dpToPx(72.0f);

    /* renamed from: c0, reason: collision with root package name */
    private IGPSService f232534c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.rolegroup.viewmodel.h f232535d0;

    /* renamed from: e0, reason: collision with root package name */
    private ux1.g f232536e0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.guild.rolegroup.viewmodel.h Gh() {
        return new com.tencent.mobileqq.guild.rolegroup.viewmodel.h(this.V, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(List list) {
        this.f232536e0.setData(list);
    }

    private void Ih() {
        IGPSService iGPSService = (IGPSService) getQBaseActivity().getAppRuntime().getRuntimeService(IGPSService.class, "");
        this.f232534c0 = iGPSService;
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(this.V);
        if (guildInfo == null) {
            QLog.w("Guild.rg.CreatorRoleDetailFragment", 1, "Failed get guildInfo");
            return;
        }
        String creatorId = guildInfo.getCreatorId();
        this.Y = creatorId;
        this.f232534c0.getGuildUserDisplayName(this.V, creatorId);
    }

    public static void Jh(Context context, String str, int i3, String str2) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_id", str);
        intent.putExtra("extra_role_color", i3);
        intent.putExtra("extra_role_display_tag_name", str2);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildCreatorRoleFragment.class);
    }

    private void Kh() {
        if (getActivity() == null) {
            QLog.e("Guild.rg.CreatorRoleDetailFragment", 1, "getActivity() return null");
            onBackEvent();
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("Guild.rg.CreatorRoleDetailFragment", 1, "bundle is null");
            onBackEvent();
        } else {
            this.V = intent.getStringExtra("extra_guild_id");
            this.W = intent.getIntExtra("extra_role_color", -1);
            this.X = intent.getStringExtra("extra_role_display_tag_name");
        }
    }

    private void Lh() {
        String o16 = QQGuildUIUtil.o(this.V, this.Y, getAppInterface(), 1);
        this.Z = o16;
        if (TextUtils.isEmpty(o16)) {
            QLog.w("Guild.rg.CreatorRoleDetailFragment", 1, "fullAvatarUrl is empty");
            return;
        }
        ImageView imageView = this.T;
        IQQGuildAvatarApi iQQGuildAvatarApi = (IQQGuildAvatarApi) ch.R0(IQQGuildAvatarApi.class);
        String str = this.Z;
        int i3 = this.f232533b0;
        imageView.setImageDrawable(iQQGuildAvatarApi.getAvatarDrawable(str, i3, i3, (String) null));
        this.U.setText(this.f232534c0.getGuildUserDisplayName(this.V, this.Y));
    }

    private void initView() {
        String str;
        this.E.setText(getString(R.string.f1517318h));
        uh(ViewUtils.dpToPx(16.0f));
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildCreatorRoleFragment.this.lambda$initView$0(view);
            }
        });
        if (TextUtils.isEmpty(this.X)) {
            str = "\u9891\u9053\u4e3b";
        } else {
            str = this.X;
        }
        ((TextView) this.P.findViewById(R.id.f779045m)).setText(str);
        this.P.findViewById(R.id.zm5).setBackgroundColor(this.W);
        ((ImageView) this.P.findViewById(R.id.vtg)).setImageTintList(ColorStateList.valueOf(this.W));
        ((TextView) this.P.findViewById(R.id.vti)).setText(ch.t(this.W));
        this.U = (TextView) this.P.findViewById(R.id.ubj);
        this.T = (ImageView) this.P.findViewById(R.id.a2o);
        Ih();
        Lh();
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.f239007o);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        com.tencent.mobileqq.guild.base.extension.q.a(recyclerView, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(0.0f));
        ux1.g gVar = new ux1.g();
        this.f232536e0 = gVar;
        recyclerView.setAdapter(gVar);
        recyclerView.setNestedScrollingEnabled(false);
    }

    private void initViewModel() {
        com.tencent.mobileqq.guild.rolegroup.viewmodel.h hVar = (com.tencent.mobileqq.guild.rolegroup.viewmodel.h) ef1.c.a(this, com.tencent.mobileqq.guild.rolegroup.viewmodel.h.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.tencent.mobileqq.guild.rolegroup.viewmodel.h Gh;
                Gh = GuildCreatorRoleFragment.this.Gh();
                return Gh;
            }
        });
        this.f232535d0 = hVar;
        hVar.U1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCreatorRoleFragment.this.Hh((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Kh();
        initView();
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f6a;
    }
}
