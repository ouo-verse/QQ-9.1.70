package com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.fragment.audience.module.subtopbar.QQGuildSubTopBarLiveFragment;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.module.subtopbar.QQGuildLiveBaseSubTopBarFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.viewmodel.i;
import com.tencent.mobileqq.guild.nt.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.math.BigDecimal;
import nq1.g;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildSubTopBarLiveFragment extends QQGuildLiveBaseSubTopBarFragment implements View.OnClickListener, nq1.d {
    private TextView C;
    private TextView D;
    private ImageView E;
    private View F;
    private ImageView G;
    private TextView H;
    private final tq1.b I = GLiveChannelCore.f226698a.t();
    private com.tencent.mobileqq.guild.live.viewmodel.module.b J;
    private View K;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Observer<String> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            QQGuildSubTopBarLiveFragment.this.Eh(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements Observer<String> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            QQGuildSubTopBarLiveFragment.this.Gh(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c implements Observer<eu> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(eu euVar) {
            QQGuildSubTopBarLiveFragment.this.Fh(euVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d implements Observer<Integer> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num != null) {
                QQGuildSubTopBarLiveFragment.this.Jh(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                QQGuildSubTopBarLiveFragment.this.K.setVisibility(0);
            } else {
                QQGuildSubTopBarLiveFragment.this.K.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ah(Boolean bool) {
        Ih();
    }

    public static QQGuildLiveModuleBaseFragment Bh() {
        return new QQGuildSubTopBarLiveFragment();
    }

    private void Ch() {
        String mainSource;
        if (o.c("QGL.anchor_name_click")) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.QQGuildSubTopBarLiveFragment", 2, "anchor name click too fast return");
                return;
            }
            return;
        }
        if (getActivity() != null) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
            if (channelInfo != null && channelInfo.getLiveAnchorTinyId() > 0) {
                JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) gLiveChannelCore.s().getBundle().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
                String str = "";
                if (joinInfoParam == null) {
                    mainSource = "";
                } else {
                    mainSource = joinInfoParam.getMainSource();
                }
                if (joinInfoParam != null) {
                    str = joinInfoParam.getSubSource();
                }
                GuildProfileData guildProfileData = new GuildProfileData(channelInfo.getGuildId(), channelInfo.getChannelUin(), String.valueOf(channelInfo.getLiveAnchorTinyId()), 2, GuildProfileData.getSceneTypeBySource(mainSource, str, 4));
                guildProfileData.getExtras().putBoolean("open_profile_card_by_live_host", true);
                guildProfileData.getGuildBaseProfileData().r(channelInfo.getChannelUin());
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(getActivity(), guildProfileData);
                return;
            }
            QLog.e("QGL.QQGuildSubTopBarLiveFragment", 1, "openAnchorProfileCard channelInfo.getLiveAnchorTinyId invalid.");
        }
    }

    private void Dh() {
        if (getActivity() == null) {
            return;
        }
        if (VersionUtils.isHoneycomb()) {
            getActivity().startActivity(new Intent("android.settings.SETTINGS"));
        } else {
            getActivity().startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh(String str) {
        Drawable avatarDrawable;
        if (TextUtils.isEmpty(str)) {
            avatarDrawable = ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getDefaultFaceDrawable(true);
        } else {
            avatarDrawable = ((IQQGuildAvatarApi) getAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(str, 0, true, "live_anchor_avatar");
        }
        this.G.setImageDrawable(avatarDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(eu euVar) {
        String url = euVar.getUrl();
        if (!StringUtil.isEmpty(url)) {
            this.E.setVisibility(0);
            u.p(url, this.E);
        } else {
            this.E.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh(String str) {
        if (str != null && str.length() > 15) {
            this.D.setText(str.substring(0, 15));
            this.D.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        } else {
            this.D.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Hh, reason: merged with bridge method [inline-methods] */
    public void yh(IGProRoleManagementTag iGProRoleManagementTag) {
        if (iGProRoleManagementTag != null && !TextUtils.isEmpty(iGProRoleManagementTag.getTagName())) {
            this.H.setVisibility(0);
            this.H.setBackgroundTintList(ColorStateList.valueOf((int) (iGProRoleManagementTag.getColor() | (-16777216))));
            this.H.setText(iGProRoleManagementTag.getTagName());
            return;
        }
        this.H.setVisibility(8);
    }

    private void Ih() {
        Boolean value = this.I.D().getValue();
        Boolean bool = Boolean.TRUE;
        if (value == bool) {
            this.F.setVisibility(0);
        } else if (GLiveChannelCore.f226698a.r().a() && this.I.C().getValue() == bool) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(int i3) {
        if (i3 >= 10000) {
            this.C.setText(getString(R.string.f147500x2, String.valueOf(BigDecimal.valueOf(i3 / 10000).setScale(1, 4).doubleValue())));
        } else {
            this.C.setText(getString(R.string.f147490x1, String.valueOf(i3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initLiveDataObserver$3(Boolean bool) {
        Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zh(Boolean bool) {
        Ih();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ewp;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected void initLiveDataObserver() {
        this.J.b2().observe(getViewLifecycleOwner(), new a());
        this.J.d2().observe(getViewLifecycleOwner(), new b());
        this.J.c2().observe(getViewLifecycleOwner(), new c());
        this.J.f2().observe(getViewLifecycleOwner(), new Observer() { // from class: mq1.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubTopBarLiveFragment.this.yh((IGProRoleManagementTag) obj);
            }
        });
        this.I.f().observe(getViewLifecycleOwner(), new d());
        this.I.n().observe(getViewLifecycleOwner(), new e());
        this.I.D().observe(getViewLifecycleOwner(), new Observer() { // from class: mq1.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubTopBarLiveFragment.this.zh((Boolean) obj);
            }
        });
        this.I.n().observe(getViewLifecycleOwner(), new Observer() { // from class: mq1.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubTopBarLiveFragment.this.Ah((Boolean) obj);
            }
        });
        this.I.C().observe(getViewLifecycleOwner(), new Observer() { // from class: mq1.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubTopBarLiveFragment.this.lambda$initLiveDataObserver$3((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NonNull View view) {
        this.K = view.findViewById(R.id.wn_);
        if (getShowHideAnimHelper() != null) {
            getShowHideAnimHelper().n(view, "subTopBarLiveRootView");
            getShowHideAnimHelper().i(view, "subTopBarLiveRootView");
        }
        this.C = (TextView) view.findViewById(R.id.wne);
        this.D = (TextView) view.findViewById(R.id.wna);
        this.H = (TextView) view.findViewById(R.id.vwy);
        this.E = (ImageView) view.findViewById(R.id.wnb);
        this.G = (ImageView) view.findViewById(R.id.wng);
        this.F = view.findViewById(R.id.wm6);
        this.K.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initViewModel() {
        super.initViewModel();
        this.J = (com.tencent.mobileqq.guild.live.viewmodel.module.b) i.a(this.mLiveRoomViewModelStoreOwner).get(com.tencent.mobileqq.guild.live.viewmodel.module.b.class);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildSubTopBarLiveFragment", 2, "onAttach.");
        }
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.f(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wn_) {
            Ch();
        } else if (view.getId() == R.id.wnh) {
            Dh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildSubTopBarLiveFragment", 2, "onDetach.");
        }
        g gVar = this.mLiveModuleControl;
        if (gVar != null) {
            gVar.f(null);
        }
    }
}
