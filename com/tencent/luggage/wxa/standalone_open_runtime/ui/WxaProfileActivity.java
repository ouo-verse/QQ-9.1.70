package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.bk.e;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.i3.t;
import com.tencent.luggage.wxa.k7.f;
import com.tencent.luggage.wxa.mo.a0;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u0006\n\u0002\b\u0014\u0018\u0000 G2\u00020\u0001:\u0002GHB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR+\u0010&\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00168B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R+\u0010*\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00168B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R+\u00100\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00104\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00168B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010!\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R+\u0010;\u001a\u0002052\u0006\u0010\u001f\u001a\u0002058B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u0010!\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010>\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00168B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b<\u0010!\u001a\u0004\b=\u0010#\"\u0004\b.\u0010%R+\u0010A\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00168B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b?\u0010!\u001a\u0004\b@\u0010#\"\u0004\b9\u0010%R\u0014\u0010D\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity;", "Lcom/tencent/mm/ui/BaseActivity;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onStart", "Landroid/content/Intent;", "intent", "onNewIntent", "", "getLayoutId", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onOptionsItemSelected", "j", "Landroid/view/ViewGroup;", "l", "O", "Landroid/view/ViewGroup;", "root", "", "P", "Ljava/lang/String;", "wxaAppID", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "wxaUsername", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity;", "context", "<set-?>", ExifInterface.LATITUDE_SOUTH, "Lkotlin/properties/ReadWriteProperty;", "getWxaIconUrl", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "wxaIconUrl", "T", "getWxaNickName", "e", "wxaNickName", "U", "getTradingGuaranteeFlag", "()I", "b", "(I)V", "tradingGuaranteeFlag", "V", "getWxaDesc", "c", "wxaDesc", "", "W", "getWxaAverageScore", "()D", "a", "(D)V", "wxaAverageScore", "X", "getRegisterBody", "registerBody", "Y", "getCategory", "category", "k", "()Z", "isMultiTaskModeEnabledForWxaApp", "<init>", "()V", "Companion", "WxaProfileServiceView", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class WxaProfileActivity extends BaseActivity {

    /* renamed from: O, reason: from kotlin metadata */
    public ViewGroup root;

    /* renamed from: P, reason: from kotlin metadata */
    public String wxaAppID;

    /* renamed from: Q, reason: from kotlin metadata */
    public String wxaUsername;

    /* renamed from: R, reason: from kotlin metadata */
    public final WxaProfileActivity context = this;

    /* renamed from: S, reason: from kotlin metadata */
    public final ReadWriteProperty wxaIconUrl;

    /* renamed from: T, reason: from kotlin metadata */
    public final ReadWriteProperty wxaNickName;

    /* renamed from: U, reason: from kotlin metadata */
    public final ReadWriteProperty tradingGuaranteeFlag;

    /* renamed from: V, reason: from kotlin metadata */
    public final ReadWriteProperty wxaDesc;

    /* renamed from: W, reason: from kotlin metadata */
    public final ReadWriteProperty wxaAverageScore;

    /* renamed from: X, reason: from kotlin metadata */
    public final ReadWriteProperty registerBody;

    /* renamed from: Y, reason: from kotlin metadata */
    public final ReadWriteProperty category;
    public static final /* synthetic */ KProperty[] Z = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "wxaIconUrl", "getWxaIconUrl()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "wxaNickName", "getWxaNickName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "tradingGuaranteeFlag", "getTradingGuaranteeFlag()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "wxaDesc", "getWxaDesc()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "wxaAverageScore", "getWxaAverageScore()D", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "registerBody", "getRegisterBody()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(WxaProfileActivity.class, "category", "getCategory()Ljava/lang/String;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$Companion;", "", "()V", "KEY_APPID", "", "KEY_HOST_NATIVE_EXTRA_DATA", "TAG", "show", "", "ctx", "Landroid/content/Context;", "wxaAppID", "hostNativeExtraData", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, String str2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            companion.show(context, str, str2);
        }

        @JvmStatic
        public final void show(@NotNull Context ctx, @NotNull String wxaAppID, @Nullable String hostNativeExtraData) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
            Intent intent = new Intent(ctx, (Class<?>) WxaProfileActivity.class);
            if (!(ctx instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("_key_appid", wxaAppID);
            intent.putExtra("_key_host_native_extra_data", hostNativeExtraData);
            b.a(ctx, intent);
            ctx.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$WxaProfileServiceView;", "Landroid/widget/LinearLayout;", "", "value", "a", "Ljava/lang/String;", "getItemHeader", "()Ljava/lang/String;", "setItemHeader", "(Ljava/lang/String;)V", "itemHeader", "b", "getItemDesc", "setItemDesc", "itemDesc", "c", "getHeaderName", "setHeaderName", "headerName", "d", "getDescName", "setDescName", "descName", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;)V", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class WxaProfileServiceView extends LinearLayout {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public String itemHeader;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public String itemDesc;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public String headerName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public String descName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WxaProfileServiceView(@NotNull Context ctx) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.itemHeader = "";
            this.itemDesc = "";
            this.headerName = "service_header";
            this.descName = "service_desc";
            setBackgroundColor(a0.b(ctx, R.color.f158017al3));
            setOrientation(0);
            Constructor declaredConstructor = TextView.class.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            View view = (View) declaredConstructor.newInstance(getContext());
            Intrinsics.checkNotNullExpressionValue(view, "view");
            TextView textView = (TextView) view;
            a0.c(textView, this.headerName);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(a0.c(ctx, R.dimen.bht));
            layoutParams.setMarginEnd(a0.c(ctx, R.dimen.bht));
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(8388627);
            textView.setTextColor(a0.b(ctx, R.color.f156614aj0));
            textView.setTextSize(0, a0.c(ctx, R.dimen.bl_));
            addView(view);
            Constructor declaredConstructor2 = TextView.class.getDeclaredConstructor(Context.class);
            declaredConstructor2.setAccessible(true);
            View view2 = (View) declaredConstructor2.newInstance(getContext());
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            TextView textView2 = (TextView) view2;
            a0.c(textView2, this.descName);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams2.setMarginStart(a0.c(ctx, R.dimen.bht));
            layoutParams2.setMarginEnd(a0.c(ctx, R.dimen.bht));
            layoutParams2.gravity = 8388627;
            textView2.setLayoutParams(layoutParams2);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(a0.b(ctx, R.color.f156614aj0));
            textView2.setTextSize(0, a0.c(ctx, R.dimen.bl_));
            textView2.setGravity(8388627);
            addView(view2);
        }

        @NotNull
        public final String getDescName() {
            return this.descName;
        }

        @NotNull
        public final String getHeaderName() {
            return this.headerName;
        }

        @NotNull
        public final String getItemDesc() {
            return this.itemDesc;
        }

        @NotNull
        public final String getItemHeader() {
            return this.itemHeader;
        }

        public final void setDescName(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ((TextView) a0.a(this, this.descName)).setId(value.hashCode());
            this.descName = value;
        }

        public final void setHeaderName(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ((TextView) a0.a(this, this.headerName)).setId(value.hashCode());
            this.headerName = value;
        }

        public final void setItemDesc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ((TextView) a0.a(this, this.descName)).setText(value);
            this.itemDesc = value;
        }

        public final void setItemHeader(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ((TextView) a0.a(this, this.headerName)).setText(value);
            this.itemHeader = value;
        }
    }

    public WxaProfileActivity() {
        Delegates delegates = Delegates.INSTANCE;
        final String str = "";
        this.wxaIconUrl = new ObservableProperty<String>(str) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, String oldValue, String newValue) {
                ViewGroup viewGroup;
                Intrinsics.checkNotNullParameter(property, "property");
                String str2 = newValue;
                AppBrandSimpleImageLoader instance = AppBrandSimpleImageLoader.instance();
                viewGroup = this.root;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                instance.attach((ImageView) a0.a(viewGroup, "wxa_icon"), str2, R.drawable.ojy, new WxaIconTransformation());
            }
        };
        this.wxaNickName = new ObservableProperty<String>(str) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, String oldValue, String newValue) {
                ViewGroup viewGroup;
                Intrinsics.checkNotNullParameter(property, "property");
                String str2 = newValue;
                viewGroup = this.root;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                ((TextView) a0.a(viewGroup, "wxa_name")).setText(str2);
            }
        };
        final int i3 = 0;
        this.tradingGuaranteeFlag = new ObservableProperty<Integer>(i3) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, Integer oldValue, Integer newValue) {
                ViewGroup viewGroup;
                int i16;
                ViewGroup viewGroup2;
                int c16;
                Intrinsics.checkNotNullParameter(property, "property");
                int intValue = newValue.intValue();
                oldValue.intValue();
                viewGroup = this.root;
                ViewGroup viewGroup3 = null;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                ImageView imageView = (ImageView) a0.a(viewGroup, "trading_guarantee_icon");
                if (intValue == 1) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
                viewGroup2 = this.root;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                } else {
                    viewGroup3 = viewGroup2;
                }
                TextView textView = (TextView) a0.a(viewGroup3, "wxa_desc");
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                if (intValue == 1) {
                    c16 = a0.c(this, R.dimen.bht);
                } else {
                    c16 = a0.c(this, R.dimen.bi8);
                }
                layoutParams2.topMargin = c16;
                textView.setLayoutParams(layoutParams2);
            }
        };
        this.wxaDesc = new ObservableProperty<String>(str) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, String oldValue, String newValue) {
                ViewGroup viewGroup;
                boolean isBlank;
                int i16;
                Intrinsics.checkNotNullParameter(property, "property");
                String str2 = newValue;
                viewGroup = this.root;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                TextView textView = (TextView) a0.a(viewGroup, "wxa_desc");
                textView.setText(str2);
                isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                textView.setVisibility(i16);
            }
        };
        final Double valueOf = Double.valueOf(0.0d);
        this.wxaAverageScore = new ObservableProperty<Double>(valueOf) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, Double oldValue, Double newValue) {
                ViewGroup viewGroup;
                ViewGroup viewGroup2;
                ViewGroup viewGroup3;
                ViewGroup viewGroup4;
                boolean z16;
                Intrinsics.checkNotNullParameter(property, "property");
                double doubleValue = newValue.doubleValue();
                oldValue.doubleValue();
                String valueOf2 = String.valueOf(doubleValue);
                viewGroup = this.root;
                ViewGroup viewGroup5 = null;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                RatingBar ratingBar = (RatingBar) viewGroup.findViewById(R.id.f87874vj);
                viewGroup2 = this.root;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup2 = null;
                }
                TextView textView = (TextView) a0.a(viewGroup2, "star_not_enough");
                viewGroup3 = this.root;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup3 = null;
                }
                LinearLayout linearLayout = (LinearLayout) a0.a(viewGroup3, "star_layout");
                viewGroup4 = this.root;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                } else {
                    viewGroup5 = viewGroup4;
                }
                TextView textView2 = (TextView) a0.a(viewGroup5, TuxQuestionType.QUESTION_STAR_TEXT);
                if (doubleValue > 0.0d) {
                    textView.setVisibility(8);
                    linearLayout.setVisibility(0);
                    textView2.setText(valueOf2);
                    ratingBar.setRating((float) doubleValue);
                    return;
                }
                if (doubleValue == 0.0d) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    linearLayout.setVisibility(8);
                    textView.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                    linearLayout.setVisibility(8);
                    textView.setVisibility(8);
                }
            }
        };
        this.registerBody = new ObservableProperty<String>(str) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, String oldValue, String newValue) {
                ViewGroup viewGroup;
                Intrinsics.checkNotNullParameter(property, "property");
                String str2 = newValue;
                viewGroup = this.root;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                ((TextView) a0.a(viewGroup, "service_desc")).setText(str2);
            }
        };
        this.category = new ObservableProperty<String>(str) { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$special$$inlined$observable$7
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, String oldValue, String newValue) {
                ViewGroup viewGroup;
                Intrinsics.checkNotNullParameter(property, "property");
                String str2 = newValue;
                viewGroup = this.root;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    viewGroup = null;
                }
                ((TextView) a0.a(viewGroup, "service_category")).setText(str2);
            }
        };
    }

    @Override // com.tencent.mm.ui.BaseActivity
    public int getLayoutId() {
        return R.layout.f168246fg2;
    }

    public final void j() {
        String stringExtra = getIntent().getStringExtra("_key_appid");
        if (stringExtra != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new WxaProfileActivity$fillData$1$1(stringExtra, this, null), 3, null);
        }
    }

    public final boolean k() {
        com.tencent.luggage.wxaapi.a debugApi;
        s d16 = s.d.f138074a.d();
        if (d16 != null && (debugApi = d16.getDebugApi()) != null && debugApi.isMultiTaskModeEnabledForWxaApp()) {
            return true;
        }
        return false;
    }

    public final ViewGroup l() {
        ScrollView scrollView = new ScrollView(this.context);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        scrollView.setBackgroundResource(R.color.f157020hq);
        scrollView.setFillViewport(true);
        Constructor declaredConstructor = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor.setAccessible(true);
        View view = (View) declaredConstructor.newInstance(scrollView.getContext());
        Intrinsics.checkNotNullExpressionValue(view, "view");
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.setFocusableInTouchMode(true);
        linearLayout.setFocusable(true);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(a0.b(this, R.color.agr));
        Constructor declaredConstructor2 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor2.setAccessible(true);
        View view2 = (View) declaredConstructor2.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        LinearLayout linearLayout2 = (LinearLayout) view2;
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        Unit unit = Unit.INSTANCE;
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundColor(a0.b(this, R.color.f158017al3));
        Constructor declaredConstructor3 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor3.setAccessible(true);
        View view3 = (View) declaredConstructor3.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        ImageView imageView = (ImageView) view3;
        a0.c(imageView, "wxa_icon");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a0.c(this, R.dimen.f158084bj0), a0.c(this, R.dimen.f158084bj0));
        layoutParams2.topMargin = a0.c(this, R.dimen.bht);
        layoutParams2.gravity = 1;
        imageView.setLayoutParams(layoutParams2);
        linearLayout2.addView(view3);
        Constructor declaredConstructor4 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor4.setAccessible(true);
        View view4 = (View) declaredConstructor4.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view4, "view");
        TextView textView = (TextView) view4;
        a0.c(textView, "wxa_name");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.topMargin = a0.c(this, R.dimen.bht);
        layoutParams3.setMarginStart(a0.c(this, R.dimen.bir));
        layoutParams3.setMarginEnd(a0.c(this, R.dimen.bir));
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(0, a0.c(this, R.dimen.bl_));
        textView.setTextColor(a0.b(this, R.color.c7u));
        textView.setGravity(17);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(textView.getTypeface(), 1);
        linearLayout2.addView(view4);
        Constructor declaredConstructor5 = ImageView.class.getDeclaredConstructor(Context.class);
        declaredConstructor5.setAccessible(true);
        View view5 = (View) declaredConstructor5.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view5, "view");
        ImageView imageView2 = (ImageView) view5;
        a0.c(imageView2, "trading_guarantee_icon");
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(a0.c(this, R.dimen.bgn), a0.c(this, R.dimen.bi8));
        layoutParams4.gravity = 1;
        layoutParams4.topMargin = a0.c(this, R.dimen.bh9);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setVisibility(8);
        imageView2.setBackgroundResource(R.drawable.og9);
        linearLayout2.addView(view5);
        Constructor declaredConstructor6 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor6.setAccessible(true);
        View view6 = (View) declaredConstructor6.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view6, "view");
        TextView textView2 = (TextView) view6;
        a0.c(textView2, "wxa_desc");
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 1;
        layoutParams5.setMarginStart(a0.c(this, R.dimen.bir));
        layoutParams5.setMarginEnd(a0.c(this, R.dimen.bir));
        layoutParams5.topMargin = a0.c(this, R.dimen.bht);
        textView2.setLayoutParams(layoutParams5);
        textView2.setLineSpacing(0.0f, 1.4f);
        textView2.setTextSize(0, a0.a(this, 15));
        textView2.setTextColor(a0.b(this, R.color.f156614aj0));
        textView2.setGravity(17);
        linearLayout2.addView(view6);
        Constructor declaredConstructor7 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor7.setAccessible(true);
        View view7 = (View) declaredConstructor7.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view7, "view");
        TextView textView3 = (TextView) view7;
        a0.c(textView3, "star_not_enough");
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 1;
        layoutParams6.setMarginStart(a0.c(this, R.dimen.bir));
        layoutParams6.setMarginEnd(a0.c(this, R.dimen.bir));
        layoutParams6.topMargin = a0.c(this, R.dimen.bht);
        textView3.setLayoutParams(layoutParams6);
        textView3.setGravity(17);
        textView3.setTextSize(0, a0.a(this, 15));
        textView3.setText(a0.e(this, R.string.f242497uq));
        textView3.setTextColor(a0.b(this, R.color.bgr));
        textView3.setVisibility(8);
        linearLayout2.addView(view7);
        Constructor declaredConstructor8 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor8.setAccessible(true);
        View view8 = (View) declaredConstructor8.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view8, "view");
        LinearLayout linearLayout3 = (LinearLayout) view8;
        a0.c(linearLayout3, "star_layout");
        linearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, a0.a(this, 20));
        layoutParams7.gravity = 17;
        layoutParams7.topMargin = a0.c(this, R.dimen.bht);
        linearLayout3.setLayoutParams(layoutParams7);
        linearLayout3.setGravity(17);
        Constructor declaredConstructor9 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor9.setAccessible(true);
        View view9 = (View) declaredConstructor9.newInstance(linearLayout3.getContext());
        Intrinsics.checkNotNullExpressionValue(view9, "view");
        TextView textView4 = (TextView) view9;
        a0.c(textView4, TuxQuestionType.QUESTION_STAR_TEXT);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 17;
        textView4.setLayoutParams(layoutParams8);
        textView4.setTextSize(0, a0.c(this, R.dimen.bl_));
        textView4.setTextColor(a0.b(this, R.color.c7u));
        textView4.setText("3.5");
        textView4.setTypeface(textView4.getTypeface(), 1);
        textView4.setGravity(17);
        linearLayout3.addView(view9);
        LayoutInflater.from(linearLayout3.getContext()).inflate(R.layout.f168247fg3, (ViewGroup) linearLayout3, true);
        linearLayout3.setVisibility(8);
        linearLayout2.addView(view8);
        Constructor declaredConstructor10 = LinearLayout.class.getDeclaredConstructor(Context.class);
        declaredConstructor10.setAccessible(true);
        View view10 = (View) declaredConstructor10.newInstance(linearLayout2.getContext());
        Intrinsics.checkNotNullExpressionValue(view10, "view");
        LinearLayout linearLayout4 = (LinearLayout) view10;
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.gravity = 1;
        layoutParams9.topMargin = a0.c(this, R.dimen.bi8);
        layoutParams9.bottomMargin = a0.c(this, R.dimen.bi8);
        linearLayout4.setLayoutParams(layoutParams9);
        Constructor declaredConstructor11 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor11.setAccessible(true);
        View view11 = (View) declaredConstructor11.newInstance(linearLayout4.getContext());
        Intrinsics.checkNotNullExpressionValue(view11, "view");
        TextView textView5 = (TextView) view11;
        a0.c(textView5, "enter_app_bt");
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        int c16 = a0.c(this, R.dimen.bht);
        textView5.setPadding(c16, c16, c16, c16);
        textView5.setLayoutParams(layoutParams10);
        textView5.setText(a0.e(this, R.string.f242457um));
        textView5.setTypeface(textView5.getTypeface(), 1);
        textView5.setTextColor(a0.b(this, R.color.b_2));
        textView5.setTextSize(0, a0.a(this, 17));
        textView5.setBackground(getDrawable(R.drawable.lka));
        linearLayout4.addView(view11);
        Constructor declaredConstructor12 = View.class.getDeclaredConstructor(Context.class);
        declaredConstructor12.setAccessible(true);
        View view12 = (View) declaredConstructor12.newInstance(linearLayout4.getContext());
        Intrinsics.checkNotNullExpressionValue(view12, "view");
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(a0.a(this, 1), -1);
        layoutParams11.topMargin = a0.c(this, R.dimen.bht);
        layoutParams11.bottomMargin = a0.c(this, R.dimen.bht);
        layoutParams11.setMarginStart(a0.c(this, R.dimen.bif));
        layoutParams11.setMarginEnd(a0.c(this, R.dimen.bif));
        view12.setLayoutParams(layoutParams11);
        view12.setBackgroundColor(a0.b(this, R.color.ahy));
        linearLayout4.addView(view12);
        Constructor declaredConstructor13 = TextView.class.getDeclaredConstructor(Context.class);
        declaredConstructor13.setAccessible(true);
        View view13 = (View) declaredConstructor13.newInstance(linearLayout4.getContext());
        Intrinsics.checkNotNullExpressionValue(view13, "view");
        TextView textView6 = (TextView) view13;
        a0.c(textView6, "enter_wechat");
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        int c17 = a0.c(this, R.dimen.bht);
        textView6.setPadding(c17, c17, c17, c17);
        textView6.setLayoutParams(layoutParams12);
        textView6.setText(a0.e(this, R.string.f242467un));
        textView6.setTypeface(textView6.getTypeface(), 1);
        textView6.setTextColor(a0.b(this, R.color.b_2));
        textView6.setTextSize(0, a0.a(this, 17));
        textView6.setBackground(getDrawable(R.drawable.lka));
        linearLayout4.addView(view13);
        linearLayout2.addView(view10);
        linearLayout.addView(view2);
        Constructor declaredConstructor14 = View.class.getDeclaredConstructor(Context.class);
        declaredConstructor14.setAccessible(true);
        View view14 = (View) declaredConstructor14.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view14, "view");
        view14.setLayoutParams(new LinearLayout.LayoutParams(-1, a0.c(this, R.dimen.bj8)));
        linearLayout.addView(view14);
        Constructor declaredConstructor15 = WxaProfileServiceView.class.getDeclaredConstructor(Context.class);
        declaredConstructor15.setAccessible(true);
        View view15 = (View) declaredConstructor15.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view15, "view");
        WxaProfileServiceView wxaProfileServiceView = (WxaProfileServiceView) view15;
        wxaProfileServiceView.setLayoutParams(new LinearLayout.LayoutParams(-1, a0.a(this, 52)));
        String string = wxaProfileServiceView.getContext().getString(R.string.f242487up);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026profile_service_category)");
        wxaProfileServiceView.setItemHeader(string);
        wxaProfileServiceView.setItemDesc("");
        wxaProfileServiceView.setDescName("service_category");
        linearLayout.addView(view15);
        Constructor declaredConstructor16 = View.class.getDeclaredConstructor(Context.class);
        declaredConstructor16.setAccessible(true);
        View view16 = (View) declaredConstructor16.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view16, "view");
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams13.setMarginStart(a0.c(this, R.dimen.bht));
        view16.setLayoutParams(layoutParams13);
        view16.setBackgroundColor(a0.b(this, R.color.ahy));
        linearLayout.addView(view16);
        Constructor declaredConstructor17 = WxaProfileServiceView.class.getDeclaredConstructor(Context.class);
        declaredConstructor17.setAccessible(true);
        View view17 = (View) declaredConstructor17.newInstance(linearLayout.getContext());
        Intrinsics.checkNotNullExpressionValue(view17, "view");
        WxaProfileServiceView wxaProfileServiceView2 = (WxaProfileServiceView) view17;
        wxaProfileServiceView2.setLayoutParams(new LinearLayout.LayoutParams(-1, a0.a(this, 52)));
        String string2 = wxaProfileServiceView2.getContext().getString(R.string.f242507ur);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026xa_proflie_register_body)");
        wxaProfileServiceView2.setItemHeader(string2);
        wxaProfileServiceView2.setItemDesc("");
        wxaProfileServiceView2.setDescName("service_desc");
        linearLayout.addView(view17);
        scrollView.addView(view);
        return scrollView;
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.adj);
        super.onCreate(savedInstanceState);
        ViewGroup l3 = l();
        this.root = l3;
        ViewGroup viewGroup = null;
        if (l3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            l3 = null;
        }
        setContentView(l3, new ViewGroup.LayoutParams(-1, -1));
        setBackBtn(new MenuItem.OnMenuItemClickListener() { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$onCreate$1
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(@NotNull MenuItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WxaProfileActivity.this.onBackPressed();
                return true;
            }
        }, 0, BaseActivity.h.BACK);
        if (!com.tencent.luggage.wxa.q7.b.a(this)) {
            finish();
            return;
        }
        j();
        ViewGroup viewGroup2 = this.root;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            viewGroup2 = null;
        }
        ((TextView) a0.a(viewGroup2, "enter_app_bt")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$onCreate$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                boolean k3;
                boolean k16;
                WxaProfileActivity wxaProfileActivity = WxaProfileActivity.this;
                com.tencent.luggage.wxa.d6.b bVar = new com.tencent.luggage.wxa.d6.b();
                WxaProfileActivity wxaProfileActivity2 = WxaProfileActivity.this;
                str = wxaProfileActivity2.wxaAppID;
                String str2 = null;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("wxaAppID");
                    str = null;
                }
                bVar.f124086d = str;
                bVar.f124090h = 0;
                bVar.f124095m = s.f.f138080a.a();
                k3 = wxaProfileActivity2.k();
                bVar.f124098p = !k3;
                Intent intent = wxaProfileActivity2.getIntent();
                if (intent != null) {
                    str2 = intent.getStringExtra("_key_host_native_extra_data");
                }
                bVar.f124100r = str2;
                e eVar = new e();
                eVar.f122984c = 1024;
                Unit unit = Unit.INSTANCE;
                t.a(wxaProfileActivity, bVar, eVar, null, false, 24, null);
                k16 = WxaProfileActivity.this.k();
                if (!k16) {
                    WxaProfileActivity.this.finish();
                    f.f131770a.b(WxaProfileActivity.this);
                }
            }
        });
        ViewGroup viewGroup3 = this.root;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            viewGroup = viewGroup3;
        }
        ((TextView) a0.a(viewGroup, "enter_wechat")).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$onCreate$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str;
                String str2;
                String str3;
                str = WxaProfileActivity.this.wxaAppID;
                if (str != null) {
                    str2 = WxaProfileActivity.this.wxaUsername;
                    if (str2 != null) {
                        WxaEnterWechatInvokeManager wxaEnterWechatInvokeManager = WxaEnterWechatInvokeManager.f140737a;
                        str3 = WxaProfileActivity.this.wxaAppID;
                        if (str3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("wxaAppID");
                            str3 = null;
                        }
                        final WxaProfileActivity wxaProfileActivity = WxaProfileActivity.this;
                        wxaEnterWechatInvokeManager.a(str3, wxaProfileActivity, "sdk_openAppProfile", new Function0<String>() { // from class: com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity$onCreate$3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                String str4;
                                String trimIndent;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("\n                    {\n                        \"username\": \"");
                                str4 = WxaProfileActivity.this.wxaUsername;
                                if (str4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("wxaUsername");
                                    str4 = null;
                                }
                                sb5.append(str4);
                                sb5.append("\"\n                    }\n                    ");
                                trimIndent = StringsKt__IndentKt.trimIndent(sb5.toString());
                                return trimIndent;
                            }
                        });
                    }
                }
            }
        });
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            Intrinsics.checkNotNull(supportActionBar);
            supportActionBar.setElevation(0.0f);
        }
        setActionBarColor(a0.b(this.context, R.color.agv));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        if (!isFinishing()) {
            j();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        View decorView;
        super.onStart();
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-257));
        }
    }

    public final void e(String str) {
        this.wxaNickName.setValue(this, Z[1], str);
    }

    public final void b(int i3) {
        this.tradingGuaranteeFlag.setValue(this, Z[2], Integer.valueOf(i3));
    }

    public final void c(String str) {
        this.wxaDesc.setValue(this, Z[3], str);
    }

    public final void d(String str) {
        this.wxaIconUrl.setValue(this, Z[0], str);
    }

    public final void b(String str) {
        this.registerBody.setValue(this, Z[5], str);
    }

    public final void a(double d16) {
        this.wxaAverageScore.setValue(this, Z[4], Double.valueOf(d16));
    }

    public final void a(String str) {
        this.category.setValue(this, Z[6], str);
    }
}
