package org.jf.dexlib2.builder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LocatedDebugItems extends LocatedItems<BuilderDebugItem> {
    @Override // org.jf.dexlib2.builder.LocatedItems
    protected String getAddLocatedItemError() {
        return "Cannot add a debug item that has already been added to a method.You must remove it from its current location first.";
    }
}
