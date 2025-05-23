package com.tencent.mobileqq.guild.robot.api.impl;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import ap0.f;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPanelApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import hx1.a;

/* loaded from: classes14.dex */
public class GuildRobotPanelApiImpl implements IGuildRobotPanelApi {
    private static final String TAG = "GuildRobotTag:GuildRobotPanelApiImpl";

    /* loaded from: classes14.dex */
    class a implements a.InterfaceC10478a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Editable f232048a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f232049b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f232050c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f232051d;

        a(Editable editable, String str, boolean z16, EditText editText) {
            this.f232048a = editable;
            this.f232049b = str;
            this.f232050c = z16;
            this.f232051d = editText;
        }

        @Override // hx1.a.InterfaceC10478a
        public void a(CommonBotInfo commonBotInfo) {
            SpannableString o16;
            this.f232048a.clear();
            hx1.a.a().d(this);
            if (this.f232049b != null && !TextUtils.isEmpty(commonBotInfo.getName())) {
                if (!this.f232050c && (o16 = com.tencent.guild.aio.input.at.utils.b.o(this.f232051d.getContext(), this.f232049b, commonBotInfo.getName(), this.f232051d, false)) != null) {
                    this.f232048a.insert(0, o16);
                }
                GuildRobotPanelApiImpl.this.setSelectionAndShowKeyboard(this.f232051d);
                QLog.i(GuildRobotPanelApiImpl.TAG, 1, "editableText: " + ((Object) this.f232048a));
                return;
            }
            QLog.w(GuildRobotPanelApiImpl.TAG, 1, "invalidData, tinyId: " + this.f232049b + ", name: " + commonBotInfo.getName());
        }
    }

    /* loaded from: classes14.dex */
    class b implements a.InterfaceC10478a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Editable f232053a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f232054b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ EditText f232055c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f232056d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f232057e;

        b(Editable editable, boolean z16, EditText editText, String str, String str2) {
            this.f232053a = editable;
            this.f232054b = z16;
            this.f232055c = editText;
            this.f232056d = str;
            this.f232057e = str2;
        }

        @Override // hx1.a.InterfaceC10478a
        public void a(CommonBotInfo commonBotInfo) {
            this.f232053a.clear();
            if (!this.f232054b) {
                SpannableString o16 = com.tencent.guild.aio.input.at.utils.b.o(this.f232055c.getContext(), this.f232056d, commonBotInfo.getName(), this.f232055c, false);
                f.isAtListeningBlocked = true;
                this.f232053a.insert(0, o16);
                f.isAtListeningBlocked = false;
            }
            if (!TextUtils.isEmpty(this.f232057e)) {
                this.f232053a.insert(this.f232055c.getSelectionStart(), "/\u641c\u7d22 ");
                this.f232053a.insert(this.f232055c.getSelectionStart(), this.f232057e);
            } else {
                f.isAtListeningBlocked = true;
                this.f232053a.insert(this.f232055c.getSelectionStart(), "/\u641c\u7d22 ");
                f.isAtListeningBlocked = false;
                this.f232055c.requestFocus();
                EditText editText = this.f232055c;
                editText.setSelection(editText.getText().length());
                InputMethodManager inputMethodManager = (InputMethodManager) this.f232055c.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(this.f232055c, 2);
                }
            }
            QLog.i(GuildRobotPanelApiImpl.TAG, 1, "editableText: " + ((Object) this.f232053a));
            hx1.a.a().d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectionAndShowKeyboard(EditText editText) {
        editText.requestFocus();
        editText.setSelection(editText.getText().length());
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 0);
        }
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPanelApi
    public void insertAtSpan(Activity activity, EditText editText, String str, String str2, boolean z16) {
        hx1.b.c(activity, editText, str, str2, z16);
        QLog.d(TAG, 1, "insertAtSpan, tinyId: ", str, ", name=", str2);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPanelApi
    public boolean openRobotFunctionsPanel(EditText editText, String str, String str2, boolean z16) {
        QLog.i(TAG, 1, "openRobotFunctionsPanel, tinyId: " + str + ", param" + str2);
        if (editText == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Editable editableText = editText.getEditableText();
        if (z16) {
            f.isSlashListeningBlocked = true;
        } else {
            zo0.a aVar = f.guildRobotAtHelper;
            if (aVar == null) {
                return false;
            }
            f.robotFunctionPanelBlockTime++;
            aVar.c(str);
        }
        hx1.a.a().c(new a(editableText, str, z16, editText));
        return true;
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotPanelApi
    public boolean openRobotInlineSearchPanel(EditText editText, String str, String str2, boolean z16) {
        QLog.i(TAG, 1, "openRobotInlineSearchPanel, tinyId: " + str + "param" + str2);
        if (editText == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Editable editableText = editText.getEditableText();
        if (z16) {
            f.isSlashListeningBlocked = true;
        } else {
            zo0.a aVar = f.guildRobotAtHelper;
            if (aVar == null) {
                return false;
            }
            f.robotFunctionPanelBlockTime++;
            aVar.c(str);
        }
        hx1.a.a().c(new b(editableText, z16, editText, str, str2));
        return true;
    }
}
