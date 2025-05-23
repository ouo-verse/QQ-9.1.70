package com.tencent.mobileqq.colornote.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSettingFragment extends QIphoneTitleBarFragment {
    private Activity C;
    private SettingSectionContainer D;
    private QUISingleLineListItem E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f201529d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f201530e;

        a(h hVar, int i3) {
            this.f201529d = hVar;
            this.f201530e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f201529d.a(view, this.f201530e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements Comparator<ColorNote> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ColorNote colorNote, ColorNote colorNote2) {
            return -((int) (colorNote.getTime() - colorNote2.getTime()));
        }
    }

    private void rh() {
        boolean z16;
        final AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        ea1.c a16 = ColorNoteRecentConfigProcessor.a();
        boolean z17 = true;
        if (a16 != null && a16.a()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!ColorNoteControllerImpl.isRecentlyViewedSwitchOn(appRuntime) || !z16) {
            z17 = false;
        }
        QUISingleLineListItem qUISingleLineListItem = (QUISingleLineListItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.a3v);
        this.E = qUISingleLineListItem;
        if (z16) {
            qUISingleLineListItem.setVisibility(0);
            this.E.setBackgroundType(QUIListItemBackgroundType.AllRound);
            this.E.setStyle(QUIListItemStyle.Card);
            this.E.setConfig(new x.b.d(getString(R.string.bs7)), new x.c.f(z17, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.colornote.settings.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z18) {
                    ColorNoteSettingFragment.sh(AppRuntime.this, compoundButton, z18);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void sh(AppRuntime appRuntime, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ((IColorNoteController) QRoute.api(IColorNoteController.class)).setRecentlyViewedSwitch(appRuntime, z16);
        if (!z16) {
            new ColorNoteCurd().r(null);
        }
        e.a(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        if (!isAdded()) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSettingFragment", 2, "[loadContentView] fragment is not attached");
                return;
            }
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("colorfultab_shield_recent_enable", true)) {
            QLog.i("ColorNoteSettingFragment", 1, "loadContentView shieldRecentContent");
            return;
        }
        SettingSectionContainer settingSectionContainer = (SettingSectionContainer) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.djr);
        this.D = settingSectionContainer;
        settingSectionContainer.setVisibility(0);
        this.D.removeAllViews();
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.djq).setVisibility(0);
        SparseArray<List<ColorNote>> uh5 = uh();
        for (h hVar : c.f()) {
            if (hVar != null && !TextUtils.isEmpty(hVar.getTitle())) {
                int type = hVar.getType();
                List<ColorNote> b16 = c.b(uh5.get(type));
                ColorNoteSettingBaseSection colorNoteSettingBaseSection = new ColorNoteSettingBaseSection(this.C);
                com.tencent.mobileqq.colornote.settings.a aVar = new com.tencent.mobileqq.colornote.settings.a(getQBaseActivity().getAppRuntime());
                colorNoteSettingBaseSection.setAdapter(aVar);
                if (b16 != null) {
                    if (b16.size() > 0) {
                        colorNoteSettingBaseSection.setBgType(1);
                    } else {
                        colorNoteSettingBaseSection.setBgType(0);
                    }
                    aVar.g(b16, type);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = ((QIphoneTitleBarFragment) this).mContentView.getContext().getResources().getDimensionPixelSize(R.dimen.b_7);
                colorNoteSettingBaseSection.setHeaderOnClickListener(new a(hVar, type));
                String title = hVar.getTitle();
                colorNoteSettingBaseSection.setHeaderTitle(title);
                colorNoteSettingBaseSection.setContentDescription(title);
                this.D.addView(colorNoteSettingBaseSection, layoutParams);
                c.c(getQBaseActivity().getAppRuntime(), type);
            }
        }
    }

    private SparseArray<List<ColorNote>> uh() {
        int[] iArr = c.f201548a;
        SparseArray<List<ColorNote>> sparseArray = new SparseArray<>(iArr.length);
        for (int i3 : iArr) {
            sparseArray.put(i3, c.e(getQBaseActivity().getAppRuntime(), i3));
        }
        List<ColorNote> list = sparseArray.get(17039360);
        ArrayList arrayList = new ArrayList();
        for (ColorNote colorNote : list) {
            if (ColorNoteSmallScreenUtil.f(colorNote.getSubType()) == 4) {
                arrayList.add(colorNote);
            }
        }
        list.removeAll(arrayList);
        List<ColorNote> e16 = c.e(getQBaseActivity().getAppRuntime(), android.R.id.background);
        List<ColorNote> e17 = c.e(getQBaseActivity().getAppRuntime(), android.R.id.content);
        List<ColorNote> list2 = sparseArray.get(android.R.dimen.app_icon_size);
        if (e16 != null && e16.size() > 0) {
            list2.addAll(e16);
        }
        if (e17 != null && e17.size() > 0) {
            list2.addAll(e17);
        }
        if (arrayList.size() > 0) {
            list2.addAll(arrayList);
        }
        Collections.sort(list2, new b());
        return sparseArray;
    }

    public static void vh(Context context, Class<? extends ColorNoteSettingFragment> cls, Bundle bundle) {
        String str;
        if (context != null && cls != null) {
            ReportController.o(null, "dc00898", "", "", "0X800AA7E", "0X800AA7E", bundle.getInt("start_from", 1), 0, "", "", "", "");
            Intent intent = new Intent();
            intent.addFlags(268435456);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, cls);
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSettingFragment", 2, "start fragment: " + cls.getName());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            String str2 = "";
            if (context != null) {
                str = "";
            } else {
                str = "context ";
            }
            sb5.append(str);
            if (cls == null) {
                str2 = "fragment ";
            }
            sb5.append(str2);
            sb5.append("is null");
            QLog.d("ColorNoteSettingFragment", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getString(R.string.vz7));
        th();
        rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.aor;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.C = activity;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ColorNoteSettingFragment.this.th();
            }
        }, 500L);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
