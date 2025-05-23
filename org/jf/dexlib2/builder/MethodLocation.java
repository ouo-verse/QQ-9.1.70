package org.jf.dexlib2.builder;

import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.builder.debug.BuilderEndLocal;
import org.jf.dexlib2.builder.debug.BuilderEpilogueBegin;
import org.jf.dexlib2.builder.debug.BuilderLineNumber;
import org.jf.dexlib2.builder.debug.BuilderPrologueEnd;
import org.jf.dexlib2.builder.debug.BuilderRestartLocal;
import org.jf.dexlib2.builder.debug.BuilderSetSourceFile;
import org.jf.dexlib2.builder.debug.BuilderStartLocal;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MethodLocation {
    int codeAddress;
    int index;

    @Nullable
    BuilderInstruction instruction;
    private final LocatedItems<BuilderDebugItem> debugItems = new LocatedDebugItems();
    private final LocatedItems<Label> labels = new LocatedLabels();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodLocation(@Nullable BuilderInstruction builderInstruction, int i3, int i16) {
        this.instruction = builderInstruction;
        this.codeAddress = i3;
        this.index = i16;
    }

    public void addEndLocal(int i3) {
        getDebugItems().add(new BuilderEndLocal(i3));
    }

    public void addEpilogue() {
        getDebugItems().add(new BuilderEpilogueBegin());
    }

    public void addLineNumber(int i3) {
        getDebugItems().add(new BuilderLineNumber(i3));
    }

    @Nonnull
    public Label addNewLabel() {
        Label label = new Label();
        getLabels().add(label);
        return label;
    }

    public void addPrologue() {
        getDebugItems().add(new BuilderPrologueEnd());
    }

    public void addRestartLocal(int i3) {
        getDebugItems().add(new BuilderRestartLocal(i3));
    }

    public void addSetSourceFile(@Nullable StringReference stringReference) {
        getDebugItems().add(new BuilderSetSourceFile(stringReference));
    }

    public void addStartLocal(int i3, @Nullable StringReference stringReference, @Nullable TypeReference typeReference, @Nullable StringReference stringReference2) {
        getDebugItems().add(new BuilderStartLocal(i3, stringReference, typeReference, stringReference2));
    }

    public int getCodeAddress() {
        return this.codeAddress;
    }

    @Nonnull
    public Set<BuilderDebugItem> getDebugItems() {
        return this.debugItems.getModifiableItems(this);
    }

    public int getIndex() {
        return this.index;
    }

    @Nullable
    public Instruction getInstruction() {
        return this.instruction;
    }

    @Nonnull
    public Set<Label> getLabels() {
        return this.labels.getModifiableItems(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mergeInto(@Nonnull MethodLocation methodLocation) {
        this.labels.mergeItemsIntoNext(methodLocation, methodLocation.labels);
        this.debugItems.mergeItemsIntoNext(methodLocation, methodLocation.debugItems);
    }
}
