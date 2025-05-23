package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardSendHongBaoOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected int f210866d;

    /* renamed from: e, reason: collision with root package name */
    private String f210867e;

    /* renamed from: f, reason: collision with root package name */
    int f210868f;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f210869d;

        a(QQCustomDialog qQCustomDialog) {
            this.f210869d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSendHongBaoOption.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            this.f210869d.dismiss();
            ForwardSendHongBaoOption.this.mActivity.setResult(-1);
            ForwardSendHongBaoOption.this.mActivity.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f210871d;

        b(QQCustomDialog qQCustomDialog) {
            this.f210871d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSendHongBaoOption.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ForwardSendHongBaoOption.this.realForwardTo();
                this.f210871d.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f210873d;

        c(QQCustomDialog qQCustomDialog) {
            this.f210873d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSendHongBaoOption.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                this.f210873d.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialog f210875d;

        d(QQCustomDialog qQCustomDialog) {
            this.f210875d = qQCustomDialog;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSendHongBaoOption.this, (Object) qQCustomDialog);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            this.f210875d.dismiss();
            ForwardSendHongBaoOption.this.mActivity.setResult(-1);
            ForwardSendHongBaoOption.this.mActivity.finish();
        }
    }

    public ForwardSendHongBaoOption(Intent intent) {
        super(intent);
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.f210867e = null;
        this.f210868f = 5;
        this.f210866d = intent.getIntExtra(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, 273);
        if (intent.hasExtra("title")) {
            str = intent.getStringExtra("title");
        } else {
            str = "";
        }
        this.f210867e = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (allowDiscussAbility() && (this.f210866d & 256) > 0) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility() && (this.f210866d & 16) > 0) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility() && (this.f210866d & 1) > 0) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null) {
                if (Utils.J(recentUser.uin) || recentUser.getType() == 10004 || ((recentUser.getType() == 0 && CrmUtils.v(this.app, recentUser.uin, recentUser.getType())) || ((recentUser.getType() == 1 && isHotChat(recentUser.uin)) || (recentUser.getType() != 0 && recentUser.getType() != 1 && recentUser.getType() != 3000)))) {
                    if (recentUser.getType() == 1004 || recentUser.getType() == 1000) {
                        if (this.mSurpportTroopDiscussionTmpConv) {
                        }
                    }
                }
                if ((recentUser.getType() == 0 && isSupportAbility(e.O3)) || ((recentUser.getType() == 1 && isSupportAbility(e.P3)) || (recentUser.getType() == 3000 && isSupportAbility(e.Q3)))) {
                    arrayList.add(recentUser);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (TextUtils.isEmpty(this.f210867e)) {
            return super.getTitle();
        }
        return this.f210867e;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9 A[Catch: JSONException -> 0x0163, TryCatch #0 {JSONException -> 0x0163, blocks: (B:12:0x0058, B:14:0x0069, B:16:0x006f, B:18:0x007e, B:19:0x0093, B:21:0x009a, B:23:0x00a3, B:24:0x00bd, B:26:0x00f9, B:28:0x0105, B:30:0x010f, B:31:0x0113, B:33:0x0118, B:35:0x0146, B:42:0x00d2), top: B:11:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        hideProgressDialog();
        String stringExtra = intent.getStringExtra("result");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_SEND_HONG_BAO, 2, "ForwardOperations.onActivityResult_sendHongBao(). result_from_cai_fu_tong_SDK=" + stringExtra);
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            if (jSONObject.has(QzoneIPCModule.RESULT_CODE)) {
                int i17 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                if (i17 == 0) {
                    String string = this.mExtraData.getString("invoke_from");
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_SEND_HONG_BAO, 2, "ForwardOperations.onActivityResult_sendHongBao(). from=" + string);
                    }
                    if (!TextUtils.isEmpty(string) && string.equals("qwallet")) {
                        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mActivity), null);
                        m3.putExtras(this.mExtraData);
                        this.mActivity.startActivity(m3);
                        this.mActivity.setResult(-1);
                    }
                    this.mActivity.setResult(-1);
                    this.mActivity.finish();
                } else if (i17 == 66201004 || i17 == 66209015) {
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.mActivity, 230, HardCodeUtil.qqStr(R.string.mqj), this.mActivity.getString(R.string.bce), null, null);
                    createCustomDialog.setNegativeButton(R.string.button_back, new a(createCustomDialog));
                    createCustomDialog.show();
                }
                if (!z16) {
                    String string2 = this.mActivity.getString(R.string.bce);
                    if (jSONObject.has("retmsg") && !TextUtils.isEmpty(jSONObject.getString("retmsg"))) {
                        string2 = jSONObject.getString("retmsg");
                    }
                    String str = string2;
                    int i18 = this.f210868f;
                    if (i18 > 0) {
                        this.f210868f = i18 - 1;
                        QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(this.mActivity, 230, HardCodeUtil.qqStr(R.string.mql), str, null, null);
                        createCustomDialog2.setPositiveButton(R.string.f170970bc4, new b(createCustomDialog2));
                        createCustomDialog2.setNegativeButton(R.string.cancel, new c(createCustomDialog2));
                        createCustomDialog2.show();
                        return;
                    }
                    QQCustomDialog createCustomDialog3 = DialogUtil.createCustomDialog(this.mActivity, 230, HardCodeUtil.qqStr(R.string.mq8), str, null, null);
                    createCustomDialog3.setNegativeButton(R.string.button_back, new d(createCustomDialog3));
                    createCustomDialog3.show();
                    return;
                }
                return;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show(this.mActivity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("listid", this.mExtraData.getString("hb_id"));
                jSONObject2.put("send_uin", this.mExtraData.getString("send_uin"));
                jSONObject2.put("hb_type", Integer.parseInt(this.mExtraData.getString("hb_type")));
                int i3 = this.mExtraData.getInt("uintype");
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 == 3000) {
                            jSONObject2.put("recv_type", 2);
                            jSONObject2.put("group_id", this.mExtraData.getString("uin"));
                        }
                    } else {
                        jSONObject2.put("recv_type", 3);
                        jSONObject2.put("group_id", this.mExtraData.getString("uin"));
                    }
                } else {
                    jSONObject2.put("recv_type", 1);
                }
                jSONObject2.put("recv_uin", this.mExtraData.getString("uin"));
                jSONObject2.put("appid", String.valueOf(AppSetting.f()));
                jSONObject2.put("from_memo", this.app.getCurrentNickname());
                jSONObject.put("userId", this.app.getCurrentAccountUin());
                jSONObject.put(HippyHeaderListViewController.VIEW_TAG, "qpay_hb_share");
                jSONObject.put("extra_data", jSONObject2);
            } catch (Exception unused) {
            }
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
            bundle.putString("callbackSn", "0");
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_SEND_HONG_BAO, 2, "ForwardOperations.forwardTo(). passed data=" + bundle.toString());
            }
            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(this.mActivity);
            payBridgeIntent.putExtras(bundle);
            payBridgeIntent.putExtra("pay_requestcode", 5);
            this.mActivity.startActivityForResult(payBridgeIntent, 20002);
            showProgressDialog(R.string.bc5);
        }
        return true;
    }
}
