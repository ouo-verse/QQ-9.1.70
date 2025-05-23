package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQNotifySettingFragment extends QQNotifySettingBaseFragment {
    static IPatchRedirector $redirector_;
    private TextView V;
    private LinearLayout W;
    private ImageView X;
    private TextView Y;

    public QQNotifySettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void Gh(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_msgid", URLDecoder.decode(str));
        intent.putExtra("key_busid", URLDecoder.decode(str2));
        intent.putExtra("key_schema", URLDecoder.decode(str3));
        intent.putExtra("key_domain", URLDecoder.decode(str4));
        PublicFragmentActivity.b.a(context, intent, PublicTransFragmentActivity.class, QQNotifySettingFragment.class);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
    public View Ch(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) layoutInflater, (Object) viewGroup);
        }
        return layoutInflater.inflate(R.layout.cal, viewGroup, false);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void Jf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QQToast.makeText(getBaseActivity(), HardCodeUtil.qqStr(R.string.qyb), 0).show();
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.biz.a
    public void T6(int i3, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
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
            this.G.setText(HardCodeUtil.qqStr(R.string.qy8));
            this.V.setText(HardCodeUtil.qqStr(R.string.qyd));
            this.Y.setText(HardCodeUtil.qqStr(R.string.qy_));
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(getArguments().getString("key_schema") + "://?retcode=" + this.R + "&retmsg=" + URLEncoder.encode(this.S)));
        intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
        try {
            startActivity(intent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            super.onClick(view);
            if (view.getId() == R.id.f167033k60) {
                Ah(this.R, this.S);
            }
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
            LinearLayout linearLayout = (LinearLayout) this.D.findViewById(R.id.lnt);
            this.W = linearLayout;
            linearLayout.setVisibility(0);
            this.X = (ImageView) this.D.findViewById(R.id.lnr);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = UIUtils.b(getBaseActivity(), 106.0f);
            obtain.mRequestWidth = UIUtils.b(getBaseActivity(), 195.0f);
            URLDrawable drawable = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201907/upload_a69bf0fc5262c4bc452dd03f6b95a9c0.png", obtain);
            if (drawable != null) {
                this.X.setImageDrawable(drawable);
            }
            this.Y = (TextView) this.D.findViewById(R.id.lns);
            TextView textView = (TextView) this.D.findViewById(R.id.f167033k60);
            this.V = textView;
            textView.setOnClickListener(this);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }
}
