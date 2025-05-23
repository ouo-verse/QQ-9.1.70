package com.qzone.reborn.widget;

import android.view.View;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b$\u0010%R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u001c\u0010\u000fR.\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b\u001b\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/qzone/reborn/widget/b;", "", "", "a", "I", "b", "()I", "setIcon", "(I)V", "icon", "", "Ljava/lang/String;", "f", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "Landroid/view/View$OnClickListener;", "c", "Landroid/view/View$OnClickListener;", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "onClickListener", "d", "g", "emId", "e", tl.h.F, "pageId", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "params", "<init>", "(ILjava/lang/String;Landroid/view/View$OnClickListener;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int icon;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener onClickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String emId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String pageId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> params;

    public b(int i3, String text, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.icon = i3;
        this.text = text;
        this.onClickListener = onClickListener;
        this.params = new LinkedHashMap();
    }

    /* renamed from: a, reason: from getter */
    public final String getEmId() {
        return this.emId;
    }

    /* renamed from: b, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* renamed from: c, reason: from getter */
    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    /* renamed from: d, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    public final Map<String, Object> e() {
        return this.params;
    }

    /* renamed from: f, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final void g(String str) {
        this.emId = str;
    }

    public final void h(String str) {
        this.pageId = str;
    }
}
