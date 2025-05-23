package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.jvm.functions.Function0;
import vx1.a;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildChannelAdminRoleFragment extends QQGuildTitleBarFragment implements a.InterfaceC11444a {
    private ImageView T;
    private TextView U;
    private RadiusFrameLayout V;
    private TextView W;
    private RecyclerView X;
    private RecyclerView Y;
    private RecyclerView Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f232524a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f232525b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f232526c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f232527d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.rolegroup.viewmodel.e f232528e0;

    /* renamed from: f0, reason: collision with root package name */
    private vx1.a f232529f0;

    /* renamed from: g0, reason: collision with root package name */
    private ux1.g f232530g0;

    /* renamed from: h0, reason: collision with root package name */
    private a f232531h0 = new a();

    private void Hh() {
        ((com.tencent.mobileqq.guild.rolegroup.viewmodel.h) ef1.c.a(this, com.tencent.mobileqq.guild.rolegroup.viewmodel.h.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.tencent.mobileqq.guild.rolegroup.viewmodel.h Jh;
                Jh = GuildChannelAdminRoleFragment.this.Jh();
                return Jh;
            }
        })).U1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildChannelAdminRoleFragment.this.Kh((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ih(cf1.b bVar) {
        if (bVar != null) {
            SecurityTipHelperKt.D(BaseApplication.getContext(), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.tencent.mobileqq.guild.rolegroup.viewmodel.h Jh() {
        return new com.tencent.mobileqq.guild.rolegroup.viewmodel.h(this.f232524a0, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(List list) {
        this.f232530g0.setData(list);
    }

    public static void Lh(Context context, @NonNull String str, int i3, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("extra_guild_id", str);
        intent.putExtra("extra_role_color", i3);
        intent.putExtra("extra_role_display_tag_name", str2);
        intent.putExtra("extra_role_name", str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildChannelAdminRoleFragment.class);
    }

    private void Mh() {
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("Guild.rg.ChannelAdminRoleDetailFragment", 1, "bundle is null");
            onBackEvent();
            return;
        }
        this.f232524a0 = intent.getStringExtra("extra_guild_id");
        this.f232525b0 = intent.getIntExtra("extra_role_color", -1);
        this.f232526c0 = intent.getStringExtra("extra_role_display_tag_name");
        String stringExtra = intent.getStringExtra("extra_role_name");
        this.f232527d0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.f232527d0 = HardCodeUtil.qqStr(R.string.f141040fl);
        }
    }

    private void initData() {
        com.tencent.mobileqq.guild.rolegroup.viewmodel.e eVar = (com.tencent.mobileqq.guild.rolegroup.viewmodel.e) ef1.c.a(this, com.tencent.mobileqq.guild.rolegroup.viewmodel.e.class, new Function0() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new com.tencent.mobileqq.guild.rolegroup.viewmodel.e();
            }
        });
        this.f232528e0 = eVar;
        eVar.T1(this.f232524a0);
        this.f232528e0.Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildChannelAdminRoleFragment.this.lambda$initData$0((List) obj);
            }
        });
        this.f232528e0.getToastEvent().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildChannelAdminRoleFragment.Ih((cf1.b) obj);
            }
        });
    }

    @RequiresApi(api = 21)
    private void initView() {
        String str;
        uh(ViewUtils.dpToPx(16.0f));
        this.E.setText(this.f232527d0);
        this.T = (ImageView) this.P.findViewById(R.id.vtd);
        this.U = (TextView) this.P.findViewById(R.id.vti);
        this.V = (RadiusFrameLayout) this.P.findViewById(R.id.f778945l);
        ((TextView) this.P.findViewById(R.id.yjr)).setText(R.string.f141050fm);
        if (TextUtils.isEmpty(this.f232526c0)) {
            str = getContext().getResources().getString(R.string.f154461ev);
        } else {
            str = this.f232526c0;
        }
        TextView textView = (TextView) this.P.findViewById(R.id.f779045m);
        this.W = textView;
        textView.setText(str);
        this.Z = (RecyclerView) this.P.findViewById(R.id.t59);
        this.X = (RecyclerView) this.P.findViewById(R.id.eoq);
        this.Y = (RecyclerView) this.P.findViewById(R.id.f239007o);
        this.T.setImageTintList(ColorStateList.valueOf(this.f232525b0));
        this.U.setText(ch.t(this.f232525b0));
        this.V.setBackgroundColor(this.f232525b0);
        this.X.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        vx1.a aVar = new vx1.a(this.f232524a0, new a.InterfaceC11444a() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.q
            @Override // vx1.a.InterfaceC11444a
            public final void g6(String str2, String str3, int i3) {
                GuildChannelAdminRoleFragment.this.g6(str2, str3, i3);
            }
        });
        this.f232529f0 = aVar;
        this.X.setAdapter(aVar);
        this.Y.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        com.tencent.mobileqq.guild.base.extension.q.a(this.Y, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(0.0f));
        ux1.g gVar = new ux1.g();
        this.f232530g0 = gVar;
        this.Y.setAdapter(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0(List list) {
        this.f232529f0.setData(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    @RequiresApi(api = 21)
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Mh();
        initView();
        initData();
        Hh();
    }

    @Override // vx1.a.InterfaceC11444a
    public void g6(String str, String str2, int i3) {
        String string;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 5) {
                    if (i3 != 7) {
                        string = this.f232527d0;
                    } else {
                        string = getString(R.string.f141140fv);
                    }
                } else {
                    string = getString(R.string.f141510gv);
                }
            } else {
                string = getString(R.string.f142070id);
            }
        } else {
            string = getString(R.string.f1488610q);
        }
        GuildCommonViewMemberFragment.ki(requireActivity(), new GuildRoleMemberParamData(this.f232524a0, string, 2, 3).setSubChannelId(str).setSubTitleStr(str2).setRoleGroupId("5").setMaxCountCanSelect(this.f232528e0.P1()).setOpenPageSlideType(2).setActivityRequestCode(2001).setNextAddPageTitle(ch.i().getString(R.string.f1488410o)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ehm;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f232528e0.O1();
    }
}
