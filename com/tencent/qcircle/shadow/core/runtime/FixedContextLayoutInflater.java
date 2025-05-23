package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class FixedContextLayoutInflater extends LayoutInflater {
    private static final String TAG = "FixedContextLayoutInflater";
    private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app."};

    public FixedContextLayoutInflater(Context context) {
        super(context);
    }

    abstract Pair<String, String> changeViewNameAndPrefix(String str, String str2);

    @Override // android.view.LayoutInflater
    public LayoutInflater cloneInContext(Context context) {
        return createNewContextLayoutInflater(context);
    }

    abstract LayoutInflater createNewContextLayoutInflater(Context context);

    @Override // android.view.LayoutInflater
    protected View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        View createView;
        for (String str2 : sClassPrefixList) {
            try {
                Pair<String, String> changeViewNameAndPrefix = changeViewNameAndPrefix(str2, str);
                createView = createView((String) changeViewNameAndPrefix.first, (String) changeViewNameAndPrefix.second, attributeSet);
            } catch (ClassNotFoundException unused) {
            }
            if (createView != null) {
                return createView;
            }
        }
        return super.onCreateView(str, attributeSet);
    }

    public FixedContextLayoutInflater(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }
}
