package com.tencent.ecommerce.repo.live;

import android.graphics.Color;
import com.tencent.ark.ark;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0004B3\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\u000b\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/repo/live/HotLabel;", "", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTextPrefix", "(Ljava/lang/String;)V", "textPrefix", IECSearchBar.METHOD_SET_TEXT, "text", "c", "getTextColorStr", "setTextColorStr", "textColorStr", "d", "getBorderColorStr", "setBorderColorStr", "borderColorStr", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HotLabel {

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f105108e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String textPrefix;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String textColorStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String borderColorStr;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/repo/live/HotLabel$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/ecommerce/repo/live/HotLabel;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.HotLabel$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final HotLabel a(JSONObject json) {
            String str;
            String str2;
            String str3;
            String optString;
            String str4 = "";
            if (json == null || (str = json.optString("text_prefix", "")) == null) {
                str = "";
            }
            if (json == null || (str2 = json.optString("text")) == null) {
                str2 = "";
            }
            if (json == null || (str3 = json.optString("text_color")) == null) {
                str3 = "";
            }
            if (json != null && (optString = json.optString(LayoutAttrDefine.BorderColor)) != null) {
                str4 = optString;
            }
            return new HotLabel(str, str2, str3, str4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.ecommerce.repo.live.HotLabel$Companion$DEFAULT_COLOR$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return Color.parseColor("#FF3370");
            }
        });
        f105108e = lazy;
    }

    public HotLabel(String str, String str2, String str3, String str4) {
        this.textPrefix = str;
        this.text = str2;
        this.textColorStr = str3;
        this.borderColorStr = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: b, reason: from getter */
    public final String getTextPrefix() {
        return this.textPrefix;
    }

    public String toString() {
        return "HotLabel[textPrefix:" + this.textPrefix + "text:" + this.text + "textColorStr:" + this.textColorStr + "borderColorStr:" + this.borderColorStr + "]";
    }
}
