package com.tencent.timi.game.ad.ui.view;

import af4.OperationItem;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.utils.b;
import com.tencent.timi.game.utils.l;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u000fB/\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH$J\b\u0010\u000b\u001a\u00020\nH$J\b\u0010\r\u001a\u00020\fH$J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u0006H&J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0006J\b\u0010\u0014\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0004R\"\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001eR\"\u0010%\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/timi/game/ad/ui/view/BaseOperationSingleItemView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/image/URLImageView;", "igv", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", h.F, "", DomainData.DOMAIN_NAME, "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "c", "Lvn4/a;", "d", "Landroid/widget/TextView;", "e", "", "a", "b", "Laf4/d;", "k", "l", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "g", "()Z", "setMIsLandscape", "(Z)V", "mIsLandscape", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", "f", "Laf4/d;", "()Laf4/d;", "setData", "(Laf4/d;)V", "data", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BaseOperationSingleItemView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable defaultColorDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private OperationItem data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseOperationSingleItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsLandscape = z16;
        this.defaultColorDrawable = new ColorDrawable(Color.parseColor("#00000000"));
        this.data = new OperationItem(0, 0L, 0, null, null, null, null, null, 0, 0, false, null, null, 0, null, 0L, 0L, 0L, 0, 0L, null, null, 4194303, null);
    }

    private final URLDrawable.URLDrawableOptions h(URLImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = this.defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = this.defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        options.mPlayGifImage = true;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    private final void n() {
        l.h("BaseOperationSingleItemView_", 2, "updateTimerView data:" + this.data);
        if (this.data.getETimer() == -1) {
            if (a()) {
                e().setVisibility(8);
                return;
            }
            return;
        }
        long eTimer = this.data.getETimer();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Long l3 = null;
        try {
            Date parse = OperationItem.INSTANCE.c().parse(String.valueOf(eTimer));
            if (parse != null) {
                l3 = Long.valueOf(parse.getTime());
            }
        } catch (Exception unused) {
        }
        if ((l3 == null || l3.longValue() != 0) && l3 != null) {
            l.h("BaseOperationSingleItemView_", 4, "updateTimerView serverTimeStamp:" + serverTimeMillis + ", timerEndTimeStamp:" + l3 + ", data:" + this.data);
            if (serverTimeMillis > l3.longValue()) {
                if (a()) {
                    e().setVisibility(8);
                    return;
                }
                return;
            }
            long longValue = (l3.longValue() - serverTimeMillis) / 1000;
            long j3 = 60;
            long j16 = longValue % j3;
            long j17 = (longValue / j3) % j3;
            long j18 = longValue / 3600;
            l.h("BaseOperationSingleItemView_", 4, "updateTimerView gapTimeInSec:" + longValue + ", hour:" + j18 + ", min:" + j17 + ", sec:" + j16);
            if (j18 > 100) {
                if (a()) {
                    e().setVisibility(8);
                    return;
                }
                return;
            }
            if (j18 == 0) {
                TextView e16 = e();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                e16.setText(format + ":" + format2);
            } else {
                TextView e17 = e();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j18)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                String format4 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17)}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
                String format5 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
                e17.setText(format3 + ":" + format4 + ":" + format5);
            }
            e().setVisibility(0);
            return;
        }
        if (a()) {
            e().setVisibility(8);
        }
    }

    protected boolean a() {
        return true;
    }

    public abstract void b();

    @NotNull
    protected abstract RoundCornerImageView c();

    @NotNull
    protected abstract TimiPicInfo d();

    @NotNull
    protected abstract TextView e();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: f, reason: from getter */
    public final OperationItem getData() {
        return this.data;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getMIsLandscape() {
        return this.mIsLandscape;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        n();
    }

    public final void k(@NotNull OperationItem d16) {
        Intrinsics.checkNotNullParameter(d16, "d");
        this.data = d16;
        i();
    }

    public final void l() {
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        RoundCornerImageView c16 = c();
        c16.setRadius(b.c(4));
        b.f(c16, d(), h(c16));
    }

    public final void setMIsLandscape(boolean z16) {
        this.mIsLandscape = z16;
    }
}
