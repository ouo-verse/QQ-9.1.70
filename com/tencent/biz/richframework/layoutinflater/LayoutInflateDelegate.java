package com.tencent.biz.richframework.layoutinflater;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/LayoutInflateDelegate;", "", "afterInflate", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "root", "Landroid/view/ViewGroup;", "attachToRoot", "", "view", "Landroid/view/View;", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface LayoutInflateDelegate {
    void afterInflate(@NotNull XmlPullParser parser, @Nullable ViewGroup root, boolean attachToRoot, @NotNull View view);
}
