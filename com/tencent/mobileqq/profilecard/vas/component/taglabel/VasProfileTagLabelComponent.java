package com.tencent.mobileqq.profilecard.vas.component.taglabel;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.b;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.AdaptiveLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.slf4j.Marker;

/* loaded from: classes16.dex */
public class VasProfileTagLabelComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    private static final int MAX_TAGS_NUM = 7;
    private static final String TAG = "VasProfileTagLabelComponent";
    private TextView[] mTagLabels;

    public VasProfileTagLabelComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isTagTemplateProfile() {
        DATA data = this.mData;
        if (data == 0 || ((ProfileCardInfo) data).curUseStyleId != ProfileCardTemplate.PROFILE_CARD_STYLE_TAG) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [android.view.View, VIEW] */
    private boolean makeOrRefreshTagLabel(Card card) {
        boolean z16;
        View view;
        int i3;
        if (isTagTemplateProfile() && !((ProfileCardInfo) this.mData).isTroopMemberCard) {
            View view2 = (View) this.mViewContainer;
            if (view2 == null) {
                ?? inflate = this.mActivity.getLayoutInflater().inflate(R.layout.b0t, (ViewGroup) null);
                this.mViewContainer = inflate;
                z16 = true;
                view = inflate;
            } else {
                z16 = false;
                view = view2;
            }
            Resources resources = this.mActivity.getResources();
            AdaptiveLayout adaptiveLayout = (AdaptiveLayout) view.findViewById(R.id.jar);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.anb);
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa == 0) {
                i3 = 8;
            } else {
                i3 = 7;
            }
            int i16 = -16777216;
            if (this.mTagLabels == null) {
                if (adaptiveLayout != null) {
                    adaptiveLayout.setGap(dimensionPixelSize, dimensionPixelSize);
                }
                this.mTagLabels = new TextView[i3];
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.an_);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.anc);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.anf);
                int i17 = 0;
                while (i17 < i3) {
                    TextView textView = new TextView(this.mActivity);
                    this.mTagLabels[i17] = textView;
                    textView.setBackgroundResource(R.drawable.anl);
                    textView.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
                    textView.setTextSize(0, dimensionPixelSize2);
                    textView.setTextColor(i16);
                    textView.setGravity(17);
                    if (7 == i17) {
                        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.ang);
                        textView.setTextSize(0, dimensionPixelSize5);
                        textView.setText(Marker.ANY_NON_NULL_MARKER);
                        textView.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                        textView.setTag(new b(47, null));
                        textView.setOnClickListener(this);
                        dimensionPixelSize2 = dimensionPixelSize5;
                    } else {
                        textView.setVisibility(8);
                    }
                    if (adaptiveLayout != null) {
                        adaptiveLayout.addView(textView);
                    }
                    i17++;
                    i16 = -16777216;
                }
            }
            List<ProfileLabelInfo> labelList = card.getLabelList();
            if (adaptiveLayout != null && labelList != null) {
                int min = Math.min(labelList.size(), 7);
                for (int i18 = 0; i18 < i3; i18++) {
                    TextView textView2 = this.mTagLabels[i18];
                    if (i18 < min) {
                        textView2.setText(labelList.get(i18).labelName);
                        textView2.setVisibility(0);
                    } else if (i18 < 7) {
                        textView2.setVisibility(8);
                    }
                    if (textView2.getVisibility() == 0) {
                        Drawable background = textView2.getBackground();
                        if (background instanceof GradientDrawable) {
                            GradientDrawable gradientDrawable = (GradientDrawable) background;
                            if (card.backgroundColor == 1) {
                                gradientDrawable.setColor(-2130706433);
                                gradientDrawable.setStroke(1, 855638016);
                                textView2.setTextColor(-16777216);
                            } else {
                                gradientDrawable.setColor(Integer.MIN_VALUE);
                                gradientDrawable.setStroke(1, 872415231);
                                textView2.setTextColor(-1);
                            }
                        }
                    }
                }
            }
            return z16;
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        this.mViewContainer = null;
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1033;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_TAG_LABEL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        Card r16;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1004 && (r16 = ((FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.mApp.getCurrentAccountUin())) != null) {
            ((ProfileCardInfo) this.mData).card = r16;
            this.mDelegate.notifyCardUpdate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if ((tag instanceof b) && ((b) tag).f260135a == 47) {
            try {
                Intent intent = new Intent(this.mActivity, (Class<?>) ProfileLabelEditorActivity.class);
                intent.putExtra("uin", ((ProfileCardInfo) this.mData).allInOne.uin);
                this.mActivity.startActivityForResult(intent, 1004);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "start label editor fail.", e16);
            }
            ReportController.o(this.mApp, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "2", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        return makeOrRefreshTagLabel(profileCardInfo.card) | super.lambda$checkValidComponent$3((VasProfileTagLabelComponent) profileCardInfo);
    }
}
