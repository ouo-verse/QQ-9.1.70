package com.tencent.mobileqq.guild.profile.profilecard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.er;
import com.tencent.mobileqq.qqguildsdk.data.et;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001\bB'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/widget/GiftLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "", "iconId", "", "str", "", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/er;", "giftData", "b", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/profile/profilecard/widget/TextImageView;", "d", "Lcom/tencent/mobileqq/guild/profile/profilecard/widget/TextImageView;", "charmView", "e", "starView", "f", "Ljava/lang/String;", "charmText", h.F, "charmToastMsg", "i", "starText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "starToastMsg", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GiftLayout extends RelativeLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextImageView charmView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextImageView starView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String charmText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String charmToastMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String starText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String starToastMsg;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(int iconId, String str) {
        if (!StringUtil.isEmpty(str)) {
            QQToast qQToast = new QQToast(getContext());
            qQToast.setToastIcon(iconId);
            qQToast.setToastMsg(str);
            qQToast.setDuration(0);
            qQToast.show();
        }
    }

    public final void b(@NotNull er giftData) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(giftData, "giftData");
        et b16 = giftData.b();
        String str4 = null;
        if (b16 != null) {
            str = b16.b();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = "";
        }
        this.charmText = str;
        et b17 = giftData.b();
        if (b17 != null) {
            str2 = b17.a();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.charmToastMsg = str2;
        et a16 = giftData.a();
        if (a16 != null) {
            str3 = a16.b();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        this.starText = str3;
        et a17 = giftData.a();
        if (a17 != null) {
            str4 = a17.a();
        }
        if (str4 != null) {
            str5 = str4;
        }
        this.starToastMsg = str5;
        this.charmView.setText(this.charmText);
        this.starView.setText(this.starText);
        QLog.d("GiftLayout", 1, "updateUI charmText-" + this.charmText + " starText-" + this.starText);
        if (StringUtil.isEmpty(this.charmText)) {
            this.charmView.setVisibility(8);
        }
        if (StringUtil.isEmpty(this.starText)) {
            this.starView.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.c("fastClickGuard")) {
            if (Intrinsics.areEqual(v3, this.charmView)) {
                a(R.drawable.guild_personal_gift_charm, this.charmToastMsg);
            } else if (Intrinsics.areEqual(v3, this.starView)) {
                a(R.drawable.guild_personal_gift_star, this.starToastMsg);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GiftLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.charmText = "";
        this.charmToastMsg = "";
        this.starText = "";
        this.starToastMsg = "";
        View.inflate(context, R.layout.f2m, this);
        View findViewById = findViewById(R.id.w2g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_charm_value)");
        TextImageView textImageView = (TextImageView) findViewById;
        this.charmView = textImageView;
        View findViewById2 = findViewById(R.id.x1b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_start_value)");
        TextImageView textImageView2 = (TextImageView) findViewById2;
        this.starView = textImageView2;
        textImageView.setOnClickListener(this);
        textImageView2.setOnClickListener(this);
    }
}
