package com.tencent.mobileqq.guild.setting.guildmanage.name;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.mainframe.create.j;
import com.tencent.mobileqq.guild.setting.guildmanage.name.QQGuildNameSettingFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cd;
import com.tencent.mobileqq.qqguildsdk.data.genc.ce;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.NumberUtil;
import com.tencent.util.UiThreadUtil;
import h53.QUIInputCountCalculateStrategy;
import h53.c;
import h53.q;
import java.util.ArrayList;
import java.util.HashMap;
import wh2.d;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildNameSettingFragment extends QQGuildNameBaseFragment {
    private IGProGuildInfo W;
    private boolean X = false;
    private q Y = Sh();
    Dialog Z = null;

    private q Sh() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Th, reason: merged with bridge method [inline-methods] */
    public void Vh(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        int i16;
        boolean i17 = j.i(iGProSecurityResult);
        if (iGProSecurityResult != null) {
            i16 = (int) iGProSecurityResult.get$actionCode();
        } else {
            i16 = -1;
        }
        if (i17) {
            i16 = i3;
        }
        Dialog dialog = this.Z;
        if (dialog != null && dialog.isShowing()) {
            this.Z.dismiss();
        }
        if (i16 == 0 && ch.p(iGProSecurityResult)) {
            Xh();
        } else {
            SecurityTipHelperKt.A(BaseApplication.getContext(), i3, str, iGProSecurityResult);
        }
    }

    private boolean Uh() {
        String charSequence = this.V.d().toString();
        if (cb.b(charSequence).c() < this.T || TextUtils.equals(charSequence, this.W.getGuildName())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wh(String str, final int i3, final String str2, final IGProSecurityResult iGProSecurityResult, int i16) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            QLog.d("QQGuildNameSettingFragment", 1, "handleModifyGuildInfoBack:", "name", str, " errCode:", Integer.valueOf(i3), " errMsg:", str2, " secResult:", iGProSecurityResult);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: nz1.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQGuildNameSettingFragment.this.Vh(i3, str2, iGProSecurityResult);
                }
            });
        } else {
            QLog.e("QQGuildNameSettingFragment", 1, "onSubmit onSetGuildInfoResult the date is null");
        }
    }

    private void Xh() {
        QQToast.makeText(BaseApplication.getContext(), 2, "\u5df2\u63d0\u4ea4\u5ba1\u6838\uff0c\u901a\u8fc7\u540e\u751f\u6548", 1).show();
        if (getActivity() == null) {
            return;
        }
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public static void Yh(Context context, IGProGuildInfo iGProGuildInfo, int i3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_guild_info", iGProGuildInfo);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, QQGuildNameSettingFragment.class, i3);
    }

    private void bi() {
        this.V.setVisibility(0);
        setRightButtonEnable(Uh());
    }

    private void initView() {
        resetLeftButton();
        Object parent = this.P.getParent();
        if (parent instanceof View) {
            ((View) parent).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        this.V.setInputViewWatcher(this.Y);
        this.V.setStyle(1);
        this.V.setShowBottomLine(false);
        ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.d_z);
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        bi();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment
    protected String Dh() {
        return null;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment
    protected String Eh() {
        IGProGuildInfo iGProGuildInfo = this.W;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo.getGuildName();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment
    protected void Fh() {
        String Eh = Eh();
        int c16 = c.a(Eh, new QUIInputCountCalculateStrategy()).c(new QUIInputCountCalculateStrategy());
        if (c16 <= this.U) {
            this.V.setContentText(Eh());
            QUISingleLineInputView qUISingleLineInputView = this.V;
            qUISingleLineInputView.setTextSelection(qUISingleLineInputView.d().length());
        } else {
            this.V.setMaxWordCount(c16);
            this.V.setContentText(Eh);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment
    protected void Gh(String str) {
        if (this.W != null && getActivity() != null) {
            if (TextUtils.equals(str, this.W.getGuildName())) {
                getActivity().finish();
                return;
            } else {
                Zh(true);
                return;
            }
        }
        QLog.e("QQGuildNameSettingFragment", 1, "onSubmit the date is null");
    }

    void Zh(boolean z16) {
        com.tencent.mobileqq.guild.setting.guildmanage.name.a.a(this);
        final String trim = this.V.d().toString().trim();
        QLog.d("QQGuildNameSettingFragment", 1, "sendModifyNameRequest:", "name", trim, " ignoreGeneralizationWords:", Boolean.valueOf(z16));
        cd cdVar = new cd();
        cdVar.m(1);
        cdVar.k(trim);
        ArrayList<cd> arrayList = new ArrayList<>();
        arrayList.add(cdVar);
        ce ceVar = new ce();
        ceVar.g(NumberUtil.stringToLong(this.W.getGuildID()));
        ceVar.e(arrayList);
        ceVar.h(z16 ? 1 : 0);
        ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).setGuildAuditInfo(ceVar, new d() { // from class: nz1.a
            @Override // wh2.d
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, int i16) {
                QQGuildNameSettingFragment.this.Wh(trim, i3, str, iGProSecurityResult, i16);
            }
        });
    }

    void ai(View view) {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(view, "pg_sgrp_set_name");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        IGProGuildInfo iGProGuildInfo = this.W;
        if (iGProGuildInfo != null) {
            hashMap.put("sgrp_channel_id", iGProGuildInfo.getGuildID());
        }
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment, com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.W = (IGProGuildInfo) getActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info");
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView();
        ai(this.N);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f0w;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment
    protected String getTitle() {
        return getResources().getString(R.string.f156471ka);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        InputMethodUtil.hide(this.V);
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = this.F;
        if (textView != null) {
            textView.setTextColor(AppCompatResources.getColorStateList(textView.getContext(), R.color.qui_common_text_primary));
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            this.J.f().setBackground(GuildUIUtils.w(guildDefaultThemeNavBarCommon.getContext(), R.drawable.guild_back_left, Integer.valueOf(R.color.qui_common_icon_primary)));
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.J;
            guildDefaultThemeNavBarCommon2.setTitleColor(AppCompatResources.getColorStateList(guildDefaultThemeNavBarCommon2.getContext(), R.color.qui_common_text_primary));
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_fill_light_primary;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_fill_light_primary_bg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements q {
        a() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
            boolean z16;
            if (((QQGuildNameBaseFragment) QQGuildNameSettingFragment.this).V != null && ((QQGuildNameBaseFragment) QQGuildNameSettingFragment.this).V.d() != null) {
                if (j.c(((QQGuildNameBaseFragment) QQGuildNameSettingFragment.this).V) && !TextUtils.equals(((QQGuildNameBaseFragment) QQGuildNameSettingFragment.this).V.d(), QQGuildNameSettingFragment.this.W.getGuildName())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QQGuildNameSettingFragment.this.setRightButtonEnable(z16);
            }
        }

        @Override // h53.k
        public void f8(boolean z16) {
            if (QQGuildNameSettingFragment.this.X != z16 && z16) {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(((QQGuildNameBaseFragment) QQGuildNameSettingFragment.this).V, "em_sgrp_create_name", "clck", new HashMap());
            }
            QQGuildNameSettingFragment.this.X = z16;
            if (!z16 || ((QQGuildNameBaseFragment) QQGuildNameSettingFragment.this).V.d() == null) {
                return;
            }
            QQGuildNameSettingFragment.this.setRightButtonEnable(true);
        }

        @Override // h53.q
        public void A4(String str) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // h53.k
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
