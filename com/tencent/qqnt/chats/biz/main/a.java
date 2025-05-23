package com.tencent.qqnt.chats.biz.main;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import q3.f;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u000e\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/a;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "e", "()Landroid/view/ViewGroup;", "root", "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "chatsList", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "c", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragArea", "Landroidx/constraintlayout/widget/ConstraintLayout;", "d", "Landroidx/constraintlayout/widget/ConstraintLayout;", "f", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "thirdContainer", "refreshView", "g", "topbarContainer", "Lq3/f;", "Lq3/f;", "()Lq3/f;", "recyclerScroll", "<init>", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;Landroidx/constraintlayout/widget/ConstraintLayout;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lq3/f;)V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView chatsList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QUIBadgeDragLayout dragArea;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout thirdContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup refreshView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup topbarContainer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f recyclerScroll;

    public a(@NotNull ViewGroup root, @NotNull RecyclerView chatsList, @NotNull QUIBadgeDragLayout dragArea, @NotNull ConstraintLayout thirdContainer, @NotNull ViewGroup refreshView, @NotNull ViewGroup topbarContainer, @NotNull f recyclerScroll) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(chatsList, "chatsList");
        Intrinsics.checkNotNullParameter(dragArea, "dragArea");
        Intrinsics.checkNotNullParameter(thirdContainer, "thirdContainer");
        Intrinsics.checkNotNullParameter(refreshView, "refreshView");
        Intrinsics.checkNotNullParameter(topbarContainer, "topbarContainer");
        Intrinsics.checkNotNullParameter(recyclerScroll, "recyclerScroll");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, root, chatsList, dragArea, thirdContainer, refreshView, topbarContainer, recyclerScroll);
            return;
        }
        this.root = root;
        this.chatsList = chatsList;
        this.dragArea = dragArea;
        this.thirdContainer = thirdContainer;
        this.refreshView = refreshView;
        this.topbarContainer = topbarContainer;
        this.recyclerScroll = recyclerScroll;
    }

    @NotNull
    public final RecyclerView a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.chatsList;
    }

    @NotNull
    public final QUIBadgeDragLayout b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QUIBadgeDragLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.dragArea;
    }

    @NotNull
    public final f c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.recyclerScroll;
    }

    @NotNull
    public final ViewGroup d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.refreshView;
    }

    @NotNull
    public final ViewGroup e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.root;
    }

    @NotNull
    public final ConstraintLayout f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConstraintLayout) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.thirdContainer;
    }

    @NotNull
    public final ViewGroup g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.topbarContainer;
    }
}
