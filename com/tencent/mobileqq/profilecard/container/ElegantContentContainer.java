package com.tencent.mobileqq.profilecard.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.container.BaseContentContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ElegantContentContainer extends BaseContentContainer {
    private static final int COMPONENT_MARGIN = 10;
    private static final int CONTAINER_DIVIDER_HEIGHT = 12;
    private static final String DIVIDER_COLOR_NIGHT = "#3D3D41";
    private static final String DIVIDER_COLOR_NORMAL = "#E6E6E6";
    private static final float DIVIDER_HEIGHT_DP = 0.5f;
    public static final String TAG = "ElegantContentContainer";
    private final HashMap<String, Integer> mKeyEmptyWeightMap;
    private final HashMap<String, Integer> mKeyWeightMap;
    private final TreeMap<Integer, String> mTreeMap;

    public ElegantContentContainer(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.mKeyWeightMap = new HashMap<>();
        this.mKeyEmptyWeightMap = new HashMap<>();
        this.mTreeMap = new TreeMap<>();
        initWeightMap();
    }

    private List<String[]> componentList2ComponentBlock(String[] strArr) {
        Integer num;
        ArrayList<List<String>> arrayList = new ArrayList<List<String>>() { // from class: com.tencent.mobileqq.profilecard.container.ElegantContentContainer.2
            {
                add(new ArrayList());
                add(new ArrayList());
                add(new ArrayList());
            }
        };
        for (String str : strArr) {
            HashMap<String, Integer> hashMap = IProfileContentKey.COMPONENT_ADD_MAP_ELEGANT;
            if (hashMap.containsKey(str) && (num = hashMap.get(str)) != null) {
                arrayList.get(num.intValue()).add(str);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (List<String> list : arrayList) {
            if (list.size() > 0) {
                arrayList2.add((String[]) list.toArray(new String[0]));
            }
        }
        return arrayList2;
    }

    private void initWeightMap() {
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_ACCOUNT_INFO_V2, 0);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_ACCOUNT_LEVEL, 1);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_DIAMOND, 2);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_PERSONAL_SIG, 3);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_PYMK_REASON_DATA, 4);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_TROOP_MEM_INFO, 5);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_PERSONALITY_LABEL, 6);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_ADD_PROFILE, 7);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_IN_STEP, 8);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_INTIMATE, 9);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_QZONE, 10);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_META_FARM, 11);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_QQCIRCLE, 12);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_PHOTO_WALL, 13);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_PRESENT, 14);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_QQCARD, 15);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_DRESSUP, 16);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_ANONYMOUS, 17);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_STICKY_NOTE, 18);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_TROOP_GAME_INFO, 19);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_YUAN_MENG, 20);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_GAME_INFO, 21);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_MINI_PLAYING, 22);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_FAVOR, 23);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_MUSIC_DATA, 24);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_MUSIC_BOX, 25);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_STICKY_NOTE_EMPTY, 26);
        this.mKeyWeightMap.put(IProfileContentKey.MAP_KEY_PHONE, 27);
        this.mKeyEmptyWeightMap.put(IProfileContentKey.MAP_KEY_QZONE, 10);
        this.mKeyEmptyWeightMap.put(IProfileContentKey.MAP_KEY_QQCIRCLE, 12);
        this.mKeyEmptyWeightMap.put(IProfileContentKey.MAP_KEY_PRESENT, 97);
        this.mKeyEmptyWeightMap.put(IProfileContentKey.MAP_KEY_QQCARD, 98);
        this.mKeyEmptyWeightMap.put(IProfileContentKey.MAP_KEY_DRESSUP, 99);
        this.mKeyEmptyWeightMap.put(IProfileContentKey.MAP_KEY_ANONYMOUS, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ View lambda$initComponentDividerCreator$0(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.cys, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected boolean enableDivider() {
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.AbsProfileContainer
    protected List<Integer> getChildComponentTypeList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1006);
        arrayList.add(1021);
        arrayList.add(1009);
        arrayList.add(1011);
        arrayList.add(1012);
        arrayList.add(1050);
        arrayList.add(1013);
        arrayList.add(1028);
        arrayList.add(1047);
        arrayList.add(1049);
        arrayList.add(1010);
        arrayList.add(1023);
        arrayList.add(1019);
        arrayList.add(1018);
        arrayList.add(1026);
        arrayList.add(1014);
        arrayList.add(1038);
        arrayList.add(1017);
        arrayList.add(1030);
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
        return TAG;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected String[] getDividerMap() {
        return IProfileContentKey.KEY_MAP_HAS_TOP_DIVIDER_ELEGANT;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected List<String[]> getKeyMap() {
        return IProfileContentKey.KEY_MAP_WEIGHT;
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected void initComponentDividerCreator() {
        this.mDividerCreator = new ProfileContentView.IDividerCreator() { // from class: com.tencent.mobileqq.profilecard.container.a
            @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentView.IDividerCreator
            public final View createDivider(Context context) {
                View lambda$initComponentDividerCreator$0;
                lambda$initComponentDividerCreator$0 = ElegantContentContainer.lambda$initComponentDividerCreator$0(context);
                return lambda$initComponentDividerCreator$0;
            }
        };
    }

    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected void initContainerDividerCreator() {
        this.mContainerDividerCreator = new ProfileContentView.IContainerDividerCreator() { // from class: com.tencent.mobileqq.profilecard.container.ElegantContentContainer.1
            @Override // com.tencent.mobileqq.profilecard.base.view.ProfileContentView.IContainerDividerCreator
            public View createContainerDivider(Context context) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(12.0f));
                View inflate = LayoutInflater.from(context).inflate(R.layout.cyx, (ViewGroup) null);
                inflate.setLayoutParams(layoutParams);
                return inflate;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateDivider(String str, boolean z16) {
        VIEW view = this.mViewContainer;
        if (view != 0) {
            ((ProfileContentView) view).updateDivider(str, z16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer
    protected void updateViewContainer() {
        ((ProfileContentView) this.mViewContainer).setKeyMap(componentList2ComponentBlock((String[]) this.mTreeMap.values().toArray(new String[0])));
        ((ProfileContentView) this.mViewContainer).setEnableDivider(enableDivider());
        ((ProfileContentView) this.mViewContainer).setDividerMap(getDividerMap());
        ((ProfileContentView) this.mViewContainer).setDividerCreator(this.mDividerCreator);
        ((ProfileContentView) this.mViewContainer).setContainerDividerCreator(this.mContainerDividerCreator);
        ((ProfileContentView) this.mViewContainer).setComponentMargin(ViewUtils.dpToPx(10.0f));
        ((ProfileContentView) this.mViewContainer).rebuildProfileContent((ProfileCardInfo) this.mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.container.BaseContentContainer, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        boolean z16;
        char c16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("onDateUpdate this=%s", this));
        }
        this.mData = profileCardInfo;
        int size = this.mChildComponent.size();
        StringBuilder sb5 = new StringBuilder("");
        int i3 = 0;
        boolean z17 = false;
        while (i3 < size) {
            AbsProfileContentComponent absProfileContentComponent = (AbsProfileContentComponent) this.mChildComponent.valueAt(i3);
            if (absProfileContentComponent != null && checkValidComponent(absProfileContentComponent, (ProfileCardInfo) this.mData)) {
                try {
                    z16 = absProfileContentComponent.lambda$checkValidComponent$3(profileCardInfo);
                } catch (Exception e16) {
                    Object[] objArr = new Object[3];
                    objArr[0] = "onDataUpdate fail.";
                    objArr[1] = e16;
                    objArr[c16] = absProfileContentComponent;
                    QLog.e(TAG, 1, objArr);
                    z16 = false;
                }
                String profileContentKey = absProfileContentComponent.getProfileContentKey();
                View containerView = absProfileContentComponent.getContainerView();
                boolean isComponentContentEmpty = absProfileContentComponent.isComponentContentEmpty();
                int intValue = this.mKeyEmptyWeightMap.get(profileContentKey) != null ? this.mKeyEmptyWeightMap.get(profileContentKey).intValue() : 0;
                int intValue2 = this.mKeyWeightMap.get(profileContentKey) != null ? this.mKeyWeightMap.get(profileContentKey).intValue() : 0;
                if (!isComponentContentEmpty) {
                    intValue = intValue2;
                }
                sb5.append(String.format(" onDataUpdate update=%s key=%s view=%s viewParent=%s", Boolean.valueOf(z16), profileContentKey, containerView, containerView != null ? containerView.getParent() : null));
                boolean z18 = z16 || absProfileContentComponent.isNeedForceRefresh();
                if (z18) {
                    updateMoreInfoMap(profileContentKey, containerView);
                    if (this.mTreeMap.containsValue(profileContentKey)) {
                        Iterator<Integer> it = this.mTreeMap.keySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            int intValue3 = it.next().intValue();
                            if (profileContentKey.equals(this.mTreeMap.get(Integer.valueOf(intValue3)))) {
                                this.mTreeMap.remove(Integer.valueOf(intValue3));
                                break;
                            }
                        }
                    }
                    this.mTreeMap.put(Integer.valueOf(intValue), profileContentKey);
                }
                z17 |= z18;
            }
            i3++;
            c16 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, sb5);
        }
        if (z17) {
            updateViewContainer();
        }
        return z17;
    }
}
