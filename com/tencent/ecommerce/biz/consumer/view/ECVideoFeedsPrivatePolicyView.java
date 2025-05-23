package com.tencent.ecommerce.biz.consumer.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.repo.consumer.resp.GameInfo;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\bB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/view/ECVideoFeedsPrivatePolicyView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "Landroid/text/SpannableString;", "", "target", "url", "", "a", "Landroid/view/View;", "getView", "Lcom/tencent/ecommerce/repo/consumer/resp/GameInfo;", "gameInfo", "configUI", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "lineOne", "e", "lineTwo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECVideoFeedsPrivatePolicyView extends FrameLayout implements IECPrivatePolicyView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView lineOne;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView lineTwo;

    public ECVideoFeedsPrivatePolicyView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.ct5, (ViewGroup) this, true);
        this.lineOne = (TextView) findViewById(R.id.ods);
        this.lineTwo = (TextView) findViewById(R.id.odt);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECPrivatePolicyView
    public void configUI(GameInfo gameInfo) {
        this.lineOne.setText(getContext().getResources().getString(R.string.wpq, gameInfo.getPrivilege().getDeveloper(), gameInfo.getPrivilege().getAppName()));
        TextView textView = this.lineTwo;
        SpannableString spannableString = new SpannableString(getContext().getResources().getString(R.string.wpr, gameInfo.getPrivilege().getVersion()));
        a(spannableString, "\u9690\u79c1\u653f\u7b56", gameInfo.getPrivilege().getPrivatePoliciesUrl());
        a(spannableString, "\u5e94\u7528\u6743\u9650", "https://speed.gamecenter.qq.com/pushgame/v1/detail-permission?_wwv=134&appid=" + gameInfo.getBasic().getAppId());
        Unit unit = Unit.INSTANCE;
        textView.setText(spannableString);
        this.lineTwo.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void a(SpannableString spannableString, String str, final String str2) {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) spannableString, str, 0, false, 6, (Object) null);
        int length = str.length() + indexOf$default;
        if (indexOf$default < 0 || TextUtils.isEmpty(str2)) {
            return;
        }
        spannableString.setSpan(new URLSpan(str2) { // from class: com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsPrivatePolicyView$addUrlSpan$1
            @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
            public void onClick(View widget) {
                ECScheme.g(getURL(), null, 2, null);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds5) {
                super.updateDrawState(ds5);
                ds5.setColor(-1);
            }
        }, indexOf$default, length, 33);
    }

    @Override // com.tencent.ecommerce.biz.consumer.view.IECPrivatePolicyView
    public View getView() {
        return this;
    }
}
