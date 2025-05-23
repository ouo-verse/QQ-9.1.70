package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/* compiled from: P */
/* loaded from: classes.dex */
public interface OperationChangeListener {
    void enqueueOption(SpecialEffectsController.Operation operation);

    void onCompleteListener(SpecialEffectsController.Operation operation);
}
