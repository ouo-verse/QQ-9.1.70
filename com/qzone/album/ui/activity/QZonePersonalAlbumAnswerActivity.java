package com.qzone.album.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseFragment;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.ExtendLinearLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.MapParcelable;
import java.util.HashMap;

/* loaded from: classes39.dex */
public class QZonePersonalAlbumAnswerActivity extends QZoneTitleBarFragmentV2 {

    /* renamed from: i0, reason: collision with root package name */
    private String f44026i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f44027j0;

    /* renamed from: k0, reason: collision with root package name */
    private EditText f44028k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f44029l0;

    /* renamed from: m0, reason: collision with root package name */
    private String f44030m0;

    /* renamed from: n0, reason: collision with root package name */
    private Long f44031n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f44032o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f44033p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f44034q0;

    /* renamed from: s0, reason: collision with root package name */
    private InputMethodManager f44036s0;

    /* renamed from: t0, reason: collision with root package name */
    private ExtendLinearLayout f44037t0;

    /* renamed from: h0, reason: collision with root package name */
    private int f44025h0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    private HashMap<Integer, String> f44035r0 = new HashMap<>();

    /* renamed from: u0, reason: collision with root package name */
    private boolean f44038u0 = true;

    /* renamed from: v0, reason: collision with root package name */
    private View.OnClickListener f44039v0 = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ExtendLinearLayout.a {
        a() {
        }

        @Override // com.qzone.widget.ExtendLinearLayout.a
        public boolean onDown(MotionEvent motionEvent) {
            return !QZonePersonalAlbumAnswerActivity.this.ui(motionEvent) && QZonePersonalAlbumAnswerActivity.this.ti();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intent intent = new Intent();
            intent.setClass(QZonePersonalAlbumAnswerActivity.this.getActivity(), QZoneFriendFeedXActivity.class);
            intent.putExtra("qzone_uin", LoginData.getInstance().getUin());
            intent.addFlags(67108864);
            QZoneHelper.forwardToQZoneFriendFeedActivity(QZonePersonalAlbumAnswerActivity.this.getActivity(), intent, false);
            QZonePersonalAlbumAnswerActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZonePersonalAlbumAnswerActivity.this.ti();
            QZonePersonalAlbumAnswerActivity.this.oi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements AbsCompatRequest.a {
        d() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZonePersonalAlbumAnswerActivity.this.qi();
            if (sVar.getSucceed()) {
                if (QZonePersonalAlbumAnswerActivity.this.f44028k0 != null) {
                    g4.a.f401215a.getUiInterface().b(QZonePersonalAlbumAnswerActivity.this.f44030m0, QZonePersonalAlbumAnswerActivity.this.f44031n0, QZonePersonalAlbumAnswerActivity.this.f44028k0.getText().toString().trim());
                    com.qzone.album.base.Service.a.W().O0(25, QZonePersonalAlbumAnswerActivity.this.f44030m0);
                    QZonePersonalAlbumAnswerActivity.this.ri();
                    return;
                }
                return;
            }
            QZonePersonalAlbumAnswerActivity.this.toast(sVar.getMessage(), 4);
        }
    }

    private void initIntent() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f44029l0 = arguments.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_NAME);
            this.f44030m0 = arguments.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID);
            this.f44031n0 = Long.valueOf(arguments.getLong("key_album_owner_uin", 0L));
            this.f44032o0 = arguments.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_QUESTION);
            this.f44034q0 = arguments.getBoolean(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_WX, false);
            MapParcelable mapParcelable = (MapParcelable) arguments.getParcelable(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_BUIS_PARAM);
            this.f44033p0 = arguments.getInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, 1);
            if (mapParcelable != null && mapParcelable.getSingleMap() != null) {
                this.f44035r0 = (HashMap) mapParcelable.getSingleMap();
            }
            this.f44025h0 = arguments.getInt(QZoneHelper.QZonePersonalAlbumContants.KEY_ANSWER_PAGE_CONGENT_FLAG);
            this.f44026i0 = arguments.getString(QZoneHelper.QZonePersonalAlbumContants.KEY_ANSWER_PAGE_ERROR_MSG);
            return;
        }
        w5.b.g(BaseFragment.TAG, 1, "getArguments is null in onCreateView");
    }

    private void initUI() {
        if (this.f44025h0 == 0) {
            setTitle(R.string.f173023gj4);
            TextView textView = this.C;
            if (textView != null) {
                textView.setText(R.string.cancel);
            }
            Xh(R.string.f173003ge2, this.f44039v0, false);
            ExtendLinearLayout extendLinearLayout = (ExtendLinearLayout) findViewById(R.id.f164255p0);
            this.f44037t0 = extendLinearLayout;
            extendLinearLayout.setOnDownListener(new a());
            this.f44027j0 = (TextView) findViewById(R.id.h28);
            if (!TextUtils.isEmpty(this.f44032o0)) {
                this.f44027j0.setText(this.f44032o0);
            }
            EditText editText = (EditText) findViewById(R.id.f164344sh);
            this.f44028k0 = editText;
            editText.addTextChangedListener(new e());
            if (Build.VERSION.SDK_INT >= 31) {
                vi();
                return;
            }
            return;
        }
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.bwf);
        TextView textView2 = (TextView) findViewById(R.id.bwu);
        TextView textView3 = (TextView) findViewById(R.id.bwd);
        TextView textView4 = (TextView) findViewById(R.id.k7p);
        asyncImageView.setAsyncImage(com.qzone.album.ui.widget.c.f44291a0);
        textView2.setText(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_TEXT, QzoneConfig.DefaultValue.DEFAULT_MEMORY_DEFAUL_TEXT));
        textView3.setText(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_ARCHIVE_MEMORY, QzoneConfig.SECONDARY_MEMOEY_TEXT_CONTENT, QzoneConfig.DefaultValue.DEFAULT_MEMORY_DEFAUL_TEXT_CONTENT));
        if (this.f44034q0) {
            textView4.setVisibility(0);
            textView4.setText(R.string.vqa);
            textView4.setOnClickListener(new b());
            textView3.setVisibility(8);
            return;
        }
        textView3.setVisibility(0);
        textView4.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        String obj;
        if (this.f44038u0) {
            this.f44038u0 = false;
            if (checkNetworkConnect()) {
                EditText editText = this.f44028k0;
                if (editText == null || (obj = editText.getText().toString()) == null) {
                    return;
                }
                g4.a.f401215a.getUiInterface().a(getActivity());
                com.qzone.album.base.Service.a.W().Q1(this.f44031n0.longValue(), this.f44030m0, obj, this.f44035r0, new d());
                return;
            }
            showNoNetworkTips();
            this.f44038u0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        boolean z16 = this.f44028k0 != null ? !TextUtils.isEmpty(r0.getText().toString().trim()) : false;
        TextView textView = this.E;
        if (textView != null) {
            textView.setEnabled(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi() {
        g4.a.f401215a.getUiInterface().c();
        this.f44038u0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(this.f44030m0);
        businessAlbumInfo.mUin = this.f44031n0.longValue();
        businessAlbumInfo.mAlbumType = this.f44033p0;
        businessAlbumInfo.mCover = "";
        businessAlbumInfo.mTitle = this.f44029l0;
        startActivity(ak.I(getActivity(), businessAlbumInfo, 0));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ti() {
        InputMethodManager inputMethodManager = this.f44036s0;
        return inputMethodManager != null && inputMethodManager.isActive(this.f44028k0) && this.f44036s0.hideSoftInputFromWindow(this.f44028k0.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ui(MotionEvent motionEvent) {
        if (this.f44028k0 == null) {
            return false;
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) (motionEvent.getY() + getTitleBarHeight() + this.mStatusBarHeight);
        EditText editText = this.f44028k0;
        Rect si5 = editText != null ? si(editText) : null;
        return si5 != null && si5.contains(x16, y16);
    }

    private void vi() {
        EditText editText = this.f44028k0;
        if (editText == null) {
            return;
        }
        editText.setClickable(true);
        this.f44028k0.setFocusable(true);
        this.f44028k0.setFocusableInTouchMode(true);
    }

    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        EditText editText;
        if (this.f44025h0 == 0 && (editText = this.f44028k0) != null && editText.isFocused()) {
            this.f44036s0.hideSoftInputFromWindow(this.f44028k0.getWindowToken(), 0);
        }
        super.finish();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        initIntent();
        if (this.f44025h0 == 0) {
            return Rh(layoutInflater, R.layout.f169024bo0, viewGroup);
        }
        return Rh(layoutInflater, R.layout.bhy, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public void onNetStateChanged(boolean z16) {
        super.onNetStateChanged(z16);
        if (z16) {
            return;
        }
        this.f44038u0 = true;
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f44038u0 = true;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        g4.a.f401215a.getUiInterface().destroy();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f44036s0 = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        initUI();
    }

    private Rect si(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private boolean f44044d = false;

        /* renamed from: e, reason: collision with root package name */
        private int f44045e;

        /* renamed from: f, reason: collision with root package name */
        private int f44046f;

        /* renamed from: h, reason: collision with root package name */
        private int f44047h;

        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            QZonePersonalAlbumAnswerActivity.this.pi();
            if (!this.f44044d || editable.length() <= 20) {
                return;
            }
            QZonePersonalAlbumAnswerActivity qZonePersonalAlbumAnswerActivity = QZonePersonalAlbumAnswerActivity.this;
            qZonePersonalAlbumAnswerActivity.toast(String.format(qZonePersonalAlbumAnswerActivity.getString(R.string.ghn), 20));
            char[] cArr = new char[20];
            editable.getChars(0, this.f44045e, cArr, 0);
            try {
                if (this.f44045e + this.f44046f != editable.length()) {
                    int length = this.f44046f - (editable.length() - 20);
                    int i3 = this.f44045e;
                    editable.getChars(i3, i3 + length, cArr, i3);
                    editable.getChars(this.f44045e + this.f44046f, editable.length(), cArr, this.f44045e + length);
                } else {
                    int i16 = this.f44045e;
                    editable.getChars(i16, 20, cArr, i16);
                }
                editable.replace(0, editable.length(), String.valueOf(cArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if ((charSequence.length() - i16) + i17 > 20) {
                this.f44044d = true;
                this.f44045e = i3;
                this.f44046f = i17;
                this.f44047h = i16;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
