package com.qzone.module.feedcomponent.util;

import com.qzone.widget.AsyncImageable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SecrectImageLoader implements AsyncImageable.AsyncImageListener {
    WeakReference<TemplateSetter> wTemplateSetter;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface TemplateSetter {
        void setTemplate(String str, boolean z16);
    }

    public SecrectImageLoader(TemplateSetter templateSetter) {
        this.wTemplateSetter = new WeakReference<>(templateSetter);
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageFailed(AsyncImageable asyncImageable) {
        TemplateSetter templateSetter;
        WeakReference<TemplateSetter> weakReference = this.wTemplateSetter;
        if (weakReference == null || (templateSetter = weakReference.get()) == null) {
            return;
        }
        templateSetter.setTemplate("1", false);
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageLoaded(AsyncImageable asyncImageable) {
        TemplateSetter templateSetter;
        WeakReference<TemplateSetter> weakReference = this.wTemplateSetter;
        if (weakReference == null || (templateSetter = weakReference.get()) == null) {
            return;
        }
        templateSetter.setTemplate("1", true);
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageStarted(AsyncImageable asyncImageable) {
    }

    @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
    public void onImageProgress(AsyncImageable asyncImageable, float f16) {
    }
}
