package com.tencent.qcircle.shadow.core.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ShadowLayoutInflater extends ShadowWebViewLayoutInflater {
    private ShadowLayoutInflater mBaseInflater;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InnerInflater extends ShadowLayoutInflater {
        @Override // com.tencent.qcircle.shadow.core.runtime.ShadowLayoutInflater, com.tencent.qcircle.shadow.core.runtime.FixedContextLayoutInflater
        /* bridge */ /* synthetic */ LayoutInflater createNewContextLayoutInflater(Context context) {
            return super.createNewContextLayoutInflater(context);
        }

        InnerInflater(LayoutInflater layoutInflater, Context context, String str) {
            super(layoutInflater, context);
            setFactory2(new ShadowFactory2(str));
        }
    }

    public static ShadowLayoutInflater build(LayoutInflater layoutInflater, Context context, String str) {
        return new ShadowLayoutInflater(new InnerInflater(layoutInflater, context, str), context);
    }

    private boolean canTryInflateAgain(Throwable th5) {
        if (th5 instanceof Resources.NotFoundException) {
            return true;
        }
        if (th5.getCause() != null) {
            return canTryInflateAgain(th5.getCause());
        }
        return false;
    }

    @Override // android.view.LayoutInflater
    public View inflate(@LayoutRes int i3, ViewGroup viewGroup, boolean z16) {
        ShadowLayoutInflater shadowLayoutInflater;
        try {
            return super.inflate(i3, viewGroup, z16);
        } catch (Exception e16) {
            if (canTryInflateAgain(e16) && (shadowLayoutInflater = this.mBaseInflater) != null) {
                return shadowLayoutInflater.inflate(i3, viewGroup, z16);
            }
            throw e16;
        }
    }

    ShadowLayoutInflater(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
        if (layoutInflater.getContext() instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) layoutInflater.getContext();
            if (contextWrapper.getBaseContext() instanceof Activity) {
                this.mBaseInflater = new ShadowLayoutInflater(LayoutInflater.from(contextWrapper.getBaseContext()), contextWrapper.getBaseContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qcircle.shadow.core.runtime.FixedContextLayoutInflater
    public ShadowLayoutInflater createNewContextLayoutInflater(Context context) {
        if (context instanceof PluginContainerActivity) {
            return new ShadowLayoutInflater(this, (Context) ((PluginContainerActivity) context).getPluginActivity());
        }
        return new ShadowLayoutInflater(this, context);
    }
}
