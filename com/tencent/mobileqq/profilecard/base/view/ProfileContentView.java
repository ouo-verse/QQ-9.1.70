package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes16.dex */
public class ProfileContentView extends LinearLayout implements IProfileContentKey {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileContentView";
    private int componentMargin;
    private IContainerDividerCreator mContainerDividerCreator;
    private IDividerCreator mDividerCreator;
    private String[] mDividerMap;
    private boolean mEnableDivider;
    private List<String[]> mKeyMap;
    private final HashMap<String, View> mMoreInfoMap;

    /* loaded from: classes16.dex */
    public interface IContainerDividerCreator {
        View createContainerDivider(Context context);
    }

    /* loaded from: classes16.dex */
    public interface IDividerCreator {
        View createDivider(Context context);
    }

    public ProfileContentView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mEnableDivider = true;
        this.mKeyMap = IProfileContentKey.COMPONENT_ADD_LIST_NORMAL;
        this.mDividerMap = IProfileContentKey.KEY_MAP_HAS_TOP_DIVIDER;
        this.componentMargin = 0;
        this.mMoreInfoMap = new HashMap<>();
    }

    private void addContainerDivider(List<View> list, String str) {
        String format = String.format("%s_%s", IProfileContentKey.MAP_KEY_CONTAINER_DIVIDER, str);
        View view = this.mMoreInfoMap.get(format);
        if (view == null || view.getParent() != null) {
            if (view != null) {
                QLog.e(TAG, 1, String.format("checkAndAddDivider dividerView=%s viewParent=%s", view, view.getParent()));
            }
            IContainerDividerCreator iContainerDividerCreator = this.mContainerDividerCreator;
            if (iContainerDividerCreator != null) {
                view = iContainerDividerCreator.createContainerDivider(getContext());
            }
            if (view == null) {
                return;
            } else {
                this.mMoreInfoMap.put(format, view);
            }
        }
        list.add(view);
    }

    private boolean checkAndAddDivider(int i3, View view) {
        boolean z16;
        String[] strArr = this.mDividerMap;
        int length = strArr.length;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                if (view == this.mMoreInfoMap.get(strArr[i16])) {
                    z16 = true;
                    break;
                }
                i16++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!this.mEnableDivider) {
            z16 = false;
        }
        if (z16 && getChildCount() == 0) {
            z16 = false;
        }
        if (z16) {
            String format = String.format("%s_%s", IProfileContentKey.MAP_KEY_DIVIDER, Integer.valueOf(i3));
            View view2 = this.mMoreInfoMap.get(format);
            if (view2 == null || view2.getParent() != null) {
                if (view2 != null) {
                    QLog.e(TAG, 1, String.format("checkAndAddDivider dividerView=%s viewParent=%s", view2, view2.getParent()));
                }
                IDividerCreator iDividerCreator = this.mDividerCreator;
                if (iDividerCreator != null) {
                    view2 = iDividerCreator.createDivider(getContext());
                }
                this.mMoreInfoMap.put(format, view2);
            }
            addView(view2);
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            }
        }
        return z16;
    }

    private boolean checkBottomMargin(View view) {
        for (String str : IProfileContentKey.KEY_MAP_HAS_BOTTOM_MARGIN_ELEGANT) {
            if (view == this.mMoreInfoMap.get(str)) {
                return true;
            }
        }
        return false;
    }

    private List<View> getAllComponentView() {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder("");
        boolean z16 = false;
        for (String[] strArr : this.mKeyMap) {
            for (String str : strArr) {
                View view = this.mMoreInfoMap.get(str);
                if (view != null) {
                    if (z16 && this.mContainerDividerCreator != null) {
                        addContainerDivider(arrayList, str);
                        z16 = false;
                    }
                    arrayList.add(view);
                    sb5.append(String.format("rebuildProfileContent key==%s view=%s", str, view));
                }
            }
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5);
        }
        return arrayList;
    }

    private boolean isDefaultProfile(ProfileCardInfo profileCardInfo) {
        if (profileCardInfo == null || profileCardInfo.curUseStyleId != ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
            return false;
        }
        return true;
    }

    public HashMap<String, View> getMoreInfoMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mMoreInfoMap;
    }

    public void rebuildProfileContent(ProfileCardInfo profileCardInfo) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo);
            return;
        }
        int i16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "rebuildProfileContent");
        }
        removeAllViews();
        List<View> allComponentView = getAllComponentView();
        if (allComponentView != null) {
            i3 = allComponentView.size();
        } else {
            i3 = 0;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < i3) {
            View view = allComponentView.get(i17);
            if (isDefaultProfile(profileCardInfo) && checkAndAddDivider(i18, view)) {
                i18++;
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                Object[] objArr = new Object[i16];
                objArr[0] = view;
                objArr[1] = parent;
                QLog.e(TAG, 1, String.format("updateMoreInfo itemView=%s viewParent=%s", objArr));
                if (QLog.isDebugVersion()) {
                    Set<String> keySet = this.mMoreInfoMap.keySet();
                    StringBuilder sb5 = new StringBuilder();
                    for (String str : keySet) {
                        Object[] objArr2 = new Object[i16];
                        objArr2[0] = str;
                        objArr2[1] = this.mMoreInfoMap.get(str);
                        sb5.append(String.format("updateMoreInfo key=%s view=%s", objArr2));
                        i16 = 2;
                    }
                    QLog.e(TAG, 1, sb5);
                }
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                    QLog.i(TAG, 1, "rebuildProfileContent,remove_view_first!");
                }
            }
            addView(view);
            if (checkBottomMargin(view) && (view.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                ((LinearLayout.LayoutParams) view.getLayoutParams()).bottomMargin = this.componentMargin;
            }
            i17++;
            i16 = 2;
        }
    }

    public void setComponentMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.componentMargin = i3;
        }
    }

    public void setContainerDividerCreator(IContainerDividerCreator iContainerDividerCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iContainerDividerCreator);
        } else {
            this.mContainerDividerCreator = iContainerDividerCreator;
        }
    }

    public void setDividerCreator(IDividerCreator iDividerCreator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iDividerCreator);
        } else {
            this.mDividerCreator = iDividerCreator;
        }
    }

    public void setDividerMap(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) strArr);
        } else {
            if (strArr == null) {
                return;
            }
            this.mDividerMap = strArr;
        }
    }

    public void setEnableDivider(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mEnableDivider = z16;
        }
    }

    public void setKeyMap(List<String[]> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            this.mKeyMap = list;
        }
    }

    public void updateDivider(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
            return;
        }
        View view = this.mMoreInfoMap.get(String.format("%s_%s", IProfileContentKey.MAP_KEY_CONTAINER_DIVIDER, str));
        if (view == null) {
            return;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public ProfileContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mEnableDivider = true;
        this.mKeyMap = IProfileContentKey.COMPONENT_ADD_LIST_NORMAL;
        this.mDividerMap = IProfileContentKey.KEY_MAP_HAS_TOP_DIVIDER;
        this.componentMargin = 0;
        this.mMoreInfoMap = new HashMap<>();
    }
}
