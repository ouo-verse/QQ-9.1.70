package com.tencent.mobileqq.activity.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.biz.guild.GuildSlideCoordinator;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.mini.ui.dialog.DisplayHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.xaction.log.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001d\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bB%\b\u0016\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/home/view/ListViewBackgroundView;", "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$d;", "", NodeProps.ON_ATTACHED_TO_WINDOW, "", "progress", "J", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "d", "I", "guildNavigationBarHeight", "e", "guildTopCornerRadius", "", "f", "Z", "guildCompleteShow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ListViewBackgroundView extends View implements IGuildLayoutApi.d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int guildNavigationBarHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int guildTopCornerRadius;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean guildCompleteShow;

    public ListViewBackgroundView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.guildNavigationBarHeight = getResources().getDimensionPixelSize(R.dimen.chp);
            this.guildTopCornerRadius = DisplayHelper.dpToPx(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float progress) {
        Drawable drawable;
        Drawable drawable2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(progress));
            return;
        }
        if (!QQTheme.isVasTheme()) {
            if (GuildLayoutManager.f354256a.q()) {
                b.a("ListViewBackgroundView", 2, "set qui_common_fill_light_primary_bg");
                drawable2 = getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg);
            } else {
                b.a("ListViewBackgroundView", 2, "set bg_texture_theme_version2");
                drawable2 = getResources().getDrawable(R.drawable.bg_texture_theme_version2);
            }
            setBackground(drawable2);
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
                return;
            }
            return;
        }
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            b.a("ListViewBackgroundView", 2, "set null");
            drawable = null;
        } else {
            b.a("ListViewBackgroundView", 2, "vas set bg_texture_theme_version2");
            drawable = getResources().getDrawable(R.drawable.bg_texture_theme_version2);
        }
        setBackground(drawable);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!QQTheme.isVasTheme() && this.guildCompleteShow) {
            int save = canvas.save();
            canvas.clipRect(0, this.guildNavigationBarHeight, GuildLayoutManager.g() + this.guildTopCornerRadius, getHeight());
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onAttachedToWindow();
            GuildSlideCoordinator.k(this);
        }
    }

    public ListViewBackgroundView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.guildNavigationBarHeight = getResources().getDimensionPixelSize(R.dimen.chp);
            this.guildTopCornerRadius = DisplayHelper.dpToPx(8);
        }
    }

    public ListViewBackgroundView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.guildNavigationBarHeight = getResources().getDimensionPixelSize(R.dimen.chp);
            this.guildTopCornerRadius = DisplayHelper.dpToPx(8);
        }
    }
}
