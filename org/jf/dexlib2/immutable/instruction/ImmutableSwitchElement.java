package org.jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.util.ImmutableConverter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableSwitchElement implements SwitchElement {
    private static final ImmutableConverter<ImmutableSwitchElement, SwitchElement> CONVERTER = new ImmutableConverter<ImmutableSwitchElement, SwitchElement>() { // from class: org.jf.dexlib2.immutable.instruction.ImmutableSwitchElement.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull SwitchElement switchElement) {
            return switchElement instanceof ImmutableSwitchElement;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableSwitchElement makeImmutable(@Nonnull SwitchElement switchElement) {
            return ImmutableSwitchElement.of(switchElement);
        }
    };
    protected final int key;
    protected final int offset;

    public ImmutableSwitchElement(int i3, int i16) {
        this.key = i3;
        this.offset = i16;
    }

    @Nonnull
    public static ImmutableList<ImmutableSwitchElement> immutableListOf(@Nullable List<? extends SwitchElement> list) {
        return CONVERTER.toList(list);
    }

    @Nonnull
    public static ImmutableSwitchElement of(SwitchElement switchElement) {
        if (switchElement instanceof ImmutableSwitchElement) {
            return (ImmutableSwitchElement) switchElement;
        }
        return new ImmutableSwitchElement(switchElement.getKey(), switchElement.getOffset());
    }

    @Override // org.jf.dexlib2.iface.instruction.SwitchElement
    public int getKey() {
        return this.key;
    }

    @Override // org.jf.dexlib2.iface.instruction.SwitchElement
    public int getOffset() {
        return this.offset;
    }
}
