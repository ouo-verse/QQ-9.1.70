package com.tencent.qqnt.rich;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.android.androidbypass.MarkdownTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010R<\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\u0013j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0014`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R<\u0010\u0018\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\u0013j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0014`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0013j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/rich/b;", "", "Landroid/view/View;", "view", "", "nodeId", "", "d", "nodeType", "b", "a", "f", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "c", "", "clearStream", "e", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "viewCache", "usedViewCache", "Ljava/util/Set;", "textViewSet", "usedTextViewSet", "streamViewCache", "streamReplaceViewCache", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Set<Object>> viewCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Set<Object>> usedViewCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<TextView> textViewSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<TextView> usedTextViewSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, View> streamViewCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, View> streamReplaceViewCache;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewCache = new HashMap<>();
        this.usedViewCache = new HashMap<>();
        this.textViewSet = new LinkedHashSet();
        this.usedTextViewSet = new LinkedHashSet();
        this.streamViewCache = new HashMap<>();
        this.streamReplaceViewCache = new HashMap<>();
    }

    @Nullable
    public final Object a(@NotNull String nodeType) {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) nodeType);
        }
        Intrinsics.checkNotNullParameter(nodeType, "nodeType");
        Set<Object> set = this.viewCache.get(nodeType);
        if (set != null && (!set.isEmpty())) {
            first = CollectionsKt___CollectionsKt.first(set);
            set.remove(first);
            Iterator<Map.Entry<String, View>> it = this.streamViewCache.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(it.next().getValue(), first)) {
                    it.remove();
                    break;
                }
            }
            return first;
        }
        return null;
    }

    @Nullable
    public final View b(@NotNull String nodeId, @NotNull String nodeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nodeId, (Object) nodeType);
        }
        Intrinsics.checkNotNullParameter(nodeId, "nodeId");
        Intrinsics.checkNotNullParameter(nodeType, "nodeType");
        View view = this.streamViewCache.get(nodeId);
        if (view != null) {
            Set<Object> set = this.viewCache.get(nodeType);
            if (set != null) {
                set.remove(view);
                return view;
            }
            return view;
        }
        return null;
    }

    @NotNull
    public final TextView c(@NotNull Context context) {
        TextView markdownTextView;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.textViewSet.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first(this.textViewSet);
            markdownTextView = (TextView) first;
            this.textViewSet.remove(markdownTextView);
        } else {
            markdownTextView = new MarkdownTextView(context, null, 0, 6, null);
        }
        this.usedTextViewSet.add(markdownTextView);
        return markdownTextView;
    }

    public final void d(@NotNull View view, @NotNull String nodeId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) nodeId);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(nodeId, "nodeId");
        this.streamViewCache.put(nodeId, view);
    }

    public final void e(boolean clearStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, clearStream);
            return;
        }
        this.textViewSet.addAll(this.usedTextViewSet);
        this.usedTextViewSet.clear();
        Set<String> keySet = this.usedViewCache.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "usedViewCache.keys");
        for (String str : keySet) {
            Set<Object> set = this.usedViewCache.get(str);
            if (set == null) {
                set = new LinkedHashSet<>();
            }
            Set<Object> set2 = this.viewCache.get(str);
            if (set2 == null) {
                set2 = new LinkedHashSet<>();
            }
            set2.addAll(set);
            this.viewCache.put(str, set2);
            Set<Object> set3 = this.usedViewCache.get(str);
            if (set3 != null) {
                set3.clear();
            }
        }
        if (clearStream) {
            this.streamViewCache.clear();
            this.streamReplaceViewCache.clear();
        }
    }

    public final void f(@NotNull Object view, @NotNull String nodeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, view, (Object) nodeType);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(nodeType, "nodeType");
        Set<Object> set = this.usedViewCache.get(nodeType);
        if (set == null) {
            set = new LinkedHashSet<>();
        }
        set.add(view);
        this.usedViewCache.put(nodeType, set);
    }
}
