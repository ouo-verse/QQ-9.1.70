package org.jf.dexlib2.writer.builder;

import com.google.common.collect.ImmutableList;
import java.util.AbstractList;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderTypeList extends AbstractList<BuilderTypeReference> {
    static final BuilderTypeList EMPTY = new BuilderTypeList(ImmutableList.of());
    int offset = 0;

    @Nonnull
    final List<? extends BuilderTypeReference> types;

    public BuilderTypeList(@Nonnull List<? extends BuilderTypeReference> list) {
        this.types = list;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i3) {
        this.offset = i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.types.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public BuilderTypeReference get(int i3) {
        return this.types.get(i3);
    }
}
