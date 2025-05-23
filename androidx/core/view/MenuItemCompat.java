package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes.dex */
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getSupportActionProvider();
        }
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        int alphabeticModifiers;
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            alphabeticModifiers = menuItem.getAlphabeticModifiers();
            return alphabeticModifiers;
        }
        return 0;
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        CharSequence contentDescription;
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            contentDescription = menuItem.getContentDescription();
            return contentDescription;
        }
        return null;
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        ColorStateList iconTintList;
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            iconTintList = menuItem.getIconTintList();
            return iconTintList;
        }
        return null;
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        PorterDuff.Mode iconTintMode;
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            iconTintMode = menuItem.getIconTintMode();
            return iconTintMode;
        }
        return null;
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        int numericModifiers;
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            numericModifiers = menuItem.getNumericModifiers();
            return numericModifiers;
        }
        return 0;
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        CharSequence tooltipText;
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            tooltipText = menuItem.getTooltipText();
            return tooltipText;
        }
        return null;
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c16, int i3) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c16, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c16, i3);
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c16, int i3) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c16, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c16, i3);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, final OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: androidx.core.view.MenuItemCompat.1
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem menuItem2) {
                return OnActionExpandListener.this.onMenuItemActionCollapse(menuItem2);
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem menuItem2) {
                return OnActionExpandListener.this.onMenuItemActionExpand(menuItem2);
            }
        });
    }

    public static void setShortcut(MenuItem menuItem, char c16, char c17, int i3, int i16) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShortcut(c16, c17, i3, i16);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setShortcut(c16, c17, i3, i16);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i3) {
        menuItem.setShowAsAction(i3);
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i3) {
        return menuItem.setActionView(i3);
    }
}
