package com.tencent.mobileqq.nearbypro.chats.part;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0017\u0010\u001a\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/b;", "", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", "root", "Landroidx/recyclerview/widget/RecyclerView;", "b", "Landroidx/recyclerview/widget/RecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "chatsList", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "c", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "()Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragArea", "Lq3/f;", "d", "Lq3/f;", "e", "()Lq3/f;", "refreshView", h.F, "topbarContainer", "recyclerScroll", "g", "topBannerContainer", "publicAccountNotice", "<init>", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;Lq3/f;Landroid/view/ViewGroup;Lq3/f;Landroid/view/ViewGroup;Landroid/view/ViewGroup;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView chatsList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DragFrameLayout dragArea;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q3.f refreshView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup topbarContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q3.f recyclerScroll;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup topBannerContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup publicAccountNotice;

    public b(@NotNull ViewGroup root, @NotNull RecyclerView chatsList, @NotNull DragFrameLayout dragArea, @NotNull q3.f refreshView, @NotNull ViewGroup topbarContainer, @NotNull q3.f recyclerScroll, @NotNull ViewGroup topBannerContainer, @NotNull ViewGroup publicAccountNotice) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(chatsList, "chatsList");
        Intrinsics.checkNotNullParameter(dragArea, "dragArea");
        Intrinsics.checkNotNullParameter(refreshView, "refreshView");
        Intrinsics.checkNotNullParameter(topbarContainer, "topbarContainer");
        Intrinsics.checkNotNullParameter(recyclerScroll, "recyclerScroll");
        Intrinsics.checkNotNullParameter(topBannerContainer, "topBannerContainer");
        Intrinsics.checkNotNullParameter(publicAccountNotice, "publicAccountNotice");
        this.root = root;
        this.chatsList = chatsList;
        this.dragArea = dragArea;
        this.refreshView = refreshView;
        this.topbarContainer = topbarContainer;
        this.recyclerScroll = recyclerScroll;
        this.topBannerContainer = topBannerContainer;
        this.publicAccountNotice = publicAccountNotice;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final RecyclerView getChatsList() {
        return this.chatsList;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final DragFrameLayout getDragArea() {
        return this.dragArea;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ViewGroup getPublicAccountNotice() {
        return this.publicAccountNotice;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final q3.f getRecyclerScroll() {
        return this.recyclerScroll;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final q3.f getRefreshView() {
        return this.refreshView;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ViewGroup getRoot() {
        return this.root;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final ViewGroup getTopBannerContainer() {
        return this.topBannerContainer;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final ViewGroup getTopbarContainer() {
        return this.topbarContainer;
    }
}
