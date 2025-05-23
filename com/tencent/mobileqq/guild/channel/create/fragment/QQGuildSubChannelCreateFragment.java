package com.tencent.mobileqq.guild.channel.create.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import bg1.c;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateFragment;
import com.tencent.mobileqq.guild.channel.create.viewmodel.GuildSubChannelCreateViewModel;
import com.tencent.mobileqq.guild.channel.create.widget.SubChannelApplicationLinkController;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildOpenBindPermissionUtils;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.GuildChannelIconUtil;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.HashMap;
import of1.GuildCreateTextChannelSubType;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildSubChannelCreateFragment extends BaseCreateSubChannelFragment implements View.OnClickListener, CharacterCountEditText.c, Handler.Callback {
    private TextView F;
    private TextView G;
    private RoundRectImageView H;
    private ImageView I;
    private CharacterCountEditText J;
    private TextView K;
    private View L;
    private TextView M;
    private View N;
    private ImageView P;
    private ImageView Q;
    private TextView R;
    private View S;
    private View T;
    private View U;
    private View V;
    private TextView W;
    private View X;
    private TextView Y;

    @Nullable
    private SubChannelApplicationLinkController Z;

    /* renamed from: a0, reason: collision with root package name */
    private GuildSubChannelCreateViewModel f214836a0;

    /* renamed from: b0, reason: collision with root package name */
    private RoleLabelData[] f214837b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    private RoleLabelData[] f214838c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    private RoleGroupUserUIData[] f214839d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    private RoleGroupUserUIData[] f214840e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    private final WeakReferenceHandler f214841f0 = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: g0, reason: collision with root package name */
    private int f214842g0 = 20;

    /* renamed from: h0, reason: collision with root package name */
    private Boolean f214843h0 = Boolean.FALSE;

    /* renamed from: i0, reason: collision with root package name */
    private String f214844i0 = "\u8ba8\u8bba\u7ec4";

    /* renamed from: j0, reason: collision with root package name */
    private String f214845j0 = "";

    private String Ah(String str) {
        IGProGuildInfo guildInfo = ((IGPSService) ch.S0(IGPSService.class, "")).getGuildInfo(str);
        if (guildInfo == null) {
            return "";
        }
        return guildInfo.getAvatarUrl(100);
    }

    private void Bh(EditText editText) {
        editText.setFocusableInTouchMode(false);
        editText.clearFocus();
        editText.setFocusableInTouchMode(true);
    }

    private void Ch(int i3) {
        Zh(false);
        GuildChannelIconUtil.p(this.I, i3, 0);
        if (i3 != 1) {
            if (i3 != 5) {
                if (i3 == 6) {
                    this.J.setText(this.f214836a0.getAppName());
                    this.J.setSelection(this.f214836a0.getAppName().length());
                    if (this.f214836a0.getAppId() == MiniAppReportManager.MAX_TIME_VALUE) {
                        this.Z = new SubChannelApplicationLinkController(this.C);
                        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) this.E.getDialog();
                        if (aVar != null) {
                            aVar.getBehavior().addBottomSheetCallback(new b());
                        }
                    }
                    if (!StringUtil.isEmpty(this.f214836a0.getAppIconUrl())) {
                        this.H.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestWidth = ViewUtils.dip2px(18.0f);
                        obtain.mRequestHeight = ViewUtils.dip2px(18.0f);
                        this.H.setImageDrawable(URLDrawable.getDrawable(this.f214836a0.getAppIconUrl(), obtain));
                        this.H.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            Dh();
            Zh(true);
            this.G.setText(R.string.f147590xa);
            return;
        }
        this.f214836a0.setGuildTextChannelSubType(new GuildCreateTextChannelSubType(0, "\u95f2\u804a", this.f214845j0));
    }

    private void Dh() {
        if (this.S != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.x5_)).inflate();
        this.S = inflate;
        View findViewById = inflate.findViewById(R.id.f165554wm4);
        this.T = findViewById;
        findViewById.setOnClickListener(this);
        this.U = this.S.findViewById(R.id.wm5);
        View findViewById2 = this.S.findViewById(R.id.wm_);
        this.V = findViewById2;
        findViewById2.setOnClickListener(this);
        this.W = (TextView) this.S.findViewById(R.id.f165557wn2);
        this.X = this.S.findViewById(R.id.wma);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(GuildSubChannelCreateViewModel.c cVar) {
        Vh(cVar.f214854a, this.f214836a0.getSelectMemberTips());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(GuildSubChannelCreateViewModel.b bVar) {
        Uh(bVar.f214850a, this.f214836a0.getSelectLiveAnchorMemberTips());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(cf1.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.f30775b == 0 && ch.p(bVar.f30776c)) {
            ch.f1(bVar.f30774a);
        } else {
            Mh(bVar.f30775b, bVar.f30774a, bVar.f30776c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh() {
        InputMethodUtil.show(this.J);
    }

    public static QQGuildSubChannelCreateFragment Kh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildSubChannelCreateFragment qQGuildSubChannelCreateFragment = new QQGuildSubChannelCreateFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildSubChannelCreateFragment.setArguments(bundle);
        return qQGuildSubChannelCreateFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Lh, reason: merged with bridge method [inline-methods] */
    public void Hh(GuildSubChannelCreateViewModel.d dVar) {
        if (dVar == null) {
            return;
        }
        Sh(dVar.f214859b);
        InputMethodUtil.hide(this.J);
        Bh(this.J);
        if (this.f214836a0.getChannelType() == 6 && this.f214836a0.getAppId() == MiniAppReportManager.MAX_TIME_VALUE) {
            if (!dVar.f214858a) {
                ch.e1(2, getString(R.string.f141330gd));
            }
            Oh(dVar.f214859b);
        } else if (!"main_setting".equals(this.D.f214823f) && !"msg_list_setting".equals(this.D.f214823f) && !"guild_home_page".equals(this.D.f214823f)) {
            if (!dVar.f214858a) {
                String string = getString(R.string.f141330gd);
                if (this.f214836a0.getChannelType() == 5) {
                    string = getString(R.string.f141520gw);
                } else if (this.f214836a0.getChannelType() == 2) {
                    string = getString(R.string.f142080ie);
                }
                if (this.f214843h0.booleanValue()) {
                    string = getString(R.string.f141130fu);
                }
                ch.e1(2, string);
            }
        } else {
            if (!dVar.f214858a) {
                ch.e1(2, getString(R.string.f141330gd));
            }
            int channelType = this.f214836a0.getChannelType();
            if (channelType != 1) {
                if (channelType != 6) {
                    if (channelType == 7) {
                        Qh(dVar.f214859b);
                    }
                } else if (this.f214836a0.getAppId() == 1000050) {
                    Rh(dVar.f214859b);
                }
            } else {
                Ph(dVar.f214859b);
            }
        }
        BaseDialogFragment baseDialogFragment = this.E;
        if (baseDialogFragment != null) {
            baseDialogFragment.rh();
        }
    }

    private void Mh(int i3, String str, @Nullable IGProSecurityResult iGProSecurityResult) {
        SubChannelApplicationLinkController subChannelApplicationLinkController;
        if (iGProSecurityResult != null && iGProSecurityResult.get$actionCode() == 102) {
            c.f(getActivity(), iGProSecurityResult, i3, str);
        } else if (i3 == 349007 && (subChannelApplicationLinkController = this.Z) != null) {
            subChannelApplicationLinkController.y();
        } else {
            SecurityTipHelperKt.J(iGProSecurityResult, getActivity(), i3, str);
        }
    }

    private void Nh(int i3, @Nullable Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            RoleLabelData[] roleLabelDataArr = (RoleLabelData[]) extras.getSerializable("SELECTED_ROLES_CACHE_DATA");
            RoleGroupUserUIData[] roleGroupUserUIDataArr = (RoleGroupUserUIData[]) extras.getSerializable("SELECTED_USERS_CACHE_DATA");
            if (roleLabelDataArr == null) {
                roleLabelDataArr = new RoleLabelData[0];
            }
            if (roleGroupUserUIDataArr == null) {
                roleGroupUserUIDataArr = new RoleGroupUserUIData[0];
            }
            QLog.d("Guild.c.create.QQGuildSubChannelCreateFragment", 4, "mCacheSelectedRole size:" + roleLabelDataArr.length + " mCacheSelectedMember:" + roleGroupUserUIDataArr.length);
            if (i3 == 403) {
                this.f214837b0 = roleLabelDataArr;
                this.f214839d0 = roleGroupUserUIDataArr;
                this.f214836a0.setChannelVisibleType(2, GuildOpenBindPermissionUtils.c(roleGroupUserUIDataArr), GuildOpenBindPermissionUtils.b(this.f214837b0));
            } else if (i3 == 404) {
                this.f214838c0 = roleLabelDataArr;
                this.f214840e0 = roleGroupUserUIDataArr;
                this.f214836a0.setChannelLiveAnchorType(0, GuildOpenBindPermissionUtils.c(roleGroupUserUIDataArr), GuildOpenBindPermissionUtils.b(this.f214838c0));
            }
        }
    }

    private void Oh(@NonNull IGProChannelInfo iGProChannelInfo) {
        kg1.a.d(getQBaseActivity(), new GuildClientParams().a((int) iGProChannelInfo.getApplicationId()).e0(iGProChannelInfo.getGuildId()).i0(iGProChannelInfo.getAppChannelJumpType()).f(iGProChannelInfo.getChannelUin()).g(iGProChannelInfo.getChannelName()).c0(Ah(iGProChannelInfo.getGuildId())).j0(iGProChannelInfo.getAppChannelJumpUrl()).g0(false).n(2).e());
    }

    private void Ph(@NonNull IGProChannelInfo iGProChannelInfo) {
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.extraInfo.channelOpenSourceForOnlineReport = 2;
        if (GuildMainFrameUtils.p(getQBaseActivity()) != null) {
            QLog.i("Guild.c.create.QQGuildSubChannelCreateFragment", 1, "open chatPanel in mainFrame");
            LaunchGuildChatPieParam a16 = new LaunchGuildChatPieParam().l(iGProChannelInfo.getGuildId()).b(iGProChannelInfo.getChannelUin()).r(false).o(1).a();
            a16.G.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
            GuildMainFrameUtils.r(getQBaseActivity(), 1, a16);
            return;
        }
        QLog.i("Guild.c.create.QQGuildSubChannelCreateFragment", 1, "open chatPanel in standalone");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin());
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        GuildJumpUtil.n(requireContext(), jumpGuildParam);
    }

    private void Qh(@NonNull IGProChannelInfo iGProChannelInfo) {
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.extraInfo.channelOpenSourceForOnlineReport = 2;
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            GuildJumpUtil.s(getContext(), iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), guildAppReportSourceInfo);
            return;
        }
        QLog.i("Guild.c.create.QQGuildSubChannelCreateFragment", 1, "fail open feedCenterPanel, from: " + this.D.f214823f + ", tabSelected: " + ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected());
        new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin()).setReportSourceInfo(guildAppReportSourceInfo);
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoChannelDirectly(requireContext(), new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin()));
    }

    private void Rh(@NonNull IGProChannelInfo iGProChannelInfo) {
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoChannelDirectly(requireContext(), new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin()));
        } else if (((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSimpleGuildMode().booleanValue()) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).gotoChannelDirectly(requireContext(), new JumpGuildParam(iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin()));
        } else {
            kg1.a.d(getQBaseActivity(), new GuildClientParams().a((int) iGProChannelInfo.getApplicationId()).e0(iGProChannelInfo.getGuildId()).i0(iGProChannelInfo.getAppChannelJumpType()).f(iGProChannelInfo.getChannelUin()).g(iGProChannelInfo.getChannelName()).c0(Ah(iGProChannelInfo.getChannelUin())).j0(iGProChannelInfo.getAppChannelJumpUrl()).g0(false).e());
        }
    }

    private void Sh(IGProChannelInfo iGProChannelInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(iGProChannelInfo.getType()));
        hashMap.put("sgrp_sub_channel_name", iGProChannelInfo.getChannelName());
        hashMap.put("sgrp_op_create_result", Integer.valueOf(this.f214836a0.getReportVisibleType()));
        int i3 = 1;
        if (this.f214836a0.getChannelType() == 1) {
            hashMap.put("sgrp_sub_text_channel_type", "" + this.f214836a0.getTextChannelSubtypeId());
        } else {
            hashMap.put("sgrp_sub_text_channel_type", "-1");
        }
        if (this.f214836a0.getChannelType() == 6) {
            hashMap.put("sgrp_sub_appchannel_id", Long.valueOf(this.f214836a0.getAppId()));
        }
        if (this.f214836a0.getChannelType() == 5) {
            GuildSubChannelCreateViewModel.b value = this.f214836a0.getChannelLiveAnchorLiveData().getValue();
            if (value == null || value.f214850a != 1) {
                i3 = 2;
            }
        } else {
            i3 = 3;
        }
        hashMap.put("sgrp_create_set_anchor", Integer.valueOf(i3));
        VideoReport.reportEvent("clck", this.G, hashMap);
    }

    private void Th(int i3) {
        GuildBindPermissionActionFactory.FetchType fetchType;
        RoleGroupUserUIData[] roleGroupUserUIDataArr;
        RoleLabelData[] roleLabelDataArr;
        CreateSubChannelInfo createSubChannelInfo = this.D;
        if (createSubChannelInfo == null) {
            QLog.d("Guild.c.create.QQGuildSubChannelCreateFragment", 4, "selectVisibleMember createInfo null return");
            return;
        }
        String str = createSubChannelInfo.f214821d;
        if (i3 == 404) {
            fetchType = GuildBindPermissionActionFactory.FetchType.FETCH_LIVE_CHANNEL_OPEN_LIVE;
        } else {
            fetchType = GuildBindPermissionActionFactory.FetchType.FETCH_WHO_CAN_SEE;
        }
        GuildBindPermissionActionFactory.FetchType fetchType2 = fetchType;
        if (i3 == 404) {
            roleGroupUserUIDataArr = this.f214840e0;
        } else {
            roleGroupUserUIDataArr = this.f214839d0;
        }
        RoleGroupUserUIData[] roleGroupUserUIDataArr2 = roleGroupUserUIDataArr;
        if (i3 == 404) {
            roleLabelDataArr = this.f214838c0;
        } else {
            roleLabelDataArr = this.f214837b0;
        }
        GuildOpenBindPermissionUtils.v(this, str, fetchType2, i3, roleGroupUserUIDataArr2, roleLabelDataArr, createSubChannelInfo.f214824h);
        this.E.yh();
        this.E.D = Boolean.FALSE;
    }

    private void Uh(int i3, String str) {
        if (this.S == null) {
            QLog.i("Guild.c.create.QQGuildSubChannelCreateFragment", 1, "[setChannelLiveAnchorType] mLiveAnchorLayout is null.");
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                QLog.i("Guild.c.create.QQGuildSubChannelCreateFragment", 1, "[setChannelLiveAnchorType] invalid type = " + i3);
                return;
            }
            this.U.setVisibility(0);
            this.X.setVisibility(8);
            this.W.setVisibility(8);
            return;
        }
        this.U.setVisibility(8);
        this.X.setVisibility(0);
        this.W.setVisibility(0);
        this.W.setText(str);
    }

    private void Vh(int i3, String str) {
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.e("Guild.c.create.QQGuildSubChannelCreateFragment", 1, "invalid visibleType=" + i3);
                return;
            }
            this.P.setVisibility(8);
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.R.setText(str);
            return;
        }
        this.P.setVisibility(0);
        this.Q.setVisibility(8);
        this.R.setVisibility(8);
    }

    private void Wh() {
        VideoReport.setElementId(this.G, "em_sgrp_create_channel_done");
        VideoReport.setElementClickPolicy(this.G, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.G, ExposurePolicy.REPORT_NONE);
    }

    private void Xh() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.C, "pg_create_sub_channel");
        VideoReport.setPageContentId(this.C, "QQGuildSubChannelCreateFragment");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.D.f214821d);
        hashMap.put("sgrp_user_type", ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.D.f214821d));
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(this.D.f214824h));
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.C, this.D.f214821d, hashMap);
    }

    private void Yh() {
        this.J.setFocusable(true);
        this.J.setFocusableInTouchMode(true);
        this.J.requestFocus();
        this.J.postDelayed(new Runnable() { // from class: pf1.h
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildSubChannelCreateFragment.this.Jh();
            }
        }, 800L);
    }

    private void Zh(boolean z16) {
        int i3;
        View view = this.S;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ai, reason: merged with bridge method [inline-methods] */
    public void Gh(GuildCreateTextChannelSubType guildCreateTextChannelSubType) {
        if (guildCreateTextChannelSubType == null) {
            return;
        }
        this.J.setHint(guildCreateTextChannelSubType.getHintText());
        GuildChannelIconUtil.p(this.I, 1, guildCreateTextChannelSubType.getId());
    }

    private void initData() {
        IGProGuildInfo guildInfo = ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).getGuildInfo(this.D.f214821d);
        if (guildInfo != null && guildInfo.isVisibleForVisitor() && this.D.f214824h != 6) {
            this.M.setText(getResources().getString(R.string.f139550bk));
        } else {
            this.M.setText(getResources().getString(R.string.f139560bl));
        }
        GuildSubChannelCreateViewModel guildSubChannelCreateViewModel = (GuildSubChannelCreateViewModel) h.b(this, GuildSubChannelCreateViewModel.sViewModelFactory).get(GuildSubChannelCreateViewModel.class);
        this.f214836a0 = guildSubChannelCreateViewModel;
        guildSubChannelCreateViewModel.init(this.D);
        Bundle bundle = this.D.f214825i;
        if (bundle != null) {
            String string = bundle.getString("extra_key_text_channel_name", "");
            if (!TextUtils.isEmpty(string)) {
                this.f214844i0 = string;
                this.f214845j0 = "\u95f2\u804a\uff08" + this.f214844i0 + "\u540d\u79f0\uff09";
            }
        }
        if (guildInfo != null && this.D.f214824h == 7 && guildInfo.isMovePostSection()) {
            this.f214843h0 = Boolean.TRUE;
            this.Y.setText(getResources().getString(R.string.f140970fe));
            this.F.setText(getResources().getString(R.string.f140850f3));
            this.G.setText(getResources().getString(R.string.f143340lt));
            this.G.setAlpha(0.3f);
            this.J.setHint(getResources().getString(R.string.f141170fy));
            this.f214842g0 = 5;
            this.K.setText("0/" + this.f214842g0);
            this.J.setLimitCount(this.f214842g0);
            Ch(7);
            this.I.setVisibility(8);
        } else {
            this.f214843h0 = Boolean.FALSE;
            int i3 = this.D.f214824h;
            if (i3 == 5) {
                this.Y.setText(getResources().getString(R.string.f141310gb));
                this.J.setHint(getResources().getString(R.string.f141540gy));
            } else if (i3 == 2) {
                this.Y.setText(getResources().getString(R.string.f141350gf));
                this.J.setHint(getResources().getString(R.string.f142140ik));
            } else if (i3 == 1) {
                this.Y.setText("\u521b\u5efa" + this.f214844i0);
                this.J.setHint(this.f214845j0);
            } else {
                this.Y.setText(getResources().getString(R.string.f142960ks));
                this.J.setHint(getResources().getString(R.string.f141740hh));
            }
            this.F.setText(this.D.f214826m);
            this.G.setText(getResources().getString(R.string.f147590xa));
            this.f214842g0 = 20;
            this.K.setText("0/" + this.f214842g0);
            this.J.setLimitCount(this.f214842g0);
            Ch(this.f214836a0.getChannelType());
            this.I.setVisibility(0);
        }
        this.f214836a0.getChannelVisibleLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: pf1.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubChannelCreateFragment.this.Eh((GuildSubChannelCreateViewModel.c) obj);
            }
        });
        this.f214836a0.getChannelLiveAnchorLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: pf1.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubChannelCreateFragment.this.Fh((GuildSubChannelCreateViewModel.b) obj);
            }
        });
        this.f214836a0.getGuildTextChannelSubType().observe(getViewLifecycleOwner(), new Observer() { // from class: pf1.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubChannelCreateFragment.this.Gh((GuildCreateTextChannelSubType) obj);
            }
        });
        this.f214836a0.getCreateChannelResultData().observe(getViewLifecycleOwner(), new Observer() { // from class: pf1.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubChannelCreateFragment.this.Hh((GuildSubChannelCreateViewModel.d) obj);
            }
        });
        this.f214836a0.getToastEvent().observe(getViewLifecycleOwner(), new Observer() { // from class: pf1.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildSubChannelCreateFragment.this.Ih((cf1.b) obj);
            }
        });
    }

    @RequiresApi(api = 21)
    private void initView() {
        this.G = (TextView) this.C.findViewById(R.id.j6n);
        this.J = (CharacterCountEditText) this.C.findViewById(R.id.f901351n);
        this.F = (TextView) this.C.findViewById(R.id.t2v);
        this.K = (TextView) this.C.findViewById(R.id.ts7);
        this.I = (ImageView) this.C.findViewById(R.id.tsq);
        this.H = (RoundRectImageView) this.C.findViewById(R.id.stb);
        this.Y = (TextView) this.C.findViewById(R.id.uas);
        this.L = this.C.findViewById(R.id.sly);
        this.P = (ImageView) this.C.findViewById(R.id.slz);
        this.M = (TextView) this.C.findViewById(R.id.f164294rc);
        this.N = this.C.findViewById(R.id.ucu);
        this.Q = (ImageView) this.C.findViewById(R.id.ucv);
        this.R = (TextView) this.C.findViewById(R.id.f82104fz);
        this.J.setCountChangeListener(this);
        this.G.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.N.setOnClickListener(this);
        Yh();
        BaseDialogFragment baseDialogFragment = this.E;
        if (baseDialogFragment != null) {
            baseDialogFragment.Ch(new BaseDialogFragment.c() { // from class: pf1.b
                @Override // com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment.c
                public final void a() {
                    QQGuildSubChannelCreateFragment.this.lambda$initView$0();
                }
            });
            ((com.google.android.material.bottomsheet.a) this.E.getDialog()).getBehavior().addBottomSheetCallback(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        InputMethodUtil.hide(this.J);
    }

    private void zh() {
        SubChannelApplicationLinkController subChannelApplicationLinkController;
        String obj = this.J.getText().toString();
        if (TextUtils.isEmpty(obj) && this.f214843h0.booleanValue()) {
            QQGuildUIUtil.Q(getContext(), R.string.f141210g2);
            return;
        }
        if (this.f214843h0.booleanValue() && TextUtils.isEmpty(obj.trim())) {
            QQGuildUIUtil.Q(getContext(), R.string.f141200g1);
            return;
        }
        if (!this.f214836a0.checkCreateValid(obj)) {
            return;
        }
        if (this.f214836a0.getAppId() == MiniAppReportManager.MAX_TIME_VALUE && (subChannelApplicationLinkController = this.Z) != null && !this.f214836a0.setApplicationSubChannelLink(subChannelApplicationLinkController.n())) {
            return;
        }
        this.f214836a0.createChannelWithParams(obj, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f9h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        BaseDialogFragment baseDialogFragment;
        if (message.what == 1 && (baseDialogFragment = this.E) != null) {
            baseDialogFragment.sh();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
    @RequiresApi(api = 21)
    protected void init() {
        initView();
        initData();
        Xh();
        Wh();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.d("Guild.c.create.QQGuildSubChannelCreateFragment", 4, "onActivityResult " + i16);
        if (i16 == -1) {
            Nh(i3, intent);
        }
        this.E.Bh();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v()) {
            if (view == this.G) {
                zh();
            } else if (view == this.F) {
                InputMethodUtil.hide(this.J);
                Bh(this.J);
                this.f214841f0.sendEmptyMessageDelayed(1, 200L);
            } else if (view == this.L) {
                this.f214836a0.setChannelVisibleType(1, new ArrayList(), new ArrayList());
            } else if (view == this.N) {
                Th(403);
            } else if (view == this.T) {
                this.f214836a0.setChannelLiveAnchorType(1, new ArrayList(), new ArrayList());
            } else if (view == this.V) {
                Th(404);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        InputMethodUtil.hide(this.J);
        onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SubChannelApplicationLinkController subChannelApplicationLinkController = this.Z;
        if (subChannelApplicationLinkController != null) {
            subChannelApplicationLinkController.v();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SubChannelApplicationLinkController subChannelApplicationLinkController = this.Z;
        if (subChannelApplicationLinkController != null) {
            subChannelApplicationLinkController.w();
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
    public void s7(cb.b bVar) {
        float f16;
        if (TextUtils.isEmpty(this.J.getText().toString())) {
            this.J.setTypeface(Typeface.defaultFromStyle(0));
        } else {
            this.J.setTypeface(Typeface.defaultFromStyle(1));
        }
        this.K.setText(bVar.a() + "/" + this.f214842g0);
        if (this.G.getText() == getResources().getString(R.string.f143340lt)) {
            TextView textView = this.G;
            if (bVar.a() > 0) {
                f16 = 1.0f;
            } else {
                f16 = 0.3f;
            }
            textView.setAlpha(f16);
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
    public void Bf(cb.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends BottomSheetBehavior.e {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
            InputMethodUtil.hide(QQGuildSubChannelCreateFragment.this.J);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NonNull View view, int i3) {
            QQGuildSubChannelCreateFragment.this.Z.u();
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NonNull View view, float f16) {
        }
    }
}
