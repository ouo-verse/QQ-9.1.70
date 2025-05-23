package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.ark.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.aw;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qqfav.QfavHelper;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardQFavBatchOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    boolean f210776d;

    /* renamed from: e, reason: collision with root package name */
    boolean f210777e;

    public ForwardQFavBatchOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.f210776d = false;
            this.f210777e = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Intent intent, Bundle bundle, String str, String str2, String str3, int i3, int i16, String str4, int i17) {
        com.tencent.mobileqq.shortvideo.v b16 = com.tencent.mobileqq.shortvideo.h.b(3, 2);
        intent.putExtras(bundle);
        com.tencent.mobileqq.shortvideo.p a16 = com.tencent.mobileqq.shortvideo.l.a(2, intent, b16);
        a16.f288043f = this.mExtraData.getString("uin");
        a16.f288044g = this.mExtraData.getString("troop_uin");
        a16.f288041d = this.mExtraData.getInt("uintype");
        a16.f288040c = 2;
        a16.I = i16;
        b16.d(a16);
        com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
        fVar.r(fVar.c(a16.f288041d, a16.f288043f, a16.f288044g), a16.f288204r);
        cooperation.qqfav.d.c(this.app, "User_Forward", 5, 0, i17);
    }

    private String B(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString(AppConstants.Key.FORWARD_EXTRA);
        int i3 = bundle.getInt("qfavType");
        if (i3 == 5 || i3 == 8 || i3 == 2) {
            if (string == null) {
                string = bundle.getString(AppConstants.Key.FORWARD_EXTRA);
            }
            if (string == null) {
                string = bundle.getString(AppConstants.Key.FORWARD_FILEPATH);
            }
            if (string == null) {
                return bundle.getString("GALLERY.FORWORD_LOCAL_PATH");
            }
            return string;
        }
        return string;
    }

    private boolean C(byte[] bArr, String str, String str2, String str3, int i3, int i16) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(new String(bArr)).optJSONObject("arkAppInfo");
            if (optJSONObject == null) {
                return false;
            }
            String optString = optJSONObject.optString("appName");
            String optString2 = optJSONObject.optString("appDesc");
            String optString3 = optJSONObject.optString(QQCustomArkDialogUtil.APP_MIN_VERSION, Constants.DEFAULT_MIN_APP_VERSION);
            String optString4 = optJSONObject.optString(QQCustomArkDialogUtil.APP_VIEW);
            String optString5 = optJSONObject.optString("appConfig");
            ArkAppMessage arkAppMessage = new ArkAppMessage(optJSONObject.optString(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT), optString, optString2, optString4, optString3, optJSONObject.optString(QQCustomArkDialogUtil.META_DATA), optString5, "");
            try {
                ArkAppMessage arkAppMessage2 = (ArkAppMessage) com.tencent.mobileqq.ark.e.a(2, optString, this.mExtraData, arkAppMessage);
                if (arkAppMessage2 != null) {
                    arkAppMessage = arkAppMessage2;
                }
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179557e = str2;
                sessionInfo.f179563i = str;
                sessionInfo.f179555d = i3;
                sessionInfo.f179559f = str3;
                arkAppMessage.forwardID = i16;
                com.tencent.mobileqq.forward.utils.f.f211079a.g(sessionInfo, arkAppMessage);
                return true;
            } catch (JSONException e16) {
                e = e16;
                e.printStackTrace();
                return false;
            }
        } catch (JSONException e17) {
            e = e17;
        }
    }

    private boolean D(byte[] bArr, String str, String str2, String str3, int i3, int i16) {
        if (bArr != null && bArr.length > 0) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                ArkAppMessage arkAppMessage = new ArkAppMessage(jSONObject.optString("prompt"), jSONObject.optString("app"), "", jSONObject.optString("view"), jSONObject.optString("ver"), jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME), jSONObject.optString(DownloadInfo.spKey_Config), "");
                SessionInfo sessionInfo = new SessionInfo();
                sessionInfo.f179557e = str2;
                sessionInfo.f179563i = str;
                sessionInfo.f179555d = i3;
                sessionInfo.f179559f = str3;
                arkAppMessage.forwardID = i16;
                com.tencent.mobileqq.forward.utils.f.f211079a.g(sessionInfo, arkAppMessage);
                return true;
            } catch (JSONException unused) {
                QLog.e("ForwardOption.ForwardQFavBatchOption", 1, "sendProfileCardArkMsg is error!");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bundle bundle, int i3) {
        String string = this.mExtraData.getString("uin");
        int i16 = this.mExtraData.getInt("uintype");
        FileManagerEntity m3 = QfavHelper.m(bundle, this.mExtraData.getString("uin"), this.mExtraData.getInt("uintype"));
        if (m3 == null) {
            return;
        }
        this.app.getFileManagerEngine().C0(m3, string, "", i16, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Bundle bundle, String str, String str2, String str3, int i3, int i16, String str4, int i17) {
        if (cooperation.qqfav.util.a.c()) {
            cooperation.qqfav.util.a.d(this.app, this.mActivity, bundle.getString("uuid"), str2, i3, str3);
        } else {
            SessionInfo sessionInfo = new SessionInfo();
            sessionInfo.f179557e = str2;
            sessionInfo.f179563i = str;
            sessionInfo.f179555d = i3;
            sessionInfo.f179559f = str3;
            String string = bundle.getString(QCircleSchemeAttr.Polymerize.LAT);
            String string2 = bundle.getString("lon");
            String string3 = bundle.getString("title");
            String string4 = bundle.getString("address");
            this.mExtraData.putInt("isArk", 1);
            ChatActivityFacade.S(this.mActivity, this.app, sessionInfo, string, string2, string4, string3, string4, null, "", "", "", this.mExtraData);
        }
        cooperation.qqfav.d.c(this.app, "User_Forward", 7, 0, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Bundle bundle, int i3, String str, String str2, int i16, int i17, String str3, int i18) {
        String string = bundle.getString(AppConstants.Key.FORWARD_FILEPATH);
        if (string == null) {
            string = "";
        }
        ThreadManagerV2.post(new Runnable(string, str, i16, str2, i17) { // from class: com.tencent.mobileqq.forward.ForwardQFavBatchOption.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f210788d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f210789e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f210790f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f210791h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f210792i;

            {
                this.f210788d = string;
                this.f210789e = str;
                this.f210790f = i16;
                this.f210791h = str2;
                this.f210792i = i17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ForwardQFavBatchOption.this, string, str, Integer.valueOf(i16), str2, Integer.valueOf(i17));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ForwardQFavBatchOption forwardQFavBatchOption = ForwardQFavBatchOption.this;
                    ForwardSendPicUtil.b(forwardQFavBatchOption.app, this.f210788d, 0, this.f210789e, this.f210790f, this.f210791h, false, forwardQFavBatchOption.mActivity, this.f210792i);
                }
            }
        }, 8, null, false);
        cooperation.qqfav.d.c(this.app, "User_Forward", 3, 0, i18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d6, code lost:
    
        if (r10 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(Bundle bundle, int i3, String str, String str2, int i16, int i17, String str3, int i18) {
        boolean D;
        boolean z16;
        int i19;
        int i26;
        String str4;
        String str5;
        AbsStructMsg g16;
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, BaseApplication.getContext().getString(R.string.b4_));
        bundle.putString("app_name", BaseApplication.getContext().getString(R.string.b48));
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, "qqfav://operation/2");
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 133);
        boolean z17 = bundle.getBoolean("bFriendCard", false);
        boolean z18 = bundle.getBoolean("bNameplateArkFav", false);
        byte[] byteArray = bundle.getByteArray("sBizDataList");
        boolean z19 = true;
        if (i3 == 6) {
            int i27 = bundle.getInt("nLinkType");
            if (i27 != 4 && i27 != 5) {
                if (i27 != 6 && i27 != 7) {
                    if (i27 == 8) {
                        D = C(byteArray, str, str, str2, i16, i17);
                        z16 = false;
                    }
                    D = false;
                    z16 = false;
                }
                D = false;
                z16 = true;
            } else {
                ArkAppMessage arkAppMessage = new ArkAppMessage();
                arkAppMessage.fromAppXml(new String(byteArray));
                MessageForArkApp u16 = com.tencent.mobileqq.service.message.q.u(this.app, str, str2, i16, arkAppMessage);
                com.tencent.mobileqq.activity.aio.forward.b d16 = com.tencent.mobileqq.activity.aio.forward.b.d();
                long j3 = u16.uniseq;
                d16.e(j3, j3, i17);
                com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
                fVar.g(fVar.c(i16, str, str2), arkAppMessage);
                z16 = false;
                D = true;
            }
        } else if (z18) {
            D = D(byteArray, str, str, str2, i16, i17);
            z16 = false;
        } else {
            if (z17) {
            }
            D = false;
            z16 = false;
        }
        if (!D && z16 && byteArray != null && (g16 = com.tencent.mobileqq.structmsg.i.g(byteArray, 0)) != null) {
            QQAppInterface qQAppInterface = this.app;
            int i28 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i28 + 1;
            i19 = i18;
            i26 = i16;
            str5 = str;
            MessageForStructing A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, str3, str, str2, i16, i28, g16);
            com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, g16.uniseq, i17);
            com.tencent.mobileqq.forward.utils.f fVar2 = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar2.q(fVar2.c(i26, str5, str2), A);
            str4 = str2;
        } else {
            i19 = i18;
            i26 = i16;
            str4 = str2;
            str5 = str;
            z19 = D;
        }
        if (!z19) {
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle);
            QQAppInterface qQAppInterface2 = this.app;
            int i29 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i29 + 1;
            MessageForStructing A2 = com.tencent.mobileqq.service.message.q.A(qQAppInterface2, str3, str, str2, i16, i29, e16);
            com.tencent.mobileqq.activity.aio.forward.b.d().e(A2.uniseq, e16.uniseq, i17);
            com.tencent.mobileqq.forward.utils.f fVar3 = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar3.q(fVar3.c(i26, str5, str4), A2);
        }
        if (i3 == 8) {
            cooperation.qqfav.d.c(this.app, "User_Forward", 8, 0, i19);
        } else {
            cooperation.qqfav.d.c(this.app, "User_Forward", 2, 0, i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Bundle bundle, int i3, String str, String str2, int i16, int i17, String str3, int i18) {
        int i19;
        int i26;
        int i27;
        boolean z16;
        int i28;
        int i29;
        int i36;
        boolean z17;
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, BaseApplication.getContext().getString(R.string.b4_));
        bundle.putString("app_name", BaseApplication.getContext().getString(R.string.b48));
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "plugin");
        bundle.putString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, "qqfav://operation/2");
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, 133);
        boolean z18 = bundle.getBoolean("bNameplateArkFav", false);
        byte[] byteArray = bundle.getByteArray("sBizDataList");
        if (i3 == 6) {
            int i37 = bundle.getInt("nLinkType");
            if (i37 != 4 && i37 != 5) {
                if (i37 == 8) {
                    i28 = 2;
                    i29 = 0;
                    i36 = i18;
                    z17 = C(byteArray, str, str, str2, i16, i17);
                } else if (i37 != 6 && i37 != 7) {
                    String string = bundle.getString("detail_url");
                    String string2 = bundle.getString("title");
                    if (TextUtils.isEmpty(string2)) {
                        string2 = "[\u6807\u9898\u4e3a\u7a7a]";
                    }
                    if (TextUtils.isEmpty(string)) {
                        QLog.e("ForwardOption.ForwardQFavBatchOption", 1, "forwardRichMediaAndLinkByArk url is empty");
                        return;
                    }
                    String format = String.format("%s\n%s", string2, string);
                    i28 = 2;
                    i29 = 0;
                    i36 = i18;
                    com.tencent.mobileqq.service.message.q.B(this.app, str3, str, str2, i16, (byte) 1, (byte) 0, (short) 0, format);
                    if (this.app.getMessageFacade() != null) {
                        com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
                        fVar.i(fVar.c(i16, str, str2), format);
                    }
                } else {
                    i28 = 2;
                    i29 = 0;
                    i36 = i18;
                    z17 = false;
                }
                i26 = i29;
                i27 = i28;
                z16 = z17;
                i19 = i36;
            } else {
                i28 = 2;
                i29 = 0;
                i36 = i18;
                ArkAppMessage arkAppMessage = new ArkAppMessage();
                arkAppMessage.fromAppXml(new String(byteArray));
                MessageForArkApp u16 = com.tencent.mobileqq.service.message.q.u(this.app, str, str2, i16, arkAppMessage);
                com.tencent.mobileqq.activity.aio.forward.b d16 = com.tencent.mobileqq.activity.aio.forward.b.d();
                long j3 = u16.uniseq;
                d16.e(j3, j3, i17);
                com.tencent.mobileqq.forward.utils.f fVar2 = com.tencent.mobileqq.forward.utils.f.f211079a;
                fVar2.g(fVar2.c(i16, str, str2), arkAppMessage);
            }
            z17 = true;
            i26 = i29;
            i27 = i28;
            z16 = z17;
            i19 = i36;
        } else if (z18) {
            i19 = i18;
            i26 = 0;
            i27 = 2;
            z16 = D(byteArray, str, str, str2, i16, i17);
        } else {
            i19 = i18;
            i26 = 0;
            i27 = 2;
            z16 = false;
        }
        if (!z16) {
            cooperation.qqfav.util.a.d(this.app, this.mActivity, bundle.getString("uuid"), str, i16, str2);
        }
        if (i3 == 8) {
            cooperation.qqfav.d.c(this.app, "User_Forward", 8, i26, i19);
        } else {
            cooperation.qqfav.d.c(this.app, "User_Forward", i27, i26, i19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bundle bundle, int i3, String str, String str2, int i16, int i17, String str3, int i18) {
        String string = bundle.getString("text");
        if (string == null) {
            string = "";
        }
        com.tencent.mobileqq.service.message.q.B(this.app, str3, str, str2, i16, (byte) 1, (byte) 0, (short) 0, string);
        if (this.app.getMessageFacade() != null) {
            com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar.i(fVar.c(i16, str, str2), string);
        }
        cooperation.qqfav.d.c(this.app, "User_Forward", 1, 0, i18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bundle bundle, int i3) {
        String str = AppConstants.DATALINE_PC_UIN;
        FileManagerEntity m3 = QfavHelper.m(bundle, str, 7);
        if (m3 == null) {
            return;
        }
        this.app.getFileManagerEngine().C0(m3, str, "", 6000, i3);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected void addOtherEditListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.f210776d) {
            addImageEditListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.mConfirmDialog.setMessageWithEmo(this.mForwardText, this.mDensity);
        TextView messageTextView = this.mConfirmDialog.getMessageTextView();
        ViewGroup.LayoutParams layoutParams = messageTextView.getLayoutParams();
        layoutParams.width = -1;
        messageTextView.setLayoutParams(layoutParams);
        messageTextView.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        Bundle bundle;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.buildForwardAbility();
        ArrayList parcelableArrayListExtra = this.mIntent.getParcelableArrayListExtra("bundleList");
        boolean z16 = true;
        if (parcelableArrayListExtra != null) {
            boolean z17 = true;
            for (int i16 = 0; i16 < parcelableArrayListExtra.size(); i16++) {
                if (((Bundle) parcelableArrayListExtra.get(i16)).getInt("qfavType") != 3) {
                    z17 = false;
                }
            }
            if (parcelableArrayListExtra.size() != 1 || (((i3 = (bundle = (Bundle) parcelableArrayListExtra.get(0)).getInt("qfavType")) != 5 && i3 != 8 && i3 != 2) || !bundle.getBoolean("k_dataline", false))) {
                z16 = z17;
            }
        }
        if (z16) {
            this.mForwardAbilities.add(e.S3);
            this.mIntent.putExtra("isJumpAIO", false);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void forwardToTarget() {
        int i3;
        ArrayList arrayList;
        Intent intent;
        String str;
        String str2;
        String str3;
        int i16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        String string = this.mExtraData.getString("troop_uin");
        String string2 = this.mExtraData.getString("uin");
        String string3 = this.mExtraData.getString("uinname");
        int i17 = this.mExtraData.getInt("uintype");
        Intent intent2 = new Intent();
        int i18 = 0;
        boolean booleanExtra = this.mIntent.getBooleanExtra("needStartChatActivity", false);
        intent2.putExtra("needStartChatActivity", booleanExtra);
        if (booleanExtra) {
            intent2 = BaseAIOUtils.m(intent2, null);
            intent2.putExtras(this.mExtraData);
        }
        int i19 = 1;
        this.mActivity.getIntent().putExtra("isFromFavorites", true);
        this.mActivity.setResult(-1, intent2);
        this.mActivity.finish();
        Intent intent3 = new Intent(intent2);
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (this.mIntent.getBooleanExtra("forwardFromAIO", false)) {
            i19 = 2;
        }
        int i26 = i19;
        ArrayList parcelableArrayListExtra = this.mIntent.getParcelableArrayListExtra("bundleList");
        int i27 = this.mExtraData.getInt("KEY_MSG_FORWARD_ID");
        int i28 = 0;
        while (i28 < parcelableArrayListExtra.size()) {
            Bundle bundle = (Bundle) parcelableArrayListExtra.get(i28);
            if (bundle != null) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                str = string;
                str2 = string2;
                i3 = i28;
                arrayList = parcelableArrayListExtra;
                intent = intent3;
                String str4 = string3;
                str3 = string3;
                i16 = i18;
                Runnable runnable = new Runnable(bundle, string2, string, i17, i27, currentAccountUin, i26, str4, intent) { // from class: com.tencent.mobileqq.forward.ForwardQFavBatchOption.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int C;
                    final /* synthetic */ String D;
                    final /* synthetic */ Intent E;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Bundle f210778d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f210779e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f210780f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f210781h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f210782i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ String f210783m;

                    {
                        this.f210778d = bundle;
                        this.f210779e = string2;
                        this.f210780f = string;
                        this.f210781h = i17;
                        this.f210782i = i27;
                        this.f210783m = currentAccountUin;
                        this.C = i26;
                        this.D = str4;
                        this.E = intent;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ForwardQFavBatchOption.this, bundle, string2, string, Integer.valueOf(i17), Integer.valueOf(i27), currentAccountUin, Integer.valueOf(i26), str4, intent);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        int i29 = this.f210778d.getInt("qfavType");
                        switch (i29) {
                            case 1:
                                ForwardQFavBatchOption.this.y(this.f210778d, i29, this.f210779e, this.f210780f, this.f210781h, this.f210782i, this.f210783m, this.C);
                                return;
                            case 2:
                                ForwardQFavBatchOption.this.v(this.f210778d, i29, this.f210779e, this.f210780f, this.f210781h, this.f210782i, this.f210783m, this.C);
                                return;
                            case 3:
                                ForwardQFavBatchOption.this.t(this.f210778d, this.f210782i);
                                return;
                            case 4:
                            default:
                                return;
                            case 5:
                                ForwardQFavBatchOption.this.A(this.E, this.f210778d, this.D, this.f210779e, this.f210780f, this.f210781h, this.f210782i, this.f210783m, this.C);
                                return;
                            case 6:
                            case 8:
                                if (cooperation.qqfav.util.a.c()) {
                                    ForwardQFavBatchOption.this.x(this.f210778d, i29, this.f210779e, this.f210780f, this.f210781h, this.f210782i, this.f210783m, this.C);
                                    return;
                                } else {
                                    ForwardQFavBatchOption.this.w(this.f210778d, i29, this.f210779e, this.f210780f, this.f210781h, this.f210782i, this.f210783m, this.C);
                                    return;
                                }
                            case 7:
                                ForwardQFavBatchOption.this.u(this.f210778d, this.D, this.f210779e, this.f210780f, this.f210781h, this.f210782i, this.f210783m, this.C);
                                return;
                        }
                    }
                };
                if (i3 == 0) {
                    j3 = 200;
                } else {
                    j3 = i3 * 10;
                }
                uIHandler.postDelayed(runnable, j3);
            } else {
                i3 = i28;
                arrayList = parcelableArrayListExtra;
                intent = intent3;
                str = string;
                str2 = string2;
                str3 = string3;
                i16 = i18;
            }
            i28 = i3 + 1;
            i18 = i16;
            string = str;
            string2 = str2;
            parcelableArrayListExtra = arrayList;
            intent3 = intent;
            string3 = str3;
        }
        int i29 = i18;
        cooperation.qqfav.d.c(this.app, "User_BatchForwardSendBtnClick", i29, i29, parcelableArrayListExtra.size());
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!this.f210776d) {
            ArrayList parcelableArrayListExtra = this.mIntent.getParcelableArrayListExtra("bundleList");
            if (parcelableArrayListExtra != null) {
                this.mForwardText = parcelableArrayListExtra.size() + this.mActivity.getString(R.string.f186633rt);
            }
        } else {
            this.mForwardText = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.mForwardText);
        }
        return this.mForwardText;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public String getDialogTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String string = this.mExtraData.getString("uinname");
        if (this.mExtraData.getInt("key_forward_ability_type") == e.S3.intValue()) {
            return HardCodeUtil.qqStr(R.string.cf5);
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public Bitmap getFilePathBitmap(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (this.f210776d) {
            Bitmap i3 = com.tencent.mobileqq.util.j.i(str, 100, 100);
            if (i3 != null) {
                return aw.s(i3, new File(str));
            }
            return i3;
        }
        return super.getFilePathBitmap(str);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        boolean booleanExtra = this.mIntent.getBooleanExtra("bSinglePicSelected", false);
        this.f210776d = booleanExtra;
        if (booleanExtra && TextUtils.isEmpty(this.mForwardThumb)) {
            this.mForwardThumb = this.mExtraData.getString(AppConstants.Key.FORWARD_FILEPATH);
        }
        if (this.mExtraData.getBoolean("qqfav_extra_skip_confirm", false)) {
            forwardToTarget();
        }
        ArrayList parcelableArrayListExtra = this.mIntent.getParcelableArrayListExtra("bundleList");
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() == 1) {
            Bundle bundle = (Bundle) parcelableArrayListExtra.get(0);
            if (bundle == null) {
                return false;
            }
            if (bundle.getInt("qfavType") == 5) {
                this.mForwardThumb = bundle.getString(AppConstants.Key.FORWARD_THUMB);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        if (this.f210777e) {
            return;
        }
        this.f210777e = true;
        ArrayList parcelableArrayListExtra = this.mIntent.getParcelableArrayListExtra("bundleList");
        this.mActivity.getIntent().putExtra("isFromFavorites", true);
        this.mActivity.getIntent().putExtra("hasJumpAIO", false);
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
        int i3 = this.mExtraData.getInt("KEY_MSG_FORWARD_ID");
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() == 1) {
            Bundle bundle = (Bundle) parcelableArrayListExtra.get(0);
            int i16 = bundle.getInt("qfavType");
            if (i16 == 5) {
                intent.putExtra("dataline_forward_type", 100);
                z(bundle, i3);
            } else if (i16 == 8 || i16 == 2) {
                String B = B(bundle);
                if (!TextUtils.isEmpty(B)) {
                    intent.putExtra("dataline_forward_type", 101);
                    if (i16 == 2 && FileManagerUtil.getFileType(B) != 0) {
                        String str = B + ".jpg";
                        File file = new File(B);
                        File file2 = new File(str);
                        file.renameTo(file2);
                        ThreadManagerV2.excute(new Runnable(file2, file) { // from class: com.tencent.mobileqq.forward.ForwardQFavBatchOption.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ File f210784d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ File f210785e;

                            {
                                this.f210784d = file2;
                                this.f210785e = file;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, ForwardQFavBatchOption.this, file2, file);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    com.tencent.mobileqq.filemanager.util.q.b(this.f210784d, this.f210785e);
                                }
                            }
                        }, 64, null, false);
                        B = str;
                    }
                    intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, B);
                    intent.putExtra(AppConstants.Key.FORWARD_EXTRA, B);
                    intent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
                    QLog.d("ForwardOption.ForwardQFavBatchOption", 1, "sendDatalineSingle filePath: " + B);
                    intent.putExtra("dataline_forward_path", B);
                    AutoSaveUtils.d(true, B);
                }
            }
        }
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 1) {
            boolean booleanExtra = this.mIntent.getBooleanExtra("needStartChatActivity", false);
            intent.putExtra("needStartChatActivity", booleanExtra);
            if (booleanExtra) {
                BaseAIOUtils.m(intent, null).putExtras(this.mExtraData);
            }
            for (int i17 = 0; i17 < parcelableArrayListExtra.size(); i17++) {
                Bundle bundle2 = (Bundle) parcelableArrayListExtra.get(i17);
                if (bundle2 != null) {
                    MqqHandler uIHandler = ThreadManager.getUIHandler();
                    Runnable runnable = new Runnable(bundle2, i3) { // from class: com.tencent.mobileqq.forward.ForwardQFavBatchOption.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bundle f210786d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ int f210787e;

                        {
                            this.f210786d = bundle2;
                            this.f210787e = i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, ForwardQFavBatchOption.this, bundle2, Integer.valueOf(i3));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (this.f210786d.getInt("qfavType") == 3) {
                                this.f210786d.putInt("dataline_forward_type", 100);
                                ForwardQFavBatchOption.this.z(this.f210786d, this.f210787e);
                            }
                        }
                    };
                    if (i17 == 0) {
                        j3 = 200;
                    } else {
                        j3 = i17 * 10;
                    }
                    uIHandler.postDelayed(runnable, j3);
                }
            }
        }
    }
}
