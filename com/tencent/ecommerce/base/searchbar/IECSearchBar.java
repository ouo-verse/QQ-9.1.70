package com.tencent.ecommerce.base.searchbar;

import android.view.View;
import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u0000 \b2\u00020\u0001:\u0002\t\nJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/base/searchbar/IECSearchBar;", "", "Landroid/view/View;", "getView", "", "method", "param", "call", "Companion", "Callback", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECSearchBar {
    public static final int CANCEL_RESULT_CLOSE_CHAIN = 0;
    public static final int CANCEL_RESULT_CLOSE_SELF = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f100956a;

    @NotNull
    public static final String METHOD_DO_BACK = "doBack";

    @NotNull
    public static final String METHOD_DO_CANCEL = "doCancel";

    @NotNull
    public static final String METHOD_DO_CLEAR = "doClear";

    @NotNull
    public static final String METHOD_DO_SEARCH = "doSearch";

    @NotNull
    public static final String METHOD_DO_TEXT_CHANGED = "doTextChanged";

    @NotNull
    public static final String METHOD_ON_CANCEL_RESULT = "onCancelResult";

    @NotNull
    public static final String METHOD_SET_CALLBACK = "setCallback";

    @NotNull
    public static final String METHOD_SET_HINT = "setHint";

    @NotNull
    public static final String METHOD_SET_TEXT = "setText";

    @NotNull
    public static final String METHOD_SHOW_KEYBOARD = "showKeyboard";

    @NotNull
    public static final String METHOD_UPDATE_STYLE = "updateStyle";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/searchbar/IECSearchBar$Callback;", "", "call", "method", "", "param", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface Callback {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes5.dex */
        public static final class a {
            public static /* synthetic */ Object a(Callback callback, String str, Object obj, int i3, Object obj2) {
                if (obj2 == null) {
                    if ((i3 & 2) != 0) {
                        obj = null;
                    }
                    return callback.call(str, obj);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: call");
            }
        }

        @Nullable
        Object call(@NotNull String method, @Nullable Object param);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/base/searchbar/IECSearchBar$a;", "", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.searchbar.IECSearchBar$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f100956a = new Companion();

        Companion() {
        }
    }

    @Nullable
    Object call(@NotNull String method, @Nullable Object param);

    @Nullable
    View getView();
}
