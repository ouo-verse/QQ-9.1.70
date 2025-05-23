package com.tencent.qqnt.chats.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0010\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chats/view/ClipSkinnableRecycleView;", "Lcom/tencent/qqnt/chats/view/SkinnableRecycleView;", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$d;", "", "progress", "", "J", "Landroid/graphics/Canvas;", "c", "dispatchDraw", "", "i", "Z", "guildCompleteShow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ClipSkinnableRecycleView extends SkinnableRecycleView implements GuildLayoutManager.d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean guildCompleteShow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipSkinnableRecycleView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.qqnt.chats.biz.guild.GuildLayoutManager.d
    public void J(float progress) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(progress));
            return;
        }
        boolean z18 = this.guildCompleteShow;
        if (progress == 100.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z18 != z16) {
            if (progress != 100.0f) {
                z17 = false;
            }
            this.guildCompleteShow = z17;
            invalidate();
        }
    }

    @Override // com.tencent.qqnt.chats.view.SkinnableRecycleView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) c16);
            return;
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        if (GuildLayoutManager.f354256a.r()) {
            int save = c16.save();
            c16.clipRect(0, 0, GuildLayoutManager.g(), c16.getHeight());
            super.dispatchDraw(c16);
            c16.restoreToCount(save);
            return;
        }
        super.dispatchDraw(c16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipSkinnableRecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipSkinnableRecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
