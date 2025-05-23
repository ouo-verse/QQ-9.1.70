package com.tencent.mobileqq.guild.contentshare.template.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.c;
import com.tencent.guild.aio.util.ex.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.component.qrcode.a;
import com.tencent.mobileqq.component.qrcode.d;
import com.tencent.mobileqq.component.qrcode.e;
import com.tencent.mobileqq.component.qrcode.f;
import com.tencent.mobileqq.component.qrcode.i;
import com.tencent.mobileqq.guild.contentshare.template.header.SharePicBottomLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn0.ab;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/header/SharePicBottomLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "e", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "codeView", "c", "", "Lcom/tencent/mobileqq/component/qrcode/f;", "d", h.F, "", "name", "setGuildName", "", NodeProps.VISIBLE, "g", "Landroid/graphics/drawable/Drawable;", "drawable", "setChannelDrawable", "", "url", "setQRCodeUrl", "Lvn0/ab;", "Lvn0/ab;", "binding", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SharePicBottomLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ab binding;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/contentshare/template/header/SharePicBottomLayout$b", "Lcom/tencent/mobileqq/component/qrcode/a;", "", "color", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {
        b(List<f> list) {
            super(list);
        }

        @Override // com.tencent.mobileqq.component.qrcode.a
        @NotNull
        public List<Integer> a(int color) {
            int collectionSizeOrDefault;
            List<f> b16 = b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (f fVar : b16) {
                vd0.b b17 = vd0.b.b(color);
                arrayList.add(Integer.valueOf(vd0.b.a(b17.d(), b17.c(), b17.e()).i()));
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePicBottomLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        e(context);
    }

    private final void c(QUIColorfulQRCodeView codeView) {
        HashMap hashMap = new HashMap();
        float b16 = c.b(3);
        hashMap.put(3, new d(7, 6, b16, 1.5f));
        hashMap.put(4, new d(9, 7, b16, 1.5f));
        codeView.q();
        codeView.e(false);
        codeView.setIsAdjustDarkLogo(false);
        codeView.setTargetGenerateQRCodeParams(new e(3, 4, hashMap, ErrorCorrectionLevel.Q));
        codeView.k(-16777216, new b(d()));
        codeView.g(new i(R.drawable.guild_qrcode_logo, null, null, 0));
    }

    private final List<f> d() {
        List<f> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d)});
        return listOf;
    }

    private final void e(Context context) {
        ab g16 = ab.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        g16.f441907c.setCornerRadiusAndMode(c.b(6), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3) {
        QLog.i("SharePicBottomLayout", 1, "setQRCodeUrl result=" + i3);
    }

    private final void h() {
        post(new Runnable() { // from class: wg1.b
            @Override // java.lang.Runnable
            public final void run() {
                SharePicBottomLayout.i(SharePicBottomLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SharePicBottomLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ab abVar = this$0.binding;
        ab abVar2 = null;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar = null;
        }
        abVar.f441911g.measure(0, 0);
        int measuredWidth = this$0.getMeasuredWidth();
        ab abVar3 = this$0.binding;
        if (abVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar3 = null;
        }
        int measuredWidth2 = measuredWidth - abVar3.f441906b.getMeasuredWidth();
        ab abVar4 = this$0.binding;
        if (abVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar4 = null;
        }
        int measuredWidth3 = (measuredWidth2 - abVar4.f441907c.getMeasuredWidth()) - c.b(18);
        ab abVar5 = this$0.binding;
        if (abVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar5 = null;
        }
        TextPaint paint = abVar5.f441908d.getPaint();
        ab abVar6 = this$0.binding;
        if (abVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar6 = null;
        }
        float measureText = paint.measureText(abVar6.f441908d.getText().toString());
        ab abVar7 = this$0.binding;
        if (abVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar7 = null;
        }
        TextPaint paint2 = abVar7.f441910f.getPaint();
        ab abVar8 = this$0.binding;
        if (abVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar8 = null;
        }
        float measureText2 = paint2.measureText(abVar8.f441910f.getText().toString()) + c.b(16);
        float f16 = measuredWidth3;
        if (f16 < measureText + measureText2) {
            ab abVar9 = this$0.binding;
            if (abVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                abVar9 = null;
            }
            ViewGroup.LayoutParams layoutParams = abVar9.f441908d.getLayoutParams();
            layoutParams.width = (int) (f16 - measureText2);
            ab abVar10 = this$0.binding;
            if (abVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                abVar2 = abVar10;
            }
            abVar2.f441908d.setLayoutParams(layoutParams);
        }
        QLog.i("SharePicBottomLayout", 1, "updateWidth total=" + measuredWidth3 + " channelNameWidth=" + measureText + " medalWidth=" + measureText2 + " width111=" + this$0.getMeasuredWidth());
    }

    public final void g(boolean visible) {
        ab abVar = this.binding;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar = null;
        }
        TextView textView = abVar.f441910f;
        Boolean valueOf = Boolean.valueOf(visible);
        textView.setVisibility(0);
        if (((View) g.a(valueOf, textView)) == null) {
            textView.setVisibility(8);
        }
        if (visible) {
            h();
        }
    }

    public final void setChannelDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ab abVar = this.binding;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar = null;
        }
        abVar.f441907c.setImageDrawable(drawable);
    }

    public final void setGuildName(@NotNull CharSequence name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ab abVar = this.binding;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar = null;
        }
        abVar.f441908d.setText(name);
    }

    public final void setQRCodeUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ab abVar = this.binding;
        ab abVar2 = null;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            abVar = null;
        }
        QUIColorfulQRCodeView qUIColorfulQRCodeView = abVar.f441906b;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView, "binding.QrCodeImg");
        c(qUIColorfulQRCodeView);
        QLog.i("SharePicBottomLayout", 1, "setQRCodeUrl url=" + url);
        ab abVar3 = this.binding;
        if (abVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            abVar2 = abVar3;
        }
        abVar2.f441906b.f(url, new com.tencent.mobileqq.component.qrcode.g() { // from class: wg1.a
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                SharePicBottomLayout.f(i3);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePicBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        e(context);
    }
}
