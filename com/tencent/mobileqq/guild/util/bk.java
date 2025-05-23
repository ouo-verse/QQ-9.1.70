package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.data.de;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bk {
    public static boolean a(de deVar, de deVar2) {
        if (deVar == deVar2) {
            return true;
        }
        if (deVar == null || deVar2 == null) {
            return false;
        }
        if (deVar.getApp() == null ? deVar2.getApp() != null : !deVar.getApp().equals(deVar2.getApp())) {
            return false;
        }
        if (deVar.getView() == null ? deVar2.getView() != null : !deVar.getView().equals(deVar2.getView())) {
            return false;
        }
        if (deVar.b() == null ? deVar2.b() != null : !deVar.b().equals(deVar2.b())) {
            return false;
        }
        if (deVar.getDesc() == null ? deVar2.getDesc() != null : !deVar.getDesc().equals(deVar2.getDesc())) {
            return false;
        }
        if (deVar.getPrompt() == null ? deVar2.getPrompt() != null : !deVar.getPrompt().equals(deVar2.getPrompt())) {
            return false;
        }
        if (deVar.a() == null ? deVar2.a() != null : !deVar.a().equals(deVar2.a())) {
            return false;
        }
        if (deVar.getConfig() != null) {
            return deVar.getConfig().equals(deVar2.getConfig());
        }
        if (deVar2.getConfig() == null) {
            return true;
        }
        return false;
    }
}
