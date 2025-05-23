package com.tencent.timi.game.liveroom.impl.room.view;

import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import com.tencent.trpcprotocol.qlive.TrpcFansGroupOuterClass$ModifyGroupNameRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class af extends ReportDialogFragment {

    /* renamed from: d, reason: collision with root package name */
    private View f378711d;

    /* renamed from: e, reason: collision with root package name */
    private EditText f378712e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f378713f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f378714h;

    /* renamed from: i, reason: collision with root package name */
    private jj4.d f378715i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            af.this.d();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            af.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements zi4.a<TrpcFansGroupOuterClass$ModifyGroupNameRsp> {
        c() {
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(TrpcFansGroupOuterClass$ModifyGroupNameRsp trpcFansGroupOuterClass$ModifyGroupNameRsp) {
            QQToast.makeText(af.this.getActivity(), "\u4fee\u6539\u6210\u529f", 2).show();
            af.this.dismissAllowingStateLoss();
        }

        @Override // zi4.a
        public void fail(int i3, String str) {
            QQToast.makeText(af.this.getActivity(), str, 1).show();
        }
    }

    private void b() {
        this.f378715i = new jj4.d();
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        if (bVar == null) {
            QLog.i("ModifyFansGroupDialog", 1, "onConfirmClick: liveRoomService==null");
            return;
        }
        IQQLiveSDK f16 = bVar.f();
        if (f16 == null) {
            QLog.e("ModifyFansGroupDialog", 1, "onConfirmClick return liveSDK=" + f16);
            return;
        }
        this.f378715i.m(f16.getProxySsoService());
    }

    private void c() {
        this.f378712e = (EditText) this.f378711d.findViewById(R.id.v0_);
        this.f378713f = (TextView) this.f378711d.findViewById(R.id.v08);
        TextView textView = (TextView) this.f378711d.findViewById(R.id.v09);
        this.f378714h = textView;
        textView.setOnClickListener(new a());
        this.f378713f.setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String obj = this.f378712e.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            QQToast.makeText(getActivity(), "\u7c89\u4e1d\u56e2\u540d\u79f0\u4e0d\u53ef\u4e3a\u7a7a", 1).show();
        } else if (com.tencent.timi.game.liveroom.impl.room.util.i.a(obj) > 6) {
            QQToast.makeText(getActivity(), "\u7c89\u4e1d\u56e2\u540d\u79f0\u4e0d\u53ef\u8d85\u8fc73\u4e2a\u5b57", 1).show();
        } else {
            this.f378715i.k(obj, new c());
        }
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e16) {
            QLog.e("ModifyFansGroupDialog", 1, "dismiss e=" + e16);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        this.f378711d = layoutInflater.inflate(R.layout.huz, viewGroup, false);
        c();
        b();
        View view = this.f378711d;
        FragmentCollector.onFragmentViewCreated(this, view);
        return view;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && getActivity() != null) {
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.dimAmount = 0.0f;
            dialog.getWindow().setAttributes(attributes);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            super.show(fragmentManager, str);
        } catch (Exception e16) {
            QLog.e("ModifyFansGroupDialog", 1, "show e=" + e16);
        }
    }
}
