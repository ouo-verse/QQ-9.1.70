package com.tencent.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionSheetHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ActionSheetHelper";
    private static Boolean sCanAdjustNavigationBar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f384528d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f384529e;

        a(ActionSheet actionSheet, View view) {
            this.f384528d = actionSheet;
            this.f384529e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) actionSheet, (Object) view);
            }
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            QUIImmersiveHelper.t(this.f384528d.getWindow(), false, null, true, this.f384528d.getActionContentView());
            this.f384529e.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27622);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sCanAdjustNavigationBar = null;
        }
    }

    public ActionSheetHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void adjustNavigationBar(ActionSheet actionSheet) {
        RelativeLayout actionContentView;
        if (actionSheet != null && canAdjustNavigationBar() && (actionContentView = actionSheet.getActionContentView()) != null) {
            actionContentView.getViewTreeObserver().addOnPreDrawListener(new a(actionSheet, actionContentView));
        }
    }

    private static boolean canAdjustNavigationBar() {
        if (sCanAdjustNavigationBar == null) {
            sCanAdjustNavigationBar = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("can_open_action_sheet_adjust_navigation_bar", true));
        }
        return sCanAdjustNavigationBar.booleanValue();
    }

    public static ActionSheet createActionSheet(Context context, List<ActionMenuItem> list, ActionSheet.OnButtonClickListener onButtonClickListener) {
        return updateActionSheet(context, null, list, onButtonClickListener);
    }

    public static Dialog createDialog(Context context, View view) {
        return createDialog(context, view, -1, null);
    }

    public static Dialog createFullScreenDialog(Context context, View view) {
        ActionSheet createFullScreenDialog = ActionSheet.createFullScreenDialog(context);
        createFullScreenDialog.setActionContentView(view, new LinearLayout.LayoutParams(-1, -1));
        adjustNavigationBar(createFullScreenDialog);
        return createFullScreenDialog;
    }

    public static void dismissActionSheet(Activity activity, ActionSheet actionSheet) {
        if (activity != null && actionSheet != null) {
            try {
                if (!activity.isFinishing()) {
                    actionSheet.dismiss();
                } else {
                    QLog.e(TAG, 1, "dismissActionSheet when activity(" + activity + ") is finish!");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static String getStringById(Context context, int i3) {
        if (context == null) {
            return null;
        }
        return context.getString(i3);
    }

    public static void showActionSheet(Activity activity, ActionSheet actionSheet) {
        if (activity != null && actionSheet != null) {
            try {
                if (!activity.isFinishing()) {
                    actionSheet.show();
                } else {
                    QLog.e(TAG, 1, "showActionSheet when activity(" + activity + ") is finish!");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static ActionSheet updateActionSheet(Context context, ActionSheet actionSheet, List<ActionMenuItem> list, ActionSheet.OnButtonClickListener onButtonClickListener) {
        if (context == null || list == null || list.size() <= 0) {
            return null;
        }
        if (actionSheet == null) {
            actionSheet = (ActionSheet) createDialog(context, null);
        } else {
            actionSheet.clear();
            actionSheet.updateUI();
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            ActionMenuItem actionMenuItem = list.get(i3);
            if (actionMenuItem.visibility == 0) {
                int i16 = actionMenuItem.type;
                if (i16 == 1) {
                    actionSheet.addButton(actionMenuItem, 1);
                } else if (i16 == 2) {
                    actionSheet.addButton(actionMenuItem, 3);
                }
            }
        }
        actionSheet.setOnButtonClickListener(onButtonClickListener);
        return actionSheet;
    }

    public static Dialog createDialog(Context context, View view, int i3, ViewGroup.LayoutParams layoutParams) {
        try {
            ActionSheet create = ActionSheet.create(context, i3, layoutParams);
            create.setActionContentView(view, null);
            adjustNavigationBar(create);
            return create;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "create action sheet error", e16);
            return new ActionSheet(context);
        }
    }

    public static Dialog createDialog(Context context, View view, boolean z16) {
        return createDialog(context, view, -1, null, z16);
    }

    public static Dialog createDialog(Context context, View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z16) {
        try {
            ActionSheet create = ActionSheet.create(context, i3, layoutParams, z16);
            create.setActionContentView(view, null);
            adjustNavigationBar(create);
            return create;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "create action sheet error", e16);
            return new ActionSheet(context);
        }
    }
}
