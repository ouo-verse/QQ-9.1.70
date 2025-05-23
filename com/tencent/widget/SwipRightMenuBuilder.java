package com.tencent.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class SwipRightMenuBuilder {
    static IPatchRedirector $redirector_;
    protected String TAG;
    protected final int mMaxMenuCount;
    protected final Stack<View>[] mMenuViewCache;
    protected final SwipRightMenuItem[] mTempMenus;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SwipItemBaseHolder {
        static IPatchRedirector $redirector_;
        public View leftView;
        public SwipRightMenuItem[] rightMenuItems;

        public SwipItemBaseHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SwipRightMenuItem {
        static IPatchRedirector $redirector_;
        public int menuHeight;
        public int menuId;
        public int menuType;
        public View menuView;
        public int menuWidth;

        public SwipRightMenuItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void reset() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.menuType = -1;
            this.menuId = -1;
            this.menuWidth = 0;
            this.menuHeight = 0;
            this.menuView = null;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "[menuType = " + this.menuType + ",menuId = " + this.menuId + ",menuWidth = " + this.menuWidth + ",menuHeight = " + this.menuHeight + ",menuView = " + this.menuView + "]";
        }
    }

    public SwipRightMenuBuilder(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.TAG = SwipRightMenuBuilder.class.getSimpleName();
        this.mMaxMenuCount = i3;
        if (i3 >= 0 && (i3 <= 0 || i16 >= 1)) {
            this.mMenuViewCache = new Stack[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                this.mMenuViewCache[i17] = new Stack<>();
            }
            this.mTempMenus = new SwipRightMenuItem[this.mMaxMenuCount];
            for (int i18 = 0; i18 < this.mMaxMenuCount; i18++) {
                this.mTempMenus[i18] = new SwipRightMenuItem();
            }
            return;
        }
        throw new IllegalArgumentException("SwipRightMenuBuilder, menuTypeCount = " + i16);
    }

    public abstract View createRightMenuItem(Context context, int i3);

    public View createView(Context context, View view, SwipItemBaseHolder swipItemBaseHolder, int i3) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, swipItemBaseHolder, Integer.valueOf(i3));
        }
        if (swipItemBaseHolder != null && view != null) {
            int i16 = this.mMaxMenuCount;
            if (i16 > 0) {
                swipItemBaseHolder.rightMenuItems = new SwipRightMenuItem[i16];
                for (int i17 = 0; i17 < this.mMaxMenuCount; i17++) {
                    swipItemBaseHolder.rightMenuItems[i17] = new SwipRightMenuItem();
                    SwipRightMenuItem swipRightMenuItem = swipItemBaseHolder.rightMenuItems[i17];
                    swipRightMenuItem.menuType = -1;
                    swipRightMenuItem.menuWidth = 0;
                    swipRightMenuItem.menuView = null;
                }
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                linearLayout.setClipChildren(false);
                linearLayout.setClipToPadding(false);
                linearLayout.addView(view, new LinearLayout.LayoutParams(i3, -2));
                view2 = linearLayout;
            } else {
                swipItemBaseHolder.rightMenuItems = null;
                view2 = view;
            }
            swipItemBaseHolder.leftView = view;
            return view2;
        }
        throw new NullPointerException("SwipRightMenuBuilder.createView holder is null or leftView is null");
    }

    public abstract void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuItem[] swipRightMenuItemArr);

    protected void recycleMenuView(SwipRightMenuItem swipRightMenuItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) swipRightMenuItem);
            return;
        }
        if (swipRightMenuItem == null) {
            return;
        }
        View view = swipRightMenuItem.menuView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(swipRightMenuItem.menuView);
                } else {
                    throw new IllegalArgumentException("recycleMenuView, parent is not ViewGroup");
                }
            }
            synchronized (this.mMenuViewCache) {
                int i3 = swipRightMenuItem.menuType;
                if (i3 >= 0) {
                    Stack<View>[] stackArr = this.mMenuViewCache;
                    if (i3 < stackArr.length) {
                        stackArr[i3].push(swipRightMenuItem.menuView);
                    }
                }
            }
        }
        swipRightMenuItem.reset();
    }

    public abstract View updateRightMenuItem(int i3, Object obj, SwipRightMenuItem swipRightMenuItem, View.OnClickListener onClickListener);

    public int updateRightMenuView(Context context, View view, int i3, Object obj, SwipItemBaseHolder swipItemBaseHolder, View.OnClickListener onClickListener) {
        SwipRightMenuItem[] swipRightMenuItemArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, context, view, Integer.valueOf(i3), obj, swipItemBaseHolder, onClickListener)).intValue();
        }
        if (!(view instanceof LinearLayout) || swipItemBaseHolder == null || (swipRightMenuItemArr = swipItemBaseHolder.rightMenuItems) == null || swipRightMenuItemArr.length == 0 || swipRightMenuItemArr.length > this.mMaxMenuCount) {
            return 0;
        }
        LinearLayout linearLayout = (LinearLayout) view;
        getRightMenuItemInfo(i3, obj, this.mTempMenus);
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < this.mMaxMenuCount) {
            if (this.mMenuViewCache.length > i16) {
                SwipRightMenuItem swipRightMenuItem = swipItemBaseHolder.rightMenuItems[i17];
                if (swipRightMenuItem.menuType != this.mTempMenus[i17].menuType) {
                    recycleMenuView(swipRightMenuItem);
                }
            }
            SwipRightMenuItem swipRightMenuItem2 = swipItemBaseHolder.rightMenuItems[i17];
            SwipRightMenuItem swipRightMenuItem3 = this.mTempMenus[i17];
            int i26 = swipRightMenuItem3.menuType;
            swipRightMenuItem2.menuType = i26;
            swipRightMenuItem2.menuId = swipRightMenuItem3.menuId;
            swipRightMenuItem2.menuWidth = 0;
            swipRightMenuItem2.menuHeight = -1;
            View view2 = swipRightMenuItem2.menuView;
            if (i26 >= 0) {
                Stack<View>[] stackArr = this.mMenuViewCache;
                if (i26 < stackArr.length) {
                    if (view2 == null) {
                        synchronized (stackArr) {
                            if (!this.mMenuViewCache[i26].isEmpty()) {
                                view2 = this.mMenuViewCache[i26].pop();
                            }
                        }
                        if (view2 == null) {
                            view2 = createRightMenuItem(context, i26);
                        }
                        if (view2 != null) {
                            swipItemBaseHolder.rightMenuItems[i17].menuView = view2;
                            z16 = true;
                        } else {
                            throw new NullPointerException("updateRightMenuView menuView is null");
                        }
                    } else {
                        z16 = false;
                    }
                    updateRightMenuItem(i3, obj, swipItemBaseHolder.rightMenuItems[i17], onClickListener);
                    int i27 = swipItemBaseHolder.rightMenuItems[i17].menuWidth;
                    if (i27 >= 0) {
                        i18 += i27;
                        i19++;
                        view2.setVisibility(0);
                        if (z16) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
                            if (layoutParams == null) {
                                SwipRightMenuItem swipRightMenuItem4 = swipItemBaseHolder.rightMenuItems[i17];
                                layoutParams = new LinearLayout.LayoutParams(swipRightMenuItem4.menuWidth, swipRightMenuItem4.menuHeight);
                                view2.setLayoutParams(layoutParams);
                            } else {
                                SwipRightMenuItem swipRightMenuItem5 = swipItemBaseHolder.rightMenuItems[i17];
                                layoutParams.width = swipRightMenuItem5.menuWidth;
                                layoutParams.height = swipRightMenuItem5.menuHeight;
                            }
                            layoutParams.gravity = 16;
                            linearLayout.addView(view2, i19);
                        }
                        i17++;
                        i16 = 1;
                    } else {
                        throw new IllegalArgumentException("updateRightMenuView, menuWidth = " + swipItemBaseHolder.rightMenuItems[i17].menuWidth);
                    }
                }
            }
            if (view2 != null) {
                view2.setVisibility(8);
                i19++;
            }
            i17++;
            i16 = 1;
        }
        view.setTag(-3, Integer.valueOf(i18));
        return i18;
    }
}
