package com.qwallet.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qwallet.activity.patternlock.PatternLockHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.TenpayInterface;
import cooperation.qwallet.plugin.IActivity;
import mqq.util.WeakReference;

/* loaded from: classes3.dex */
public class QvipPayFullScreenRealAuthActivity extends QWalletBaseFragment {
    private boolean C;
    private int D;
    private com.qwallet.activity.patternlock.biz.a E;

    /* loaded from: classes3.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QvipPayFullScreenRealAuthActivity.this.E.i(4);
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Intent intent = new Intent();
            intent.setAction(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL);
            QvipPayFullScreenRealAuthActivity.this.sendBroadcast(intent);
            dialogInterface.dismiss();
            QvipPayFullScreenRealAuthActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Intent intent = new Intent();
            intent.setAction(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL);
            QvipPayFullScreenRealAuthActivity.this.sendBroadcast(intent);
            dialogInterface.dismiss();
            QvipPayFullScreenRealAuthActivity.this.finish();
        }
    }

    private String qh(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            return getContext().getString(R.string.f179723_5);
        }
        return getContext().getString(R.string.f179733_6);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.hh_, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.qwallet.activity.patternlock.biz.a aVar = this.E;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.C) {
            if (g.c("qwallet_is_pws_enter_" + com.tencent.mobileqq.base.a.c(), true)) {
                finish();
                return;
            }
            final Bundle bundle = new Bundle();
            bundle.putString("userId", com.tencent.mobileqq.base.a.c());
            PatternLockHelper.d(getContext(), 230, null, getContext().getString(R.string.f179753_8), getContext().getString(R.string.cancel), getContext().getString(R.string.f179813_d), new DialogInterface.OnClickListener() { // from class: com.qwallet.activity.QvipPayFullScreenRealAuthActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    TenpayInterface.gotoView(QvipPayFullScreenRealAuthActivity.this.getContext(), "idCardVerify", com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), bundle, new ResultReceiver(null) { // from class: com.qwallet.activity.QvipPayFullScreenRealAuthActivity.3.1
                        @Override // android.os.ResultReceiver
                        protected void onReceiveResult(int i16, Bundle bundle2) {
                            QLog.i("QvipPayFullScreenRealAuthActivity", 2, "resultCode: " + i16);
                        }
                    });
                    dialogInterface.dismiss();
                }
            }, new c());
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getIntent() != null) {
            this.C = getIntent().getBooleanExtra("is_real_auth", false);
            this.D = getIntent().getIntExtra("pwd_type", -1);
        }
        if (!this.C) {
            com.qwallet.activity.patternlock.biz.a b16 = com.qwallet.activity.patternlock.biz.c.a().b(0);
            this.E = b16;
            b16.e(new WeakReference<>(getActivity()));
            PatternLockHelper.d(getContext(), 230, null, String.format(getContext().getString(R.string.f179713_4), qh(this.D)), getContext().getString(R.string.cancel), getContext().getString(R.string.f179703_3), new a(), new b());
        }
    }
}
