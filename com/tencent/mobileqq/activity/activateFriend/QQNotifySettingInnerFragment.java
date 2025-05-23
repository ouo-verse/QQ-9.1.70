package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQNotifySettingInnerFragment extends QQNotifySettingBaseFragment {
    static IPatchRedirector $redirector_;
    private ScrollView V;
    private ImageView W;
    private ImageView X;
    private TextView Y;
    private TextView Z;

    public QQNotifySettingInnerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void Hh() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        this.V.post(new Runnable(translateAnimation) { // from class: com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TranslateAnimation f177880d;

            {
                this.f177880d = translateAnimation;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQNotifySettingInnerFragment.this, (Object) translateAnimation);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    QQNotifySettingInnerFragment.this.V.setVisibility(0);
                    QQNotifySettingInnerFragment.this.V.startAnimation(this.f177880d);
                }
            }
        });
    }

    public static void Ih(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_msgid", str);
        intent.putExtra("key_busid", str2);
        intent.putExtra("key_domain", str3);
        PublicFragmentActivity.b.d(activity, intent, PublicTransFragmentActivity.class, QQNotifySettingInnerFragment.class, QQNotifySettingBaseFragment.U);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
    public View Ch(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
        return layoutInflater.inflate(R.layout.cam, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
    public void Eh(AcsGetMsgRsp acsGetMsgRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) acsGetMsgRsp);
        } else {
            super.Eh(acsGetMsgRsp);
            Hh();
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void Jf() {
        Context baseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (getBaseActivity() == null) {
            baseActivity = BaseApplication.getContext();
        } else {
            baseActivity = getBaseActivity();
        }
        if (baseActivity == null) {
            return;
        }
        QQToast.makeText(baseActivity, HardCodeUtil.qqStr(R.string.qye), 0).show();
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
            this.G.setText(HardCodeUtil.qqStr(R.string.qyc));
            this.Y.setText(HardCodeUtil.qqStr(R.string.qya));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = this.X.getHeight();
            obtain.mRequestWidth = this.X.getWidth();
            URLDrawable drawable = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_623df8b3818ab2d06b9511a3c38871ec.png", obtain);
            if (drawable != null) {
                if (drawable.getStatus() == 2) {
                    drawable.restartDownload();
                }
                this.X.setImageDrawable(drawable);
                return;
            }
            return;
        }
        if (i3 != 2) {
            Ah(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void id(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
        } else if (getBaseActivity() != null) {
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
            TextView textView = (TextView) this.D.findViewById(R.id.f167042k73);
            this.Z = textView;
            textView.setVisibility(8);
            ((LinearLayout) this.D.findViewById(R.id.lnu)).setVisibility(0);
            ImageView imageView = (ImageView) this.D.findViewById(R.id.lnv);
            this.X = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = UIUtils.b(getBaseActivity(), 86.0f);
            obtain.mRequestWidth = UIUtils.b(getBaseActivity(), 86.0f);
            URLDrawable drawable = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_c180abdeaa834c09173949780f36b7a6.png", obtain);
            if (drawable != null) {
                if (drawable.getStatus() == 2) {
                    drawable.restartDownload();
                }
                this.X.setImageDrawable(drawable);
            }
            this.Y = (TextView) this.D.findViewById(R.id.lnw);
            ImageView imageView2 = (ImageView) this.D.findViewById(R.id.aga);
            this.W = imageView2;
            imageView2.setOnClickListener(this);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
