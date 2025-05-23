package com.tencent.ecommerce.biz.logistics;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.logistics.ECLogisticsTraceAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u001c\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u001c\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/q;", "Lcom/tencent/ecommerce/biz/logistics/o;", "Lcom/tencent/ecommerce/biz/logistics/t;", "", "srcText", "Landroid/text/SpannableString;", DomainData.DOMAIN_NAME, "data", "", "o", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "status", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "statusImage", "G", "time", "H", "desc", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "I", "Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;", "listener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/logistics/ECLogisticsTraceAdapter$ActionListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class q extends o<ShipDetailItemData> {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView status;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView statusImage;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView time;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView desc;

    /* renamed from: I, reason: from kotlin metadata */
    private final ECLogisticsTraceAdapter.ActionListener listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/logistics/q$a", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SpannableString f102914e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f102915f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f102916h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f102917i;

        a(SpannableString spannableString, int i3, int i16, int i17) {
            this.f102914e = spannableString;
            this.f102915f = i3;
            this.f102916h = i16;
            this.f102917i = i17;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            q.this.listener.makePhoneCall(this.f102914e.subSequence(this.f102915f, this.f102916h).toString());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            ds5.setColor(this.f102917i);
            ds5.setUnderlineText(false);
        }
    }

    private final SpannableString n(String srcText) {
        Pattern pattern;
        SpannableString spannableString = new SpannableString(srcText);
        pattern = i.f102906a;
        Matcher matcher = pattern.matcher(srcText);
        int color = ECSkin.INSTANCE.getColor(R.color.f6932w);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            spannableString.setSpan(new a(spannableString, start, end, color), start, end, 34);
        }
        return spannableString;
    }

    @Override // com.tencent.ecommerce.biz.logistics.o
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void l(ShipDetailItemData data) {
        ImageView imageView = this.statusImage;
        ECSkin eCSkin = ECSkin.INSTANCE;
        imageView.setImageDrawable(eCSkin.getDrawable(data.statusIconResId));
        this.time.setText(data.acceptTime);
        this.desc.setText(n(data.acceptStation));
        this.desc.setMovementMethod(LinkMovementMethod.getInstance());
        this.status.setVisibility(data.statusDesc.length() > 0 ? 0 : 8);
        this.status.setText(data.statusDesc);
        int color = eCSkin.getColor(data.getTextColorResID());
        this.time.setTextColor(color);
        this.desc.setTextColor(color);
        this.status.setTextColor(color);
    }

    public q(View view, ECLogisticsTraceAdapter.ActionListener actionListener) {
        super(view, null);
        this.listener = actionListener;
        this.status = (TextView) view.findViewById(R.id.f163105ob4);
        this.statusImage = (ImageView) view.findViewById(R.id.ob5);
        this.time = (TextView) view.findViewById(R.id.oca);
        this.desc = (TextView) view.findViewById(R.id.nv6);
    }
}
