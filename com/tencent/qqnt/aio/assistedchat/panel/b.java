package com.tencent.qqnt.aio.assistedchat.panel;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/b;", "Landroidx/viewpager/widget/PagerAdapter;", "", "Lcom/tencent/qqnt/aio/assistedchat/panel/k;", "items", "", "f", "", "position", "e", "panelId", "d", "getCount", "Landroid/view/View;", "view", "", "obj", "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "destroyItem", "Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "getInteraction", "()Lcom/tencent/qqnt/aio/assistedchat/panel/p;", "interaction", "", "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/panel/p;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends PagerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p interaction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<k> itemList;

    public b(@NotNull p interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interaction);
        } else {
            this.interaction = interaction;
            this.itemList = new ArrayList();
        }
    }

    public final int d(int panelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, panelId)).intValue();
        }
        int size = this.itemList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.itemList.get(i3).a() == panelId) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object obj) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, container, Integer.valueOf(position), obj);
            return;
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (obj instanceof View) {
            view = (View) obj;
        } else {
            view = null;
        }
        if (view != null) {
            container.removeView(view);
        }
    }

    public final int e(int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.itemList, position);
            k kVar = (k) orNull;
            if (kVar != null) {
                return kVar.a();
            }
            return -1;
        }
        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, position)).intValue();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void f(@NotNull List<k> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        this.itemList.clear();
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.itemList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) container, position);
        }
        Intrinsics.checkNotNullParameter(container, "container");
        View a16 = this.interaction.a(e(position));
        if (a16.getParent() != null) {
            ViewParent parent = a16.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(a16);
            }
        }
        container.addView(a16);
        return a16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, obj)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual(view, obj);
    }
}
