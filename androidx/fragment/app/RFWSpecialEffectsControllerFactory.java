package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class RFWSpecialEffectsControllerFactory implements SpecialEffectsControllerFactory {
    private final OperationChangeListener mListener;

    public RFWSpecialEffectsControllerFactory(OperationChangeListener operationChangeListener) {
        this.mListener = operationChangeListener;
    }

    @Override // androidx.fragment.app.SpecialEffectsControllerFactory
    @NonNull
    public SpecialEffectsController createController(@NonNull ViewGroup viewGroup) {
        return new RFWSpecialEffectsController(viewGroup, this.mListener);
    }
}
