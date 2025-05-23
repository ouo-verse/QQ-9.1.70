package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQRecurrentNotifySettingFragment extends QQNotifySettingBaseFragment {
    static IPatchRedirector $redirector_;
    private ScrollView V;
    private Button W;
    private ImageView X;
    private TextView Y;

    public QQRecurrentNotifySettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void Hh(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQRecurrentNotifySettingFragment", 2, "setBusinessLogo url is empty");
                return;
            }
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = UIUtils.b(getBaseActivity(), 28.0f);
        obtain.mRequestWidth = UIUtils.b(getBaseActivity(), 28.0f);
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (drawable != null) {
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            this.X.setImageDrawable(drawable);
        }
    }

    private void Ih() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        this.V.post(new Runnable(translateAnimation) { // from class: com.tencent.mobileqq.activity.activateFriend.QQRecurrentNotifySettingFragment.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TranslateAnimation f177881d;

            {
                this.f177881d = translateAnimation;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQRecurrentNotifySettingFragment.this, (Object) translateAnimation);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQRecurrentNotifySettingFragment.this.V.setVisibility(0);
                    QQRecurrentNotifySettingFragment.this.V.startAnimation(this.f177881d);
                }
            }
        });
    }

    public static void Jh(Activity activity, String str, String str2, String str3, int i3) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_msgid", str);
        intent.putExtra("key_busid", str2);
        intent.putExtra("key_domain", str3);
        PublicFragmentActivity.b.d(activity, intent, PublicTransFragmentActivity.class, QQRecurrentNotifySettingFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
    public View Ch(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
        return layoutInflater.inflate(R.layout.gvn, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
    public void Eh(AcsGetMsgRsp acsGetMsgRsp) {
        String format;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) acsGetMsgRsp);
            return;
        }
        if (acsGetMsgRsp != null) {
            if (acsGetMsgRsp.ret_code == 0) {
                String str = "";
                if (TextUtils.isEmpty(acsGetMsgRsp.busi_name)) {
                    format = "";
                } else {
                    format = String.format(this.D.getContext().getString(R.string.f211535l3), acsGetMsgRsp.busi_name);
                }
                if (!TextUtils.isEmpty(acsGetMsgRsp.sub_content)) {
                    str = acsGetMsgRsp.sub_content;
                }
                this.Y.setText(format);
                this.E.setText(str);
                this.G.setEnabled(true);
                Hh(acsGetMsgRsp.busi_logo);
                Ih();
                return;
            }
            this.G.setEnabled(false);
            Jf();
            T6(acsGetMsgRsp.ret_code, acsGetMsgRsp.err_str);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void Jf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            QQToast.makeText(mobileQQ, HardCodeUtil.qqStr(R.string.qye), 0).show();
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void T6(int i3, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.L = z16;
        this.R = i3;
        this.S = str;
        if (z16) {
            this.G.setTag("1");
            Ah(this.R, this.S);
        } else if (i3 != 2) {
            Ah(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void id(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[6];
            boolean z16 = false;
            objArr[0] = "callbackResult getActivity is null:";
            if (getBaseActivity() == null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            objArr[2] = " errorCode=";
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = " msg=";
            objArr[5] = str;
            QLog.d("QQRecurrentNotifySettingFragment", 2, objArr);
        }
        if (getBaseActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra("errorCode", i3);
            intent.putExtra("msg", str);
            getBaseActivity().setResult(-1, intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
        } else {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            this.V = (ScrollView) this.D.findViewById(R.id.f164327rz);
            ((LinearLayout) this.D.findViewById(R.id.lnu)).setVisibility(0);
            ImageView imageView = (ImageView) this.D.findViewById(R.id.lnv);
            this.X = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.Y = (TextView) this.D.findViewById(R.id.lnw);
            Button button = (Button) this.D.findViewById(R.id.aga);
            this.W = button;
            button.setOnClickListener(this);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
