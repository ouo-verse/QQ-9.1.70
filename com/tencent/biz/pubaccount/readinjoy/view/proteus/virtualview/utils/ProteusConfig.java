package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;

/* loaded from: classes4.dex */
public class ProteusConfig {
    public CustomMethodsRegister.CustomMethodInterface customMethodInterface;
    public DrawableUtil.DrawableHelper drawableHelper;
    public IProteusDtReporter dtReporter;
    public LogUtil.ProteusLog proteusLog;

    /* loaded from: classes4.dex */
    public static class ProteusConfigBuilder {
        private ProteusConfig config = new ProteusConfig();

        public ProteusConfig build() {
            return this.config;
        }

        public ProteusConfigBuilder withCustomMethodInterface(CustomMethodsRegister.CustomMethodInterface customMethodInterface) {
            this.config.customMethodInterface = customMethodInterface;
            return this;
        }

        public ProteusConfigBuilder withDrawableHelper(DrawableUtil.DrawableHelper drawableHelper) {
            this.config.drawableHelper = drawableHelper;
            return this;
        }

        public ProteusConfigBuilder withDtReporter(IProteusDtReporter iProteusDtReporter) {
            this.config.dtReporter = iProteusDtReporter;
            return this;
        }

        public ProteusConfigBuilder withLogger(LogUtil.ProteusLog proteusLog) {
            this.config.proteusLog = proteusLog;
            return this;
        }
    }
}
