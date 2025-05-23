package com.tencent.qfsmonet.api.module.singleinput;

import androidx.annotation.NonNull;
import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IMonetColorBlindnessModule extends IMonetSingleInputModule {
    public static final String DEFAULT = "DEFAULT";
    public static final String DEUTERANOPIA = "DEUTERANOPIA";
    public static final String PROTANOPIA = "PROTANOPIA";
    public static final String TRITANOPIA = "TRITANOPIA";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface ColorBlindnessMode {
    }

    void setColorBlindnessMode(String str);

    void setLutPath(@NonNull String str);
}
