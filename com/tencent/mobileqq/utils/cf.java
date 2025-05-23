package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.parts.QQSettingMeChangeAccountPartV3;
import com.tencent.mobileqq.parts.QQSettingMeCoverPartV3;
import com.tencent.mobileqq.parts.QQSettingMeFloatingViewPartV3;
import com.tencent.mobileqq.parts.QQSettingMeMenuPanelPartV3;
import com.tencent.mobileqq.parts.QQSettingMeNavigationPartV3;
import com.tencent.mobileqq.parts.QQSettingMeProfileCardPartV3;
import com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3;
import com.tencent.mobileqq.parts.QQSettingMeProfileNickPartV3;
import com.tencent.mobileqq.parts.QQSettingMeProfilePrettyIconPartV3;
import com.tencent.mobileqq.parts.QQSettingMeQRcodePartV3;
import com.tencent.mobileqq.parts.QQSettingMeSignaturePartV3;
import com.tencent.mobileqq.parts.QQSettingMeTopIconChangePart;
import com.tencent.mobileqq.parts.QQSettingMeVipLevelPartV3;
import com.tencent.mobileqq.parts.QQSettingMeVipMedalPartV3;
import com.tencent.mobileqq.parts.QQSettingMeVipNameplatePartV3;
import com.tencent.mobileqq.parts.QQSettingMeZPlanBgPartV3;
import com.tencent.mobileqq.parts.QQSettingMeZPlanFloatingViewPartV3;
import com.tencent.mobileqq.parts.QQSettingMeZPlanMenuPartV3;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.zplan.sharedengine.part.QQSettingMeZPlanFilamentPart;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006R8\u0010\f\u001a&\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\t0\bj\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\t`\n8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/utils/cf;", "", "", "Lcom/tencent/mobileqq/part/a;", "partList", "b", "", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sInjectParts", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class cf {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cf f307520a = new cf();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ConfigInject(configPath = "AutoInjectYml/Business/Drawer/Inject_QQSettingMeV3.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<? extends com.tencent.mobileqq.part.a>> sInjectParts;

    static {
        ArrayList<Class<? extends com.tencent.mobileqq.part.a>> arrayList = new ArrayList<>();
        sInjectParts = arrayList;
        arrayList.add(QQSettingMeZPlanFilamentPart.class);
    }

    cf() {
    }

    private final List<com.tencent.mobileqq.part.a> b(List<com.tencent.mobileqq.part.a> partList) {
        partList.add(new QQSettingMeZPlanFloatingViewPartV3());
        partList.add(new QQSettingMeFloatingViewPartV3());
        partList.add(new QQSettingMeNavigationPartV3());
        partList.add(new QQSettingMeTopIconChangePart());
        partList.add(new QQSettingMeProfileCardPartV3());
        partList.add(new com.tencent.mobileqq.parts.ag());
        partList.add(new QQSettingMeProfileNickPartV3());
        partList.add(new QQSettingMeProfilePrettyIconPartV3());
        partList.add(new QQSettingMeQRcodePartV3());
        partList.add(new QQSettingMeSignaturePartV3());
        partList.add(new QQSettingMeVipMedalPartV3());
        partList.add(new QQSettingMeVipNameplatePartV3());
        partList.add(new QQSettingMeVipLevelPartV3());
        partList.add(new QQSettingMeProfileMaskPartV3());
        partList.add(new QQSettingMeChangeAccountPartV3(false, 1, null));
        partList.add(new QQSettingMeMenuPanelPartV3());
        partList.add(new com.tencent.mobileqq.parts.bi());
        partList.add(new QQSettingMeZPlanMenuPartV3());
        partList.add(new QQSettingMeZPlanBgPartV3());
        partList.add(new QQSettingMeCoverPartV3());
        Iterator<Class<? extends com.tencent.mobileqq.part.a>> it = sInjectParts.iterator();
        while (it.hasNext()) {
            try {
                com.tencent.mobileqq.part.a newInstance = it.next().getConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance != null) {
                    partList.add(newInstance);
                }
            } catch (Exception e16) {
                QLog.e("QQSettingMeViewV3", 2, "initParts error:" + e16);
            }
        }
        return partList;
    }

    @NotNull
    public final List<com.tencent.mobileqq.part.a> a() {
        return b(new ArrayList());
    }
}
