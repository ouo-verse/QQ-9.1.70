package org.jf.dexlib2.iface.instruction.formats;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.SwitchPayload;

/* loaded from: classes29.dex */
public interface PackedSwitchPayload extends SwitchPayload {
    @Override // org.jf.dexlib2.iface.instruction.SwitchPayload
    @Nonnull
    List<? extends SwitchElement> getSwitchElements();
}
