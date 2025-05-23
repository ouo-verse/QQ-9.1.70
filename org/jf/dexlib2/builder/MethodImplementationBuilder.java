package org.jf.dexlib2.builder;

import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.reference.StringReference;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MethodImplementationBuilder {
    private MethodLocation currentLocation;

    @Nonnull
    private final MutableMethodImplementation impl;
    private final HashMap<String, Label> labels = new HashMap<>();

    public MethodImplementationBuilder(int i3) {
        MutableMethodImplementation mutableMethodImplementation = new MutableMethodImplementation(i3);
        this.impl = mutableMethodImplementation;
        this.currentLocation = mutableMethodImplementation.instructionList.get(0);
    }

    public void addCatch(@Nullable TypeReference typeReference, @Nonnull Label label, @Nonnull Label label2, @Nonnull Label label3) {
        this.impl.addCatch(typeReference, label, label2, label3);
    }

    public void addEndLocal(int i3) {
        this.currentLocation.addEndLocal(i3);
    }

    public void addEpilogue() {
        this.currentLocation.addEpilogue();
    }

    public void addInstruction(@Nullable BuilderInstruction builderInstruction) {
        this.impl.addInstruction(builderInstruction);
        this.currentLocation = this.impl.instructionList.get(r2.size() - 1);
    }

    @Nonnull
    public Label addLabel(@Nonnull String str) {
        Label label = this.labels.get(str);
        if (label != null) {
            if (!label.isPlaced()) {
                this.currentLocation.getLabels().add(label);
                return label;
            }
            throw new IllegalArgumentException("There is already a label with that name.");
        }
        Label addNewLabel = this.currentLocation.addNewLabel();
        this.labels.put(str, addNewLabel);
        return addNewLabel;
    }

    public void addLineNumber(int i3) {
        this.currentLocation.addLineNumber(i3);
    }

    public void addPrologue() {
        this.currentLocation.addPrologue();
    }

    public void addRestartLocal(int i3) {
        this.currentLocation.addRestartLocal(i3);
    }

    public void addSetSourceFile(@Nullable StringReference stringReference) {
        this.currentLocation.addSetSourceFile(stringReference);
    }

    public void addStartLocal(int i3, @Nullable StringReference stringReference, @Nullable TypeReference typeReference, @Nullable StringReference stringReference2) {
        this.currentLocation.addStartLocal(i3, stringReference, typeReference, stringReference2);
    }

    @Nonnull
    public Label getLabel(@Nonnull String str) {
        Label label = this.labels.get(str);
        if (label == null) {
            Label label2 = new Label();
            this.labels.put(str, label2);
            return label2;
        }
        return label;
    }

    public MethodImplementation getMethodImplementation() {
        return this.impl;
    }

    public void addCatch(@Nullable String str, @Nonnull Label label, @Nonnull Label label2, @Nonnull Label label3) {
        this.impl.addCatch(str, label, label2, label3);
    }

    public void addCatch(@Nonnull Label label, @Nonnull Label label2, @Nonnull Label label3) {
        this.impl.addCatch(label, label2, label3);
    }
}
