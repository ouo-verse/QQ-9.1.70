package com.tencent.mobileqq.zplan.card.impl.view.smallhome.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.view.ZplanSmallHomeCardMsgPopItemView;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import fi3.af;
import gi3.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.d;
import pv4.s;
import wf3.g;
import wf3.i;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/view/ZplanSmallHomeCardMsgPopItemView;", "Landroid/widget/LinearLayout;", "Lpv4/d;", "itemData", "", "position", "Lcom/tencent/sqshow/zootopia/data/c;", "cardData", "", "b", "Lfi3/af;", "d", "Lfi3/af;", "viewBinding", "", "e", "Ljava/lang/String;", "lastAvatar", "Lcom/tencent/sqshow/zootopia/card/report/a;", "f", "Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanSmallHomeCardMsgPopItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final af viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String lastAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final a reportHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanSmallHomeCardMsgPopItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        af f16 = af.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.viewBinding = f16;
        this.lastAvatar = "";
        this.reportHelper = new a();
        setBackgroundResource(R.drawable.f159853h12);
        setGravity(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(d itemData, ZplanSmallHomeCardMsgPopItemView this$0, ZootopiaCardData zootopiaCardData, int i3, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i16 = itemData.f427579a;
        if (i16 == 15) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            new g(context, 1).b();
        } else if (i16 == 17) {
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            new i(context2).n();
        } else if (i16 == 19) {
            Context context3 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            new g(context3, 0).b();
        }
        if (zootopiaCardData != null) {
            this$0.reportHelper.a(this$0, 0, i3, "", zootopiaCardData, new s(), new HashMap<>(), "em_zplan_xw_msg_bubble");
        }
    }

    public final void b(final d itemData, final int position, final ZootopiaCardData cardData) {
        String str;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (!Intrinsics.areEqual(this.lastAvatar, itemData.f427588j)) {
            RoundCornerImageView roundCornerImageView = this.viewBinding.f398806b;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "viewBinding.iconAvatar");
            String str2 = itemData.f427588j;
            Intrinsics.checkNotNullExpressionValue(str2, "itemData.avatar");
            CommonExKt.w(roundCornerImageView, str2, null, null, 6, null);
            String str3 = itemData.f427588j;
            Intrinsics.checkNotNullExpressionValue(str3, "itemData.avatar");
            this.lastAvatar = str3;
        }
        this.viewBinding.f398806b.setRadius(com.tencent.sqshow.zootopia.utils.i.e(8));
        a.Companion companion = gi3.a.INSTANCE;
        TextView textView = this.viewBinding.f398808d;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.txtNick");
        String str4 = itemData.f427587i;
        Intrinsics.checkNotNullExpressionValue(str4, "itemData.nickName");
        companion.b(textView, str4, 14);
        TextView textView2 = this.viewBinding.f398807c;
        Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.txtMsg");
        if (itemData.f427579a == 19) {
            str = "\uff1a" + itemData.f427583e;
        } else {
            str = itemData.f427583e;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if(itemData.eventType ==\u2026.msg}\" else  itemData.msg");
        companion.b(textView2, str, 14);
        setOnClickListener(new View.OnClickListener() { // from class: xf3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanSmallHomeCardMsgPopItemView.c(pv4.d.this, this, cardData, position, view);
            }
        });
    }
}
