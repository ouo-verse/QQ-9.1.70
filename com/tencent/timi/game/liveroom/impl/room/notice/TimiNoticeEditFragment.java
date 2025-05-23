package com.tencent.timi.game.liveroom.impl.room.notice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.widget.chat.message.m;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.sso.request.QQLiveSetAnnounceRequest;
import com.tencent.timi.game.utils.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiNoticeEditFragment extends QPublicBaseFragment implements View.OnClickListener {
    private View C;
    private ImageView D;
    private TextView E;
    private EditText F;
    private String G;
    private long H;
    private long I;

    private void finish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private void handleBackClick() {
        finish();
    }

    private void initData() {
        if (!TextUtils.isEmpty(this.G)) {
            this.F.setText(this.G);
            this.F.setSelection(this.G.length());
        }
        this.F.postDelayed(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.TimiNoticeEditFragment.2
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) TimiNoticeEditFragment.this.F.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(TimiNoticeEditFragment.this.F, 0);
            }
        }, 400L);
        wh(this.G);
    }

    private void initIntent() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        this.G = intent.getStringExtra("key_notice_content");
        this.H = intent.getLongExtra("key_room_id", 0L);
        this.I = intent.getLongExtra("key_anchor_id", 0L);
    }

    private void initListener() {
        this.D.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.addTextChangedListener(new a());
    }

    private void initView() {
        this.D = (ImageView) this.C.findViewById(R.id.zt8);
        this.E = (TextView) this.C.findViewById(R.id.zt9);
        this.F = (EditText) this.C.findViewById(R.id.zt_);
        this.F.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
        this.D.setColorFilter(-1);
    }

    private void sh() {
        final String obj = this.F.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetAnnounceRequest(this.H, this.I, obj), new ILiveNetRequest.Callback() { // from class: com.tencent.timi.game.liveroom.impl.room.notice.j
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                TimiNoticeEditFragment.this.uh(obj, qQLiveResponse);
            }
        });
    }

    private boolean th(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str != null && str.equals(this.G)) {
            return false;
        }
        return !TextUtils.isEmpty(str.replace("\r\n", "").replace("\n", "").replace(" ", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(String str, QQLiveResponse qQLiveResponse) {
        String str2;
        xq4.g gVar = (xq4.g) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && gVar != null) {
            vh(str);
            SimpleEventBus.getInstance().dispatchEvent(new UpdateNoticeEvent());
            finish();
            l.i("Timi_Notice", "getRoomAnnounce success ");
            return;
        }
        long retCode = qQLiveResponse.getRetCode();
        String errMsg = qQLiveResponse.getErrMsg();
        if (retCode == -11657) {
            str2 = "\u6b63\u5728\u5ba1\u6838\u4e2d";
        } else if (retCode != -11654) {
            str2 = "\u670d\u52a1\u5668\u8d70\u8ff7\u8def\u4e86\uff0c\u518d\u8bd5\u4e00\u4e0b";
        } else {
            str2 = "\u5185\u5bb9\u5b58\u5728\u654f\u611f\u4fe1\u606f\uff0c\u8bf7\u68c0\u67e5\u4fee\u6539\u540e\u518d\u5c1d\u8bd5";
        }
        com.tencent.timi.game.ui.widget.f.c(str2);
        l.e("Timi_Notice", "getRoomAnnounce failed :errorCode == " + retCode + ",errorMessage == " + errMsg);
    }

    private void vh(String str) {
        m mVar = new m();
        mVar.roomId = this.H;
        mVar.uid = this.I;
        mVar.announce = str;
        mVar.approved = false;
        mVar.b(false);
        com.tencent.timi.game.liveroom.impl.room.notice.a.INSTANCE.a().e(str, 2);
        SimpleEventBus.getInstance().dispatchEvent(new NoticeCommitEvent(mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(String str) {
        this.E.setEnabled(th(str));
    }

    public static void xh(Context context, String str, long j3, long j16) {
        Intent intent = new Intent(context, (Class<?>) TimiNoticeEditFragment.class);
        intent.putExtra("key_notice_content", str);
        intent.putExtra("key_room_id", j3);
        intent.putExtra("key_anchor_id", j16);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivityForTool.class, TimiNoticeEditFragment.class);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.zt8) {
            handleBackClick();
        } else if (view.getId() == R.id.zt9) {
            sh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull @NotNull LayoutInflater layoutInflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup viewGroup, @Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.f169121hv1, viewGroup, false);
        initIntent();
        initView();
        initListener();
        initData();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TimiNoticeEditFragment.this.wh(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
