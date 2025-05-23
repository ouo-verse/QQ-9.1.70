package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.SpecialEffectsController;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class RFWSpecialEffectsController extends DefaultSpecialEffectsController {
    private final OperationChangeListener mListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWSpecialEffectsController(@NonNull ViewGroup viewGroup, OperationChangeListener operationChangeListener) {
        super(viewGroup);
        this.mListener = operationChangeListener;
    }

    private void handleCompleteOperations(List<SpecialEffectsController.Operation> list) {
        Iterator<SpecialEffectsController.Operation> it = list.iterator();
        while (it.hasNext()) {
            this.mListener.onCompleteListener(it.next());
        }
    }

    private void handleEnqueueOperations(List<SpecialEffectsController.Operation> list) {
        Iterator<SpecialEffectsController.Operation> it = list.iterator();
        while (it.hasNext()) {
            this.mListener.enqueueOption(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void enqueueAdd(@NonNull SpecialEffectsController.Operation.State state, @NonNull FragmentStateManager fragmentStateManager) {
        super.enqueueAdd(state, fragmentStateManager);
        handleEnqueueOperations(this.mPendingOperations);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void enqueueHide(@NonNull FragmentStateManager fragmentStateManager) {
        super.enqueueHide(fragmentStateManager);
        handleEnqueueOperations(this.mPendingOperations);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void enqueueRemove(@NonNull FragmentStateManager fragmentStateManager) {
        super.enqueueRemove(fragmentStateManager);
        handleEnqueueOperations(this.mPendingOperations);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.SpecialEffectsController
    public void enqueueShow(@NonNull FragmentStateManager fragmentStateManager) {
        super.enqueueShow(fragmentStateManager);
        handleEnqueueOperations(this.mPendingOperations);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.DefaultSpecialEffectsController, androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z16) {
        super.executeOperations(list, z16);
        handleCompleteOperations(list);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    @NonNull
    public /* bridge */ /* synthetic */ ViewGroup getContainer() {
        return super.getContainer();
    }
}
