package com.tencent.shadow.core.runtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.shadow.core.runtime.skin.entity.SkinItem;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ShadowLayoutInflater extends ShadowWebViewLayoutInflater {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class InnerInflater extends ShadowLayoutInflater {
        InnerInflater(LayoutInflater layoutInflater, Context context, String str, HashMap<View, SkinItem> hashMap) {
            super(layoutInflater, context, str);
            setFactory2(new ShadowFactory2(str, this, hashMap));
        }
    }

    public static ShadowLayoutInflater build(LayoutInflater layoutInflater, Context context, String str) {
        return build(layoutInflater, context, str, null);
    }

    ShadowLayoutInflater(LayoutInflater layoutInflater, Context context, String str) {
        super(layoutInflater, context);
    }

    public static ShadowLayoutInflater build(LayoutInflater layoutInflater, Context context, String str, HashMap<View, SkinItem> hashMap) {
        return new ShadowLayoutInflater(new InnerInflater(layoutInflater, context, str, hashMap), context, str);
    }
}
