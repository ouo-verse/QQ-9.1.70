package com.tencent.guild.aio.article.msglist.holder.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/component/GuildArticleGrayTipsContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Landroid/view/View;", "d1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", h.F, "Lkotlin/Lazy;", "i1", "()Landroid/view/ViewGroup;", "contentView", "Landroid/widget/TextView;", "i", "j1", "()Landroid/widget/TextView;", "textView", "<init>", "(Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleGrayTipsContentComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy textView;

    public GuildArticleGrayTipsContentComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.guild.aio.article.msglist.holder.component.GuildArticleGrayTipsContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                return new FrameLayout(GuildArticleGrayTipsContentComponent.this.getRoot().getContext());
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.article.msglist.holder.component.GuildArticleGrayTipsContentComponent$textView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                return BubbleTextViewUtil.f111916a.c(GuildArticleGrayTipsContentComponent.this.getMContext());
            }
        });
        this.textView = lazy2;
    }

    private final ViewGroup i1() {
        return (ViewGroup) this.contentView.getValue();
    }

    private final TextView j1() {
        return (TextView) this.textView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        MsgElement firstTypeElement = ((GuildMsgItem) msgItem).getFirstTypeElement(8);
        if (QLog.isColorLevel()) {
            QLog.d("GrayTipsContentComponent", 2, "recv grayTipsElement: ", firstTypeElement);
        }
        if (j1().getParent() == null) {
            j1().setText(getMContext().getString(R.string.f139730c2));
            i1().addView(j1());
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return i1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
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
