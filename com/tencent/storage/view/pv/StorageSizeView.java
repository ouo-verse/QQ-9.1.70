package com.tencent.storage.view.pv;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.storage.view.rtv.RollingTextView;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/tencent/storage/view/pv/StorageSizeView;", "Landroid/widget/FrameLayout;", "", "qqUsed", "phoneTotal", "", "expand", "", "c", "phoneUsed", "setStorageSize", "a", "Lcom/tencent/storage/view/pv/LoadingProgressView;", "d", "Lcom/tencent/storage/view/pv/LoadingProgressView;", "lpv", "Landroid/view/View;", "e", "Landroid/view/View;", "root", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvStorageDesc", "Lcom/tencent/storage/view/rtv/RollingTextView;", h.F, "Lcom/tencent/storage/view/rtv/RollingTextView;", "rtvStorageSize", "i", "rtvStorageSizeUnit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rtvContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class StorageSizeView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadingProgressView lpv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View root;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView tvStorageDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RollingTextView rtvStorageSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RollingTextView rtvStorageSizeUnit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View rtvContainer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageSizeView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    public static /* synthetic */ void b(StorageSizeView storageSizeView, long j3, long j16, long j17, boolean z16, int i3, Object obj) {
        boolean z17;
        if ((i3 & 8) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        storageSizeView.a(j3, j16, j17, z17);
    }

    private final void c(long qqUsed, long phoneTotal, boolean expand2) {
        CharSequence trim;
        CharSequence trim2;
        CharSequence trim3;
        CharSequence trim4;
        CharSequence trim5;
        CharSequence trim6;
        float f16 = (((float) qqUsed) * 100.0f) / ((float) phoneTotal);
        StringBuilder sb5 = new StringBuilder();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f16)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb5.append(format);
        sb5.append('%');
        this.tvStorageDesc.setText(getContext().getString(R.string.f229136vm, sb5.toString()));
        com.tencent.storage.view.c cVar = com.tencent.storage.view.c.f373802a;
        Pair<String, String> d16 = cVar.d(qqUsed);
        this.rtvContainer.setContentDescription(((String) d16.first) + TokenParser.SP + ((String) d16.second));
        if (expand2) {
            RollingTextView rollingTextView = this.rtvStorageSize;
            Object obj = d16.first;
            Intrinsics.checkNotNullExpressionValue(obj, "qqUsedSizePair.first");
            trim5 = StringsKt__StringsKt.trim((CharSequence) obj);
            rollingTextView.setText(trim5.toString());
            RollingTextView rollingTextView2 = this.rtvStorageSizeUnit;
            Object obj2 = d16.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "qqUsedSizePair.second");
            trim6 = StringsKt__StringsKt.trim((CharSequence) obj2);
            rollingTextView2.setText(trim6.toString());
            return;
        }
        RollingTextView rollingTextView3 = this.rtvStorageSize;
        Object obj3 = d16.first;
        Intrinsics.checkNotNullExpressionValue(obj3, "qqUsedSizePair.first");
        trim = StringsKt__StringsKt.trim((CharSequence) obj3);
        rollingTextView3.setText(cVar.b(trim.toString()), false, false);
        RollingTextView rollingTextView4 = this.rtvStorageSizeUnit;
        Object obj4 = d16.second;
        Intrinsics.checkNotNullExpressionValue(obj4, "qqUsedSizePair.second");
        trim2 = StringsKt__StringsKt.trim((CharSequence) obj4);
        rollingTextView4.setText(cVar.b(trim2.toString()), false, false);
        RollingTextView rollingTextView5 = this.rtvStorageSize;
        Object obj5 = d16.first;
        Intrinsics.checkNotNullExpressionValue(obj5, "qqUsedSizePair.first");
        trim3 = StringsKt__StringsKt.trim((CharSequence) obj5);
        rollingTextView5.setText(trim3.toString(), true, false);
        RollingTextView rollingTextView6 = this.rtvStorageSizeUnit;
        Object obj6 = d16.second;
        Intrinsics.checkNotNullExpressionValue(obj6, "qqUsedSizePair.second");
        trim4 = StringsKt__StringsKt.trim((CharSequence) obj6);
        rollingTextView6.setText(trim4.toString(), true, false);
    }

    public static /* synthetic */ void setStorageSize$default(StorageSizeView storageSizeView, long j3, long j16, long j17, boolean z16, int i3, Object obj) {
        boolean z17;
        if ((i3 & 8) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        storageSizeView.setStorageSize(j3, j16, j17, z17);
    }

    public final void a(long qqUsed, long phoneUsed, long phoneTotal, boolean expand2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(qqUsed), Long.valueOf(phoneUsed), Long.valueOf(phoneTotal), Boolean.valueOf(expand2));
            return;
        }
        float f16 = 100;
        float f17 = (float) phoneTotal;
        this.lpv.n((((float) phoneUsed) * f16) / f17, (((float) qqUsed) * f16) / f17);
        c(qqUsed, phoneTotal, expand2);
    }

    public final void setStorageSize(long qqUsed, long phoneUsed, long phoneTotal, boolean expand2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(qqUsed), Long.valueOf(phoneUsed), Long.valueOf(phoneTotal), Boolean.valueOf(expand2));
            return;
        }
        float f16 = 100;
        float f17 = (float) phoneTotal;
        this.lpv.g((((float) phoneUsed) * f16) / f17, (((float) qqUsed) * f16) / f17);
        c(qqUsed, phoneTotal, expand2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageSizeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ StorageSizeView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StorageSizeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.f169096hr2, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.root)");
        this.root = findViewById;
        View findViewById2 = findViewById(R.id.yva);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.lpv)");
        this.lpv = (LoadingProgressView) findViewById2;
        View findViewById3 = findViewById(R.id.f111566lk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_storage_desc)");
        this.tvStorageDesc = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f785947h);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.rtv_storage_size)");
        this.rtvStorageSize = (RollingTextView) findViewById4;
        View findViewById5 = findViewById(R.id.f785847g);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.rtv_container)");
        this.rtvContainer = findViewById5;
        this.rtvStorageSize.setTextColorStateList(R.color.skin_storage_size_text_color);
        this.rtvStorageSize.setTextSize(1, 41.0f);
        this.rtvStorageSize.setTextFont(PTSNodeTextBase.FONT_FAMILY_SANS_SERIF_MEDIUM);
        View findViewById6 = findViewById(R.id.f786047i);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.rtv_storage_unit)");
        RollingTextView rollingTextView = (RollingTextView) findViewById6;
        this.rtvStorageSizeUnit = rollingTextView;
        rollingTextView.setTextColorStateList(R.color.skin_storage_size_text_color);
        this.rtvStorageSizeUnit.setTextSize(1, 18.0f);
        this.rtvStorageSizeUnit.setTextFont(PTSNodeTextBase.FONT_FAMILY_SANS_SERIF_MEDIUM);
        com.tencent.storage.view.c cVar = com.tencent.storage.view.c.f373802a;
        if (cVar.e((Activity) context)) {
            this.rtvStorageSize.setTextSize(1, 39.0f);
            this.rtvStorageSizeUnit.setTextSize(1, 16.0f);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            int c16 = (int) cVar.c(240.0f, resources);
            ViewGroup.LayoutParams layoutParams = this.lpv.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = c16;
            marginLayoutParams.height = c16;
            this.lpv.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.root.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            marginLayoutParams2.topMargin = (int) cVar.c(10.0f, resources2);
            this.root.setLayoutParams(marginLayoutParams2);
        }
        float f16 = this.rtvStorageSize.g().getFontMetrics().bottom - this.rtvStorageSizeUnit.g().getFontMetrics().bottom;
        ViewGroup.LayoutParams layoutParams3 = this.rtvStorageSizeUnit.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
        marginLayoutParams3.bottomMargin = (int) f16;
        this.rtvStorageSizeUnit.setLayoutParams(marginLayoutParams3);
    }
}
