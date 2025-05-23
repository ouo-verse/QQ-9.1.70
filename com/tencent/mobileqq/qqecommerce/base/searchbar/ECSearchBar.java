package com.tencent.mobileqq.qqecommerce.base.searchbar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import com.tencent.mobileqq.widget.search.SearchController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003-15\u0018\u0000 \u00032\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R4\u0010,\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040(j\u0002`)0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar;", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBar;", "", "j", "", "param", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "l", "p", "Landroid/view/View;", "getView", "", "method", "call", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "b", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "Landroid/widget/EditText;", "c", "Landroid/widget/EditText;", "editText", "Lcom/tencent/mobileqq/search/view/AutoHintLayout;", "d", "Lcom/tencent/mobileqq/search/view/AutoHintLayout;", "autoHintLayout", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBar$Callback;", "e", "Lcom/tencent/ecommerce/base/searchbar/IECSearchBar$Callback;", "callback", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/base/searchbar/CommonMethod;", "f", "Ljava/util/Map;", "methodMap", "com/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$d", "g", "Lcom/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$d;", "textWatcher", "com/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$b", h.F, "Lcom/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$b;", "searchActionCallback", "com/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$c", "i", "Lcom/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$c;", "searchUiResource", "Landroid/app/Activity;", "k", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/content/Context;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECSearchBar implements IECSearchBar {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar searchBar;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private EditText editText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AutoHintLayout autoHintLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IECSearchBar.Callback callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Function1<Object, Object>> methodMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final d textWatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b searchActionCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final c searchUiResource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$b", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements QUISearchBar.ActionCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            IECSearchBar.Callback callback = ECSearchBar.this.callback;
            Object a16 = callback != null ? IECSearchBar.Callback.a.a(callback, IECSearchBar.METHOD_DO_BACK, null, 2, null) : null;
            Boolean bool = a16 instanceof Boolean ? (Boolean) a16 : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            IECSearchBar.Callback callback = ECSearchBar.this.callback;
            if (callback != null) {
                IECSearchBar.Callback.a.a(callback, IECSearchBar.METHOD_DO_CANCEL, null, 2, null);
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            QuickPinyinEditText inputWidget;
            IECSearchBar.Callback callback = ECSearchBar.this.callback;
            Object a16 = callback != null ? IECSearchBar.Callback.a.a(callback, IECSearchBar.METHOD_DO_CLEAR, null, 2, null) : null;
            QUISearchBar qUISearchBar = ECSearchBar.this.searchBar;
            if (qUISearchBar != null && (inputWidget = qUISearchBar.getInputWidget()) != null) {
                inputWidget.requestFocus();
                InputMethodUtil.show(inputWidget);
            }
            Boolean bool = a16 instanceof Boolean ? (Boolean) a16 : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            String str;
            Editable text;
            IECSearchBar.Callback callback = ECSearchBar.this.callback;
            if (callback != null) {
                EditText editText = ECSearchBar.this.editText;
                if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                    str = "";
                }
                callback.call(IECSearchBar.METHOD_DO_SEARCH, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$c", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bar", "Landroid/graphics/drawable/Drawable;", "getBackground", "getInputBackground", "getBackIcon", "getClearIcon", "getSearchIcon", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends QUISearchBarResource {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getBackIcon(QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            Drawable p16 = ie0.a.f().p(bar.getContext(), R.drawable.qui_chevron_left, R.color.qui_common_icon_primary, 1000);
            Intrinsics.checkNotNullExpressionValue(p16, "getInstances().getQuiTok\u2026stants.SKIN\n            )");
            return p16;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getBackground(QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            if (QQTheme.isVasTheme()) {
                return new ColorDrawable(0);
            }
            return new ColorDrawable(ie0.a.f().g(bar.getContext(), R.color.qui_common_fill_light_primary, 1000));
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getClearIcon(QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            Drawable p16 = ie0.a.f().p(bar.getContext(), R.drawable.qui_close_filled, R.color.qui_common_icon_secondary, 1000);
            Intrinsics.checkNotNullExpressionValue(p16, "getInstances().getQuiTok\u2026stants.SKIN\n            )");
            return p16;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getInputBackground(QUISearchBar bar) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(bar, "bar");
            if (QQTheme.isVasTheme() && (drawable = ResourcesCompat.getDrawable(bar.getResources(), R.drawable.skin_searchbar_input_theme_version2, null)) != null) {
                return drawable;
            }
            Drawable k3 = ie0.a.f().k(bar.getContext(), R.color.qui_common_fill_standard_primary, ViewUtils.dpToPx(4.0f), 1000);
            Intrinsics.checkNotNullExpressionValue(k3, "getInstances().getQuiTok\u2026stants.SKIN\n            )");
            return k3;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getSearchIcon(QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            Drawable p16 = ie0.a.f().p(bar.getContext(), R.drawable.qui_search, R.color.qui_common_icon_secondary, 1000);
            Intrinsics.checkNotNullExpressionValue(p16, "getInstances().getQuiTok\u2026stants.SKIN\n            )");
            return p16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/searchbar/ECSearchBar$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            IECSearchBar.Callback callback = ECSearchBar.this.callback;
            if (callback != null) {
                callback.call(IECSearchBar.METHOD_DO_TEXT_CHANGED, s16.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }

    public ECSearchBar(Context context) {
        Map<String, Function1<Object, Object>> mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(IECSearchBar.METHOD_UPDATE_STYLE, new ECSearchBar$methodMap$1(this)), TuplesKt.to(IECSearchBar.METHOD_SET_CALLBACK, new ECSearchBar$methodMap$2(this)), TuplesKt.to(IECSearchBar.METHOD_SET_HINT, new ECSearchBar$methodMap$3(this)), TuplesKt.to(IECSearchBar.METHOD_SET_TEXT, new ECSearchBar$methodMap$4(this)), TuplesKt.to(IECSearchBar.METHOD_ON_CANCEL_RESULT, new ECSearchBar$methodMap$5(this)), TuplesKt.to("showKeyboard", new ECSearchBar$methodMap$6(this)));
        this.methodMap = mapOf;
        this.textWatcher = new d();
        this.searchActionCallback = new b();
        this.searchUiResource = new c();
    }

    private final void j() {
        QUISearchBar qUISearchBar = new QUISearchBar(this.context);
        qUISearchBar.setActionCallback(this.searchActionCallback);
        qUISearchBar.setCustomResource(this.searchUiResource);
        qUISearchBar.bindSearchChain(false);
        qUISearchBar.setFocusable(true);
        qUISearchBar.setFocusableInTouchMode(true);
        QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
        this.editText = inputWidget;
        if (inputWidget != null) {
            inputWidget.clearFocus();
        }
        qUISearchBar.getInputWidget().addTextChangedListener(this.textWatcher);
        this.autoHintLayout = qUISearchBar.getAutoHintLayout();
        this.searchBar = qUISearchBar;
    }

    private final Activity k() {
        Context context = this.context;
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(Object param) {
        Activity k3;
        String str = param instanceof String ? (String) param : null;
        int parseInt = str != null ? Integer.parseInt(str) : 0;
        if (parseInt == 0) {
            Activity k16 = k();
            if (k16 != null) {
                k16.finish();
            }
            QUISearchBar qUISearchBar = this.searchBar;
            if (qUISearchBar != null) {
                SearchController.defaultCancelAction(qUISearchBar, qUISearchBar.getSearchController(), true);
            }
        } else if (parseInt == 1 && (k3 = k()) != null) {
            k3.finish();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(Object param) {
        IECSearchBar.Callback callback = param instanceof IECSearchBar.Callback ? (IECSearchBar.Callback) param : null;
        if (callback != null) {
            this.callback = callback;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(Object param) {
        boolean startsWith$default;
        AutoHintLayout autoHintLayout;
        boolean endsWith$default;
        ArrayList arrayList = new ArrayList();
        String str = param instanceof String ? (String) param : null;
        if (str == null) {
            str = "";
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "[", false, 2, null);
        if (startsWith$default) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, "]", false, 2, null);
            if (endsWith$default) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = jSONArray.optString(i3);
                        Intrinsics.checkNotNullExpressionValue(optString, "jsonArray.optString(i)");
                        arrayList.add(optString);
                    }
                } catch (JSONException e16) {
                    QLog.e("ECSearchBar", 1, e16, new Object[0]);
                }
                autoHintLayout = this.autoHintLayout;
                if (autoHintLayout != null) {
                    autoHintLayout.setHintList(arrayList);
                }
                return null;
            }
        }
        arrayList.add(str);
        autoHintLayout = this.autoHintLayout;
        if (autoHintLayout != null) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(Object param) {
        String str = param instanceof String ? (String) param : null;
        if (str == null) {
            str = "";
        }
        EditText editText = this.editText;
        if (editText != null) {
            editText.setText(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p(Object param) {
        QuickPinyinEditText inputWidget;
        QUISearchBar qUISearchBar = this.searchBar;
        if (qUISearchBar == null || (inputWidget = qUISearchBar.getInputWidget()) == null) {
            return null;
        }
        inputWidget.requestFocus();
        InputMethodUtil.show(inputWidget);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(Object param) {
        Integer num = param instanceof Integer ? (Integer) param : null;
        if (num != null) {
            int intValue = num.intValue();
            QUISearchBar qUISearchBar = this.searchBar;
            if (qUISearchBar != null) {
                qUISearchBar.updateStyle(intValue);
            }
            EditText editText = this.editText;
            if (editText != null) {
                editText.clearFocus();
            }
        }
        return null;
    }

    @Override // com.tencent.ecommerce.base.searchbar.IECSearchBar
    public Object call(String method, Object param) {
        Intrinsics.checkNotNullParameter(method, "method");
        Function1<Object, Object> function1 = this.methodMap.get(method);
        if (function1 != null) {
            return function1.invoke(param);
        }
        return null;
    }

    @Override // com.tencent.ecommerce.base.searchbar.IECSearchBar
    public View getView() {
        j();
        return this.searchBar;
    }
}
