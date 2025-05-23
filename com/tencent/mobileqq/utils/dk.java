package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean$ActionType;", "a", "drawer-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class dk {
    @NotNull
    public static final QQSettingMeBizBean.ActionType a(@Nullable String str) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1854658143) {
                if (hashCode != 85812) {
                    if (hashCode == 1782509130 && str.equals("MINIAPP")) {
                        return QQSettingMeBizBean.ActionType.MINIAPP;
                    }
                } else if (str.equals("WEB")) {
                    return QQSettingMeBizBean.ActionType.WEB;
                }
            } else if (str.equals("SCHEMA")) {
                return QQSettingMeBizBean.ActionType.SCHEMA;
            }
        }
        return QQSettingMeBizBean.ActionType.DEFAULT;
    }
}
