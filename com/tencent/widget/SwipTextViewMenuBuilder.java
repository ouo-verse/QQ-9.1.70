package com.tencent.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.widget.SwipRightMenuBuilder;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class SwipTextViewMenuBuilder extends SwipRightMenuBuilder {
    static IPatchRedirector $redirector_ = null;
    public static final int TAG_MENU_STR_ID = -2;
    public static final int TAG_POSITION = -1;
    public static final String TAG_SWIP_ICON_MENU_ITEM = "tag_swip_icon_menu_item";
    protected int[] MENU_BG_IDS;
    protected final int MENU_HEIGHT;
    protected final int[] MENU_IDS;
    protected final int[] MENU_STR_IDS;
    protected final int[] MENU_WIDTH;

    public SwipTextViewMenuBuilder(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
        super(i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            return;
        }
        this.MENU_WIDTH = iArr;
        this.MENU_HEIGHT = i17;
        this.MENU_IDS = iArr2;
        this.MENU_STR_IDS = iArr3;
        this.MENU_BG_IDS = iArr4;
    }

    @Override // com.tencent.widget.SwipRightMenuBuilder
    public View createRightMenuItem(Context context, int i3) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, i3);
        }
        SimpleTextView simpleTextView = new SimpleTextView(context);
        simpleTextView.setLayoutParams(new LinearLayout.LayoutParams(this.MENU_WIDTH[i3], this.MENU_HEIGHT));
        simpleTextView.setGravity(17);
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1 || !SimpleUIUtil.isNowElderMode()) {
            z16 = false;
        }
        if (z16) {
            f16 = 18.0f;
        } else {
            f16 = 16.0f;
        }
        simpleTextView.setTextSize(f16);
        simpleTextView.setTextColor(-1);
        return simpleTextView;
    }

    public void setMENU_BG_IDS(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iArr);
        } else {
            this.MENU_BG_IDS = iArr;
        }
    }

    @Override // com.tencent.widget.SwipRightMenuBuilder
    public View updateRightMenuItem(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem, View.OnClickListener onClickListener) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), obj, swipRightMenuItem, onClickListener);
        }
        SimpleTextView simpleTextView = null;
        if (swipRightMenuItem != null && swipRightMenuItem.menuType >= 0 && (i16 = swipRightMenuItem.menuId) >= 0) {
            View view = swipRightMenuItem.menuView;
            if (view instanceof SimpleTextView) {
                simpleTextView = (SimpleTextView) view;
            }
            int i17 = this.MENU_STR_IDS[i16];
            int i18 = this.MENU_BG_IDS[i16];
            int i19 = this.MENU_IDS[i16];
            if (simpleTextView != null) {
                simpleTextView.setVisibility(0);
                simpleTextView.setText(simpleTextView.getContext().getResources().getString(i17));
                simpleTextView.setBackgroundResource(i18);
                simpleTextView.setId(i19);
                simpleTextView.setTag(TAG_SWIP_ICON_MENU_ITEM);
                simpleTextView.setTag(-2, Integer.valueOf(i17));
                simpleTextView.setTag(-1, Integer.valueOf(i3));
                simpleTextView.setContentDescription(simpleTextView.getResources().getString(i17));
                simpleTextView.setOnClickListener(onClickListener);
                swipRightMenuItem.menuWidth = this.MENU_WIDTH[swipRightMenuItem.menuType];
                swipRightMenuItem.menuHeight = this.MENU_HEIGHT;
            }
        }
        return simpleTextView;
    }
}
