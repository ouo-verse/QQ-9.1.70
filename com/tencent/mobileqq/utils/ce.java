package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.bizParts.QQSettingMeChangeAccountPart;
import com.tencent.mobileqq.bizParts.QQSettingMeCoverPart;
import com.tencent.mobileqq.bizParts.QQSettingMeFloatingViewPart;
import com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart;
import com.tencent.mobileqq.bizParts.QQSettingMeNavigationPart;
import com.tencent.mobileqq.bizParts.QQSettingMeProfileCardPart;
import com.tencent.mobileqq.bizParts.QQSettingMeZPlanBgPart;
import com.tencent.mobileqq.bizParts.QQSettingMeZPlanFloatingViewPart;
import com.tencent.mobileqq.bizParts.QQSettingMeZPlanMenuPart;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006R8\u0010\f\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\t0\bj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\t`\n8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/utils/ce;", "", "", "Lcom/tencent/mobileqq/part/a;", "partList", "b", "", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sInjectParts", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ce {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ce f307518a = new ce();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ConfigInject(configPath = "AutoInjectYml/Business/Drawer/Inject_QQSettingMeV9.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends com.tencent.mobileqq.part.a>> sInjectParts;

    static {
        ArrayList<Class<? extends com.tencent.mobileqq.part.a>> arrayList = new ArrayList<>();
        sInjectParts = arrayList;
        arrayList.add(QQSettingMeZPlanFilamentPart.class);
    }

    ce() {
    }

    private final List<com.tencent.mobileqq.part.a> b(List<com.tencent.mobileqq.part.a> partList) {
        partList.add(new QQSettingMeZPlanFloatingViewPart());
        partList.add(new QQSettingMeFloatingViewPart());
        partList.add(new com.tencent.mobileqq.bizParts.a());
        partList.add(new QQSettingMeNavigationPart());
        partList.add(new QQSettingMeProfileCardPart());
        partList.add(new QQSettingMeChangeAccountPart(false, 1, null));
        partList.add(new QQSettingMeMenuPanelPart());
        partList.add(new com.tencent.mobileqq.bizParts.bk());
        partList.add(new QQSettingMeZPlanMenuPart());
        partList.add(new QQSettingMeZPlanBgPart());
        partList.add(new QQSettingMeCoverPart());
        Iterator<Class<? extends com.tencent.mobileqq.part.a>> it = sInjectParts.iterator();
        while (it.hasNext()) {
            try {
                com.tencent.mobileqq.part.a newInstance = it.next().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance != null) {
                    partList.add(newInstance);
                }
            } catch (Exception e16) {
                QLog.e("QQSettingMeViewV9", 2, "initParts error:" + e16);
            }
        }
        return partList;
    }

    @NotNull
    public final List<com.tencent.mobileqq.part.a> a() {
        return b(new ArrayList());
    }
}
