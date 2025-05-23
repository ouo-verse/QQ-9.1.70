package com.tencent.guild.aio.msglist.holder.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.guild.aio.msglist.holder.component.tail.GameTail;
import com.tencent.guild.aio.msglist.holder.component.tail.RobotPushSettingTail;
import com.tencent.guild.aio.msglist.holder.component.tail.RobotSourceTail;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0017\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleTailComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Lcom/tencent/guild/aio/msglist/holder/component/tail/a;", "k1", "", "position", "", "", "payloads", "", "b1", "Landroid/widget/FrameLayout;", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", tl.h.F, "Landroid/widget/FrameLayout;", "mTailLayout", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Lkotlin/Lazy;", "j1", "()Ljava/util/ArrayList;", "mMsgTailList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/msglist/holder/component/tail/a;", "showingTail", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildBubbleTailComponent extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout mTailLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMsgTailList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.holder.component.tail.a showingTail;

    public GuildBubbleTailComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        FrameLayout frameLayout = new FrameLayout(root.getContext());
        frameLayout.setVisibility(8);
        this.mTailLayout = frameLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<com.tencent.guild.aio.msglist.holder.component.tail.a>>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleTailComponent$mMsgTailList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<com.tencent.guild.aio.msglist.holder.component.tail.a> invoke() {
                ArrayList<com.tencent.guild.aio.msglist.holder.component.tail.a> arrayListOf;
                Context context = GuildBubbleTailComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                Context context2 = GuildBubbleTailComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                Context context3 = GuildBubbleTailComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "root.context");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new GameTail(context), new RobotSourceTail(context2), new RobotPushSettingTail(context3));
                return arrayListOf;
            }
        });
        this.mMsgTailList = lazy;
    }

    private final ArrayList<com.tencent.guild.aio.msglist.holder.component.tail.a> j1() {
        return (ArrayList) this.mMsgTailList.getValue();
    }

    private final com.tencent.guild.aio.msglist.holder.component.tail.a k1(com.tencent.aio.data.msglist.a msgItem) {
        com.tencent.guild.aio.msglist.holder.component.tail.a aVar = null;
        for (com.tencent.guild.aio.msglist.holder.component.tail.a aVar2 : j1()) {
            if (aVar2.b(msgItem) && (aVar == null || aVar.d() < aVar2.d())) {
                aVar = aVar2;
            }
        }
        return aVar;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        com.tencent.guild.aio.msglist.holder.component.tail.a k16 = k1(msgItem);
        if (!Intrinsics.areEqual(this.showingTail, k16)) {
            this.mTailLayout.removeAllViews();
            if (k16 != null) {
                this.mTailLayout.addView(k16.a());
            }
        }
        if (k16 != null) {
            k16.c(msgItem);
        }
        FrameLayout frameLayout = this.mTailLayout;
        if (k16 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        frameLayout.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, frameLayout)) == null) {
            frameLayout.setVisibility(8);
        }
        this.showingTail = k16;
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: i1, reason: from getter and merged with bridge method [inline-methods] */
    public FrameLayout d1() {
        return this.mTailLayout;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
