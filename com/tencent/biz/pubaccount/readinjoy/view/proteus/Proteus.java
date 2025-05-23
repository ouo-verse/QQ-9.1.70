package com.tencent.biz.pubaccount.readinjoy.view.proteus;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ProteusConfig;

/* loaded from: classes4.dex */
public class Proteus {
    private static volatile Proteus instance;
    private static ProteusConfig proteusConfig;

    Proteus() {
    }

    public static Proteus getInstance() {
        if (instance == null) {
            synchronized (Proteus.class) {
                if (instance == null) {
                    instance = new Proteus();
                }
            }
        }
        return instance;
    }

    public IProteusDtReporter getDtReporter() {
        ProteusConfig proteusConfig2 = proteusConfig;
        if (proteusConfig2 != null) {
            return proteusConfig2.dtReporter;
        }
        return null;
    }

    public void init(ProteusConfig proteusConfig2) {
        if (proteusConfig2 == null) {
            return;
        }
        proteusConfig = proteusConfig2;
        LogUtil.ProteusLog proteusLog = proteusConfig2.proteusLog;
        if (proteusLog != null) {
            LogUtil.setProteusLog(proteusLog);
        }
        CustomMethodsRegister.CustomMethodInterface customMethodInterface = proteusConfig2.customMethodInterface;
        if (customMethodInterface != null) {
            CustomMethodsRegister.registerCustomMethod(customMethodInterface);
        }
        DrawableUtil.DrawableHelper drawableHelper = proteusConfig2.drawableHelper;
        if (drawableHelper != null) {
            DrawableUtil.setDrawableHelper(drawableHelper);
        }
    }
}
