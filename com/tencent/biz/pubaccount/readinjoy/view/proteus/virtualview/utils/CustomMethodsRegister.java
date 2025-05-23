package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class CustomMethodsRegister {
    public static final String CMD_DECODE_EMOTION = "decodeEmotion";
    public static final String CMD_HYPER_LINK_CLICK = "HyperLinkClick";
    public static CustomMethodInterface customMethodInterface;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface CustomMethodInterface {
        Object invoke(String str, Object... objArr);
    }

    public static void registerCustomMethod(CustomMethodInterface customMethodInterface2) {
        customMethodInterface = customMethodInterface2;
    }
}
