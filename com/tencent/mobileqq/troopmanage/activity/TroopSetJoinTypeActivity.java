package com.tencent.mobileqq.troopmanage.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.widget.qqui.InputMethodLinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.jointype.event.TroopManageSetJoinTypeResultEvent;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.base.TroopManageBaseFragment;
import com.tencent.mobileqq.troopmanage.base.TroopManagerHandler;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cw;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$InviteMethod;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopSetJoinTypeActivity extends TroopManageBaseFragment implements View.OnClickListener, InputMethodLinearLayout.a, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    boolean A0;
    private int B0;
    private final View.OnFocusChangeListener C0;
    TextView.OnEditorActionListener D0;
    private EditText E;
    boolean E0;
    private EditText F;
    int F0;
    private EditText G;
    com.tencent.mobileqq.troopmanage.base.f G0;
    private View H;
    private View I;
    private View J;
    private LinearLayout K;
    private TextView L;
    private View M;
    private View N;
    private TextView P;
    private QUISingleLineListItem Q;
    private QUISingleLineListItem R;
    private View S;
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> T;
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> U;
    private final View[] V;
    private QQAnonymousDialog W;
    protected com.tencent.mobileqq.widget.ap X;
    private boolean Y;
    private com.tencent.biz.troop.b Z;

    /* renamed from: a0, reason: collision with root package name */
    protected InputMethodManager f302902a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TroopManagerHandler f302903b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f302904c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f302905d0;

    /* renamed from: e0, reason: collision with root package name */
    private String f302906e0;

    /* renamed from: f0, reason: collision with root package name */
    private List<Long> f302907f0;

    /* renamed from: g0, reason: collision with root package name */
    private TroopInfo f302908g0;

    /* renamed from: h0, reason: collision with root package name */
    private TroopInfoData f302909h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f302910i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f302911j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f302912k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f302913l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f302914m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f302915n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f302916o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f302917p0;

    /* renamed from: q0, reason: collision with root package name */
    private long f302918q0;

    /* renamed from: r0, reason: collision with root package name */
    private long f302919r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f302920s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f302921t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f302922u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f302923v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f302924w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f302925x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f302926y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f302927z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopSetJoinTypeActivity.this.Ki(z16);
            } else {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopSetJoinTypeActivity.this.Ni();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                return;
            }
            TroopSetJoinTypeActivity.this.f302925x0--;
            QLog.d("TroopSetJoinTypeActivity", 1, "onModifyTroopQuestion: succ:" + z16 + ",isNeedPayToJoin:" + TroopSetJoinTypeActivity.this.Ui() + ",mTroopInfo.troopPrivilegeFlag:" + TroopSetJoinTypeActivity.this.f302908g0.troopPrivilegeFlag + ",mNewOption:" + TroopSetJoinTypeActivity.this.f302910i0 + ",errCode:" + i3);
            if (z16) {
                if (TroopSetJoinTypeActivity.this.Ui()) {
                    ((TroopManageBaseFragment) TroopSetJoinTypeActivity.this).D.reportClickEvent("P_CliOper", "Grp_payjoin", "", "set_joingrp", "admin_set", 0, 0, TroopSetJoinTypeActivity.this.f302908g0.troopuin, "", "", "");
                    long j3 = TroopSetJoinTypeActivity.this.f302908g0.troopPrivilegeFlag & (-513);
                    TroopSetJoinTypeActivity troopSetJoinTypeActivity = TroopSetJoinTypeActivity.this;
                    troopSetJoinTypeActivity.tj(64, j3, (short) troopSetJoinTypeActivity.f302910i0);
                } else {
                    TroopSetJoinTypeActivity troopSetJoinTypeActivity2 = TroopSetJoinTypeActivity.this;
                    troopSetJoinTypeActivity2.tj(1, troopSetJoinTypeActivity2.f302908g0.troopPrivilegeFlag, (short) TroopSetJoinTypeActivity.this.f302910i0);
                }
            } else if (i3 == 1006) {
                TroopSetJoinTypeActivity.this.W.D.setImageResource(R.drawable.bsz);
                TroopSetJoinTypeActivity.this.W.E.setText(R.string.dvk);
                TroopSetJoinTypeActivity.this.W.O();
            }
            TroopSetJoinTypeActivity.this.zj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                return;
            }
            TroopSetJoinTypeActivity.this.f302925x0--;
            QLog.d("TroopSetJoinTypeActivity", 1, "[handleAllowMemberInviteChange]: succ:" + z16 + ",mNewAllowMemberInvite:" + TroopSetJoinTypeActivity.this.f302912k0 + ",mSetSvrSucc: " + TroopSetJoinTypeActivity.this.f302924w0 + ",dwGroupFlagExt:" + TroopSetJoinTypeActivity.this.f302908g0.dwGroupFlagExt);
            if (z16) {
                if (TroopSetJoinTypeActivity.this.f302912k0) {
                    TroopSetJoinTypeActivity.this.f302908g0.dwGroupFlagExt &= -129;
                } else {
                    TroopSetJoinTypeActivity.this.f302908g0.dwGroupFlagExt |= 128;
                }
                TroopSetJoinTypeActivity.this.f302924w0 = true;
                ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).saveTroopFlagExToSP(TroopSetJoinTypeActivity.this.getContext(), TroopSetJoinTypeActivity.this.f302905d0, TroopSetJoinTypeActivity.this.f302908g0.dwGroupFlagExt);
            } else {
                TroopSetJoinTypeActivity troopSetJoinTypeActivity = TroopSetJoinTypeActivity.this;
                troopSetJoinTypeActivity.Lj(troopSetJoinTypeActivity.getString(R.string.f179863_i));
            }
            TroopSetJoinTypeActivity.this.zj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements com.tencent.qqnt.troop.e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                return;
            }
            TroopSetJoinTypeActivity.this.f302925x0--;
            if (i3 == 0) {
                TroopSetJoinTypeActivity.this.f302924w0 = true;
                TroopSetJoinTypeActivity.this.f302908g0.troopPrivilegeFlag = (TroopSetJoinTypeActivity.this.f302908g0.troopPrivilegeFlag & (~TroopSetJoinTypeActivity.this.f302919r0)) | TroopSetJoinTypeActivity.this.f302918q0;
            } else {
                TroopSetJoinTypeActivity troopSetJoinTypeActivity = TroopSetJoinTypeActivity.this;
                troopSetJoinTypeActivity.Lj(troopSetJoinTypeActivity.getString(R.string.f179873_j));
            }
            TroopSetJoinTypeActivity.this.zj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f302933d;

        f(EditText editText) {
            this.f302933d = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this, (Object) editText);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            View view = (View) this.f302933d.getTag();
            int length = charSequence.toString().getBytes(StandardCharsets.UTF_8).length;
            if (length == 0) {
                view.setVisibility(8);
            } else if (this.f302933d.hasFocus()) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            String charSequence2 = charSequence.toString();
            if (length > 30) {
                while (length > 30) {
                    int length2 = charSequence2.length();
                    if (length2 >= 2) {
                        int i18 = length2 - 2;
                        if (Character.isHighSurrogate(charSequence2.charAt(i18))) {
                            charSequence2 = charSequence2.substring(0, i18);
                            length = charSequence2.getBytes(StandardCharsets.UTF_8).length;
                        }
                    }
                    charSequence2 = charSequence2.substring(0, length2 - 1);
                    length = charSequence2.getBytes(StandardCharsets.UTF_8).length;
                }
                this.f302933d.setText(charSequence2);
                EditText editText = this.f302933d;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (textView == TroopSetJoinTypeActivity.this.E) {
                String obj = TroopSetJoinTypeActivity.this.E.getText().toString();
                if (!TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj.trim())) {
                    TroopSetJoinTypeActivity.this.W.D.setImageResource(R.drawable.bsz);
                    TroopSetJoinTypeActivity.this.W.E.setText(R.string.eqj);
                    TroopSetJoinTypeActivity.this.W.O();
                } else {
                    TroopSetJoinTypeActivity troopSetJoinTypeActivity = TroopSetJoinTypeActivity.this;
                    troopSetJoinTypeActivity.f302902a0.hideSoftInputFromWindow(troopSetJoinTypeActivity.E.getWindowToken(), 0);
                    TroopSetJoinTypeActivity.this.E.clearFocus();
                    z16 = false;
                }
            } else if (textView == TroopSetJoinTypeActivity.this.F) {
                String obj2 = TroopSetJoinTypeActivity.this.F.getText().toString();
                if (!TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj2.trim())) {
                    TroopSetJoinTypeActivity.this.W.D.setImageResource(R.drawable.bsz);
                    TroopSetJoinTypeActivity.this.W.E.setText(R.string.eqj);
                    TroopSetJoinTypeActivity.this.W.O();
                } else {
                    TroopSetJoinTypeActivity.this.G.requestFocus();
                    if (TroopSetJoinTypeActivity.this.G.getText().length() != 0) {
                        TroopSetJoinTypeActivity.this.G.setSelection(TroopSetJoinTypeActivity.this.G.getText().length());
                    }
                    TroopSetJoinTypeActivity troopSetJoinTypeActivity2 = TroopSetJoinTypeActivity.this;
                    troopSetJoinTypeActivity2.f302902a0.showSoftInput(troopSetJoinTypeActivity2.G, 0);
                    z16 = false;
                }
            } else {
                if (textView == TroopSetJoinTypeActivity.this.G) {
                    if (TextUtils.isEmpty(TroopSetJoinTypeActivity.this.G.getText().toString().trim())) {
                        TroopSetJoinTypeActivity troopSetJoinTypeActivity3 = TroopSetJoinTypeActivity.this;
                        troopSetJoinTypeActivity3.qh(troopSetJoinTypeActivity3.getString(R.string.eqi));
                    } else {
                        TroopSetJoinTypeActivity troopSetJoinTypeActivity4 = TroopSetJoinTypeActivity.this;
                        troopSetJoinTypeActivity4.f302902a0.hideSoftInputFromWindow(troopSetJoinTypeActivity4.G.getWindowToken(), 0);
                        TroopSetJoinTypeActivity.this.G.clearFocus();
                    }
                }
                z16 = false;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class h implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f302936d;

        h(ActionSheet actionSheet) {
            this.f302936d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (TroopSetJoinTypeActivity.this.f302921t0 == 1 || TroopSetJoinTypeActivity.this.f302921t0 == 2 || TroopSetJoinTypeActivity.this.f302921t0 == 3) {
                TroopSetJoinTypeActivity.this.f302923v0 = true;
            }
            TextView textView = (TextView) TroopSetJoinTypeActivity.this.N.findViewById(R.id.info);
            if (i3 == 0) {
                ITroopManageService iTroopManageService = ((TroopManageBaseFragment) TroopSetJoinTypeActivity.this).D;
                String str4 = TroopSetJoinTypeActivity.this.f302908g0.troopuin;
                if (TroopSetJoinTypeActivity.this.f302909h0.bOwner) {
                    str = "0";
                } else {
                    str = "1";
                }
                iTroopManageService.reportClickEvent("dc00899", "Grp_manage", "", "invite_mana", "Clk_nonverify", 0, 0, str4, str, "", "");
                TroopSetJoinTypeActivity.this.f302918q0 = 1048576L;
                textView.setText(TroopSetJoinTypeActivity.this.getString(R.string.f1792338t));
            } else if (i3 == 1) {
                ITroopManageService iTroopManageService2 = ((TroopManageBaseFragment) TroopSetJoinTypeActivity.this).D;
                String str5 = TroopSetJoinTypeActivity.this.f302908g0.troopuin;
                if (TroopSetJoinTypeActivity.this.f302909h0.bOwner) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                iTroopManageService2.reportClickEvent("dc00899", "Grp_manage", "", "invite_mana", "Clk_needverify", 0, 0, str5, str2, "", "");
                TroopSetJoinTypeActivity.this.f302918q0 = 0L;
                textView.setText(TroopSetJoinTypeActivity.this.getString(R.string.f1792238s));
            } else if (i3 == 2) {
                ITroopManageService iTroopManageService3 = ((TroopManageBaseFragment) TroopSetJoinTypeActivity.this).D;
                String str6 = TroopSetJoinTypeActivity.this.f302909h0.troopUin;
                if (TroopSetJoinTypeActivity.this.f302909h0.bOwner) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                iTroopManageService3.reportClickEvent("dc00899", "Grp_manage", "", "invite_mana", "autojoin_100", 0, 0, str6, str3, "", "");
                TroopSetJoinTypeActivity.this.f302918q0 = 67108864L;
                textView.setText(TroopSetJoinTypeActivity.this.getString(R.string.e0i));
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopSetJoinTypeActivity", 2, "showInviteModeActionSheet() mCurFocusViewId : " + TroopSetJoinTypeActivity.this.f302921t0 + " mLastFocusViewId : " + TroopSetJoinTypeActivity.this.f302922u0 + " mIsSelectedInviteModeInNeedVerify : " + TroopSetJoinTypeActivity.this.f302923v0 + " mNewAllowMemberInvite : " + TroopSetJoinTypeActivity.this.f302912k0 + " mNewTroopInviteMode : " + TroopSetJoinTypeActivity.this.f302918q0);
            }
            this.f302936d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class i extends com.tencent.mobileqq.troopmanage.base.f {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSetJoinTypeActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troopmanage.base.f
        public void q(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16) {
                GroupExt groupExt = TroopSetJoinTypeActivity.this.f302908g0.groupExt;
                if (!z17) {
                    i3 = 1;
                }
                groupExt.inviteRobotMemberExamine = i3;
            }
            TroopSetJoinTypeActivity.this.zj();
        }

        @Override // com.tencent.mobileqq.troopmanage.base.f
        public void r(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 1;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16) {
                GroupExt groupExt = TroopSetJoinTypeActivity.this.f302908g0.groupExt;
                if (z17) {
                    i3 = 2;
                }
                groupExt.inviteRobotMemberSwitch = i3;
            }
            TroopSetJoinTypeActivity.this.zj();
        }
    }

    public TroopSetJoinTypeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = null;
        this.V = new View[7];
        this.f302904c0 = "1";
        this.f302905d0 = "0";
        this.f302906e0 = "";
        this.f302907f0 = null;
        this.f302908g0 = null;
        this.f302909h0 = null;
        this.f302910i0 = -1;
        this.f302911j0 = -1;
        this.f302919r0 = -1L;
        this.f302921t0 = -1;
        this.f302922u0 = -1;
        this.f302925x0 = 0;
        this.f302927z0 = 0;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.troopmanage.activity.v
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                TroopSetJoinTypeActivity.this.jj(view, z16);
            }
        };
        this.D0 = new g();
        this.E0 = false;
        this.F0 = 1;
        this.G0 = new i();
    }

    private void Ai(String str, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        hashMap2.put("dt_eid", str);
        hashMap2.put("eid", str);
        hashMap2.put("cur_pg", getReportPageParams());
        VideoReport.reportEvent("dt_clck", hashMap2);
    }

    public static String Aj(Context context, TroopInfoData troopInfoData) {
        if (troopInfoData.isOnlyTroopMemberInvite) {
            return context.getString(R.string.i76);
        }
        short s16 = troopInfoData.cGroupOption;
        if (s16 != 1) {
            if (s16 != 2) {
                if (s16 != 3) {
                    if (s16 != 4) {
                        if (s16 != 5) {
                            return "";
                        }
                        return context.getString(R.string.i78);
                    }
                    return context.getString(R.string.i79);
                }
                return context.getString(R.string.i7d);
            }
            return context.getString(R.string.i7b);
        }
        return context.getString(R.string.i77);
    }

    private void Bi(String str, String str2, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        hashMap2.put("dt_eid", str);
        hashMap2.put("eid", str);
        hashMap2.put("cur_pg", getReportPageParams());
        VideoReport.reportEvent(str2, hashMap2);
    }

    private void Bj(int i3) {
        this.f302903b0.R2(this.f302905d0, i3);
    }

    private void Ci(String str, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        hashMap2.put("dt_eid", str);
        hashMap2.put("eid", str);
        hashMap2.put("cur_pg", getReportPageParams());
        VideoReport.reportEvent("dt_imp", hashMap2);
    }

    private void Cj(boolean z16) {
        this.f302903b0.S2(this.f302905d0, Boolean.valueOf(z16));
    }

    private void Di(View view) {
        try {
            VideoReport.addToDetectionWhitelist(requireActivity());
            VideoReport.setPageId(view, "pg_group_set_add_way");
            HashMap hashMap = new HashMap();
            hashMap.put("group_id", this.f302905d0);
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.f302904c0);
            VideoReport.setPageParams(view, new PageParams(hashMap));
            VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_ALL);
        } catch (Exception unused) {
            QLog.e("TroopSetJoinTypeActivity", 1, "reportDtOnCreate e: $e");
        }
    }

    private HashMap<String, Object> Ei() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("join_way", Integer.valueOf(this.f302910i0));
        hashMap.put("allow_invite_join", Integer.valueOf(this.f302912k0 ? 1 : 0));
        long j3 = this.f302918q0;
        int i3 = 2;
        if (j3 == 67108864) {
            hashMap.put("invite_review_way", 1);
        } else if (j3 == 1048576) {
            hashMap.put("invite_review_way", 2);
        } else if (j3 == 0) {
            hashMap.put("invite_review_way", 3);
        }
        hashMap.put("allow_invite_robot_join", Integer.valueOf(Qi() ? 1 : 0));
        if (Si()) {
            i3 = 1;
        }
        hashMap.put("invite_robot_review_way", Integer.valueOf(i3));
        return hashMap;
    }

    private void Ej(List<Long> list, com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e eVar, TroopMultiGroupManageSvr$InviteMethod troopMultiGroupManageSvr$InviteMethod) {
        if (!ph()) {
            this.X.e(2, getString(R.string.b3j), 1000);
        } else {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.a.f297668a.b(list, eVar, troopMultiGroupManageSvr$InviteMethod, new Function0() { // from class: com.tencent.mobileqq.troopmanage.activity.ah
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit oj5;
                    oj5 = TroopSetJoinTypeActivity.this.oj();
                    return oj5;
                }
            }, new Function2() { // from class: com.tencent.mobileqq.troopmanage.activity.ai
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit pj5;
                    pj5 = TroopSetJoinTypeActivity.this.pj((Integer) obj, (String) obj2);
                    return pj5;
                }
            });
        }
    }

    private String Fi(TroopInfo troopInfo, Resources resources) {
        short s16;
        if (troopInfo == null || resources == null) {
            return "";
        }
        if (TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 128) && TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 512)) {
            s16 = 6;
        } else {
            s16 = troopInfo.cGroupOption;
        }
        if ((s16 == 1 || s16 == 6) && !troopInfo.isOnlyTroopMemberInviteOption()) {
            return resources.getString(R.string.f1792338t);
        }
        long j3 = troopInfo.troopPrivilegeFlag;
        if ((101711872 & j3) == 0) {
            return resources.getString(R.string.f1792238s);
        }
        if ((j3 & 1048576) == 1048576) {
            return resources.getString(R.string.f1792338t);
        }
        if ((j3 & 67108864) != 67108864 && (j3 & 33554432) != 33554432) {
            return "";
        }
        return resources.getString(R.string.e0i);
    }

    private void Fj() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(getString(R.string.f235007ah));
        createCustomDialog.setMessage(getString(R.string.f234997ag));
        final HashMap hashMap = new HashMap();
        createCustomDialog.setPositiveButton(getString(R.string.f185793pj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.aa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopSetJoinTypeActivity.this.rj(hashMap, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(getString(R.string.f185783pi), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopSetJoinTypeActivity.this.qj(hashMap, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        Bi("em_group_set_confirm_pop", "ev_group_set_confirm_pop_imp", new HashMap<>());
    }

    private List<Long> Gi(String str) {
        long j3;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    j3 = Long.parseLong(jSONArray.optString(i3));
                } catch (NumberFormatException unused) {
                    QLog.d("TroopSetJoinTypeActivity", 1, "parse troop uin exception.");
                    j3 = 0;
                }
                if (j3 > 0) {
                    arrayList.add(Long.valueOf(j3));
                }
            }
        } catch (JSONException unused2) {
            QLog.e("TroopSetJoinTypeActivity", 1, "getMultiGroupListFromArgument parse json error.");
        }
        return arrayList;
    }

    private void Gj(EditText editText, boolean z16) {
        View view = (View) editText.getTag();
        if (editText.getText().length() == 0) {
            view.setVisibility(8);
        } else if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    private void Hi() {
        this.f302925x0++;
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyAllowMemberInvite(this.f302905d0, this.f302912k0, this, new d());
    }

    private void Ii() {
        this.f302925x0++;
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopPrivilegeFlag(this, this.f302908g0.troopuin, this.f302918q0, 101711872L, new e());
    }

    private void Ji(int i3) {
        String string;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = this.U;
        if (i3 == 2) {
            string = getContext().getString(R.string.f1792238s);
        } else {
            string = getContext().getString(R.string.f1792338t);
        }
        xVar.U(new x.c.g(string, true, false));
        this.R.setConfig(this.U.K(), this.U.O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki(boolean z16) {
        if (z16) {
            this.R.setVisibility(0);
        } else {
            this.R.setVisibility(8);
        }
        this.f302915n0 = z16;
    }

    private void Kj() {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18 = true;
        ActionSheet create = ActionSheet.create(getContext(), -1, null, true);
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 10;
        } else {
            i3 = 0;
        }
        if (this.f302918q0 == 1048576) {
            z16 = true;
        } else {
            z16 = false;
        }
        create.addRadioButton(R.string.f1792338t, i3, z16);
        if (this.f302918q0 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        create.addRadioButton(R.string.f1792238s, i3, z17);
        if (this.f302918q0 != 67108864) {
            z18 = false;
        }
        create.addRadioButton(R.string.e0i, i3, z18);
        create.setOnButtonClickListener(new h(create));
        create.addCancelButton(R.string.cancel);
        create.show();
    }

    private void Li() {
        if (!this.f302908g0.isNewTroop()) {
            com.tencent.qqnt.troop.e eVar = new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.activity.ac
                @Override // com.tencent.qqnt.troop.e
                public final void onResult(boolean z16, int i3, String str) {
                    TroopSetJoinTypeActivity.this.Yi(z16, i3, str);
                }
            };
            int i3 = this.f302910i0;
            if (i3 == 3 && this.f302926y0 != 0 && this.f302911j0 != 3) {
                this.f302926y0 = 0;
                this.f302925x0++;
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopSearchType(this, this.f302905d0, this.f302926y0, eVar);
            } else if (i3 != 3 && this.f302926y0 == 0 && this.f302911j0 == 3) {
                this.f302927z0 = 0;
                this.f302926y0 = 2 - 0;
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopSearchType(this, this.f302905d0, this.f302926y0, eVar);
                this.f302925x0++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj(@NonNull String str) {
        if (this.f302925x0 <= 0) {
            qh(str);
        }
    }

    private void Mi() {
        int i3 = this.f302910i0;
        if (i3 == 4) {
            this.f302925x0++;
            String obj = this.F.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                obj = this.F.getHint().toString();
            }
            String trim = obj.trim();
            String trim2 = this.G.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                qh(getString(R.string.eqj));
                return;
            } else if (TextUtils.isEmpty(trim2)) {
                qh(getString(R.string.eqi));
                return;
            } else {
                sj(trim, trim2);
                return;
            }
        }
        if (i3 == 5) {
            this.f302925x0++;
            String obj2 = this.E.getText().toString();
            boolean isEmpty = TextUtils.isEmpty(obj2);
            String trim3 = obj2.trim();
            if (isEmpty) {
                trim3 = this.E.getHint().toString();
            } else if (TextUtils.isEmpty(trim3)) {
                this.W.D.setImageResource(R.drawable.bsz);
                this.W.E.setText(R.string.eqj);
                this.W.O();
                return;
            }
            sj(trim3, null);
            return;
        }
        if (Ui()) {
            tj(64, this.f302908g0.troopPrivilegeFlag & (-513), (short) this.f302910i0);
        } else {
            tj(1, this.f302908g0.troopPrivilegeFlag, (short) this.f302910i0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ni() {
        boolean z16 = this.f302917p0;
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getContext(), null);
        actionSheet.addRadioButton(R.string.f1792338t, z16);
        actionSheet.addRadioButton(R.string.f1792238s, !z16);
        actionSheet.addCancelButton(17039360);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.z
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopSetJoinTypeActivity.this.Zi(actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean Oi() {
        boolean z16;
        byte b16;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        this.f302904c0 = arguments.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "1");
        String string = arguments.getString("troop_uin");
        this.f302905d0 = string;
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "mTroopUin : " + this.f302905d0);
        }
        this.f302908g0 = ((ITroopInfoService) this.C.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(this.f302905d0);
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "mTroopInfo : " + this.f302908g0);
        }
        if (this.f302908g0.isOnlyTroopMemberInviteOption()) {
            this.f302920s0 = true;
            TroopInfo troopInfo = this.f302908g0;
            troopInfo.cGroupOption = (short) 2;
            troopInfo.setOnlyTroopMemberInviteOption(false);
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        this.f302909h0 = troopInfoData;
        troopInfoData.updateForTroopChatSetting(this.f302908g0, getResources(), this.C.getAccount());
        TroopInfoData troopInfoData2 = this.f302909h0;
        troopInfoData2.isMember = true;
        TroopInfo troopInfo2 = this.f302908g0;
        long j3 = troopInfo2.dwGroupFlagExt;
        troopInfoData2.nGroupFlagExt = (int) j3;
        short s16 = troopInfo2.cGroupOption;
        this.f302911j0 = s16;
        this.f302910i0 = s16;
        if ((j3 & 128) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f302913l0 = z16;
        this.f302912k0 = z16;
        long j16 = troopInfo2.troopPrivilegeFlag;
        if ((j16 & 1048576) == 1048576) {
            this.f302919r0 = 1048576L;
        } else if ((j16 & 101711872) == 0) {
            this.f302919r0 = 0L;
        } else {
            this.f302919r0 = 67108864L;
        }
        this.f302918q0 = this.f302919r0;
        if ((!troopInfo2.isNewTroop() || (this.f302908g0.hasSetTroopName() && this.f302908g0.hasSetTroopHead())) && this.f302908g0.mCanSearchByTroopUin) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            int i3 = !this.f302908g0.mCanSearchByKeywords ? 1 : 0;
            this.f302927z0 = i3;
            this.f302926y0 = 2 - i3;
        } else {
            this.f302926y0 = 0;
        }
        this.Y = ThemeUtil.isNowThemeIsNight(this.C, false, null);
        String string2 = arguments.getString("troopUinList", "");
        this.f302906e0 = string2;
        this.f302907f0 = Gi(string2);
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, " mOriginOption : " + this.f302911j0 + " mNewAllowMemberInvite : " + this.f302912k0 + " mOriginTroopInviteMode : " + this.f302919r0 + " mNewSearchwayOpt : " + this.f302926y0 + " mOriginJoinTypeIsOnlyInvite : " + this.f302920s0 + " mTroopUinList: " + this.f302907f0);
        }
        return true;
    }

    private void Oj() {
        TroopInfo troopInfo = this.f302908g0;
        long j3 = troopInfo.troopPrivilegeFlag;
        if ((j3 & 1048576) == 1048576) {
            this.f302918q0 = 1048576L;
        } else if ((j3 & 101711872) == 0) {
            this.f302918q0 = 0L;
        } else {
            this.f302918q0 = 67108864L;
        }
        ((TextView) this.N.findViewById(R.id.info)).setText(Fi(troopInfo, getResources()));
    }

    private void Pi() {
        short s16 = this.f302908g0.cGroupOption;
        this.B0 = s16;
        this.f302910i0 = s16;
        int i3 = 1;
        if (s16 != 1) {
            if (s16 != 2) {
                i3 = 5;
                if (s16 != 3) {
                    if (s16 != 4) {
                        if (s16 != 5) {
                            i3 = -1;
                        } else {
                            i3 = 2;
                        }
                    } else {
                        i3 = 3;
                    }
                }
            }
        } else {
            i3 = 0;
        }
        this.f302921t0 = i3;
        Nj(i3);
        Dj(false);
        String d16 = cw.d(getContext(), this.f302908g0.troopuin);
        if (!TextUtils.isEmpty(d16)) {
            this.G.setText(d16);
            EditText editText = this.G;
            editText.setSelection(editText.getText().length());
        }
        String troopQuestionFromSP = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(getContext(), this.f302908g0.troopuin);
        if (!TextUtils.isEmpty(troopQuestionFromSP)) {
            this.F.setText(troopQuestionFromSP);
            EditText editText2 = this.F;
            editText2.setSelection(editText2.getText().length());
            this.E.setText(troopQuestionFromSP);
            EditText editText3 = this.E;
            editText3.setSelection(editText3.getText().length());
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "initItems() mCurFocusViewId : " + this.f302921t0);
        }
        Qj();
    }

    private void Pj(boolean z16) {
        int i3;
        View view = this.N;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        FormSwitchItem formSwitchItem = (FormSwitchItem) this.M.findViewById(R.id.drj);
        if (z16) {
            formSwitchItem.setBgType(1);
        } else {
            formSwitchItem.setBgType(0);
        }
    }

    private boolean Qi() {
        if (this.f302908g0.groupExt.inviteRobotMemberSwitch != 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Qj() {
        int i3;
        FormSwitchItem formSwitchItem = (FormSwitchItem) this.M.findViewById(R.id.drj);
        Switch r16 = formSwitchItem.getSwitch();
        r16.setOnCheckedChangeListener(null);
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "updateInviteView() mCurFocusViewId : " + this.f302921t0 + " mLastFocusViewId : " + this.f302922u0 + " mIsSelectedInviteModeInNeedVerify : " + this.f302923v0 + " mNewAllowMemberInvite : " + this.f302912k0);
        }
        int i16 = this.f302921t0;
        if (i16 != 0) {
            if (i16 != 1 && i16 != 2 && i16 != 3) {
                if (i16 == 5) {
                    this.f302912k0 = false;
                }
            } else {
                formSwitchItem.setChecked(this.f302912k0);
                this.L.setVisibility(0);
                this.M.setVisibility(0);
                this.N.setEnabled(true);
                Pj(this.f302912k0);
                this.P.setVisibility(0);
                if (!this.f302923v0 && (i3 = this.f302922u0) != -1 && i3 != 1 && i3 != 2 && i3 != 3) {
                    this.f302912k0 = true;
                    formSwitchItem.setChecked(true);
                    Pj(true);
                    this.f302918q0 = 67108864L;
                    ((TextView) this.N.findViewById(R.id.info)).setText(getString(R.string.e0i));
                }
                if (!Ti() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101745", false)) {
                    this.S.setVisibility(0);
                }
            }
            if (!this.f302912k0) {
                this.P.setText(getString(R.string.f180683bq));
            } else {
                this.P.setText(getString(R.string.f180673bp));
            }
            r16.setOnCheckedChangeListener(this);
        }
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        Pj(false);
        this.N.setEnabled(true);
        this.P.setVisibility(8);
        this.f302923v0 = false;
        this.S.setVisibility(8);
        if (!this.f302912k0) {
        }
        r16.setOnCheckedChangeListener(this);
    }

    private boolean Ri() {
        return TroopInfo.hasPayPrivilege(this.f302908g0.troopPrivilegeFlag, 128);
    }

    private boolean Si() {
        if (this.f302908g0.groupExt.inviteRobotMemberExamine != 2) {
            return true;
        }
        return false;
    }

    private boolean Ti() {
        List<Long> list = this.f302907f0;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ui() {
        if (Ri() && Vi()) {
            return true;
        }
        return false;
    }

    private boolean Vi() {
        return TroopInfo.hasPayPrivilege(this.f302908g0.troopPrivilegeFlag, 512);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wi(Boolean bool, TroopInfo troopInfo) {
        xj(bool.booleanValue(), troopInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Xi(final Boolean bool, final TroopInfo troopInfo) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.activity.am
            @Override // java.lang.Runnable
            public final void run() {
                TroopSetJoinTypeActivity.this.Wi(bool, troopInfo);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yi(boolean z16, int i3, String str) {
        boolean z17;
        boolean z18 = true;
        this.f302925x0--;
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "onSetTroopSearchType: succ : " + z16 + " mNewSearchwayOpt : " + this.f302926y0);
        }
        if (z16) {
            TroopInfo troopInfo = this.f302908g0;
            int i16 = this.f302926y0;
            if (i16 > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            troopInfo.mCanSearchByTroopUin = z17;
            if (i16 != 2) {
                z18 = false;
            }
            troopInfo.mCanSearchByKeywords = z18;
        }
        zj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zi(ActionSheet actionSheet, View view, int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                Ji(2);
                this.f302917p0 = false;
                actionSheet.dismiss();
                return;
            }
            return;
        }
        Ji(1);
        this.f302917p0 = true;
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.E.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.F.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void cj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EditText editText = this.G;
        if (editText != null && this.f302902a0 != null) {
            editText.requestFocus();
            Editable text = this.G.getText();
            if (text != null) {
                this.G.setSelection(text.length());
            }
            this.f302902a0.showSoftInput(this.G, 0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dj(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.G.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ej(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        ITroopManageService iTroopManageService = this.D;
        String str2 = this.f302908g0.troopuin;
        if (this.f302909h0.bOwner) {
            str = "0";
        } else {
            str = "1";
        }
        iTroopManageService.reportClickEvent("dc00899", "Grp_manage", "", "grp_verification", "Clk_cancel", 0, 0, str2, str, "", "");
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void fj(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        ITroopManageService iTroopManageService = this.D;
        String str2 = this.f302908g0.troopuin;
        if (this.f302909h0.bOwner) {
            str = "0";
        } else {
            str = "1";
        }
        iTroopManageService.reportClickEvent("dc00899", "Grp_manage", "", "grp_verification", "Clk_confirm", 0, 0, str2, str, "" + Rj(this.f302921t0), "");
        if (Ti()) {
            Fj();
        } else {
            Ij();
        }
        Ai("em_group_confirm_btn", Ei());
        EventCollector.getInstance().onViewClicked(view);
    }

    private HashMap<String, Object> getReportPageParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("group_id", this.f302905d0);
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, this.f302904c0);
        hashMap.put("dt_pgid", "pg_group_set_add_way");
        hashMap.put("pgid", "pg_group_set_add_way");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void gj(String str, boolean z16, int i3, String str2) {
        this.f302925x0--;
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "onModifyOnlyTroopMemberInviteJoinTroop: succ : " + z16 + " troopUin : " + str);
        }
        if (this.f302908g0.troopuin.equalsIgnoreCase(str)) {
            if (z16) {
                this.f302908g0.setOnlyTroopMemberInviteOption(false);
            } else {
                this.X.e(2, getString(R.string.bxk), 1000);
            }
        }
        zj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hj(String str, boolean z16, int i3, String str2) {
        this.f302925x0--;
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "onModifyTroopJoinTroop: succ : " + z16 + " troopUin : " + str + " mSetSvrSucc : " + this.f302924w0 + " mNewOption : " + this.f302910i0 + " mTroopInfo.cGroupOption : " + ((int) this.f302908g0.cGroupOption));
        }
        if (this.f302905d0.equalsIgnoreCase(str)) {
            if (z16) {
                this.f302924w0 = true;
                this.f302908g0.cGroupOption = (short) this.f302910i0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopSetJoinTypeActivity", 2, str + ":" + str2);
                }
                Lj(getString(R.string.bxk));
            }
        }
        zj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ij(String str, boolean z16, int i3, String str2) {
        this.f302925x0--;
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "onModifyPayToJoinInfo: succ : " + z16 + " troopUin : " + str + " mNewOption : " + this.f302910i0 + " mTroopInfo.troopPrivilegeFlag : " + this.f302908g0.troopPrivilegeFlag);
        }
        if (this.f302908g0.troopuin.equalsIgnoreCase(str)) {
            if (z16) {
                this.f302924w0 = true;
                TroopInfo troopInfo = this.f302908g0;
                short s16 = (short) this.f302910i0;
                troopInfo.cGroupOption = s16;
                TroopInfoData troopInfoData = this.f302909h0;
                troopInfoData.cGroupOption = s16;
                long j3 = troopInfo.troopPrivilegeFlag & (-513);
                troopInfo.troopPrivilegeFlag = j3;
                troopInfo.dwAppPrivilegeFlag = j3;
                troopInfoData.mTroopPrivilegeFlag = (int) j3;
            } else {
                Lj(getString(R.string.f171409et2));
            }
        }
        zj();
    }

    private void initViews() {
        String string;
        this.W = new QQAnonymousDialog(getContext());
        ((QIphoneTitleBarFragment) this).mContentView.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        ((InputMethodLinearLayout) ((QIphoneTitleBarFragment) this).mContentView).setOrientation(1);
        ((InputMethodLinearLayout) ((QIphoneTitleBarFragment) this).mContentView).setOnSizeChangedListenner(this);
        BounceScrollView bounceScrollView = new BounceScrollView(getContext());
        bounceScrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        bounceScrollView.setFocusable(false);
        ((InputMethodLinearLayout) ((QIphoneTitleBarFragment) this).mContentView).addView(bounceScrollView);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        bounceScrollView.addView(linearLayout);
        setTitle(HardCodeUtil.qqStr(R.string.uqt));
        linearLayout.addView(View.inflate(getContext(), R.layout.b4b, null));
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.height = 1;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        View zi5 = zi(0, getString(R.string.i77));
        Mj(zi5, 1, true);
        linearLayout.addView(zi5);
        this.V[0] = zi5;
        View zi6 = zi(6, getString(R.string.i7a));
        Mj(zi6, 2, true);
        linearLayout.addView(zi6);
        this.V[6] = zi6;
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.K = linearLayout2;
        linearLayout.addView(linearLayout2);
        this.K.setOrientation(1);
        this.K.setVisibility(8);
        View zi7 = zi(1, getString(R.string.i7b));
        Mj(zi7, 2, true);
        this.K.addView(zi7);
        this.V[1] = zi7;
        View zi8 = zi(2, getString(R.string.i78));
        Mj(zi8, 2, true);
        this.K.addView(zi8);
        this.V[2] = zi8;
        View inflate = ((ViewStub) zi8.findViewById(R.id.h2b)).inflate();
        this.H = inflate;
        Mj(inflate, 2, true);
        EditText editText = (EditText) this.H.findViewById(R.id.btm);
        this.E = editText;
        editText.setOnEditorActionListener(this.D0);
        View findViewById = this.H.findViewById(R.id.ayh);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSetJoinTypeActivity.this.aj(view2);
            }
        });
        findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.uqv));
        this.E.setTag(findViewById);
        this.E.setHint(getString(R.string.i7_));
        this.E.setOnFocusChangeListener(this.C0);
        Jj(this.E);
        ((TextView) this.H.findViewById(R.id.title)).setText(getString(R.string.eqm));
        View zi9 = zi(3, getString(R.string.i79));
        Mj(zi9, 2, true);
        this.K.addView(zi9);
        this.V[3] = zi9;
        View inflate2 = ((ViewStub) zi9.findViewById(R.id.h2b)).inflate();
        this.I = inflate2;
        Mj(inflate2, 2, true);
        View findViewById2 = this.I.findViewById(R.id.ayh);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSetJoinTypeActivity.this.bj(view2);
            }
        });
        findViewById2.setContentDescription(HardCodeUtil.qqStr(R.string.uqs));
        EditText editText2 = (EditText) this.I.findViewById(R.id.btm);
        this.F = editText2;
        editText2.setOnEditorActionListener(this.D0);
        this.F.setOnFocusChangeListener(this.C0);
        this.F.setHint(getString(R.string.i7_));
        this.F.setTag(findViewById2);
        Jj(this.F);
        ((TextView) this.I.findViewById(R.id.title)).setText(R.string.eqm);
        View inflate3 = ((ViewStub) zi9.findViewById(R.id.f164347sk)).inflate();
        this.J = inflate3;
        Mj(inflate3, 2, true);
        this.J.findViewById(R.id.btl).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSetJoinTypeActivity.this.cj(view2);
            }
        });
        this.G = (EditText) this.J.findViewById(R.id.btm);
        View findViewById3 = this.J.findViewById(R.id.ayh);
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSetJoinTypeActivity.this.dj(view2);
            }
        });
        findViewById3.setContentDescription(HardCodeUtil.qqStr(R.string.uqu));
        this.G.setOnEditorActionListener(this.D0);
        this.G.setOnFocusChangeListener(this.C0);
        this.G.setTag(findViewById3);
        Jj(this.G);
        ((TextView) this.J.findViewById(R.id.title)).setText(R.string.eql);
        View zi10 = zi(5, getString(R.string.i7d));
        Mj(zi10, 3, true);
        linearLayout.addView(zi10);
        this.V[5] = zi10;
        TextView textView = new TextView(getContext());
        this.L = textView;
        textView.setTextAppearance(getContext(), R.style.aiu);
        this.L.setText(getString(R.string.f234797_x));
        this.L.setPadding(getResources().getDimensionPixelSize(R.dimen.akz), getResources().getDimensionPixelSize(R.dimen.f159486al0), getResources().getDimensionPixelSize(R.dimen.akz), getResources().getDimensionPixelSize(R.dimen.f159486al0));
        linearLayout.addView(this.L);
        View inflate4 = View.inflate(getContext(), R.layout.f168894b41, null);
        this.M = inflate4;
        FormSwitchItem formSwitchItem = (FormSwitchItem) inflate4.findViewById(R.id.drj);
        this.M.findViewById(R.id.dlo).setVisibility(8);
        formSwitchItem.setUseCardUIStyle(false);
        formSwitchItem.setText(HardCodeUtil.qqStr(R.string.ums));
        formSwitchItem.setContentDescription(HardCodeUtil.qqStr(R.string.umv));
        formSwitchItem.setBgType(1);
        formSwitchItem.setTag(8);
        formSwitchItem.getTextView().setTextSize(1, 18.0f);
        formSwitchItem.setFocusable(true);
        Switch r16 = formSwitchItem.getSwitch();
        r16.setTag(8);
        linearLayout.addView(this.M);
        r16.setOnCheckedChangeListener(this);
        this.N = View.inflate(getContext(), R.layout.b3y, null);
        String Fi = Fi(this.f302908g0, getResources());
        this.N.setTag(9);
        this.N.setOnClickListener(this);
        ((FormItemRelativeLayout) this.N).setUseCardUI(false);
        ((FormItemRelativeLayout) this.N).setBGType(3);
        TextView textView2 = (TextView) this.N.findViewById(R.id.title);
        textView2.setText(getString(R.string.i7l));
        textView2.setTextSize(17.0f);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.qui_list_symbol);
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.dac), getResources().getDimensionPixelSize(R.dimen.dac));
            textView2.setCompoundDrawables(drawable, null, null, null);
        }
        textView2.setCompoundDrawablePadding((int) (getResources().getDisplayMetrics().density * 12.0f));
        ((TextView) this.N.findViewById(R.id.info)).setText(Fi);
        linearLayout.addView(this.N);
        TextView textView3 = new TextView(getContext());
        this.P = textView3;
        textView3.setTextAppearance(getContext(), R.style.f173760jw);
        this.P.setPadding(getResources().getDimensionPixelSize(R.dimen.akz), getResources().getDimensionPixelSize(R.dimen.f159486al0), getResources().getDimensionPixelSize(R.dimen.akz), getResources().getDimensionPixelSize(R.dimen.f159486al0));
        linearLayout.addView(this.P);
        this.leftView.setContentDescription(getString(R.string.f181173d2));
        this.leftView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSetJoinTypeActivity.this.ej(view2);
            }
        });
        this.rightViewText.setText(R.string.f171151ok);
        this.rightViewText.setVisibility(0);
        this.rightViewText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopSetJoinTypeActivity.this.fj(view2);
            }
        });
        Ci("em_group_confirm_btn", Ei());
        this.X = new com.tencent.mobileqq.widget.ap(getQBaseActivity());
        this.T = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(getContext().getString(R.string.f1792538v)), new x.c.f(Qi(), new a()));
        x.b.C8996b c8996b = new x.b.C8996b(getContext().getString(R.string.f1792438u), R.drawable.qui_list_symbol);
        if (Si()) {
            string = getContext().getString(R.string.f1792338t);
        } else {
            string = getContext().getString(R.string.f1792238s);
        }
        this.U = new com.tencent.mobileqq.widget.listitem.x<>(c8996b, new x.c.g(string, true, false));
        View inflate5 = View.inflate(getContext(), R.layout.h6a, null);
        this.S = inflate5;
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) inflate5.findViewById(R.id.f769142y);
        this.Q = qUISingleLineListItem;
        qUISingleLineListItem.setConfig(this.T.K(), this.T.O());
        QUISingleLineListItem qUISingleLineListItem2 = this.Q;
        QUIListItemStyle qUIListItemStyle = QUIListItemStyle.FullWidth;
        qUISingleLineListItem2.setStyle(qUIListItemStyle);
        QUISingleLineListItem qUISingleLineListItem3 = (QUISingleLineListItem) this.S.findViewById(R.id.f775944s);
        this.R = qUISingleLineListItem3;
        qUISingleLineListItem3.setConfig(this.U.K(), this.U.O());
        this.R.setStyle(qUIListItemStyle);
        if (!Qi()) {
            this.R.setVisibility(8);
        }
        this.R.setOnClickListener(new b());
        this.f302914m0 = Qi();
        boolean Si = Si();
        this.f302916o0 = Si;
        this.f302915n0 = this.f302914m0;
        this.f302917p0 = Si;
        this.S.setVisibility(8);
        linearLayout.addView(this.S);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jj(View view, boolean z16) {
        if (view instanceof EditText) {
            Gj((EditText) view, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit kj(Boolean bool, TroopInfo troopInfo) {
        boolean z16;
        if (QLog.isColorLevel()) {
            long j3 = troopInfo.dwAppPrivilegeFlag;
            boolean z17 = true;
            if ((128 & j3) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((j3 & 512) == 0) {
                z17 = false;
            }
            QLog.d("TroopSetJoinTypeActivity", 2, "onGetPayToJoinTroopStatus succ : " + bool + " hasPayToJoinTroopPrivilege : " + z16 + " isPayToJoinTroop : " + z17 + " mCurFocusViewId : " + this.f302921t0 + " mLastFocusViewId : " + this.f302922u0);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lj(DialogInterface dialogInterface, int i3) {
        zj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mj(View view) {
        this.f302902a0.showSoftInput(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void nj(final View view, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        if (view != null) {
            view.requestFocus();
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                editText.setSelection(editText.getText().length());
            }
            qQCustomDialog.dismiss();
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troopmanage.activity.an
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSetJoinTypeActivity.this.mj(view);
                }
            }, 100L);
            return;
        }
        qQCustomDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit oj() {
        this.f302924w0 = true;
        if (isAdded() && getContext() != null) {
            rh(getString(R.string.f179883_k));
        }
        yj();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit pj(Integer num, String str) {
        if (isAdded() && getContext() != null) {
            Lj(getString(R.string.f179873_j));
        }
        yj();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void qj(HashMap hashMap, DialogInterface dialogInterface, int i3) {
        hashMap.put("btn_type", 0);
        Bi("em_group_set_confirm_pop", "ev_group_set_confirm_pop_clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void rj(HashMap hashMap, DialogInterface dialogInterface, int i3) {
        Hj();
        hashMap.put("btn_type", 1);
        Bi("em_group_set_confirm_pop", "ev_group_set_confirm_pop_clck", hashMap);
    }

    private void sj(String str, String str2) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyAnswerAndQuestion(this.f302908g0.troopuin, str, str2, this, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i3, long j3, short s16) {
        if (this.f302920s0) {
            this.f302925x0++;
            uj(this.f302909h0.troopUin, true, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "mOriginJoinTypeIsOnlyInvite : " + this.f302920s0 + " nModifyFlag : " + i3 + " nTroopPrivilegeFlag : " + j3 + " cGroupOption : " + ((int) s16));
        }
        if ((i3 & 255) == 0) {
            return;
        }
        if ((i3 & 64) > 0) {
            this.f302925x0++;
            wj(this.f302905d0, (int) j3, s16);
            return;
        }
        try {
            if (this.Z != null) {
                this.f302925x0++;
                vj(this.f302905d0, s16);
            }
        } catch (Exception e16) {
            QLog.e("TroopSetJoinTypeActivity", 1, "modifyTroopJoinTypeFlag e: " + e16);
        }
    }

    private boolean ui() {
        if (this.f302913l0 != this.f302912k0) {
            return true;
        }
        return false;
    }

    private void uj(final String str, boolean z16, boolean z17) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyOnlyTroopMemberInviteJoinTroop(this, str, z16, z17, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.activity.ae
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z18, int i3, String str2) {
                TroopSetJoinTypeActivity.this.gj(str, z18, i3, str2);
            }
        });
    }

    private boolean vi() {
        if (this.f302914m0 != this.f302915n0) {
            return true;
        }
        return false;
    }

    private void vj(final String str, short s16) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopJoinTypeFlag(this, str, s16, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.activity.af
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str2) {
                TroopSetJoinTypeActivity.this.hj(str, z16, i3, str2);
            }
        });
    }

    private boolean wi() {
        if (this.f302918q0 != this.f302919r0) {
            return true;
        }
        return false;
    }

    private void wj(final String str, int i3, short s16) {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopPayToJoinFlag(this, str, 512, i3 & 512, s16, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troopmanage.activity.ad
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i16, String str2) {
                TroopSetJoinTypeActivity.this.ij(str, z16, i16, str2);
            }
        });
    }

    private boolean xi() {
        if (this.f302916o0 != this.f302917p0) {
            return true;
        }
        return false;
    }

    private void xj(boolean z16, TroopInfo troopInfo) {
        if (z16 && troopInfo != null) {
            boolean z17 = true;
            QLog.d("TroopSetJoinTypeActivity", 1, "onSend0x88d_0_forJoinTroop_Ret succ: cGroupOption : " + ((int) troopInfo.cGroupOption) + " dwGroupFlagExt3 : " + troopInfo.dwGroupFlagExt3 + ", dwGroupFlagExt = " + troopInfo.dwGroupFlagExt + " troopPrivilegeFlag = " + troopInfo.troopPrivilegeFlag);
            TroopInfo troopInfo2 = this.f302908g0;
            troopInfo2.cGroupOption = troopInfo.cGroupOption;
            troopInfo2.joinTroopAnswer = troopInfo.joinTroopAnswer;
            String str = troopInfo.joinTroopQuestion;
            troopInfo2.joinTroopQuestion = str;
            troopInfo2.dwGroupFlagExt3 = troopInfo.dwGroupFlagExt3;
            troopInfo2.dwGroupFlagExt = troopInfo.dwGroupFlagExt;
            troopInfo2.troopPrivilegeFlag = troopInfo.troopPrivilegeFlag;
            if (!TextUtils.isEmpty(str)) {
                this.E.setText(this.f302908g0.joinTroopQuestion);
                this.F.setText(this.f302908g0.joinTroopQuestion);
            }
            if (!TextUtils.isEmpty(this.f302908g0.joinTroopAnswer)) {
                this.G.setText(this.f302908g0.joinTroopAnswer);
            }
            boolean z18 = this.f302912k0;
            TroopInfo troopInfo3 = this.f302908g0;
            if ((troopInfo3.dwGroupFlagExt & 128) != 0) {
                z17 = false;
            }
            this.f302912k0 = z17;
            if (this.B0 != troopInfo3.cGroupOption || z17 != z18) {
                Pi();
            }
            Oj();
        }
    }

    private boolean yi() {
        if (this.f302921t0 == 2) {
            String obj = this.E.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                obj = this.E.getHint().toString();
            }
            if (!obj.equals(this.f302908g0.joinTroopQuestion)) {
                return true;
            }
        }
        if (this.f302921t0 == 3) {
            String obj2 = this.F.getText().toString();
            String obj3 = this.G.getText().toString();
            if (!obj2.equals(this.f302908g0.joinTroopQuestion) || !obj3.equals(this.f302908g0.joinTroopAnswer)) {
                return true;
            }
        }
        if (this.f302911j0 != this.f302910i0) {
            return true;
        }
        return false;
    }

    private void yj() {
        String str;
        String str2;
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return;
        }
        int i3 = requireArguments().getInt("seq", -1);
        String string = requireArguments().getString("processName", "");
        if (TextUtils.isEmpty(string)) {
            str = "";
        } else {
            str = string;
        }
        int i16 = this.f302910i0;
        boolean z16 = this.f302924w0;
        if (TextUtils.isEmpty(this.f302906e0)) {
            str2 = "";
        } else {
            str2 = this.f302906e0;
        }
        SimpleEventBus.getInstance().dispatchEvent(new TroopManageSetJoinTypeResultEvent(i3, str, i16, z16, str2));
        qBaseActivity.finish();
        qBaseActivity.overridePendingTransition(0, R.anim.f154423k);
    }

    private View zi(int i3, String str) {
        View inflate = View.inflate(getContext(), R.layout.ajj, null);
        if (i3 == 0 || this.Y) {
            inflate.findViewById(R.id.jp7).setBackgroundDrawable(null);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            inflate.findViewById(R.id.axa).setVisibility(8);
        } else {
            inflate.findViewById(R.id.icon).setVisibility(4);
        }
        if (i3 != 6) {
            inflate.findViewById(R.id.f164472yw).setVisibility(8);
        }
        View findViewById = inflate.findViewById(R.id.jti);
        findViewById.setTag(Integer.valueOf(i3));
        findViewById.setOnClickListener(this);
        ((TextView) inflate.findViewById(R.id.title)).setText(str);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj() {
        QBaseActivity qBaseActivity;
        if (this.f302925x0 != 0 || (qBaseActivity = getQBaseActivity()) == null) {
            return;
        }
        if (this.f302909h0 == null) {
            qBaseActivity.setResult(0);
        } else {
            Intent intent = new Intent();
            intent.putExtra("onlyInvite", this.f302908g0.isOnlyTroopMemberInviteOption());
            intent.putExtra("cGroupOption", (int) this.f302908g0.cGroupOption);
            intent.putExtra("isSetFee", false);
            intent.putExtra("isSetSuccess", this.f302924w0);
            intent.putExtra("isCanSearchByTroopUin", this.f302908g0.mCanSearchByTroopUin);
            intent.putExtra("isCanSearchByKeywords", this.f302908g0.mCanSearchByKeywords);
            intent.putExtra("troop_uin", this.f302905d0);
            qBaseActivity.setResult(-1, intent);
        }
        qBaseActivity.finish();
        qBaseActivity.overridePendingTransition(0, R.anim.f154423k);
    }

    protected void Dj(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "refreshEditView() mCurFocusViewId : " + this.f302921t0 + " mLastFocusViewId : " + this.f302922u0 + " mOriginOption : " + this.f302911j0 + "mIsOpen : " + this.A0);
        }
        int i3 = this.f302921t0;
        int i16 = 8;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                int i17 = this.f302922u0;
                                if (i17 != 1 && i17 != 2 && i17 != 3) {
                                    this.K.setVisibility(0);
                                    this.f302922u0 = this.f302921t0;
                                    this.f302921t0 = 1;
                                    Nj(1);
                                    Dj(z16);
                                    return;
                                }
                                LinearLayout linearLayout = this.K;
                                if (linearLayout.getVisibility() == 8) {
                                    i16 = 0;
                                }
                                linearLayout.setVisibility(i16);
                                Nj(this.f302922u0);
                                return;
                            }
                            return;
                        }
                    } else {
                        this.H.setVisibility(8);
                        this.I.setVisibility(0);
                        this.J.setVisibility(0);
                        this.K.setVisibility(0);
                        if (z16) {
                            boolean isEmpty = TextUtils.isEmpty(this.f302908g0.joinTroopQuestion);
                            if ((this.f302911j0 != 4 && isEmpty) || this.A0) {
                                this.F.requestFocus();
                                this.f302902a0.showSoftInput(this.F, 0);
                                if (this.F.getText() != null) {
                                    EditText editText = this.F;
                                    editText.setSelection(editText.getText().length());
                                    return;
                                }
                                return;
                            }
                            this.f302902a0.hideSoftInputFromInputMethod(this.F.getWindowToken(), 0);
                            return;
                        }
                        this.f302902a0.hideSoftInputFromInputMethod(this.F.getWindowToken(), 0);
                        return;
                    }
                } else {
                    this.J.setVisibility(8);
                    this.I.setVisibility(8);
                    this.H.setVisibility(0);
                    this.K.setVisibility(0);
                    if (z16) {
                        boolean isEmpty2 = TextUtils.isEmpty(this.f302908g0.joinTroopQuestion);
                        if ((this.f302911j0 != 5 && isEmpty2) || this.A0) {
                            this.E.requestFocus();
                            this.f302902a0.showSoftInput(this.E, 0);
                            if (this.E.getText() != null) {
                                EditText editText2 = this.E;
                                editText2.setSelection(editText2.getText().length());
                                return;
                            }
                            return;
                        }
                        this.f302902a0.hideSoftInputFromWindow(this.E.getWindowToken(), 0);
                        return;
                    }
                    this.f302902a0.hideSoftInputFromWindow(this.E.getWindowToken(), 0);
                    return;
                }
            } else {
                this.J.setVisibility(8);
                this.I.setVisibility(8);
                this.H.setVisibility(8);
                this.K.setVisibility(0);
                return;
            }
        }
        this.K.setVisibility(8);
    }

    protected void Hj() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int i3 = this.f302910i0;
        String str3 = "";
        if (i3 == 4) {
            String obj = this.F.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                obj = this.F.getHint().toString();
            }
            str = obj.trim();
            str2 = this.G.getText().toString().trim();
            if (TextUtils.isEmpty(str)) {
                qh(getString(R.string.eqj));
                return;
            } else if (TextUtils.isEmpty(str2)) {
                qh(getString(R.string.eqi));
                return;
            }
        } else if (i3 != 5) {
            str = "";
            str2 = str;
        } else {
            String obj2 = this.E.getText().toString();
            boolean isEmpty = TextUtils.isEmpty(obj2);
            str = obj2.trim();
            if (isEmpty) {
                str = this.E.getHint().toString();
            } else if (TextUtils.isEmpty(str)) {
                this.W.D.setImageResource(R.drawable.bsz);
                this.W.E.setText(R.string.eqj);
                this.W.O();
                return;
            }
            str2 = "";
        }
        int i16 = this.f302910i0;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
        }
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e eVar = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e(i16, str, str3);
        TroopMultiGroupManageSvr$InviteMethod troopMultiGroupManageSvr$InviteMethod = new TroopMultiGroupManageSvr$InviteMethod();
        troopMultiGroupManageSvr$InviteMethod.allow_invite.set(this.f302912k0 ? 1 : 0);
        long j3 = this.f302918q0;
        if (j3 == 1048576) {
            troopMultiGroupManageSvr$InviteMethod.invite_type.set(0);
        } else if (j3 == 0) {
            troopMultiGroupManageSvr$InviteMethod.invite_type.set(1);
        } else if (j3 == 67108864) {
            troopMultiGroupManageSvr$InviteMethod.invite_type.set(2);
        }
        Ej(this.f302907f0, eVar, troopMultiGroupManageSvr$InviteMethod);
    }

    protected void Ij() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int i3 = 2;
        if (!ph()) {
            this.X.e(2, getString(R.string.b3j), 1000);
            return;
        }
        this.f302925x0 = 0;
        if (yi() && this.f302910i0 == 1) {
            this.f302912k0 = true;
            this.f302918q0 = 67108864L;
        }
        if (ui()) {
            Hi();
        }
        if (wi()) {
            Ii();
        }
        if (yi()) {
            Mi();
        }
        if (vi()) {
            Cj(this.f302915n0);
        }
        if (xi()) {
            if (this.f302917p0) {
                i3 = 1;
            }
            Bj(i3);
        }
        Li();
        zj();
    }

    void Jj(EditText editText) {
        editText.addTextChangedListener(new f(editText));
    }

    public void Mj(View view, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, view, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            if (view == null) {
                return;
            }
            view.setBackgroundDrawable(com.tencent.mobileqq.widget.o.h(view.getResources(), i3, z16, false));
        }
    }

    public void Nj(int i3) {
        View[] viewArr;
        int i16;
        boolean z16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        int i18 = 0;
        while (true) {
            viewArr = this.V;
            if (i18 >= viewArr.length) {
                break;
            }
            View view = viewArr[i18];
            if (view != null) {
                if (i18 == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i18 != 1 && i18 != 2 && i18 != 3) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.icon);
                    if (imageView != null) {
                        if (z16) {
                            i17 = 0;
                        } else {
                            i17 = 4;
                        }
                        imageView.setVisibility(i17);
                        if (z16) {
                            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.uqw));
                        } else {
                            imageView.setContentDescription(null);
                        }
                    }
                } else {
                    ((CheckBox) view.findViewById(R.id.axa)).setChecked(z16);
                    if (z16) {
                        this.F0 = i3;
                    }
                }
            }
            i18++;
        }
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            View findViewById = viewArr[6].findViewById(R.id.icon);
            findViewById.setVisibility(0);
            findViewById.setContentDescription(HardCodeUtil.qqStr(R.string.uqx));
        }
        if (i3 == 6) {
            View findViewById2 = this.V[i3].findViewById(R.id.f164472yw);
            float rotation = findViewById2.getRotation();
            if (this.E0) {
                i16 = -90;
            } else {
                i16 = 90;
            }
            findViewById2.setRotation(rotation + i16);
            this.E0 = !this.E0;
        }
    }

    protected int Rj(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (i3 == 0) {
            return 5;
        }
        if (i3 != 5) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return 2;
                }
                return 0;
            }
            return 1;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        if (!Oi()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopSetJoinTypeActivity", 2, "initData failed");
                return;
            }
            return;
        }
        this.f302902a0 = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        getQBaseActivity().getWindow().setSoftInputMode(18);
        initViews();
        Pi();
        this.f302903b0 = this.D.getTroopManageHandler();
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.Z = A;
        A.p();
        this.C.addObserver(this.G0);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopJoinType(this.f302905d0, true, "TroopSetJoinTypeActivity", this, new Function2() { // from class: com.tencent.mobileqq.troopmanage.activity.al
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit Xi;
                Xi = TroopSetJoinTypeActivity.this.Xi((Boolean) obj, (TroopInfo) obj2);
                return Xi;
            }
        });
        this.D.reportClickEvent("dc00899", "Grp_set_new", "", "Grp_manage", "exp_join", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("TroopSetJoinTypeActivity", 2, "doOnCreate succ");
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            Di(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.hzo;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            if (i3 == 8) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSetJoinTypeActivity", 2, "doOnActivityResult(): REQUEST_FOR_SET_PAY_TO_JOIN_TROOP succ");
                }
                ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopPayEnterStatus(this.f302908g0.troopuin, "TroopSetJoinTypeActivity", this, new Function2() { // from class: com.tencent.mobileqq.troopmanage.activity.ag
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit kj5;
                        kj5 = TroopSetJoinTypeActivity.this.kj((Boolean) obj, (TroopInfo) obj2);
                        return kj5;
                    }
                });
                return;
            }
            super.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.A0) {
            final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
            createCustomDialog.setTitle(R.string.f171377ej4);
            createCustomDialog.setMessage(R.string.eqk);
            final View currentFocus = getQBaseActivity().getWindow().getCurrentFocus();
            createCustomDialog.setPositiveButton(R.string.bvo, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.aj
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSetJoinTypeActivity.this.lj(dialogInterface, i3);
                }
            });
            createCustomDialog.setNegativeButton(R.string.f171032bu3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.activity.ak
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSetJoinTypeActivity.this.nj(currentFocus, createCustomDialog, dialogInterface, i3);
                }
            });
            createCustomDialog.show();
            return true;
        }
        if (Ti()) {
            yj();
        } else {
            zj();
        }
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        String str;
        String str2;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, compoundButton, Boolean.valueOf(z16));
        } else {
            Object tag = compoundButton.getTag();
            if ((tag instanceof Integer) && tag.equals(8)) {
                ITroopManageService iTroopManageService = this.D;
                if (z16) {
                    str = "Clk_open";
                } else {
                    str = "Clk_close";
                }
                String str3 = str;
                String str4 = this.f302908g0.troopuin;
                if (this.f302909h0.bOwner) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                iTroopManageService.reportClickEvent("dc00899", "Grp_manage", "", "invite", str3, 0, 0, str4, str2, "", "");
                this.f302912k0 = z16;
                View view = this.N;
                if (view != null) {
                    view.setEnabled(true);
                    Pj(z16);
                }
                if (this.f302912k0) {
                    this.P.setText(getString(R.string.f180683bq));
                } else {
                    this.P.setText(getString(R.string.f180673bp));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopSetJoinTypeActivity", 2, "onCheckedChanged : mNewAllowMemberInvite : " + this.f302912k0 + " mCurFocusViewId : " + this.f302921t0);
                }
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 6) {
                intValue = this.F0;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopSetJoinTypeActivity", 2, "onClick() mCurFocusViewId : " + this.f302921t0 + " mLastFocusViewId : " + this.f302922u0 + " nTag : " + intValue);
            }
            if (intValue == 9) {
                Kj();
            } else {
                int i16 = this.f302921t0;
                if (i16 != intValue) {
                    if (i16 == 5) {
                        TroopInfo troopInfo = this.f302908g0;
                        if (troopInfo.cGroupOption != 3 && ((i3 = troopInfo.troopTypeExt) == 2 || i3 == 3 || i3 == 4)) {
                            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
                            createCustomDialog.setMessage(getString(R.string.f171406es3));
                            createCustomDialog.setPositiveButton(getString(R.string.ibr), new DialogUtil.DialogOnClickAdapter());
                            createCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
                            createCustomDialog.show();
                        }
                    }
                    this.f302922u0 = i16;
                    this.f302921t0 = intValue;
                    if (intValue != 0) {
                        if (intValue != 1) {
                            if (intValue != 2) {
                                if (intValue != 3) {
                                    if (intValue == 5) {
                                        this.f302910i0 = 3;
                                    }
                                } else {
                                    this.f302910i0 = 4;
                                }
                            } else {
                                this.f302910i0 = 5;
                            }
                        } else {
                            this.f302910i0 = 2;
                        }
                    } else {
                        this.f302910i0 = 1;
                    }
                    if (intValue != 2 && intValue != 3) {
                        this.f302902a0.hideSoftInputFromWindow(this.E.getWindowToken(), 0);
                    }
                    Dj(true);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopSetJoinTypeActivity", 2, "onClick(): mCurFocusViewId : " + this.f302921t0 + " mLastFocusViewId : " + this.f302922u0);
                    }
                    Nj(this.f302921t0);
                    Qj();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.Z.q();
        this.C.removeObserver(this.G0);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.guild.widget.qqui.InputMethodLinearLayout.a
    public void onSizeChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        this.A0 = z16;
        if (!z16) {
            this.E.clearFocus();
            this.G.clearFocus();
            this.F.clearFocus();
        }
    }
}
