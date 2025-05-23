package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardAniStickerOption extends ForwardBaseOption {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardAniStickerOption.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQCustomDialog qQCustomDialog = ForwardAniStickerOption.this.mConfirmDialog;
                if (qQCustomDialog != null) {
                    qQCustomDialog.hideSoftInputFromWindow();
                    o oVar = new o(ForwardAniStickerOption.this.mConfirmDialog);
                    oVar.m(ForwardAniStickerOption.this.mActivity.getString(R.string.bc8), ForwardAniStickerOption.this.mForwardText);
                    ForwardAniStickerOption.this.mConfirmDialog.addPreviewView(oVar.c());
                    ForwardAniStickerOption.this.reportClickContentAction();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ForwardAniStickerOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        } else {
            this.mSurpportTroopDiscussionTmpConv = true;
            this.mForwardReportType = 11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void adjustDialogProperty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.adjustDialogProperty();
        this.mConfirmDialog.adjustMessageBottomMargin(17.0f);
        this.mConfirmDialog.setMessageTextColor(R.color.f157116k8);
        this.mConfirmDialog.setMessageTextSize(14.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.buildForwardAbility();
        if (this.mIntent.getBooleanExtra("k_dataline", true)) {
            this.mForwardAbilities.add(e.S3);
            this.mForwardAbilities.add(e.X3);
            this.mForwardAbilities.add(e.f211017e4);
        }
        if (this.mIntent.getBooleanExtra("k_smartdevice", false) && allowSmartDeviceAbility()) {
            this.mForwardAbilities.add(e.W3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        LinearLayout linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(0);
        AnimationTextView animationTextView = new AnimationTextView(this.mActivity);
        String dialogContent = getDialogContent();
        if (dialogContent == null) {
            dialogContent = "";
        }
        animationTextView.setText(new QQText(dialogContent, 5, 16));
        animationTextView.setMaxLines(2);
        animationTextView.setEllipsize(TextUtils.TruncateAt.END);
        animationTextView.setTextColor(this.mActivity.getResources().getColorStateList(R.color.f157084jf));
        animationTextView.setTextSize(14.0f);
        ImageView imageView = new ImageView(this.mActivity);
        imageView.setImageResource(R.drawable.forward_dialog_file_arrow_normal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.gravity = 17;
        linearLayout.addView(animationTextView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(8.0f), ViewUtils.dip2px(14.0f));
        layoutParams2.gravity = 17;
        layoutParams2.setMargins(ViewUtils.dip2px(3.0f), 0, 0, 0);
        SimpleModeHelper.s(animationTextView, imageView, layoutParams2);
        linearLayout.addView(imageView, layoutParams2);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        View view = new View(this.mActivity);
        view.setId(R.id.lim);
        SimpleModeHelper.q(view);
        view.setOnClickListener(new a());
        FrameLayout frameLayout = new FrameLayout(this.mActivity);
        int dip2px = ViewUtils.dip2px(20.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 16));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<RecentUser> getForwardRecentList(List<RecentUser> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (recentUser != null && !Utils.J(recentUser.uin) && recentUser.getType() != 1008 && recentUser.getType() != 1021 && recentUser.getType() != 10004 && recentUser.getType() != 7000 && recentUser.getType() != 6004 && recentUser.getType() != 6002 && (recentUser.getType() != 1 || !isHotChat(recentUser.uin))) {
                if (recentUser.getType() != 1006 || isSupportAbility(e.U3)) {
                    if (recentUser.getType() != 9501 && (recentUser.getType() != 0 || !l(recentUser))) {
                        if ((recentUser.getType() != 1004 && recentUser.getType() != 1000) || this.mSurpportTroopDiscussionTmpConv) {
                            arrayList.add(recentUser);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean l(RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) recentUser)).booleanValue();
        }
        return CrmUtils.v(this.app, recentUser.uin, recentUser.getType());
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        SpannableString spannableString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        super.preloadData();
        if (this.mForwardText == null && (spannableString = (SpannableString) this.mExtraData.get(AppConstants.Key.FORWARD_TEXT)) != null) {
            this.mForwardText = spannableString.toString();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.mActivity);
        aliasIntent.putExtras(this.mExtraData);
        ForwardUtils.w(this.app, this.mActivity, this.mAppContext, aliasIntent, null);
        this.mActivity.setResult(-1, aliasIntent);
        this.mActivity.finish();
        return false;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected int realShareToQfav() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int i3 = -1;
        if (QfavBuilder.k0(null, this.mForwardText).C(this.app).e(this.mActivity, this.app.getAccount(), -1, null)) {
            i3 = 0;
        }
        int i16 = i3;
        if (i16 == 0) {
            cooperation.qqfav.d.d(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void sendDatalineSingle(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        } else {
            intent.putExtra("dataline_forward_type", 102);
            intent.putExtra("dataline_forward_text", this.mForwardText);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }
}
