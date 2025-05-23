package com.tencent.mobileqq.selectfriend.processor;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/processor/m;", "Lcom/tencent/mobileqq/selectfriend/processor/d;", "Landroid/app/Activity;", EventKey.ACT, "", "y", "", "isFinish", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "g", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "i", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mApp", "Lmqq/app/AppActivity;", "j", "Lmqq/app/AppActivity;", "mAppActivity", "<init>", "()V", "k", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m extends d {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QQAppInterface mApp;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private AppActivity mAppActivity;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(m this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.t() == null) {
            return;
        }
        QQCustomDialog t16 = this$0.t();
        if (t16 != null) {
            t16.hideSoftInputFromWindow();
        }
        o oVar = new o(this$0.t());
        Activity r16 = this$0.r();
        oVar.m(r16 != null ? r16.getString(R.string.bc8) : null, this$0.u().getString(AppConstants.Key.FORWARD_TEXT));
        QQCustomDialog t17 = this$0.t();
        if (t17 != null) {
            t17.addPreviewView(oVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public boolean C(boolean isFinish, ResultRecord resultRecord) {
        u().putBoolean("is_finish_current_page", isFinish);
        return super.C(isFinish, resultRecord);
    }

    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public QQCustomDialog f() {
        QQCustomDialog f16 = super.f();
        if (f16 != null) {
            f16.adjustMessageBottomMargin(17.0f);
        }
        if (f16 != null) {
            f16.setMessageTextSize(14.0f);
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public View g() {
        Resources resources;
        LinearLayout linearLayout = new LinearLayout(r());
        linearLayout.setOrientation(0);
        AnimationTextView animationTextView = new AnimationTextView(r());
        String string = u().getString(AppConstants.Key.FORWARD_TEXT);
        if (string == null) {
            string = "";
        }
        animationTextView.setText(new QQText(string, 5, 16));
        animationTextView.setMaxLines(2);
        animationTextView.setEllipsize(TextUtils.TruncateAt.END);
        Activity r16 = r();
        animationTextView.setTextColor((r16 == null || (resources = r16.getResources()) == null) ? null : resources.getColorStateList(R.color.f157084jf));
        animationTextView.setTextSize(14.0f);
        ImageView imageView = new ImageView(r());
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
        View view = new View(r());
        view.setId(R.id.lim);
        SimpleModeHelper.q(view);
        Activity r17 = r();
        view.setContentDescription(r17 != null ? r17.getString(R.string.bc8) : null);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.processor.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m.K(m.this, view2);
            }
        });
        if (r() == null) {
            return null;
        }
        Activity r18 = r();
        Intrinsics.checkNotNull(r18);
        FrameLayout frameLayout = new FrameLayout(r18);
        int dip2px = ViewUtils.dip2px(20.0f);
        frameLayout.setPadding(0, dip2px, 0, dip2px);
        frameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 16));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.selectfriend.processor.d
    public void y(Activity act) {
        super.y(act);
        Intrinsics.checkNotNull(act, "null cannot be cast to non-null type mqq.app.AppActivity");
        AppActivity appActivity = (AppActivity) act;
        this.mAppActivity = appActivity;
        AppRuntime appRuntime = appActivity != null ? appActivity.getAppRuntime() : null;
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        this.mApp = (QQAppInterface) appRuntime;
    }
}
