package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ActionProvider;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public interface SupportMenuItem extends MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    ActionProvider getSupportActionProvider();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    boolean requiresActionButton();

    boolean requiresOverflow();

    @Override // android.view.MenuItem
    MenuItem setActionView(int i3);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c16, int i3);

    @Override // android.view.MenuItem
    /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    SupportMenuItem setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c16, int i3);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c16, char c17, int i3, int i16);

    @Override // android.view.MenuItem
    void setShowAsAction(int i3);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int i3);

    SupportMenuItem setSupportActionProvider(ActionProvider actionProvider);

    @Override // android.view.MenuItem
    /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence);

    @Override // android.view.MenuItem
    SupportMenuItem setTooltipText(CharSequence charSequence);
}
