package com.tencent.mobileqq.profilecard.base.container;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class ProfileContentContainer extends BaseContentContainer {
    static IPatchRedirector $redirector_ = null;
    private static final float DIVIDER_HEIGHT_DP = 0.75f;
    private static final float DIVIDER_MARGIN_BOTTOM_DP = 6.0f;
    private static final float DIVIDER_MARGIN_TOP_DP = 6.0f;
    public static final String TAG = "ProfileContentContainer";

    public ProfileContentContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected boolean enableDivider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return !QQTheme.isNowSimpleUI();
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    protected List<Integer> getChildComponentTypeList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(1006);
        arrayList.add(1007);
        arrayList.add(1008);
        arrayList.add(1009);
        arrayList.add(1035);
        arrayList.add(1011);
        arrayList.add(1010);
        arrayList.add(1012);
        arrayList.add(1050);
        arrayList.add(1013);
        arrayList.add(1014);
        arrayList.add(1017);
        arrayList.add(1018);
        arrayList.add(1019);
        arrayList.add(1021);
        arrayList.add(1023);
        arrayList.add(1026);
        arrayList.add(1027);
        arrayList.add(1028);
        arrayList.add(1047);
        arrayList.add(1049);
        arrayList.add(1029);
        arrayList.add(1030);
        arrayList.add(1032);
        arrayList.add(1033);
        arrayList.add(1038);
        arrayList.add(1039);
        arrayList.add(1041);
        arrayList.add(1042);
        arrayList.add(1043);
        arrayList.add(1044);
        arrayList.add(1048);
        arrayList.add(1051);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected void initComponentDividerCreator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mDividerCreator = new ProfileContentView.IDividerCreator() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileContentContainer.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentView.IDividerCreator
                public View createDivider(Context context) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                    }
                    int dpToPx = ViewUtils.dpToPx(0.75f);
                    if (dpToPx < 1) {
                        dpToPx = 1;
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dpToPx);
                    Resources resources = context.getResources();
                    layoutParams.leftMargin = resources.getDimensionPixelSize(R.dimen.f159041uo) + resources.getDimensionPixelSize(R.dimen.a07) + resources.getDimensionPixelSize(R.dimen.a08);
                    layoutParams.topMargin = ViewUtils.dpToPx(6.0f);
                    layoutParams.bottomMargin = ViewUtils.dpToPx(6.0f);
                    View view = new View(context);
                    view.setLayoutParams(layoutParams);
                    view.setBackgroundResource(R.drawable.f162459hj3);
                    return view;
                }
            };
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected void initContainerDividerCreator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mContainerDividerCreator = new ProfileContentView.IContainerDividerCreator() { // from class: com.tencent.mobileqq.profilecard.base.container.ProfileContentContainer.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileContentContainer.this);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentView.IContainerDividerCreator
                public View createContainerDivider(Context context) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context);
                    }
                    return null;
                }
            };
        }
    }
}
