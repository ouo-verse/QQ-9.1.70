package com.tencent.open.agent;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.d;
import com.tencent.open.widget.CursorEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SendStoryActivity extends QBaseActivity implements View.OnClickListener, TextWatcher, d.a, HttpCgiAsyncTask.a {

    /* renamed from: a0, reason: collision with root package name */
    protected Bundle f340022a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f340023b0;

    /* renamed from: c0, reason: collision with root package name */
    protected String f340024c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f340025d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f340026e0;

    /* renamed from: f0, reason: collision with root package name */
    protected String f340027f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f340028g0;

    /* renamed from: q0, reason: collision with root package name */
    protected View f340038q0;

    /* renamed from: r0, reason: collision with root package name */
    protected TextView f340039r0;

    /* renamed from: s0, reason: collision with root package name */
    protected TextView f340040s0;

    /* renamed from: t0, reason: collision with root package name */
    protected TextView f340041t0;

    /* renamed from: u0, reason: collision with root package name */
    protected TextView f340042u0;

    /* renamed from: w0, reason: collision with root package name */
    protected InputFilter[] f340044w0;

    /* renamed from: h0, reason: collision with root package name */
    protected String f340029h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    protected CursorEditText f340030i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    protected Button f340031j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    protected LinearLayout f340032k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    protected TextView f340033l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    protected TextView f340034m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    protected ImageView f340035n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    protected LinearLayout f340036o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    protected RelativeLayout f340037p0 = null;

    /* renamed from: v0, reason: collision with root package name */
    protected ProgressDialog f340043v0 = null;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Comparator<Friend> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f340045d;

        a(Editable editable) {
            this.f340045d = editable;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Friend friend, Friend friend2) {
            return this.f340045d.getSpanStart(friend) - this.f340045d.getSpanStart(friend2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b extends com.tencent.open.base.e {

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Comparator<Friend> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Editable f340048d;

            a(Editable editable) {
                this.f340048d = editable;
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Friend friend, Friend friend2) {
                return this.f340048d.getSpanStart(friend2) - this.f340048d.getSpanStart(friend);
            }
        }

        public b(EditText editText, int i3) {
            super(editText, i3);
        }

        @Override // com.tencent.open.base.e, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int c16;
            int i19;
            Editable editableText = this.f340971d.getEditableText();
            StringBuilder sb5 = new StringBuilder(editableText.toString());
            Friend[] friendArr = (Friend[]) editableText.getSpans(0, editableText.length(), Friend.class);
            Arrays.sort(friendArr, new a(editableText));
            for (Friend friend : friendArr) {
                sb5.delete(editableText.getSpanStart(friend), editableText.getSpanEnd(friend));
            }
            int c17 = this.f340972e - com.tencent.open.base.j.c(sb5.toString());
            int c18 = com.tencent.open.base.j.c(charSequence.subSequence(i3, i16).toString());
            if (c17 <= 0) {
                return "";
            }
            if (c17 >= c18) {
                return null;
            }
            int i26 = i3;
            while (i26 < i16) {
                if (Character.isHighSurrogate(charSequence.charAt(i26))) {
                    c16 = com.tencent.open.base.j.c(charSequence.subSequence(i26, i26 + 2).toString());
                    i19 = 2;
                } else {
                    c16 = com.tencent.open.base.j.c(String.valueOf(charSequence.charAt(i26)));
                    i19 = 1;
                }
                c17 -= c16;
                if (c17 < 0) {
                    break;
                }
                i26 += i19;
            }
            if (i26 == i3) {
                return "";
            }
            return charSequence.subSequence(i3, i26);
        }
    }

    protected void F2() {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", -5);
        String str = com.tencent.open.business.base.b.f341055c;
        intent.putExtra("key_error_msg", str);
        com.tencent.open.base.f.c("SendStoryActivity", "initParams:error code:-5; error msg:" + str);
        if (this.f340022a0 != null) {
            StringBuilder sb5 = new StringBuilder();
            for (String str2 : this.f340022a0.keySet()) {
                sb5.append(str2 + MsgSummary.STR_COLON + this.f340022a0.get(str2).toString() + " ");
            }
            com.tencent.open.base.f.c("SendStoryActivity", "params=" + sb5.toString());
        }
        super.setResult(-1, intent);
        super.finish();
    }

    protected boolean G2() {
        try {
            Bundle bundleExtra = super.getIntent().getBundleExtra("key_params");
            this.f340022a0 = bundleExtra;
            if (bundleExtra != null && bundleExtra.containsKey("appid") && this.f340022a0.containsKey("hopenid") && this.f340022a0.containsKey("keystr") && this.f340022a0.containsKey("keytype") && this.f340022a0.containsKey("platform") && this.f340022a0.containsKey("title") && this.f340022a0.containsKey(s4.c.PICS) && this.f340022a0.containsKey("encrytoken")) {
                this.f340023b0 = this.f340022a0.getString("appid");
                this.f340024c0 = this.f340022a0.getString("keystr");
                this.f340028g0 = this.f340022a0.getString(s4.c.PICS);
                this.f340025d0 = com.tencent.open.base.j.g(this.f340022a0.getString("title"), 72, true, false);
                String string = this.f340022a0.getString("hopenid");
                String string2 = this.f340022a0.getString("keytype");
                String string3 = this.f340022a0.getString("platform");
                String string4 = this.f340022a0.getString("encrytoken");
                if (!"".equals(this.f340023b0.trim()) && !"".equals(string.trim()) && !"".equals(this.f340024c0.trim()) && !"".equals(string2.trim()) && !"".equals(string3.trim()) && !"".equals(this.f340025d0.trim()) && !"".equals(this.f340028g0.trim()) && !"".equals(string4.trim())) {
                    if (this.f340022a0.containsKey("description")) {
                        this.f340027f0 = com.tencent.open.base.j.g(this.f340022a0.getString("description"), 80, false, false);
                    }
                    if (this.f340022a0.containsKey("summary")) {
                        this.f340026e0 = com.tencent.open.base.j.g(this.f340022a0.getString("summary"), 160, true, false);
                    }
                    this.f340029h0 = lq3.c.c().a("https://fusion.qq.com/cgi-bin/appstage/mapp_sendstory.cgi");
                    return true;
                }
                F2();
                return false;
            }
            F2();
            return false;
        } catch (Exception e16) {
            com.tencent.open.base.f.d("SendStoryActivity", "initParams exception. " + e16.getMessage(), e16);
            F2();
            return false;
        }
    }

    protected String H2(Friend friend) {
        String str;
        if (TextUtils.isEmpty(friend.f340348f)) {
            str = friend.f340347e;
        } else {
            str = friend.f340348f;
        }
        return "@" + com.tencent.open.base.j.g(str, 12, false, false) + " ";
    }

    protected void I2(Intent intent) {
        int intExtra = intent.getIntExtra("key_error_code", -6);
        if (intExtra != 0) {
            QQToast.makeText(getApplicationContext(), intent.getStringExtra("key_error_msg"), 0).show();
            com.tencent.open.base.f.c("SendStoryActivity", "onSendStoryComplete error:{KEY_ERROR_CODE:" + intExtra + "; KEY_ERROR_MSG:" + intent.getStringExtra("key_error_msg") + "}");
        }
        super.setResult(-1, intent);
        super.finish();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        for (Friend friend : (Friend[]) editable.getSpans(0, editable.length(), Friend.class)) {
            int spanStart = editable.getSpanStart(friend);
            int spanEnd = editable.getSpanEnd(friend);
            if (!editable.subSequence(spanStart, spanEnd).toString().equals(H2(friend))) {
                editable.removeSpan(friend);
                editable.delete(spanStart, spanEnd);
            }
        }
    }

    protected void dismissProgressDialog() {
        ProgressDialog progressDialog = this.f340043v0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f340043v0.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        if (i16 == -1) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null && extras.getInt("key_error_code", -6) == 0) {
                    this.f340030i0.setFilters(new InputFilter[0]);
                    Editable editableText = this.f340030i0.getEditableText();
                    Parcelable[] parcelableArray = extras.getParcelableArray("RESULT_BUDDIES_SELECTED");
                    if (parcelableArray == null) {
                        return;
                    }
                    int selectionStart = this.f340030i0.getSelectionStart();
                    editableText.delete(selectionStart, this.f340030i0.getSelectionEnd());
                    Friend[] friendArr = (Friend[]) editableText.getSpans(0, editableText.length(), Friend.class);
                    int length = parcelableArray.length;
                    int i17 = 0;
                    while (true) {
                        boolean z17 = true;
                        if (i17 >= length) {
                            break;
                        }
                        Parcelable parcelable = parcelableArray[i17];
                        Friend friend = new Friend((Friend) parcelable);
                        int length2 = friendArr.length;
                        int i18 = 0;
                        while (true) {
                            if (i18 >= length2) {
                                break;
                            }
                            if (friendArr[i18].f340346d.equals(friend.f340346d)) {
                                z17 = false;
                                break;
                            }
                            i18++;
                        }
                        if (z17) {
                            String H2 = H2(friend);
                            editableText.insert(selectionStart, H2);
                            editableText.setSpan(parcelable, selectionStart, H2.length() + selectionStart, 33);
                            selectionStart += H2.length();
                        }
                        i17++;
                    }
                    for (Friend friend2 : (Friend[]) editableText.getSpans(0, editableText.length(), Friend.class)) {
                        int length3 = parcelableArray.length;
                        int i19 = 0;
                        while (true) {
                            if (i19 < length3) {
                                if (friend2.f340346d.equals(((Friend) parcelableArray[i19]).f340346d)) {
                                    z16 = false;
                                    break;
                                }
                                i19++;
                            } else {
                                z16 = true;
                                break;
                            }
                        }
                        if (z16) {
                            int spanStart = editableText.getSpanStart(friend2);
                            int spanEnd = editableText.getSpanEnd(friend2);
                            editableText.removeSpan(friend2);
                            editableText.delete(spanStart, spanEnd);
                        }
                    }
                    this.f340030i0.setFilters(this.f340044w0);
                }
            } catch (Exception e16) {
                com.tencent.open.base.f.d("SendStoryActivity", "onActivityResult error:" + e16.getMessage(), e16);
                super.setResult(0);
                super.finish();
            }
        }
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void f(JSONObject jSONObject) {
        try {
            com.tencent.open.business.base.e.g(IndividuationPlugin.Business_Pendant, "ANDROIDQQ.SENDSTORY.FEED1", this.f340023b0, true);
            dismissProgressDialog();
            int i3 = jSONObject.getInt("ret");
            String string = jSONObject.getString("msg");
            if (i3 == 0) {
                QQToast.makeText(getApplicationContext(), R.string.f170762a62, 0).show();
            }
            Intent intent = new Intent();
            intent.putExtra("key_error_code", i3);
            intent.putExtra("key_error_msg", string);
            intent.putExtra("key_response", jSONObject.toString());
            I2(intent);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d("SendStoryActivity", "SendStory exception. " + e16.getMessage(), e16);
            Intent intent2 = new Intent();
            intent2.putExtra("key_error_code", -4);
            intent2.putExtra("key_error_msg", com.tencent.open.business.base.b.f341054b);
            I2(intent2);
        } catch (Exception e17) {
            onException(e17);
        }
    }

    @TargetApi(14)
    protected void findViews() {
        this.f340036o0 = (LinearLayout) super.findViewById(R.id.eeb);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.f340036o0.setFitsSystemWindows(true);
            this.f340036o0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        this.f340038q0 = super.findViewById(R.id.jo9);
        this.f340039r0 = (TextView) super.findViewById(R.id.ivTitleName);
        this.f340040s0 = (TextView) super.findViewById(R.id.ivTitleBtnLeft);
        this.f340041t0 = (TextView) super.findViewById(R.id.ivTitleBtnLeftButton);
        this.f340042u0 = (TextView) super.findViewById(R.id.ivTitleBtnRightText);
        this.f340040s0.setOnClickListener(this);
        this.f340041t0.setOnClickListener(this);
        this.f340042u0.setOnClickListener(this);
        this.f340030i0 = (CursorEditText) super.findViewById(R.id.bz9);
        this.f340031j0 = (Button) super.findViewById(R.id.af9);
        this.f340032k0 = (LinearLayout) super.findViewById(R.id.eef);
        this.f340037p0 = (RelativeLayout) super.findViewById(R.id.icy);
        this.f340033l0 = (TextView) super.findViewById(R.id.kaz);
        this.f340034m0 = (TextView) super.findViewById(R.id.kay);
        this.f340035n0 = (ImageView) super.findViewById(R.id.dyh);
        this.f340031j0.setOnClickListener(this);
        InputFilter[] inputFilterArr = {new b(this.f340030i0, 80)};
        this.f340044w0 = inputFilterArr;
        this.f340030i0.setFilters(inputFilterArr);
        this.f340030i0.addTextChangedListener(this);
        this.f340030i0.setSpannedClassToSkip(Friend.class);
        this.f340033l0.setText(com.tencent.open.base.j.g(this.f340025d0, 28, true, false));
        String str = this.f340027f0;
        if (str != null && str.length() > 0) {
            this.f340030i0.setText(this.f340027f0);
            this.f340030i0.setTextColor(-16777216);
        }
        String str2 = this.f340026e0;
        if (str2 != null && str2.length() > 0) {
            this.f340034m0.setText(com.tencent.open.base.j.g(this.f340026e0, 80, true, false));
        }
        new com.tencent.open.base.http.d(null, MsfSdkUtils.insertMtype("yingyongbao", this.f340028g0), null, "GET", this).execute(new Void[0]);
        CursorEditText cursorEditText = this.f340030i0;
        cursorEditText.setSelection(cursorEditText.getText().toString().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        super.setResult(0);
        super.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f340040s0) {
            super.setResult(0);
            super.finish();
        } else if (view == this.f340031j0) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("appid", this.f340023b0);
            bundle.putString("hopenid", this.f340022a0.getString("hopenid"));
            bundle.putString("keystr", this.f340024c0);
            bundle.putString("keytype", this.f340022a0.getString("keytype"));
            bundle.putString("encrytoken", this.f340022a0.getString("encrytoken"));
            bundle.putString("platform", this.f340022a0.getString("platform"));
            if (this.f340022a0.containsKey("sdkv")) {
                bundle.putString("sdkv", this.f340022a0.getString("sdkv"));
            }
            if (this.f340022a0.containsKey("sdkp")) {
                bundle.putString("sdkp", this.f340022a0.getString("sdkp"));
            }
            bundle.putString("key_action", "action_story");
            Friend[] friendArr = (Friend[]) this.f340030i0.getEditableText().getSpans(0, this.f340030i0.length(), Friend.class);
            String[] strArr = new String[friendArr.length];
            for (int i3 = 0; i3 < friendArr.length; i3++) {
                strArr[i3] = friendArr[i3].f340346d;
            }
            bundle.putStringArray("BuddiesSelected", strArr);
            intent.setClass(this, SocialFriendChooser.class);
            intent.putExtra("key_action", "action_story");
            intent.putExtra("key_params", bundle);
            super.startActivityForResult(intent, 0);
            if (QLog.isColorLevel()) {
                QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchStart:" + SystemClock.elapsedRealtime());
            }
        } else if (view == this.f340041t0) {
            onBackEvent();
        } else if (view == this.f340042u0) {
            StringBuilder sb5 = new StringBuilder();
            Editable editableText = this.f340030i0.getEditableText();
            Friend[] friendArr2 = (Friend[]) editableText.getSpans(0, editableText.length(), Friend.class);
            Arrays.sort(friendArr2, new a(editableText));
            HashSet hashSet = new HashSet();
            int length = friendArr2.length;
            int i16 = 0;
            int i17 = 0;
            while (i16 < length) {
                Friend friend = friendArr2[i16];
                int spanStart = editableText.getSpanStart(friend);
                int spanEnd = editableText.getSpanEnd(friend);
                sb5.append(editableText.subSequence(i17, spanStart));
                String str = friend.f340347e;
                if (str == null) {
                    str = friend.f340348f;
                }
                sb5.append(String.format("@{openid:%s,nick:%s}", friend.f340346d, com.tencent.open.base.j.b(str)));
                hashSet.add(friend.f340346d);
                i16++;
                i17 = spanEnd;
            }
            if (i17 != editableText.length()) {
                sb5.append(editableText.subSequence(i17, editableText.length()));
            }
            if (hashSet.size() > 10) {
                QQToast.makeText(getApplicationContext(), super.getString(R.string.f170761a61, new Object[]{10}), 0).show();
            } else {
                Bundle bundle2 = new Bundle(this.f340022a0);
                bundle2.putString("summary", this.f340026e0);
                bundle2.putString("title", this.f340025d0);
                bundle2.putString("description", sb5.toString());
                bundle2.putString("appid_for_getting_config", this.f340023b0);
                bundle2.putString("agentversion", com.tencent.open.adapter.a.f().b());
                ProgressDialog show = ProgressDialog.show(this, "", super.getString(R.string.a67), true);
                this.f340043v0 = show;
                show.setCancelable(true);
                new HttpCgiAsyncTask(this.f340029h0, "POST", this, true).b(bundle2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.requestWindowFeature(1);
        super.onCreate(bundle);
        super.setTheme(R.style.f173428d2);
        super.setContentView(R.layout.f168470x1);
        G2();
        findViews();
        com.tencent.open.business.base.e.g("100", "ANDROIDQQ.SENDSTORY.FS", this.f340023b0, true);
    }

    @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
    public void onException(Exception exc) {
        dismissProgressDialog();
        com.tencent.open.base.f.d("SendStoryActivity", "SendStory exception. " + exc.getMessage(), exc);
        Intent intent = new Intent();
        if (exc instanceof ConnectTimeoutException) {
            intent.putExtra("key_error_code", -7);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341057e);
        } else if (exc instanceof SocketTimeoutException) {
            intent.putExtra("key_error_code", -8);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341058f);
        } else if (exc instanceof MalformedURLException) {
            intent.putExtra("key_error_code", -3);
            intent.putExtra("key_error_msg", "\u8bbf\u95eeurl\u6709\u8bef!");
        } else if (exc instanceof HttpBaseUtil.HttpStatusException) {
            intent.putExtra("key_error_code", -10);
            intent.putExtra("key_error_msg", "Http\u8fd4\u56de\u7801\u5f02\u5e38!");
        } else if (exc instanceof HttpBaseUtil.NetworkUnavailableException) {
            intent.putExtra("key_error_code", -9);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341059g);
        } else if (exc instanceof IOException) {
            intent.putExtra("key_error_code", -2);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341053a);
        } else {
            intent.putExtra("key_error_code", -6);
            intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341056d);
        }
        I2(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f340040s0.setVisibility(4);
        this.f340041t0.setVisibility(0);
        this.f340041t0.setText(R.string.cancel);
        this.f340042u0.setVisibility(0);
        this.f340042u0.setText(R.string.a69);
        this.f340039r0.setText(R.string.f170763a63);
        this.f340041t0.setOnClickListener(this);
        this.f340042u0.setOnClickListener(this);
    }

    @Override // com.tencent.open.base.http.d.a
    public void r1(String str, Bitmap bitmap) {
        if (bitmap != null) {
            this.f340035n0.setImageBitmap(bitmap);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
