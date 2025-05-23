package com.tencent.mobileqq.utils;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R0\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0006\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/utils/di;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "d", "Ljava/util/List;", "b", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "groups", "", "Ljava/lang/Boolean;", "getEnableV3", "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "enableV3", "", "f", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "c", "(Ljava/lang/Integer;)V", "drawerUIForm", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.utils.di, reason: from toString */
/* loaded from: classes20.dex */
public final class QQSettingMeViewListBean implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private List<? extends List<? extends QQSettingMeBizBean>> groups;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Boolean enableV3 = Boolean.FALSE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Integer drawerUIForm = 1;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getDrawerUIForm() {
        return this.drawerUIForm;
    }

    @Nullable
    public final List<List<QQSettingMeBizBean>> b() {
        return this.groups;
    }

    public final void c(@Nullable Integer num) {
        this.drawerUIForm = num;
    }

    public final void d(@Nullable Boolean bool) {
        this.enableV3 = bool;
    }

    public final void e(@Nullable List<? extends List<? extends QQSettingMeBizBean>> list) {
        this.groups = list;
    }

    @NotNull
    public String toString() {
        return "QQSettingMeViewListBean(enableV3=" + this.enableV3 + ", drawerUIForm=" + this.drawerUIForm + ", groups=" + this.groups + ')';
    }
}
