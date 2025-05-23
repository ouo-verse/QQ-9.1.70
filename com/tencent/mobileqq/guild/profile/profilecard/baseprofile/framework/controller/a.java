package com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller;

import android.os.Bundle;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import xv1.b;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends IGuildComponentController {

    /* renamed from: e, reason: collision with root package name */
    private List<Integer> f231389e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f231390f;

    /* renamed from: h, reason: collision with root package name */
    private b f231391h;

    /* renamed from: i, reason: collision with root package name */
    protected IGuildComponentController.a f231392i;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<AbsGuildProfileComponent> f231388d = new SparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private xv1.a f231393m = new xv1.a();

    public a(List<Integer> list) {
        this.f231389e = list;
    }

    private void a(GuildProfileData guildProfileData) {
        int size = this.f231389e.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbsGuildProfileComponent a16 = this.f231393m.a(this.f231389e.get(i3).intValue(), this, guildProfileData);
            if (a16 != null) {
                a16.attachToComponentController();
            }
        }
    }

    private void d(SparseArray<Integer> sparseArray, View view, int i3) {
        int intValue = sparseArray.valueAt(i3).intValue();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = intValue;
        this.f231390f.addView(view, layoutParams);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void addComponent(AbsGuildProfileComponent absGuildProfileComponent) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildProfileComponentController", 2, String.format("addComponent component=%s", absGuildProfileComponent));
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (absGuildProfileComponent != null) {
                int componentType = absGuildProfileComponent.getComponentType();
                if (this.f231388d.indexOfKey(componentType) < 0) {
                    this.f231388d.put(componentType, absGuildProfileComponent);
                    return;
                } else {
                    QLog.e("Guild.profile.GuildProfileComponentController", 1, String.format("addComponent component exist. component=%s", absGuildProfileComponent));
                    return;
                }
            }
            return;
        }
        throw new RuntimeException("This Method Must Call In Main Thread.");
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onInitData(GuildProfileData guildProfileData) {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onInitData(guildProfileData);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdateData(GuildProfileData guildProfileData) {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onUpdateData(guildProfileData);
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public AbsGuildProfileComponent createComponent(int i3, GuildProfileData guildProfileData) {
        return this.f231393m.a(i3, this, guildProfileData);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public AbsGuildProfileComponent getComponent(int i3) {
        return this.f231388d.get(i3);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public ViewGroup getContentViewContainer() {
        return this.f231390f;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public IGuildComponentController.a getDelegate() {
        return this.f231392i;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void handleDismissAction() {
        b bVar = this.f231391h;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void init(Fragment fragment, GuildProfileData guildProfileData, IGuildComponentController.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildProfileComponentController", 2, String.format("init fragment=%s", fragment));
        }
        this.f231392i = aVar;
        a(guildProfileData);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onConfigurationChanged() {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onConfigurationChanged();
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void onCreate(Fragment fragment, AppInterface appInterface, Bundle bundle) {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = this.f231389e.size();
        ViewGroup viewGroup = this.f231390f;
        if (viewGroup == null) {
            QLog.w("Guild.profile.GuildProfileComponentController", 1, "onCreate contentViewContainer is null!");
            return;
        }
        viewGroup.removeAllViews();
        SparseArray<Integer> b16 = wv1.a.b();
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = this.f231389e.get(i3).intValue();
            AbsGuildProfileComponent valueAt = clone.valueAt(clone.indexOfKey(intValue));
            valueAt.onCreate(fragment, appInterface, bundle);
            View m193getContainerView = valueAt.m193getContainerView();
            if (m193getContainerView.getParent() != null) {
                return;
            }
            int indexOfKey = b16.indexOfKey(intValue);
            if (indexOfKey >= 0) {
                d(b16, m193getContainerView, indexOfKey);
            } else {
                this.f231390f.addView(m193getContainerView);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        this.f231390f = null;
        List<Integer> list = this.f231389e;
        if (list != null) {
            list.clear();
        }
        SparseArray<AbsGuildProfileComponent> sparseArray = this.f231388d;
        if (sparseArray != null) {
            SparseArray<AbsGuildProfileComponent> clone = sparseArray.clone();
            int size = clone.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbsGuildProfileComponent valueAt = clone.valueAt(i3);
                valueAt.detachFromComponentController();
                valueAt.onDestroy();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onLoadFinish();
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onLoadStart();
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onPause() {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onPause();
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onResume() {
        SparseArray<AbsGuildProfileComponent> clone = this.f231388d.clone();
        int size = clone.size();
        for (int i3 = 0; i3 < size; i3++) {
            clone.valueAt(i3).onResume();
        }
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void removeComponent(AbsGuildProfileComponent absGuildProfileComponent) {
        int indexOfKey;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildProfileComponentController", 2, String.format("removeComponent component=%s", absGuildProfileComponent));
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (absGuildProfileComponent != null && (indexOfKey = this.f231388d.indexOfKey(absGuildProfileComponent.getComponentType())) >= 0) {
                this.f231388d.removeAt(indexOfKey);
                return;
            }
            return;
        }
        throw new RuntimeException("This Method Must Call In Main Thread.");
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void setContentViewContainer(ViewGroup viewGroup) {
        this.f231390f = viewGroup;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController
    public void setDismissAction(b bVar) {
        this.f231391h = bVar;
    }
}
